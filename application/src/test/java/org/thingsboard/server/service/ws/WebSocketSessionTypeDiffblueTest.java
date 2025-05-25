package org.thingsboard.server.service.ws;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WebSocketSessionTypeDiffblueTest {
  /**
   * Test {@link WebSocketSessionType#forName(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketSessionType#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'Name'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional WebSocketSessionType.forName(String)"})
  void testForName_whenName_thenReturnNotPresent() {
    // Arrange and Act
    Optional<WebSocketSessionType> actualForNameResult = WebSocketSessionType.forName("Name");

    // Assert
    assertFalse(actualForNameResult.isPresent());
  }

  /**
   * Test {@link WebSocketSessionType#forName(String)}.
   * <ul>
   *   <li>When {@code notifications}.</li>
   *   <li>Then return {@link Optional#get()} is {@code NOTIFICATIONS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketSessionType#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'notifications'; then return get() is 'NOTIFICATIONS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional WebSocketSessionType.forName(String)"})
  void testForName_whenNotifications_thenReturnGetIsNotifications() {
    // Arrange and Act
    Optional<WebSocketSessionType> actualForNameResult = WebSocketSessionType.forName("notifications");

    // Assert
    assertEquals(WebSocketSessionType.NOTIFICATIONS, actualForNameResult.get());
    assertTrue(actualForNameResult.isPresent());
  }

  /**
   * Test {@link WebSocketSessionType#forName(String)}.
   * <ul>
   *   <li>When {@code NOTIFICATIONS}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebSocketSessionType#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'NOTIFICATIONS'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional WebSocketSessionType.forName(String)"})
  void testForName_whenNotifications_thenReturnNotPresent() {
    // Arrange and Act
    Optional<WebSocketSessionType> actualForNameResult = WebSocketSessionType.forName("NOTIFICATIONS");

    // Assert
    assertFalse(actualForNameResult.isPresent());
  }
}
