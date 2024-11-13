package org.thingsboard.server.service.notification.provider;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.settings.NotificationSettings;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversationType;
import org.thingsboard.server.dao.notification.NotificationSettingsService;

@ContextConfiguration(classes = {DefaultSlackService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DefaultSlackServiceDiffblueTest {
  @Autowired
  private DefaultSlackService defaultSlackService;

  @MockBean
  private NotificationSettingsService notificationSettingsService;

  /**
   * Test
   * {@link DefaultSlackService#sendMessage(TenantId, String, String, String)}.
   * <p>
   * Method under test:
   * {@link DefaultSlackService#sendMessage(TenantId, String, String, String)}
   */
  @Test
  @DisplayName("Test sendMessage(TenantId, String, String, String)")
  void testSendMessage() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> defaultSlackService.sendMessage(new TenantId(UUID.randomUUID()),
        "ABC123", "42", "Not all who wander are lost"));
  }

  /**
   * Test
   * {@link DefaultSlackService#listConversations(TenantId, String, SlackConversationType)}.
   * <ul>
   *   <li>When {@code DIRECT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSlackService#listConversations(TenantId, String, SlackConversationType)}
   */
  @Test
  @DisplayName("Test listConversations(TenantId, String, SlackConversationType); when 'DIRECT'")
  void testListConversations_whenDirect() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> defaultSlackService.listConversations(new TenantId(UUID.randomUUID()),
        "ABC123", SlackConversationType.DIRECT));
  }

  /**
   * Test
   * {@link DefaultSlackService#listConversations(TenantId, String, SlackConversationType)}.
   * <ul>
   *   <li>When {@code PRIVATE_CHANNEL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSlackService#listConversations(TenantId, String, SlackConversationType)}
   */
  @Test
  @DisplayName("Test listConversations(TenantId, String, SlackConversationType); when 'PRIVATE_CHANNEL'")
  void testListConversations_whenPrivateChannel() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> defaultSlackService.listConversations(new TenantId(UUID.randomUUID()),
        "ABC123", SlackConversationType.PRIVATE_CHANNEL));
  }

  /**
   * Test
   * {@link DefaultSlackService#listConversations(TenantId, String, SlackConversationType)}.
   * <ul>
   *   <li>When {@code PUBLIC_CHANNEL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSlackService#listConversations(TenantId, String, SlackConversationType)}
   */
  @Test
  @DisplayName("Test listConversations(TenantId, String, SlackConversationType); when 'PUBLIC_CHANNEL'")
  void testListConversations_whenPublicChannel() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> defaultSlackService.listConversations(new TenantId(UUID.randomUUID()),
        "ABC123", SlackConversationType.PUBLIC_CHANNEL));
  }

  /**
   * Test {@link DefaultSlackService#getToken(TenantId)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSlackService#getToken(TenantId)}
   */
  @Test
  @DisplayName("Test getToken(TenantId); then return 'null'")
  void testGetToken_thenReturnNull() {
    // Arrange
    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setDeliveryMethodsConfigs(new HashMap<>());
    when(notificationSettingsService.findNotificationSettings(Mockito.<TenantId>any()))
        .thenReturn(notificationSettings);

    // Act
    String actualToken = defaultSlackService.getToken(new TenantId(UUID.randomUUID()));

    // Assert
    verify(notificationSettingsService).findNotificationSettings(isA(TenantId.class));
    assertNull(actualToken);
  }

  /**
   * Test {@link DefaultSlackService#getToken(TenantId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSlackService#getToken(TenantId)}
   */
  @Test
  @DisplayName("Test getToken(TenantId); then throw RuntimeException")
  void testGetToken_thenThrowRuntimeException() {
    // Arrange
    when(notificationSettingsService.findNotificationSettings(Mockito.<TenantId>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultSlackService.getToken(new TenantId(UUID.randomUUID())));
    verify(notificationSettingsService).findNotificationSettings(isA(TenantId.class));
  }
}
