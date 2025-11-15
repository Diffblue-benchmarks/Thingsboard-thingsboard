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
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EntityInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityInfo#equals(Object)}
   *   <li>{@link EntityInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, "Name");
    EntityInfo entityInfo2 = new EntityInfo(TenantId.SYS_TENANT_ID, "Name");

    // Act and Assert
    assertEquals(entityInfo, entityInfo2);
    int expectedHashCodeResult = entityInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityInfo#equals(Object)}
   *   <li>{@link EntityInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(null, "Name");
    EntityInfo entityInfo2 = new EntityInfo(null, "Name");

    // Act and Assert
    assertEquals(entityInfo, entityInfo2);
    int expectedHashCodeResult = entityInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityInfo#equals(Object)}
   *   <li>{@link EntityInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, null);
    EntityInfo entityInfo2 = new EntityInfo(TenantId.SYS_TENANT_ID, null);

    // Act and Assert
    assertEquals(entityInfo, entityInfo2);
    int expectedHashCodeResult = entityInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityInfo#equals(Object)}
   *   <li>{@link EntityInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, "Name");

    // Act and Assert
    assertEquals(entityInfo, entityInfo);
    int expectedHashCodeResult = entityInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityInfo.hashCode());
  }

  /**
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(null, "Name");

    // Act and Assert
    assertNotEquals(entityInfo, new EntityInfo(TenantId.SYS_TENANT_ID, "Name"));
  }

  /**
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(new AlarmId(EntityId.NULL_UUID), "Name");

    // Act and Assert
    assertNotEquals(entityInfo, new EntityInfo(TenantId.SYS_TENANT_ID, "Name"));
  }

  /**
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(mock(EntityId.class), "Name");

    // Act and Assert
    assertNotEquals(entityInfo, new EntityInfo(TenantId.SYS_TENANT_ID, "Name"));
  }

  /**
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, null);

    // Act and Assert
    assertNotEquals(entityInfo, new EntityInfo(TenantId.SYS_TENANT_ID, "Name"));
  }

  /**
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, "org.thingsboard.server.common.data.EntityInfo");

    // Act and Assert
    assertNotEquals(entityInfo, new EntityInfo(TenantId.SYS_TENANT_ID, "Name"));
  }

  /**
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, "Name");

    // Act and Assert
    assertNotEquals(entityInfo, new DeviceProfileInfo(new DeviceProfile()));
  }

  /**
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityInfo(TenantId.SYS_TENANT_ID, "Name"), null);
  }

  /**
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityInfo(TenantId.SYS_TENANT_ID, "Name"), "Different type to EntityInfo");
  }

  /**
   * Method under test: {@link EntityInfo#getId()}
   */
  @Test
  void testGetId() {
    // Arrange and Act
    EntityId actualId = (new EntityInfo(TenantId.SYS_TENANT_ID, "Name")).getId();

    // Assert
    assertSame(((TenantId) actualId).SYS_TENANT_ID, actualId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityInfo#EntityInfo(EntityId, String)}
   *   <li>{@link EntityInfo#toString()}
   *   <li>{@link EntityInfo#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TenantId id = TenantId.SYS_TENANT_ID;

    // Act
    EntityInfo actualEntityInfo = new EntityInfo(id, "Name");
    String actualToStringResult = actualEntityInfo.toString();

    // Assert
    assertEquals("EntityInfo(id=13814000-1dd2-11b2-8080-808080808080, name=Name)", actualToStringResult);
    assertEquals("Name", actualEntityInfo.getName());
    TenantId expectedId = id.SYS_TENANT_ID;
    assertSame(expectedId, actualEntityInfo.getId());
  }
}
