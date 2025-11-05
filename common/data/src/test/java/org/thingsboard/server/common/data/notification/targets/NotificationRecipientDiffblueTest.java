package org.thingsboard.server.common.data.notification.targets;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NotificationRecipientDiffblueTest {
  /**
   * Test {@link NotificationRecipient#getFirstName()}.
   *
   * <p>Method under test: {@link NotificationRecipient#getFirstName()}
   */
  @Test
  @DisplayName("Test getFirstName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String NotificationRecipient.getFirstName()"})
  void testGetFirstName() {
    // Arrange, Act and Assert
    assertNull(new MicrosoftTeamsNotificationTargetConfig().getFirstName());
  }

  /**
   * Test {@link NotificationRecipient#getLastName()}.
   *
   * <p>Method under test: {@link NotificationRecipient#getLastName()}
   */
  @Test
  @DisplayName("Test getLastName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String NotificationRecipient.getLastName()"})
  void testGetLastName() {
    // Arrange, Act and Assert
    assertNull(new MicrosoftTeamsNotificationTargetConfig().getLastName());
  }

  /**
   * Test {@link NotificationRecipient#getEmail()}.
   *
   * <p>Method under test: {@link NotificationRecipient#getEmail()}
   */
  @Test
  @DisplayName("Test getEmail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String NotificationRecipient.getEmail()"})
  void testGetEmail() {
    // Arrange, Act and Assert
    assertNull(new MicrosoftTeamsNotificationTargetConfig().getEmail());
  }
}
