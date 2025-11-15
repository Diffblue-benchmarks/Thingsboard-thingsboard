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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class DeviceCredentialsUpdateNotificationMsgDiffblueTest {
  /**
   * Test {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}, and {@link DeviceCredentialsUpdateNotificationMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}
   *   <li>{@link DeviceCredentialsUpdateNotificationMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceCredentialsUpdateNotificationMsg.equals(Object)",
      "int DeviceCredentialsUpdateNotificationMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceCredentialsUpdateNotificationMsg deviceCredentialsUpdateNotificationMsg = new DeviceCredentialsUpdateNotificationMsg(
        null, null, new DeviceCredentials());
    DeviceCredentialsUpdateNotificationMsg deviceCredentialsUpdateNotificationMsg2 = new DeviceCredentialsUpdateNotificationMsg(
        null, null, new DeviceCredentials());

    // Act and Assert
    assertEquals(deviceCredentialsUpdateNotificationMsg, deviceCredentialsUpdateNotificationMsg2);
    int expectedHashCodeResult = deviceCredentialsUpdateNotificationMsg.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentialsUpdateNotificationMsg2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}, and {@link DeviceCredentialsUpdateNotificationMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}
   *   <li>{@link DeviceCredentialsUpdateNotificationMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceCredentialsUpdateNotificationMsg.equals(Object)",
      "int DeviceCredentialsUpdateNotificationMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceCredentialsUpdateNotificationMsg deviceCredentialsUpdateNotificationMsg = new DeviceCredentialsUpdateNotificationMsg(
        null, null, null);
    DeviceCredentialsUpdateNotificationMsg deviceCredentialsUpdateNotificationMsg2 = new DeviceCredentialsUpdateNotificationMsg(
        null, null, null);

    // Act and Assert
    assertEquals(deviceCredentialsUpdateNotificationMsg, deviceCredentialsUpdateNotificationMsg2);
    int expectedHashCodeResult = deviceCredentialsUpdateNotificationMsg.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentialsUpdateNotificationMsg2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceCredentialsUpdateNotificationMsg.equals(Object)",
      "int DeviceCredentialsUpdateNotificationMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceCredentialsUpdateNotificationMsg deviceCredentialsUpdateNotificationMsg = new DeviceCredentialsUpdateNotificationMsg(
        tenantId, null, new DeviceCredentials());
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(deviceCredentialsUpdateNotificationMsg,
        new DeviceCredentialsUpdateNotificationMsg(tenantId2, null, new DeviceCredentials()));
  }

  /**
   * Test {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceCredentialsUpdateNotificationMsg.equals(Object)",
      "int DeviceCredentialsUpdateNotificationMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceCredentialsUpdateNotificationMsg deviceCredentialsUpdateNotificationMsg = new DeviceCredentialsUpdateNotificationMsg(
        null, null, new DeviceCredentials());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(deviceCredentialsUpdateNotificationMsg,
        new DeviceCredentialsUpdateNotificationMsg(tenantId, null, new DeviceCredentials()));
  }

  /**
   * Test {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceCredentialsUpdateNotificationMsg.equals(Object)",
      "int DeviceCredentialsUpdateNotificationMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(new DeviceCredentialsUpdateNotificationMsg(tenantId, null, new DeviceCredentials()), 1);
  }

  /**
   * Test {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceCredentialsUpdateNotificationMsg.equals(Object)",
      "int DeviceCredentialsUpdateNotificationMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.randomUUID());
    DeviceCredentialsUpdateNotificationMsg deviceCredentialsUpdateNotificationMsg = new DeviceCredentialsUpdateNotificationMsg(
        null, deviceId, new DeviceCredentials());

    // Act and Assert
    assertNotEquals(deviceCredentialsUpdateNotificationMsg,
        new DeviceCredentialsUpdateNotificationMsg(null, null, new DeviceCredentials()));
  }

  /**
   * Test {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceCredentialsUpdateNotificationMsg.equals(Object)",
      "int DeviceCredentialsUpdateNotificationMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceCredentialsUpdateNotificationMsg deviceCredentialsUpdateNotificationMsg = new DeviceCredentialsUpdateNotificationMsg(
        null, null, null);

    // Act and Assert
    assertNotEquals(deviceCredentialsUpdateNotificationMsg,
        new DeviceCredentialsUpdateNotificationMsg(null, null, new DeviceCredentials()));
  }

  /**
   * Test {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceCredentialsUpdateNotificationMsg.equals(Object)",
      "int DeviceCredentialsUpdateNotificationMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceCredentialsUpdateNotificationMsg deviceCredentialsUpdateNotificationMsg = new DeviceCredentialsUpdateNotificationMsg(
        null, null, new DeviceCredentials(new DeviceCredentialsId(UUID.randomUUID())));

    // Act and Assert
    assertNotEquals(deviceCredentialsUpdateNotificationMsg,
        new DeviceCredentialsUpdateNotificationMsg(null, null, new DeviceCredentials()));
  }

  /**
   * Test {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsUpdateNotificationMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceCredentialsUpdateNotificationMsg.equals(Object)",
      "int DeviceCredentialsUpdateNotificationMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceCredentialsUpdateNotificationMsg deviceCredentialsUpdateNotificationMsg = new DeviceCredentialsUpdateNotificationMsg(
        null, null, new DeviceCredentials());
    DeviceId deviceId = new DeviceId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(deviceCredentialsUpdateNotificationMsg,
        new DeviceCredentialsUpdateNotificationMsg(null, deviceId, new DeviceCredentials()));
  }
}
