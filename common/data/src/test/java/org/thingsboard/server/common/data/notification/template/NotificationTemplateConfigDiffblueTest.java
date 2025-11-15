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
package org.thingsboard.server.common.data.notification.template;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class NotificationTemplateConfigDiffblueTest {
  /**
   * Method under test: {@link NotificationTemplateConfig#copy()}
   */
  @Test
  void testCopy() {
    // Arrange
    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    notificationTemplateConfig.setDeliveryMethodsTemplates(new HashMap<>());

    // Act and Assert
    assertEquals(notificationTemplateConfig, notificationTemplateConfig.copy());
  }

  /**
   * Method under test: {@link NotificationTemplateConfig#copy()}
   */
  @Test
  void testCopy2() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = new HashMap<>();
    deliveryMethodsTemplates.put(NotificationDeliveryMethod.WEB, new EmailDeliveryMethodNotificationTemplate());

    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    notificationTemplateConfig.setDeliveryMethodsTemplates(deliveryMethodsTemplates);

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates2 = notificationTemplateConfig
        .copy()
        .getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates2.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates2.get(NotificationDeliveryMethod.WEB);
    assertTrue(getResult instanceof EmailDeliveryMethodNotificationTemplate);
    assertNull(getResult.getBody());
    assertNull(((EmailDeliveryMethodNotificationTemplate) getResult).getSubject());
    List<TemplatableValue> templatableValues = getResult.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, getResult.getMethod());
    assertFalse(getResult.isEnabled());
  }

  /**
   * Method under test: {@link NotificationTemplateConfig#copy()}
   */
  @Test
  void testCopy3() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = new HashMap<>();
    deliveryMethodsTemplates.put(NotificationDeliveryMethod.EMAIL, new EmailDeliveryMethodNotificationTemplate());
    deliveryMethodsTemplates.put(NotificationDeliveryMethod.WEB, new EmailDeliveryMethodNotificationTemplate());

    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    notificationTemplateConfig.setDeliveryMethodsTemplates(deliveryMethodsTemplates);

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates2 = notificationTemplateConfig
        .copy()
        .getDeliveryMethodsTemplates();
    assertEquals(2, deliveryMethodsTemplates2.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates2.get(NotificationDeliveryMethod.EMAIL);
    assertTrue(getResult instanceof EmailDeliveryMethodNotificationTemplate);
    DeliveryMethodNotificationTemplate getResult2 = deliveryMethodsTemplates2.get(NotificationDeliveryMethod.WEB);
    assertTrue(getResult2 instanceof EmailDeliveryMethodNotificationTemplate);
    assertNull(getResult.getBody());
    assertNull(getResult2.getBody());
    assertNull(((EmailDeliveryMethodNotificationTemplate) getResult).getSubject());
    assertNull(((EmailDeliveryMethodNotificationTemplate) getResult2).getSubject());
    List<TemplatableValue> templatableValues = getResult.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    List<TemplatableValue> templatableValues2 = getResult2.getTemplatableValues();
    assertEquals(2, templatableValues2.size());
    assertNull(templatableValues2.get(0).get());
    assertNull(templatableValues2.get(1).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, getResult.getMethod());
    assertEquals(NotificationDeliveryMethod.EMAIL, getResult2.getMethod());
    assertFalse(getResult.isEnabled());
    assertFalse(getResult2.isEnabled());
  }

  /**
   * Method under test: {@link NotificationTemplateConfig#copy()}
   */
  @Test
  void testCopy4() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = new HashMap<>();
    deliveryMethodsTemplates.computeIfPresent(NotificationDeliveryMethod.WEB, mock(BiFunction.class));
    deliveryMethodsTemplates.put(NotificationDeliveryMethod.WEB, new EmailDeliveryMethodNotificationTemplate());

    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    notificationTemplateConfig.setDeliveryMethodsTemplates(deliveryMethodsTemplates);

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates2 = notificationTemplateConfig
        .copy()
        .getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates2.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates2.get(NotificationDeliveryMethod.WEB);
    assertTrue(getResult instanceof EmailDeliveryMethodNotificationTemplate);
    assertNull(getResult.getBody());
    assertNull(((EmailDeliveryMethodNotificationTemplate) getResult).getSubject());
    List<TemplatableValue> templatableValues = getResult.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, getResult.getMethod());
    assertFalse(getResult.isEnabled());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplateConfig#equals(Object)}
   *   <li>{@link NotificationTemplateConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    NotificationTemplateConfig notificationTemplateConfig2 = new NotificationTemplateConfig();

    // Act and Assert
    assertEquals(notificationTemplateConfig, notificationTemplateConfig2);
    int expectedHashCodeResult = notificationTemplateConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplateConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplateConfig#equals(Object)}
   *   <li>{@link NotificationTemplateConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    notificationTemplateConfig.setDeliveryMethodsTemplates(new HashMap<>());

    NotificationTemplateConfig notificationTemplateConfig2 = new NotificationTemplateConfig();
    notificationTemplateConfig2.setDeliveryMethodsTemplates(new HashMap<>());

    // Act and Assert
    assertEquals(notificationTemplateConfig, notificationTemplateConfig2);
    int expectedHashCodeResult = notificationTemplateConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplateConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplateConfig#equals(Object)}
   *   <li>{@link NotificationTemplateConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();

    // Act and Assert
    assertEquals(notificationTemplateConfig, notificationTemplateConfig);
    int expectedHashCodeResult = notificationTemplateConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplateConfig.hashCode());
  }

  /**
   * Method under test: {@link NotificationTemplateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationTemplateConfig(), 1);
  }

  /**
   * Method under test: {@link NotificationTemplateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    notificationTemplateConfig.setDeliveryMethodsTemplates(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationTemplateConfig, new NotificationTemplateConfig());
  }

  /**
   * Method under test: {@link NotificationTemplateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();

    NotificationTemplateConfig notificationTemplateConfig2 = new NotificationTemplateConfig();
    notificationTemplateConfig2.setDeliveryMethodsTemplates(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationTemplateConfig, notificationTemplateConfig2);
  }

  /**
   * Method under test: {@link NotificationTemplateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = new HashMap<>();
    deliveryMethodsTemplates.computeIfPresent(NotificationDeliveryMethod.WEB, mock(BiFunction.class));

    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    notificationTemplateConfig.setDeliveryMethodsTemplates(deliveryMethodsTemplates);

    // Act and Assert
    assertNotEquals(notificationTemplateConfig, new NotificationTemplateConfig());
  }

  /**
   * Method under test: {@link NotificationTemplateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationTemplateConfig(), null);
  }

  /**
   * Method under test: {@link NotificationTemplateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationTemplateConfig(), "Different type to NotificationTemplateConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link NotificationTemplateConfig}
   *   <li>{@link NotificationTemplateConfig#setDeliveryMethodsTemplates(Map)}
   *   <li>{@link NotificationTemplateConfig#toString()}
   *   <li>{@link NotificationTemplateConfig#getDeliveryMethodsTemplates()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationTemplateConfig actualNotificationTemplateConfig = new NotificationTemplateConfig();
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = new HashMap<>();
    actualNotificationTemplateConfig.setDeliveryMethodsTemplates(deliveryMethodsTemplates);
    String actualToStringResult = actualNotificationTemplateConfig.toString();
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> actualDeliveryMethodsTemplates = actualNotificationTemplateConfig
        .getDeliveryMethodsTemplates();

    // Assert that nothing has changed
    assertEquals("NotificationTemplateConfig(deliveryMethodsTemplates={})", actualToStringResult);
    assertTrue(actualDeliveryMethodsTemplates.isEmpty());
    assertSame(deliveryMethodsTemplates, actualDeliveryMethodsTemplates);
  }
}
