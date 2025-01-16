package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.data.ComplexEntitiesExportCtx;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;

class EntityViewExportServiceDiffblueTest {
  /**
   * Test
   * {@link EntityViewExportService#setRelatedEntities(EntitiesExportCtx, EntityView, EntityExportData)}
   * with {@code EntitiesExportCtx}, {@code EntityView}, {@code EntityExportData}.
   * <p>
   * Method under test:
   * {@link EntityViewExportService#setRelatedEntities(EntitiesExportCtx, EntityView, EntityExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, EntityView, EntityExportData) with 'EntitiesExportCtx', 'EntityView', 'EntityExportData'")
  void testSetRelatedEntitiesWithEntitiesExportCtxEntityViewEntityExportData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityViewExportService entityViewExportService = new EntityViewExportService();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    User user = mock(User.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    EntityView entityView = new EntityView();

    // Act
    entityViewExportService.setRelatedEntities(ctx, entityView, new EntityExportData<>());

    // Assert
    verify(request).getEntityTypes();
  }

  /**
   * Test {@link EntityViewExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test: {@link EntityViewExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  void testGetSupportedEntityTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = (new EntityViewExportService()).getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.ENTITY_VIEW));
  }
}
