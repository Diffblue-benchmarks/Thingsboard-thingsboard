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
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class MicrosoftTeamsDeliveryMethodNotificationTemplateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#hashCode()}
   * </ul>
   */
  @Test
  void testButtonEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();

    // Act and Assert
    assertEquals(button, button2);
    int expectedHashCodeResult = button.hashCode();
    assertEquals(expectedHashCodeResult, button2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#hashCode()}
   * </ul>
   */
  @Test
  void testButtonEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button.setText("Text");

    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button2.setText("Text");

    // Act and Assert
    assertEquals(button, button2);
    int expectedHashCodeResult = button.hashCode();
    assertEquals(expectedHashCodeResult, button2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#hashCode()}
   * </ul>
   */
  @Test
  void testButtonEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button.setLinkType(MicrosoftTeamsDeliveryMethodNotificationTemplate.Button.LinkType.LINK);

    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button2.setLinkType(MicrosoftTeamsDeliveryMethodNotificationTemplate.Button.LinkType.LINK);

    // Act and Assert
    assertEquals(button, button2);
    int expectedHashCodeResult = button.hashCode();
    assertEquals(expectedHashCodeResult, button2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#hashCode()}
   * </ul>
   */
  @Test
  void testButtonEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button.setLink("Link");

    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button2.setLink("Link");

    // Act and Assert
    assertEquals(button, button2);
    int expectedHashCodeResult = button.hashCode();
    assertEquals(expectedHashCodeResult, button2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#hashCode()}
   * </ul>
   */
  @Test
  void testButtonEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button.setDashboardId(EntityId.NULL_UUID);

    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button2.setDashboardId(EntityId.NULL_UUID);

    // Act and Assert
    assertEquals(button, button2);
    int expectedHashCodeResult = button.hashCode();
    assertEquals(expectedHashCodeResult, button2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#hashCode()}
   * </ul>
   */
  @Test
  void testButtonEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button.setDashboardState("Dashboard State");

    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button2.setDashboardState("Dashboard State");

    // Act and Assert
    assertEquals(button, button2);
    int expectedHashCodeResult = button.hashCode();
    assertEquals(expectedHashCodeResult, button2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#hashCode()}
   * </ul>
   */
  @Test
  void testButtonEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();

    // Act and Assert
    assertEquals(button, button);
    int expectedHashCodeResult = button.hashCode();
    assertEquals(expectedHashCodeResult, button.hashCode());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   */
  @Test
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button(), 1);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   */
  @Test
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button.setEnabled(true);

    // Act and Assert
    assertNotEquals(button, new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   */
  @Test
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button.setText("Text");

    // Act and Assert
    assertNotEquals(button, new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   */
  @Test
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button.setLinkType(MicrosoftTeamsDeliveryMethodNotificationTemplate.Button.LinkType.LINK);

    // Act and Assert
    assertNotEquals(button, new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   */
  @Test
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button.setLink("Link");

    // Act and Assert
    assertNotEquals(button, new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   */
  @Test
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button.setDashboardId(EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(button, new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   */
  @Test
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button.setDashboardState("Dashboard State");

    // Act and Assert
    assertNotEquals(button, new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   */
  @Test
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button.setSetEntityIdInState(true);

    // Act and Assert
    assertNotEquals(button, new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   */
  @Test
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();

    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button2.setText("Text");

    // Act and Assert
    assertNotEquals(button, button2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   */
  @Test
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();

    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button2.setLinkType(MicrosoftTeamsDeliveryMethodNotificationTemplate.Button.LinkType.LINK);

    // Act and Assert
    assertNotEquals(button, button2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   */
  @Test
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();

    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button2.setLink("Link");

    // Act and Assert
    assertNotEquals(button, button2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   */
  @Test
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();

    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button2.setDashboardId(EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(button, button2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   */
  @Test
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();

    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    button2.setDashboardState("Dashboard State");

    // Act and Assert
    assertNotEquals(button, button2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   */
  @Test
  void testButtonEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button(), null);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#equals(Object)}
   */
  @Test
  void testButtonEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button(), "Different type to Button");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#Button()}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#setDashboardId(UUID)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#setDashboardState(String)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#setEnabled(boolean)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#setLink(String)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#setLinkType(MicrosoftTeamsDeliveryMethodNotificationTemplate.Button.LinkType)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#setSetEntityIdInState(boolean)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#setText(String)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#toString()}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#getDashboardId()}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#getDashboardState()}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#getLink()}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#getLinkType()}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#getText()}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#isEnabled()}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#isSetEntityIdInState()}
   * </ul>
   */
  @Test
  void testButtonGettersAndSetters() {
    // Arrange and Act
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button actualButton = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    UUID dashboardId = EntityId.NULL_UUID;
    actualButton.setDashboardId(dashboardId);
    actualButton.setDashboardState("Dashboard State");
    actualButton.setEnabled(true);
    actualButton.setLink("Link");
    actualButton.setLinkType(MicrosoftTeamsDeliveryMethodNotificationTemplate.Button.LinkType.LINK);
    actualButton.setSetEntityIdInState(true);
    actualButton.setText("Text");
    String actualToStringResult = actualButton.toString();
    UUID actualDashboardId = actualButton.getDashboardId();
    String actualDashboardState = actualButton.getDashboardState();
    String actualLink = actualButton.getLink();
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button.LinkType actualLinkType = actualButton.getLinkType();
    String actualText = actualButton.getText();
    boolean actualIsEnabledResult = actualButton.isEnabled();
    boolean actualIsSetEntityIdInStateResult = actualButton.isSetEntityIdInState();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDashboardId.toString());
    assertEquals("Dashboard State", actualDashboardState);
    assertEquals("Link", actualLink);
    assertEquals("MicrosoftTeamsDeliveryMethodNotificationTemplate.Button(enabled=true, text=Text, linkType=LINK,"
        + " link=Link, dashboardId=13814000-1dd2-11b2-8080-808080808080, dashboardState=Dashboard State,"
        + " setEntityIdInState=true)", actualToStringResult);
    assertEquals("Text", actualText);
    assertEquals(MicrosoftTeamsDeliveryMethodNotificationTemplate.Button.LinkType.LINK, actualLinkType);
    assertTrue(actualIsEnabledResult);
    assertTrue(actualIsSetEntityIdInStateResult);
    assertSame(dashboardId, actualDashboardId);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate.Button#Button(MicrosoftTeamsDeliveryMethodNotificationTemplate.Button)}
   */
  @Test
  void testButtonNewButton() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button other = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();

    // Act and Assert
    assertEquals(other, new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button(other));
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  void testCopy() {
    // Arrange and Act
    MicrosoftTeamsDeliveryMethodNotificationTemplate actualCopyResult = (new MicrosoftTeamsDeliveryMethodNotificationTemplate())
        .copy();

    // Assert
    assertNull(actualCopyResult.getBody());
    assertNull(actualCopyResult.getSubject());
    assertNull(actualCopyResult.getThemeColor());
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualCopyResult.getButton());
    assertEquals(NotificationDeliveryMethod.MICROSOFT_TEAMS, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  void testCopy2() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    microsoftTeamsDeliveryMethodNotificationTemplate.setButton(button);

    // Act
    MicrosoftTeamsDeliveryMethodNotificationTemplate actualCopyResult = microsoftTeamsDeliveryMethodNotificationTemplate
        .copy();

    // Assert
    assertNull(actualCopyResult.getBody());
    assertNull(actualCopyResult.getSubject());
    assertNull(actualCopyResult.getThemeColor());
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertEquals(NotificationDeliveryMethod.MICROSOFT_TEAMS, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
    assertEquals(button, actualCopyResult.getButton());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertEquals(microsoftTeamsDeliveryMethodNotificationTemplate, microsoftTeamsDeliveryMethodNotificationTemplate);
    int expectedHashCodeResult = microsoftTeamsDeliveryMethodNotificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, microsoftTeamsDeliveryMethodNotificationTemplate.hashCode());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        new MicrosoftTeamsDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new MicrosoftTeamsDeliveryMethodNotificationTemplate(),
        mock(EmailDeliveryMethodNotificationTemplate.class));
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        new MicrosoftTeamsDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate.setThemeColor("Theme Color");

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        new MicrosoftTeamsDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate
        .setButton(new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button());

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        new MicrosoftTeamsDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate.setEnabled(true);

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        new MicrosoftTeamsDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();

    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        microsoftTeamsDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();

    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate2.setThemeColor("Theme Color");

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        microsoftTeamsDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();

    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate2
        .setButton(new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button());

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        microsoftTeamsDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        microsoftTeamsDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate.setThemeColor("Theme Color");

    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate2.setThemeColor("Theme Color");

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        microsoftTeamsDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate
        .setButton(new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button());

    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate2
        .setButton(new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button());

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        microsoftTeamsDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MicrosoftTeamsDeliveryMethodNotificationTemplate(), null);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MicrosoftTeamsDeliveryMethodNotificationTemplate(),
        "Different type to MicrosoftTeamsDeliveryMethodNotificationTemplate");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#setButton(MicrosoftTeamsDeliveryMethodNotificationTemplate.Button)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#setSubject(String)}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#setThemeColor(String)}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#toString()}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#getButton()}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#getMethod()}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#getSubject()}
   *   <li>
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#getTemplatableValues()}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#getThemeColor()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();

    // Act
    microsoftTeamsDeliveryMethodNotificationTemplate.setButton(button);
    microsoftTeamsDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");
    microsoftTeamsDeliveryMethodNotificationTemplate.setThemeColor("Theme Color");
    microsoftTeamsDeliveryMethodNotificationTemplate.toString();
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button actualButton = microsoftTeamsDeliveryMethodNotificationTemplate
        .getButton();
    NotificationDeliveryMethod actualMethod = microsoftTeamsDeliveryMethodNotificationTemplate.getMethod();
    String actualSubject = microsoftTeamsDeliveryMethodNotificationTemplate.getSubject();
    List<TemplatableValue> actualTemplatableValues = microsoftTeamsDeliveryMethodNotificationTemplate
        .getTemplatableValues();
    String actualThemeColor = microsoftTeamsDeliveryMethodNotificationTemplate.getThemeColor();

    // Assert that nothing has changed
    assertEquals("Hello from the Dreaming Spires", actualSubject);
    assertEquals(4, actualTemplatableValues.size());
    assertEquals("Hello from the Dreaming Spires", actualTemplatableValues.get(1).get());
    assertEquals("Theme Color", actualThemeColor);
    assertEquals(NotificationDeliveryMethod.MICROSOFT_TEAMS, actualMethod);
    assertSame(button, actualButton);
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#MicrosoftTeamsDeliveryMethodNotificationTemplate()}
   */
  @Test
  void testNewMicrosoftTeamsDeliveryMethodNotificationTemplate() {
    // Arrange and Act
    MicrosoftTeamsDeliveryMethodNotificationTemplate actualMicrosoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();

    // Assert
    assertNull(actualMicrosoftTeamsDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualMicrosoftTeamsDeliveryMethodNotificationTemplate.getSubject());
    assertNull(actualMicrosoftTeamsDeliveryMethodNotificationTemplate.getThemeColor());
    List<TemplatableValue> templatableValues = actualMicrosoftTeamsDeliveryMethodNotificationTemplate
        .getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualMicrosoftTeamsDeliveryMethodNotificationTemplate.getButton());
    assertEquals(NotificationDeliveryMethod.MICROSOFT_TEAMS,
        actualMicrosoftTeamsDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualMicrosoftTeamsDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#MicrosoftTeamsDeliveryMethodNotificationTemplate(MicrosoftTeamsDeliveryMethodNotificationTemplate)}
   */
  @Test
  void testNewMicrosoftTeamsDeliveryMethodNotificationTemplate2() {
    // Arrange and Act
    MicrosoftTeamsDeliveryMethodNotificationTemplate actualMicrosoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate(
        new MicrosoftTeamsDeliveryMethodNotificationTemplate());

    // Assert
    assertNull(actualMicrosoftTeamsDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualMicrosoftTeamsDeliveryMethodNotificationTemplate.getSubject());
    assertNull(actualMicrosoftTeamsDeliveryMethodNotificationTemplate.getThemeColor());
    List<TemplatableValue> templatableValues = actualMicrosoftTeamsDeliveryMethodNotificationTemplate
        .getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualMicrosoftTeamsDeliveryMethodNotificationTemplate.getButton());
    assertEquals(NotificationDeliveryMethod.MICROSOFT_TEAMS,
        actualMicrosoftTeamsDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualMicrosoftTeamsDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Method under test:
   * {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#MicrosoftTeamsDeliveryMethodNotificationTemplate(MicrosoftTeamsDeliveryMethodNotificationTemplate)}
   */
  @Test
  void testNewMicrosoftTeamsDeliveryMethodNotificationTemplate3() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate other = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    MicrosoftTeamsDeliveryMethodNotificationTemplate.Button button = new MicrosoftTeamsDeliveryMethodNotificationTemplate.Button();
    other.setButton(button);

    // Act
    MicrosoftTeamsDeliveryMethodNotificationTemplate actualMicrosoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate(
        other);

    // Assert
    assertNull(actualMicrosoftTeamsDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualMicrosoftTeamsDeliveryMethodNotificationTemplate.getSubject());
    assertNull(actualMicrosoftTeamsDeliveryMethodNotificationTemplate.getThemeColor());
    List<TemplatableValue> templatableValues = actualMicrosoftTeamsDeliveryMethodNotificationTemplate
        .getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertEquals(NotificationDeliveryMethod.MICROSOFT_TEAMS,
        actualMicrosoftTeamsDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualMicrosoftTeamsDeliveryMethodNotificationTemplate.isEnabled());
    assertEquals(button, actualMicrosoftTeamsDeliveryMethodNotificationTemplate.getButton());
  }
}
