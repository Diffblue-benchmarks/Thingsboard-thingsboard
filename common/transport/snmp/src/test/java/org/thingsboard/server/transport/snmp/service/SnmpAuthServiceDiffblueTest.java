package org.thingsboard.server.transport.snmp.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.device.data.SnmpDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.SnmpDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.transport.snmp.AuthenticationProtocol;
import org.thingsboard.server.common.data.transport.snmp.SnmpProtocolVersion;

@ExtendWith(MockitoExtension.class)
class SnmpAuthServiceDiffblueTest {
  @InjectMocks private SnmpAuthService snmpAuthService;

  /**
   * Test {@link SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}.
   *
   * <p>Method under test: {@link
   * SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}
   */
  @Test
  @DisplayName(
      "Test setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.snmp4j.Target SnmpAuthService.setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)"
  })
  void testSetUpSnmpTarget() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration profileTransportConfig =
        new SnmpDeviceProfileTransportConfiguration();
    SnmpDeviceTransportConfiguration deviceTransportConfig =
        mock(SnmpDeviceTransportConfiguration.class);
    when(deviceTransportConfig.getCommunity()).thenThrow(new UnsupportedOperationException("foo"));
    when(deviceTransportConfig.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V1);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> snmpAuthService.setUpSnmpTarget(profileTransportConfig, deviceTransportConfig));
    verify(deviceTransportConfig).getCommunity();
    verify(deviceTransportConfig).getProtocolVersion();
  }

  /**
   * Test {@link SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}.
   *
   * <p>Method under test: {@link
   * SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}
   */
  @Test
  @DisplayName(
      "Test setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.snmp4j.Target SnmpAuthService.setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)"
  })
  void testSetUpSnmpTarget2() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration profileTransportConfig =
        new SnmpDeviceProfileTransportConfiguration();
    SnmpDeviceTransportConfiguration deviceTransportConfig =
        mock(SnmpDeviceTransportConfiguration.class);
    when(deviceTransportConfig.getUsername()).thenThrow(new UnsupportedOperationException("foo"));
    when(deviceTransportConfig.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> snmpAuthService.setUpSnmpTarget(profileTransportConfig, deviceTransportConfig));
    verify(deviceTransportConfig).getProtocolVersion();
    verify(deviceTransportConfig).getUsername();
  }

  /**
   * Test {@link SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}.
   *
   * <p>Method under test: {@link
   * SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}
   */
  @Test
  @DisplayName(
      "Test setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.snmp4j.Target SnmpAuthService.setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)"
  })
  void testSetUpSnmpTarget3() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration profileTransportConfig =
        new SnmpDeviceProfileTransportConfiguration();
    SnmpDeviceTransportConfiguration deviceTransportConfig =
        mock(SnmpDeviceTransportConfiguration.class);
    when(deviceTransportConfig.getSecurityName())
        .thenThrow(new UnsupportedOperationException("foo"));
    when(deviceTransportConfig.getUsername()).thenReturn("janedoe");
    when(deviceTransportConfig.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> snmpAuthService.setUpSnmpTarget(profileTransportConfig, deviceTransportConfig));
    verify(deviceTransportConfig).getProtocolVersion();
    verify(deviceTransportConfig).getSecurityName();
    verify(deviceTransportConfig).getUsername();
  }

  /**
   * Test {@link SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}.
   *
   * <p>Method under test: {@link
   * SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}
   */
  @Test
  @DisplayName(
      "Test setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.snmp4j.Target SnmpAuthService.setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)"
  })
  void testSetUpSnmpTarget4() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration profileTransportConfig =
        new SnmpDeviceProfileTransportConfiguration();
    SnmpDeviceTransportConfiguration deviceTransportConfig =
        mock(SnmpDeviceTransportConfiguration.class);
    when(deviceTransportConfig.getEngineId()).thenThrow(new UnsupportedOperationException("foo"));
    when(deviceTransportConfig.getSecurityName()).thenReturn("Security Name");
    when(deviceTransportConfig.getUsername()).thenReturn("janedoe");
    when(deviceTransportConfig.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> snmpAuthService.setUpSnmpTarget(profileTransportConfig, deviceTransportConfig));
    verify(deviceTransportConfig).getEngineId();
    verify(deviceTransportConfig).getProtocolVersion();
    verify(deviceTransportConfig).getSecurityName();
    verify(deviceTransportConfig).getUsername();
  }

  /**
   * Test {@link SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}.
   *
   * <p>Method under test: {@link
   * SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}
   */
  @Test
  @DisplayName(
      "Test setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.snmp4j.Target SnmpAuthService.setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)"
  })
  void testSetUpSnmpTarget5() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration profileTransportConfig =
        new SnmpDeviceProfileTransportConfiguration();
    SnmpDeviceTransportConfiguration deviceTransportConfig =
        mock(SnmpDeviceTransportConfiguration.class);
    when(deviceTransportConfig.getAuthenticationPassphrase())
        .thenThrow(new UnsupportedOperationException("foo"));
    when(deviceTransportConfig.getEngineId()).thenReturn("42");
    when(deviceTransportConfig.getAuthenticationProtocol())
        .thenReturn(AuthenticationProtocol.SHA_1);
    when(deviceTransportConfig.getSecurityName()).thenReturn("Security Name");
    when(deviceTransportConfig.getUsername()).thenReturn("janedoe");
    when(deviceTransportConfig.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> snmpAuthService.setUpSnmpTarget(profileTransportConfig, deviceTransportConfig));
    verify(deviceTransportConfig).getAuthenticationPassphrase();
    verify(deviceTransportConfig).getAuthenticationProtocol();
    verify(deviceTransportConfig).getEngineId();
    verify(deviceTransportConfig).getProtocolVersion();
    verify(deviceTransportConfig).getSecurityName();
    verify(deviceTransportConfig).getUsername();
  }

  /**
   * Test {@link SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code Community}.
   *   <li>Then calls {@link SnmpDeviceTransportConfiguration#getHost()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}
   */
  @Test
  @DisplayName(
      "Test setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration); given 'Community'; then calls getHost()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.snmp4j.Target SnmpAuthService.setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)"
  })
  void testSetUpSnmpTarget_givenCommunity_thenCallsGetHost() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration profileTransportConfig =
        new SnmpDeviceProfileTransportConfiguration();
    SnmpDeviceTransportConfiguration deviceTransportConfig =
        mock(SnmpDeviceTransportConfiguration.class);
    when(deviceTransportConfig.getHost()).thenThrow(new UnsupportedOperationException("foo"));
    when(deviceTransportConfig.getCommunity()).thenReturn("Community");
    when(deviceTransportConfig.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V1);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> snmpAuthService.setUpSnmpTarget(profileTransportConfig, deviceTransportConfig));
    verify(deviceTransportConfig).getCommunity();
    verify(deviceTransportConfig).getHost();
    verify(deviceTransportConfig).getProtocolVersion();
  }

  /**
   * Test {@link SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link SnmpDeviceTransportConfiguration#getAuthenticationPassphrase()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}
   */
  @Test
  @DisplayName(
      "Test setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration); then calls getAuthenticationPassphrase()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.snmp4j.Target SnmpAuthService.setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)"
  })
  void testSetUpSnmpTarget_thenCallsGetAuthenticationPassphrase() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration profileTransportConfig =
        new SnmpDeviceProfileTransportConfiguration();
    SnmpDeviceTransportConfiguration deviceTransportConfig =
        mock(SnmpDeviceTransportConfiguration.class);
    when(deviceTransportConfig.getAuthenticationPassphrase())
        .thenReturn("Authentication Passphrase");
    when(deviceTransportConfig.getEngineId()).thenReturn("42");
    when(deviceTransportConfig.getAuthenticationProtocol())
        .thenReturn(AuthenticationProtocol.SHA_1);
    when(deviceTransportConfig.getSecurityName()).thenReturn("Security Name");
    when(deviceTransportConfig.getUsername()).thenReturn("janedoe");
    when(deviceTransportConfig.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> snmpAuthService.setUpSnmpTarget(profileTransportConfig, deviceTransportConfig));
    verify(deviceTransportConfig).getAuthenticationPassphrase();
    verify(deviceTransportConfig, atLeast(1)).getAuthenticationProtocol();
    verify(deviceTransportConfig).getEngineId();
    verify(deviceTransportConfig).getProtocolVersion();
    verify(deviceTransportConfig).getSecurityName();
    verify(deviceTransportConfig).getUsername();
  }
}
