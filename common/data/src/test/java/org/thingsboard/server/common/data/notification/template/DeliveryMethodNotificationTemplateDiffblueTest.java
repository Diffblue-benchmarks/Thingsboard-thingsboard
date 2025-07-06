package org.thingsboard.server.common.data.notification.template;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DeliveryMethodNotificationTemplateDiffblueTest {
  /**
   * Test {@link DeliveryMethodNotificationTemplate#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link
   *       EmailDeliveryMethodNotificationTemplate#EmailDeliveryMethodNotificationTemplate()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#canEqual(Object)}
   */
  @Test
  @DisplayName(
      "Test canEqual(Object); when EmailDeliveryMethodNotificationTemplate(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeliveryMethodNotificationTemplate.canEqual(Object)"})
  void testCanEqual_whenEmailDeliveryMethodNotificationTemplate_thenReturnTrue() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate =
        new EmailDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertTrue(
        emailDeliveryMethodNotificationTemplate.canEqual(
            new EmailDeliveryMethodNotificationTemplate()));
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeliveryMethodNotificationTemplate.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EmailDeliveryMethodNotificationTemplate().canEqual("Other"));
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#equals(Object)}, and {@link
   * DeliveryMethodNotificationTemplate#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeliveryMethodNotificationTemplate.equals(Object)",
    "int DeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate =
        new EmailDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertEquals(emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate);
    int expectedHashCodeResult = emailDeliveryMethodNotificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, emailDeliveryMethodNotificationTemplate.hashCode());
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeliveryMethodNotificationTemplate.equals(Object)",
    "int DeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate =
        new EmailDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertNotEquals(
        emailDeliveryMethodNotificationTemplate, new EmailDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeliveryMethodNotificationTemplate.equals(Object)",
    "int DeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate =
        new EmailDeliveryMethodNotificationTemplate();
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 =
        mock(EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.getBody()).thenReturn(null);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(true);
    when(emailDeliveryMethodNotificationTemplate2.getSubject())
        .thenReturn("Hello from the Dreaming Spires");
    when(emailDeliveryMethodNotificationTemplate2.getTemplatableValues())
        .thenReturn(new ArrayList<>());
    when(emailDeliveryMethodNotificationTemplate2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(
        emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeliveryMethodNotificationTemplate.equals(Object)",
    "int DeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate =
        new EmailDeliveryMethodNotificationTemplate();
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 =
        mock(EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.getBody()).thenReturn(null);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(false);
    when(emailDeliveryMethodNotificationTemplate2.getSubject())
        .thenReturn("Hello from the Dreaming Spires");
    when(emailDeliveryMethodNotificationTemplate2.getTemplatableValues())
        .thenReturn(new ArrayList<>());
    when(emailDeliveryMethodNotificationTemplate2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(
        emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeliveryMethodNotificationTemplate.equals(Object)",
    "int DeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate =
        new EmailDeliveryMethodNotificationTemplate();
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 =
        mock(EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(false);
    when(emailDeliveryMethodNotificationTemplate2.getBody())
        .thenReturn("Not all who wander are lost");
    when(emailDeliveryMethodNotificationTemplate2.getSubject())
        .thenReturn("Hello from the Dreaming Spires");
    when(emailDeliveryMethodNotificationTemplate2.getTemplatableValues())
        .thenReturn(new ArrayList<>());
    when(emailDeliveryMethodNotificationTemplate2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(
        emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeliveryMethodNotificationTemplate.equals(Object)",
    "int DeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate =
        new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate.setEnabled(true);
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 =
        mock(EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.getBody()).thenReturn(null);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(true);
    when(emailDeliveryMethodNotificationTemplate2.getSubject())
        .thenReturn("Hello from the Dreaming Spires");
    when(emailDeliveryMethodNotificationTemplate2.getTemplatableValues())
        .thenReturn(new ArrayList<>());
    when(emailDeliveryMethodNotificationTemplate2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(
        emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeliveryMethodNotificationTemplate.equals(Object)",
    "int DeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate =
        new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate.setBody("Not all who wander are lost");
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 =
        mock(EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.getBody()).thenReturn(null);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(false);
    when(emailDeliveryMethodNotificationTemplate2.getSubject())
        .thenReturn("Hello from the Dreaming Spires");
    when(emailDeliveryMethodNotificationTemplate2.getTemplatableValues())
        .thenReturn(new ArrayList<>());
    when(emailDeliveryMethodNotificationTemplate2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(
        emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeliveryMethodNotificationTemplate.equals(Object)",
    "int DeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate =
        new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate.setBody("Not all who wander are lost");
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 =
        mock(EmailDeliveryMethodNotificationTemplate.class);
    when(emailDeliveryMethodNotificationTemplate2.isEnabled()).thenReturn(false);
    when(emailDeliveryMethodNotificationTemplate2.getBody())
        .thenReturn("Not all who wander are lost");
    when(emailDeliveryMethodNotificationTemplate2.getSubject())
        .thenReturn("Hello from the Dreaming Spires");
    when(emailDeliveryMethodNotificationTemplate2.getTemplatableValues())
        .thenReturn(new ArrayList<>());
    when(emailDeliveryMethodNotificationTemplate2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(
        emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeliveryMethodNotificationTemplate.equals(Object)",
    "int DeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailDeliveryMethodNotificationTemplate(), null);
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeliveryMethodNotificationTemplate.equals(Object)",
    "int DeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EmailDeliveryMethodNotificationTemplate(),
        "Different type to DeliveryMethodNotificationTemplate");
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#getBody()}.
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#getBody()}
   */
  @Test
  @DisplayName("Test getBody()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DeliveryMethodNotificationTemplate.getBody()"})
  void testGetBody() {
    // Arrange, Act and Assert
    assertNull(new EmailDeliveryMethodNotificationTemplate().getBody());
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#isEnabled()}.
   *
   * <ul>
   *   <li>Given {@link
   *       EmailDeliveryMethodNotificationTemplate#EmailDeliveryMethodNotificationTemplate()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#isEnabled()}
   */
  @Test
  @DisplayName(
      "Test isEnabled(); given EmailDeliveryMethodNotificationTemplate(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeliveryMethodNotificationTemplate.isEnabled()"})
  void testIsEnabled_givenEmailDeliveryMethodNotificationTemplate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EmailDeliveryMethodNotificationTemplate().isEnabled());
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#isEnabled()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#isEnabled()}
   */
  @Test
  @DisplayName("Test isEnabled(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeliveryMethodNotificationTemplate.isEnabled()"})
  void testIsEnabled_thenReturnTrue() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate =
        new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate.setEnabled(true);

    // Act and Assert
    assertTrue(emailDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#setBody(String)}.
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#setBody(String)}
   */
  @Test
  @DisplayName("Test setBody(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeliveryMethodNotificationTemplate.setBody(String)"})
  void testSetBody() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate =
        new EmailDeliveryMethodNotificationTemplate();

    // Act
    emailDeliveryMethodNotificationTemplate.setBody("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", emailDeliveryMethodNotificationTemplate.getBody());
    List<TemplatableValue> templatableValues =
        emailDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertEquals("Not all who wander are lost", templatableValues.get(0).get());
  }

  /**
   * Test {@link DeliveryMethodNotificationTemplate#setEnabled(boolean)}.
   *
   * <p>Method under test: {@link DeliveryMethodNotificationTemplate#setEnabled(boolean)}
   */
  @Test
  @DisplayName("Test setEnabled(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeliveryMethodNotificationTemplate.setEnabled(boolean)"})
  void testSetEnabled() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate =
        new EmailDeliveryMethodNotificationTemplate();

    // Act
    emailDeliveryMethodNotificationTemplate.setEnabled(true);

    // Assert
    assertTrue(emailDeliveryMethodNotificationTemplate.isEnabled());
  }
}
