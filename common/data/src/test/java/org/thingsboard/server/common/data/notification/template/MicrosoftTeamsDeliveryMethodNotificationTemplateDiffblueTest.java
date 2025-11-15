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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.template.MicrosoftTeamsDeliveryMethodNotificationTemplate.Button;
import org.thingsboard.server.common.data.notification.template.MicrosoftTeamsDeliveryMethodNotificationTemplate.Button.LinkType;

class MicrosoftTeamsDeliveryMethodNotificationTemplateDiffblueTest {
  /**
   * Test Button {@link Button#equals(Object)}, and {@link Button#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Button#equals(Object)}
   *   <li>{@link Button#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Button equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Button button = new Button();
    Button button2 = new Button();

    // Act and Assert
    assertEquals(button, button2);
    int expectedHashCodeResult = button.hashCode();
    assertEquals(expectedHashCodeResult, button2.hashCode());
  }

  /**
   * Test Button {@link Button#equals(Object)}, and {@link Button#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Button#equals(Object)}
   *   <li>{@link Button#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Button equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Button button = new Button();
    button.setText("Text");

    Button button2 = new Button();
    button2.setText("Text");

    // Act and Assert
    assertEquals(button, button2);
    int expectedHashCodeResult = button.hashCode();
    assertEquals(expectedHashCodeResult, button2.hashCode());
  }

  /**
   * Test Button {@link Button#equals(Object)}, and {@link Button#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Button#equals(Object)}
   *   <li>{@link Button#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Button equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Button button = new Button();
    button.setLinkType(LinkType.LINK);

    Button button2 = new Button();
    button2.setLinkType(LinkType.LINK);

    // Act and Assert
    assertEquals(button, button2);
    int expectedHashCodeResult = button.hashCode();
    assertEquals(expectedHashCodeResult, button2.hashCode());
  }

  /**
   * Test Button {@link Button#equals(Object)}, and {@link Button#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Button#equals(Object)}
   *   <li>{@link Button#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Button equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Button button = new Button();
    button.setLink("Link");

    Button button2 = new Button();
    button2.setLink("Link");

    // Act and Assert
    assertEquals(button, button2);
    int expectedHashCodeResult = button.hashCode();
    assertEquals(expectedHashCodeResult, button2.hashCode());
  }

  /**
   * Test Button {@link Button#equals(Object)}, and {@link Button#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Button#equals(Object)}
   *   <li>{@link Button#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Button equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    Button button = new Button();
    button.setDashboardId(EntityId.NULL_UUID);

    Button button2 = new Button();
    button2.setDashboardId(EntityId.NULL_UUID);

    // Act and Assert
    assertEquals(button, button2);
    int expectedHashCodeResult = button.hashCode();
    assertEquals(expectedHashCodeResult, button2.hashCode());
  }

  /**
   * Test Button {@link Button#equals(Object)}, and {@link Button#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Button#equals(Object)}
   *   <li>{@link Button#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Button equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    Button button = new Button();
    button.setDashboardState("Dashboard State");

    Button button2 = new Button();
    button2.setDashboardState("Dashboard State");

    // Act and Assert
    assertEquals(button, button2);
    int expectedHashCodeResult = button.hashCode();
    assertEquals(expectedHashCodeResult, button2.hashCode());
  }

  /**
   * Test Button {@link Button#equals(Object)}, and {@link Button#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Button#equals(Object)}
   *   <li>{@link Button#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Button equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Button button = new Button();

    // Act and Assert
    assertEquals(button, button);
    int expectedHashCodeResult = button.hashCode();
    assertEquals(expectedHashCodeResult, button.hashCode());
  }

  /**
   * Test Button {@link Button#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#equals(Object)}
   */
  @Test
  @DisplayName("Test Button equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Button(), 1);
  }

  /**
   * Test Button {@link Button#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#equals(Object)}
   */
  @Test
  @DisplayName("Test Button equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Button button = new Button();
    button.setEnabled(true);

    // Act and Assert
    assertNotEquals(button, new Button());
  }

  /**
   * Test Button {@link Button#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#equals(Object)}
   */
  @Test
  @DisplayName("Test Button equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Button button = new Button();
    button.setText("Text");

    // Act and Assert
    assertNotEquals(button, new Button());
  }

  /**
   * Test Button {@link Button#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#equals(Object)}
   */
  @Test
  @DisplayName("Test Button equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Button button = new Button();
    button.setLinkType(LinkType.LINK);

    // Act and Assert
    assertNotEquals(button, new Button());
  }

  /**
   * Test Button {@link Button#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#equals(Object)}
   */
  @Test
  @DisplayName("Test Button equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Button button = new Button();
    button.setLink("Link");

    // Act and Assert
    assertNotEquals(button, new Button());
  }

  /**
   * Test Button {@link Button#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#equals(Object)}
   */
  @Test
  @DisplayName("Test Button equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Button button = new Button();
    button.setDashboardId(EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(button, new Button());
  }

  /**
   * Test Button {@link Button#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#equals(Object)}
   */
  @Test
  @DisplayName("Test Button equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Button button = new Button();
    button.setDashboardState("Dashboard State");

    // Act and Assert
    assertNotEquals(button, new Button());
  }

  /**
   * Test Button {@link Button#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#equals(Object)}
   */
  @Test
  @DisplayName("Test Button equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Button button = new Button();
    button.setSetEntityIdInState(true);

    // Act and Assert
    assertNotEquals(button, new Button());
  }

  /**
   * Test Button {@link Button#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#equals(Object)}
   */
  @Test
  @DisplayName("Test Button equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Button button = new Button();

    Button button2 = new Button();
    button2.setText("Text");

    // Act and Assert
    assertNotEquals(button, button2);
  }

  /**
   * Test Button {@link Button#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#equals(Object)}
   */
  @Test
  @DisplayName("Test Button equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Button button = new Button();

    Button button2 = new Button();
    button2.setLinkType(LinkType.LINK);

    // Act and Assert
    assertNotEquals(button, button2);
  }

  /**
   * Test Button {@link Button#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#equals(Object)}
   */
  @Test
  @DisplayName("Test Button equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Button button = new Button();

    Button button2 = new Button();
    button2.setLink("Link");

    // Act and Assert
    assertNotEquals(button, button2);
  }

  /**
   * Test Button {@link Button#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#equals(Object)}
   */
  @Test
  @DisplayName("Test Button equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Button button = new Button();

    Button button2 = new Button();
    button2.setDashboardId(EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(button, button2);
  }

  /**
   * Test Button {@link Button#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#equals(Object)}
   */
  @Test
  @DisplayName("Test Button equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Button button = new Button();

    Button button2 = new Button();
    button2.setDashboardState("Dashboard State");

    // Act and Assert
    assertNotEquals(button, button2);
  }

  /**
   * Test Button {@link Button#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#equals(Object)}
   */
  @Test
  @DisplayName("Test Button equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Button(), null);
  }

  /**
   * Test Button {@link Button#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#equals(Object)}
   */
  @Test
  @DisplayName("Test Button equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Button.equals(Object)", "int Button.hashCode()"})
  void testButtonEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Button(), "Different type to Button");
  }

  /**
   * Test Button getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Button#Button()}
   *   <li>{@link Button#setDashboardId(UUID)}
   *   <li>{@link Button#setDashboardState(String)}
   *   <li>{@link Button#setEnabled(boolean)}
   *   <li>{@link Button#setLink(String)}
   *   <li>{@link Button#setLinkType(Button.LinkType)}
   *   <li>{@link Button#setSetEntityIdInState(boolean)}
   *   <li>{@link Button#setText(String)}
   *   <li>{@link Button#toString()}
   *   <li>{@link Button#getDashboardId()}
   *   <li>{@link Button#getDashboardState()}
   *   <li>{@link Button#getLink()}
   *   <li>{@link Button#getLinkType()}
   *   <li>{@link Button#getText()}
   *   <li>{@link Button#isEnabled()}
   *   <li>{@link Button#isSetEntityIdInState()}
   * </ul>
   */
  @Test
  @DisplayName("Test Button getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Button.<init>()", "UUID Button.getDashboardId()", "String Button.getDashboardState()",
      "String Button.getLink()", "Button.LinkType Button.getLinkType()", "String Button.getText()",
      "boolean Button.isEnabled()", "boolean Button.isSetEntityIdInState()", "void Button.setDashboardId(UUID)",
      "void Button.setDashboardState(String)", "void Button.setEnabled(boolean)", "void Button.setLink(String)",
      "void Button.setLinkType(Button.LinkType)", "void Button.setSetEntityIdInState(boolean)",
      "void Button.setText(String)", "String Button.toString()"})
  void testButtonGettersAndSetters() {
    // Arrange and Act
    Button actualButton = new Button();
    UUID dashboardId = EntityId.NULL_UUID;
    actualButton.setDashboardId(dashboardId);
    actualButton.setDashboardState("Dashboard State");
    actualButton.setEnabled(true);
    actualButton.setLink("Link");
    actualButton.setLinkType(LinkType.LINK);
    actualButton.setSetEntityIdInState(true);
    actualButton.setText("Text");
    String actualToStringResult = actualButton.toString();
    UUID actualDashboardId = actualButton.getDashboardId();
    String actualDashboardState = actualButton.getDashboardState();
    String actualLink = actualButton.getLink();
    LinkType actualLinkType = actualButton.getLinkType();
    String actualText = actualButton.getText();
    boolean actualIsEnabledResult = actualButton.isEnabled();
    boolean actualIsSetEntityIdInStateResult = actualButton.isSetEntityIdInState();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDashboardId.toString());
    assertEquals("Dashboard State", actualDashboardState);
    assertEquals("Link", actualLink);
    assertEquals("MicrosoftTeamsDeliveryMethodNotificationTemplate.Button(enabled=true, text=Text, linkType=LINK,"
        + " link=Link, dashboardId=13814000-1dd2-11b2-8080-808080808080, dashboardState=Dashboard State,"
        + " setEntityIdInState=true)", actualToStringResult);
    assertEquals("Text", actualText);
    assertEquals(LinkType.LINK, actualLinkType);
    assertTrue(actualIsEnabledResult);
    assertTrue(actualIsSetEntityIdInStateResult);
    assertSame(dashboardId, actualDashboardId);
  }

  /**
   * Test Button {@link Button#Button(Button)}.
   * <ul>
   *   <li>When {@link Button#Button()}.</li>
   *   <li>Then return {@link Button#Button()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Button#Button(Button)}
   */
  @Test
  @DisplayName("Test Button new Button(Button); when Button(); then return Button()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Button.<init>(Button)"})
  void testButtonNewButton_whenButton_thenReturnButton() {
    // Arrange
    Button other = new Button();

    // Act and Assert
    assertEquals(other, new Button(other));
  }

  /**
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#MicrosoftTeamsDeliveryMethodNotificationTemplate()}.
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#MicrosoftTeamsDeliveryMethodNotificationTemplate()}
   */
  @Test
  @DisplayName("Test new MicrosoftTeamsDeliveryMethodNotificationTemplate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MicrosoftTeamsDeliveryMethodNotificationTemplate.<init>()"})
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
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#MicrosoftTeamsDeliveryMethodNotificationTemplate(MicrosoftTeamsDeliveryMethodNotificationTemplate)}.
   * <ul>
   *   <li>Then return Body is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#MicrosoftTeamsDeliveryMethodNotificationTemplate(MicrosoftTeamsDeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName("Test new MicrosoftTeamsDeliveryMethodNotificationTemplate(MicrosoftTeamsDeliveryMethodNotificationTemplate); then return Body is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void MicrosoftTeamsDeliveryMethodNotificationTemplate.<init>(MicrosoftTeamsDeliveryMethodNotificationTemplate)"})
  void testNewMicrosoftTeamsDeliveryMethodNotificationTemplate_thenReturnBodyIsNull() {
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
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#MicrosoftTeamsDeliveryMethodNotificationTemplate(MicrosoftTeamsDeliveryMethodNotificationTemplate)}.
   * <ul>
   *   <li>Then return Button is {@link Button#Button()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#MicrosoftTeamsDeliveryMethodNotificationTemplate(MicrosoftTeamsDeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName("Test new MicrosoftTeamsDeliveryMethodNotificationTemplate(MicrosoftTeamsDeliveryMethodNotificationTemplate); then return Button is Button()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void MicrosoftTeamsDeliveryMethodNotificationTemplate.<init>(MicrosoftTeamsDeliveryMethodNotificationTemplate)"})
  void testNewMicrosoftTeamsDeliveryMethodNotificationTemplate_thenReturnButtonIsButton() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate other = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    Button button = new Button();
    other.setButton(button);

    // Act and Assert
    assertEquals(button, (new MicrosoftTeamsDeliveryMethodNotificationTemplate(other)).getButton());
  }

  /**
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#copy()}.
   * <ul>
   *   <li>Then return Body is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy(); then return Body is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MicrosoftTeamsDeliveryMethodNotificationTemplate MicrosoftTeamsDeliveryMethodNotificationTemplate.copy()"})
  void testCopy_thenReturnBodyIsNull() {
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
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#copy()}.
   * <ul>
   *   <li>Then return Button is {@link Button#Button()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy(); then return Button is Button()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MicrosoftTeamsDeliveryMethodNotificationTemplate MicrosoftTeamsDeliveryMethodNotificationTemplate.copy()"})
  void testCopy_thenReturnButtonIsButton() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    Button button = new Button();
    microsoftTeamsDeliveryMethodNotificationTemplate.setButton(button);

    // Act and Assert
    assertEquals(button, microsoftTeamsDeliveryMethodNotificationTemplate.copy().getButton());
  }

  /**
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}, and {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MicrosoftTeamsDeliveryMethodNotificationTemplate.equals(Object)",
      "int MicrosoftTeamsDeliveryMethodNotificationTemplate.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertEquals(microsoftTeamsDeliveryMethodNotificationTemplate, microsoftTeamsDeliveryMethodNotificationTemplate);
    int expectedHashCodeResult = microsoftTeamsDeliveryMethodNotificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, microsoftTeamsDeliveryMethodNotificationTemplate.hashCode());
  }

  /**
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MicrosoftTeamsDeliveryMethodNotificationTemplate.equals(Object)",
      "int MicrosoftTeamsDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        new MicrosoftTeamsDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MicrosoftTeamsDeliveryMethodNotificationTemplate.equals(Object)",
      "int MicrosoftTeamsDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        new MicrosoftTeamsDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MicrosoftTeamsDeliveryMethodNotificationTemplate.equals(Object)",
      "int MicrosoftTeamsDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate.setThemeColor("Theme Color");

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        new MicrosoftTeamsDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MicrosoftTeamsDeliveryMethodNotificationTemplate.equals(Object)",
      "int MicrosoftTeamsDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate.setButton(new Button());

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        new MicrosoftTeamsDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MicrosoftTeamsDeliveryMethodNotificationTemplate.equals(Object)",
      "int MicrosoftTeamsDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate.setEnabled(true);

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        new MicrosoftTeamsDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MicrosoftTeamsDeliveryMethodNotificationTemplate.equals(Object)",
      "int MicrosoftTeamsDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();

    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        microsoftTeamsDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MicrosoftTeamsDeliveryMethodNotificationTemplate.equals(Object)",
      "int MicrosoftTeamsDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();

    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate2.setThemeColor("Theme Color");

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        microsoftTeamsDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MicrosoftTeamsDeliveryMethodNotificationTemplate.equals(Object)",
      "int MicrosoftTeamsDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();

    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate2.setButton(new Button());

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        microsoftTeamsDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MicrosoftTeamsDeliveryMethodNotificationTemplate.equals(Object)",
      "int MicrosoftTeamsDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MicrosoftTeamsDeliveryMethodNotificationTemplate.equals(Object)",
      "int MicrosoftTeamsDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
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
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MicrosoftTeamsDeliveryMethodNotificationTemplate.equals(Object)",
      "int MicrosoftTeamsDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate.setButton(new Button());

    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate2 = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    microsoftTeamsDeliveryMethodNotificationTemplate2.setButton(new Button());

    // Act and Assert
    assertNotEquals(microsoftTeamsDeliveryMethodNotificationTemplate,
        microsoftTeamsDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MicrosoftTeamsDeliveryMethodNotificationTemplate.equals(Object)",
      "int MicrosoftTeamsDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MicrosoftTeamsDeliveryMethodNotificationTemplate(), null);
  }

  /**
   * Test {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MicrosoftTeamsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MicrosoftTeamsDeliveryMethodNotificationTemplate.equals(Object)",
      "int MicrosoftTeamsDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MicrosoftTeamsDeliveryMethodNotificationTemplate(),
        "Different type to MicrosoftTeamsDeliveryMethodNotificationTemplate");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#setButton(Button)}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#setSubject(String)}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#setThemeColor(String)}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#toString()}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#getButton()}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#getMethod()}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#getSubject()}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#getTemplatableValues()}
   *   <li>{@link MicrosoftTeamsDeliveryMethodNotificationTemplate#getThemeColor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Button MicrosoftTeamsDeliveryMethodNotificationTemplate.getButton()",
      "NotificationDeliveryMethod MicrosoftTeamsDeliveryMethodNotificationTemplate.getMethod()",
      "String MicrosoftTeamsDeliveryMethodNotificationTemplate.getSubject()",
      "List MicrosoftTeamsDeliveryMethodNotificationTemplate.getTemplatableValues()",
      "String MicrosoftTeamsDeliveryMethodNotificationTemplate.getThemeColor()",
      "void MicrosoftTeamsDeliveryMethodNotificationTemplate.setButton(Button)",
      "void MicrosoftTeamsDeliveryMethodNotificationTemplate.setSubject(String)",
      "void MicrosoftTeamsDeliveryMethodNotificationTemplate.setThemeColor(String)",
      "String MicrosoftTeamsDeliveryMethodNotificationTemplate.toString()"})
  void testGettersAndSetters() {
    // Arrange
    MicrosoftTeamsDeliveryMethodNotificationTemplate microsoftTeamsDeliveryMethodNotificationTemplate = new MicrosoftTeamsDeliveryMethodNotificationTemplate();
    Button button = new Button();

    // Act
    microsoftTeamsDeliveryMethodNotificationTemplate.setButton(button);
    microsoftTeamsDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");
    microsoftTeamsDeliveryMethodNotificationTemplate.setThemeColor("Theme Color");
    microsoftTeamsDeliveryMethodNotificationTemplate.toString();
    Button actualButton = microsoftTeamsDeliveryMethodNotificationTemplate.getButton();
    NotificationDeliveryMethod actualMethod = microsoftTeamsDeliveryMethodNotificationTemplate.getMethod();
    String actualSubject = microsoftTeamsDeliveryMethodNotificationTemplate.getSubject();
    List<TemplatableValue> actualTemplatableValues = microsoftTeamsDeliveryMethodNotificationTemplate
        .getTemplatableValues();
    String actualThemeColor = microsoftTeamsDeliveryMethodNotificationTemplate.getThemeColor();

    // Assert
    assertEquals("Hello from the Dreaming Spires", actualSubject);
    assertEquals(4, actualTemplatableValues.size());
    assertEquals("Hello from the Dreaming Spires", actualTemplatableValues.get(1).get());
    assertEquals("Theme Color", actualThemeColor);
    assertNull(actualTemplatableValues.get(0).get());
    assertNull(actualTemplatableValues.get(2).get());
    assertNull(actualTemplatableValues.get(3).get());
    assertEquals(NotificationDeliveryMethod.MICROSOFT_TEAMS, actualMethod);
    assertSame(button, actualButton);
  }
}
