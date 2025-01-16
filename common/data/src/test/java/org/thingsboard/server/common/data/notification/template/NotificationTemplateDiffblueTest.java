package org.thingsboard.server.common.data.notification.template;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationType;

class NotificationTemplateDiffblueTest {
  /**
   * Test {@link NotificationTemplate#equals(Object)}, and
   * {@link NotificationTemplate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplate#equals(Object)}
   *   <li>{@link NotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    NotificationTemplate notificationTemplate2 = new NotificationTemplate();

    // Act and Assert
    assertEquals(notificationTemplate, notificationTemplate2);
    int expectedHashCodeResult = notificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplate2.hashCode());
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}, and
   * {@link NotificationTemplate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplate#equals(Object)}
   *   <li>{@link NotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setTenantId(TenantId.SYS_TENANT_ID);

    NotificationTemplate notificationTemplate2 = new NotificationTemplate();
    notificationTemplate2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(notificationTemplate, notificationTemplate2);
    int expectedHashCodeResult = notificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplate2.hashCode());
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}, and
   * {@link NotificationTemplate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplate#equals(Object)}
   *   <li>{@link NotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setName("Name");

    NotificationTemplate notificationTemplate2 = new NotificationTemplate();
    notificationTemplate2.setName("Name");

    // Act and Assert
    assertEquals(notificationTemplate, notificationTemplate2);
    int expectedHashCodeResult = notificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplate2.hashCode());
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}, and
   * {@link NotificationTemplate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplate#equals(Object)}
   *   <li>{@link NotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setNotificationType(NotificationType.GENERAL);

    NotificationTemplate notificationTemplate2 = new NotificationTemplate();
    notificationTemplate2.setNotificationType(NotificationType.GENERAL);

    // Act and Assert
    assertEquals(notificationTemplate, notificationTemplate2);
    int expectedHashCodeResult = notificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplate2.hashCode());
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}, and
   * {@link NotificationTemplate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplate#equals(Object)}
   *   <li>{@link NotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setConfiguration(new NotificationTemplateConfig());

    NotificationTemplate notificationTemplate2 = new NotificationTemplate();
    notificationTemplate2.setConfiguration(new NotificationTemplateConfig());

    // Act and Assert
    assertEquals(notificationTemplate, notificationTemplate2);
    int expectedHashCodeResult = notificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplate2.hashCode());
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}, and
   * {@link NotificationTemplate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplate#equals(Object)}
   *   <li>{@link NotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate
        .setExternalId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    NotificationTemplate notificationTemplate2 = new NotificationTemplate();
    notificationTemplate2
        .setExternalId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertEquals(notificationTemplate, notificationTemplate2);
    int expectedHashCodeResult = notificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplate2.hashCode());
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}, and
   * {@link NotificationTemplate#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplate#equals(Object)}
   *   <li>{@link NotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();

    // Act and Assert
    assertEquals(notificationTemplate, notificationTemplate);
    int expectedHashCodeResult = notificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplate.hashCode());
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationTemplate(), 1);
    assertNotEquals(new NotificationTemplate(), mock(AdminSettings.class));
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(notificationTemplate, new NotificationTemplate());
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setName("Name");

    // Act and Assert
    assertNotEquals(notificationTemplate, new NotificationTemplate());
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setNotificationType(NotificationType.GENERAL);

    // Act and Assert
    assertNotEquals(notificationTemplate, new NotificationTemplate());
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setConfiguration(new NotificationTemplateConfig());

    // Act and Assert
    assertNotEquals(notificationTemplate, new NotificationTemplate());
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate
        .setExternalId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(notificationTemplate, new NotificationTemplate());
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(notificationTemplate, new NotificationTemplate());
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();

    NotificationTemplate notificationTemplate2 = new NotificationTemplate();
    notificationTemplate2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(notificationTemplate, notificationTemplate2);
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();

    NotificationTemplate notificationTemplate2 = new NotificationTemplate();
    notificationTemplate2.setName("Name");

    // Act and Assert
    assertNotEquals(notificationTemplate, notificationTemplate2);
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();

    NotificationTemplate notificationTemplate2 = new NotificationTemplate();
    notificationTemplate2.setNotificationType(NotificationType.GENERAL);

    // Act and Assert
    assertNotEquals(notificationTemplate, notificationTemplate2);
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();

    NotificationTemplate notificationTemplate2 = new NotificationTemplate();
    notificationTemplate2.setConfiguration(new NotificationTemplateConfig());

    // Act and Assert
    assertNotEquals(notificationTemplate, notificationTemplate2);
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();

    NotificationTemplate notificationTemplate2 = new NotificationTemplate();
    notificationTemplate2
        .setExternalId(new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(notificationTemplate, notificationTemplate2);
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationTemplate(), null);
  }

  /**
   * Test {@link NotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationTemplate(), "Different type to NotificationTemplate");
  }

  /**
   * Test {@link NotificationTemplate#getExternalId()}.
   * <p>
   * Method under test: {@link NotificationTemplate#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new NotificationTemplate()).getExternalId());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplate#NotificationTemplate()}
   *   <li>{@link NotificationTemplate#setConfiguration(NotificationTemplateConfig)}
   *   <li>{@link NotificationTemplate#setExternalId(NotificationTemplateId)}
   *   <li>{@link NotificationTemplate#setName(String)}
   *   <li>{@link NotificationTemplate#setNotificationType(NotificationType)}
   *   <li>{@link NotificationTemplate#setTenantId(TenantId)}
   *   <li>{@link NotificationTemplate#toString()}
   *   <li>{@link NotificationTemplate#getConfiguration()}
   *   <li>{@link NotificationTemplate#getName()}
   *   <li>{@link NotificationTemplate#getNotificationType()}
   *   <li>{@link NotificationTemplate#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationTemplate actualNotificationTemplate = new NotificationTemplate();
    NotificationTemplateConfig configuration = new NotificationTemplateConfig();
    actualNotificationTemplate.setConfiguration(configuration);
    NotificationTemplateId externalId = new NotificationTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualNotificationTemplate.setExternalId(externalId);
    actualNotificationTemplate.setName("Name");
    actualNotificationTemplate.setNotificationType(NotificationType.GENERAL);
    actualNotificationTemplate.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualNotificationTemplate.toString();
    NotificationTemplateConfig actualConfiguration = actualNotificationTemplate.getConfiguration();
    String actualName = actualNotificationTemplate.getName();
    NotificationType actualNotificationType = actualNotificationTemplate.getNotificationType();
    TenantId actualTenantId = actualNotificationTemplate.getTenantId();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(
        "NotificationTemplate(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, notificationType=GENERAL,"
            + " configuration=NotificationTemplateConfig(deliveryMethodsTemplates=null), externalId=784f394c-42b6"
            + "-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertEquals(0L, actualNotificationTemplate.getCreatedTime());
    assertEquals(NotificationType.GENERAL, actualNotificationType);
    assertSame(externalId, actualNotificationTemplate.getExternalId());
    assertSame(configuration, actualConfiguration);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link NotificationTemplate#NotificationTemplate(NotificationTemplate)}.
   * <p>
   * Method under test:
   * {@link NotificationTemplate#NotificationTemplate(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test new NotificationTemplate(NotificationTemplate)")
  void testNewNotificationTemplate() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = new HashMap<>();
    deliveryMethodsTemplates.put(NotificationDeliveryMethod.WEB, new EmailDeliveryMethodNotificationTemplate());

    NotificationTemplateConfig configuration = new NotificationTemplateConfig();
    configuration.setDeliveryMethodsTemplates(deliveryMethodsTemplates);

    NotificationTemplate other = new NotificationTemplate();
    other.setConfiguration(configuration);

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates2 = (new NotificationTemplate(
        other)).getConfiguration().getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates2.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates2.get(NotificationDeliveryMethod.WEB);
    assertTrue(getResult instanceof EmailDeliveryMethodNotificationTemplate);
    assertNull(getResult.getBody());
    assertNull(((EmailDeliveryMethodNotificationTemplate) getResult).getSubject());
    List<TemplatableValue> templatableValues = getResult.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, getResult.getMethod());
    assertFalse(getResult.isEnabled());
  }

  /**
   * Test {@link NotificationTemplate#NotificationTemplate(NotificationTemplate)}.
   * <p>
   * Method under test:
   * {@link NotificationTemplate#NotificationTemplate(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test new NotificationTemplate(NotificationTemplate)")
  void testNewNotificationTemplate2() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = new HashMap<>();
    deliveryMethodsTemplates.put(NotificationDeliveryMethod.EMAIL, new EmailDeliveryMethodNotificationTemplate());
    deliveryMethodsTemplates.put(NotificationDeliveryMethod.WEB, new EmailDeliveryMethodNotificationTemplate());

    NotificationTemplateConfig configuration = new NotificationTemplateConfig();
    configuration.setDeliveryMethodsTemplates(deliveryMethodsTemplates);

    NotificationTemplate other = new NotificationTemplate();
    other.setConfiguration(configuration);

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates2 = (new NotificationTemplate(
        other)).getConfiguration().getDeliveryMethodsTemplates();
    assertEquals(2, deliveryMethodsTemplates2.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates2.get(NotificationDeliveryMethod.EMAIL);
    assertTrue(getResult instanceof EmailDeliveryMethodNotificationTemplate);
    assertNull(getResult.getBody());
    assertNull(((EmailDeliveryMethodNotificationTemplate) getResult).getSubject());
    List<TemplatableValue> templatableValues = getResult.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, getResult.getMethod());
    assertFalse(getResult.isEnabled());
    assertTrue(deliveryMethodsTemplates2.containsKey(NotificationDeliveryMethod.WEB));
  }

  /**
   * Test {@link NotificationTemplate#NotificationTemplate(NotificationTemplate)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code WEB} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplate#NotificationTemplate(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test new NotificationTemplate(NotificationTemplate); given HashMap() computeIfPresent 'WEB' and BiFunction")
  void testNewNotificationTemplate_givenHashMapComputeIfPresentWebAndBiFunction() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = new HashMap<>();
    deliveryMethodsTemplates.computeIfPresent(NotificationDeliveryMethod.WEB, mock(BiFunction.class));
    deliveryMethodsTemplates.put(NotificationDeliveryMethod.WEB, new EmailDeliveryMethodNotificationTemplate());

    NotificationTemplateConfig configuration = new NotificationTemplateConfig();
    configuration.setDeliveryMethodsTemplates(deliveryMethodsTemplates);

    NotificationTemplate other = new NotificationTemplate();
    other.setConfiguration(configuration);

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates2 = (new NotificationTemplate(
        other)).getConfiguration().getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates2.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates2.get(NotificationDeliveryMethod.WEB);
    assertTrue(getResult instanceof EmailDeliveryMethodNotificationTemplate);
    assertNull(getResult.getBody());
    assertNull(((EmailDeliveryMethodNotificationTemplate) getResult).getSubject());
    List<TemplatableValue> templatableValues = getResult.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, getResult.getMethod());
    assertFalse(getResult.isEnabled());
  }

  /**
   * Test {@link NotificationTemplate#NotificationTemplate(NotificationTemplate)}.
   * <ul>
   *   <li>Then return {@link NotificationTemplate#NotificationTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplate#NotificationTemplate(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test new NotificationTemplate(NotificationTemplate); then return NotificationTemplate()")
  void testNewNotificationTemplate_thenReturnNotificationTemplate() {
    // Arrange
    NotificationTemplateConfig configuration = new NotificationTemplateConfig();
    configuration.setDeliveryMethodsTemplates(new HashMap<>());

    NotificationTemplate other = new NotificationTemplate();
    other.setConfiguration(configuration);

    // Act and Assert
    assertEquals(other, new NotificationTemplate(other));
  }

  /**
   * Test {@link NotificationTemplate#NotificationTemplate(NotificationTemplate)}.
   * <ul>
   *   <li>When {@link NotificationTemplate#NotificationTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplate#NotificationTemplate(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test new NotificationTemplate(NotificationTemplate); when NotificationTemplate()")
  void testNewNotificationTemplate_whenNotificationTemplate() {
    // Arrange
    NotificationTemplate other = new NotificationTemplate();

    // Act and Assert
    assertEquals(other, new NotificationTemplate(other));
  }
}
