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
package org.thingsboard.monitoring.config.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class DeviceConfigDiffblueTest {
  /**
   * Test {@link DeviceConfig#equals(Object)}, and {@link DeviceConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceConfig#equals(Object)}
   *   <li>{@link DeviceConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConfig.equals(Object)", "int DeviceConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceConfig deviceConfig = new DeviceConfig();
    deviceConfig.setCredentials(new DeviceCredentials());
    deviceConfig.setId("");
    deviceConfig.setName("Name");

    DeviceConfig deviceConfig2 = new DeviceConfig();
    deviceConfig2.setCredentials(new DeviceCredentials());
    deviceConfig2.setId("");
    deviceConfig2.setName("Name");

    // Act and Assert
    assertEquals(deviceConfig, deviceConfig2);
    assertEquals(deviceConfig.hashCode(), deviceConfig2.hashCode());
  }

  /**
   * Test {@link DeviceConfig#equals(Object)}, and {@link DeviceConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceConfig#equals(Object)}
   *   <li>{@link DeviceConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConfig.equals(Object)", "int DeviceConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceConfig deviceConfig = new DeviceConfig();
    deviceConfig.setCredentials(null);
    deviceConfig.setId("");
    deviceConfig.setName("Name");

    DeviceConfig deviceConfig2 = new DeviceConfig();
    deviceConfig2.setCredentials(null);
    deviceConfig2.setId("");
    deviceConfig2.setName("Name");

    // Act and Assert
    assertEquals(deviceConfig, deviceConfig2);
    assertEquals(deviceConfig.hashCode(), deviceConfig2.hashCode());
  }

  /**
   * Test {@link DeviceConfig#equals(Object)}, and {@link DeviceConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceConfig#equals(Object)}
   *   <li>{@link DeviceConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConfig.equals(Object)", "int DeviceConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceConfig deviceConfig = new DeviceConfig();
    deviceConfig.setCredentials(new DeviceCredentials());
    deviceConfig.setId("");
    deviceConfig.setName(null);

    DeviceConfig deviceConfig2 = new DeviceConfig();
    deviceConfig2.setCredentials(new DeviceCredentials());
    deviceConfig2.setId("");
    deviceConfig2.setName(null);

    // Act and Assert
    assertEquals(deviceConfig, deviceConfig2);
    assertEquals(deviceConfig.hashCode(), deviceConfig2.hashCode());
  }

  /**
   * Test {@link DeviceConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConfig.equals(Object)", "int DeviceConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceConfig deviceConfig = new DeviceConfig();
    deviceConfig.setCredentials(null);
    deviceConfig.setId("");
    deviceConfig.setName("Name");

    DeviceConfig deviceConfig2 = new DeviceConfig();
    deviceConfig2.setCredentials(new DeviceCredentials());
    deviceConfig2.setId("");
    deviceConfig2.setName("Name");

    // Act and Assert
    assertNotEquals(deviceConfig, deviceConfig2);
  }

  /**
   * Test {@link DeviceConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConfig.equals(Object)", "int DeviceConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceConfig deviceConfig = new DeviceConfig();
    deviceConfig.setCredentials(new DeviceCredentials(new DeviceCredentialsId(UUID.randomUUID())));
    deviceConfig.setId("");
    deviceConfig.setName("Name");

    DeviceConfig deviceConfig2 = new DeviceConfig();
    deviceConfig2.setCredentials(new DeviceCredentials());
    deviceConfig2.setId("");
    deviceConfig2.setName("Name");

    // Act and Assert
    assertNotEquals(deviceConfig, deviceConfig2);
  }

  /**
   * Test {@link DeviceConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConfig.equals(Object)", "int DeviceConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceConfig deviceConfig = new DeviceConfig();
    deviceConfig.setCredentials(new DeviceCredentials());
    deviceConfig.setId("");
    deviceConfig.setName(null);

    DeviceConfig deviceConfig2 = new DeviceConfig();
    deviceConfig2.setCredentials(new DeviceCredentials());
    deviceConfig2.setId("");
    deviceConfig2.setName("Name");

    // Act and Assert
    assertNotEquals(deviceConfig, deviceConfig2);
  }

  /**
   * Test {@link DeviceConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConfig.equals(Object)", "int DeviceConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceConfig deviceConfig = new DeviceConfig();
    deviceConfig.setCredentials(new DeviceCredentials());
    deviceConfig.setId("");
    deviceConfig.setName("org.thingsboard.monitoring.config.transport.DeviceConfig");

    DeviceConfig deviceConfig2 = new DeviceConfig();
    deviceConfig2.setCredentials(new DeviceCredentials());
    deviceConfig2.setId("");
    deviceConfig2.setName("Name");

    // Act and Assert
    assertNotEquals(deviceConfig, deviceConfig2);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceConfig}
   *   <li>{@link DeviceConfig#setCredentials(DeviceCredentials)}
   *   <li>{@link DeviceConfig#setName(String)}
   *   <li>{@link DeviceConfig#toString()}
   *   <li>{@link DeviceConfig#getCredentials()}
   *   <li>{@link DeviceConfig#getId()}
   *   <li>{@link DeviceConfig#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceConfig.<init>()",
    "DeviceCredentials DeviceConfig.getCredentials()",
    "UUID DeviceConfig.getId()",
    "String DeviceConfig.getName()",
    "void DeviceConfig.setCredentials(DeviceCredentials)",
    "void DeviceConfig.setName(String)",
    "String DeviceConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceConfig actualDeviceConfig = new DeviceConfig();
    DeviceCredentials credentials = new DeviceCredentials();
    actualDeviceConfig.setCredentials(credentials);
    actualDeviceConfig.setName("Name");
    String actualToStringResult = actualDeviceConfig.toString();
    DeviceCredentials actualCredentials = actualDeviceConfig.getCredentials();
    UUID actualId = actualDeviceConfig.getId();

    // Assert
    assertEquals(
        "DeviceConfig(id=null, name=Name, credentials=DeviceCredentials [deviceId=null, credentialsType=null,"
            + " credentialsId=null, credentialsValue=null, createdTime=0, id=null])",
        actualToStringResult);
    assertEquals("Name", actualDeviceConfig.getName());
    assertNull(actualId);
    assertSame(credentials, actualCredentials);
  }
}
