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
import org.thingsboard.server.common.data.sync.ie.WidgetTypeExportData;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.common.data.sync.vc.request.create.SyncStrategy;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.data.ComplexEntitiesExportCtx;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;

@ExtendWith(MockitoExtension.class)
class WidgetTypeExportServiceDiffblueTest {
  @InjectMocks
  private WidgetTypeExportService widgetTypeExportService;

  /**
   * Test {@link WidgetTypeExportService#setRelatedEntities(EntitiesExportCtx, WidgetTypeDetails, WidgetTypeExportData)} with {@code EntitiesExportCtx}, {@code WidgetTypeDetails}, {@code WidgetTypeExportData}.
   * <p>
   * Method under test: {@link WidgetTypeExportService#setRelatedEntities(EntitiesExportCtx, WidgetTypeDetails, WidgetTypeExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, WidgetTypeDetails, WidgetTypeExportData) with 'EntitiesExportCtx', 'WidgetTypeDetails', 'WidgetTypeExportData'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void WidgetTypeExportService.setRelatedEntities(EntitiesExportCtx, WidgetTypeDetails, WidgetTypeExportData)"})
  void testSetRelatedEntitiesWithEntitiesExportCtxWidgetTypeDetailsWidgetTypeExportData() {
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

    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> widgetTypeExportService.setRelatedEntities(ctx, widgetTypeDetails, new WidgetTypeExportData()));
  }

  /**
   * Test {@link WidgetTypeExportService#newExportData()}.
   * <p>
   * Method under test: {@link WidgetTypeExportService#newExportData()}
   */
  @Test
  @DisplayName("Test newExportData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WidgetTypeExportData WidgetTypeExportService.newExportData()"})
  void testNewExportData() {
    // Arrange and Act
    WidgetTypeExportData actualNewExportDataResult = widgetTypeExportService.newExportData();

    // Assert
    assertNull(actualNewExportDataResult.getRelations());
    assertNull(actualNewExportDataResult.getAttributes());
    assertNull(actualNewExportDataResult.getEntityType());
    assertNull(actualNewExportDataResult.getEntity());
    assertFalse(actualNewExportDataResult.hasAttributes());
    assertFalse(actualNewExportDataResult.hasCredentials());
    assertFalse(actualNewExportDataResult.hasRelations());
  }

  /**
   * Test {@link WidgetTypeExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test: {@link WidgetTypeExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set WidgetTypeExportService.getSupportedEntityTypes()"})
  void testGetSupportedEntityTypes() {
    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = widgetTypeExportService.getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.WIDGET_TYPE));
  }
}
