package org.thingsboard.server.service.notification.provider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.notification.provider.DefaultFirebaseService.FirebaseContext;

class DefaultFirebaseServiceDiffblueTest {
  /**
   * Test FirebaseContext {@link FirebaseContext#FirebaseContext(String, String)}.
   *
   * <ul>
   *   <li>When {@code Credentials}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FirebaseContext#FirebaseContext(String, String)}
   */
  @Test
  @DisplayName(
      "Test FirebaseContext new FirebaseContext(String, String); when 'Credentials'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FirebaseContext.<init>(String, String)"})
  void testFirebaseContextNewFirebaseContext_whenCredentials_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new FirebaseContext("Key", "Credentials"));
  }
}
