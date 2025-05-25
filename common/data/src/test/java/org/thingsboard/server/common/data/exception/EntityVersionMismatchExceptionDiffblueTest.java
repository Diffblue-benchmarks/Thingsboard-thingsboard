package org.thingsboard.server.common.data.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class EntityVersionMismatchExceptionDiffblueTest {
  /**
   * Test {@link EntityVersionMismatchException#EntityVersionMismatchException(String, Throwable)}.
   * <p>
   * Method under test: {@link EntityVersionMismatchException#EntityVersionMismatchException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EntityVersionMismatchException(String, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityVersionMismatchException.<init>(String, Throwable)"})
  void testNewEntityVersionMismatchException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EntityVersionMismatchException actualEntityVersionMismatchException = new EntityVersionMismatchException(
        "0123456789ABCDEF", cause);

    // Assert
    assertEquals("0123456789ABCDEF", actualEntityVersionMismatchException.getMessage());
    assertEquals(0, actualEntityVersionMismatchException.getSuppressed().length);
    assertSame(cause, actualEntityVersionMismatchException.getCause());
  }

  /**
   * Test {@link EntityVersionMismatchException#EntityVersionMismatchException(EntityType, Throwable)}.
   * <p>
   * Method under test: {@link EntityVersionMismatchException#EntityVersionMismatchException(EntityType, Throwable)}
   */
  @Test
  @DisplayName("Test new EntityVersionMismatchException(EntityType, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityVersionMismatchException.<init>(EntityType, Throwable)"})
  void testNewEntityVersionMismatchException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EntityVersionMismatchException actualEntityVersionMismatchException = new EntityVersionMismatchException(
        EntityType.TENANT, cause);

    // Assert
    assertEquals("Tenant was already changed by someone else",
        actualEntityVersionMismatchException.getLocalizedMessage());
    assertEquals("Tenant was already changed by someone else", actualEntityVersionMismatchException.getMessage());
    assertEquals(0, actualEntityVersionMismatchException.getSuppressed().length);
    assertSame(cause, actualEntityVersionMismatchException.getCause());
  }

  /**
   * Test {@link EntityVersionMismatchException#EntityVersionMismatchException(EntityType, Throwable)}.
   * <p>
   * Method under test: {@link EntityVersionMismatchException#EntityVersionMismatchException(EntityType, Throwable)}
   */
  @Test
  @DisplayName("Test new EntityVersionMismatchException(EntityType, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityVersionMismatchException.<init>(EntityType, Throwable)"})
  void testNewEntityVersionMismatchException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EntityVersionMismatchException actualEntityVersionMismatchException = new EntityVersionMismatchException(
        (EntityType) null, cause);

    // Assert
    assertEquals("Entity was already changed by someone else",
        actualEntityVersionMismatchException.getLocalizedMessage());
    assertEquals("Entity was already changed by someone else", actualEntityVersionMismatchException.getMessage());
    assertEquals(0, actualEntityVersionMismatchException.getSuppressed().length);
    assertSame(cause, actualEntityVersionMismatchException.getCause());
  }
}
