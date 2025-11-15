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
package org.thingsboard.server.coapserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.UUID;
import org.apache.http.HttpHost;
import org.apache.http.conn.HttpInetSocketAddress;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.transport.auth.TransportDeviceInfo;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;

class TbCoapDtlsSessionInMemoryStorageDiffblueTest {
  /**
   * Method under test:
   * {@link TbCoapDtlsSessionInMemoryStorage#put(InetSocketAddress, TbCoapDtlsSessionInfo)}
   */
  @Test
  void testPut() {
    // Arrange
    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage = new TbCoapDtlsSessionInMemoryStorage(1L, 1L);
    HttpInetSocketAddress remotePeer = new HttpInetSocketAddress(HttpHost.create("https://example.org/example"),
        mock(InetAddress.class), 8080);

    ValidateDeviceCredentialsResponse.ValidateDeviceCredentialsResponseBuilder validateDeviceCredentialsResponseBuilder = mock(
        ValidateDeviceCredentialsResponse.ValidateDeviceCredentialsResponseBuilder.class);
    when(validateDeviceCredentialsResponseBuilder.credentials(Mockito.<String>any()))
        .thenReturn(ValidateDeviceCredentialsResponse.builder());
    ValidateDeviceCredentialsResponse.ValidateDeviceCredentialsResponseBuilder credentialsResult = validateDeviceCredentialsResponseBuilder
        .credentials("Credentials");
    TransportDeviceInfo deviceInfo = mock(TransportDeviceInfo.class);
    doNothing().when(deviceInfo).setDeviceProfileId(Mockito.<DeviceProfileId>any());
    doNothing().when(deviceInfo).setDeviceType(Mockito.<String>any());
    doNothing().when(deviceInfo).setEdrxCycle(Mockito.<Long>any());
    doNothing().when(deviceInfo).setGateway(anyBoolean());
    doNothing().when(deviceInfo).setPagingTransmissionWindow(Mockito.<Long>any());
    doNothing().when(deviceInfo).setPowerMode(Mockito.<PowerMode>any());
    doNothing().when(deviceInfo).setPsmActivityTimer(Mockito.<Long>any());
    doNothing().when(deviceInfo).setTenantId(Mockito.<TenantId>any());
    doNothing().when(deviceInfo).setDeviceId(Mockito.<DeviceId>any());
    doNothing().when(deviceInfo).setDeviceName(Mockito.<String>any());
    doNothing().when(deviceInfo).setAdditionalInfo(Mockito.<String>any());
    doNothing().when(deviceInfo).setCustomerId(Mockito.<CustomerId>any());
    deviceInfo.setAdditionalInfo("Additional Info");
    deviceInfo.setCustomerId(new CustomerId(UUID.randomUUID()));
    deviceInfo.setDeviceId(null);
    deviceInfo.setDeviceName("Device Name");
    deviceInfo.setDeviceProfileId(null);
    deviceInfo.setDeviceType("Device Type");
    deviceInfo.setEdrxCycle(1L);
    deviceInfo.setGateway(true);
    deviceInfo.setPagingTransmissionWindow(1L);
    deviceInfo.setPowerMode(PowerMode.PSM);
    deviceInfo.setPsmActivityTimer(1L);
    deviceInfo.setTenantId(new TenantId(UUID.randomUUID()));
    ValidateDeviceCredentialsResponse.ValidateDeviceCredentialsResponseBuilder deviceInfoResult = credentialsResult
        .deviceInfo(deviceInfo);
    ValidateDeviceCredentialsResponse msg = deviceInfoResult.deviceProfile(new DeviceProfile()).build();

    // Act
    tbCoapDtlsSessionInMemoryStorage.put(remotePeer, new TbCoapDtlsSessionInfo(msg, new DeviceProfile()));

    // Assert
    verify(deviceInfo).setAdditionalInfo(eq("Additional Info"));
    verify(deviceInfo).setCustomerId(isA(CustomerId.class));
    verify(deviceInfo).setDeviceId(isNull());
    verify(deviceInfo).setDeviceName(eq("Device Name"));
    verify(deviceInfo).setDeviceProfileId(isNull());
    verify(deviceInfo).setDeviceType(eq("Device Type"));
    verify(deviceInfo).setEdrxCycle(eq(1L));
    verify(deviceInfo).setGateway(eq(true));
    verify(deviceInfo).setPagingTransmissionWindow(eq(1L));
    verify(deviceInfo).setPowerMode(eq(PowerMode.PSM));
    verify(deviceInfo).setPsmActivityTimer(eq(1L));
    verify(deviceInfo).setTenantId(isA(TenantId.class));
    verify(validateDeviceCredentialsResponseBuilder).credentials(eq("Credentials"));
    assertEquals(1, tbCoapDtlsSessionInMemoryStorage.getDtlsSessionsMap().size());
  }

  /**
   * Method under test:
   * {@link TbCoapDtlsSessionInMemoryStorage#evictTimeoutSessions()}
   */
  @Test
  void testEvictTimeoutSessions() {
    // Arrange
    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage = new TbCoapDtlsSessionInMemoryStorage(1L, 1L);

    // Act
    tbCoapDtlsSessionInMemoryStorage.evictTimeoutSessions();

    // Assert
    assertTrue(tbCoapDtlsSessionInMemoryStorage.getDtlsSessionsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link TbCoapDtlsSessionInMemoryStorage#evictTimeoutSessions()}
   */
  @Test
  void testEvictTimeoutSessions2() {
    // Arrange
    ValidateDeviceCredentialsResponse.ValidateDeviceCredentialsResponseBuilder validateDeviceCredentialsResponseBuilder = mock(
        ValidateDeviceCredentialsResponse.ValidateDeviceCredentialsResponseBuilder.class);
    when(validateDeviceCredentialsResponseBuilder.credentials(Mockito.<String>any()))
        .thenReturn(ValidateDeviceCredentialsResponse.builder());
    ValidateDeviceCredentialsResponse.ValidateDeviceCredentialsResponseBuilder credentialsResult = validateDeviceCredentialsResponseBuilder
        .credentials("Credentials");
    TransportDeviceInfo deviceInfo = mock(TransportDeviceInfo.class);
    doNothing().when(deviceInfo).setDeviceProfileId(Mockito.<DeviceProfileId>any());
    doNothing().when(deviceInfo).setDeviceType(Mockito.<String>any());
    doNothing().when(deviceInfo).setEdrxCycle(Mockito.<Long>any());
    doNothing().when(deviceInfo).setGateway(anyBoolean());
    doNothing().when(deviceInfo).setPagingTransmissionWindow(Mockito.<Long>any());
    doNothing().when(deviceInfo).setPowerMode(Mockito.<PowerMode>any());
    doNothing().when(deviceInfo).setPsmActivityTimer(Mockito.<Long>any());
    doNothing().when(deviceInfo).setTenantId(Mockito.<TenantId>any());
    doNothing().when(deviceInfo).setDeviceId(Mockito.<DeviceId>any());
    doNothing().when(deviceInfo).setDeviceName(Mockito.<String>any());
    doNothing().when(deviceInfo).setAdditionalInfo(Mockito.<String>any());
    doNothing().when(deviceInfo).setCustomerId(Mockito.<CustomerId>any());
    deviceInfo.setAdditionalInfo("Additional Info");
    deviceInfo.setCustomerId(new CustomerId(UUID.randomUUID()));
    deviceInfo.setDeviceId(null);
    deviceInfo.setDeviceName("Device Name");
    deviceInfo.setDeviceProfileId(null);
    deviceInfo.setDeviceType("Device Type");
    deviceInfo.setEdrxCycle(1L);
    deviceInfo.setGateway(true);
    deviceInfo.setPagingTransmissionWindow(1L);
    deviceInfo.setPowerMode(PowerMode.PSM);
    deviceInfo.setPsmActivityTimer(1L);
    deviceInfo.setTenantId(new TenantId(UUID.randomUUID()));
    ValidateDeviceCredentialsResponse.ValidateDeviceCredentialsResponseBuilder deviceInfoResult = credentialsResult
        .deviceInfo(deviceInfo);
    ValidateDeviceCredentialsResponse msg = deviceInfoResult.deviceProfile(new DeviceProfile()).build();
    TbCoapDtlsSessionInfo dtlsSessionInfo = new TbCoapDtlsSessionInfo(msg, new DeviceProfile());

    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage = new TbCoapDtlsSessionInMemoryStorage(
        -2051757870L, 1L);
    tbCoapDtlsSessionInMemoryStorage.put(
        new HttpInetSocketAddress(HttpHost.create("https://example.org/example"), mock(InetAddress.class), 8080),
        dtlsSessionInfo);

    // Act
    tbCoapDtlsSessionInMemoryStorage.evictTimeoutSessions();

    // Assert
    verify(deviceInfo).setAdditionalInfo(eq("Additional Info"));
    verify(deviceInfo).setCustomerId(isA(CustomerId.class));
    verify(deviceInfo).setDeviceId(isNull());
    verify(deviceInfo).setDeviceName(eq("Device Name"));
    verify(deviceInfo).setDeviceProfileId(isNull());
    verify(deviceInfo).setDeviceType(eq("Device Type"));
    verify(deviceInfo).setEdrxCycle(eq(1L));
    verify(deviceInfo).setGateway(eq(true));
    verify(deviceInfo).setPagingTransmissionWindow(eq(1L));
    verify(deviceInfo).setPowerMode(eq(PowerMode.PSM));
    verify(deviceInfo).setPsmActivityTimer(eq(1L));
    verify(deviceInfo).setTenantId(isA(TenantId.class));
    verify(validateDeviceCredentialsResponseBuilder).credentials(eq("Credentials"));
    assertTrue(tbCoapDtlsSessionInMemoryStorage.getDtlsSessionsMap().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage = new TbCoapDtlsSessionInMemoryStorage(1L, 1L);
    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage2 = new TbCoapDtlsSessionInMemoryStorage(1L, 1L);

    // Act and Assert
    assertEquals(tbCoapDtlsSessionInMemoryStorage, tbCoapDtlsSessionInMemoryStorage2);
    int expectedHashCodeResult = tbCoapDtlsSessionInMemoryStorage.hashCode();
    assertEquals(expectedHashCodeResult, tbCoapDtlsSessionInMemoryStorage2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage = new TbCoapDtlsSessionInMemoryStorage(1L, 1L);

    // Act and Assert
    assertEquals(tbCoapDtlsSessionInMemoryStorage, tbCoapDtlsSessionInMemoryStorage);
    int expectedHashCodeResult = tbCoapDtlsSessionInMemoryStorage.hashCode();
    assertEquals(expectedHashCodeResult, tbCoapDtlsSessionInMemoryStorage.hashCode());
  }

  /**
   * Method under test: {@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage = new TbCoapDtlsSessionInMemoryStorage(3L, 1L);

    // Act and Assert
    assertNotEquals(tbCoapDtlsSessionInMemoryStorage, new TbCoapDtlsSessionInMemoryStorage(1L, 1L));
  }

  /**
   * Method under test: {@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage = new TbCoapDtlsSessionInMemoryStorage(1L, 3L);

    // Act and Assert
    assertNotEquals(tbCoapDtlsSessionInMemoryStorage, new TbCoapDtlsSessionInMemoryStorage(1L, 1L));
  }

  /**
   * Method under test: {@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCoapDtlsSessionInMemoryStorage(1L, 1L), null);
  }

  /**
   * Method under test: {@link TbCoapDtlsSessionInMemoryStorage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCoapDtlsSessionInMemoryStorage(1L, 1L), "Different type to TbCoapDtlsSessionInMemoryStorage");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbCoapDtlsSessionInMemoryStorage#setDtlsSessionInactivityTimeout(long)}
   *   <li>
   * {@link TbCoapDtlsSessionInMemoryStorage#setDtlsSessionReportTimeout(long)}
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#toString()}
   *   <li>
   * {@link TbCoapDtlsSessionInMemoryStorage#getDtlsSessionInactivityTimeout()}
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#getDtlsSessionReportTimeout()}
   *   <li>{@link TbCoapDtlsSessionInMemoryStorage#getDtlsSessionsMap()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbCoapDtlsSessionInMemoryStorage tbCoapDtlsSessionInMemoryStorage = new TbCoapDtlsSessionInMemoryStorage(1L, 1L);

    // Act
    tbCoapDtlsSessionInMemoryStorage.setDtlsSessionInactivityTimeout(1L);
    tbCoapDtlsSessionInMemoryStorage.setDtlsSessionReportTimeout(1L);
    String actualToStringResult = tbCoapDtlsSessionInMemoryStorage.toString();
    long actualDtlsSessionInactivityTimeout = tbCoapDtlsSessionInMemoryStorage.getDtlsSessionInactivityTimeout();
    long actualDtlsSessionReportTimeout = tbCoapDtlsSessionInMemoryStorage.getDtlsSessionReportTimeout();

    // Assert that nothing has changed
    assertEquals(
        "TbCoapDtlsSessionInMemoryStorage(dtlsSessionsMap={}, dtlsSessionInactivityTimeout=1, dtlsSessionReportTimeout"
            + "=1)",
        actualToStringResult);
    assertEquals(1L, actualDtlsSessionInactivityTimeout);
    assertEquals(1L, actualDtlsSessionReportTimeout);
    assertTrue(tbCoapDtlsSessionInMemoryStorage.getDtlsSessionsMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link TbCoapDtlsSessionInMemoryStorage#TbCoapDtlsSessionInMemoryStorage(long, long)}
   */
  @Test
  void testNewTbCoapDtlsSessionInMemoryStorage() {
    // Arrange and Act
    TbCoapDtlsSessionInMemoryStorage actualTbCoapDtlsSessionInMemoryStorage = new TbCoapDtlsSessionInMemoryStorage(1L,
        1L);

    // Assert
    assertEquals(1L, actualTbCoapDtlsSessionInMemoryStorage.getDtlsSessionInactivityTimeout());
    assertEquals(1L, actualTbCoapDtlsSessionInMemoryStorage.getDtlsSessionReportTimeout());
    assertTrue(actualTbCoapDtlsSessionInMemoryStorage.getDtlsSessionsMap().isEmpty());
  }
}
