package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.alarm.AlarmCommentType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class AbstractAlarmCommentEntityDiffblueTest {
  /**
   * Test {@link AbstractAlarmCommentEntity#toAlarmComment()}.
   *
   * <ul>
   *   <li>Given {@link AlarmCommentEntity#AlarmCommentEntity()}.
   *   <li>Then return Comment is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#toAlarmComment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmComment AbstractAlarmCommentEntity.toAlarmComment()"})
  public void testToAlarmComment_givenAlarmCommentEntity_thenReturnCommentIsNull() {
    // Arrange and Act
    AlarmComment actualToAlarmCommentResult = new AlarmCommentEntity().toAlarmComment();

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
   *
   * <ul>
   *   <li>Then return UserId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#toAlarmComment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmComment AbstractAlarmCommentEntity.toAlarmComment()"})
  public void testToAlarmComment_thenReturnUserIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmCommentEntity.setUserId(userId);

    // Act and Assert
    UserId userId2 = alarmCommentEntity.toAlarmComment().getUserId();
    UUID id = userId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.USER, userId2.getEntityType());
    assertFalse(userId2.isNullUid());
    assertSame(userId, id);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link AlarmCommentEntity#AlarmCommentEntity()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#canEqual(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractAlarmCommentEntity.canEqual(Object)"})
  public void testCanEqual_whenAlarmCommentEntity_thenReturnTrue() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();

    // Act and Assert
    assertTrue(alarmCommentEntity.canEqual(new AlarmCommentEntity()));
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#canEqual(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractAlarmCommentEntity.canEqual(Object)"})
  public void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new AlarmCommentEntity().canEqual("Other"));
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}, and {@link
   * AbstractAlarmCommentEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
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
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}, and {@link
   * AbstractAlarmCommentEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    AlarmCommentEntity alarmCommentEntity2 = mock(AlarmCommentEntity.class);
    when(alarmCommentEntity2.getComment()).thenReturn(null);
    when(alarmCommentEntity2.getId()).thenReturn(null);
    when(alarmCommentEntity2.getAlarmId()).thenReturn(null);
    when(alarmCommentEntity2.getUserId()).thenReturn(null);
    when(alarmCommentEntity2.getType()).thenReturn(null);
    when(alarmCommentEntity2.getCreatedTime()).thenReturn(0L);
    when(alarmCommentEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(alarmCommentEntity, alarmCommentEntity2);
    int notExpectedHashCodeResult = alarmCommentEntity.hashCode();
    assertNotEquals(notExpectedHashCodeResult, alarmCommentEntity2.hashCode());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}, and {@link
   * AbstractAlarmCommentEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmCommentEntity alarmCommentEntity2 = mock(AlarmCommentEntity.class);
    when(alarmCommentEntity2.getComment()).thenReturn(null);
    when(alarmCommentEntity2.getId()).thenReturn(null);
    when(alarmCommentEntity2.getAlarmId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(alarmCommentEntity2.getUserId()).thenReturn(null);
    when(alarmCommentEntity2.getType()).thenReturn(null);
    when(alarmCommentEntity2.getCreatedTime()).thenReturn(0L);
    when(alarmCommentEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(alarmCommentEntity, alarmCommentEntity2);
    int notExpectedHashCodeResult = alarmCommentEntity.hashCode();
    assertNotEquals(notExpectedHashCodeResult, alarmCommentEntity2.hashCode());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}, and {@link
   * AbstractAlarmCommentEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmCommentEntity alarmCommentEntity2 = mock(AlarmCommentEntity.class);
    when(alarmCommentEntity2.getComment()).thenReturn(null);
    when(alarmCommentEntity2.getId()).thenReturn(null);
    when(alarmCommentEntity2.getAlarmId()).thenReturn(null);
    when(alarmCommentEntity2.getUserId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(alarmCommentEntity2.getType()).thenReturn(null);
    when(alarmCommentEntity2.getCreatedTime()).thenReturn(0L);
    when(alarmCommentEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(alarmCommentEntity, alarmCommentEntity2);
    int notExpectedHashCodeResult = alarmCommentEntity.hashCode();
    assertNotEquals(notExpectedHashCodeResult, alarmCommentEntity2.hashCode());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}, and {@link
   * AbstractAlarmCommentEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    AlarmCommentEntity alarmCommentEntity2 = mock(AlarmCommentEntity.class);
    when(alarmCommentEntity2.getComment()).thenReturn(null);
    when(alarmCommentEntity2.getId()).thenReturn(null);
    when(alarmCommentEntity2.getAlarmId()).thenReturn(null);
    when(alarmCommentEntity2.getUserId()).thenReturn(null);
    when(alarmCommentEntity2.getType()).thenReturn(AlarmCommentType.SYSTEM);
    when(alarmCommentEntity2.getCreatedTime()).thenReturn(0L);
    when(alarmCommentEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(alarmCommentEntity, alarmCommentEntity2);
    int notExpectedHashCodeResult = alarmCommentEntity.hashCode();
    assertNotEquals(notExpectedHashCodeResult, alarmCommentEntity2.hashCode());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}, and {@link
   * AbstractAlarmCommentEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    AlarmCommentEntity alarmCommentEntity2 = mock(AlarmCommentEntity.class);
    when(alarmCommentEntity2.getComment())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(alarmCommentEntity2.getId()).thenReturn(null);
    when(alarmCommentEntity2.getAlarmId()).thenReturn(null);
    when(alarmCommentEntity2.getUserId()).thenReturn(null);
    when(alarmCommentEntity2.getType()).thenReturn(null);
    when(alarmCommentEntity2.getCreatedTime()).thenReturn(0L);
    when(alarmCommentEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(alarmCommentEntity, alarmCommentEntity2);
    int notExpectedHashCodeResult = alarmCommentEntity.hashCode();
    assertNotEquals(notExpectedHashCodeResult, alarmCommentEntity2.hashCode());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}, and {@link
   * AbstractAlarmCommentEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();

    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    adminSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmCommentEntity, adminSettingsEntity);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    AlarmCommentEntity alarmCommentEntity2 = mock(AlarmCommentEntity.class);
    when(alarmCommentEntity2.getComment()).thenReturn(null);
    when(alarmCommentEntity2.getId()).thenReturn(null);
    when(alarmCommentEntity2.getAlarmId()).thenReturn(null);
    when(alarmCommentEntity2.getUserId()).thenReturn(null);
    when(alarmCommentEntity2.getType()).thenReturn(null);
    when(alarmCommentEntity2.getCreatedTime()).thenReturn(1L);
    when(alarmCommentEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, alarmCommentEntity2);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    AlarmCommentEntity alarmCommentEntity2 = mock(AlarmCommentEntity.class);
    when(alarmCommentEntity2.getComment())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(alarmCommentEntity2.getId()).thenReturn(null);
    when(alarmCommentEntity2.getAlarmId()).thenReturn(null);
    when(alarmCommentEntity2.getUserId()).thenReturn(null);
    when(alarmCommentEntity2.getType()).thenReturn(null);
    when(alarmCommentEntity2.getCreatedTime()).thenReturn(0L);
    when(alarmCommentEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, alarmCommentEntity2);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    AlarmCommentEntity alarmCommentEntity2 = mock(AlarmCommentEntity.class);
    when(alarmCommentEntity2.getComment()).thenReturn(null);
    when(alarmCommentEntity2.getId()).thenReturn(null);
    when(alarmCommentEntity2.getAlarmId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(alarmCommentEntity2.getUserId()).thenReturn(null);
    when(alarmCommentEntity2.getType()).thenReturn(null);
    when(alarmCommentEntity2.getCreatedTime()).thenReturn(0L);
    when(alarmCommentEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, alarmCommentEntity2);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    AlarmCommentEntity alarmCommentEntity2 = mock(AlarmCommentEntity.class);
    when(alarmCommentEntity2.getComment()).thenReturn(null);
    when(alarmCommentEntity2.getId()).thenReturn(null);
    when(alarmCommentEntity2.getAlarmId()).thenReturn(null);
    when(alarmCommentEntity2.getUserId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(alarmCommentEntity2.getType()).thenReturn(null);
    when(alarmCommentEntity2.getCreatedTime()).thenReturn(0L);
    when(alarmCommentEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, alarmCommentEntity2);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    AlarmCommentEntity alarmCommentEntity2 = mock(AlarmCommentEntity.class);
    when(alarmCommentEntity2.getComment()).thenReturn(null);
    when(alarmCommentEntity2.getId()).thenReturn(null);
    when(alarmCommentEntity2.getAlarmId()).thenReturn(null);
    when(alarmCommentEntity2.getUserId()).thenReturn(null);
    when(alarmCommentEntity2.getType()).thenReturn(AlarmCommentType.SYSTEM);
    when(alarmCommentEntity2.getCreatedTime()).thenReturn(0L);
    when(alarmCommentEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, alarmCommentEntity2);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmCommentEntity alarmCommentEntity2 = mock(AlarmCommentEntity.class);
    when(alarmCommentEntity2.getComment()).thenReturn(null);
    when(alarmCommentEntity2.getId()).thenReturn(null);
    when(alarmCommentEntity2.getAlarmId()).thenReturn(null);
    when(alarmCommentEntity2.getUserId()).thenReturn(null);
    when(alarmCommentEntity2.getType()).thenReturn(null);
    when(alarmCommentEntity2.getCreatedTime()).thenReturn(0L);
    when(alarmCommentEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, alarmCommentEntity2);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmCommentEntity alarmCommentEntity2 = mock(AlarmCommentEntity.class);
    when(alarmCommentEntity2.getComment()).thenReturn(null);
    when(alarmCommentEntity2.getId()).thenReturn(null);
    when(alarmCommentEntity2.getAlarmId()).thenReturn(null);
    when(alarmCommentEntity2.getUserId()).thenReturn(null);
    when(alarmCommentEntity2.getType()).thenReturn(null);
    when(alarmCommentEntity2.getCreatedTime()).thenReturn(0L);
    when(alarmCommentEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, alarmCommentEntity2);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    AlarmCommentEntity alarmCommentEntity2 = mock(AlarmCommentEntity.class);
    when(alarmCommentEntity2.getComment()).thenReturn(null);
    when(alarmCommentEntity2.getId()).thenReturn(null);
    when(alarmCommentEntity2.getAlarmId()).thenReturn(null);
    when(alarmCommentEntity2.getUserId()).thenReturn(null);
    when(alarmCommentEntity2.getType()).thenReturn(null);
    when(alarmCommentEntity2.getCreatedTime()).thenReturn(0L);
    when(alarmCommentEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, alarmCommentEntity2);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    AlarmCommentEntity alarmCommentEntity2 = mock(AlarmCommentEntity.class);
    when(alarmCommentEntity2.getComment()).thenReturn(null);
    when(alarmCommentEntity2.getId()).thenReturn(null);
    when(alarmCommentEntity2.getAlarmId()).thenReturn(null);
    when(alarmCommentEntity2.getUserId()).thenReturn(null);
    when(alarmCommentEntity2.getType()).thenReturn(null);
    when(alarmCommentEntity2.getCreatedTime()).thenReturn(0L);
    when(alarmCommentEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmCommentEntity, alarmCommentEntity2);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentEntity(), null);
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentEntity(), "Different type to AbstractAlarmCommentEntity");
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#getAlarmId()}.
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#getAlarmId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UUID AbstractAlarmCommentEntity.getAlarmId()"})
  public void testGetAlarmId() {
    // Arrange, Act and Assert
    assertNull(new AlarmCommentEntity().getAlarmId());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#getComment()}.
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#getComment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JsonNode AbstractAlarmCommentEntity.getComment()"})
  public void testGetComment() {
    // Arrange, Act and Assert
    assertNull(new AlarmCommentEntity().getComment());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#getType()}.
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmCommentType AbstractAlarmCommentEntity.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull(new AlarmCommentEntity().getType());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#getUserId()}.
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#getUserId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UUID AbstractAlarmCommentEntity.getUserId()"})
  public void testGetUserId() {
    // Arrange, Act and Assert
    assertNull(new AlarmCommentEntity().getUserId());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#setAlarmId(UUID)}.
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#setAlarmId(UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractAlarmCommentEntity.setAlarmId(UUID)"})
  public void testSetAlarmId() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    UUID alarmId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    alarmCommentEntity.setAlarmId(alarmId);

    // Assert
    assertSame(alarmId, alarmCommentEntity.toData().getAlarmId().getId());
    assertSame(alarmId, alarmCommentEntity.getAlarmId());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#setComment(JsonNode)}.
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#setComment(JsonNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractAlarmCommentEntity.setComment(JsonNode)"})
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
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#setType(AlarmCommentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractAlarmCommentEntity.setType(AlarmCommentType)"})
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
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#setUserId(UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractAlarmCommentEntity.setUserId(UUID)"})
  public void testSetUserId() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    alarmCommentEntity.setUserId(userId);

    // Assert
    UserId userId2 = alarmCommentEntity.toData().getUserId();
    assertEquals(EntityType.USER, userId2.getEntityType());
    assertFalse(userId2.isNullUid());
    assertSame(userId, userId2.getId());
    assertSame(userId, alarmCommentEntity.getUserId());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#toString()}.
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String AbstractAlarmCommentEntity.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("AlarmCommentEntity()", new AlarmCommentEntity().toString());
  }
}
