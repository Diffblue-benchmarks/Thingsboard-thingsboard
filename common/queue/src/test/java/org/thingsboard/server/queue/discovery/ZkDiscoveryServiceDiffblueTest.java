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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class ZkDiscoveryServiceDiffblueTest {
  @Mock private TbServiceInfoProvider tbServiceInfoProvider;

  @InjectMocks private ZkDiscoveryService zkDiscoveryService;

  /**
   * Test {@link ZkDiscoveryService#isMonolith()}.
   *
   * <p>Method under test: {@link ZkDiscoveryService#isMonolith()}
   */
  @Test
  @DisplayName("Test isMonolith()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZkDiscoveryService.isMonolith()"})
  void testIsMonolith() {
    // Arrange
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider2,
            tenantRoutingInfoService,
            applicationEventPublisher2,
            queueRoutingInfoService,
            new TopicService());

    ZkDiscoveryService zkDiscoveryService =
        new ZkDiscoveryService(applicationEventPublisher, serviceInfoProvider, partitionService);

    // Act and Assert
    assertFalse(zkDiscoveryService.isMonolith());
  }

  /**
   * Test {@link ZkDiscoveryService#publishCurrentServer()}.
   *
   * <p>Method under test: {@link ZkDiscoveryService#publishCurrentServer()}
   */
  @Test
  @DisplayName("Test publishCurrentServer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZkDiscoveryService.publishCurrentServer()"})
  void testPublishCurrentServer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceInfo()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> zkDiscoveryService.publishCurrentServer());
    verify(tbServiceInfoProvider).getServiceInfo();
  }

  /**
   * Test {@link ZkDiscoveryService#missingProperty(String)}.
   *
   * <p>Method under test: {@link ZkDiscoveryService#missingProperty(String)}
   */
  @Test
  @DisplayName("Test missingProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ZkDiscoveryService.missingProperty(String)"})
  void testMissingProperty() {
    // Arrange, Act and Assert
    assertEquals(
        "The Property Name property need to be set!",
        ZkDiscoveryService.missingProperty("Property Name"));
  }

  /**
   * Test {@link ZkDiscoveryService#recalculatePartitions()}.
   *
   * <p>Method under test: {@link ZkDiscoveryService#recalculatePartitions()}
   */
  @Test
  @DisplayName("Test recalculatePartitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZkDiscoveryService.recalculatePartitions()"})
  void testRecalculatePartitions() {
    // Arrange
    when(tbServiceInfoProvider.getServiceInfo()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> zkDiscoveryService.recalculatePartitions());
    verify(tbServiceInfoProvider).getServiceInfo();
  }
}
