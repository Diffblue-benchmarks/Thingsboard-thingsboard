package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.QueueStatsId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.QueueStats;
import org.thingsboard.server.dao.model.ModelConstants;

public class QueueStatsEntityDiffblueTest {
  /**
   * Test {@link QueueStatsEntity#equals(Object)}, and
   * {@link QueueStatsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueStatsEntity#equals(Object)}
   *   <li>{@link QueueStatsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(queueStatsEntity, queueStatsEntity2);
    int expectedHashCodeResult = queueStatsEntity.hashCode();
    assertEquals(expectedHashCodeResult, queueStatsEntity2.hashCode());
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}, and
   * {@link QueueStatsEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueStatsEntity#equals(Object)}
   *   <li>{@link QueueStatsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(queueStatsEntity, queueStatsEntity);
    int expectedHashCodeResult = queueStatsEntity.hashCode();
    assertEquals(expectedHashCodeResult, queueStatsEntity.hashCode());
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(3L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueStatsEntity, queueStatsEntity2);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("42");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueStatsEntity, queueStatsEntity2);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName(null);
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueStatsEntity, queueStatsEntity2);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("Queue Name");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueStatsEntity, queueStatsEntity2);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId(null);
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueStatsEntity, queueStatsEntity2);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(UUID.randomUUID());
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueStatsEntity, queueStatsEntity2);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(null);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    QueueStatsEntity queueStatsEntity2 = new QueueStatsEntity();
    queueStatsEntity2.setCreatedTime(1L);
    queueStatsEntity2.setId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setQueueName("Queue Name");
    queueStatsEntity2.setServiceId("42");
    queueStatsEntity2.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueStatsEntity, queueStatsEntity2);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueStatsEntity, null);
  }

  /**
   * Test {@link QueueStatsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(queueStatsEntity, "Different type to QueueStatsEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueStatsEntity#QueueStatsEntity()}
   *   <li>{@link QueueStatsEntity#setQueueName(String)}
   *   <li>{@link QueueStatsEntity#setServiceId(String)}
   *   <li>{@link QueueStatsEntity#setTenantId(UUID)}
   *   <li>{@link QueueStatsEntity#toString()}
   *   <li>{@link QueueStatsEntity#getQueueName()}
   *   <li>{@link QueueStatsEntity#getServiceId()}
   *   <li>{@link QueueStatsEntity#getTenantId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    QueueStatsEntity actualQueueStatsEntity = new QueueStatsEntity();
    actualQueueStatsEntity.setQueueName("Queue Name");
    actualQueueStatsEntity.setServiceId("42");
    UUID tenantId = ModelConstants.NULL_UUID;
    actualQueueStatsEntity.setTenantId(tenantId);
    String actualToStringResult = actualQueueStatsEntity.toString();
    String actualQueueName = actualQueueStatsEntity.getQueueName();
    String actualServiceId = actualQueueStatsEntity.getServiceId();
    UUID actualTenantId = actualQueueStatsEntity.getTenantId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantId.toString());
    assertEquals("42", actualServiceId);
    assertEquals("Queue Name", actualQueueName);
    assertEquals("QueueStatsEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, queueName=Queue Name, serviceId=42)",
        actualToStringResult);
    assertEquals(0L, actualQueueStatsEntity.getCreatedTime());
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link QueueStats#QueueStats()} Id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}
   */
  @Test
  public void testNewQueueStatsEntity_givenNull_whenQueueStatsIdIsNull() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setId(null);
    queueStats.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    QueueStatsEntity actualQueueStatsEntity = new QueueStatsEntity(queueStats);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualQueueStatsEntity.getTenantId().toString());
    assertNull(actualQueueStatsEntity.getId());
    assertNull(actualQueueStatsEntity.getUuid());
    assertEquals(0L, actualQueueStatsEntity.getCreatedTime());
  }

  /**
   * Test {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return CreatedTime is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}
   */
  @Test
  public void testNewQueueStatsEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setCreatedTime(1L);

    // Act
    QueueStatsEntity actualQueueStatsEntity = new QueueStatsEntity(queueStats);

    // Assert
    assertNull(actualQueueStatsEntity.getId());
    assertNull(actualQueueStatsEntity.getUuid());
    assertNull(actualQueueStatsEntity.getTenantId());
    assertEquals(1L, actualQueueStatsEntity.getCreatedTime());
  }

  /**
   * Test {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}.
   * <ul>
   *   <li>Then return Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}
   */
  @Test
  public void testNewQueueStatsEntity_thenReturnIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setId(new QueueStatsId(ModelConstants.NULL_UUID));
    queueStats.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    QueueStatsEntity actualQueueStatsEntity = new QueueStatsEntity(queueStats);

    // Assert
    UUID id = actualQueueStatsEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualQueueStatsEntity.getTenantId().toString());
    assertEquals(0L, actualQueueStatsEntity.getCreatedTime());
    assertSame(id, actualQueueStatsEntity.getUuid());
  }

  /**
   * Test {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}.
   * <ul>
   *   <li>When {@link QueueStats#QueueStats()}.</li>
   *   <li>Then return TenantId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsEntity#QueueStatsEntity(QueueStats)}
   */
  @Test
  public void testNewQueueStatsEntity_whenQueueStats_thenReturnTenantIdIsNull() {
    // Arrange and Act
    QueueStatsEntity actualQueueStatsEntity = new QueueStatsEntity(new QueueStats());

    // Assert
    assertNull(actualQueueStatsEntity.getId());
    assertNull(actualQueueStatsEntity.getUuid());
    assertNull(actualQueueStatsEntity.getTenantId());
    assertEquals(0L, actualQueueStatsEntity.getCreatedTime());
  }

  /**
   * Test {@link QueueStatsEntity#toData()}.
   * <p>
   * Method under test: {@link QueueStatsEntity#toData()}
   */
  @Test
  public void testToData() {
    // Arrange and Act
    QueueStats actualToDataResult = (new QueueStatsEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getQueueName());
    assertNull(actualToDataResult.getServiceId());
    assertNull(actualToDataResult.getUuidId());
    QueueStatsId id = actualToDataResult.getId();
    assertNull(id.getId());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertNull(tenantId.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.QUEUE_STATS, id.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(id.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
