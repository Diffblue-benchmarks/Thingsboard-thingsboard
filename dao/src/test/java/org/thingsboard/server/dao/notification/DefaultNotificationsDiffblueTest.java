package org.thingsboard.server.dao.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.rule.DefaultNotificationRuleRecipientsConfig;
import org.thingsboard.server.common.data.notification.rule.EscalatedNotificationRuleRecipientsConfig;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.NotificationRuleRecipientsConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.data.notification.template.DeliveryMethodNotificationTemplate;
import org.thingsboard.server.common.data.notification.template.WebDeliveryMethodNotificationTemplate;
import org.thingsboard.server.dao.notification.DefaultNotifications.DefaultNotification;
import org.thingsboard.server.dao.notification.DefaultNotifications.DefaultNotification.DefaultNotificationBuilder;
import org.thingsboard.server.dao.notification.DefaultNotifications.DefaultRule;
import org.thingsboard.server.dao.notification.DefaultNotifications.DefaultRule.DefaultRuleBuilder;

@ContextConfiguration(classes = {DefaultRuleBuilder.class, DefaultNotificationBuilder.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultNotificationsDiffblueTest {
  @Autowired
  private DefaultNotificationBuilder defaultNotificationBuilder;

  @Autowired
  private DefaultRuleBuilder defaultRuleBuilder;

  /**
   * Test DefaultNotification {@link DefaultNotification#equals(Object)}, and {@link DefaultNotification#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultNotification#equals(Object)}
   *   <li>{@link DefaultNotification#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultNotificationBuilder nameResult = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultNotificationBuilder nameResult = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotificationBuilder nameResult2 = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule2 = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult2 = nameResult2.rule(rule2)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultNotificationBuilder defaultNotificationBuilder = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.button(Mockito.<String>any())).thenReturn(DefaultNotification.builder());
    DefaultNotificationBuilder nameResult = defaultNotificationBuilder.button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotificationBuilder nameResult2 = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule2 = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult2 = nameResult2.rule(rule2)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DefaultNotificationBuilder defaultNotificationBuilder = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.color(Mockito.<String>any())).thenReturn(DefaultNotification.builder());
    DefaultNotificationBuilder defaultNotificationBuilder2 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotificationBuilder nameResult = defaultNotificationBuilder2.button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotificationBuilder nameResult2 = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule2 = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult2 = nameResult2.rule(rule2)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DefaultNotificationBuilder defaultNotificationBuilder = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any())).thenReturn(DefaultNotification.builder());
    DefaultNotificationBuilder defaultNotificationBuilder2 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotificationBuilder defaultNotificationBuilder3 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotificationBuilder nameResult = defaultNotificationBuilder3.button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotificationBuilder nameResult2 = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule2 = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult2 = nameResult2.rule(rule2)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DefaultNotificationBuilder defaultNotificationBuilder = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any())).thenReturn(DefaultNotification.builder());
    DefaultNotificationBuilder defaultNotificationBuilder2 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotificationBuilder defaultNotificationBuilder3 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotificationBuilder nameResult = defaultNotificationBuilder3.button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Hello from the Dreaming Spires");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotificationBuilder nameResult2 = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule2 = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult2 = nameResult2.rule(rule2)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DefaultNotificationBuilder defaultNotificationBuilder = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any())).thenReturn(DefaultNotification.builder());
    DefaultNotificationBuilder defaultNotificationBuilder2 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotificationBuilder defaultNotificationBuilder3 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotificationBuilder nameResult = defaultNotificationBuilder3.button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name(null);
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotificationBuilder nameResult2 = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule2 = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult2 = nameResult2.rule(rule2)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DefaultNotificationBuilder defaultNotificationBuilder = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any())).thenReturn(DefaultNotification.builder());
    DefaultNotificationBuilder defaultNotificationBuilder2 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotificationBuilder defaultNotificationBuilder3 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotificationBuilder nameResult = defaultNotificationBuilder3.button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Name")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotificationBuilder nameResult2 = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule2 = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult2 = nameResult2.rule(rule2)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DefaultNotificationBuilder defaultNotificationBuilder = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any())).thenReturn(DefaultNotification.builder());
    DefaultNotificationBuilder defaultNotificationBuilder2 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotificationBuilder defaultNotificationBuilder3 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotificationBuilder nameResult = defaultNotificationBuilder3.button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
        .subject(null)
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotificationBuilder nameResult2 = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule2 = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult2 = nameResult2.rule(rule2)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DefaultNotificationBuilder defaultNotificationBuilder = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any())).thenReturn(DefaultNotification.builder());
    DefaultNotificationBuilder defaultNotificationBuilder2 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotificationBuilder defaultNotificationBuilder3 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotificationBuilder nameResult = defaultNotificationBuilder3.button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Name")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotificationBuilder nameResult2 = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule2 = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult2 = nameResult2.rule(rule2)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DefaultNotificationBuilder defaultNotificationBuilder = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any())).thenReturn(DefaultNotification.builder());
    DefaultNotificationBuilder defaultNotificationBuilder2 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotificationBuilder defaultNotificationBuilder3 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotificationBuilder nameResult = defaultNotificationBuilder3.button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text(null)
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotificationBuilder nameResult2 = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule2 = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult2 = nameResult2.rule(rule2)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DefaultNotificationBuilder defaultNotificationBuilder = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any())).thenReturn(DefaultNotification.builder());
    DefaultNotificationBuilder defaultNotificationBuilder2 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotificationBuilder defaultNotificationBuilder3 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotificationBuilder nameResult = defaultNotificationBuilder3.button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(null)
        .build();
    DefaultNotificationBuilder nameResult2 = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule2 = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult2 = nameResult2.rule(rule2)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DefaultNotificationBuilder defaultNotificationBuilder = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any())).thenReturn(DefaultNotification.builder());
    DefaultNotificationBuilder defaultNotificationBuilder2 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotificationBuilder defaultNotificationBuilder3 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotificationBuilder nameResult = defaultNotificationBuilder3.button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.ALARM)
        .build();
    DefaultNotificationBuilder nameResult2 = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule2 = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult2 = nameResult2.rule(rule2)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    DefaultNotificationBuilder defaultNotificationBuilder = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any())).thenReturn(DefaultNotification.builder());
    DefaultNotificationBuilder defaultNotificationBuilder2 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotificationBuilder defaultNotificationBuilder3 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotificationBuilder nameResult = defaultNotificationBuilder3.button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotificationBuilder nameResult2 = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon(null)
        .link("Link")
        .name("Name");
    DefaultRule rule2 = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult2 = nameResult2.rule(rule2)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    DefaultNotificationBuilder builderResult = DefaultNotification.builder();
    builderResult.icon("Name");
    DefaultNotificationBuilder defaultNotificationBuilder = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any())).thenReturn(builderResult);
    DefaultNotificationBuilder defaultNotificationBuilder2 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotificationBuilder defaultNotificationBuilder3 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotificationBuilder nameResult = defaultNotificationBuilder3.button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotificationBuilder nameResult2 = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule2 = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult2 = nameResult2.rule(rule2)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    DefaultNotificationBuilder defaultNotificationBuilder = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder.icon(Mockito.<String>any())).thenReturn(DefaultNotification.builder());
    DefaultNotificationBuilder defaultNotificationBuilder2 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder2.color(Mockito.<String>any())).thenReturn(defaultNotificationBuilder);
    DefaultNotificationBuilder defaultNotificationBuilder3 = mock(DefaultNotificationBuilder.class);
    when(defaultNotificationBuilder3.button(Mockito.<String>any())).thenReturn(defaultNotificationBuilder2);
    DefaultNotificationBuilder nameResult = defaultNotificationBuilder3.button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name(null);
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    DefaultNotificationBuilder nameResult2 = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name(null);
    DefaultRule rule2 = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult2 = nameResult2.rule(rule2)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DefaultNotificationBuilder nameResult = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
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
   * Method under test: {@link DefaultNotification#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotification.equals(Object)", "int DefaultNotification.hashCode()"})
  public void testDefaultNotificationEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DefaultNotificationBuilder nameResult = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultNotification buildResult = nameResult.rule(rule)
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
   *   <li>{@link DefaultNotification#DefaultNotification(String, NotificationType, String, String, String, String, String, String, DefaultRule)}
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultNotification.<init>(String, NotificationType, String, String, String, String, String, String, DefaultRule)",
      "String DefaultNotification.getButton()", "String DefaultNotification.getColor()",
      "String DefaultNotification.getIcon()", "String DefaultNotification.getLink()",
      "String DefaultNotification.getName()", "DefaultRule DefaultNotification.getRule()",
      "String DefaultNotification.getSubject()", "String DefaultNotification.getText()",
      "NotificationType DefaultNotification.getType()", "DefaultNotificationBuilder DefaultNotification.toBuilder()",
      "String DefaultNotification.toString()"})
  public void testDefaultNotificationGettersAndSetters() {
    // Arrange
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act
    DefaultNotification actualDefaultNotification = new DefaultNotification("Name", NotificationType.GENERAL,
        "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link", rule);
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
   * Test DefaultNotification {@link DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}.
   * <p>
   * Method under test: {@link DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationRule DefaultNotification.toRule(NotificationTemplateId, NotificationTargetId[])"})
  public void testDefaultNotificationToRule() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(null)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotification defaultNotification = new DefaultNotification("Name", NotificationType.GENERAL,
        "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link", rule);
    NotificationTemplateId templateId = new NotificationTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    NotificationRule actualToRuleResult = defaultNotification.toRule(templateId, new NotificationTargetId(id));

    // Assert
    verify(triggerConfig).getTriggerType();
    NotificationRuleRecipientsConfig recipientsConfig = actualToRuleResult.getRecipientsConfig();
    assertTrue(recipientsConfig instanceof DefaultNotificationRuleRecipientsConfig);
    List<UUID> targets = ((DefaultNotificationRuleRecipientsConfig) recipientsConfig).getTargets();
    assertEquals(1, targets.size());
    UUID getResult = targets.get(0);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", getResult.toString());
    Map<Integer, List<UUID>> targetsTable = recipientsConfig.getTargetsTable();
    assertEquals(1, targetsTable.size());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualToRuleResult.getTriggerType());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, recipientsConfig.getTriggerType());
    assertTrue(actualToRuleResult.isEnabled());
    assertSame(targets, targetsTable.get(0));
    assertSame(id, getResult);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}.
   * <p>
   * Method under test: {@link DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationRule DefaultNotification.toRule(NotificationTemplateId, NotificationTargetId[])"})
  public void testDefaultNotificationToRule2() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ALARM);
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotification defaultNotification = new DefaultNotification("Name", NotificationType.GENERAL,
        "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link", rule);
    NotificationTemplateId templateId = new NotificationTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    NotificationRule actualToRuleResult = defaultNotification.toRule(templateId, new NotificationTargetId(id));

    // Assert
    verify(triggerConfig).getTriggerType();
    NotificationRuleRecipientsConfig recipientsConfig = actualToRuleResult.getRecipientsConfig();
    assertTrue(recipientsConfig instanceof EscalatedNotificationRuleRecipientsConfig);
    Map<Integer, List<UUID>> escalationTable = ((EscalatedNotificationRuleRecipientsConfig) recipientsConfig)
        .getEscalationTable();
    assertEquals(1, escalationTable.size());
    List<UUID> getResult = escalationTable.get(0);
    assertEquals(1, getResult.size());
    UUID getResult2 = getResult.get(0);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", getResult2.toString());
    assertEquals(NotificationRuleTriggerType.ALARM, actualToRuleResult.getTriggerType());
    assertEquals(NotificationRuleTriggerType.ALARM, recipientsConfig.getTriggerType());
    assertSame(escalationTable, recipientsConfig.getTargetsTable());
    assertSame(id, getResult2);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}.
   * <ul>
   *   <li>Then return Enabled.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationRule DefaultNotification.toRule(NotificationTemplateId, NotificationTargetId[])"})
  public void testDefaultNotificationToRule_thenReturnEnabled() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotification defaultNotification = new DefaultNotification("Name", NotificationType.GENERAL,
        "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link", rule);
    NotificationTemplateId templateId = new NotificationTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    NotificationRule actualToRuleResult = defaultNotification.toRule(templateId, new NotificationTargetId(id));

    // Assert
    verify(triggerConfig).getTriggerType();
    NotificationRuleRecipientsConfig recipientsConfig = actualToRuleResult.getRecipientsConfig();
    assertTrue(recipientsConfig instanceof DefaultNotificationRuleRecipientsConfig);
    List<UUID> targets = ((DefaultNotificationRuleRecipientsConfig) recipientsConfig).getTargets();
    assertEquals(1, targets.size());
    UUID getResult = targets.get(0);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", getResult.toString());
    Map<Integer, List<UUID>> targetsTable = recipientsConfig.getTargetsTable();
    assertEquals(1, targetsTable.size());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualToRuleResult.getTriggerType());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, recipientsConfig.getTriggerType());
    assertTrue(actualToRuleResult.isEnabled());
    assertSame(targets, targetsTable.get(0));
    assertSame(id, getResult);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}.
   * <ul>
   *   <li>Then return not Enabled.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotification#toRule(NotificationTemplateId, NotificationTargetId[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationRule DefaultNotification.toRule(NotificationTemplateId, NotificationTargetId[])"})
  public void testDefaultNotificationToRule_thenReturnNotEnabled() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(false)
        .name("Name")
        .triggerConfig(triggerConfig)
        .build();
    DefaultNotification defaultNotification = new DefaultNotification("Name", NotificationType.GENERAL,
        "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link", rule);
    NotificationTemplateId templateId = new NotificationTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    NotificationRule actualToRuleResult = defaultNotification.toRule(templateId, new NotificationTargetId(id));

    // Assert
    verify(triggerConfig).getTriggerType();
    NotificationRuleRecipientsConfig recipientsConfig = actualToRuleResult.getRecipientsConfig();
    assertTrue(recipientsConfig instanceof DefaultNotificationRuleRecipientsConfig);
    List<UUID> targets = ((DefaultNotificationRuleRecipientsConfig) recipientsConfig).getTargets();
    assertEquals(1, targets.size());
    UUID getResult = targets.get(0);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", getResult.toString());
    Map<Integer, List<UUID>> targetsTable = recipientsConfig.getTargetsTable();
    assertEquals(1, targetsTable.size());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualToRuleResult.getTriggerType());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, recipientsConfig.getTriggerType());
    assertFalse(actualToRuleResult.isEnabled());
    assertSame(targets, targetsTable.get(0));
    assertSame(id, getResult);
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toTemplate()}.
   * <p>
   * Method under test: {@link DefaultNotification#toTemplate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.notification.template.NotificationTemplate DefaultNotification.toTemplate()"})
  public void testDefaultNotificationToTemplate() {
    // Arrange
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = (new DefaultNotification(
        "Name", NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "Icon", "Color", "Button", "Link",
        rule)).toTemplate().getConfiguration().getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates.get(NotificationDeliveryMethod.WEB);
    JsonNode additionalConfig = ((WebDeliveryMethodNotificationTemplate) getResult).getAdditionalConfig();
    Iterator<JsonNode> iteratorResult = additionalConfig.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(additionalConfig instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalConfig.traverse() instanceof TreeTraversingParser);
    assertTrue(getResult instanceof WebDeliveryMethodNotificationTemplate);
    assertEquals("{\r\n  \"enabled\" : true,\r\n  \"icon\" : \"Icon\",\r\n  \"color\" : \"Color\"\r\n}",
        nextResult.toPrettyString());
    assertEquals("{\r\n" + "  \"icon\" : {\r\n" + "    \"enabled\" : true,\r\n" + "    \"icon\" : \"Icon\",\r\n"
        + "    \"color\" : \"Color\"\r\n" + "  },\r\n" + "  \"actionButtonConfig\" : {\r\n"
        + "    \"enabled\" : true,\r\n" + "    \"text\" : \"Button\",\r\n" + "    \"linkType\" : \"LINK\",\r\n"
        + "    \"link\" : \"Link\"\r\n" + "  }\r\n" + "}", additionalConfig.toPrettyString());
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toTemplate()}.
   * <p>
   * Method under test: {@link DefaultNotification#toTemplate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.notification.template.NotificationTemplate DefaultNotification.toTemplate()"})
  public void testDefaultNotificationToTemplate2() {
    // Arrange
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = (new DefaultNotification(
        "Name", null, "Hello from the Dreaming Spires", "Text", "Icon", null, null, null, rule)).toTemplate()
        .getConfiguration()
        .getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates.get(NotificationDeliveryMethod.WEB);
    JsonNode additionalConfig = ((WebDeliveryMethodNotificationTemplate) getResult).getAdditionalConfig();
    Iterator<JsonNode> iteratorResult = additionalConfig.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(additionalConfig instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalConfig.traverse() instanceof TreeTraversingParser);
    assertTrue(getResult instanceof WebDeliveryMethodNotificationTemplate);
    assertEquals("{\r\n  \"enabled\" : true,\r\n  \"icon\" : \"Icon\",\r\n  \"color\" : \"#757575\"\r\n}",
        nextResult.toPrettyString());
    assertEquals("{\r\n" + "  \"icon\" : {\r\n" + "    \"enabled\" : true,\r\n" + "    \"icon\" : \"Icon\",\r\n"
        + "    \"color\" : \"#757575\"\r\n" + "  },\r\n" + "  \"actionButtonConfig\" : {\r\n"
        + "    \"enabled\" : false\r\n" + "  }\r\n" + "}", additionalConfig.toPrettyString());
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test DefaultNotification {@link DefaultNotification#toTemplate()}.
   * <p>
   * Method under test: {@link DefaultNotification#toTemplate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.notification.template.NotificationTemplate DefaultNotification.toTemplate()"})
  public void testDefaultNotificationToTemplate3() {
    // Arrange
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = (new DefaultNotification(
        "Name", NotificationType.GENERAL, "Hello from the Dreaming Spires", "Text", "", "Color", "Button", "Link",
        rule)).toTemplate().getConfiguration().getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates.get(NotificationDeliveryMethod.WEB);
    JsonNode additionalConfig = ((WebDeliveryMethodNotificationTemplate) getResult).getAdditionalConfig();
    Iterator<JsonNode> iteratorResult = additionalConfig.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(additionalConfig instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalConfig.traverse() instanceof TreeTraversingParser);
    assertTrue(getResult instanceof WebDeliveryMethodNotificationTemplate);
    assertEquals("{\r\n  \"enabled\" : true,\r\n  \"icon\" : \"\",\r\n  \"color\" : \"Color\"\r\n}",
        nextResult.toPrettyString());
    assertEquals("{\r\n" + "  \"icon\" : {\r\n" + "    \"enabled\" : true,\r\n" + "    \"icon\" : \"\",\r\n"
        + "    \"color\" : \"Color\"\r\n" + "  },\r\n" + "  \"actionButtonConfig\" : {\r\n"
        + "    \"enabled\" : true,\r\n" + "    \"text\" : \"Button\",\r\n" + "    \"linkType\" : \"LINK\",\r\n"
        + "    \"link\" : \"Link\"\r\n" + "  }\r\n" + "}", additionalConfig.toPrettyString());
    assertTrue(nextResult.iterator().hasNext());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test DefaultNotification_DefaultNotificationBuilder {@link DefaultNotificationBuilder#build()}.
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultNotificationBuilder.<init>()",
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
      "DefaultNotificationBuilder DefaultNotificationBuilder.type(NotificationType)"})
  public void testDefaultNotification_DefaultNotificationBuilderBuild() {
    // Arrange
    DefaultNotificationBuilder nameResult = DefaultNotification.builder()
        .button("Button")
        .color("Color")
        .icon("Icon")
        .link("Link")
        .name("Name");
    DefaultRule rule = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();

    // Act
    DefaultNotification actualBuildResult = nameResult.rule(rule)
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
    DefaultRule rule2 = actualBuildResult.getRule();
    assertEquals("Name", rule2.getName());
    assertEquals("Text", actualBuildResult.getText());
    assertEquals("The characteristics of someone or something", rule2.getDescription());
    assertEquals(NotificationType.GENERAL, actualBuildResult.getType());
    assertTrue(rule2.getEnabled());
  }

  /**
   * Test DefaultRule {@link DefaultRule#equals(Object)}, and {@link DefaultRule#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultRule#equals(Object)}
   *   <li>{@link DefaultRule#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultRule buildResult = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(null)
        .build();
    DefaultRule buildResult2 = DefaultRule.builder()
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
   * Test DefaultRule {@link DefaultRule#equals(Object)}, and {@link DefaultRule#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultRule#equals(Object)}
   *   <li>{@link DefaultRule#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DefaultRuleBuilder defaultRuleBuilder = mock(DefaultRuleBuilder.class);
    when(defaultRuleBuilder.description(Mockito.<String>any())).thenReturn(DefaultRule.builder());
    DefaultRule buildResult = defaultRuleBuilder.description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(null)
        .build();
    DefaultRuleBuilder defaultRuleBuilder2 = mock(DefaultRuleBuilder.class);
    when(defaultRuleBuilder2.description(Mockito.<String>any())).thenReturn(DefaultRule.builder());
    DefaultRule buildResult2 = defaultRuleBuilder2.description("The characteristics of someone or something")
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
   * Test DefaultRule {@link DefaultRule#equals(Object)}, and {@link DefaultRule#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultRule#equals(Object)}
   *   <li>{@link DefaultRule#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultRule buildResult = DefaultRule.builder()
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
   * Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultRule buildResult = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultRule buildResult2 = DefaultRule.builder()
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
   * Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultRule buildResult = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(false)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultRule buildResult2 = DefaultRule.builder()
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
   * Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DefaultRule buildResult = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(null)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultRule buildResult2 = DefaultRule.builder()
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
   * Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DefaultRule buildResult = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name(null)
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultRule buildResult2 = DefaultRule.builder()
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
   * Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DefaultRule buildResult = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("42")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultRule buildResult2 = DefaultRule.builder()
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
   * Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DefaultRule buildResult = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(null)
        .build();
    DefaultRule buildResult2 = DefaultRule.builder()
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
   * Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DefaultRule buildResult = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(null)
        .name("Name")
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultRule buildResult2 = DefaultRule.builder()
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
   * Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DefaultRule buildResult = DefaultRule.builder()
        .description("The characteristics of someone or something")
        .enabled(true)
        .name(null)
        .triggerConfig(mock(NotificationRuleTriggerConfig.class))
        .build();
    DefaultRule buildResult2 = DefaultRule.builder()
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
   * Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DefaultRuleBuilder defaultRuleBuilder = mock(DefaultRuleBuilder.class);
    when(defaultRuleBuilder.description(Mockito.<String>any())).thenReturn(DefaultRule.builder());
    DefaultRule buildResult = defaultRuleBuilder.description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(null)
        .build();
    DefaultRule buildResult2 = DefaultRule.builder()
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
   * Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DefaultRuleBuilder builderResult = DefaultRule.builder();
    builderResult.description("The characteristics of someone or something");
    DefaultRuleBuilder defaultRuleBuilder = mock(DefaultRuleBuilder.class);
    when(defaultRuleBuilder.description(Mockito.<String>any())).thenReturn(builderResult);
    DefaultRule buildResult = defaultRuleBuilder.description("The characteristics of someone or something")
        .enabled(true)
        .name("Name")
        .triggerConfig(null)
        .build();
    DefaultRuleBuilder defaultRuleBuilder2 = mock(DefaultRuleBuilder.class);
    when(defaultRuleBuilder2.description(Mockito.<String>any())).thenReturn(DefaultRule.builder());
    DefaultRule buildResult2 = defaultRuleBuilder2.description("The characteristics of someone or something")
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
   * Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DefaultRule buildResult = DefaultRule.builder()
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
   * Method under test: {@link DefaultRule#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultRule.equals(Object)", "int DefaultRule.hashCode()"})
  public void testDefaultRuleEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DefaultRule buildResult = DefaultRule.builder()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultRule.<init>(String, Boolean, NotificationRuleTriggerConfig, String)",
      "String DefaultRule.getDescription()", "Boolean DefaultRule.getEnabled()", "String DefaultRule.getName()",
      "NotificationRuleTriggerConfig DefaultRule.getTriggerConfig()",
      "DefaultRule.DefaultRuleBuilder DefaultRule.toBuilder()", "String DefaultRule.toString()"})
  public void testDefaultRuleGettersAndSetters() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);

    // Act
    DefaultRule actualDefaultRule = new DefaultRule("Name", true, triggerConfig,
        "The characteristics of someone or something");
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultRule.DefaultRuleBuilder#build()}
   *   <li>{@link DefaultRule.DefaultRuleBuilder#description(String)}
   *   <li>{@link DefaultRule.DefaultRuleBuilder#enabled(Boolean)}
   *   <li>{@link DefaultRule.DefaultRuleBuilder#name(String)}
   *   <li>{@link DefaultRule.DefaultRuleBuilder#triggerConfig(NotificationRuleTriggerConfig)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultRule.DefaultRuleBuilder.<init>()",
      "DefaultRule DefaultRule.DefaultRuleBuilder.build()",
      "DefaultRule.DefaultRuleBuilder DefaultRule.DefaultRuleBuilder.description(String)",
      "DefaultRule.DefaultRuleBuilder DefaultRule.DefaultRuleBuilder.enabled(Boolean)",
      "DefaultRule.DefaultRuleBuilder DefaultRule.DefaultRuleBuilder.name(String)",
      "String DefaultRule.DefaultRuleBuilder.toString()",
      "DefaultRule.DefaultRuleBuilder DefaultRule.DefaultRuleBuilder.triggerConfig(NotificationRuleTriggerConfig)"})
  public void testDefaultRule_DefaultRuleBuilderBuild() {
    // Arrange and Act
    DefaultRule actualBuildResult = DefaultRule.builder()
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
