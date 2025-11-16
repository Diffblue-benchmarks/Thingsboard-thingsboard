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
package org.thingsboard.server.common.msg.rule.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;

class DeviceMetaDataDiffblueTest {
  /**
   * Test {@link DeviceMetaData#equals(Object)}, and {@link DeviceMetaData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceMetaData#equals(Object)}
   *   <li>{@link DeviceMetaData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, "Device Name", "Device Type", null);
    DeviceMetaData deviceMetaData2 = new DeviceMetaData(null, "Device Name", "Device Type", null);

    // Act and Assert
    assertEquals(deviceMetaData, deviceMetaData2);
    assertEquals(deviceMetaData.hashCode(), deviceMetaData2.hashCode());
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData =
        new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.randomUUID());
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    DeviceMetaData deviceMetaData =
        new DeviceMetaData(deviceId, "Device Name", "Device Type", deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData =
        new DeviceMetaData(null, "Device Type", "Device Type", deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, null, "Device Type", deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData =
        new DeviceMetaData(null, "Device Name", "Device Name", deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, "Device Name", null, deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, "Device Name", "Device Type", null);
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    // Act and Assert
    assertNotEquals(new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes), 1);
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData =
        new DeviceMetaData(null, "Device Type", "Device Type", deviceAttributes);
    DeviceId deviceId = new DeviceId(UUID.randomUUID());
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData,
        new DeviceMetaData(deviceId, "Device Name", "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, null, "Device Type", deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, null, "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, "Device Name", null, deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", null, deviceAttributes2));
  }
}
