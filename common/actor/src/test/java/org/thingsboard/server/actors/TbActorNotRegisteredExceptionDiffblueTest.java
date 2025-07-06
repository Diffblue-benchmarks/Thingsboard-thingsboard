package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbActorNotRegisteredExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbActorNotRegisteredException#TbActorNotRegisteredException(TbActorId, String)}
   *   <li>{@link TbActorNotRegisteredException#getTarget()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbActorNotRegisteredException.<init>(TbActorId, String)",
    "TbActorId TbActorNotRegisteredException.getTarget()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbActorId target = mock(TbActorId.class);

    // Act
    TbActorNotRegisteredException actualTbActorNotRegisteredException =
        new TbActorNotRegisteredException(target, "An error occurred");
    TbActorId actualTarget = actualTbActorNotRegisteredException.getTarget();

    // Assert
    assertEquals("An error occurred", actualTbActorNotRegisteredException.getMessage());
    assertNull(actualTbActorNotRegisteredException.getCause());
    assertEquals(0, actualTbActorNotRegisteredException.getSuppressed().length);
    assertSame(target, actualTarget);
  }
}
