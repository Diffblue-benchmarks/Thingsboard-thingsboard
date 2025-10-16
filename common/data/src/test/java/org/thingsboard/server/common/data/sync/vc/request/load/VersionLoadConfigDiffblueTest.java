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
package org.thingsboard.server.common.data.sync.vc.request.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VersionLoadConfigDiffblueTest {
  /**
   * Test {@link VersionLoadConfig#equals(Object)}, and {@link VersionLoadConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionLoadConfig#equals(Object)}
   *   <li>{@link VersionLoadConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionLoadConfig.equals(Object)",
    "int VersionLoadConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    VersionLoadConfig versionLoadConfig2 = new VersionLoadConfig();
    versionLoadConfig2.setLoadAttributes(true);
    versionLoadConfig2.setLoadCredentials(true);
    versionLoadConfig2.setLoadRelations(true);

    // Act and Assert
    assertEquals(versionLoadConfig, versionLoadConfig2);
    assertEquals(versionLoadConfig.hashCode(), versionLoadConfig2.hashCode());
  }

  /**
   * Test {@link VersionLoadConfig#equals(Object)}, and {@link VersionLoadConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionLoadConfig#equals(Object)}
   *   <li>{@link VersionLoadConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionLoadConfig.equals(Object)",
    "int VersionLoadConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    // Act and Assert
    assertEquals(versionLoadConfig, versionLoadConfig);
    int expectedHashCodeResult = versionLoadConfig.hashCode();
    assertEquals(expectedHashCodeResult, versionLoadConfig.hashCode());
  }

  /**
   * Test {@link VersionLoadConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionLoadConfig.equals(Object)",
    "int VersionLoadConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(false);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    VersionLoadConfig versionLoadConfig2 = new VersionLoadConfig();
    versionLoadConfig2.setLoadAttributes(true);
    versionLoadConfig2.setLoadCredentials(true);
    versionLoadConfig2.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, versionLoadConfig2);
  }

  /**
   * Test {@link VersionLoadConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionLoadConfig.equals(Object)",
    "int VersionLoadConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(false);
    versionLoadConfig.setLoadRelations(true);

    VersionLoadConfig versionLoadConfig2 = new VersionLoadConfig();
    versionLoadConfig2.setLoadAttributes(true);
    versionLoadConfig2.setLoadCredentials(true);
    versionLoadConfig2.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, versionLoadConfig2);
  }

  /**
   * Test {@link VersionLoadConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionLoadConfig.equals(Object)",
    "int VersionLoadConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(false);

    VersionLoadConfig versionLoadConfig2 = new VersionLoadConfig();
    versionLoadConfig2.setLoadAttributes(true);
    versionLoadConfig2.setLoadCredentials(true);
    versionLoadConfig2.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, versionLoadConfig2);
  }

  /**
   * Test {@link VersionLoadConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionLoadConfig.equals(Object)",
    "int VersionLoadConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, null);
  }

  /**
   * Test {@link VersionLoadConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean VersionLoadConfig.equals(Object)",
    "int VersionLoadConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    VersionLoadConfig versionLoadConfig = new VersionLoadConfig();
    versionLoadConfig.setLoadAttributes(true);
    versionLoadConfig.setLoadCredentials(true);
    versionLoadConfig.setLoadRelations(true);

    // Act and Assert
    assertNotEquals(versionLoadConfig, "Different type to VersionLoadConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link VersionLoadConfig}
   *   <li>{@link VersionLoadConfig#setLoadAttributes(boolean)}
   *   <li>{@link VersionLoadConfig#setLoadCredentials(boolean)}
   *   <li>{@link VersionLoadConfig#setLoadRelations(boolean)}
   *   <li>{@link VersionLoadConfig#toString()}
   *   <li>{@link VersionLoadConfig#isLoadAttributes()}
   *   <li>{@link VersionLoadConfig#isLoadCredentials()}
   *   <li>{@link VersionLoadConfig#isLoadRelations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void VersionLoadConfig.<init>()",
    "boolean VersionLoadConfig.isLoadAttributes()",
    "boolean VersionLoadConfig.isLoadCredentials()",
    "boolean VersionLoadConfig.isLoadRelations()",
    "void VersionLoadConfig.setLoadAttributes(boolean)",
    "void VersionLoadConfig.setLoadCredentials(boolean)",
    "void VersionLoadConfig.setLoadRelations(boolean)",
    "String VersionLoadConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    VersionLoadConfig actualVersionLoadConfig = new VersionLoadConfig();
    actualVersionLoadConfig.setLoadAttributes(true);
    actualVersionLoadConfig.setLoadCredentials(true);
    actualVersionLoadConfig.setLoadRelations(true);
    String actualToStringResult = actualVersionLoadConfig.toString();
    boolean actualIsLoadAttributesResult = actualVersionLoadConfig.isLoadAttributes();
    boolean actualIsLoadCredentialsResult = actualVersionLoadConfig.isLoadCredentials();

    // Assert
    assertEquals(
        "VersionLoadConfig(loadRelations=true, loadAttributes=true, loadCredentials=true)",
        actualToStringResult);
    assertTrue(actualIsLoadAttributesResult);
    assertTrue(actualIsLoadCredentialsResult);
    assertTrue(actualVersionLoadConfig.isLoadRelations());
  }
}
