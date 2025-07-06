package org.thingsboard.server.common.data.notification.template;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class SmsDeliveryMethodNotificationTemplateDiffblueTest {
  /**
   * Test {@link SmsDeliveryMethodNotificationTemplate#SmsDeliveryMethodNotificationTemplate()}.
   *
   * <p>Method under test: {@link
   * SmsDeliveryMethodNotificationTemplate#SmsDeliveryMethodNotificationTemplate()}
   */
  @Test
  @DisplayName("Test new SmsDeliveryMethodNotificationTemplate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SmsDeliveryMethodNotificationTemplate.<init>()"})
  void testNewSmsDeliveryMethodNotificationTemplate() {
    // Arrange and Act
    SmsDeliveryMethodNotificationTemplate actualSmsDeliveryMethodNotificationTemplate =
        new SmsDeliveryMethodNotificationTemplate();

    // Assert
    assertNull(actualSmsDeliveryMethodNotificationTemplate.getBody());
    List<TemplatableValue> templatableValues =
        actualSmsDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(1, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertEquals(
        NotificationDeliveryMethod.SMS, actualSmsDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualSmsDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Test {@link
   * SmsDeliveryMethodNotificationTemplate#SmsDeliveryMethodNotificationTemplate(SmsDeliveryMethodNotificationTemplate)}.
   *
   * <ul>
   *   <li>Then return Body is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SmsDeliveryMethodNotificationTemplate#SmsDeliveryMethodNotificationTemplate(SmsDeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName(
      "Test new SmsDeliveryMethodNotificationTemplate(SmsDeliveryMethodNotificationTemplate); then return Body is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void SmsDeliveryMethodNotificationTemplate.<init>(SmsDeliveryMethodNotificationTemplate)"
  })
  void testNewSmsDeliveryMethodNotificationTemplate_thenReturnBodyIsNull() {
    // Arrange and Act
    SmsDeliveryMethodNotificationTemplate actualSmsDeliveryMethodNotificationTemplate =
        new SmsDeliveryMethodNotificationTemplate(new SmsDeliveryMethodNotificationTemplate());

    // Assert
    assertNull(actualSmsDeliveryMethodNotificationTemplate.getBody());
    List<TemplatableValue> templatableValues =
        actualSmsDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(1, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertEquals(
        NotificationDeliveryMethod.SMS, actualSmsDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualSmsDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Test {@link SmsDeliveryMethodNotificationTemplate#getBody()}.
   *
   * <p>Method under test: {@link SmsDeliveryMethodNotificationTemplate#getBody()}
   */
  @Test
  @DisplayName("Test getBody()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String SmsDeliveryMethodNotificationTemplate.getBody()"})
  void testGetBody() {
    // Arrange, Act and Assert
    assertNull(new SmsDeliveryMethodNotificationTemplate().getBody());
  }

  /**
   * Test {@link SmsDeliveryMethodNotificationTemplate#equals(Object)}, and {@link
   * SmsDeliveryMethodNotificationTemplate#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SmsDeliveryMethodNotificationTemplate#equals(Object)}
   *   <li>{@link SmsDeliveryMethodNotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SmsDeliveryMethodNotificationTemplate.equals(Object)",
    "int SmsDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SmsDeliveryMethodNotificationTemplate smsDeliveryMethodNotificationTemplate =
        new SmsDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertEquals(smsDeliveryMethodNotificationTemplate, smsDeliveryMethodNotificationTemplate);
    int expectedHashCodeResult = smsDeliveryMethodNotificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, smsDeliveryMethodNotificationTemplate.hashCode());
  }

  /**
   * Test {@link SmsDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SmsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SmsDeliveryMethodNotificationTemplate.equals(Object)",
    "int SmsDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SmsDeliveryMethodNotificationTemplate smsDeliveryMethodNotificationTemplate =
        new SmsDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertNotEquals(
        smsDeliveryMethodNotificationTemplate, new SmsDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link SmsDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SmsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SmsDeliveryMethodNotificationTemplate.equals(Object)",
    "int SmsDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SmsDeliveryMethodNotificationTemplate smsDeliveryMethodNotificationTemplate =
        new SmsDeliveryMethodNotificationTemplate();
    smsDeliveryMethodNotificationTemplate.setEnabled(true);

    // Act and Assert
    assertNotEquals(
        smsDeliveryMethodNotificationTemplate, new SmsDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link SmsDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SmsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SmsDeliveryMethodNotificationTemplate.equals(Object)",
    "int SmsDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SmsDeliveryMethodNotificationTemplate(), null);
  }

  /**
   * Test {@link SmsDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SmsDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean SmsDeliveryMethodNotificationTemplate.equals(Object)",
    "int SmsDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new SmsDeliveryMethodNotificationTemplate(),
        "Different type to SmsDeliveryMethodNotificationTemplate");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SmsDeliveryMethodNotificationTemplate#toString()}
   *   <li>{@link SmsDeliveryMethodNotificationTemplate#getMethod()}
   *   <li>{@link SmsDeliveryMethodNotificationTemplate#getTemplatableValues()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "NotificationDeliveryMethod SmsDeliveryMethodNotificationTemplate.getMethod()",
    "List SmsDeliveryMethodNotificationTemplate.getTemplatableValues()",
    "java.lang.String SmsDeliveryMethodNotificationTemplate.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    SmsDeliveryMethodNotificationTemplate smsDeliveryMethodNotificationTemplate =
        new SmsDeliveryMethodNotificationTemplate();

    // Act
    smsDeliveryMethodNotificationTemplate.toString();
    NotificationDeliveryMethod actualMethod = smsDeliveryMethodNotificationTemplate.getMethod();
    List<TemplatableValue> actualTemplatableValues =
        smsDeliveryMethodNotificationTemplate.getTemplatableValues();

    // Assert
    assertEquals(1, actualTemplatableValues.size());
    assertNull(actualTemplatableValues.get(0).get());
    assertEquals(NotificationDeliveryMethod.SMS, actualMethod);
  }

  /**
   * Test {@link SmsDeliveryMethodNotificationTemplate#copy()}.
   *
   * <p>Method under test: {@link SmsDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DeliveryMethodNotificationTemplate SmsDeliveryMethodNotificationTemplate.copy()"
  })
  void testCopy() {
    // Arrange and Act
    DeliveryMethodNotificationTemplate actualCopyResult =
        new SmsDeliveryMethodNotificationTemplate().copy();

    // Assert
    assertTrue(actualCopyResult instanceof SmsDeliveryMethodNotificationTemplate);
    assertNull(actualCopyResult.getBody());
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(1, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertEquals(NotificationDeliveryMethod.SMS, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
  }
}
