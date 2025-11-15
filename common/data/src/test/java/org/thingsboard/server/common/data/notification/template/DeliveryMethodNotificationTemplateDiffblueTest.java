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
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DeliveryMethodNotificationTemplateDiffblueTest {
  /**
   * Method under test:
   * {@link DeliveryMethodNotificationTemplate#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new EmailDeliveryMethodNotificationTemplate()).canEqual("Other"));
  }

  /**
   * Method under test:
   * {@link DeliveryMethodNotificationTemplate#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertTrue(emailDeliveryMethodNotificationTemplate.canEqual(new EmailDeliveryMethodNotificationTemplate()));
  }

  /**
   * Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
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
   * Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, new EmailDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(true);
    when(emailDeliveryMethodNotificationTemplate2.getBody()).thenReturn("Not all who wander are lost");
    when(emailDeliveryMethodNotificationTemplate2.getSubject()).thenReturn("Hello from the Dreaming Spires");
    when(emailDeliveryMethodNotificationTemplate2.getTemplatableValues()).thenReturn(new ArrayList<>());
    when(emailDeliveryMethodNotificationTemplate2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(false);
    when(emailDeliveryMethodNotificationTemplate2.getBody()).thenReturn("Not all who wander are lost");
    when(emailDeliveryMethodNotificationTemplate2.getSubject()).thenReturn("Hello from the Dreaming Spires");
    when(emailDeliveryMethodNotificationTemplate2.getTemplatableValues()).thenReturn(new ArrayList<>());
    when(emailDeliveryMethodNotificationTemplate2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate.setEnabled(true);
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(true);
    when(emailDeliveryMethodNotificationTemplate2.getBody()).thenReturn("Not all who wander are lost");
    when(emailDeliveryMethodNotificationTemplate2.getSubject()).thenReturn("Hello from the Dreaming Spires");
    when(emailDeliveryMethodNotificationTemplate2.getTemplatableValues()).thenReturn(new ArrayList<>());
    when(emailDeliveryMethodNotificationTemplate2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate.setBody("Not all who wander are lost");
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(false);
    when(emailDeliveryMethodNotificationTemplate2.getBody()).thenReturn("Not all who wander are lost");
    when(emailDeliveryMethodNotificationTemplate2.getSubject()).thenReturn("Hello from the Dreaming Spires");
    when(emailDeliveryMethodNotificationTemplate2.getTemplatableValues()).thenReturn(new ArrayList<>());
    when(emailDeliveryMethodNotificationTemplate2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate.setBody("Body");
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 = mock(
        EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(false);
    when(emailDeliveryMethodNotificationTemplate2.getBody()).thenReturn("Not all who wander are lost");
    when(emailDeliveryMethodNotificationTemplate2.getSubject()).thenReturn("Hello from the Dreaming Spires");
    when(emailDeliveryMethodNotificationTemplate2.getTemplatableValues()).thenReturn(new ArrayList<>());
    when(emailDeliveryMethodNotificationTemplate2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailDeliveryMethodNotificationTemplate(), null);
  }

  /**
   * Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailDeliveryMethodNotificationTemplate(),
        "Different type to DeliveryMethodNotificationTemplate");
  }

  /**
   * Method under test: {@link DeliveryMethodNotificationTemplate#getBody()}
   */
  @Test
  void testGetBody() {
    // Arrange, Act and Assert
    assertNull((new EmailDeliveryMethodNotificationTemplate()).getBody());
  }

  /**
   * Method under test: {@link DeliveryMethodNotificationTemplate#isEnabled()}
   */
  @Test
  void testIsEnabled() {
    // Arrange, Act and Assert
    assertFalse((new EmailDeliveryMethodNotificationTemplate()).isEnabled());
  }

  /**
   * Method under test: {@link DeliveryMethodNotificationTemplate#isEnabled()}
   */
  @Test
  void testIsEnabled2() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate.setEnabled(true);

    // Act and Assert
    assertTrue(emailDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Method under test: {@link DeliveryMethodNotificationTemplate#setBody(String)}
   */
  @Test
  void testSetBody() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();

    // Act
    emailDeliveryMethodNotificationTemplate.setBody("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", emailDeliveryMethodNotificationTemplate.getBody());
    List<TemplatableValue> templatableValues = emailDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertEquals("Not all who wander are lost", templatableValues.get(0).get());
  }

  /**
   * Method under test:
   * {@link DeliveryMethodNotificationTemplate#setEnabled(boolean)}
   */
  @Test
  void testSetEnabled() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();

    // Act
    emailDeliveryMethodNotificationTemplate.setEnabled(true);

    // Assert
    assertTrue(emailDeliveryMethodNotificationTemplate.isEnabled());
  }
}
