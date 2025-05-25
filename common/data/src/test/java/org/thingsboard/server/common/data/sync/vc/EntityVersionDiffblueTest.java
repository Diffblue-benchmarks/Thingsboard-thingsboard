package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityVersionDiffblueTest {
  /**
   * Test {@link EntityVersion#equals(Object)}, and {@link EntityVersion#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityVersion#equals(Object)}
   *   <li>{@link EntityVersion#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersion.equals(Object)", "int EntityVersion.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityVersion entityVersion = new EntityVersion(10L, "42", "Name", "JaneDoe");
    EntityVersion entityVersion2 = new EntityVersion(10L, "42", "Name", "JaneDoe");

    // Act and Assert
    assertEquals(entityVersion, entityVersion2);
    int expectedHashCodeResult = entityVersion.hashCode();
    assertEquals(expectedHashCodeResult, entityVersion2.hashCode());
  }

  /**
   * Test {@link EntityVersion#equals(Object)}, and {@link EntityVersion#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityVersion#equals(Object)}
   *   <li>{@link EntityVersion#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersion.equals(Object)", "int EntityVersion.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityVersion entityVersion = new EntityVersion(10L, null, "Name", "JaneDoe");
    EntityVersion entityVersion2 = new EntityVersion(10L, null, "Name", "JaneDoe");

    // Act and Assert
    assertEquals(entityVersion, entityVersion2);
    int expectedHashCodeResult = entityVersion.hashCode();
    assertEquals(expectedHashCodeResult, entityVersion2.hashCode());
  }

  /**
   * Test {@link EntityVersion#equals(Object)}, and {@link EntityVersion#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityVersion#equals(Object)}
   *   <li>{@link EntityVersion#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersion.equals(Object)", "int EntityVersion.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityVersion entityVersion = new EntityVersion(10L, "42", null, "JaneDoe");
    EntityVersion entityVersion2 = new EntityVersion(10L, "42", null, "JaneDoe");

    // Act and Assert
    assertEquals(entityVersion, entityVersion2);
    int expectedHashCodeResult = entityVersion.hashCode();
    assertEquals(expectedHashCodeResult, entityVersion2.hashCode());
  }

  /**
   * Test {@link EntityVersion#equals(Object)}, and {@link EntityVersion#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityVersion#equals(Object)}
   *   <li>{@link EntityVersion#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersion.equals(Object)", "int EntityVersion.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityVersion entityVersion = new EntityVersion(10L, "42", "Name", null);
    EntityVersion entityVersion2 = new EntityVersion(10L, "42", "Name", null);

    // Act and Assert
    assertEquals(entityVersion, entityVersion2);
    int expectedHashCodeResult = entityVersion.hashCode();
    assertEquals(expectedHashCodeResult, entityVersion2.hashCode());
  }

  /**
   * Test {@link EntityVersion#equals(Object)}, and {@link EntityVersion#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityVersion#equals(Object)}
   *   <li>{@link EntityVersion#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersion.equals(Object)", "int EntityVersion.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityVersion entityVersion = new EntityVersion(10L, "42", "Name", "JaneDoe");

    // Act and Assert
    assertEquals(entityVersion, entityVersion);
    int expectedHashCodeResult = entityVersion.hashCode();
    assertEquals(expectedHashCodeResult, entityVersion.hashCode());
  }

  /**
   * Test {@link EntityVersion#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersion.equals(Object)", "int EntityVersion.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityVersion entityVersion = new EntityVersion(1L, "42", "Name", "JaneDoe");

    // Act and Assert
    assertNotEquals(entityVersion, new EntityVersion(10L, "42", "Name", "JaneDoe"));
  }

  /**
   * Test {@link EntityVersion#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersion.equals(Object)", "int EntityVersion.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityVersion entityVersion = new EntityVersion(10L, "Name", "Name", "JaneDoe");

    // Act and Assert
    assertNotEquals(entityVersion, new EntityVersion(10L, "42", "Name", "JaneDoe"));
  }

  /**
   * Test {@link EntityVersion#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersion.equals(Object)", "int EntityVersion.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityVersion entityVersion = new EntityVersion(10L, null, "Name", "JaneDoe");

    // Act and Assert
    assertNotEquals(entityVersion, new EntityVersion(10L, "42", "Name", "JaneDoe"));
  }

  /**
   * Test {@link EntityVersion#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersion.equals(Object)", "int EntityVersion.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityVersion entityVersion = new EntityVersion(10L, "42", "42", "JaneDoe");

    // Act and Assert
    assertNotEquals(entityVersion, new EntityVersion(10L, "42", "Name", "JaneDoe"));
  }

  /**
   * Test {@link EntityVersion#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersion.equals(Object)", "int EntityVersion.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityVersion entityVersion = new EntityVersion(10L, "42", null, "JaneDoe");

    // Act and Assert
    assertNotEquals(entityVersion, new EntityVersion(10L, "42", "Name", "JaneDoe"));
  }

  /**
   * Test {@link EntityVersion#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersion.equals(Object)", "int EntityVersion.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityVersion entityVersion = new EntityVersion(10L, "42", "Name", "42");

    // Act and Assert
    assertNotEquals(entityVersion, new EntityVersion(10L, "42", "Name", "JaneDoe"));
  }

  /**
   * Test {@link EntityVersion#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersion.equals(Object)", "int EntityVersion.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityVersion entityVersion = new EntityVersion(10L, "42", "Name", null);

    // Act and Assert
    assertNotEquals(entityVersion, new EntityVersion(10L, "42", "Name", "JaneDoe"));
  }

  /**
   * Test {@link EntityVersion#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersion.equals(Object)", "int EntityVersion.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityVersion(10L, "42", "Name", "JaneDoe"), null);
  }

  /**
   * Test {@link EntityVersion#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityVersion#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersion.equals(Object)", "int EntityVersion.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityVersion(10L, "42", "Name", "JaneDoe"), "Different type to EntityVersion");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityVersion#EntityVersion()}
   *   <li>{@link EntityVersion#setAuthor(String)}
   *   <li>{@link EntityVersion#setId(String)}
   *   <li>{@link EntityVersion#setName(String)}
   *   <li>{@link EntityVersion#setTimestamp(long)}
   *   <li>{@link EntityVersion#toString()}
   *   <li>{@link EntityVersion#getAuthor()}
   *   <li>{@link EntityVersion#getId()}
   *   <li>{@link EntityVersion#getName()}
   *   <li>{@link EntityVersion#getTimestamp()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityVersion.<init>()", "String EntityVersion.getAuthor()", "String EntityVersion.getId()",
      "String EntityVersion.getName()", "long EntityVersion.getTimestamp()", "void EntityVersion.setAuthor(String)",
      "void EntityVersion.setId(String)", "void EntityVersion.setName(String)", "void EntityVersion.setTimestamp(long)",
      "String EntityVersion.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EntityVersion actualEntityVersion = new EntityVersion();
    actualEntityVersion.setAuthor("JaneDoe");
    actualEntityVersion.setId("42");
    actualEntityVersion.setName("Name");
    actualEntityVersion.setTimestamp(10L);
    String actualToStringResult = actualEntityVersion.toString();
    String actualAuthor = actualEntityVersion.getAuthor();
    String actualId = actualEntityVersion.getId();
    String actualName = actualEntityVersion.getName();

    // Assert
    assertEquals("42", actualId);
    assertEquals("EntityVersion(timestamp=10, id=42, name=Name, author=JaneDoe)", actualToStringResult);
    assertEquals("JaneDoe", actualAuthor);
    assertEquals("Name", actualName);
    assertEquals(10L, actualEntityVersion.getTimestamp());
  }

  /**
   * Test {@link EntityVersion#EntityVersion(long, String, String, String)}.
   * <p>
   * Method under test: {@link EntityVersion#EntityVersion(long, String, String, String)}
   */
  @Test
  @DisplayName("Test new EntityVersion(long, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityVersion.<init>(long, String, String, String)"})
  void testNewEntityVersion() {
    // Arrange and Act
    EntityVersion actualEntityVersion = new EntityVersion(10L, "42", "Name", "JaneDoe");

    // Assert
    assertEquals("42", actualEntityVersion.getId());
    assertEquals("JaneDoe", actualEntityVersion.getAuthor());
    assertEquals("Name", actualEntityVersion.getName());
    assertEquals(10L, actualEntityVersion.getTimestamp());
  }
}
