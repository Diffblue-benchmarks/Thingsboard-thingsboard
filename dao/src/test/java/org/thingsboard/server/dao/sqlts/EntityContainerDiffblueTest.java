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
package org.thingsboard.server.dao.sqlts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AbstractTsKvEntity;
import org.thingsboard.server.dao.model.sqlts.latest.TsKvLatestEntity;

public class EntityContainerDiffblueTest {
  /**
   * Test {@link EntityContainer#equals(Object)}, and {@link EntityContainer#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityContainer#equals(Object)}
   *   <li>{@link EntityContainer#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityContainer.equals(Object)", "int EntityContainer.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityContainer<AbstractTsKvEntity> entityContainer =
        new EntityContainer<>(new TsKvLatestEntity(), "2020-03-01");
    EntityContainer<AbstractTsKvEntity> entityContainer2 =
        new EntityContainer<>(new TsKvLatestEntity(), "2020-03-01");

    // Act and Assert
    assertEquals(entityContainer, entityContainer2);
    assertEquals(entityContainer.hashCode(), entityContainer2.hashCode());
  }

  /**
   * Test {@link EntityContainer#equals(Object)}, and {@link EntityContainer#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityContainer#equals(Object)}
   *   <li>{@link EntityContainer#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityContainer.equals(Object)", "int EntityContainer.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityContainer<AbstractTsKvEntity> entityContainer = new EntityContainer<>(null, "2020-03-01");
    EntityContainer<AbstractTsKvEntity> entityContainer2 =
        new EntityContainer<>(null, "2020-03-01");

    // Act and Assert
    assertEquals(entityContainer, entityContainer2);
    assertEquals(entityContainer.hashCode(), entityContainer2.hashCode());
  }

  /**
   * Test {@link EntityContainer#equals(Object)}, and {@link EntityContainer#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityContainer#equals(Object)}
   *   <li>{@link EntityContainer#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityContainer.equals(Object)", "int EntityContainer.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityContainer<AbstractTsKvEntity> entityContainer =
        new EntityContainer<>(new TsKvLatestEntity(), null);
    EntityContainer<AbstractTsKvEntity> entityContainer2 =
        new EntityContainer<>(new TsKvLatestEntity(), null);

    // Act and Assert
    assertEquals(entityContainer, entityContainer2);
    assertEquals(entityContainer.hashCode(), entityContainer2.hashCode());
  }

  /**
   * Test {@link EntityContainer#equals(Object)}, and {@link EntityContainer#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityContainer#equals(Object)}
   *   <li>{@link EntityContainer#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityContainer.equals(Object)", "int EntityContainer.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityContainer<AbstractTsKvEntity> entityContainer =
        new EntityContainer<>(new TsKvLatestEntity(), "2020-03-01");

    // Act and Assert
    assertEquals(entityContainer, entityContainer);
    int expectedHashCodeResult = entityContainer.hashCode();
    assertEquals(expectedHashCodeResult, entityContainer.hashCode());
  }

  /**
   * Test {@link EntityContainer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityContainer#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityContainer.equals(Object)", "int EntityContainer.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityContainer<AbstractTsKvEntity> entityContainer = new EntityContainer<>(null, "2020-03-01");

    // Act and Assert
    assertNotEquals(entityContainer, new EntityContainer<>(new TsKvLatestEntity(), "2020-03-01"));
  }

  /**
   * Test {@link EntityContainer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityContainer#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityContainer.equals(Object)", "int EntityContainer.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsKvLatestEntity tsKvLatestEntity =
        new TsKvLatestEntity(
            ModelConstants.NULL_UUID, 1, "2020-03-01", "42", true, 42L, 10.0d, "42", 1L, 1L);
    EntityContainer<AbstractTsKvEntity> entityContainer =
        new EntityContainer<>(tsKvLatestEntity, "2020-03-01");

    // Act and Assert
    assertNotEquals(entityContainer, new EntityContainer<>(new TsKvLatestEntity(), "2020-03-01"));
  }

  /**
   * Test {@link EntityContainer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityContainer#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityContainer.equals(Object)", "int EntityContainer.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityContainer<AbstractTsKvEntity> entityContainer =
        new EntityContainer<>(new TsKvLatestEntity(), "2020/03/01");

    // Act and Assert
    assertNotEquals(entityContainer, new EntityContainer<>(new TsKvLatestEntity(), "2020-03-01"));
  }

  /**
   * Test {@link EntityContainer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityContainer#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityContainer.equals(Object)", "int EntityContainer.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityContainer<AbstractTsKvEntity> entityContainer =
        new EntityContainer<>(new TsKvLatestEntity(), null);

    // Act and Assert
    assertNotEquals(entityContainer, new EntityContainer<>(new TsKvLatestEntity(), "2020-03-01"));
  }

  /**
   * Test {@link EntityContainer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityContainer#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityContainer.equals(Object)", "int EntityContainer.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityContainer<AbstractTsKvEntity> entityContainer =
        new EntityContainer<>(new TsKvLatestEntity(), "2020-03-01");

    // Act and Assert
    assertNotEquals(entityContainer, null);
  }

  /**
   * Test {@link EntityContainer#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityContainer#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityContainer.equals(Object)", "int EntityContainer.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityContainer<AbstractTsKvEntity> entityContainer =
        new EntityContainer<>(new TsKvLatestEntity(), "2020-03-01");

    // Act and Assert
    assertNotEquals(entityContainer, "Different type to EntityContainer");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityContainer#EntityContainer(AbstractTsKvEntity, String)}
   *   <li>{@link EntityContainer#setEntity(AbstractTsKvEntity)}
   *   <li>{@link EntityContainer#setPartitionDate(String)}
   *   <li>{@link EntityContainer#toString()}
   *   <li>{@link EntityContainer#getEntity()}
   *   <li>{@link EntityContainer#getPartitionDate()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityContainer.<init>(AbstractTsKvEntity, String)",
    "AbstractTsKvEntity EntityContainer.getEntity()",
    "String EntityContainer.getPartitionDate()",
    "void EntityContainer.setEntity(AbstractTsKvEntity)",
    "void EntityContainer.setPartitionDate(String)",
    "String EntityContainer.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityContainer<AbstractTsKvEntity> actualEntityContainer =
        new EntityContainer<>(new TsKvLatestEntity(), "2020-03-01");
    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    actualEntityContainer.setEntity(tsKvLatestEntity);
    actualEntityContainer.setPartitionDate("2020-03-01");
    String actualToStringResult = actualEntityContainer.toString();
    AbstractTsKvEntity actualEntity = actualEntityContainer.getEntity();

    // Assert
    assertEquals("2020-03-01", actualEntityContainer.getPartitionDate());
    assertEquals(
        "EntityContainer(entity=TsKvLatestEntity(version=null), partitionDate=2020-03-01)",
        actualToStringResult);
    assertSame(tsKvLatestEntity, actualEntity);
  }
}
