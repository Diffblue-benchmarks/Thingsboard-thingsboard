package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.targets.platform.CustomerUsersFilter;
import org.thingsboard.server.common.data.notification.targets.platform.PlatformUsersNotificationTargetConfig;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.common.data.sync.vc.request.create.SyncStrategy;
import org.thingsboard.server.service.sync.ie.exporting.ExportableEntitiesService;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.data.ComplexEntitiesExportCtx;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;

@ExtendWith(MockitoExtension.class)
class NotificationTargetExportServiceDiffblueTest {
  @Mock
  private ExportableEntitiesService exportableEntitiesService;

  @InjectMocks
  private NotificationTargetExportService notificationTargetExportService;

  /**
   * Test {@link NotificationTargetExportService#setRelatedEntities(EntitiesExportCtx, NotificationTarget, EntityExportData)} with {@code EntitiesExportCtx}, {@code NotificationTarget}, {@code EntityExportData}.
   * <p>
   * Method under test: {@link NotificationTargetExportService#setRelatedEntities(EntitiesExportCtx, NotificationTarget, EntityExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, NotificationTarget, EntityExportData) with 'EntitiesExportCtx', 'NotificationTarget', 'EntityExportData'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void NotificationTargetExportService.setRelatedEntities(EntitiesExportCtx, NotificationTarget, EntityExportData)"})
  void testSetRelatedEntitiesWithEntitiesExportCtxNotificationTargetEntityExportData() {
    // Arrange
    when(exportableEntitiesService.getExternalIdByInternal(Mockito.<CustomerId>any()))
        .thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ComplexVersionCreateRequest request = new ComplexVersionCreateRequest();
    request.setBranch("janedoe/featurebranch");
    request.setEntityTypes(new HashMap<>());
    request.setSyncStrategy(SyncStrategy.MERGE);
    request.setVersionName("1.0.2");
    User user = new User();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    CustomerUsersFilter usersFilter = new CustomerUsersFilter();
    usersFilter.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PlatformUsersNotificationTargetConfig configuration = new PlatformUsersNotificationTargetConfig();
    configuration.setDescription("The characteristics of someone or something");
    configuration.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(configuration);

    // Act
    notificationTargetExportService.setRelatedEntities(ctx, notificationTarget, new EntityExportData<>());

    // Assert
    verify(exportableEntitiesService).getExternalIdByInternal(isA(CustomerId.class));
    assertEquals(1, ctx.getExternalIdMap().size());
  }

  /**
   * Test {@link NotificationTargetExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test: {@link NotificationTargetExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set NotificationTargetExportService.getSupportedEntityTypes()"})
  void testGetSupportedEntityTypes() {
    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = notificationTargetExportService.getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.NOTIFICATION_TARGET));
  }
}
