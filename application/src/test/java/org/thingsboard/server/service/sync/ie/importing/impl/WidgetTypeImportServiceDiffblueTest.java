package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.common.data.sync.ie.WidgetTypeExportData;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.widget.WidgetTypeServiceImpl;
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

@ExtendWith(MockitoExtension.class)
class WidgetTypeImportServiceDiffblueTest {
  @InjectMocks
  private WidgetTypeImportService widgetTypeImportService;

  /**
   * Test {@link WidgetTypeImportService#setOwner(TenantId, WidgetTypeDetails, IdProvider)}.
   * <p>
   * Method under test: {@link WidgetTypeImportService#setOwner(TenantId, WidgetTypeDetails, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, WidgetTypeDetails, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetTypeImportService.setOwner(TenantId, WidgetTypeDetails, IdProvider)"})
  void testSetOwner() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    WidgetTypeDetails widgetsBundle = new WidgetTypeDetails();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    widgetTypeImportService.setOwner(tenantId, widgetsBundle,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    assertSame(tenantId, widgetsBundle.getTenantId());
  }

  /**
   * Test {@link WidgetTypeImportService#prepare(EntitiesImportCtx, WidgetTypeDetails, WidgetTypeDetails, WidgetTypeExportData, IdProvider)}.
   * <p>
   * Method under test: {@link WidgetTypeImportService#prepare(EntitiesImportCtx, WidgetTypeDetails, WidgetTypeDetails, WidgetTypeExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, WidgetTypeDetails, WidgetTypeDetails, WidgetTypeExportData, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "WidgetTypeDetails WidgetTypeImportService.prepare(EntitiesImportCtx, WidgetTypeDetails, WidgetTypeDetails, WidgetTypeExportData, IdProvider)"})
  void testPrepare() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    WidgetTypeDetails widgetsBundle = new WidgetTypeDetails();
    WidgetTypeDetails old = new WidgetTypeDetails();
    WidgetTypeExportData exportData = new WidgetTypeExportData();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertSame(widgetsBundle, widgetTypeImportService.prepare(ctx, widgetsBundle, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult())));
  }

  /**
   * Test {@link WidgetTypeImportService#compare(EntitiesImportCtx, WidgetTypeExportData, WidgetTypeDetails, WidgetTypeDetails)} with {@code EntitiesImportCtx}, {@code WidgetTypeExportData}, {@code WidgetTypeDetails}, {@code WidgetTypeDetails}.
   * <p>
   * Method under test: {@link WidgetTypeImportService#compare(EntitiesImportCtx, WidgetTypeExportData, WidgetTypeDetails, WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, WidgetTypeExportData, WidgetTypeDetails, WidgetTypeDetails) with 'EntitiesImportCtx', 'WidgetTypeExportData', 'WidgetTypeDetails', 'WidgetTypeDetails'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean WidgetTypeImportService.compare(EntitiesImportCtx, WidgetTypeExportData, WidgetTypeDetails, WidgetTypeDetails)"})
  void testCompareWithEntitiesImportCtxWidgetTypeExportDataWidgetTypeDetailsWidgetTypeDetails() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    WidgetTypeExportData exportData = new WidgetTypeExportData();
    WidgetTypeDetails prepared = new WidgetTypeDetails();

    // Act and Assert
    assertTrue(widgetTypeImportService.compare(ctx, exportData, prepared, new WidgetTypeDetails()));
  }

  /**
   * Test {@link WidgetTypeImportService#deepCopy(WidgetTypeDetails)} with {@code WidgetTypeDetails}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then Descriptor return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeImportService#deepCopy(WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test deepCopy(WidgetTypeDetails) with 'WidgetTypeDetails'; given 'true'; then Descriptor return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WidgetTypeDetails WidgetTypeImportService.deepCopy(WidgetTypeDetails)"})
  void testDeepCopyWithWidgetTypeDetails_givenTrue_thenDescriptorReturnMissingNode() {
    // Arrange
    WidgetTypeDetails widgetsBundle = mock(WidgetTypeDetails.class);
    when(widgetsBundle.isDeprecated()).thenReturn(true);
    when(widgetsBundle.isScada()).thenReturn(true);
    MissingNode instance = MissingNode.getInstance();
    when(widgetsBundle.getDescriptor()).thenReturn(instance);
    when(widgetsBundle.getVersion()).thenReturn(1L);
    when(widgetsBundle.getFqn()).thenReturn("Fqn");
    when(widgetsBundle.getName()).thenReturn("Name");
    when(widgetsBundle.getDescription()).thenReturn("The characteristics of someone or something");
    when(widgetsBundle.getImage()).thenReturn("Image");
    when(widgetsBundle.getTags()).thenReturn(new String[]{"Tags"});
    when(widgetsBundle.getCreatedTime()).thenReturn(1L);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(widgetsBundle.getTenantId()).thenReturn(tenantId);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    WidgetTypeId widgetTypeId = new WidgetTypeId(id);
    when(widgetsBundle.getId()).thenReturn(widgetTypeId);
    WidgetTypeId widgetTypeId2 = new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(widgetsBundle.getExternalId()).thenReturn(widgetTypeId2);

    // Act
    WidgetTypeDetails actualDeepCopyResult = widgetTypeImportService.deepCopy(widgetsBundle);

    // Assert
    verify(widgetsBundle).getCreatedTime();
    verify(widgetsBundle).getFqn();
    verify(widgetsBundle).getId();
    verify(widgetsBundle).getName();
    verify(widgetsBundle).getTenantId();
    verify(widgetsBundle).getVersion();
    verify(widgetsBundle).isDeprecated();
    verify(widgetsBundle).isScada();
    verify(widgetsBundle).getDescriptor();
    verify(widgetsBundle).getDescription();
    verify(widgetsBundle).getExternalId();
    verify(widgetsBundle).getImage();
    verify(widgetsBundle).getTags();
    JsonNode descriptor = actualDeepCopyResult.getDescriptor();
    assertTrue(descriptor instanceof MissingNode);
    assertEquals("Fqn", actualDeepCopyResult.getFqn());
    assertEquals("Image", actualDeepCopyResult.getImage());
    assertEquals("Name", actualDeepCopyResult.getName());
    assertEquals("The characteristics of someone or something", actualDeepCopyResult.getDescription());
    assertEquals(1, actualDeepCopyResult.getTags().length);
    assertEquals(1L, actualDeepCopyResult.getVersion().longValue());
    assertEquals(1L, actualDeepCopyResult.getCreatedTime());
    assertTrue(actualDeepCopyResult.isDeprecated());
    assertTrue(actualDeepCopyResult.isScada());
    assertSame(tenantId, actualDeepCopyResult.getTenantId());
    assertSame(widgetTypeId, actualDeepCopyResult.getId());
    assertSame(widgetTypeId2, actualDeepCopyResult.getExternalId());
    assertSame(instance, descriptor);
    assertSame(id, actualDeepCopyResult.getUuidId());
  }

  /**
   * Test {@link WidgetTypeImportService#deepCopy(WidgetTypeDetails)} with {@code WidgetTypeDetails}.
   * <ul>
   *   <li>Then return {@link WidgetTypeDetails#WidgetTypeDetails()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeImportService#deepCopy(WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test deepCopy(WidgetTypeDetails) with 'WidgetTypeDetails'; then return WidgetTypeDetails()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WidgetTypeDetails WidgetTypeImportService.deepCopy(WidgetTypeDetails)"})
  void testDeepCopyWithWidgetTypeDetails_thenReturnWidgetTypeDetails() {
    // Arrange
    WidgetTypeDetails widgetsBundle = new WidgetTypeDetails();

    // Act and Assert
    assertEquals(widgetsBundle, widgetTypeImportService.deepCopy(widgetsBundle));
  }

  /**
   * Test {@link WidgetTypeImportService#getEntityType()}.
   * <p>
   * Method under test: {@link WidgetTypeImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType WidgetTypeImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.WIDGET_TYPE, (new WidgetTypeImportService(new WidgetTypeServiceImpl())).getEntityType());
  }
}
