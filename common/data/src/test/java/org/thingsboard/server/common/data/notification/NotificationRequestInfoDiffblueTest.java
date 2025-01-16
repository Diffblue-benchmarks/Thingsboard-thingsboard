package org.thingsboard.server.common.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;

class NotificationRequestInfoDiffblueTest {
  /**
   * Test {@link NotificationRequestInfo#equals(Object)}, and
   * {@link NotificationRequestInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestInfo#equals(Object)}
   *   <li>{@link NotificationRequestInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link NotificationRequestInfo#equals(Object)}, and
   * {@link NotificationRequestInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestInfo#equals(Object)}
   *   <li>{@link NotificationRequestInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link NotificationRequestInfo#equals(Object)}, and
   * {@link NotificationRequestInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestInfo#equals(Object)}
   *   <li>{@link NotificationRequestInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link NotificationRequestInfo#equals(Object)}, and
   * {@link NotificationRequestInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestInfo#equals(Object)}
   *   <li>{@link NotificationRequestInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest request = templateResult
        .templateId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo(request, "Template Name",
        new ArrayList<>());

    // Act and Assert
    assertNotEquals(notificationRequestInfo, new NotificationRequestInfo());
  }

  /**
   * Test {@link NotificationRequestInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();
    notificationRequestInfo.setTemplateName("Template Name");

    // Act and Assert
    assertNotEquals(notificationRequestInfo, new NotificationRequestInfo());
  }

  /**
   * Test {@link NotificationRequestInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();
    notificationRequestInfo.setDeliveryMethods(new ArrayList<>());

    // Act and Assert
    assertNotEquals(notificationRequestInfo, new NotificationRequestInfo());
  }

  /**
   * Test {@link NotificationRequestInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRequestInfo(), null);
  }

  /**
   * Test {@link NotificationRequestInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRequestInfo(), "Different type to NotificationRequestInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationRequestInfo actualNotificationRequestInfo = new NotificationRequestInfo();
    ArrayList<NotificationDeliveryMethod> deliveryMethods = new ArrayList<>();
    actualNotificationRequestInfo.setDeliveryMethods(deliveryMethods);
    actualNotificationRequestInfo.setTemplateName("Template Name");
    String actualToStringResult = actualNotificationRequestInfo.toString();
    List<NotificationDeliveryMethod> actualDeliveryMethods = actualNotificationRequestInfo.getDeliveryMethods();

    // Assert that nothing has changed
    assertEquals("NotificationRequestInfo(templateName=Template Name, deliveryMethods=[])", actualToStringResult);
    assertEquals("Template Name", actualNotificationRequestInfo.getTemplateName());
    assertEquals(0L, actualNotificationRequestInfo.getCreatedTime());
    assertTrue(actualDeliveryMethods.isEmpty());
    assertSame(deliveryMethods, actualDeliveryMethods);
  }

  /**
   * Test
   * {@link NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String, List)}.
   * <ul>
   *   <li>Given {@code EMAIL}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code EMAIL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String, List)}
   */
  @Test
  @DisplayName("Test new NotificationRequestInfo(NotificationRequest, String, List); given 'EMAIL'; when ArrayList() add 'EMAIL'")
  void testNewNotificationRequestInfo_givenEmail_whenArrayListAddEmail() {
    // Arrange
    NotificationRequest request = new NotificationRequest();

    ArrayList<NotificationDeliveryMethod> deliveryMethods = new ArrayList<>();
    deliveryMethods.add(NotificationDeliveryMethod.EMAIL);
    deliveryMethods.add(NotificationDeliveryMethod.WEB);

    // Act
    NotificationRequestInfo actualNotificationRequestInfo = new NotificationRequestInfo(request, "Template Name",
        deliveryMethods);

    // Assert
    assertEquals("To targets null", actualNotificationRequestInfo.getName());
    assertNull(actualNotificationRequestInfo.getTargets());
    assertNull(actualNotificationRequestInfo.getOriginatorEntityId());
    assertNull(actualNotificationRequestInfo.getRuleId());
    assertNull(actualNotificationRequestInfo.getTemplateId());
    assertNull(actualNotificationRequestInfo.getTenantId());
    assertNull(actualNotificationRequestInfo.getStats());
    assertNull(actualNotificationRequestInfo.getStatus());
    assertNull(actualNotificationRequestInfo.getInfo());
    assertNull(actualNotificationRequestInfo.getTemplate());
    assertSame(deliveryMethods, actualNotificationRequestInfo.getDeliveryMethods());
  }

  /**
   * Test
   * {@link NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String, List)}.
   * <ul>
   *   <li>Given {@code WEB}.</li>
   *   <li>Then return DeliveryMethods is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String, List)}
   */
  @Test
  @DisplayName("Test new NotificationRequestInfo(NotificationRequest, String, List); given 'WEB'; then return DeliveryMethods is ArrayList()")
  void testNewNotificationRequestInfo_givenWeb_thenReturnDeliveryMethodsIsArrayList() {
    // Arrange
    NotificationRequest request = new NotificationRequest();

    ArrayList<NotificationDeliveryMethod> deliveryMethods = new ArrayList<>();
    deliveryMethods.add(NotificationDeliveryMethod.WEB);

    // Act
    NotificationRequestInfo actualNotificationRequestInfo = new NotificationRequestInfo(request, "Template Name",
        deliveryMethods);

    // Assert
    assertEquals("To targets null", actualNotificationRequestInfo.getName());
    assertNull(actualNotificationRequestInfo.getTargets());
    assertNull(actualNotificationRequestInfo.getOriginatorEntityId());
    assertNull(actualNotificationRequestInfo.getRuleId());
    assertNull(actualNotificationRequestInfo.getTemplateId());
    assertNull(actualNotificationRequestInfo.getTenantId());
    assertNull(actualNotificationRequestInfo.getStats());
    assertNull(actualNotificationRequestInfo.getStatus());
    assertNull(actualNotificationRequestInfo.getInfo());
    assertNull(actualNotificationRequestInfo.getTemplate());
    assertSame(deliveryMethods, actualNotificationRequestInfo.getDeliveryMethods());
  }

  /**
   * Test
   * {@link NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String, List)}.
   * <ul>
   *   <li>Then OriginatorEntityId return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String, List)}
   */
  @Test
  @DisplayName("Test new NotificationRequestInfo(NotificationRequest, String, List); then OriginatorEntityId return TenantId")
  void testNewNotificationRequestInfo_thenOriginatorEntityIdReturnTenantId() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRuleId ruleId = new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult.ruleId(ruleId);
    NotificationRequestStats stats = new NotificationRequestStats();
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(stats)
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationTemplate template = new NotificationTemplate();
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(template);
    NotificationTemplateId templateId = new NotificationTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRequest request = templateResult.templateId(templateId).tenantId(TenantId.SYS_TENANT_ID).build();

    // Act
    NotificationRequestInfo actualNotificationRequestInfo = new NotificationRequestInfo(request, "Template Name",
        new ArrayList<>());

    // Assert
    EntityId originatorEntityId = actualNotificationRequestInfo.getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.getId().toString());
    assertEquals("To targets []", actualNotificationRequestInfo.getName());
    assertEquals(EntityType.TENANT, originatorEntityId.getEntityType());
    assertEquals(NotificationRequestStatus.PROCESSING, actualNotificationRequestInfo.getStatus());
    assertTrue(actualNotificationRequestInfo.getTargets().isEmpty());
    assertTrue(originatorEntityId.isNullUid());
    assertTrue(((TenantId) originatorEntityId).isSysTenantId());
    assertSame(ruleId, actualNotificationRequestInfo.getRuleId());
    assertSame(templateId, actualNotificationRequestInfo.getTemplateId());
    assertSame(stats, actualNotificationRequestInfo.getStats());
    assertSame(template, actualNotificationRequestInfo.getTemplate());
    assertSame(originatorEntityId, actualNotificationRequestInfo.getTenantId());
  }

  /**
   * Test
   * {@link NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return DeliveryMethods Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String, List)}
   */
  @Test
  @DisplayName("Test new NotificationRequestInfo(NotificationRequest, String, List); when ArrayList(); then return DeliveryMethods Empty")
  void testNewNotificationRequestInfo_whenArrayList_thenReturnDeliveryMethodsEmpty() {
    // Arrange
    NotificationRequest request = new NotificationRequest();

    // Act
    NotificationRequestInfo actualNotificationRequestInfo = new NotificationRequestInfo(request, "Template Name",
        new ArrayList<>());

    // Assert
    assertEquals("To targets null", actualNotificationRequestInfo.getName());
    assertNull(actualNotificationRequestInfo.getTargets());
    assertNull(actualNotificationRequestInfo.getOriginatorEntityId());
    assertNull(actualNotificationRequestInfo.getRuleId());
    assertNull(actualNotificationRequestInfo.getTemplateId());
    assertNull(actualNotificationRequestInfo.getTenantId());
    assertNull(actualNotificationRequestInfo.getStats());
    assertNull(actualNotificationRequestInfo.getStatus());
    assertNull(actualNotificationRequestInfo.getInfo());
    assertNull(actualNotificationRequestInfo.getTemplate());
    assertTrue(actualNotificationRequestInfo.getDeliveryMethods().isEmpty());
  }
}
