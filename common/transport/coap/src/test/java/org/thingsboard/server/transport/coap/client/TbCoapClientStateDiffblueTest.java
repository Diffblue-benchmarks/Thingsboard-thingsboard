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
package org.thingsboard.server.transport.coap.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.transport.auth.TransportDeviceInfo;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;

class TbCoapClientStateDiffblueTest {
  /**
   * Method under test:
   * {@link TbCoapClientState#init(ValidateDeviceCredentialsResponse)}
   */
  @Test
  void testInit() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);
    TransportDeviceInfo transportDeviceInfo = mock(TransportDeviceInfo.class);
    when(transportDeviceInfo.getEdrxCycle()).thenReturn(1L);
    when(transportDeviceInfo.getPagingTransmissionWindow()).thenReturn(1L);
    when(transportDeviceInfo.getPsmActivityTimer()).thenReturn(1L);
    when(transportDeviceInfo.getPowerMode()).thenReturn(PowerMode.PSM);
    when(transportDeviceInfo.getDeviceProfileId()).thenReturn(null);
    doNothing().when(transportDeviceInfo).setDeviceProfileId(Mockito.<DeviceProfileId>any());
    doNothing().when(transportDeviceInfo).setDeviceType(Mockito.<String>any());
    doNothing().when(transportDeviceInfo).setEdrxCycle(Mockito.<Long>any());
    doNothing().when(transportDeviceInfo).setGateway(anyBoolean());
    doNothing().when(transportDeviceInfo).setPagingTransmissionWindow(Mockito.<Long>any());
    doNothing().when(transportDeviceInfo).setPowerMode(Mockito.<PowerMode>any());
    doNothing().when(transportDeviceInfo).setPsmActivityTimer(Mockito.<Long>any());
    doNothing().when(transportDeviceInfo).setTenantId(Mockito.<TenantId>any());
    doNothing().when(transportDeviceInfo).setDeviceId(Mockito.<DeviceId>any());
    doNothing().when(transportDeviceInfo).setDeviceName(Mockito.<String>any());
    doNothing().when(transportDeviceInfo).setAdditionalInfo(Mockito.<String>any());
    doNothing().when(transportDeviceInfo).setCustomerId(Mockito.<CustomerId>any());
    transportDeviceInfo.setAdditionalInfo("Additional Info");
    transportDeviceInfo.setCustomerId(new CustomerId(UUID.randomUUID()));
    transportDeviceInfo.setDeviceId(null);
    transportDeviceInfo.setDeviceName("Device Name");
    transportDeviceInfo.setDeviceProfileId(null);
    transportDeviceInfo.setDeviceType("Device Type");
    transportDeviceInfo.setEdrxCycle(1L);
    transportDeviceInfo.setGateway(true);
    transportDeviceInfo.setPagingTransmissionWindow(1L);
    transportDeviceInfo.setPowerMode(PowerMode.PSM);
    transportDeviceInfo.setPsmActivityTimer(1L);
    transportDeviceInfo.setTenantId(new TenantId(UUID.randomUUID()));
    ValidateDeviceCredentialsResponse credentials = mock(ValidateDeviceCredentialsResponse.class);
    when(credentials.getDeviceInfo()).thenReturn(transportDeviceInfo);

    // Act
    tbCoapClientState.init(credentials);

    // Assert
    verify(transportDeviceInfo).getDeviceProfileId();
    verify(transportDeviceInfo).getEdrxCycle();
    verify(transportDeviceInfo).getPagingTransmissionWindow();
    verify(transportDeviceInfo).getPowerMode();
    verify(transportDeviceInfo).getPsmActivityTimer();
    verify(transportDeviceInfo).setAdditionalInfo(eq("Additional Info"));
    verify(transportDeviceInfo).setCustomerId(isA(CustomerId.class));
    verify(transportDeviceInfo).setDeviceId(isNull());
    verify(transportDeviceInfo).setDeviceName(eq("Device Name"));
    verify(transportDeviceInfo).setDeviceProfileId(isNull());
    verify(transportDeviceInfo).setDeviceType(eq("Device Type"));
    verify(transportDeviceInfo).setEdrxCycle(eq(1L));
    verify(transportDeviceInfo).setGateway(eq(true));
    verify(transportDeviceInfo).setPagingTransmissionWindow(eq(1L));
    verify(transportDeviceInfo).setPowerMode(eq(PowerMode.PSM));
    verify(transportDeviceInfo).setPsmActivityTimer(eq(1L));
    verify(transportDeviceInfo).setTenantId(isA(TenantId.class));
    verify(credentials, atLeast(1)).getDeviceInfo();
    assertEquals(1L, tbCoapClientState.getEdrxCycle().longValue());
    assertEquals(1L, tbCoapClientState.getPagingTransmissionWindow().longValue());
    assertEquals(1L, tbCoapClientState.getPsmActivityTimer().longValue());
    assertEquals(PowerMode.PSM, tbCoapClientState.getPowerMode());
    assertSame(credentials, tbCoapClientState.getCredentials());
  }

  /**
   * Method under test: {@link TbCoapClientState#lock()}
   */
  @Test
  void testLock() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);

    // Act
    tbCoapClientState.lock();

    // Assert that nothing has changed
    Lock lock = tbCoapClientState.getLock();
    assertTrue(lock instanceof ReentrantLock);
    assertTrue(((ReentrantLock) lock).isLocked());
  }

  /**
   * Method under test: {@link TbCoapClientState#updateLastUplinkTime(long)}
   */
  @Test
  void testUpdateLastUplinkTime() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);

    // Act
    long actualUpdateLastUplinkTimeResult = tbCoapClientState.updateLastUplinkTime(1L);

    // Assert
    assertEquals(1L, tbCoapClientState.getLastUplinkTime());
    assertEquals(1L, actualUpdateLastUplinkTimeResult);
  }

  /**
   * Method under test: {@link TbCoapClientState#updateLastUplinkTime(long)}
   */
  @Test
  void testUpdateLastUplinkTime2() {
    // Arrange
    TbCoapClientState tbCoapClientState = new TbCoapClientState(null);

    // Act
    long actualUpdateLastUplinkTimeResult = tbCoapClientState.updateLastUplinkTime(0L);

    // Assert
    assertEquals(0L, tbCoapClientState.getLastUplinkTime());
    assertEquals(0L, actualUpdateLastUplinkTimeResult);
  }
}
