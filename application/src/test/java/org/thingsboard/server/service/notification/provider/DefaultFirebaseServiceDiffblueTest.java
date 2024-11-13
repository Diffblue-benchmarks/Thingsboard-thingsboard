package org.thingsboard.server.service.notification.provider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.notification.provider.DefaultFirebaseService.FirebaseContext;

class DefaultFirebaseServiceDiffblueTest {
  /**
   * Test FirebaseContext {@link FirebaseContext#FirebaseContext(String, String)}.
   * <ul>
   *   <li>When {@code Credentials}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultFirebaseService.FirebaseContext#FirebaseContext(String, String)}
   */
  @Test
  @DisplayName("Test FirebaseContext new FirebaseContext(String, String); when 'Credentials'; then throw RuntimeException")
  void testFirebaseContextNewFirebaseContext_whenCredentials_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new DefaultFirebaseService.FirebaseContext("Key", "Credentials"));

  }
}
