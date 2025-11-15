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
package org.thingsboard.server.common.data.transport.snmp.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.transport.snmp.SnmpMapping;
import org.thingsboard.server.common.data.transport.snmp.config.impl.ClientAttributesQueryingSnmpCommunicationConfig;
import org.thingsboard.server.common.data.transport.snmp.config.impl.SharedAttributesSettingSnmpCommunicationConfig;

class MultipleMappingsSnmpCommunicationConfigDiffblueTest {
  /**
   * Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid() {
    // Arrange, Act and Assert
    assertFalse((new ToServerRpcRequestSnmpCommunicationConfig()).isValid());
  }

  /**
   * Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid2() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(new ArrayList<>());

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid3() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);
    snmpMapping.setOid(null);
    snmpMapping.setKey(null);

    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(snmpMapping);

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid4() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);
    snmpMapping.setOid("");
    snmpMapping.setKey(null);

    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(snmpMapping);

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid5() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);
    snmpMapping.setOid("foo");
    snmpMapping.setKey(null);

    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(snmpMapping);

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid6() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(null);

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid7() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);
    snmpMapping.setOid("0.0.0");
    snmpMapping.setKey(null);

    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(snmpMapping);

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid8() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);
    snmpMapping.setOid("0.0.0");
    snmpMapping.setKey(null);

    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("0.0.0", "0.0.0", DataType.BOOLEAN));
    mappings.add(snmpMapping);

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid9() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);
    snmpMapping.setOid("0.0.0");
    snmpMapping.setKey(null);

    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("0.0.0", "", DataType.BOOLEAN));
    mappings.add(snmpMapping);

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid10() {
    // Arrange
    SnmpMapping snmpMapping = new SnmpMapping("Oid", "Key", DataType.BOOLEAN);
    snmpMapping.setOid("0.0.0");
    snmpMapping.setKey("0.0.0");

    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(snmpMapping);

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertTrue(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Method under test:
   * {@link MultipleMappingsSnmpCommunicationConfig#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new ToServerRpcRequestSnmpCommunicationConfig()).canEqual("Other"));
  }

  /**
   * Method under test:
   * {@link MultipleMappingsSnmpCommunicationConfig#getAllMappings()}
   */
  @Test
  void testGetAllMappings() {
    // Arrange, Act and Assert
    assertNull((new ToServerRpcRequestSnmpCommunicationConfig()).getAllMappings());
  }

  /**
   * Method under test:
   * {@link MultipleMappingsSnmpCommunicationConfig#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();

    // Act and Assert
    assertTrue(toServerRpcRequestSnmpCommunicationConfig.canEqual(new ToServerRpcRequestSnmpCommunicationConfig()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link MultipleMappingsSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig2 = new ToServerRpcRequestSnmpCommunicationConfig();

    // Act and Assert
    assertEquals(toServerRpcRequestSnmpCommunicationConfig, toServerRpcRequestSnmpCommunicationConfig2);
    int expectedHashCodeResult = toServerRpcRequestSnmpCommunicationConfig.hashCode();
    assertEquals(expectedHashCodeResult, toServerRpcRequestSnmpCommunicationConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link MultipleMappingsSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(new ArrayList<>());
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = mock(
        ClientAttributesQueryingSnmpCommunicationConfig.class);
    when(clientAttributesQueryingSnmpCommunicationConfig.getMappings()).thenReturn(new ArrayList<>());
    when(clientAttributesQueryingSnmpCommunicationConfig.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(toServerRpcRequestSnmpCommunicationConfig, clientAttributesQueryingSnmpCommunicationConfig);
    int notExpectedHashCodeResult = toServerRpcRequestSnmpCommunicationConfig.hashCode();
    assertNotEquals(notExpectedHashCodeResult, clientAttributesQueryingSnmpCommunicationConfig.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link MultipleMappingsSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();

    // Act and Assert
    assertEquals(toServerRpcRequestSnmpCommunicationConfig, toServerRpcRequestSnmpCommunicationConfig);
    int expectedHashCodeResult = toServerRpcRequestSnmpCommunicationConfig.hashCode();
    assertEquals(expectedHashCodeResult, toServerRpcRequestSnmpCommunicationConfig.hashCode());
  }

  /**
   * Method under test:
   * {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();

    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(toServerRpcRequestSnmpCommunicationConfig, clientAttributesQueryingSnmpCommunicationConfig);
  }

  /**
   * Method under test:
   * {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();

    SharedAttributesSettingSnmpCommunicationConfig sharedAttributesSettingSnmpCommunicationConfig = new SharedAttributesSettingSnmpCommunicationConfig();
    sharedAttributesSettingSnmpCommunicationConfig.setMappings(new ArrayList<>());

    // Act and Assert
    assertNotEquals(toServerRpcRequestSnmpCommunicationConfig, sharedAttributesSettingSnmpCommunicationConfig);
  }

  /**
   * Method under test:
   * {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = mock(
        ClientAttributesQueryingSnmpCommunicationConfig.class);
    when(clientAttributesQueryingSnmpCommunicationConfig.getMappings()).thenReturn(new ArrayList<>());
    when(clientAttributesQueryingSnmpCommunicationConfig.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(toServerRpcRequestSnmpCommunicationConfig, clientAttributesQueryingSnmpCommunicationConfig);
  }

  /**
   * Method under test:
   * {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = mock(
        ClientAttributesQueryingSnmpCommunicationConfig.class);
    when(clientAttributesQueryingSnmpCommunicationConfig.getMappings()).thenReturn(new ArrayList<>());
    when(clientAttributesQueryingSnmpCommunicationConfig.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(toServerRpcRequestSnmpCommunicationConfig, clientAttributesQueryingSnmpCommunicationConfig);
  }

  /**
   * Method under test:
   * {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ToServerRpcRequestSnmpCommunicationConfig(), null);
  }

  /**
   * Method under test:
   * {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ToServerRpcRequestSnmpCommunicationConfig(),
        "Different type to MultipleMappingsSnmpCommunicationConfig");
  }

  /**
   * Method under test:
   * {@link MultipleMappingsSnmpCommunicationConfig#getMappings()}
   */
  @Test
  void testGetMappings() {
    // Arrange, Act and Assert
    assertNull((new ToServerRpcRequestSnmpCommunicationConfig()).getMappings());
  }

  /**
   * Method under test:
   * {@link MultipleMappingsSnmpCommunicationConfig#setMappings(List)}
   */
  @Test
  void testSetMappings() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    ArrayList<SnmpMapping> mappings = new ArrayList<>();

    // Act
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Assert
    assertSame(mappings, toServerRpcRequestSnmpCommunicationConfig.getAllMappings());
    assertSame(mappings, toServerRpcRequestSnmpCommunicationConfig.getMappings());
  }

  /**
   * Method under test:
   * {@link MultipleMappingsSnmpCommunicationConfig#setMappings(List)}
   */
  @Test
  void testSetMappings2() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();

    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    // Act
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Assert
    assertSame(mappings, toServerRpcRequestSnmpCommunicationConfig.getAllMappings());
    assertSame(mappings, toServerRpcRequestSnmpCommunicationConfig.getMappings());
  }

  /**
   * Method under test:
   * {@link MultipleMappingsSnmpCommunicationConfig#setMappings(List)}
   */
  @Test
  void testSetMappings3() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();

    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    // Act
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Assert
    assertSame(mappings, toServerRpcRequestSnmpCommunicationConfig.getAllMappings());
    assertSame(mappings, toServerRpcRequestSnmpCommunicationConfig.getMappings());
  }

  /**
   * Method under test: {@link MultipleMappingsSnmpCommunicationConfig#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("MultipleMappingsSnmpCommunicationConfig(mappings=null)",
        (new ToServerRpcRequestSnmpCommunicationConfig()).toString());
  }

  /**
   * Method under test: {@link MultipleMappingsSnmpCommunicationConfig#toString()}
   */
  @Test
  void testToString2() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertEquals("MultipleMappingsSnmpCommunicationConfig(mappings=[SnmpMapping(oid=Oid, key=Key, dataType=BOOLEAN)])",
        toServerRpcRequestSnmpCommunicationConfig.toString());
  }

  /**
   * Method under test: {@link MultipleMappingsSnmpCommunicationConfig#toString()}
   */
  @Test
  void testToString3() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertEquals(
        "MultipleMappingsSnmpCommunicationConfig(mappings=[SnmpMapping(oid=Oid, key=Key, dataType=BOOLEAN),"
            + " SnmpMapping(oid=Oid, key=Key, dataType=BOOLEAN)])",
        toServerRpcRequestSnmpCommunicationConfig.toString());
  }
}
