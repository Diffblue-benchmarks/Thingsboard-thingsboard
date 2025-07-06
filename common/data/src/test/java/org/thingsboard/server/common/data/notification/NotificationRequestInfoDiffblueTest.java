package org.thingsboard.server.common.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationRequest.NotificationRequestBuilder;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;

class NotificationRequestInfoDiffblueTest {
  /**
   * Test {@link NotificationRequestInfo#equals(Object)}, and {@link
   * NotificationRequestInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequestInfo#equals(Object)}
   *   <li>{@link NotificationRequestInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequestInfo.equals(Object)",
    "int NotificationRequestInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();
    NotificationRequestInfo notificationRequestInfo2 = new NotificationRequestInfo();

    // Act and Assert
    assertEquals(notificationRequestInfo, notificationRequestInfo2);
    int expectedHashCodeResult = notificationRequestInfo.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestInfo2.hashCode());
  }

  /**
   * Test {@link NotificationRequestInfo#equals(Object)}, and {@link
   * NotificationRequestInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequestInfo#equals(Object)}
   *   <li>{@link NotificationRequestInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequestInfo.equals(Object)",
    "int NotificationRequestInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();
    notificationRequestInfo.setTemplateName("Template Name");

    NotificationRequestInfo notificationRequestInfo2 = new NotificationRequestInfo();
    notificationRequestInfo2.setTemplateName("Template Name");

    // Act and Assert
    assertEquals(notificationRequestInfo, notificationRequestInfo2);
    int expectedHashCodeResult = notificationRequestInfo.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestInfo2.hashCode());
  }

  /**
   * Test {@link NotificationRequestInfo#equals(Object)}, and {@link
   * NotificationRequestInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequestInfo#equals(Object)}
   *   <li>{@link NotificationRequestInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequestInfo.equals(Object)",
    "int NotificationRequestInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();
    notificationRequestInfo.setDeliveryMethods(new ArrayList<>());

    NotificationRequestInfo notificationRequestInfo2 = new NotificationRequestInfo();
    notificationRequestInfo2.setDeliveryMethods(new ArrayList<>());

    // Act and Assert
    assertEquals(notificationRequestInfo, notificationRequestInfo2);
    int expectedHashCodeResult = notificationRequestInfo.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestInfo2.hashCode());
  }

  /**
   * Test {@link NotificationRequestInfo#equals(Object)}, and {@link
   * NotificationRequestInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequestInfo#equals(Object)}
   *   <li>{@link NotificationRequestInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequestInfo.equals(Object)",
    "int NotificationRequestInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();

    // Act and Assert
    assertEquals(notificationRequestInfo, notificationRequestInfo);
    int expectedHashCodeResult = notificationRequestInfo.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestInfo.hashCode());
  }

  /**
   * Test {@link NotificationRequestInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequestInfo.equals(Object)",
    "int NotificationRequestInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequestBuilder originatorEntityIdResult =
        NotificationRequest.builder()
            .info(mock(NotificationInfo.class))
            .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);
    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest request =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(TenantId.SYS_TENANT_ID)
            .build();
    NotificationRequestInfo notificationRequestInfo =
        new NotificationRequestInfo(request, "Template Name", new ArrayList<>());

    // Act and Assert
    assertNotEquals(notificationRequestInfo, new NotificationRequestInfo());
  }

  /**
   * Test {@link NotificationRequestInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequestInfo.equals(Object)",
    "int NotificationRequestInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();
    notificationRequestInfo.setTemplateName("Template Name");

    // Act and Assert
    assertNotEquals(notificationRequestInfo, new NotificationRequestInfo());
  }

  /**
   * Test {@link NotificationRequestInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequestInfo.equals(Object)",
    "int NotificationRequestInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();
    notificationRequestInfo.setDeliveryMethods(new ArrayList<>());

    // Act and Assert
    assertNotEquals(notificationRequestInfo, new NotificationRequestInfo());
  }

  /**
   * Test {@link NotificationRequestInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequestInfo.equals(Object)",
    "int NotificationRequestInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();

    NotificationRequestInfo notificationRequestInfo2 = new NotificationRequestInfo();
    notificationRequestInfo2.setTemplateName("Template Name");

    // Act and Assert
    assertNotEquals(notificationRequestInfo, notificationRequestInfo2);
  }

  /**
   * Test {@link NotificationRequestInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequestInfo.equals(Object)",
    "int NotificationRequestInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();

    NotificationRequestInfo notificationRequestInfo2 = new NotificationRequestInfo();
    notificationRequestInfo2.setDeliveryMethods(new ArrayList<>());

    // Act and Assert
    assertNotEquals(notificationRequestInfo, notificationRequestInfo2);
  }

  /**
   * Test {@link NotificationRequestInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequestInfo.equals(Object)",
    "int NotificationRequestInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRequestInfo(), null);
  }

  /**
   * Test {@link NotificationRequestInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationRequestInfo.equals(Object)",
    "int NotificationRequestInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRequestInfo(), "Different type to NotificationRequestInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequestInfo#NotificationRequestInfo()}
   *   <li>{@link NotificationRequestInfo#setDeliveryMethods(List)}
   *   <li>{@link NotificationRequestInfo#setTemplateName(String)}
   *   <li>{@link NotificationRequestInfo#toString()}
   *   <li>{@link NotificationRequestInfo#getDeliveryMethods()}
   *   <li>{@link NotificationRequestInfo#getTemplateName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void NotificationRequestInfo.<init>()",
    "List NotificationRequestInfo.getDeliveryMethods()",
    "String NotificationRequestInfo.getTemplateName()",
    "void NotificationRequestInfo.setDeliveryMethods(List)",
    "void NotificationRequestInfo.setTemplateName(String)",
    "String NotificationRequestInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationRequestInfo actualNotificationRequestInfo = new NotificationRequestInfo();
    ArrayList<NotificationDeliveryMethod> deliveryMethods = new ArrayList<>();
    actualNotificationRequestInfo.setDeliveryMethods(deliveryMethods);
    actualNotificationRequestInfo.setTemplateName("Template Name");
    String actualToStringResult = actualNotificationRequestInfo.toString();
    List<NotificationDeliveryMethod> actualDeliveryMethods =
        actualNotificationRequestInfo.getDeliveryMethods();

    // Assert
    assertEquals(
        "NotificationRequestInfo(templateName=Template Name, deliveryMethods=[])",
        actualToStringResult);
    assertEquals("Template Name", actualNotificationRequestInfo.getTemplateName());
    assertNull(actualNotificationRequestInfo.getTargets());
    assertNull(actualNotificationRequestInfo.getOriginatorEntityId());
    assertNull(actualNotificationRequestInfo.getId());
    assertNull(actualNotificationRequestInfo.getRuleId());
    assertNull(actualNotificationRequestInfo.getTemplateId());
    assertNull(actualNotificationRequestInfo.getTenantId());
    assertNull(actualNotificationRequestInfo.getAdditionalConfig());
    assertNull(actualNotificationRequestInfo.getStats());
    assertNull(actualNotificationRequestInfo.getStatus());
    assertNull(actualNotificationRequestInfo.getInfo());
    assertNull(actualNotificationRequestInfo.getTemplate());
    assertEquals(0L, actualNotificationRequestInfo.getCreatedTime());
    assertTrue(actualDeliveryMethods.isEmpty());
    assertSame(deliveryMethods, actualDeliveryMethods);
  }

  /**
   * Test {@link NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String,
   * List)}.
   *
   * <ul>
   *   <li>Given {@code EMAIL}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code EMAIL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String, List)}
   */
  @Test
  @DisplayName(
      "Test new NotificationRequestInfo(NotificationRequest, String, List); given 'EMAIL'; when ArrayList() add 'EMAIL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRequestInfo.<init>(NotificationRequest, String, List)"})
  void testNewNotificationRequestInfo_givenEmail_whenArrayListAddEmail() {
    // Arrange
    NotificationRequest request = new NotificationRequest();

    ArrayList<NotificationDeliveryMethod> deliveryMethods = new ArrayList<>();
    deliveryMethods.add(NotificationDeliveryMethod.EMAIL);
    deliveryMethods.add(NotificationDeliveryMethod.WEB);

    // Act
    NotificationRequestInfo actualNotificationRequestInfo =
        new NotificationRequestInfo(request, "Template Name", deliveryMethods);

    // Assert
    assertEquals("Template Name", actualNotificationRequestInfo.getTemplateName());
    assertEquals("To targets null", actualNotificationRequestInfo.getName());
    assertNull(actualNotificationRequestInfo.getTargets());
    assertNull(actualNotificationRequestInfo.getUuidId());
    assertNull(actualNotificationRequestInfo.getOriginatorEntityId());
    assertNull(actualNotificationRequestInfo.getId());
    assertNull(actualNotificationRequestInfo.getRuleId());
    assertNull(actualNotificationRequestInfo.getTemplateId());
    assertNull(actualNotificationRequestInfo.getTenantId());
    assertNull(actualNotificationRequestInfo.getSenderId());
    assertNull(actualNotificationRequestInfo.getAdditionalConfig());
    assertNull(actualNotificationRequestInfo.getStats());
    assertNull(actualNotificationRequestInfo.getStatus());
    assertNull(actualNotificationRequestInfo.getInfo());
    assertNull(actualNotificationRequestInfo.getTemplate());
    assertEquals(0L, actualNotificationRequestInfo.getCreatedTime());
    assertFalse(actualNotificationRequestInfo.isScheduled());
    assertFalse(actualNotificationRequestInfo.isSent());
    assertSame(deliveryMethods, actualNotificationRequestInfo.getDeliveryMethods());
  }

  /**
   * Test {@link NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String,
   * List)}.
   *
   * <ul>
   *   <li>Given {@code WEB}.
   *   <li>Then return DeliveryMethods is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String, List)}
   */
  @Test
  @DisplayName(
      "Test new NotificationRequestInfo(NotificationRequest, String, List); given 'WEB'; then return DeliveryMethods is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRequestInfo.<init>(NotificationRequest, String, List)"})
  void testNewNotificationRequestInfo_givenWeb_thenReturnDeliveryMethodsIsArrayList() {
    // Arrange
    NotificationRequest request = new NotificationRequest();

    ArrayList<NotificationDeliveryMethod> deliveryMethods = new ArrayList<>();
    deliveryMethods.add(NotificationDeliveryMethod.WEB);

    // Act
    NotificationRequestInfo actualNotificationRequestInfo =
        new NotificationRequestInfo(request, "Template Name", deliveryMethods);

    // Assert
    assertEquals("Template Name", actualNotificationRequestInfo.getTemplateName());
    assertEquals("To targets null", actualNotificationRequestInfo.getName());
    assertNull(actualNotificationRequestInfo.getTargets());
    assertNull(actualNotificationRequestInfo.getUuidId());
    assertNull(actualNotificationRequestInfo.getOriginatorEntityId());
    assertNull(actualNotificationRequestInfo.getId());
    assertNull(actualNotificationRequestInfo.getRuleId());
    assertNull(actualNotificationRequestInfo.getTemplateId());
    assertNull(actualNotificationRequestInfo.getTenantId());
    assertNull(actualNotificationRequestInfo.getSenderId());
    assertNull(actualNotificationRequestInfo.getAdditionalConfig());
    assertNull(actualNotificationRequestInfo.getStats());
    assertNull(actualNotificationRequestInfo.getStatus());
    assertNull(actualNotificationRequestInfo.getInfo());
    assertNull(actualNotificationRequestInfo.getTemplate());
    assertEquals(0L, actualNotificationRequestInfo.getCreatedTime());
    assertFalse(actualNotificationRequestInfo.isScheduled());
    assertFalse(actualNotificationRequestInfo.isSent());
    assertSame(deliveryMethods, actualNotificationRequestInfo.getDeliveryMethods());
  }

  /**
   * Test {@link NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return DeliveryMethods Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String, List)}
   */
  @Test
  @DisplayName(
      "Test new NotificationRequestInfo(NotificationRequest, String, List); when ArrayList(); then return DeliveryMethods Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRequestInfo.<init>(NotificationRequest, String, List)"})
  void testNewNotificationRequestInfo_whenArrayList_thenReturnDeliveryMethodsEmpty() {
    // Arrange
    NotificationRequest request = new NotificationRequest();

    // Act
    NotificationRequestInfo actualNotificationRequestInfo =
        new NotificationRequestInfo(request, "Template Name", new ArrayList<>());

    // Assert
    assertEquals("Template Name", actualNotificationRequestInfo.getTemplateName());
    assertEquals("To targets null", actualNotificationRequestInfo.getName());
    assertNull(actualNotificationRequestInfo.getTargets());
    assertNull(actualNotificationRequestInfo.getUuidId());
    assertNull(actualNotificationRequestInfo.getOriginatorEntityId());
    assertNull(actualNotificationRequestInfo.getId());
    assertNull(actualNotificationRequestInfo.getRuleId());
    assertNull(actualNotificationRequestInfo.getTemplateId());
    assertNull(actualNotificationRequestInfo.getTenantId());
    assertNull(actualNotificationRequestInfo.getSenderId());
    assertNull(actualNotificationRequestInfo.getAdditionalConfig());
    assertNull(actualNotificationRequestInfo.getStats());
    assertNull(actualNotificationRequestInfo.getStatus());
    assertNull(actualNotificationRequestInfo.getInfo());
    assertNull(actualNotificationRequestInfo.getTemplate());
    assertEquals(0L, actualNotificationRequestInfo.getCreatedTime());
    assertFalse(actualNotificationRequestInfo.isScheduled());
    assertFalse(actualNotificationRequestInfo.isSent());
    assertTrue(actualNotificationRequestInfo.getDeliveryMethods().isEmpty());
  }
}
