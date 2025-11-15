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
package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;
import org.thingsboard.server.common.msg.queue.ServiceType;

class QueueKeyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QueueKey#equals(Object)}
   *   <li>{@link QueueKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);
    QueueKey queueKey2 = new QueueKey(ServiceType.TB_CORE);

    // Act and Assert
    assertEquals(queueKey, queueKey2);
    int expectedHashCodeResult = queueKey.hashCode();
    assertEquals(expectedHashCodeResult, queueKey2.hashCode());
  }

  /**
   * Method under test: {@link QueueKey#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("QK(Main,TB_CORE,system)", (new QueueKey(ServiceType.TB_CORE)).toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QueueKey#equals(Object)}
   *   <li>{@link QueueKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    QueueKey queueKey = new QueueKey(null);
    QueueKey queueKey2 = new QueueKey(null);

    // Act and Assert
    assertEquals(queueKey, queueKey2);
    int expectedHashCodeResult = queueKey.hashCode();
    assertEquals(expectedHashCodeResult, queueKey2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QueueKey#equals(Object)}
   *   <li>{@link QueueKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE, new Queue());
    QueueKey queueKey2 = new QueueKey(ServiceType.TB_CORE, new Queue());

    // Act and Assert
    assertEquals(queueKey, queueKey2);
    int expectedHashCodeResult = queueKey.hashCode();
    assertEquals(expectedHashCodeResult, queueKey2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QueueKey#equals(Object)}
   *   <li>{@link QueueKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);

    // Act and Assert
    assertEquals(queueKey, queueKey);
    int expectedHashCodeResult = queueKey.hashCode();
    assertEquals(expectedHashCodeResult, queueKey.hashCode());
  }

  /**
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    QueueKey queueKey = new QueueKey(null);

    // Act and Assert
    assertNotEquals(queueKey, new QueueKey(ServiceType.TB_CORE));
  }

  /**
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_RULE_ENGINE);

    // Act and Assert
    assertNotEquals(queueKey, new QueueKey(ServiceType.TB_CORE));
  }

  /**
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE, new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(queueKey, new QueueKey(ServiceType.TB_CORE));
  }

  /**
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE, new Queue());

    // Act and Assert
    assertNotEquals(queueKey, new QueueKey(ServiceType.TB_CORE));
  }

  /**
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);

    // Act and Assert
    assertNotEquals(queueKey, new QueueKey(ServiceType.TB_CORE, new Queue()));
  }

  /**
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueKey(ServiceType.TB_CORE, new TenantId(UUID.randomUUID())), mock(AdminSettingsId.class));
  }

  /**
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE, new Queue());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(queueKey,
        new QueueKey(ServiceType.TB_CORE, new Queue(tenantId, new TenantProfileQueueConfiguration())));
  }

  /**
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueKey(ServiceType.TB_CORE), null);
  }

  /**
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueKey(ServiceType.TB_CORE), "Different type to QueueKey");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QueueKey#QueueKey(ServiceType, String, TenantId)}
   *   <li>{@link QueueKey#getQueueName()}
   *   <li>{@link QueueKey#getTenantId()}
   *   <li>{@link QueueKey#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    QueueKey actualQueueKey = new QueueKey(ServiceType.TB_CORE, "Queue Name", tenantId);
    String actualQueueName = actualQueueKey.getQueueName();
    TenantId actualTenantId = actualQueueKey.getTenantId();

    // Assert
    assertEquals("Queue Name", actualQueueName);
    assertEquals(ServiceType.TB_CORE, actualQueueKey.getType());
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Method under test: {@link QueueKey#QueueKey(ServiceType)}
   */
  @Test
  void testNewQueueKey() {
    // Arrange and Act
    QueueKey actualQueueKey = new QueueKey(ServiceType.TB_CORE);

    // Assert
    TenantId tenantId = actualQueueKey.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Main", actualQueueKey.getQueueName());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(ServiceType.TB_CORE, actualQueueKey.getType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Method under test: {@link QueueKey#QueueKey(ServiceType, TenantId)}
   */
  @Test
  void testNewQueueKey2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    QueueKey actualQueueKey = new QueueKey(ServiceType.TB_CORE, tenantId);

    // Assert
    assertEquals("Main", actualQueueKey.getQueueName());
    assertEquals(ServiceType.TB_CORE, actualQueueKey.getType());
    assertSame(tenantId, actualQueueKey.getTenantId());
  }

  /**
   * Method under test: {@link QueueKey#QueueKey(ServiceType, TenantId)}
   */
  @Test
  void testNewQueueKey3() {
    // Arrange and Act
    QueueKey actualQueueKey = new QueueKey(ServiceType.TB_CORE, (TenantId) null);

    // Assert
    TenantId tenantId = actualQueueKey.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Main", actualQueueKey.getQueueName());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(ServiceType.TB_CORE, actualQueueKey.getType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Method under test: {@link QueueKey#QueueKey(ServiceType, Queue)}
   */
  @Test
  void testNewQueueKey4() {
    // Arrange and Act
    QueueKey actualQueueKey = new QueueKey(ServiceType.TB_CORE, new Queue());

    // Assert
    assertNull(actualQueueKey.getQueueName());
    assertNull(actualQueueKey.getTenantId());
    assertEquals(ServiceType.TB_CORE, actualQueueKey.getType());
  }

  /**
   * Method under test: {@link QueueKey#QueueKey(ServiceType, QueueRoutingInfo)}
   */
  @Test
  void testNewQueueKey5() {
    // Arrange and Act
    QueueKey actualQueueKey = new QueueKey(ServiceType.TB_CORE, new QueueRoutingInfo(new Queue()));

    // Assert
    assertNull(actualQueueKey.getQueueName());
    assertNull(actualQueueKey.getTenantId());
    assertEquals(ServiceType.TB_CORE, actualQueueKey.getType());
  }

  /**
   * Method under test: {@link QueueKey#withQueueName(String)}
   */
  @Test
  void testWithQueueName() {
    // Arrange and Act
    QueueKey actualWithQueueNameResult = (new QueueKey(ServiceType.TB_CORE)).withQueueName("Queue Name");

    // Assert
    TenantId tenantId = actualWithQueueNameResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Queue Name", actualWithQueueNameResult.getQueueName());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(ServiceType.TB_CORE, actualWithQueueNameResult.getType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Method under test: {@link QueueKey#withQueueName(String)}
   */
  @Test
  void testWithQueueName2() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);

    // Act and Assert
    assertSame(queueKey, queueKey.withQueueName("Main"));
  }
}
