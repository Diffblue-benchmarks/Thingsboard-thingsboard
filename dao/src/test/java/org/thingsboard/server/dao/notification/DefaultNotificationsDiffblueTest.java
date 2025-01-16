package org.thingsboard.server.dao.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.rule.DefaultNotificationRuleRecipientsConfig;
import org.thingsboard.server.common.data.notification.rule.EscalatedNotificationRuleRecipientsConfig;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.NotificationRuleRecipientsConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.data.notification.template.DeliveryMethodNotificationTemplate;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.notification.template.TemplatableValue;
import org.thingsboard.server.common.data.notification.template.WebDeliveryMethodNotificationTemplate;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.notification.DefaultNotifications.DefaultNotification;
import org.thingsboard.server.dao.notification.DefaultNotifications.DefaultNotification.DefaultNotificationBuilder;
import org.thingsboard.server.dao.notification.DefaultNotifications.DefaultRule;
import org.thingsboard.server.dao.notification.DefaultNotifications.DefaultRule.DefaultRuleBuilder;

@ContextConfiguration(classes = {DefaultNotifications.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class DefaultNotificationsDiffblueTest {
  @Autowired
  private DefaultNotifications defaultNotifications;

  @MockBean
  private NotificationRuleService notificationRuleService;

  @MockBean
  private NotificationTemplateService notificationTemplateService;

  /**
   * Test
   * {@link DefaultNotifications#create(TenantId, DefaultNotification, NotificationTargetId[])}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications#create(TenantId, DefaultNotifications.DefaultNotification, NotificationTargetId[])}
   */
  @Test
  public void testCreate() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(Mockito.<TenantId>any(),
        Mockito.<NotificationTemplate>any())).thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotifications.DefaultNotification defaultNotification = new DefaultNotifications.DefaultNotification("Name",
        NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link", rule);

    // Act
    defaultNotifications.create(ModelConstants.SYSTEM_TENANT, defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    verify(notificationRuleService).saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService).saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test
   * {@link DefaultNotifications#create(TenantId, DefaultNotification, NotificationTargetId[])}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications#create(TenantId, DefaultNotifications.DefaultNotification, NotificationTargetId[])}
   */
  @Test
  public void testCreate2() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(Mockito.<TenantId>any(),
        Mockito.<NotificationTemplate>any())).thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotifications.DefaultNotification defaultNotification = new DefaultNotifications.DefaultNotification("Name",
        null, "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link", rule);

    // Act
    defaultNotifications.create(ModelConstants.SYSTEM_TENANT, defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    verify(notificationRuleService).saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService).saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test
   * {@link DefaultNotifications#create(TenantId, DefaultNotification, NotificationTargetId[])}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications#create(TenantId, DefaultNotifications.DefaultNotification, NotificationTargetId[])}
   */
  @Test
  public void testCreate3() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(Mockito.<TenantId>any(),
        Mockito.<NotificationTemplate>any())).thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotifications.DefaultNotification defaultNotification = new DefaultNotifications.DefaultNotification("Name",
        NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", null, "Color", "Button", "Link", rule);

    // Act
    defaultNotifications.create(ModelConstants.SYSTEM_TENANT, defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    verify(notificationRuleService).saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService).saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test
   * {@link DefaultNotifications#create(TenantId, DefaultNotification, NotificationTargetId[])}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications#create(TenantId, DefaultNotifications.DefaultNotification, NotificationTargetId[])}
   */
  @Test
  public void testCreate4() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(Mockito.<TenantId>any(),
        Mockito.<NotificationTemplate>any())).thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotifications.DefaultNotification defaultNotification = new DefaultNotifications.DefaultNotification("Name",
        NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", null, "Button", "Link", rule);

    // Act
    defaultNotifications.create(ModelConstants.SYSTEM_TENANT, defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    verify(notificationRuleService).saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService).saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test
   * {@link DefaultNotifications#create(TenantId, DefaultNotification, NotificationTargetId[])}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications#create(TenantId, DefaultNotifications.DefaultNotification, NotificationTargetId[])}
   */
  @Test
  public void testCreate5() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(Mockito.<TenantId>any(),
        Mockito.<NotificationTemplate>any())).thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotifications.DefaultNotification defaultNotification = new DefaultNotifications.DefaultNotification("Name",
        NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", "Color", null, "Link", rule);

    // Act
    defaultNotifications.create(ModelConstants.SYSTEM_TENANT, defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    verify(notificationRuleService).saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService).saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test
   * {@link DefaultNotifications#create(TenantId, DefaultNotification, NotificationTargetId[])}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications#create(TenantId, DefaultNotifications.DefaultNotification, NotificationTargetId[])}
   */
  @Test
  public void testCreate6() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(Mockito.<TenantId>any(),
        Mockito.<NotificationTemplate>any())).thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotifications.DefaultNotification defaultNotification = new DefaultNotifications.DefaultNotification("Name",
        NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", null, rule);

    // Act
    defaultNotifications.create(ModelConstants.SYSTEM_TENANT, defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    verify(notificationRuleService).saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService).saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test
   * {@link DefaultNotifications#create(TenantId, DefaultNotification, NotificationTargetId[])}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications#create(TenantId, DefaultNotifications.DefaultNotification, NotificationTargetId[])}
   */
  @Test
  public void testCreate7() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(Mockito.<TenantId>any(),
        Mockito.<NotificationTemplate>any())).thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(false)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotifications.DefaultNotification defaultNotification = new DefaultNotifications.DefaultNotification("Name",
        NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link", rule);

    // Act
    defaultNotifications.create(ModelConstants.SYSTEM_TENANT, defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    verify(notificationRuleService).saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService).saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test
   * {@link DefaultNotifications#create(TenantId, DefaultNotification, NotificationTargetId[])}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications#create(TenantId, DefaultNotifications.DefaultNotification, NotificationTargetId[])}
   */
  @Test
  public void testCreate8() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(Mockito.<TenantId>any(),
        Mockito.<NotificationTemplate>any())).thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(null)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotifications.DefaultNotification defaultNotification = new DefaultNotifications.DefaultNotification("Name",
        NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link", rule);

    // Act
    defaultNotifications.create(ModelConstants.SYSTEM_TENANT, defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    verify(notificationRuleService).saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService).saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test
   * {@link DefaultNotifications#create(TenantId, DefaultNotification, NotificationTargetId[])}.
   * <ul>
   *   <li>Given {@code ALARM}.</li>
   *   <li>When {@link NotificationRuleTriggerConfig}
   * {@link NotificationRuleTriggerConfig#getTriggerType()} return
   * {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications#create(TenantId, DefaultNotifications.DefaultNotification, NotificationTargetId[])}
   */
  @Test
  public void testCreate_givenAlarm_whenNotificationRuleTriggerConfigGetTriggerTypeReturnAlarm() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(Mockito.<TenantId>any(),
        Mockito.<NotificationTemplate>any())).thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ALARM);
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotifications.DefaultNotification defaultNotification = new DefaultNotifications.DefaultNotification("Name",
        NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link", rule);

    // Act
    defaultNotifications.create(ModelConstants.SYSTEM_TENANT, defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    verify(notificationRuleService).saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService).saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test
   * {@link DefaultNotifications#create(TenantId, DefaultNotification, NotificationTargetId[])}.
   * <ul>
   *   <li>Given {@link NotificationRule#NotificationRule()}.</li>
   *   <li>Then calls
   * {@link DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications#create(TenantId, DefaultNotifications.DefaultNotification, NotificationTargetId[])}
   */
  @Test
  public void testCreate_givenNotificationRule_thenCallsToRule() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(Mockito.<TenantId>any(),
        Mockito.<NotificationTemplate>any())).thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());
    DefaultNotifications.DefaultNotification defaultNotification = mock(DefaultNotifications.DefaultNotification.class);
    when(defaultNotification.toRule(Mockito.<NotificationTemplateId>any(), isA(NotificationTargetId[].class)))
        .thenReturn(new NotificationRule());
    DefaultNotifications.DefaultRule buildResult = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    when(defaultNotification.getRule()).thenReturn(buildResult);
    when(defaultNotification.toTemplate()).thenReturn(new NotificationTemplate());

    // Act
    defaultNotifications.create(ModelConstants.SYSTEM_TENANT, defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(defaultNotification).getRule();
    verify(defaultNotification).toRule(isNull(), isA(NotificationTargetId[].class));
    verify(defaultNotification).toTemplate();
    verify(notificationRuleService).saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService).saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test
   * {@link DefaultNotifications#create(TenantId, DefaultNotification, NotificationTargetId[])}.
   * <ul>
   *   <li>Given {@link NotificationTemplate#NotificationTemplate()}.</li>
   *   <li>Then calls {@link DefaultNotification#getRule()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications#create(TenantId, DefaultNotifications.DefaultNotification, NotificationTargetId[])}
   */
  @Test
  public void testCreate_givenNotificationTemplate_thenCallsGetRule() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(Mockito.<TenantId>any(),
        Mockito.<NotificationTemplate>any())).thenReturn(new NotificationTemplate());
    DefaultNotifications.DefaultNotification defaultNotification = mock(DefaultNotifications.DefaultNotification.class);
    DefaultNotifications.DefaultRule buildResult = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    when(defaultNotification.getRule()).thenReturn(buildResult);
    when(defaultNotification.toTemplate()).thenReturn(new NotificationTemplate());

    // Act
    defaultNotifications.create(ModelConstants.SYSTEM_TENANT, defaultNotification);

    // Assert
    verify(defaultNotification).getRule();
    verify(defaultNotification).toTemplate();
    verify(notificationTemplateService).saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}, and
   * {@link DefaultNotification#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultNotifications.DefaultNotification#equals(Object)}
   *   <li>{@link DefaultNotifications.DefaultNotification#hashCode()}
   * </ul>
   */
  @Test
  public void testDefaultNotificationEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult2 = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult2 = nameResult2.rule(rule2)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.button(Mockito.<String>any()))
        .thenReturn(DefaultNotifications.DefaultNotification.builder());
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = defaultNotificationBuilder
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult2 = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult2 = nameResult2.rule(rule2)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.color(Mockito.<String>any()))
        .thenReturn(DefaultNotifications.DefaultNotification.builder());
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder2 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = defaultNotificationBuilder2
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult2 = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult2 = nameResult2.rule(rule2)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any()))
        .thenReturn(DefaultNotifications.DefaultNotification.builder());
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder2 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder3 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = defaultNotificationBuilder3
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult2 = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult2 = nameResult2.rule(rule2)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any()))
        .thenReturn(DefaultNotifications.DefaultNotification.builder());
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder2 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder3 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = defaultNotificationBuilder3
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Hello from the Dreaming Spires");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult2 = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult2 = nameResult2.rule(rule2)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any()))
        .thenReturn(DefaultNotifications.DefaultNotification.builder());
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder2 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder3 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = defaultNotificationBuilder3
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name(null);
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult2 = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult2 = nameResult2.rule(rule2)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any()))
        .thenReturn(DefaultNotifications.DefaultNotification.builder());
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder2 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder3 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = defaultNotificationBuilder3
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Name")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult2 = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult2 = nameResult2.rule(rule2)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any()))
        .thenReturn(DefaultNotifications.DefaultNotification.builder());
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder2 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder3 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = defaultNotificationBuilder3
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject(null)
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult2 = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult2 = nameResult2.rule(rule2)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any()))
        .thenReturn(DefaultNotifications.DefaultNotification.builder());
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder2 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder3 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = defaultNotificationBuilder3
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Name")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult2 = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult2 = nameResult2.rule(rule2)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any()))
        .thenReturn(DefaultNotifications.DefaultNotification.builder());
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder2 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder3 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = defaultNotificationBuilder3
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text(null)
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult2 = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult2 = nameResult2.rule(rule2)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any()))
        .thenReturn(DefaultNotifications.DefaultNotification.builder());
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder2 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder3 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = defaultNotificationBuilder3
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(null)
        .build();
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult2 = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult2 = nameResult2.rule(rule2)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any()))
        .thenReturn(DefaultNotifications.DefaultNotification.builder());
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder2 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder3 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = defaultNotificationBuilder3
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.ALARM)
        .build();
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult2 = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult2 = nameResult2.rule(rule2)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any()))
        .thenReturn(DefaultNotifications.DefaultNotification.builder());
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder2 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder3 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = defaultNotificationBuilder3
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult2 = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon(null)
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult2 = nameResult2.rule(rule2)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder builderResult = DefaultNotifications.DefaultNotification
        .builder();
    builderResult.icon("Name");
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any())).thenReturn(builderResult);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder2 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder3 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = defaultNotificationBuilder3
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult2 = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult2 = nameResult2.rule(rule2)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any()))
        .thenReturn(DefaultNotifications.DefaultNotification.builder());
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder2 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder defaultNotificationBuilder3 = mock(
        DefaultNotifications.DefaultNotification.DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = defaultNotificationBuilder3
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name(null);
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult2 = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name(null);
    DefaultNotifications.DefaultRule rule2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult2 = nameResult2.rule(rule2)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#equals(Object)}
   */
  @Test
  public void testDefaultNotificationEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to DefaultNotification");
  }

  /**
   * Test DefaultNotification getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DefaultNotifications.DefaultNotification#DefaultNotification(String, NotificationType, String, String, String, String, String, String, DefaultNotifications.DefaultRule)}
   *   <li>{@link DefaultNotifications.DefaultNotification#toString()}
   *   <li>{@link DefaultNotifications.DefaultNotification#getButton()}
   *   <li>{@link DefaultNotifications.DefaultNotification#getColor()}
   *   <li>{@link DefaultNotifications.DefaultNotification#getIcon()}
   *   <li>{@link DefaultNotifications.DefaultNotification#getLink()}
   *   <li>{@link DefaultNotifications.DefaultNotification#getName()}
   *   <li>{@link DefaultNotifications.DefaultNotification#getRule()}
   *   <li>{@link DefaultNotifications.DefaultNotification#getSubject()}
   *   <li>{@link DefaultNotifications.DefaultNotification#getText()}
   *   <li>{@link DefaultNotifications.DefaultNotification#getType()}
   *   <li>{@link DefaultNotifications.DefaultNotification#toBuilder()}
   * </ul>
   */
  @Test
  public void testDefaultNotificationGettersAndSetters() {
    // Arrange
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act
    DefaultNotifications.DefaultNotification actualDefaultNotification = new DefaultNotifications.DefaultNotification(
        "Name", NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link",
        rule);
    actualDefaultNotification.toString();
    String actualButton = actualDefaultNotification.getButton();
    String actualColor = actualDefaultNotification.getColor();
    String actualIcon = actualDefaultNotification.getIcon();
    String actualLink = actualDefaultNotification.getLink();
    String actualName = actualDefaultNotification.getName();
    DefaultNotifications.DefaultRule actualRule = actualDefaultNotification.getRule();
    String actualSubject = actualDefaultNotification.getSubject();
    String actualText = actualDefaultNotification.getText();
    NotificationType actualType = actualDefaultNotification.getType();
    actualDefaultNotification.toBuilder();

    // Assert
    assertEquals("Button", actualButton);
    assertEquals("Color", actualColor);
    assertEquals("Hello from the Dreaming Spires", actualSubject);
    assertEquals("Icon", actualIcon);
    assertEquals("Link", actualLink);
    assertEquals("Name", actualName);
    assertEquals("Text", actualText);
    assertEquals(NotificationType.GENERAL, actualType);
    assertSame(rule, actualRule);
  }

  /**
   * Test DefaultNotification
   * {@link DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}
   */
  @Test
  public void testDefaultNotificationToRule() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(null)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotifications.DefaultNotification defaultNotification = new DefaultNotifications.DefaultNotification("Name",
        NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link", rule);
    NotificationTemplateId templateId = new NotificationTemplateId(ModelConstants.NULL_UUID);

    // Act
    NotificationRule actualToRuleResult = defaultNotification.toRule(templateId,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    NotificationRuleRecipientsConfig recipientsConfig = actualToRuleResult.getRecipientsConfig();
    assertTrue(recipientsConfig instanceof DefaultNotificationRuleRecipientsConfig);
    List<UUID> targets = ((DefaultNotificationRuleRecipientsConfig) recipientsConfig).getTargets();
    assertEquals(1, targets.size());
    Map<Integer, List<UUID>> targetsTable = recipientsConfig.getTargetsTable();
    assertEquals(1, targetsTable.size());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualToRuleResult.getTriggerType());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, recipientsConfig.getTriggerType());
    assertTrue(actualToRuleResult.isEnabled());
    assertSame(targets, targetsTable.get(0));
  }

  /**
   * Test DefaultNotification
   * {@link DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}
   */
  @Test
  public void testDefaultNotificationToRule2() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ALARM);
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotifications.DefaultNotification defaultNotification = new DefaultNotifications.DefaultNotification("Name",
        NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link", rule);
    NotificationTemplateId templateId = new NotificationTemplateId(ModelConstants.NULL_UUID);

    // Act
    NotificationRule actualToRuleResult = defaultNotification.toRule(templateId,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    NotificationRuleRecipientsConfig recipientsConfig = actualToRuleResult.getRecipientsConfig();
    assertTrue(recipientsConfig instanceof EscalatedNotificationRuleRecipientsConfig);
    Map<Integer, List<UUID>> escalationTable = ((EscalatedNotificationRuleRecipientsConfig) recipientsConfig)
        .getEscalationTable();
    assertEquals(1, escalationTable.size());
    assertEquals(1, escalationTable.get(0).size());
    assertEquals(NotificationRuleTriggerType.ALARM, actualToRuleResult.getTriggerType());
    assertEquals(NotificationRuleTriggerType.ALARM, recipientsConfig.getTriggerType());
    assertSame(escalationTable, recipientsConfig.getTargetsTable());
  }

  /**
   * Test DefaultNotification
   * {@link DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}.
   * <ul>
   *   <li>Then return Enabled.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}
   */
  @Test
  public void testDefaultNotificationToRule_thenReturnEnabled() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotifications.DefaultNotification defaultNotification = new DefaultNotifications.DefaultNotification("Name",
        NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link", rule);
    NotificationTemplateId templateId = new NotificationTemplateId(ModelConstants.NULL_UUID);

    // Act
    NotificationRule actualToRuleResult = defaultNotification.toRule(templateId,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    NotificationRuleRecipientsConfig recipientsConfig = actualToRuleResult.getRecipientsConfig();
    assertTrue(recipientsConfig instanceof DefaultNotificationRuleRecipientsConfig);
    List<UUID> targets = ((DefaultNotificationRuleRecipientsConfig) recipientsConfig).getTargets();
    assertEquals(1, targets.size());
    Map<Integer, List<UUID>> targetsTable = recipientsConfig.getTargetsTable();
    assertEquals(1, targetsTable.size());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualToRuleResult.getTriggerType());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, recipientsConfig.getTriggerType());
    assertTrue(actualToRuleResult.isEnabled());
    assertSame(targets, targetsTable.get(0));
  }

  /**
   * Test DefaultNotification
   * {@link DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}.
   * <ul>
   *   <li>Then return not Enabled.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}
   */
  @Test
  public void testDefaultNotificationToRule_thenReturnNotEnabled() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(false)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotifications.DefaultNotification defaultNotification = new DefaultNotifications.DefaultNotification("Name",
        NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link", rule);
    NotificationTemplateId templateId = new NotificationTemplateId(ModelConstants.NULL_UUID);

    // Act
    NotificationRule actualToRuleResult = defaultNotification.toRule(templateId,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    NotificationRuleRecipientsConfig recipientsConfig = actualToRuleResult.getRecipientsConfig();
    assertTrue(recipientsConfig instanceof DefaultNotificationRuleRecipientsConfig);
    List<UUID> targets = ((DefaultNotificationRuleRecipientsConfig) recipientsConfig).getTargets();
    assertEquals(1, targets.size());
    Map<Integer, List<UUID>> targetsTable = recipientsConfig.getTargetsTable();
    assertEquals(1, targetsTable.size());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualToRuleResult.getTriggerType());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, recipientsConfig.getTriggerType());
    assertFalse(actualToRuleResult.isEnabled());
    assertSame(targets, targetsTable.get(0));
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toTemplate()}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#toTemplate()}
   */
  @Test
  public void testDefaultNotificationToTemplate() {
    // Arrange
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = (new DefaultNotifications.DefaultNotification(
        "Name", NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link",
        rule)).toTemplate().getConfiguration().getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates.get(NotificationDeliveryMethod.WEB);
    JsonNode additionalConfig = ((WebDeliveryMethodNotificationTemplate) getResult).getAdditionalConfig();
    Iterator<JsonNode> iteratorResult = additionalConfig.iterator();
    JsonNode nextResult = iteratorResult.next();
    Iterator<JsonNode> iteratorResult2 = nextResult.iterator();
    JsonNode nextResult2 = iteratorResult2.next();
    assertTrue(nextResult2 instanceof BooleanNode);
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(additionalConfig instanceof ObjectNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalConfig.traverse() instanceof TreeTraversingParser);
    assertTrue(getResult instanceof WebDeliveryMethodNotificationTemplate);
    assertTrue(iteratorResult2.hasNext());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toTemplate()}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#toTemplate()}
   */
  @Test
  public void testDefaultNotificationToTemplate2() {
    // Arrange
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = (new DefaultNotifications.DefaultNotification(
        "Name", null, "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link", rule)).toTemplate()
        .getConfiguration()
        .getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates.get(NotificationDeliveryMethod.WEB);
    JsonNode additionalConfig = ((WebDeliveryMethodNotificationTemplate) getResult).getAdditionalConfig();
    Iterator<JsonNode> iteratorResult = additionalConfig.iterator();
    JsonNode nextResult = iteratorResult.next();
    Iterator<JsonNode> iteratorResult2 = nextResult.iterator();
    JsonNode nextResult2 = iteratorResult2.next();
    assertTrue(nextResult2 instanceof BooleanNode);
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(additionalConfig instanceof ObjectNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalConfig.traverse() instanceof TreeTraversingParser);
    assertTrue(getResult instanceof WebDeliveryMethodNotificationTemplate);
    assertTrue(iteratorResult2.hasNext());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toTemplate()}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#toTemplate()}
   */
  @Test
  public void testDefaultNotificationToTemplate3() {
    // Arrange
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = (new DefaultNotifications.DefaultNotification(
        "Name", NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", null, "Color", "Button", "Link",
        rule)).toTemplate().getConfiguration().getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates.get(NotificationDeliveryMethod.WEB);
    JsonNode additionalConfig = ((WebDeliveryMethodNotificationTemplate) getResult).getAdditionalConfig();
    Iterator<JsonNode> iteratorResult = additionalConfig.iterator();
    JsonNode nextResult = iteratorResult.next();
    Iterator<JsonNode> iteratorResult2 = nextResult.iterator();
    JsonNode nextResult2 = iteratorResult2.next();
    assertTrue(nextResult2 instanceof BooleanNode);
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(additionalConfig instanceof ObjectNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalConfig.traverse() instanceof TreeTraversingParser);
    assertTrue(getResult instanceof WebDeliveryMethodNotificationTemplate);
    assertEquals("{\r\n  \"enabled\" : false\r\n}", nextResult.toPrettyString());
    assertEquals("{\r\n" + "  \"icon\" : {\r\n" + "    \"enabled\" : false\r\n" + "  },\r\n"
        + "  \"actionButtonConfig\" : {\r\n" + "    \"enabled\" : true,\r\n" + "    \"text\" : \"Button\",\r\n"
        + "    \"linkType\" : \"LINK\",\r\n" + "    \"link\" : \"Link\"\r\n" + "  }\r\n" + "}",
        additionalConfig.toPrettyString());
    assertEquals(1, nextResult.size());
    assertFalse(iteratorResult2.hasNext());
    assertTrue(iteratorResult.hasNext());
    String expectedToPrettyStringResult = Boolean.FALSE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult2.toPrettyString());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toTemplate()}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#toTemplate()}
   */
  @Test
  public void testDefaultNotificationToTemplate4() {
    // Arrange
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = (new DefaultNotifications.DefaultNotification(
        "Name", NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "", "Color", "Button", "Link",
        rule)).toTemplate().getConfiguration().getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates.get(NotificationDeliveryMethod.WEB);
    JsonNode additionalConfig = ((WebDeliveryMethodNotificationTemplate) getResult).getAdditionalConfig();
    Iterator<JsonNode> iteratorResult = additionalConfig.iterator();
    JsonNode nextResult = iteratorResult.next();
    Iterator<JsonNode> iteratorResult2 = nextResult.iterator();
    JsonNode nextResult2 = iteratorResult2.next();
    assertTrue(nextResult2 instanceof BooleanNode);
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(additionalConfig instanceof ObjectNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalConfig.traverse() instanceof TreeTraversingParser);
    assertTrue(getResult instanceof WebDeliveryMethodNotificationTemplate);
    assertEquals("{\r\n  \"enabled\" : true,\r\n  \"icon\" : \"\",\r\n  \"color\" : \"Color\"\r\n}",
        nextResult.toPrettyString());
    assertEquals("{\r\n" + "  \"icon\" : {\r\n" + "    \"enabled\" : true,\r\n" + "    \"icon\" : \"\",\r\n"
        + "    \"color\" : \"Color\"\r\n" + "  },\r\n" + "  \"actionButtonConfig\" : {\r\n"
        + "    \"enabled\" : true,\r\n" + "    \"text\" : \"Button\",\r\n" + "    \"linkType\" : \"LINK\",\r\n"
        + "    \"link\" : \"Link\"\r\n" + "  }\r\n" + "}", additionalConfig.toPrettyString());
    assertTrue(iteratorResult2.hasNext());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toTemplate()}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#toTemplate()}
   */
  @Test
  public void testDefaultNotificationToTemplate5() {
    // Arrange
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = (new DefaultNotifications.DefaultNotification(
        "Name", NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", null, "Button", "Link",
        rule)).toTemplate().getConfiguration().getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates.get(NotificationDeliveryMethod.WEB);
    JsonNode additionalConfig = ((WebDeliveryMethodNotificationTemplate) getResult).getAdditionalConfig();
    Iterator<JsonNode> iteratorResult = additionalConfig.iterator();
    JsonNode nextResult = iteratorResult.next();
    Iterator<JsonNode> iteratorResult2 = nextResult.iterator();
    JsonNode nextResult2 = iteratorResult2.next();
    assertTrue(nextResult2 instanceof BooleanNode);
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(additionalConfig instanceof ObjectNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalConfig.traverse() instanceof TreeTraversingParser);
    assertTrue(getResult instanceof WebDeliveryMethodNotificationTemplate);
    assertEquals("{\r\n  \"enabled\" : true,\r\n  \"icon\" : \"Icon\",\r\n  \"color\" : \"#757575\"\r\n}",
        nextResult.toPrettyString());
    assertEquals("{\r\n" + "  \"icon\" : {\r\n" + "    \"enabled\" : true,\r\n" + "    \"icon\" : \"Icon\",\r\n"
        + "    \"color\" : \"#757575\"\r\n" + "  },\r\n" + "  \"actionButtonConfig\" : {\r\n"
        + "    \"enabled\" : true,\r\n" + "    \"text\" : \"Button\",\r\n" + "    \"linkType\" : \"LINK\",\r\n"
        + "    \"link\" : \"Link\"\r\n" + "  }\r\n" + "}", additionalConfig.toPrettyString());
    assertTrue(iteratorResult2.hasNext());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toTemplate()}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#toTemplate()}
   */
  @Test
  public void testDefaultNotificationToTemplate6() {
    // Arrange
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = (new DefaultNotifications.DefaultNotification(
        "Name", NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", "Color", null, "Link",
        rule)).toTemplate().getConfiguration().getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates.get(NotificationDeliveryMethod.WEB);
    JsonNode additionalConfig = ((WebDeliveryMethodNotificationTemplate) getResult).getAdditionalConfig();
    Iterator<JsonNode> iteratorResult = additionalConfig.iterator();
    JsonNode nextResult = iteratorResult.next();
    Iterator<JsonNode> iteratorResult2 = nextResult.iterator();
    JsonNode nextResult2 = iteratorResult2.next();
    assertTrue(nextResult2 instanceof BooleanNode);
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(additionalConfig instanceof ObjectNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalConfig.traverse() instanceof TreeTraversingParser);
    assertTrue(getResult instanceof WebDeliveryMethodNotificationTemplate);
    assertEquals("{\r\n" + "  \"icon\" : {\r\n" + "    \"enabled\" : true,\r\n" + "    \"icon\" : \"Icon\",\r\n"
        + "    \"color\" : \"Color\"\r\n" + "  },\r\n" + "  \"actionButtonConfig\" : {\r\n"
        + "    \"enabled\" : false\r\n" + "  }\r\n" + "}", additionalConfig.toPrettyString());
    List<TemplatableValue> templatableValues = getResult.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(2).get());
    assertNull(((WebDeliveryMethodNotificationTemplate) getResult).getButtonText());
    assertTrue(iteratorResult2.hasNext());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toTemplate()}.
   * <p>
   * Method under test:
   * {@link DefaultNotifications.DefaultNotification#toTemplate()}
   */
  @Test
  public void testDefaultNotificationToTemplate7() {
    // Arrange
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = (new DefaultNotifications.DefaultNotification(
        "Name", NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", null,
        rule)).toTemplate().getConfiguration().getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates.get(NotificationDeliveryMethod.WEB);
    JsonNode additionalConfig = ((WebDeliveryMethodNotificationTemplate) getResult).getAdditionalConfig();
    Iterator<JsonNode> iteratorResult = additionalConfig.iterator();
    JsonNode nextResult = iteratorResult.next();
    Iterator<JsonNode> iteratorResult2 = nextResult.iterator();
    JsonNode nextResult2 = iteratorResult2.next();
    assertTrue(nextResult2 instanceof BooleanNode);
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(additionalConfig instanceof ObjectNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalConfig.traverse() instanceof TreeTraversingParser);
    assertTrue(getResult instanceof WebDeliveryMethodNotificationTemplate);
    assertEquals("{\r\n" + "  \"icon\" : {\r\n" + "    \"enabled\" : true,\r\n" + "    \"icon\" : \"Icon\",\r\n"
        + "    \"color\" : \"Color\"\r\n" + "  },\r\n" + "  \"actionButtonConfig\" : {\r\n"
        + "    \"enabled\" : true,\r\n" + "    \"text\" : \"Button\",\r\n" + "    \"linkType\" : \"LINK\",\r\n"
        + "    \"link\" : null\r\n" + "  }\r\n" + "}", additionalConfig.toPrettyString());
    assertTrue(iteratorResult2.hasNext());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test DefaultNotification_DefaultNotificationBuilder
   * {@link DefaultNotificationBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DefaultNotifications.DefaultNotification.DefaultNotificationBuilder#build()}
   *   <li>
   * {@link DefaultNotifications.DefaultNotification.DefaultNotificationBuilder#button(String)}
   *   <li>
   * {@link DefaultNotifications.DefaultNotification.DefaultNotificationBuilder#color(String)}
   *   <li>
   * {@link DefaultNotifications.DefaultNotification.DefaultNotificationBuilder#icon(String)}
   *   <li>
   * {@link DefaultNotifications.DefaultNotification.DefaultNotificationBuilder#link(String)}
   *   <li>
   * {@link DefaultNotifications.DefaultNotification.DefaultNotificationBuilder#name(String)}
   *   <li>
   * {@link DefaultNotifications.DefaultNotification.DefaultNotificationBuilder#rule(DefaultNotifications.DefaultRule)}
   *   <li>
   * {@link DefaultNotifications.DefaultNotification.DefaultNotificationBuilder#subject(String)}
   *   <li>
   * {@link DefaultNotifications.DefaultNotification.DefaultNotificationBuilder#text(String)}
   *   <li>
   * {@link DefaultNotifications.DefaultNotification.DefaultNotificationBuilder#type(NotificationType)}
   * </ul>
   */
  @Test
  public void testDefaultNotification_DefaultNotificationBuilderBuild() {
    // Arrange
    DefaultNotifications.DefaultNotification.DefaultNotificationBuilder nameResult = DefaultNotifications.DefaultNotification
        .builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultNotifications.DefaultRule rule = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act
    DefaultNotifications.DefaultNotification actualBuildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    // Assert
    assertEquals("Button", actualBuildResult.getButton());
    assertEquals("Color", actualBuildResult.getColor());
    assertEquals("Hello from the Dreaming Spires", actualBuildResult.getSubject());
    assertEquals("Icon", actualBuildResult.getIcon());
    assertEquals("Link", actualBuildResult.getLink());
    assertEquals("Name", actualBuildResult.getName());
    DefaultNotifications.DefaultRule rule2 = actualBuildResult.getRule();
    assertEquals("Name", rule2.getName());
    assertEquals("Text", actualBuildResult.getText());
    assertEquals("The characteristics of someone or something", rule2.getDescription());
    assertEquals(NotificationType.GENERAL, actualBuildResult.getType());
    assertTrue(rule2.getEnabled());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}, and
   * {@link DefaultRule#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultNotifications.DefaultRule#equals(Object)}
   *   <li>{@link DefaultNotifications.DefaultRule#hashCode()}
   * </ul>
   */
  @Test
  public void testDefaultRuleEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultNotifications.DefaultRule buildResult = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(null)
        .build();
    DefaultNotifications.DefaultRule buildResult2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(null)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}, and
   * {@link DefaultRule#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultNotifications.DefaultRule#equals(Object)}
   *   <li>{@link DefaultNotifications.DefaultRule#hashCode()}
   * </ul>
   */
  @Test
  public void testDefaultRuleEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DefaultNotifications.DefaultRule.DefaultRuleBuilder defaultRuleBuilder = mock(
        DefaultNotifications.DefaultRule.DefaultRuleBuilder.class);
    when(defaultRuleBuilder.description(Mockito.<String>any())).thenReturn(DefaultNotifications.DefaultRule.builder());
    DefaultNotifications.DefaultRule buildResult = defaultRuleBuilder
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(null)
        .build();
    DefaultNotifications.DefaultRule.DefaultRuleBuilder defaultRuleBuilder2 = mock(
        DefaultNotifications.DefaultRule.DefaultRuleBuilder.class);
    when(defaultRuleBuilder2.description(Mockito.<String>any())).thenReturn(DefaultNotifications.DefaultRule.builder());
    DefaultNotifications.DefaultRule buildResult2 = defaultRuleBuilder2
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(null)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}, and
   * {@link DefaultRule#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultNotifications.DefaultRule#equals(Object)}
   *   <li>{@link DefaultNotifications.DefaultRule#hashCode()}
   * </ul>
   */
  @Test
  public void testDefaultRuleEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultNotifications.DefaultRule buildResult = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotifications.DefaultRule#equals(Object)}
   */
  @Test
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultNotifications.DefaultRule buildResult = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultRule buildResult2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotifications.DefaultRule#equals(Object)}
   */
  @Test
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultNotifications.DefaultRule buildResult = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(false)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultRule buildResult2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotifications.DefaultRule#equals(Object)}
   */
  @Test
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DefaultNotifications.DefaultRule buildResult = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(null)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultRule buildResult2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotifications.DefaultRule#equals(Object)}
   */
  @Test
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DefaultNotifications.DefaultRule buildResult = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name(null)
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultRule buildResult2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotifications.DefaultRule#equals(Object)}
   */
  @Test
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DefaultNotifications.DefaultRule buildResult = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("42")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultRule buildResult2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotifications.DefaultRule#equals(Object)}
   */
  @Test
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DefaultNotifications.DefaultRule buildResult = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(null)
        .build();
    DefaultNotifications.DefaultRule buildResult2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotifications.DefaultRule#equals(Object)}
   */
  @Test
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DefaultNotifications.DefaultRule buildResult = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(null)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultRule buildResult2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(null)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotifications.DefaultRule#equals(Object)}
   */
  @Test
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DefaultNotifications.DefaultRule buildResult = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name(null)
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotifications.DefaultRule buildResult2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name(null)
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotifications.DefaultRule#equals(Object)}
   */
  @Test
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DefaultNotifications.DefaultRule.DefaultRuleBuilder defaultRuleBuilder = mock(
        DefaultNotifications.DefaultRule.DefaultRuleBuilder.class);
    when(defaultRuleBuilder.description(Mockito.<String>any())).thenReturn(DefaultNotifications.DefaultRule.builder());
    DefaultNotifications.DefaultRule buildResult = defaultRuleBuilder
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(null)
        .build();
    DefaultNotifications.DefaultRule buildResult2 = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotifications.DefaultRule#equals(Object)}
   */
  @Test
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DefaultNotifications.DefaultRule.DefaultRuleBuilder builderResult = DefaultNotifications.DefaultRule.builder();
    builderResult.description("The characteristics of someone or something");
    DefaultNotifications.DefaultRule.DefaultRuleBuilder defaultRuleBuilder = mock(
        DefaultNotifications.DefaultRule.DefaultRuleBuilder.class);
    when(defaultRuleBuilder.description(Mockito.<String>any())).thenReturn(builderResult);
    DefaultNotifications.DefaultRule buildResult = defaultRuleBuilder
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(null)
        .build();
    DefaultNotifications.DefaultRule.DefaultRuleBuilder defaultRuleBuilder2 = mock(
        DefaultNotifications.DefaultRule.DefaultRuleBuilder.class);
    when(defaultRuleBuilder2.description(Mockito.<String>any())).thenReturn(DefaultNotifications.DefaultRule.builder());
    DefaultNotifications.DefaultRule buildResult2 = defaultRuleBuilder2
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotifications.DefaultRule#equals(Object)}
   */
  @Test
  public void testDefaultRuleEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DefaultNotifications.DefaultRule buildResult = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotifications.DefaultRule#equals(Object)}
   */
  @Test
  public void testDefaultRuleEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DefaultNotifications.DefaultRule buildResult = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to DefaultRule");
  }

  /**
   * Test DefaultRule getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DefaultNotifications.DefaultRule#DefaultRule(String, Boolean, NotificationRuleTriggerConfig, String)}
   *   <li>{@link DefaultNotifications.DefaultRule#toString()}
   *   <li>{@link DefaultNotifications.DefaultRule#getDescription()}
   *   <li>{@link DefaultNotifications.DefaultRule#getEnabled()}
   *   <li>{@link DefaultNotifications.DefaultRule#getName()}
   *   <li>{@link DefaultNotifications.DefaultRule#getTriggerConfig()}
   *   <li>{@link DefaultNotifications.DefaultRule#toBuilder()}
   * </ul>
   */
  @Test
  public void testDefaultRuleGettersAndSetters() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);

    // Act
    DefaultNotifications.DefaultRule actualDefaultRule = new DefaultNotifications.DefaultRule("Name", true,
        triggerConfig, "The characteristics of someone or something");
    actualDefaultRule.toString();
    String actualDescription = actualDefaultRule.getDescription();
    Boolean actualEnabled = actualDefaultRule.getEnabled();
    String actualName = actualDefaultRule.getName();
    NotificationRuleTriggerConfig actualTriggerConfig = actualDefaultRule.getTriggerConfig();
    actualDefaultRule.toBuilder();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertTrue(actualEnabled);
    assertSame(triggerConfig, actualTriggerConfig);
  }

  /**
   * Test DefaultRule_DefaultRuleBuilder {@link DefaultRuleBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultNotifications.DefaultRule.DefaultRuleBuilder#build()}
   *   <li>
   * {@link DefaultNotifications.DefaultRule.DefaultRuleBuilder#description(String)}
   *   <li>
   * {@link DefaultNotifications.DefaultRule.DefaultRuleBuilder#enabled(Boolean)}
   *   <li>{@link DefaultNotifications.DefaultRule.DefaultRuleBuilder#name(String)}
   *   <li>
   * {@link DefaultNotifications.DefaultRule.DefaultRuleBuilder#triggerConfig(NotificationRuleTriggerConfig)}
   * </ul>
   */
  @Test
  public void testDefaultRule_DefaultRuleBuilderBuild() {
    // Arrange and Act
    DefaultNotifications.DefaultRule actualBuildResult = DefaultNotifications.DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Assert
    assertEquals("Name", actualBuildResult.getName());
    assertEquals("The characteristics of someone or something", actualBuildResult.getDescription());
    assertTrue(actualBuildResult.getEnabled());
  }
}
