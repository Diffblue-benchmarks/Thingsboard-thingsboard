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
import org.junit.jupiter.api.Test;

class FeaturesInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FeaturesInfo#equals(Object)}
   *   <li>{@link FeaturesInfo#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link FeaturesInfo#equals(Object)}
   *   <li>{@link FeaturesInfo#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link FeaturesInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link FeaturesInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link FeaturesInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link FeaturesInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link FeaturesInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link FeaturesInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link FeaturesInfo#equals(Object)}
   */
  @Test
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

    // Assert that nothing has changed
    assertEquals("FeaturesInfo(isEmailEnabled=true, isSmsEnabled=true, isNotificationEnabled=true, isOauthEnabled=true,"
        + " isTwoFaEnabled=true)", actualToStringResult);
    assertTrue(actualIsEmailEnabledResult);
    assertTrue(actualIsNotificationEnabledResult);
    assertTrue(actualIsOauthEnabledResult);
    assertTrue(actualIsSmsEnabledResult);
    assertTrue(actualFeaturesInfo.isTwoFaEnabled());
  }
}
