/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.notification.NotificationRequest;
import org.thingsboard.server.common.data.notification.NotificationRequest.NotificationRequestBuilder;
import org.thingsboard.server.common.data.notification.NotificationRequestStats;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.common.data.notification.info.ApiUsageLimitNotificationInfo;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class NotificationRequestEntityDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(null);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(null);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(null);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(null);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(null);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(null);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(null);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(null);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(DoubleNode.valueOf(10.0d));
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(null);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(3L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(DoubleNode.valueOf(10.0d));
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(null);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(UUID.randomUUID());
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(null);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(null);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.CUSTOMER);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.randomUUID());
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(null);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(DoubleNode.valueOf(10.0d));
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(null);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(null);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.SENT);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets(null);
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets(
        "org.thingsboard.server.dao.model.sql.NotificationRequestEntity");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(DoubleNode.valueOf(10.0d));
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(null);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(UUID.randomUUID());
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(null);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(UUID.randomUUID());
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(null);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRequestEntity.equals(Object)",
    "int NotificationRequestEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
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
  public void testGettersAndSetters() {
    // Arrange and Act
    NotificationRequestEntity actualNotificationRequestEntity = new NotificationRequestEntity();
    actualNotificationRequestEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualNotificationRequestEntity.setInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualNotificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    actualNotificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    actualNotificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    actualNotificationRequestEntity.setStats(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualNotificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    actualNotificationRequestEntity.setTargets("Targets");
    JsonNode template = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualNotificationRequestEntity.setTemplate(template);
    actualNotificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    UUID tenantId = ModelConstants.NULL_UUID;
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
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualOriginatorEntityId.toString());
    assertEquals(
        "NotificationRequestEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, targets=Targets,"
            + " templateId=13814000-1dd2-11b2-8080-808080808080, template={\"isPublic\":true}, info={\"isPublic\":true},"
            + " additionalConfig={\"isPublic\":true}, originatorEntityId=13814000-1dd2-11b2-8080-808080808080,"
            + " originatorEntityType=TENANT, ruleId=13814000-1dd2-11b2-8080-808080808080, status=PROCESSING,"
            + " stats={\"isPublic\":true})",
        actualToStringResult);
    assertEquals("Targets", actualTargets);
    assertNull(actualNotificationRequestEntity.getId());
    assertNull(actualNotificationRequestEntity.getUuid());
    assertEquals(0L, actualNotificationRequestEntity.getCreatedTime());
    assertEquals(EntityType.TENANT, actualOriginatorEntityType);
    assertEquals(NotificationRequestStatus.PROCESSING, actualStatus);
    assertSame(template, actualAdditionalConfig);
    assertSame(template, actualInfo);
    assertSame(template, actualStats);
    assertSame(template, actualTemplate);
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, actualRuleId);
    assertSame(tenantId, actualTemplateId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   *
   * <p>Method under test: {@link
   * NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  public void testNewNotificationRequestEntity() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  public void testNewNotificationRequestEntity2() {
    // Arrange
    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setTemplateId(new NotificationTemplateId(ModelConstants.NULL_UUID));

    // Act
    NotificationRequestEntity actualNotificationRequestEntity =
        new NotificationRequestEntity(notificationRequest);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRequestEntity.getTemplateId().toString());
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRequestEntity.getTenantId().toString());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityId());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityType());
  }

  /**
   * Test {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   *
   * <p>Method under test: {@link
   * NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  public void testNewNotificationRequestEntity3() {
    // Arrange
    ArrayList<UUID> targets = new ArrayList<>();
    targets.add(ModelConstants.NULL_UUID);

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
        "13814000-1dd2-11b2-8080-808080808080", actualNotificationRequestEntity.getTargets());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  public void testNewNotificationRequestEntity4() {
    // Arrange
    ArrayList<UUID> targets = new ArrayList<>();
    targets.add(ModelConstants.NULL_UUID);
    targets.add(ModelConstants.NULL_UUID);

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
        "13814000-1dd2-11b2-8080-808080808080,13814000-1dd2-11b2-8080-808080808080",
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  public void testNewNotificationRequestEntity5() {
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
        originatorEntityIdResult.ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));

    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);

    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());

    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest =
        templateResult
            .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequestEntity)"})
  public void testNewNotificationRequestEntity6() {
    // Arrange
    NotificationRequestEntity other = new NotificationRequestEntity();
    other.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setCreatedTime(1L);
    other.setId(ModelConstants.NULL_UUID);
    other.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setOriginatorEntityId(ModelConstants.NULL_UUID);
    other.setOriginatorEntityType(EntityType.TENANT);
    other.setRuleId(ModelConstants.NULL_UUID);
    other.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setStatus(NotificationRequestStatus.PROCESSING);
    other.setTargets("Targets");
    other.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setTemplateId(ModelConstants.NULL_UUID);
    other.setTenantId(ModelConstants.NULL_UUID);
    other.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  public void testNewNotificationRequestEntity_givenArrayList() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  public void testNewNotificationRequestEntity_givenOne_thenReturnCreatedTimeIsOne() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  public void testNewNotificationRequestEntity_givenSystem_tenant() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  public void testNewNotificationRequestEntity_thenReturnOriginatorEntityTypeIsTenant() {
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
        originatorEntityIdResult.ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));

    NotificationRequestBuilder statusResult =
        ruleIdResult
            .stats(new NotificationRequestStats())
            .status(NotificationRequestStatus.PROCESSING);

    NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());

    NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest =
        templateResult
            .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  public void testNewNotificationRequestEntity_thenTemplateIteratorNextReturnNullNode() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRequestEntity.<init>(NotificationRequest)"})
  public void testNewNotificationRequestEntity_whenNotificationRequest() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_givenNotificationRequestEntity() {
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
   *   <li>Given {@link NotificationRequestEntity#NotificationRequestEntity()} Targets is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_givenNotificationRequestEntityTargetsIsEmptyString() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setTargets("");

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
   *   <li>Given {@link NotificationRequestEntity#NotificationRequestEntity()} Template is Instance.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_givenNotificationRequestEntityTemplateIsInstance() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_givenNotificationRequestEntityTenantIdIsNull_uuid() {
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
   *   <li>Then OriginatorEntityId return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenOriginatorEntityIdReturnAlarmId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.ALARM);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId originatorEntityId = notificationRequestEntity.toData().getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof AlarmId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.getId().toString());
    assertEquals(EntityType.ALARM, originatorEntityId.getEntityType());
    assertTrue(originatorEntityId.isNullUid());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then OriginatorEntityId return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenOriginatorEntityIdReturnAssetId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.ASSET);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId originatorEntityId = notificationRequestEntity.toData().getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof AssetId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.getId().toString());
    assertEquals(EntityType.ASSET, originatorEntityId.getEntityType());
    assertTrue(originatorEntityId.isNullUid());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then OriginatorEntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenOriginatorEntityIdReturnCustomerId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.CUSTOMER);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId originatorEntityId = notificationRequestEntity.toData().getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof CustomerId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.getId().toString());
    assertEquals(EntityType.CUSTOMER, originatorEntityId.getEntityType());
    assertTrue(originatorEntityId.isNullUid());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then OriginatorEntityId return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenOriginatorEntityIdReturnDashboardId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.DASHBOARD);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId originatorEntityId = notificationRequestEntity.toData().getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof DashboardId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.getId().toString());
    assertEquals(EntityType.DASHBOARD, originatorEntityId.getEntityType());
    assertTrue(originatorEntityId.isNullUid());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then OriginatorEntityId return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenOriginatorEntityIdReturnDeviceId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.DEVICE);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId originatorEntityId = notificationRequestEntity.toData().getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof DeviceId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.getId().toString());
    assertEquals(EntityType.DEVICE, originatorEntityId.getEntityType());
    assertTrue(originatorEntityId.isNullUid());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then OriginatorEntityId return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenOriginatorEntityIdReturnDeviceProfileId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.DEVICE_PROFILE);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId originatorEntityId = notificationRequestEntity.toData().getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof DeviceProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.getId().toString());
    assertEquals(EntityType.DEVICE_PROFILE, originatorEntityId.getEntityType());
    assertTrue(originatorEntityId.isNullUid());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then OriginatorEntityId return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenOriginatorEntityIdReturnEntityViewId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.ENTITY_VIEW);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId originatorEntityId = notificationRequestEntity.toData().getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof EntityViewId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.getId().toString());
    assertEquals(EntityType.ENTITY_VIEW, originatorEntityId.getEntityType());
    assertTrue(originatorEntityId.isNullUid());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then OriginatorEntityId return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenOriginatorEntityIdReturnRuleChainId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.RULE_CHAIN);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId originatorEntityId = notificationRequestEntity.toData().getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof RuleChainId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, originatorEntityId.getEntityType());
    assertTrue(originatorEntityId.isNullUid());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then OriginatorEntityId return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenOriginatorEntityIdReturnRuleNodeId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.RULE_NODE);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId originatorEntityId = notificationRequestEntity.toData().getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof RuleNodeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.getId().toString());
    assertEquals(EntityType.RULE_NODE, originatorEntityId.getEntityType());
    assertTrue(originatorEntityId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenOriginatorEntityIdReturnTenantId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);

    // Act
    NotificationRequest actualToDataResult = notificationRequestEntity.toData();

    // Assert
    EntityId originatorEntityId = actualToDataResult.getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof TenantId);
    assertEquals(EntityType.TENANT, originatorEntityId.getEntityType());
    assertTrue(((TenantId) originatorEntityId).isSysTenantId());
    assertSame(originatorEntityId, actualToDataResult.getTenantId());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then OriginatorEntityId return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenOriginatorEntityIdReturnTenantProfileId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT_PROFILE);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId originatorEntityId = notificationRequestEntity.toData().getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof TenantProfileId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.getId().toString());
    assertEquals(EntityType.TENANT_PROFILE, originatorEntityId.getEntityType());
    assertTrue(originatorEntityId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenOriginatorEntityIdReturnUserId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.USER);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);

    // Act
    NotificationRequest actualToDataResult = notificationRequestEntity.toData();

    // Assert
    EntityId originatorEntityId = actualToDataResult.getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof UserId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.getId().toString());
    assertEquals(EntityType.USER, originatorEntityId.getEntityType());
    assertTrue(originatorEntityId.isNullUid());
    assertSame(originatorEntityId, actualToDataResult.getSenderId());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then OriginatorEntityId return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenOriginatorEntityIdReturnWidgetTypeId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.WIDGET_TYPE);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId originatorEntityId = notificationRequestEntity.toData().getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof WidgetTypeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.getId().toString());
    assertEquals(EntityType.WIDGET_TYPE, originatorEntityId.getEntityType());
    assertTrue(originatorEntityId.isNullUid());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then OriginatorEntityId return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenOriginatorEntityIdReturnWidgetsBundleId() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setOriginatorEntityType(EntityType.WIDGETS_BUNDLE);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);

    // Act and Assert
    EntityId originatorEntityId = notificationRequestEntity.toData().getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof WidgetsBundleId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.getId().toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, originatorEntityId.getEntityType());
    assertTrue(originatorEntityId.isNullUid());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TemplateId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenReturnTemplateIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);

    // Act
    NotificationRequest actualToDataResult = notificationRequestEntity.toData();

    // Assert
    NotificationTemplateId templateId = actualToDataResult.getTemplateId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateId.getId().toString());
    assertNull(actualToDataResult.getOriginatorEntityId());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, templateId.getEntityType());
    assertTrue(templateId.isNullUid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenReturnTenantIdIdIsRandomUUID() {
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
   *   <li>Then return TenantId Id toString is {@code 00000000-0000-0001-0000-000000000001}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequest NotificationRequestEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs00000000000000010000000000000001() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setTenantId(new UUID(1L, 1L));

    // Act
    NotificationRequest actualToDataResult = notificationRequestEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("00000000-0000-0001-0000-000000000001", tenantId.getId().toString());
    assertNull(actualToDataResult.getOriginatorEntityId());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
