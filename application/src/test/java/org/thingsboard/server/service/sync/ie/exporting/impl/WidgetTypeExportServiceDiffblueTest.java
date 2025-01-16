package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.WidgetTypeExportData;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.data.ComplexEntitiesExportCtx;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;

class WidgetTypeExportServiceDiffblueTest {
  /**
   * Test
   * {@link WidgetTypeExportService#setRelatedEntities(EntitiesExportCtx, WidgetTypeDetails, WidgetTypeExportData)}
   * with {@code EntitiesExportCtx}, {@code WidgetTypeDetails},
   * {@code WidgetTypeExportData}.
   * <p>
   * Method under test:
   * {@link WidgetTypeExportService#setRelatedEntities(EntitiesExportCtx, WidgetTypeDetails, WidgetTypeExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, WidgetTypeDetails, WidgetTypeExportData) with 'EntitiesExportCtx', 'WidgetTypeDetails', 'WidgetTypeExportData'")
  void testSetRelatedEntitiesWithEntitiesExportCtxWidgetTypeDetailsWidgetTypeExportData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetTypeExportService widgetTypeExportService = new WidgetTypeExportService();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    User user = mock(User.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> widgetTypeExportService.setRelatedEntities(ctx, widgetTypeDetails, new WidgetTypeExportData()));
    verify(request).getEntityTypes();
  }

  /**
   * Test {@link WidgetTypeExportService#newExportData()}.
   * <p>
   * Method under test: {@link WidgetTypeExportService#newExportData()}
   */
  @Test
  @DisplayName("Test newExportData()")
  void testNewExportData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    WidgetTypeExportData actualNewExportDataResult = (new WidgetTypeExportService()).newExportData();

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
  void testGetSupportedEntityTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = (new WidgetTypeExportService()).getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.WIDGET_TYPE));
  }
}
