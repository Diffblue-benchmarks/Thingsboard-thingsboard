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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.UUID;
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
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.secure.TbLwM2MSecurityInfo;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MAuthException;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mTypeServer;

class TbLwM2mSecurityStoreDiffblueTest {
  /**
   * Method under test:
   * {@link TbLwM2mSecurityStore#getTbLwM2MSecurityInfoByEndpoint(String)}
   */
  @Test
  void testGetTbLwM2MSecurityInfoByEndpoint() {
    // Arrange
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act and Assert
    assertNull((new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig())))
        .getTbLwM2MSecurityInfoByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  void testGetByEndpoint() {
    // Arrange
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    SecurityInfo newX509CertInfoResult = SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com");
    when(securityStore.getByEndpoint(Mockito.<String>any())).thenReturn(newX509CertInfoResult);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    SecurityInfo actualByEndpoint = (new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig())))
        .getByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(securityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    assertSame(newX509CertInfoResult, actualByEndpoint);
  }

  /**
   * Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  void testGetByEndpoint2() {
    // Arrange
    SecurityInfo securityInfo = mock(SecurityInfo.class);
    when(securityInfo.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(securityInfo.usePSK()).thenReturn(true);
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    when(securityStore.getByEndpoint(Mockito.<String>any())).thenReturn(securityInfo);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    (new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig())))
        .getByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(securityInfo).getEndpoint();
    verify(securityInfo).usePSK();
    verify(securityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  void testGetByEndpoint3() {
    // Arrange
    SecurityInfo securityInfo = mock(SecurityInfo.class);
    when(securityInfo.getEndpoint()).thenThrow(new LwM2MAuthException());
    when(securityInfo.usePSK()).thenReturn(true);
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    when(securityStore.getByEndpoint(Mockito.<String>any())).thenReturn(securityInfo);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act and Assert
    assertThrows(LwM2MAuthException.class,
        () -> (new TbLwM2mSecurityStore(securityStore,
            new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig())))
            .getByEndpoint("https://config.us-east-2.amazonaws.com"));
    verify(securityInfo).getEndpoint();
    verify(securityInfo).usePSK();
    verify(securityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  void testGetByEndpoint4() {
    // Arrange
    SecurityInfo securityInfo = mock(SecurityInfo.class);
    when(securityInfo.getPskIdentity()).thenReturn("Psk Identity");
    when(securityInfo.getEndpoint()).thenReturn("NO_SEC");
    when(securityInfo.usePSK()).thenReturn(true);
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    when(securityStore.getByEndpoint(Mockito.<String>any())).thenReturn(securityInfo);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    (new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig())))
        .getByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(securityInfo).getEndpoint();
    verify(securityInfo).getPskIdentity();
    verify(securityInfo).usePSK();
    verify(securityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  void testGetByEndpoint5() throws UnsupportedEncodingException {
    // Arrange
    SecurityInfo securityInfo = mock(SecurityInfo.class);
    when(securityInfo.getPreSharedKey()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(securityInfo.getPskIdentity()).thenReturn("NO_SEC");
    when(securityInfo.getEndpoint()).thenReturn("NO_SEC");
    when(securityInfo.usePSK()).thenReturn(true);
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    when(securityStore.getByEndpoint(Mockito.<String>any())).thenReturn(securityInfo);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    (new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig())))
        .getByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(securityInfo).getEndpoint();
    verify(securityInfo).getPreSharedKey();
    verify(securityInfo).getPskIdentity();
    verify(securityInfo).usePSK();
    verify(securityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  void testGetByEndpoint6() {
    // Arrange
    SecurityInfo securityInfo = mock(SecurityInfo.class);
    when(securityInfo.getPreSharedKey()).thenThrow(new LwM2MAuthException());
    when(securityInfo.getPskIdentity()).thenReturn("NO_SEC");
    when(securityInfo.getEndpoint()).thenReturn("NO_SEC");
    when(securityInfo.usePSK()).thenReturn(true);
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    when(securityStore.getByEndpoint(Mockito.<String>any())).thenReturn(securityInfo);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act and Assert
    assertThrows(LwM2MAuthException.class,
        () -> (new TbLwM2mSecurityStore(securityStore,
            new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig())))
            .getByEndpoint("https://config.us-east-2.amazonaws.com"));
    verify(securityInfo).getEndpoint();
    verify(securityInfo).getPreSharedKey();
    verify(securityInfo).getPskIdentity();
    verify(securityInfo).usePSK();
    verify(securityStore).getByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link TbLwM2mSecurityStore#getByIdentity(String)}
   */
  @Test
  void testGetByIdentity() {
    // Arrange
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    SecurityInfo newX509CertInfoResult = SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com");
    when(securityStore.getByIdentity(Mockito.<String>any())).thenReturn(newX509CertInfoResult);
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    SecurityInfo actualByIdentity = (new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig())))
        .getByIdentity("Psk Identity");

    // Assert
    verify(securityStore).getByIdentity(eq("Psk Identity"));
    assertSame(newX509CertInfoResult, actualByIdentity);
  }

  /**
   * Method under test: {@link TbLwM2mSecurityStore#getByIdentity(String)}
   */
  @Test
  void testGetByIdentity2() throws NonUniqueSecurityInfoException {
    // Arrange
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    doNothing().when(securityStore).put(Mockito.<TbLwM2MSecurityInfo>any());
    when(securityStore.getByIdentity(Mockito.<String>any())).thenReturn(null);
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
    TbLwM2MSecurityInfo tbLwM2MSecurityInfo = mock(TbLwM2MSecurityInfo.class);
    SecurityInfo newX509CertInfoResult = SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com");
    when(tbLwM2MSecurityInfo.getSecurityInfo()).thenReturn(newX509CertInfoResult);
    doNothing().when(tbLwM2MSecurityInfo).setMsg(Mockito.<ValidateDeviceCredentialsResponse>any());
    doNothing().when(tbLwM2MSecurityInfo).setSecurityInfo(Mockito.<SecurityInfo>any());
    doNothing().when(tbLwM2MSecurityInfo).setSecurityMode(Mockito.<SecurityMode>any());
    doNothing().when(tbLwM2MSecurityInfo).setBootstrapConfig(Mockito.<BootstrapConfig>any());
    doNothing().when(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(Mockito.<LwM2MBootstrapConfig>any());
    doNothing().when(tbLwM2MSecurityInfo).setDeviceProfile(Mockito.<DeviceProfile>any());
    doNothing().when(tbLwM2MSecurityInfo).setEndpoint(Mockito.<String>any());
    tbLwM2MSecurityInfo.setBootstrapConfig(new BootstrapConfig());
    tbLwM2MSecurityInfo.setBootstrapCredentialConfig(new LwM2MBootstrapConfig());
    tbLwM2MSecurityInfo.setDeviceProfile(new DeviceProfile());
    tbLwM2MSecurityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    tbLwM2MSecurityInfo.setMsg(msg);
    tbLwM2MSecurityInfo.setSecurityInfo(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    tbLwM2MSecurityInfo.setSecurityMode(SecurityMode.PSK);
    LwM2mCredentialsSecurityInfoValidator validator = mock(LwM2mCredentialsSecurityInfoValidator.class);
    when(validator.getEndpointSecurityInfoByCredentialsId(Mockito.<String>any(), Mockito.<LwM2mTypeServer>any()))
        .thenReturn(tbLwM2MSecurityInfo);

    // Act
    SecurityInfo actualByIdentity = (new TbLwM2mSecurityStore(securityStore, validator)).getByIdentity("Psk Identity");

    // Assert
    verify(securityStore).getByIdentity(eq("Psk Identity"));
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
    verify(validator).getEndpointSecurityInfoByCredentialsId(eq("Psk Identity"), eq(LwM2mTypeServer.CLIENT));
    verify(tbLwM2MSecurityInfo).getSecurityInfo();
    verify(tbLwM2MSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbLwM2MSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbLwM2MSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbLwM2MSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
    verify(securityStore).put(isA(TbLwM2MSecurityInfo.class));
    assertSame(newX509CertInfoResult, actualByIdentity);
  }

  /**
   * Method under test:
   * {@link TbLwM2mSecurityStore#getByOscoreIdentity(OscoreIdentity)}
   */
  @Test
  void testGetByOscoreIdentity() throws UnsupportedEncodingException {
    // Arrange
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    TbLwM2mSecurityStore tbLwM2mSecurityStore = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig()));

    // Act and Assert
    assertNull(tbLwM2mSecurityStore.getByOscoreIdentity(new OscoreIdentity("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test:
   * {@link TbLwM2mSecurityStore#fetchAndPutSecurityInfo(String)}
   */
  @Test
  void testFetchAndPutSecurityInfo() {
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
    TbLwM2MSecurityInfo tbLwM2MSecurityInfo = mock(TbLwM2MSecurityInfo.class);
    when(tbLwM2MSecurityInfo.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    SecurityInfo newX509CertInfoResult = SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com");
    when(tbLwM2MSecurityInfo.getSecurityInfo()).thenReturn(newX509CertInfoResult);
    doNothing().when(tbLwM2MSecurityInfo).setMsg(Mockito.<ValidateDeviceCredentialsResponse>any());
    doNothing().when(tbLwM2MSecurityInfo).setSecurityInfo(Mockito.<SecurityInfo>any());
    doNothing().when(tbLwM2MSecurityInfo).setSecurityMode(Mockito.<SecurityMode>any());
    doNothing().when(tbLwM2MSecurityInfo).setBootstrapConfig(Mockito.<BootstrapConfig>any());
    doNothing().when(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(Mockito.<LwM2MBootstrapConfig>any());
    doNothing().when(tbLwM2MSecurityInfo).setDeviceProfile(Mockito.<DeviceProfile>any());
    doNothing().when(tbLwM2MSecurityInfo).setEndpoint(Mockito.<String>any());
    tbLwM2MSecurityInfo.setBootstrapConfig(new BootstrapConfig());
    tbLwM2MSecurityInfo.setBootstrapCredentialConfig(new LwM2MBootstrapConfig());
    tbLwM2MSecurityInfo.setDeviceProfile(new DeviceProfile());
    tbLwM2MSecurityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    tbLwM2MSecurityInfo.setMsg(msg);
    tbLwM2MSecurityInfo.setSecurityInfo(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    tbLwM2MSecurityInfo.setSecurityMode(SecurityMode.PSK);
    LwM2mCredentialsSecurityInfoValidator validator = mock(LwM2mCredentialsSecurityInfoValidator.class);
    when(validator.getEndpointSecurityInfoByCredentialsId(Mockito.<String>any(), Mockito.<LwM2mTypeServer>any()))
        .thenReturn(tbLwM2MSecurityInfo);

    // Act
    SecurityInfo actualFetchAndPutSecurityInfoResult = (new TbLwM2mSecurityStore(new TbInMemorySecurityStore(),
        validator)).fetchAndPutSecurityInfo("42");

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
    verify(validator).getEndpointSecurityInfoByCredentialsId(eq("42"), eq(LwM2mTypeServer.CLIENT));
    verify(tbLwM2MSecurityInfo).getEndpoint();
    verify(tbLwM2MSecurityInfo, atLeast(1)).getSecurityInfo();
    verify(tbLwM2MSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbLwM2MSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbLwM2MSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbLwM2MSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
    assertSame(newX509CertInfoResult, actualFetchAndPutSecurityInfoResult);
  }

  /**
   * Method under test:
   * {@link TbLwM2mSecurityStore#fetchAndPutSecurityInfo(String)}
   */
  @Test
  void testFetchAndPutSecurityInfo2() throws NonUniqueSecurityInfoException {
    // Arrange
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    doNothing().when(securityStore).put(Mockito.<TbLwM2MSecurityInfo>any());
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
    TbLwM2MSecurityInfo tbLwM2MSecurityInfo = mock(TbLwM2MSecurityInfo.class);
    SecurityInfo newX509CertInfoResult = SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com");
    when(tbLwM2MSecurityInfo.getSecurityInfo()).thenReturn(newX509CertInfoResult);
    doNothing().when(tbLwM2MSecurityInfo).setMsg(Mockito.<ValidateDeviceCredentialsResponse>any());
    doNothing().when(tbLwM2MSecurityInfo).setSecurityInfo(Mockito.<SecurityInfo>any());
    doNothing().when(tbLwM2MSecurityInfo).setSecurityMode(Mockito.<SecurityMode>any());
    doNothing().when(tbLwM2MSecurityInfo).setBootstrapConfig(Mockito.<BootstrapConfig>any());
    doNothing().when(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(Mockito.<LwM2MBootstrapConfig>any());
    doNothing().when(tbLwM2MSecurityInfo).setDeviceProfile(Mockito.<DeviceProfile>any());
    doNothing().when(tbLwM2MSecurityInfo).setEndpoint(Mockito.<String>any());
    tbLwM2MSecurityInfo.setBootstrapConfig(new BootstrapConfig());
    tbLwM2MSecurityInfo.setBootstrapCredentialConfig(new LwM2MBootstrapConfig());
    tbLwM2MSecurityInfo.setDeviceProfile(new DeviceProfile());
    tbLwM2MSecurityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    tbLwM2MSecurityInfo.setMsg(msg);
    tbLwM2MSecurityInfo.setSecurityInfo(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    tbLwM2MSecurityInfo.setSecurityMode(SecurityMode.PSK);
    LwM2mCredentialsSecurityInfoValidator validator = mock(LwM2mCredentialsSecurityInfoValidator.class);
    when(validator.getEndpointSecurityInfoByCredentialsId(Mockito.<String>any(), Mockito.<LwM2mTypeServer>any()))
        .thenReturn(tbLwM2MSecurityInfo);

    // Act
    SecurityInfo actualFetchAndPutSecurityInfoResult = (new TbLwM2mSecurityStore(securityStore, validator))
        .fetchAndPutSecurityInfo("42");

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
    verify(validator).getEndpointSecurityInfoByCredentialsId(eq("42"), eq(LwM2mTypeServer.CLIENT));
    verify(tbLwM2MSecurityInfo).getSecurityInfo();
    verify(tbLwM2MSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbLwM2MSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbLwM2MSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbLwM2MSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
    verify(securityStore).put(isA(TbLwM2MSecurityInfo.class));
    assertSame(newX509CertInfoResult, actualFetchAndPutSecurityInfoResult);
  }

  /**
   * Method under test:
   * {@link TbLwM2mSecurityStore#fetchAndPutSecurityInfo(String)}
   */
  @Test
  void testFetchAndPutSecurityInfo3() throws NonUniqueSecurityInfoException {
    // Arrange
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    doThrow(new NonUniqueSecurityInfoException("Msg")).when(securityStore).put(Mockito.<TbLwM2MSecurityInfo>any());
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
    TbLwM2MSecurityInfo tbLwM2MSecurityInfo = mock(TbLwM2MSecurityInfo.class);
    SecurityInfo newX509CertInfoResult = SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com");
    when(tbLwM2MSecurityInfo.getSecurityInfo()).thenReturn(newX509CertInfoResult);
    doNothing().when(tbLwM2MSecurityInfo).setMsg(Mockito.<ValidateDeviceCredentialsResponse>any());
    doNothing().when(tbLwM2MSecurityInfo).setSecurityInfo(Mockito.<SecurityInfo>any());
    doNothing().when(tbLwM2MSecurityInfo).setSecurityMode(Mockito.<SecurityMode>any());
    doNothing().when(tbLwM2MSecurityInfo).setBootstrapConfig(Mockito.<BootstrapConfig>any());
    doNothing().when(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(Mockito.<LwM2MBootstrapConfig>any());
    doNothing().when(tbLwM2MSecurityInfo).setDeviceProfile(Mockito.<DeviceProfile>any());
    doNothing().when(tbLwM2MSecurityInfo).setEndpoint(Mockito.<String>any());
    tbLwM2MSecurityInfo.setBootstrapConfig(new BootstrapConfig());
    tbLwM2MSecurityInfo.setBootstrapCredentialConfig(new LwM2MBootstrapConfig());
    tbLwM2MSecurityInfo.setDeviceProfile(new DeviceProfile());
    tbLwM2MSecurityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    tbLwM2MSecurityInfo.setMsg(msg);
    tbLwM2MSecurityInfo.setSecurityInfo(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    tbLwM2MSecurityInfo.setSecurityMode(SecurityMode.PSK);
    LwM2mCredentialsSecurityInfoValidator validator = mock(LwM2mCredentialsSecurityInfoValidator.class);
    when(validator.getEndpointSecurityInfoByCredentialsId(Mockito.<String>any(), Mockito.<LwM2mTypeServer>any()))
        .thenReturn(tbLwM2MSecurityInfo);

    // Act
    SecurityInfo actualFetchAndPutSecurityInfoResult = (new TbLwM2mSecurityStore(securityStore, validator))
        .fetchAndPutSecurityInfo("42");

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
    verify(validator).getEndpointSecurityInfoByCredentialsId(eq("42"), eq(LwM2mTypeServer.CLIENT));
    verify(tbLwM2MSecurityInfo).getSecurityInfo();
    verify(tbLwM2MSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbLwM2MSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbLwM2MSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbLwM2MSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
    verify(securityStore).put(isA(TbLwM2MSecurityInfo.class));
    assertSame(newX509CertInfoResult, actualFetchAndPutSecurityInfoResult);
  }

  /**
   * Method under test: {@link TbLwM2mSecurityStore#putX509(TbLwM2MSecurityInfo)}
   */
  @Test
  void testPutX509() throws NonUniqueSecurityInfoException {
    // Arrange
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    TbLwM2mSecurityStore tbLwM2mSecurityStore = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig()));

    TbLwM2MSecurityInfo securityInfo = new TbLwM2MSecurityInfo();
    BootstrapConfig bootstrapConfig = new BootstrapConfig();
    securityInfo.setBootstrapConfig(bootstrapConfig);
    LwM2MBootstrapConfig bootstrapCredentialConfig = new LwM2MBootstrapConfig();
    securityInfo.setBootstrapCredentialConfig(bootstrapCredentialConfig);
    securityInfo.setDeviceProfile(new DeviceProfile());
    securityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    SecurityInfo securityInfo2 = SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com");
    securityInfo.setSecurityInfo(securityInfo2);
    securityInfo.setSecurityMode(SecurityMode.PSK);

    // Act
    tbLwM2mSecurityStore.putX509(securityInfo);

    // Assert
    assertSame(bootstrapConfig, securityInfo.getBootstrapConfig());
    assertSame(bootstrapCredentialConfig, securityInfo.getBootstrapCredentialConfig());
    assertSame(securityInfo2, tbLwM2mSecurityStore.getByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link TbLwM2mSecurityStore#putX509(TbLwM2MSecurityInfo)}
   */
  @Test
  void testPutX5092() throws NonUniqueSecurityInfoException {
    // Arrange
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    TbLwM2mSecurityStore tbLwM2mSecurityStore = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig()));

    TbLwM2MSecurityInfo securityInfo = new TbLwM2MSecurityInfo();
    BootstrapConfig bootstrapConfig = new BootstrapConfig();
    securityInfo.setBootstrapConfig(bootstrapConfig);
    LwM2MBootstrapConfig bootstrapCredentialConfig = new LwM2MBootstrapConfig(new ArrayList<>(),
        mock(LwM2MBootstrapClientCredential.class), mock(LwM2MBootstrapClientCredential.class));

    securityInfo.setBootstrapCredentialConfig(bootstrapCredentialConfig);
    securityInfo.setDeviceProfile(new DeviceProfile());
    securityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    SecurityInfo securityInfo2 = SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com");
    securityInfo.setSecurityInfo(securityInfo2);
    securityInfo.setSecurityMode(SecurityMode.PSK);

    // Act
    tbLwM2mSecurityStore.putX509(securityInfo);

    // Assert
    assertSame(bootstrapConfig, securityInfo.getBootstrapConfig());
    assertSame(bootstrapCredentialConfig, securityInfo.getBootstrapCredentialConfig());
    assertSame(securityInfo2, tbLwM2mSecurityStore.getByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link TbLwM2mSecurityStore#putX509(TbLwM2MSecurityInfo)}
   */
  @Test
  void testPutX5093() throws NonUniqueSecurityInfoException {
    // Arrange
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    TbLwM2mSecurityStore tbLwM2mSecurityStore = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig()));

    TbLwM2MSecurityInfo securityInfo = new TbLwM2MSecurityInfo();
    BootstrapConfig bootstrapConfig = new BootstrapConfig();
    securityInfo.setBootstrapConfig(bootstrapConfig);
    LwM2MBootstrapConfig bootstrapCredentialConfig = new LwM2MBootstrapConfig();
    securityInfo.setBootstrapCredentialConfig(bootstrapCredentialConfig);
    securityInfo.setDeviceProfile(new DeviceProfile());
    securityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    securityInfo.setSecurityInfo(null);
    securityInfo.setSecurityMode(SecurityMode.PSK);

    // Act
    tbLwM2mSecurityStore.putX509(securityInfo);

    // Assert
    assertSame(bootstrapConfig, securityInfo.getBootstrapConfig());
    assertSame(bootstrapCredentialConfig, securityInfo.getBootstrapCredentialConfig());
  }

  /**
   * Method under test: {@link TbLwM2mSecurityStore#remove(String, String)}
   */
  @Test
  void testRemove() {
    // Arrange
    TbEditableSecurityStore securityStore = mock(TbEditableSecurityStore.class);
    doNothing().when(securityStore).remove(Mockito.<String>any());
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    (new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig())))
        .remove("https://config.us-east-2.amazonaws.com", "42");

    // Assert
    verify(securityStore).remove(eq("https://config.us-east-2.amazonaws.com"));
  }
}
