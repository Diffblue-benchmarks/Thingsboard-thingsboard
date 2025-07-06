package org.thingsboard.server.transport.snmp.service;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
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
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.device.data.SnmpDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.SnmpDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.transport.snmp.config.SnmpCommunicationConfig;
import org.thingsboard.server.common.data.transport.snmp.config.ToServerRpcRequestSnmpCommunicationConfig;
import org.thingsboard.server.transport.snmp.SnmpTransportContext;
import org.thingsboard.server.transport.snmp.session.DeviceSessionContext;

@ExtendWith(MockitoExtension.class)
class SnmpTransportServiceDiffblueTest {
  @Mock private SnmpTransportContext snmpTransportContext;

  @InjectMocks private SnmpTransportService snmpTransportService;

  /**
   * Test {@link SnmpTransportService#createQueryingTasks(DeviceSessionContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportService#createQueryingTasks(DeviceSessionContext)}
   */
  @Test
  @DisplayName("Test createQueryingTasks(DeviceSessionContext); given ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpTransportService.createQueryingTasks(DeviceSessionContext)"})
  void testCreateQueryingTasks_givenArrayList() throws Exception {
    // Arrange
    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    when(snmpTransportContext.getSnmpAuthService()).thenReturn(snmpAuthService);

    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    profileTransportConfiguration.setCommunicationConfigs(new ArrayList<>());
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    snmpTransportService.createQueryingTasks(
        new DeviceSessionContext(
            tenantId,
            device,
            deviceProfile,
            "ABC123",
            profileTransportConfiguration,
            new SnmpDeviceTransportConfiguration(),
            snmpTransportContext));

    // Assert
    verify(snmpTransportContext).getSnmpAuthService();
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
  }

  /**
   * Test {@link SnmpTransportService#createQueryingTasks(DeviceSessionContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then calls {@link SnmpDeviceProfileTransportConfiguration#getCommunicationConfigs()}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportService#createQueryingTasks(DeviceSessionContext)}
   */
  @Test
  @DisplayName(
      "Test createQueryingTasks(DeviceSessionContext); given ArrayList() add 'null'; then calls getCommunicationConfigs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpTransportService.createQueryingTasks(DeviceSessionContext)"})
  void testCreateQueryingTasks_givenArrayListAddNull_thenCallsGetCommunicationConfigs()
      throws Exception {
    // Arrange
    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    when(snmpTransportContext.getSnmpAuthService()).thenReturn(snmpAuthService);

    ArrayList<SnmpCommunicationConfig> snmpCommunicationConfigList = new ArrayList<>();
    snmpCommunicationConfigList.add(null);
    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        mock(SnmpDeviceProfileTransportConfiguration.class);
    when(profileTransportConfiguration.getCommunicationConfigs())
        .thenReturn(snmpCommunicationConfigList);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    snmpTransportService.createQueryingTasks(
        new DeviceSessionContext(
            tenantId,
            device,
            deviceProfile,
            "ABC123",
            profileTransportConfiguration,
            new SnmpDeviceTransportConfiguration(),
            snmpTransportContext));

    // Assert
    verify(profileTransportConfiguration).getCommunicationConfigs();
    verify(snmpTransportContext).getSnmpAuthService();
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
  }

  /**
   * Test {@link SnmpTransportService#createQueryingTasks(DeviceSessionContext)}.
   *
   * <ul>
   *   <li>Then calls {@link SnmpDeviceProfileTransportConfiguration#getCommunicationConfigs()}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportService#createQueryingTasks(DeviceSessionContext)}
   */
  @Test
  @DisplayName(
      "Test createQueryingTasks(DeviceSessionContext); then calls getCommunicationConfigs()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpTransportService.createQueryingTasks(DeviceSessionContext)"})
  void testCreateQueryingTasks_thenCallsGetCommunicationConfigs() throws Exception {
    // Arrange
    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    when(snmpTransportContext.getSnmpAuthService()).thenReturn(snmpAuthService);

    ArrayList<SnmpCommunicationConfig> snmpCommunicationConfigList = new ArrayList<>();
    snmpCommunicationConfigList.add(new ToServerRpcRequestSnmpCommunicationConfig());
    snmpCommunicationConfigList.add(null);
    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        mock(SnmpDeviceProfileTransportConfiguration.class);
    when(profileTransportConfiguration.getCommunicationConfigs())
        .thenReturn(snmpCommunicationConfigList);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    snmpTransportService.createQueryingTasks(
        new DeviceSessionContext(
            tenantId,
            device,
            deviceProfile,
            "ABC123",
            profileTransportConfiguration,
            new SnmpDeviceTransportConfiguration(),
            snmpTransportContext));

    // Assert
    verify(profileTransportConfiguration).getCommunicationConfigs();
    verify(snmpTransportContext).getSnmpAuthService();
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
  }

  /**
   * Test {@link SnmpTransportService#cancelQueryingTasks(DeviceSessionContext)}.
   *
   * <ul>
   *   <li>Then calls {@link SnmpTransportContext#getSnmpAuthService()}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportService#cancelQueryingTasks(DeviceSessionContext)}
   */
  @Test
  @DisplayName("Test cancelQueryingTasks(DeviceSessionContext); then calls getSnmpAuthService()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpTransportService.cancelQueryingTasks(DeviceSessionContext)"})
  void testCancelQueryingTasks_thenCallsGetSnmpAuthService() throws Exception {
    // Arrange
    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    when(snmpTransportContext.getSnmpAuthService()).thenReturn(snmpAuthService);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();
    DeviceProfile deviceProfile = new DeviceProfile();
    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();

    // Act
    snmpTransportService.cancelQueryingTasks(
        new DeviceSessionContext(
            tenantId,
            device,
            deviceProfile,
            "ABC123",
            profileTransportConfiguration,
            new SnmpDeviceTransportConfiguration(),
            snmpTransportContext));

    // Assert
    verify(snmpTransportContext).getSnmpAuthService();
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
  }
}
