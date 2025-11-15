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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.transport.snmp.SnmpMapping;
import org.thingsboard.server.common.data.transport.snmp.SnmpMethod;
import org.thingsboard.server.common.data.transport.snmp.config.impl.ClientAttributesQueryingSnmpCommunicationConfig;
import org.thingsboard.server.common.data.transport.snmp.config.impl.TelemetryQueryingSnmpCommunicationConfig;

class RepeatingQueryingSnmpCommunicationConfigDiffblueTest {
  /**
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new ClientAttributesQueryingSnmpCommunicationConfig()).canEqual("Other"));
  }

  /**
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#getMethod()}
   */
  @Test
  void testGetMethod() {
    // Arrange, Act and Assert
    assertEquals(SnmpMethod.GET, (new ClientAttributesQueryingSnmpCommunicationConfig()).getMethod());
  }

  /**
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid() {
    // Arrange, Act and Assert
    assertFalse((new ClientAttributesQueryingSnmpCommunicationConfig()).isValid());
  }

  /**
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid2() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(0L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid3() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid4() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid5() {
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
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid6() {
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
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid7() {
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
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid8() {
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
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid9() {
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
   * Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  void testIsValid10() {
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
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();

    // Act and Assert
    assertTrue(clientAttributesQueryingSnmpCommunicationConfig
        .canEqual(new ClientAttributesQueryingSnmpCommunicationConfig()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();

    // Act and Assert
    assertEquals(clientAttributesQueryingSnmpCommunicationConfig, clientAttributesQueryingSnmpCommunicationConfig);
    int expectedHashCodeResult = clientAttributesQueryingSnmpCommunicationConfig.hashCode();
    assertEquals(expectedHashCodeResult, clientAttributesQueryingSnmpCommunicationConfig.hashCode());
  }

  /**
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig = new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(new ArrayList<>());

    // Act and Assert
    assertNotEquals(clientAttributesQueryingSnmpCommunicationConfig, toServerRpcRequestSnmpCommunicationConfig);
  }

  /**
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
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
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new ClientAttributesQueryingSnmpCommunicationConfig(),
        mock(ToServerRpcRequestSnmpCommunicationConfig.class));
  }

  /**
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(clientAttributesQueryingSnmpCommunicationConfig,
        new ClientAttributesQueryingSnmpCommunicationConfig());
  }

  /**
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());

    // Act and Assert
    assertNotEquals(clientAttributesQueryingSnmpCommunicationConfig,
        new ClientAttributesQueryingSnmpCommunicationConfig());
  }

  /**
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();

    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig2 = new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig2.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(clientAttributesQueryingSnmpCommunicationConfig, clientAttributesQueryingSnmpCommunicationConfig2);
  }

  /**
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClientAttributesQueryingSnmpCommunicationConfig(), null);
  }

  /**
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClientAttributesQueryingSnmpCommunicationConfig(),
        "Different type to RepeatingQueryingSnmpCommunicationConfig");
  }

  /**
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#getQueryingFrequencyMs()}
   */
  @Test
  void testGetQueryingFrequencyMs() {
    // Arrange, Act and Assert
    assertNull((new ClientAttributesQueryingSnmpCommunicationConfig()).getQueryingFrequencyMs());
  }

  /**
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#setQueryingFrequencyMs(Long)}
   */
  @Test
  void testSetQueryingFrequencyMs() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = new ClientAttributesQueryingSnmpCommunicationConfig();

    // Act
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Assert
    assertEquals(1L, clientAttributesQueryingSnmpCommunicationConfig.getQueryingFrequencyMs().longValue());
  }

  /**
   * Method under test:
   * {@link RepeatingQueryingSnmpCommunicationConfig#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("RepeatingQueryingSnmpCommunicationConfig(queryingFrequencyMs=null)",
        (new ClientAttributesQueryingSnmpCommunicationConfig()).toString());
  }
}
