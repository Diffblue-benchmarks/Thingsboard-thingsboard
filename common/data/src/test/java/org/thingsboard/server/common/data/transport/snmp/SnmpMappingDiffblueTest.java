package org.thingsboard.server.common.data.transport.snmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.DataType;

class SnmpMappingDiffblueTest {
  /**
   * Test {@link SnmpMapping#isValid()}.
   * <ul>
   *   <li>Given {@link SnmpMapping#SnmpMapping(String, String, DataType)} with
   * {@code Oid} and {@code Key} and dataType is {@code BOOLEAN} Oid is empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpMapping#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); given SnmpMapping(String, String, DataType) with 'Oid' and 'Key' and dataType is 'BOOLEAN' Oid is empty string")
  void testIsValid_givenSnmpMappingWithOidAndKeyAndDataTypeIsBooleanOidIsEmptyString() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);
    snmpMapping.setOid("");
    snmpMapping.setKey(null);

    // Act and Assert
    assertFalse(snmpMapping.isValid());
  }

  /**
   * Test {@link SnmpMapping#isValid()}.
   * <ul>
   *   <li>Given {@link SnmpMapping#SnmpMapping(String, String, DataType)} with
   * {@code Oid} and {@code Key} and dataType is {@code BOOLEAN} Oid is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpMapping#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); given SnmpMapping(String, String, DataType) with 'Oid' and 'Key' and dataType is 'BOOLEAN' Oid is 'null'")
  void testIsValid_givenSnmpMappingWithOidAndKeyAndDataTypeIsBooleanOidIsNull() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);
    snmpMapping.setOid(null);
    snmpMapping.setKey(null);

    // Act and Assert
    assertFalse(snmpMapping.isValid());
  }

  /**
   * Test {@link SnmpMapping#isValid()}.
   * <ul>
   *   <li>Given {@link SnmpMapping#SnmpMapping(String, String, DataType)} with
   * {@code Oid} and {@code Key} and dataType is {@code BOOLEAN}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpMapping#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); given SnmpMapping(String, String, DataType) with 'Oid' and 'Key' and dataType is 'BOOLEAN'; then return 'false'")
  void testIsValid_givenSnmpMappingWithOidAndKeyAndDataTypeIsBoolean_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SnmpMapping("Oid", "Key", DataType.BOOLEAN)).isValid());
  }

  /**
   * Test {@link SnmpMapping#isValid()}.
   * <ul>
   *   <li>Given {@link SnmpMapping#SnmpMapping(String, String, DataType)} with oid
   * is {@code 0.0.0} and key is empty string and dataType is
   * {@code BOOLEAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpMapping#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); given SnmpMapping(String, String, DataType) with oid is '0.0.0' and key is empty string and dataType is 'BOOLEAN'")
  void testIsValid_givenSnmpMappingWithOidIs000AndKeyIsEmptyStringAndDataTypeIsBoolean() {
    // Arrange, Act and Assert
    assertFalse((new SnmpMapping("0.0.0", "", DataType.BOOLEAN)).isValid());
  }

  /**
   * Test {@link SnmpMapping#isValid()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpMapping#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then return 'true'")
  void testIsValid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new SnmpMapping("0.0.0", "Key", DataType.BOOLEAN)).isValid());
  }

  /**
   * Test {@link SnmpMapping#equals(Object)}, and {@link SnmpMapping#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpMapping#equals(Object)}
   *   <li>{@link SnmpMapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);
    SnmpMapping snmpMapping2 = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);

    // Act and Assert
    assertEquals(snmpMapping, snmpMapping2);
    int expectedHashCodeResult = snmpMapping.hashCode();
    assertEquals(expectedHashCodeResult, snmpMapping2.hashCode());
  }

  /**
   * Test {@link SnmpMapping#equals(Object)}, and {@link SnmpMapping#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpMapping#equals(Object)}
   *   <li>{@link SnmpMapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping(null, "Key", DataType.BOOLEAN);
    SnmpMapping snmpMapping2 = new SnmpMapping(null, "Key", DataType.BOOLEAN);

    // Act and Assert
    assertEquals(snmpMapping, snmpMapping2);
    int expectedHashCodeResult = snmpMapping.hashCode();
    assertEquals(expectedHashCodeResult, snmpMapping2.hashCode());
  }

  /**
   * Test {@link SnmpMapping#equals(Object)}, and {@link SnmpMapping#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpMapping#equals(Object)}
   *   <li>{@link SnmpMapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", null, DataType.BOOLEAN);
    SnmpMapping snmpMapping2 = new SnmpMapping("Oid", null, DataType.BOOLEAN);

    // Act and Assert
    assertEquals(snmpMapping, snmpMapping2);
    int expectedHashCodeResult = snmpMapping.hashCode();
    assertEquals(expectedHashCodeResult, snmpMapping2.hashCode());
  }

  /**
   * Test {@link SnmpMapping#equals(Object)}, and {@link SnmpMapping#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpMapping#equals(Object)}
   *   <li>{@link SnmpMapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", null);
    SnmpMapping snmpMapping2 = new SnmpMapping("Oid", "Key", null);

    // Act and Assert
    assertEquals(snmpMapping, snmpMapping2);
    int expectedHashCodeResult = snmpMapping.hashCode();
    assertEquals(expectedHashCodeResult, snmpMapping2.hashCode());
  }

  /**
   * Test {@link SnmpMapping#equals(Object)}, and {@link SnmpMapping#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpMapping#equals(Object)}
   *   <li>{@link SnmpMapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);

    // Act and Assert
    assertEquals(snmpMapping, snmpMapping);
    int expectedHashCodeResult = snmpMapping.hashCode();
    assertEquals(expectedHashCodeResult, snmpMapping.hashCode());
  }

  /**
   * Test {@link SnmpMapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Key", "Key", DataType.BOOLEAN);

    // Act and Assert
    assertNotEquals(snmpMapping, new SnmpMapping("Oid", "Key", DataType.BOOLEAN));
  }

  /**
   * Test {@link SnmpMapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping(null, "Key", DataType.BOOLEAN);

    // Act and Assert
    assertNotEquals(snmpMapping, new SnmpMapping("Oid", "Key", DataType.BOOLEAN));
  }

  /**
   * Test {@link SnmpMapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Oid", DataType.BOOLEAN);

    // Act and Assert
    assertNotEquals(snmpMapping, new SnmpMapping("Oid", "Key", DataType.BOOLEAN));
  }

  /**
   * Test {@link SnmpMapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", null, DataType.BOOLEAN);

    // Act and Assert
    assertNotEquals(snmpMapping, new SnmpMapping("Oid", "Key", DataType.BOOLEAN));
  }

  /**
   * Test {@link SnmpMapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", null);

    // Act and Assert
    assertNotEquals(snmpMapping, new SnmpMapping("Oid", "Key", DataType.BOOLEAN));
  }

  /**
   * Test {@link SnmpMapping#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.LONG);

    // Act and Assert
    assertNotEquals(snmpMapping, new SnmpMapping("Oid", "Key", DataType.BOOLEAN));
  }

  /**
   * Test {@link SnmpMapping#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SnmpMapping("Oid", "Key", DataType.BOOLEAN), null);
  }

  /**
   * Test {@link SnmpMapping#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SnmpMapping("Oid", "Key", DataType.BOOLEAN), "Different type to SnmpMapping");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpMapping#SnmpMapping()}
   *   <li>{@link SnmpMapping#setDataType(DataType)}
   *   <li>{@link SnmpMapping#setKey(String)}
   *   <li>{@link SnmpMapping#setOid(String)}
   *   <li>{@link SnmpMapping#toString()}
   *   <li>{@link SnmpMapping#getDataType()}
   *   <li>{@link SnmpMapping#getKey()}
   *   <li>{@link SnmpMapping#getOid()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    SnmpMapping actualSnmpMapping = new SnmpMapping();
    actualSnmpMapping.setDataType(DataType.BOOLEAN);
    actualSnmpMapping.setKey("Key");
    actualSnmpMapping.setOid("Oid");
    String actualToStringResult = actualSnmpMapping.toString();
    DataType actualDataType = actualSnmpMapping.getDataType();
    String actualKey = actualSnmpMapping.getKey();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals("Oid", actualSnmpMapping.getOid());
    assertEquals("SnmpMapping(oid=Oid, key=Key, dataType=BOOLEAN)", actualToStringResult);
    assertEquals(DataType.BOOLEAN, actualDataType);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Oid}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpMapping#SnmpMapping(String, String, DataType)}
   *   <li>{@link SnmpMapping#setDataType(DataType)}
   *   <li>{@link SnmpMapping#setKey(String)}
   *   <li>{@link SnmpMapping#setOid(String)}
   *   <li>{@link SnmpMapping#toString()}
   *   <li>{@link SnmpMapping#getDataType()}
   *   <li>{@link SnmpMapping#getKey()}
   *   <li>{@link SnmpMapping#getOid()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Oid'")
  void testGettersAndSetters_whenOid() {
    // Arrange and Act
    SnmpMapping actualSnmpMapping = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);
    actualSnmpMapping.setDataType(DataType.BOOLEAN);
    actualSnmpMapping.setKey("Key");
    actualSnmpMapping.setOid("Oid");
    String actualToStringResult = actualSnmpMapping.toString();
    DataType actualDataType = actualSnmpMapping.getDataType();
    String actualKey = actualSnmpMapping.getKey();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals("Oid", actualSnmpMapping.getOid());
    assertEquals("SnmpMapping(oid=Oid, key=Key, dataType=BOOLEAN)", actualToStringResult);
    assertEquals(DataType.BOOLEAN, actualDataType);
  }
}
