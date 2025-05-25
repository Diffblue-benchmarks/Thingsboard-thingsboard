package org.thingsboard.server.service.notification.channels;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetAddress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.notification.targets.MicrosoftTeamsNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.template.MicrosoftTeamsDeliveryMethodNotificationTemplate;
import org.thingsboard.server.common.data.notification.template.MicrosoftTeamsDeliveryMethodNotificationTemplate.Button;
import org.thingsboard.server.common.data.notification.template.MicrosoftTeamsDeliveryMethodNotificationTemplate.Button.LinkType;
import org.thingsboard.server.service.notification.NotificationProcessingContext;

@ExtendWith(MockitoExtension.class)
class MicrosoftTeamsNotificationChannelDiffblueTest {
  @InjectMocks
  private MicrosoftTeamsNotificationChannel microsoftTeamsNotificationChannel;

  /**
   * Test {@link MicrosoftTeamsNotificationChannel#sendNotification(MicrosoftTeamsNotificationTargetConfig, MicrosoftTeamsDeliveryMethodNotificationTemplate, NotificationProcessingContext)} with {@code MicrosoftTeamsNotificationTargetConfig}, {@code MicrosoftTeamsDeliveryMethodNotificationTemplate}, {@code NotificationProcessingContext}.
   * <p>
   * Method under test: {@link MicrosoftTeamsNotificationChannel#sendNotification(MicrosoftTeamsNotificationTargetConfig, MicrosoftTeamsDeliveryMethodNotificationTemplate, NotificationProcessingContext)}
   */
  @Test
  @DisplayName("Test sendNotification(MicrosoftTeamsNotificationTargetConfig, MicrosoftTeamsDeliveryMethodNotificationTemplate, NotificationProcessingContext) with 'MicrosoftTeamsNotificationTargetConfig', 'MicrosoftTeamsDeliveryMethodNotificationTemplate', 'NotificationProcessingContext'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void MicrosoftTeamsNotificationChannel.sendNotification(MicrosoftTeamsNotificationTargetConfig, MicrosoftTeamsDeliveryMethodNotificationTemplate, NotificationProcessingContext)"})
  void testSendNotificationWithMicrosoftTeamsNotificationTargetConfigMicrosoftTeamsDeliveryMethodNotificationTemplateNotificationProcessingContext()
      throws Exception {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
          .thenReturn(new InetAddress[]{mock(InetAddress.class)});
      MicrosoftTeamsNotificationTargetConfig targetConfig = mock(MicrosoftTeamsNotificationTargetConfig.class);
      when(targetConfig.getUseOldApi()).thenReturn(false);
      doNothing().when(targetConfig).setChannelName(Mockito.<String>any());
      doNothing().when(targetConfig).setUseOldApi(Mockito.<Boolean>any());
      doNothing().when(targetConfig).setWebhookUrl(Mockito.<String>any());
      doNothing().when(targetConfig).setDescription(Mockito.<String>any());
      targetConfig.setChannelName("Channel Name");
      targetConfig.setDescription("The characteristics of someone or something");
      targetConfig.setUseOldApi(true);
      targetConfig.setWebhookUrl("https://example.org/example");
      Button button = mock(Button.class);
      when(button.getText()).thenThrow(new IllegalStateException("message"));
      when(button.getLink()).thenReturn("Link");
      when(button.getLinkType()).thenReturn(LinkType.LINK);
      when(button.isEnabled()).thenReturn(true);
      MicrosoftTeamsDeliveryMethodNotificationTemplate processedTemplate = mock(
          MicrosoftTeamsDeliveryMethodNotificationTemplate.class);
      when(processedTemplate.getBody()).thenReturn("Not all who wander are lost");
      when(processedTemplate.getSubject()).thenReturn("Hello from the Dreaming Spires");
      when(processedTemplate.getThemeColor()).thenReturn("Theme Color");
      when(processedTemplate.getButton()).thenReturn(button);

      // Act and Assert
      assertThrows(IllegalStateException.class,
          () -> microsoftTeamsNotificationChannel.sendNotification(targetConfig, processedTemplate, null));
      verify(targetConfig, atLeast(1)).getUseOldApi();
      verify(targetConfig).setChannelName(eq("Channel Name"));
      verify(targetConfig).setUseOldApi(eq(true));
      verify(targetConfig).setWebhookUrl(eq("https://example.org/example"));
      verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
      verify(processedTemplate).getBody();
      verify(processedTemplate, atLeast(1)).getButton();
      verify(processedTemplate, atLeast(1)).getSubject();
      verify(processedTemplate, atLeast(1)).getThemeColor();
      verify(button).getLink();
      verify(button).getLinkType();
      verify(button).getText();
      verify(button).isEnabled();
    }
  }

  /**
   * Test {@link MicrosoftTeamsNotificationChannel#sendNotification(MicrosoftTeamsNotificationTargetConfig, MicrosoftTeamsDeliveryMethodNotificationTemplate, NotificationProcessingContext)} with {@code MicrosoftTeamsNotificationTargetConfig}, {@code MicrosoftTeamsDeliveryMethodNotificationTemplate}, {@code NotificationProcessingContext}.
   * <p>
   * Method under test: {@link MicrosoftTeamsNotificationChannel#sendNotification(MicrosoftTeamsNotificationTargetConfig, MicrosoftTeamsDeliveryMethodNotificationTemplate, NotificationProcessingContext)}
   */
  @Test
  @DisplayName("Test sendNotification(MicrosoftTeamsNotificationTargetConfig, MicrosoftTeamsDeliveryMethodNotificationTemplate, NotificationProcessingContext) with 'MicrosoftTeamsNotificationTargetConfig', 'MicrosoftTeamsDeliveryMethodNotificationTemplate', 'NotificationProcessingContext'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void MicrosoftTeamsNotificationChannel.sendNotification(MicrosoftTeamsNotificationTargetConfig, MicrosoftTeamsDeliveryMethodNotificationTemplate, NotificationProcessingContext)"})
  void testSendNotificationWithMicrosoftTeamsNotificationTargetConfigMicrosoftTeamsDeliveryMethodNotificationTemplateNotificationProcessingContext2()
      throws Exception {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
          .thenReturn(new InetAddress[]{mock(InetAddress.class)});
      MicrosoftTeamsNotificationTargetConfig targetConfig = mock(MicrosoftTeamsNotificationTargetConfig.class);
      when(targetConfig.getUseOldApi()).thenReturn(false);
      doNothing().when(targetConfig).setChannelName(Mockito.<String>any());
      doNothing().when(targetConfig).setUseOldApi(Mockito.<Boolean>any());
      doNothing().when(targetConfig).setWebhookUrl(Mockito.<String>any());
      doNothing().when(targetConfig).setDescription(Mockito.<String>any());
      targetConfig.setChannelName("Channel Name");
      targetConfig.setDescription("The characteristics of someone or something");
      targetConfig.setUseOldApi(true);
      targetConfig.setWebhookUrl("https://example.org/example");
      Button button = mock(Button.class);
      when(button.isSetEntityIdInState()).thenThrow(new IllegalStateException("message"));
      when(button.getLinkType()).thenReturn(LinkType.DASHBOARD);
      when(button.isEnabled()).thenReturn(true);
      MicrosoftTeamsDeliveryMethodNotificationTemplate processedTemplate = mock(
          MicrosoftTeamsDeliveryMethodNotificationTemplate.class);
      when(processedTemplate.getBody()).thenReturn("Not all who wander are lost");
      when(processedTemplate.getSubject()).thenReturn("Hello from the Dreaming Spires");
      when(processedTemplate.getThemeColor()).thenReturn("Theme Color");
      when(processedTemplate.getButton()).thenReturn(button);

      // Act and Assert
      assertThrows(IllegalStateException.class,
          () -> microsoftTeamsNotificationChannel.sendNotification(targetConfig, processedTemplate, null));
      verify(targetConfig, atLeast(1)).getUseOldApi();
      verify(targetConfig).setChannelName(eq("Channel Name"));
      verify(targetConfig).setUseOldApi(eq(true));
      verify(targetConfig).setWebhookUrl(eq("https://example.org/example"));
      verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
      verify(processedTemplate).getBody();
      verify(processedTemplate).getButton();
      verify(processedTemplate, atLeast(1)).getSubject();
      verify(processedTemplate, atLeast(1)).getThemeColor();
      verify(button).getLinkType();
      verify(button).isEnabled();
      verify(button).isSetEntityIdInState();
    }
  }

  /**
   * Test {@link MicrosoftTeamsNotificationChannel#sendNotification(MicrosoftTeamsNotificationTargetConfig, MicrosoftTeamsDeliveryMethodNotificationTemplate, NotificationProcessingContext)} with {@code MicrosoftTeamsNotificationTargetConfig}, {@code MicrosoftTeamsDeliveryMethodNotificationTemplate}, {@code NotificationProcessingContext}.
   * <p>
   * Method under test: {@link MicrosoftTeamsNotificationChannel#sendNotification(MicrosoftTeamsNotificationTargetConfig, MicrosoftTeamsDeliveryMethodNotificationTemplate, NotificationProcessingContext)}
   */
  @Test
  @DisplayName("Test sendNotification(MicrosoftTeamsNotificationTargetConfig, MicrosoftTeamsDeliveryMethodNotificationTemplate, NotificationProcessingContext) with 'MicrosoftTeamsNotificationTargetConfig', 'MicrosoftTeamsDeliveryMethodNotificationTemplate', 'NotificationProcessingContext'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void MicrosoftTeamsNotificationChannel.sendNotification(MicrosoftTeamsNotificationTargetConfig, MicrosoftTeamsDeliveryMethodNotificationTemplate, NotificationProcessingContext)"})
  void testSendNotificationWithMicrosoftTeamsNotificationTargetConfigMicrosoftTeamsDeliveryMethodNotificationTemplateNotificationProcessingContext3()
      throws Exception {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      mockInetAddress.when(() -> InetAddress.getAllByName(Mockito.<String>any()))
          .thenReturn(new InetAddress[]{mock(InetAddress.class)});
      MicrosoftTeamsNotificationTargetConfig targetConfig = mock(MicrosoftTeamsNotificationTargetConfig.class);
      when(targetConfig.getUseOldApi()).thenReturn(true);
      doNothing().when(targetConfig).setChannelName(Mockito.<String>any());
      doNothing().when(targetConfig).setUseOldApi(Mockito.<Boolean>any());
      doNothing().when(targetConfig).setWebhookUrl(Mockito.<String>any());
      doNothing().when(targetConfig).setDescription(Mockito.<String>any());
      targetConfig.setChannelName("Channel Name");
      targetConfig.setDescription("The characteristics of someone or something");
      targetConfig.setUseOldApi(true);
      targetConfig.setWebhookUrl("https://example.org/example");
      Button button = mock(Button.class);
      when(button.isSetEntityIdInState()).thenThrow(new IllegalStateException("message"));
      when(button.getLinkType()).thenReturn(LinkType.DASHBOARD);
      when(button.isEnabled()).thenReturn(true);
      MicrosoftTeamsDeliveryMethodNotificationTemplate processedTemplate = mock(
          MicrosoftTeamsDeliveryMethodNotificationTemplate.class);
      when(processedTemplate.getBody()).thenReturn("Not all who wander are lost");
      when(processedTemplate.getSubject()).thenReturn("Hello from the Dreaming Spires");
      when(processedTemplate.getThemeColor()).thenReturn("Theme Color");
      when(processedTemplate.getButton()).thenReturn(button);

      // Act and Assert
      assertThrows(IllegalStateException.class,
          () -> microsoftTeamsNotificationChannel.sendNotification(targetConfig, processedTemplate, null));
      verify(targetConfig, atLeast(1)).getUseOldApi();
      verify(targetConfig).setChannelName(eq("Channel Name"));
      verify(targetConfig).setUseOldApi(eq(true));
      verify(targetConfig).setWebhookUrl(eq("https://example.org/example"));
      verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
      verify(processedTemplate).getBody();
      verify(processedTemplate, atLeast(1)).getButton();
      verify(processedTemplate, atLeast(1)).getSubject();
      verify(processedTemplate).getThemeColor();
      verify(button).getLinkType();
      verify(button).isEnabled();
      verify(button).isSetEntityIdInState();
    }
  }
}
