package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SubscriptionErrorCodeDiffblueTest {
  /**
   * Test {@link SubscriptionErrorCode#forCode(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionErrorCode#forCode(int)}
   */
  @Test
  @DisplayName("Test forCode(int); when four; then throw IllegalArgumentException")
  void testForCode_whenFour_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SubscriptionErrorCode.forCode(4));
  }

  /**
   * Test {@link SubscriptionErrorCode#forCode(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code INTERNAL_ERROR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SubscriptionErrorCode#forCode(int)}
   */
  @Test
  @DisplayName("Test forCode(int); when one; then return 'INTERNAL_ERROR'")
  void testForCode_whenOne_thenReturnInternalError() {
    // Arrange, Act and Assert
    assertEquals(SubscriptionErrorCode.INTERNAL_ERROR, SubscriptionErrorCode.forCode(1));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SubscriptionErrorCode#getCode()}
   *   <li>{@link SubscriptionErrorCode#getDefaultMsg()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    SubscriptionErrorCode valueOfResult = SubscriptionErrorCode.valueOf("NO_ERROR");

    // Act
    int actualCode = valueOfResult.getCode();

    // Assert
    assertNull(valueOfResult.getDefaultMsg());
    assertEquals(0, actualCode);
  }
}
