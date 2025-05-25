package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.common.data.sync.ie.WidgetsBundleExportData;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.widget.WidgetTypeServiceImpl;
import org.thingsboard.server.dao.widget.WidgetsBundleServiceImpl;
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

@ExtendWith(MockitoExtension.class)
class WidgetsBundleImportServiceDiffblueTest {
  @InjectMocks
  private WidgetsBundleImportService widgetsBundleImportService;

  /**
   * Test {@link WidgetsBundleImportService#setOwner(TenantId, WidgetsBundle, IdProvider)}.
   * <p>
   * Method under test: {@link WidgetsBundleImportService#setOwner(TenantId, WidgetsBundle, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, WidgetsBundle, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetsBundleImportService.setOwner(TenantId, WidgetsBundle, IdProvider)"})
  void testSetOwner() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    widgetsBundleImportService.setOwner(tenantId, widgetsBundle,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    assertSame(tenantId, widgetsBundle.getTenantId());
  }

  /**
   * Test {@link WidgetsBundleImportService#setOwner(TenantId, WidgetsBundle, IdProvider)}.
   * <ul>
   *   <li>When {@link WidgetsBundle} {@link WidgetsBundle#setTenantId(TenantId)} does nothing.</li>
   *   <li>Then calls {@link WidgetsBundle#setTenantId(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleImportService#setOwner(TenantId, WidgetsBundle, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, WidgetsBundle, IdProvider); when WidgetsBundle setTenantId(TenantId) does nothing; then calls setTenantId(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetsBundleImportService.setOwner(TenantId, WidgetsBundle, IdProvider)"})
  void testSetOwner_whenWidgetsBundleSetTenantIdDoesNothing_thenCallsSetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    doNothing().when(widgetsBundle).setTenantId(Mockito.<TenantId>any());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    widgetsBundleImportService.setOwner(tenantId, widgetsBundle,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    verify(widgetsBundle).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link WidgetsBundleImportService#prepare(EntitiesImportCtx, WidgetsBundle, WidgetsBundle, WidgetsBundleExportData, IdProvider)}.
   * <p>
   * Method under test: {@link WidgetsBundleImportService#prepare(EntitiesImportCtx, WidgetsBundle, WidgetsBundle, WidgetsBundleExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, WidgetsBundle, WidgetsBundle, WidgetsBundleExportData, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "WidgetsBundle WidgetsBundleImportService.prepare(EntitiesImportCtx, WidgetsBundle, WidgetsBundle, WidgetsBundleExportData, IdProvider)"})
  void testPrepare() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    WidgetsBundle widgetsBundle = new WidgetsBundle();
    WidgetsBundle old = new WidgetsBundle();
    WidgetsBundleExportData exportData = new WidgetsBundleExportData();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertSame(widgetsBundle, widgetsBundleImportService.prepare(ctx, widgetsBundle, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult())));
  }

  /**
   * Test {@link WidgetsBundleImportService#compare(EntitiesImportCtx, WidgetsBundleExportData, WidgetsBundle, WidgetsBundle)} with {@code EntitiesImportCtx}, {@code WidgetsBundleExportData}, {@code WidgetsBundle}, {@code WidgetsBundle}.
   * <p>
   * Method under test: {@link WidgetsBundleImportService#compare(EntitiesImportCtx, WidgetsBundleExportData, WidgetsBundle, WidgetsBundle)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, WidgetsBundleExportData, WidgetsBundle, WidgetsBundle) with 'EntitiesImportCtx', 'WidgetsBundleExportData', 'WidgetsBundle', 'WidgetsBundle'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean WidgetsBundleImportService.compare(EntitiesImportCtx, WidgetsBundleExportData, WidgetsBundle, WidgetsBundle)"})
  void testCompareWithEntitiesImportCtxWidgetsBundleExportDataWidgetsBundleWidgetsBundle() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    WidgetsBundleExportData exportData = new WidgetsBundleExportData();
    WidgetsBundle prepared = new WidgetsBundle();

    // Act and Assert
    assertTrue(widgetsBundleImportService.compare(ctx, exportData, prepared, new WidgetsBundle()));
  }

  /**
   * Test {@link WidgetsBundleImportService#deepCopy(WidgetsBundle)} with {@code WidgetsBundle}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@code Alias}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleImportService#deepCopy(WidgetsBundle)}
   */
  @Test
  @DisplayName("Test deepCopy(WidgetsBundle) with 'WidgetsBundle'; given 'true'; then return 'Alias'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleImportService.deepCopy(WidgetsBundle)"})
  void testDeepCopyWithWidgetsBundle_givenTrue_thenReturnAlias() {
    // Arrange
    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    when(widgetsBundle.isScada()).thenReturn(true);
    when(widgetsBundle.getOrder()).thenReturn(1);
    when(widgetsBundle.getVersion()).thenReturn(1L);
    when(widgetsBundle.getAlias()).thenReturn("Alias");
    when(widgetsBundle.getDescription()).thenReturn("The characteristics of someone or something");
    when(widgetsBundle.getImage()).thenReturn("Image");
    when(widgetsBundle.getTitle()).thenReturn("Dr");
    when(widgetsBundle.getCreatedTime()).thenReturn(1L);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(widgetsBundle.getTenantId()).thenReturn(tenantId);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(widgetsBundle.getExternalId()).thenReturn(widgetsBundleId);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    WidgetsBundleId widgetsBundleId2 = new WidgetsBundleId(id);
    when(widgetsBundle.getId()).thenReturn(widgetsBundleId2);

    // Act
    WidgetsBundle actualDeepCopyResult = widgetsBundleImportService.deepCopy(widgetsBundle);

    // Assert
    verify(widgetsBundle).getAlias();
    verify(widgetsBundle).getCreatedTime();
    verify(widgetsBundle).getDescription();
    verify(widgetsBundle).getExternalId();
    verify(widgetsBundle).getId();
    verify(widgetsBundle).getImage();
    verify(widgetsBundle).getOrder();
    verify(widgetsBundle).getTenantId();
    verify(widgetsBundle).getTitle();
    verify(widgetsBundle).getVersion();
    verify(widgetsBundle).isScada();
    assertEquals("Alias", actualDeepCopyResult.getAlias());
    assertEquals("Dr", actualDeepCopyResult.getName());
    assertEquals("Dr", actualDeepCopyResult.getTitle());
    assertEquals("Image", actualDeepCopyResult.getImage());
    assertEquals("The characteristics of someone or something", actualDeepCopyResult.getDescription());
    assertEquals(1, actualDeepCopyResult.getOrder().intValue());
    assertEquals(1L, actualDeepCopyResult.getVersion().longValue());
    assertEquals(1L, actualDeepCopyResult.getCreatedTime());
    assertTrue(actualDeepCopyResult.isScada());
    assertSame(tenantId, actualDeepCopyResult.getTenantId());
    assertSame(widgetsBundleId, actualDeepCopyResult.getExternalId());
    assertSame(widgetsBundleId2, actualDeepCopyResult.getId());
    assertSame(id, actualDeepCopyResult.getUuidId());
  }

  /**
   * Test {@link WidgetsBundleImportService#deepCopy(WidgetsBundle)} with {@code WidgetsBundle}.
   * <ul>
   *   <li>When {@link WidgetsBundle#WidgetsBundle()}.</li>
   *   <li>Then return {@link WidgetsBundle#WidgetsBundle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleImportService#deepCopy(WidgetsBundle)}
   */
  @Test
  @DisplayName("Test deepCopy(WidgetsBundle) with 'WidgetsBundle'; when WidgetsBundle(); then return WidgetsBundle()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleImportService.deepCopy(WidgetsBundle)"})
  void testDeepCopyWithWidgetsBundle_whenWidgetsBundle_thenReturnWidgetsBundle() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();

    // Act and Assert
    assertEquals(widgetsBundle, widgetsBundleImportService.deepCopy(widgetsBundle));
  }

  /**
   * Test {@link WidgetsBundleImportService#getEntityType()}.
   * <p>
   * Method under test: {@link WidgetsBundleImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType WidgetsBundleImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange
    WidgetsBundleServiceImpl widgetsBundleService = new WidgetsBundleServiceImpl();

    // Act and Assert
    assertEquals(EntityType.WIDGETS_BUNDLE,
        (new WidgetsBundleImportService(widgetsBundleService, new WidgetTypeServiceImpl())).getEntityType());
  }
}
