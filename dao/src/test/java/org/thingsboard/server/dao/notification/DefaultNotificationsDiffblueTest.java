/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
import org.thingsboard.server.common.data.notification.template.WebDeliveryMethodNotificationTemplate;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.notification.DefaultNotifications.DefaultNotification;
import org.thingsboard.server.dao.notification.DefaultNotifications.DefaultNotification.DefaultNotificationBuilder;
import org.thingsboard.server.dao.notification.DefaultNotifications.DefaultRule;
import org.thingsboard.server.dao.notification.DefaultNotifications.DefaultRule.DefaultRuleBuilder;

@ContextConfiguration(
    classes = {
      DefaultRuleBuilder.class,
      DefaultNotificationBuilder.class,
      DefaultNotifications.class
    })
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultNotificationsDiffblueTest {
  @Autowired private DefaultNotificationBuilder defaultNotificationBuilder;

  @Autowired private DefaultNotifications defaultNotifications;

  @Autowired private DefaultRuleBuilder defaultRuleBuilder;

  @MockBean private NotificationRuleService notificationRuleService;

  @MockBean private NotificationTemplateService notificationTemplateService;

  /**
   * Test {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}.
   *
   * <p>Method under test: {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotifications.create(TenantId, DefaultNotification, NotificationTargetId[])"
  })
  public void testCreate() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(
            Mockito.<TenantId>any(), Mockito.<NotificationTemplate>any()))
        .thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(
            Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());

    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultRule rule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(triggerConfig)
            .build();
    DefaultNotification defaultNotification =
        new DefaultNotification(
            "Name",
            NotificationType.GENERAL,
            "Hello from the Dreaming Spires",
            "Text",
            "Icon",
            "Color",
            "Button",
            "Link",
            rule);

    // Act
    defaultNotifications.create(
        ModelConstants.SYSTEM_TENANT,
        defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    verify(notificationRuleService)
        .saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService)
        .saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}.
   *
   * <p>Method under test: {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotifications.create(TenantId, DefaultNotification, NotificationTargetId[])"
  })
  public void testCreate2() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(
            Mockito.<TenantId>any(), Mockito.<NotificationTemplate>any()))
        .thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(
            Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());

    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultRule rule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(triggerConfig)
            .build();
    DefaultNotification defaultNotification =
        new DefaultNotification(
            "Name",
            null,
            "Hello from the Dreaming Spires",
            "Text",
            "Icon",
            "Color",
            "Button",
            "Link",
            rule);

    // Act
    defaultNotifications.create(
        ModelConstants.SYSTEM_TENANT,
        defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    verify(notificationRuleService)
        .saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService)
        .saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}.
   *
   * <p>Method under test: {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotifications.create(TenantId, DefaultNotification, NotificationTargetId[])"
  })
  public void testCreate3() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(
            Mockito.<TenantId>any(), Mockito.<NotificationTemplate>any()))
        .thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(
            Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());

    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultRule rule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(triggerConfig)
            .build();
    DefaultNotification defaultNotification =
        new DefaultNotification(
            "Name",
            NotificationType.GENERAL,
            "Hello from the Dreaming Spires",
            "Text",
            null,
            "Color",
            "Button",
            "Link",
            rule);

    // Act
    defaultNotifications.create(
        ModelConstants.SYSTEM_TENANT,
        defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    verify(notificationRuleService)
        .saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService)
        .saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}.
   *
   * <p>Method under test: {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotifications.create(TenantId, DefaultNotification, NotificationTargetId[])"
  })
  public void testCreate4() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(
            Mockito.<TenantId>any(), Mockito.<NotificationTemplate>any()))
        .thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(
            Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());

    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultRule rule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(triggerConfig)
            .build();
    DefaultNotification defaultNotification =
        new DefaultNotification(
            "Name",
            NotificationType.GENERAL,
            "Hello from the Dreaming Spires",
            "Text",
            "Icon",
            null,
            "Button",
            "Link",
            rule);

    // Act
    defaultNotifications.create(
        ModelConstants.SYSTEM_TENANT,
        defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    verify(notificationRuleService)
        .saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService)
        .saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}.
   *
   * <p>Method under test: {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotifications.create(TenantId, DefaultNotification, NotificationTargetId[])"
  })
  public void testCreate5() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(
            Mockito.<TenantId>any(), Mockito.<NotificationTemplate>any()))
        .thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(
            Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());

    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultRule rule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(triggerConfig)
            .build();
    DefaultNotification defaultNotification =
        new DefaultNotification(
            "Name",
            NotificationType.GENERAL,
            "Hello from the Dreaming Spires",
            "Text",
            "Icon",
            "Color",
            null,
            "Link",
            rule);

    // Act
    defaultNotifications.create(
        ModelConstants.SYSTEM_TENANT,
        defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    verify(notificationRuleService)
        .saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService)
        .saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}.
   *
   * <p>Method under test: {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotifications.create(TenantId, DefaultNotification, NotificationTargetId[])"
  })
  public void testCreate6() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(
            Mockito.<TenantId>any(), Mockito.<NotificationTemplate>any()))
        .thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(
            Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());

    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultRule rule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(triggerConfig)
            .build();
    DefaultNotification defaultNotification =
        new DefaultNotification(
            "Name",
            NotificationType.GENERAL,
            "Hello from the Dreaming Spires",
            "Text",
            "Icon",
            "Color",
            "Button",
            null,
            rule);

    // Act
    defaultNotifications.create(
        ModelConstants.SYSTEM_TENANT,
        defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    verify(notificationRuleService)
        .saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService)
        .saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}.
   *
   * <ul>
   *   <li>Given {@link NotificationRuleService}.
   *   <li>Then calls {@link DefaultNotification#getRule()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotifications.create(TenantId, DefaultNotification, NotificationTargetId[])"
  })
  public void testCreate_givenNotificationRuleService_thenCallsGetRule() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(
            Mockito.<TenantId>any(), Mockito.<NotificationTemplate>any()))
        .thenReturn(new NotificationTemplate());

    DefaultNotification defaultNotification = mock(DefaultNotification.class);
    DefaultRule defaultRule =
        new DefaultRule(
            "Name",
            null,
            mock(NotificationRuleTriggerConfig.class),
            "The characteristics of someone or something");
    when(defaultNotification.getRule()).thenReturn(defaultRule);
    when(defaultNotification.toTemplate()).thenReturn(new NotificationTemplate());

    // Act
    defaultNotifications.create(ModelConstants.SYSTEM_TENANT, defaultNotification);

    // Assert
    verify(defaultNotification).getRule();
    verify(defaultNotification).toTemplate();
    verify(notificationTemplateService)
        .saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}.
   *
   * <ul>
   *   <li>Given {@link NotificationRuleService}.
   *   <li>When {@link DefaultNotification} {@link DefaultNotification#getRule()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotifications.create(TenantId, DefaultNotification, NotificationTargetId[])"
  })
  public void testCreate_givenNotificationRuleService_whenDefaultNotificationGetRuleReturnNull() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(
            Mockito.<TenantId>any(), Mockito.<NotificationTemplate>any()))
        .thenReturn(new NotificationTemplate());

    DefaultNotification defaultNotification = mock(DefaultNotification.class);
    when(defaultNotification.getRule()).thenReturn(null);
    when(defaultNotification.toTemplate()).thenReturn(new NotificationTemplate());

    // Act
    defaultNotifications.create(
        ModelConstants.SYSTEM_TENANT,
        defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(defaultNotification).getRule();
    verify(defaultNotification).toTemplate();
    verify(notificationTemplateService)
        .saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}.
   *
   * <ul>
   *   <li>Given {@link NotificationRule#NotificationRule()}.
   *   <li>Then calls {@link DefaultNotification#toRule(NotificationTemplateId,
   *       NotificationTargetId[])}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotifications#create(TenantId, DefaultNotification,
   * NotificationTargetId[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotifications.create(TenantId, DefaultNotification, NotificationTargetId[])"
  })
  public void testCreate_givenNotificationRule_thenCallsToRule() {
    // Arrange
    when(notificationTemplateService.saveNotificationTemplate(
            Mockito.<TenantId>any(), Mockito.<NotificationTemplate>any()))
        .thenReturn(new NotificationTemplate());
    when(notificationRuleService.saveNotificationRule(
            Mockito.<TenantId>any(), Mockito.<NotificationRule>any()))
        .thenReturn(new NotificationRule());

    DefaultNotification defaultNotification = mock(DefaultNotification.class);
    when(defaultNotification.toRule(
            Mockito.<NotificationTemplateId>any(), isA(NotificationTargetId[].class)))
        .thenReturn(new NotificationRule());
    DefaultRule defaultRule =
        new DefaultRule(
            "Name",
            null,
            mock(NotificationRuleTriggerConfig.class),
            "The characteristics of someone or something");
    when(defaultNotification.getRule()).thenReturn(defaultRule);
    when(defaultNotification.toTemplate()).thenReturn(new NotificationTemplate());

    // Act
    defaultNotifications.create(
        ModelConstants.SYSTEM_TENANT,
        defaultNotification,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(defaultNotification).getRule();
    verify(defaultNotification).toRule(isNull(), isA(NotificationTargetId[].class));
    verify(defaultNotification).toTemplate();
    verify(notificationRuleService)
        .saveNotificationRule(isA(TenantId.class), isA(NotificationRule.class));
    verify(notificationTemplateService)
        .saveNotificationTemplate(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}, and {@link
   * DefaultNotification#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultNotification#equals(Object)}
   *   <li>{@link DefaultNotification#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    // Act and Assert
    assertEquals(defaultNotification, defaultNotification);
    int expectedHashCodeResult = defaultNotification.hashCode();
    assertEquals(expectedHashCodeResult, defaultNotification.hashCode());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Name")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button(null)
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Name")
            .icon("Icon")
            .link("Link")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color(null)
            .icon("Icon")
            .link("Link")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Name")
            .link("Link")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon(null)
            .link("Link")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Name")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link(null)
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Hello from the Dreaming Spires");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name(null);
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Name")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject(null)
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Name")
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text(null)
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(null)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.ALARM)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button(null)
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");
    DefaultNotification defaultNotification =
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    DefaultNotificationBuilder nameResult2 =
        DefaultNotification.builder()
            .button(null)
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        defaultNotification,
        nameResult2
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build(),
        null);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotification.equals(Object)",
    "int DefaultNotification.hashCode()"
  })
  public void testDefaultNotificationEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DefaultNotificationBuilder nameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");

    // Act and Assert
    assertNotEquals(
        nameResult
            .rule(
                DefaultRule.builder()
                    .description("The characteristics of someone or something")
                    .enabled(true)
                    .name("Name")
                    .triggerConfig(mock(NotificationRuleTriggerConfig.class))
                    .build())
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build(),
        "Different type to DefaultNotification");
  }

  /**
   * Test DefaultNotification getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultNotification#DefaultNotification(String, NotificationType, String, String,
   *       String, String, String, String, DefaultRule)}
   *   <li>{@link DefaultNotification#toString()}
   *   <li>{@link DefaultNotification#getButton()}
   *   <li>{@link DefaultNotification#getColor()}
   *   <li>{@link DefaultNotification#getIcon()}
   *   <li>{@link DefaultNotification#getLink()}
   *   <li>{@link DefaultNotification#getName()}
   *   <li>{@link DefaultNotification#getRule()}
   *   <li>{@link DefaultNotification#getSubject()}
   *   <li>{@link DefaultNotification#getText()}
   *   <li>{@link DefaultNotification#getType()}
   *   <li>{@link DefaultNotification#toBuilder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotification.<init>(String, NotificationType, String, String, String, String, String, String, DefaultRule)",
    "String DefaultNotification.getButton()",
    "String DefaultNotification.getColor()",
    "String DefaultNotification.getIcon()",
    "String DefaultNotification.getLink()",
    "String DefaultNotification.getName()",
    "DefaultRule DefaultNotification.getRule()",
    "String DefaultNotification.getSubject()",
    "String DefaultNotification.getText()",
    "NotificationType DefaultNotification.getType()",
    "DefaultNotificationBuilder DefaultNotification.toBuilder()",
    "String DefaultNotification.toString()"
  })
  public void testDefaultNotificationGettersAndSetters() {
    // Arrange
    DefaultRule rule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build();

    // Act
    DefaultNotification actualDefaultNotification =
        new DefaultNotification(
            "Name",
            NotificationType.GENERAL,
            "Hello from the Dreaming Spires",
            "Text",
            "Icon",
            "Color",
            "Button",
            "Link",
            rule);
    actualDefaultNotification.toString();
    String actualButton = actualDefaultNotification.getButton();
    String actualColor = actualDefaultNotification.getColor();
    String actualIcon = actualDefaultNotification.getIcon();
    String actualLink = actualDefaultNotification.getLink();
    String actualName = actualDefaultNotification.getName();
    DefaultRule actualRule = actualDefaultNotification.getRule();
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
   * Test DefaultNotification {@link DefaultNotification#toRule(NotificationTemplateId,
   * NotificationTargetId[])}.
   *
   * <p>Method under test: {@link DefaultNotification#toRule(NotificationTemplateId,
   * NotificationTargetId[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRule DefaultNotification.toRule(NotificationTemplateId, NotificationTargetId[])"
  })
  public void testDefaultNotificationToRule() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultRule rule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(null)
            .name("Name")
            .triggerConfig(triggerConfig)
            .build();
    DefaultNotification defaultNotification =
        new DefaultNotification(
            "Name",
            NotificationType.GENERAL,
            "Hello from the Dreaming Spires",
            "Text",
            "Icon",
            "Color",
            "Button",
            "Link",
            rule);
    NotificationTemplateId templateId = new NotificationTemplateId(ModelConstants.NULL_UUID);

    // Act
    NotificationRule actualToRuleResult =
        defaultNotification.toRule(templateId, new NotificationTargetId(ModelConstants.NULL_UUID));

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
   * Test DefaultNotification {@link DefaultNotification#toRule(NotificationTemplateId,
   * NotificationTargetId[])}.
   *
   * <p>Method under test: {@link DefaultNotification#toRule(NotificationTemplateId,
   * NotificationTargetId[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRule DefaultNotification.toRule(NotificationTemplateId, NotificationTargetId[])"
  })
  public void testDefaultNotificationToRule2() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ALARM);
    DefaultRule rule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(triggerConfig)
            .build();
    DefaultNotification defaultNotification =
        new DefaultNotification(
            "Name",
            NotificationType.GENERAL,
            "Hello from the Dreaming Spires",
            "Text",
            "Icon",
            "Color",
            "Button",
            "Link",
            rule);
    NotificationTemplateId templateId = new NotificationTemplateId(ModelConstants.NULL_UUID);

    // Act
    NotificationRule actualToRuleResult =
        defaultNotification.toRule(templateId, new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(triggerConfig).getTriggerType();
    NotificationRuleRecipientsConfig recipientsConfig = actualToRuleResult.getRecipientsConfig();
    assertTrue(recipientsConfig instanceof EscalatedNotificationRuleRecipientsConfig);
    Map<Integer, List<UUID>> escalationTable =
        ((EscalatedNotificationRuleRecipientsConfig) recipientsConfig).getEscalationTable();
    assertEquals(1, escalationTable.size());
    assertEquals(1, escalationTable.get(0).size());
    assertEquals(NotificationRuleTriggerType.ALARM, actualToRuleResult.getTriggerType());
    assertEquals(NotificationRuleTriggerType.ALARM, recipientsConfig.getTriggerType());
    assertSame(escalationTable, recipientsConfig.getTargetsTable());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toRule(NotificationTemplateId,
   * NotificationTargetId[])}.
   *
   * <ul>
   *   <li>Then return Enabled.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#toRule(NotificationTemplateId,
   * NotificationTargetId[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRule DefaultNotification.toRule(NotificationTemplateId, NotificationTargetId[])"
  })
  public void testDefaultNotificationToRule_thenReturnEnabled() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultRule rule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(triggerConfig)
            .build();
    DefaultNotification defaultNotification =
        new DefaultNotification(
            "Name",
            NotificationType.GENERAL,
            "Hello from the Dreaming Spires",
            "Text",
            "Icon",
            "Color",
            "Button",
            "Link",
            rule);
    NotificationTemplateId templateId = new NotificationTemplateId(ModelConstants.NULL_UUID);

    // Act
    NotificationRule actualToRuleResult =
        defaultNotification.toRule(templateId, new NotificationTargetId(ModelConstants.NULL_UUID));

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
   * Test DefaultNotification {@link DefaultNotification#toRule(NotificationTemplateId,
   * NotificationTargetId[])}.
   *
   * <ul>
   *   <li>Then return not Enabled.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotification#toRule(NotificationTemplateId,
   * NotificationTargetId[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRule DefaultNotification.toRule(NotificationTemplateId, NotificationTargetId[])"
  })
  public void testDefaultNotificationToRule_thenReturnNotEnabled() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultRule rule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(false)
            .name("Name")
            .triggerConfig(triggerConfig)
            .build();
    DefaultNotification defaultNotification =
        new DefaultNotification(
            "Name",
            NotificationType.GENERAL,
            "Hello from the Dreaming Spires",
            "Text",
            "Icon",
            "Color",
            "Button",
            "Link",
            rule);
    NotificationTemplateId templateId = new NotificationTemplateId(ModelConstants.NULL_UUID);

    // Act
    NotificationRule actualToRuleResult =
        defaultNotification.toRule(templateId, new NotificationTargetId(ModelConstants.NULL_UUID));

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
   *
   * <p>Method under test: {@link DefaultNotification#toTemplate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTemplate DefaultNotification.toTemplate()"})
  public void testDefaultNotificationToTemplate() {
    // Arrange
    DefaultRule rule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build();
    DefaultNotification defaultNotification =
        new DefaultNotification(
            "Name",
            NotificationType.GENERAL,
            "Hello from the Dreaming Spires",
            "Text",
            "Icon",
            "Color",
            "Button",
            "Link",
            rule);

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates =
        defaultNotification.toTemplate().getConfiguration().getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates.size());
    DeliveryMethodNotificationTemplate getResult =
        deliveryMethodsTemplates.get(NotificationDeliveryMethod.WEB);
    JsonNode additionalConfig =
        ((WebDeliveryMethodNotificationTemplate) getResult).getAdditionalConfig();
    Iterator<JsonNode> iteratorResult = additionalConfig.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(additionalConfig instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalConfig.traverse() instanceof TreeTraversingParser);
    assertTrue(getResult instanceof WebDeliveryMethodNotificationTemplate);
    assertEquals(
        "{\n  \"enabled\" : true,\n  \"icon\" : \"Icon\",\n  \"color\" : \"Color\"\n}",
        nextResult.toPrettyString());
    assertEquals(
        "{\n"
            + "  \"icon\" : {\n"
            + "    \"enabled\" : true,\n"
            + "    \"icon\" : \"Icon\",\n"
            + "    \"color\" : \"Color\"\n"
            + "  },\n"
            + "  \"actionButtonConfig\" : {\n"
            + "    \"enabled\" : true,\n"
            + "    \"text\" : \"Button\",\n"
            + "    \"linkType\" : \"LINK\",\n"
            + "    \"link\" : \"Link\"\n"
            + "  }\n"
            + "}",
        additionalConfig.toPrettyString());
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toTemplate()}.
   *
   * <p>Method under test: {@link DefaultNotification#toTemplate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTemplate DefaultNotification.toTemplate()"})
  public void testDefaultNotificationToTemplate2() {
    // Arrange
    DefaultRule rule =
        new DefaultRule(
            "Name",
            true,
            mock(NotificationRuleTriggerConfig.class),
            "The characteristics of someone or something");
    DefaultNotification defaultNotification =
        new DefaultNotification(
            "Name", null, "Hello from the Dreaming Spires", "Text", "Icon", null, null, null, rule);

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates =
        defaultNotification.toTemplate().getConfiguration().getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates.size());
    DeliveryMethodNotificationTemplate getResult =
        deliveryMethodsTemplates.get(NotificationDeliveryMethod.WEB);
    JsonNode additionalConfig =
        ((WebDeliveryMethodNotificationTemplate) getResult).getAdditionalConfig();
    Iterator<JsonNode> iteratorResult = additionalConfig.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(additionalConfig instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalConfig.traverse() instanceof TreeTraversingParser);
    assertTrue(getResult instanceof WebDeliveryMethodNotificationTemplate);
    assertEquals(
        "{\n  \"enabled\" : true,\n  \"icon\" : \"Icon\",\n  \"color\" : \"#757575\"\n}",
        nextResult.toPrettyString());
    assertEquals(
        "{\n"
            + "  \"icon\" : {\n"
            + "    \"enabled\" : true,\n"
            + "    \"icon\" : \"Icon\",\n"
            + "    \"color\" : \"#757575\"\n"
            + "  },\n"
            + "  \"actionButtonConfig\" : {\n"
            + "    \"enabled\" : false\n"
            + "  }\n"
            + "}",
        additionalConfig.toPrettyString());
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toTemplate()}.
   *
   * <p>Method under test: {@link DefaultNotification#toTemplate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTemplate DefaultNotification.toTemplate()"})
  public void testDefaultNotificationToTemplate3() {
    // Arrange
    DefaultRule rule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build();
    DefaultNotification defaultNotification =
        new DefaultNotification(
            "Name",
            NotificationType.GENERAL,
            "Hello from the Dreaming Spires",
            "Text",
            "",
            "Color",
            "Button",
            "Link",
            rule);

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates =
        defaultNotification.toTemplate().getConfiguration().getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates.size());
    DeliveryMethodNotificationTemplate getResult =
        deliveryMethodsTemplates.get(NotificationDeliveryMethod.WEB);
    JsonNode additionalConfig =
        ((WebDeliveryMethodNotificationTemplate) getResult).getAdditionalConfig();
    Iterator<JsonNode> iteratorResult = additionalConfig.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(additionalConfig instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalConfig.traverse() instanceof TreeTraversingParser);
    assertTrue(getResult instanceof WebDeliveryMethodNotificationTemplate);
    assertEquals(
        "{\n  \"enabled\" : true,\n  \"icon\" : \"\",\n  \"color\" : \"Color\"\n}",
        nextResult.toPrettyString());
    assertEquals(
        "{\n"
            + "  \"icon\" : {\n"
            + "    \"enabled\" : true,\n"
            + "    \"icon\" : \"\",\n"
            + "    \"color\" : \"Color\"\n"
            + "  },\n"
            + "  \"actionButtonConfig\" : {\n"
            + "    \"enabled\" : true,\n"
            + "    \"text\" : \"Button\",\n"
            + "    \"linkType\" : \"LINK\",\n"
            + "    \"link\" : \"Link\"\n"
            + "  }\n"
            + "}",
        additionalConfig.toPrettyString());
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test DefaultNotification_DefaultNotificationBuilder {@link DefaultNotificationBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultNotificationBuilder#build()}
   *   <li>{@link DefaultNotificationBuilder#button(String)}
   *   <li>{@link DefaultNotificationBuilder#color(String)}
   *   <li>{@link DefaultNotificationBuilder#icon(String)}
   *   <li>{@link DefaultNotificationBuilder#link(String)}
   *   <li>{@link DefaultNotificationBuilder#name(String)}
   *   <li>{@link DefaultNotificationBuilder#rule(DefaultRule)}
   *   <li>{@link DefaultNotificationBuilder#subject(String)}
   *   <li>{@link DefaultNotificationBuilder#text(String)}
   *   <li>{@link DefaultNotificationBuilder#type(NotificationType)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationBuilder.<init>()",
    "DefaultNotification DefaultNotificationBuilder.build()",
    "DefaultNotificationBuilder DefaultNotificationBuilder.button(String)",
    "DefaultNotificationBuilder DefaultNotificationBuilder.color(String)",
    "DefaultNotificationBuilder DefaultNotificationBuilder.icon(String)",
    "DefaultNotificationBuilder DefaultNotificationBuilder.link(String)",
    "DefaultNotificationBuilder DefaultNotificationBuilder.name(String)",
    "DefaultNotificationBuilder DefaultNotificationBuilder.rule(DefaultRule)",
    "DefaultNotificationBuilder DefaultNotificationBuilder.subject(String)",
    "DefaultNotificationBuilder DefaultNotificationBuilder.text(String)",
    "String DefaultNotificationBuilder.toString()",
    "DefaultNotificationBuilder DefaultNotificationBuilder.type(NotificationType)"
  })
  public void testDefaultNotification_DefaultNotificationBuilderBuild() {
    // Arrange and Act
    DefaultNotificationBuilder actualNameResult =
        DefaultNotification.builder()
            .button("Button")
            .color("Color")
            .icon("Icon")
            .link("Link")
            .name("Name");
    DefaultRule rule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build();
    DefaultNotification actualDefaultNotification =
        actualNameResult
            .rule(rule)
            .subject("Hello from the Dreaming Spires")
            .text("Text")
            .type(NotificationType.GENERAL)
            .build();

    // Assert
    assertEquals("Button", actualDefaultNotification.getButton());
    assertEquals("Color", actualDefaultNotification.getColor());
    assertEquals("Hello from the Dreaming Spires", actualDefaultNotification.getSubject());
    assertEquals("Icon", actualDefaultNotification.getIcon());
    assertEquals("Link", actualDefaultNotification.getLink());
    assertEquals("Name", actualDefaultNotification.getName());
    assertEquals("Text", actualDefaultNotification.getText());
    assertEquals(NotificationType.GENERAL, actualDefaultNotification.getType());
    assertSame(rule, actualDefaultNotification.getRule());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}, and {@link DefaultRule#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultRule#equals(Object)}
   *   <li>{@link DefaultRule#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultRule defaultRule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(null)
            .build();
    DefaultRule defaultRule2 =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(null)
            .build();

    // Act and Assert
    assertEquals(defaultRule, defaultRule2);
    assertEquals(defaultRule.hashCode(), defaultRule2.hashCode());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}, and {@link DefaultRule#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultRule#equals(Object)}
   *   <li>{@link DefaultRule#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DefaultRule defaultRule =
        DefaultRule.builder()
            .description(null)
            .enabled(true)
            .name("Name")
            .triggerConfig(null)
            .build();
    DefaultRule defaultRule2 =
        DefaultRule.builder()
            .description(null)
            .enabled(true)
            .name("Name")
            .triggerConfig(null)
            .build();

    // Act and Assert
    assertEquals(defaultRule, defaultRule2);
    assertEquals(defaultRule.hashCode(), defaultRule2.hashCode());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}, and {@link DefaultRule#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultRule#equals(Object)}
   *   <li>{@link DefaultRule#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultRule defaultRule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build();

    // Act and Assert
    assertEquals(defaultRule, defaultRule);
    int expectedHashCodeResult = defaultRule.hashCode();
    assertEquals(expectedHashCodeResult, defaultRule.hashCode());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultRule defaultRule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build();

    // Act and Assert
    assertNotEquals(
        defaultRule,
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultRule defaultRule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(false)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build();

    // Act and Assert
    assertNotEquals(
        defaultRule,
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DefaultRule defaultRule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(null)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build();

    // Act and Assert
    assertNotEquals(
        defaultRule,
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DefaultRule defaultRule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name(null)
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build();

    // Act and Assert
    assertNotEquals(
        defaultRule,
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DefaultRule defaultRule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("42")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build();

    // Act and Assert
    assertNotEquals(
        defaultRule,
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DefaultRule defaultRule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(null)
            .build();

    // Act and Assert
    assertNotEquals(
        defaultRule,
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DefaultRule defaultRule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(null)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build();

    // Act and Assert
    assertNotEquals(
        defaultRule,
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(null)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DefaultRule defaultRule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name(null)
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build();

    // Act and Assert
    assertNotEquals(
        defaultRule,
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name(null)
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DefaultRule defaultRule =
        DefaultRule.builder()
            .description("Name")
            .enabled(true)
            .name("Name")
            .triggerConfig(null)
            .build();

    // Act and Assert
    assertNotEquals(
        defaultRule,
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(null)
            .build());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DefaultRule defaultRule =
        DefaultRule.builder()
            .description(null)
            .enabled(true)
            .name("Name")
            .triggerConfig(null)
            .build();

    // Act and Assert
    assertNotEquals(
        defaultRule,
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(null)
            .build());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build(),
        null);
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(mock(NotificationRuleTriggerConfig.class))
            .build(),
        "Different type to DefaultRule");
  }

  /**
   * Test DefaultRule getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultRule#DefaultRule(String, Boolean, NotificationRuleTriggerConfig, String)}
   *   <li>{@link DefaultRule#toString()}
   *   <li>{@link DefaultRule#getDescription()}
   *   <li>{@link DefaultRule#getEnabled()}
   *   <li>{@link DefaultRule#getName()}
   *   <li>{@link DefaultRule#getTriggerConfig()}
   *   <li>{@link DefaultRule#toBuilder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultRule.<init>(String, Boolean, NotificationRuleTriggerConfig, String)",
    "String DefaultRule.getDescription()",
    "Boolean DefaultRule.getEnabled()",
    "String DefaultRule.getName()",
    "NotificationRuleTriggerConfig DefaultRule.getTriggerConfig()",
    "DefaultRule.DefaultRuleBuilder DefaultRule.toBuilder()",
    "String DefaultRule.toString()"
  })
  public void testDefaultRuleGettersAndSetters() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);

    // Act
    DefaultRule actualDefaultRule =
        new DefaultRule("Name", true, triggerConfig, "The characteristics of someone or something");
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
   * Test DefaultRule_DefaultRuleBuilder {@link DefaultRule.DefaultRuleBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultRule.DefaultRuleBuilder#build()}
   *   <li>{@link DefaultRule.DefaultRuleBuilder#description(String)}
   *   <li>{@link DefaultRule.DefaultRuleBuilder#enabled(Boolean)}
   *   <li>{@link DefaultRule.DefaultRuleBuilder#name(String)}
   *   <li>{@link DefaultRule.DefaultRuleBuilder#triggerConfig(NotificationRuleTriggerConfig)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultRule.DefaultRuleBuilder.<init>()",
    "DefaultRule DefaultRule.DefaultRuleBuilder.build()",
    "DefaultRule.DefaultRuleBuilder DefaultRule.DefaultRuleBuilder.description(String)",
    "DefaultRule.DefaultRuleBuilder DefaultRule.DefaultRuleBuilder.enabled(Boolean)",
    "DefaultRule.DefaultRuleBuilder DefaultRule.DefaultRuleBuilder.name(String)",
    "String DefaultRule.DefaultRuleBuilder.toString()",
    "DefaultRule.DefaultRuleBuilder DefaultRule.DefaultRuleBuilder.triggerConfig(NotificationRuleTriggerConfig)"
  })
  public void testDefaultRule_DefaultRuleBuilderBuild() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);

    // Act
    DefaultRule actualDefaultRule =
        DefaultRule.builder()
            .description("The characteristics of someone or something")
            .enabled(true)
            .name("Name")
            .triggerConfig(triggerConfig)
            .build();

    // Assert
    assertEquals("Name", actualDefaultRule.getName());
    assertEquals("The characteristics of someone or something", actualDefaultRule.getDescription());
    assertTrue(actualDefaultRule.getEnabled());
    assertSame(triggerConfig, actualDefaultRule.getTriggerConfig());
  }
}
