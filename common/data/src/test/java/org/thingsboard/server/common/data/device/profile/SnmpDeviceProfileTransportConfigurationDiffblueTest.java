package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.transport.snmp.config.SnmpCommunicationConfig;
import org.thingsboard.server.common.data.transport.snmp.config.ToServerRpcRequestSnmpCommunicationConfig;

class SnmpDeviceProfileTransportConfigurationDiffblueTest {
  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#validate()}.
   * <p>
   * Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  void testValidate() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(null);
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#validate()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); given ArrayList() add 'null'; then throw IllegalArgumentException")
  void testValidate_givenArrayListAddNull_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(null);

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#validate()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link ToServerRpcRequestSnmpCommunicationConfig} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); given ArrayList() add ToServerRpcRequestSnmpCommunicationConfig (default constructor)")
  void testValidate_givenArrayListAddToServerRpcRequestSnmpCommunicationConfig() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(new ToServerRpcRequestSnmpCommunicationConfig());

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#validate()}.
   * <ul>
   *   <li>Given {@link SnmpDeviceProfileTransportConfiguration} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); given SnmpDeviceProfileTransportConfiguration (default constructor)")
  void testValidate_givenSnmpDeviceProfileTransportConfiguration() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new SnmpDeviceProfileTransportConfiguration()).validate());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#validate()}.
   * <ul>
   *   <li>Given {@link SnmpDeviceProfileTransportConfiguration} (default
   * constructor) Retries is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); given SnmpDeviceProfileTransportConfiguration (default constructor) Retries is minus one")
  void testValidate_givenSnmpDeviceProfileTransportConfigurationRetriesIsMinusOne() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(null);

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(-1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#validate()}.
   * <ul>
   *   <li>Given {@link SnmpDeviceProfileTransportConfiguration} (default
   * constructor) Retries is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); given SnmpDeviceProfileTransportConfiguration (default constructor) Retries is 'null'")
  void testValidate_givenSnmpDeviceProfileTransportConfigurationRetriesIsNull() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(null);

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#validate()}.
   * <ul>
   *   <li>Given {@link SnmpDeviceProfileTransportConfiguration} (default
   * constructor) TimeoutMs is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); given SnmpDeviceProfileTransportConfiguration (default constructor) TimeoutMs is minus one")
  void testValidate_givenSnmpDeviceProfileTransportConfigurationTimeoutMsIsMinusOne() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(null);

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(-1);
    snmpDeviceProfileTransportConfiguration.setRetries(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}, and
   * {@link SnmpDeviceProfileTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 = new SnmpDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}, and
   * {@link SnmpDeviceProfileTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(10);

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setTimeoutMs(10);

    // Act and Assert
    assertEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}, and
   * {@link SnmpDeviceProfileTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setRetries(1);

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setRetries(1);

    // Act and Assert
    assertEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}, and
   * {@link SnmpDeviceProfileTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(new ArrayList<>());

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setCommunicationConfigs(new ArrayList<>());

    // Act and Assert
    assertEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}, and
   * {@link SnmpDeviceProfileTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration);
    int expectedHashCodeResult = snmpDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceProfileTransportConfiguration.hashCode());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SnmpDeviceProfileTransportConfiguration(), 1);
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(10);

    // Act and Assert
    assertNotEquals(snmpDeviceProfileTransportConfiguration, new SnmpDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setRetries(1);

    // Act and Assert
    assertNotEquals(snmpDeviceProfileTransportConfiguration, new SnmpDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(new ArrayList<>());

    // Act and Assert
    assertNotEquals(snmpDeviceProfileTransportConfiguration, new SnmpDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setTimeoutMs(10);

    // Act and Assert
    assertNotEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setRetries(1);

    // Act and Assert
    assertNotEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setCommunicationConfigs(new ArrayList<>());

    // Act and Assert
    assertNotEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(mock(ToServerRpcRequestSnmpCommunicationConfig.class));

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);

    // Act and Assert
    assertNotEquals(snmpDeviceProfileTransportConfiguration, new SnmpDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SnmpDeviceProfileTransportConfiguration(), null);
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SnmpDeviceProfileTransportConfiguration(),
        "Different type to SnmpDeviceProfileTransportConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link SnmpDeviceProfileTransportConfiguration}
   *   <li>
   * {@link SnmpDeviceProfileTransportConfiguration#setCommunicationConfigs(List)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#setRetries(Integer)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#setTimeoutMs(Integer)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#toString()}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#getCommunicationConfigs()}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#getRetries()}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#getTimeoutMs()}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    SnmpDeviceProfileTransportConfiguration actualSnmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    actualSnmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);
    actualSnmpDeviceProfileTransportConfiguration.setRetries(1);
    actualSnmpDeviceProfileTransportConfiguration.setTimeoutMs(10);
    String actualToStringResult = actualSnmpDeviceProfileTransportConfiguration.toString();
    List<SnmpCommunicationConfig> actualCommunicationConfigs = actualSnmpDeviceProfileTransportConfiguration
        .getCommunicationConfigs();
    Integer actualRetries = actualSnmpDeviceProfileTransportConfiguration.getRetries();
    Integer actualTimeoutMs = actualSnmpDeviceProfileTransportConfiguration.getTimeoutMs();
    DeviceTransportType actualType = actualSnmpDeviceProfileTransportConfiguration.getType();

    // Assert that nothing has changed
    assertEquals("SnmpDeviceProfileTransportConfiguration(timeoutMs=10, retries=1, communicationConfigs=[])",
        actualToStringResult);
    assertEquals(1, actualRetries.intValue());
    assertEquals(10, actualTimeoutMs.intValue());
    assertEquals(DeviceTransportType.SNMP, actualType);
    assertTrue(actualCommunicationConfigs.isEmpty());
    assertSame(communicationConfigs, actualCommunicationConfigs);
  }
}
