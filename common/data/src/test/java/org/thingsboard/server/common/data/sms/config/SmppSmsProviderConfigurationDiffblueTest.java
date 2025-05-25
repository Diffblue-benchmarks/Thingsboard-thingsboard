package org.thingsboard.server.common.data.sms.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.sms.config.SmppSmsProviderConfiguration.SmppBindType;

class SmppSmsProviderConfigurationDiffblueTest {
  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}, and {@link SmppSmsProviderConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SmppSmsProviderConfiguration#equals(Object)}
   *   <li>{@link SmppSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
    int expectedHashCodeResult = smppSmsProviderConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, smppSmsProviderConfiguration2.hashCode());
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}, and {@link SmppSmsProviderConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SmppSmsProviderConfiguration#equals(Object)}
   *   <li>{@link SmppSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    // Act and Assert
    assertEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration);
    int expectedHashCodeResult = smppSmsProviderConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, smppSmsProviderConfiguration.hashCode());
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("17 High St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange(null);
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(null);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.RX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 1);
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme(null);
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 1);
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi(null);
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 1);
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon(null);
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("1.0.2");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost(null);
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("1.0.2");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword(null);
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(1);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(null);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("localhost");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion(null);
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("1.0.2");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType(null);
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("17 High St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress(null);
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 1);
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi(null);
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 1);
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon(null);
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("1.0.2");
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId(null);
    smppSmsProviderConfiguration.setSystemType("System Type");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual29() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("1.0.2");

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual30() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType(null);

    SmppSmsProviderConfiguration smppSmsProviderConfiguration2 = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration2.setAddressRange("42 Main St");
    smppSmsProviderConfiguration2.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration2.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration2.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration2.setHost("localhost");
    smppSmsProviderConfiguration2.setPassword("iloveyou");
    smppSmsProviderConfiguration2.setPort(8080);
    smppSmsProviderConfiguration2.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration2.setServiceType("Service Type");
    smppSmsProviderConfiguration2.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration2.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration2.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration2.setSystemId("42");
    smppSmsProviderConfiguration2.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, smppSmsProviderConfiguration2);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, null);
  }

  /**
   * Test {@link SmppSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmppSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmppSmsProviderConfiguration.equals(Object)",
      "int SmppSmsProviderConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SmppSmsProviderConfiguration smppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    smppSmsProviderConfiguration.setAddressRange("42 Main St");
    smppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    smppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    smppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    smppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    smppSmsProviderConfiguration.setHost("localhost");
    smppSmsProviderConfiguration.setPassword("iloveyou");
    smppSmsProviderConfiguration.setPort(8080);
    smppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    smppSmsProviderConfiguration.setServiceType("Service Type");
    smppSmsProviderConfiguration.setSourceAddress("42 Main St");
    smppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    smppSmsProviderConfiguration.setSourceTon((byte) 'A');
    smppSmsProviderConfiguration.setSystemId("42");
    smppSmsProviderConfiguration.setSystemType("System Type");

    // Act and Assert
    assertNotEquals(smppSmsProviderConfiguration, "Different type to SmppSmsProviderConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SmppSmsProviderConfiguration}
   *   <li>{@link SmppSmsProviderConfiguration#setAddressRange(String)}
   *   <li>{@link SmppSmsProviderConfiguration#setBindType(SmppBindType)}
   *   <li>{@link SmppSmsProviderConfiguration#setCodingScheme(Byte)}
   *   <li>{@link SmppSmsProviderConfiguration#setDestinationNpi(Byte)}
   *   <li>{@link SmppSmsProviderConfiguration#setDestinationTon(Byte)}
   *   <li>{@link SmppSmsProviderConfiguration#setHost(String)}
   *   <li>{@link SmppSmsProviderConfiguration#setPassword(String)}
   *   <li>{@link SmppSmsProviderConfiguration#setPort(Integer)}
   *   <li>{@link SmppSmsProviderConfiguration#setProtocolVersion(String)}
   *   <li>{@link SmppSmsProviderConfiguration#setServiceType(String)}
   *   <li>{@link SmppSmsProviderConfiguration#setSourceAddress(String)}
   *   <li>{@link SmppSmsProviderConfiguration#setSourceNpi(Byte)}
   *   <li>{@link SmppSmsProviderConfiguration#setSourceTon(Byte)}
   *   <li>{@link SmppSmsProviderConfiguration#setSystemId(String)}
   *   <li>{@link SmppSmsProviderConfiguration#setSystemType(String)}
   *   <li>{@link SmppSmsProviderConfiguration#toString()}
   *   <li>{@link SmppSmsProviderConfiguration#getAddressRange()}
   *   <li>{@link SmppSmsProviderConfiguration#getBindType()}
   *   <li>{@link SmppSmsProviderConfiguration#getCodingScheme()}
   *   <li>{@link SmppSmsProviderConfiguration#getDestinationNpi()}
   *   <li>{@link SmppSmsProviderConfiguration#getDestinationTon()}
   *   <li>{@link SmppSmsProviderConfiguration#getHost()}
   *   <li>{@link SmppSmsProviderConfiguration#getPassword()}
   *   <li>{@link SmppSmsProviderConfiguration#getPort()}
   *   <li>{@link SmppSmsProviderConfiguration#getProtocolVersion()}
   *   <li>{@link SmppSmsProviderConfiguration#getServiceType()}
   *   <li>{@link SmppSmsProviderConfiguration#getSourceAddress()}
   *   <li>{@link SmppSmsProviderConfiguration#getSourceNpi()}
   *   <li>{@link SmppSmsProviderConfiguration#getSourceTon()}
   *   <li>{@link SmppSmsProviderConfiguration#getSystemId()}
   *   <li>{@link SmppSmsProviderConfiguration#getSystemType()}
   *   <li>{@link SmppSmsProviderConfiguration#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SmppSmsProviderConfiguration.<init>()",
      "String SmppSmsProviderConfiguration.getAddressRange()",
      "SmppBindType SmppSmsProviderConfiguration.getBindType()", "Byte SmppSmsProviderConfiguration.getCodingScheme()",
      "Byte SmppSmsProviderConfiguration.getDestinationNpi()", "Byte SmppSmsProviderConfiguration.getDestinationTon()",
      "String SmppSmsProviderConfiguration.getHost()", "String SmppSmsProviderConfiguration.getPassword()",
      "Integer SmppSmsProviderConfiguration.getPort()", "String SmppSmsProviderConfiguration.getProtocolVersion()",
      "String SmppSmsProviderConfiguration.getServiceType()", "String SmppSmsProviderConfiguration.getSourceAddress()",
      "Byte SmppSmsProviderConfiguration.getSourceNpi()", "Byte SmppSmsProviderConfiguration.getSourceTon()",
      "String SmppSmsProviderConfiguration.getSystemId()", "String SmppSmsProviderConfiguration.getSystemType()",
      "SmsProviderType SmppSmsProviderConfiguration.getType()",
      "void SmppSmsProviderConfiguration.setAddressRange(String)",
      "void SmppSmsProviderConfiguration.setBindType(SmppBindType)",
      "void SmppSmsProviderConfiguration.setCodingScheme(Byte)",
      "void SmppSmsProviderConfiguration.setDestinationNpi(Byte)",
      "void SmppSmsProviderConfiguration.setDestinationTon(Byte)", "void SmppSmsProviderConfiguration.setHost(String)",
      "void SmppSmsProviderConfiguration.setPassword(String)", "void SmppSmsProviderConfiguration.setPort(Integer)",
      "void SmppSmsProviderConfiguration.setProtocolVersion(String)",
      "void SmppSmsProviderConfiguration.setServiceType(String)",
      "void SmppSmsProviderConfiguration.setSourceAddress(String)",
      "void SmppSmsProviderConfiguration.setSourceNpi(Byte)", "void SmppSmsProviderConfiguration.setSourceTon(Byte)",
      "void SmppSmsProviderConfiguration.setSystemId(String)",
      "void SmppSmsProviderConfiguration.setSystemType(String)", "String SmppSmsProviderConfiguration.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    SmppSmsProviderConfiguration actualSmppSmsProviderConfiguration = new SmppSmsProviderConfiguration();
    actualSmppSmsProviderConfiguration.setAddressRange("42 Main St");
    actualSmppSmsProviderConfiguration.setBindType(SmppBindType.TX);
    actualSmppSmsProviderConfiguration.setCodingScheme((byte) 'A');
    actualSmppSmsProviderConfiguration.setDestinationNpi((byte) 'A');
    actualSmppSmsProviderConfiguration.setDestinationTon((byte) 'A');
    actualSmppSmsProviderConfiguration.setHost("localhost");
    actualSmppSmsProviderConfiguration.setPassword("iloveyou");
    actualSmppSmsProviderConfiguration.setPort(8080);
    actualSmppSmsProviderConfiguration.setProtocolVersion("1.0.2");
    actualSmppSmsProviderConfiguration.setServiceType("Service Type");
    actualSmppSmsProviderConfiguration.setSourceAddress("42 Main St");
    actualSmppSmsProviderConfiguration.setSourceNpi((byte) 'A');
    actualSmppSmsProviderConfiguration.setSourceTon((byte) 'A');
    actualSmppSmsProviderConfiguration.setSystemId("42");
    actualSmppSmsProviderConfiguration.setSystemType("System Type");
    String actualToStringResult = actualSmppSmsProviderConfiguration.toString();
    String actualAddressRange = actualSmppSmsProviderConfiguration.getAddressRange();
    SmppBindType actualBindType = actualSmppSmsProviderConfiguration.getBindType();
    Byte actualCodingScheme = actualSmppSmsProviderConfiguration.getCodingScheme();
    Byte actualDestinationNpi = actualSmppSmsProviderConfiguration.getDestinationNpi();
    Byte actualDestinationTon = actualSmppSmsProviderConfiguration.getDestinationTon();
    String actualHost = actualSmppSmsProviderConfiguration.getHost();
    String actualPassword = actualSmppSmsProviderConfiguration.getPassword();
    Integer actualPort = actualSmppSmsProviderConfiguration.getPort();
    String actualProtocolVersion = actualSmppSmsProviderConfiguration.getProtocolVersion();
    String actualServiceType = actualSmppSmsProviderConfiguration.getServiceType();
    String actualSourceAddress = actualSmppSmsProviderConfiguration.getSourceAddress();
    Byte actualSourceNpi = actualSmppSmsProviderConfiguration.getSourceNpi();
    Byte actualSourceTon = actualSmppSmsProviderConfiguration.getSourceTon();
    String actualSystemId = actualSmppSmsProviderConfiguration.getSystemId();
    String actualSystemType = actualSmppSmsProviderConfiguration.getSystemType();
    SmsProviderType actualType = actualSmppSmsProviderConfiguration.getType();

    // Assert
    assertEquals("1.0.2", actualProtocolVersion);
    assertEquals("42 Main St", actualAddressRange);
    assertEquals("42 Main St", actualSourceAddress);
    assertEquals("42", actualSystemId);
    assertEquals("Service Type", actualServiceType);
    assertEquals("SmppSmsProviderConfiguration(protocolVersion=1.0.2, host=localhost, port=8080, systemId=42,"
        + " password=iloveyou, systemType=System Type, bindType=TX, serviceType=Service Type, sourceAddress=42"
        + " Main St, sourceTon=65, sourceNpi=65, destinationTon=65, destinationNpi=65, addressRange=42 Main St,"
        + " codingScheme=65)", actualToStringResult);
    assertEquals("System Type", actualSystemType);
    assertEquals("iloveyou", actualPassword);
    assertEquals("localhost", actualHost);
    assertEquals(8080, actualPort.intValue());
    assertEquals(SmppBindType.TX, actualBindType);
    assertEquals(SmsProviderType.SMPP, actualType);
    assertEquals('A', actualCodingScheme.byteValue());
    assertEquals('A', actualDestinationNpi.byteValue());
    assertEquals('A', actualDestinationTon.byteValue());
    assertEquals('A', actualSourceNpi.byteValue());
    assertEquals('A', actualSourceTon.byteValue());
  }
}
