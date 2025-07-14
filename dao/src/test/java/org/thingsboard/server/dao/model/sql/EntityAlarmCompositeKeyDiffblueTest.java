package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityAlarmCompositeKeyDiffblueTest {
  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}, and {@link
   * EntityAlarmCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmCompositeKey#equals(Object)}
   *   <li>{@link EntityAlarmCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey();
    EntityAlarmCompositeKey entityAlarmCompositeKey2 = new EntityAlarmCompositeKey();

    // Act and Assert
    assertEquals(entityAlarmCompositeKey, entityAlarmCompositeKey2);
    int expectedHashCodeResult = entityAlarmCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmCompositeKey2.hashCode());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}, and {@link
   * EntityAlarmCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmCompositeKey#equals(Object)}
   *   <li>{@link EntityAlarmCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntityAlarmCompositeKey entityAlarmCompositeKey =
        new EntityAlarmCompositeKey(
            entityId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID entityId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntityAlarmCompositeKey entityAlarmCompositeKey2 =
        new EntityAlarmCompositeKey(
            entityId2, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(entityAlarmCompositeKey, entityAlarmCompositeKey2);
    int expectedHashCodeResult = entityAlarmCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmCompositeKey2.hashCode());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}, and {@link
   * EntityAlarmCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityAlarmCompositeKey#equals(Object)}
   *   <li>{@link EntityAlarmCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey();

    // Act and Assert
    assertEquals(entityAlarmCompositeKey, entityAlarmCompositeKey);
    int expectedHashCodeResult = entityAlarmCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarmCompositeKey.hashCode());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntityAlarmCompositeKey entityAlarmCompositeKey =
        new EntityAlarmCompositeKey(
            entityId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmCompositeKey, new EntityAlarmCompositeKey());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(
        entityAlarmCompositeKey,
        new EntityAlarmCompositeKey(
            entityId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey();
    entityAlarmCompositeKey.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmCompositeKey, new EntityAlarmCompositeKey());
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityAlarmCompositeKey entityAlarmCompositeKey = new EntityAlarmCompositeKey();

    EntityAlarmCompositeKey entityAlarmCompositeKey2 = new EntityAlarmCompositeKey();
    entityAlarmCompositeKey2.setAlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(entityAlarmCompositeKey, entityAlarmCompositeKey2);
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityAlarmCompositeKey(), null);
  }

  /**
   * Test {@link EntityAlarmCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityAlarmCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityAlarmCompositeKey.equals(Object)",
    "int EntityAlarmCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityAlarmCompositeKey(), "Different type to EntityAlarmCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntityAlarmCompositeKey.<init>()",
    "void EntityAlarmCompositeKey.<init>(UUID, UUID)",
    "UUID EntityAlarmCompositeKey.getAlarmId()",
    "UUID EntityAlarmCompositeKey.getEntityId()",
    "void EntityAlarmCompositeKey.setAlarmId(UUID)",
    "void EntityAlarmCompositeKey.setEntityId(UUID)",
    "String EntityAlarmCompositeKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityAlarmCompositeKey actualEntityAlarmCompositeKey = new EntityAlarmCompositeKey();
    UUID alarmId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualEntityAlarmCompositeKey.setAlarmId(alarmId);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualEntityAlarmCompositeKey.setEntityId(entityId);
    String actualToStringResult = actualEntityAlarmCompositeKey.toString();
    UUID actualAlarmId = actualEntityAlarmCompositeKey.getAlarmId();
    UUID actualEntityId = actualEntityAlarmCompositeKey.getEntityId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualAlarmId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals(
        "EntityAlarmCompositeKey(entityId=784f394c-42b6-435a-983c-b7beff2784f9, alarmId=784f394c-42b6-435a-983c"
            + "-b7beff2784f9)",
        actualToStringResult);
    assertSame(alarmId, actualAlarmId);
    assertSame(entityId, actualEntityId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters; when fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntityAlarmCompositeKey.<init>()",
    "void EntityAlarmCompositeKey.<init>(UUID, UUID)",
    "UUID EntityAlarmCompositeKey.getAlarmId()",
    "UUID EntityAlarmCompositeKey.getEntityId()",
    "void EntityAlarmCompositeKey.setAlarmId(UUID)",
    "void EntityAlarmCompositeKey.setEntityId(UUID)",
    "String EntityAlarmCompositeKey.toString()"
  })
  void testGettersAndSetters_whenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    EntityAlarmCompositeKey actualEntityAlarmCompositeKey =
        new EntityAlarmCompositeKey(
            entityId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID alarmId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualEntityAlarmCompositeKey.setAlarmId(alarmId);
    UUID entityId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualEntityAlarmCompositeKey.setEntityId(entityId2);
    String actualToStringResult = actualEntityAlarmCompositeKey.toString();
    UUID actualAlarmId = actualEntityAlarmCompositeKey.getAlarmId();
    UUID actualEntityId = actualEntityAlarmCompositeKey.getEntityId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualAlarmId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals(
        "EntityAlarmCompositeKey(entityId=784f394c-42b6-435a-983c-b7beff2784f9, alarmId=784f394c-42b6-435a-983c"
            + "-b7beff2784f9)",
        actualToStringResult);
    assertSame(alarmId, actualAlarmId);
    assertSame(entityId2, actualEntityId);
  }
}
