package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.alarm.AlarmCommentType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

class AbstractAlarmCommentEntityDiffblueTest {
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
  @DisplayName("Test toAlarmComment(); given AlarmCommentEntity(); then return Comment is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmComment AbstractAlarmCommentEntity.toAlarmComment()"})
  void testToAlarmComment_givenAlarmCommentEntity_thenReturnCommentIsNull() {
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
  @DisplayName(
      "Test toAlarmComment(); then return UserId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmComment AbstractAlarmCommentEntity.toAlarmComment()"})
  void testToAlarmComment_thenReturnUserIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
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
  @DisplayName("Test canEqual(Object); when AlarmCommentEntity(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractAlarmCommentEntity.canEqual(Object)"})
  void testCanEqual_whenAlarmCommentEntity_thenReturnTrue() {
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
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractAlarmCommentEntity.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAlarmCommentEntity.equals(Object)",
    "int AbstractAlarmCommentEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentEntity(), "Different type to AbstractAlarmCommentEntity");
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#getAlarmId()}.
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#getAlarmId()}
   */
  @Test
  @DisplayName("Test getAlarmId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID AbstractAlarmCommentEntity.getAlarmId()"})
  void testGetAlarmId() {
    // Arrange, Act and Assert
    assertNull(new AlarmCommentEntity().getAlarmId());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#getComment()}.
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#getComment()}
   */
  @Test
  @DisplayName("Test getComment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode AbstractAlarmCommentEntity.getComment()"})
  void testGetComment() {
    // Arrange, Act and Assert
    assertNull(new AlarmCommentEntity().getComment());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#getType()}.
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmCommentType AbstractAlarmCommentEntity.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertNull(new AlarmCommentEntity().getType());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#getUserId()}.
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#getUserId()}
   */
  @Test
  @DisplayName("Test getUserId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID AbstractAlarmCommentEntity.getUserId()"})
  void testGetUserId() {
    // Arrange, Act and Assert
    assertNull(new AlarmCommentEntity().getUserId());
  }

  /**
   * Test {@link AbstractAlarmCommentEntity#setAlarmId(UUID)}.
   *
   * <p>Method under test: {@link AbstractAlarmCommentEntity#setAlarmId(UUID)}
   */
  @Test
  @DisplayName("Test setAlarmId(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractAlarmCommentEntity.setAlarmId(UUID)"})
  void testSetAlarmId() {
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
  @DisplayName("Test setComment(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractAlarmCommentEntity.setComment(JsonNode)"})
  void testSetComment() {
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
  @DisplayName("Test setType(AlarmCommentType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractAlarmCommentEntity.setType(AlarmCommentType)"})
  void testSetType() {
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
  @DisplayName("Test setUserId(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractAlarmCommentEntity.setUserId(UUID)"})
  void testSetUserId() {
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
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AbstractAlarmCommentEntity.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("AlarmCommentEntity()", new AlarmCommentEntity().toString());
  }
}
