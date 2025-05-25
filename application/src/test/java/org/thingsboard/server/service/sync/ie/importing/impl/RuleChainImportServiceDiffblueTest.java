package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainConnectionInfo;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.common.data.sync.ie.RuleChainExportData;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.relation.BaseRelationService;
import org.thingsboard.server.dao.relation.RelationCaffeineCache;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.dao.rule.RuleNodeDao;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.relation.JpaRelationDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;
import org.thingsboard.server.dao.sql.rule.JpaRuleNodeDao;
import org.thingsboard.server.service.component.AnnotationComponentDiscoveryService;
import org.thingsboard.server.service.install.InstallScripts;
import org.thingsboard.server.service.rule.DefaultTbRuleChainService;
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

@ExtendWith(MockitoExtension.class)
class RuleChainImportServiceDiffblueTest {
  @InjectMocks
  private RuleChainImportService ruleChainImportService;

  @Mock
  private RuleNodeDao ruleNodeDao;

  /**
   * Test {@link RuleChainImportService#setOwner(TenantId, RuleChain, IdProvider)}.
   * <p>
   * Method under test: {@link RuleChainImportService#setOwner(TenantId, RuleChain, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, RuleChain, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleChainImportService.setOwner(TenantId, RuleChain, IdProvider)"})
  void testSetOwner() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChain ruleChain = new RuleChain();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    ruleChainImportService.setOwner(tenantId, ruleChain,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    assertSame(tenantId, ruleChain.getTenantId());
  }

  /**
   * Test {@link RuleChainImportService#setOwner(TenantId, RuleChain, IdProvider)}.
   * <ul>
   *   <li>When {@link RuleChain} {@link RuleChain#setTenantId(TenantId)} does nothing.</li>
   *   <li>Then calls {@link RuleChain#setTenantId(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#setOwner(TenantId, RuleChain, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, RuleChain, IdProvider); when RuleChain setTenantId(TenantId) does nothing; then calls setTenantId(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleChainImportService.setOwner(TenantId, RuleChain, IdProvider)"})
  void testSetOwner_whenRuleChainSetTenantIdDoesNothing_thenCallsSetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChain ruleChain = mock(RuleChain.class);
    doNothing().when(ruleChain).setTenantId(Mockito.<TenantId>any());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    ruleChainImportService.setOwner(tenantId, ruleChain,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    verify(ruleChain).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link RuleNode#RuleNode()}.</li>
   *   <li>Then calls {@link EntitiesImportCtx#putInternalId(EntityId, EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider); given ArrayList() add RuleNode(); then calls putInternalId(EntityId, EntityId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChain RuleChainImportService.prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)"})
  void testPrepare_givenArrayListAddRuleNode_thenCallsPutInternalId() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode());
    when(ruleNodeDao.findByExternalIds(Mockito.<RuleChainId>any(), Mockito.<List<RuleNodeId>>any()))
        .thenReturn(ruleNodeList);
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    doNothing().when(ctx).putInternalId(Mockito.<EntityId>any(), Mockito.<EntityId>any());
    when(ctx.getInternalId(Mockito.<EntityId>any())).thenReturn(null);
    RuleChain ruleChain = mock(RuleChain.class);
    doNothing().when(ruleChain).setFirstRuleNodeId(Mockito.<RuleNodeId>any());
    when(ruleChain.getFirstRuleNodeId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleChain old = new RuleChain();

    RuleChainExportData exportData = new RuleChainExportData();
    exportData.setMetaData(new RuleChainMetaData());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    RuleChain actualPrepareResult = ruleChainImportService.prepare(ctx, ruleChain, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(ruleChain).setFirstRuleNodeId(isNull());
    verify(ruleNodeDao).findByExternalIds(isNull(), isA(List.class));
    verify(ctx).getInternalId(isA(EntityId.class));
    verify(ctx).putInternalId(isNull(), isNull());
    assertSame(ruleChain, actualPrepareResult);
  }

  /**
   * Test {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link RuleNode#RuleNode()}.</li>
   *   <li>Then calls {@link EntitiesImportCtx#putInternalId(EntityId, EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider); given ArrayList() add RuleNode(); then calls putInternalId(EntityId, EntityId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChain RuleChainImportService.prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)"})
  void testPrepare_givenArrayListAddRuleNode_thenCallsPutInternalId2() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode());
    ruleNodeList.add(new RuleNode());
    when(ruleNodeDao.findByExternalIds(Mockito.<RuleChainId>any(), Mockito.<List<RuleNodeId>>any()))
        .thenReturn(ruleNodeList);
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    doNothing().when(ctx).putInternalId(Mockito.<EntityId>any(), Mockito.<EntityId>any());
    when(ctx.getInternalId(Mockito.<EntityId>any())).thenReturn(null);
    RuleChain ruleChain = mock(RuleChain.class);
    doNothing().when(ruleChain).setFirstRuleNodeId(Mockito.<RuleNodeId>any());
    when(ruleChain.getFirstRuleNodeId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleChain old = new RuleChain();

    RuleChainExportData exportData = new RuleChainExportData();
    exportData.setMetaData(new RuleChainMetaData());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    RuleChain actualPrepareResult = ruleChainImportService.prepare(ctx, ruleChain, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(ruleChain).setFirstRuleNodeId(isNull());
    verify(ruleNodeDao).findByExternalIds(isNull(), isA(List.class));
    verify(ctx).getInternalId(isA(EntityId.class));
    verify(ctx, atLeast(1)).putInternalId(isNull(), isNull());
    assertSame(ruleChain, actualPrepareResult);
  }

  /**
   * Test {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link EntitiesImportCtx#getInternalId(EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider); given 'null'; when 'null'; then calls getInternalId(EntityId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChain RuleChainImportService.prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)"})
  void testPrepare_givenNull_whenNull_thenCallsGetInternalId() {
    // Arrange
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.getInternalId(Mockito.<EntityId>any())).thenReturn(null);
    RuleChain ruleChain = mock(RuleChain.class);
    doNothing().when(ruleChain).setFirstRuleNodeId(Mockito.<RuleNodeId>any());
    when(ruleChain.getFirstRuleNodeId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleChainExportData exportData = new RuleChainExportData();
    exportData.setMetaData(new RuleChainMetaData());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    RuleChain actualPrepareResult = ruleChainImportService.prepare(ctx, ruleChain, null, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(ruleChain).setFirstRuleNodeId(isNull());
    verify(ctx).getInternalId(isA(EntityId.class));
    assertSame(ruleChain, actualPrepareResult);
  }

  /**
   * Test {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link RuleChain#RuleChain()}.</li>
   *   <li>Then calls {@link EntitiesImportCtx#getInternalId(EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider); given 'null'; when RuleChain(); then calls getInternalId(EntityId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChain RuleChainImportService.prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)"})
  void testPrepare_givenNull_whenRuleChain_thenCallsGetInternalId() {
    // Arrange
    when(ruleNodeDao.findByExternalIds(Mockito.<RuleChainId>any(), Mockito.<List<RuleNodeId>>any()))
        .thenReturn(new ArrayList<>());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.getInternalId(Mockito.<EntityId>any())).thenReturn(null);
    RuleChain ruleChain = mock(RuleChain.class);
    doNothing().when(ruleChain).setFirstRuleNodeId(Mockito.<RuleNodeId>any());
    when(ruleChain.getFirstRuleNodeId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleChain old = new RuleChain();

    RuleChainExportData exportData = new RuleChainExportData();
    exportData.setMetaData(new RuleChainMetaData());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    RuleChain actualPrepareResult = ruleChainImportService.prepare(ctx, ruleChain, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(ruleChain).setFirstRuleNodeId(isNull());
    verify(ruleNodeDao).findByExternalIds(isNull(), isA(List.class));
    verify(ctx).getInternalId(isA(EntityId.class));
    assertSame(ruleChain, actualPrepareResult);
  }

  /**
   * Test {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link RuleChainConnectionInfo} (default constructor) AdditionalInfo is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider); given RuleChainConnectionInfo (default constructor) AdditionalInfo is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChain RuleChainImportService.prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)"})
  void testPrepare_givenRuleChainConnectionInfoAdditionalInfoIsInstance() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode());
    when(ruleNodeDao.findByExternalIds(Mockito.<RuleChainId>any(), Mockito.<List<RuleNodeId>>any()))
        .thenReturn(ruleNodeList);
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    doNothing().when(ctx).putInternalId(Mockito.<EntityId>any(), Mockito.<EntityId>any());
    when(ctx.getInternalId(Mockito.<EntityId>any())).thenReturn(null);
    RuleChain ruleChain = mock(RuleChain.class);
    doNothing().when(ruleChain).setFirstRuleNodeId(Mockito.<RuleNodeId>any());
    when(ruleChain.getFirstRuleNodeId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleChain old = mock(RuleChain.class);
    when(old.getId()).thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo
        .setTargetRuleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");

    ArrayList<RuleChainConnectionInfo> ruleChainConnectionInfoList = new ArrayList<>();
    ruleChainConnectionInfoList.add(ruleChainConnectionInfo);
    RuleChainMetaData metaData = mock(RuleChainMetaData.class);
    when(metaData.getNodes()).thenReturn(new ArrayList<>());
    when(metaData.getRuleChainConnections()).thenReturn(ruleChainConnectionInfoList);

    RuleChainExportData exportData = new RuleChainExportData();
    exportData.setMetaData(metaData);
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    RuleChain actualPrepareResult = ruleChainImportService.prepare(ctx, ruleChain, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(old).getId();
    verify(ruleChain).setFirstRuleNodeId(isNull());
    verify(metaData).getNodes();
    verify(metaData).getRuleChainConnections();
    verify(ruleNodeDao).findByExternalIds(isA(RuleChainId.class), isA(List.class));
    verify(ctx).getInternalId(isA(EntityId.class));
    verify(ctx).putInternalId(isNull(), isNull());
    assertSame(ruleChain, actualPrepareResult);
  }

  /**
   * Test {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link RuleChainConnectionInfo} (default constructor) FromIndex is five.</li>
   *   <li>Then calls {@link RuleChainMetaData#getNodes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider); given RuleChainConnectionInfo (default constructor) FromIndex is five; then calls getNodes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChain RuleChainImportService.prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)"})
  void testPrepare_givenRuleChainConnectionInfoFromIndexIsFive_thenCallsGetNodes() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode());
    when(ruleNodeDao.findByExternalIds(Mockito.<RuleChainId>any(), Mockito.<List<RuleNodeId>>any()))
        .thenReturn(ruleNodeList);
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    doNothing().when(ctx).putInternalId(Mockito.<EntityId>any(), Mockito.<EntityId>any());
    when(ctx.getInternalId(Mockito.<EntityId>any())).thenReturn(null);
    RuleChain ruleChain = mock(RuleChain.class);
    doNothing().when(ruleChain).setFirstRuleNodeId(Mockito.<RuleNodeId>any());
    when(ruleChain.getFirstRuleNodeId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleChain old = mock(RuleChain.class);
    when(old.getId()).thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo
        .setTargetRuleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo2.setFromIndex(5);
    ruleChainConnectionInfo2
        .setTargetRuleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    ruleChainConnectionInfo2.setType("miss");

    ArrayList<RuleChainConnectionInfo> ruleChainConnectionInfoList = new ArrayList<>();
    ruleChainConnectionInfoList.add(ruleChainConnectionInfo2);
    ruleChainConnectionInfoList.add(ruleChainConnectionInfo);
    RuleChainMetaData metaData = mock(RuleChainMetaData.class);
    when(metaData.getNodes()).thenReturn(new ArrayList<>());
    when(metaData.getRuleChainConnections()).thenReturn(ruleChainConnectionInfoList);

    RuleChainExportData exportData = new RuleChainExportData();
    exportData.setMetaData(metaData);
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    RuleChain actualPrepareResult = ruleChainImportService.prepare(ctx, ruleChain, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(old).getId();
    verify(ruleChain).setFirstRuleNodeId(isNull());
    verify(metaData).getNodes();
    verify(metaData).getRuleChainConnections();
    verify(ruleNodeDao).findByExternalIds(isA(RuleChainId.class), isA(List.class));
    verify(ctx).getInternalId(isA(EntityId.class));
    verify(ctx).putInternalId(isNull(), isNull());
    assertSame(ruleChain, actualPrepareResult);
  }

  /**
   * Test {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link RuleChainMetaData} {@link RuleChainMetaData#getNodes()} return {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link RuleChainMetaData#getNodes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider); given RuleChainMetaData getNodes() return ArrayList(); then calls getNodes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChain RuleChainImportService.prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)"})
  void testPrepare_givenRuleChainMetaDataGetNodesReturnArrayList_thenCallsGetNodes() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode());
    when(ruleNodeDao.findByExternalIds(Mockito.<RuleChainId>any(), Mockito.<List<RuleNodeId>>any()))
        .thenReturn(ruleNodeList);
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    doNothing().when(ctx).putInternalId(Mockito.<EntityId>any(), Mockito.<EntityId>any());
    when(ctx.getInternalId(Mockito.<EntityId>any())).thenReturn(null);
    RuleChain ruleChain = mock(RuleChain.class);
    doNothing().when(ruleChain).setFirstRuleNodeId(Mockito.<RuleNodeId>any());
    when(ruleChain.getFirstRuleNodeId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleChain old = mock(RuleChain.class);
    when(old.getId()).thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleChainMetaData metaData = mock(RuleChainMetaData.class);
    when(metaData.getNodes()).thenReturn(new ArrayList<>());
    when(metaData.getRuleChainConnections()).thenReturn(new ArrayList<>());

    RuleChainExportData exportData = new RuleChainExportData();
    exportData.setMetaData(metaData);
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    RuleChain actualPrepareResult = ruleChainImportService.prepare(ctx, ruleChain, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(old).getId();
    verify(ruleChain).setFirstRuleNodeId(isNull());
    verify(metaData).getNodes();
    verify(metaData).getRuleChainConnections();
    verify(ruleNodeDao).findByExternalIds(isA(RuleChainId.class), isA(List.class));
    verify(ctx).getInternalId(isA(EntityId.class));
    verify(ctx).putInternalId(isNull(), isNull());
    assertSame(ruleChain, actualPrepareResult);
  }

  /**
   * Test {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link RuleChainMetaData} {@link RuleChainMetaData#getNodes()} return {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link RuleChainMetaData#getNodes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider); given RuleChainMetaData getNodes() return ArrayList(); then calls getNodes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChain RuleChainImportService.prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)"})
  void testPrepare_givenRuleChainMetaDataGetNodesReturnArrayList_thenCallsGetNodes2() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode());
    when(ruleNodeDao.findByExternalIds(Mockito.<RuleChainId>any(), Mockito.<List<RuleNodeId>>any()))
        .thenReturn(ruleNodeList);
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    doNothing().when(ctx).putInternalId(Mockito.<EntityId>any(), Mockito.<EntityId>any());
    when(ctx.getInternalId(Mockito.<EntityId>any())).thenReturn(null);
    RuleChain ruleChain = mock(RuleChain.class);
    doNothing().when(ruleChain).setFirstRuleNodeId(Mockito.<RuleNodeId>any());
    when(ruleChain.getFirstRuleNodeId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleChain old = mock(RuleChain.class);
    when(old.getId()).thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<RuleNode> ruleNodeList2 = new ArrayList<>();
    ruleNodeList2.add(new RuleNode());
    RuleChainMetaData metaData = mock(RuleChainMetaData.class);
    when(metaData.getNodes()).thenReturn(ruleNodeList2);
    when(metaData.getRuleChainConnections()).thenReturn(new ArrayList<>());

    RuleChainExportData exportData = new RuleChainExportData();
    exportData.setMetaData(metaData);
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    RuleChain actualPrepareResult = ruleChainImportService.prepare(ctx, ruleChain, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(old, atLeast(1)).getId();
    verify(ruleChain).setFirstRuleNodeId(isNull());
    verify(metaData).getNodes();
    verify(metaData).getRuleChainConnections();
    verify(ruleNodeDao).findByExternalIds(isA(RuleChainId.class), isA(List.class));
    verify(ctx, atLeast(1)).getInternalId(Mockito.<EntityId>any());
    verify(ctx).putInternalId(isNull(), isNull());
    assertSame(ruleChain, actualPrepareResult);
  }

  /**
   * Test {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link RuleChainMetaData} {@link RuleChainMetaData#getNodes()} return {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link RuleChainMetaData#getNodes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider); given RuleChainMetaData getNodes() return ArrayList(); then calls getNodes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChain RuleChainImportService.prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)"})
  void testPrepare_givenRuleChainMetaDataGetNodesReturnArrayList_thenCallsGetNodes3() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode());
    when(ruleNodeDao.findByExternalIds(Mockito.<RuleChainId>any(), Mockito.<List<RuleNodeId>>any()))
        .thenReturn(ruleNodeList);
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    doNothing().when(ctx).putInternalId(Mockito.<EntityId>any(), Mockito.<EntityId>any());
    when(ctx.getInternalId(Mockito.<EntityId>any())).thenReturn(null);
    RuleChain ruleChain = mock(RuleChain.class);
    doNothing().when(ruleChain).setFirstRuleNodeId(Mockito.<RuleNodeId>any());
    when(ruleChain.getFirstRuleNodeId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleChain old = mock(RuleChain.class);
    when(old.getId()).thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<RuleNode> ruleNodeList2 = new ArrayList<>();
    ruleNodeList2.add(new RuleNode());
    ruleNodeList2.add(new RuleNode());
    RuleChainMetaData metaData = mock(RuleChainMetaData.class);
    when(metaData.getNodes()).thenReturn(ruleNodeList2);
    when(metaData.getRuleChainConnections()).thenReturn(new ArrayList<>());

    RuleChainExportData exportData = new RuleChainExportData();
    exportData.setMetaData(metaData);
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    RuleChain actualPrepareResult = ruleChainImportService.prepare(ctx, ruleChain, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(old, atLeast(1)).getId();
    verify(ruleChain).setFirstRuleNodeId(isNull());
    verify(metaData).getNodes();
    verify(metaData).getRuleChainConnections();
    verify(ruleNodeDao).findByExternalIds(isA(RuleChainId.class), isA(List.class));
    verify(ctx, atLeast(1)).getInternalId(Mockito.<EntityId>any());
    verify(ctx).putInternalId(isNull(), isNull());
    assertSame(ruleChain, actualPrepareResult);
  }

  /**
   * Test {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link RuleChainMetaData} (default constructor).</li>
   *   <li>When {@link RuleChain#RuleChain()}.</li>
   *   <li>Then return {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider); given RuleChainMetaData (default constructor); when RuleChain(); then return RuleChain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChain RuleChainImportService.prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)"})
  void testPrepare_givenRuleChainMetaData_whenRuleChain_thenReturnRuleChain() {
    // Arrange
    when(ruleNodeDao.findByExternalIds(Mockito.<RuleChainId>any(), Mockito.<List<RuleNodeId>>any()))
        .thenReturn(new ArrayList<>());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    RuleChain ruleChain = new RuleChain();
    RuleChain old = new RuleChain();

    RuleChainExportData exportData = new RuleChainExportData();
    exportData.setMetaData(new RuleChainMetaData());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    RuleChain actualPrepareResult = ruleChainImportService.prepare(ctx, ruleChain, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(ruleNodeDao).findByExternalIds(isNull(), isA(List.class));
    assertSame(ruleChain, actualPrepareResult);
  }

  /**
   * Test {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link RuleChainMetaData} (default constructor).</li>
   *   <li>When {@link RuleChain#RuleChain()}.</li>
   *   <li>Then return {@link RuleChain}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider); given RuleChainMetaData (default constructor); when RuleChain(); then return RuleChain")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChain RuleChainImportService.prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)"})
  void testPrepare_givenRuleChainMetaData_whenRuleChain_thenReturnRuleChain2() {
    // Arrange
    when(ruleNodeDao.findByExternalIds(Mockito.<RuleChainId>any(), Mockito.<List<RuleNodeId>>any()))
        .thenReturn(new ArrayList<>());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    RuleChain ruleChain = mock(RuleChain.class);
    doNothing().when(ruleChain).setFirstRuleNodeId(Mockito.<RuleNodeId>any());
    when(ruleChain.getFirstRuleNodeId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleChain old = new RuleChain();

    RuleChainExportData exportData = new RuleChainExportData();
    exportData.setMetaData(new RuleChainMetaData());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    RuleChain actualPrepareResult = ruleChainImportService.prepare(ctx, ruleChain, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(ruleChain).setFirstRuleNodeId(isNull());
    verify(ruleNodeDao).findByExternalIds(isNull(), isA(List.class));
    assertSame(ruleChain, actualPrepareResult);
  }

  /**
   * Test {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}.
   * <ul>
   *   <li>Then calls {@link RuleChain#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider); then calls getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleChain RuleChainImportService.prepare(EntitiesImportCtx, RuleChain, RuleChain, RuleChainExportData, IdProvider)"})
  void testPrepare_thenCallsGetId() {
    // Arrange
    ArrayList<RuleNode> ruleNodeList = new ArrayList<>();
    ruleNodeList.add(new RuleNode());
    when(ruleNodeDao.findByExternalIds(Mockito.<RuleChainId>any(), Mockito.<List<RuleNodeId>>any()))
        .thenReturn(ruleNodeList);
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    doNothing().when(ctx).putInternalId(Mockito.<EntityId>any(), Mockito.<EntityId>any());
    when(ctx.getInternalId(Mockito.<EntityId>any())).thenReturn(null);
    RuleChain ruleChain = mock(RuleChain.class);
    doNothing().when(ruleChain).setFirstRuleNodeId(Mockito.<RuleNodeId>any());
    when(ruleChain.getFirstRuleNodeId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleChain old = mock(RuleChain.class);
    when(old.getId()).thenReturn(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleChainExportData exportData = new RuleChainExportData();
    exportData.setMetaData(new RuleChainMetaData());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    RuleChain actualPrepareResult = ruleChainImportService.prepare(ctx, ruleChain, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(old).getId();
    verify(ruleChain).setFirstRuleNodeId(isNull());
    verify(ruleNodeDao).findByExternalIds(isA(RuleChainId.class), isA(List.class));
    verify(ctx).getInternalId(isA(EntityId.class));
    verify(ctx).putInternalId(isNull(), isNull());
    assertSame(ruleChain, actualPrepareResult);
  }

  /**
   * Test {@link RuleChainImportService#deepCopy(RuleChain)} with {@code RuleChain}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then AdditionalInfo return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#deepCopy(RuleChain)}
   */
  @Test
  @DisplayName("Test deepCopy(RuleChain) with 'RuleChain'; given 'true'; then AdditionalInfo return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainImportService.deepCopy(RuleChain)"})
  void testDeepCopyWithRuleChain_givenTrue_thenAdditionalInfoReturnMissingNode() throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(true);
    when(ruleChain.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    MissingNode instance = MissingNode.getInstance();
    when(ruleChain.getConfiguration()).thenReturn(instance);
    when(ruleChain.getVersion()).thenReturn(1L);
    when(ruleChain.getName()).thenReturn("Name");
    when(ruleChain.getCreatedTime()).thenReturn(1L);
    RuleChainId ruleChainId = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(ruleChain.getExternalId()).thenReturn(ruleChainId);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    RuleChainId ruleChainId2 = new RuleChainId(id);
    when(ruleChain.getId()).thenReturn(ruleChainId2);
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(ruleChain.getFirstRuleNodeId()).thenReturn(ruleNodeId);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(ruleChain.getTenantId()).thenReturn(tenantId);
    when(ruleChain.getType()).thenReturn(RuleChainType.CORE);

    // Act
    RuleChain actualDeepCopyResult = ruleChainImportService.deepCopy(ruleChain);

    // Assert
    verify(ruleChain).getAdditionalInfo();
    verify(ruleChain).getConfiguration();
    verify(ruleChain).getCreatedTime();
    verify(ruleChain).getExternalId();
    verify(ruleChain).getFirstRuleNodeId();
    verify(ruleChain).getId();
    verify(ruleChain).getName();
    verify(ruleChain).getTenantId();
    verify(ruleChain).getType();
    verify(ruleChain).getVersion();
    verify(ruleChain).isRoot();
    JsonNode additionalInfo = actualDeepCopyResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof MissingNode);
    assertEquals("Name", actualDeepCopyResult.getName());
    assertEquals(1L, actualDeepCopyResult.getVersion().longValue());
    assertEquals(1L, actualDeepCopyResult.getCreatedTime());
    assertEquals(RuleChainType.CORE, actualDeepCopyResult.getType());
    assertTrue(actualDeepCopyResult.isDefault());
    assertTrue(actualDeepCopyResult.isRoot());
    assertSame(ruleChainId, actualDeepCopyResult.getExternalId());
    assertSame(ruleChainId2, actualDeepCopyResult.getId());
    assertSame(ruleNodeId, actualDeepCopyResult.getFirstRuleNodeId());
    assertSame(tenantId, actualDeepCopyResult.getTenantId());
    assertSame(instance, additionalInfo);
    assertSame(instance, actualDeepCopyResult.getConfiguration());
    assertSame(id, actualDeepCopyResult.getUuidId());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualDeepCopyResult.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChainImportService#deepCopy(RuleChain)} with {@code RuleChain}.
   * <ul>
   *   <li>When {@link RuleChain#RuleChain(RuleChain)} with ruleChain is {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#deepCopy(RuleChain)}
   */
  @Test
  @DisplayName("Test deepCopy(RuleChain) with 'RuleChain'; when RuleChain(RuleChain) with ruleChain is RuleChain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainImportService.deepCopy(RuleChain)"})
  void testDeepCopyWithRuleChain_whenRuleChainWithRuleChainIsRuleChain() throws UnsupportedEncodingException {
    // Arrange and Act
    RuleChain actualDeepCopyResult = ruleChainImportService.deepCopy(new RuleChain(new RuleChain()));

    // Assert
    JsonNode additionalInfo = actualDeepCopyResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertNull(actualDeepCopyResult.getVersion());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getFirstRuleNodeId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertNull(actualDeepCopyResult.getType());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
    assertFalse(actualDeepCopyResult.isDefault());
    assertFalse(actualDeepCopyResult.isRoot());
    assertSame(additionalInfo, actualDeepCopyResult.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualDeepCopyResult.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChainImportService#deepCopy(RuleChain)} with {@code RuleChain}.
   * <ul>
   *   <li>When {@link RuleChain#RuleChain()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#deepCopy(RuleChain)}
   */
  @Test
  @DisplayName("Test deepCopy(RuleChain) with 'RuleChain'; when RuleChain(); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChain RuleChainImportService.deepCopy(RuleChain)"})
  void testDeepCopyWithRuleChain_whenRuleChain_thenAdditionalInfoReturnNullNode() throws UnsupportedEncodingException {
    // Arrange and Act
    RuleChain actualDeepCopyResult = ruleChainImportService.deepCopy(new RuleChain());

    // Assert
    JsonNode additionalInfo = actualDeepCopyResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertNull(actualDeepCopyResult.getVersion());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getFirstRuleNodeId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertNull(actualDeepCopyResult.getType());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
    assertFalse(actualDeepCopyResult.isDefault());
    assertFalse(actualDeepCopyResult.isRoot());
    assertSame(additionalInfo, actualDeepCopyResult.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualDeepCopyResult.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChainImportService#getEntityType()}.
   * <p>
   * Method under test: {@link RuleChainImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType RuleChainImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange
    BaseRuleChainService ruleChainService = new BaseRuleChainService();
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    InstallScripts installScripts = new InstallScripts();
    DefaultTbRuleChainService tbRuleChainService = new DefaultTbRuleChainService(ruleChainService, relationService,
        installScripts, new AnnotationComponentDiscoveryService());

    BaseRuleChainService ruleChainService2 = new BaseRuleChainService();

    // Act and Assert
    assertEquals(EntityType.RULE_CHAIN,
        (new RuleChainImportService(tbRuleChainService, ruleChainService2, new JpaRuleNodeDao())).getEntityType());
  }
}
