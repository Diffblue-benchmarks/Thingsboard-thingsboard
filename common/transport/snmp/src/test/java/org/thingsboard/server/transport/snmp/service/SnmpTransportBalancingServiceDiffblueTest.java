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
package org.thingsboard.server.transport.snmp.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.queue.discovery.PartitionService;

@ExtendWith(MockitoExtension.class)
class SnmpTransportBalancingServiceDiffblueTest {
  @Mock private PartitionService partitionService;

  @InjectMocks private SnmpTransportBalancingService snmpTransportBalancingService;

  /**
   * Test {@link SnmpTransportBalancingService#isManagedByCurrentTransport(UUID)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportBalancingService#isManagedByCurrentTransport(UUID)}
   */
  @Test
  @DisplayName("Test isManagedByCurrentTransport(UUID); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SnmpTransportBalancingService.isManagedByCurrentTransport(UUID)"})
  void testIsManagedByCurrentTransport_thenReturnFalse() {
    // Arrange
    when(partitionService.resolvePartitionIndex(Mockito.<UUID>any(), anyInt())).thenReturn(1);

    // Act
    boolean actualIsManagedByCurrentTransportResult =
        snmpTransportBalancingService.isManagedByCurrentTransport(UUID.randomUUID());

    // Assert
    verify(partitionService).resolvePartitionIndex(isA(UUID.class), eq(1));
    assertFalse(actualIsManagedByCurrentTransportResult);
  }

  /**
   * Test {@link SnmpTransportBalancingService#isManagedByCurrentTransport(UUID)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportBalancingService#isManagedByCurrentTransport(UUID)}
   */
  @Test
  @DisplayName("Test isManagedByCurrentTransport(UUID); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SnmpTransportBalancingService.isManagedByCurrentTransport(UUID)"})
  void testIsManagedByCurrentTransport_thenReturnTrue() {
    // Arrange
    when(partitionService.resolvePartitionIndex(Mockito.<UUID>any(), anyInt())).thenReturn(0);

    // Act
    boolean actualIsManagedByCurrentTransportResult =
        snmpTransportBalancingService.isManagedByCurrentTransport(UUID.randomUUID());

    // Assert
    verify(partitionService).resolvePartitionIndex(isA(UUID.class), eq(1));
    assertTrue(actualIsManagedByCurrentTransportResult);
  }
}
