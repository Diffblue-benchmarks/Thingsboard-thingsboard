package org.thingsboard.server.common.data.notification.template;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class MobileAppDeliveryMethodNotificationTemplateDiffblueTest {
  /**
   * Test {@link
   * MobileAppDeliveryMethodNotificationTemplate#MobileAppDeliveryMethodNotificationTemplate()}.
   *
   * <p>Method under test: {@link
   * MobileAppDeliveryMethodNotificationTemplate#MobileAppDeliveryMethodNotificationTemplate()}
   */
  @Test
  @DisplayName("Test new MobileAppDeliveryMethodNotificationTemplate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MobileAppDeliveryMethodNotificationTemplate.<init>()"})
  void testNewMobileAppDeliveryMethodNotificationTemplate() {
    // Arrange and Act
    MobileAppDeliveryMethodNotificationTemplate actualMobileAppDeliveryMethodNotificationTemplate =
        new MobileAppDeliveryMethodNotificationTemplate();

    // Assert
    assertNull(actualMobileAppDeliveryMethodNotificationTemplate.getAdditionalConfig());
    assertNull(actualMobileAppDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualMobileAppDeliveryMethodNotificationTemplate.getSubject());
    List<TemplatableValue> templatableValues =
        actualMobileAppDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(
        NotificationDeliveryMethod.MOBILE_APP,
        actualMobileAppDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualMobileAppDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Test {@link
   * MobileAppDeliveryMethodNotificationTemplate#MobileAppDeliveryMethodNotificationTemplate(MobileAppDeliveryMethodNotificationTemplate)}.
   *
   * <p>Method under test: {@link
   * MobileAppDeliveryMethodNotificationTemplate#MobileAppDeliveryMethodNotificationTemplate(MobileAppDeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName(
      "Test new MobileAppDeliveryMethodNotificationTemplate(MobileAppDeliveryMethodNotificationTemplate)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppDeliveryMethodNotificationTemplate.<init>(MobileAppDeliveryMethodNotificationTemplate)"
  })
  void testNewMobileAppDeliveryMethodNotificationTemplate2() {
    // Arrange and Act
    MobileAppDeliveryMethodNotificationTemplate actualMobileAppDeliveryMethodNotificationTemplate =
        new MobileAppDeliveryMethodNotificationTemplate(
            new MobileAppDeliveryMethodNotificationTemplate());

    // Assert
    assertNull(actualMobileAppDeliveryMethodNotificationTemplate.getAdditionalConfig());
    assertNull(actualMobileAppDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualMobileAppDeliveryMethodNotificationTemplate.getSubject());
    List<TemplatableValue> templatableValues =
        actualMobileAppDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(
        NotificationDeliveryMethod.MOBILE_APP,
        actualMobileAppDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualMobileAppDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Test {@link MobileAppDeliveryMethodNotificationTemplate#copy()}.
   *
   * <p>Method under test: {@link MobileAppDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppDeliveryMethodNotificationTemplate MobileAppDeliveryMethodNotificationTemplate.copy()"
  })
  void testCopy() {
    // Arrange and Act
    MobileAppDeliveryMethodNotificationTemplate actualCopyResult =
        new MobileAppDeliveryMethodNotificationTemplate().copy();

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
   * Test {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}, and {@link
   * MobileAppDeliveryMethodNotificationTemplate#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppDeliveryMethodNotificationTemplate.equals(Object)",
    "int MobileAppDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate =
        new MobileAppDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertEquals(
        mobileAppDeliveryMethodNotificationTemplate, mobileAppDeliveryMethodNotificationTemplate);
    int expectedHashCodeResult = mobileAppDeliveryMethodNotificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppDeliveryMethodNotificationTemplate.hashCode());
  }

  /**
   * Test {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppDeliveryMethodNotificationTemplate.equals(Object)",
    "int MobileAppDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate =
        new MobileAppDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertNotEquals(
        mobileAppDeliveryMethodNotificationTemplate,
        new MobileAppDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppDeliveryMethodNotificationTemplate.equals(Object)",
    "int MobileAppDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate =
        new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(
        mobileAppDeliveryMethodNotificationTemplate,
        new MobileAppDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppDeliveryMethodNotificationTemplate.equals(Object)",
    "int MobileAppDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate =
        new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate.setAdditionalConfig(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(
        mobileAppDeliveryMethodNotificationTemplate,
        new MobileAppDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppDeliveryMethodNotificationTemplate.equals(Object)",
    "int MobileAppDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate =
        new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate.setEnabled(true);

    // Act and Assert
    assertNotEquals(
        mobileAppDeliveryMethodNotificationTemplate,
        new MobileAppDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppDeliveryMethodNotificationTemplate.equals(Object)",
    "int MobileAppDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate =
        new MobileAppDeliveryMethodNotificationTemplate();

    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate2 =
        new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(
        mobileAppDeliveryMethodNotificationTemplate, mobileAppDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppDeliveryMethodNotificationTemplate.equals(Object)",
    "int MobileAppDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate =
        new MobileAppDeliveryMethodNotificationTemplate();

    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate2 =
        new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate2.setAdditionalConfig(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(
        mobileAppDeliveryMethodNotificationTemplate, mobileAppDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppDeliveryMethodNotificationTemplate.equals(Object)",
    "int MobileAppDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate =
        new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate2 =
        new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(
        mobileAppDeliveryMethodNotificationTemplate, mobileAppDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppDeliveryMethodNotificationTemplate.equals(Object)",
    "int MobileAppDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate =
        new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate.setAdditionalConfig(DoubleNode.valueOf(10.0d));

    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate2 =
        new MobileAppDeliveryMethodNotificationTemplate();
    mobileAppDeliveryMethodNotificationTemplate2.setAdditionalConfig(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(
        mobileAppDeliveryMethodNotificationTemplate, mobileAppDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppDeliveryMethodNotificationTemplate.equals(Object)",
    "int MobileAppDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppDeliveryMethodNotificationTemplate(), null);
  }

  /**
   * Test {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MobileAppDeliveryMethodNotificationTemplate.equals(Object)",
    "int MobileAppDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new MobileAppDeliveryMethodNotificationTemplate(),
        "Different type to MobileAppDeliveryMethodNotificationTemplate");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#setAdditionalConfig(JsonNode)}
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#setSubject(String)}
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#toString()}
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#getAdditionalConfig()}
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#getMethod()}
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#getSubject()}
   *   <li>{@link MobileAppDeliveryMethodNotificationTemplate#getTemplatableValues()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonNode MobileAppDeliveryMethodNotificationTemplate.getAdditionalConfig()",
    "NotificationDeliveryMethod MobileAppDeliveryMethodNotificationTemplate.getMethod()",
    "String MobileAppDeliveryMethodNotificationTemplate.getSubject()",
    "List MobileAppDeliveryMethodNotificationTemplate.getTemplatableValues()",
    "void MobileAppDeliveryMethodNotificationTemplate.setAdditionalConfig(JsonNode)",
    "void MobileAppDeliveryMethodNotificationTemplate.setSubject(String)",
    "String MobileAppDeliveryMethodNotificationTemplate.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    MobileAppDeliveryMethodNotificationTemplate mobileAppDeliveryMethodNotificationTemplate =
        new MobileAppDeliveryMethodNotificationTemplate();
    DoubleNode additionalConfig = DoubleNode.valueOf(10.0d);

    // Act
    mobileAppDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);
    mobileAppDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");
    mobileAppDeliveryMethodNotificationTemplate.toString();
    JsonNode actualAdditionalConfig =
        mobileAppDeliveryMethodNotificationTemplate.getAdditionalConfig();
    NotificationDeliveryMethod actualMethod =
        mobileAppDeliveryMethodNotificationTemplate.getMethod();
    String actualSubject = mobileAppDeliveryMethodNotificationTemplate.getSubject();
    List<TemplatableValue> actualTemplatableValues =
        mobileAppDeliveryMethodNotificationTemplate.getTemplatableValues();

    // Assert
    assertEquals("Hello from the Dreaming Spires", actualSubject);
    assertEquals(2, actualTemplatableValues.size());
    assertEquals("Hello from the Dreaming Spires", actualTemplatableValues.get(1).get());
    assertNull(actualTemplatableValues.get(0).get());
    assertEquals(NotificationDeliveryMethod.MOBILE_APP, actualMethod);
    assertSame(additionalConfig, actualAdditionalConfig);
  }
}
