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
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceNameOrTypeUpdateMsgDiffblueTest {
  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}, and {@link
   * DeviceNameOrTypeUpdateMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   *   <li>{@link DeviceNameOrTypeUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceNameOrTypeUpdateMsg.equals(Object)",
    "int DeviceNameOrTypeUpdateMsg.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg =
        new DeviceNameOrTypeUpdateMsg(null, null, "Device Name", "Device Type");
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg2 =
        new DeviceNameOrTypeUpdateMsg(null, null, "Device Name", "Device Type");

    // Act and Assert
    assertEquals(deviceNameOrTypeUpdateMsg, deviceNameOrTypeUpdateMsg2);
    assertEquals(deviceNameOrTypeUpdateMsg.hashCode(), deviceNameOrTypeUpdateMsg2.hashCode());
  }

  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}, and {@link
   * DeviceNameOrTypeUpdateMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   *   <li>{@link DeviceNameOrTypeUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceNameOrTypeUpdateMsg.equals(Object)",
    "int DeviceNameOrTypeUpdateMsg.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg =
        new DeviceNameOrTypeUpdateMsg(null, null, null, "Device Type");
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg2 =
        new DeviceNameOrTypeUpdateMsg(null, null, null, "Device Type");

    // Act and Assert
    assertEquals(deviceNameOrTypeUpdateMsg, deviceNameOrTypeUpdateMsg2);
    assertEquals(deviceNameOrTypeUpdateMsg.hashCode(), deviceNameOrTypeUpdateMsg2.hashCode());
  }

  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}, and {@link
   * DeviceNameOrTypeUpdateMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   *   <li>{@link DeviceNameOrTypeUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceNameOrTypeUpdateMsg.equals(Object)",
    "int DeviceNameOrTypeUpdateMsg.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg =
        new DeviceNameOrTypeUpdateMsg(null, null, "Device Name", null);
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg2 =
        new DeviceNameOrTypeUpdateMsg(null, null, "Device Name", null);

    // Act and Assert
    assertEquals(deviceNameOrTypeUpdateMsg, deviceNameOrTypeUpdateMsg2);
    assertEquals(deviceNameOrTypeUpdateMsg.hashCode(), deviceNameOrTypeUpdateMsg2.hashCode());
  }

  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}, and {@link
   * DeviceNameOrTypeUpdateMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   *   <li>{@link DeviceNameOrTypeUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceNameOrTypeUpdateMsg.equals(Object)",
    "int DeviceNameOrTypeUpdateMsg.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg =
        new DeviceNameOrTypeUpdateMsg(new TenantId(null), null, "Device Name", "Device Type");
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg2 =
        new DeviceNameOrTypeUpdateMsg(new TenantId(null), null, "Device Name", "Device Type");

    // Act and Assert
    assertEquals(deviceNameOrTypeUpdateMsg, deviceNameOrTypeUpdateMsg2);
    assertEquals(deviceNameOrTypeUpdateMsg.hashCode(), deviceNameOrTypeUpdateMsg2.hashCode());
  }

  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceNameOrTypeUpdateMsg.equals(Object)",
    "int DeviceNameOrTypeUpdateMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg =
        new DeviceNameOrTypeUpdateMsg(
            new TenantId(UUID.randomUUID()), null, "Device Name", "Device Type");

    // Act and Assert
    assertNotEquals(
        deviceNameOrTypeUpdateMsg,
        new DeviceNameOrTypeUpdateMsg(
            new TenantId(UUID.randomUUID()), null, "Device Name", "Device Type"));
  }

  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceNameOrTypeUpdateMsg.equals(Object)",
    "int DeviceNameOrTypeUpdateMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg =
        new DeviceNameOrTypeUpdateMsg(null, null, "Device Name", "Device Type");

    // Act and Assert
    assertNotEquals(
        deviceNameOrTypeUpdateMsg,
        new DeviceNameOrTypeUpdateMsg(
            new TenantId(UUID.randomUUID()), null, "Device Name", "Device Type"));
  }

  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceNameOrTypeUpdateMsg.equals(Object)",
    "int DeviceNameOrTypeUpdateMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DeviceNameOrTypeUpdateMsg(
            new TenantId(UUID.randomUUID()), null, "Device Name", "Device Type"),
        1);
  }

  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceNameOrTypeUpdateMsg.equals(Object)",
    "int DeviceNameOrTypeUpdateMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg =
        new DeviceNameOrTypeUpdateMsg(
            null, new DeviceId(UUID.randomUUID()), "Device Name", "Device Type");

    // Act and Assert
    assertNotEquals(
        deviceNameOrTypeUpdateMsg,
        new DeviceNameOrTypeUpdateMsg(null, null, "Device Name", "Device Type"));
  }

  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceNameOrTypeUpdateMsg.equals(Object)",
    "int DeviceNameOrTypeUpdateMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg =
        new DeviceNameOrTypeUpdateMsg(null, null, "Device Type", "Device Type");

    // Act and Assert
    assertNotEquals(
        deviceNameOrTypeUpdateMsg,
        new DeviceNameOrTypeUpdateMsg(null, null, "Device Name", "Device Type"));
  }

  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceNameOrTypeUpdateMsg.equals(Object)",
    "int DeviceNameOrTypeUpdateMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg =
        new DeviceNameOrTypeUpdateMsg(null, null, null, "Device Type");

    // Act and Assert
    assertNotEquals(
        deviceNameOrTypeUpdateMsg,
        new DeviceNameOrTypeUpdateMsg(null, null, "Device Name", "Device Type"));
  }

  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceNameOrTypeUpdateMsg.equals(Object)",
    "int DeviceNameOrTypeUpdateMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg =
        new DeviceNameOrTypeUpdateMsg(null, null, "Device Name", "Device Name");

    // Act and Assert
    assertNotEquals(
        deviceNameOrTypeUpdateMsg,
        new DeviceNameOrTypeUpdateMsg(null, null, "Device Name", "Device Type"));
  }

  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceNameOrTypeUpdateMsg.equals(Object)",
    "int DeviceNameOrTypeUpdateMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg =
        new DeviceNameOrTypeUpdateMsg(null, null, "Device Name", null);

    // Act and Assert
    assertNotEquals(
        deviceNameOrTypeUpdateMsg,
        new DeviceNameOrTypeUpdateMsg(null, null, "Device Name", "Device Type"));
  }

  /**
   * Test {@link DeviceNameOrTypeUpdateMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceNameOrTypeUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceNameOrTypeUpdateMsg.equals(Object)",
    "int DeviceNameOrTypeUpdateMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceNameOrTypeUpdateMsg deviceNameOrTypeUpdateMsg =
        new DeviceNameOrTypeUpdateMsg(null, null, "Device Name", "Device Type");

    // Act and Assert
    assertNotEquals(
        deviceNameOrTypeUpdateMsg,
        new DeviceNameOrTypeUpdateMsg(
            null, new DeviceId(UUID.randomUUID()), "Device Name", "Device Type"));
  }
}
