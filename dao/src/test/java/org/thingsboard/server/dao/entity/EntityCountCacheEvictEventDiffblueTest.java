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
package org.thingsboard.server.dao.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityCountCacheEvictEventDiffblueTest {
  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}, and {@link
   * EntityCountCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheEvictEvent#equals(Object)}
   *   <li>{@link EntityCountCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);
    EntityCountCacheEvictEvent entityCountCacheEvictEvent2 =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheEvictEvent, entityCountCacheEvictEvent2);
    assertEquals(entityCountCacheEvictEvent.hashCode(), entityCountCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}, and {@link
   * EntityCountCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheEvictEvent#equals(Object)}
   *   <li>{@link EntityCountCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(null, EntityType.TENANT);
    EntityCountCacheEvictEvent entityCountCacheEvictEvent2 =
        new EntityCountCacheEvictEvent(null, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheEvictEvent, entityCountCacheEvictEvent2);
    assertEquals(entityCountCacheEvictEvent.hashCode(), entityCountCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}, and {@link
   * EntityCountCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheEvictEvent#equals(Object)}
   *   <li>{@link EntityCountCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, null);
    EntityCountCacheEvictEvent entityCountCacheEvictEvent2 =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, null);

    // Act and Assert
    assertEquals(entityCountCacheEvictEvent, entityCountCacheEvictEvent2);
    assertEquals(entityCountCacheEvictEvent.hashCode(), entityCountCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}, and {@link
   * EntityCountCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheEvictEvent#equals(Object)}
   *   <li>{@link EntityCountCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheEvictEvent, entityCountCacheEvictEvent);
    int expectedHashCodeResult = entityCountCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, entityCountCacheEvictEvent.hashCode());
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(null, EntityType.TENANT);

    // Act and Assert
    assertNotEquals(
        entityCountCacheEvictEvent,
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, null);

    // Act and Assert
    assertNotEquals(
        entityCountCacheEvictEvent,
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.CUSTOMER);

    // Act and Assert
    assertNotEquals(
        entityCountCacheEvictEvent,
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityCountCacheEvictEvent entityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Act and Assert
    assertNotEquals(
        entityCountCacheEvictEvent, new EntityCountCacheEvictEvent(null, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT), null);
  }

  /**
   * Test {@link EntityCountCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheEvictEvent.equals(Object)",
    "int EntityCountCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT),
        "Different type to EntityCountCacheEvictEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheEvictEvent#EntityCountCacheEvictEvent(TenantId, EntityType)}
   *   <li>{@link EntityCountCacheEvictEvent#toString()}
   *   <li>{@link EntityCountCacheEvictEvent#getEntityType()}
   *   <li>{@link EntityCountCacheEvictEvent#getTenantId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityCountCacheEvictEvent.<init>(TenantId, EntityType)",
    "EntityType EntityCountCacheEvictEvent.getEntityType()",
    "TenantId EntityCountCacheEvictEvent.getTenantId()",
    "String EntityCountCacheEvictEvent.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityCountCacheEvictEvent actualEntityCountCacheEvictEvent =
        new EntityCountCacheEvictEvent(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);
    String actualToStringResult = actualEntityCountCacheEvictEvent.toString();
    EntityType actualEntityType = actualEntityCountCacheEvictEvent.getEntityType();

    // Assert
    assertEquals(
        "EntityCountCacheEvictEvent(tenantId=13814000-1dd2-11b2-8080-808080808080, entityType=TENANT)",
        actualToStringResult);
    assertEquals(EntityType.TENANT, actualEntityType);
    assertSame(TenantId.SYS_TENANT_ID, actualEntityCountCacheEvictEvent.getTenantId());
  }
}
