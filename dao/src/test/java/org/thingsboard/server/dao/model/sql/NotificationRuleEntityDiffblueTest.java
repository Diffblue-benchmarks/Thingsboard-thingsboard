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
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.DefaultNotificationRuleRecipientsConfig;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class NotificationRuleEntityDiffblueTest {
  /**
   * Test {@link NotificationRuleEntity#equals(Object)}, and {@link
   * NotificationRuleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRuleEntity#equals(Object)}
   *   <li>{@link NotificationRuleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationRuleEntity, notificationRuleEntity2);
    assertEquals(notificationRuleEntity.hashCode(), notificationRuleEntity2.hashCode());
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}, and {@link
   * NotificationRuleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRuleEntity#equals(Object)}
   *   <li>{@link NotificationRuleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(null);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(null);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationRuleEntity, notificationRuleEntity2);
    assertEquals(notificationRuleEntity.hashCode(), notificationRuleEntity2.hashCode());
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}, and {@link
   * NotificationRuleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRuleEntity#equals(Object)}
   *   <li>{@link NotificationRuleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(null);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(null);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationRuleEntity, notificationRuleEntity2);
    assertEquals(notificationRuleEntity.hashCode(), notificationRuleEntity2.hashCode());
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}, and {@link
   * NotificationRuleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRuleEntity#equals(Object)}
   *   <li>{@link NotificationRuleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName(null);
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName(null);
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationRuleEntity, notificationRuleEntity2);
    assertEquals(notificationRuleEntity.hashCode(), notificationRuleEntity2.hashCode());
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}, and {@link
   * NotificationRuleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRuleEntity#equals(Object)}
   *   <li>{@link NotificationRuleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(null);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(null);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationRuleEntity, notificationRuleEntity2);
    assertEquals(notificationRuleEntity.hashCode(), notificationRuleEntity2.hashCode());
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}, and {@link
   * NotificationRuleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRuleEntity#equals(Object)}
   *   <li>{@link NotificationRuleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationRuleEntity, notificationRuleEntity);
    int expectedHashCodeResult = notificationRuleEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationRuleEntity.hashCode());
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(DoubleNode.valueOf(10.0d));
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(null);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(3L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(false);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.randomUUID());
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(null);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName(null);
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("org.thingsboard.server.dao.model.sql.NotificationRuleEntity");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(DoubleNode.valueOf(10.0d));
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(null);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.randomUUID());
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(null);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(UUID.randomUUID());
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(null);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(DoubleNode.valueOf(10.0d));
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(null);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(null);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ALARM);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, null);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, "Different type to NotificationRuleEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRuleEntity#NotificationRuleEntity()}
   *   <li>{@link NotificationRuleEntity#setAdditionalConfig(JsonNode)}
   *   <li>{@link NotificationRuleEntity#setEnabled(boolean)}
   *   <li>{@link NotificationRuleEntity#setExternalId(UUID)}
   *   <li>{@link NotificationRuleEntity#setName(String)}
   *   <li>{@link NotificationRuleEntity#setRecipientsConfig(JsonNode)}
   *   <li>{@link NotificationRuleEntity#setTemplateId(UUID)}
   *   <li>{@link NotificationRuleEntity#setTenantId(UUID)}
   *   <li>{@link NotificationRuleEntity#setTriggerConfig(JsonNode)}
   *   <li>{@link NotificationRuleEntity#setTriggerType(NotificationRuleTriggerType)}
   *   <li>{@link NotificationRuleEntity#toString()}
   *   <li>{@link NotificationRuleEntity#getAdditionalConfig()}
   *   <li>{@link NotificationRuleEntity#getExternalId()}
   *   <li>{@link NotificationRuleEntity#getName()}
   *   <li>{@link NotificationRuleEntity#getRecipientsConfig()}
   *   <li>{@link NotificationRuleEntity#getTemplateId()}
   *   <li>{@link NotificationRuleEntity#getTenantId()}
   *   <li>{@link NotificationRuleEntity#getTriggerConfig()}
   *   <li>{@link NotificationRuleEntity#getTriggerType()}
   *   <li>{@link NotificationRuleEntity#isEnabled()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationRuleEntity.<init>()",
    "JsonNode NotificationRuleEntity.getAdditionalConfig()",
    "UUID NotificationRuleEntity.getExternalId()",
    "String NotificationRuleEntity.getName()",
    "JsonNode NotificationRuleEntity.getRecipientsConfig()",
    "UUID NotificationRuleEntity.getTemplateId()",
    "UUID NotificationRuleEntity.getTenantId()",
    "JsonNode NotificationRuleEntity.getTriggerConfig()",
    "NotificationRuleTriggerType NotificationRuleEntity.getTriggerType()",
    "boolean NotificationRuleEntity.isEnabled()",
    "void NotificationRuleEntity.setAdditionalConfig(JsonNode)",
    "void NotificationRuleEntity.setEnabled(boolean)",
    "void NotificationRuleEntity.setExternalId(UUID)",
    "void NotificationRuleEntity.setName(String)",
    "void NotificationRuleEntity.setRecipientsConfig(JsonNode)",
    "void NotificationRuleEntity.setTemplateId(UUID)",
    "void NotificationRuleEntity.setTenantId(UUID)",
    "void NotificationRuleEntity.setTriggerConfig(JsonNode)",
    "void NotificationRuleEntity.setTriggerType(NotificationRuleTriggerType)",
    "String NotificationRuleEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    NotificationRuleEntity actualNotificationRuleEntity = new NotificationRuleEntity();
    actualNotificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualNotificationRuleEntity.setEnabled(true);
    actualNotificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    actualNotificationRuleEntity.setName("Name");
    actualNotificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualNotificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    UUID tenantId = ModelConstants.NULL_UUID;
    actualNotificationRuleEntity.setTenantId(tenantId);
    JsonNode triggerConfig = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualNotificationRuleEntity.setTriggerConfig(triggerConfig);
    actualNotificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    String actualToStringResult = actualNotificationRuleEntity.toString();
    JsonNode actualAdditionalConfig = actualNotificationRuleEntity.getAdditionalConfig();
    UUID actualExternalId = actualNotificationRuleEntity.getExternalId();
    String actualName = actualNotificationRuleEntity.getName();
    JsonNode actualRecipientsConfig = actualNotificationRuleEntity.getRecipientsConfig();
    UUID actualTemplateId = actualNotificationRuleEntity.getTemplateId();
    UUID actualTenantId = actualNotificationRuleEntity.getTenantId();
    JsonNode actualTriggerConfig = actualNotificationRuleEntity.getTriggerConfig();
    NotificationRuleTriggerType actualTriggerType = actualNotificationRuleEntity.getTriggerType();
    boolean actualIsEnabledResult = actualNotificationRuleEntity.isEnabled();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Name", actualName);
    assertEquals(
        "NotificationRuleEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, enabled=true,"
            + " templateId=13814000-1dd2-11b2-8080-808080808080, triggerType=ENTITY_ACTION, triggerConfig={\"isPublic\":true},"
            + " recipientsConfig={\"isPublic\":true}, additionalConfig={\"isPublic\":true}, externalId=13814000-1dd2-11b2"
            + "-8080-808080808080)",
        actualToStringResult);
    assertNull(actualNotificationRuleEntity.getId());
    assertNull(actualNotificationRuleEntity.getUuid());
    assertEquals(0L, actualNotificationRuleEntity.getCreatedTime());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualTriggerType);
    assertTrue(actualIsEnabledResult);
    assertSame(triggerConfig, actualAdditionalConfig);
    assertSame(triggerConfig, actualRecipientsConfig);
    assertSame(triggerConfig, actualTriggerConfig);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualTemplateId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}.
   *
   * <p>Method under test: {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRuleEntity.<init>(NotificationRule)"})
  public void testNewNotificationRuleEntity() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTemplateId(new NotificationTemplateId(ModelConstants.NULL_UUID));

    // Act
    NotificationRuleEntity actualNotificationRuleEntity =
        new NotificationRuleEntity(notificationRule);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRuleEntity.getTemplateId().toString());
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRuleEntity.getTenantId().toString());
    assertNull(actualNotificationRuleEntity.getAdditionalConfig());
    assertNull(actualNotificationRuleEntity.getRecipientsConfig());
    assertNull(actualNotificationRuleEntity.getTriggerConfig());
    assertNull(actualNotificationRuleEntity.getName());
    assertNull(actualNotificationRuleEntity.getId());
    assertNull(actualNotificationRuleEntity.getUuid());
    assertNull(actualNotificationRuleEntity.getExternalId());
    assertNull(actualNotificationRuleEntity.getTriggerType());
    assertEquals(0L, actualNotificationRuleEntity.getCreatedTime());
    assertFalse(actualNotificationRuleEntity.isEnabled());
  }

  /**
   * Test {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRuleEntity)}.
   *
   * <p>Method under test: {@link
   * NotificationRuleEntity#NotificationRuleEntity(NotificationRuleEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRuleEntity.<init>(NotificationRuleEntity)"})
  public void testNewNotificationRuleEntity2() {
    // Arrange
    NotificationRuleEntity other = new NotificationRuleEntity();
    other.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setCreatedTime(1L);
    other.setEnabled(true);
    other.setExternalId(ModelConstants.NULL_UUID);
    other.setId(ModelConstants.NULL_UUID);
    other.setName("Name");
    other.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setTemplateId(ModelConstants.NULL_UUID);
    other.setTenantId(ModelConstants.NULL_UUID);
    other.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    other.setUuid(ModelConstants.NULL_UUID);

    // Act
    NotificationRuleEntity actualNotificationRuleEntity = new NotificationRuleEntity(other);

    // Assert
    assertEquals(other, actualNotificationRuleEntity);
  }

  /**
   * Test {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRuleEntity.<init>(NotificationRule)"})
  public void testNewNotificationRuleEntity_givenSystem_tenant() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    NotificationRuleEntity actualNotificationRuleEntity =
        new NotificationRuleEntity(notificationRule);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRuleEntity.getTenantId().toString());
    assertNull(actualNotificationRuleEntity.getAdditionalConfig());
    assertNull(actualNotificationRuleEntity.getRecipientsConfig());
    assertNull(actualNotificationRuleEntity.getTriggerConfig());
    assertNull(actualNotificationRuleEntity.getName());
    assertNull(actualNotificationRuleEntity.getId());
    assertNull(actualNotificationRuleEntity.getUuid());
    assertNull(actualNotificationRuleEntity.getExternalId());
    assertNull(actualNotificationRuleEntity.getTemplateId());
    assertNull(actualNotificationRuleEntity.getTriggerType());
    assertEquals(0L, actualNotificationRuleEntity.getCreatedTime());
    assertFalse(actualNotificationRuleEntity.isEnabled());
  }

  /**
   * Test {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return CreatedTime is three.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRuleEntity.<init>(NotificationRule)"})
  public void testNewNotificationRuleEntity_givenThree_thenReturnCreatedTimeIsThree() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setCreatedTime(3L);

    // Act
    NotificationRuleEntity actualNotificationRuleEntity =
        new NotificationRuleEntity(notificationRule);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRuleEntity.getTenantId().toString());
    assertNull(actualNotificationRuleEntity.getAdditionalConfig());
    assertNull(actualNotificationRuleEntity.getRecipientsConfig());
    assertNull(actualNotificationRuleEntity.getTriggerConfig());
    assertNull(actualNotificationRuleEntity.getName());
    assertNull(actualNotificationRuleEntity.getId());
    assertNull(actualNotificationRuleEntity.getUuid());
    assertNull(actualNotificationRuleEntity.getExternalId());
    assertNull(actualNotificationRuleEntity.getTemplateId());
    assertNull(actualNotificationRuleEntity.getTriggerType());
    assertEquals(3L, actualNotificationRuleEntity.getCreatedTime());
    assertFalse(actualNotificationRuleEntity.isEnabled());
  }

  /**
   * Test {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}.
   *
   * <ul>
   *   <li>Then RecipientsConfig return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRuleEntity.<init>(NotificationRule)"})
  public void testNewNotificationRuleEntity_thenRecipientsConfigReturnObjectNode() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setRecipientsConfig(new DefaultNotificationRuleRecipientsConfig());

    // Act and Assert
    assertTrue(
        new NotificationRuleEntity(notificationRule).getRecipientsConfig() instanceof ObjectNode);
  }

  /**
   * Test {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}.
   *
   * <ul>
   *   <li>When {@link NotificationRule#NotificationRule()}.
   *   <li>Then return TemplateId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationRuleEntity.<init>(NotificationRule)"})
  public void testNewNotificationRuleEntity_whenNotificationRule_thenReturnTemplateIdIsNull() {
    // Arrange and Act
    NotificationRuleEntity actualNotificationRuleEntity =
        new NotificationRuleEntity(new NotificationRule());

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRuleEntity.getTenantId().toString());
    assertNull(actualNotificationRuleEntity.getAdditionalConfig());
    assertNull(actualNotificationRuleEntity.getRecipientsConfig());
    assertNull(actualNotificationRuleEntity.getTriggerConfig());
    assertNull(actualNotificationRuleEntity.getName());
    assertNull(actualNotificationRuleEntity.getId());
    assertNull(actualNotificationRuleEntity.getUuid());
    assertNull(actualNotificationRuleEntity.getExternalId());
    assertNull(actualNotificationRuleEntity.getTemplateId());
    assertNull(actualNotificationRuleEntity.getTriggerType());
    assertEquals(0L, actualNotificationRuleEntity.getCreatedTime());
    assertFalse(actualNotificationRuleEntity.isEnabled());
  }

  /**
   * Test {@link NotificationRuleEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link NotificationRuleEntity#NotificationRuleEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRule NotificationRuleEntity.toData()"})
  public void testToData_givenNotificationRuleEntity() {
    // Arrange and Act
    NotificationRule actualToDataResult = new NotificationRuleEntity().toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getTemplateId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationRuleEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link NotificationRuleEntity#NotificationRuleEntity()} RecipientsConfig is
   *       Instance.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRule NotificationRuleEntity.toData()"})
  public void testToData_givenNotificationRuleEntityRecipientsConfigIsInstance() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());

    // Act
    NotificationRule actualToDataResult = notificationRuleEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getTemplateId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationRuleEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link NotificationRuleEntity#NotificationRuleEntity()} TenantId is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRule NotificationRuleEntity.toData()"})
  public void testToData_givenNotificationRuleEntityTenantIdIsNull_uuid() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act
    NotificationRule actualToDataResult = notificationRuleEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getTemplateId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationRuleEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TemplateId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRule NotificationRuleEntity.toData()"})
  public void testToData_thenReturnTemplateIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);

    // Act
    NotificationRule actualToDataResult = notificationRuleEntity.toData();

    // Assert
    NotificationTemplateId templateId = actualToDataResult.getTemplateId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateId.getId().toString());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, templateId.getEntityType());
    assertTrue(templateId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationRuleEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRule NotificationRuleEntity.toData()"})
  public void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    UUID tenantId = UUID.randomUUID();
    notificationRuleEntity.setTenantId(tenantId);

    // Act
    NotificationRule actualToDataResult = notificationRuleEntity.toData();

    // Assert
    assertNull(actualToDataResult.getTemplateId());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link NotificationRuleEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 00000000-0000-0001-0000-000000000001}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRule NotificationRuleEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs00000000000000010000000000000001() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setTenantId(new UUID(1L, 1L));

    // Act
    NotificationRule actualToDataResult = notificationRuleEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("00000000-0000-0001-0000-000000000001", tenantId.getId().toString());
    assertNull(actualToDataResult.getTemplateId());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
