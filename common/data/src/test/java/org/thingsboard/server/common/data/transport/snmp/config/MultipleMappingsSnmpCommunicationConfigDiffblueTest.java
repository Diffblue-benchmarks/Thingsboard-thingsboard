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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.transport.snmp.SnmpMapping;
import org.thingsboard.server.common.data.transport.snmp.config.impl.ClientAttributesQueryingSnmpCommunicationConfig;
import org.thingsboard.server.common.data.transport.snmp.config.impl.SharedAttributesSettingSnmpCommunicationConfig;

class MultipleMappingsSnmpCommunicationConfigDiffblueTest {
  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#isValid()}.
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleMappingsSnmpCommunicationConfig.isValid()"})
  void testIsValid() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("not empty", "not blank", DataType.BOOLEAN));

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#isValid()}.
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleMappingsSnmpCommunicationConfig.isValid()"})
  void testIsValid2() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("", "not blank", DataType.BOOLEAN));

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#isValid()}.
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleMappingsSnmpCommunicationConfig.isValid()"})
  void testIsValid3() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping(null, "not blank", DataType.BOOLEAN));

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#isValid()}.
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleMappingsSnmpCommunicationConfig.isValid()"})
  void testIsValid4() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("0.0.0", "0.0.0", DataType.BOOLEAN));
    mappings.add(new SnmpMapping("not empty", "not blank", DataType.BOOLEAN));

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#isValid()}.
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleMappingsSnmpCommunicationConfig.isValid()"})
  void testIsValid5() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    SnmpMapping snmpMapping = new SnmpMapping("0.0.0", null, DataType.BOOLEAN);
    mappings.add(snmpMapping);
    mappings.add(new SnmpMapping("not empty", "not blank", DataType.BOOLEAN));

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#isValid()}.
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleMappingsSnmpCommunicationConfig.isValid()"})
  void testIsValid6() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("0.0.0", "", DataType.BOOLEAN));
    mappings.add(new SnmpMapping("not empty", "not blank", DataType.BOOLEAN));

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#isValid()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); given ArrayList() add 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleMappingsSnmpCommunicationConfig.isValid()"})
  void testIsValid_givenArrayListAddNull_thenReturnFalse() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(null);

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#isValid()}.
   *
   * <ul>
   *   <li>Given {@link ToServerRpcRequestSnmpCommunicationConfig} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName(
      "Test isValid(); given ToServerRpcRequestSnmpCommunicationConfig (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleMappingsSnmpCommunicationConfig.isValid()"})
  void testIsValid_givenToServerRpcRequestSnmpCommunicationConfig_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ToServerRpcRequestSnmpCommunicationConfig().isValid());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#isValid()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleMappingsSnmpCommunicationConfig.isValid()"})
  void testIsValid_thenReturnFalse() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(new ArrayList<>());

    // Act and Assert
    assertFalse(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#isValid()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleMappingsSnmpCommunicationConfig.isValid()"})
  void testIsValid_thenReturnTrue() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("0.0.0", "not blank", DataType.BOOLEAN));

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertTrue(toServerRpcRequestSnmpCommunicationConfig.isValid());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#getAllMappings()}.
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#getAllMappings()}
   */
  @Test
  @DisplayName("Test getAllMappings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MultipleMappingsSnmpCommunicationConfig.getAllMappings()"})
  void testGetAllMappings() {
    // Arrange, Act and Assert
    assertNull(new ToServerRpcRequestSnmpCommunicationConfig().getAllMappings());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleMappingsSnmpCommunicationConfig.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ToServerRpcRequestSnmpCommunicationConfig().canEqual("Other"));
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link ToServerRpcRequestSnmpCommunicationConfig} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#canEqual(Object)}
   */
  @Test
  @DisplayName(
      "Test canEqual(Object); when ToServerRpcRequestSnmpCommunicationConfig (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MultipleMappingsSnmpCommunicationConfig.canEqual(Object)"})
  void testCanEqual_whenToServerRpcRequestSnmpCommunicationConfig_thenReturnTrue() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();

    // Act and Assert
    assertTrue(
        toServerRpcRequestSnmpCommunicationConfig.canEqual(
            new ToServerRpcRequestSnmpCommunicationConfig()));
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}, and {@link
   * MultipleMappingsSnmpCommunicationConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link MultipleMappingsSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MultipleMappingsSnmpCommunicationConfig.equals(Object)",
    "int MultipleMappingsSnmpCommunicationConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig2 =
        new ToServerRpcRequestSnmpCommunicationConfig();

    // Act and Assert
    assertEquals(
        toServerRpcRequestSnmpCommunicationConfig, toServerRpcRequestSnmpCommunicationConfig2);
    assertEquals(
        toServerRpcRequestSnmpCommunicationConfig.hashCode(),
        toServerRpcRequestSnmpCommunicationConfig2.hashCode());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}, and {@link
   * MultipleMappingsSnmpCommunicationConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link MultipleMappingsSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MultipleMappingsSnmpCommunicationConfig.equals(Object)",
    "int MultipleMappingsSnmpCommunicationConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(new ArrayList<>());

    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            mock(ClientAttributesQueryingSnmpCommunicationConfig.class);
    when(clientAttributesQueryingSnmpCommunicationConfig.getMappings())
        .thenReturn(new ArrayList<>());
    when(clientAttributesQueryingSnmpCommunicationConfig.canEqual(Mockito.<Object>any()))
        .thenReturn(true);

    // Act and Assert
    assertEquals(
        toServerRpcRequestSnmpCommunicationConfig, clientAttributesQueryingSnmpCommunicationConfig);
    assertNotEquals(
        toServerRpcRequestSnmpCommunicationConfig.hashCode(),
        clientAttributesQueryingSnmpCommunicationConfig.hashCode());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}, and {@link
   * MultipleMappingsSnmpCommunicationConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link MultipleMappingsSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MultipleMappingsSnmpCommunicationConfig.equals(Object)",
    "int MultipleMappingsSnmpCommunicationConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();

    // Act and Assert
    assertEquals(
        toServerRpcRequestSnmpCommunicationConfig, toServerRpcRequestSnmpCommunicationConfig);
    int expectedHashCodeResult = toServerRpcRequestSnmpCommunicationConfig.hashCode();
    assertEquals(expectedHashCodeResult, toServerRpcRequestSnmpCommunicationConfig.hashCode());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MultipleMappingsSnmpCommunicationConfig.equals(Object)",
    "int MultipleMappingsSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();

    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            new ClientAttributesQueryingSnmpCommunicationConfig();
    clientAttributesQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    clientAttributesQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(
        toServerRpcRequestSnmpCommunicationConfig, clientAttributesQueryingSnmpCommunicationConfig);
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MultipleMappingsSnmpCommunicationConfig.equals(Object)",
    "int MultipleMappingsSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();

    SharedAttributesSettingSnmpCommunicationConfig sharedAttributesSettingSnmpCommunicationConfig =
        new SharedAttributesSettingSnmpCommunicationConfig();
    sharedAttributesSettingSnmpCommunicationConfig.setMappings(new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        toServerRpcRequestSnmpCommunicationConfig, sharedAttributesSettingSnmpCommunicationConfig);
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MultipleMappingsSnmpCommunicationConfig.equals(Object)",
    "int MultipleMappingsSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();

    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            mock(ClientAttributesQueryingSnmpCommunicationConfig.class);
    when(clientAttributesQueryingSnmpCommunicationConfig.getMappings())
        .thenReturn(new ArrayList<>());
    when(clientAttributesQueryingSnmpCommunicationConfig.canEqual(Mockito.<Object>any()))
        .thenReturn(true);

    // Act and Assert
    assertNotEquals(
        toServerRpcRequestSnmpCommunicationConfig, clientAttributesQueryingSnmpCommunicationConfig);
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MultipleMappingsSnmpCommunicationConfig.equals(Object)",
    "int MultipleMappingsSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    ClientAttributesQueryingSnmpCommunicationConfig
        clientAttributesQueryingSnmpCommunicationConfig =
            mock(ClientAttributesQueryingSnmpCommunicationConfig.class);
    when(clientAttributesQueryingSnmpCommunicationConfig.getMappings())
        .thenReturn(new ArrayList<>());
    when(clientAttributesQueryingSnmpCommunicationConfig.canEqual(Mockito.<Object>any()))
        .thenReturn(true);

    // Act and Assert
    assertNotEquals(
        toServerRpcRequestSnmpCommunicationConfig, clientAttributesQueryingSnmpCommunicationConfig);
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MultipleMappingsSnmpCommunicationConfig.equals(Object)",
    "int MultipleMappingsSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ToServerRpcRequestSnmpCommunicationConfig(), null);
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MultipleMappingsSnmpCommunicationConfig.equals(Object)",
    "int MultipleMappingsSnmpCommunicationConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ToServerRpcRequestSnmpCommunicationConfig(),
        "Different type to MultipleMappingsSnmpCommunicationConfig");
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#getMappings()}.
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#getMappings()}
   */
  @Test
  @DisplayName("Test getMappings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MultipleMappingsSnmpCommunicationConfig.getMappings()"})
  void testGetMappings() {
    // Arrange, Act and Assert
    assertNull(new ToServerRpcRequestSnmpCommunicationConfig().getMappings());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#setMappings(List)}.
   *
   * <ul>
   *   <li>Given {@link SnmpMapping#SnmpMapping(String, String, DataType)} with {@code Oid} and
   *       {@code Key} and dataType is {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#setMappings(List)}
   */
  @Test
  @DisplayName(
      "Test setMappings(List); given SnmpMapping(String, String, DataType) with 'Oid' and 'Key' and dataType is 'BOOLEAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultipleMappingsSnmpCommunicationConfig.setMappings(List)"})
  void testSetMappings_givenSnmpMappingWithOidAndKeyAndDataTypeIsBoolean() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();

    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    // Act
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Assert
    assertSame(mappings, toServerRpcRequestSnmpCommunicationConfig.getAllMappings());
    assertSame(mappings, toServerRpcRequestSnmpCommunicationConfig.getMappings());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#setMappings(List)}.
   *
   * <ul>
   *   <li>Given {@link SnmpMapping#SnmpMapping(String, String, DataType)} with {@code Oid} and
   *       {@code Key} and dataType is {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#setMappings(List)}
   */
  @Test
  @DisplayName(
      "Test setMappings(List); given SnmpMapping(String, String, DataType) with 'Oid' and 'Key' and dataType is 'BOOLEAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultipleMappingsSnmpCommunicationConfig.setMappings(List)"})
  void testSetMappings_givenSnmpMappingWithOidAndKeyAndDataTypeIsBoolean2() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();

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
   * Test {@link MultipleMappingsSnmpCommunicationConfig#setMappings(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#setMappings(List)}
   */
  @Test
  @DisplayName("Test setMappings(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultipleMappingsSnmpCommunicationConfig.setMappings(List)"})
  void testSetMappings_whenArrayList() {
    // Arrange
    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    ArrayList<SnmpMapping> mappings = new ArrayList<>();

    // Act
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Assert
    assertSame(mappings, toServerRpcRequestSnmpCommunicationConfig.getAllMappings());
    assertSame(mappings, toServerRpcRequestSnmpCommunicationConfig.getMappings());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#toString()}.
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String MultipleMappingsSnmpCommunicationConfig.toString()"})
  void testToString() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertEquals(
        "MultipleMappingsSnmpCommunicationConfig(mappings=[SnmpMapping(oid=Oid, key=Key, dataType=BOOLEAN)])",
        toServerRpcRequestSnmpCommunicationConfig.toString());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#toString()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String MultipleMappingsSnmpCommunicationConfig.toString()"})
  void testToString_thenReturnAString() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    ToServerRpcRequestSnmpCommunicationConfig toServerRpcRequestSnmpCommunicationConfig =
        new ToServerRpcRequestSnmpCommunicationConfig();
    toServerRpcRequestSnmpCommunicationConfig.setMappings(mappings);

    // Act and Assert
    assertEquals(
        "MultipleMappingsSnmpCommunicationConfig(mappings=[SnmpMapping(oid=Oid, key=Key, dataType=BOOLEAN),"
            + " SnmpMapping(oid=Oid, key=Key, dataType=BOOLEAN)])",
        toServerRpcRequestSnmpCommunicationConfig.toString());
  }

  /**
   * Test {@link MultipleMappingsSnmpCommunicationConfig#toString()}.
   *
   * <ul>
   *   <li>Then return {@code MultipleMappingsSnmpCommunicationConfig(mappings=null)}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleMappingsSnmpCommunicationConfig#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'MultipleMappingsSnmpCommunicationConfig(mappings=null)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String MultipleMappingsSnmpCommunicationConfig.toString()"})
  void testToString_thenReturnMultipleMappingsSnmpCommunicationConfigMappingsNull() {
    // Arrange, Act and Assert
    assertEquals(
        "MultipleMappingsSnmpCommunicationConfig(mappings=null)",
        new ToServerRpcRequestSnmpCommunicationConfig().toString());
  }
}
