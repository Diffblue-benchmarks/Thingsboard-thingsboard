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
package org.thingsboard.server.transport.snmp;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
import org.snmp4j.CommunityTarget;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.device.data.SnmpDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.SnmpDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.transport.snmp.service.SnmpAuthService;
import org.thingsboard.server.transport.snmp.service.SnmpTransportService;
import org.thingsboard.server.transport.snmp.session.DeviceSessionContext;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class SnmpTransportContextDiffblueTest {
  @Mock private SnmpAuthService snmpAuthService;

  @InjectMocks private SnmpTransportContext snmpTransportContext;

  @Mock private SnmpTransportService snmpTransportService;

  @Mock private TransportService transportService;

  /**
   * Test {@link SnmpTransportContext#onDeviceDeleted(DeviceSessionContext)}.
   *
   * <p>Method under test: {@link SnmpTransportContext#onDeviceDeleted(DeviceSessionContext)}
   */
  @Test
  @DisplayName("Test onDeviceDeleted(DeviceSessionContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpTransportContext.onDeviceDeleted(DeviceSessionContext)"})
  void testOnDeviceDeleted() throws Exception {
    // Arrange
    doNothing()
        .when(transportService)
        .lifecycleEvent(
            Mockito.<TenantId>any(),
            Mockito.<DeviceId>any(),
            Mockito.<ComponentLifecycleEvent>any(),
            anyBoolean(),
            Mockito.<Throwable>any());
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());
    doNothing().when(snmpTransportService).cancelQueryingTasks(Mockito.<DeviceSessionContext>any());
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    doNothing().when(snmpAuthService).cleanUpSnmpAuthInfo(Mockito.<DeviceSessionContext>any());

    Device device = mock(Device.class);
    when(device.getId()).thenReturn(new DeviceId(UUID.randomUUID()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceProfile deviceProfile = new DeviceProfile();
    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();

    DeviceSessionContext sessionContext =
        new DeviceSessionContext(
            tenantId,
            device,
            deviceProfile,
            "ABC123",
            profileTransportConfiguration,
            new SnmpDeviceTransportConfiguration(),
            snmpTransportContext);

    // Act
    snmpTransportContext.onDeviceDeleted(sessionContext);

    // Assert
    verify(device, atLeast(1)).getId();
    verify(transportService).deregisterSession(isNull());
    verify(transportService)
        .lifecycleEvent(
            isA(TenantId.class),
            isA(DeviceId.class),
            eq(ComponentLifecycleEvent.STOPPED),
            eq(true),
            isNull());
    verify(snmpAuthService).cleanUpSnmpAuthInfo(isA(DeviceSessionContext.class));
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
    verify(snmpTransportService).cancelQueryingTasks(isA(DeviceSessionContext.class));
    assertFalse(sessionContext.isActive());
  }

  /**
   * Test {@link SnmpTransportContext#onDeviceDeleted(DeviceSessionContext)}.
   *
   * <p>Method under test: {@link SnmpTransportContext#onDeviceDeleted(DeviceSessionContext)}
   */
  @Test
  @DisplayName("Test onDeviceDeleted(DeviceSessionContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpTransportContext.onDeviceDeleted(DeviceSessionContext)"})
  void testOnDeviceDeleted2() throws Exception {
    // Arrange
    doNothing()
        .when(transportService)
        .lifecycleEvent(
            Mockito.<TenantId>any(),
            Mockito.<DeviceId>any(),
            Mockito.<ComponentLifecycleEvent>any(),
            anyBoolean(),
            Mockito.<Throwable>any());
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());
    doNothing().when(snmpTransportService).cancelQueryingTasks(Mockito.<DeviceSessionContext>any());
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    doNothing().when(snmpAuthService).cleanUpSnmpAuthInfo(Mockito.<DeviceSessionContext>any());

    Device device = mock(Device.class);
    when(device.getId()).thenReturn(new DeviceId(UUID.randomUUID()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceProfile deviceProfile = new DeviceProfile();
    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();

    DeviceSessionContext sessionContext =
        new DeviceSessionContext(
            tenantId,
            device,
            deviceProfile,
            "ABC123",
            profileTransportConfiguration,
            new SnmpDeviceTransportConfiguration(),
            snmpTransportContext);

    // Act
    snmpTransportContext.onDeviceDeleted(sessionContext);

    // Assert
    verify(device, atLeast(1)).getId();
    verify(transportService).deregisterSession(isNull());
    verify(transportService)
        .lifecycleEvent(
            isA(TenantId.class),
            isA(DeviceId.class),
            eq(ComponentLifecycleEvent.STOPPED),
            eq(true),
            isNull());
    verify(snmpAuthService).cleanUpSnmpAuthInfo(isA(DeviceSessionContext.class));
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
    verify(snmpTransportService).cancelQueryingTasks(isA(DeviceSessionContext.class));
    assertFalse(sessionContext.isActive());
  }

  /**
   * Test {@link SnmpTransportContext#getSessions()}.
   *
   * <p>Method under test: {@link SnmpTransportContext#getSessions()}
   */
  @Test
  @DisplayName("Test getSessions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection SnmpTransportContext.getSessions()"})
  void testGetSessions() {
    // Arrange, Act and Assert
    assertTrue(snmpTransportContext.getSessions().isEmpty());
  }

  /**
   * Test {@link SnmpTransportContext#getSessions()}.
   *
   * <p>Method under test: {@link SnmpTransportContext#getSessions()}
   */
  @Test
  @DisplayName("Test getSessions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection SnmpTransportContext.getSessions()"})
  void testGetSessions2() {
    // Arrange, Act and Assert
    assertTrue(snmpTransportContext.getSessions().isEmpty());
  }
}
