package org.thingsboard.server.service.ws.notification.sub;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.service.subscription.TbSubscription;

class AbstractNotificationSubscriptionDiffblueTest {
  /**
   * Test {@link AbstractNotificationSubscription#getSequence()}.
   * <p>
   * Method under test: {@link AbstractNotificationSubscription#getSequence()}
   */
  @Test
  @DisplayName("Test getSequence()")
  void testGetSequence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationsCountSubscription notificationsCountSubscription = new NotificationsCountSubscription("42", "42", 1,
        new TenantId(UUID.randomUUID()), null, mock(BiConsumer.class));

    // Act and Assert
    assertSame(notificationsCountSubscription.sequence, notificationsCountSubscription.getSequence());
  }

  /**
   * Test {@link AbstractNotificationSubscription#getTotalUnreadCounter()}.
   * <p>
   * Method under test:
   * {@link AbstractNotificationSubscription#getTotalUnreadCounter()}
   */
  @Test
  @DisplayName("Test getTotalUnreadCounter()")
  void testGetTotalUnreadCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationsCountSubscription notificationsCountSubscription = new NotificationsCountSubscription("42", "42", 1,
        new TenantId(UUID.randomUUID()), null, mock(BiConsumer.class));

    // Act and Assert
    assertSame(notificationsCountSubscription.totalUnreadCounter,
        notificationsCountSubscription.getTotalUnreadCounter());
  }
}
