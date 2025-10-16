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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.transport.snmp.SnmpMapping;
import org.thingsboard.server.common.data.transport.snmp.SnmpMethod;
import org.thingsboard.server.common.data.transport.snmp.config.impl.ClientAttributesQueryingSnmpCommunicationConfig;
import org.thingsboard.server.common.data.transport.snmp.config.impl.TelemetryQueryingSnmpCommunicationConfig;

class RepeatingQueryingSnmpCommunicationConfigDiffblueTest {
  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#getMethod()}.
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#getMethod()}
   */
  @Test
  @DisplayName("Test getMethod()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SnmpMethod RepeatingQueryingSnmpCommunicationConfig.getMethod()"})
  void testGetMethod() {
    // Arrange, Act and Assert
    assertEquals(SnmpMethod.GET, new ClientAttributesQueryingSnmpCommunicationConfig().getMethod());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RepeatingQueryingSnmpCommunicationConfig.isValid()"})
  void testIsValid() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(0L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RepeatingQueryingSnmpCommunicationConfig.isValid()"})
  void testIsValid2() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RepeatingQueryingSnmpCommunicationConfig.isValid()"})
  void testIsValid3() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RepeatingQueryingSnmpCommunicationConfig.isValid()"})
  void testIsValid4() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("0.0.0", "0.0.0", DataType.BOOLEAN));
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(mappings);
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RepeatingQueryingSnmpCommunicationConfig.isValid()"})
  void testIsValid5() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    SnmpMapping snmpMapping = new SnmpMapping("0.0.0", null, DataType.BOOLEAN);
    mappings.add(snmpMapping);
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(mappings);
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); given ArrayList() add 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RepeatingQueryingSnmpCommunicationConfig.isValid()"})
  void testIsValid_givenArrayListAddNull_thenReturnFalse() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(null);

    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(mappings);
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SnmpMapping#SnmpMapping(String, String,
   *       DataType)} with {@code Oid} and {@code Key} and dataType is {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName(
      "Test isValid(); given ArrayList() add SnmpMapping(String, String, DataType) with 'Oid' and 'Key' and dataType is 'BOOLEAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RepeatingQueryingSnmpCommunicationConfig.isValid()"})
  void testIsValid_givenArrayListAddSnmpMappingWithOidAndKeyAndDataTypeIsBoolean() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(mappings);
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SnmpMapping#SnmpMapping(String, String,
   *       DataType)} with oid is {@code null} and {@code Key} and dataType is {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName(
      "Test isValid(); given ArrayList() add SnmpMapping(String, String, DataType) with oid is 'null' and 'Key' and dataType is 'BOOLEAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RepeatingQueryingSnmpCommunicationConfig.isValid()"})
  void testIsValid_givenArrayListAddSnmpMappingWithOidIsNullAndKeyAndDataTypeIsBoolean() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping(null, "Key", DataType.BOOLEAN));

    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(mappings);
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertFalse(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   *
   * <ul>
   *   <li>Given {@link ClientAttributesQueryingSnmpCommunicationConfig} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName(
      "Test isValid(); given ClientAttributesQueryingSnmpCommunicationConfig (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RepeatingQueryingSnmpCommunicationConfig.isValid()"})
  void testIsValid_givenClientAttributesQueryingSnmpCommunicationConfig_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ClientAttributesQueryingSnmpCommunicationConfig().isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RepeatingQueryingSnmpCommunicationConfig.isValid()"})
  void testIsValid_thenReturnTrue() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("0.0.0", "Key", DataType.BOOLEAN));

    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(mappings);
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertTrue(clientAttributesQueryingSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link ClientAttributesQueryingSnmpCommunicationConfig} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#canEqual(Object)}
   */
  @Test
  @DisplayName(
      "Test canEqual(Object); when ClientAttributesQueryingSnmpCommunicationConfig (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RepeatingQueryingSnmpCommunicationConfig.canEqual(Object)"})
  void testCanEqual_whenClientAttributesQueryingSnmpCommunicationConfig_thenReturnTrue() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();

    // Act and Assert
    assertTrue(
        clientAttributesQueryingSnmpCommunicationConfig.canEqual(
            new ClientAttributesQueryingSnmpCommunicationConfig()));
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RepeatingQueryingSnmpCommunicationConfig.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ClientAttributesQueryingSnmpCommunicationConfig().canEqual("Other"));
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}, and {@link
   * RepeatingQueryingSnmpCommunicationConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RepeatingQueryingSnmpCommunicationConfig.equals(Object)",
    "int RepeatingQueryingSnmpCommunicationConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig2 =
            new ClientAttributesQueryingSnmpCommunicationConfig();

    // Act and Assert
    assertEquals(
        clientAttributesQueryingSnmpCommunicationConfig,
        clientAttributesQueryingSnmpCommunicationConfig2);
    assertEquals(
        clientAttributesQueryingSnmpCommunicationConfig.hashCode(),
        clientAttributesQueryingSnmpCommunicationConfig2.hashCode());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}, and {@link
   * RepeatingQueryingSnmpCommunicationConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RepeatingQueryingSnmpCommunicationConfig.equals(Object)",
    "int RepeatingQueryingSnmpCommunicationConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig2 =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig2.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertEquals(
        clientAttributesQueryingSnmpCommunicationConfig,
        clientAttributesQueryingSnmpCommunicationConfig2);
    assertEquals(
        clientAttributesQueryingSnmpCommunicationConfig.hashCode(),
        clientAttributesQueryingSnmpCommunicationConfig2.hashCode());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}, and {@link
   * RepeatingQueryingSnmpCommunicationConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link RepeatingQueryingSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RepeatingQueryingSnmpCommunicationConfig.equals(Object)",
    "int RepeatingQueryingSnmpCommunicationConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();

    // Act and Assert
    assertEquals(
        clientAttributesQueryingSnmpCommunicationConfig,
        clientAttributesQueryingSnmpCommunicationConfig);
    int expectedHashCodeResult = clientAttributesQueryingSnmpCommunicationConfig.hashCode();
    assertEquals(
        expectedHashCodeResult, clientAttributesQueryingSnmpCommunicationConfig.hashCode());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RepeatingQueryingSnmpCommunicationConfig.equals(Object)",
    "int RepeatingQueryingSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        clientAttributesQueryingSnmpCommunicationConfig, toServerRpcRequestSnmpCommunicationConfig);
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RepeatingQueryingSnmpCommunicationConfig.equals(Object)",
    "int RepeatingQueryingSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();

    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig =
        new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(
        clientAttributesQueryingSnmpCommunicationConfig, telemetryQueryingSnmpCommunicationConfig);
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RepeatingQueryingSnmpCommunicationConfig.equals(Object)",
    "int RepeatingQueryingSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(
        clientAttributesQueryingSnmpCommunicationConfig,
        new ClientAttributesQueryingSnmpCommunicationConfig());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RepeatingQueryingSnmpCommunicationConfig.equals(Object)",
    "int RepeatingQueryingSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        clientAttributesQueryingSnmpCommunicationConfig,
        new ClientAttributesQueryingSnmpCommunicationConfig());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RepeatingQueryingSnmpCommunicationConfig.equals(Object)",
    "int RepeatingQueryingSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();

    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig2 =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig2.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(
        clientAttributesQueryingSnmpCommunicationConfig,
        clientAttributesQueryingSnmpCommunicationConfig2);
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RepeatingQueryingSnmpCommunicationConfig.equals(Object)",
    "int RepeatingQueryingSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClientAttributesQueryingSnmpCommunicationConfig(), null);
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RepeatingQueryingSnmpCommunicationConfig.equals(Object)",
    "int RepeatingQueryingSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ClientAttributesQueryingSnmpCommunicationConfig(),
        "Different type to RepeatingQueryingSnmpCommunicationConfig");
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#getQueryingFrequencyMs()}.
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#getQueryingFrequencyMs()}
   */
  @Test
  @DisplayName("Test getQueryingFrequencyMs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long RepeatingQueryingSnmpCommunicationConfig.getQueryingFrequencyMs()"})
  void testGetQueryingFrequencyMs() {
    // Arrange, Act and Assert
    assertNull(new ClientAttributesQueryingSnmpCommunicationConfig().getQueryingFrequencyMs());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#setQueryingFrequencyMs(Long)}.
   *
   * <p>Method under test: {@link
   * RepeatingQueryingSnmpCommunicationConfig#setQueryingFrequencyMs(Long)}
   */
  @Test
  @DisplayName("Test setQueryingFrequencyMs(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RepeatingQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(Long)"})
  void testSetQueryingFrequencyMs() {
    // Arrange
    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();

    // Act
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Assert
    assertEquals(
        1L, clientAttributesQueryingSnmpCommunicationConfig.getQueryingFrequencyMs().longValue());
  }

  /**
   * Test {@link RepeatingQueryingSnmpCommunicationConfig#toString()}.
   *
   * <p>Method under test: {@link RepeatingQueryingSnmpCommunicationConfig#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RepeatingQueryingSnmpCommunicationConfig.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "RepeatingQueryingSnmpCommunicationConfig(queryingFrequencyMs=null)",
        new ClientAttributesQueryingSnmpCommunicationConfig().toString());
  }
}
