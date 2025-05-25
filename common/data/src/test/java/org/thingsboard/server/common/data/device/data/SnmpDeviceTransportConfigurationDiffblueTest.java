package org.thingsboard.server.common.data.device.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.transport.snmp.AuthenticationProtocol;
import org.thingsboard.server.common.data.transport.snmp.PrivacyProtocol;
import org.thingsboard.server.common.data.transport.snmp.SnmpProtocolVersion;

class SnmpDeviceTransportConfigurationDiffblueTest {
  /**
   * Test new {@link SnmpDeviceTransportConfiguration} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link SnmpDeviceTransportConfiguration}
   */
  @Test
  @DisplayName("Test new SnmpDeviceTransportConfiguration (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpDeviceTransportConfiguration.<init>()"})
  void testNewSnmpDeviceTransportConfiguration() {
    // Arrange and Act
    SnmpDeviceTransportConfiguration actualSnmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();

    // Assert
    assertEquals("localhost", actualSnmpDeviceTransportConfiguration.getHost());
    assertEquals("public", actualSnmpDeviceTransportConfiguration.getCommunity());
    assertNull(actualSnmpDeviceTransportConfiguration.getAuthenticationPassphrase());
    assertNull(actualSnmpDeviceTransportConfiguration.getContextName());
    assertNull(actualSnmpDeviceTransportConfiguration.getEngineId());
    assertNull(actualSnmpDeviceTransportConfiguration.getPrivacyPassphrase());
    assertNull(actualSnmpDeviceTransportConfiguration.getSecurityName());
    assertNull(actualSnmpDeviceTransportConfiguration.getUsername());
    assertNull(actualSnmpDeviceTransportConfiguration.getAuthenticationProtocol());
    assertNull(actualSnmpDeviceTransportConfiguration.getPrivacyProtocol());
    assertEquals(161, actualSnmpDeviceTransportConfiguration.getPort().intValue());
    assertEquals(DeviceTransportType.SNMP, actualSnmpDeviceTransportConfiguration.getType());
    assertEquals(SnmpProtocolVersion.V2C, actualSnmpDeviceTransportConfiguration.getProtocolVersion());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#validate()}.
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpDeviceTransportConfiguration.validate()"})
  void testValidate() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setSecurityName("Transport configuration is not valid");
    snmpDeviceTransportConfiguration.setUsername("janedoe");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#validate()}.
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpDeviceTransportConfiguration.validate()"})
  void testValidate2() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setContextName("Transport configuration is not valid");
    snmpDeviceTransportConfiguration.setSecurityName("Transport configuration is not valid");
    snmpDeviceTransportConfiguration.setUsername("janedoe");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#validate()}.
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpDeviceTransportConfiguration.validate()"})
  void testValidate3() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setAuthenticationPassphrase("Transport configuration is not valid");
    snmpDeviceTransportConfiguration.setAuthenticationProtocol(AuthenticationProtocol.SHA_1);
    snmpDeviceTransportConfiguration.setContextName("Transport configuration is not valid");
    snmpDeviceTransportConfiguration.setSecurityName("Transport configuration is not valid");
    snmpDeviceTransportConfiguration.setUsername("janedoe");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#validate()}.
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpDeviceTransportConfiguration.validate()"})
  void testValidate4() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setPrivacyPassphrase("Transport configuration is not valid");
    snmpDeviceTransportConfiguration.setPrivacyProtocol(PrivacyProtocol.DES);
    snmpDeviceTransportConfiguration.setAuthenticationPassphrase("Transport configuration is not valid");
    snmpDeviceTransportConfiguration.setAuthenticationProtocol(AuthenticationProtocol.SHA_1);
    snmpDeviceTransportConfiguration.setContextName("Transport configuration is not valid");
    snmpDeviceTransportConfiguration.setSecurityName("Transport configuration is not valid");
    snmpDeviceTransportConfiguration.setUsername("janedoe");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#validate()}.
   * <ul>
   *   <li>Given {@link SnmpDeviceTransportConfiguration} (default constructor) AuthenticationProtocol is {@code SHA_1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); given SnmpDeviceTransportConfiguration (default constructor) AuthenticationProtocol is 'SHA_1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpDeviceTransportConfiguration.validate()"})
  void testValidate_givenSnmpDeviceTransportConfigurationAuthenticationProtocolIsSha1() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setAuthenticationProtocol(AuthenticationProtocol.SHA_1);
    snmpDeviceTransportConfiguration.setContextName("Transport configuration is not valid");
    snmpDeviceTransportConfiguration.setSecurityName("Transport configuration is not valid");
    snmpDeviceTransportConfiguration.setUsername("janedoe");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#validate()}.
   * <ul>
   *   <li>Given {@link SnmpDeviceTransportConfiguration} (default constructor) Community is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); given SnmpDeviceTransportConfiguration (default constructor) Community is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpDeviceTransportConfiguration.validate()"})
  void testValidate_givenSnmpDeviceTransportConfigurationCommunityIsEmptyString() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setCommunity("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#validate()}.
   * <ul>
   *   <li>Given {@link SnmpDeviceTransportConfiguration} (default constructor) Host is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); given SnmpDeviceTransportConfiguration (default constructor) Host is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpDeviceTransportConfiguration.validate()"})
  void testValidate_givenSnmpDeviceTransportConfigurationHostIsEmptyString() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setHost("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#validate()}.
   * <ul>
   *   <li>Given {@link SnmpDeviceTransportConfiguration} (default constructor) PrivacyProtocol is {@code DES}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); given SnmpDeviceTransportConfiguration (default constructor) PrivacyProtocol is 'DES'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpDeviceTransportConfiguration.validate()"})
  void testValidate_givenSnmpDeviceTransportConfigurationPrivacyProtocolIsDes() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setPrivacyProtocol(PrivacyProtocol.DES);
    snmpDeviceTransportConfiguration.setAuthenticationPassphrase("Transport configuration is not valid");
    snmpDeviceTransportConfiguration.setAuthenticationProtocol(AuthenticationProtocol.SHA_1);
    snmpDeviceTransportConfiguration.setContextName("Transport configuration is not valid");
    snmpDeviceTransportConfiguration.setSecurityName("Transport configuration is not valid");
    snmpDeviceTransportConfiguration.setUsername("janedoe");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#validate()}.
   * <ul>
   *   <li>Given {@link SnmpDeviceTransportConfiguration} (default constructor) ProtocolVersion is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); given SnmpDeviceTransportConfiguration (default constructor) ProtocolVersion is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpDeviceTransportConfiguration.validate()"})
  void testValidate_givenSnmpDeviceTransportConfigurationProtocolVersionIsNull() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setUsername("janedoe");
    snmpDeviceTransportConfiguration.setProtocolVersion(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#validate()}.
   * <ul>
   *   <li>Given {@link SnmpDeviceTransportConfiguration} (default constructor) ProtocolVersion is {@code V3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); given SnmpDeviceTransportConfiguration (default constructor) ProtocolVersion is 'V3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpDeviceTransportConfiguration.validate()"})
  void testValidate_givenSnmpDeviceTransportConfigurationProtocolVersionIsV3() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#validate()}.
   * <ul>
   *   <li>Given {@link SnmpDeviceTransportConfiguration} (default constructor) Username is {@code janedoe}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); given SnmpDeviceTransportConfiguration (default constructor) Username is 'janedoe'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnmpDeviceTransportConfiguration.validate()"})
  void testValidate_givenSnmpDeviceTransportConfigurationUsernameIsJanedoe() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setUsername("janedoe");
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}, and {@link SnmpDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}, and {@link SnmpDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setUsername("janedoe");

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setUsername("janedoe");

    // Act and Assert
    assertEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}, and {@link SnmpDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setSecurityName("localhost");

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setSecurityName("localhost");

    // Act and Assert
    assertEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}, and {@link SnmpDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setContextName("localhost");

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setContextName("localhost");

    // Act and Assert
    assertEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}, and {@link SnmpDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setAuthenticationProtocol(AuthenticationProtocol.SHA_1);

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setAuthenticationProtocol(AuthenticationProtocol.SHA_1);

    // Act and Assert
    assertEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}, and {@link SnmpDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setAuthenticationPassphrase("localhost");

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setAuthenticationPassphrase("localhost");

    // Act and Assert
    assertEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}, and {@link SnmpDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setPrivacyProtocol(PrivacyProtocol.DES);

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setPrivacyProtocol(PrivacyProtocol.DES);

    // Act and Assert
    assertEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}, and {@link SnmpDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setPrivacyPassphrase("localhost");

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setPrivacyPassphrase("localhost");

    // Act and Assert
    assertEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}, and {@link SnmpDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual9() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setEngineId("42");

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setEngineId("42");

    // Act and Assert
    assertEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}, and {@link SnmpDeviceTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration);
    int expectedHashCodeResult = snmpDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceTransportConfiguration.hashCode());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SnmpDeviceTransportConfiguration(), 1);
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setPort(8080);

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, new SnmpDeviceTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V1);

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, new SnmpDeviceTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setCommunity("localhost");

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, new SnmpDeviceTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, new SnmpDeviceTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setSecurityName("localhost");

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, new SnmpDeviceTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setContextName("localhost");

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, new SnmpDeviceTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setAuthenticationProtocol(AuthenticationProtocol.SHA_1);

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, new SnmpDeviceTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setAuthenticationPassphrase("localhost");

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, new SnmpDeviceTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setPrivacyProtocol(PrivacyProtocol.DES);

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, new SnmpDeviceTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setPrivacyPassphrase("localhost");

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, new SnmpDeviceTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setEngineId("42");

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, new SnmpDeviceTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setUsername("janedoe");

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setSecurityName("localhost");

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setContextName("localhost");

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setAuthenticationProtocol(AuthenticationProtocol.SHA_1);

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setAuthenticationPassphrase("localhost");

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setPrivacyProtocol(PrivacyProtocol.DES);

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setPrivacyPassphrase("localhost");

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();

    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration2 = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration2.setEngineId("42");

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, snmpDeviceTransportConfiguration2);
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setPort(null);

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, new SnmpDeviceTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setProtocolVersion(null);

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, new SnmpDeviceTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    snmpDeviceTransportConfiguration.setCommunity(null);

    // Act and Assert
    assertNotEquals(snmpDeviceTransportConfiguration, new SnmpDeviceTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SnmpDeviceTransportConfiguration(), null);
  }

  /**
   * Test {@link SnmpDeviceTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnmpDeviceTransportConfiguration.equals(Object)",
      "int SnmpDeviceTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SnmpDeviceTransportConfiguration(), "Different type to SnmpDeviceTransportConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceTransportConfiguration#setAuthenticationPassphrase(String)}
   *   <li>{@link SnmpDeviceTransportConfiguration#setAuthenticationProtocol(AuthenticationProtocol)}
   *   <li>{@link SnmpDeviceTransportConfiguration#setCommunity(String)}
   *   <li>{@link SnmpDeviceTransportConfiguration#setContextName(String)}
   *   <li>{@link SnmpDeviceTransportConfiguration#setEngineId(String)}
   *   <li>{@link SnmpDeviceTransportConfiguration#setHost(String)}
   *   <li>{@link SnmpDeviceTransportConfiguration#setPort(Integer)}
   *   <li>{@link SnmpDeviceTransportConfiguration#setPrivacyPassphrase(String)}
   *   <li>{@link SnmpDeviceTransportConfiguration#setPrivacyProtocol(PrivacyProtocol)}
   *   <li>{@link SnmpDeviceTransportConfiguration#setProtocolVersion(SnmpProtocolVersion)}
   *   <li>{@link SnmpDeviceTransportConfiguration#setSecurityName(String)}
   *   <li>{@link SnmpDeviceTransportConfiguration#setUsername(String)}
   *   <li>{@link SnmpDeviceTransportConfiguration#toString()}
   *   <li>{@link SnmpDeviceTransportConfiguration#getAuthenticationPassphrase()}
   *   <li>{@link SnmpDeviceTransportConfiguration#getAuthenticationProtocol()}
   *   <li>{@link SnmpDeviceTransportConfiguration#getCommunity()}
   *   <li>{@link SnmpDeviceTransportConfiguration#getContextName()}
   *   <li>{@link SnmpDeviceTransportConfiguration#getEngineId()}
   *   <li>{@link SnmpDeviceTransportConfiguration#getHost()}
   *   <li>{@link SnmpDeviceTransportConfiguration#getPort()}
   *   <li>{@link SnmpDeviceTransportConfiguration#getPrivacyPassphrase()}
   *   <li>{@link SnmpDeviceTransportConfiguration#getPrivacyProtocol()}
   *   <li>{@link SnmpDeviceTransportConfiguration#getProtocolVersion()}
   *   <li>{@link SnmpDeviceTransportConfiguration#getSecurityName()}
   *   <li>{@link SnmpDeviceTransportConfiguration#getType()}
   *   <li>{@link SnmpDeviceTransportConfiguration#getUsername()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SnmpDeviceTransportConfiguration.getAuthenticationPassphrase()",
      "AuthenticationProtocol SnmpDeviceTransportConfiguration.getAuthenticationProtocol()",
      "String SnmpDeviceTransportConfiguration.getCommunity()",
      "String SnmpDeviceTransportConfiguration.getContextName()",
      "String SnmpDeviceTransportConfiguration.getEngineId()", "String SnmpDeviceTransportConfiguration.getHost()",
      "Integer SnmpDeviceTransportConfiguration.getPort()",
      "String SnmpDeviceTransportConfiguration.getPrivacyPassphrase()",
      "PrivacyProtocol SnmpDeviceTransportConfiguration.getPrivacyProtocol()",
      "SnmpProtocolVersion SnmpDeviceTransportConfiguration.getProtocolVersion()",
      "String SnmpDeviceTransportConfiguration.getSecurityName()",
      "DeviceTransportType SnmpDeviceTransportConfiguration.getType()",
      "String SnmpDeviceTransportConfiguration.getUsername()",
      "void SnmpDeviceTransportConfiguration.setAuthenticationPassphrase(String)",
      "void SnmpDeviceTransportConfiguration.setAuthenticationProtocol(AuthenticationProtocol)",
      "void SnmpDeviceTransportConfiguration.setCommunity(String)",
      "void SnmpDeviceTransportConfiguration.setContextName(String)",
      "void SnmpDeviceTransportConfiguration.setEngineId(String)",
      "void SnmpDeviceTransportConfiguration.setHost(String)", "void SnmpDeviceTransportConfiguration.setPort(Integer)",
      "void SnmpDeviceTransportConfiguration.setPrivacyPassphrase(String)",
      "void SnmpDeviceTransportConfiguration.setPrivacyProtocol(PrivacyProtocol)",
      "void SnmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion)",
      "void SnmpDeviceTransportConfiguration.setSecurityName(String)",
      "void SnmpDeviceTransportConfiguration.setUsername(String)",
      "String SnmpDeviceTransportConfiguration.toString()"})
  void testGettersAndSetters() {
    // Arrange
    SnmpDeviceTransportConfiguration snmpDeviceTransportConfiguration = new SnmpDeviceTransportConfiguration();

    // Act
    snmpDeviceTransportConfiguration.setAuthenticationPassphrase("Authentication Passphrase");
    snmpDeviceTransportConfiguration.setAuthenticationProtocol(AuthenticationProtocol.SHA_1);
    snmpDeviceTransportConfiguration.setCommunity("Community");
    snmpDeviceTransportConfiguration.setContextName("Context Name");
    snmpDeviceTransportConfiguration.setEngineId("42");
    snmpDeviceTransportConfiguration.setHost("localhost");
    snmpDeviceTransportConfiguration.setPort(8080);
    snmpDeviceTransportConfiguration.setPrivacyPassphrase("Privacy Passphrase");
    snmpDeviceTransportConfiguration.setPrivacyProtocol(PrivacyProtocol.DES);
    snmpDeviceTransportConfiguration.setProtocolVersion(SnmpProtocolVersion.V1);
    snmpDeviceTransportConfiguration.setSecurityName("Security Name");
    snmpDeviceTransportConfiguration.setUsername("janedoe");
    String actualToStringResult = snmpDeviceTransportConfiguration.toString();
    String actualAuthenticationPassphrase = snmpDeviceTransportConfiguration.getAuthenticationPassphrase();
    AuthenticationProtocol actualAuthenticationProtocol = snmpDeviceTransportConfiguration.getAuthenticationProtocol();
    String actualCommunity = snmpDeviceTransportConfiguration.getCommunity();
    String actualContextName = snmpDeviceTransportConfiguration.getContextName();
    String actualEngineId = snmpDeviceTransportConfiguration.getEngineId();
    String actualHost = snmpDeviceTransportConfiguration.getHost();
    Integer actualPort = snmpDeviceTransportConfiguration.getPort();
    String actualPrivacyPassphrase = snmpDeviceTransportConfiguration.getPrivacyPassphrase();
    PrivacyProtocol actualPrivacyProtocol = snmpDeviceTransportConfiguration.getPrivacyProtocol();
    SnmpProtocolVersion actualProtocolVersion = snmpDeviceTransportConfiguration.getProtocolVersion();
    String actualSecurityName = snmpDeviceTransportConfiguration.getSecurityName();
    DeviceTransportType actualType = snmpDeviceTransportConfiguration.getType();

    // Assert
    assertEquals("42", actualEngineId);
    assertEquals("Authentication Passphrase", actualAuthenticationPassphrase);
    assertEquals("Community", actualCommunity);
    assertEquals("Context Name", actualContextName);
    assertEquals("Privacy Passphrase", actualPrivacyPassphrase);
    assertEquals("Security Name", actualSecurityName);
    assertEquals("SnmpDeviceTransportConfiguration(host=localhost, port=8080, protocolVersion=V1)",
        actualToStringResult);
    assertEquals("janedoe", snmpDeviceTransportConfiguration.getUsername());
    assertEquals("localhost", actualHost);
    assertEquals(8080, actualPort.intValue());
    assertEquals(DeviceTransportType.SNMP, actualType);
    assertEquals(AuthenticationProtocol.SHA_1, actualAuthenticationProtocol);
    assertEquals(PrivacyProtocol.DES, actualPrivacyProtocol);
    assertEquals(SnmpProtocolVersion.V1, actualProtocolVersion);
  }
}
