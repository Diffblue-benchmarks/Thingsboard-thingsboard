package org.thingsboard.rule.engine.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbNodeExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Message is {@code Exception: foo}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNodeException#TbNodeException(Exception)}
   *   <li>{@link TbNodeException#isUnrecoverable()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Message is 'java.lang.Exception: foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbNodeException.<init>(Exception)",
    "void TbNodeException.<init>(Exception, boolean)",
    "void TbNodeException.<init>(String)",
    "void TbNodeException.<init>(String, boolean)",
    "boolean TbNodeException.isUnrecoverable()"
  })
  void testGettersAndSetters_thenReturnMessageIsJavaLangExceptionFoo() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    TbNodeException actualTbNodeException = new TbNodeException(e);
    boolean actualIsUnrecoverableResult = actualTbNodeException.isUnrecoverable();

    // Assert
    assertEquals("java.lang.Exception: foo", actualTbNodeException.getMessage());
    assertEquals(0, actualTbNodeException.getSuppressed().length);
    assertFalse(actualIsUnrecoverableResult);
    assertSame(e, actualTbNodeException.getCause());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Message is {@code Exception: foo}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNodeException#TbNodeException(Exception, boolean)}
   *   <li>{@link TbNodeException#isUnrecoverable()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Message is 'java.lang.Exception: foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbNodeException.<init>(Exception)",
    "void TbNodeException.<init>(Exception, boolean)",
    "void TbNodeException.<init>(String)",
    "void TbNodeException.<init>(String, boolean)",
    "boolean TbNodeException.isUnrecoverable()"
  })
  void testGettersAndSetters_thenReturnMessageIsJavaLangExceptionFoo2() {
    // Arrange
    Exception e = new Exception("foo");

    // Act
    TbNodeException actualTbNodeException = new TbNodeException(e, true);
    boolean actualIsUnrecoverableResult = actualTbNodeException.isUnrecoverable();

    // Assert
    assertEquals("java.lang.Exception: foo", actualTbNodeException.getMessage());
    assertEquals(0, actualTbNodeException.getSuppressed().length);
    assertTrue(actualIsUnrecoverableResult);
    assertSame(e, actualTbNodeException.getCause());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNodeException#TbNodeException(String)}
   *   <li>{@link TbNodeException#isUnrecoverable()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbNodeException.<init>(Exception)",
    "void TbNodeException.<init>(Exception, boolean)",
    "void TbNodeException.<init>(String)",
    "void TbNodeException.<init>(String, boolean)",
    "boolean TbNodeException.isUnrecoverable()"
  })
  void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    TbNodeException actualTbNodeException = new TbNodeException("An error occurred");
    boolean actualIsUnrecoverableResult = actualTbNodeException.isUnrecoverable();

    // Assert
    assertEquals("An error occurred", actualTbNodeException.getMessage());
    assertNull(actualTbNodeException.getCause());
    assertEquals(0, actualTbNodeException.getSuppressed().length);
    assertFalse(actualIsUnrecoverableResult);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNodeException#TbNodeException(String, boolean)}
   *   <li>{@link TbNodeException#isUnrecoverable()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbNodeException.<init>(Exception)",
    "void TbNodeException.<init>(Exception, boolean)",
    "void TbNodeException.<init>(String)",
    "void TbNodeException.<init>(String, boolean)",
    "boolean TbNodeException.isUnrecoverable()"
  })
  void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange and Act
    TbNodeException actualTbNodeException = new TbNodeException("An error occurred", true);
    boolean actualIsUnrecoverableResult = actualTbNodeException.isUnrecoverable();

    // Assert
    assertEquals("An error occurred", actualTbNodeException.getMessage());
    assertNull(actualTbNodeException.getCause());
    assertEquals(0, actualTbNodeException.getSuppressed().length);
    assertTrue(actualIsUnrecoverableResult);
  }
}
