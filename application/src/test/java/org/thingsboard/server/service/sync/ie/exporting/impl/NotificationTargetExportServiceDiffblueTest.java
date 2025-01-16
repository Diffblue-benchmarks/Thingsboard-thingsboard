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
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.targets.MicrosoftTeamsNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.targets.platform.PlatformUsersNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilter;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilterType;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.data.ComplexEntitiesExportCtx;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;

class NotificationTargetExportServiceDiffblueTest {
  /**
   * Test
   * {@link NotificationTargetExportService#setRelatedEntities(EntitiesExportCtx, NotificationTarget, EntityExportData)}
   * with {@code EntitiesExportCtx}, {@code NotificationTarget},
   * {@code EntityExportData}.
   * <p>
   * Method under test:
   * {@link NotificationTargetExportService#setRelatedEntities(EntitiesExportCtx, NotificationTarget, EntityExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, NotificationTarget, EntityExportData) with 'EntitiesExportCtx', 'NotificationTarget', 'EntityExportData'")
  void testSetRelatedEntitiesWithEntitiesExportCtxNotificationTargetEntityExportData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTargetExportService notificationTargetExportService = new NotificationTargetExportService();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    User user = mock(User.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(new MicrosoftTeamsNotificationTargetConfig());

    // Act
    notificationTargetExportService.setRelatedEntities(ctx, notificationTarget, new EntityExportData<>());

    // Assert that nothing has changed
    verify(request).getEntityTypes();
  }

  /**
   * Test
   * {@link NotificationTargetExportService#setRelatedEntities(EntitiesExportCtx, NotificationTarget, EntityExportData)}
   * with {@code EntitiesExportCtx}, {@code NotificationTarget},
   * {@code EntityExportData}.
   * <p>
   * Method under test:
   * {@link NotificationTargetExportService#setRelatedEntities(EntitiesExportCtx, NotificationTarget, EntityExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, NotificationTarget, EntityExportData) with 'EntitiesExportCtx', 'NotificationTarget', 'EntityExportData'")
  void testSetRelatedEntitiesWithEntitiesExportCtxNotificationTargetEntityExportData2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTargetExportService notificationTargetExportService = new NotificationTargetExportService();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    User user = mock(User.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);

    PlatformUsersNotificationTargetConfig configuration = new PlatformUsersNotificationTargetConfig();
    configuration.setDescription("The characteristics of someone or something");
    configuration.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(configuration);

    // Act
    notificationTargetExportService.setRelatedEntities(ctx, notificationTarget, new EntityExportData<>());

    // Assert that nothing has changed
    verify(usersFilter).getType();
    verify(request).getEntityTypes();
  }

  /**
   * Test {@link NotificationTargetExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test:
   * {@link NotificationTargetExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  void testGetSupportedEntityTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = (new NotificationTargetExportService()).getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.NOTIFICATION_TARGET));
  }
}
