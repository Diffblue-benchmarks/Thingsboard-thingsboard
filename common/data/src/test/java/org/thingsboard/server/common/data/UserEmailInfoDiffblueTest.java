package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.UserId;

class UserEmailInfoDiffblueTest {
  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(mock(UserId.class), "jane.doe@example.org", "Jane", "Doe");

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new UserEmailInfo(mock(UserId.class), "jane.doe@example.org", "Jane", "Doe"), "42");
  }

  /**
   * Test {@link UserEmailInfo#getId()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserEmailInfo#getId()}
   */
  @Test
  @DisplayName("Test getId(); then return 'null'")
  void testGetId_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe")).getId());
  }
}
