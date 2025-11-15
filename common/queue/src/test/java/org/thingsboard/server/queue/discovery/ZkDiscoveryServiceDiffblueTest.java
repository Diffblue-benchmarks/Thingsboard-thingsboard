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
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;

class ZkDiscoveryServiceDiffblueTest {
  /**
   * Test {@link ZkDiscoveryService#isMonolith()}.
   * <p>
   * Method under test: {@link ZkDiscoveryService#isMonolith()}
   */
  @Test
  @DisplayName("Test isMonolith()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ZkDiscoveryService.isMonolith()"})
  void testIsMonolith() {
    // Arrange
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    // Act and Assert
    assertFalse((new ZkDiscoveryService(applicationEventPublisher, serviceInfoProvider,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher2,
            queueRoutingInfoService, new TopicService())))
        .isMonolith());
  }

  /**
   * Test {@link ZkDiscoveryService#missingProperty(String)}.
   * <p>
   * Method under test: {@link ZkDiscoveryService#missingProperty(String)}
   */
  @Test
  @DisplayName("Test missingProperty(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ZkDiscoveryService.missingProperty(String)"})
  void testMissingProperty() {
    // Arrange, Act and Assert
    assertEquals("The Property Name property need to be set!", ZkDiscoveryService.missingProperty("Property Name"));
  }
}
