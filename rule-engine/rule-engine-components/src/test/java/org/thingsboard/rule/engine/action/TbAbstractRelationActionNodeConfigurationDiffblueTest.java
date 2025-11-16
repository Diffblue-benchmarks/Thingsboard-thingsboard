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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class TbAbstractRelationActionNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbAbstractRelationActionNodeConfiguration.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TbCreateRelationNodeConfiguration().canEqual("Other"));
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link TbCreateRelationNodeConfiguration} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName(
      "Test canEqual(Object); when TbCreateRelationNodeConfiguration (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbAbstractRelationActionNodeConfiguration.canEqual(Object)"})
  void testCanEqual_whenTbCreateRelationNodeConfiguration_thenReturnTrue() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();

    // Act and Assert
    assertTrue(tbCreateRelationNodeConfiguration.canEqual(new TbCreateRelationNodeConfiguration()));
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}, and {@link
   * TbAbstractRelationActionNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration2 =
        new TbCreateRelationNodeConfiguration();

    // Act and Assert
    assertEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration2);
    assertEquals(
        tbCreateRelationNodeConfiguration.hashCode(),
        tbCreateRelationNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}, and {@link
   * TbAbstractRelationActionNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();

    // Act and Assert
    assertEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration);
    int expectedHashCodeResult = tbCreateRelationNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbCreateRelationNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCreateRelationNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();

    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration2 =
        mock(TbCreateRelationNodeConfiguration.class);
    when(tbCreateRelationNodeConfiguration2.isChangeOriginatorToRelatedEntity()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isCreateEntityIfNotExists()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isRemoveCurrentRelations()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.getEntityNamePattern())
        .thenReturn("Entity Name Pattern");
    when(tbCreateRelationNodeConfiguration2.getEntityTypePattern())
        .thenReturn("Entity Type Pattern");
    when(tbCreateRelationNodeConfiguration2.getRelationType()).thenReturn("Relation Type");
    when(tbCreateRelationNodeConfiguration2.getEntityType()).thenReturn(EntityType.TENANT);
    when(tbCreateRelationNodeConfiguration2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(tbCreateRelationNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setDirection(EntitySearchDirection.FROM);

    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration2 =
        mock(TbCreateRelationNodeConfiguration.class);
    when(tbCreateRelationNodeConfiguration2.isChangeOriginatorToRelatedEntity()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isCreateEntityIfNotExists()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isRemoveCurrentRelations()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.getEntityNamePattern())
        .thenReturn("Entity Name Pattern");
    when(tbCreateRelationNodeConfiguration2.getEntityTypePattern())
        .thenReturn("Entity Type Pattern");
    when(tbCreateRelationNodeConfiguration2.getRelationType()).thenReturn("Relation Type");
    when(tbCreateRelationNodeConfiguration2.getEntityType()).thenReturn(EntityType.TENANT);
    when(tbCreateRelationNodeConfiguration2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(tbCreateRelationNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setDirection(EntitySearchDirection.TO);

    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration2 =
        mock(TbCreateRelationNodeConfiguration.class);
    when(tbCreateRelationNodeConfiguration2.isChangeOriginatorToRelatedEntity()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isCreateEntityIfNotExists()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isRemoveCurrentRelations()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.getEntityNamePattern())
        .thenReturn("Entity Name Pattern");
    when(tbCreateRelationNodeConfiguration2.getEntityTypePattern())
        .thenReturn("Entity Type Pattern");
    when(tbCreateRelationNodeConfiguration2.getRelationType()).thenReturn("Relation Type");
    when(tbCreateRelationNodeConfiguration2.getEntityType()).thenReturn(EntityType.TENANT);
    when(tbCreateRelationNodeConfiguration2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(tbCreateRelationNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setDirection(EntitySearchDirection.FROM);

    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration2 =
        mock(TbCreateRelationNodeConfiguration.class);
    when(tbCreateRelationNodeConfiguration2.isChangeOriginatorToRelatedEntity()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isCreateEntityIfNotExists()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isRemoveCurrentRelations()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.getEntityNamePattern())
        .thenReturn("Entity Name Pattern");
    when(tbCreateRelationNodeConfiguration2.getEntityTypePattern())
        .thenReturn("Entity Type Pattern");
    when(tbCreateRelationNodeConfiguration2.getRelationType()).thenReturn(null);
    when(tbCreateRelationNodeConfiguration2.getEntityType()).thenReturn(EntityType.TENANT);
    when(tbCreateRelationNodeConfiguration2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(tbCreateRelationNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setRelationType("Relation Type");
    tbCreateRelationNodeConfiguration.setDirection(EntitySearchDirection.FROM);

    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration2 =
        mock(TbCreateRelationNodeConfiguration.class);
    when(tbCreateRelationNodeConfiguration2.isChangeOriginatorToRelatedEntity()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isCreateEntityIfNotExists()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isRemoveCurrentRelations()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.getEntityNamePattern())
        .thenReturn("Entity Name Pattern");
    when(tbCreateRelationNodeConfiguration2.getEntityTypePattern())
        .thenReturn("Entity Type Pattern");
    when(tbCreateRelationNodeConfiguration2.getRelationType()).thenReturn(null);
    when(tbCreateRelationNodeConfiguration2.getEntityType()).thenReturn(EntityType.TENANT);
    when(tbCreateRelationNodeConfiguration2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(tbCreateRelationNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setEntityType(EntityType.TENANT);
    tbCreateRelationNodeConfiguration.setDirection(EntitySearchDirection.FROM);

    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration2 =
        mock(TbCreateRelationNodeConfiguration.class);
    when(tbCreateRelationNodeConfiguration2.isChangeOriginatorToRelatedEntity()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isCreateEntityIfNotExists()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isRemoveCurrentRelations()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.getEntityNamePattern())
        .thenReturn("Entity Name Pattern");
    when(tbCreateRelationNodeConfiguration2.getEntityTypePattern())
        .thenReturn("Entity Type Pattern");
    when(tbCreateRelationNodeConfiguration2.getRelationType()).thenReturn(null);
    when(tbCreateRelationNodeConfiguration2.getEntityType()).thenReturn(EntityType.TENANT);
    when(tbCreateRelationNodeConfiguration2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(tbCreateRelationNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setEntityType(EntityType.CUSTOMER);
    tbCreateRelationNodeConfiguration.setDirection(EntitySearchDirection.FROM);

    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration2 =
        mock(TbCreateRelationNodeConfiguration.class);
    when(tbCreateRelationNodeConfiguration2.isChangeOriginatorToRelatedEntity()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isCreateEntityIfNotExists()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isRemoveCurrentRelations()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.getEntityNamePattern())
        .thenReturn("Entity Name Pattern");
    when(tbCreateRelationNodeConfiguration2.getEntityTypePattern())
        .thenReturn("Entity Type Pattern");
    when(tbCreateRelationNodeConfiguration2.getRelationType()).thenReturn(null);
    when(tbCreateRelationNodeConfiguration2.getEntityType()).thenReturn(EntityType.TENANT);
    when(tbCreateRelationNodeConfiguration2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(tbCreateRelationNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setRelationType("Relation Type");
    tbCreateRelationNodeConfiguration.setDirection(EntitySearchDirection.FROM);

    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration2 =
        mock(TbCreateRelationNodeConfiguration.class);
    when(tbCreateRelationNodeConfiguration2.isChangeOriginatorToRelatedEntity()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isCreateEntityIfNotExists()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isRemoveCurrentRelations()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.getEntityNamePattern())
        .thenReturn("Entity Name Pattern");
    when(tbCreateRelationNodeConfiguration2.getEntityTypePattern())
        .thenReturn("Entity Type Pattern");
    when(tbCreateRelationNodeConfiguration2.getRelationType()).thenReturn("Relation Type");
    when(tbCreateRelationNodeConfiguration2.getEntityType()).thenReturn(EntityType.TENANT);
    when(tbCreateRelationNodeConfiguration2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(tbCreateRelationNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setEntityType(EntityType.TENANT);
    tbCreateRelationNodeConfiguration.setDirection(EntitySearchDirection.FROM);

    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration2 =
        mock(TbCreateRelationNodeConfiguration.class);
    when(tbCreateRelationNodeConfiguration2.isChangeOriginatorToRelatedEntity()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isCreateEntityIfNotExists()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isRemoveCurrentRelations()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.getEntityNamePattern()).thenReturn(null);
    when(tbCreateRelationNodeConfiguration2.getEntityTypePattern())
        .thenReturn("Entity Type Pattern");
    when(tbCreateRelationNodeConfiguration2.getRelationType()).thenReturn(null);
    when(tbCreateRelationNodeConfiguration2.getEntityType()).thenReturn(EntityType.TENANT);
    when(tbCreateRelationNodeConfiguration2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(tbCreateRelationNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setEntityNamePattern("Entity Name Pattern");
    tbCreateRelationNodeConfiguration.setEntityType(EntityType.TENANT);
    tbCreateRelationNodeConfiguration.setDirection(EntitySearchDirection.FROM);

    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration2 =
        mock(TbCreateRelationNodeConfiguration.class);
    when(tbCreateRelationNodeConfiguration2.isChangeOriginatorToRelatedEntity()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isCreateEntityIfNotExists()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isRemoveCurrentRelations()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.getEntityNamePattern()).thenReturn(null);
    when(tbCreateRelationNodeConfiguration2.getEntityTypePattern())
        .thenReturn("Entity Type Pattern");
    when(tbCreateRelationNodeConfiguration2.getRelationType()).thenReturn(null);
    when(tbCreateRelationNodeConfiguration2.getEntityType()).thenReturn(EntityType.TENANT);
    when(tbCreateRelationNodeConfiguration2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(tbCreateRelationNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setEntityTypePattern("Entity Type Pattern");
    tbCreateRelationNodeConfiguration.setEntityType(EntityType.TENANT);
    tbCreateRelationNodeConfiguration.setDirection(EntitySearchDirection.FROM);

    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration2 =
        mock(TbCreateRelationNodeConfiguration.class);
    when(tbCreateRelationNodeConfiguration2.isChangeOriginatorToRelatedEntity()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isCreateEntityIfNotExists()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isRemoveCurrentRelations()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.getEntityNamePattern()).thenReturn(null);
    when(tbCreateRelationNodeConfiguration2.getEntityTypePattern())
        .thenReturn("Entity Type Pattern");
    when(tbCreateRelationNodeConfiguration2.getRelationType()).thenReturn(null);
    when(tbCreateRelationNodeConfiguration2.getEntityType()).thenReturn(EntityType.TENANT);
    when(tbCreateRelationNodeConfiguration2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(tbCreateRelationNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setEntityTypePattern(
        "org.thingsboard.rule.engine.action.TbAbstractRelationActionNodeConfiguration");
    tbCreateRelationNodeConfiguration.setEntityType(EntityType.TENANT);
    tbCreateRelationNodeConfiguration.setDirection(EntitySearchDirection.FROM);

    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration2 =
        mock(TbCreateRelationNodeConfiguration.class);
    when(tbCreateRelationNodeConfiguration2.isChangeOriginatorToRelatedEntity()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isCreateEntityIfNotExists()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isRemoveCurrentRelations()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.getEntityNamePattern()).thenReturn(null);
    when(tbCreateRelationNodeConfiguration2.getEntityTypePattern())
        .thenReturn("Entity Type Pattern");
    when(tbCreateRelationNodeConfiguration2.getRelationType()).thenReturn(null);
    when(tbCreateRelationNodeConfiguration2.getEntityType()).thenReturn(EntityType.TENANT);
    when(tbCreateRelationNodeConfiguration2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(tbCreateRelationNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setEntityNamePattern("Entity Name Pattern");
    tbCreateRelationNodeConfiguration.setEntityType(EntityType.TENANT);
    tbCreateRelationNodeConfiguration.setDirection(EntitySearchDirection.FROM);

    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration2 =
        mock(TbCreateRelationNodeConfiguration.class);
    when(tbCreateRelationNodeConfiguration2.isChangeOriginatorToRelatedEntity()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isCreateEntityIfNotExists()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.isRemoveCurrentRelations()).thenReturn(true);
    when(tbCreateRelationNodeConfiguration2.getEntityNamePattern())
        .thenReturn("Entity Name Pattern");
    when(tbCreateRelationNodeConfiguration2.getEntityTypePattern())
        .thenReturn("Entity Type Pattern");
    when(tbCreateRelationNodeConfiguration2.getRelationType()).thenReturn(null);
    when(tbCreateRelationNodeConfiguration2.getEntityType()).thenReturn(EntityType.TENANT);
    when(tbCreateRelationNodeConfiguration2.getDirection()).thenReturn(EntitySearchDirection.FROM);
    when(tbCreateRelationNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbCreateRelationNodeConfiguration, tbCreateRelationNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbCreateRelationNodeConfiguration(), null);
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractRelationActionNodeConfiguration.equals(Object)",
    "int TbAbstractRelationActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbCreateRelationNodeConfiguration(),
        "Different type to TbAbstractRelationActionNodeConfiguration");
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#getDirection()}.
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntitySearchDirection TbAbstractRelationActionNodeConfiguration.getDirection()"
  })
  void testGetDirection() {
    // Arrange, Act and Assert
    assertNull(new TbCreateRelationNodeConfiguration().getDirection());
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#getEntityNamePattern()}.
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#getEntityNamePattern()}
   */
  @Test
  @DisplayName("Test getEntityNamePattern()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbAbstractRelationActionNodeConfiguration.getEntityNamePattern()"})
  void testGetEntityNamePattern() {
    // Arrange, Act and Assert
    assertNull(new TbCreateRelationNodeConfiguration().getEntityNamePattern());
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#getEntityType()}.
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType TbAbstractRelationActionNodeConfiguration.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertNull(new TbCreateRelationNodeConfiguration().getEntityType());
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#getEntityTypePattern()}.
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#getEntityTypePattern()}
   */
  @Test
  @DisplayName("Test getEntityTypePattern()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbAbstractRelationActionNodeConfiguration.getEntityTypePattern()"})
  void testGetEntityTypePattern() {
    // Arrange, Act and Assert
    assertNull(new TbCreateRelationNodeConfiguration().getEntityTypePattern());
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#getRelationType()}.
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#getRelationType()}
   */
  @Test
  @DisplayName("Test getRelationType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbAbstractRelationActionNodeConfiguration.getRelationType()"})
  void testGetRelationType() {
    // Arrange, Act and Assert
    assertNull(new TbCreateRelationNodeConfiguration().getRelationType());
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#setDirection(EntitySearchDirection)}.
   *
   * <p>Method under test: {@link
   * TbAbstractRelationActionNodeConfiguration#setDirection(EntitySearchDirection)}
   */
  @Test
  @DisplayName("Test setDirection(EntitySearchDirection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAbstractRelationActionNodeConfiguration.setDirection(EntitySearchDirection)"
  })
  void testSetDirection() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();

    // Act
    tbCreateRelationNodeConfiguration.setDirection(EntitySearchDirection.FROM);

    // Assert
    assertEquals(EntitySearchDirection.FROM, tbCreateRelationNodeConfiguration.getDirection());
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#setEntityNamePattern(String)}.
   *
   * <p>Method under test: {@link
   * TbAbstractRelationActionNodeConfiguration#setEntityNamePattern(String)}
   */
  @Test
  @DisplayName("Test setEntityNamePattern(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractRelationActionNodeConfiguration.setEntityNamePattern(String)"})
  void testSetEntityNamePattern() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();

    // Act
    tbCreateRelationNodeConfiguration.setEntityNamePattern("Entity Name Pattern");

    // Assert
    assertEquals("Entity Name Pattern", tbCreateRelationNodeConfiguration.getEntityNamePattern());
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#setEntityType(EntityType)}.
   *
   * <p>Method under test: {@link
   * TbAbstractRelationActionNodeConfiguration#setEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test setEntityType(EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractRelationActionNodeConfiguration.setEntityType(EntityType)"})
  void testSetEntityType() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();

    // Act
    tbCreateRelationNodeConfiguration.setEntityType(EntityType.TENANT);

    // Assert
    assertEquals(EntityType.TENANT, tbCreateRelationNodeConfiguration.getEntityType());
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#setEntityTypePattern(String)}.
   *
   * <p>Method under test: {@link
   * TbAbstractRelationActionNodeConfiguration#setEntityTypePattern(String)}
   */
  @Test
  @DisplayName("Test setEntityTypePattern(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractRelationActionNodeConfiguration.setEntityTypePattern(String)"})
  void testSetEntityTypePattern() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();

    // Act
    tbCreateRelationNodeConfiguration.setEntityTypePattern("Entity Type Pattern");

    // Assert
    assertEquals("Entity Type Pattern", tbCreateRelationNodeConfiguration.getEntityTypePattern());
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#setRelationType(String)}.
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#setRelationType(String)}
   */
  @Test
  @DisplayName("Test setRelationType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractRelationActionNodeConfiguration.setRelationType(String)"})
  void testSetRelationType() {
    // Arrange
    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();

    // Act
    tbCreateRelationNodeConfiguration.setRelationType("Relation Type");

    // Assert
    assertEquals("Relation Type", tbCreateRelationNodeConfiguration.getRelationType());
  }

  /**
   * Test {@link TbAbstractRelationActionNodeConfiguration#toString()}.
   *
   * <p>Method under test: {@link TbAbstractRelationActionNodeConfiguration#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbAbstractRelationActionNodeConfiguration.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "TbCreateRelationNodeConfiguration(createEntityIfNotExists=false, changeOriginatorToRelatedEntity=false,"
            + " removeCurrentRelations=false)",
        new TbCreateRelationNodeConfiguration().toString());
  }
}
