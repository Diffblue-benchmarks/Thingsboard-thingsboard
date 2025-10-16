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

public class EntityCountCacheKeyDiffblueTest {
  /**
   * Test {@link EntityCountCacheKey#equals(Object)}, and {@link EntityCountCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheKey#equals(Object)}
   *   <li>{@link EntityCountCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);
    EntityCountCacheKey entityCountCacheKey2 =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheKey, entityCountCacheKey2);
    assertEquals(entityCountCacheKey.hashCode(), entityCountCacheKey2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}, and {@link EntityCountCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheKey#equals(Object)}
   *   <li>{@link EntityCountCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey = new EntityCountCacheKey(null, EntityType.TENANT);
    EntityCountCacheKey entityCountCacheKey2 = new EntityCountCacheKey(null, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheKey, entityCountCacheKey2);
    assertEquals(entityCountCacheKey.hashCode(), entityCountCacheKey2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}, and {@link EntityCountCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheKey#equals(Object)}
   *   <li>{@link EntityCountCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, null);
    EntityCountCacheKey entityCountCacheKey2 =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, null);

    // Act and Assert
    assertEquals(entityCountCacheKey, entityCountCacheKey2);
    assertEquals(entityCountCacheKey.hashCode(), entityCountCacheKey2.hashCode());
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}, and {@link EntityCountCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheKey#equals(Object)}
   *   <li>{@link EntityCountCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Act and Assert
    assertEquals(entityCountCacheKey, entityCountCacheKey);
    int expectedHashCodeResult = entityCountCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, entityCountCacheKey.hashCode());
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey = new EntityCountCacheKey(null, EntityType.TENANT);

    // Act and Assert
    assertNotEquals(
        entityCountCacheKey,
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, null);

    // Act and Assert
    assertNotEquals(
        entityCountCacheKey,
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.CUSTOMER);

    // Act and Assert
    assertNotEquals(
        entityCountCacheKey,
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityCountCacheKey entityCountCacheKey =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityCountCacheKey, new EntityCountCacheKey(null, EntityType.TENANT));
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT), null);
  }

  /**
   * Test {@link EntityCountCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityCountCacheKey#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityCountCacheKey.equals(Object)",
    "int EntityCountCacheKey.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT),
        "Different type to EntityCountCacheKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityCountCacheKey#EntityCountCacheKey(TenantId, EntityType)}
   *   <li>{@link EntityCountCacheKey#toString()}
   *   <li>{@link EntityCountCacheKey#getEntityType()}
   *   <li>{@link EntityCountCacheKey#getTenantId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityCountCacheKey.<init>(TenantId, EntityType)",
    "EntityType EntityCountCacheKey.getEntityType()",
    "TenantId EntityCountCacheKey.getTenantId()",
    "String EntityCountCacheKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityCountCacheKey actualEntityCountCacheKey =
        new EntityCountCacheKey(ModelConstants.SYSTEM_TENANT, EntityType.TENANT);
    String actualToStringResult = actualEntityCountCacheKey.toString();
    EntityType actualEntityType = actualEntityCountCacheKey.getEntityType();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080_TENANT", actualToStringResult);
    assertEquals(EntityType.TENANT, actualEntityType);
    assertSame(TenantId.SYS_TENANT_ID, actualEntityCountCacheKey.getTenantId());
  }
}
