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
package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;

class MobileAppOauth2ClientDiffblueTest {
  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}, and {@link
   * MobileAppOauth2Client#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppOauth2Client#equals(Object)}
   *   <li>{@link MobileAppOauth2Client#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2Client.equals(Object)",
    "int MobileAppOauth2Client.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();
    MobileAppOauth2Client mobileAppOauth2Client2 = new MobileAppOauth2Client();

    // Act and Assert
    assertEquals(mobileAppOauth2Client, mobileAppOauth2Client2);
    assertEquals(mobileAppOauth2Client.hashCode(), mobileAppOauth2Client2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}, and {@link
   * MobileAppOauth2Client#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppOauth2Client#equals(Object)}
   *   <li>{@link MobileAppOauth2Client#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2Client.equals(Object)",
    "int MobileAppOauth2Client.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();
    mobileAppOauth2Client.setMobileAppId(new MobileAppId(EntityId.NULL_UUID));

    MobileAppOauth2Client mobileAppOauth2Client2 = new MobileAppOauth2Client();
    mobileAppOauth2Client2.setMobileAppId(new MobileAppId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals(mobileAppOauth2Client, mobileAppOauth2Client2);
    assertEquals(mobileAppOauth2Client.hashCode(), mobileAppOauth2Client2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}, and {@link
   * MobileAppOauth2Client#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppOauth2Client#equals(Object)}
   *   <li>{@link MobileAppOauth2Client#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2Client.equals(Object)",
    "int MobileAppOauth2Client.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();

    // Act and Assert
    assertEquals(mobileAppOauth2Client, mobileAppOauth2Client);
    int expectedHashCodeResult = mobileAppOauth2Client.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2Client.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2Client.equals(Object)",
    "int MobileAppOauth2Client.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppOauth2Client(), 1);
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2Client.equals(Object)",
    "int MobileAppOauth2Client.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();
    mobileAppOauth2Client.setMobileAppId(new MobileAppId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(mobileAppOauth2Client, new MobileAppOauth2Client());
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2Client.equals(Object)",
    "int MobileAppOauth2Client.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();
    mobileAppOauth2Client.setOAuth2ClientId(new OAuth2ClientId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(mobileAppOauth2Client, new MobileAppOauth2Client());
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2Client.equals(Object)",
    "int MobileAppOauth2Client.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();

    MobileAppOauth2Client mobileAppOauth2Client2 = new MobileAppOauth2Client();
    mobileAppOauth2Client2.setMobileAppId(new MobileAppId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(mobileAppOauth2Client, mobileAppOauth2Client2);
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2Client.equals(Object)",
    "int MobileAppOauth2Client.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();

    MobileAppOauth2Client mobileAppOauth2Client2 = new MobileAppOauth2Client();
    mobileAppOauth2Client2.setOAuth2ClientId(new OAuth2ClientId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(mobileAppOauth2Client, mobileAppOauth2Client2);
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2Client.equals(Object)",
    "int MobileAppOauth2Client.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppOauth2Client(), null);
  }

  /**
   * Test {@link MobileAppOauth2Client#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppOauth2Client.equals(Object)",
    "int MobileAppOauth2Client.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppOauth2Client(), "Different type to MobileAppOauth2Client");
  }
}
