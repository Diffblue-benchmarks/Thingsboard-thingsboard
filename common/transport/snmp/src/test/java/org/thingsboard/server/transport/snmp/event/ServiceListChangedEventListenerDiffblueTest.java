package org.thingsboard.server.transport.snmp.event;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.LazyStringArrayList;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ServiceInfo;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.discovery.event.ServiceListChangedEvent;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.transport.snmp.service.PduService;
import org.thingsboard.server.transport.snmp.service.SnmpTransportBalancingService;
import org.thingsboard.server.transport.snmp.service.SnmpTransportService;

class ServiceListChangedEventListenerDiffblueTest {
  /**
   * Test {@link ServiceListChangedEventListener#onTbApplicationEvent(ServiceListChangedEvent)} with
   * {@code ServiceListChangedEvent}.
   *
   * <p>Method under test: {@link
   * ServiceListChangedEventListener#onTbApplicationEvent(ServiceListChangedEvent)}
   */
  @Test
  @DisplayName("Test onTbApplicationEvent(ServiceListChangedEvent) with 'ServiceListChangedEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServiceListChangedEventListener.onTbApplicationEvent(ServiceListChangedEvent)"
  })
  void testOnTbApplicationEventWithServiceListChangedEvent() {
    // Arrange
    SnmpTransportBalancingService snmpTransportBalancingService =
        mock(SnmpTransportBalancingService.class);
    doNothing()
        .when(snmpTransportBalancingService)
        .onServiceListChanged(Mockito.<ServiceListChangedEvent>any());
    ServiceListChangedEventListener serviceListChangedEventListener =
        new ServiceListChangedEventListener(snmpTransportBalancingService);

    // Act
    serviceListChangedEventListener.onTbApplicationEvent(
        new ServiceListChangedEvent(new ArrayList<>(), ServiceInfo.getDefaultInstance()));

    // Assert
    verify(snmpTransportBalancingService).onServiceListChanged(isA(ServiceListChangedEvent.class));
  }

  /**
   * Test {@link ServiceListChangedEventListener#onTbApplicationEvent(ServiceListChangedEvent)} with
   * {@code ServiceListChangedEvent}.
   *
   * <ul>
   *   <li>Then calls {@link ServiceInfo#getTransportsList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ServiceListChangedEventListener#onTbApplicationEvent(ServiceListChangedEvent)}
   */
  @Test
  @DisplayName(
      "Test onTbApplicationEvent(ServiceListChangedEvent) with 'ServiceListChangedEvent'; then calls getTransportsList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServiceListChangedEventListener.onTbApplicationEvent(ServiceListChangedEvent)"
  })
  void testOnTbApplicationEventWithServiceListChangedEvent_thenCallsGetTransportsList() {
    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();

    DefaultTransportService transportService =
        new DefaultTransportService(
            null,
            null,
            null,
            null,
            topicService,
            serviceInfoProvider2,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            null,
            new DefaultSchedulerComponent(),
            mock(ApplicationEventPublisher.class),
            null,
            mock(NotificationRuleProcessor.class),
            null);
    SnmpTransportService snmpTransportService =
        new SnmpTransportService(transportService, new PduService());

    SnmpTransportBalancingService snmpTransportBalancingService =
        new SnmpTransportBalancingService(partitionService, eventPublisher, snmpTransportService);
    ServiceListChangedEventListener serviceListChangedEventListener =
        new ServiceListChangedEventListener(snmpTransportBalancingService);

    ServiceInfo currentService = mock(ServiceInfo.class);
    when(currentService.getTransportsList()).thenReturn(LazyStringArrayList.emptyList());
    ServiceListChangedEvent event = new ServiceListChangedEvent(new ArrayList<>(), currentService);

    // Act
    serviceListChangedEventListener.onTbApplicationEvent(event);

    // Assert
    verify(currentService).getTransportsList();
  }
}
