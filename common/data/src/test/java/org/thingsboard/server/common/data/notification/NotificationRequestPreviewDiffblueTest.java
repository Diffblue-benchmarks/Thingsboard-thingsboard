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
package org.thingsboard.server.common.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.template.DeliveryMethodNotificationTemplate;
import org.thingsboard.server.common.data.notification.template.EmailDeliveryMethodNotificationTemplate;

class NotificationRequestPreviewDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestPreview#equals(Object)}
   *   <li>{@link NotificationRequestPreview#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRequestPreview notificationRequestPreview = new NotificationRequestPreview();
    notificationRequestPreview.setProcessedTemplates(new HashMap<>());
    notificationRequestPreview.setRecipientsCountByTarget(new HashMap<>());
    notificationRequestPreview.setRecipientsPreview(new ArrayList<>());
    notificationRequestPreview.setTotalRecipientsCount(3);

    NotificationRequestPreview notificationRequestPreview2 = new NotificationRequestPreview();
    notificationRequestPreview2.setProcessedTemplates(new HashMap<>());
    notificationRequestPreview2.setRecipientsCountByTarget(new HashMap<>());
    notificationRequestPreview2.setRecipientsPreview(new ArrayList<>());
    notificationRequestPreview2.setTotalRecipientsCount(3);

    // Act and Assert
    assertEquals(notificationRequestPreview, notificationRequestPreview2);
    int expectedHashCodeResult = notificationRequestPreview.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestPreview2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestPreview#equals(Object)}
   *   <li>{@link NotificationRequestPreview#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRequestPreview notificationRequestPreview = new NotificationRequestPreview();
    notificationRequestPreview.setProcessedTemplates(new HashMap<>());
    notificationRequestPreview.setRecipientsCountByTarget(new HashMap<>());
    notificationRequestPreview.setRecipientsPreview(new ArrayList<>());
    notificationRequestPreview.setTotalRecipientsCount(3);

    // Act and Assert
    assertEquals(notificationRequestPreview, notificationRequestPreview);
    int expectedHashCodeResult = notificationRequestPreview.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestPreview.hashCode());
  }

  /**
   * Method under test: {@link NotificationRequestPreview#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> processedTemplates = new HashMap<>();
    processedTemplates.put(NotificationDeliveryMethod.WEB, new EmailDeliveryMethodNotificationTemplate());

    NotificationRequestPreview notificationRequestPreview = new NotificationRequestPreview();
    notificationRequestPreview.setProcessedTemplates(processedTemplates);
    notificationRequestPreview.setRecipientsCountByTarget(new HashMap<>());
    notificationRequestPreview.setRecipientsPreview(new ArrayList<>());
    notificationRequestPreview.setTotalRecipientsCount(3);

    NotificationRequestPreview notificationRequestPreview2 = new NotificationRequestPreview();
    notificationRequestPreview2.setProcessedTemplates(new HashMap<>());
    notificationRequestPreview2.setRecipientsCountByTarget(new HashMap<>());
    notificationRequestPreview2.setRecipientsPreview(new ArrayList<>());
    notificationRequestPreview2.setTotalRecipientsCount(3);

    // Act and Assert
    assertNotEquals(notificationRequestPreview, notificationRequestPreview2);
  }

  /**
   * Method under test: {@link NotificationRequestPreview#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> processedTemplates = new HashMap<>();
    processedTemplates.computeIfPresent(NotificationDeliveryMethod.WEB, mock(BiFunction.class));
    processedTemplates.put(NotificationDeliveryMethod.WEB, new EmailDeliveryMethodNotificationTemplate());

    NotificationRequestPreview notificationRequestPreview = new NotificationRequestPreview();
    notificationRequestPreview.setProcessedTemplates(processedTemplates);
    notificationRequestPreview.setRecipientsCountByTarget(new HashMap<>());
    notificationRequestPreview.setRecipientsPreview(new ArrayList<>());
    notificationRequestPreview.setTotalRecipientsCount(3);

    NotificationRequestPreview notificationRequestPreview2 = new NotificationRequestPreview();
    notificationRequestPreview2.setProcessedTemplates(new HashMap<>());
    notificationRequestPreview2.setRecipientsCountByTarget(new HashMap<>());
    notificationRequestPreview2.setRecipientsPreview(new ArrayList<>());
    notificationRequestPreview2.setTotalRecipientsCount(3);

    // Act and Assert
    assertNotEquals(notificationRequestPreview, notificationRequestPreview2);
  }

  /**
   * Method under test: {@link NotificationRequestPreview#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashMap<String, Integer> recipientsCountByTarget = new HashMap<>();
    recipientsCountByTarget.put("foo", 1);

    NotificationRequestPreview notificationRequestPreview = new NotificationRequestPreview();
    notificationRequestPreview.setProcessedTemplates(new HashMap<>());
    notificationRequestPreview.setRecipientsCountByTarget(recipientsCountByTarget);
    notificationRequestPreview.setRecipientsPreview(new ArrayList<>());
    notificationRequestPreview.setTotalRecipientsCount(3);

    NotificationRequestPreview notificationRequestPreview2 = new NotificationRequestPreview();
    notificationRequestPreview2.setProcessedTemplates(new HashMap<>());
    notificationRequestPreview2.setRecipientsCountByTarget(new HashMap<>());
    notificationRequestPreview2.setRecipientsPreview(new ArrayList<>());
    notificationRequestPreview2.setTotalRecipientsCount(3);

    // Act and Assert
    assertNotEquals(notificationRequestPreview, notificationRequestPreview2);
  }

  /**
   * Method under test: {@link NotificationRequestPreview#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<String> recipientsPreview = new ArrayList<>();
    recipientsPreview.add("foo");

    NotificationRequestPreview notificationRequestPreview = new NotificationRequestPreview();
    notificationRequestPreview.setProcessedTemplates(new HashMap<>());
    notificationRequestPreview.setRecipientsCountByTarget(new HashMap<>());
    notificationRequestPreview.setRecipientsPreview(recipientsPreview);
    notificationRequestPreview.setTotalRecipientsCount(3);

    NotificationRequestPreview notificationRequestPreview2 = new NotificationRequestPreview();
    notificationRequestPreview2.setProcessedTemplates(new HashMap<>());
    notificationRequestPreview2.setRecipientsCountByTarget(new HashMap<>());
    notificationRequestPreview2.setRecipientsPreview(new ArrayList<>());
    notificationRequestPreview2.setTotalRecipientsCount(3);

    // Act and Assert
    assertNotEquals(notificationRequestPreview, notificationRequestPreview2);
  }

  /**
   * Method under test: {@link NotificationRequestPreview#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRequestPreview notificationRequestPreview = new NotificationRequestPreview();
    notificationRequestPreview.setProcessedTemplates(new HashMap<>());
    notificationRequestPreview.setRecipientsCountByTarget(new HashMap<>());
    notificationRequestPreview.setRecipientsPreview(new ArrayList<>());
    notificationRequestPreview.setTotalRecipientsCount(1);

    NotificationRequestPreview notificationRequestPreview2 = new NotificationRequestPreview();
    notificationRequestPreview2.setProcessedTemplates(new HashMap<>());
    notificationRequestPreview2.setRecipientsCountByTarget(new HashMap<>());
    notificationRequestPreview2.setRecipientsPreview(new ArrayList<>());
    notificationRequestPreview2.setTotalRecipientsCount(3);

    // Act and Assert
    assertNotEquals(notificationRequestPreview, notificationRequestPreview2);
  }

  /**
   * Method under test: {@link NotificationRequestPreview#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRequestPreview notificationRequestPreview = new NotificationRequestPreview();
    notificationRequestPreview.setProcessedTemplates(new HashMap<>());
    notificationRequestPreview.setRecipientsCountByTarget(new HashMap<>());
    notificationRequestPreview.setRecipientsPreview(new ArrayList<>());
    notificationRequestPreview.setTotalRecipientsCount(3);

    // Act and Assert
    assertNotEquals(notificationRequestPreview, null);
  }

  /**
   * Method under test: {@link NotificationRequestPreview#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRequestPreview notificationRequestPreview = new NotificationRequestPreview();
    notificationRequestPreview.setProcessedTemplates(new HashMap<>());
    notificationRequestPreview.setRecipientsCountByTarget(new HashMap<>());
    notificationRequestPreview.setRecipientsPreview(new ArrayList<>());
    notificationRequestPreview.setTotalRecipientsCount(3);

    // Act and Assert
    assertNotEquals(notificationRequestPreview, "Different type to NotificationRequestPreview");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link NotificationRequestPreview}
   *   <li>{@link NotificationRequestPreview#setProcessedTemplates(Map)}
   *   <li>{@link NotificationRequestPreview#setRecipientsCountByTarget(Map)}
   *   <li>{@link NotificationRequestPreview#setRecipientsPreview(Collection)}
   *   <li>{@link NotificationRequestPreview#setTotalRecipientsCount(int)}
   *   <li>{@link NotificationRequestPreview#toString()}
   *   <li>{@link NotificationRequestPreview#getProcessedTemplates()}
   *   <li>{@link NotificationRequestPreview#getRecipientsCountByTarget()}
   *   <li>{@link NotificationRequestPreview#getRecipientsPreview()}
   *   <li>{@link NotificationRequestPreview#getTotalRecipientsCount()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationRequestPreview actualNotificationRequestPreview = new NotificationRequestPreview();
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> processedTemplates = new HashMap<>();
    actualNotificationRequestPreview.setProcessedTemplates(processedTemplates);
    HashMap<String, Integer> recipientsCountByTarget = new HashMap<>();
    actualNotificationRequestPreview.setRecipientsCountByTarget(recipientsCountByTarget);
    ArrayList<String> recipientsPreview = new ArrayList<>();
    actualNotificationRequestPreview.setRecipientsPreview(recipientsPreview);
    actualNotificationRequestPreview.setTotalRecipientsCount(3);
    String actualToStringResult = actualNotificationRequestPreview.toString();
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> actualProcessedTemplates = actualNotificationRequestPreview
        .getProcessedTemplates();
    Map<String, Integer> actualRecipientsCountByTarget = actualNotificationRequestPreview.getRecipientsCountByTarget();
    Collection<String> actualRecipientsPreview = actualNotificationRequestPreview.getRecipientsPreview();

    // Assert that nothing has changed
    assertTrue(actualRecipientsPreview instanceof List);
    assertEquals("NotificationRequestPreview(processedTemplates={}, totalRecipientsCount=3, recipientsCountByTarget={},"
        + " recipientsPreview=[])", actualToStringResult);
    assertEquals(3, actualNotificationRequestPreview.getTotalRecipientsCount());
    assertTrue(actualProcessedTemplates.isEmpty());
    assertTrue(actualRecipientsCountByTarget.isEmpty());
    assertSame(recipientsPreview, actualRecipientsPreview);
    assertSame(processedTemplates, actualProcessedTemplates);
    assertSame(recipientsCountByTarget, actualRecipientsCountByTarget);
  }
}
