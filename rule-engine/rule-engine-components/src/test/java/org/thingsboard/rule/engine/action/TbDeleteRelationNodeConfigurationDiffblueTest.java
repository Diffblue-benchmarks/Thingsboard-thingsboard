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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class TbDeleteRelationNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbDeleteRelationNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbDeleteRelationNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbDeleteRelationNodeConfiguration TbDeleteRelationNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbDeleteRelationNodeConfiguration actualDefaultConfigurationResult =
        new TbDeleteRelationNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals("", actualDefaultConfigurationResult.getEntityNamePattern());
    assertEquals("Contains", actualDefaultConfigurationResult.getRelationType());
    assertNull(actualDefaultConfigurationResult.getEntityTypePattern());
    assertNull(actualDefaultConfigurationResult.getEntityType());
    assertEquals(EntitySearchDirection.FROM, actualDefaultConfigurationResult.getDirection());
    assertFalse(actualDefaultConfigurationResult.isDeleteForSingleEntity());
  }

  /**
   * Test {@link TbDeleteRelationNodeConfiguration#equals(Object)}, and {@link
   * TbDeleteRelationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbDeleteRelationNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeleteRelationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteRelationNodeConfiguration.equals(Object)",
    "int TbDeleteRelationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbDeleteRelationNodeConfiguration tbDeleteRelationNodeConfiguration =
        new TbDeleteRelationNodeConfiguration();
    TbDeleteRelationNodeConfiguration tbDeleteRelationNodeConfiguration2 =
        new TbDeleteRelationNodeConfiguration();

    // Act and Assert
    assertEquals(tbDeleteRelationNodeConfiguration, tbDeleteRelationNodeConfiguration2);
    assertEquals(
        tbDeleteRelationNodeConfiguration.hashCode(),
        tbDeleteRelationNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbDeleteRelationNodeConfiguration#equals(Object)}, and {@link
   * TbDeleteRelationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbDeleteRelationNodeConfiguration#equals(Object)}
   *   <li>{@link TbDeleteRelationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteRelationNodeConfiguration.equals(Object)",
    "int TbDeleteRelationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbDeleteRelationNodeConfiguration tbDeleteRelationNodeConfiguration =
        new TbDeleteRelationNodeConfiguration();

    // Act and Assert
    assertEquals(tbDeleteRelationNodeConfiguration, tbDeleteRelationNodeConfiguration);
    int expectedHashCodeResult = tbDeleteRelationNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbDeleteRelationNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbDeleteRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteRelationNodeConfiguration.equals(Object)",
    "int TbDeleteRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbDeleteRelationNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbDeleteRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteRelationNodeConfiguration.equals(Object)",
    "int TbDeleteRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbDeleteRelationNodeConfiguration tbDeleteRelationNodeConfiguration =
        new TbDeleteRelationNodeConfiguration();
    tbDeleteRelationNodeConfiguration.setDeleteForSingleEntity(true);

    // Act and Assert
    assertNotEquals(tbDeleteRelationNodeConfiguration, new TbDeleteRelationNodeConfiguration());
  }

  /**
   * Test {@link TbDeleteRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteRelationNodeConfiguration.equals(Object)",
    "int TbDeleteRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbDeleteRelationNodeConfiguration tbDeleteRelationNodeConfiguration =
        new TbDeleteRelationNodeConfiguration();
    tbDeleteRelationNodeConfiguration.setDirection(EntitySearchDirection.FROM);

    // Act and Assert
    assertNotEquals(tbDeleteRelationNodeConfiguration, new TbDeleteRelationNodeConfiguration());
  }

  /**
   * Test {@link TbDeleteRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteRelationNodeConfiguration.equals(Object)",
    "int TbDeleteRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbDeleteRelationNodeConfiguration(), null);
  }

  /**
   * Test {@link TbDeleteRelationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbDeleteRelationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbDeleteRelationNodeConfiguration.equals(Object)",
    "int TbDeleteRelationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbDeleteRelationNodeConfiguration(),
        "Different type to TbDeleteRelationNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbDeleteRelationNodeConfiguration}
   *   <li>{@link TbDeleteRelationNodeConfiguration#setDeleteForSingleEntity(boolean)}
   *   <li>{@link TbDeleteRelationNodeConfiguration#toString()}
   *   <li>{@link TbDeleteRelationNodeConfiguration#isDeleteForSingleEntity()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbDeleteRelationNodeConfiguration.<init>()",
    "boolean TbDeleteRelationNodeConfiguration.isDeleteForSingleEntity()",
    "void TbDeleteRelationNodeConfiguration.setDeleteForSingleEntity(boolean)",
    "String TbDeleteRelationNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbDeleteRelationNodeConfiguration actualTbDeleteRelationNodeConfiguration =
        new TbDeleteRelationNodeConfiguration();
    actualTbDeleteRelationNodeConfiguration.setDeleteForSingleEntity(true);
    String actualToStringResult = actualTbDeleteRelationNodeConfiguration.toString();
    boolean actualIsDeleteForSingleEntityResult =
        actualTbDeleteRelationNodeConfiguration.isDeleteForSingleEntity();

    // Assert
    assertEquals(
        "TbDeleteRelationNodeConfiguration(deleteForSingleEntity=true)", actualToStringResult);
    assertNull(actualTbDeleteRelationNodeConfiguration.getEntityNamePattern());
    assertNull(actualTbDeleteRelationNodeConfiguration.getEntityTypePattern());
    assertNull(actualTbDeleteRelationNodeConfiguration.getRelationType());
    assertNull(actualTbDeleteRelationNodeConfiguration.getEntityType());
    assertNull(actualTbDeleteRelationNodeConfiguration.getDirection());
    assertTrue(actualIsDeleteForSingleEntityResult);
  }
}
