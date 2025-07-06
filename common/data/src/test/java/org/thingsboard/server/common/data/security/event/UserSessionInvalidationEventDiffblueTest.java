package org.thingsboard.server.common.data.security.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserSessionInvalidationEventDiffblueTest {
  /**
   * Test {@link UserSessionInvalidationEvent#UserSessionInvalidationEvent(String)}.
   *
   * <p>Method under test: {@link UserSessionInvalidationEvent#UserSessionInvalidationEvent(String)}
   */
  @Test
  @DisplayName("Test new UserSessionInvalidationEvent(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserSessionInvalidationEvent.<init>(String)"})
  void testNewUserSessionInvalidationEvent() {
    // Arrange, Act and Assert
    assertEquals("42", new UserSessionInvalidationEvent("42").getId());
  }

  /**
   * Test {@link UserSessionInvalidationEvent#equals(Object)}, and {@link
   * UserSessionInvalidationEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSessionInvalidationEvent#equals(Object)}
   *   <li>{@link UserSessionInvalidationEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSessionInvalidationEvent.equals(Object)",
    "int UserSessionInvalidationEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserSessionInvalidationEvent userSessionInvalidationEvent =
        new UserSessionInvalidationEvent("42");

    // Act and Assert
    assertEquals(userSessionInvalidationEvent, userSessionInvalidationEvent);
    int expectedHashCodeResult = userSessionInvalidationEvent.hashCode();
    assertEquals(expectedHashCodeResult, userSessionInvalidationEvent.hashCode());
  }

  /**
   * Test {@link UserSessionInvalidationEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSessionInvalidationEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSessionInvalidationEvent.equals(Object)",
    "int UserSessionInvalidationEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserSessionInvalidationEvent userSessionInvalidationEvent =
        new UserSessionInvalidationEvent("42");

    // Act and Assert
    assertNotEquals(userSessionInvalidationEvent, new UserSessionInvalidationEvent("42"));
  }

  /**
   * Test {@link UserSessionInvalidationEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSessionInvalidationEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSessionInvalidationEvent.equals(Object)",
    "int UserSessionInvalidationEvent.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserSessionInvalidationEvent("42"), null);
  }

  /**
   * Test {@link UserSessionInvalidationEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSessionInvalidationEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSessionInvalidationEvent.equals(Object)",
    "int UserSessionInvalidationEvent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new UserSessionInvalidationEvent("42"), "Different type to UserSessionInvalidationEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSessionInvalidationEvent#getId()}
   *   <li>{@link UserSessionInvalidationEvent#getTs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "String UserSessionInvalidationEvent.getId()",
    "long UserSessionInvalidationEvent.getTs()"
  })
  void testGettersAndSetters() {
    // Arrange
    UserSessionInvalidationEvent userSessionInvalidationEvent =
        new UserSessionInvalidationEvent("42");

    // Act
    String actualId = userSessionInvalidationEvent.getId();
    userSessionInvalidationEvent.getTs();

    // Assert
    assertEquals("42", actualId);
  }
}
