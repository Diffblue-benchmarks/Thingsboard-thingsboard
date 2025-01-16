package org.thingsboard.server.service.entitiy.dashboard;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.dao.resource.BaseResourceService;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.widget.WidgetsBundleServiceImpl;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.service.sync.DefaultGitSyncService;

class DashboardSyncServiceDiffblueTest {
  /**
   * Test {@link DashboardSyncService#init()}.
   * <ul>
   *   <li>Given {@link DefaultGitSyncService}
   * {@link DefaultGitSyncService#registerSync(String, String, String, long, Runnable)}
   * does nothing.</li>
   *   <li>Then calls
   * {@link DefaultGitSyncService#registerSync(String, String, String, long, Runnable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardSyncService#init()}
   */
  @Test
  @DisplayName("Test init(); given DefaultGitSyncService registerSync(String, String, String, long, Runnable) does nothing; then calls registerSync(String, String, String, long, Runnable)")
  void testInit_givenDefaultGitSyncServiceRegisterSyncDoesNothing_thenCallsRegisterSync() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultGitSyncService gitSyncService = mock(DefaultGitSyncService.class);
    doNothing().when(gitSyncService)
        .registerSync(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(), anyLong(),
            Mockito.<Runnable>any());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    BaseResourceService resourceService = new BaseResourceService(resourceDao, resourceInfoDao,
        new ResourceDataValidator());

    WidgetsBundleServiceImpl widgetsBundleService = new WidgetsBundleServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    // Act
    (new DashboardSyncService(gitSyncService, resourceService, widgetsBundleService,
        new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService, applicationEventPublisher,
            queueRoutingInfoService, new TopicService())))
        .init();

    // Assert that nothing has changed
    verify(gitSyncService).registerSync(eq("gateways-dashboard"), isNull(), isNull(), eq(0L), isA(Runnable.class));
  }
}
