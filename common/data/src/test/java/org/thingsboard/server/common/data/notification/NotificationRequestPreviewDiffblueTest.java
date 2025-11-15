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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.template.DeliveryMethodNotificationTemplate;
import org.thingsboard.server.common.data.notification.template.EmailDeliveryMethodNotificationTemplate;

class NotificationRequestPreviewDiffblueTest {
  /**
   * Test {@link NotificationRequestPreview#equals(Object)}, and {@link NotificationRequestPreview#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestPreview#equals(Object)}
   *   <li>{@link NotificationRequestPreview#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestPreview.equals(Object)", "int NotificationRequestPreview.hashCode()"})
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
   * Test {@link NotificationRequestPreview#equals(Object)}, and {@link NotificationRequestPreview#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestPreview#equals(Object)}
   *   <li>{@link NotificationRequestPreview#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestPreview.equals(Object)", "int NotificationRequestPreview.hashCode()"})
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
   * Test {@link NotificationRequestPreview#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestPreview.equals(Object)", "int NotificationRequestPreview.hashCode()"})
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
   * Test {@link NotificationRequestPreview#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestPreview.equals(Object)", "int NotificationRequestPreview.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
   * Test {@link NotificationRequestPreview#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestPreview.equals(Object)", "int NotificationRequestPreview.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
   * Test {@link NotificationRequestPreview#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestPreview.equals(Object)", "int NotificationRequestPreview.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   * Test {@link NotificationRequestPreview#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestPreview.equals(Object)", "int NotificationRequestPreview.hashCode()"})
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
   * Test {@link NotificationRequestPreview#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestPreview#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestPreview.equals(Object)", "int NotificationRequestPreview.hashCode()"})
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NotificationRequestPreview}
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRequestPreview.<init>()",
      "Map NotificationRequestPreview.getProcessedTemplates()",
      "Map NotificationRequestPreview.getRecipientsCountByTarget()",
      "Collection NotificationRequestPreview.getRecipientsPreview()",
      "int NotificationRequestPreview.getTotalRecipientsCount()",
      "void NotificationRequestPreview.setProcessedTemplates(Map)",
      "void NotificationRequestPreview.setRecipientsCountByTarget(Map)",
      "void NotificationRequestPreview.setRecipientsPreview(Collection)",
      "void NotificationRequestPreview.setTotalRecipientsCount(int)", "String NotificationRequestPreview.toString()"})
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

    // Assert
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
