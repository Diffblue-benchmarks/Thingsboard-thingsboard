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
package org.thingsboard.server.common.data.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OAuth2ClientInfoDiffblueTest {
  /**
   * Test {@link OAuth2ClientInfo#OAuth2ClientInfo(OAuth2Client)}.
   *
   * <p>Method under test: {@link OAuth2ClientInfo#OAuth2ClientInfo(OAuth2Client)}
   */
  @Test
  @DisplayName("Test new OAuth2ClientInfo(OAuth2Client)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2ClientInfo.<init>(OAuth2Client)"})
  void testNewOAuth2ClientInfo() {
    // Arrange and Act
    OAuth2ClientInfo actualOAuth2ClientInfo = new OAuth2ClientInfo(new OAuth2Client());

    // Assert
    assertEquals("", actualOAuth2ClientInfo.getProviderName());
    assertNull(actualOAuth2ClientInfo.getName());
    assertNull(actualOAuth2ClientInfo.getTitle());
    assertNull(actualOAuth2ClientInfo.getPlatforms());
    assertNull(actualOAuth2ClientInfo.getUuidId());
    assertNull(actualOAuth2ClientInfo.getId());
    assertEquals(0L, actualOAuth2ClientInfo.getCreatedTime());
  }

  /**
   * Test {@link OAuth2ClientInfo#equals(Object)}, and {@link OAuth2ClientInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientInfo#equals(Object)}
   *   <li>{@link OAuth2ClientInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2ClientInfo.equals(Object)", "int OAuth2ClientInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OAuth2ClientInfo oAuth2ClientInfo = new OAuth2ClientInfo();
    OAuth2ClientInfo oAuth2ClientInfo2 = new OAuth2ClientInfo();

    // Act and Assert
    assertEquals(oAuth2ClientInfo, oAuth2ClientInfo2);
    assertEquals(oAuth2ClientInfo.hashCode(), oAuth2ClientInfo2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientInfo#equals(Object)}, and {@link OAuth2ClientInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientInfo#equals(Object)}
   *   <li>{@link OAuth2ClientInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2ClientInfo.equals(Object)", "int OAuth2ClientInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OAuth2ClientInfo oAuth2ClientInfo = new OAuth2ClientInfo(new OAuth2Client());
    OAuth2ClientInfo oAuth2ClientInfo2 = new OAuth2ClientInfo(new OAuth2Client());

    // Act and Assert
    assertEquals(oAuth2ClientInfo, oAuth2ClientInfo2);
    assertEquals(oAuth2ClientInfo.hashCode(), oAuth2ClientInfo2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientInfo#equals(Object)}, and {@link OAuth2ClientInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientInfo#equals(Object)}
   *   <li>{@link OAuth2ClientInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2ClientInfo.equals(Object)", "int OAuth2ClientInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OAuth2ClientInfo oAuth2ClientInfo = new OAuth2ClientInfo();
    oAuth2ClientInfo.setTitle("Dr");

    OAuth2ClientInfo oAuth2ClientInfo2 = new OAuth2ClientInfo();
    oAuth2ClientInfo2.setTitle("Dr");

    // Act and Assert
    assertEquals(oAuth2ClientInfo, oAuth2ClientInfo2);
    assertEquals(oAuth2ClientInfo.hashCode(), oAuth2ClientInfo2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientInfo#equals(Object)}, and {@link OAuth2ClientInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientInfo#equals(Object)}
   *   <li>{@link OAuth2ClientInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2ClientInfo.equals(Object)", "int OAuth2ClientInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    OAuth2ClientInfo oAuth2ClientInfo = new OAuth2ClientInfo();
    oAuth2ClientInfo.setPlatforms(new ArrayList<>());

    OAuth2ClientInfo oAuth2ClientInfo2 = new OAuth2ClientInfo();
    oAuth2ClientInfo2.setPlatforms(new ArrayList<>());

    // Act and Assert
    assertEquals(oAuth2ClientInfo, oAuth2ClientInfo2);
    assertEquals(oAuth2ClientInfo.hashCode(), oAuth2ClientInfo2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientInfo#equals(Object)}, and {@link OAuth2ClientInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2ClientInfo#equals(Object)}
   *   <li>{@link OAuth2ClientInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2ClientInfo.equals(Object)", "int OAuth2ClientInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2ClientInfo oAuth2ClientInfo = new OAuth2ClientInfo();

    // Act and Assert
    assertEquals(oAuth2ClientInfo, oAuth2ClientInfo);
    int expectedHashCodeResult = oAuth2ClientInfo.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2ClientInfo.hashCode());
  }

  /**
   * Test {@link OAuth2ClientInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2ClientInfo.equals(Object)", "int OAuth2ClientInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientInfo oAuth2ClientInfo = new OAuth2ClientInfo(new OAuth2Client());

    // Act and Assert
    assertNotEquals(oAuth2ClientInfo, new OAuth2ClientInfo());
  }

  /**
   * Test {@link OAuth2ClientInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2ClientInfo.equals(Object)", "int OAuth2ClientInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OAuth2ClientInfo oAuth2ClientInfo = new OAuth2ClientInfo();

    // Act and Assert
    assertNotEquals(oAuth2ClientInfo, new OAuth2ClientInfo(new OAuth2Client()));
  }

  /**
   * Test {@link OAuth2ClientInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2ClientInfo.equals(Object)", "int OAuth2ClientInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OAuth2ClientInfo oAuth2ClientInfo = new OAuth2ClientInfo();
    oAuth2ClientInfo.setTitle("Dr");

    // Act and Assert
    assertNotEquals(oAuth2ClientInfo, new OAuth2ClientInfo());
  }

  /**
   * Test {@link OAuth2ClientInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2ClientInfo.equals(Object)", "int OAuth2ClientInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OAuth2ClientInfo oAuth2ClientInfo = new OAuth2ClientInfo();
    oAuth2ClientInfo.setPlatforms(new ArrayList<>());

    // Act and Assert
    assertNotEquals(oAuth2ClientInfo, new OAuth2ClientInfo());
  }

  /**
   * Test {@link OAuth2ClientInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2ClientInfo.equals(Object)", "int OAuth2ClientInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OAuth2ClientInfo oAuth2ClientInfo = new OAuth2ClientInfo();
    oAuth2ClientInfo.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(oAuth2ClientInfo, new OAuth2ClientInfo());
  }

  /**
   * Test {@link OAuth2ClientInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2ClientInfo.equals(Object)", "int OAuth2ClientInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OAuth2ClientInfo oAuth2ClientInfo = new OAuth2ClientInfo();

    OAuth2ClientInfo oAuth2ClientInfo2 = new OAuth2ClientInfo();
    oAuth2ClientInfo2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(oAuth2ClientInfo, oAuth2ClientInfo2);
  }

  /**
   * Test {@link OAuth2ClientInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2ClientInfo.equals(Object)", "int OAuth2ClientInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OAuth2ClientInfo oAuth2ClientInfo = new OAuth2ClientInfo();

    OAuth2ClientInfo oAuth2ClientInfo2 = new OAuth2ClientInfo();
    oAuth2ClientInfo2.setPlatforms(new ArrayList<>());

    // Act and Assert
    assertNotEquals(oAuth2ClientInfo, oAuth2ClientInfo2);
  }

  /**
   * Test {@link OAuth2ClientInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2ClientInfo.equals(Object)", "int OAuth2ClientInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2ClientInfo(), null);
  }

  /**
   * Test {@link OAuth2ClientInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2ClientInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2ClientInfo.equals(Object)", "int OAuth2ClientInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2ClientInfo(), "Different type to OAuth2ClientInfo");
  }
}
