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
package org.thingsboard.server.common.data.transport.snmp.config.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.transport.snmp.SnmpCommunicationSpec;
import org.thingsboard.server.common.data.transport.snmp.SnmpMapping;

class TelemetryQueryingSnmpCommunicationConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig2 = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig2.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig2.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertEquals(telemetryQueryingSnmpCommunicationConfig, telemetryQueryingSnmpCommunicationConfig2);
    int expectedHashCodeResult = telemetryQueryingSnmpCommunicationConfig.hashCode();
    assertEquals(expectedHashCodeResult, telemetryQueryingSnmpCommunicationConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertEquals(telemetryQueryingSnmpCommunicationConfig, telemetryQueryingSnmpCommunicationConfig);
    int expectedHashCodeResult = telemetryQueryingSnmpCommunicationConfig.hashCode();
    assertEquals(expectedHashCodeResult, telemetryQueryingSnmpCommunicationConfig.hashCode());
  }

  /**
   * Method under test:
   * {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(mappings);
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig2 = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig2.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig2.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(telemetryQueryingSnmpCommunicationConfig, telemetryQueryingSnmpCommunicationConfig2);
  }

  /**
   * Method under test:
   * {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);
    ClientAttributesQueryingSnmpCommunicationConfig clientAttributesQueryingSnmpCommunicationConfig = mock(
        ClientAttributesQueryingSnmpCommunicationConfig.class);
    doNothing().when(clientAttributesQueryingSnmpCommunicationConfig).setMappings(Mockito.<List<SnmpMapping>>any());
    doNothing().when(clientAttributesQueryingSnmpCommunicationConfig).setQueryingFrequencyMs(Mockito.<Long>any());
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(telemetryQueryingSnmpCommunicationConfig, clientAttributesQueryingSnmpCommunicationConfig);
  }

  /**
   * Method under test:
   * {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(telemetryQueryingSnmpCommunicationConfig, null);
  }

  /**
   * Method under test:
   * {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(telemetryQueryingSnmpCommunicationConfig,
        "Different type to TelemetryQueryingSnmpCommunicationConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TelemetryQueryingSnmpCommunicationConfig}
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#toString()}
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#getSpec()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TelemetryQueryingSnmpCommunicationConfig actualTelemetryQueryingSnmpCommunicationConfig = new TelemetryQueryingSnmpCommunicationConfig();
    String actualToStringResult = actualTelemetryQueryingSnmpCommunicationConfig.toString();
    SnmpCommunicationSpec actualSpec = actualTelemetryQueryingSnmpCommunicationConfig.getSpec();

    // Assert
    assertEquals("TelemetryQueryingSnmpCommunicationConfig()", actualToStringResult);
    assertNull(actualTelemetryQueryingSnmpCommunicationConfig.getQueryingFrequencyMs());
    assertNull(actualTelemetryQueryingSnmpCommunicationConfig.getAllMappings());
    assertNull(actualTelemetryQueryingSnmpCommunicationConfig.getMappings());
    assertEquals(SnmpCommunicationSpec.TELEMETRY_QUERYING, actualSpec);
  }
}
