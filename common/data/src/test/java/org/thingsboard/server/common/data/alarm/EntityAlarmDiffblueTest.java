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
package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;

class EntityAlarmDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarm#equals(Object)}
   *   <li>{@link EntityAlarm#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    EntityAlarm entityAlarm2 = new EntityAlarm();

    // Act and Assert
    assertEquals(entityAlarm, entityAlarm2);
    int expectedHashCodeResult = entityAlarm.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarm2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarm#equals(Object)}
   *   <li>{@link EntityAlarm#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setTenantId(TenantId.SYS_TENANT_ID);

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(entityAlarm, entityAlarm2);
    int expectedHashCodeResult = entityAlarm.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarm2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarm#equals(Object)}
   *   <li>{@link EntityAlarm#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setEntityId(TenantId.SYS_TENANT_ID);

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(entityAlarm, entityAlarm2);
    int expectedHashCodeResult = entityAlarm.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarm2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarm#equals(Object)}
   *   <li>{@link EntityAlarm#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setAlarmType("Alarm Type");

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setAlarmType("Alarm Type");

    // Act and Assert
    assertEquals(entityAlarm, entityAlarm2);
    int expectedHashCodeResult = entityAlarm.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarm2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarm#equals(Object)}
   *   <li>{@link EntityAlarm#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals(entityAlarm, entityAlarm2);
    int expectedHashCodeResult = entityAlarm.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarm2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarm#equals(Object)}
   *   <li>{@link EntityAlarm#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();

    // Act and Assert
    assertEquals(entityAlarm, entityAlarm);
    int expectedHashCodeResult = entityAlarm.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarm.hashCode());
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityAlarm(), 1);
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityAlarm, new EntityAlarm());
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityAlarm, new EntityAlarm());
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(entityAlarm, new EntityAlarm());
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setAlarmType("Alarm Type");

    // Act and Assert
    assertNotEquals(entityAlarm, new EntityAlarm());
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(entityAlarm, new EntityAlarm());
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityAlarm, entityAlarm2);
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityAlarm, entityAlarm2);
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setAlarmType("Alarm Type");

    // Act and Assert
    assertNotEquals(entityAlarm, entityAlarm2);
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(entityAlarm, entityAlarm2);
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setEntityId(mock(EntityId.class));

    // Act and Assert
    assertNotEquals(entityAlarm, new EntityAlarm());
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setAssigneeId(new UserId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(entityAlarm, new EntityAlarm());
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setAlarmId(new AlarmId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(entityAlarm, new EntityAlarm());
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setAssigneeId(new UserId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(entityAlarm, entityAlarm2);
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setAlarmId(new AlarmId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(entityAlarm, entityAlarm2);
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityAlarm(), null);
  }

  /**
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityAlarm(), "Different type to EntityAlarm");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarm#EntityAlarm()}
   *   <li>{@link EntityAlarm#setAlarmType(String)}
   *   <li>{@link EntityAlarm#setCreatedTime(long)}
   *   <li>{@link EntityAlarm#setCustomerId(CustomerId)}
   *   <li>{@link EntityAlarm#setEntityId(EntityId)}
   *   <li>{@link EntityAlarm#setTenantId(TenantId)}
   *   <li>{@link EntityAlarm#toString()}
   *   <li>{@link EntityAlarm#getAlarmId()}
   *   <li>{@link EntityAlarm#getAlarmType()}
   *   <li>{@link EntityAlarm#getAssigneeId()}
   *   <li>{@link EntityAlarm#getCreatedTime()}
   *   <li>{@link EntityAlarm#getCustomerId()}
   *   <li>{@link EntityAlarm#getEntityId()}
   *   <li>{@link EntityAlarm#getTenantId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityAlarm actualEntityAlarm = new EntityAlarm();
    actualEntityAlarm.setAlarmType("Alarm Type");
    actualEntityAlarm.setCreatedTime(1L);
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    actualEntityAlarm.setCustomerId(customerId);
    actualEntityAlarm.setEntityId(TenantId.SYS_TENANT_ID);
    actualEntityAlarm.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualEntityAlarm.toString();
    actualEntityAlarm.getAlarmId();
    String actualAlarmType = actualEntityAlarm.getAlarmType();
    actualEntityAlarm.getAssigneeId();
    long actualCreatedTime = actualEntityAlarm.getCreatedTime();
    CustomerId actualCustomerId = actualEntityAlarm.getCustomerId();
    EntityId actualEntityId = actualEntityAlarm.getEntityId();
    TenantId actualTenantId = actualEntityAlarm.getTenantId();

    // Assert that nothing has changed
    assertEquals("Alarm Type", actualAlarmType);
    assertEquals(
        "EntityAlarm(tenantId=13814000-1dd2-11b2-8080-808080808080, entityId=13814000-1dd2-11b2-8080-808080808080,"
            + " createdTime=1, alarmType=Alarm Type, customerId=13814000-1dd2-11b2-8080-808080808080, assigneeId=null,"
            + " alarmId=null)",
        actualToStringResult);
    assertEquals(1L, actualCreatedTime);
    assertSame(customerId, actualCustomerId);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualTenantId);
  }
}
