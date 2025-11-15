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
package org.thingsboard.server.transport.lwm2m.server.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.eclipse.leshan.core.SecurityMode;
import org.eclipse.leshan.core.peer.OscoreIdentity;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.security.NonUniqueSecurityInfoException;
import org.eclipse.leshan.server.security.SecurityInfo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.device.credentials.lwm2m.LwM2MBootstrapClientCredential;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.transport.auth.TransportDeviceInfo;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
import org.thingsboard.server.transport.lwm2m.bootstrap.secure.LwM2MBootstrapConfig;
import org.thingsboard.server.transport.lwm2m.secure.TbLwM2MSecurityInfo;

class TbInMemorySecurityStoreDiffblueTest {
  /**
   * Method under test: {@link TbInMemorySecurityStore#getByEndpoint(String)}
   */
  @Test
  void testGetByEndpoint() {
    // Arrange, Act and Assert
    assertNull((new TbInMemorySecurityStore()).getByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link TbInMemorySecurityStore#getByIdentity(String)}
   */
  @Test
  void testGetByIdentity() {
    // Arrange, Act and Assert
    assertNull((new TbInMemorySecurityStore()).getByIdentity("Identity"));
  }

  /**
   * Method under test:
   * {@link TbInMemorySecurityStore#getByOscoreIdentity(OscoreIdentity)}
   */
  @Test
  void testGetByOscoreIdentity() throws UnsupportedEncodingException {
    // Arrange
    TbInMemorySecurityStore tbInMemorySecurityStore = new TbInMemorySecurityStore();

    // Act and Assert
    assertNull(tbInMemorySecurityStore.getByOscoreIdentity(new OscoreIdentity("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test: {@link TbInMemorySecurityStore#put(TbLwM2MSecurityInfo)}
   */
  @Test
  void testPut() throws NonUniqueSecurityInfoException {
    // Arrange
    TbInMemorySecurityStore tbInMemorySecurityStore = new TbInMemorySecurityStore();

    TbLwM2MSecurityInfo tbSecurityInfo = new TbLwM2MSecurityInfo();
    BootstrapConfig bootstrapConfig = new BootstrapConfig();
    tbSecurityInfo.setBootstrapConfig(bootstrapConfig);
    LwM2MBootstrapConfig bootstrapCredentialConfig = new LwM2MBootstrapConfig();
    tbSecurityInfo.setBootstrapCredentialConfig(bootstrapCredentialConfig);
    tbSecurityInfo.setDeviceProfile(new DeviceProfile());
    tbSecurityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    tbSecurityInfo.setSecurityInfo(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    tbSecurityInfo.setSecurityMode(SecurityMode.PSK);

    // Act
    tbInMemorySecurityStore.put(tbSecurityInfo);

    // Assert
    Map<String, TbLwM2MSecurityInfo> stringTbLwM2MSecurityInfoMap = tbInMemorySecurityStore.securityByEp;
    assertEquals(1, stringTbLwM2MSecurityInfoMap.size());
    assertSame(bootstrapConfig, tbSecurityInfo.getBootstrapConfig());
    assertSame(bootstrapCredentialConfig, tbSecurityInfo.getBootstrapCredentialConfig());
    assertSame(tbSecurityInfo, stringTbLwM2MSecurityInfoMap.get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link TbInMemorySecurityStore#put(TbLwM2MSecurityInfo)}
   */
  @Test
  void testPut2() throws NonUniqueSecurityInfoException {
    // Arrange
    TbInMemorySecurityStore tbInMemorySecurityStore = new TbInMemorySecurityStore();

    TbLwM2MSecurityInfo tbSecurityInfo = new TbLwM2MSecurityInfo();
    BootstrapConfig bootstrapConfig = new BootstrapConfig();
    tbSecurityInfo.setBootstrapConfig(bootstrapConfig);
    LwM2MBootstrapConfig bootstrapCredentialConfig = new LwM2MBootstrapConfig(new ArrayList<>(),
        mock(LwM2MBootstrapClientCredential.class), mock(LwM2MBootstrapClientCredential.class));

    tbSecurityInfo.setBootstrapCredentialConfig(bootstrapCredentialConfig);
    tbSecurityInfo.setDeviceProfile(new DeviceProfile());
    tbSecurityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    tbSecurityInfo.setSecurityInfo(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    tbSecurityInfo.setSecurityMode(SecurityMode.PSK);

    // Act
    tbInMemorySecurityStore.put(tbSecurityInfo);

    // Assert
    Map<String, TbLwM2MSecurityInfo> stringTbLwM2MSecurityInfoMap = tbInMemorySecurityStore.securityByEp;
    assertEquals(1, stringTbLwM2MSecurityInfoMap.size());
    assertSame(bootstrapConfig, tbSecurityInfo.getBootstrapConfig());
    assertSame(bootstrapCredentialConfig, tbSecurityInfo.getBootstrapCredentialConfig());
    assertSame(tbSecurityInfo, stringTbLwM2MSecurityInfoMap.get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link TbInMemorySecurityStore#put(TbLwM2MSecurityInfo)}
   */
  @Test
  void testPut3() throws NonUniqueSecurityInfoException {
    // Arrange
    TbInMemorySecurityStore tbInMemorySecurityStore = new TbInMemorySecurityStore();

    TbLwM2MSecurityInfo tbSecurityInfo = new TbLwM2MSecurityInfo();
    BootstrapConfig bootstrapConfig = new BootstrapConfig();
    tbSecurityInfo.setBootstrapConfig(bootstrapConfig);
    LwM2MBootstrapConfig bootstrapCredentialConfig = new LwM2MBootstrapConfig();
    tbSecurityInfo.setBootstrapCredentialConfig(bootstrapCredentialConfig);
    tbSecurityInfo.setDeviceProfile(new DeviceProfile());
    tbSecurityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    tbSecurityInfo.setSecurityInfo(null);
    tbSecurityInfo.setSecurityMode(SecurityMode.PSK);

    // Act
    tbInMemorySecurityStore.put(tbSecurityInfo);

    // Assert
    Map<String, TbLwM2MSecurityInfo> stringTbLwM2MSecurityInfoMap = tbInMemorySecurityStore.securityByEp;
    assertEquals(1, stringTbLwM2MSecurityInfoMap.size());
    assertSame(bootstrapConfig, tbSecurityInfo.getBootstrapConfig());
    assertSame(bootstrapCredentialConfig, tbSecurityInfo.getBootstrapCredentialConfig());
    assertSame(tbSecurityInfo, stringTbLwM2MSecurityInfoMap.get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link TbInMemorySecurityStore#remove(String)}
   */
  @Test
  void testRemove() {
    // Arrange
    TbInMemorySecurityStore tbInMemorySecurityStore = new TbInMemorySecurityStore();

    // Act
    tbInMemorySecurityStore.remove("https://config.us-east-2.amazonaws.com");

    // Assert
    assertTrue(tbInMemorySecurityStore.securityByEp.isEmpty());
    assertTrue(tbInMemorySecurityStore.securityByIdentity.isEmpty());
  }

  /**
   * Method under test: {@link TbInMemorySecurityStore#remove(String)}
   */
  @Test
  void testRemove2() throws NonUniqueSecurityInfoException {
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
    TbLwM2MSecurityInfo tbSecurityInfo = mock(TbLwM2MSecurityInfo.class);
    when(tbSecurityInfo.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(tbSecurityInfo.getSecurityInfo())
        .thenReturn(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    doNothing().when(tbSecurityInfo).setMsg(Mockito.<ValidateDeviceCredentialsResponse>any());
    doNothing().when(tbSecurityInfo).setSecurityInfo(Mockito.<SecurityInfo>any());
    doNothing().when(tbSecurityInfo).setSecurityMode(Mockito.<SecurityMode>any());
    doNothing().when(tbSecurityInfo).setBootstrapConfig(Mockito.<BootstrapConfig>any());
    doNothing().when(tbSecurityInfo).setBootstrapCredentialConfig(Mockito.<LwM2MBootstrapConfig>any());
    doNothing().when(tbSecurityInfo).setDeviceProfile(Mockito.<DeviceProfile>any());
    doNothing().when(tbSecurityInfo).setEndpoint(Mockito.<String>any());
    tbSecurityInfo.setBootstrapConfig(new BootstrapConfig());
    tbSecurityInfo.setBootstrapCredentialConfig(new LwM2MBootstrapConfig());
    tbSecurityInfo.setDeviceProfile(new DeviceProfile());
    tbSecurityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    tbSecurityInfo.setMsg(msg);
    tbSecurityInfo.setSecurityInfo(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    tbSecurityInfo.setSecurityMode(SecurityMode.PSK);

    TbInMemorySecurityStore tbInMemorySecurityStore = new TbInMemorySecurityStore();
    tbInMemorySecurityStore.put(tbSecurityInfo);

    // Act
    tbInMemorySecurityStore.remove("https://config.us-east-2.amazonaws.com");

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
    verify(tbSecurityInfo).getEndpoint();
    verify(tbSecurityInfo, atLeast(1)).getSecurityInfo();
    verify(tbSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
    assertTrue(tbInMemorySecurityStore.securityByEp.isEmpty());
    assertTrue(tbInMemorySecurityStore.securityByIdentity.isEmpty());
  }

  /**
   * Method under test: {@link TbInMemorySecurityStore#remove(String)}
   */
  @Test
  void testRemove3() throws NonUniqueSecurityInfoException {
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
    TbLwM2MSecurityInfo tbSecurityInfo = mock(TbLwM2MSecurityInfo.class);
    when(tbSecurityInfo.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(tbSecurityInfo.getSecurityInfo()).thenReturn(null);
    doNothing().when(tbSecurityInfo).setMsg(Mockito.<ValidateDeviceCredentialsResponse>any());
    doNothing().when(tbSecurityInfo).setSecurityInfo(Mockito.<SecurityInfo>any());
    doNothing().when(tbSecurityInfo).setSecurityMode(Mockito.<SecurityMode>any());
    doNothing().when(tbSecurityInfo).setBootstrapConfig(Mockito.<BootstrapConfig>any());
    doNothing().when(tbSecurityInfo).setBootstrapCredentialConfig(Mockito.<LwM2MBootstrapConfig>any());
    doNothing().when(tbSecurityInfo).setDeviceProfile(Mockito.<DeviceProfile>any());
    doNothing().when(tbSecurityInfo).setEndpoint(Mockito.<String>any());
    tbSecurityInfo.setBootstrapConfig(new BootstrapConfig());
    tbSecurityInfo.setBootstrapCredentialConfig(new LwM2MBootstrapConfig());
    tbSecurityInfo.setDeviceProfile(new DeviceProfile());
    tbSecurityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    tbSecurityInfo.setMsg(msg);
    tbSecurityInfo.setSecurityInfo(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    tbSecurityInfo.setSecurityMode(SecurityMode.PSK);

    TbInMemorySecurityStore tbInMemorySecurityStore = new TbInMemorySecurityStore();
    tbInMemorySecurityStore.put(tbSecurityInfo);

    // Act
    tbInMemorySecurityStore.remove("https://config.us-east-2.amazonaws.com");

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
    verify(tbSecurityInfo).getEndpoint();
    verify(tbSecurityInfo, atLeast(1)).getSecurityInfo();
    verify(tbSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
    assertTrue(tbInMemorySecurityStore.securityByEp.isEmpty());
    assertTrue(tbInMemorySecurityStore.securityByIdentity.isEmpty());
  }

  /**
   * Method under test: {@link TbInMemorySecurityStore#remove(String)}
   */
  @Test
  void testRemove4() throws NonUniqueSecurityInfoException {
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
    SecurityInfo securityInfo = mock(SecurityInfo.class);
    when(securityInfo.getPskIdentity()).thenReturn("Psk Identity");
    TbLwM2MSecurityInfo tbSecurityInfo = mock(TbLwM2MSecurityInfo.class);
    when(tbSecurityInfo.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(tbSecurityInfo.getSecurityInfo()).thenReturn(securityInfo);
    doNothing().when(tbSecurityInfo).setMsg(Mockito.<ValidateDeviceCredentialsResponse>any());
    doNothing().when(tbSecurityInfo).setSecurityInfo(Mockito.<SecurityInfo>any());
    doNothing().when(tbSecurityInfo).setSecurityMode(Mockito.<SecurityMode>any());
    doNothing().when(tbSecurityInfo).setBootstrapConfig(Mockito.<BootstrapConfig>any());
    doNothing().when(tbSecurityInfo).setBootstrapCredentialConfig(Mockito.<LwM2MBootstrapConfig>any());
    doNothing().when(tbSecurityInfo).setDeviceProfile(Mockito.<DeviceProfile>any());
    doNothing().when(tbSecurityInfo).setEndpoint(Mockito.<String>any());
    tbSecurityInfo.setBootstrapConfig(new BootstrapConfig());
    tbSecurityInfo.setBootstrapCredentialConfig(new LwM2MBootstrapConfig());
    tbSecurityInfo.setDeviceProfile(new DeviceProfile());
    tbSecurityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    tbSecurityInfo.setMsg(msg);
    tbSecurityInfo.setSecurityInfo(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    tbSecurityInfo.setSecurityMode(SecurityMode.PSK);

    TbInMemorySecurityStore tbInMemorySecurityStore = new TbInMemorySecurityStore();
    tbInMemorySecurityStore.put(tbSecurityInfo);

    // Act
    tbInMemorySecurityStore.remove("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(securityInfo, atLeast(1)).getPskIdentity();
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
    verify(tbSecurityInfo).getEndpoint();
    verify(tbSecurityInfo, atLeast(1)).getSecurityInfo();
    verify(tbSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
    assertTrue(tbInMemorySecurityStore.securityByEp.isEmpty());
    assertTrue(tbInMemorySecurityStore.securityByIdentity.isEmpty());
  }

  /**
   * Method under test:
   * {@link TbInMemorySecurityStore#getTbLwM2MSecurityInfoByEndpoint(String)}
   */
  @Test
  void testGetTbLwM2MSecurityInfoByEndpoint() {
    // Arrange, Act and Assert
    assertNull(
        (new TbInMemorySecurityStore()).getTbLwM2MSecurityInfoByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TbInMemorySecurityStore}
   */
  @Test
  void testNewTbInMemorySecurityStore() {
    // Arrange and Act
    TbInMemorySecurityStore actualTbInMemorySecurityStore = new TbInMemorySecurityStore();

    // Assert
    ReadWriteLock readWriteLock = actualTbInMemorySecurityStore.readWriteLock;
    assertTrue(readWriteLock instanceof ReentrantReadWriteLock);
    Lock lock = actualTbInMemorySecurityStore.writeLock;
    assertTrue(lock instanceof ReentrantReadWriteLock.WriteLock);
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getQueueLength());
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getReadHoldCount());
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getReadLockCount());
    assertEquals(0, ((ReentrantReadWriteLock) readWriteLock).getWriteHoldCount());
    assertEquals(0, ((ReentrantReadWriteLock.WriteLock) lock).getHoldCount());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).hasQueuedThreads());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).isFair());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).isWriteLocked());
    assertFalse(((ReentrantReadWriteLock) readWriteLock).isWriteLockedByCurrentThread());
    assertFalse(((ReentrantReadWriteLock.WriteLock) lock).isHeldByCurrentThread());
    assertTrue(actualTbInMemorySecurityStore.securityByEp.isEmpty());
    assertTrue(actualTbInMemorySecurityStore.securityByIdentity.isEmpty());
    Lock expectedReadLockResult = actualTbInMemorySecurityStore.readLock;
    assertSame(expectedReadLockResult, readWriteLock.readLock());
  }
}
