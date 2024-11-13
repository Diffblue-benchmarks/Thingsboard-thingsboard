package org.thingsboard.server.transport.lwm2m.bootstrap.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.eclipse.leshan.core.SecurityMode;
import org.eclipse.leshan.core.peer.OscoreIdentity;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.bootstrap.EditableBootstrapConfigStore;
import org.eclipse.leshan.server.bootstrap.InMemoryBootstrapConfigStore;
import org.eclipse.leshan.server.security.SecurityInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.transport.TransportContext;
import org.thingsboard.server.common.transport.auth.TransportDeviceInfo;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
import org.thingsboard.server.transport.lwm2m.bootstrap.secure.LwM2MBootstrapConfig;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.secure.TbLwM2MSecurityInfo;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MAuthException;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mTypeServer;

class LwM2MBootstrapSecurityStoreDiffblueTest {
  /**
   * Test {@link LwM2MBootstrapSecurityStore#getAllByEndpoint(String)}.
   * <p>
   * Method under test:
   * {@link LwM2MBootstrapSecurityStore#getAllByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getAllByEndpoint(String)")
  void testGetAllByEndpoint() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    when(tbLwM2MSecurityInfo.getBootstrapCredentialConfig()).thenReturn(null);
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
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = mock(
        LwM2mCredentialsSecurityInfoValidator.class);
    when(lwM2MCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(Mockito.<String>any(),
        Mockito.<LwM2mTypeServer>any())).thenReturn(tbLwM2MSecurityInfo);
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    Iterator<SecurityInfo> actualAllByEndpoint = (new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context, new LwM2mTransportServerHelper(new LwM2mTransportContext())))
        .getAllByEndpoint("https://config.us-east-2.amazonaws.com");

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
    verify(lwM2MCredentialsSecurityInfoValidator).getEndpointSecurityInfoByCredentialsId(
        eq("https://config.us-east-2.amazonaws.com"), eq(LwM2mTypeServer.BOOTSTRAP));
    verify(tbLwM2MSecurityInfo).getBootstrapCredentialConfig();
    verify(tbLwM2MSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbLwM2MSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbLwM2MSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbLwM2MSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
    assertNull(actualAllByEndpoint);
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getAllByEndpoint(String)}.
   * <ul>
   *   <li>Given {@link TbLwM2MSecurityInfo}
   * {@link TbLwM2MSecurityInfo#getSecurityMode()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MBootstrapSecurityStore#getAllByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getAllByEndpoint(String); given TbLwM2MSecurityInfo getSecurityMode() return 'null'")
  void testGetAllByEndpoint_givenTbLwM2MSecurityInfoGetSecurityModeReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    when(tbLwM2MSecurityInfo.getSecurityMode()).thenReturn(null);
    when(tbLwM2MSecurityInfo.getBootstrapCredentialConfig()).thenReturn(new LwM2MBootstrapConfig());
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
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = mock(
        LwM2mCredentialsSecurityInfoValidator.class);
    when(lwM2MCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(Mockito.<String>any(),
        Mockito.<LwM2mTypeServer>any())).thenReturn(tbLwM2MSecurityInfo);
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    Iterator<SecurityInfo> actualAllByEndpoint = (new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context, new LwM2mTransportServerHelper(new LwM2mTransportContext())))
        .getAllByEndpoint("https://config.us-east-2.amazonaws.com");

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
    verify(lwM2MCredentialsSecurityInfoValidator).getEndpointSecurityInfoByCredentialsId(
        eq("https://config.us-east-2.amazonaws.com"), eq(LwM2mTypeServer.BOOTSTRAP));
    verify(tbLwM2MSecurityInfo).getBootstrapCredentialConfig();
    verify(tbLwM2MSecurityInfo).getSecurityMode();
    verify(tbLwM2MSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbLwM2MSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbLwM2MSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbLwM2MSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
    assertNull(actualAllByEndpoint);
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getAllByEndpoint(String)}.
   * <ul>
   *   <li>Then throw {@link LwM2MAuthException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MBootstrapSecurityStore#getAllByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getAllByEndpoint(String); then throw LwM2MAuthException")
  void testGetAllByEndpoint_thenThrowLwM2MAuthException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    when(tbLwM2MSecurityInfo.getSecurityInfo()).thenThrow(new LwM2MAuthException());
    when(tbLwM2MSecurityInfo.getSecurityMode()).thenReturn(SecurityMode.PSK);
    when(tbLwM2MSecurityInfo.getBootstrapCredentialConfig()).thenReturn(new LwM2MBootstrapConfig());
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
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = mock(
        LwM2mCredentialsSecurityInfoValidator.class);
    when(lwM2MCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(Mockito.<String>any(),
        Mockito.<LwM2mTypeServer>any())).thenReturn(tbLwM2MSecurityInfo);
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act and Assert
    assertThrows(LwM2MAuthException.class,
        () -> (new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context,
            new LwM2mTransportServerHelper(new LwM2mTransportContext())))
            .getAllByEndpoint("https://config.us-east-2.amazonaws.com"));
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
    verify(lwM2MCredentialsSecurityInfoValidator).getEndpointSecurityInfoByCredentialsId(
        eq("https://config.us-east-2.amazonaws.com"), eq(LwM2mTypeServer.BOOTSTRAP));
    verify(tbLwM2MSecurityInfo).getBootstrapCredentialConfig();
    verify(tbLwM2MSecurityInfo).getSecurityInfo();
    verify(tbLwM2MSecurityInfo).getSecurityMode();
    verify(tbLwM2MSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbLwM2MSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbLwM2MSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbLwM2MSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getByIdentity(String)}.
   * <ul>
   *   <li>Given {@link TbLwM2MSecurityInfo}
   * {@link TbLwM2MSecurityInfo#getBootstrapCredentialConfig()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MBootstrapSecurityStore#getByIdentity(String)}
   */
  @Test
  @DisplayName("Test getByIdentity(String); given TbLwM2MSecurityInfo getBootstrapCredentialConfig() return 'null'")
  void testGetByIdentity_givenTbLwM2MSecurityInfoGetBootstrapCredentialConfigReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    new LwM2MAuthException();
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
    when(tbLwM2MSecurityInfo.getBootstrapCredentialConfig()).thenReturn(null);
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
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = mock(
        LwM2mCredentialsSecurityInfoValidator.class);
    when(lwM2MCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(Mockito.<String>any(),
        Mockito.<LwM2mTypeServer>any())).thenReturn(tbLwM2MSecurityInfo);
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    SecurityInfo actualByIdentity = (new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context, new LwM2mTransportServerHelper(new LwM2mTransportContext())))
        .getByIdentity("Identity");

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
    verify(lwM2MCredentialsSecurityInfoValidator).getEndpointSecurityInfoByCredentialsId(eq("Identity"),
        eq(LwM2mTypeServer.BOOTSTRAP));
    verify(tbLwM2MSecurityInfo).getBootstrapCredentialConfig();
    verify(tbLwM2MSecurityInfo).getSecurityInfo();
    verify(tbLwM2MSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbLwM2MSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbLwM2MSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbLwM2MSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
    assertSame(newX509CertInfoResult, actualByIdentity);
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getByIdentity(String)}.
   * <ul>
   *   <li>Given {@link TbLwM2MSecurityInfo}
   * {@link TbLwM2MSecurityInfo#getSecurityMode()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MBootstrapSecurityStore#getByIdentity(String)}
   */
  @Test
  @DisplayName("Test getByIdentity(String); given TbLwM2MSecurityInfo getSecurityMode() return 'null'")
  void testGetByIdentity_givenTbLwM2MSecurityInfoGetSecurityModeReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    new LwM2MAuthException();
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
    when(tbLwM2MSecurityInfo.getSecurityMode()).thenReturn(null);
    SecurityInfo newX509CertInfoResult = SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com");
    when(tbLwM2MSecurityInfo.getSecurityInfo()).thenReturn(newX509CertInfoResult);
    when(tbLwM2MSecurityInfo.getBootstrapCredentialConfig()).thenReturn(new LwM2MBootstrapConfig());
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
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = mock(
        LwM2mCredentialsSecurityInfoValidator.class);
    when(lwM2MCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(Mockito.<String>any(),
        Mockito.<LwM2mTypeServer>any())).thenReturn(tbLwM2MSecurityInfo);
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    SecurityInfo actualByIdentity = (new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context, new LwM2mTransportServerHelper(new LwM2mTransportContext())))
        .getByIdentity("Identity");

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
    verify(lwM2MCredentialsSecurityInfoValidator).getEndpointSecurityInfoByCredentialsId(eq("Identity"),
        eq(LwM2mTypeServer.BOOTSTRAP));
    verify(tbLwM2MSecurityInfo).getBootstrapCredentialConfig();
    verify(tbLwM2MSecurityInfo).getSecurityInfo();
    verify(tbLwM2MSecurityInfo).getSecurityMode();
    verify(tbLwM2MSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbLwM2MSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbLwM2MSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbLwM2MSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
    assertSame(newX509CertInfoResult, actualByIdentity);
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getByIdentity(String)}.
   * <ul>
   *   <li>Then calls {@link TbLwM2MSecurityInfo#getMsg()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MBootstrapSecurityStore#getByIdentity(String)}
   */
  @Test
  @DisplayName("Test getByIdentity(String); then calls getMsg()")
  void testGetByIdentity_thenCallsGetMsg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    new LwM2MAuthException();
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
    when(tbLwM2MSecurityInfo.getMsg()).thenThrow(new LwM2MAuthException());
    when(tbLwM2MSecurityInfo.getSecurityMode()).thenReturn(SecurityMode.PSK);
    when(tbLwM2MSecurityInfo.getBootstrapCredentialConfig()).thenReturn(new LwM2MBootstrapConfig());
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
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = mock(
        LwM2mCredentialsSecurityInfoValidator.class);
    when(lwM2MCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(Mockito.<String>any(),
        Mockito.<LwM2mTypeServer>any())).thenReturn(tbLwM2MSecurityInfo);
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    SecurityInfo actualByIdentity = (new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context, new LwM2mTransportServerHelper(new LwM2mTransportContext())))
        .getByIdentity("Identity");

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
    verify(lwM2MCredentialsSecurityInfoValidator).getEndpointSecurityInfoByCredentialsId(eq("Identity"),
        eq(LwM2mTypeServer.BOOTSTRAP));
    verify(tbLwM2MSecurityInfo, atLeast(1)).getBootstrapCredentialConfig();
    verify(tbLwM2MSecurityInfo).getMsg();
    verify(tbLwM2MSecurityInfo).getSecurityMode();
    verify(tbLwM2MSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbLwM2MSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbLwM2MSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbLwM2MSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
    assertNull(actualByIdentity);
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getByIdentity(String)}.
   * <ul>
   *   <li>Then calls {@link TransportContext#getTransportService()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MBootstrapSecurityStore#getByIdentity(String)}
   */
  @Test
  @DisplayName("Test getByIdentity(String); then calls getTransportService()")
  void testGetByIdentity_thenCallsGetTransportService() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenThrow(new LwM2MAuthException());
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act
    SecurityInfo actualByIdentity = (new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext())))
        .getByIdentity("Identity");

    // Assert
    verify(context).getTransportService();
    assertNull(actualByIdentity);
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getByOscoreIdentity(OscoreIdentity)}.
   * <p>
   * Method under test:
   * {@link LwM2MBootstrapSecurityStore#getByOscoreIdentity(OscoreIdentity)}
   */
  @Test
  @DisplayName("Test getByOscoreIdentity(OscoreIdentity)")
  void testGetByOscoreIdentity() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    // Act and Assert
    assertNull(lwM2MBootstrapSecurityStore.getByOscoreIdentity(new OscoreIdentity("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getByOscoreIdentity(OscoreIdentity)}.
   * <p>
   * Method under test:
   * {@link LwM2MBootstrapSecurityStore#getByOscoreIdentity(OscoreIdentity)}
   */
  @Test
  @DisplayName("Test getByOscoreIdentity(OscoreIdentity)")
  void testGetByOscoreIdentity2() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InMemoryBootstrapConfigStore bootstrapConfigStore = mock(InMemoryBootstrapConfigStore.class);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    // Act and Assert
    assertNull(lwM2MBootstrapSecurityStore.getByOscoreIdentity(new OscoreIdentity("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getX509ByEndpoint(String)}.
   * <p>
   * Method under test:
   * {@link LwM2MBootstrapSecurityStore#getX509ByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getX509ByEndpoint(String)")
  void testGetX509ByEndpoint() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    when(tbLwM2MSecurityInfo.getBootstrapCredentialConfig()).thenReturn(null);
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
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = mock(
        LwM2mCredentialsSecurityInfoValidator.class);
    when(lwM2MCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(Mockito.<String>any(),
        Mockito.<LwM2mTypeServer>any())).thenReturn(tbLwM2MSecurityInfo);
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    (new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context,
        new LwM2mTransportServerHelper(new LwM2mTransportContext())))
        .getX509ByEndpoint("https://config.us-east-2.amazonaws.com");

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
    verify(lwM2MCredentialsSecurityInfoValidator).getEndpointSecurityInfoByCredentialsId(
        eq("https://config.us-east-2.amazonaws.com"), eq(LwM2mTypeServer.BOOTSTRAP));
    verify(tbLwM2MSecurityInfo).getBootstrapCredentialConfig();
    verify(tbLwM2MSecurityInfo).getEndpoint();
    verify(tbLwM2MSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbLwM2MSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbLwM2MSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbLwM2MSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getX509ByEndpoint(String)}.
   * <ul>
   *   <li>Given {@link TbLwM2MSecurityInfo}
   * {@link TbLwM2MSecurityInfo#getSecurityMode()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MBootstrapSecurityStore#getX509ByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getX509ByEndpoint(String); given TbLwM2MSecurityInfo getSecurityMode() return 'null'")
  void testGetX509ByEndpoint_givenTbLwM2MSecurityInfoGetSecurityModeReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    when(tbLwM2MSecurityInfo.getSecurityMode()).thenReturn(null);
    when(tbLwM2MSecurityInfo.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(tbLwM2MSecurityInfo.getBootstrapCredentialConfig()).thenReturn(new LwM2MBootstrapConfig());
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
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = mock(
        LwM2mCredentialsSecurityInfoValidator.class);
    when(lwM2MCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(Mockito.<String>any(),
        Mockito.<LwM2mTypeServer>any())).thenReturn(tbLwM2MSecurityInfo);
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act
    (new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context,
        new LwM2mTransportServerHelper(new LwM2mTransportContext())))
        .getX509ByEndpoint("https://config.us-east-2.amazonaws.com");

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
    verify(lwM2MCredentialsSecurityInfoValidator).getEndpointSecurityInfoByCredentialsId(
        eq("https://config.us-east-2.amazonaws.com"), eq(LwM2mTypeServer.BOOTSTRAP));
    verify(tbLwM2MSecurityInfo).getBootstrapCredentialConfig();
    verify(tbLwM2MSecurityInfo).getEndpoint();
    verify(tbLwM2MSecurityInfo).getSecurityMode();
    verify(tbLwM2MSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbLwM2MSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbLwM2MSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbLwM2MSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getX509ByEndpoint(String)}.
   * <ul>
   *   <li>Then throw {@link LwM2MAuthException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MBootstrapSecurityStore#getX509ByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getX509ByEndpoint(String); then throw LwM2MAuthException")
  void testGetX509ByEndpoint_thenThrowLwM2MAuthException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
    when(tbLwM2MSecurityInfo.getSecurityInfo()).thenThrow(new LwM2MAuthException());
    when(tbLwM2MSecurityInfo.getSecurityMode()).thenReturn(SecurityMode.PSK);
    when(tbLwM2MSecurityInfo.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(tbLwM2MSecurityInfo.getBootstrapCredentialConfig()).thenReturn(new LwM2MBootstrapConfig());
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
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = mock(
        LwM2mCredentialsSecurityInfoValidator.class);
    when(lwM2MCredentialsSecurityInfoValidator.getEndpointSecurityInfoByCredentialsId(Mockito.<String>any(),
        Mockito.<LwM2mTypeServer>any())).thenReturn(tbLwM2MSecurityInfo);
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act and Assert
    assertThrows(LwM2MAuthException.class,
        () -> (new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context,
            new LwM2mTransportServerHelper(new LwM2mTransportContext())))
            .getX509ByEndpoint("https://config.us-east-2.amazonaws.com"));
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
    verify(lwM2MCredentialsSecurityInfoValidator).getEndpointSecurityInfoByCredentialsId(
        eq("https://config.us-east-2.amazonaws.com"), eq(LwM2mTypeServer.BOOTSTRAP));
    verify(tbLwM2MSecurityInfo).getBootstrapCredentialConfig();
    verify(tbLwM2MSecurityInfo).getEndpoint();
    verify(tbLwM2MSecurityInfo).getSecurityInfo();
    verify(tbLwM2MSecurityInfo).getSecurityMode();
    verify(tbLwM2MSecurityInfo).setBootstrapConfig(isA(BootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setBootstrapCredentialConfig(isA(LwM2MBootstrapConfig.class));
    verify(tbLwM2MSecurityInfo).setDeviceProfile(isA(DeviceProfile.class));
    verify(tbLwM2MSecurityInfo).setEndpoint(eq("https://config.us-east-2.amazonaws.com"));
    verify(tbLwM2MSecurityInfo).setMsg(isA(ValidateDeviceCredentialsResponse.class));
    verify(tbLwM2MSecurityInfo).setSecurityInfo(isA(SecurityInfo.class));
    verify(tbLwM2MSecurityInfo).setSecurityMode(eq(SecurityMode.PSK));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getSessionByEndpoint(String)}.
   * <p>
   * Method under test:
   * {@link LwM2MBootstrapSecurityStore#getSessionByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getSessionByEndpoint(String)")
  void testGetSessionByEndpoint() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act and Assert
    assertNull((new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context2,
        new LwM2mTransportServerHelper(new LwM2mTransportContext())))
        .getSessionByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#getSessionByEndpoint(String)}.
   * <p>
   * Method under test:
   * {@link LwM2MBootstrapSecurityStore#getSessionByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getSessionByEndpoint(String)")
  void testGetSessionByEndpoint2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EditableBootstrapConfigStore bootstrapConfigStore = mock(EditableBootstrapConfigStore.class);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act and Assert
    assertNull((new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context2,
        new LwM2mTransportServerHelper(new LwM2mTransportContext())))
        .getSessionByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#removeSessionByEndpoint(String)}.
   * <p>
   * Method under test:
   * {@link LwM2MBootstrapSecurityStore#removeSessionByEndpoint(String)}
   */
  @Test
  @DisplayName("Test removeSessionByEndpoint(String)")
  void testRemoveSessionByEndpoint() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act and Assert
    assertNull((new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context2,
        new LwM2mTransportServerHelper(new LwM2mTransportContext())))
        .removeSessionByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link LwM2MBootstrapSecurityStore#removeSessionByEndpoint(String)}.
   * <p>
   * Method under test:
   * {@link LwM2MBootstrapSecurityStore#removeSessionByEndpoint(String)}
   */
  @Test
  @DisplayName("Test removeSessionByEndpoint(String)")
  void testRemoveSessionByEndpoint2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EditableBootstrapConfigStore bootstrapConfigStore = mock(EditableBootstrapConfigStore.class);
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act and Assert
    assertNull((new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context2,
        new LwM2mTransportServerHelper(new LwM2mTransportContext())))
        .removeSessionByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test
   * {@link LwM2MBootstrapSecurityStore#getBootstrapConfigByEndpoint(String)}.
   * <p>
   * Method under test:
   * {@link LwM2MBootstrapSecurityStore#getBootstrapConfigByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getBootstrapConfigByEndpoint(String)")
  void testGetBootstrapConfigByEndpoint() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act and Assert
    assertNull((new LwM2MBootstrapSecurityStore(bootstrapConfigStore, lwM2MCredentialsSecurityInfoValidator, context2,
        new LwM2mTransportServerHelper(new LwM2mTransportContext())))
        .getBootstrapConfigByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test
   * {@link LwM2MBootstrapSecurityStore#getBootstrapConfigByEndpoint(String)}.
   * <ul>
   *   <li>Then calls {@link EditableBootstrapConfigStore#getAll()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MBootstrapSecurityStore#getBootstrapConfigByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getBootstrapConfigByEndpoint(String); then calls getAll()")
  void testGetBootstrapConfigByEndpoint_thenCallsGetAll() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EditableBootstrapConfigStore bootstrapConfigStore = mock(EditableBootstrapConfigStore.class);
    when(bootstrapConfigStore.getAll()).thenReturn(new HashMap<>());
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();

    // Act
    BootstrapConfig actualBootstrapConfigByEndpoint = (new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext())))
        .getBootstrapConfigByEndpoint("https://config.us-east-2.amazonaws.com");

    // Assert
    verify(bootstrapConfigStore).getAll();
    assertNull(actualBootstrapConfigByEndpoint);
  }

  /**
   * Test
   * {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo, String)}.
   * <ul>
   *   <li>Then throw {@link LwM2MAuthException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2MBootstrapSecurityStore#addValueToStore(TbLwM2MSecurityInfo, String)}
   */
  @Test
  @DisplayName("Test addValueToStore(TbLwM2MSecurityInfo, String); then throw LwM2MAuthException")
  void testAddValueToStore_thenThrowLwM2MAuthException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(context);
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context2, new LwM2MTransportServerConfig());

    LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, new LwM2mTransportContext(), helper);
    ValidateDeviceCredentialsResponse msg = mock(ValidateDeviceCredentialsResponse.class);
    when(msg.getDeviceInfo()).thenThrow(new LwM2MAuthException());

    TbLwM2MSecurityInfo store = new TbLwM2MSecurityInfo();
    store.setBootstrapConfig(new BootstrapConfig());
    store.setBootstrapCredentialConfig(new LwM2MBootstrapConfig());
    store.setDeviceProfile(new DeviceProfile());
    store.setEndpoint("https://config.us-east-2.amazonaws.com");
    store.setMsg(msg);
    store.setSecurityInfo(SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com"));
    store.setSecurityMode(SecurityMode.PSK);

    // Act and Assert
    assertThrows(LwM2MAuthException.class,
        () -> lwM2MBootstrapSecurityStore.addValueToStore(store, "https://config.us-east-2.amazonaws.com"));
    verify(context).getNodeId();
    verify(msg).getDeviceInfo();
  }
}
