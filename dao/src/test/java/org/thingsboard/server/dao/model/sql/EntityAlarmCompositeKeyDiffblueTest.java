package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.alarm.EntityAlarm;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityAlarmCompositeKeyDiffblueTest {
  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}, and
   * {@link EntityAlarmCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarmCompositeKey#equals(Object)}
   *   <li>{@link EntityAlarmCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey();
    EntityAlarmCompositeKey entityAlarmCompositeKey2 = new EntityAlarmCompositeKey();

    // Act and Assert
    assertEquals(entityAlarmCompositeKey, entityAlarmCompositeKey2);
    int expectedHashCodeResult = entityAlarmCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmCompositeKey2.hashCode());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}, and
   * {@link EntityAlarmCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarmCompositeKey#equals(Object)}
   *   <li>{@link EntityAlarmCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID);
    EntityAlarmCompositeKey entityAlarmCompositeKey2 = new EntityAlarmCompositeKey(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(entityAlarmCompositeKey, entityAlarmCompositeKey2);
    int expectedHashCodeResult = entityAlarmCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmCompositeKey2.hashCode());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}, and
   * {@link EntityAlarmCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarmCompositeKey#equals(Object)}
   *   <li>{@link EntityAlarmCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey();

    // Act and Assert
    assertEquals(entityAlarmCompositeKey, entityAlarmCompositeKey);
    int expectedHashCodeResult = entityAlarmCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmCompositeKey.hashCode());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmCompositeKey, new EntityAlarmCompositeKey());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey();

    // Act and Assert
    assertNotEquals(entityAlarmCompositeKey,
        new EntityAlarmCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID));
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey();
    entityAlarmCompositeKey.setAlarmId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmCompositeKey, new EntityAlarmCompositeKey());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey();

    EntityAlarmCompositeKey entityAlarmCompositeKey2 = new EntityAlarmCompositeKey();
    entityAlarmCompositeKey2.setAlarmId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(entityAlarmCompositeKey, entityAlarmCompositeKey2);
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(entityAlarm.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey(entityAlarm);

    // Act and Assert
    assertNotEquals(entityAlarmCompositeKey, new EntityAlarmCompositeKey());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityAlarmCompositeKey(), null);
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityAlarmCompositeKey(), "Different type to EntityAlarmCompositeKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarmCompositeKey#EntityAlarmCompositeKey()}
   *   <li>{@link EntityAlarmCompositeKey#setAlarmId(UUID)}
   *   <li>{@link EntityAlarmCompositeKey#setEntityId(UUID)}
   *   <li>{@link EntityAlarmCompositeKey#toString()}
   *   <li>{@link EntityAlarmCompositeKey#getAlarmId()}
   *   <li>{@link EntityAlarmCompositeKey#getEntityId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityAlarmCompositeKey actualEntityAlarmCompositeKey = new EntityAlarmCompositeKey();
    actualEntityAlarmCompositeKey.setAlarmId(ModelConstants.NULL_UUID);
    UUID entityId = ModelConstants.NULL_UUID;
    actualEntityAlarmCompositeKey.setEntityId(entityId);
    String actualToStringResult = actualEntityAlarmCompositeKey.toString();
    UUID actualAlarmId = actualEntityAlarmCompositeKey.getAlarmId();
    UUID actualEntityId = actualEntityAlarmCompositeKey.getEntityId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAlarmId.toString());
    assertEquals(
        "EntityAlarmCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, alarmId=13814000-1dd2-11b2-8080"
            + "-808080808080)",
        actualToStringResult);
    assertSame(entityId, actualAlarmId);
    assertSame(entityId, actualEntityId);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarmCompositeKey#EntityAlarmCompositeKey(UUID, UUID)}
   *   <li>{@link EntityAlarmCompositeKey#setAlarmId(UUID)}
   *   <li>{@link EntityAlarmCompositeKey#setEntityId(UUID)}
   *   <li>{@link EntityAlarmCompositeKey#toString()}
   *   <li>{@link EntityAlarmCompositeKey#getAlarmId()}
   *   <li>{@link EntityAlarmCompositeKey#getEntityId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    EntityAlarmCompositeKey actualEntityAlarmCompositeKey = new EntityAlarmCompositeKey(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID);
    actualEntityAlarmCompositeKey.setAlarmId(ModelConstants.NULL_UUID);
    UUID entityId = ModelConstants.NULL_UUID;
    actualEntityAlarmCompositeKey.setEntityId(entityId);
    String actualToStringResult = actualEntityAlarmCompositeKey.toString();
    UUID actualAlarmId = actualEntityAlarmCompositeKey.getAlarmId();
    UUID actualEntityId = actualEntityAlarmCompositeKey.getEntityId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAlarmId.toString());
    assertEquals(
        "EntityAlarmCompositeKey(entityId=13814000-1dd2-11b2-8080-808080808080, alarmId=13814000-1dd2-11b2-8080"
            + "-808080808080)",
        actualToStringResult);
    assertSame(entityId, actualAlarmId);
    assertSame(entityId, actualEntityId);
  }

  /**
   * Test {@link EntityAlarmCompositeKey#EntityAlarmCompositeKey(EntityAlarm)}.
   * <p>
   * Method under test:
   * {@link EntityAlarmCompositeKey#EntityAlarmCompositeKey(EntityAlarm)}
   */
  @Test
  public void testNewEntityAlarmCompositeKey() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setAlarmId(new AlarmId(ModelConstants.NULL_UUID));
    entityAlarm.setEntityId(entityId);

    // Act
    EntityAlarmCompositeKey actualEntityAlarmCompositeKey = new EntityAlarmCompositeKey(entityAlarm);

    // Assert
    verify(entityId).getId();
    UUID alarmId = actualEntityAlarmCompositeKey.getAlarmId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", alarmId.toString());
    assertSame(alarmId, actualEntityAlarmCompositeKey.getEntityId());
  }
}
