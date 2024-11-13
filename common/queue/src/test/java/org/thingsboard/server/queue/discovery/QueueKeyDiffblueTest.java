package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;
import org.thingsboard.server.common.msg.queue.ServiceType;

class QueueKeyDiffblueTest {
  /**
   * Test {@link QueueKey#equals(Object)}, and {@link QueueKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueKey#equals(Object)}
   *   <li>{@link QueueKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link QueueKey#equals(Object)}, and {@link QueueKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueKey#equals(Object)}
   *   <li>{@link QueueKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link QueueKey#equals(Object)}, and {@link QueueKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueKey#equals(Object)}
   *   <li>{@link QueueKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link QueueKey#equals(Object)}, and {@link QueueKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueKey#equals(Object)}
   *   <li>{@link QueueKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);

    // Act and Assert
    assertEquals(queueKey, queueKey);
    int expectedHashCodeResult = queueKey.hashCode();
    assertEquals(expectedHashCodeResult, queueKey.hashCode());
  }

  /**
   * Test {@link QueueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    QueueKey queueKey = new QueueKey(null);

    // Act and Assert
    assertNotEquals(queueKey, new QueueKey(ServiceType.TB_CORE));
  }

  /**
   * Test {@link QueueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_RULE_ENGINE);

    // Act and Assert
    assertNotEquals(queueKey, new QueueKey(ServiceType.TB_CORE));
  }

  /**
   * Test {@link QueueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE, new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(queueKey, new QueueKey(ServiceType.TB_CORE));
  }

  /**
   * Test {@link QueueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE, new Queue());

    // Act and Assert
    assertNotEquals(queueKey, new QueueKey(ServiceType.TB_CORE));
  }

  /**
   * Test {@link QueueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);

    // Act and Assert
    assertNotEquals(queueKey, new QueueKey(ServiceType.TB_CORE, new Queue()));
  }

  /**
   * Test {@link QueueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueKey(ServiceType.TB_CORE, new TenantId(UUID.randomUUID())), mock(AdminSettingsId.class));
  }

  /**
   * Test {@link QueueKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE, new Queue());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(queueKey,
        new QueueKey(ServiceType.TB_CORE, new Queue(tenantId, new TenantProfileQueueConfiguration())));
  }

  /**
   * Test {@link QueueKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueKey(ServiceType.TB_CORE), null);
  }

  /**
   * Test {@link QueueKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueKey(ServiceType.TB_CORE), "Different type to QueueKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueKey#QueueKey(ServiceType, String, TenantId)}
   *   <li>{@link QueueKey#getQueueName()}
   *   <li>{@link QueueKey#getTenantId()}
   *   <li>{@link QueueKey#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
   * Test {@link QueueKey#QueueKey(ServiceType)}.
   * <p>
   * Method under test: {@link QueueKey#QueueKey(ServiceType)}
   */
  @Test
  @DisplayName("Test new QueueKey(ServiceType)")
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
   * Test {@link QueueKey#QueueKey(ServiceType, TenantId)}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueKey#QueueKey(ServiceType, TenantId)}
   */
  @Test
  @DisplayName("Test new QueueKey(ServiceType, TenantId); then return TenantId Id toString is '13814000-1dd2-11b2-8080-808080808080'")
  void testNewQueueKey_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
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
   * Test {@link QueueKey#QueueKey(ServiceType, TenantId)}.
   * <ul>
   *   <li>Then return TenantId is {@link TenantId#TenantId(UUID)} with id is
   * randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueKey#QueueKey(ServiceType, TenantId)}
   */
  @Test
  @DisplayName("Test new QueueKey(ServiceType, TenantId); then return TenantId is TenantId(UUID) with id is randomUUID")
  void testNewQueueKey_thenReturnTenantIdIsTenantIdWithIdIsRandomUUID() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertSame(tenantId, (new QueueKey(ServiceType.TB_CORE, tenantId)).getTenantId());
  }

  /**
   * Test {@link QueueKey#QueueKey(ServiceType, QueueRoutingInfo)}.
   * <ul>
   *   <li>When {@link QueueRoutingInfo#QueueRoutingInfo(Queue)} with queue is
   * {@link Queue#Queue()}.</li>
   *   <li>Then return QueueName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueKey#QueueKey(ServiceType, QueueRoutingInfo)}
   */
  @Test
  @DisplayName("Test new QueueKey(ServiceType, QueueRoutingInfo); when QueueRoutingInfo(Queue) with queue is Queue(); then return QueueName is 'null'")
  void testNewQueueKey_whenQueueRoutingInfoWithQueueIsQueue_thenReturnQueueNameIsNull() {
    // Arrange and Act
    QueueKey actualQueueKey = new QueueKey(ServiceType.TB_CORE, new QueueRoutingInfo(new Queue()));

    // Assert
    assertNull(actualQueueKey.getQueueName());
    assertNull(actualQueueKey.getTenantId());
    assertEquals(ServiceType.TB_CORE, actualQueueKey.getType());
  }

  /**
   * Test {@link QueueKey#QueueKey(ServiceType, Queue)}.
   * <ul>
   *   <li>When {@link Queue#Queue()}.</li>
   *   <li>Then return QueueName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueKey#QueueKey(ServiceType, Queue)}
   */
  @Test
  @DisplayName("Test new QueueKey(ServiceType, Queue); when Queue(); then return QueueName is 'null'")
  void testNewQueueKey_whenQueue_thenReturnQueueNameIsNull() {
    // Arrange and Act
    QueueKey actualQueueKey = new QueueKey(ServiceType.TB_CORE, new Queue());

    // Assert
    assertNull(actualQueueKey.getQueueName());
    assertNull(actualQueueKey.getTenantId());
    assertEquals(ServiceType.TB_CORE, actualQueueKey.getType());
  }

  /**
   * Test {@link QueueKey#toString()}.
   * <p>
   * Method under test: {@link QueueKey#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);

    // Act
    String actualToStringResult = queueKey.toString();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", queueKey.getTenantId().getId().toString());
    assertEquals("QK(Main,TB_CORE,system)", actualToStringResult);
  }

  /**
   * Test {@link QueueKey#withQueueName(String)}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueKey#withQueueName(String)}
   */
  @Test
  @DisplayName("Test withQueueName(String); then return TenantId Id toString is '13814000-1dd2-11b2-8080-808080808080'")
  void testWithQueueName_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
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
   * Test {@link QueueKey#withQueueName(String)}.
   * <ul>
   *   <li>When {@code Main}.</li>
   *   <li>Then return {@link QueueKey#QueueKey(ServiceType)} with type is
   * {@code TB_CORE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueKey#withQueueName(String)}
   */
  @Test
  @DisplayName("Test withQueueName(String); when 'Main'; then return QueueKey(ServiceType) with type is 'TB_CORE'")
  void testWithQueueName_whenMain_thenReturnQueueKeyWithTypeIsTbCore() {
    // Arrange
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);

    // Act and Assert
    assertSame(queueKey, queueKey.withQueueName("Main"));
  }
}
