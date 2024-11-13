package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.EntityAlarm;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityAlarmEntityDiffblueTest {
  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and
   * {@link EntityAlarmEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = entityAlarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmEntity2.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and
   * {@link EntityAlarmEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = entityAlarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmEntity2.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and
   * {@link EntityAlarmEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = entityAlarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmEntity2.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and
   * {@link EntityAlarmEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = entityAlarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmEntity2.hashCode());
  }

  /**
   * Test {@link EntityAlarmEntity#equals(Object)}, and
   * {@link EntityAlarmEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarmEntity#equals(Object)}
   *   <li>{@link EntityAlarmEntity#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#equals(Object)}
   */
  @Test
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
   * <p>
   * Methods under test:
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
    UUID actualTenantId = actualEntityAlarmEntity.getTenantId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAlarmId.toString());
    assertEquals("Alarm Type", actualAlarmType);
    assertEquals("Entity Type", actualEntityType);
    assertEquals("EntityAlarmEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, entityType=Entity Type, entityId"
        + "=13814000-1dd2-11b2-8080-808080808080, alarmId=13814000-1dd2-11b2-8080-808080808080, createdTime=1,"
        + " alarmType=Alarm Type, customerId=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertEquals(1L, actualCreatedTime);
    assertSame(tenantId, actualAlarmId);
    assertSame(tenantId, actualCustomerId);
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link EntityAlarmEntity#EntityAlarmEntity(EntityAlarm)}.
   * <p>
   * Method under test: {@link EntityAlarmEntity#EntityAlarmEntity(EntityAlarm)}
   */
  @Test
  public void testNewEntityAlarmEntity() {
    // Arrange
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmType()).thenReturn("Alarm Type");
    when(entityAlarm.getCreatedTime()).thenReturn(1L);
    when(entityAlarm.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getAlarmId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(entityAlarm.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entityAlarm).setTenantId(Mockito.<TenantId>any());
    entityAlarm.setTenantId(new TenantId(ModelConstants.NULL_UUID));

    // Act
    EntityAlarmEntity actualEntityAlarmEntity = new EntityAlarmEntity(entityAlarm);

    // Assert
    verify(entityAlarm).getAlarmId();
    verify(entityAlarm).getAlarmType();
    verify(entityAlarm).getCreatedTime();
    verify(entityAlarm, atLeast(1)).getCustomerId();
    verify(entityAlarm, atLeast(1)).getEntityId();
    verify(entityAlarm).getTenantId();
    verify(entityAlarm).setTenantId(isA(TenantId.class));
    UUID customerId = actualEntityAlarmEntity.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.toString());
    assertEquals("CUSTOMER", actualEntityAlarmEntity.getEntityType());
    assertSame(customerId, actualEntityAlarmEntity.getEntityId());
    assertSame(customerId, actualEntityAlarmEntity.getTenantId());
  }

  /**
   * Test {@link EntityAlarmEntity#EntityAlarmEntity(EntityAlarm)}.
   * <p>
   * Method under test: {@link EntityAlarmEntity#EntityAlarmEntity(EntityAlarm)}
   */
  @Test
  public void testNewEntityAlarmEntity2() {
    // Arrange
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmType()).thenReturn("Alarm Type");
    when(entityAlarm.getCreatedTime()).thenReturn(1L);
    when(entityAlarm.getCustomerId()).thenReturn(null);
    when(entityAlarm.getAlarmId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(entityAlarm.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entityAlarm).setTenantId(Mockito.<TenantId>any());
    entityAlarm.setTenantId(new TenantId(ModelConstants.NULL_UUID));

    // Act
    EntityAlarmEntity actualEntityAlarmEntity = new EntityAlarmEntity(entityAlarm);

    // Assert
    verify(entityAlarm).getAlarmId();
    verify(entityAlarm).getAlarmType();
    verify(entityAlarm).getCreatedTime();
    verify(entityAlarm).getCustomerId();
    verify(entityAlarm, atLeast(1)).getEntityId();
    verify(entityAlarm).getTenantId();
    verify(entityAlarm).setTenantId(isA(TenantId.class));
    UUID entityId = actualEntityAlarmEntity.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertEquals("CUSTOMER", actualEntityAlarmEntity.getEntityType());
    assertNull(actualEntityAlarmEntity.getCustomerId());
    assertSame(entityId, actualEntityAlarmEntity.getTenantId());
  }

  /**
   * Test {@link EntityAlarmEntity#EntityAlarmEntity(EntityAlarm)}.
   * <ul>
   *   <li>Then return EntityType is {@code TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#EntityAlarmEntity(EntityAlarm)}
   */
  @Test
  public void testNewEntityAlarmEntity_thenReturnEntityTypeIsTenant() {
    // Arrange
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmType()).thenReturn("Alarm Type");
    when(entityAlarm.getCreatedTime()).thenReturn(1L);
    when(entityAlarm.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getAlarmId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(entityAlarm.getEntityId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entityAlarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entityAlarm).setTenantId(Mockito.<TenantId>any());
    entityAlarm.setTenantId(new TenantId(ModelConstants.NULL_UUID));

    // Act
    EntityAlarmEntity actualEntityAlarmEntity = new EntityAlarmEntity(entityAlarm);

    // Assert
    verify(entityAlarm).getAlarmId();
    verify(entityAlarm).getAlarmType();
    verify(entityAlarm).getCreatedTime();
    verify(entityAlarm, atLeast(1)).getCustomerId();
    verify(entityAlarm, atLeast(1)).getEntityId();
    verify(entityAlarm).getTenantId();
    verify(entityAlarm).setTenantId(isA(TenantId.class));
    UUID customerId = actualEntityAlarmEntity.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.toString());
    assertEquals("TENANT", actualEntityAlarmEntity.getEntityType());
    assertSame(customerId, actualEntityAlarmEntity.getEntityId());
    assertSame(customerId, actualEntityAlarmEntity.getTenantId());
  }

  /**
   * Test {@link EntityAlarmEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnAlarmId() {
    // Arrange
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmType()).thenReturn("Alarm Type");
    when(entityAlarm.getCreatedTime()).thenReturn(1L);
    when(entityAlarm.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getAlarmId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(entityAlarm.getEntityId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(entityAlarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    EntityAlarm actualToDataResult = (new EntityAlarmEntity(entityAlarm)).toData();

    // Assert
    verify(entityAlarm).getAlarmId();
    verify(entityAlarm).getAlarmType();
    verify(entityAlarm).getCreatedTime();
    verify(entityAlarm, atLeast(1)).getCustomerId();
    verify(entityAlarm, atLeast(1)).getEntityId();
    verify(entityAlarm).getTenantId();
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof AlarmId);
    assertEquals("Alarm Type", actualToDataResult.getAlarmType());
    assertEquals(EntityType.ALARM, entityId.getEntityType());
  }

  /**
   * Test {@link EntityAlarmEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link ApiUsageStateId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnApiUsageStateId() {
    // Arrange
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmType()).thenReturn("foo");
    when(entityAlarm.getCreatedTime()).thenReturn(1L);
    when(entityAlarm.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getAlarmId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(entityAlarm.getEntityId()).thenReturn(new ApiUsageStateId(ModelConstants.NULL_UUID));
    when(entityAlarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    EntityAlarm actualToDataResult = (new EntityAlarmEntity(entityAlarm)).toData();

    // Assert
    verify(entityAlarm).getAlarmId();
    verify(entityAlarm).getAlarmType();
    verify(entityAlarm).getCreatedTime();
    verify(entityAlarm, atLeast(1)).getCustomerId();
    verify(entityAlarm, atLeast(1)).getEntityId();
    verify(entityAlarm).getTenantId();
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof ApiUsageStateId);
    assertEquals("foo", actualToDataResult.getAlarmType());
    assertEquals(EntityType.API_USAGE_STATE, entityId.getEntityType());
  }

  /**
   * Test {@link EntityAlarmEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link AssetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnAssetId() {
    // Arrange
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmType()).thenReturn("foo");
    when(entityAlarm.getCreatedTime()).thenReturn(1L);
    when(entityAlarm.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getAlarmId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(entityAlarm.getEntityId()).thenReturn(new AssetId(ModelConstants.NULL_UUID));
    when(entityAlarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    EntityAlarm actualToDataResult = (new EntityAlarmEntity(entityAlarm)).toData();

    // Assert
    verify(entityAlarm).getAlarmId();
    verify(entityAlarm).getAlarmType();
    verify(entityAlarm).getCreatedTime();
    verify(entityAlarm, atLeast(1)).getCustomerId();
    verify(entityAlarm, atLeast(1)).getEntityId();
    verify(entityAlarm).getTenantId();
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof AssetId);
    assertEquals("foo", actualToDataResult.getAlarmType());
    assertEquals(EntityType.ASSET, entityId.getEntityType());
  }

  /**
   * Test {@link EntityAlarmEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link AssetProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnAssetProfileId() {
    // Arrange
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmType()).thenReturn("foo");
    when(entityAlarm.getCreatedTime()).thenReturn(1L);
    when(entityAlarm.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getAlarmId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(entityAlarm.getEntityId()).thenReturn(new AssetProfileId(ModelConstants.NULL_UUID));
    when(entityAlarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    EntityAlarm actualToDataResult = (new EntityAlarmEntity(entityAlarm)).toData();

    // Assert
    verify(entityAlarm).getAlarmId();
    verify(entityAlarm).getAlarmType();
    verify(entityAlarm).getCreatedTime();
    verify(entityAlarm, atLeast(1)).getCustomerId();
    verify(entityAlarm, atLeast(1)).getEntityId();
    verify(entityAlarm).getTenantId();
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof AssetProfileId);
    assertEquals("foo", actualToDataResult.getAlarmType());
    assertEquals(EntityType.ASSET_PROFILE, entityId.getEntityType());
  }

  /**
   * Test {@link EntityAlarmEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnCustomerId() {
    // Arrange
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmType()).thenReturn("Alarm Type");
    when(entityAlarm.getCreatedTime()).thenReturn(1L);
    when(entityAlarm.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getAlarmId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(entityAlarm.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    EntityAlarm actualToDataResult = (new EntityAlarmEntity(entityAlarm)).toData();

    // Assert
    verify(entityAlarm).getAlarmId();
    verify(entityAlarm).getAlarmType();
    verify(entityAlarm).getCreatedTime();
    verify(entityAlarm, atLeast(1)).getCustomerId();
    verify(entityAlarm, atLeast(1)).getEntityId();
    verify(entityAlarm).getTenantId();
    assertTrue(actualToDataResult.getEntityId() instanceof CustomerId);
  }

  /**
   * Test {@link EntityAlarmEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnDashboardId() {
    // Arrange
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmType()).thenReturn("foo");
    when(entityAlarm.getCreatedTime()).thenReturn(1L);
    when(entityAlarm.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getAlarmId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(entityAlarm.getEntityId()).thenReturn(new DashboardId(ModelConstants.NULL_UUID));
    when(entityAlarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    EntityAlarm actualToDataResult = (new EntityAlarmEntity(entityAlarm)).toData();

    // Assert
    verify(entityAlarm).getAlarmId();
    verify(entityAlarm).getAlarmType();
    verify(entityAlarm).getCreatedTime();
    verify(entityAlarm, atLeast(1)).getCustomerId();
    verify(entityAlarm, atLeast(1)).getEntityId();
    verify(entityAlarm).getTenantId();
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof DashboardId);
    assertEquals("foo", actualToDataResult.getAlarmType());
    assertEquals(EntityType.DASHBOARD, entityId.getEntityType());
  }

  /**
   * Test {@link EntityAlarmEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnTenantId() {
    // Arrange
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmType()).thenReturn("Alarm Type");
    when(entityAlarm.getCreatedTime()).thenReturn(1L);
    when(entityAlarm.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getAlarmId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(entityAlarm.getEntityId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entityAlarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    EntityAlarm actualToDataResult = (new EntityAlarmEntity(entityAlarm)).toData();

    // Assert
    verify(entityAlarm).getAlarmId();
    verify(entityAlarm).getAlarmType();
    verify(entityAlarm).getCreatedTime();
    verify(entityAlarm, atLeast(1)).getCustomerId();
    verify(entityAlarm, atLeast(1)).getEntityId();
    verify(entityAlarm).getTenantId();
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, actualToDataResult.getTenantId());
  }
}
