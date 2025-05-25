package org.thingsboard.server.common.data.security.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.UserId;

class UserCredentialsInvalidationEventDiffblueTest {
  /**
   * Test {@link UserCredentialsInvalidationEvent#getId()}.
   * <ul>
   *   <li>Then return {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsInvalidationEvent#getId()}
   */
  @Test
  @DisplayName("Test getId(); then return '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String UserCredentialsInvalidationEvent.getId()"})
  void testGetId_thenReturn784f394c42b6435a983cB7beff2784f9() {
    // Arrange, Act and Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9",
        (new UserCredentialsInvalidationEvent(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))))
            .getId());
  }

  /**
   * Test {@link UserCredentialsInvalidationEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsInvalidationEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserCredentialsInvalidationEvent.equals(Object)",
      "int UserCredentialsInvalidationEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserCredentialsInvalidationEvent userCredentialsInvalidationEvent = new UserCredentialsInvalidationEvent(null);

    // Act and Assert
    assertNotEquals(userCredentialsInvalidationEvent, new UserCredentialsInvalidationEvent(null));
  }

  /**
   * Test {@link UserCredentialsInvalidationEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsInvalidationEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserCredentialsInvalidationEvent.equals(Object)",
      "int UserCredentialsInvalidationEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new UserCredentialsInvalidationEvent(null), 1);
  }
}
