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
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerConfig;

class NotificationRuleInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleInfo#equals(Object)}
   *   <li>{@link NotificationRuleInfo#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleInfo#equals(Object)}
   *   <li>{@link NotificationRuleInfo#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleInfo#equals(Object)}
   *   <li>{@link NotificationRuleInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();

    // Act and Assert
    assertEquals(notificationRuleInfo, notificationRuleInfo);
    int expectedHashCodeResult = notificationRuleInfo.hashCode();
    assertEquals(expectedHashCodeResult, notificationRuleInfo.hashCode());
  }

  /**
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRule rule = new NotificationRule();
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo(rule, "Template Name", new ArrayList<>());

    // Act and Assert
    assertNotEquals(notificationRuleInfo, new NotificationRuleInfo());
  }

  /**
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    NotificationRule rule = new NotificationRule();

    // Act and Assert
    assertNotEquals(notificationRuleInfo, new NotificationRuleInfo(rule, "Template Name", new ArrayList<>()));
  }

  /**
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));

    // Act and Assert
    assertNotEquals(notificationRuleInfo, 1);
  }

  /**
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setDeliveryMethods(new ArrayList<>());

    // Act and Assert
    assertNotEquals(notificationRuleInfo, new NotificationRuleInfo());
  }

  /**
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    notificationRuleInfo.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(notificationRuleInfo, new NotificationRuleInfo());
  }

  /**
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();

    NotificationRuleInfo notificationRuleInfo2 = new NotificationRuleInfo();
    notificationRuleInfo2.setDeliveryMethods(new ArrayList<>());

    // Act and Assert
    assertNotEquals(notificationRuleInfo, notificationRuleInfo2);
  }

  /**
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRuleInfo(), null);
  }

  /**
   * Method under test: {@link NotificationRuleInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRuleInfo(), "Different type to NotificationRuleInfo");
  }

  /**
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
   * Method under test:
   * {@link NotificationRuleInfo#NotificationRuleInfo(NotificationRule, String, List)}
   */
  @Test
  void testNewNotificationRuleInfo() {
    // Arrange
    NotificationRule rule = new NotificationRule();
    ArrayList<NotificationDeliveryMethod> deliveryMethods = new ArrayList<>();

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
    List<NotificationDeliveryMethod> deliveryMethods2 = actualNotificationRuleInfo.getDeliveryMethods();
    assertTrue(deliveryMethods2.isEmpty());
    assertSame(deliveryMethods, deliveryMethods2);
  }

  /**
   * Method under test:
   * {@link NotificationRuleInfo#NotificationRuleInfo(NotificationRule, String, List)}
   */
  @Test
  void testNewNotificationRuleInfo2() {
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
    List<NotificationDeliveryMethod> deliveryMethods2 = actualNotificationRuleInfo.getDeliveryMethods();
    assertEquals(1, deliveryMethods2.size());
    assertEquals(NotificationDeliveryMethod.WEB, deliveryMethods2.get(0));
    assertFalse(actualNotificationRuleInfo.isEnabled());
    assertSame(deliveryMethods, deliveryMethods2);
  }

  /**
   * Method under test:
   * {@link NotificationRuleInfo#NotificationRuleInfo(NotificationRule, String, List)}
   */
  @Test
  void testNewNotificationRuleInfo3() {
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
   * Method under test:
   * {@link NotificationRuleInfo#NotificationRuleInfo(NotificationRule, String, List)}
   */
  @Test
  void testNewNotificationRuleInfo4() {
    // Arrange
    NotificationRule rule = new NotificationRule();
    rule.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));
    ArrayList<NotificationDeliveryMethod> deliveryMethods = new ArrayList<>();

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
    assertNull(actualNotificationRuleInfo.getTriggerType());
    assertEquals(0L, actualNotificationRuleInfo.getCreatedTime());
    assertFalse(actualNotificationRuleInfo.isEnabled());
    List<NotificationDeliveryMethod> deliveryMethods2 = actualNotificationRuleInfo.getDeliveryMethods();
    assertTrue(deliveryMethods2.isEmpty());
    assertSame(deliveryMethods, deliveryMethods2);
  }
}
