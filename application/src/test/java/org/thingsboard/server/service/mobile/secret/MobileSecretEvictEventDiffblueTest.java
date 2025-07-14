package org.thingsboard.server.service.mobile.secret;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MobileSecretEvictEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileSecretEvictEvent#MobileSecretEvictEvent(String)}
   *   <li>{@link MobileSecretEvictEvent#toString()}
   *   <li>{@link MobileSecretEvictEvent#getSecret()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MobileSecretEvictEvent.<init>(String)",
    "String MobileSecretEvictEvent.getSecret()",
    "String MobileSecretEvictEvent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    MobileSecretEvictEvent actualMobileSecretEvictEvent = new MobileSecretEvictEvent("Secret");
    String actualToStringResult = actualMobileSecretEvictEvent.toString();

    // Assert
    assertEquals("MobileSecretEvictEvent(secret=Secret)", actualToStringResult);
    assertEquals("Secret", actualMobileSecretEvictEvent.getSecret());
  }
}
