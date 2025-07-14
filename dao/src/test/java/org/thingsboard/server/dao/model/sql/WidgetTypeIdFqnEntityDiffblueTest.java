package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.dao.model.ModelConstants;

class WidgetTypeIdFqnEntityDiffblueTest {
  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}, and {@link
   * WidgetTypeIdFqnEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeIdFqnEntity#equals(Object)}
   *   <li>{@link WidgetTypeIdFqnEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity =
        new WidgetTypeIdFqnEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Fqn");
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity2 =
        new WidgetTypeIdFqnEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Fqn");

    // Act and Assert
    assertEquals(widgetTypeIdFqnEntity, widgetTypeIdFqnEntity2);
    int expectedHashCodeResult = widgetTypeIdFqnEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeIdFqnEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}, and {@link
   * WidgetTypeIdFqnEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeIdFqnEntity#equals(Object)}
   *   <li>{@link WidgetTypeIdFqnEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity = new WidgetTypeIdFqnEntity(null, "Fqn");
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity2 = new WidgetTypeIdFqnEntity(null, "Fqn");

    // Act and Assert
    assertEquals(widgetTypeIdFqnEntity, widgetTypeIdFqnEntity2);
    int expectedHashCodeResult = widgetTypeIdFqnEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeIdFqnEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}, and {@link
   * WidgetTypeIdFqnEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeIdFqnEntity#equals(Object)}
   *   <li>{@link WidgetTypeIdFqnEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity =
        new WidgetTypeIdFqnEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), null);
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity2 =
        new WidgetTypeIdFqnEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), null);

    // Act and Assert
    assertEquals(widgetTypeIdFqnEntity, widgetTypeIdFqnEntity2);
    int expectedHashCodeResult = widgetTypeIdFqnEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeIdFqnEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}, and {@link
   * WidgetTypeIdFqnEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeIdFqnEntity#equals(Object)}
   *   <li>{@link WidgetTypeIdFqnEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity =
        new WidgetTypeIdFqnEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Fqn");

    // Act and Assert
    assertEquals(widgetTypeIdFqnEntity, widgetTypeIdFqnEntity);
    int expectedHashCodeResult = widgetTypeIdFqnEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeIdFqnEntity.hashCode());
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeIdFqnEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity =
        new WidgetTypeIdFqnEntity(ModelConstants.NULL_UUID, "Fqn");

    // Act and Assert
    assertNotEquals(
        widgetTypeIdFqnEntity,
        new WidgetTypeIdFqnEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Fqn"));
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeIdFqnEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity = new WidgetTypeIdFqnEntity(null, "Fqn");

    // Act and Assert
    assertNotEquals(
        widgetTypeIdFqnEntity,
        new WidgetTypeIdFqnEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Fqn"));
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeIdFqnEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity =
        new WidgetTypeIdFqnEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), null);

    // Act and Assert
    assertNotEquals(
        widgetTypeIdFqnEntity,
        new WidgetTypeIdFqnEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Fqn"));
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeIdFqnEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetTypeIdFqnEntity widgetTypeIdFqnEntity =
        new WidgetTypeIdFqnEntity(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "org.thingsboard.server.dao.model.sql.WidgetTypeIdFqnEntity");

    // Act and Assert
    assertNotEquals(
        widgetTypeIdFqnEntity,
        new WidgetTypeIdFqnEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Fqn"));
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeIdFqnEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new WidgetTypeIdFqnEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Fqn"),
        null);
  }

  /**
   * Test {@link WidgetTypeIdFqnEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeIdFqnEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetTypeIdFqnEntity.equals(Object)",
    "int WidgetTypeIdFqnEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new WidgetTypeIdFqnEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Fqn"),
        "Different type to WidgetTypeIdFqnEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeIdFqnEntity#WidgetTypeIdFqnEntity(UUID, String)}
   *   <li>{@link WidgetTypeIdFqnEntity#setFqn(String)}
   *   <li>{@link WidgetTypeIdFqnEntity#setId(UUID)}
   *   <li>{@link WidgetTypeIdFqnEntity#toString()}
   *   <li>{@link WidgetTypeIdFqnEntity#getFqn()}
   *   <li>{@link WidgetTypeIdFqnEntity#getId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void WidgetTypeIdFqnEntity.<init>(UUID, String)",
    "String WidgetTypeIdFqnEntity.getFqn()",
    "UUID WidgetTypeIdFqnEntity.getId()",
    "void WidgetTypeIdFqnEntity.setFqn(String)",
    "void WidgetTypeIdFqnEntity.setId(UUID)",
    "String WidgetTypeIdFqnEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeIdFqnEntity actualWidgetTypeIdFqnEntity =
        new WidgetTypeIdFqnEntity(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Fqn");
    actualWidgetTypeIdFqnEntity.setFqn("Fqn");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualWidgetTypeIdFqnEntity.setId(id);
    String actualToStringResult = actualWidgetTypeIdFqnEntity.toString();
    String actualFqn = actualWidgetTypeIdFqnEntity.getFqn();
    UUID actualId = actualWidgetTypeIdFqnEntity.getId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualId.toString());
    assertEquals("Fqn", actualFqn);
    assertEquals(
        "WidgetTypeIdFqnEntity(id=784f394c-42b6-435a-983c-b7beff2784f9, fqn=Fqn)",
        actualToStringResult);
    assertSame(id, actualId);
  }
}
