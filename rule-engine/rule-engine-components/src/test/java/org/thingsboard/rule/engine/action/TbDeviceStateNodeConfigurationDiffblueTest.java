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
package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.msg.TbMsgType;

class TbDeviceStateNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbDeviceStateNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbDeviceStateNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbDeviceStateNodeConfiguration TbDeviceStateNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange, Act and Assert
    assertEquals(
        TbMsgType.ACTIVITY_EVENT,
        new TbDeviceStateNodeConfiguration().defaultConfiguration().getEvent());
  }

  /**
   * Test {@link TbDeviceStateNodeConfiguration#equals(Object)}, and {@link
   * TbDeviceStateNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbDeviceStateNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeviceStateNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeviceStateNodeConfiguration.equals(Object)",
    "int TbDeviceStateNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbDeviceStateNodeConfiguration tbDeviceStateNodeConfiguration =
        new TbDeviceStateNodeConfiguration();
    TbDeviceStateNodeConfiguration tbDeviceStateNodeConfiguration2 =
        new TbDeviceStateNodeConfiguration();

    // Act and Assert
    assertEquals(tbDeviceStateNodeConfiguration, tbDeviceStateNodeConfiguration2);
    assertEquals(
        tbDeviceStateNodeConfiguration.hashCode(), tbDeviceStateNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbDeviceStateNodeConfiguration#equals(Object)}, and {@link
   * TbDeviceStateNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbDeviceStateNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeviceStateNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeviceStateNodeConfiguration.equals(Object)",
    "int TbDeviceStateNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbDeviceStateNodeConfiguration tbDeviceStateNodeConfiguration =
        new TbDeviceStateNodeConfiguration();
    tbDeviceStateNodeConfiguration.setEvent(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbDeviceStateNodeConfiguration tbDeviceStateNodeConfiguration2 =
        new TbDeviceStateNodeConfiguration();
    tbDeviceStateNodeConfiguration2.setEvent(TbMsgType.POST_ATTRIBUTES_REQUEST);

    // Act and Assert
    assertEquals(tbDeviceStateNodeConfiguration, tbDeviceStateNodeConfiguration2);
    assertEquals(
        tbDeviceStateNodeConfiguration.hashCode(), tbDeviceStateNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbDeviceStateNodeConfiguration#equals(Object)}, and {@link
   * TbDeviceStateNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbDeviceStateNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeviceStateNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeviceStateNodeConfiguration.equals(Object)",
    "int TbDeviceStateNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbDeviceStateNodeConfiguration tbDeviceStateNodeConfiguration =
        new TbDeviceStateNodeConfiguration();

    // Act and Assert
    assertEquals(tbDeviceStateNodeConfiguration, tbDeviceStateNodeConfiguration);
    int expectedHashCodeResult = tbDeviceStateNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbDeviceStateNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbDeviceStateNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeviceStateNodeConfiguration.equals(Object)",
    "int TbDeviceStateNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbDeviceStateNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbDeviceStateNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeviceStateNodeConfiguration.equals(Object)",
    "int TbDeviceStateNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbDeviceStateNodeConfiguration tbDeviceStateNodeConfiguration =
        new TbDeviceStateNodeConfiguration();
    tbDeviceStateNodeConfiguration.setEvent(TbMsgType.POST_ATTRIBUTES_REQUEST);

    // Act and Assert
    assertNotEquals(tbDeviceStateNodeConfiguration, new TbDeviceStateNodeConfiguration());
  }

  /**
   * Test {@link TbDeviceStateNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeviceStateNodeConfiguration.equals(Object)",
    "int TbDeviceStateNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbDeviceStateNodeConfiguration tbDeviceStateNodeConfiguration =
        new TbDeviceStateNodeConfiguration();

    TbDeviceStateNodeConfiguration tbDeviceStateNodeConfiguration2 =
        new TbDeviceStateNodeConfiguration();
    tbDeviceStateNodeConfiguration2.setEvent(TbMsgType.POST_ATTRIBUTES_REQUEST);

    // Act and Assert
    assertNotEquals(tbDeviceStateNodeConfiguration, tbDeviceStateNodeConfiguration2);
  }

  /**
   * Test {@link TbDeviceStateNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeviceStateNodeConfiguration.equals(Object)",
    "int TbDeviceStateNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbDeviceStateNodeConfiguration(), null);
  }

  /**
   * Test {@link TbDeviceStateNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceStateNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeviceStateNodeConfiguration.equals(Object)",
    "int TbDeviceStateNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbDeviceStateNodeConfiguration(), "Different type to TbDeviceStateNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbDeviceStateNodeConfiguration}
   *   <li>{@link TbDeviceStateNodeConfiguration#setEvent(TbMsgType)}
   *   <li>{@link TbDeviceStateNodeConfiguration#toString()}
   *   <li>{@link TbDeviceStateNodeConfiguration#getEvent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbDeviceStateNodeConfiguration.<init>()",
    "TbMsgType TbDeviceStateNodeConfiguration.getEvent()",
    "void TbDeviceStateNodeConfiguration.setEvent(TbMsgType)",
    "String TbDeviceStateNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbDeviceStateNodeConfiguration actualTbDeviceStateNodeConfiguration =
        new TbDeviceStateNodeConfiguration();
    actualTbDeviceStateNodeConfiguration.setEvent(TbMsgType.POST_ATTRIBUTES_REQUEST);
    String actualToStringResult = actualTbDeviceStateNodeConfiguration.toString();

    // Assert
    assertEquals(
        "TbDeviceStateNodeConfiguration(event=POST_ATTRIBUTES_REQUEST)", actualToStringResult);
    assertEquals(
        TbMsgType.POST_ATTRIBUTES_REQUEST, actualTbDeviceStateNodeConfiguration.getEvent());
  }
}
