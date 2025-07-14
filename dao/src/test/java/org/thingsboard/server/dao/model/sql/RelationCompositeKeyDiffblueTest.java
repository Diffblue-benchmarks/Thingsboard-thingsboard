package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

class RelationCompositeKeyDiffblueTest {
  /**
   * Test {@link RelationCompositeKey#equals(Object)}, and {@link RelationCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCompositeKey#equals(Object)}
   *   <li>{@link RelationCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();
    RelationCompositeKey relationCompositeKey2 = new RelationCompositeKey();

    // Act and Assert
    assertEquals(relationCompositeKey, relationCompositeKey2);
    int expectedHashCodeResult = relationCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, relationCompositeKey2.hashCode());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}, and {@link RelationCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCompositeKey#equals(Object)}
   *   <li>{@link RelationCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UUID fromId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    RelationCompositeKey relationCompositeKey =
        new RelationCompositeKey(
            fromId,
            "jane.doe@example.org",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "To Type",
            "Relation Type",
            "Relation Type Group");
    UUID fromId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    RelationCompositeKey relationCompositeKey2 =
        new RelationCompositeKey(
            fromId2,
            "jane.doe@example.org",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "To Type",
            "Relation Type",
            "Relation Type Group");

    // Act and Assert
    assertEquals(relationCompositeKey, relationCompositeKey2);
    int expectedHashCodeResult = relationCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, relationCompositeKey2.hashCode());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}, and {@link RelationCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCompositeKey#equals(Object)}
   *   <li>{@link RelationCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();

    // Act and Assert
    assertEquals(relationCompositeKey, relationCompositeKey);
    int expectedHashCodeResult = relationCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, relationCompositeKey.hashCode());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID fromId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    RelationCompositeKey relationCompositeKey =
        new RelationCompositeKey(
            fromId,
            "jane.doe@example.org",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "To Type",
            "Relation Type",
            "Relation Type Group");

    // Act and Assert
    assertNotEquals(relationCompositeKey, new RelationCompositeKey());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();
    UUID fromId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(
        relationCompositeKey,
        new RelationCompositeKey(
            fromId,
            "jane.doe@example.org",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "To Type",
            "Relation Type",
            "Relation Type Group"));
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();
    relationCompositeKey.setFromType("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(relationCompositeKey, new RelationCompositeKey());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();
    relationCompositeKey.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(relationCompositeKey, new RelationCompositeKey());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();
    relationCompositeKey.setToType("To Type");

    // Act and Assert
    assertNotEquals(relationCompositeKey, new RelationCompositeKey());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();
    relationCompositeKey.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(relationCompositeKey, new RelationCompositeKey());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();
    relationCompositeKey.setRelationTypeGroup("Relation Type Group");

    // Act and Assert
    assertNotEquals(relationCompositeKey, new RelationCompositeKey());
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();

    RelationCompositeKey relationCompositeKey2 = new RelationCompositeKey();
    relationCompositeKey2.setFromType("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(relationCompositeKey, relationCompositeKey2);
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();

    RelationCompositeKey relationCompositeKey2 = new RelationCompositeKey();
    relationCompositeKey2.setToId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(relationCompositeKey, relationCompositeKey2);
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();

    RelationCompositeKey relationCompositeKey2 = new RelationCompositeKey();
    relationCompositeKey2.setToType("To Type");

    // Act and Assert
    assertNotEquals(relationCompositeKey, relationCompositeKey2);
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();

    RelationCompositeKey relationCompositeKey2 = new RelationCompositeKey();
    relationCompositeKey2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(relationCompositeKey, relationCompositeKey2);
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RelationCompositeKey relationCompositeKey = new RelationCompositeKey();

    RelationCompositeKey relationCompositeKey2 = new RelationCompositeKey();
    relationCompositeKey2.setRelationTypeGroup("Relation Type Group");

    // Act and Assert
    assertNotEquals(relationCompositeKey, relationCompositeKey2);
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelationCompositeKey(), null);
  }

  /**
   * Test {@link RelationCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RelationCompositeKey.equals(Object)",
    "int RelationCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelationCompositeKey(), "Different type to RelationCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCompositeKey#RelationCompositeKey()}
   *   <li>{@link RelationCompositeKey#setFromId(UUID)}
   *   <li>{@link RelationCompositeKey#setFromType(String)}
   *   <li>{@link RelationCompositeKey#setRelationType(String)}
   *   <li>{@link RelationCompositeKey#setRelationTypeGroup(String)}
   *   <li>{@link RelationCompositeKey#setToId(UUID)}
   *   <li>{@link RelationCompositeKey#setToType(String)}
   *   <li>{@link RelationCompositeKey#toString()}
   *   <li>{@link RelationCompositeKey#getFromId()}
   *   <li>{@link RelationCompositeKey#getFromType()}
   *   <li>{@link RelationCompositeKey#getRelationType()}
   *   <li>{@link RelationCompositeKey#getRelationTypeGroup()}
   *   <li>{@link RelationCompositeKey#getToId()}
   *   <li>{@link RelationCompositeKey#getToType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RelationCompositeKey.<init>()",
    "void RelationCompositeKey.<init>(UUID, String, UUID, String, String, String)",
    "UUID RelationCompositeKey.getFromId()",
    "String RelationCompositeKey.getFromType()",
    "String RelationCompositeKey.getRelationType()",
    "String RelationCompositeKey.getRelationTypeGroup()",
    "UUID RelationCompositeKey.getToId()",
    "String RelationCompositeKey.getToType()",
    "void RelationCompositeKey.setFromId(UUID)",
    "void RelationCompositeKey.setFromType(String)",
    "void RelationCompositeKey.setRelationType(String)",
    "void RelationCompositeKey.setRelationTypeGroup(String)",
    "void RelationCompositeKey.setToId(UUID)",
    "void RelationCompositeKey.setToType(String)",
    "String RelationCompositeKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RelationCompositeKey actualRelationCompositeKey = new RelationCompositeKey();
    UUID fromId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRelationCompositeKey.setFromId(fromId);
    actualRelationCompositeKey.setFromType("jane.doe@example.org");
    actualRelationCompositeKey.setRelationType("Relation Type");
    actualRelationCompositeKey.setRelationTypeGroup("Relation Type Group");
    UUID toId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRelationCompositeKey.setToId(toId);
    actualRelationCompositeKey.setToType("To Type");
    String actualToStringResult = actualRelationCompositeKey.toString();
    UUID actualFromId = actualRelationCompositeKey.getFromId();
    String actualFromType = actualRelationCompositeKey.getFromType();
    String actualRelationType = actualRelationCompositeKey.getRelationType();
    String actualRelationTypeGroup = actualRelationCompositeKey.getRelationTypeGroup();
    UUID actualToId = actualRelationCompositeKey.getToId();
    String actualToType = actualRelationCompositeKey.getToType();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualFromId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualToId.toString());
    assertEquals("Relation Type Group", actualRelationTypeGroup);
    assertEquals("Relation Type", actualRelationType);
    assertEquals(
        "RelationCompositeKey(fromId=784f394c-42b6-435a-983c-b7beff2784f9, fromType=jane.doe@example.org,"
            + " toId=784f394c-42b6-435a-983c-b7beff2784f9, toType=To Type, relationType=Relation Type, relationTypeGroup"
            + "=Relation Type Group)",
        actualToStringResult);
    assertEquals("To Type", actualToType);
    assertEquals("jane.doe@example.org", actualFromType);
    assertSame(fromId, actualFromId);
    assertSame(toId, actualToId);
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
   *   <li>{@link RelationCompositeKey#RelationCompositeKey(UUID, String, UUID, String, String,
   *       String)}
   *   <li>{@link RelationCompositeKey#setFromId(UUID)}
   *   <li>{@link RelationCompositeKey#setFromType(String)}
   *   <li>{@link RelationCompositeKey#setRelationType(String)}
   *   <li>{@link RelationCompositeKey#setRelationTypeGroup(String)}
   *   <li>{@link RelationCompositeKey#setToId(UUID)}
   *   <li>{@link RelationCompositeKey#setToType(String)}
   *   <li>{@link RelationCompositeKey#toString()}
   *   <li>{@link RelationCompositeKey#getFromId()}
   *   <li>{@link RelationCompositeKey#getFromType()}
   *   <li>{@link RelationCompositeKey#getRelationType()}
   *   <li>{@link RelationCompositeKey#getRelationTypeGroup()}
   *   <li>{@link RelationCompositeKey#getToId()}
   *   <li>{@link RelationCompositeKey#getToType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RelationCompositeKey.<init>()",
    "void RelationCompositeKey.<init>(UUID, String, UUID, String, String, String)",
    "UUID RelationCompositeKey.getFromId()",
    "String RelationCompositeKey.getFromType()",
    "String RelationCompositeKey.getRelationType()",
    "String RelationCompositeKey.getRelationTypeGroup()",
    "UUID RelationCompositeKey.getToId()",
    "String RelationCompositeKey.getToType()",
    "void RelationCompositeKey.setFromId(UUID)",
    "void RelationCompositeKey.setFromType(String)",
    "void RelationCompositeKey.setRelationType(String)",
    "void RelationCompositeKey.setRelationTypeGroup(String)",
    "void RelationCompositeKey.setToId(UUID)",
    "void RelationCompositeKey.setToType(String)",
    "String RelationCompositeKey.toString()"
  })
  void testGettersAndSetters_whenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    UUID fromId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    RelationCompositeKey actualRelationCompositeKey =
        new RelationCompositeKey(
            fromId,
            "jane.doe@example.org",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "To Type",
            "Relation Type",
            "Relation Type Group");
    UUID fromId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRelationCompositeKey.setFromId(fromId2);
    actualRelationCompositeKey.setFromType("jane.doe@example.org");
    actualRelationCompositeKey.setRelationType("Relation Type");
    actualRelationCompositeKey.setRelationTypeGroup("Relation Type Group");
    UUID toId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualRelationCompositeKey.setToId(toId);
    actualRelationCompositeKey.setToType("To Type");
    String actualToStringResult = actualRelationCompositeKey.toString();
    UUID actualFromId = actualRelationCompositeKey.getFromId();
    String actualFromType = actualRelationCompositeKey.getFromType();
    String actualRelationType = actualRelationCompositeKey.getRelationType();
    String actualRelationTypeGroup = actualRelationCompositeKey.getRelationTypeGroup();
    UUID actualToId = actualRelationCompositeKey.getToId();
    String actualToType = actualRelationCompositeKey.getToType();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualFromId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualToId.toString());
    assertEquals("Relation Type Group", actualRelationTypeGroup);
    assertEquals("Relation Type", actualRelationType);
    assertEquals(
        "RelationCompositeKey(fromId=784f394c-42b6-435a-983c-b7beff2784f9, fromType=jane.doe@example.org,"
            + " toId=784f394c-42b6-435a-983c-b7beff2784f9, toType=To Type, relationType=Relation Type, relationTypeGroup"
            + "=Relation Type Group)",
        actualToStringResult);
    assertEquals("To Type", actualToType);
    assertEquals("jane.doe@example.org", actualFromType);
    assertSame(fromId2, actualFromId);
    assertSame(toId, actualToId);
  }

  /**
   * Test {@link RelationCompositeKey#RelationCompositeKey(EntityRelation)}.
   *
   * <p>Method under test: {@link RelationCompositeKey#RelationCompositeKey(EntityRelation)}
   */
  @Test
  @DisplayName("Test new RelationCompositeKey(EntityRelation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RelationCompositeKey.<init>(EntityRelation)"})
  void testNewRelationCompositeKey() {
    // Arrange
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type");
    relation.setFrom(ModelConstants.SYSTEM_TENANT);

    // Act
    RelationCompositeKey actualRelationCompositeKey = new RelationCompositeKey(relation);

    // Assert
    UUID fromId = actualRelationCompositeKey.getFromId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", fromId.toString());
    assertEquals("COMMON", actualRelationCompositeKey.getRelationTypeGroup());
    assertEquals("CUSTOMER", actualRelationCompositeKey.getToType());
    assertEquals("TENANT", actualRelationCompositeKey.getFromType());
    assertEquals("Type", actualRelationCompositeKey.getRelationType());
    assertSame(fromId, actualRelationCompositeKey.getToId());
  }
}
