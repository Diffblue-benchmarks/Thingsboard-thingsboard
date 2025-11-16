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
package org.thingsboard.server.common.transport.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;

class TransportDeviceInfoDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TransportDeviceInfo}
   *   <li>{@link TransportDeviceInfo#setAdditionalInfo(String)}
   *   <li>{@link TransportDeviceInfo#setCustomerId(CustomerId)}
   *   <li>{@link TransportDeviceInfo#setDeviceName(String)}
   *   <li>{@link TransportDeviceInfo#setDeviceType(String)}
   *   <li>{@link TransportDeviceInfo#setEdrxCycle(Long)}
   *   <li>{@link TransportDeviceInfo#setGateway(boolean)}
   *   <li>{@link TransportDeviceInfo#setPagingTransmissionWindow(Long)}
   *   <li>{@link TransportDeviceInfo#setPowerMode(PowerMode)}
   *   <li>{@link TransportDeviceInfo#setPsmActivityTimer(Long)}
   *   <li>{@link TransportDeviceInfo#setTenantId(TenantId)}
   *   <li>{@link TransportDeviceInfo#toString()}
   *   <li>{@link TransportDeviceInfo#getAdditionalInfo()}
   *   <li>{@link TransportDeviceInfo#getCustomerId()}
   *   <li>{@link TransportDeviceInfo#getDeviceId()}
   *   <li>{@link TransportDeviceInfo#getDeviceName()}
   *   <li>{@link TransportDeviceInfo#getDeviceProfileId()}
   *   <li>{@link TransportDeviceInfo#getDeviceType()}
   *   <li>{@link TransportDeviceInfo#getEdrxCycle()}
   *   <li>{@link TransportDeviceInfo#getPagingTransmissionWindow()}
   *   <li>{@link TransportDeviceInfo#getPowerMode()}
   *   <li>{@link TransportDeviceInfo#getPsmActivityTimer()}
   *   <li>{@link TransportDeviceInfo#getTenantId()}
   *   <li>{@link TransportDeviceInfo#isGateway()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TransportDeviceInfo.<init>()",
    "String TransportDeviceInfo.getAdditionalInfo()",
    "CustomerId TransportDeviceInfo.getCustomerId()",
    "DeviceId TransportDeviceInfo.getDeviceId()",
    "String TransportDeviceInfo.getDeviceName()",
    "DeviceProfileId TransportDeviceInfo.getDeviceProfileId()",
    "String TransportDeviceInfo.getDeviceType()",
    "Long TransportDeviceInfo.getEdrxCycle()",
    "Long TransportDeviceInfo.getPagingTransmissionWindow()",
    "PowerMode TransportDeviceInfo.getPowerMode()",
    "Long TransportDeviceInfo.getPsmActivityTimer()",
    "TenantId TransportDeviceInfo.getTenantId()",
    "boolean TransportDeviceInfo.isGateway()",
    "void TransportDeviceInfo.setAdditionalInfo(String)",
    "void TransportDeviceInfo.setCustomerId(CustomerId)",
    "void TransportDeviceInfo.setDeviceId(DeviceId)",
    "void TransportDeviceInfo.setDeviceName(String)",
    "void TransportDeviceInfo.setDeviceProfileId(DeviceProfileId)",
    "void TransportDeviceInfo.setDeviceType(String)",
    "void TransportDeviceInfo.setEdrxCycle(Long)",
    "void TransportDeviceInfo.setGateway(boolean)",
    "void TransportDeviceInfo.setPagingTransmissionWindow(Long)",
    "void TransportDeviceInfo.setPowerMode(PowerMode)",
    "void TransportDeviceInfo.setPsmActivityTimer(Long)",
    "void TransportDeviceInfo.setTenantId(TenantId)",
    "String TransportDeviceInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TransportDeviceInfo actualTransportDeviceInfo = new TransportDeviceInfo();
    actualTransportDeviceInfo.setAdditionalInfo("Additional Info");
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    actualTransportDeviceInfo.setCustomerId(customerId);
    actualTransportDeviceInfo.setDeviceName("Device Name");
    actualTransportDeviceInfo.setDeviceType("Device Type");
    actualTransportDeviceInfo.setEdrxCycle(1L);
    actualTransportDeviceInfo.setGateway(true);
    actualTransportDeviceInfo.setPagingTransmissionWindow(1L);
    actualTransportDeviceInfo.setPowerMode(PowerMode.PSM);
    actualTransportDeviceInfo.setPsmActivityTimer(1L);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    actualTransportDeviceInfo.setTenantId(tenantId);
    actualTransportDeviceInfo.toString();
    String actualAdditionalInfo = actualTransportDeviceInfo.getAdditionalInfo();
    CustomerId actualCustomerId = actualTransportDeviceInfo.getCustomerId();
    DeviceId actualDeviceId = actualTransportDeviceInfo.getDeviceId();
    String actualDeviceName = actualTransportDeviceInfo.getDeviceName();
    DeviceProfileId actualDeviceProfileId = actualTransportDeviceInfo.getDeviceProfileId();
    String actualDeviceType = actualTransportDeviceInfo.getDeviceType();
    Long actualEdrxCycle = actualTransportDeviceInfo.getEdrxCycle();
    Long actualPagingTransmissionWindow = actualTransportDeviceInfo.getPagingTransmissionWindow();
    PowerMode actualPowerMode = actualTransportDeviceInfo.getPowerMode();
    Long actualPsmActivityTimer = actualTransportDeviceInfo.getPsmActivityTimer();
    TenantId actualTenantId = actualTransportDeviceInfo.getTenantId();
    boolean actualIsGatewayResult = actualTransportDeviceInfo.isGateway();

    // Assert
    assertEquals("Additional Info", actualAdditionalInfo);
    assertEquals("Device Name", actualDeviceName);
    assertEquals("Device Type", actualDeviceType);
    assertNull(actualDeviceId);
    assertNull(actualDeviceProfileId);
    assertEquals(1L, actualEdrxCycle.longValue());
    assertEquals(1L, actualPagingTransmissionWindow.longValue());
    assertEquals(1L, actualPsmActivityTimer.longValue());
    assertEquals(PowerMode.PSM, actualPowerMode);
    assertTrue(actualIsGatewayResult);
    assertSame(customerId, actualCustomerId);
    assertSame(tenantId, actualTenantId);
  }
}
