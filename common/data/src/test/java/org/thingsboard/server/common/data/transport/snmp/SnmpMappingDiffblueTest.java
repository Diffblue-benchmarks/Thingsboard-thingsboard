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
package org.thingsboard.server.common.data.transport.snmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.DataType;

class SnmpMappingDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpMapping#equals(Object)}
   *   <li>{@link SnmpMapping#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link SnmpMapping#isValid()}
   */
  @Test
  void testIsValid() {
    // Arrange, Act and Assert
    assertFalse((new SnmpMapping("Oid", "Key", DataType.BOOLEAN)).isValid());
    assertTrue((new SnmpMapping("0.0.0", "Key", DataType.BOOLEAN)).isValid());
    assertFalse((new SnmpMapping("0.0.0", "", DataType.BOOLEAN)).isValid());
  }

  /**
   * Method under test: {@link SnmpMapping#isValid()}
   */
  @Test
  void testIsValid2() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);
    snmpMapping.setOid(null);
    snmpMapping.setKey(null);

    // Act and Assert
    assertFalse(snmpMapping.isValid());
  }

  /**
   * Method under test: {@link SnmpMapping#isValid()}
   */
  @Test
  void testIsValid3() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);
    snmpMapping.setOid("");
    snmpMapping.setKey(null);

    // Act and Assert
    assertFalse(snmpMapping.isValid());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpMapping#equals(Object)}
   *   <li>{@link SnmpMapping#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpMapping#equals(Object)}
   *   <li>{@link SnmpMapping#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpMapping#equals(Object)}
   *   <li>{@link SnmpMapping#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpMapping#equals(Object)}
   *   <li>{@link SnmpMapping#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);

    // Act and Assert
    assertEquals(snmpMapping, snmpMapping);
    int expectedHashCodeResult = snmpMapping.hashCode();
    assertEquals(expectedHashCodeResult, snmpMapping.hashCode());
  }

  /**
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Key", "Key", DataType.BOOLEAN);

    // Act and Assert
    assertNotEquals(snmpMapping, new SnmpMapping("Oid", "Key", DataType.BOOLEAN));
  }

  /**
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping(null, "Key", DataType.BOOLEAN);

    // Act and Assert
    assertNotEquals(snmpMapping, new SnmpMapping("Oid", "Key", DataType.BOOLEAN));
  }

  /**
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Oid", DataType.BOOLEAN);

    // Act and Assert
    assertNotEquals(snmpMapping, new SnmpMapping("Oid", "Key", DataType.BOOLEAN));
  }

  /**
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", null, DataType.BOOLEAN);

    // Act and Assert
    assertNotEquals(snmpMapping, new SnmpMapping("Oid", "Key", DataType.BOOLEAN));
  }

  /**
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", null);

    // Act and Assert
    assertNotEquals(snmpMapping, new SnmpMapping("Oid", "Key", DataType.BOOLEAN));
  }

  /**
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.LONG);

    // Act and Assert
    assertNotEquals(snmpMapping, new SnmpMapping("Oid", "Key", DataType.BOOLEAN));
  }

  /**
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SnmpMapping("Oid", "Key", DataType.BOOLEAN), null);
  }

  /**
   * Method under test: {@link SnmpMapping#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SnmpMapping("Oid", "Key", DataType.BOOLEAN), "Different type to SnmpMapping");
  }

  /**
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
  void testGettersAndSetters2() {
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
