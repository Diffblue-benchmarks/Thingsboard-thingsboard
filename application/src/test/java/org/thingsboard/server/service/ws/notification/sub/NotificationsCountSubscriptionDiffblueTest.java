package org.thingsboard.server.service.ws.notification.sub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.service.subscription.TbSubscription;
import org.thingsboard.server.service.subscription.TbSubscriptionType;
import org.thingsboard.server.service.ws.notification.cmd.UnreadNotificationsCountUpdate;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.CmdUpdateType;

class NotificationsCountSubscriptionDiffblueTest {
  /**
   * Test
   * {@link NotificationsCountSubscription#NotificationsCountSubscription(String, String, int, TenantId, EntityId, BiConsumer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ServiceId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationsCountSubscription#NotificationsCountSubscription(String, String, int, TenantId, EntityId, BiConsumer)}
   */
  @Test
  @DisplayName("Test new NotificationsCountSubscription(String, String, int, TenantId, EntityId, BiConsumer); when 'null'; then return ServiceId is '42'")
  void testNewNotificationsCountSubscription_whenNull_thenReturnServiceIdIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    BiConsumer<TbSubscription<NotificationsSubscriptionUpdate>, NotificationsSubscriptionUpdate> updateProcessor = mock(
        BiConsumer.class);

    // Act
    NotificationsCountSubscription actualNotificationsCountSubscription = new NotificationsCountSubscription("42", "42",
        1, tenantId, null, updateProcessor);

    // Assert
    assertEquals("42", actualNotificationsCountSubscription.getServiceId());
    assertEquals("42", actualNotificationsCountSubscription.getSessionId());
    assertNull(actualNotificationsCountSubscription.getEntityId());
    assertEquals(0, actualNotificationsCountSubscription.getSequence().get());
    assertEquals(1, actualNotificationsCountSubscription.getSubscriptionId());
    assertEquals(TbSubscriptionType.NOTIFICATIONS_COUNT, actualNotificationsCountSubscription.getType());
    assertSame(tenantId, actualNotificationsCountSubscription.getTenantId());
    assertSame(updateProcessor, actualNotificationsCountSubscription.getUpdateProcessor());
  }

  /**
   * Test {@link NotificationsCountSubscription#createUpdate()}.
   * <ul>
   *   <li>Then return ErrorMsg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationsCountSubscription#createUpdate()}
   */
  @Test
  @DisplayName("Test createUpdate(); then return ErrorMsg is 'null'")
  void testCreateUpdate_thenReturnErrorMsgIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationsCountSubscription notificationsCountSubscription = new NotificationsCountSubscription("42", "42", 1,
        new TenantId(UUID.randomUUID()), null, mock(BiConsumer.class));

    // Act
    UnreadNotificationsCountUpdate actualCreateUpdateResult = notificationsCountSubscription.createUpdate();

    // Assert
    assertNull(actualCreateUpdateResult.getErrorMsg());
    assertEquals(0, actualCreateUpdateResult.getTotalUnreadCount());
    assertEquals(0, actualCreateUpdateResult.getErrorCode());
    assertEquals(1, notificationsCountSubscription.getSequence().get());
    assertEquals(1, actualCreateUpdateResult.getSequenceNumber());
    assertEquals(1, actualCreateUpdateResult.getCmdId());
    assertEquals(CmdUpdateType.NOTIFICATIONS_COUNT, actualCreateUpdateResult.getCmdUpdateType());
  }
}
