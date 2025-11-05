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
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.notification.NotificationRequest;
import org.thingsboard.server.common.data.notification.NotificationRequest.NotificationRequestBuilder;
import org.thingsboard.server.common.data.notification.NotificationRequestStats;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.common.data.notification.info.ApiUsageLimitNotificationInfo;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

class NotificationRequestEntityDiffblueTest {
  /**
   * Test {@link NotificationRequestEntity#equals(Object)}, and {@link
   * NotificationRequestEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequestEntity#equals(Object)}
   *   <li>{@link NotificationRequestEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationRequestEntity, notificationRequestEntity2);
    assertEquals(notificationRequestEntity.hashCode(), notificationRequestEntity2.hashCode());
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}, and {@link
   * NotificationRequestEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequestEntity#equals(Object)}
   *   <li>{@link NotificationRequestEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(null);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(null);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationRequestEntity, notificationRequestEntity2);
    assertEquals(notificationRequestEntity.hashCode(), notificationRequestEntity2.hashCode());
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}, and {@link
   * NotificationRequestEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequestEntity#equals(Object)}
   *   <li>{@link NotificationRequestEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(null);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(null);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationRequestEntity, notificationRequestEntity2);
    assertEquals(notificationRequestEntity.hashCode(), notificationRequestEntity2.hashCode());
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}, and {@link
   * NotificationRequestEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequestEntity#equals(Object)}
   *   <li>{@link NotificationRequestEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(null);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(null);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationRequestEntity, notificationRequestEntity2);
    assertEquals(notificationRequestEntity.hashCode(), notificationRequestEntity2.hashCode());
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}, and {@link
   * NotificationRequestEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequestEntity#equals(Object)}
   *   <li>{@link NotificationRequestEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(null);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(null);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationRequestEntity, notificationRequestEntity2);
    assertEquals(notificationRequestEntity.hashCode(), notificationRequestEntity2.hashCode());
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}, and {@link
   * NotificationRequestEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequestEntity#equals(Object)}
   *   <li>{@link NotificationRequestEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationRequestEntity, notificationRequestEntity);
    int expectedHashCodeResult = notificationRequestEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestEntity.hashCode());
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(DoubleNode.valueOf(10.0d));
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(null);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(3L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(DoubleNode.valueOf(10.0d));
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(null);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(null);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(null);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.CUSTOMER);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(null);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(DoubleNode.valueOf(10.0d));
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(null);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(null);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.SENT);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets(null);
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets(
        "org.thingsboard.server.dao.model.sql.NotificationRequestEntity");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(DoubleNode.valueOf(10.0d));
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(null);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(null);
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(null);
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, null);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRequestEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRequestEntity, "Different type to NotificationRequestEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRequestEntity#NotificationRequestEntity()}
   *   <li>{@link NotificationRequestEntity#setAdditionalConfig(JsonNode)}
   *   <li>{@link NotificationRequestEntity#setInfo(JsonNode)}
   *   <li>{@link NotificationRequestEntity#setOriginatorEntityId(UUID)}
   *   <li>{@link NotificationRequestEntity#setOriginatorEntityType(EntityType)}
   *   <li>{@link NotificationRequestEntity#setRuleId(UUID)}
   *   <li>{@link NotificationRequestEntity#setStats(JsonNode)}
   *   <li>{@link NotificationRequestEntity#setStatus(NotificationRequestStatus)}
   *   <li>{@link NotificationRequestEntity#setTargets(String)}
   *   <li>{@link NotificationRequestEntity#setTemplate(JsonNode)}
   *   <li>{@link NotificationRequestEntity#setTemplateId(UUID)}
   *   <li>{@link NotificationRequestEntity#setTenantId(UUID)}
   *   <li>{@link NotificationRequestEntity#toString()}
   *   <li>{@link NotificationRequestEntity#getAdditionalConfig()}
   *   <li>{@link NotificationRequestEntity#getInfo()}
   *   <li>{@link NotificationRequestEntity#getOriginatorEntityId()}
   *   <li>{@link NotificationRequestEntity#getOriginatorEntityType()}
   *   <li>{@link NotificationRequestEntity#getRuleId()}
   *   <li>{@link NotificationRequestEntity#getStats()}
   *   <li>{@link NotificationRequestEntity#getStatus()}
   *   <li>{@link NotificationRequestEntity#getTargets()}
   *   <li>{@link NotificationRequestEntity#getTemplate()}
   *   <li>{@link NotificationRequestEntity#getTemplateId()}
   *   <li>{@link NotificationRequestEntity#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationRequestEntity.<init>()",
    "JsonNode NotificationRequestEntity.getAdditionalConfig()",
    "JsonNode NotificationRequestEntity.getInfo()",
    "UUID NotificationRequestEntity.getOriginatorEntityId()",
    "EntityType NotificationRequestEntity.getOriginatorEntityType()",
    "UUID NotificationRequestEntity.getRuleId()",
    "JsonNode NotificationRequestEntity.getStats()",
    "NotificationRequestStatus NotificationRequestEntity.getStatus()",
    "String NotificationRequestEntity.getTargets()",
    "JsonNode NotificationRequestEntity.getTemplate()",
    "UUID NotificationRequestEntity.getTemplateId()",
    "UUID NotificationRequestEntity.getTenantId()",
    "void NotificationRequestEntity.setAdditionalConfig(JsonNode)",
    "void NotificationRequestEntity.setInfo(JsonNode)",
    "void NotificationRequestEntity.setOriginatorEntityId(UUID)",
    "void NotificationRequestEntity.setOriginatorEntityType(EntityType)",
    "void NotificationRequestEntity.setRuleId(UUID)",
    "void NotificationRequestEntity.setStats(JsonNode)",
    "void NotificationRequestEntity.setStatus(NotificationRequestStatus)",
    "void NotificationRequestEntity.setTargets(String)",
    "void NotificationRequestEntity.setTemplate(JsonNode)",
    "void NotificationRequestEntity.setTemplateId(UUID)",
    "void NotificationRequestEntity.setTenantId(UUID)",
    "String NotificationRequestEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationRequestEntity actualNotificationRequestEntity = new NotificationRequestEntity();
    actualNotificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualNotificationRequestEntity.setInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    UUID originatorEntityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationRequestEntity.setOriginatorEntityId(originatorEntityId);
    actualNotificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    UUID ruleId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationRequestEntity.setRuleId(ruleId);
    actualNotificationRequestEntity.setStats(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualNotificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    actualNotificationRequestEntity.setTargets("Targets");
    JsonNode template = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualNotificationRequestEntity.setTemplate(template);
    UUID templateId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationRequestEntity.setTemplateId(templateId);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationRequestEntity.setTenantId(tenantId);
    String actualToStringResult = actualNotificationRequestEntity.toString();
    JsonNode actualAdditionalConfig = actualNotificationRequestEntity.getAdditionalConfig();
    JsonNode actualInfo = actualNotificationRequestEntity.getInfo();
    UUID actualOriginatorEntityId = actualNotificationRequestEntity.getOriginatorEntityId();
    EntityType actualOriginatorEntityType =
        actualNotificationRequestEntity.getOriginatorEntityType();
    UUID actualRuleId = actualNotificationRequestEntity.getRuleId();
    JsonNode actualStats = actualNotificationRequestEntity.getStats();
    NotificationRequestStatus actualStatus = actualNotificationRequestEntity.getStatus();
    String actualTargets = actualNotificationRequestEntity.getTargets();
    JsonNode actualTemplate = actualNotificationRequestEntity.getTemplate();
    UUID actualTemplateId = actualNotificationRequestEntity.getTemplateId();
    UUID actualTenantId = actualNotificationRequestEntity.getTenantId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualOriginatorEntityId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualRuleId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTemplateId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals(
        "NotificationRequestEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, targets=Targets,"
            + " templateId=784f394c-42b6-435a-983c-b7beff2784f9, template={\"isPublic\":true}, info={\"isPublic\":true},"
            + " additionalConfig={\"isPublic\":true}, originatorEntityId=784f394c-42b6-435a-983c-b7beff2784f9,"
            + " originatorEntityType=TENANT, ruleId=784f394c-42b6-435a-983c-b7beff2784f9, status=PROCESSING,"
            + " stats={\"isPublic\":true})",
        actualToStringResult);
    assertEquals("Targets", actualTargets);
    assertNull(actualNotificationRequestEntity.getId());
    assertNull(actualNotificationRequestEntity.getUuid());
    assertEquals(0L, actualNotificationRequestEntity.getCreatedTime());
    assertEquals(EntityType.TENANT, actualOriginatorEntityType);
    assertEquals(NotificationRequestStatus.PROCESSING, actualStatus);
    assertSame(originatorEntityId, actualOriginatorEntityId);
    assertSame(ruleId, actualRuleId);
    assertSame(templateId, actualTemplateId);
    assertSame(tenantId, actualTenantId);
    assertSame(template, actualAdditionalConfig);
    assertSame(template, actualInfo);
    assertSame(template, actualStats);
    assertSame(template, actualTemplate);
  }

  /**
   * Test {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   *
   * <p>Method under test: {@link
   * NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  @DisplayName("Test new NotificationRequestEntity(NotificationRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  void testNewNotificationRequestEntity() {
    // Arrange
    NotificationRequest notificationRequest = new NotificationRequest(new NotificationRequest());
    notificationRequest.setOriginatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    NotificationRequestEntity actualNotificationRequestEntity =
        new NotificationRequestEntity(notificationRequest);

    // Assert
    UUID originatorEntityId = actualNotificationRequestEntity.getOriginatorEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.toString());
    assertNull(actualNotificationRequestEntity.getTemplate());
    assertEquals(EntityType.CUSTOMER, actualNotificationRequestEntity.getOriginatorEntityType());
    assertSame(originatorEntityId, actualNotificationRequestEntity.getTenantId());
  }

  /**
   * Test {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   *
   * <p>Method under test: {@link
   * NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  @DisplayName("Test new NotificationRequestEntity(NotificationRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  void testNewNotificationRequestEntity2() {
    // Arrange
    NotificationRequest notificationRequest = new NotificationRequest();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    notificationRequest.setTemplateId(new NotificationTemplateId(id));

    // Act
    NotificationRequestEntity actualNotificationRequestEntity =
        new NotificationRequestEntity(notificationRequest);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRequestEntity.getTenantId().toString());
    UUID templateId = actualNotificationRequestEntity.getTemplateId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", templateId.toString());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityId());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityType());
    assertSame(id, templateId);
  }

  /**
   * Test {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   *
   * <p>Method under test: {@link
   * NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  @DisplayName("Test new NotificationRequestEntity(NotificationRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  void testNewNotificationRequestEntity3() {
    // Arrange
    ArrayList<UUID> targets = new ArrayList<>();
    targets.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setTargets(targets);

    // Act
    NotificationRequestEntity actualNotificationRequestEntity =
        new NotificationRequestEntity(notificationRequest);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRequestEntity.getTenantId().toString());
    assertEquals(
        "784f394c-42b6-435a-983c-b7beff2784f9", actualNotificationRequestEntity.getTargets());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityId());
    assertNull(actualNotificationRequestEntity.getTemplateId());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityType());
  }

  /**
   * Test {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   *
   * <p>Method under test: {@link
   * NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  @DisplayName("Test new NotificationRequestEntity(NotificationRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  void testNewNotificationRequestEntity4() {
    // Arrange
    ArrayList<UUID> targets = new ArrayList<>();
    targets.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    targets.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setTargets(targets);

    // Act
    NotificationRequestEntity actualNotificationRequestEntity =
        new NotificationRequestEntity(notificationRequest);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRequestEntity.getTenantId().toString());
    assertEquals(
        "784f394c-42b6-435a-983c-b7beff2784f9,784f394c-42b6-435a-983c-b7beff2784f9",
        actualNotificationRequestEntity.getTargets());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityId());
    assertNull(actualNotificationRequestEntity.getTemplateId());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityType());
  }

  /**
   * Test {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   *
   * <p>Method under test: {@link
   * NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  @DisplayName("Test new NotificationRequestEntity(NotificationRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  void testNewNotificationRequestEntity5() {
    // Arrange
    NotificationRequestBuilder builderResult = NotificationRequest.builder();

    NotificationRequestBuilder originatorEntityIdResult =
        builderResult
            .info(
                ApiUsageLimitNotificationInfo.builder()
                    .currentValue("42")
                    .feature(ApiFeature.TRANSPORT)
                    .limit("Limit")
                    .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
                    .status(ApiUsageStateValue.ENABLED)
                    .tenantId(ModelConstants.SYSTEM_TENANT)
                    .tenantName("Tenant Name")
                    .build())
            .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);

    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());

    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    // Act
    NotificationRequestEntity actualNotificationRequestEntity =
        new NotificationRequestEntity(notificationRequest);

    // Assert
    JsonNode info = actualNotificationRequestEntity.getInfo();
    assertTrue(info instanceof ObjectNode);
    JsonNode stats = actualNotificationRequestEntity.getStats();
    assertTrue(stats instanceof ObjectNode);
    assertTrue(info.traverse() instanceof TreeTraversingParser);
    assertTrue(stats.traverse() instanceof TreeTraversingParser);
    assertTrue(info.iterator().hasNext());
    assertTrue(stats.iterator().hasNext());
  }

  /**
   * Test {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequestEntity)}.
   *
   * <p>Method under test: {@link
   * NotificationRequestEntity#NotificationRequestEntity(NotificationRequestEntity)}
   */
  @Test
  @DisplayName("Test new NotificationRequestEntity(NotificationRequestEntity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequestEntity)"})
  void testNewNotificationRequestEntity6() {
    // Arrange
    NotificationRequestEntity other = new NotificationRequestEntity();
    other.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setCreatedTime(1L);
    other.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    other.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setOriginatorEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    other.setOriginatorEntityType(EntityType.TENANT);
    other.setRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    other.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setStatus(NotificationRequestStatus.PROCESSING);
    other.setTargets("Targets");
    other.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    other.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    other.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    NotificationRequestEntity actualNotificationRequestEntity =
        new NotificationRequestEntity(other);

    // Assert
    assertEquals(other, actualNotificationRequestEntity);
  }

  /**
   * Test {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  @DisplayName("Test new NotificationRequestEntity(NotificationRequest); given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  void testNewNotificationRequestEntity_givenArrayList() {
    // Arrange
    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setTargets(new ArrayList<>());

    // Act
    NotificationRequestEntity actualNotificationRequestEntity =
        new NotificationRequestEntity(notificationRequest);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRequestEntity.getTenantId().toString());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityId());
    assertNull(actualNotificationRequestEntity.getTemplateId());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityType());
  }

  /**
   * Test {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  @DisplayName(
      "Test new NotificationRequestEntity(NotificationRequest); given one; then return CreatedTime is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  void testNewNotificationRequestEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setCreatedTime(1L);

    // Act
    NotificationRequestEntity actualNotificationRequestEntity =
        new NotificationRequestEntity(notificationRequest);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRequestEntity.getTenantId().toString());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityId());
    assertNull(actualNotificationRequestEntity.getTemplateId());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityType());
    assertEquals(1L, actualNotificationRequestEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  @DisplayName("Test new NotificationRequestEntity(NotificationRequest); given SYSTEM_TENANT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  void testNewNotificationRequestEntity_givenSystem_tenant() {
    // Arrange
    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    NotificationRequestEntity actualNotificationRequestEntity =
        new NotificationRequestEntity(notificationRequest);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRequestEntity.getTenantId().toString());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityId());
    assertNull(actualNotificationRequestEntity.getTemplateId());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityType());
  }

  /**
   * Test {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   *
   * <ul>
   *   <li>Then return OriginatorEntityType is {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  @DisplayName(
      "Test new NotificationRequestEntity(NotificationRequest); then return OriginatorEntityType is 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  void testNewNotificationRequestEntity_thenReturnOriginatorEntityTypeIsTenant() {
    // Arrange
    NotificationRequestBuilder builderResult = NotificationRequest.builder();

    NotificationRequestBuilder originatorEntityIdResult =
        builderResult
            .info(
                ApiUsageLimitNotificationInfo.builder()
                    .currentValue("42")
                    .feature(ApiFeature.TRANSPORT)
                    .limit("Limit")
                    .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
                    .status(ApiUsageStateValue.ENABLED)
                    .tenantId(ModelConstants.SYSTEM_TENANT)
                    .tenantName("Tenant Name")
                    .build())
            .originatorEntityId(ModelConstants.SYSTEM_TENANT);

    NotificationRequestBuilder ruleIdResult =
        originatorEntityIdResult.ruleId(
            new NotificationRuleId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);

    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());

    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest =
        templateResult
            .templateId(
                new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    // Act
    NotificationRequestEntity actualNotificationRequestEntity =
        new NotificationRequestEntity(notificationRequest);

    // Assert
    JsonNode info = actualNotificationRequestEntity.getInfo();
    assertTrue(info instanceof ObjectNode);
    JsonNode stats = actualNotificationRequestEntity.getStats();
    assertTrue(stats instanceof ObjectNode);
    assertTrue(info.traverse() instanceof TreeTraversingParser);
    assertTrue(stats.traverse() instanceof TreeTraversingParser);
    assertEquals(EntityType.TENANT, actualNotificationRequestEntity.getOriginatorEntityType());
    assertTrue(info.iterator().hasNext());
    assertTrue(stats.iterator().hasNext());
  }

  /**
   * Test {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   *
   * <ul>
   *   <li>Then Template iterator next return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  @DisplayName(
      "Test new NotificationRequestEntity(NotificationRequest); then Template iterator next return NullNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  void testNewNotificationRequestEntity_thenTemplateIteratorNextReturnNullNode() {
    // Arrange
    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setTemplate(new NotificationTemplate());

    // Act and Assert
    JsonNode template = new NotificationRequestEntity(notificationRequest).getTemplate();
    assertTrue(template instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = template.iterator();
    assertTrue(iteratorResult.hasNext());
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    assertTrue(iteratorResult.next() instanceof LongNode);
    assertSame(nextResult, iteratorResult.next());
    assertTrue(template.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   *
   * <ul>
   *   <li>When {@link NotificationRequest#NotificationRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  @DisplayName(
      "Test new NotificationRequestEntity(NotificationRequest); when NotificationRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  void testNewNotificationRequestEntity_whenNotificationRequest() {
    // Arrange and Act
    NotificationRequestEntity actualNotificationRequestEntity =
        new NotificationRequestEntity(new NotificationRequest());

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRequestEntity.getTenantId().toString());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityId());
    assertNull(actualNotificationRequestEntity.getTemplateId());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityType());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link NotificationRequestEntity#NotificationRequestEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given NotificationRequestEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  void testToData_givenNotificationRequestEntity() {
    // Arrange and Act
    NotificationRequest actualToDataResult = new NotificationRequestEntity().toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getOriginatorEntityId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link NotificationRequestEntity#NotificationRequestEntity()} Template is Instance.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given NotificationRequestEntity() Template is Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  void testToData_givenNotificationRequestEntityTemplateIsInstance() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setTemplate(MissingNode.getInstance());

    // Act
    NotificationRequest actualToDataResult = notificationRequestEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getOriginatorEntityId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link NotificationRequestEntity#NotificationRequestEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given NotificationRequestEntity() TenantId is NULL_UUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  void testToData_givenNotificationRequestEntityTenantIdIsNull_uuid() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act
    NotificationRequest actualToDataResult = notificationRequestEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getOriginatorEntityId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then OriginatorEntityId return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then OriginatorEntityId return TenantId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  void testToData_thenOriginatorEntityIdReturnTenantId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setOriginatorEntityId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    EntityId originatorEntityId = notificationRequestEntity.toData().getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof TenantId);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", originatorEntityId.getId().toString());
    assertEquals(EntityType.TENANT, originatorEntityId.getEntityType());
    assertFalse(originatorEntityId.isNullUid());
    assertFalse(((TenantId) originatorEntityId).isSysTenantId());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then OriginatorEntityId return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then OriginatorEntityId return UserId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  void testToData_thenOriginatorEntityIdReturnUserId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.USER);
    UUID originatorEntityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    notificationRequestEntity.setOriginatorEntityId(originatorEntityId);

    // Act
    NotificationRequest actualToDataResult = notificationRequestEntity.toData();

    // Assert
    EntityId originatorEntityId2 = actualToDataResult.getOriginatorEntityId();
    assertTrue(originatorEntityId2 instanceof UserId);
    assertEquals(EntityType.USER, originatorEntityId2.getEntityType());
    assertSame(originatorEntityId, originatorEntityId2.getId());
    assertSame(originatorEntityId2, actualToDataResult.getSenderId());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TemplateId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TemplateId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  void testToData_thenReturnTemplateIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    UUID templateId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    notificationRequestEntity.setTemplateId(templateId);

    // Act and Assert
    NotificationTemplateId templateId2 = notificationRequestEntity.toData().getTemplateId();
    UUID id = templateId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, templateId2.getEntityType());
    assertFalse(templateId2.isNullUid());
    assertSame(templateId, id);
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TenantId Id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    UUID tenantId = UUID.randomUUID();
    notificationRequestEntity.setTenantId(tenantId);

    // Act
    NotificationRequest actualToDataResult = notificationRequestEntity.toData();

    // Assert
    assertNull(actualToDataResult.getOriginatorEntityId());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    NotificationRequest actualToDataResult = notificationRequestEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertNull(actualToDataResult.getOriginatorEntityId());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
