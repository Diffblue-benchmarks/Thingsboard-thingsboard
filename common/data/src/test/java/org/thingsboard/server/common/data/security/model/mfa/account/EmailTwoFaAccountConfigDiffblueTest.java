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
package org.thingsboard.server.common.data.security.model.mfa.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

class EmailTwoFaAccountConfigDiffblueTest {
  /**
   * Test {@link EmailTwoFaAccountConfig#equals(Object)}, and {@link EmailTwoFaAccountConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTwoFaAccountConfig#equals(Object)}
   *   <li>{@link EmailTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailTwoFaAccountConfig.equals(Object)", "int EmailTwoFaAccountConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();
    emailTwoFaAccountConfig.setEmail("jane.doe@example.org");
    emailTwoFaAccountConfig.setSerializeHiddenFields(true);
    emailTwoFaAccountConfig.setUseByDefault(true);

    EmailTwoFaAccountConfig emailTwoFaAccountConfig2 = new EmailTwoFaAccountConfig();
    emailTwoFaAccountConfig2.setEmail("jane.doe@example.org");
    emailTwoFaAccountConfig2.setSerializeHiddenFields(true);
    emailTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertEquals(emailTwoFaAccountConfig, emailTwoFaAccountConfig2);
    int expectedHashCodeResult = emailTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, emailTwoFaAccountConfig2.hashCode());
  }

  /**
   * Test {@link EmailTwoFaAccountConfig#equals(Object)}, and {@link EmailTwoFaAccountConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTwoFaAccountConfig#equals(Object)}
   *   <li>{@link EmailTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailTwoFaAccountConfig.equals(Object)", "int EmailTwoFaAccountConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();
    emailTwoFaAccountConfig.setEmail(null);
    emailTwoFaAccountConfig.setSerializeHiddenFields(true);
    emailTwoFaAccountConfig.setUseByDefault(true);

    EmailTwoFaAccountConfig emailTwoFaAccountConfig2 = new EmailTwoFaAccountConfig();
    emailTwoFaAccountConfig2.setEmail(null);
    emailTwoFaAccountConfig2.setSerializeHiddenFields(true);
    emailTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertEquals(emailTwoFaAccountConfig, emailTwoFaAccountConfig2);
    int expectedHashCodeResult = emailTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, emailTwoFaAccountConfig2.hashCode());
  }

  /**
   * Test {@link EmailTwoFaAccountConfig#equals(Object)}, and {@link EmailTwoFaAccountConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTwoFaAccountConfig#equals(Object)}
   *   <li>{@link EmailTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailTwoFaAccountConfig.equals(Object)", "int EmailTwoFaAccountConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();
    emailTwoFaAccountConfig.setEmail("jane.doe@example.org");
    emailTwoFaAccountConfig.setSerializeHiddenFields(true);
    emailTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertEquals(emailTwoFaAccountConfig, emailTwoFaAccountConfig);
    int expectedHashCodeResult = emailTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, emailTwoFaAccountConfig.hashCode());
  }

  /**
   * Test {@link EmailTwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailTwoFaAccountConfig.equals(Object)", "int EmailTwoFaAccountConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();
    emailTwoFaAccountConfig.setEmail("john.smith@example.org");
    emailTwoFaAccountConfig.setSerializeHiddenFields(true);
    emailTwoFaAccountConfig.setUseByDefault(true);

    EmailTwoFaAccountConfig emailTwoFaAccountConfig2 = new EmailTwoFaAccountConfig();
    emailTwoFaAccountConfig2.setEmail("jane.doe@example.org");
    emailTwoFaAccountConfig2.setSerializeHiddenFields(true);
    emailTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(emailTwoFaAccountConfig, emailTwoFaAccountConfig2);
  }

  /**
   * Test {@link EmailTwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailTwoFaAccountConfig.equals(Object)", "int EmailTwoFaAccountConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();
    emailTwoFaAccountConfig.setEmail(null);
    emailTwoFaAccountConfig.setSerializeHiddenFields(true);
    emailTwoFaAccountConfig.setUseByDefault(true);

    EmailTwoFaAccountConfig emailTwoFaAccountConfig2 = new EmailTwoFaAccountConfig();
    emailTwoFaAccountConfig2.setEmail("jane.doe@example.org");
    emailTwoFaAccountConfig2.setSerializeHiddenFields(true);
    emailTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(emailTwoFaAccountConfig, emailTwoFaAccountConfig2);
  }

  /**
   * Test {@link EmailTwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailTwoFaAccountConfig.equals(Object)", "int EmailTwoFaAccountConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();
    emailTwoFaAccountConfig.setEmail("jane.doe@example.org");
    emailTwoFaAccountConfig.setSerializeHiddenFields(true);
    emailTwoFaAccountConfig.setUseByDefault(false);

    EmailTwoFaAccountConfig emailTwoFaAccountConfig2 = new EmailTwoFaAccountConfig();
    emailTwoFaAccountConfig2.setEmail("jane.doe@example.org");
    emailTwoFaAccountConfig2.setSerializeHiddenFields(true);
    emailTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(emailTwoFaAccountConfig, emailTwoFaAccountConfig2);
  }

  /**
   * Test {@link EmailTwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailTwoFaAccountConfig.equals(Object)", "int EmailTwoFaAccountConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();
    emailTwoFaAccountConfig.setEmail("jane.doe@example.org");
    emailTwoFaAccountConfig.setSerializeHiddenFields(true);
    emailTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(emailTwoFaAccountConfig, null);
  }

  /**
   * Test {@link EmailTwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailTwoFaAccountConfig.equals(Object)", "int EmailTwoFaAccountConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();
    emailTwoFaAccountConfig.setEmail("jane.doe@example.org");
    emailTwoFaAccountConfig.setSerializeHiddenFields(true);
    emailTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(emailTwoFaAccountConfig, "Different type to EmailTwoFaAccountConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EmailTwoFaAccountConfig}
   *   <li>{@link EmailTwoFaAccountConfig#setEmail(String)}
   *   <li>{@link EmailTwoFaAccountConfig#toString()}
   *   <li>{@link EmailTwoFaAccountConfig#getEmail()}
   *   <li>{@link EmailTwoFaAccountConfig#getProviderType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EmailTwoFaAccountConfig.<init>()", "String EmailTwoFaAccountConfig.getEmail()",
      "TwoFaProviderType EmailTwoFaAccountConfig.getProviderType()", "void EmailTwoFaAccountConfig.setEmail(String)",
      "String EmailTwoFaAccountConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EmailTwoFaAccountConfig actualEmailTwoFaAccountConfig = new EmailTwoFaAccountConfig();
    actualEmailTwoFaAccountConfig.setEmail("jane.doe@example.org");
    String actualToStringResult = actualEmailTwoFaAccountConfig.toString();
    String actualEmail = actualEmailTwoFaAccountConfig.getEmail();

    // Assert
    assertEquals("EmailTwoFaAccountConfig(email=jane.doe@example.org)", actualToStringResult);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals(TwoFaProviderType.EMAIL, actualEmailTwoFaAccountConfig.getProviderType());
    assertFalse(actualEmailTwoFaAccountConfig.isSerializeHiddenFields());
    assertFalse(actualEmailTwoFaAccountConfig.isUseByDefault());
  }
}
