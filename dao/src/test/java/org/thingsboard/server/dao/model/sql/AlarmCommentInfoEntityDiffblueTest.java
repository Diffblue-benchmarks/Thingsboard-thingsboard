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
import org.thingsboard.server.common.data.alarm.AlarmCommentInfo;
import org.thingsboard.server.common.data.alarm.AlarmCommentType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

class AlarmCommentInfoEntityDiffblueTest {
  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}, and {@link
   * AlarmCommentInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentInfoEntity#equals(Object)}
   *   <li>{@link AlarmCommentInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentInfoEntity.equals(Object)",
    "int AlarmCommentInfoEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();
    AlarmCommentInfoEntity alarmCommentInfoEntity2 = new AlarmCommentInfoEntity();

    // Act and Assert
    assertEquals(alarmCommentInfoEntity, alarmCommentInfoEntity2);
    assertEquals(alarmCommentInfoEntity.hashCode(), alarmCommentInfoEntity2.hashCode());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}, and {@link
   * AlarmCommentInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentInfoEntity#equals(Object)}
   *   <li>{@link AlarmCommentInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentInfoEntity.equals(Object)",
    "int AlarmCommentInfoEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmCommentInfoEntity alarmCommentInfoEntity =
        new AlarmCommentInfoEntity(alarmCommentEntity, "Jane", "Doe", "jane.doe@example.org");

    AlarmCommentEntity alarmCommentEntity2 = new AlarmCommentEntity();
    alarmCommentEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity2.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity2.setCreatedTime(1L);
    alarmCommentEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity2.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmCommentInfoEntity alarmCommentInfoEntity2 =
        new AlarmCommentInfoEntity(alarmCommentEntity2, "Jane", "Doe", "jane.doe@example.org");

    // Act and Assert
    assertEquals(alarmCommentInfoEntity, alarmCommentInfoEntity2);
    assertEquals(alarmCommentInfoEntity.hashCode(), alarmCommentInfoEntity2.hashCode());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}, and {@link
   * AlarmCommentInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentInfoEntity#equals(Object)}
   *   <li>{@link AlarmCommentInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentInfoEntity.equals(Object)",
    "int AlarmCommentInfoEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();

    // Act and Assert
    assertEquals(alarmCommentInfoEntity, alarmCommentInfoEntity);
    int expectedHashCodeResult = alarmCommentInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfoEntity.hashCode());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentInfoEntity.equals(Object)",
    "int AlarmCommentInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity(alarmCommentEntity);

    // Act and Assert
    assertNotEquals(alarmCommentInfoEntity, new AlarmCommentInfoEntity());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentInfoEntity.equals(Object)",
    "int AlarmCommentInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();
    alarmCommentInfoEntity.setFirstName("Jane");

    // Act and Assert
    assertNotEquals(alarmCommentInfoEntity, new AlarmCommentInfoEntity());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentInfoEntity.equals(Object)",
    "int AlarmCommentInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();
    alarmCommentInfoEntity.setLastName("Doe");

    // Act and Assert
    assertNotEquals(alarmCommentInfoEntity, new AlarmCommentInfoEntity());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentInfoEntity.equals(Object)",
    "int AlarmCommentInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();
    alarmCommentInfoEntity.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(alarmCommentInfoEntity, new AlarmCommentInfoEntity());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentInfoEntity.equals(Object)",
    "int AlarmCommentInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity(alarmCommentEntity);

    AlarmCommentEntity alarmCommentEntity2 = new AlarmCommentEntity();
    alarmCommentEntity2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity2.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity2.setCreatedTime(1L);
    alarmCommentEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity2.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        alarmCommentInfoEntity,
        new AlarmCommentInfoEntity(alarmCommentEntity2, "Jane", "Doe", "jane.doe@example.org"));
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentInfoEntity.equals(Object)",
    "int AlarmCommentInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();

    AlarmCommentInfoEntity alarmCommentInfoEntity2 = new AlarmCommentInfoEntity();
    alarmCommentInfoEntity2.setLastName("Doe");

    // Act and Assert
    assertNotEquals(alarmCommentInfoEntity, alarmCommentInfoEntity2);
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentInfoEntity.equals(Object)",
    "int AlarmCommentInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();

    AlarmCommentInfoEntity alarmCommentInfoEntity2 = new AlarmCommentInfoEntity();
    alarmCommentInfoEntity2.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(alarmCommentInfoEntity, alarmCommentInfoEntity2);
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentInfoEntity.equals(Object)",
    "int AlarmCommentInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentInfoEntity(), null);
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmCommentInfoEntity.equals(Object)",
    "int AlarmCommentInfoEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentInfoEntity(), "Different type to AlarmCommentInfoEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentInfoEntity#AlarmCommentInfoEntity()}
   *   <li>{@link AlarmCommentInfoEntity#setEmail(String)}
   *   <li>{@link AlarmCommentInfoEntity#setFirstName(String)}
   *   <li>{@link AlarmCommentInfoEntity#setLastName(String)}
   *   <li>{@link AlarmCommentInfoEntity#toString()}
   *   <li>{@link AlarmCommentInfoEntity#getEmail()}
   *   <li>{@link AlarmCommentInfoEntity#getFirstName()}
   *   <li>{@link AlarmCommentInfoEntity#getLastName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmCommentInfoEntity.<init>()",
    "String AlarmCommentInfoEntity.getEmail()",
    "String AlarmCommentInfoEntity.getFirstName()",
    "String AlarmCommentInfoEntity.getLastName()",
    "void AlarmCommentInfoEntity.setEmail(String)",
    "void AlarmCommentInfoEntity.setFirstName(String)",
    "void AlarmCommentInfoEntity.setLastName(String)",
    "String AlarmCommentInfoEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmCommentInfoEntity actualAlarmCommentInfoEntity = new AlarmCommentInfoEntity();
    actualAlarmCommentInfoEntity.setEmail("jane.doe@example.org");
    actualAlarmCommentInfoEntity.setFirstName("Jane");
    actualAlarmCommentInfoEntity.setLastName("Doe");
    String actualToStringResult = actualAlarmCommentInfoEntity.toString();
    String actualEmail = actualAlarmCommentInfoEntity.getEmail();
    String actualFirstName = actualAlarmCommentInfoEntity.getFirstName();

    // Assert
    assertEquals(
        "AlarmCommentInfoEntity(firstName=Jane, lastName=Doe, email=jane.doe@example.org)",
        actualToStringResult);
    assertEquals("Doe", actualAlarmCommentInfoEntity.getLastName());
    assertEquals("Jane", actualFirstName);
    assertEquals("jane.doe@example.org", actualEmail);
    assertNull(actualAlarmCommentInfoEntity.getComment());
    assertNull(actualAlarmCommentInfoEntity.getId());
    assertNull(actualAlarmCommentInfoEntity.getUuid());
    assertNull(actualAlarmCommentInfoEntity.getAlarmId());
    assertNull(actualAlarmCommentInfoEntity.getUserId());
    assertNull(actualAlarmCommentInfoEntity.getType());
    assertEquals(0L, actualAlarmCommentInfoEntity.getCreatedTime());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity)}
   */
  @Test
  @DisplayName(
      "Test new AlarmCommentInfoEntity(AlarmCommentEntity); given one; then return CreatedTime is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmCommentInfoEntity.<init>(AlarmCommentEntity)"})
  void testNewAlarmCommentInfoEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    UUID alarmId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmCommentEntity.setAlarmId(alarmId);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmCommentEntity.setUserId(userId);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmCommentEntity.setUuid(id);

    // Act
    AlarmCommentInfoEntity actualAlarmCommentInfoEntity =
        new AlarmCommentInfoEntity(alarmCommentEntity);

    // Assert
    assertTrue(actualAlarmCommentInfoEntity.getComment() instanceof ObjectNode);
    assertNull(actualAlarmCommentInfoEntity.getEmail());
    assertNull(actualAlarmCommentInfoEntity.getFirstName());
    assertNull(actualAlarmCommentInfoEntity.getLastName());
    assertEquals(1L, actualAlarmCommentInfoEntity.getCreatedTime());
    assertEquals(AlarmCommentType.SYSTEM, actualAlarmCommentInfoEntity.getType());
    assertSame(id, actualAlarmCommentInfoEntity.getId());
    assertSame(id, actualAlarmCommentInfoEntity.getUuid());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getAlarmId());
    assertSame(userId, actualAlarmCommentInfoEntity.getUserId());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new AlarmCommentInfoEntity(AlarmCommentEntity, String, String, String); given one; then return CreatedTime is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmCommentInfoEntity.<init>(AlarmCommentEntity, String, String, String)"
  })
  void testNewAlarmCommentInfoEntity_givenOne_thenReturnCreatedTimeIsOne2() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    UUID alarmId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmCommentEntity.setAlarmId(alarmId);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmCommentEntity.setUserId(userId);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmCommentEntity.setUuid(id);

    // Act
    AlarmCommentInfoEntity actualAlarmCommentInfoEntity =
        new AlarmCommentInfoEntity(alarmCommentEntity, "Jane", "Doe", "jane.doe@example.org");

    // Assert
    assertTrue(actualAlarmCommentInfoEntity.getComment() instanceof ObjectNode);
    assertEquals("Doe", actualAlarmCommentInfoEntity.getLastName());
    assertEquals("Jane", actualAlarmCommentInfoEntity.getFirstName());
    assertEquals("jane.doe@example.org", actualAlarmCommentInfoEntity.getEmail());
    assertEquals(1L, actualAlarmCommentInfoEntity.getCreatedTime());
    assertEquals(AlarmCommentType.SYSTEM, actualAlarmCommentInfoEntity.getType());
    assertSame(id, actualAlarmCommentInfoEntity.getId());
    assertSame(id, actualAlarmCommentInfoEntity.getUuid());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getAlarmId());
    assertSame(userId, actualAlarmCommentInfoEntity.getUserId());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then return CreatedTime is zero.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity)}
   */
  @Test
  @DisplayName(
      "Test new AlarmCommentInfoEntity(AlarmCommentEntity); given zero; then return CreatedTime is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmCommentInfoEntity.<init>(AlarmCommentEntity)"})
  void testNewAlarmCommentInfoEntity_givenZero_thenReturnCreatedTimeIsZero() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    UUID alarmId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmCommentEntity.setAlarmId(alarmId);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(0L);
    alarmCommentEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmCommentEntity.setUserId(userId);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmCommentEntity.setUuid(id);

    // Act
    AlarmCommentInfoEntity actualAlarmCommentInfoEntity =
        new AlarmCommentInfoEntity(alarmCommentEntity);

    // Assert
    assertTrue(actualAlarmCommentInfoEntity.getComment() instanceof ObjectNode);
    assertNull(actualAlarmCommentInfoEntity.getEmail());
    assertNull(actualAlarmCommentInfoEntity.getFirstName());
    assertNull(actualAlarmCommentInfoEntity.getLastName());
    assertEquals(0L, actualAlarmCommentInfoEntity.getCreatedTime());
    assertEquals(AlarmCommentType.SYSTEM, actualAlarmCommentInfoEntity.getType());
    assertSame(id, actualAlarmCommentInfoEntity.getId());
    assertSame(id, actualAlarmCommentInfoEntity.getUuid());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getAlarmId());
    assertSame(userId, actualAlarmCommentInfoEntity.getUserId());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity, String, String,
   * String)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then return CreatedTime is zero.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity(AlarmCommentEntity,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test new AlarmCommentInfoEntity(AlarmCommentEntity, String, String, String); given zero; then return CreatedTime is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmCommentInfoEntity.<init>(AlarmCommentEntity, String, String, String)"
  })
  void testNewAlarmCommentInfoEntity_givenZero_thenReturnCreatedTimeIsZero2() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    UUID alarmId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmCommentEntity.setAlarmId(alarmId);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(0L);
    alarmCommentEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmCommentEntity.setUserId(userId);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmCommentEntity.setUuid(id);

    // Act
    AlarmCommentInfoEntity actualAlarmCommentInfoEntity =
        new AlarmCommentInfoEntity(alarmCommentEntity, "Jane", "Doe", "jane.doe@example.org");

    // Assert
    assertTrue(actualAlarmCommentInfoEntity.getComment() instanceof ObjectNode);
    assertEquals("Doe", actualAlarmCommentInfoEntity.getLastName());
    assertEquals("Jane", actualAlarmCommentInfoEntity.getFirstName());
    assertEquals("jane.doe@example.org", actualAlarmCommentInfoEntity.getEmail());
    assertEquals(0L, actualAlarmCommentInfoEntity.getCreatedTime());
    assertEquals(AlarmCommentType.SYSTEM, actualAlarmCommentInfoEntity.getType());
    assertSame(id, actualAlarmCommentInfoEntity.getId());
    assertSame(id, actualAlarmCommentInfoEntity.getUuid());
    assertSame(alarmId, actualAlarmCommentInfoEntity.getAlarmId());
    assertSame(userId, actualAlarmCommentInfoEntity.getUserId());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmCommentInfoEntity#AlarmCommentInfoEntity()}.
   *   <li>Then return Comment is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given AlarmCommentInfoEntity(); then return Comment is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmCommentInfo AlarmCommentInfoEntity.toData()"})
  void testToData_givenAlarmCommentInfoEntity_thenReturnCommentIsNull() {
    // Arrange and Act
    AlarmCommentInfo actualToDataResult = new AlarmCommentInfoEntity().toData();

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
   * Test {@link AlarmCommentInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Comment return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfoEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Comment return ObjectNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmCommentInfo AlarmCommentInfoEntity.toData()"})
  void testToData_thenCommentReturnObjectNode() {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmCommentEntity.setUuid(id);

    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity(alarmCommentEntity);
    alarmCommentInfoEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AlarmCommentInfo actualToDataResult = alarmCommentInfoEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getComment() instanceof ObjectNode);
    assertEquals("{\"isPublic\":true}", actualToDataResult.getName());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(AlarmCommentType.SYSTEM, actualToDataResult.getType());
    assertSame(id, actualToDataResult.getUuidId());
  }
}
