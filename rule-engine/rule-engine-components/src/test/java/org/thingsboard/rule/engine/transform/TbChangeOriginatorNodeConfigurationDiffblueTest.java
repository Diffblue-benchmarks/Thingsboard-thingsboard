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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.data.RelationsQuery;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationEntityTypeFilter;

class TbChangeOriginatorNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbChangeOriginatorNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbChangeOriginatorNodeConfiguration TbChangeOriginatorNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbChangeOriginatorNodeConfiguration actualDefaultConfigurationResult =
        new TbChangeOriginatorNodeConfiguration().defaultConfiguration();

    // Assert
    RelationsQuery relationsQuery = actualDefaultConfigurationResult.getRelationsQuery();
    List<RelationEntityTypeFilter> filters = relationsQuery.getFilters();
    assertEquals(1, filters.size());
    RelationEntityTypeFilter getResult = filters.get(0);
    assertEquals("Contains", getResult.getRelationType());
    assertNull(actualDefaultConfigurationResult.getEntityNamePattern());
    assertNull(actualDefaultConfigurationResult.getEntityType());
    assertEquals(1, relationsQuery.getMaxLevel());
    assertEquals(OriginatorSource.CUSTOMER, actualDefaultConfigurationResult.getOriginatorSource());
    assertEquals(EntitySearchDirection.FROM, relationsQuery.getDirection());
    assertFalse(relationsQuery.isFetchLastLevelOnly());
    assertFalse(getResult.isNegate());
    assertTrue(getResult.getEntityTypes().isEmpty());
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}, and {@link
   * TbChangeOriginatorNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   *   <li>{@link TbChangeOriginatorNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration2 =
        new TbChangeOriginatorNodeConfiguration();

    // Act and Assert
    assertEquals(tbChangeOriginatorNodeConfiguration, tbChangeOriginatorNodeConfiguration2);
    assertEquals(
        tbChangeOriginatorNodeConfiguration.hashCode(),
        tbChangeOriginatorNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}, and {@link
   * TbChangeOriginatorNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   *   <li>{@link TbChangeOriginatorNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration.setOriginatorSource(OriginatorSource.CUSTOMER);

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration2 =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration2.setOriginatorSource(OriginatorSource.CUSTOMER);

    // Act and Assert
    assertEquals(tbChangeOriginatorNodeConfiguration, tbChangeOriginatorNodeConfiguration2);
    assertEquals(
        tbChangeOriginatorNodeConfiguration.hashCode(),
        tbChangeOriginatorNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}, and {@link
   * TbChangeOriginatorNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   *   <li>{@link TbChangeOriginatorNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration.setRelationsQuery(relationsQuery);

    RelationsQuery relationsQuery2 = new RelationsQuery();
    relationsQuery2.setDirection(EntitySearchDirection.FROM);
    relationsQuery2.setFetchLastLevelOnly(true);
    relationsQuery2.setFilters(new ArrayList<>());
    relationsQuery2.setMaxLevel(3);

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration2 =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration2.setRelationsQuery(relationsQuery2);

    // Act and Assert
    assertEquals(tbChangeOriginatorNodeConfiguration, tbChangeOriginatorNodeConfiguration2);
    assertEquals(
        tbChangeOriginatorNodeConfiguration.hashCode(),
        tbChangeOriginatorNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}, and {@link
   * TbChangeOriginatorNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   *   <li>{@link TbChangeOriginatorNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration.setEntityType("Entity Type");

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration2 =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration2.setEntityType("Entity Type");

    // Act and Assert
    assertEquals(tbChangeOriginatorNodeConfiguration, tbChangeOriginatorNodeConfiguration2);
    assertEquals(
        tbChangeOriginatorNodeConfiguration.hashCode(),
        tbChangeOriginatorNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}, and {@link
   * TbChangeOriginatorNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   *   <li>{@link TbChangeOriginatorNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration.setEntityNamePattern("Entity Name Pattern");

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration2 =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration2.setEntityNamePattern("Entity Name Pattern");

    // Act and Assert
    assertEquals(tbChangeOriginatorNodeConfiguration, tbChangeOriginatorNodeConfiguration2);
    assertEquals(
        tbChangeOriginatorNodeConfiguration.hashCode(),
        tbChangeOriginatorNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}, and {@link
   * TbChangeOriginatorNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   *   <li>{@link TbChangeOriginatorNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();

    // Act and Assert
    assertEquals(tbChangeOriginatorNodeConfiguration, tbChangeOriginatorNodeConfiguration);
    int expectedHashCodeResult = tbChangeOriginatorNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbChangeOriginatorNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbChangeOriginatorNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration.setOriginatorSource(OriginatorSource.CUSTOMER);

    // Act and Assert
    assertNotEquals(tbChangeOriginatorNodeConfiguration, new TbChangeOriginatorNodeConfiguration());
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration.setRelationsQuery(relationsQuery);

    // Act and Assert
    assertNotEquals(tbChangeOriginatorNodeConfiguration, new TbChangeOriginatorNodeConfiguration());
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration.setEntityType("Entity Type");

    // Act and Assert
    assertNotEquals(tbChangeOriginatorNodeConfiguration, new TbChangeOriginatorNodeConfiguration());
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration.setEntityNamePattern("Entity Name Pattern");

    // Act and Assert
    assertNotEquals(tbChangeOriginatorNodeConfiguration, new TbChangeOriginatorNodeConfiguration());
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration2 =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration2.setOriginatorSource(OriginatorSource.CUSTOMER);

    // Act and Assert
    assertNotEquals(tbChangeOriginatorNodeConfiguration, tbChangeOriginatorNodeConfiguration2);
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();

    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration2 =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration2.setRelationsQuery(relationsQuery);

    // Act and Assert
    assertNotEquals(tbChangeOriginatorNodeConfiguration, tbChangeOriginatorNodeConfiguration2);
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration2 =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration2.setEntityType("Entity Type");

    // Act and Assert
    assertNotEquals(tbChangeOriginatorNodeConfiguration, tbChangeOriginatorNodeConfiguration2);
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration2 =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration2.setEntityNamePattern("Entity Name Pattern");

    // Act and Assert
    assertNotEquals(tbChangeOriginatorNodeConfiguration, tbChangeOriginatorNodeConfiguration2);
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbChangeOriginatorNodeConfiguration(), null);
  }

  /**
   * Test {@link TbChangeOriginatorNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbChangeOriginatorNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbChangeOriginatorNodeConfiguration.equals(Object)",
    "int TbChangeOriginatorNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbChangeOriginatorNodeConfiguration(),
        "Different type to TbChangeOriginatorNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbChangeOriginatorNodeConfiguration}
   *   <li>{@link TbChangeOriginatorNodeConfiguration#setEntityNamePattern(String)}
   *   <li>{@link TbChangeOriginatorNodeConfiguration#setEntityType(String)}
   *   <li>{@link TbChangeOriginatorNodeConfiguration#setOriginatorSource(OriginatorSource)}
   *   <li>{@link TbChangeOriginatorNodeConfiguration#setRelationsQuery(RelationsQuery)}
   *   <li>{@link TbChangeOriginatorNodeConfiguration#toString()}
   *   <li>{@link TbChangeOriginatorNodeConfiguration#getEntityNamePattern()}
   *   <li>{@link TbChangeOriginatorNodeConfiguration#getEntityType()}
   *   <li>{@link TbChangeOriginatorNodeConfiguration#getOriginatorSource()}
   *   <li>{@link TbChangeOriginatorNodeConfiguration#getRelationsQuery()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbChangeOriginatorNodeConfiguration.<init>()",
    "String TbChangeOriginatorNodeConfiguration.getEntityNamePattern()",
    "String TbChangeOriginatorNodeConfiguration.getEntityType()",
    "OriginatorSource TbChangeOriginatorNodeConfiguration.getOriginatorSource()",
    "RelationsQuery TbChangeOriginatorNodeConfiguration.getRelationsQuery()",
    "void TbChangeOriginatorNodeConfiguration.setEntityNamePattern(String)",
    "void TbChangeOriginatorNodeConfiguration.setEntityType(String)",
    "void TbChangeOriginatorNodeConfiguration.setOriginatorSource(OriginatorSource)",
    "void TbChangeOriginatorNodeConfiguration.setRelationsQuery(RelationsQuery)",
    "String TbChangeOriginatorNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbChangeOriginatorNodeConfiguration actualTbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    actualTbChangeOriginatorNodeConfiguration.setEntityNamePattern("Entity Name Pattern");
    actualTbChangeOriginatorNodeConfiguration.setEntityType("Entity Type");
    actualTbChangeOriginatorNodeConfiguration.setOriginatorSource(OriginatorSource.CUSTOMER);
    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);
    actualTbChangeOriginatorNodeConfiguration.setRelationsQuery(relationsQuery);
    String actualToStringResult = actualTbChangeOriginatorNodeConfiguration.toString();
    String actualEntityNamePattern =
        actualTbChangeOriginatorNodeConfiguration.getEntityNamePattern();
    String actualEntityType = actualTbChangeOriginatorNodeConfiguration.getEntityType();
    OriginatorSource actualOriginatorSource =
        actualTbChangeOriginatorNodeConfiguration.getOriginatorSource();

    // Assert
    assertEquals("Entity Name Pattern", actualEntityNamePattern);
    assertEquals("Entity Type", actualEntityType);
    assertEquals(
        "TbChangeOriginatorNodeConfiguration(originatorSource=CUSTOMER, relationsQuery=RelationsQuery(direction=FROM,"
            + " maxLevel=3, filters=[], fetchLastLevelOnly=true), entityType=Entity Type, entityNamePattern=Entity"
            + " Name Pattern)",
        actualToStringResult);
    assertEquals(OriginatorSource.CUSTOMER, actualOriginatorSource);
    assertSame(relationsQuery, actualTbChangeOriginatorNodeConfiguration.getRelationsQuery());
  }
}
