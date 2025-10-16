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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class SlackDeliveryMethodNotificationTemplateDiffblueTest {
  /**
   * Test {@link SlackDeliveryMethodNotificationTemplate#SlackDeliveryMethodNotificationTemplate()}.
   *
   * <p>Method under test: {@link
   * SlackDeliveryMethodNotificationTemplate#SlackDeliveryMethodNotificationTemplate()}
   */
  @Test
  @DisplayName("Test new SlackDeliveryMethodNotificationTemplate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SlackDeliveryMethodNotificationTemplate.<init>()"})
  void testNewSlackDeliveryMethodNotificationTemplate() {
    // Arrange and Act
    SlackDeliveryMethodNotificationTemplate actualSlackDeliveryMethodNotificationTemplate =
        new SlackDeliveryMethodNotificationTemplate();

    // Assert
    assertNull(actualSlackDeliveryMethodNotificationTemplate.getBody());
    List<TemplatableValue> templatableValues =
        actualSlackDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(1, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertEquals(
        NotificationDeliveryMethod.SLACK,
        actualSlackDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualSlackDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Test {@link
   * SlackDeliveryMethodNotificationTemplate#SlackDeliveryMethodNotificationTemplate(DeliveryMethodNotificationTemplate)}.
   *
   * <ul>
   *   <li>Then return Body is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SlackDeliveryMethodNotificationTemplate#SlackDeliveryMethodNotificationTemplate(DeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName(
      "Test new SlackDeliveryMethodNotificationTemplate(DeliveryMethodNotificationTemplate); then return Body is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SlackDeliveryMethodNotificationTemplate.<init>(DeliveryMethodNotificationTemplate)"
  })
  void testNewSlackDeliveryMethodNotificationTemplate_thenReturnBodyIsNull() {
    // Arrange and Act
    SlackDeliveryMethodNotificationTemplate actualSlackDeliveryMethodNotificationTemplate =
        new SlackDeliveryMethodNotificationTemplate(new EmailDeliveryMethodNotificationTemplate());

    // Assert
    assertNull(actualSlackDeliveryMethodNotificationTemplate.getBody());
    List<TemplatableValue> templatableValues =
        actualSlackDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(1, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertEquals(
        NotificationDeliveryMethod.SLACK,
        actualSlackDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualSlackDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Test {@link SlackDeliveryMethodNotificationTemplate#getBody()}.
   *
   * <p>Method under test: {@link SlackDeliveryMethodNotificationTemplate#getBody()}
   */
  @Test
  @DisplayName("Test getBody()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String SlackDeliveryMethodNotificationTemplate.getBody()"})
  void testGetBody() {
    // Arrange, Act and Assert
    assertNull(new SlackDeliveryMethodNotificationTemplate().getBody());
  }

  /**
   * Test {@link SlackDeliveryMethodNotificationTemplate#equals(Object)}, and {@link
   * SlackDeliveryMethodNotificationTemplate#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlackDeliveryMethodNotificationTemplate#equals(Object)}
   *   <li>{@link SlackDeliveryMethodNotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackDeliveryMethodNotificationTemplate.equals(Object)",
    "int SlackDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SlackDeliveryMethodNotificationTemplate slackDeliveryMethodNotificationTemplate =
        new SlackDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertEquals(slackDeliveryMethodNotificationTemplate, slackDeliveryMethodNotificationTemplate);
    int expectedHashCodeResult = slackDeliveryMethodNotificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, slackDeliveryMethodNotificationTemplate.hashCode());
  }

  /**
   * Test {@link SlackDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackDeliveryMethodNotificationTemplate.equals(Object)",
    "int SlackDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SlackDeliveryMethodNotificationTemplate slackDeliveryMethodNotificationTemplate =
        new SlackDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertNotEquals(
        slackDeliveryMethodNotificationTemplate, new SlackDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link SlackDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackDeliveryMethodNotificationTemplate.equals(Object)",
    "int SlackDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SlackDeliveryMethodNotificationTemplate slackDeliveryMethodNotificationTemplate =
        new SlackDeliveryMethodNotificationTemplate();
    slackDeliveryMethodNotificationTemplate.setEnabled(true);

    // Act and Assert
    assertNotEquals(
        slackDeliveryMethodNotificationTemplate, new SlackDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link SlackDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackDeliveryMethodNotificationTemplate.equals(Object)",
    "int SlackDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SlackDeliveryMethodNotificationTemplate(), null);
  }

  /**
   * Test {@link SlackDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SlackDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SlackDeliveryMethodNotificationTemplate.equals(Object)",
    "int SlackDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new SlackDeliveryMethodNotificationTemplate(),
        "Different type to SlackDeliveryMethodNotificationTemplate");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SlackDeliveryMethodNotificationTemplate#toString()}
   *   <li>{@link SlackDeliveryMethodNotificationTemplate#getMethod()}
   *   <li>{@link SlackDeliveryMethodNotificationTemplate#getTemplatableValues()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationDeliveryMethod SlackDeliveryMethodNotificationTemplate.getMethod()",
    "List SlackDeliveryMethodNotificationTemplate.getTemplatableValues()",
    "java.lang.String SlackDeliveryMethodNotificationTemplate.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    SlackDeliveryMethodNotificationTemplate slackDeliveryMethodNotificationTemplate =
        new SlackDeliveryMethodNotificationTemplate();

    // Act
    slackDeliveryMethodNotificationTemplate.toString();
    NotificationDeliveryMethod actualMethod = slackDeliveryMethodNotificationTemplate.getMethod();
    List<TemplatableValue> actualTemplatableValues =
        slackDeliveryMethodNotificationTemplate.getTemplatableValues();

    // Assert
    assertEquals(1, actualTemplatableValues.size());
    assertNull(actualTemplatableValues.get(0).get());
    assertEquals(NotificationDeliveryMethod.SLACK, actualMethod);
  }

  /**
   * Test {@link SlackDeliveryMethodNotificationTemplate#copy()}.
   *
   * <p>Method under test: {@link SlackDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SlackDeliveryMethodNotificationTemplate SlackDeliveryMethodNotificationTemplate.copy()"
  })
  void testCopy() {
    // Arrange and Act
    SlackDeliveryMethodNotificationTemplate actualCopyResult =
        new SlackDeliveryMethodNotificationTemplate().copy();

    // Assert
    assertNull(actualCopyResult.getBody());
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(1, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertEquals(NotificationDeliveryMethod.SLACK, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
  }
}
