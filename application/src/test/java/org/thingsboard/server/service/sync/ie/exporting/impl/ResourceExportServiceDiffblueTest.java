package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityExportSettings;
import org.thingsboard.server.service.sync.vc.data.ComplexEntitiesExportCtx;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;

class ResourceExportServiceDiffblueTest {
  /**
   * Test
   * {@link ResourceExportService#setAdditionalExportData(EntitiesExportCtx, TbResource, EntityExportData)}
   * with {@code EntitiesExportCtx}, {@code TbResource}, {@code EntityExportData}.
   * <p>
   * Method under test:
   * {@link ResourceExportService#setAdditionalExportData(EntitiesExportCtx, TbResource, EntityExportData)}
   */
  @Test
  @DisplayName("Test setAdditionalExportData(EntitiesExportCtx, TbResource, EntityExportData) with 'EntitiesExportCtx', 'TbResource', 'EntityExportData'")
  void testSetAdditionalExportDataWithEntitiesExportCtxTbResourceEntityExportData() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceExportService resourceExportService = new ResourceExportService();
    EntityExportSettings.EntityExportSettingsBuilder entityExportSettingsBuilder = mock(
        EntityExportSettings.EntityExportSettingsBuilder.class);
    when(entityExportSettingsBuilder.exportAttributes(anyBoolean())).thenReturn(EntityExportSettings.builder());
    EntityExportSettings buildResult = entityExportSettingsBuilder.exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(false)
        .build();
    ComplexEntitiesExportCtx ctx = mock(ComplexEntitiesExportCtx.class);
    when(ctx.getSettings()).thenReturn(buildResult);
    TbResource resource = new TbResource();

    // Act
    resourceExportService.setAdditionalExportData(ctx, resource, new EntityExportData<>());

    // Assert
    verify(entityExportSettingsBuilder).exportAttributes(eq(true));
    verify(ctx).getSettings();
  }

  /**
   * Test {@link ResourceExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test: {@link ResourceExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  void testGetSupportedEntityTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = (new ResourceExportService()).getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.TB_RESOURCE));
  }
}
