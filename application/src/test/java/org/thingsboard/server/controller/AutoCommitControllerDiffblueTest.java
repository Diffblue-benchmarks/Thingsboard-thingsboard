package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.dao.alarm.AlarmCommentService;
import org.thingsboard.server.dao.asset.AssetProfileService;
import org.thingsboard.server.dao.asset.AssetService;
import org.thingsboard.server.dao.attributes.AttributesService;
import org.thingsboard.server.dao.audit.AuditLogService;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.dashboard.DashboardService;
import org.thingsboard.server.dao.device.ClaimDevicesService;
import org.thingsboard.server.dao.device.DeviceCredentialsService;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.device.DeviceService;
import org.thingsboard.server.dao.domain.DomainService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.mobile.MobileAppService;
import org.thingsboard.server.dao.oauth2.OAuth2ClientService;
import org.thingsboard.server.dao.oauth2.OAuth2ConfigTemplateService;
import org.thingsboard.server.dao.ota.OtaPackageService;
import org.thingsboard.server.dao.queue.QueueService;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.resource.ResourceService;
import org.thingsboard.server.dao.rpc.RpcService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileService;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.dao.widget.WidgetTypeService;
import org.thingsboard.server.dao.widget.WidgetsBundleService;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.provider.TbQueueProducerProvider;
import org.thingsboard.server.service.action.EntityActionService;
import org.thingsboard.server.service.component.ComponentDiscoveryService;
import org.thingsboard.server.service.entitiy.TbLogEntityActionService;
import org.thingsboard.server.service.entitiy.user.TbUserSettingsService;
import org.thingsboard.server.service.ota.OtaPackageStateService;
import org.thingsboard.server.service.profile.TbAssetProfileCache;
import org.thingsboard.server.service.profile.TbDeviceProfileCache;
import org.thingsboard.server.service.security.permission.AccessControlService;
import org.thingsboard.server.service.state.DeviceStateService;
import org.thingsboard.server.service.sync.ie.exporting.ExportableEntitiesService;
import org.thingsboard.server.service.sync.vc.EntitiesVersionControlService;
import org.thingsboard.server.service.telemetry.AlarmSubscriptionService;
import org.thingsboard.server.service.telemetry.TelemetrySubscriptionService;

@ContextConfiguration(classes = {AutoCommitController.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class AutoCommitControllerDiffblueTest {
  @MockBean private AccessControlService accessControlService;

  @MockBean private AlarmCommentService alarmCommentService;

  @MockBean private AlarmSubscriptionService alarmSubscriptionService;

  @MockBean private AssetProfileService assetProfileService;

  @MockBean private AssetService assetService;

  @MockBean private AttributesService attributesService;

  @MockBean private AuditLogService auditLogService;

  @Autowired private AutoCommitController autoCommitController;

  @MockBean private ClaimDevicesService claimDevicesService;

  @MockBean private ComponentDiscoveryService componentDiscoveryService;

  @MockBean private CustomerService customerService;

  @MockBean private DashboardService dashboardService;

  @MockBean private DeviceCredentialsService deviceCredentialsService;

  @MockBean private DeviceProfileService deviceProfileService;

  @MockBean private DeviceService deviceService;

  @MockBean private DeviceStateService deviceStateService;

  @MockBean private DomainService domainService;

  @MockBean private EntitiesVersionControlService entitiesVersionControlService;

  @MockBean private EntityActionService entityActionService;

  @MockBean private EntityViewService entityViewService;

  @MockBean private ExportableEntitiesService exportableEntitiesService;

  @MockBean private MobileAppService mobileAppService;

  @MockBean private OAuth2ClientService oAuth2ClientService;

  @MockBean private OAuth2ConfigTemplateService oAuth2ConfigTemplateService;

  @MockBean private OtaPackageService otaPackageService;

  @MockBean private OtaPackageStateService otaPackageStateService;

  @MockBean private PartitionService partitionService;

  @MockBean private QueueService queueService;

  @MockBean private RelationService relationService;

  @MockBean private ResourceService resourceService;

  @MockBean private RpcService rpcService;

  @MockBean private RuleChainService ruleChainService;

  @MockBean private TbAssetProfileCache tbAssetProfileCache;

  @MockBean private TbClusterService tbClusterService;

  @MockBean private TbDeviceProfileCache tbDeviceProfileCache;

  @MockBean private TbLogEntityActionService tbLogEntityActionService;

  @MockBean private TbQueueProducerProvider tbQueueProducerProvider;

  @MockBean private TbServiceInfoProvider tbServiceInfoProvider;

  @MockBean private TbTenantProfileCache tbTenantProfileCache;

  @MockBean private TbUserSettingsService tbUserSettingsService;

  @MockBean private TelemetrySubscriptionService telemetrySubscriptionService;

  @MockBean private TenantProfileService tenantProfileService;

  @MockBean private TenantService tenantService;

  @MockBean private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  @MockBean private UserService userService;

  @MockBean private WidgetTypeService widgetTypeService;

  @MockBean private WidgetsBundleService widgetsBundleService;

  /**
   * Test {@link AutoCommitController#autoCommit(User, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link AutoCommitController} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link AutoCommitController#autoCommit(User, EntityId)}
   */
  @Test
  @DisplayName(
      "Test autoCommit(User, EntityId); given AutoCommitController (default constructor); when 'null'; then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture AutoCommitController.autoCommit(User, EntityId)"})
  void testAutoCommit_givenAutoCommitController_whenNull_thenReturnDone() throws Exception {
    // Arrange
    AutoCommitController autoCommitController = new AutoCommitController();

    // Act and Assert
    assertTrue(autoCommitController.autoCommit(new User(), null).isDone());
  }

  /**
   * Test {@link AutoCommitController#autoCommit(User, EntityId)}.
   *
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link AutoCommitController#autoCommit(User, EntityId)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityId); then return ApiFutureToListenableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture AutoCommitController.autoCommit(User, EntityId)"})
  void testAutoCommit_thenReturnApiFutureToListenableFuture() throws Exception {
    // Arrange
    SettableFuture<UUID> delegate = SettableFuture.create();
    ForwardingApiFuture<UUID> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    ApiFutureToListenableFuture<UUID> apiFutureToListenableFuture =
        new ApiFutureToListenableFuture<>(apiFuture);
    when(entitiesVersionControlService.autoCommit(Mockito.<User>any(), Mockito.<EntityId>any()))
        .thenReturn(apiFutureToListenableFuture);

    // Act
    ListenableFuture<UUID> actualAutoCommitResult =
        autoCommitController.autoCommit(new User(), null);

    // Assert
    verify(entitiesVersionControlService).autoCommit(isA(User.class), isNull());
    assertTrue(actualAutoCommitResult instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualAutoCommitResult);
  }

  /**
   * Test {@link AutoCommitController#autoCommit(User, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AutoCommitController#autoCommit(User, EntityId)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityId); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture AutoCommitController.autoCommit(User, EntityId)"})
  void testAutoCommit_thenThrowRuntimeException() throws Exception {
    // Arrange
    when(entitiesVersionControlService.autoCommit(Mockito.<User>any(), Mockito.<EntityId>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> autoCommitController.autoCommit(new User(), null));
    verify(entitiesVersionControlService).autoCommit(isA(User.class), isNull());
  }
}
