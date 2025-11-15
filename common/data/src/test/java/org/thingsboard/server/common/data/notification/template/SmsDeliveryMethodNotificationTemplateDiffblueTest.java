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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class SmsDeliveryMethodNotificationTemplateDiffblueTest {
  /**
   * Method under test: {@link SmsDeliveryMethodNotificationTemplate#getBody()}
   */
  @Test
  void testGetBody() {
    // Arrange, Act and Assert
    assertNull((new SmsDeliveryMethodNotificationTemplate()).getBody());
  }

  /**
   * Method under test: {@link SmsDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  void testCopy() {
    // Arrange and Act
    DeliveryMethodNotificationTemplate actualCopyResult = (new SmsDeliveryMethodNotificationTemplate()).copy();

    // Assert
    assertTrue(actualCopyResult instanceof SmsDeliveryMethodNotificationTemplate);
    assertNull(actualCopyResult.getBody());
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(1, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertEquals(NotificationDeliveryMethod.SMS, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SmsDeliveryMethodNotificationTemplate#equals(Object)}
   *   <li>{@link SmsDeliveryMethodNotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SmsDeliveryMethodNotificationTemplate smsDeliveryMethodNotificationTemplate = new SmsDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertEquals(smsDeliveryMethodNotificationTemplate, smsDeliveryMethodNotificationTemplate);
    int expectedHashCodeResult = smsDeliveryMethodNotificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, smsDeliveryMethodNotificationTemplate.hashCode());
  }

  /**
   * Method under test:
   * {@link SmsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SmsDeliveryMethodNotificationTemplate smsDeliveryMethodNotificationTemplate = new SmsDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertNotEquals(smsDeliveryMethodNotificationTemplate, new SmsDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link SmsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new SmsDeliveryMethodNotificationTemplate(), mock(EmailDeliveryMethodNotificationTemplate.class));
  }

  /**
   * Method under test:
   * {@link SmsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SmsDeliveryMethodNotificationTemplate smsDeliveryMethodNotificationTemplate = new SmsDeliveryMethodNotificationTemplate();
    smsDeliveryMethodNotificationTemplate.setEnabled(true);

    // Act and Assert
    assertNotEquals(smsDeliveryMethodNotificationTemplate, new SmsDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link SmsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SmsDeliveryMethodNotificationTemplate(), null);
  }

  /**
   * Method under test:
   * {@link SmsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SmsDeliveryMethodNotificationTemplate(),
        "Different type to SmsDeliveryMethodNotificationTemplate");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SmsDeliveryMethodNotificationTemplate#toString()}
   *   <li>{@link SmsDeliveryMethodNotificationTemplate#getMethod()}
   *   <li>{@link SmsDeliveryMethodNotificationTemplate#getTemplatableValues()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    SmsDeliveryMethodNotificationTemplate smsDeliveryMethodNotificationTemplate = new SmsDeliveryMethodNotificationTemplate();

    // Act
    smsDeliveryMethodNotificationTemplate.toString();
    NotificationDeliveryMethod actualMethod = smsDeliveryMethodNotificationTemplate.getMethod();
    List<TemplatableValue> actualTemplatableValues = smsDeliveryMethodNotificationTemplate.getTemplatableValues();

    // Assert
    assertEquals(1, actualTemplatableValues.size());
    assertNull(actualTemplatableValues.get(0).get());
    assertEquals(NotificationDeliveryMethod.SMS, actualMethod);
  }

  /**
   * Method under test:
   * {@link SmsDeliveryMethodNotificationTemplate#SmsDeliveryMethodNotificationTemplate()}
   */
  @Test
  void testNewSmsDeliveryMethodNotificationTemplate() {
    // Arrange and Act
    SmsDeliveryMethodNotificationTemplate actualSmsDeliveryMethodNotificationTemplate = new SmsDeliveryMethodNotificationTemplate();

    // Assert
    assertNull(actualSmsDeliveryMethodNotificationTemplate.getBody());
    List<TemplatableValue> templatableValues = actualSmsDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(1, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertEquals(NotificationDeliveryMethod.SMS, actualSmsDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualSmsDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Method under test:
   * {@link SmsDeliveryMethodNotificationTemplate#SmsDeliveryMethodNotificationTemplate(SmsDeliveryMethodNotificationTemplate)}
   */
  @Test
  void testNewSmsDeliveryMethodNotificationTemplate2() {
    // Arrange and Act
    SmsDeliveryMethodNotificationTemplate actualSmsDeliveryMethodNotificationTemplate = new SmsDeliveryMethodNotificationTemplate(
        new SmsDeliveryMethodNotificationTemplate());

    // Assert
    assertNull(actualSmsDeliveryMethodNotificationTemplate.getBody());
    List<TemplatableValue> templatableValues = actualSmsDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(1, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertEquals(NotificationDeliveryMethod.SMS, actualSmsDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualSmsDeliveryMethodNotificationTemplate.isEnabled());
  }
}
