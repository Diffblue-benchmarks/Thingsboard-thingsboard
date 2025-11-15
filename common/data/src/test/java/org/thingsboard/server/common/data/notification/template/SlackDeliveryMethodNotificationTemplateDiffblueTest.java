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

class SlackDeliveryMethodNotificationTemplateDiffblueTest {
  /**
   * Method under test: {@link SlackDeliveryMethodNotificationTemplate#getBody()}
   */
  @Test
  void testGetBody() {
    // Arrange, Act and Assert
    assertNull((new SlackDeliveryMethodNotificationTemplate()).getBody());
  }

  /**
   * Method under test: {@link SlackDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  void testCopy() {
    // Arrange and Act
    SlackDeliveryMethodNotificationTemplate actualCopyResult = (new SlackDeliveryMethodNotificationTemplate()).copy();

    // Assert
    assertNull(actualCopyResult.getBody());
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(1, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertEquals(NotificationDeliveryMethod.SLACK, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SlackDeliveryMethodNotificationTemplate#equals(Object)}
   *   <li>{@link SlackDeliveryMethodNotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SlackDeliveryMethodNotificationTemplate slackDeliveryMethodNotificationTemplate = new SlackDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertEquals(slackDeliveryMethodNotificationTemplate, slackDeliveryMethodNotificationTemplate);
    int expectedHashCodeResult = slackDeliveryMethodNotificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, slackDeliveryMethodNotificationTemplate.hashCode());
  }

  /**
   * Method under test:
   * {@link SlackDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SlackDeliveryMethodNotificationTemplate slackDeliveryMethodNotificationTemplate = new SlackDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertNotEquals(slackDeliveryMethodNotificationTemplate, new SlackDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link SlackDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new SlackDeliveryMethodNotificationTemplate(), mock(EmailDeliveryMethodNotificationTemplate.class));
  }

  /**
   * Method under test:
   * {@link SlackDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SlackDeliveryMethodNotificationTemplate slackDeliveryMethodNotificationTemplate = new SlackDeliveryMethodNotificationTemplate();
    slackDeliveryMethodNotificationTemplate.setEnabled(true);

    // Act and Assert
    assertNotEquals(slackDeliveryMethodNotificationTemplate, new SlackDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link SlackDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SlackDeliveryMethodNotificationTemplate(), null);
  }

  /**
   * Method under test:
   * {@link SlackDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SlackDeliveryMethodNotificationTemplate(),
        "Different type to SlackDeliveryMethodNotificationTemplate");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SlackDeliveryMethodNotificationTemplate#toString()}
   *   <li>{@link SlackDeliveryMethodNotificationTemplate#getMethod()}
   *   <li>{@link SlackDeliveryMethodNotificationTemplate#getTemplatableValues()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    SlackDeliveryMethodNotificationTemplate slackDeliveryMethodNotificationTemplate = new SlackDeliveryMethodNotificationTemplate();

    // Act
    slackDeliveryMethodNotificationTemplate.toString();
    NotificationDeliveryMethod actualMethod = slackDeliveryMethodNotificationTemplate.getMethod();
    List<TemplatableValue> actualTemplatableValues = slackDeliveryMethodNotificationTemplate.getTemplatableValues();

    // Assert
    assertEquals(1, actualTemplatableValues.size());
    assertNull(actualTemplatableValues.get(0).get());
    assertEquals(NotificationDeliveryMethod.SLACK, actualMethod);
  }

  /**
   * Method under test:
   * {@link SlackDeliveryMethodNotificationTemplate#SlackDeliveryMethodNotificationTemplate()}
   */
  @Test
  void testNewSlackDeliveryMethodNotificationTemplate() {
    // Arrange and Act
    SlackDeliveryMethodNotificationTemplate actualSlackDeliveryMethodNotificationTemplate = new SlackDeliveryMethodNotificationTemplate();

    // Assert
    assertNull(actualSlackDeliveryMethodNotificationTemplate.getBody());
    List<TemplatableValue> templatableValues = actualSlackDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(1, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertEquals(NotificationDeliveryMethod.SLACK, actualSlackDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualSlackDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Method under test:
   * {@link SlackDeliveryMethodNotificationTemplate#SlackDeliveryMethodNotificationTemplate(DeliveryMethodNotificationTemplate)}
   */
  @Test
  void testNewSlackDeliveryMethodNotificationTemplate2() {
    // Arrange and Act
    SlackDeliveryMethodNotificationTemplate actualSlackDeliveryMethodNotificationTemplate = new SlackDeliveryMethodNotificationTemplate(
        new EmailDeliveryMethodNotificationTemplate());

    // Assert
    assertNull(actualSlackDeliveryMethodNotificationTemplate.getBody());
    List<TemplatableValue> templatableValues = actualSlackDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(1, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertEquals(NotificationDeliveryMethod.SLACK, actualSlackDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualSlackDeliveryMethodNotificationTemplate.isEnabled());
  }
}
