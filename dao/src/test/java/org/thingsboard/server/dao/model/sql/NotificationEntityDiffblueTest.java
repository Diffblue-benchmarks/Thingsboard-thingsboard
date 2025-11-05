package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.Iterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.notification.Notification;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationStatus;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.info.ApiUsageLimitNotificationInfo;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

class NotificationEntityDiffblueTest {
  /**
   * Test {@link NotificationEntity#equals(Object)}, and {@link NotificationEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationEntity#equals(Object)}
   *   <li>{@link NotificationEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationEntity, notificationEntity2);
    assertEquals(notificationEntity.hashCode(), notificationEntity2.hashCode());
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}, and {@link NotificationEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationEntity#equals(Object)}
   *   <li>{@link NotificationEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(null);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(null);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationEntity, notificationEntity2);
    assertEquals(notificationEntity.hashCode(), notificationEntity2.hashCode());
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}, and {@link NotificationEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationEntity#equals(Object)}
   *   <li>{@link NotificationEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(null);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(null);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationEntity, notificationEntity2);
    assertEquals(notificationEntity.hashCode(), notificationEntity2.hashCode());
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}, and {@link NotificationEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationEntity#equals(Object)}
   *   <li>{@link NotificationEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(null);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(null);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationEntity, notificationEntity2);
    assertEquals(notificationEntity.hashCode(), notificationEntity2.hashCode());
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}, and {@link NotificationEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationEntity#equals(Object)}
   *   <li>{@link NotificationEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(null);
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(null);
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationEntity, notificationEntity2);
    assertEquals(notificationEntity.hashCode(), notificationEntity2.hashCode());
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}, and {@link NotificationEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationEntity#equals(Object)}
   *   <li>{@link NotificationEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(null);
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(null);
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationEntity, notificationEntity2);
    assertEquals(notificationEntity.hashCode(), notificationEntity2.hashCode());
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}, and {@link NotificationEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationEntity#equals(Object)}
   *   <li>{@link NotificationEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationEntity, notificationEntity);
    int expectedHashCodeResult = notificationEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationEntity.hashCode());
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(DoubleNode.valueOf(10.0d));
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(null);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(3L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(null);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.EMAIL);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(DoubleNode.valueOf(10.0d));
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(null);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(ModelConstants.NULL_UUID);
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(null);
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(null);
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(null);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.READ);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Text");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject(null);
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Hello from the Dreaming Spires");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText(null);
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(null);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.ALARM);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, notificationEntity2);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, null);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationEntity.equals(Object)",
    "int NotificationEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationEntity, "Different type to NotificationEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationEntity#NotificationEntity()}
   *   <li>{@link NotificationEntity#setAdditionalConfig(JsonNode)}
   *   <li>{@link NotificationEntity#setDeliveryMethod(NotificationDeliveryMethod)}
   *   <li>{@link NotificationEntity#setInfo(JsonNode)}
   *   <li>{@link NotificationEntity#setRecipientId(UUID)}
   *   <li>{@link NotificationEntity#setRequestId(UUID)}
   *   <li>{@link NotificationEntity#setStatus(NotificationStatus)}
   *   <li>{@link NotificationEntity#setSubject(String)}
   *   <li>{@link NotificationEntity#setText(String)}
   *   <li>{@link NotificationEntity#setType(NotificationType)}
   *   <li>{@link NotificationEntity#toString()}
   *   <li>{@link NotificationEntity#getAdditionalConfig()}
   *   <li>{@link NotificationEntity#getDeliveryMethod()}
   *   <li>{@link NotificationEntity#getInfo()}
   *   <li>{@link NotificationEntity#getRecipientId()}
   *   <li>{@link NotificationEntity#getRequestId()}
   *   <li>{@link NotificationEntity#getStatus()}
   *   <li>{@link NotificationEntity#getSubject()}
   *   <li>{@link NotificationEntity#getText()}
   *   <li>{@link NotificationEntity#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationEntity.<init>()",
    "JsonNode NotificationEntity.getAdditionalConfig()",
    "NotificationDeliveryMethod NotificationEntity.getDeliveryMethod()",
    "JsonNode NotificationEntity.getInfo()",
    "UUID NotificationEntity.getRecipientId()",
    "UUID NotificationEntity.getRequestId()",
    "NotificationStatus NotificationEntity.getStatus()",
    "String NotificationEntity.getSubject()",
    "String NotificationEntity.getText()",
    "NotificationType NotificationEntity.getType()",
    "void NotificationEntity.setAdditionalConfig(JsonNode)",
    "void NotificationEntity.setDeliveryMethod(NotificationDeliveryMethod)",
    "void NotificationEntity.setInfo(JsonNode)",
    "void NotificationEntity.setRecipientId(UUID)",
    "void NotificationEntity.setRequestId(UUID)",
    "void NotificationEntity.setStatus(NotificationStatus)",
    "void NotificationEntity.setSubject(String)",
    "void NotificationEntity.setText(String)",
    "void NotificationEntity.setType(NotificationType)",
    "String NotificationEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationEntity actualNotificationEntity = new NotificationEntity();
    actualNotificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualNotificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    JsonNode info = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualNotificationEntity.setInfo(info);
    UUID recipientId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationEntity.setRecipientId(recipientId);
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationEntity.setRequestId(requestId);
    actualNotificationEntity.setStatus(NotificationStatus.SENT);
    actualNotificationEntity.setSubject("Hello from the Dreaming Spires");
    actualNotificationEntity.setText("Text");
    actualNotificationEntity.setType(NotificationType.GENERAL);
    String actualToStringResult = actualNotificationEntity.toString();
    JsonNode actualAdditionalConfig = actualNotificationEntity.getAdditionalConfig();
    NotificationDeliveryMethod actualDeliveryMethod = actualNotificationEntity.getDeliveryMethod();
    JsonNode actualInfo = actualNotificationEntity.getInfo();
    UUID actualRecipientId = actualNotificationEntity.getRecipientId();
    UUID actualRequestId = actualNotificationEntity.getRequestId();
    NotificationStatus actualStatus = actualNotificationEntity.getStatus();
    String actualSubject = actualNotificationEntity.getSubject();
    String actualText = actualNotificationEntity.getText();
    NotificationType actualType = actualNotificationEntity.getType();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualRecipientId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualRequestId.toString());
    assertEquals("Hello from the Dreaming Spires", actualSubject);
    assertEquals(
        "NotificationEntity(requestId=784f394c-42b6-435a-983c-b7beff2784f9, recipientId=784f394c-42b6-435a-983c"
            + "-b7beff2784f9, type=GENERAL, deliveryMethod=WEB, subject=Hello from the Dreaming Spires, text=Text,"
            + " additionalConfig={\"isPublic\":true}, info={\"isPublic\":true}, status=SENT)",
        actualToStringResult);
    assertEquals("Text", actualText);
    assertNull(actualNotificationEntity.getId());
    assertNull(actualNotificationEntity.getUuid());
    assertEquals(0L, actualNotificationEntity.getCreatedTime());
    assertEquals(NotificationDeliveryMethod.WEB, actualDeliveryMethod);
    assertEquals(NotificationStatus.SENT, actualStatus);
    assertEquals(NotificationType.GENERAL, actualType);
    assertSame(recipientId, actualRecipientId);
    assertSame(requestId, actualRequestId);
    assertSame(info, actualAdditionalConfig);
    assertSame(info, actualInfo);
  }

  /**
   * Test {@link NotificationEntity#NotificationEntity(Notification)}.
   *
   * <p>Method under test: {@link NotificationEntity#NotificationEntity(Notification)}
   */
  @Test
  @DisplayName("Test new NotificationEntity(Notification)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationEntity.<init>(Notification)"})
  void testNewNotificationEntity() {
    // Arrange
    Notification notification = new Notification();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    notification.setRequestId(new NotificationRequestId(id));

    // Act
    NotificationEntity actualNotificationEntity = new NotificationEntity(notification);

    // Assert
    UUID requestId = actualNotificationEntity.getRequestId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", requestId.toString());
    assertNull(actualNotificationEntity.getInfo());
    assertEquals(0L, actualNotificationEntity.getCreatedTime());
    assertSame(id, requestId);
  }

  /**
   * Test {@link NotificationEntity#NotificationEntity(Notification)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#NotificationEntity(Notification)}
   */
  @Test
  @DisplayName(
      "Test new NotificationEntity(Notification); given one; then return CreatedTime is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationEntity.<init>(Notification)"})
  void testNewNotificationEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    Notification notification = new Notification();
    notification.setCreatedTime(1L);

    // Act
    NotificationEntity actualNotificationEntity = new NotificationEntity(notification);

    // Assert
    assertNull(actualNotificationEntity.getAdditionalConfig());
    assertNull(actualNotificationEntity.getSubject());
    assertNull(actualNotificationEntity.getText());
    assertNull(actualNotificationEntity.getId());
    assertNull(actualNotificationEntity.getUuid());
    assertNull(actualNotificationEntity.getRecipientId());
    assertNull(actualNotificationEntity.getRequestId());
    assertNull(actualNotificationEntity.getDeliveryMethod());
    assertNull(actualNotificationEntity.getStatus());
    assertNull(actualNotificationEntity.getType());
    assertEquals(1L, actualNotificationEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationEntity#NotificationEntity(Notification)}.
   *
   * <ul>
   *   <li>Then Info iterator next return {@link TextNode}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#NotificationEntity(Notification)}
   */
  @Test
  @DisplayName("Test new NotificationEntity(Notification); then Info iterator next return TextNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationEntity.<init>(Notification)"})
  void testNewNotificationEntity_thenInfoIteratorNextReturnTextNode() {
    // Arrange
    Notification notification = new Notification();
    notification.setInfo(
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .tenantName("Tenant Name")
            .build());

    // Act and Assert
    JsonNode info = new NotificationEntity(notification).getInfo();
    assertTrue(info instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = info.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertEquals(13, info.size());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link NotificationEntity#NotificationEntity(Notification)}.
   *
   * <ul>
   *   <li>When {@link Notification#Notification()}.
   *   <li>Then return AdditionalConfig is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#NotificationEntity(Notification)}
   */
  @Test
  @DisplayName(
      "Test new NotificationEntity(Notification); when Notification(); then return AdditionalConfig is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationEntity.<init>(Notification)"})
  void testNewNotificationEntity_whenNotification_thenReturnAdditionalConfigIsNull() {
    // Arrange and Act
    NotificationEntity actualNotificationEntity = new NotificationEntity(new Notification());

    // Assert
    assertNull(actualNotificationEntity.getAdditionalConfig());
    assertNull(actualNotificationEntity.getSubject());
    assertNull(actualNotificationEntity.getText());
    assertNull(actualNotificationEntity.getId());
    assertNull(actualNotificationEntity.getUuid());
    assertNull(actualNotificationEntity.getRecipientId());
    assertNull(actualNotificationEntity.getRequestId());
    assertNull(actualNotificationEntity.getDeliveryMethod());
    assertNull(actualNotificationEntity.getStatus());
    assertNull(actualNotificationEntity.getType());
    assertEquals(0L, actualNotificationEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link NotificationEntity#NotificationEntity()}.
   *   <li>Then return RequestId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given NotificationEntity(); then return RequestId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Notification NotificationEntity.toData()"})
  void testToData_givenNotificationEntity_thenReturnRequestIdIsNull() {
    // Arrange and Act
    Notification actualToDataResult = new NotificationEntity().toData();

    // Assert
    assertNull(actualToDataResult.getAdditionalConfig());
    assertNull(actualToDataResult.getSubject());
    assertNull(actualToDataResult.getText());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getRequestId());
    assertNull(actualToDataResult.getRecipientId());
    assertNull(actualToDataResult.getDeliveryMethod());
    assertNull(actualToDataResult.getStatus());
    assertNull(actualToDataResult.getType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link NotificationEntity#toData()}.
   *
   * <ul>
   *   <li>Then AdditionalConfig return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then AdditionalConfig return ObjectNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Notification NotificationEntity.toData()"})
  void testToData_thenAdditionalConfigReturnObjectNode() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setInfo(MissingNode.getInstance());
    notificationEntity.setRecipientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    notificationEntity.setUuid(id);

    // Act
    Notification actualToDataResult = notificationEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalConfig() instanceof ObjectNode);
    assertEquals("Hello from the Dreaming Spires", actualToDataResult.getSubject());
    assertEquals("Text", actualToDataResult.getText());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(NotificationDeliveryMethod.WEB, actualToDataResult.getDeliveryMethod());
    assertEquals(NotificationStatus.SENT, actualToDataResult.getStatus());
    assertEquals(NotificationType.GENERAL, actualToDataResult.getType());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link NotificationEntity#toData()}.
   *
   * <ul>
   *   <li>Then return RequestId EntityType is {@code NOTIFICATION_REQUEST}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return RequestId EntityType is 'NOTIFICATION_REQUEST'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Notification NotificationEntity.toData()"})
  void testToData_thenReturnRequestIdEntityTypeIsNotificationRequest() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    notificationEntity.setRequestId(requestId);

    // Act
    Notification actualToDataResult = notificationEntity.toData();

    // Assert
    assertNull(actualToDataResult.getAdditionalConfig());
    assertNull(actualToDataResult.getSubject());
    assertNull(actualToDataResult.getText());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getRecipientId());
    assertNull(actualToDataResult.getDeliveryMethod());
    assertNull(actualToDataResult.getStatus());
    assertNull(actualToDataResult.getType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    NotificationRequestId requestId2 = actualToDataResult.getRequestId();
    assertEquals(EntityType.NOTIFICATION_REQUEST, requestId2.getEntityType());
    assertFalse(requestId2.isNullUid());
    assertSame(requestId, requestId2.getId());
  }
}
