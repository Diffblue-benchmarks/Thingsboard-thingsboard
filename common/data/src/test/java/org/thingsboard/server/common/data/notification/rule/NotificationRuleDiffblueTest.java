package org.thingsboard.server.common.data.notification.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class NotificationRuleDiffblueTest {
  /**
   * Test {@link NotificationRule#equals(Object)}, and {@link NotificationRule#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRule#equals(Object)}
   *   <li>{@link NotificationRule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    NotificationRule notificationRule2 = new NotificationRule();

    // Act and Assert
    assertEquals(notificationRule, notificationRule2);
    assertEquals(notificationRule.hashCode(), notificationRule2.hashCode());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}, and {@link NotificationRule#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRule#equals(Object)}
   *   <li>{@link NotificationRule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    // Act and Assert
    assertEquals(notificationRule, notificationRule);
    int expectedHashCodeResult = notificationRule.hashCode();
    assertEquals(expectedHashCodeResult, notificationRule.hashCode());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();

    // Act and Assert
    assertNotEquals(notificationRuleInfo, new NotificationRule());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRuleInfo());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRuleInfo notificationRuleInfo = mock(NotificationRuleInfo.class);
    when(notificationRuleInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(notificationRule, notificationRuleInfo);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();

    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    NotificationRuleInfo notificationRuleInfo2 = mock(NotificationRuleInfo.class);
    when(notificationRuleInfo2.isEnabled()).thenReturn(true);
    when(notificationRuleInfo2.getName()).thenReturn("Name");
    when(notificationRuleInfo2.getTemplateName()).thenReturn("Template Name");
    when(notificationRuleInfo2.getDeliveryMethods()).thenReturn(new ArrayList<>());
    when(notificationRuleInfo2.getExternalId())
        .thenReturn(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTemplateId())
        .thenReturn(
            new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(notificationRuleInfo2.getAdditionalConfig()).thenReturn(notificationRuleConfig);
    when(notificationRuleInfo2.getRecipientsConfig())
        .thenReturn(new DefaultNotificationRuleRecipientsConfig());
    when(notificationRuleInfo2.getTriggerConfig())
        .thenReturn(mock(NotificationRuleTriggerConfig.class));
    when(notificationRuleInfo2.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(notificationRuleInfo, notificationRuleInfo2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setEnabled(true);

    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    NotificationRuleInfo notificationRuleInfo2 = mock(NotificationRuleInfo.class);
    when(notificationRuleInfo2.isEnabled()).thenReturn(true);
    when(notificationRuleInfo2.getName()).thenReturn("Name");
    when(notificationRuleInfo2.getTemplateName()).thenReturn("Template Name");
    when(notificationRuleInfo2.getDeliveryMethods()).thenReturn(new ArrayList<>());
    when(notificationRuleInfo2.getExternalId())
        .thenReturn(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTemplateId())
        .thenReturn(
            new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(notificationRuleInfo2.getAdditionalConfig()).thenReturn(notificationRuleConfig);
    when(notificationRuleInfo2.getRecipientsConfig())
        .thenReturn(new DefaultNotificationRuleRecipientsConfig());
    when(notificationRuleInfo2.getTriggerConfig())
        .thenReturn(mock(NotificationRuleTriggerConfig.class));
    when(notificationRuleInfo2.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(notificationRuleInfo, notificationRuleInfo2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setEnabled(true);

    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    NotificationRuleInfo notificationRuleInfo2 = mock(NotificationRuleInfo.class);
    when(notificationRuleInfo2.isEnabled()).thenReturn(true);
    when(notificationRuleInfo2.getName()).thenReturn("Name");
    when(notificationRuleInfo2.getTemplateName()).thenReturn("Template Name");
    when(notificationRuleInfo2.getDeliveryMethods()).thenReturn(new ArrayList<>());
    when(notificationRuleInfo2.getExternalId())
        .thenReturn(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTemplateId())
        .thenReturn(
            new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTenantId()).thenReturn(null);
    when(notificationRuleInfo2.getAdditionalConfig()).thenReturn(notificationRuleConfig);
    when(notificationRuleInfo2.getRecipientsConfig())
        .thenReturn(new DefaultNotificationRuleRecipientsConfig());
    when(notificationRuleInfo2.getTriggerConfig())
        .thenReturn(mock(NotificationRuleTriggerConfig.class));
    when(notificationRuleInfo2.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(notificationRuleInfo, notificationRuleInfo2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setTenantId(TenantId.SYS_TENANT_ID);
    notificationRuleInfo.setEnabled(true);

    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    NotificationRuleInfo notificationRuleInfo2 = mock(NotificationRuleInfo.class);
    when(notificationRuleInfo2.isEnabled()).thenReturn(true);
    when(notificationRuleInfo2.getName()).thenReturn("Name");
    when(notificationRuleInfo2.getTemplateName()).thenReturn("Template Name");
    when(notificationRuleInfo2.getDeliveryMethods()).thenReturn(new ArrayList<>());
    when(notificationRuleInfo2.getExternalId())
        .thenReturn(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTemplateId())
        .thenReturn(
            new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTenantId()).thenReturn(null);
    when(notificationRuleInfo2.getAdditionalConfig()).thenReturn(notificationRuleConfig);
    when(notificationRuleInfo2.getRecipientsConfig())
        .thenReturn(new DefaultNotificationRuleRecipientsConfig());
    when(notificationRuleInfo2.getTriggerConfig())
        .thenReturn(mock(NotificationRuleTriggerConfig.class));
    when(notificationRuleInfo2.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(notificationRuleInfo, notificationRuleInfo2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setName("Name");
    notificationRuleInfo.setEnabled(true);

    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    NotificationRuleInfo notificationRuleInfo2 = mock(NotificationRuleInfo.class);
    when(notificationRuleInfo2.isEnabled()).thenReturn(true);
    when(notificationRuleInfo2.getName()).thenReturn("Name");
    when(notificationRuleInfo2.getTemplateName()).thenReturn("Template Name");
    when(notificationRuleInfo2.getDeliveryMethods()).thenReturn(new ArrayList<>());
    when(notificationRuleInfo2.getExternalId())
        .thenReturn(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTemplateId())
        .thenReturn(
            new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTenantId()).thenReturn(null);
    when(notificationRuleInfo2.getAdditionalConfig()).thenReturn(notificationRuleConfig);
    when(notificationRuleInfo2.getRecipientsConfig())
        .thenReturn(new DefaultNotificationRuleRecipientsConfig());
    when(notificationRuleInfo2.getTriggerConfig())
        .thenReturn(mock(NotificationRuleTriggerConfig.class));
    when(notificationRuleInfo2.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(notificationRuleInfo, notificationRuleInfo2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setName("org.thingsboard.server.common.data.id.NotificationRuleId");
    notificationRuleInfo.setEnabled(true);

    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    NotificationRuleInfo notificationRuleInfo2 = mock(NotificationRuleInfo.class);
    when(notificationRuleInfo2.isEnabled()).thenReturn(true);
    when(notificationRuleInfo2.getName()).thenReturn("Name");
    when(notificationRuleInfo2.getTemplateName()).thenReturn("Template Name");
    when(notificationRuleInfo2.getDeliveryMethods()).thenReturn(new ArrayList<>());
    when(notificationRuleInfo2.getExternalId())
        .thenReturn(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTemplateId())
        .thenReturn(
            new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTenantId()).thenReturn(null);
    when(notificationRuleInfo2.getAdditionalConfig()).thenReturn(notificationRuleConfig);
    when(notificationRuleInfo2.getRecipientsConfig())
        .thenReturn(new DefaultNotificationRuleRecipientsConfig());
    when(notificationRuleInfo2.getTriggerConfig())
        .thenReturn(mock(NotificationRuleTriggerConfig.class));
    when(notificationRuleInfo2.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(notificationRuleInfo, notificationRuleInfo2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setTenantId(TenantId.SYS_TENANT_ID);
    notificationRuleInfo.setEnabled(true);

    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    NotificationRuleInfo notificationRuleInfo2 = mock(NotificationRuleInfo.class);
    when(notificationRuleInfo2.isEnabled()).thenReturn(true);
    when(notificationRuleInfo2.getName()).thenReturn("Name");
    when(notificationRuleInfo2.getTemplateName()).thenReturn("Template Name");
    when(notificationRuleInfo2.getDeliveryMethods()).thenReturn(new ArrayList<>());
    when(notificationRuleInfo2.getExternalId())
        .thenReturn(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTemplateId())
        .thenReturn(
            new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(notificationRuleInfo2.getAdditionalConfig()).thenReturn(notificationRuleConfig);
    when(notificationRuleInfo2.getRecipientsConfig())
        .thenReturn(new DefaultNotificationRuleRecipientsConfig());
    when(notificationRuleInfo2.getTriggerConfig())
        .thenReturn(mock(NotificationRuleTriggerConfig.class));
    when(notificationRuleInfo2.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(notificationRuleInfo, notificationRuleInfo2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setName("Name");
    notificationRuleInfo.setEnabled(true);

    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    NotificationRuleInfo notificationRuleInfo2 = mock(NotificationRuleInfo.class);
    when(notificationRuleInfo2.isEnabled()).thenReturn(true);
    when(notificationRuleInfo2.getName()).thenReturn("Name");
    when(notificationRuleInfo2.getTemplateName()).thenReturn("Template Name");
    when(notificationRuleInfo2.getDeliveryMethods()).thenReturn(new ArrayList<>());
    when(notificationRuleInfo2.getExternalId())
        .thenReturn(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTemplateId()).thenReturn(null);
    when(notificationRuleInfo2.getTenantId()).thenReturn(null);
    when(notificationRuleInfo2.getAdditionalConfig()).thenReturn(notificationRuleConfig);
    when(notificationRuleInfo2.getRecipientsConfig())
        .thenReturn(new DefaultNotificationRuleRecipientsConfig());
    when(notificationRuleInfo2.getTriggerConfig())
        .thenReturn(mock(NotificationRuleTriggerConfig.class));
    when(notificationRuleInfo2.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(notificationRuleInfo, notificationRuleInfo2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setTemplateId(
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    notificationRuleInfo.setName("Name");
    notificationRuleInfo.setEnabled(true);

    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    NotificationRuleInfo notificationRuleInfo2 = mock(NotificationRuleInfo.class);
    when(notificationRuleInfo2.isEnabled()).thenReturn(true);
    when(notificationRuleInfo2.getName()).thenReturn("Name");
    when(notificationRuleInfo2.getTemplateName()).thenReturn("Template Name");
    when(notificationRuleInfo2.getDeliveryMethods()).thenReturn(new ArrayList<>());
    when(notificationRuleInfo2.getExternalId())
        .thenReturn(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTemplateId()).thenReturn(null);
    when(notificationRuleInfo2.getTenantId()).thenReturn(null);
    when(notificationRuleInfo2.getAdditionalConfig()).thenReturn(notificationRuleConfig);
    when(notificationRuleInfo2.getRecipientsConfig())
        .thenReturn(new DefaultNotificationRuleRecipientsConfig());
    when(notificationRuleInfo2.getTriggerConfig())
        .thenReturn(mock(NotificationRuleTriggerConfig.class));
    when(notificationRuleInfo2.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(notificationRuleInfo, notificationRuleInfo2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleInfo.setName("Name");
    notificationRuleInfo.setEnabled(true);

    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    NotificationRuleInfo notificationRuleInfo2 = mock(NotificationRuleInfo.class);
    when(notificationRuleInfo2.isEnabled()).thenReturn(true);
    when(notificationRuleInfo2.getName()).thenReturn("Name");
    when(notificationRuleInfo2.getTemplateName()).thenReturn("Template Name");
    when(notificationRuleInfo2.getDeliveryMethods()).thenReturn(new ArrayList<>());
    when(notificationRuleInfo2.getExternalId())
        .thenReturn(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTemplateId()).thenReturn(null);
    when(notificationRuleInfo2.getTenantId()).thenReturn(null);
    when(notificationRuleInfo2.getAdditionalConfig()).thenReturn(notificationRuleConfig);
    when(notificationRuleInfo2.getRecipientsConfig())
        .thenReturn(new DefaultNotificationRuleRecipientsConfig());
    when(notificationRuleInfo2.getTriggerConfig())
        .thenReturn(mock(NotificationRuleTriggerConfig.class));
    when(notificationRuleInfo2.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(notificationRuleInfo, notificationRuleInfo2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setTriggerType(NotificationRuleTriggerType.ALARM);
    notificationRuleInfo.setName("Name");
    notificationRuleInfo.setEnabled(true);

    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    NotificationRuleInfo notificationRuleInfo2 = mock(NotificationRuleInfo.class);
    when(notificationRuleInfo2.isEnabled()).thenReturn(true);
    when(notificationRuleInfo2.getName()).thenReturn("Name");
    when(notificationRuleInfo2.getTemplateName()).thenReturn("Template Name");
    when(notificationRuleInfo2.getDeliveryMethods()).thenReturn(new ArrayList<>());
    when(notificationRuleInfo2.getExternalId())
        .thenReturn(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTemplateId()).thenReturn(null);
    when(notificationRuleInfo2.getTenantId()).thenReturn(null);
    when(notificationRuleInfo2.getAdditionalConfig()).thenReturn(notificationRuleConfig);
    when(notificationRuleInfo2.getRecipientsConfig())
        .thenReturn(new DefaultNotificationRuleRecipientsConfig());
    when(notificationRuleInfo2.getTriggerConfig())
        .thenReturn(mock(NotificationRuleTriggerConfig.class));
    when(notificationRuleInfo2.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(notificationRuleInfo, notificationRuleInfo2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setTemplateId(
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    notificationRuleInfo.setName("Name");
    notificationRuleInfo.setEnabled(true);

    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    NotificationRuleInfo notificationRuleInfo2 = mock(NotificationRuleInfo.class);
    when(notificationRuleInfo2.isEnabled()).thenReturn(true);
    when(notificationRuleInfo2.getName()).thenReturn("Name");
    when(notificationRuleInfo2.getTemplateName()).thenReturn("Template Name");
    when(notificationRuleInfo2.getDeliveryMethods()).thenReturn(new ArrayList<>());
    when(notificationRuleInfo2.getExternalId())
        .thenReturn(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTemplateId())
        .thenReturn(
            new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(notificationRuleInfo2.getTenantId()).thenReturn(null);
    when(notificationRuleInfo2.getAdditionalConfig()).thenReturn(notificationRuleConfig);
    when(notificationRuleInfo2.getRecipientsConfig())
        .thenReturn(new DefaultNotificationRuleRecipientsConfig());
    when(notificationRuleInfo2.getTriggerConfig())
        .thenReturn(mock(NotificationRuleTriggerConfig.class));
    when(notificationRuleInfo2.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(notificationRuleInfo, notificationRuleInfo2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRule(), null);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.equals(Object)", "int NotificationRule.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRule(), "Different type to NotificationRule");
  }

  /**
   * Test {@link NotificationRule#getExternalId()}.
   *
   * <p>Method under test: {@link NotificationRule#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRuleId NotificationRule.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull(new NotificationRule().getExternalId());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRule#NotificationRule()}
   *   <li>{@link NotificationRule#setAdditionalConfig(NotificationRuleConfig)}
   *   <li>{@link NotificationRule#setEnabled(boolean)}
   *   <li>{@link NotificationRule#setExternalId(NotificationRuleId)}
   *   <li>{@link NotificationRule#setName(String)}
   *   <li>{@link NotificationRule#setRecipientsConfig(NotificationRuleRecipientsConfig)}
   *   <li>{@link NotificationRule#setTemplateId(NotificationTemplateId)}
   *   <li>{@link NotificationRule#setTenantId(TenantId)}
   *   <li>{@link NotificationRule#setTriggerConfig(NotificationRuleTriggerConfig)}
   *   <li>{@link NotificationRule#setTriggerType(NotificationRuleTriggerType)}
   *   <li>{@link NotificationRule#toString()}
   *   <li>{@link NotificationRule#getAdditionalConfig()}
   *   <li>{@link NotificationRule#getName()}
   *   <li>{@link NotificationRule#getRecipientsConfig()}
   *   <li>{@link NotificationRule#getTemplateId()}
   *   <li>{@link NotificationRule#getTenantId()}
   *   <li>{@link NotificationRule#getTriggerConfig()}
   *   <li>{@link NotificationRule#getTriggerType()}
   *   <li>{@link NotificationRule#isEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationRule.<init>()",
    "NotificationRuleConfig NotificationRule.getAdditionalConfig()",
    "String NotificationRule.getName()",
    "NotificationRuleRecipientsConfig NotificationRule.getRecipientsConfig()",
    "NotificationTemplateId NotificationRule.getTemplateId()",
    "TenantId NotificationRule.getTenantId()",
    "NotificationRuleTriggerConfig NotificationRule.getTriggerConfig()",
    "NotificationRuleTriggerType NotificationRule.getTriggerType()",
    "boolean NotificationRule.isEnabled()",
    "void NotificationRule.setAdditionalConfig(NotificationRuleConfig)",
    "void NotificationRule.setEnabled(boolean)",
    "void NotificationRule.setExternalId(NotificationRuleId)",
    "void NotificationRule.setName(String)",
    "void NotificationRule.setRecipientsConfig(NotificationRuleRecipientsConfig)",
    "void NotificationRule.setTemplateId(NotificationTemplateId)",
    "void NotificationRule.setTenantId(TenantId)",
    "void NotificationRule.setTriggerConfig(NotificationRuleTriggerConfig)",
    "void NotificationRule.setTriggerType(NotificationRuleTriggerType)",
    "String NotificationRule.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationRule actualNotificationRule = new NotificationRule();
    NotificationRuleConfig additionalConfig = new NotificationRuleConfig();
    additionalConfig.setDescription("The characteristics of someone or something");
    actualNotificationRule.setAdditionalConfig(additionalConfig);
    actualNotificationRule.setEnabled(true);
    NotificationRuleId externalId =
        new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualNotificationRule.setExternalId(externalId);
    actualNotificationRule.setName("Name");
    DefaultNotificationRuleRecipientsConfig recipientsConfig =
        new DefaultNotificationRuleRecipientsConfig();
    actualNotificationRule.setRecipientsConfig(recipientsConfig);
    NotificationTemplateId templateId =
        new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualNotificationRule.setTemplateId(templateId);
    actualNotificationRule.setTenantId(TenantId.SYS_TENANT_ID);
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    actualNotificationRule.setTriggerConfig(triggerConfig);
    actualNotificationRule.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    actualNotificationRule.toString();
    NotificationRuleConfig actualAdditionalConfig = actualNotificationRule.getAdditionalConfig();
    String actualName = actualNotificationRule.getName();
    NotificationRuleRecipientsConfig actualRecipientsConfig =
        actualNotificationRule.getRecipientsConfig();
    NotificationTemplateId actualTemplateId = actualNotificationRule.getTemplateId();
    TenantId actualTenantId = actualNotificationRule.getTenantId();
    NotificationRuleTriggerConfig actualTriggerConfig = actualNotificationRule.getTriggerConfig();
    NotificationRuleTriggerType actualTriggerType = actualNotificationRule.getTriggerType();
    boolean actualIsEnabledResult = actualNotificationRule.isEnabled();

    // Assert
    assertEquals("Name", actualName);
    assertEquals(
        "The characteristics of someone or something", actualAdditionalConfig.getDescription());
    assertNull(actualNotificationRule.getId());
    assertEquals(0L, actualNotificationRule.getCreatedTime());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualTriggerType);
    assertTrue(actualIsEnabledResult);
    assertSame(externalId, actualNotificationRule.getExternalId());
    assertSame(templateId, actualTemplateId);
    assertSame(recipientsConfig, actualRecipientsConfig);
    assertSame(additionalConfig, actualAdditionalConfig);
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
    assertSame(triggerConfig, actualTriggerConfig);
  }

  /**
   * Test {@link NotificationRule#NotificationRule(NotificationRule)}.
   *
   * <p>Method under test: {@link NotificationRule#NotificationRule(NotificationRule)}
   */
  @Test
  @DisplayName("Test new NotificationRule(NotificationRule)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRule.<init>(NotificationRule)"})
  void testNewNotificationRule() {
    // Arrange
    NotificationRule other = new NotificationRule();

    // Act
    NotificationRule actualNotificationRule = new NotificationRule(other);

    // Assert
    assertEquals(other, actualNotificationRule);
  }

  /**
   * Test {@link NotificationRule#isValid()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.isValid()"})
  void testIsValid_thenReturnFalse() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTriggerConfig(triggerConfig);

    // Act
    boolean actualIsValidResult = notificationRule.isValid();

    // Assert
    verify(triggerConfig).getTriggerType();
    assertFalse(actualIsValidResult);
  }

  /**
   * Test {@link NotificationRule#isValid()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.isValid()"})
  void testIsValid_thenReturnFalse2() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setRecipientsConfig(new DefaultNotificationRuleRecipientsConfig());
    notificationRule.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRule.setTriggerConfig(triggerConfig);

    // Act
    boolean actualIsValidResult = notificationRule.isValid();

    // Assert
    verify(triggerConfig).getTriggerType();
    assertFalse(actualIsValidResult);
  }

  /**
   * Test {@link NotificationRule#isValid()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRule.isValid()"})
  void testIsValid_thenReturnTrue() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);

    DefaultNotificationRuleRecipientsConfig recipientsConfig =
        new DefaultNotificationRuleRecipientsConfig();
    recipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setRecipientsConfig(recipientsConfig);
    notificationRule.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRule.setTriggerConfig(triggerConfig);

    // Act
    boolean actualIsValidResult = notificationRule.isValid();

    // Assert
    verify(triggerConfig).getTriggerType();
    assertTrue(actualIsValidResult);
  }

  /**
   * Test {@link NotificationRule#getDeduplicationKey()}.
   *
   * <ul>
   *   <li>Then return {@code :Deduplication Key}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRule#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey(); then return ':Deduplication Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NotificationRule.getDeduplicationKey()"})
  void testGetDeduplicationKey_thenReturnDeduplicationKey() {
    // Arrange
    EscalatedNotificationRuleRecipientsConfig recipientsConfig =
        new EscalatedNotificationRuleRecipientsConfig();
    recipientsConfig.setEscalationTable(new HashMap<>());
    recipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getDeduplicationKey()).thenReturn("Deduplication Key");

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTriggerConfig(triggerConfig);
    notificationRule.setRecipientsConfig(recipientsConfig);

    // Act
    String actualDeduplicationKey = notificationRule.getDeduplicationKey();

    // Assert
    verify(triggerConfig).getDeduplicationKey();
    assertEquals(":Deduplication Key", actualDeduplicationKey);
  }
}
