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
import static org.mockito.Mockito.mock;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class EmailDeliveryMethodNotificationTemplateDiffblueTest {
  /**
   * Method under test: {@link EmailDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  void testCopy() {
    // Arrange and Act
    EmailDeliveryMethodNotificationTemplate actualCopyResult = (new EmailDeliveryMethodNotificationTemplate()).copy();

    // Assert
    assertNull(actualCopyResult.getBody());
    assertNull(actualCopyResult.getSubject());
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   *   <li>{@link EmailDeliveryMethodNotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertEquals(emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate);
    int expectedHashCodeResult = emailDeliveryMethodNotificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, emailDeliveryMethodNotificationTemplate.hashCode());
  }

  /**
   * Method under test:
   * {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, new EmailDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailDeliveryMethodNotificationTemplate(),
        mock(MicrosoftTeamsDeliveryMethodNotificationTemplate.class));
  }

  /**
   * Method under test:
   * {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, new EmailDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate.setEnabled(true);

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, new EmailDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();

    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 = new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 = new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailDeliveryMethodNotificationTemplate(), null);
  }

  /**
   * Method under test:
   * {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailDeliveryMethodNotificationTemplate(),
        "Different type to EmailDeliveryMethodNotificationTemplate");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EmailDeliveryMethodNotificationTemplate#setSubject(String)}
   *   <li>{@link EmailDeliveryMethodNotificationTemplate#toString()}
   *   <li>{@link EmailDeliveryMethodNotificationTemplate#getMethod()}
   *   <li>{@link EmailDeliveryMethodNotificationTemplate#getSubject()}
   *   <li>{@link EmailDeliveryMethodNotificationTemplate#getTemplatableValues()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();

    // Act
    emailDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");
    emailDeliveryMethodNotificationTemplate.toString();
    NotificationDeliveryMethod actualMethod = emailDeliveryMethodNotificationTemplate.getMethod();
    String actualSubject = emailDeliveryMethodNotificationTemplate.getSubject();
    List<TemplatableValue> actualTemplatableValues = emailDeliveryMethodNotificationTemplate.getTemplatableValues();

    // Assert that nothing has changed
    assertEquals("Hello from the Dreaming Spires", actualSubject);
    assertEquals(2, actualTemplatableValues.size());
    assertEquals("Hello from the Dreaming Spires", actualTemplatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, actualMethod);
  }

  /**
   * Method under test:
   * {@link EmailDeliveryMethodNotificationTemplate#EmailDeliveryMethodNotificationTemplate()}
   */
  @Test
  void testNewEmailDeliveryMethodNotificationTemplate() {
    // Arrange and Act
    EmailDeliveryMethodNotificationTemplate actualEmailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();

    // Assert
    assertNull(actualEmailDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualEmailDeliveryMethodNotificationTemplate.getSubject());
    List<TemplatableValue> templatableValues = actualEmailDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, actualEmailDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualEmailDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Method under test:
   * {@link EmailDeliveryMethodNotificationTemplate#EmailDeliveryMethodNotificationTemplate(EmailDeliveryMethodNotificationTemplate)}
   */
  @Test
  void testNewEmailDeliveryMethodNotificationTemplate2() {
    // Arrange and Act
    EmailDeliveryMethodNotificationTemplate actualEmailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate(
        new EmailDeliveryMethodNotificationTemplate());

    // Assert
    assertNull(actualEmailDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualEmailDeliveryMethodNotificationTemplate.getSubject());
    List<TemplatableValue> templatableValues = actualEmailDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, actualEmailDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualEmailDeliveryMethodNotificationTemplate.isEnabled());
  }
}
