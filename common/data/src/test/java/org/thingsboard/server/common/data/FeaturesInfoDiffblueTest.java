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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FeaturesInfoDiffblueTest {
  /**
   * Test {@link FeaturesInfo#equals(Object)}, and {@link FeaturesInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FeaturesInfo#equals(Object)}
   *   <li>{@link FeaturesInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FeaturesInfo.equals(Object)", "int FeaturesInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FeaturesInfo featuresInfo = new FeaturesInfo();
    featuresInfo.setEmailEnabled(true);
    featuresInfo.setNotificationEnabled(true);
    featuresInfo.setOauthEnabled(true);
    featuresInfo.setSmsEnabled(true);
    featuresInfo.setTwoFaEnabled(true);

    FeaturesInfo featuresInfo2 = new FeaturesInfo();
    featuresInfo2.setEmailEnabled(true);
    featuresInfo2.setNotificationEnabled(true);
    featuresInfo2.setOauthEnabled(true);
    featuresInfo2.setSmsEnabled(true);
    featuresInfo2.setTwoFaEnabled(true);

    // Act and Assert
    assertEquals(featuresInfo, featuresInfo2);
    int expectedHashCodeResult = featuresInfo.hashCode();
    assertEquals(expectedHashCodeResult, featuresInfo2.hashCode());
  }

  /**
   * Test {@link FeaturesInfo#equals(Object)}, and {@link FeaturesInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FeaturesInfo#equals(Object)}
   *   <li>{@link FeaturesInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FeaturesInfo.equals(Object)", "int FeaturesInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FeaturesInfo featuresInfo = new FeaturesInfo();
    featuresInfo.setEmailEnabled(true);
    featuresInfo.setNotificationEnabled(true);
    featuresInfo.setOauthEnabled(true);
    featuresInfo.setSmsEnabled(true);
    featuresInfo.setTwoFaEnabled(true);

    // Act and Assert
    assertEquals(featuresInfo, featuresInfo);
    int expectedHashCodeResult = featuresInfo.hashCode();
    assertEquals(expectedHashCodeResult, featuresInfo.hashCode());
  }

  /**
   * Test {@link FeaturesInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturesInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FeaturesInfo.equals(Object)", "int FeaturesInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FeaturesInfo featuresInfo = new FeaturesInfo();
    featuresInfo.setEmailEnabled(false);
    featuresInfo.setNotificationEnabled(true);
    featuresInfo.setOauthEnabled(true);
    featuresInfo.setSmsEnabled(true);
    featuresInfo.setTwoFaEnabled(true);

    FeaturesInfo featuresInfo2 = new FeaturesInfo();
    featuresInfo2.setEmailEnabled(true);
    featuresInfo2.setNotificationEnabled(true);
    featuresInfo2.setOauthEnabled(true);
    featuresInfo2.setSmsEnabled(true);
    featuresInfo2.setTwoFaEnabled(true);

    // Act and Assert
    assertNotEquals(featuresInfo, featuresInfo2);
  }

  /**
   * Test {@link FeaturesInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturesInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FeaturesInfo.equals(Object)", "int FeaturesInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FeaturesInfo featuresInfo = new FeaturesInfo();
    featuresInfo.setEmailEnabled(true);
    featuresInfo.setNotificationEnabled(false);
    featuresInfo.setOauthEnabled(true);
    featuresInfo.setSmsEnabled(true);
    featuresInfo.setTwoFaEnabled(true);

    FeaturesInfo featuresInfo2 = new FeaturesInfo();
    featuresInfo2.setEmailEnabled(true);
    featuresInfo2.setNotificationEnabled(true);
    featuresInfo2.setOauthEnabled(true);
    featuresInfo2.setSmsEnabled(true);
    featuresInfo2.setTwoFaEnabled(true);

    // Act and Assert
    assertNotEquals(featuresInfo, featuresInfo2);
  }

  /**
   * Test {@link FeaturesInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturesInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FeaturesInfo.equals(Object)", "int FeaturesInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FeaturesInfo featuresInfo = new FeaturesInfo();
    featuresInfo.setEmailEnabled(true);
    featuresInfo.setNotificationEnabled(true);
    featuresInfo.setOauthEnabled(false);
    featuresInfo.setSmsEnabled(true);
    featuresInfo.setTwoFaEnabled(true);

    FeaturesInfo featuresInfo2 = new FeaturesInfo();
    featuresInfo2.setEmailEnabled(true);
    featuresInfo2.setNotificationEnabled(true);
    featuresInfo2.setOauthEnabled(true);
    featuresInfo2.setSmsEnabled(true);
    featuresInfo2.setTwoFaEnabled(true);

    // Act and Assert
    assertNotEquals(featuresInfo, featuresInfo2);
  }

  /**
   * Test {@link FeaturesInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturesInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FeaturesInfo.equals(Object)", "int FeaturesInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    FeaturesInfo featuresInfo = new FeaturesInfo();
    featuresInfo.setEmailEnabled(true);
    featuresInfo.setNotificationEnabled(true);
    featuresInfo.setOauthEnabled(true);
    featuresInfo.setSmsEnabled(false);
    featuresInfo.setTwoFaEnabled(true);

    FeaturesInfo featuresInfo2 = new FeaturesInfo();
    featuresInfo2.setEmailEnabled(true);
    featuresInfo2.setNotificationEnabled(true);
    featuresInfo2.setOauthEnabled(true);
    featuresInfo2.setSmsEnabled(true);
    featuresInfo2.setTwoFaEnabled(true);

    // Act and Assert
    assertNotEquals(featuresInfo, featuresInfo2);
  }

  /**
   * Test {@link FeaturesInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturesInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FeaturesInfo.equals(Object)", "int FeaturesInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    FeaturesInfo featuresInfo = new FeaturesInfo();
    featuresInfo.setEmailEnabled(true);
    featuresInfo.setNotificationEnabled(true);
    featuresInfo.setOauthEnabled(true);
    featuresInfo.setSmsEnabled(true);
    featuresInfo.setTwoFaEnabled(false);

    FeaturesInfo featuresInfo2 = new FeaturesInfo();
    featuresInfo2.setEmailEnabled(true);
    featuresInfo2.setNotificationEnabled(true);
    featuresInfo2.setOauthEnabled(true);
    featuresInfo2.setSmsEnabled(true);
    featuresInfo2.setTwoFaEnabled(true);

    // Act and Assert
    assertNotEquals(featuresInfo, featuresInfo2);
  }

  /**
   * Test {@link FeaturesInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturesInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FeaturesInfo.equals(Object)", "int FeaturesInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FeaturesInfo featuresInfo = new FeaturesInfo();
    featuresInfo.setEmailEnabled(true);
    featuresInfo.setNotificationEnabled(true);
    featuresInfo.setOauthEnabled(true);
    featuresInfo.setSmsEnabled(true);
    featuresInfo.setTwoFaEnabled(true);

    // Act and Assert
    assertNotEquals(featuresInfo, null);
  }

  /**
   * Test {@link FeaturesInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FeaturesInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FeaturesInfo.equals(Object)", "int FeaturesInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FeaturesInfo featuresInfo = new FeaturesInfo();
    featuresInfo.setEmailEnabled(true);
    featuresInfo.setNotificationEnabled(true);
    featuresInfo.setOauthEnabled(true);
    featuresInfo.setSmsEnabled(true);
    featuresInfo.setTwoFaEnabled(true);

    // Act and Assert
    assertNotEquals(featuresInfo, "Different type to FeaturesInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FeaturesInfo}
   *   <li>{@link FeaturesInfo#setEmailEnabled(boolean)}
   *   <li>{@link FeaturesInfo#setNotificationEnabled(boolean)}
   *   <li>{@link FeaturesInfo#setOauthEnabled(boolean)}
   *   <li>{@link FeaturesInfo#setSmsEnabled(boolean)}
   *   <li>{@link FeaturesInfo#setTwoFaEnabled(boolean)}
   *   <li>{@link FeaturesInfo#toString()}
   *   <li>{@link FeaturesInfo#isEmailEnabled()}
   *   <li>{@link FeaturesInfo#isNotificationEnabled()}
   *   <li>{@link FeaturesInfo#isOauthEnabled()}
   *   <li>{@link FeaturesInfo#isSmsEnabled()}
   *   <li>{@link FeaturesInfo#isTwoFaEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FeaturesInfo.<init>()", "boolean FeaturesInfo.isEmailEnabled()",
      "boolean FeaturesInfo.isNotificationEnabled()", "boolean FeaturesInfo.isOauthEnabled()",
      "boolean FeaturesInfo.isSmsEnabled()", "boolean FeaturesInfo.isTwoFaEnabled()",
      "void FeaturesInfo.setEmailEnabled(boolean)", "void FeaturesInfo.setNotificationEnabled(boolean)",
      "void FeaturesInfo.setOauthEnabled(boolean)", "void FeaturesInfo.setSmsEnabled(boolean)",
      "void FeaturesInfo.setTwoFaEnabled(boolean)", "String FeaturesInfo.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    FeaturesInfo actualFeaturesInfo = new FeaturesInfo();
    actualFeaturesInfo.setEmailEnabled(true);
    actualFeaturesInfo.setNotificationEnabled(true);
    actualFeaturesInfo.setOauthEnabled(true);
    actualFeaturesInfo.setSmsEnabled(true);
    actualFeaturesInfo.setTwoFaEnabled(true);
    String actualToStringResult = actualFeaturesInfo.toString();
    boolean actualIsEmailEnabledResult = actualFeaturesInfo.isEmailEnabled();
    boolean actualIsNotificationEnabledResult = actualFeaturesInfo.isNotificationEnabled();
    boolean actualIsOauthEnabledResult = actualFeaturesInfo.isOauthEnabled();
    boolean actualIsSmsEnabledResult = actualFeaturesInfo.isSmsEnabled();

    // Assert
    assertEquals("FeaturesInfo(isEmailEnabled=true, isSmsEnabled=true, isNotificationEnabled=true, isOauthEnabled=true,"
        + " isTwoFaEnabled=true)", actualToStringResult);
    assertTrue(actualIsEmailEnabledResult);
    assertTrue(actualIsNotificationEnabledResult);
    assertTrue(actualIsOauthEnabledResult);
    assertTrue(actualIsSmsEnabledResult);
    assertTrue(actualFeaturesInfo.isTwoFaEnabled());
  }
}
