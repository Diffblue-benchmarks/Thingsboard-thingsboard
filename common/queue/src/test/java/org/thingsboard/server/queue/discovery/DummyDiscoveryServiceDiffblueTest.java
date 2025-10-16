/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ServiceInfo;

@ExtendWith(MockitoExtension.class)
class DummyDiscoveryServiceDiffblueTest {
  @InjectMocks private DummyDiscoveryService dummyDiscoveryService;

  /**
   * Test {@link DummyDiscoveryService#onApplicationEvent(ApplicationReadyEvent)}.
   *
   * <ul>
   *   <li>Then calls {@link HashPartitionService#recalculatePartitions(ServiceInfo, List)}.
   * </ul>
   *
   * <p>Method under test: {@link DummyDiscoveryService#onApplicationEvent(ApplicationReadyEvent)}
   */
  @Test
  @DisplayName(
      "Test onApplicationEvent(ApplicationReadyEvent); then calls recalculatePartitions(ServiceInfo, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DummyDiscoveryService.onApplicationEvent(ApplicationReadyEvent)"})
  void testOnApplicationEvent_thenCallsRecalculatePartitions() {
    // Arrange
    HashPartitionService partitionService = mock(HashPartitionService.class);
    doNothing()
        .when(partitionService)
        .recalculatePartitions(Mockito.<ServiceInfo>any(), Mockito.<List<ServiceInfo>>any());
    DummyDiscoveryService dummyDiscoveryService =
        new DummyDiscoveryService(new DefaultTbServiceInfoProvider(), partitionService);
    Class<Object> forNameResult = Object.class;
    SpringApplication application = new SpringApplication(forNameResult);
    String[] args = new String[] {"Args"};

    ApplicationReadyEvent event =
        new ApplicationReadyEvent(
            application,
            args,
            new AnnotationConfigReactiveWebApplicationContext(),
            Duration.ofSeconds(1L));

    // Act
    dummyDiscoveryService.onApplicationEvent(event);

    // Assert
    verify(partitionService).recalculatePartitions(isNull(), isA(List.class));
  }

  /**
   * Test {@link DummyDiscoveryService#getOtherServers()}.
   *
   * <p>Method under test: {@link DummyDiscoveryService#getOtherServers()}
   */
  @Test
  @DisplayName("Test getOtherServers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DummyDiscoveryService.getOtherServers()"})
  void testGetOtherServers() {
    // Arrange, Act and Assert
    assertTrue(dummyDiscoveryService.getOtherServers().isEmpty());
  }

  /**
   * Test {@link DummyDiscoveryService#isMonolith()}.
   *
   * <p>Method under test: {@link DummyDiscoveryService#isMonolith()}
   */
  @Test
  @DisplayName("Test isMonolith()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DummyDiscoveryService.isMonolith()"})
  void testIsMonolith() {
    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider2,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    DummyDiscoveryService dummyDiscoveryService =
        new DummyDiscoveryService(serviceInfoProvider, partitionService);

    // Act and Assert
    assertTrue(dummyDiscoveryService.isMonolith());
  }
}
