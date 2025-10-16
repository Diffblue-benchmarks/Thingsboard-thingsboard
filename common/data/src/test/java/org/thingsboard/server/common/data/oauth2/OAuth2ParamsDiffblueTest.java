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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class OAuth2ParamsDiffblueTest {
  /**
   * Test {@link OAuth2Params#equals(Object)}, and {@link OAuth2Params#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2Params#equals(Object)}
   *   <li>{@link OAuth2Params#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Params.equals(Object)", "int OAuth2Params.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OAuth2Params oAuth2Params = new OAuth2Params();
    OAuth2Params oAuth2Params2 = new OAuth2Params();

    // Act and Assert
    assertEquals(oAuth2Params, oAuth2Params2);
    assertEquals(oAuth2Params.hashCode(), oAuth2Params2.hashCode());
  }

  /**
   * Test {@link OAuth2Params#equals(Object)}, and {@link OAuth2Params#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2Params#equals(Object)}
   *   <li>{@link OAuth2Params#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Params.equals(Object)", "int OAuth2Params.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OAuth2Params oAuth2Params = new OAuth2Params();
    oAuth2Params.setTenantId(TenantId.SYS_TENANT_ID);

    OAuth2Params oAuth2Params2 = new OAuth2Params();
    oAuth2Params2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(oAuth2Params, oAuth2Params2);
    assertEquals(oAuth2Params.hashCode(), oAuth2Params2.hashCode());
  }

  /**
   * Test {@link OAuth2Params#equals(Object)}, and {@link OAuth2Params#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2Params#equals(Object)}
   *   <li>{@link OAuth2Params#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Params.equals(Object)", "int OAuth2Params.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2Params oAuth2Params = new OAuth2Params();

    // Act and Assert
    assertEquals(oAuth2Params, oAuth2Params);
    int expectedHashCodeResult = oAuth2Params.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2Params.hashCode());
  }

  /**
   * Test {@link OAuth2Params#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Params#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Params.equals(Object)", "int OAuth2Params.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2Params(), 1);
  }

  /**
   * Test {@link OAuth2Params#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Params#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Params.equals(Object)", "int OAuth2Params.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OAuth2Params oAuth2Params = new OAuth2Params();
    oAuth2Params.setEnabled(true);

    // Act and Assert
    assertNotEquals(oAuth2Params, new OAuth2Params());
  }

  /**
   * Test {@link OAuth2Params#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Params#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Params.equals(Object)", "int OAuth2Params.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OAuth2Params oAuth2Params = new OAuth2Params();
    oAuth2Params.setEdgeEnabled(true);

    // Act and Assert
    assertNotEquals(oAuth2Params, new OAuth2Params());
  }

  /**
   * Test {@link OAuth2Params#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Params#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Params.equals(Object)", "int OAuth2Params.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OAuth2Params oAuth2Params = new OAuth2Params();
    oAuth2Params.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(oAuth2Params, new OAuth2Params());
  }

  /**
   * Test {@link OAuth2Params#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Params#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Params.equals(Object)", "int OAuth2Params.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OAuth2Params oAuth2Params = new OAuth2Params();
    oAuth2Params.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(oAuth2Params, new OAuth2Params());
  }

  /**
   * Test {@link OAuth2Params#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Params#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Params.equals(Object)", "int OAuth2Params.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OAuth2Params oAuth2Params = new OAuth2Params();

    OAuth2Params oAuth2Params2 = new OAuth2Params();
    oAuth2Params2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(oAuth2Params, oAuth2Params2);
  }

  /**
   * Test {@link OAuth2Params#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Params#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Params.equals(Object)", "int OAuth2Params.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2Params(), null);
  }

  /**
   * Test {@link OAuth2Params#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OAuth2Params#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OAuth2Params.equals(Object)", "int OAuth2Params.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OAuth2Params(), "Different type to OAuth2Params");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OAuth2Params#OAuth2Params()}
   *   <li>{@link OAuth2Params#setEdgeEnabled(boolean)}
   *   <li>{@link OAuth2Params#setEnabled(boolean)}
   *   <li>{@link OAuth2Params#setTenantId(TenantId)}
   *   <li>{@link OAuth2Params#toString()}
   *   <li>{@link OAuth2Params#getTenantId()}
   *   <li>{@link OAuth2Params#isEdgeEnabled()}
   *   <li>{@link OAuth2Params#isEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OAuth2Params.<init>()",
    "TenantId OAuth2Params.getTenantId()",
    "boolean OAuth2Params.isEdgeEnabled()",
    "boolean OAuth2Params.isEnabled()",
    "void OAuth2Params.setEdgeEnabled(boolean)",
    "void OAuth2Params.setEnabled(boolean)",
    "void OAuth2Params.setTenantId(TenantId)",
    "String OAuth2Params.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    OAuth2Params actualOAuth2Params = new OAuth2Params();
    actualOAuth2Params.setEdgeEnabled(true);
    actualOAuth2Params.setEnabled(true);
    actualOAuth2Params.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualOAuth2Params.toString();
    TenantId actualTenantId = actualOAuth2Params.getTenantId();
    boolean actualIsEdgeEnabledResult = actualOAuth2Params.isEdgeEnabled();
    boolean actualIsEnabledResult = actualOAuth2Params.isEnabled();

    // Assert
    assertEquals(
        "OAuth2Params(enabled=true, edgeEnabled=true, tenantId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertNull(actualOAuth2Params.getId());
    assertEquals(0L, actualOAuth2Params.getCreatedTime());
    assertTrue(actualIsEdgeEnabledResult);
    assertTrue(actualIsEnabledResult);
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link OAuth2Params#OAuth2Params(OAuth2Params)}.
   *
   * <p>Method under test: {@link OAuth2Params#OAuth2Params(OAuth2Params)}
   */
  @Test
  @DisplayName("Test new OAuth2Params(OAuth2Params)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OAuth2Params.<init>(OAuth2Params)"})
  void testNewOAuth2Params() {
    // Arrange
    OAuth2Params oauth2Params = new OAuth2Params();

    // Act
    OAuth2Params actualOAuth2Params = new OAuth2Params(oauth2Params);

    // Assert
    assertEquals(oauth2Params, actualOAuth2Params);
  }
}
