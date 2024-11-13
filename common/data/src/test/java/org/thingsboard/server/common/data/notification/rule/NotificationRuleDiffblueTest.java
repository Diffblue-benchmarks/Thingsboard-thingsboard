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
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class NotificationRuleDiffblueTest {
  /**
   * Test {@link NotificationRule#equals(Object)}, and
   * {@link NotificationRule#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRule#equals(Object)}
   *   <li>{@link NotificationRule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    NotificationRule notificationRule2 = new NotificationRule();

    // Act and Assert
    assertEquals(notificationRule, notificationRule2);
    int expectedHashCodeResult = notificationRule.hashCode();
    assertEquals(expectedHashCodeResult, notificationRule2.hashCode());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}, and
   * {@link NotificationRule#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRule#equals(Object)}
   *   <li>{@link NotificationRule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();

    // Act and Assert
    assertNotEquals(notificationRuleInfo, new NotificationRule());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRuleInfo());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));

    // Act and Assert
    assertNotEquals(notificationRule, 1);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    NotificationRuleInfo notificationRuleInfo = mock(NotificationRuleInfo.class);
    when(notificationRuleInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(notificationRule, notificationRuleInfo);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setName("Name");

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setEnabled(true);

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTemplateId(new NotificationTemplateId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setRecipientsConfig(new DefaultNotificationRuleRecipientsConfig());

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NotificationRuleConfig additionalConfig = new NotificationRuleConfig();
    additionalConfig.setDescription("The characteristics of someone or something");

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setAdditionalConfig(additionalConfig);

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setExternalId(new NotificationRuleId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setName("Name");

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setTemplateId(new NotificationTemplateId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setRecipientsConfig(new DefaultNotificationRuleRecipientsConfig());

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRuleConfig additionalConfig = new NotificationRuleConfig();
    additionalConfig.setDescription("The characteristics of someone or something");

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setAdditionalConfig(additionalConfig);

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setExternalId(new NotificationRuleId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRule(), null);
  }

  /**
   * Test {@link NotificationRule#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRule(), "Different type to NotificationRule");
  }

  /**
   * Test {@link NotificationRule#getExternalId()}.
   * <p>
   * Method under test: {@link NotificationRule#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  void testGetExternalId() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));

    // Act and Assert
    assertNull(notificationRule.getExternalId());
  }

  /**
   * Test {@link NotificationRule#getExternalId()}.
   * <ul>
   *   <li>Given {@link NotificationRule#NotificationRule()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId(); given NotificationRule()")
  void testGetExternalId_givenNotificationRule() {
    // Arrange, Act and Assert
    assertNull((new NotificationRule()).getExternalId());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRule#NotificationRule()}
   *   <li>{@link NotificationRule#setAdditionalConfig(NotificationRuleConfig)}
   *   <li>{@link NotificationRule#setEnabled(boolean)}
   *   <li>{@link NotificationRule#setExternalId(NotificationRuleId)}
   *   <li>{@link NotificationRule#setName(String)}
   *   <li>
   * {@link NotificationRule#setRecipientsConfig(NotificationRuleRecipientsConfig)}
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
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationRule actualNotificationRule = new NotificationRule();
    NotificationRuleConfig additionalConfig = new NotificationRuleConfig();
    additionalConfig.setDescription("The characteristics of someone or something");
    actualNotificationRule.setAdditionalConfig(additionalConfig);
    actualNotificationRule.setEnabled(true);
    NotificationRuleId externalId = new NotificationRuleId(EntityId.NULL_UUID);
    actualNotificationRule.setExternalId(externalId);
    actualNotificationRule.setName("Name");
    DefaultNotificationRuleRecipientsConfig recipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    actualNotificationRule.setRecipientsConfig(recipientsConfig);
    NotificationTemplateId templateId = new NotificationTemplateId(EntityId.NULL_UUID);
    actualNotificationRule.setTemplateId(templateId);
    actualNotificationRule.setTenantId(TenantId.SYS_TENANT_ID);
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    actualNotificationRule.setTriggerConfig(triggerConfig);
    actualNotificationRule.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    actualNotificationRule.toString();
    NotificationRuleConfig actualAdditionalConfig = actualNotificationRule.getAdditionalConfig();
    String actualName = actualNotificationRule.getName();
    NotificationRuleRecipientsConfig actualRecipientsConfig = actualNotificationRule.getRecipientsConfig();
    NotificationTemplateId actualTemplateId = actualNotificationRule.getTemplateId();
    TenantId actualTenantId = actualNotificationRule.getTenantId();
    NotificationRuleTriggerConfig actualTriggerConfig = actualNotificationRule.getTriggerConfig();
    NotificationRuleTriggerType actualTriggerType = actualNotificationRule.getTriggerType();
    boolean actualIsEnabledResult = actualNotificationRule.isEnabled();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualAdditionalConfig.getDescription());
    assertEquals(0L, actualNotificationRule.getCreatedTime());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualTriggerType);
    assertTrue(actualIsEnabledResult);
    assertSame(externalId, actualNotificationRule.getExternalId());
    assertSame(templateId, actualTemplateId);
    assertSame(recipientsConfig, actualRecipientsConfig);
    assertSame(additionalConfig, actualAdditionalConfig);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
    assertSame(triggerConfig, actualTriggerConfig);
  }

  /**
   * Test {@link NotificationRule#NotificationRule(NotificationRule)}.
   * <ul>
   *   <li>Given {@link NotificationRuleTriggerConfig}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRule#NotificationRule(NotificationRule)}
   */
  @Test
  @DisplayName("Test new NotificationRule(NotificationRule); given NotificationRuleTriggerConfig; then return Name is 'null'")
  void testNewNotificationRule_givenNotificationRuleTriggerConfig_thenReturnNameIsNull() {
    // Arrange
    NotificationRule other = new NotificationRule();
    other.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));

    // Act
    NotificationRule actualNotificationRule = new NotificationRule(other);

    // Assert
    assertNull(actualNotificationRule.getName());
    assertNull(actualNotificationRule.getUuidId());
    assertNull(actualNotificationRule.getId());
    assertNull(actualNotificationRule.getExternalId());
    assertNull(actualNotificationRule.getTemplateId());
    assertNull(actualNotificationRule.getTenantId());
    assertNull(actualNotificationRule.getAdditionalConfig());
    assertNull(actualNotificationRule.getRecipientsConfig());
    assertNull(actualNotificationRule.getTriggerType());
    assertEquals(0L, actualNotificationRule.getCreatedTime());
    assertFalse(actualNotificationRule.isEnabled());
  }

  /**
   * Test {@link NotificationRule#NotificationRule(NotificationRule)}.
   * <ul>
   *   <li>When {@link NotificationRule#NotificationRule()}.</li>
   *   <li>Then return {@link NotificationRule#NotificationRule()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRule#NotificationRule(NotificationRule)}
   */
  @Test
  @DisplayName("Test new NotificationRule(NotificationRule); when NotificationRule(); then return NotificationRule()")
  void testNewNotificationRule_whenNotificationRule_thenReturnNotificationRule() {
    // Arrange
    NotificationRule other = new NotificationRule();

    // Act and Assert
    assertEquals(other, new NotificationRule(other));
  }

  /**
   * Test {@link NotificationRule#isValid()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then return 'false'")
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
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then return 'false'")
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
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#isValid()}
   */
  @Test
  @DisplayName("Test isValid(); then return 'true'")
  void testIsValid_thenReturnTrue() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);

    DefaultNotificationRuleRecipientsConfig recipientsConfig = new DefaultNotificationRuleRecipientsConfig();
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
   * <ul>
   *   <li>Then return {@code :Deduplication Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRule#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey(); then return ':Deduplication Key'")
  void testGetDeduplicationKey_thenReturnDeduplicationKey() {
    // Arrange
    EscalatedNotificationRuleRecipientsConfig recipientsConfig = new EscalatedNotificationRuleRecipientsConfig();
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
