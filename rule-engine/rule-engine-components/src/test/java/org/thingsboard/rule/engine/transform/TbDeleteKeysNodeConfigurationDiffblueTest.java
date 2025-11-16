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
package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.util.TbMsgSource;

class TbDeleteKeysNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbDeleteKeysNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbDeleteKeysNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbDeleteKeysNodeConfiguration TbDeleteKeysNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbDeleteKeysNodeConfiguration actualDefaultConfigurationResult =
        new TbDeleteKeysNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals(TbMsgSource.DATA, actualDefaultConfigurationResult.getDeleteFrom());
    assertTrue(actualDefaultConfigurationResult.getKeys().isEmpty());
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}, and {@link
   * TbDeleteKeysNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbDeleteKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeleteKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteKeysNodeConfiguration.equals(Object)",
    "int TbDeleteKeysNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration =
        new TbDeleteKeysNodeConfiguration();
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration2 =
        new TbDeleteKeysNodeConfiguration();

    // Act and Assert
    assertEquals(tbDeleteKeysNodeConfiguration, tbDeleteKeysNodeConfiguration2);
    assertEquals(
        tbDeleteKeysNodeConfiguration.hashCode(), tbDeleteKeysNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}, and {@link
   * TbDeleteKeysNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbDeleteKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeleteKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteKeysNodeConfiguration.equals(Object)",
    "int TbDeleteKeysNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration =
        new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration.setDeleteFrom(TbMsgSource.DATA);

    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration2 =
        new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration2.setDeleteFrom(TbMsgSource.DATA);

    // Act and Assert
    assertEquals(tbDeleteKeysNodeConfiguration, tbDeleteKeysNodeConfiguration2);
    assertEquals(
        tbDeleteKeysNodeConfiguration.hashCode(), tbDeleteKeysNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}, and {@link
   * TbDeleteKeysNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbDeleteKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeleteKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteKeysNodeConfiguration.equals(Object)",
    "int TbDeleteKeysNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration =
        new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration.setKeys(new HashSet<>());

    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration2 =
        new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration2.setKeys(new HashSet<>());

    // Act and Assert
    assertEquals(tbDeleteKeysNodeConfiguration, tbDeleteKeysNodeConfiguration2);
    assertEquals(
        tbDeleteKeysNodeConfiguration.hashCode(), tbDeleteKeysNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}, and {@link
   * TbDeleteKeysNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbDeleteKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeleteKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteKeysNodeConfiguration.equals(Object)",
    "int TbDeleteKeysNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration =
        new TbDeleteKeysNodeConfiguration();

    // Act and Assert
    assertEquals(tbDeleteKeysNodeConfiguration, tbDeleteKeysNodeConfiguration);
    int expectedHashCodeResult = tbDeleteKeysNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbDeleteKeysNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteKeysNodeConfiguration.equals(Object)",
    "int TbDeleteKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbDeleteKeysNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteKeysNodeConfiguration.equals(Object)",
    "int TbDeleteKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration =
        new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration.setDeleteFrom(TbMsgSource.DATA);

    // Act and Assert
    assertNotEquals(tbDeleteKeysNodeConfiguration, new TbDeleteKeysNodeConfiguration());
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteKeysNodeConfiguration.equals(Object)",
    "int TbDeleteKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration =
        new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration.setKeys(new HashSet<>());

    // Act and Assert
    assertNotEquals(tbDeleteKeysNodeConfiguration, new TbDeleteKeysNodeConfiguration());
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteKeysNodeConfiguration.equals(Object)",
    "int TbDeleteKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration =
        new TbDeleteKeysNodeConfiguration();

    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration2 =
        new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration2.setDeleteFrom(TbMsgSource.DATA);

    // Act and Assert
    assertNotEquals(tbDeleteKeysNodeConfiguration, tbDeleteKeysNodeConfiguration2);
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteKeysNodeConfiguration.equals(Object)",
    "int TbDeleteKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration =
        new TbDeleteKeysNodeConfiguration();

    TbDeleteKeysNodeConfiguration tbDeleteKeysNodeConfiguration2 =
        new TbDeleteKeysNodeConfiguration();
    tbDeleteKeysNodeConfiguration2.setKeys(new HashSet<>());

    // Act and Assert
    assertNotEquals(tbDeleteKeysNodeConfiguration, tbDeleteKeysNodeConfiguration2);
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteKeysNodeConfiguration.equals(Object)",
    "int TbDeleteKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbDeleteKeysNodeConfiguration(), null);
  }

  /**
   * Test {@link TbDeleteKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteKeysNodeConfiguration.equals(Object)",
    "int TbDeleteKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbDeleteKeysNodeConfiguration(), "Different type to TbDeleteKeysNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbDeleteKeysNodeConfiguration}
   *   <li>{@link TbDeleteKeysNodeConfiguration#setDeleteFrom(TbMsgSource)}
   *   <li>{@link TbDeleteKeysNodeConfiguration#setKeys(Set)}
   *   <li>{@link TbDeleteKeysNodeConfiguration#toString()}
   *   <li>{@link TbDeleteKeysNodeConfiguration#getDeleteFrom()}
   *   <li>{@link TbDeleteKeysNodeConfiguration#getKeys()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbDeleteKeysNodeConfiguration.<init>()",
    "TbMsgSource TbDeleteKeysNodeConfiguration.getDeleteFrom()",
    "Set TbDeleteKeysNodeConfiguration.getKeys()",
    "void TbDeleteKeysNodeConfiguration.setDeleteFrom(TbMsgSource)",
    "void TbDeleteKeysNodeConfiguration.setKeys(Set)",
    "String TbDeleteKeysNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbDeleteKeysNodeConfiguration actualTbDeleteKeysNodeConfiguration =
        new TbDeleteKeysNodeConfiguration();
    actualTbDeleteKeysNodeConfiguration.setDeleteFrom(TbMsgSource.DATA);
    HashSet<String> keys = new HashSet<>();
    actualTbDeleteKeysNodeConfiguration.setKeys(keys);
    String actualToStringResult = actualTbDeleteKeysNodeConfiguration.toString();
    TbMsgSource actualDeleteFrom = actualTbDeleteKeysNodeConfiguration.getDeleteFrom();
    Set<String> actualKeys = actualTbDeleteKeysNodeConfiguration.getKeys();

    // Assert
    assertEquals("TbDeleteKeysNodeConfiguration(deleteFrom=DATA, keys=[])", actualToStringResult);
    assertEquals(TbMsgSource.DATA, actualDeleteFrom);
    assertTrue(actualKeys.isEmpty());
    assertSame(keys, actualKeys);
  }
}
