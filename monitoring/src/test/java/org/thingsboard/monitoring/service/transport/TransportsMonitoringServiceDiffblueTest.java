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
package org.thingsboard.monitoring.service.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.monitoring.client.TbClient;
import org.thingsboard.monitoring.client.WsClientFactory;
import org.thingsboard.monitoring.config.transport.TransportMonitoringConfig;
import org.thingsboard.monitoring.config.transport.TransportMonitoringTarget;
import org.thingsboard.monitoring.service.MonitoringReporter;
import org.thingsboard.monitoring.util.TbStopWatch;

@ContextConfiguration(classes = {TransportsMonitoringService.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class TransportsMonitoringServiceDiffblueTest {
  @Autowired private ApplicationContext applicationContext;

  @Autowired private List<TransportMonitoringConfig> list;

  @MockBean private MonitoringReporter monitoringReporter;

  @MockBean private TbClient tbClient;

  @MockBean private TbStopWatch tbStopWatch;

  @MockBean private TransportMonitoringConfig transportMonitoringConfig;

  @Autowired private TransportsMonitoringService transportsMonitoringService;

  @MockBean private WsClientFactory wsClientFactory;

  /**
   * Test {@link TransportsMonitoringService#createTarget(String)}.
   *
   * <p>Method under test: {@link TransportsMonitoringService#createTarget(String)}
   */
  @Test
  @DisplayName("Test createTarget(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TransportMonitoringTarget TransportsMonitoringService.createTarget(String)"})
  void testCreateTarget() {
    // Arrange and Act
    TransportMonitoringTarget actualCreateTargetResult =
        transportsMonitoringService.createTarget("https://example.org/example");

    // Assert
    assertEquals("Main", actualCreateTargetResult.getQueue());
    assertEquals("https://example.org/example", actualCreateTargetResult.getBaseUrl());
    assertNull(actualCreateTargetResult.getDevice());
    assertFalse(actualCreateTargetResult.isCheckDomainIps());
  }

  /**
   * Test {@link TransportsMonitoringService#getName()}.
   *
   * <p>Method under test: {@link TransportsMonitoringService#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TransportsMonitoringService.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("transports check", new TransportsMonitoringService().getName());
  }
}
