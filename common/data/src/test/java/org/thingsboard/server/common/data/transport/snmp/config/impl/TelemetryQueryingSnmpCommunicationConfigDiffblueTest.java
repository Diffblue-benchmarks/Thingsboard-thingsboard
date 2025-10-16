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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.transport.snmp.SnmpCommunicationSpec;
import org.thingsboard.server.common.data.transport.snmp.SnmpMapping;

class TelemetryQueryingSnmpCommunicationConfigDiffblueTest {
  /**
   * Test {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}, and {@link
   * TelemetryQueryingSnmpCommunicationConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryQueryingSnmpCommunicationConfig.equals(Object)",
    "int TelemetryQueryingSnmpCommunicationConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig =
        new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig2 =
        new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig2.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig2.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertEquals(
        telemetryQueryingSnmpCommunicationConfig, telemetryQueryingSnmpCommunicationConfig2);
    assertEquals(
        telemetryQueryingSnmpCommunicationConfig.hashCode(),
        telemetryQueryingSnmpCommunicationConfig2.hashCode());
  }

  /**
   * Test {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}, and {@link
   * TelemetryQueryingSnmpCommunicationConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryQueryingSnmpCommunicationConfig.equals(Object)",
    "int TelemetryQueryingSnmpCommunicationConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig =
        new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertEquals(
        telemetryQueryingSnmpCommunicationConfig, telemetryQueryingSnmpCommunicationConfig);
    int expectedHashCodeResult = telemetryQueryingSnmpCommunicationConfig.hashCode();
    assertEquals(expectedHashCodeResult, telemetryQueryingSnmpCommunicationConfig.hashCode());
  }

  /**
   * Test {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryQueryingSnmpCommunicationConfig.equals(Object)",
    "int TelemetryQueryingSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig =
        new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(mappings);
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig2 =
        new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig2.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig2.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(
        telemetryQueryingSnmpCommunicationConfig, telemetryQueryingSnmpCommunicationConfig2);
  }

  /**
   * Test {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryQueryingSnmpCommunicationConfig.equals(Object)",
    "int TelemetryQueryingSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig =
        new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(telemetryQueryingSnmpCommunicationConfig, null);
  }

  /**
   * Test {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryQueryingSnmpCommunicationConfig.equals(Object)",
    "int TelemetryQueryingSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig =
        new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(
        telemetryQueryingSnmpCommunicationConfig,
        "Different type to TelemetryQueryingSnmpCommunicationConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TelemetryQueryingSnmpCommunicationConfig}
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#toString()}
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#getSpec()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TelemetryQueryingSnmpCommunicationConfig.<init>()",
    "SnmpCommunicationSpec TelemetryQueryingSnmpCommunicationConfig.getSpec()",
    "String TelemetryQueryingSnmpCommunicationConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TelemetryQueryingSnmpCommunicationConfig actualTelemetryQueryingSnmpCommunicationConfig =
        new TelemetryQueryingSnmpCommunicationConfig();
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
