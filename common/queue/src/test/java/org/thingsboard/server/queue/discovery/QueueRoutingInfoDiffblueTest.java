package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;
import org.thingsboard.server.gen.transport.TransportProtos;

class QueueRoutingInfoDiffblueTest {
  /**
   * Test {@link QueueRoutingInfo#QueueRoutingInfo(Queue)}.
   * <p>
   * Method under test: {@link QueueRoutingInfo#QueueRoutingInfo(Queue)}
   */
  @Test
  @DisplayName("Test new QueueRoutingInfo(Queue)")
  void testNewQueueRoutingInfo() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(tenantId,
        (new QueueRoutingInfo(new Queue(tenantId, new TenantProfileQueueConfiguration()))).getTenantId());
  }

  /**
   * Test
   * {@link QueueRoutingInfo#QueueRoutingInfo(GetQueueRoutingInfoResponseMsg)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return QueueName is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueueRoutingInfo#QueueRoutingInfo(TransportProtos.GetQueueRoutingInfoResponseMsg)}
   */
  @Test
  @DisplayName("Test new QueueRoutingInfo(GetQueueRoutingInfoResponseMsg); when DefaultInstance; then return QueueName is empty string")
  void testNewQueueRoutingInfo_whenDefaultInstance_thenReturnQueueNameIsEmptyString() {
    // Arrange and Act
    QueueRoutingInfo actualQueueRoutingInfo = new QueueRoutingInfo(
        TransportProtos.GetQueueRoutingInfoResponseMsg.getDefaultInstance());

    // Assert
    assertEquals("", actualQueueRoutingInfo.getQueueName());
    assertEquals("", actualQueueRoutingInfo.getQueueTopic());
    QueueId queueId = actualQueueRoutingInfo.getQueueId();
    assertEquals("00000000-0000-0000-0000-000000000000", queueId.getId().toString());
    TenantId tenantId = actualQueueRoutingInfo.getTenantId();
    assertEquals("00000000-0000-0000-0000-000000000000", tenantId.getId().toString());
    assertEquals(0, actualQueueRoutingInfo.getPartitions());
    assertEquals(EntityType.QUEUE, queueId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(queueId.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertFalse(actualQueueRoutingInfo.isDuplicateMsgToAllPartitions());
  }

  /**
   * Test {@link QueueRoutingInfo#QueueRoutingInfo(QueueUpdateMsg)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return QueueName is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueueRoutingInfo#QueueRoutingInfo(TransportProtos.QueueUpdateMsg)}
   */
  @Test
  @DisplayName("Test new QueueRoutingInfo(QueueUpdateMsg); when DefaultInstance; then return QueueName is empty string")
  void testNewQueueRoutingInfo_whenDefaultInstance_thenReturnQueueNameIsEmptyString2() {
    // Arrange and Act
    QueueRoutingInfo actualQueueRoutingInfo = new QueueRoutingInfo(TransportProtos.QueueUpdateMsg.getDefaultInstance());

    // Assert
    assertEquals("", actualQueueRoutingInfo.getQueueName());
    assertEquals("", actualQueueRoutingInfo.getQueueTopic());
    QueueId queueId = actualQueueRoutingInfo.getQueueId();
    assertEquals("00000000-0000-0000-0000-000000000000", queueId.getId().toString());
    TenantId tenantId = actualQueueRoutingInfo.getTenantId();
    assertEquals("00000000-0000-0000-0000-000000000000", tenantId.getId().toString());
    assertEquals(0, actualQueueRoutingInfo.getPartitions());
    assertEquals(EntityType.QUEUE, queueId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(queueId.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertFalse(actualQueueRoutingInfo.isDuplicateMsgToAllPartitions());
  }

  /**
   * Test {@link QueueRoutingInfo#QueueRoutingInfo(Queue)}.
   * <ul>
   *   <li>When {@link Queue#Queue()}.</li>
   *   <li>Then return QueueName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#QueueRoutingInfo(Queue)}
   */
  @Test
  @DisplayName("Test new QueueRoutingInfo(Queue); when Queue(); then return QueueName is 'null'")
  void testNewQueueRoutingInfo_whenQueue_thenReturnQueueNameIsNull() {
    // Arrange and Act
    QueueRoutingInfo actualQueueRoutingInfo = new QueueRoutingInfo(new Queue());

    // Assert
    assertNull(actualQueueRoutingInfo.getQueueName());
    assertNull(actualQueueRoutingInfo.getQueueTopic());
    assertNull(actualQueueRoutingInfo.getQueueId());
    assertNull(actualQueueRoutingInfo.getTenantId());
    assertEquals(0, actualQueueRoutingInfo.getPartitions());
    assertFalse(actualQueueRoutingInfo.isDuplicateMsgToAllPartitions());
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}, and
   * {@link QueueRoutingInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueRoutingInfo#equals(Object)}
   *   <li>{@link QueueRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue());
    QueueRoutingInfo queueRoutingInfo2 = new QueueRoutingInfo(new Queue());

    // Act and Assert
    assertEquals(queueRoutingInfo, queueRoutingInfo2);
    int expectedHashCodeResult = queueRoutingInfo.hashCode();
    assertEquals(expectedHashCodeResult, queueRoutingInfo2.hashCode());
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}, and
   * {@link QueueRoutingInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueRoutingInfo#equals(Object)}
   *   <li>{@link QueueRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue());

    // Act and Assert
    assertEquals(queueRoutingInfo, queueRoutingInfo);
    int expectedHashCodeResult = queueRoutingInfo.hashCode();
    assertEquals(expectedHashCodeResult, queueRoutingInfo.hashCode());
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(
        new Queue(tenantId, new TenantProfileQueueConfiguration()));

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue()));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.isDuplicateMsgToAllPartitions()).thenReturn(true);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getName()).thenReturn("Name");
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getTenantId()).thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(queue.getId()).thenReturn(null);
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(queue);

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue()));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.isDuplicateMsgToAllPartitions()).thenReturn(true);
    when(queue.getPartitions()).thenReturn(0);
    when(queue.getName()).thenReturn("Name");
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getTenantId()).thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(queue.getId()).thenReturn(null);
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(queue);

    // Act and Assert
    assertNotEquals(queueRoutingInfo, new QueueRoutingInfo(new Queue()));
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueRoutingInfo(new Queue()), null);
  }

  /**
   * Test {@link QueueRoutingInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueRoutingInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueRoutingInfo(new Queue()), "Different type to QueueRoutingInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueRoutingInfo#toString()}
   *   <li>{@link QueueRoutingInfo#getPartitions()}
   *   <li>{@link QueueRoutingInfo#getQueueId()}
   *   <li>{@link QueueRoutingInfo#getQueueName()}
   *   <li>{@link QueueRoutingInfo#getQueueTopic()}
   *   <li>{@link QueueRoutingInfo#getTenantId()}
   *   <li>{@link QueueRoutingInfo#isDuplicateMsgToAllPartitions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = new QueueRoutingInfo(new Queue());

    // Act
    String actualToStringResult = queueRoutingInfo.toString();
    int actualPartitions = queueRoutingInfo.getPartitions();
    QueueId actualQueueId = queueRoutingInfo.getQueueId();
    String actualQueueName = queueRoutingInfo.getQueueName();
    String actualQueueTopic = queueRoutingInfo.getQueueTopic();
    TenantId actualTenantId = queueRoutingInfo.getTenantId();

    // Assert
    assertEquals("QueueRoutingInfo(tenantId=null, queueId=null, queueName=null, queueTopic=null, partitions=0,"
        + " duplicateMsgToAllPartitions=false)", actualToStringResult);
    assertNull(actualQueueName);
    assertNull(actualQueueTopic);
    assertNull(actualQueueId);
    assertNull(actualTenantId);
    assertEquals(0, actualPartitions);
    assertFalse(queueRoutingInfo.isDuplicateMsgToAllPartitions());
  }
}
