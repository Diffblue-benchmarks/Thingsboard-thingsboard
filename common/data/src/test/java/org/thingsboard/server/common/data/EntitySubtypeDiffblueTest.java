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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class EntitySubtypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntitySubtype#equals(Object)}
   *   <li>{@link EntitySubtype#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type");
    EntitySubtype entitySubtype2 = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type");

    // Act and Assert
    assertEquals(entitySubtype, entitySubtype2);
    int expectedHashCodeResult = entitySubtype.hashCode();
    assertEquals(expectedHashCodeResult, entitySubtype2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntitySubtype#equals(Object)}
   *   <li>{@link EntitySubtype#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(null, EntityType.TENANT, "Type");
    EntitySubtype entitySubtype2 = new EntitySubtype(null, EntityType.TENANT, "Type");

    // Act and Assert
    assertEquals(entitySubtype, entitySubtype2);
    int expectedHashCodeResult = entitySubtype.hashCode();
    assertEquals(expectedHashCodeResult, entitySubtype2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntitySubtype#equals(Object)}
   *   <li>{@link EntitySubtype#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, null, "Type");
    EntitySubtype entitySubtype2 = new EntitySubtype(TenantId.SYS_TENANT_ID, null, "Type");

    // Act and Assert
    assertEquals(entitySubtype, entitySubtype2);
    int expectedHashCodeResult = entitySubtype.hashCode();
    assertEquals(expectedHashCodeResult, entitySubtype2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntitySubtype#equals(Object)}
   *   <li>{@link EntitySubtype#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, null);
    EntitySubtype entitySubtype2 = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, null);

    // Act and Assert
    assertEquals(entitySubtype, entitySubtype2);
    int expectedHashCodeResult = entitySubtype.hashCode();
    assertEquals(expectedHashCodeResult, entitySubtype2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntitySubtype#equals(Object)}
   *   <li>{@link EntitySubtype#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type");

    // Act and Assert
    assertEquals(entitySubtype, entitySubtype);
    int expectedHashCodeResult = entitySubtype.hashCode();
    assertEquals(expectedHashCodeResult, entitySubtype.hashCode());
  }

  /**
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(null, EntityType.TENANT, "Type");

    // Act and Assert
    assertNotEquals(entitySubtype, new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type"));
  }

  /**
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, null, "Type");

    // Act and Assert
    assertNotEquals(entitySubtype, new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type"));
  }

  /**
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.CUSTOMER, "Type");

    // Act and Assert
    assertNotEquals(entitySubtype, new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type"));
  }

  /**
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, null);

    // Act and Assert
    assertNotEquals(entitySubtype, new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type"));
  }

  /**
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "EntitySubtype{");

    // Act and Assert
    assertNotEquals(entitySubtype, new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type"));
  }

  /**
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntitySubtype entitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type");

    // Act and Assert
    assertNotEquals(entitySubtype, new EntitySubtype(null, EntityType.TENANT, "Type"));
  }

  /**
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type"), null);
  }

  /**
   * Method under test: {@link EntitySubtype#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type"),
        "Different type to EntitySubtype");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntitySubtype#EntitySubtype(TenantId, EntityType, String)}
   *   <li>{@link EntitySubtype#toString()}
   *   <li>{@link EntitySubtype#getEntityType()}
   *   <li>{@link EntitySubtype#getTenantId()}
   *   <li>{@link EntitySubtype#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntitySubtype actualEntitySubtype = new EntitySubtype(TenantId.SYS_TENANT_ID, EntityType.TENANT, "Type");
    String actualToStringResult = actualEntitySubtype.toString();
    EntityType actualEntityType = actualEntitySubtype.getEntityType();
    TenantId actualTenantId = actualEntitySubtype.getTenantId();

    // Assert
    assertEquals("EntitySubtype{tenantId=13814000-1dd2-11b2-8080-808080808080, entityType=TENANT, type='Type'}",
        actualToStringResult);
    assertEquals("Type", actualEntitySubtype.getType());
    assertEquals(EntityType.TENANT, actualEntityType);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
