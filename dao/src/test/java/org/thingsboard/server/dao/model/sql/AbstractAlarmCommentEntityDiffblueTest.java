package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.alarm.AlarmCommentType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AbstractAlarmCommentEntityDiffblueTest {
  /**
   * Test {@link AbstractAlarmCommentEntity#toAlarmComment()}.
   * <ul>
   *   <li>Given {@link AlarmCommentEntity#AlarmCommentEntity()}.</li>
   *   <li>Then return UserId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#toAlarmComment()}
   */
  @Test
  public void testToAlarmComment_givenAlarmCommentEntity_thenReturnUserIdIsNull() {
    // Arrange and Act
    AlarmComment actualToAlarmCommentResult = (new AlarmCommentEntity()).toAlarmComment();

    // Assert
    assertNull(actualToAlarmCommentResult.getComment());
    assertNull(actualToAlarmCommentResult.getUuidId());
    AlarmId alarmId = actualToAlarmCommentResult.getAlarmId();
    assertNull(alarmId.getId());
    assertNull(actualToAlarmCommentResult.getId().getId());
    assertNull(actualToAlarmCommentResult.getType());
    assertNull(actualToAlarmCommentResult.getUserId());
    assertEquals(0L, actualToAlarmCommentResult.getCreatedTime());
    assertEquals(EntityType.ALARM, alarmId.getEntityType());
    assertFalse(alarmId.isNullUid());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#toAlarmComment()}.
   * <ul>
   *   <li>Then return UserId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#toAlarmComment()}
   */
  @Test
  public void testToAlarmComment_thenReturnUserIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);

    // Act
    AlarmComment actualToAlarmCommentResult = alarmCommentEntity.toAlarmComment();

    // Assert
    UserId userId = actualToAlarmCommentResult.getUserId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", userId.getId().toString());
    assertNull(actualToAlarmCommentResult.getComment());
    assertNull(actualToAlarmCommentResult.getUuidId());
    AlarmId alarmId = actualToAlarmCommentResult.getAlarmId();
    assertNull(alarmId.getId());
    assertNull(actualToAlarmCommentResult.getId().getId());
    assertNull(actualToAlarmCommentResult.getType());
    assertEquals(0L, actualToAlarmCommentResult.getCreatedTime());
    assertEquals(EntityType.ALARM, alarmId.getEntityType());
    assertEquals(EntityType.USER, userId.getEntityType());
    assertFalse(alarmId.isNullUid());
    assertTrue(userId.isNullUid());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#canEqual(Object)}.
   * <ul>
   *   <li>When {@link AlarmCommentEntity#AlarmCommentEntity()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#canEqual(Object)}
   */
  @Test
  public void testCanEqual_whenAlarmCommentEntity_thenReturnTrue() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();

    // Act and Assert
    assertTrue(alarmCommentEntity.canEqual(new AlarmCommentEntity()));
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#canEqual(Object)}
   */
  @Test
  public void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AlarmCommentEntity()).canEqual("Other"));
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}, and
   * {@link AbstractAlarmCommentEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    AlarmCommentEntity alarmCommentEntity2 = new AlarmCommentEntity();

    // Act and Assert
    assertEquals(alarmCommentEntity, alarmCommentEntity2);
    int expectedHashCodeResult = alarmCommentEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentEntity2.hashCode());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}, and
   * {@link AbstractAlarmCommentEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();

    // Act and Assert
    assertEquals(alarmCommentEntity, alarmCommentEntity);
    int expectedHashCodeResult = alarmCommentEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentEntity.hashCode());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();

    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, adminSettingsEntity);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    AlarmCommentEntity alarmCommentEntity2 = mock(AlarmCommentEntity.class);
    when(alarmCommentEntity2.getComment()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(alarmCommentEntity2.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(alarmCommentEntity2.getAlarmId()).thenReturn(ModelConstants.NULL_UUID);
    when(alarmCommentEntity2.getUserId()).thenReturn(ModelConstants.NULL_UUID);
    when(alarmCommentEntity2.getCreatedTime()).thenReturn(1L);
    when(alarmCommentEntity2.getType()).thenReturn(AlarmCommentType.SYSTEM);
    when(alarmCommentEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, alarmCommentEntity2);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentEntity(), null);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentEntity(), "Different type to AbstractAlarmCommentEntity");
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#getAlarmId()}.
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#getAlarmId()}
   */
  @Test
  public void testGetAlarmId() {
    // Arrange, Act and Assert
    assertNull((new AlarmCommentEntity()).getAlarmId());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#getComment()}.
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#getComment()}
   */
  @Test
  public void testGetComment() {
    // Arrange, Act and Assert
    assertNull((new AlarmCommentEntity()).getComment());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#getType()}.
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull((new AlarmCommentEntity()).getType());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#getUserId()}.
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#getUserId()}
   */
  @Test
  public void testGetUserId() {
    // Arrange, Act and Assert
    assertNull((new AlarmCommentEntity()).getUserId());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#setAlarmId(UUID)}.
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#setAlarmId(UUID)}
   */
  @Test
  public void testSetAlarmId() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    UUID alarmId = ModelConstants.NULL_UUID;

    // Act
    alarmCommentEntity.setAlarmId(alarmId);

    // Assert
    AlarmId alarmId2 = alarmCommentEntity.toData().getAlarmId();
    assertTrue(alarmId2.isNullUid());
    assertSame(alarmId, alarmId2.getId());
    assertSame(alarmId, alarmCommentEntity.getAlarmId());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#setComment(JsonNode)}.
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#setComment(JsonNode)}
   */
  @Test
  public void testSetComment() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    JsonNode comment = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    alarmCommentEntity.setComment(comment);

    // Assert
    AlarmComment toDataResult = alarmCommentEntity.toData();
    assertEquals("{\"isPublic\":true}", toDataResult.getName());
    assertSame(comment, toDataResult.getComment());
    assertSame(comment, alarmCommentEntity.getComment());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#setType(AlarmCommentType)}.
   * <p>
   * Method under test:
   * {@link AbstractAlarmCommentEntity#setType(AlarmCommentType)}
   */
  @Test
  public void testSetType() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();

    // Act
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);

    // Assert
    assertEquals(AlarmCommentType.SYSTEM, alarmCommentEntity.toData().getType());
    assertEquals(AlarmCommentType.SYSTEM, alarmCommentEntity.getType());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#setUserId(UUID)}.
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#setUserId(UUID)}
   */
  @Test
  public void testSetUserId() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    UUID userId = ModelConstants.NULL_UUID;

    // Act
    alarmCommentEntity.setUserId(userId);

    // Assert
    UserId userId2 = alarmCommentEntity.toData().getUserId();
    assertEquals(EntityType.USER, userId2.getEntityType());
    assertTrue(userId2.isNullUid());
    assertSame(userId, userId2.getId());
    assertSame(userId, alarmCommentEntity.getUserId());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#toString()}.
   * <p>
   * Method under test: {@link AbstractAlarmCommentEntity#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("AlarmCommentEntity()", (new AlarmCommentEntity()).toString());
  }
}
