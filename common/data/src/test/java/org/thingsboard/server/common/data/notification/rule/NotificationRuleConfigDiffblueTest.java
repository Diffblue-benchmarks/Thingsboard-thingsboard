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
package org.thingsboard.server.common.data.notification.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NotificationRuleConfigDiffblueTest {
  /**
   * Test {@link NotificationRuleConfig#equals(Object)}, and {@link NotificationRuleConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleConfig#equals(Object)}
   *   <li>{@link NotificationRuleConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleConfig.equals(Object)", "int NotificationRuleConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    NotificationRuleConfig notificationRuleConfig2 = new NotificationRuleConfig();
    notificationRuleConfig2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals(notificationRuleConfig, notificationRuleConfig2);
    int expectedHashCodeResult = notificationRuleConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationRuleConfig2.hashCode());
  }

  /**
   * Test {@link NotificationRuleConfig#equals(Object)}, and {@link NotificationRuleConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleConfig#equals(Object)}
   *   <li>{@link NotificationRuleConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleConfig.equals(Object)", "int NotificationRuleConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription(null);

    NotificationRuleConfig notificationRuleConfig2 = new NotificationRuleConfig();
    notificationRuleConfig2.setDescription(null);

    // Act and Assert
    assertEquals(notificationRuleConfig, notificationRuleConfig2);
    int expectedHashCodeResult = notificationRuleConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationRuleConfig2.hashCode());
  }

  /**
   * Test {@link NotificationRuleConfig#equals(Object)}, and {@link NotificationRuleConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleConfig#equals(Object)}
   *   <li>{@link NotificationRuleConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleConfig.equals(Object)", "int NotificationRuleConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals(notificationRuleConfig, notificationRuleConfig);
    int expectedHashCodeResult = notificationRuleConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationRuleConfig.hashCode());
  }

  /**
   * Test {@link NotificationRuleConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleConfig.equals(Object)", "int NotificationRuleConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("Description");

    NotificationRuleConfig notificationRuleConfig2 = new NotificationRuleConfig();
    notificationRuleConfig2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(notificationRuleConfig, notificationRuleConfig2);
  }

  /**
   * Test {@link NotificationRuleConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleConfig.equals(Object)", "int NotificationRuleConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription(null);

    NotificationRuleConfig notificationRuleConfig2 = new NotificationRuleConfig();
    notificationRuleConfig2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(notificationRuleConfig, notificationRuleConfig2);
  }

  /**
   * Test {@link NotificationRuleConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleConfig.equals(Object)", "int NotificationRuleConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(notificationRuleConfig, null);
  }

  /**
   * Test {@link NotificationRuleConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleConfig.equals(Object)", "int NotificationRuleConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(notificationRuleConfig, "Different type to NotificationRuleConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NotificationRuleConfig}
   *   <li>{@link NotificationRuleConfig#setDescription(String)}
   *   <li>{@link NotificationRuleConfig#toString()}
   *   <li>{@link NotificationRuleConfig#getDescription()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRuleConfig.<init>()", "String NotificationRuleConfig.getDescription()",
      "void NotificationRuleConfig.setDescription(String)", "String NotificationRuleConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationRuleConfig actualNotificationRuleConfig = new NotificationRuleConfig();
    actualNotificationRuleConfig.setDescription("The characteristics of someone or something");
    String actualToStringResult = actualNotificationRuleConfig.toString();

    // Assert
    assertEquals("NotificationRuleConfig(description=The characteristics of someone or something)",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualNotificationRuleConfig.getDescription());
  }
}
