package org.thingsboard.server.common.data.transport.snmp.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.transport.snmp.SnmpMapping;
import org.thingsboard.server.common.data.transport.snmp.SnmpMethod;
import org.thingsboard.server.common.data.transport.snmp.config.impl.ClientAttributesQueryingSnmpCommunicationConfig;
import org.thingsboard.server.common.data.transport.snmp.config.impl.TelemetryQueryingSnmpCommunicationConfig;

class RepeatingQueryingSnmpCommunicationConfigDiffblueTest {
  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#getMethod()}.
   * <p>
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#getMethod()}
   */
  @Test
  @DisplayName("Test getMethod()")
  void testGetMethod() {
    // Arrange, Act and Assert
    assertEquals(SnmpMethod.GET, (new ClientAttributesQueryingSnmpCommunicationConfig()).getMethod());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   * <p>
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  void testIsValid() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(0L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   * <p>
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  void testIsValid2() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   * <p>
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  void testIsValid3() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   * <p>
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  void testIsValid4() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("0.0.0", "0.0.0", DataType.BOOLEAN));
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(mappings);
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   * <p>
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  void testIsValid5() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("0.0.0", null, DataType.BOOLEAN));
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(mappings);
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); given ArrayList() add 'null'; then return 'false'")
  void testIsValid_givenArrayListAddNull_thenReturnFalse() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(null);

    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(mappings);
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link SnmpMapping#SnmpMapping(String, String, DataType)} with {@code Oid}
   * and {@code Key} and dataType is {@code BOOLEAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); given ArrayList() add SnmpMapping(String, String, DataType) with 'Oid' and 'Key' and dataType is 'BOOLEAN'")
  void testIsValid_givenArrayListAddSnmpMappingWithOidAndKeyAndDataTypeIsBoolean() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(mappings);
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link SnmpMapping#SnmpMapping(String, String, DataType)} with oid is
   * {@code null} and {@code Key} and dataType is {@code BOOLEAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); given ArrayList() add SnmpMapping(String, String, DataType) with oid is 'null' and 'Key' and dataType is 'BOOLEAN'")
  void testIsValid_givenArrayListAddSnmpMappingWithOidIsNullAndKeyAndDataTypeIsBoolean() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping(null, "Key", DataType.BOOLEAN));

    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(mappings);
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   * <ul>
   *   <li>Given {@link ClientAttributesQueryingSnmpCommunicationConfig} (default
   * constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); given ClientAttributesQueryingSnmpCommunicationConfig (default constructor); then return 'false'")
  void testIsValid_givenClientAttributesQueryingSnmpCommunicationConfig_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ClientAttributesQueryingSnmpCommunicationConfig()).isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then return 'true'")
  void testIsValid_thenReturnTrue() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("0.0.0", "Key", DataType.BOOLEAN));

    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(mappings);
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertTrue(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#canEqual(Object)}.
   * <ul>
   *   <li>When {@link ClientAttributesQueryingSnmpCommunicationConfig} (default
   * constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when ClientAttributesQueryingSnmpCommunicationConfig (default constructor); then return 'true'")
  void testCanEqual_whenClientAttributesQueryingSnmpCommunicationConfig_thenReturnTrue() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();

    // Act and Assert
    assertTrue(clientAttributesQueryingSnmpCommunicationConfig
        .canEqual(new ClientAttributesQueryingSnmpCommunicationConfig()));
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ClientAttributesQueryingSnmpCommunicationConfig()).canEqual("Other"));
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}, and
   * {@link RepeatingQueryingSnmpCommunicationConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig2 = new ClientAttributesQueryingSnmpCommunicationConfig();

    // Act and Assert
    assertEquals(clientAttributesQueryingSnmpCommunicationConfig, clientAttributesQueryingSnmpCommunicationConfig2);
    int expectedHashCodeResult = clientAttributesQueryingSnmpCommunicationConfig.hashCode();
    assertEquals(expectedHashCodeResult, clientAttributesQueryingSnmpCommunicationConfig2.hashCode());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}, and
   * {@link RepeatingQueryingSnmpCommunicationConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig2 = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig2.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertEquals(clientAttributesQueryingSnmpCommunicationConfig, clientAttributesQueryingSnmpCommunicationConfig2);
    int expectedHashCodeResult = clientAttributesQueryingSnmpCommunicationConfig.hashCode();
    assertEquals(expectedHashCodeResult, clientAttributesQueryingSnmpCommunicationConfig2.hashCode());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}, and
   * {@link RepeatingQueryingSnmpCommunicationConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();

    // Act and Assert
    assertEquals(clientAttributesQueryingSnmpCommunicationConfig, clientAttributesQueryingSnmpCommunicationConfig);
    int expectedHashCodeResult = clientAttributesQueryingSnmpCommunicationConfig.hashCode();
    assertEquals(expectedHashCodeResult, clientAttributesQueryingSnmpCommunicationConfig.hashCode());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(new ArrayList<>());

    // Act and Assert
    assertNotEquals(clientAttributesQueryingSnmpCommunicationConfig, toServerRpcRequestSnmpCommunicationConfig);
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();

    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(clientAttributesQueryingSnmpCommunicationConfig, telemetryQueryingSnmpCommunicationConfig);
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new ClientAttributesQueryingSnmpCommunicationConfig(),
        mock(ToServerRpcRequestSnmpCommunicationConfig.class));
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(clientAttributesQueryingSnmpCommunicationConfig,
        new ClientAttributesQueryingSnmpCommunicationConfig());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());

    // Act and Assert
    assertNotEquals(clientAttributesQueryingSnmpCommunicationConfig,
        new ClientAttributesQueryingSnmpCommunicationConfig());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();

    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig2 = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig2.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(clientAttributesQueryingSnmpCommunicationConfig, clientAttributesQueryingSnmpCommunicationConfig2);
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClientAttributesQueryingSnmpCommunicationConfig(), null);
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClientAttributesQueryingSnmpCommunicationConfig(),
        "Different type to RepeatingQueryingSnmpCommunicationConfig");
  }

  /**
   * Test
   * {@link RepeatingQueryingSnmpCommunicationConfig#getQueryingFrequencyMs()}.
   * <p>
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#getQueryingFrequencyMs()}
   */
  @Test
  @DisplayName("Test getQueryingFrequencyMs()")
  void testGetQueryingFrequencyMs() {
    // Arrange, Act and Assert
    assertNull((new ClientAttributesQueryingSnmpCommunicationConfig()).getQueryingFrequencyMs());
  }

  /**
   * Test
   * {@link RepeatingQueryingSnmpCommunicationConfig#setQueryingFrequencyMs(Long)}.
   * <p>
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#setQueryingFrequencyMs(Long)}
   */
  @Test
  @DisplayName("Test setQueryingFrequencyMs(Long)")
  void testSetQueryingFrequencyMs() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();

    // Act
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Assert
    assertEquals(1L, clientAttributesQueryingSnmpCommunicationConfig.getQueryingFrequencyMs().longValue());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#toString()}.
   * <p>
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("RepeatingQueryingSnmpCommunicationConfig(queryingFrequencyMs=null)",
        (new ClientAttributesQueryingSnmpCommunicationConfig()).toString());
  }
}
