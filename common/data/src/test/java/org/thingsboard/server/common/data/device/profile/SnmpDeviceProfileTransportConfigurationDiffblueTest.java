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
package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.transport.snmp.config.SnmpCommunicationConfig;
import org.thingsboard.server.common.data.transport.snmp.config.ToServerRpcRequestSnmpCommunicationConfig;

class SnmpDeviceProfileTransportConfigurationDiffblueTest {
  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#validate()}.
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpDeviceProfileTransportConfiguration.validate()"})
  void testValidate() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(0);
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#validate()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); given ArrayList() add 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpDeviceProfileTransportConfiguration.validate()"})
  void testValidate_givenArrayListAddNull_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(null);

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(0);
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#validate()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ToServerRpcRequestSnmpCommunicationConfig}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given ArrayList() add ToServerRpcRequestSnmpCommunicationConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpDeviceProfileTransportConfiguration.validate()"})
  void testValidate_givenArrayListAddToServerRpcRequestSnmpCommunicationConfig() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(new ToServerRpcRequestSnmpCommunicationConfig());

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(0);
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#validate()}.
   *
   * <ul>
   *   <li>Given {@link SnmpDeviceProfileTransportConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given SnmpDeviceProfileTransportConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpDeviceProfileTransportConfiguration.validate()"})
  void testValidate_givenSnmpDeviceProfileTransportConfiguration() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new SnmpDeviceProfileTransportConfiguration().validate());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#validate()}.
   *
   * <ul>
   *   <li>Given {@link SnmpDeviceProfileTransportConfiguration} (default constructor) Retries is
   *       minus one.
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given SnmpDeviceProfileTransportConfiguration (default constructor) Retries is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpDeviceProfileTransportConfiguration.validate()"})
  void testValidate_givenSnmpDeviceProfileTransportConfigurationRetriesIsMinusOne() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(new ToServerRpcRequestSnmpCommunicationConfig());

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(-1);
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#validate()}.
   *
   * <ul>
   *   <li>Given {@link SnmpDeviceProfileTransportConfiguration} (default constructor) Retries is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given SnmpDeviceProfileTransportConfiguration (default constructor) Retries is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpDeviceProfileTransportConfiguration.validate()"})
  void testValidate_givenSnmpDeviceProfileTransportConfigurationRetriesIsNull() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(new ToServerRpcRequestSnmpCommunicationConfig());

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(null);
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#validate()}.
   *
   * <ul>
   *   <li>Given {@link SnmpDeviceProfileTransportConfiguration} (default constructor) TimeoutMs is
   *       minus one.
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName(
      "Test validate(); given SnmpDeviceProfileTransportConfiguration (default constructor) TimeoutMs is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpDeviceProfileTransportConfiguration.validate()"})
  void testValidate_givenSnmpDeviceProfileTransportConfigurationTimeoutMsIsMinusOne() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(new ToServerRpcRequestSnmpCommunicationConfig());

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(-1);
    snmpDeviceProfileTransportConfiguration.setRetries(0);
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#validate()}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  @DisplayName("Test validate(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpDeviceProfileTransportConfiguration.validate()"})
  void testValidate_thenDoesNotThrow() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(0);
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(new ArrayList<>());

    // Act and Assert
    assertDoesNotThrow(() -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}, and {@link
   * SnmpDeviceProfileTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SnmpDeviceProfileTransportConfiguration.equals(Object)",
    "int SnmpDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 =
        new SnmpDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
    assertEquals(
        snmpDeviceProfileTransportConfiguration.hashCode(),
        snmpDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}, and {@link
   * SnmpDeviceProfileTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SnmpDeviceProfileTransportConfiguration.equals(Object)",
    "int SnmpDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(10);

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setTimeoutMs(10);

    // Act and Assert
    assertEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
    assertEquals(
        snmpDeviceProfileTransportConfiguration.hashCode(),
        snmpDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}, and {@link
   * SnmpDeviceProfileTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SnmpDeviceProfileTransportConfiguration.equals(Object)",
    "int SnmpDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setRetries(1);

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setRetries(1);

    // Act and Assert
    assertEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
    assertEquals(
        snmpDeviceProfileTransportConfiguration.hashCode(),
        snmpDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}, and {@link
   * SnmpDeviceProfileTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SnmpDeviceProfileTransportConfiguration.equals(Object)",
    "int SnmpDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(new ArrayList<>());

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setCommunicationConfigs(new ArrayList<>());

    // Act and Assert
    assertEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
    assertEquals(
        snmpDeviceProfileTransportConfiguration.hashCode(),
        snmpDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}, and {@link
   * SnmpDeviceProfileTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SnmpDeviceProfileTransportConfiguration.equals(Object)",
    "int SnmpDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration);
    int expectedHashCodeResult = snmpDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceProfileTransportConfiguration.hashCode());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SnmpDeviceProfileTransportConfiguration.equals(Object)",
    "int SnmpDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SnmpDeviceProfileTransportConfiguration(), 1);
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SnmpDeviceProfileTransportConfiguration.equals(Object)",
    "int SnmpDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(10);

    // Act and Assert
    assertNotEquals(
        snmpDeviceProfileTransportConfiguration, new SnmpDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SnmpDeviceProfileTransportConfiguration.equals(Object)",
    "int SnmpDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setRetries(1);

    // Act and Assert
    assertNotEquals(
        snmpDeviceProfileTransportConfiguration, new SnmpDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SnmpDeviceProfileTransportConfiguration.equals(Object)",
    "int SnmpDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        snmpDeviceProfileTransportConfiguration, new SnmpDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SnmpDeviceProfileTransportConfiguration.equals(Object)",
    "int SnmpDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setTimeoutMs(10);

    // Act and Assert
    assertNotEquals(
        snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SnmpDeviceProfileTransportConfiguration.equals(Object)",
    "int SnmpDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setRetries(1);

    // Act and Assert
    assertNotEquals(
        snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SnmpDeviceProfileTransportConfiguration.equals(Object)",
    "int SnmpDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 =
        new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setCommunicationConfigs(new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SnmpDeviceProfileTransportConfiguration.equals(Object)",
    "int SnmpDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SnmpDeviceProfileTransportConfiguration(), null);
  }

  /**
   * Test {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SnmpDeviceProfileTransportConfiguration.equals(Object)",
    "int SnmpDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new SnmpDeviceProfileTransportConfiguration(),
        "Different type to SnmpDeviceProfileTransportConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SnmpDeviceProfileTransportConfiguration}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#setCommunicationConfigs(List)}
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SnmpDeviceProfileTransportConfiguration.<init>()",
    "List SnmpDeviceProfileTransportConfiguration.getCommunicationConfigs()",
    "Integer SnmpDeviceProfileTransportConfiguration.getRetries()",
    "Integer SnmpDeviceProfileTransportConfiguration.getTimeoutMs()",
    "DeviceTransportType SnmpDeviceProfileTransportConfiguration.getType()",
    "void SnmpDeviceProfileTransportConfiguration.setCommunicationConfigs(List)",
    "void SnmpDeviceProfileTransportConfiguration.setRetries(Integer)",
    "void SnmpDeviceProfileTransportConfiguration.setTimeoutMs(Integer)",
    "String SnmpDeviceProfileTransportConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SnmpDeviceProfileTransportConfiguration actualSnmpDeviceProfileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    actualSnmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);
    actualSnmpDeviceProfileTransportConfiguration.setRetries(1);
    actualSnmpDeviceProfileTransportConfiguration.setTimeoutMs(10);
    String actualToStringResult = actualSnmpDeviceProfileTransportConfiguration.toString();
    List<SnmpCommunicationConfig> actualCommunicationConfigs =
        actualSnmpDeviceProfileTransportConfiguration.getCommunicationConfigs();
    Integer actualRetries = actualSnmpDeviceProfileTransportConfiguration.getRetries();
    Integer actualTimeoutMs = actualSnmpDeviceProfileTransportConfiguration.getTimeoutMs();
    DeviceTransportType actualType = actualSnmpDeviceProfileTransportConfiguration.getType();

    // Assert
    assertEquals(
        "SnmpDeviceProfileTransportConfiguration(timeoutMs=10, retries=1, communicationConfigs=[])",
        actualToStringResult);
    assertEquals(1, actualRetries.intValue());
    assertEquals(10, actualTimeoutMs.intValue());
    assertEquals(DeviceTransportType.SNMP, actualType);
    assertTrue(actualCommunicationConfigs.isEmpty());
    assertSame(communicationConfigs, actualCommunicationConfigs);
  }
}
