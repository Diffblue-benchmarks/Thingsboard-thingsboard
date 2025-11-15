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
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class MobileAppDeliveryMethodNotificationTemplateDiffblueTest {
  /**
   * Method under test: {@link MobileAppDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  void testCopy() {
    // Arrange and Act
    MobileAppDeliveryMethodNotificationTemplate actualCopyResult = (new MobileAppDeliveryMethodNotificationTemplate())
        .copy();

    // Assert
    assertNull(actualCopyResult.getAdditionalConfig());
    assertNull(actualCopyResult.getBody());
    assertNull(actualCopyResult.getSubject());
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.MOBILE_APP, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate = new MobileAppDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertEquals(mobileAppDeliveryMethodNotificationTemplate, mobileAppDeliveryMethodNotificationTemplate);
    int expectedHashCodeResult = mobileAppDeliveryMethodNotificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppDeliveryMethodNotificationTemplate.hashCode());
  }

  /**
   * Method under test:
   * {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate = new MobileAppDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertNotEquals(mobileAppDeliveryMethodNotificationTemplate, new MobileAppDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppDeliveryMethodNotificationTemplate(),
        mock(EmailDeliveryMethodNotificationTemplate.class));
  }

  /**
   * Method under test:
   * {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate = new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(mobileAppDeliveryMethodNotificationTemplate, new MobileAppDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate = new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate.setAdditionalConfig(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(mobileAppDeliveryMethodNotificationTemplate, new MobileAppDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate = new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate.setEnabled(true);

    // Act and Assert
    assertNotEquals(mobileAppDeliveryMethodNotificationTemplate, new MobileAppDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate = new MobileAppDeliveryMethodNotificationTemplate();

    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate2 = new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(mobileAppDeliveryMethodNotificationTemplate, mobileAppDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate = new MobileAppDeliveryMethodNotificationTemplate();

    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate2 = new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate2.setAdditionalConfig(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(mobileAppDeliveryMethodNotificationTemplate, mobileAppDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate = new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate2 = new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(mobileAppDeliveryMethodNotificationTemplate, mobileAppDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate = new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate.setAdditionalConfig(MissingNode.getInstance());

    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate2 = new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate2.setAdditionalConfig(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(mobileAppDeliveryMethodNotificationTemplate, mobileAppDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppDeliveryMethodNotificationTemplate(), null);
  }

  /**
   * Method under test:
   * {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppDeliveryMethodNotificationTemplate(),
        "Different type to MobileAppDeliveryMethodNotificationTemplate");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MobileAppDeliveryMethodNotificationTemplate#setAdditionalConfig(JsonNode)}
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#setSubject(String)}
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#toString()}
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#getAdditionalConfig()}
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#getMethod()}
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#getSubject()}
   *   <li>
   * {@link MobileAppDeliveryMethodNotificationTemplate#getTemplatableValues()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate = new MobileAppDeliveryMethodNotificationTemplate();
    MissingNode additionalConfig = MissingNode.getInstance();

    // Act
    mobileAppDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);
    mobileAppDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");
    mobileAppDeliveryMethodNotificationTemplate.toString();
    JsonNode actualAdditionalConfig = mobileAppDeliveryMethodNotificationTemplate.getAdditionalConfig();
    NotificationDeliveryMethod actualMethod = mobileAppDeliveryMethodNotificationTemplate.getMethod();
    String actualSubject = mobileAppDeliveryMethodNotificationTemplate.getSubject();
    List<TemplatableValue> actualTemplatableValues = mobileAppDeliveryMethodNotificationTemplate.getTemplatableValues();

    // Assert that nothing has changed
    assertEquals("Hello from the Dreaming Spires", actualSubject);
    assertEquals(2, actualTemplatableValues.size());
    assertEquals("Hello from the Dreaming Spires", actualTemplatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.MOBILE_APP, actualMethod);
    assertSame(additionalConfig, actualAdditionalConfig);
  }

  /**
   * Method under test:
   * {@link MobileAppDeliveryMethodNotificationTemplate#MobileAppDeliveryMethodNotificationTemplate()}
   */
  @Test
  void testNewMobileAppDeliveryMethodNotificationTemplate() {
    // Arrange and Act
    MobileAppDeliveryMethodNotificationTemplate actualMobileAppDeliveryMethodNotificationTemplate = new MobileAppDeliveryMethodNotificationTemplate();

    // Assert
    assertNull(actualMobileAppDeliveryMethodNotificationTemplate.getAdditionalConfig());
    assertNull(actualMobileAppDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualMobileAppDeliveryMethodNotificationTemplate.getSubject());
    List<TemplatableValue> templatableValues = actualMobileAppDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.MOBILE_APP, actualMobileAppDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualMobileAppDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Method under test:
   * {@link MobileAppDeliveryMethodNotificationTemplate#MobileAppDeliveryMethodNotificationTemplate(MobileAppDeliveryMethodNotificationTemplate)}
   */
  @Test
  void testNewMobileAppDeliveryMethodNotificationTemplate2() {
    // Arrange and Act
    MobileAppDeliveryMethodNotificationTemplate actualMobileAppDeliveryMethodNotificationTemplate = new MobileAppDeliveryMethodNotificationTemplate(
        new MobileAppDeliveryMethodNotificationTemplate());

    // Assert
    assertNull(actualMobileAppDeliveryMethodNotificationTemplate.getAdditionalConfig());
    assertNull(actualMobileAppDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualMobileAppDeliveryMethodNotificationTemplate.getSubject());
    List<TemplatableValue> templatableValues = actualMobileAppDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.MOBILE_APP, actualMobileAppDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualMobileAppDeliveryMethodNotificationTemplate.isEnabled());
  }
}
