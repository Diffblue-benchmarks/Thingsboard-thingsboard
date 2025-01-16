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
import org.thingsboard.server.common.data.sync.ie.WidgetsBundleExportData;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.dao.widget.WidgetTypeServiceImpl;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.data.ComplexEntitiesExportCtx;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;

class WidgetsBundleExportServiceDiffblueTest {
  /**
   * Test
   * {@link WidgetsBundleExportService#setRelatedEntities(EntitiesExportCtx, WidgetsBundle, WidgetsBundleExportData)}
   * with {@code EntitiesExportCtx}, {@code WidgetsBundle},
   * {@code WidgetsBundleExportData}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleExportService#setRelatedEntities(EntitiesExportCtx, WidgetsBundle, WidgetsBundleExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, WidgetsBundle, WidgetsBundleExportData) with 'EntitiesExportCtx', 'WidgetsBundle', 'WidgetsBundleExportData'")
  void testSetRelatedEntitiesWithEntitiesExportCtxWidgetsBundleWidgetsBundleExportData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetsBundleExportService widgetsBundleExportService = new WidgetsBundleExportService(
        mock(WidgetTypeServiceImpl.class));
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    User user = new User();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    WidgetsBundle widgetsBundle = new WidgetsBundle();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> widgetsBundleExportService.setRelatedEntities(ctx, widgetsBundle, new WidgetsBundleExportData()));
    verify(request).getEntityTypes();
  }

  /**
   * Test {@link WidgetsBundleExportService#newExportData()}.
   * <p>
   * Method under test: {@link WidgetsBundleExportService#newExportData()}
   */
  @Test
  @DisplayName("Test newExportData()")
  void testNewExportData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    WidgetsBundleExportData actualNewExportDataResult = (new WidgetsBundleExportService(new WidgetTypeServiceImpl()))
        .newExportData();

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
   * Test {@link WidgetsBundleExportService#newExportData()}.
   * <p>
   * Method under test: {@link WidgetsBundleExportService#newExportData()}
   */
  @Test
  @DisplayName("Test newExportData()")
  void testNewExportData2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    WidgetsBundleExportData actualNewExportDataResult = (new WidgetsBundleExportService(
        mock(WidgetTypeServiceImpl.class))).newExportData();

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
   * Method under test:
   * {@link WidgetsBundleExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  void testGetSupportedEntityTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = (new WidgetsBundleExportService(new WidgetTypeServiceImpl()))
        .getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.WIDGETS_BUNDLE));
  }

  /**
   * Test {@link WidgetsBundleExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  void testGetSupportedEntityTypes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = (new WidgetsBundleExportService(mock(WidgetTypeServiceImpl.class)))
        .getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.WIDGETS_BUNDLE));
  }
}
