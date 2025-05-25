package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Set;
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
import org.thingsboard.server.common.data.sync.ie.WidgetsBundleExportData;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.common.data.sync.vc.request.create.SyncStrategy;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.data.ComplexEntitiesExportCtx;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;

@ExtendWith(MockitoExtension.class)
class WidgetsBundleExportServiceDiffblueTest {
  @InjectMocks
  private WidgetsBundleExportService widgetsBundleExportService;

  /**
   * Test {@link WidgetsBundleExportService#setRelatedEntities(EntitiesExportCtx, WidgetsBundle, WidgetsBundleExportData)} with {@code EntitiesExportCtx}, {@code WidgetsBundle}, {@code WidgetsBundleExportData}.
   * <p>
   * Method under test: {@link WidgetsBundleExportService#setRelatedEntities(EntitiesExportCtx, WidgetsBundle, WidgetsBundleExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, WidgetsBundle, WidgetsBundleExportData) with 'EntitiesExportCtx', 'WidgetsBundle', 'WidgetsBundleExportData'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void WidgetsBundleExportService.setRelatedEntities(EntitiesExportCtx, WidgetsBundle, WidgetsBundleExportData)"})
  void testSetRelatedEntitiesWithEntitiesExportCtxWidgetsBundleWidgetsBundleExportData() {
    // Arrange
    ComplexVersionCreateRequest request = new ComplexVersionCreateRequest();
    request.setBranch("janedoe/featurebranch");
    request.setEntityTypes(new HashMap<>());
    request.setSyncStrategy(SyncStrategy.MERGE);
    request.setVersionName("1.0.2");
    User user = new User();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    WidgetsBundle widgetsBundle = new WidgetsBundle();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> widgetsBundleExportService.setRelatedEntities(ctx, widgetsBundle, new WidgetsBundleExportData()));
  }

  /**
   * Test {@link WidgetsBundleExportService#newExportData()}.
   * <p>
   * Method under test: {@link WidgetsBundleExportService#newExportData()}
   */
  @Test
  @DisplayName("Test newExportData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WidgetsBundleExportData WidgetsBundleExportService.newExportData()"})
  void testNewExportData() {
    // Arrange and Act
    WidgetsBundleExportData actualNewExportDataResult = widgetsBundleExportService.newExportData();

    // Assert
    assertNull(actualNewExportDataResult.getWidgets());
    assertNull(actualNewExportDataResult.getFqns());
    assertNull(actualNewExportDataResult.getRelations());
    assertNull(actualNewExportDataResult.getAttributes());
    assertNull(actualNewExportDataResult.getEntityType());
    assertNull(actualNewExportDataResult.getEntity());
    assertFalse(actualNewExportDataResult.hasAttributes());
    assertFalse(actualNewExportDataResult.hasCredentials());
    assertFalse(actualNewExportDataResult.hasRelations());
  }

  /**
   * Test {@link WidgetsBundleExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test: {@link WidgetsBundleExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set WidgetsBundleExportService.getSupportedEntityTypes()"})
  void testGetSupportedEntityTypes() {
    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = widgetsBundleExportService.getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.WIDGETS_BUNDLE));
  }
}
