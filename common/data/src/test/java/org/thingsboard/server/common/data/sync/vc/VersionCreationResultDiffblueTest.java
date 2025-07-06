package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VersionCreationResultDiffblueTest {
  /**
   * Test {@link VersionCreationResult#equals(Object)}, and {@link
   * VersionCreationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionCreationResult#equals(Object)}
   *   <li>{@link VersionCreationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreationResult.equals(Object)",
    "int VersionCreationResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VersionCreationResult versionCreationResult = new VersionCreationResult("An error occurred");
    VersionCreationResult versionCreationResult2 = new VersionCreationResult("An error occurred");

    // Act and Assert
    assertEquals(versionCreationResult, versionCreationResult2);
    int expectedHashCodeResult = versionCreationResult.hashCode();
    assertEquals(expectedHashCodeResult, versionCreationResult2.hashCode());
  }

  /**
   * Test {@link VersionCreationResult#equals(Object)}, and {@link
   * VersionCreationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionCreationResult#equals(Object)}
   *   <li>{@link VersionCreationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreationResult.equals(Object)",
    "int VersionCreationResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    VersionCreationResult versionCreationResult = new VersionCreationResult(null);
    VersionCreationResult versionCreationResult2 = new VersionCreationResult(null);

    // Act and Assert
    assertEquals(versionCreationResult, versionCreationResult2);
    int expectedHashCodeResult = versionCreationResult.hashCode();
    assertEquals(expectedHashCodeResult, versionCreationResult2.hashCode());
  }

  /**
   * Test {@link VersionCreationResult#equals(Object)}, and {@link
   * VersionCreationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionCreationResult#equals(Object)}
   *   <li>{@link VersionCreationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreationResult.equals(Object)",
    "int VersionCreationResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    VersionCreationResult versionCreationResult =
        new VersionCreationResult(
            new EntityVersion(10L, "42", "An error occurred", "JaneDoe"), 1, 1, 1);
    VersionCreationResult versionCreationResult2 =
        new VersionCreationResult(
            new EntityVersion(10L, "42", "An error occurred", "JaneDoe"), 1, 1, 1);

    // Act and Assert
    assertEquals(versionCreationResult, versionCreationResult2);
    int expectedHashCodeResult = versionCreationResult.hashCode();
    assertEquals(expectedHashCodeResult, versionCreationResult2.hashCode());
  }

  /**
   * Test {@link VersionCreationResult#equals(Object)}, and {@link
   * VersionCreationResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionCreationResult#equals(Object)}
   *   <li>{@link VersionCreationResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreationResult.equals(Object)",
    "int VersionCreationResult.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VersionCreationResult versionCreationResult = new VersionCreationResult("An error occurred");

    // Act and Assert
    assertEquals(versionCreationResult, versionCreationResult);
    int expectedHashCodeResult = versionCreationResult.hashCode();
    assertEquals(expectedHashCodeResult, versionCreationResult.hashCode());
  }

  /**
   * Test {@link VersionCreationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreationResult.equals(Object)",
    "int VersionCreationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    VersionCreationResult versionCreationResult = new VersionCreationResult("Error");

    // Act and Assert
    assertNotEquals(versionCreationResult, new VersionCreationResult("An error occurred"));
  }

  /**
   * Test {@link VersionCreationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreationResult.equals(Object)",
    "int VersionCreationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    VersionCreationResult versionCreationResult = new VersionCreationResult(null);

    // Act and Assert
    assertNotEquals(versionCreationResult, new VersionCreationResult("An error occurred"));
  }

  /**
   * Test {@link VersionCreationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreationResult.equals(Object)",
    "int VersionCreationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    VersionCreationResult versionCreationResult = new VersionCreationResult();

    // Act and Assert
    assertNotEquals(versionCreationResult, new VersionCreationResult("An error occurred"));
  }

  /**
   * Test {@link VersionCreationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreationResult.equals(Object)",
    "int VersionCreationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    VersionCreationResult versionCreationResult =
        new VersionCreationResult(
            new EntityVersion(10L, "42", "An error occurred", "JaneDoe"), 1, 1, 1);

    // Act and Assert
    assertNotEquals(versionCreationResult, new VersionCreationResult("An error occurred"));
  }

  /**
   * Test {@link VersionCreationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreationResult.equals(Object)",
    "int VersionCreationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    VersionCreationResult versionCreationResult = new VersionCreationResult("An error occurred");
    versionCreationResult.setVersion(new EntityVersion(10L, "42", "An error occurred", "JaneDoe"));

    // Act and Assert
    assertNotEquals(versionCreationResult, new VersionCreationResult("An error occurred"));
  }

  /**
   * Test {@link VersionCreationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreationResult.equals(Object)",
    "int VersionCreationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    VersionCreationResult versionCreationResult = new VersionCreationResult("An error occurred");
    versionCreationResult.setModified(1);

    // Act and Assert
    assertNotEquals(versionCreationResult, new VersionCreationResult("An error occurred"));
  }

  /**
   * Test {@link VersionCreationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreationResult.equals(Object)",
    "int VersionCreationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    VersionCreationResult versionCreationResult = new VersionCreationResult("An error occurred");
    versionCreationResult.setRemoved(1);

    // Act and Assert
    assertNotEquals(versionCreationResult, new VersionCreationResult("An error occurred"));
  }

  /**
   * Test {@link VersionCreationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreationResult.equals(Object)",
    "int VersionCreationResult.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    VersionCreationResult versionCreationResult = new VersionCreationResult("An error occurred");

    VersionCreationResult versionCreationResult2 = new VersionCreationResult("An error occurred");
    versionCreationResult2.setVersion(new EntityVersion(10L, "42", "An error occurred", "JaneDoe"));

    // Act and Assert
    assertNotEquals(versionCreationResult, versionCreationResult2);
  }

  /**
   * Test {@link VersionCreationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreationResult.equals(Object)",
    "int VersionCreationResult.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new VersionCreationResult("An error occurred"), null);
  }

  /**
   * Test {@link VersionCreationResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionCreationResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionCreationResult.equals(Object)",
    "int VersionCreationResult.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new VersionCreationResult("An error occurred"), "Different type to VersionCreationResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionCreationResult#VersionCreationResult()}
   *   <li>{@link VersionCreationResult#setAdded(int)}
   *   <li>{@link VersionCreationResult#setDone(boolean)}
   *   <li>{@link VersionCreationResult#setError(String)}
   *   <li>{@link VersionCreationResult#setModified(int)}
   *   <li>{@link VersionCreationResult#setRemoved(int)}
   *   <li>{@link VersionCreationResult#setVersion(EntityVersion)}
   *   <li>{@link VersionCreationResult#toString()}
   *   <li>{@link VersionCreationResult#getAdded()}
   *   <li>{@link VersionCreationResult#getError()}
   *   <li>{@link VersionCreationResult#getModified()}
   *   <li>{@link VersionCreationResult#getRemoved()}
   *   <li>{@link VersionCreationResult#getVersion()}
   *   <li>{@link VersionCreationResult#isDone()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void VersionCreationResult.<init>()",
    "void VersionCreationResult.<init>(String)",
    "void VersionCreationResult.<init>(EntityVersion, int, int, int)",
    "int VersionCreationResult.getAdded()",
    "String VersionCreationResult.getError()",
    "int VersionCreationResult.getModified()",
    "int VersionCreationResult.getRemoved()",
    "EntityVersion VersionCreationResult.getVersion()",
    "boolean VersionCreationResult.isDone()",
    "void VersionCreationResult.setAdded(int)",
    "void VersionCreationResult.setDone(boolean)",
    "void VersionCreationResult.setError(String)",
    "void VersionCreationResult.setModified(int)",
    "void VersionCreationResult.setRemoved(int)",
    "void VersionCreationResult.setVersion(EntityVersion)",
    "String VersionCreationResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    VersionCreationResult actualVersionCreationResult = new VersionCreationResult();
    actualVersionCreationResult.setAdded(1);
    actualVersionCreationResult.setDone(true);
    actualVersionCreationResult.setError("An error occurred");
    actualVersionCreationResult.setModified(1);
    actualVersionCreationResult.setRemoved(1);
    EntityVersion version = new EntityVersion(10L, "42", "Name", "JaneDoe");

    actualVersionCreationResult.setVersion(version);
    String actualToStringResult = actualVersionCreationResult.toString();
    int actualAdded = actualVersionCreationResult.getAdded();
    String actualError = actualVersionCreationResult.getError();
    int actualModified = actualVersionCreationResult.getModified();
    int actualRemoved = actualVersionCreationResult.getRemoved();
    EntityVersion actualVersion = actualVersionCreationResult.getVersion();

    // Assert
    assertEquals("An error occurred", actualError);
    assertEquals(
        "VersionCreationResult(version=EntityVersion(timestamp=10, id=42, name=Name, author=JaneDoe), added=1,"
            + " modified=1, removed=1, error=An error occurred, done=true)",
        actualToStringResult);
    assertEquals(1, actualAdded);
    assertEquals(1, actualModified);
    assertEquals(1, actualRemoved);
    assertTrue(actualVersionCreationResult.isDone());
    assertSame(version, actualVersion);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionCreationResult#VersionCreationResult(EntityVersion, int, int, int)}
   *   <li>{@link VersionCreationResult#setAdded(int)}
   *   <li>{@link VersionCreationResult#setDone(boolean)}
   *   <li>{@link VersionCreationResult#setError(String)}
   *   <li>{@link VersionCreationResult#setModified(int)}
   *   <li>{@link VersionCreationResult#setRemoved(int)}
   *   <li>{@link VersionCreationResult#setVersion(EntityVersion)}
   *   <li>{@link VersionCreationResult#toString()}
   *   <li>{@link VersionCreationResult#getAdded()}
   *   <li>{@link VersionCreationResult#getError()}
   *   <li>{@link VersionCreationResult#getModified()}
   *   <li>{@link VersionCreationResult#getRemoved()}
   *   <li>{@link VersionCreationResult#getVersion()}
   *   <li>{@link VersionCreationResult#isDone()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void VersionCreationResult.<init>()",
    "void VersionCreationResult.<init>(String)",
    "void VersionCreationResult.<init>(EntityVersion, int, int, int)",
    "int VersionCreationResult.getAdded()",
    "String VersionCreationResult.getError()",
    "int VersionCreationResult.getModified()",
    "int VersionCreationResult.getRemoved()",
    "EntityVersion VersionCreationResult.getVersion()",
    "boolean VersionCreationResult.isDone()",
    "void VersionCreationResult.setAdded(int)",
    "void VersionCreationResult.setDone(boolean)",
    "void VersionCreationResult.setError(String)",
    "void VersionCreationResult.setModified(int)",
    "void VersionCreationResult.setRemoved(int)",
    "void VersionCreationResult.setVersion(EntityVersion)",
    "String VersionCreationResult.toString()"
  })
  void testGettersAndSetters2() {
    // Arrange and Act
    VersionCreationResult actualVersionCreationResult =
        new VersionCreationResult(new EntityVersion(10L, "42", "Name", "JaneDoe"), 1, 1, 1);
    actualVersionCreationResult.setAdded(1);
    actualVersionCreationResult.setDone(true);
    actualVersionCreationResult.setError("An error occurred");
    actualVersionCreationResult.setModified(1);
    actualVersionCreationResult.setRemoved(1);
    EntityVersion version = new EntityVersion(10L, "42", "Name", "JaneDoe");

    actualVersionCreationResult.setVersion(version);
    String actualToStringResult = actualVersionCreationResult.toString();
    int actualAdded = actualVersionCreationResult.getAdded();
    String actualError = actualVersionCreationResult.getError();
    int actualModified = actualVersionCreationResult.getModified();
    int actualRemoved = actualVersionCreationResult.getRemoved();
    EntityVersion actualVersion = actualVersionCreationResult.getVersion();

    // Assert
    assertEquals("An error occurred", actualError);
    assertEquals(
        "VersionCreationResult(version=EntityVersion(timestamp=10, id=42, name=Name, author=JaneDoe), added=1,"
            + " modified=1, removed=1, error=An error occurred, done=true)",
        actualToStringResult);
    assertEquals(1, actualAdded);
    assertEquals(1, actualModified);
    assertEquals(1, actualRemoved);
    assertTrue(actualVersionCreationResult.isDone());
    assertSame(version, actualVersion);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link VersionCreationResult#VersionCreationResult(String)}
   *   <li>{@link VersionCreationResult#setAdded(int)}
   *   <li>{@link VersionCreationResult#setDone(boolean)}
   *   <li>{@link VersionCreationResult#setError(String)}
   *   <li>{@link VersionCreationResult#setModified(int)}
   *   <li>{@link VersionCreationResult#setRemoved(int)}
   *   <li>{@link VersionCreationResult#setVersion(EntityVersion)}
   *   <li>{@link VersionCreationResult#toString()}
   *   <li>{@link VersionCreationResult#getAdded()}
   *   <li>{@link VersionCreationResult#getError()}
   *   <li>{@link VersionCreationResult#getModified()}
   *   <li>{@link VersionCreationResult#getRemoved()}
   *   <li>{@link VersionCreationResult#getVersion()}
   *   <li>{@link VersionCreationResult#isDone()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void VersionCreationResult.<init>()",
    "void VersionCreationResult.<init>(String)",
    "void VersionCreationResult.<init>(EntityVersion, int, int, int)",
    "int VersionCreationResult.getAdded()",
    "String VersionCreationResult.getError()",
    "int VersionCreationResult.getModified()",
    "int VersionCreationResult.getRemoved()",
    "EntityVersion VersionCreationResult.getVersion()",
    "boolean VersionCreationResult.isDone()",
    "void VersionCreationResult.setAdded(int)",
    "void VersionCreationResult.setDone(boolean)",
    "void VersionCreationResult.setError(String)",
    "void VersionCreationResult.setModified(int)",
    "void VersionCreationResult.setRemoved(int)",
    "void VersionCreationResult.setVersion(EntityVersion)",
    "String VersionCreationResult.toString()"
  })
  void testGettersAndSetters_whenAnErrorOccurred() {
    // Arrange and Act
    VersionCreationResult actualVersionCreationResult =
        new VersionCreationResult("An error occurred");
    actualVersionCreationResult.setAdded(1);
    actualVersionCreationResult.setDone(true);
    actualVersionCreationResult.setError("An error occurred");
    actualVersionCreationResult.setModified(1);
    actualVersionCreationResult.setRemoved(1);
    EntityVersion version = new EntityVersion(10L, "42", "Name", "JaneDoe");

    actualVersionCreationResult.setVersion(version);
    String actualToStringResult = actualVersionCreationResult.toString();
    int actualAdded = actualVersionCreationResult.getAdded();
    String actualError = actualVersionCreationResult.getError();
    int actualModified = actualVersionCreationResult.getModified();
    int actualRemoved = actualVersionCreationResult.getRemoved();
    EntityVersion actualVersion = actualVersionCreationResult.getVersion();

    // Assert
    assertEquals("An error occurred", actualError);
    assertEquals(
        "VersionCreationResult(version=EntityVersion(timestamp=10, id=42, name=Name, author=JaneDoe), added=1,"
            + " modified=1, removed=1, error=An error occurred, done=true)",
        actualToStringResult);
    assertEquals(1, actualAdded);
    assertEquals(1, actualModified);
    assertEquals(1, actualRemoved);
    assertTrue(actualVersionCreationResult.isDone());
    assertSame(version, actualVersion);
  }
}
