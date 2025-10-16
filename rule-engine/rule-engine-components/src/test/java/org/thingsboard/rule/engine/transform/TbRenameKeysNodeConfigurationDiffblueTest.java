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
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.util.TbMsgSource;

class TbRenameKeysNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbRenameKeysNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbRenameKeysNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbRenameKeysNodeConfiguration TbRenameKeysNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbRenameKeysNodeConfiguration actualDefaultConfigurationResult =
        new TbRenameKeysNodeConfiguration().defaultConfiguration();

    // Assert
    Map<String, String> renameKeysMapping = actualDefaultConfigurationResult.getRenameKeysMapping();
    assertEquals(1, renameKeysMapping.size());
    assertEquals("temperature", renameKeysMapping.get("temperatureCelsius"));
    assertEquals(TbMsgSource.DATA, actualDefaultConfigurationResult.getRenameIn());
  }

  /**
   * Test {@link TbRenameKeysNodeConfiguration#equals(Object)}, and {@link
   * TbRenameKeysNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbRenameKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbRenameKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRenameKeysNodeConfiguration.equals(Object)",
    "int TbRenameKeysNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration =
        new TbRenameKeysNodeConfiguration();
    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration2 =
        new TbRenameKeysNodeConfiguration();

    // Act and Assert
    assertEquals(tbRenameKeysNodeConfiguration, tbRenameKeysNodeConfiguration2);
    assertEquals(
        tbRenameKeysNodeConfiguration.hashCode(), tbRenameKeysNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbRenameKeysNodeConfiguration#equals(Object)}, and {@link
   * TbRenameKeysNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbRenameKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbRenameKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRenameKeysNodeConfiguration.equals(Object)",
    "int TbRenameKeysNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration =
        new TbRenameKeysNodeConfiguration();
    tbRenameKeysNodeConfiguration.setRenameIn(TbMsgSource.DATA);

    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration2 =
        new TbRenameKeysNodeConfiguration();
    tbRenameKeysNodeConfiguration2.setRenameIn(TbMsgSource.DATA);

    // Act and Assert
    assertEquals(tbRenameKeysNodeConfiguration, tbRenameKeysNodeConfiguration2);
    assertEquals(
        tbRenameKeysNodeConfiguration.hashCode(), tbRenameKeysNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbRenameKeysNodeConfiguration#equals(Object)}, and {@link
   * TbRenameKeysNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbRenameKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbRenameKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRenameKeysNodeConfiguration.equals(Object)",
    "int TbRenameKeysNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration =
        new TbRenameKeysNodeConfiguration();
    tbRenameKeysNodeConfiguration.setRenameKeysMapping(new HashMap<>());

    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration2 =
        new TbRenameKeysNodeConfiguration();
    tbRenameKeysNodeConfiguration2.setRenameKeysMapping(new HashMap<>());

    // Act and Assert
    assertEquals(tbRenameKeysNodeConfiguration, tbRenameKeysNodeConfiguration2);
    assertEquals(
        tbRenameKeysNodeConfiguration.hashCode(), tbRenameKeysNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbRenameKeysNodeConfiguration#equals(Object)}, and {@link
   * TbRenameKeysNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbRenameKeysNodeConfiguration#equals(Object)}
   *   <li>{@link TbRenameKeysNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRenameKeysNodeConfiguration.equals(Object)",
    "int TbRenameKeysNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration =
        new TbRenameKeysNodeConfiguration();

    // Act and Assert
    assertEquals(tbRenameKeysNodeConfiguration, tbRenameKeysNodeConfiguration);
    int expectedHashCodeResult = tbRenameKeysNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbRenameKeysNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbRenameKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRenameKeysNodeConfiguration.equals(Object)",
    "int TbRenameKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRenameKeysNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbRenameKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRenameKeysNodeConfiguration.equals(Object)",
    "int TbRenameKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration =
        new TbRenameKeysNodeConfiguration();
    tbRenameKeysNodeConfiguration.setRenameIn(TbMsgSource.DATA);

    // Act and Assert
    assertNotEquals(tbRenameKeysNodeConfiguration, new TbRenameKeysNodeConfiguration());
  }

  /**
   * Test {@link TbRenameKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRenameKeysNodeConfiguration.equals(Object)",
    "int TbRenameKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration =
        new TbRenameKeysNodeConfiguration();
    tbRenameKeysNodeConfiguration.setRenameKeysMapping(new HashMap<>());

    // Act and Assert
    assertNotEquals(tbRenameKeysNodeConfiguration, new TbRenameKeysNodeConfiguration());
  }

  /**
   * Test {@link TbRenameKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRenameKeysNodeConfiguration.equals(Object)",
    "int TbRenameKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration =
        new TbRenameKeysNodeConfiguration();

    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration2 =
        new TbRenameKeysNodeConfiguration();
    tbRenameKeysNodeConfiguration2.setRenameIn(TbMsgSource.DATA);

    // Act and Assert
    assertNotEquals(tbRenameKeysNodeConfiguration, tbRenameKeysNodeConfiguration2);
  }

  /**
   * Test {@link TbRenameKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRenameKeysNodeConfiguration.equals(Object)",
    "int TbRenameKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration =
        new TbRenameKeysNodeConfiguration();

    TbRenameKeysNodeConfiguration tbRenameKeysNodeConfiguration2 =
        new TbRenameKeysNodeConfiguration();
    tbRenameKeysNodeConfiguration2.setRenameKeysMapping(new HashMap<>());

    // Act and Assert
    assertNotEquals(tbRenameKeysNodeConfiguration, tbRenameKeysNodeConfiguration2);
  }

  /**
   * Test {@link TbRenameKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRenameKeysNodeConfiguration.equals(Object)",
    "int TbRenameKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbRenameKeysNodeConfiguration(), null);
  }

  /**
   * Test {@link TbRenameKeysNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbRenameKeysNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbRenameKeysNodeConfiguration.equals(Object)",
    "int TbRenameKeysNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbRenameKeysNodeConfiguration(), "Different type to TbRenameKeysNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbRenameKeysNodeConfiguration}
   *   <li>{@link TbRenameKeysNodeConfiguration#setRenameIn(TbMsgSource)}
   *   <li>{@link TbRenameKeysNodeConfiguration#setRenameKeysMapping(Map)}
   *   <li>{@link TbRenameKeysNodeConfiguration#toString()}
   *   <li>{@link TbRenameKeysNodeConfiguration#getRenameIn()}
   *   <li>{@link TbRenameKeysNodeConfiguration#getRenameKeysMapping()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbRenameKeysNodeConfiguration.<init>()",
    "TbMsgSource TbRenameKeysNodeConfiguration.getRenameIn()",
    "Map TbRenameKeysNodeConfiguration.getRenameKeysMapping()",
    "void TbRenameKeysNodeConfiguration.setRenameIn(TbMsgSource)",
    "void TbRenameKeysNodeConfiguration.setRenameKeysMapping(Map)",
    "String TbRenameKeysNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbRenameKeysNodeConfiguration actualTbRenameKeysNodeConfiguration =
        new TbRenameKeysNodeConfiguration();
    actualTbRenameKeysNodeConfiguration.setRenameIn(TbMsgSource.DATA);
    HashMap<String, String> renameKeysMapping = new HashMap<>();
    actualTbRenameKeysNodeConfiguration.setRenameKeysMapping(renameKeysMapping);
    String actualToStringResult = actualTbRenameKeysNodeConfiguration.toString();
    TbMsgSource actualRenameIn = actualTbRenameKeysNodeConfiguration.getRenameIn();
    Map<String, String> actualRenameKeysMapping =
        actualTbRenameKeysNodeConfiguration.getRenameKeysMapping();

    // Assert
    assertEquals(
        "TbRenameKeysNodeConfiguration(renameIn=DATA, renameKeysMapping={})", actualToStringResult);
    assertEquals(TbMsgSource.DATA, actualRenameIn);
    assertTrue(actualRenameKeysMapping.isEmpty());
    assertSame(renameKeysMapping, actualRenameKeysMapping);
  }
}
