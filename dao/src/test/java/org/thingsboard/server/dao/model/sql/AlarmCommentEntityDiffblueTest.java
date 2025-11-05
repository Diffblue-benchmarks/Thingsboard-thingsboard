package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.alarm.AlarmCommentType;
import org.thingsboard.server.common.data.id.AlarmCommentId;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

class AlarmCommentEntityDiffblueTest {
  /**
   * Test {@link AlarmCommentEntity#equals(Object)}, and {@link AlarmCommentEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentEntity#equals(Object)}
   *   <li>{@link AlarmCommentEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentEntity.equals(Object)",
    "int AlarmCommentEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmCommentEntity alarmCommentEntity2 = new AlarmCommentEntity();
    alarmCommentEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity2.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity2.setCreatedTime(1L);
    alarmCommentEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity2.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(alarmCommentEntity, alarmCommentEntity2);
    assertEquals(alarmCommentEntity.hashCode(), alarmCommentEntity2.hashCode());
  }

  /**
   * Test {@link AlarmCommentEntity#equals(Object)}, and {@link AlarmCommentEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentEntity#equals(Object)}
   *   <li>{@link AlarmCommentEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentEntity.equals(Object)",
    "int AlarmCommentEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(alarmCommentEntity, alarmCommentEntity);
    int expectedHashCodeResult = alarmCommentEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentEntity.hashCode());
  }

  /**
   * Test {@link AlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentEntity.equals(Object)",
    "int AlarmCommentEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmCommentEntity alarmCommentEntity2 = new AlarmCommentEntity();
    alarmCommentEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity2.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity2.setCreatedTime(1L);
    alarmCommentEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity2.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmCommentEntity, alarmCommentEntity2);
  }

  /**
   * Test {@link AlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentEntity.equals(Object)",
    "int AlarmCommentEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmCommentEntity, null);
  }

  /**
   * Test {@link AlarmCommentEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentEntity.equals(Object)",
    "int AlarmCommentEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmCommentEntity, "Different type to AlarmCommentEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentEntity#AlarmCommentEntity()}
   *   <li>{@link AlarmCommentEntity#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmCommentEntity.<init>()",
    "java.lang.String AlarmCommentEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity();

    // Assert
    assertEquals("AlarmCommentEntity()", actualAlarmCommentEntity.toString());
    assertNull(actualAlarmCommentEntity.getComment());
    assertNull(actualAlarmCommentEntity.getId());
    assertNull(actualAlarmCommentEntity.getUuid());
    assertNull(actualAlarmCommentEntity.getAlarmId());
    assertNull(actualAlarmCommentEntity.getUserId());
    assertNull(actualAlarmCommentEntity.getType());
    assertEquals(0L, actualAlarmCommentEntity.getCreatedTime());
  }

  /**
   * Test {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}.
   *
   * <p>Method under test: {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}
   */
  @Test
  @DisplayName("Test new AlarmCommentEntity(AlarmComment)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmCommentEntity.<init>(AlarmComment)"})
  void testNewAlarmCommentEntity() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment((AlarmCommentId) null);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UserId userId = new UserId(id);
    alarmComment.setUserId(userId);
    alarmComment.setType(AlarmCommentType.SYSTEM);
    alarmComment.setAlarmId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity(alarmComment);

    // Assert
    UUID userId2 = actualAlarmCommentEntity.getUserId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", userId2.toString());
    assertEquals(userId, actualAlarmCommentEntity.toData().getUserId());
    assertSame(id, userId2);
  }

  /**
   * Test {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}
   */
  @Test
  @DisplayName(
      "Test new AlarmCommentEntity(AlarmComment); given one; then return CreatedTime is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmCommentEntity.<init>(AlarmComment)"})
  void testNewAlarmCommentEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setCreatedTime(1L);
    alarmComment.setAlarmId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity(alarmComment);

    // Assert
    assertNull(actualAlarmCommentEntity.getType());
    assertEquals(1L, actualAlarmCommentEntity.getCreatedTime());
    assertEquals(alarmComment, actualAlarmCommentEntity.toData());
  }

  /**
   * Test {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}
   */
  @Test
  @DisplayName(
      "Test new AlarmCommentEntity(AlarmComment); then return Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmCommentEntity.<init>(AlarmComment)"})
  void testNewAlarmCommentEntity_thenReturnIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AlarmCommentId id2 = new AlarmCommentId(id);

    AlarmComment alarmComment = new AlarmComment(id2);
    alarmComment.setUserId(null);
    alarmComment.setType(AlarmCommentType.SYSTEM);
    alarmComment.setAlarmId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity(alarmComment);

    // Assert
    UUID id3 = actualAlarmCommentEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id3.toString());
    assertEquals(alarmComment, actualAlarmCommentEntity.toData());
    assertSame(id, id3);
    assertSame(id, actualAlarmCommentEntity.getUuid());
  }

  /**
   * Test {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}.
   *
   * <ul>
   *   <li>Then return Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}
   */
  @Test
  @DisplayName("Test new AlarmCommentEntity(AlarmComment); then return Type is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmCommentEntity.<init>(AlarmComment)"})
  void testNewAlarmCommentEntity_thenReturnTypeIsNull() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment();
    alarmComment.setAlarmId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity(alarmComment);

    // Assert
    assertNull(actualAlarmCommentEntity.getType());
    assertEquals(alarmComment, actualAlarmCommentEntity.toData());
  }

  /**
   * Test {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}.
   *
   * <ul>
   *   <li>Then return Type is {@code SYSTEM}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#AlarmCommentEntity(AlarmComment)}
   */
  @Test
  @DisplayName("Test new AlarmCommentEntity(AlarmComment); then return Type is 'SYSTEM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmCommentEntity.<init>(AlarmComment)"})
  void testNewAlarmCommentEntity_thenReturnTypeIsSystem() {
    // Arrange
    AlarmComment alarmComment = new AlarmComment((AlarmCommentId) null);
    alarmComment.setUserId(null);
    alarmComment.setType(AlarmCommentType.SYSTEM);
    alarmComment.setAlarmId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity(alarmComment);

    // Assert
    assertEquals(AlarmCommentType.SYSTEM, actualAlarmCommentEntity.getType());
    assertEquals(alarmComment, actualAlarmCommentEntity.toData());
  }

  /**
   * Test {@link AlarmCommentEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmCommentEntity#AlarmCommentEntity()}.
   *   <li>Then return Comment is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given AlarmCommentEntity(); then return Comment is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmComment AlarmCommentEntity.toData()"})
  void testToData_givenAlarmCommentEntity_thenReturnCommentIsNull() {
    // Arrange and Act
    AlarmComment actualToDataResult = new AlarmCommentEntity().toData();

    // Assert
    assertNull(actualToDataResult.getComment());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getAlarmId().getId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getUserId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link AlarmCommentEntity#toData()}.
   *
   * <ul>
   *   <li>Then Comment return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Comment return ObjectNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmComment AlarmCommentEntity.toData()"})
  void testToData_thenCommentReturnObjectNode() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmCommentEntity.setUuid(id);
    alarmCommentEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AlarmComment actualToDataResult = alarmCommentEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getComment() instanceof ObjectNode);
    assertEquals("{\"isPublic\":true}", actualToDataResult.getName());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(AlarmCommentType.SYSTEM, actualToDataResult.getType());
    assertSame(id, actualToDataResult.getUuidId());
  }
}
