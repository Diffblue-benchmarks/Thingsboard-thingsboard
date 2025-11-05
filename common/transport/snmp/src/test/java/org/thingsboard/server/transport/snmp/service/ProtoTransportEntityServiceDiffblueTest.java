package org.thingsboard.server.transport.snmp.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
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
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.GetDeviceCredentialsRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.GetDeviceRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.GetSnmpDevicesRequestMsg;

@ExtendWith(MockitoExtension.class)
class ProtoTransportEntityServiceDiffblueTest {
  @InjectMocks private ProtoTransportEntityService protoTransportEntityService;

  @Mock private TransportService transportService;

  /**
   * Test {@link ProtoTransportEntityService#getDeviceById(DeviceId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ProtoTransportEntityService#getDeviceById(DeviceId)}
   */
  @Test
  @DisplayName("Test getDeviceById(DeviceId); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Device ProtoTransportEntityService.getDeviceById(DeviceId)"
  })
  void testGetDeviceById_thenThrowIllegalArgumentException() {
    // Arrange
    when(transportService.getDevice(Mockito.<GetDeviceRequestMsg>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            protoTransportEntityService.getDeviceById(
                new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(transportService).getDevice(isA(GetDeviceRequestMsg.class));
  }

  /**
   * Test {@link ProtoTransportEntityService#getDeviceCredentialsByDeviceId(DeviceId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProtoTransportEntityService#getDeviceCredentialsByDeviceId(DeviceId)}
   */
  @Test
  @DisplayName("Test getDeviceCredentialsByDeviceId(DeviceId); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.DeviceCredentials ProtoTransportEntityService.getDeviceCredentialsByDeviceId(DeviceId)"
  })
  void testGetDeviceCredentialsByDeviceId_thenThrowIllegalArgumentException() {
    // Arrange
    when(transportService.getDeviceCredentials(Mockito.<GetDeviceCredentialsRequestMsg>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            protoTransportEntityService.getDeviceCredentialsByDeviceId(
                new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(transportService).getDeviceCredentials(isA(GetDeviceCredentialsRequestMsg.class));
  }

  /**
   * Test {@link ProtoTransportEntityService#getSnmpDevicesIds(int, int)}.
   *
   * <p>Method under test: {@link ProtoTransportEntityService#getSnmpDevicesIds(int, int)}
   */
  @Test
  @DisplayName("Test getSnmpDevicesIds(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.GetSnmpDevicesResponseMsg ProtoTransportEntityService.getSnmpDevicesIds(int, int)"
  })
  void testGetSnmpDevicesIds() {
    // Arrange
    when(transportService.getSnmpDevicesIds(Mockito.<GetSnmpDevicesRequestMsg>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> protoTransportEntityService.getSnmpDevicesIds(1, 3));
    verify(transportService).getSnmpDevicesIds(isA(GetSnmpDevicesRequestMsg.class));
  }
}
