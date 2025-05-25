package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.service.ws.notification.sub.NotificationsCountSubscription;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.id.EntityId TbSubscription.getEntityId()"})
  void testGetEntityId_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new NotificationsCountSubscription("42", "42", 1,
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, mock(BiConsumer.class)))
        .getEntityId());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String TbSubscription.getServiceId()"})
  void testGetServiceId_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42",
        (new NotificationsCountSubscription("42", "42", 1,
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, mock(BiConsumer.class)))
            .getServiceId());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String TbSubscription.getSessionId()"})
  void testGetSessionId_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42",
        (new NotificationsCountSubscription("42", "42", 1,
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, mock(BiConsumer.class)))
            .getSessionId());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int TbSubscription.getSubscriptionId()"})
  void testGetSubscriptionId_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1,
        (new NotificationsCountSubscription("42", "42", 1,
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, mock(BiConsumer.class)))
            .getSubscriptionId());
  }

  /**
   * Test {@link TbSubscription#getTenantId()}.
   * <p>
   * Method under test: {@link TbSubscription#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantId TbSubscription.getTenantId()"})
  void testGetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbSubscriptionType TbSubscription.getType()"})
  void testGetType_thenReturnNotificationsCount() {
    // Arrange, Act and Assert
    assertEquals(TbSubscriptionType.NOTIFICATIONS_COUNT,
        (new NotificationsCountSubscription("42", "42", 1,
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, mock(BiConsumer.class)))
            .getType());
  }
}
