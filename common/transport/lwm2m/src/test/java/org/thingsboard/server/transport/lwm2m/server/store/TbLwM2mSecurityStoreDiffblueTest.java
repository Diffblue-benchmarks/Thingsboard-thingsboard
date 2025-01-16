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
import org.junit.jupiter.api.DisplayName;
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
   * Test {@link TbLwM2mSecurityStore#getTbLwM2MSecurityInfoByEndpoint(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbLwM2mSecurityStore#getTbLwM2MSecurityInfoByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getTbLwM2MSecurityInfoByEndpoint(String); then return 'null'")
  void testGetTbLwM2MSecurityInfoByEndpoint_thenReturnNull() {
    // Arrange
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context = new LwM2mTransportContext();

    // Act and Assert
    assertNull((new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig())))
        .getTbLwM2MSecurityInfoByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbLwM2mSecurityStore#getByEndpoint(String)}.
   * <p>
   * Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getByEndpoint(String)")
  void testGetByEndpoint() {
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
   * Test {@link TbLwM2mSecurityStore#getByEndpoint(String)}.
   * <ul>
   *   <li>Given {@link SecurityInfo} {@link SecurityInfo#getEndpoint()} throw
   * {@link LwM2MAuthException} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getByEndpoint(String); given SecurityInfo getEndpoint() throw LwM2MAuthException (default constructor)")
  void testGetByEndpoint_givenSecurityInfoGetEndpointThrowLwM2MAuthException() {
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
   * Test {@link TbLwM2mSecurityStore#getByEndpoint(String)}.
   * <ul>
   *   <li>Given {@link SecurityInfo} {@link SecurityInfo#getPreSharedKey()} throw
   * {@link LwM2MAuthException} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getByEndpoint(String); given SecurityInfo getPreSharedKey() throw LwM2MAuthException (default constructor)")
  void testGetByEndpoint_givenSecurityInfoGetPreSharedKeyThrowLwM2MAuthException() {
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
   * Test {@link TbLwM2mSecurityStore#getByEndpoint(String)}.
   * <ul>
   *   <li>Given {@link SecurityInfo} {@link SecurityInfo#getPskIdentity()} return
   * {@code Psk Identity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getByEndpoint(String); given SecurityInfo getPskIdentity() return 'Psk Identity'")
  void testGetByEndpoint_givenSecurityInfoGetPskIdentityReturnPskIdentity() {
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
   * Test {@link TbLwM2mSecurityStore#getByEndpoint(String)}.
   * <ul>
   *   <li>Then calls {@link SecurityInfo#getPreSharedKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getByEndpoint(String); then calls getPreSharedKey()")
  void testGetByEndpoint_thenCallsGetPreSharedKey() throws UnsupportedEncodingException {
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
   * Test {@link TbLwM2mSecurityStore#getByEndpoint(String)}.
   * <ul>
   *   <li>Then return newX509CertInfo
   * {@code https://config.us-east-2.amazonaws.com}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2mSecurityStore#getByEndpoint(String)}
   */
  @Test
  @DisplayName("Test getByEndpoint(String); then return newX509CertInfo 'https://config.us-east-2.amazonaws.com'")
  void testGetByEndpoint_thenReturnNewX509CertInfoHttpsConfigUsEast2AmazonawsCom() {
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
   * Test {@link TbLwM2mSecurityStore#getByIdentity(String)}.
   * <p>
   * Method under test: {@link TbLwM2mSecurityStore#getByIdentity(String)}
   */
  @Test
  @DisplayName("Test getByIdentity(String)")
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
   * Test {@link TbLwM2mSecurityStore#getByIdentity(String)}.
   * <ul>
   *   <li>Then calls {@link TransportDeviceInfo#setAdditionalInfo(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2mSecurityStore#getByIdentity(String)}
   */
  @Test
  @DisplayName("Test getByIdentity(String); then calls setAdditionalInfo(String)")
  void testGetByIdentity_thenCallsSetAdditionalInfo() throws NonUniqueSecurityInfoException {
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
   * Test {@link TbLwM2mSecurityStore#getByOscoreIdentity(OscoreIdentity)}.
   * <p>
   * Method under test:
   * {@link TbLwM2mSecurityStore#getByOscoreIdentity(OscoreIdentity)}
   */
  @Test
  @DisplayName("Test getByOscoreIdentity(OscoreIdentity)")
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
   * Test {@link TbLwM2mSecurityStore#fetchAndPutSecurityInfo(String)}.
   * <p>
   * Method under test:
   * {@link TbLwM2mSecurityStore#fetchAndPutSecurityInfo(String)}
   */
  @Test
  @DisplayName("Test fetchAndPutSecurityInfo(String)")
  void testFetchAndPutSecurityInfo() throws NonUniqueSecurityInfoException {
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
   * Test {@link TbLwM2mSecurityStore#fetchAndPutSecurityInfo(String)}.
   * <ul>
   *   <li>Given {@link TbEditableSecurityStore}
   * {@link TbEditableSecurityStore#put(TbLwM2MSecurityInfo)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbLwM2mSecurityStore#fetchAndPutSecurityInfo(String)}
   */
  @Test
  @DisplayName("Test fetchAndPutSecurityInfo(String); given TbEditableSecurityStore put(TbLwM2MSecurityInfo) does nothing")
  void testFetchAndPutSecurityInfo_givenTbEditableSecurityStorePutDoesNothing() throws NonUniqueSecurityInfoException {
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
   * Test {@link TbLwM2mSecurityStore#fetchAndPutSecurityInfo(String)}.
   * <ul>
   *   <li>Then calls {@link TbLwM2MSecurityInfo#getEndpoint()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbLwM2mSecurityStore#fetchAndPutSecurityInfo(String)}
   */
  @Test
  @DisplayName("Test fetchAndPutSecurityInfo(String); then calls getEndpoint()")
  void testFetchAndPutSecurityInfo_thenCallsGetEndpoint() {
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
   * Test {@link TbLwM2mSecurityStore#putX509(TbLwM2MSecurityInfo)}.
   * <p>
   * Method under test: {@link TbLwM2mSecurityStore#putX509(TbLwM2MSecurityInfo)}
   */
  @Test
  @DisplayName("Test putX509(TbLwM2MSecurityInfo)")
  void testPutX509() throws NonUniqueSecurityInfoException {
    // Arrange
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    TbLwM2mSecurityStore tbLwM2mSecurityStore = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig()));

    TbLwM2MSecurityInfo securityInfo = new TbLwM2MSecurityInfo();
    securityInfo.setBootstrapConfig(new BootstrapConfig());
    securityInfo.setBootstrapCredentialConfig(new LwM2MBootstrapConfig());
    securityInfo.setDeviceProfile(new DeviceProfile());
    securityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    SecurityInfo securityInfo2 = SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com");
    securityInfo.setSecurityInfo(securityInfo2);
    securityInfo.setSecurityMode(SecurityMode.PSK);

    // Act
    tbLwM2mSecurityStore.putX509(securityInfo);

    // Assert
    assertSame(securityInfo2, tbLwM2mSecurityStore.getByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbLwM2mSecurityStore#putX509(TbLwM2MSecurityInfo)}.
   * <p>
   * Method under test: {@link TbLwM2mSecurityStore#putX509(TbLwM2MSecurityInfo)}
   */
  @Test
  @DisplayName("Test putX509(TbLwM2MSecurityInfo)")
  void testPutX5092() throws NonUniqueSecurityInfoException {
    // Arrange
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    TbLwM2mSecurityStore tbLwM2mSecurityStore = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig()));

    TbLwM2MSecurityInfo securityInfo = new TbLwM2MSecurityInfo();
    securityInfo.setBootstrapConfig(new BootstrapConfig());
    securityInfo.setBootstrapCredentialConfig(new LwM2MBootstrapConfig(new ArrayList<>(),
        mock(LwM2MBootstrapClientCredential.class), mock(LwM2MBootstrapClientCredential.class)));
    securityInfo.setDeviceProfile(new DeviceProfile());
    securityInfo.setEndpoint("https://config.us-east-2.amazonaws.com");
    SecurityInfo securityInfo2 = SecurityInfo.newX509CertInfo("https://config.us-east-2.amazonaws.com");
    securityInfo.setSecurityInfo(securityInfo2);
    securityInfo.setSecurityMode(SecurityMode.PSK);

    // Act
    tbLwM2mSecurityStore.putX509(securityInfo);

    // Assert
    assertSame(securityInfo2, tbLwM2mSecurityStore.getByEndpoint("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbLwM2mSecurityStore#remove(String, String)}.
   * <ul>
   *   <li>Given {@link TbEditableSecurityStore}
   * {@link TbEditableSecurityStore#remove(String)} does nothing.</li>
   *   <li>Then calls {@link TbEditableSecurityStore#remove(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2mSecurityStore#remove(String, String)}
   */
  @Test
  @DisplayName("Test remove(String, String); given TbEditableSecurityStore remove(String) does nothing; then calls remove(String)")
  void testRemove_givenTbEditableSecurityStoreRemoveDoesNothing_thenCallsRemove() {
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
