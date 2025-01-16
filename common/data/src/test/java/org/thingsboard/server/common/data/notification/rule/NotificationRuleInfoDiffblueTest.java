package org.thingsboard.server.common.data.notification.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerConfig;

class NotificationRuleInfoDiffblueTest {
  /**
   * Test {@link NotificationRuleInfo#equals(Object)}, and
   * {@link NotificationRuleInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleInfo#equals(Object)}
   *   <li>{@link NotificationRuleInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    NotificationRuleInfo notificationRuleInfo2 = new NotificationRuleInfo();

    // Act and Assert
    assertEquals(notificationRuleInfo, notificationRuleInfo2);
    int expectedHashCodeResult = notificationRuleInfo.hashCode();
    assertEquals(expectedHashCodeResult, notificationRuleInfo2.hashCode());
  }

  /**
   * Test {@link NotificationRuleInfo#equals(Object)}, and
   * {@link NotificationRuleInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleInfo#equals(Object)}
   *   <li>{@link NotificationRuleInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationRule rule = new NotificationRule();
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo(rule, "Template Name", new ArrayList<>());
    NotificationRule rule2 = new NotificationRule();
    NotificationRuleInfo notificationRuleInfo2 = new NotificationRuleInfo(rule2, "Template Name", new ArrayList<>());

    // Act and Assert
    assertEquals(notificationRuleInfo, notificationRuleInfo2);
    int expectedHashCodeResult = notificationRuleInfo.hashCode();
    assertEquals(expectedHashCodeResult, notificationRuleInfo2.hashCode());
  }

  /**
   * Test {@link NotificationRuleInfo#equals(Object)}, and
   * {@link NotificationRuleInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleInfo#equals(Object)}
   *   <li>{@link NotificationRuleInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();

    // Act and Assert
    assertEquals(notificationRuleInfo, notificationRuleInfo);
    int expectedHashCodeResult = notificationRuleInfo.hashCode();
    assertEquals(expectedHashCodeResult, notificationRuleInfo.hashCode());
  }

  /**
   * Test {@link NotificationRuleInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRule rule = new NotificationRule();
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo(rule, "Template Name", new ArrayList<>());

    // Act and Assert
    assertNotEquals(notificationRuleInfo, new NotificationRuleInfo());
  }

  /**
   * Test {@link NotificationRuleInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    NotificationRule rule = new NotificationRule();

    // Act and Assert
    assertNotEquals(notificationRuleInfo, new NotificationRuleInfo(rule, "Template Name", new ArrayList<>()));
  }

  /**
   * Test {@link NotificationRuleInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));

    // Act and Assert
    assertNotEquals(notificationRuleInfo, 1);
  }

  /**
   * Test {@link NotificationRuleInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setDeliveryMethods(new ArrayList<>());

    // Act and Assert
    assertNotEquals(notificationRuleInfo, new NotificationRuleInfo());
  }

  /**
   * Test {@link NotificationRuleInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(notificationRuleInfo, new NotificationRuleInfo());
  }

  /**
   * Test {@link NotificationRuleInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();

    NotificationRuleInfo notificationRuleInfo2 = new NotificationRuleInfo();
    notificationRuleInfo2.setDeliveryMethods(new ArrayList<>());

    // Act and Assert
    assertNotEquals(notificationRuleInfo, notificationRuleInfo2);
  }

  /**
   * Test {@link NotificationRuleInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRuleInfo(), null);
  }

  /**
   * Test {@link NotificationRuleInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRuleInfo(), "Different type to NotificationRuleInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleInfo#NotificationRuleInfo()}
   *   <li>{@link NotificationRuleInfo#setDeliveryMethods(List)}
   *   <li>{@link NotificationRuleInfo#setTemplateName(String)}
   *   <li>{@link NotificationRuleInfo#toString()}
   *   <li>{@link NotificationRuleInfo#getDeliveryMethods()}
   *   <li>{@link NotificationRuleInfo#getTemplateName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationRuleInfo actualNotificationRuleInfo = new NotificationRuleInfo();
    ArrayList<NotificationDeliveryMethod> deliveryMethods = new ArrayList<>();
    actualNotificationRuleInfo.setDeliveryMethods(deliveryMethods);
    actualNotificationRuleInfo.setTemplateName("Template Name");
    String actualToStringResult = actualNotificationRuleInfo.toString();
    List<NotificationDeliveryMethod> actualDeliveryMethods = actualNotificationRuleInfo.getDeliveryMethods();

    // Assert that nothing has changed
    assertEquals("NotificationRuleInfo(templateName=Template Name, deliveryMethods=[])", actualToStringResult);
    assertEquals("Template Name", actualNotificationRuleInfo.getTemplateName());
    assertEquals(0L, actualNotificationRuleInfo.getCreatedTime());
    assertFalse(actualNotificationRuleInfo.isEnabled());
    assertTrue(actualDeliveryMethods.isEmpty());
    assertSame(deliveryMethods, actualDeliveryMethods);
  }

  /**
   * Test
   * {@link NotificationRuleInfo#NotificationRuleInfo(NotificationRule, String, List)}.
   * <ul>
   *   <li>Given {@code EMAIL}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code EMAIL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleInfo#NotificationRuleInfo(NotificationRule, String, List)}
   */
  @Test
  @DisplayName("Test new NotificationRuleInfo(NotificationRule, String, List); given 'EMAIL'; when ArrayList() add 'EMAIL'")
  void testNewNotificationRuleInfo_givenEmail_whenArrayListAddEmail() {
    // Arrange
    NotificationRule rule = new NotificationRule();

    ArrayList<NotificationDeliveryMethod> deliveryMethods = new ArrayList<>();
    deliveryMethods.add(NotificationDeliveryMethod.EMAIL);
    deliveryMethods.add(NotificationDeliveryMethod.WEB);

    // Act
    NotificationRuleInfo actualNotificationRuleInfo = new NotificationRuleInfo(rule, "Template Name", deliveryMethods);

    // Assert
    assertEquals("Template Name", actualNotificationRuleInfo.getTemplateName());
    assertNull(actualNotificationRuleInfo.getName());
    assertNull(actualNotificationRuleInfo.getUuidId());
    assertNull(actualNotificationRuleInfo.getId());
    assertNull(actualNotificationRuleInfo.getExternalId());
    assertNull(actualNotificationRuleInfo.getTemplateId());
    assertNull(actualNotificationRuleInfo.getTenantId());
    assertNull(actualNotificationRuleInfo.getAdditionalConfig());
    assertNull(actualNotificationRuleInfo.getRecipientsConfig());
    assertNull(actualNotificationRuleInfo.getTriggerConfig());
    assertNull(actualNotificationRuleInfo.getTriggerType());
    assertEquals(0L, actualNotificationRuleInfo.getCreatedTime());
    assertFalse(actualNotificationRuleInfo.isEnabled());
    assertSame(deliveryMethods, actualNotificationRuleInfo.getDeliveryMethods());
  }

  /**
   * Test
   * {@link NotificationRuleInfo#NotificationRuleInfo(NotificationRule, String, List)}.
   * <ul>
   *   <li>Given {@link NotificationRuleTriggerConfig}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleInfo#NotificationRuleInfo(NotificationRule, String, List)}
   */
  @Test
  @DisplayName("Test new NotificationRuleInfo(NotificationRule, String, List); given NotificationRuleTriggerConfig")
  void testNewNotificationRuleInfo_givenNotificationRuleTriggerConfig() {
    // Arrange
    NotificationRule rule = new NotificationRule();
    rule.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));

    // Act
    NotificationRuleInfo actualNotificationRuleInfo = new NotificationRuleInfo(rule, "Template Name",
        new ArrayList<>());

    // Assert
    assertEquals("Template Name", actualNotificationRuleInfo.getTemplateName());
    assertNull(actualNotificationRuleInfo.getName());
    assertNull(actualNotificationRuleInfo.getUuidId());
    assertNull(actualNotificationRuleInfo.getId());
    assertNull(actualNotificationRuleInfo.getExternalId());
    assertNull(actualNotificationRuleInfo.getTemplateId());
    assertNull(actualNotificationRuleInfo.getTenantId());
    assertNull(actualNotificationRuleInfo.getAdditionalConfig());
    assertNull(actualNotificationRuleInfo.getRecipientsConfig());
    assertNull(actualNotificationRuleInfo.getTriggerType());
    assertEquals(0L, actualNotificationRuleInfo.getCreatedTime());
    assertFalse(actualNotificationRuleInfo.isEnabled());
    assertTrue(actualNotificationRuleInfo.getDeliveryMethods().isEmpty());
  }

  /**
   * Test
   * {@link NotificationRuleInfo#NotificationRuleInfo(NotificationRule, String, List)}.
   * <ul>
   *   <li>Given {@code WEB}.</li>
   *   <li>Then return DeliveryMethods is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleInfo#NotificationRuleInfo(NotificationRule, String, List)}
   */
  @Test
  @DisplayName("Test new NotificationRuleInfo(NotificationRule, String, List); given 'WEB'; then return DeliveryMethods is ArrayList()")
  void testNewNotificationRuleInfo_givenWeb_thenReturnDeliveryMethodsIsArrayList() {
    // Arrange
    NotificationRule rule = new NotificationRule();

    ArrayList<NotificationDeliveryMethod> deliveryMethods = new ArrayList<>();
    deliveryMethods.add(NotificationDeliveryMethod.WEB);

    // Act
    NotificationRuleInfo actualNotificationRuleInfo = new NotificationRuleInfo(rule, "Template Name", deliveryMethods);

    // Assert
    assertEquals("Template Name", actualNotificationRuleInfo.getTemplateName());
    assertNull(actualNotificationRuleInfo.getName());
    assertNull(actualNotificationRuleInfo.getUuidId());
    assertNull(actualNotificationRuleInfo.getId());
    assertNull(actualNotificationRuleInfo.getExternalId());
    assertNull(actualNotificationRuleInfo.getTemplateId());
    assertNull(actualNotificationRuleInfo.getTenantId());
    assertNull(actualNotificationRuleInfo.getAdditionalConfig());
    assertNull(actualNotificationRuleInfo.getRecipientsConfig());
    assertNull(actualNotificationRuleInfo.getTriggerConfig());
    assertNull(actualNotificationRuleInfo.getTriggerType());
    assertEquals(0L, actualNotificationRuleInfo.getCreatedTime());
    assertFalse(actualNotificationRuleInfo.isEnabled());
    assertSame(deliveryMethods, actualNotificationRuleInfo.getDeliveryMethods());
  }

  /**
   * Test
   * {@link NotificationRuleInfo#NotificationRuleInfo(NotificationRule, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return DeliveryMethods Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleInfo#NotificationRuleInfo(NotificationRule, String, List)}
   */
  @Test
  @DisplayName("Test new NotificationRuleInfo(NotificationRule, String, List); when ArrayList(); then return DeliveryMethods Empty")
  void testNewNotificationRuleInfo_whenArrayList_thenReturnDeliveryMethodsEmpty() {
    // Arrange
    NotificationRule rule = new NotificationRule();

    // Act
    NotificationRuleInfo actualNotificationRuleInfo = new NotificationRuleInfo(rule, "Template Name",
        new ArrayList<>());

    // Assert
    assertEquals("Template Name", actualNotificationRuleInfo.getTemplateName());
    assertNull(actualNotificationRuleInfo.getName());
    assertNull(actualNotificationRuleInfo.getUuidId());
    assertNull(actualNotificationRuleInfo.getId());
    assertNull(actualNotificationRuleInfo.getExternalId());
    assertNull(actualNotificationRuleInfo.getTemplateId());
    assertNull(actualNotificationRuleInfo.getTenantId());
    assertNull(actualNotificationRuleInfo.getAdditionalConfig());
    assertNull(actualNotificationRuleInfo.getRecipientsConfig());
    assertNull(actualNotificationRuleInfo.getTriggerConfig());
    assertNull(actualNotificationRuleInfo.getTriggerType());
    assertEquals(0L, actualNotificationRuleInfo.getCreatedTime());
    assertFalse(actualNotificationRuleInfo.isEnabled());
    assertTrue(actualNotificationRuleInfo.getDeliveryMethods().isEmpty());
  }
}
