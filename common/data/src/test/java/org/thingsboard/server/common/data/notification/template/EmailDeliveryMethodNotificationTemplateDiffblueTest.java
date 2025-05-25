package org.thingsboard.server.common.data.notification.template;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class EmailDeliveryMethodNotificationTemplateDiffblueTest {
  /**
   * Test {@link EmailDeliveryMethodNotificationTemplate#EmailDeliveryMethodNotificationTemplate()}.
   * <p>
   * Method under test: {@link EmailDeliveryMethodNotificationTemplate#EmailDeliveryMethodNotificationTemplate()}
   */
  @Test
  @DisplayName("Test new EmailDeliveryMethodNotificationTemplate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EmailDeliveryMethodNotificationTemplate.<init>()"})
  void testNewEmailDeliveryMethodNotificationTemplate() {
    // Arrange and Act
    EmailDeliveryMethodNotificationTemplate actualEmailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();

    // Assert
    assertNull(actualEmailDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualEmailDeliveryMethodNotificationTemplate.getSubject());
    List<TemplatableValue> templatableValues = actualEmailDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, actualEmailDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualEmailDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Test {@link EmailDeliveryMethodNotificationTemplate#EmailDeliveryMethodNotificationTemplate(EmailDeliveryMethodNotificationTemplate)}.
   * <ul>
   *   <li>Then return Body is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailDeliveryMethodNotificationTemplate#EmailDeliveryMethodNotificationTemplate(EmailDeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName("Test new EmailDeliveryMethodNotificationTemplate(EmailDeliveryMethodNotificationTemplate); then return Body is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EmailDeliveryMethodNotificationTemplate.<init>(EmailDeliveryMethodNotificationTemplate)"})
  void testNewEmailDeliveryMethodNotificationTemplate_thenReturnBodyIsNull() {
    // Arrange and Act
    EmailDeliveryMethodNotificationTemplate actualEmailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate(
        new EmailDeliveryMethodNotificationTemplate());

    // Assert
    assertNull(actualEmailDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualEmailDeliveryMethodNotificationTemplate.getSubject());
    List<TemplatableValue> templatableValues = actualEmailDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, actualEmailDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualEmailDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Test {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}, and {@link EmailDeliveryMethodNotificationTemplate#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   *   <li>{@link EmailDeliveryMethodNotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailDeliveryMethodNotificationTemplate.equals(Object)",
      "int EmailDeliveryMethodNotificationTemplate.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertEquals(emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate);
    int expectedHashCodeResult = emailDeliveryMethodNotificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, emailDeliveryMethodNotificationTemplate.hashCode());
  }

  /**
   * Test {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailDeliveryMethodNotificationTemplate.equals(Object)",
      "int EmailDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, new EmailDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailDeliveryMethodNotificationTemplate.equals(Object)",
      "int EmailDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, new EmailDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailDeliveryMethodNotificationTemplate.equals(Object)",
      "int EmailDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate.setEnabled(true);

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, new EmailDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailDeliveryMethodNotificationTemplate.equals(Object)",
      "int EmailDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();

    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 = new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailDeliveryMethodNotificationTemplate.equals(Object)",
      "int EmailDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate2 = new EmailDeliveryMethodNotificationTemplate();
    emailDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(emailDeliveryMethodNotificationTemplate, emailDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailDeliveryMethodNotificationTemplate.equals(Object)",
      "int EmailDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailDeliveryMethodNotificationTemplate(), null);
  }

  /**
   * Test {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EmailDeliveryMethodNotificationTemplate.equals(Object)",
      "int EmailDeliveryMethodNotificationTemplate.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailDeliveryMethodNotificationTemplate(),
        "Different type to EmailDeliveryMethodNotificationTemplate");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EmailDeliveryMethodNotificationTemplate#setSubject(String)}
   *   <li>{@link EmailDeliveryMethodNotificationTemplate#toString()}
   *   <li>{@link EmailDeliveryMethodNotificationTemplate#getMethod()}
   *   <li>{@link EmailDeliveryMethodNotificationTemplate#getSubject()}
   *   <li>{@link EmailDeliveryMethodNotificationTemplate#getTemplatableValues()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationDeliveryMethod EmailDeliveryMethodNotificationTemplate.getMethod()",
      "String EmailDeliveryMethodNotificationTemplate.getSubject()",
      "List EmailDeliveryMethodNotificationTemplate.getTemplatableValues()",
      "void EmailDeliveryMethodNotificationTemplate.setSubject(String)",
      "String EmailDeliveryMethodNotificationTemplate.toString()"})
  void testGettersAndSetters() {
    // Arrange
    EmailDeliveryMethodNotificationTemplate emailDeliveryMethodNotificationTemplate = new EmailDeliveryMethodNotificationTemplate();

    // Act
    emailDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");
    emailDeliveryMethodNotificationTemplate.toString();
    NotificationDeliveryMethod actualMethod = emailDeliveryMethodNotificationTemplate.getMethod();
    String actualSubject = emailDeliveryMethodNotificationTemplate.getSubject();
    List<TemplatableValue> actualTemplatableValues = emailDeliveryMethodNotificationTemplate.getTemplatableValues();

    // Assert
    assertEquals("Hello from the Dreaming Spires", actualSubject);
    assertEquals(2, actualTemplatableValues.size());
    assertEquals("Hello from the Dreaming Spires", actualTemplatableValues.get(1).get());
    assertNull(actualTemplatableValues.get(0).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, actualMethod);
  }

  /**
   * Test {@link EmailDeliveryMethodNotificationTemplate#copy()}.
   * <p>
   * Method under test: {@link EmailDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EmailDeliveryMethodNotificationTemplate EmailDeliveryMethodNotificationTemplate.copy()"})
  void testCopy() {
    // Arrange and Act
    EmailDeliveryMethodNotificationTemplate actualCopyResult = (new EmailDeliveryMethodNotificationTemplate()).copy();

    // Assert
    assertNull(actualCopyResult.getBody());
    assertNull(actualCopyResult.getSubject());
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
  }
}
