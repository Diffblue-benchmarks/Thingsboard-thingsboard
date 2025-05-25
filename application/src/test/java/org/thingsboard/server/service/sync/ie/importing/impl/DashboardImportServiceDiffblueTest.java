package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.DashboardInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.dashboard.DashboardServiceImpl;
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

@ExtendWith(MockitoExtension.class)
class DashboardImportServiceDiffblueTest {
  @InjectMocks
  private DashboardImportService dashboardImportService;

  /**
   * Test {@link DashboardImportService#setOwner(TenantId, Dashboard, IdProvider)}.
   * <p>
   * Method under test: {@link DashboardImportService#setOwner(TenantId, Dashboard, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, Dashboard, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DashboardImportService.setOwner(TenantId, Dashboard, IdProvider)"})
  void testSetOwner() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Dashboard dashboard = new Dashboard();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    dashboardImportService.setOwner(tenantId, dashboard,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    assertSame(tenantId, dashboard.getTenantId());
  }

  /**
   * Test {@link DashboardImportService#setOwner(TenantId, Dashboard, IdProvider)}.
   * <ul>
   *   <li>When {@link Dashboard} {@link DashboardInfo#setTenantId(TenantId)} does nothing.</li>
   *   <li>Then calls {@link DashboardInfo#setTenantId(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardImportService#setOwner(TenantId, Dashboard, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, Dashboard, IdProvider); when Dashboard setTenantId(TenantId) does nothing; then calls setTenantId(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DashboardImportService.setOwner(TenantId, Dashboard, IdProvider)"})
  void testSetOwner_whenDashboardSetTenantIdDoesNothing_thenCallsSetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Dashboard dashboard = mock(Dashboard.class);
    doNothing().when(dashboard).setTenantId(Mockito.<TenantId>any());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    dashboardImportService.setOwner(tenantId, dashboard,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    verify(dashboard).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code id}.</li>
   *   <li>Then calls {@link ObjectNode#fieldNames()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider); given ArrayList() add 'id'; then calls fieldNames()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Dashboard DashboardImportService.prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)"})
  void testPrepare_givenArrayListAddId_thenCallsFieldNames() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("id");
    ObjectNode objectNode = mock(ObjectNode.class);
    when(objectNode.fieldNames()).thenReturn(stringList.iterator());
    when(objectNode.isObject()).thenReturn(true);

    ArrayList<ObjectNode> objectNodeList = new ArrayList<>();
    objectNodeList.add(objectNode);
    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.getEntityAliasesConfig()).thenReturn(objectNodeList);
    when(dashboard.getWidgetsConfig()).thenReturn(new ArrayList<>());
    Dashboard old = new Dashboard();
    EntityExportData<Dashboard> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Dashboard actualPrepareResult = dashboardImportService.prepare(ctx, dashboard, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(objectNode).fieldNames();
    verify(objectNode).isObject();
    verify(dashboard).getEntityAliasesConfig();
    verify(dashboard).getWidgetsConfig();
    assertSame(dashboard, actualPrepareResult);
  }

  /**
   * Test {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider); given ArrayList() add ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Dashboard DashboardImportService.prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)"})
  void testPrepare_givenArrayListAddObjectNodeWithNcIsWithExactBigDecimalsTrue() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    ArrayList<ObjectNode> objectNodeList = new ArrayList<>();
    objectNodeList.add(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));
    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.getEntityAliasesConfig()).thenReturn(objectNodeList);
    when(dashboard.getWidgetsConfig()).thenReturn(new ArrayList<>());
    Dashboard old = new Dashboard();
    EntityExportData<Dashboard> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Dashboard actualPrepareResult = dashboardImportService.prepare(ctx, dashboard, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(dashboard).getEntityAliasesConfig();
    verify(dashboard).getWidgetsConfig();
    assertSame(dashboard, actualPrepareResult);
  }

  /**
   * Test {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider); given ArrayList() add ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Dashboard DashboardImportService.prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)"})
  void testPrepare_givenArrayListAddObjectNodeWithNcIsWithExactBigDecimalsTrue2() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    ArrayList<ObjectNode> objectNodeList = new ArrayList<>();
    objectNodeList.add(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));
    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.getEntityAliasesConfig()).thenReturn(new ArrayList<>());
    when(dashboard.getWidgetsConfig()).thenReturn(objectNodeList);
    Dashboard old = new Dashboard();
    EntityExportData<Dashboard> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Dashboard actualPrepareResult = dashboardImportService.prepare(ctx, dashboard, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(dashboard).getEntityAliasesConfig();
    verify(dashboard).getWidgetsConfig();
    assertSame(dashboard, actualPrepareResult);
  }

  /**
   * Test {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link Dashboard}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider); given ArrayList(); then return Dashboard")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Dashboard DashboardImportService.prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)"})
  void testPrepare_givenArrayList_thenReturnDashboard() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.getEntityAliasesConfig()).thenReturn(new ArrayList<>());
    when(dashboard.getWidgetsConfig()).thenReturn(new ArrayList<>());
    Dashboard old = new Dashboard();
    EntityExportData<Dashboard> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Dashboard actualPrepareResult = dashboardImportService.prepare(ctx, dashboard, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(dashboard).getEntityAliasesConfig();
    verify(dashboard).getWidgetsConfig();
    assertSame(dashboard, actualPrepareResult);
  }

  /**
   * Test {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link ObjectNode} {@link ObjectNode#fieldNames()} return {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link ObjectNode#fieldNames()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider); given ObjectNode fieldNames() return ArrayList() iterator; then calls fieldNames()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Dashboard DashboardImportService.prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)"})
  void testPrepare_givenObjectNodeFieldNamesReturnArrayListIterator_thenCallsFieldNames() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    ObjectNode objectNode = mock(ObjectNode.class);

    ArrayList<String> stringList = new ArrayList<>();
    when(objectNode.fieldNames()).thenReturn(stringList.iterator());
    when(objectNode.isObject()).thenReturn(true);

    ArrayList<ObjectNode> objectNodeList = new ArrayList<>();
    objectNodeList.add(objectNode);
    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.getEntityAliasesConfig()).thenReturn(objectNodeList);
    when(dashboard.getWidgetsConfig()).thenReturn(new ArrayList<>());
    Dashboard old = new Dashboard();
    EntityExportData<Dashboard> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Dashboard actualPrepareResult = dashboardImportService.prepare(ctx, dashboard, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(objectNode).fieldNames();
    verify(objectNode).isObject();
    verify(dashboard).getEntityAliasesConfig();
    verify(dashboard).getWidgetsConfig();
    assertSame(dashboard, actualPrepareResult);
  }

  /**
   * Test {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link ObjectNode} {@link ObjectNode#get(String)} return {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider); given ObjectNode get(String) return ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Dashboard DashboardImportService.prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)"})
  void testPrepare_givenObjectNodeGetReturnArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    stringList.add("id");
    Iterator<String> iteratorResult = stringList.iterator();
    ObjectNode objectNode = mock(ObjectNode.class);
    when(objectNode.get(Mockito.<String>any())).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(objectNode.fieldNames()).thenReturn(iteratorResult);
    when(objectNode.isObject()).thenReturn(true);

    ArrayList<ObjectNode> objectNodeList = new ArrayList<>();
    objectNodeList.add(objectNode);
    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.getEntityAliasesConfig()).thenReturn(objectNodeList);
    when(dashboard.getWidgetsConfig()).thenReturn(new ArrayList<>());
    Dashboard old = new Dashboard();
    EntityExportData<Dashboard> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Dashboard actualPrepareResult = dashboardImportService.prepare(ctx, dashboard, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(objectNode).fieldNames();
    verify(objectNode).get(eq("foo"));
    verify(objectNode).isObject();
    verify(dashboard).getEntityAliasesConfig();
    verify(dashboard).getWidgetsConfig();
    assertSame(dashboard, actualPrepareResult);
  }

  /**
   * Test {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link ObjectNode} {@link ObjectNode#get(String)} return {@link BigIntegerNode#BigIntegerNode(BigInteger)} with v is valueOf one.</li>
   *   <li>Then calls {@link ObjectNode#get(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider); given ObjectNode get(String) return BigIntegerNode(BigInteger) with v is valueOf one; then calls get(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Dashboard DashboardImportService.prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)"})
  void testPrepare_givenObjectNodeGetReturnBigIntegerNodeWithVIsValueOfOne_thenCallsGet() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    stringList.add("id");
    Iterator<String> iteratorResult = stringList.iterator();
    ObjectNode objectNode = mock(ObjectNode.class);
    when(objectNode.get(Mockito.<String>any())).thenReturn(new BigIntegerNode(BigInteger.valueOf(1L)));
    when(objectNode.fieldNames()).thenReturn(iteratorResult);
    when(objectNode.isObject()).thenReturn(true);

    ArrayList<ObjectNode> objectNodeList = new ArrayList<>();
    objectNodeList.add(objectNode);
    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.getEntityAliasesConfig()).thenReturn(objectNodeList);
    when(dashboard.getWidgetsConfig()).thenReturn(new ArrayList<>());
    Dashboard old = new Dashboard();
    EntityExportData<Dashboard> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Dashboard actualPrepareResult = dashboardImportService.prepare(ctx, dashboard, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(objectNode).fieldNames();
    verify(objectNode).get(eq("foo"));
    verify(objectNode).isObject();
    verify(dashboard).getEntityAliasesConfig();
    verify(dashboard).getWidgetsConfig();
    assertSame(dashboard, actualPrepareResult);
  }

  /**
   * Test {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link ObjectNode} {@link ObjectNode#get(String)} return Instance.</li>
   *   <li>Then calls {@link ObjectNode#get(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider); given ObjectNode get(String) return Instance; then calls get(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Dashboard DashboardImportService.prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)"})
  void testPrepare_givenObjectNodeGetReturnInstance_thenCallsGet() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    stringList.add("id");
    Iterator<String> iteratorResult = stringList.iterator();
    ObjectNode objectNode = mock(ObjectNode.class);
    when(objectNode.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    when(objectNode.fieldNames()).thenReturn(iteratorResult);
    when(objectNode.isObject()).thenReturn(true);

    ArrayList<ObjectNode> objectNodeList = new ArrayList<>();
    objectNodeList.add(objectNode);
    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.getEntityAliasesConfig()).thenReturn(objectNodeList);
    when(dashboard.getWidgetsConfig()).thenReturn(new ArrayList<>());
    Dashboard old = new Dashboard();
    EntityExportData<Dashboard> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Dashboard actualPrepareResult = dashboardImportService.prepare(ctx, dashboard, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(objectNode).fieldNames();
    verify(objectNode).get(eq("foo"));
    verify(objectNode).isObject();
    verify(dashboard).getEntityAliasesConfig();
    verify(dashboard).getWidgetsConfig();
    assertSame(dashboard, actualPrepareResult);
  }

  /**
   * Test {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Then return {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardImportService#prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider); then return Dashboard()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Dashboard DashboardImportService.prepare(EntitiesImportCtx, Dashboard, Dashboard, EntityExportData, IdProvider)"})
  void testPrepare_thenReturnDashboard() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    Dashboard dashboard = new Dashboard();
    Dashboard old = new Dashboard();
    EntityExportData<Dashboard> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertSame(dashboard, dashboardImportService.prepare(ctx, dashboard, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult())));
  }

  /**
   * Test {@link DashboardImportService#deepCopy(Dashboard)} with {@code Dashboard}.
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.</li>
   *   <li>Then return {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardImportService#deepCopy(Dashboard)}
   */
  @Test
  @DisplayName("Test deepCopy(Dashboard) with 'Dashboard'; when Dashboard(); then return Dashboard()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Dashboard DashboardImportService.deepCopy(Dashboard)"})
  void testDeepCopyWithDashboard_whenDashboard_thenReturnDashboard() {
    // Arrange
    Dashboard dashboard = new Dashboard();

    // Act and Assert
    assertEquals(dashboard, dashboardImportService.deepCopy(dashboard));
  }

  /**
   * Test {@link DashboardImportService#compare(EntitiesImportCtx, EntityExportData, Dashboard, Dashboard)} with {@code EntitiesImportCtx}, {@code EntityExportData}, {@code Dashboard}, {@code Dashboard}.
   * <p>
   * Method under test: {@link DashboardImportService#compare(EntitiesImportCtx, EntityExportData, Dashboard, Dashboard)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, EntityExportData, Dashboard, Dashboard) with 'EntitiesImportCtx', 'EntityExportData', 'Dashboard', 'Dashboard'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean DashboardImportService.compare(EntitiesImportCtx, EntityExportData, Dashboard, Dashboard)"})
  void testCompareWithEntitiesImportCtxEntityExportDataDashboardDashboard() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    EntityExportData<Dashboard> exportData = new EntityExportData<>();

    Dashboard prepared = new Dashboard();
    prepared.setConfiguration(MissingNode.getInstance());

    // Act and Assert
    assertTrue(dashboardImportService.compare(ctx, exportData, prepared, new Dashboard()));
  }

  /**
   * Test {@link DashboardImportService#getEntityType()}.
   * <p>
   * Method under test: {@link DashboardImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType DashboardImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DASHBOARD, (new DashboardImportService(new DashboardServiceImpl())).getEntityType());
  }
}
