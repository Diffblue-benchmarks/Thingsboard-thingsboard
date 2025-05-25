package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.UpdateMessage;
import org.thingsboard.server.common.data.notification.info.NewPlatformVersionNotificationInfo;
import org.thingsboard.server.common.data.notification.info.RuleOriginatedNotificationInfo;
import org.thingsboard.server.common.data.notification.rule.trigger.NewPlatformVersionTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NewPlatformVersionNotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {NewPlatformVersionTriggerProcessor.class})
@ExtendWith(SpringExtension.class)
class NewPlatformVersionTriggerProcessorDiffblueTest {
  @Autowired
  private NewPlatformVersionTriggerProcessor newPlatformVersionTriggerProcessor;

  /**
   * Test {@link NewPlatformVersionTriggerProcessor#matchesFilter(NewPlatformVersionTrigger, NewPlatformVersionNotificationRuleTriggerConfig)} with {@code NewPlatformVersionTrigger}, {@code NewPlatformVersionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link NewPlatformVersionTriggerProcessor#matchesFilter(NewPlatformVersionTrigger, NewPlatformVersionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(NewPlatformVersionTrigger, NewPlatformVersionNotificationRuleTriggerConfig) with 'NewPlatformVersionTrigger', 'NewPlatformVersionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean NewPlatformVersionTriggerProcessor.matchesFilter(NewPlatformVersionTrigger, NewPlatformVersionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithNewPlatformVersionTriggerNewPlatformVersionNotificationRuleTriggerConfig() {
    // Arrange
    NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    NewPlatformVersionTrigger trigger = builderResult
        .updateInfo(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))
        .build();

    // Act and Assert
    assertTrue(newPlatformVersionTriggerProcessor.matchesFilter(trigger,
        new NewPlatformVersionNotificationRuleTriggerConfig()));
  }

  /**
   * Test {@link NewPlatformVersionTriggerProcessor#matchesFilter(NewPlatformVersionTrigger, NewPlatformVersionNotificationRuleTriggerConfig)} with {@code NewPlatformVersionTrigger}, {@code NewPlatformVersionNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link NewPlatformVersionTriggerProcessor#matchesFilter(NewPlatformVersionTrigger, NewPlatformVersionNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(NewPlatformVersionTrigger, NewPlatformVersionNotificationRuleTriggerConfig) with 'NewPlatformVersionTrigger', 'NewPlatformVersionNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean NewPlatformVersionTriggerProcessor.matchesFilter(NewPlatformVersionTrigger, NewPlatformVersionNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithNewPlatformVersionTriggerNewPlatformVersionNotificationRuleTriggerConfig2() {
    // Arrange
    NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    builderResult.updateInfo(new UpdateMessage(false, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"));
    NewPlatformVersionTriggerBuilder newPlatformVersionTriggerBuilder = mock(NewPlatformVersionTriggerBuilder.class);
    when(newPlatformVersionTriggerBuilder.updateInfo(Mockito.<UpdateMessage>any())).thenReturn(builderResult);
    NewPlatformVersionTrigger trigger = newPlatformVersionTriggerBuilder
        .updateInfo(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))
        .build();

    // Act
    boolean actualMatchesFilterResult = newPlatformVersionTriggerProcessor.matchesFilter(trigger,
        new NewPlatformVersionNotificationRuleTriggerConfig());

    // Assert
    verify(newPlatformVersionTriggerBuilder).updateInfo(isA(UpdateMessage.class));
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test {@link NewPlatformVersionTriggerProcessor#constructNotificationInfo(NewPlatformVersionTrigger)} with {@code NewPlatformVersionTrigger}.
   * <p>
   * Method under test: {@link NewPlatformVersionTriggerProcessor#constructNotificationInfo(NewPlatformVersionTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(NewPlatformVersionTrigger) with 'NewPlatformVersionTrigger'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleOriginatedNotificationInfo NewPlatformVersionTriggerProcessor.constructNotificationInfo(NewPlatformVersionTrigger)"})
  void testConstructNotificationInfoWithNewPlatformVersionTrigger() {
    // Arrange
    NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    NewPlatformVersionTrigger trigger = builderResult
        .updateInfo(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))
        .build();

    // Act
    RuleOriginatedNotificationInfo actualConstructNotificationInfoResult = newPlatformVersionTriggerProcessor
        .constructNotificationInfo(trigger);
    Map<String, String> actualTemplateData = actualConstructNotificationInfoResult.getTemplateData();

    // Assert
    assertTrue(actualConstructNotificationInfoResult instanceof NewPlatformVersionNotificationInfo);
    assertEquals("1.0.2",
        ((NewPlatformVersionNotificationInfo) actualConstructNotificationInfoResult).getCurrentVersion());
    assertEquals("1.0.2",
        ((NewPlatformVersionNotificationInfo) actualConstructNotificationInfoResult).getLatestVersion());
    assertEquals("https://example.org/example",
        ((NewPlatformVersionNotificationInfo) actualConstructNotificationInfoResult)
            .getCurrentVersionReleaseNotesUrl());
    assertEquals("https://example.org/example",
        ((NewPlatformVersionNotificationInfo) actualConstructNotificationInfoResult).getLatestVersionReleaseNotesUrl());
    assertEquals("https://example.org/example",
        ((NewPlatformVersionNotificationInfo) actualConstructNotificationInfoResult).getUpgradeInstructionsUrl());
    assertNull(actualConstructNotificationInfoResult.getAffectedCustomerId());
    assertNull(actualConstructNotificationInfoResult.getDashboardId());
    assertNull(actualConstructNotificationInfoResult.getStateEntityId());
    assertNull(actualConstructNotificationInfoResult.getAffectedTenantId());
    assertNull(actualConstructNotificationInfoResult.getAffectedUserId());
    Map<String, String> templateData = actualConstructNotificationInfoResult.getTemplateData();
    assertEquals(5, templateData.size());
    assertTrue(templateData.containsKey("currentVersion"));
    assertTrue(templateData.containsKey("currentVersionReleaseNotesUrl"));
    assertTrue(templateData.containsKey("latestVersion"));
    assertTrue(templateData.containsKey("latestVersionReleaseNotesUrl"));
    assertTrue(templateData.containsKey("upgradeInstructionsUrl"));
    assertEquals(templateData, actualTemplateData);
  }

  /**
   * Test {@link NewPlatformVersionTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test: {@link NewPlatformVersionTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationRuleTriggerType NewPlatformVersionTriggerProcessor.getTriggerType()"})
  void testGetTriggerType() {
    // Arrange, Act and Assert
    assertEquals(NotificationRuleTriggerType.NEW_PLATFORM_VERSION,
        (new NewPlatformVersionTriggerProcessor()).getTriggerType());
  }
}
