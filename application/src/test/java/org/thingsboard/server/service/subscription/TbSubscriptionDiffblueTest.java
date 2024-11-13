package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.service.ws.notification.sub.NotificationsCountSubscription;
import org.thingsboard.server.service.ws.notification.sub.NotificationsSubscriptionUpdate;

class TbSubscriptionDiffblueTest {
  /**
   * Test {@link TbSubscription#getEntityId()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscription#getEntityId()}
   */
  @Test
  @DisplayName("Test getEntityId(); then return 'null'")
  void testGetEntityId_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new NotificationsCountSubscription("42", "42", 1, new TenantId(UUID.randomUUID()), null,
        mock(BiConsumer.class))).getEntityId());
  }

  /**
   * Test {@link TbSubscription#getServiceId()}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscription#getServiceId()}
   */
  @Test
  @DisplayName("Test getServiceId(); then return '42'")
  void testGetServiceId_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42", (new NotificationsCountSubscription("42", "42", 1, new TenantId(UUID.randomUUID()), null,
        mock(BiConsumer.class))).getServiceId());
  }

  /**
   * Test {@link TbSubscription#getSessionId()}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscription#getSessionId()}
   */
  @Test
  @DisplayName("Test getSessionId(); then return '42'")
  void testGetSessionId_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42", (new NotificationsCountSubscription("42", "42", 1, new TenantId(UUID.randomUUID()), null,
        mock(BiConsumer.class))).getSessionId());
  }

  /**
   * Test {@link TbSubscription#getSubscriptionId()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscription#getSubscriptionId()}
   */
  @Test
  @DisplayName("Test getSubscriptionId(); then return one")
  void testGetSubscriptionId_thenReturnOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(1, (new NotificationsCountSubscription("42", "42", 1, new TenantId(UUID.randomUUID()), null,
        mock(BiConsumer.class))).getSubscriptionId());
  }

  /**
   * Test {@link TbSubscription#getTenantId()}.
   * <ul>
   *   <li>Then return {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscription#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId(); then return TenantId(UUID) with id is randomUUID")
  void testGetTenantId_thenReturnTenantIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertSame(tenantId,
        (new NotificationsCountSubscription("42", "42", 1, tenantId, null, mock(BiConsumer.class))).getTenantId());
  }

  /**
   * Test {@link TbSubscription#getType()}.
   * <ul>
   *   <li>Then return {@code NOTIFICATIONS_COUNT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSubscription#getType()}
   */
  @Test
  @DisplayName("Test getType(); then return 'NOTIFICATIONS_COUNT'")
  void testGetType_thenReturnNotificationsCount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(TbSubscriptionType.NOTIFICATIONS_COUNT, (new NotificationsCountSubscription("42", "42", 1,
        new TenantId(UUID.randomUUID()), null, mock(BiConsumer.class))).getType());
  }
}
