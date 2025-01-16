package org.thingsboard.server.service.sync.ie.importing.impl;

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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.common.data.sync.ie.RuleChainExportData;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.relation.BaseRelationService;
import org.thingsboard.server.dao.relation.RelationCaffeineCache;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.relation.JpaRelationDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;
import org.thingsboard.server.dao.sql.rule.JpaRuleNodeDao;
import org.thingsboard.server.service.component.AnnotationComponentDiscoveryService;
import org.thingsboard.server.service.install.InstallScripts;
import org.thingsboard.server.service.rule.DefaultTbRuleChainService;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

class RuleChainImportServiceDiffblueTest {
  /**
   * Test
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   * with {@code EntitiesImportCtx}, {@code RuleChainExportData},
   * {@code RuleChain}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain) with 'EntitiesImportCtx', 'RuleChainExportData', 'RuleChain', 'RuleChain'")
  void testCompareWithEntitiesImportCtxRuleChainExportDataRuleChainRuleChain() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    doNothing().when(ruleChainMetaData).setRuleChainId(Mockito.<RuleChainId>any());
    RuleChainService ruleChainService = mock(RuleChainService.class);
    when(ruleChainService.loadRuleChainMetaData(Mockito.<TenantId>any(), Mockito.<RuleChainId>any()))
        .thenReturn(ruleChainMetaData);
    BaseRuleChainService ruleChainService2 = new BaseRuleChainService();
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    InstallScripts installScripts = new InstallScripts();
    DefaultTbRuleChainService tbRuleChainService = new DefaultTbRuleChainService(ruleChainService2, relationService,
        installScripts, new AnnotationComponentDiscoveryService());

    RuleChainImportService ruleChainImportService = new RuleChainImportService(tbRuleChainService, ruleChainService,
        new JpaRuleNodeDao());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    RuleChainExportData exportData = mock(RuleChainExportData.class);
    when(exportData.getMetaData()).thenReturn(new RuleChainMetaData());
    RuleChain prepared = new RuleChain();

    // Act
    boolean actualCompareResult = ruleChainImportService.compare(ctx, exportData, prepared, new RuleChain());

    // Assert
    verify(ruleChainMetaData).setRuleChainId(isNull());
    verify(exportData).getMetaData();
    verify(ruleChainService).loadRuleChainMetaData(isA(TenantId.class), isNull());
    verify(ctx).getTenantId();
    assertTrue(actualCompareResult);
  }

  /**
   * Test
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   * with {@code EntitiesImportCtx}, {@code RuleChainExportData},
   * {@code RuleChain}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain) with 'EntitiesImportCtx', 'RuleChainExportData', 'RuleChain', 'RuleChain'")
  void testCompareWithEntitiesImportCtxRuleChainExportDataRuleChainRuleChain2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    doNothing().when(ruleChainMetaData).setRuleChainId(Mockito.<RuleChainId>any());
    RuleChainService ruleChainService = mock(RuleChainService.class);
    when(ruleChainService.loadRuleChainMetaData(Mockito.<TenantId>any(), Mockito.<RuleChainId>any()))
        .thenReturn(ruleChainMetaData);
    BaseRuleChainService ruleChainService2 = new BaseRuleChainService();
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    InstallScripts installScripts = new InstallScripts();
    DefaultTbRuleChainService tbRuleChainService = new DefaultTbRuleChainService(ruleChainService2, relationService,
        installScripts, new AnnotationComponentDiscoveryService());

    RuleChainImportService ruleChainImportService = new RuleChainImportService(tbRuleChainService, ruleChainService,
        new JpaRuleNodeDao());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    RuleChainExportData exportData = mock(RuleChainExportData.class);
    when(exportData.getMetaData()).thenReturn(mock(RuleChainMetaData.class));
    RuleChain prepared = new RuleChain();

    // Act
    boolean actualCompareResult = ruleChainImportService.compare(ctx, exportData, prepared, new RuleChain());

    // Assert
    verify(ruleChainMetaData).setRuleChainId(isNull());
    verify(exportData).getMetaData();
    verify(ruleChainService).loadRuleChainMetaData(isA(TenantId.class), isNull());
    verify(ctx).getTenantId();
    assertTrue(actualCompareResult);
  }

  /**
   * Test
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   * with {@code EntitiesImportCtx}, {@code RuleChainExportData},
   * {@code RuleChain}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain) with 'EntitiesImportCtx', 'RuleChainExportData', 'RuleChain', 'RuleChain'")
  void testCompareWithEntitiesImportCtxRuleChainExportDataRuleChainRuleChain3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    RuleChainService ruleChainService2 = mock(RuleChainService.class);
    RuleChainImportService ruleChainImportService = new RuleChainImportService(tbRuleChainService, ruleChainService2,
        new JpaRuleNodeDao());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    RuleChainExportData exportData = mock(RuleChainExportData.class);

    RuleChain prepared = new RuleChain();
    prepared.setExternalId(new RuleChainId(UUID.randomUUID()));

    // Act and Assert
    assertTrue(ruleChainImportService.compare(ctx, exportData, prepared, new RuleChain()));
  }

  /**
   * Test
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   * with {@code EntitiesImportCtx}, {@code RuleChainExportData},
   * {@code RuleChain}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain) with 'EntitiesImportCtx', 'RuleChainExportData', 'RuleChain', 'RuleChain'")
  void testCompareWithEntitiesImportCtxRuleChainExportDataRuleChainRuleChain4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    RuleChainService ruleChainService2 = mock(RuleChainService.class);
    RuleChainImportService ruleChainImportService = new RuleChainImportService(tbRuleChainService, ruleChainService2,
        new JpaRuleNodeDao());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    RuleChainExportData exportData = mock(RuleChainExportData.class);

    RuleChain prepared = new RuleChain();
    prepared.setId(new RuleChainId(UUID.randomUUID()));

    // Act and Assert
    assertTrue(ruleChainImportService.compare(ctx, exportData, prepared, new RuleChain()));
  }

  /**
   * Test
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   * with {@code EntitiesImportCtx}, {@code RuleChainExportData},
   * {@code RuleChain}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain) with 'EntitiesImportCtx', 'RuleChainExportData', 'RuleChain', 'RuleChain'")
  void testCompareWithEntitiesImportCtxRuleChainExportDataRuleChainRuleChain5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    doNothing().when(ruleChainMetaData).setRuleChainId(Mockito.<RuleChainId>any());
    RuleChainService ruleChainService = mock(RuleChainService.class);
    when(ruleChainService.loadRuleChainMetaData(Mockito.<TenantId>any(), Mockito.<RuleChainId>any()))
        .thenReturn(ruleChainMetaData);
    BaseRuleChainService ruleChainService2 = new BaseRuleChainService();
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    InstallScripts installScripts = new InstallScripts();
    DefaultTbRuleChainService tbRuleChainService = new DefaultTbRuleChainService(ruleChainService2, relationService,
        installScripts, new AnnotationComponentDiscoveryService());

    RuleChainImportService ruleChainImportService = new RuleChainImportService(tbRuleChainService, ruleChainService,
        new JpaRuleNodeDao());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    RuleChainExportData exportData = mock(RuleChainExportData.class);
    when(exportData.getMetaData()).thenReturn(new RuleChainMetaData());
    RuleChain prepared = new RuleChain(new RuleChain());

    // Act
    boolean actualCompareResult = ruleChainImportService.compare(ctx, exportData, prepared, new RuleChain());

    // Assert
    verify(ruleChainMetaData).setRuleChainId(isNull());
    verify(exportData).getMetaData();
    verify(ruleChainService).loadRuleChainMetaData(isA(TenantId.class), isNull());
    verify(ctx).getTenantId();
    assertTrue(actualCompareResult);
  }

  /**
   * Test
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   * with {@code EntitiesImportCtx}, {@code RuleChainExportData},
   * {@code RuleChain}, {@code RuleChain}.
   * <p>
   * Method under test:
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain) with 'EntitiesImportCtx', 'RuleChainExportData', 'RuleChain', 'RuleChain'")
  void testCompareWithEntitiesImportCtxRuleChainExportDataRuleChainRuleChain6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    RuleChainService ruleChainService2 = mock(RuleChainService.class);
    RuleChainImportService ruleChainImportService = new RuleChainImportService(tbRuleChainService, ruleChainService2,
        new JpaRuleNodeDao());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    RuleChainExportData exportData = mock(RuleChainExportData.class);
    RuleChain prepared = mock(RuleChain.class);
    when(prepared.isRoot()).thenReturn(true);
    when(prepared.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(prepared.getConfiguration()).thenReturn(MissingNode.getInstance());
    when(prepared.getVersion()).thenReturn(1L);
    when(prepared.getName()).thenReturn("Name");
    when(prepared.getCreatedTime()).thenReturn(1L);
    when(prepared.getExternalId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    when(prepared.getId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    when(prepared.getFirstRuleNodeId()).thenReturn(new RuleNodeId(UUID.randomUUID()));
    when(prepared.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(prepared.getType()).thenReturn(RuleChainType.CORE);

    // Act
    boolean actualCompareResult = ruleChainImportService.compare(ctx, exportData, prepared, new RuleChain());

    // Assert
    verify(prepared).getAdditionalInfo();
    verify(prepared).getConfiguration();
    verify(prepared).getCreatedTime();
    verify(prepared).getExternalId();
    verify(prepared).getFirstRuleNodeId();
    verify(prepared, atLeast(1)).getId();
    verify(prepared).getName();
    verify(prepared).getTenantId();
    verify(prepared).getType();
    verify(prepared).getVersion();
    verify(prepared).isRoot();
    assertTrue(actualCompareResult);
  }

  /**
   * Test
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   * with {@code EntitiesImportCtx}, {@code RuleChainExportData},
   * {@code RuleChain}, {@code RuleChain}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain) with 'EntitiesImportCtx', 'RuleChainExportData', 'RuleChain', 'RuleChain'; given 'A'")
  void testCompareWithEntitiesImportCtxRuleChainExportDataRuleChainRuleChain_givenA() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    RuleChainService ruleChainService2 = mock(RuleChainService.class);
    RuleChainImportService ruleChainImportService = new RuleChainImportService(tbRuleChainService, ruleChainService2,
        new JpaRuleNodeDao());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    RuleChainExportData exportData = mock(RuleChainExportData.class);
    RuleChain prepared = mock(RuleChain.class);
    when(prepared.isRoot()).thenReturn(true);
    when(prepared.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(prepared.getConfiguration()).thenReturn(MissingNode.getInstance());
    when(prepared.getVersion()).thenReturn(1L);
    when(prepared.getName()).thenReturn("Name");
    when(prepared.getCreatedTime()).thenReturn(1L);
    when(prepared.getExternalId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    when(prepared.getId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    when(prepared.getFirstRuleNodeId()).thenReturn(new RuleNodeId(UUID.randomUUID()));
    when(prepared.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(prepared.getType()).thenReturn(RuleChainType.CORE);

    RuleChain existing = new RuleChain();
    existing.setConfigurationBytes(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    boolean actualCompareResult = ruleChainImportService.compare(ctx, exportData, prepared, existing);

    // Assert
    verify(prepared).getAdditionalInfo();
    verify(prepared).getConfiguration();
    verify(prepared).getCreatedTime();
    verify(prepared).getExternalId();
    verify(prepared).getFirstRuleNodeId();
    verify(prepared, atLeast(1)).getId();
    verify(prepared).getName();
    verify(prepared).getTenantId();
    verify(prepared).getType();
    verify(prepared).getVersion();
    verify(prepared).isRoot();
    assertTrue(actualCompareResult);
  }

  /**
   * Test
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   * with {@code EntitiesImportCtx}, {@code RuleChainExportData},
   * {@code RuleChain}, {@code RuleChain}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain) with 'EntitiesImportCtx', 'RuleChainExportData', 'RuleChain', 'RuleChain'; given 'false'")
  void testCompareWithEntitiesImportCtxRuleChainExportDataRuleChainRuleChain_givenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    RuleChainService ruleChainService2 = mock(RuleChainService.class);
    RuleChainImportService ruleChainImportService = new RuleChainImportService(tbRuleChainService, ruleChainService2,
        new JpaRuleNodeDao());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    RuleChainExportData exportData = mock(RuleChainExportData.class);
    RuleChain prepared = mock(RuleChain.class);
    when(prepared.isRoot()).thenReturn(false);
    when(prepared.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(prepared.getConfiguration()).thenReturn(MissingNode.getInstance());
    when(prepared.getVersion()).thenReturn(1L);
    when(prepared.getName()).thenReturn("Name");
    when(prepared.getCreatedTime()).thenReturn(1L);
    when(prepared.getExternalId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    when(prepared.getId()).thenReturn(null);
    when(prepared.getFirstRuleNodeId()).thenReturn(new RuleNodeId(UUID.randomUUID()));
    when(prepared.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(prepared.getType()).thenReturn(RuleChainType.CORE);

    // Act
    boolean actualCompareResult = ruleChainImportService.compare(ctx, exportData, prepared, new RuleChain());

    // Assert
    verify(prepared).getAdditionalInfo();
    verify(prepared).getConfiguration();
    verify(prepared).getCreatedTime();
    verify(prepared).getExternalId();
    verify(prepared).getFirstRuleNodeId();
    verify(prepared, atLeast(1)).getId();
    verify(prepared).getName();
    verify(prepared).getTenantId();
    verify(prepared).getType();
    verify(prepared).getVersion();
    verify(prepared).isRoot();
    assertTrue(actualCompareResult);
  }

  /**
   * Test
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   * with {@code EntitiesImportCtx}, {@code RuleChainExportData},
   * {@code RuleChain}, {@code RuleChain}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainImportService#compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, RuleChainExportData, RuleChain, RuleChain) with 'EntitiesImportCtx', 'RuleChainExportData', 'RuleChain', 'RuleChain'; given 'null'")
  void testCompareWithEntitiesImportCtxRuleChainExportDataRuleChainRuleChain_givenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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

    RuleChainService ruleChainService2 = mock(RuleChainService.class);
    RuleChainImportService ruleChainImportService = new RuleChainImportService(tbRuleChainService, ruleChainService2,
        new JpaRuleNodeDao());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    RuleChainExportData exportData = mock(RuleChainExportData.class);
    RuleChain prepared = mock(RuleChain.class);
    when(prepared.isRoot()).thenReturn(true);
    when(prepared.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(prepared.getConfiguration()).thenReturn(MissingNode.getInstance());
    when(prepared.getVersion()).thenReturn(1L);
    when(prepared.getName()).thenReturn("Name");
    when(prepared.getCreatedTime()).thenReturn(1L);
    when(prepared.getExternalId()).thenReturn(new RuleChainId(UUID.randomUUID()));
    when(prepared.getId()).thenReturn(null);
    when(prepared.getFirstRuleNodeId()).thenReturn(new RuleNodeId(UUID.randomUUID()));
    when(prepared.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(prepared.getType()).thenReturn(RuleChainType.CORE);

    // Act
    boolean actualCompareResult = ruleChainImportService.compare(ctx, exportData, prepared, new RuleChain());

    // Assert
    verify(prepared).getAdditionalInfo();
    verify(prepared).getConfiguration();
    verify(prepared).getCreatedTime();
    verify(prepared).getExternalId();
    verify(prepared).getFirstRuleNodeId();
    verify(prepared, atLeast(1)).getId();
    verify(prepared).getName();
    verify(prepared).getTenantId();
    verify(prepared).getType();
    verify(prepared).getVersion();
    verify(prepared).isRoot();
    assertTrue(actualCompareResult);
  }

  /**
   * Test {@link RuleChainImportService#deepCopy(RuleChain)} with
   * {@code RuleChain}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link RuleChain} {@link RuleChain#isRoot()} return
   * {@code true}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#deepCopy(RuleChain)}
   */
  @Test
  @DisplayName("Test deepCopy(RuleChain) with 'RuleChain'; given 'true'; when RuleChain isRoot() return 'true'; then return 'Name'")
  void testDeepCopyWithRuleChain_givenTrue_whenRuleChainIsRootReturnTrue_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    RuleChainImportService ruleChainImportService = new RuleChainImportService(tbRuleChainService, ruleChainService2,
        new JpaRuleNodeDao());
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(true);
    when(ruleChain.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    MissingNode instance = MissingNode.getInstance();
    when(ruleChain.getConfiguration()).thenReturn(instance);
    when(ruleChain.getVersion()).thenReturn(1L);
    when(ruleChain.getName()).thenReturn("Name");
    when(ruleChain.getCreatedTime()).thenReturn(1L);
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    when(ruleChain.getExternalId()).thenReturn(ruleChainId);
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId2 = new RuleChainId(id);
    when(ruleChain.getId()).thenReturn(ruleChainId2);
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());
    when(ruleChain.getFirstRuleNodeId()).thenReturn(ruleNodeId);
    TenantId tenantId = new TenantId(UUID.randomUUID());
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
    assertSame(instance, actualDeepCopyResult.getAdditionalInfo());
    assertSame(instance, actualDeepCopyResult.getConfiguration());
    assertSame(id, actualDeepCopyResult.getUuidId());
  }

  /**
   * Test {@link RuleChainImportService#deepCopy(RuleChain)} with
   * {@code RuleChain}.
   * <ul>
   *   <li>When {@link RuleChain#RuleChain(RuleChain)} with ruleChain is
   * {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#deepCopy(RuleChain)}
   */
  @Test
  @DisplayName("Test deepCopy(RuleChain) with 'RuleChain'; when RuleChain(RuleChain) with ruleChain is RuleChain()")
  void testDeepCopyWithRuleChain_whenRuleChainWithRuleChainIsRuleChain() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    RuleChainImportService ruleChainImportService = new RuleChainImportService(tbRuleChainService, ruleChainService2,
        new JpaRuleNodeDao());

    // Act
    RuleChain actualDeepCopyResult = ruleChainImportService.deepCopy(new RuleChain(new RuleChain()));

    // Assert
    JsonNode additionalInfo = actualDeepCopyResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualDeepCopyResult.getVersion());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getFirstRuleNodeId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertNull(actualDeepCopyResult.getType());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(actualDeepCopyResult.isDefault());
    assertFalse(actualDeepCopyResult.isRoot());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(additionalInfo, actualDeepCopyResult.getConfiguration());
  }

  /**
   * Test {@link RuleChainImportService#deepCopy(RuleChain)} with
   * {@code RuleChain}.
   * <ul>
   *   <li>When {@link RuleChain#RuleChain()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainImportService#deepCopy(RuleChain)}
   */
  @Test
  @DisplayName("Test deepCopy(RuleChain) with 'RuleChain'; when RuleChain(); then AdditionalInfo return NullNode")
  void testDeepCopyWithRuleChain_whenRuleChain_thenAdditionalInfoReturnNullNode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    RuleChainImportService ruleChainImportService = new RuleChainImportService(tbRuleChainService, ruleChainService2,
        new JpaRuleNodeDao());

    // Act
    RuleChain actualDeepCopyResult = ruleChainImportService.deepCopy(new RuleChain());

    // Assert
    JsonNode additionalInfo = actualDeepCopyResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualDeepCopyResult.getVersion());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getFirstRuleNodeId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertNull(actualDeepCopyResult.getType());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(actualDeepCopyResult.isDefault());
    assertFalse(actualDeepCopyResult.isRoot());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(additionalInfo, actualDeepCopyResult.getConfiguration());
  }

  /**
   * Test {@link RuleChainImportService#getEntityType()}.
   * <p>
   * Method under test: {@link RuleChainImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
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
