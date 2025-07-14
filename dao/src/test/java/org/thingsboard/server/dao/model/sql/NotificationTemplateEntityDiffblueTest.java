package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.notification.template.NotificationTemplateConfig;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

class NotificationTemplateEntityDiffblueTest {
  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}, and {@link
   * NotificationTemplateEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTemplateEntity#equals(Object)}
   *   <li>{@link NotificationTemplateEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationTemplateEntity, notificationTemplateEntity2);
    int expectedHashCodeResult = notificationTemplateEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplateEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}, and {@link
   * NotificationTemplateEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTemplateEntity#equals(Object)}
   *   <li>{@link NotificationTemplateEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(null);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(null);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationTemplateEntity, notificationTemplateEntity2);
    int expectedHashCodeResult = notificationTemplateEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplateEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}, and {@link
   * NotificationTemplateEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTemplateEntity#equals(Object)}
   *   <li>{@link NotificationTemplateEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(null);
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(null);
    notificationTemplateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationTemplateEntity, notificationTemplateEntity2);
    int expectedHashCodeResult = notificationTemplateEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplateEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}, and {@link
   * NotificationTemplateEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTemplateEntity#equals(Object)}
   *   <li>{@link NotificationTemplateEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationTemplateEntity, notificationTemplateEntity);
    int expectedHashCodeResult = notificationTemplateEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplateEntity.hashCode());
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(DoubleNode.valueOf(10.0d));
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(null);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(3L);
    notificationTemplateEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(null);
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName(null);
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName(
        "org.thingsboard.server.dao.model.sql.NotificationTemplateEntity");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(null);
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.ALARM);
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(null);
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, null);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTemplateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, "Different type to NotificationTemplateEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTemplateEntity#NotificationTemplateEntity()}
   *   <li>{@link NotificationTemplateEntity#setConfiguration(JsonNode)}
   *   <li>{@link NotificationTemplateEntity#setExternalId(UUID)}
   *   <li>{@link NotificationTemplateEntity#setName(String)}
   *   <li>{@link NotificationTemplateEntity#setNotificationType(NotificationType)}
   *   <li>{@link NotificationTemplateEntity#setTenantId(UUID)}
   *   <li>{@link NotificationTemplateEntity#toString()}
   *   <li>{@link NotificationTemplateEntity#getConfiguration()}
   *   <li>{@link NotificationTemplateEntity#getExternalId()}
   *   <li>{@link NotificationTemplateEntity#getName()}
   *   <li>{@link NotificationTemplateEntity#getNotificationType()}
   *   <li>{@link NotificationTemplateEntity#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void NotificationTemplateEntity.<init>()",
    "JsonNode NotificationTemplateEntity.getConfiguration()",
    "UUID NotificationTemplateEntity.getExternalId()",
    "String NotificationTemplateEntity.getName()",
    "NotificationType NotificationTemplateEntity.getNotificationType()",
    "UUID NotificationTemplateEntity.getTenantId()",
    "void NotificationTemplateEntity.setConfiguration(JsonNode)",
    "void NotificationTemplateEntity.setExternalId(UUID)",
    "void NotificationTemplateEntity.setName(String)",
    "void NotificationTemplateEntity.setNotificationType(NotificationType)",
    "void NotificationTemplateEntity.setTenantId(UUID)",
    "String NotificationTemplateEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationTemplateEntity actualNotificationTemplateEntity = new NotificationTemplateEntity();
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualNotificationTemplateEntity.setConfiguration(configuration);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationTemplateEntity.setExternalId(externalId);
    actualNotificationTemplateEntity.setName("Name");
    actualNotificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationTemplateEntity.setTenantId(tenantId);
    String actualToStringResult = actualNotificationTemplateEntity.toString();
    JsonNode actualConfiguration = actualNotificationTemplateEntity.getConfiguration();
    UUID actualExternalId = actualNotificationTemplateEntity.getExternalId();
    String actualName = actualNotificationTemplateEntity.getName();
    NotificationType actualNotificationType =
        actualNotificationTemplateEntity.getNotificationType();
    UUID actualTenantId = actualNotificationTemplateEntity.getTenantId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Name", actualName);
    assertEquals(
        "NotificationTemplateEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, name=Name, notificationType"
            + "=GENERAL, configuration={\"isPublic\":true}, externalId=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertNull(actualNotificationTemplateEntity.getId());
    assertNull(actualNotificationTemplateEntity.getUuid());
    assertEquals(0L, actualNotificationTemplateEntity.getCreatedTime());
    assertEquals(NotificationType.GENERAL, actualNotificationType);
    assertSame(externalId, actualExternalId);
    assertSame(tenantId, actualTenantId);
    assertSame(configuration, actualConfiguration);
  }

  /**
   * Test {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}.
   *
   * <p>Method under test: {@link
   * NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test new NotificationTemplateEntity(NotificationTemplate)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationTemplateEntity.<init>(NotificationTemplate)"})
  void testNewNotificationTemplateEntity() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    notificationTemplate.setExternalId(new NotificationTemplateId(id));

    // Act
    NotificationTemplateEntity actualNotificationTemplateEntity =
        new NotificationTemplateEntity(notificationTemplate);

    // Assert
    UUID externalId = actualNotificationTemplateEntity.getExternalId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", externalId.toString());
    assertNull(actualNotificationTemplateEntity.getConfiguration());
    assertEquals(0L, actualNotificationTemplateEntity.getCreatedTime());
    assertSame(id, externalId);
  }

  /**
   * Test {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}
   */
  @Test
  @DisplayName(
      "Test new NotificationTemplateEntity(NotificationTemplate); given one; then return CreatedTime is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationTemplateEntity.<init>(NotificationTemplate)"})
  void testNewNotificationTemplateEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setCreatedTime(1L);

    // Act
    NotificationTemplateEntity actualNotificationTemplateEntity =
        new NotificationTemplateEntity(notificationTemplate);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationTemplateEntity.getTenantId().toString());
    assertNull(actualNotificationTemplateEntity.getName());
    assertNull(actualNotificationTemplateEntity.getId());
    assertNull(actualNotificationTemplateEntity.getUuid());
    assertNull(actualNotificationTemplateEntity.getExternalId());
    assertNull(actualNotificationTemplateEntity.getNotificationType());
    assertEquals(1L, actualNotificationTemplateEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test new NotificationTemplateEntity(NotificationTemplate); given SYSTEM_TENANT")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationTemplateEntity.<init>(NotificationTemplate)"})
  void testNewNotificationTemplateEntity_givenSystem_tenant() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    NotificationTemplateEntity actualNotificationTemplateEntity =
        new NotificationTemplateEntity(notificationTemplate);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationTemplateEntity.getTenantId().toString());
    assertNull(actualNotificationTemplateEntity.getName());
    assertNull(actualNotificationTemplateEntity.getId());
    assertNull(actualNotificationTemplateEntity.getUuid());
    assertNull(actualNotificationTemplateEntity.getExternalId());
    assertNull(actualNotificationTemplateEntity.getNotificationType());
    assertEquals(0L, actualNotificationTemplateEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}.
   *
   * <ul>
   *   <li>Then Configuration return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}
   */
  @Test
  @DisplayName(
      "Test new NotificationTemplateEntity(NotificationTemplate); then Configuration return ObjectNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationTemplateEntity.<init>(NotificationTemplate)"})
  void testNewNotificationTemplateEntity_thenConfigurationReturnObjectNode() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setConfiguration(new NotificationTemplateConfig());

    // Act and Assert
    assertTrue(
        new NotificationTemplateEntity(notificationTemplate).getConfiguration()
            instanceof ObjectNode);
  }

  /**
   * Test {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}.
   *
   * <ul>
   *   <li>When {@link NotificationTemplate#NotificationTemplate()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}
   */
  @Test
  @DisplayName(
      "Test new NotificationTemplateEntity(NotificationTemplate); when NotificationTemplate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationTemplateEntity.<init>(NotificationTemplate)"})
  void testNewNotificationTemplateEntity_whenNotificationTemplate() {
    // Arrange and Act
    NotificationTemplateEntity actualNotificationTemplateEntity =
        new NotificationTemplateEntity(new NotificationTemplate());

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationTemplateEntity.getTenantId().toString());
    assertNull(actualNotificationTemplateEntity.getName());
    assertNull(actualNotificationTemplateEntity.getId());
    assertNull(actualNotificationTemplateEntity.getUuid());
    assertNull(actualNotificationTemplateEntity.getExternalId());
    assertNull(actualNotificationTemplateEntity.getNotificationType());
    assertEquals(0L, actualNotificationTemplateEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationTemplateEntity#toData()}.
   *
   * <p>Method under test: {@link NotificationTemplateEntity#toData()}
   */
  @Test
  @DisplayName("Test toData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateEntity.toData()"})
  void testToData() {
    // Arrange and Act
    NotificationTemplate actualToDataResult =
        new NotificationTemplateEntity(new NotificationTemplate()).toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getConfiguration());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationTemplateEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link NotificationTemplateEntity#NotificationTemplateEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given NotificationTemplateEntity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateEntity.toData()"})
  void testToData_givenNotificationTemplateEntity() {
    // Arrange and Act
    NotificationTemplate actualToDataResult = new NotificationTemplateEntity().toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getConfiguration());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationTemplateEntity#toData()}.
   *
   * <ul>
   *   <li>Then return Configuration DeliveryMethodsTemplates is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return Configuration DeliveryMethodsTemplates is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateEntity.toData()"})
  void testToData_thenReturnConfigurationDeliveryMethodsTemplatesIsNull() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setConfiguration(new NotificationTemplateConfig());

    // Act
    NotificationTemplate actualToDataResult =
        new NotificationTemplateEntity(notificationTemplate).toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getConfiguration().getDeliveryMethodsTemplates());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationTemplateEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return ExternalId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateEntity.toData()"})
  void testToData_thenReturnExternalIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    notificationTemplateEntity.setExternalId(externalId);

    // Act and Assert
    NotificationTemplateId externalId2 = notificationTemplateEntity.toData().getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertSame(externalId, id);
  }

  /**
   * Test {@link NotificationTemplateEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TenantId Id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateEntity.toData()"})
  void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    UUID tenantId = UUID.randomUUID();
    notificationTemplateEntity.setTenantId(tenantId);

    // Act
    NotificationTemplate actualToDataResult = notificationTemplateEntity.toData();

    // Assert
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getConfiguration());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link NotificationTemplateEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateEntity.toData()"})
  void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    NotificationTemplate actualToDataResult = notificationTemplateEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getConfiguration());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
