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
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class NotificationTemplateConfigDiffblueTest {
  /**
   * Test {@link NotificationTemplateConfig#copy()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code WEB} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateConfig#copy()}
   */
  @Test
  @DisplayName("Test copy(); given HashMap() computeIfPresent 'WEB' and BiFunction")
  void testCopy_givenHashMapComputeIfPresentWebAndBiFunction() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = new HashMap<>();
    deliveryMethodsTemplates.computeIfPresent(NotificationDeliveryMethod.WEB, mock(BiFunction.class));
    deliveryMethodsTemplates.put(NotificationDeliveryMethod.WEB, new EmailDeliveryMethodNotificationTemplate());

    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    notificationTemplateConfig.setDeliveryMethodsTemplates(deliveryMethodsTemplates);

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates2 = notificationTemplateConfig
        .copy()
        .getDeliveryMethodsTemplates();
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
   * Test {@link NotificationTemplateConfig#copy()}.
   * <ul>
   *   <li>Then return DeliveryMethodsTemplates Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateConfig#copy()}
   */
  @Test
  @DisplayName("Test copy(); then return DeliveryMethodsTemplates Empty")
  void testCopy_thenReturnDeliveryMethodsTemplatesEmpty() {
    // Arrange
    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    notificationTemplateConfig.setDeliveryMethodsTemplates(new HashMap<>());

    // Act and Assert
    assertTrue(notificationTemplateConfig.copy().getDeliveryMethodsTemplates().isEmpty());
  }

  /**
   * Test {@link NotificationTemplateConfig#copy()}.
   * <ul>
   *   <li>Then return DeliveryMethodsTemplates size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateConfig#copy()}
   */
  @Test
  @DisplayName("Test copy(); then return DeliveryMethodsTemplates size is one")
  void testCopy_thenReturnDeliveryMethodsTemplatesSizeIsOne() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = new HashMap<>();
    deliveryMethodsTemplates.put(NotificationDeliveryMethod.WEB, new EmailDeliveryMethodNotificationTemplate());

    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    notificationTemplateConfig.setDeliveryMethodsTemplates(deliveryMethodsTemplates);

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates2 = notificationTemplateConfig
        .copy()
        .getDeliveryMethodsTemplates();
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
   * Test {@link NotificationTemplateConfig#copy()}.
   * <ul>
   *   <li>Then return DeliveryMethodsTemplates size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateConfig#copy()}
   */
  @Test
  @DisplayName("Test copy(); then return DeliveryMethodsTemplates size is two")
  void testCopy_thenReturnDeliveryMethodsTemplatesSizeIsTwo() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = new HashMap<>();
    deliveryMethodsTemplates.put(NotificationDeliveryMethod.EMAIL, new EmailDeliveryMethodNotificationTemplate());
    deliveryMethodsTemplates.put(NotificationDeliveryMethod.WEB, new EmailDeliveryMethodNotificationTemplate());

    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    notificationTemplateConfig.setDeliveryMethodsTemplates(deliveryMethodsTemplates);

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates2 = notificationTemplateConfig
        .copy()
        .getDeliveryMethodsTemplates();
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
   * Test {@link NotificationTemplateConfig#equals(Object)}, and
   * {@link NotificationTemplateConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplateConfig#equals(Object)}
   *   <li>{@link NotificationTemplateConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    NotificationTemplateConfig notificationTemplateConfig2 = new NotificationTemplateConfig();

    // Act and Assert
    assertEquals(notificationTemplateConfig, notificationTemplateConfig2);
    int expectedHashCodeResult = notificationTemplateConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplateConfig2.hashCode());
  }

  /**
   * Test {@link NotificationTemplateConfig#equals(Object)}, and
   * {@link NotificationTemplateConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplateConfig#equals(Object)}
   *   <li>{@link NotificationTemplateConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    notificationTemplateConfig.setDeliveryMethodsTemplates(new HashMap<>());

    NotificationTemplateConfig notificationTemplateConfig2 = new NotificationTemplateConfig();
    notificationTemplateConfig2.setDeliveryMethodsTemplates(new HashMap<>());

    // Act and Assert
    assertEquals(notificationTemplateConfig, notificationTemplateConfig2);
    int expectedHashCodeResult = notificationTemplateConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplateConfig2.hashCode());
  }

  /**
   * Test {@link NotificationTemplateConfig#equals(Object)}, and
   * {@link NotificationTemplateConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplateConfig#equals(Object)}
   *   <li>{@link NotificationTemplateConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();

    // Act and Assert
    assertEquals(notificationTemplateConfig, notificationTemplateConfig);
    int expectedHashCodeResult = notificationTemplateConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplateConfig.hashCode());
  }

  /**
   * Test {@link NotificationTemplateConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationTemplateConfig(), 1);
  }

  /**
   * Test {@link NotificationTemplateConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    notificationTemplateConfig.setDeliveryMethodsTemplates(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationTemplateConfig, new NotificationTemplateConfig());
  }

  /**
   * Test {@link NotificationTemplateConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();

    NotificationTemplateConfig notificationTemplateConfig2 = new NotificationTemplateConfig();
    notificationTemplateConfig2.setDeliveryMethodsTemplates(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationTemplateConfig, notificationTemplateConfig2);
  }

  /**
   * Test {@link NotificationTemplateConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = new HashMap<>();
    deliveryMethodsTemplates.computeIfPresent(NotificationDeliveryMethod.WEB, mock(BiFunction.class));

    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    notificationTemplateConfig.setDeliveryMethodsTemplates(deliveryMethodsTemplates);

    // Act and Assert
    assertNotEquals(notificationTemplateConfig, new NotificationTemplateConfig());
  }

  /**
   * Test {@link NotificationTemplateConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationTemplateConfig(), null);
  }

  /**
   * Test {@link NotificationTemplateConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationTemplateConfig(), "Different type to NotificationTemplateConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link NotificationTemplateConfig}
   *   <li>{@link NotificationTemplateConfig#setDeliveryMethodsTemplates(Map)}
   *   <li>{@link NotificationTemplateConfig#toString()}
   *   <li>{@link NotificationTemplateConfig#getDeliveryMethodsTemplates()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationTemplateConfig actualNotificationTemplateConfig = new NotificationTemplateConfig();
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = new HashMap<>();
    actualNotificationTemplateConfig.setDeliveryMethodsTemplates(deliveryMethodsTemplates);
    String actualToStringResult = actualNotificationTemplateConfig.toString();
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> actualDeliveryMethodsTemplates = actualNotificationTemplateConfig
        .getDeliveryMethodsTemplates();

    // Assert that nothing has changed
    assertEquals("NotificationTemplateConfig(deliveryMethodsTemplates={})", actualToStringResult);
    assertTrue(actualDeliveryMethodsTemplates.isEmpty());
    assertSame(deliveryMethodsTemplates, actualDeliveryMethodsTemplates);
  }
}
