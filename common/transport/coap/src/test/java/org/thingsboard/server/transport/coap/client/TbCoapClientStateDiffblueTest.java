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
import org.junit.jupiter.api.DisplayName;
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
   * Test {@link TbCoapClientState#init(ValidateDeviceCredentialsResponse)}.
   * <ul>
   *   <li>Then {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId
   * is {@code null} EdrxCycle longValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCoapClientState#init(ValidateDeviceCredentialsResponse)}
   */
  @Test
  @DisplayName("Test init(ValidateDeviceCredentialsResponse); then TbCoapClientState(DeviceId) with deviceId is 'null' EdrxCycle longValue is one")
  void testInit_thenTbCoapClientStateWithDeviceIdIsNullEdrxCycleLongValueIsOne() {
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
   * Test {@link TbCoapClientState#lock()}.
   * <ul>
   *   <li>Then {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId
   * is {@code null} Lock {@link ReentrantLock}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCoapClientState#lock()}
   */
  @Test
  @DisplayName("Test lock(); then TbCoapClientState(DeviceId) with deviceId is 'null' Lock ReentrantLock")
  void testLock_thenTbCoapClientStateWithDeviceIdIsNullLockReentrantLock() {
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
   * Test {@link TbCoapClientState#updateLastUplinkTime(long)}.
   * <p>
   * Method under test: {@link TbCoapClientState#updateLastUplinkTime(long)}
   */
  @Test
  @DisplayName("Test updateLastUplinkTime(long)")
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
   * Test {@link TbCoapClientState#updateLastUplinkTime(long)}.
   * <p>
   * Method under test: {@link TbCoapClientState#updateLastUplinkTime(long)}
   */
  @Test
  @DisplayName("Test updateLastUplinkTime(long)")
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
