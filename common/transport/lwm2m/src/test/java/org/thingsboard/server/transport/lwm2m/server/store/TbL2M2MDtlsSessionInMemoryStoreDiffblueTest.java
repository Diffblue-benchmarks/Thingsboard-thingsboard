package org.thingsboard.server.transport.lwm2m.server.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
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
import org.thingsboard.server.transport.lwm2m.secure.TbX509DtlsSessionInfo;

class TbL2M2MDtlsSessionInMemoryStoreDiffblueTest {
  /**
   * Test
   * {@link TbL2M2MDtlsSessionInMemoryStore#put(String, TbX509DtlsSessionInfo)}.
   * <p>
   * Method under test:
   * {@link TbL2M2MDtlsSessionInMemoryStore#put(String, TbX509DtlsSessionInfo)}
   */
  @Test
  @DisplayName("Test put(String, TbX509DtlsSessionInfo)")
  void testPut() {
    // Arrange
    TbL2M2MDtlsSessionInMemoryStore tbL2M2MDtlsSessionInMemoryStore = new TbL2M2MDtlsSessionInMemoryStore();
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
    ValidateDeviceCredentialsResponse credentials = deviceInfoResult.deviceProfile(new DeviceProfile()).build();
    TbX509DtlsSessionInfo msg = new TbX509DtlsSessionInfo("X509 Common Name", credentials);

    // Act
    tbL2M2MDtlsSessionInMemoryStore.put("https://config.us-east-2.amazonaws.com", msg);

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
    assertSame(msg, tbL2M2MDtlsSessionInMemoryStore.get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbL2M2MDtlsSessionInMemoryStore#get(String)}.
   * <p>
   * Method under test: {@link TbL2M2MDtlsSessionInMemoryStore#get(String)}
   */
  @Test
  @DisplayName("Test get(String)")
  void testGet() {
    // Arrange, Act and Assert
    assertNull((new TbL2M2MDtlsSessionInMemoryStore()).get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbL2M2MDtlsSessionInMemoryStore#remove(String)}.
   * <ul>
   *   <li>Given {@link TbL2M2MDtlsSessionInMemoryStore} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TbL2M2MDtlsSessionInMemoryStore#remove(String)}
   */
  @Test
  @DisplayName("Test remove(String); given TbL2M2MDtlsSessionInMemoryStore (default constructor)")
  void testRemove_givenTbL2M2MDtlsSessionInMemoryStore() {
    // Arrange
    TbL2M2MDtlsSessionInMemoryStore tbL2M2MDtlsSessionInMemoryStore = new TbL2M2MDtlsSessionInMemoryStore();

    // Act
    tbL2M2MDtlsSessionInMemoryStore.remove("https://config.us-east-2.amazonaws.com");

    // Assert
    assertNull(tbL2M2MDtlsSessionInMemoryStore.get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbL2M2MDtlsSessionInMemoryStore#remove(String)}.
   * <ul>
   *   <li>Then calls {@link TransportDeviceInfo#setAdditionalInfo(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbL2M2MDtlsSessionInMemoryStore#remove(String)}
   */
  @Test
  @DisplayName("Test remove(String); then calls setAdditionalInfo(String)")
  void testRemove_thenCallsSetAdditionalInfo() {
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
    ValidateDeviceCredentialsResponse credentials = deviceInfoResult.deviceProfile(new DeviceProfile()).build();
    TbX509DtlsSessionInfo msg = new TbX509DtlsSessionInfo("X509 Common Name", credentials);

    TbL2M2MDtlsSessionInMemoryStore tbL2M2MDtlsSessionInMemoryStore = new TbL2M2MDtlsSessionInMemoryStore();
    tbL2M2MDtlsSessionInMemoryStore.put("https://config.us-east-2.amazonaws.com", msg);

    // Act
    tbL2M2MDtlsSessionInMemoryStore.remove("https://config.us-east-2.amazonaws.com");

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
    assertNull(tbL2M2MDtlsSessionInMemoryStore.get("https://config.us-east-2.amazonaws.com"));
  }
}
