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
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.gen.transport.TransportProtos;

class DummyDiscoveryServiceDiffblueTest {
  /**
   * Method under test:
   * {@link DummyDiscoveryService#onApplicationEvent(ApplicationReadyEvent)}
   */
  @Test
  void testOnApplicationEvent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashPartitionService partitionService = mock(HashPartitionService.class);
    doNothing().when(partitionService)
        .recalculatePartitions(Mockito.<TransportProtos.ServiceInfo>any(),
            Mockito.<List<TransportProtos.ServiceInfo>>any());
    DummyDiscoveryService dummyDiscoveryService = new DummyDiscoveryService(new DefaultTbServiceInfoProvider(),
        partitionService);
    Class<Object> forNameResult = Object.class;
    SpringApplication application = new SpringApplication(forNameResult);

    // Act
    dummyDiscoveryService.onApplicationEvent(new ApplicationReadyEvent(application, new String[]{"Args"},
        new AnnotationConfigReactiveWebApplicationContext(), null));

    // Assert that nothing has changed
    verify(partitionService).recalculatePartitions(isNull(), isA(List.class));
  }

  /**
   * Method under test: {@link DummyDiscoveryService#getOtherServers()}
   */
  @Test
  void testGetOtherServers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    // Act and Assert
    assertTrue((new DummyDiscoveryService(serviceInfoProvider, new HashPartitionService(serviceInfoProvider2,
        tenantRoutingInfoService, applicationEventPublisher, queueRoutingInfoService, new TopicService())))
        .getOtherServers()
        .isEmpty());
  }

  /**
   * Method under test: {@link DummyDiscoveryService#isMonolith()}
   */
  @Test
  void testIsMonolith() {
    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    // Act and Assert
    assertTrue((new DummyDiscoveryService(serviceInfoProvider, new HashPartitionService(serviceInfoProvider2,
        tenantRoutingInfoService, applicationEventPublisher, queueRoutingInfoService, new TopicService())))
        .isMonolith());
  }
}
