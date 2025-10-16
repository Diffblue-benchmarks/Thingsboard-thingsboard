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
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityAlarmEntityDiffblueTest {
  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and {@link EntityAlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(entityAlarmEntity, entityAlarmEntity2);
    assertEquals(entityAlarmEntity.hashCode(), entityAlarmEntity2.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and {@link EntityAlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(null);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(null);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(entityAlarmEntity, entityAlarmEntity2);
    assertEquals(entityAlarmEntity.hashCode(), entityAlarmEntity2.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and {@link EntityAlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType(null);
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType(null);
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(entityAlarmEntity, entityAlarmEntity2);
    assertEquals(entityAlarmEntity.hashCode(), entityAlarmEntity2.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and {@link EntityAlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(null);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(null);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(entityAlarmEntity, entityAlarmEntity2);
    assertEquals(entityAlarmEntity.hashCode(), entityAlarmEntity2.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and {@link EntityAlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(null);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(null);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(entityAlarmEntity, entityAlarmEntity2);
    assertEquals(entityAlarmEntity.hashCode(), entityAlarmEntity2.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and {@link EntityAlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType(null);
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType(null);
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(entityAlarmEntity, entityAlarmEntity2);
    assertEquals(entityAlarmEntity.hashCode(), entityAlarmEntity2.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and {@link EntityAlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(null);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(null);

    // Act and Assert
    assertEquals(entityAlarmEntity, entityAlarmEntity2);
    assertEquals(entityAlarmEntity.hashCode(), entityAlarmEntity2.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and {@link EntityAlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(entityAlarmEntity, entityAlarmEntity);
    int expectedHashCodeResult = entityAlarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmEntity.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(UUID.randomUUID());
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(null);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Entity Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType(null);
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(0L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(UUID.randomUUID());
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(null);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(UUID.randomUUID());
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(null);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Alarm Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType(null);
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(UUID.randomUUID());

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(null);

    EntityAlarmEntity entityAlarmEntity2 = new EntityAlarmEntity();
    entityAlarmEntity2.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setAlarmType("Alarm Type");
    entityAlarmEntity2.setCreatedTime(1L);
    entityAlarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity2.setEntityType("Entity Type");
    entityAlarmEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmEntity, entityAlarmEntity2);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmEntity, null);
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityAlarmEntity.equals(Object)",
    "int EntityAlarmEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmEntity, "Different type to EntityAlarmEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmEntity#EntityAlarmEntity()}
   *   <li>{@link EntityAlarmEntity#setAlarmId(UUID)}
   *   <li>{@link EntityAlarmEntity#setAlarmType(String)}
   *   <li>{@link EntityAlarmEntity#setCreatedTime(long)}
   *   <li>{@link EntityAlarmEntity#setCustomerId(UUID)}
   *   <li>{@link EntityAlarmEntity#setEntityId(UUID)}
   *   <li>{@link EntityAlarmEntity#setEntityType(String)}
   *   <li>{@link EntityAlarmEntity#setTenantId(UUID)}
   *   <li>{@link EntityAlarmEntity#toString()}
   *   <li>{@link EntityAlarmEntity#getAlarmId()}
   *   <li>{@link EntityAlarmEntity#getAlarmType()}
   *   <li>{@link EntityAlarmEntity#getCreatedTime()}
   *   <li>{@link EntityAlarmEntity#getCustomerId()}
   *   <li>{@link EntityAlarmEntity#getEntityId()}
   *   <li>{@link EntityAlarmEntity#getEntityType()}
   *   <li>{@link EntityAlarmEntity#getTenantId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityAlarmEntity.<init>()",
    "UUID EntityAlarmEntity.getAlarmId()",
    "String EntityAlarmEntity.getAlarmType()",
    "long EntityAlarmEntity.getCreatedTime()",
    "UUID EntityAlarmEntity.getCustomerId()",
    "UUID EntityAlarmEntity.getEntityId()",
    "String EntityAlarmEntity.getEntityType()",
    "UUID EntityAlarmEntity.getTenantId()",
    "void EntityAlarmEntity.setAlarmId(UUID)",
    "void EntityAlarmEntity.setAlarmType(String)",
    "void EntityAlarmEntity.setCreatedTime(long)",
    "void EntityAlarmEntity.setCustomerId(UUID)",
    "void EntityAlarmEntity.setEntityId(UUID)",
    "void EntityAlarmEntity.setEntityType(String)",
    "void EntityAlarmEntity.setTenantId(UUID)",
    "String EntityAlarmEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityAlarmEntity actualEntityAlarmEntity = new EntityAlarmEntity();
    actualEntityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    actualEntityAlarmEntity.setAlarmType("Alarm Type");
    actualEntityAlarmEntity.setCreatedTime(1L);
    actualEntityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    actualEntityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    actualEntityAlarmEntity.setEntityType("Entity Type");
    UUID tenantId = ModelConstants.NULL_UUID;
    actualEntityAlarmEntity.setTenantId(tenantId);
    String actualToStringResult = actualEntityAlarmEntity.toString();
    UUID actualAlarmId = actualEntityAlarmEntity.getAlarmId();
    String actualAlarmType = actualEntityAlarmEntity.getAlarmType();
    long actualCreatedTime = actualEntityAlarmEntity.getCreatedTime();
    UUID actualCustomerId = actualEntityAlarmEntity.getCustomerId();
    UUID actualEntityId = actualEntityAlarmEntity.getEntityId();
    String actualEntityType = actualEntityAlarmEntity.getEntityType();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAlarmId.toString());
    assertEquals("Alarm Type", actualAlarmType);
    assertEquals("Entity Type", actualEntityType);
    assertEquals(
        "EntityAlarmEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, entityType=Entity Type, entityId"
            + "=13814000-1dd2-11b2-8080-808080808080, alarmId=13814000-1dd2-11b2-8080-808080808080, createdTime=1,"
            + " alarmType=Alarm Type, customerId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertEquals(1L, actualCreatedTime);
    assertSame(tenantId, actualAlarmId);
    assertSame(tenantId, actualCustomerId);
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualEntityAlarmEntity.getTenantId());
  }
}
