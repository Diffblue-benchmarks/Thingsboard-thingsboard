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
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.notification.template.NotificationTemplateConfig;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class NotificationTemplateEntityDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTemplateEntity, notificationTemplateEntity2);
    assertEquals(notificationTemplateEntity.hashCode(), notificationTemplateEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(null);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(null);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTemplateEntity, notificationTemplateEntity2);
    assertEquals(notificationTemplateEntity.hashCode(), notificationTemplateEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(null);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(null);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTemplateEntity, notificationTemplateEntity2);
    assertEquals(notificationTemplateEntity.hashCode(), notificationTemplateEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName(null);
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName(null);
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTemplateEntity, notificationTemplateEntity2);
    assertEquals(notificationTemplateEntity.hashCode(), notificationTemplateEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(null);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(null);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTemplateEntity, notificationTemplateEntity2);
    assertEquals(notificationTemplateEntity.hashCode(), notificationTemplateEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(null);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(null);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTemplateEntity, notificationTemplateEntity2);
    assertEquals(notificationTemplateEntity.hashCode(), notificationTemplateEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(DoubleNode.valueOf(10.0d));
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(null);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(3L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(UUID.randomUUID());
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(null);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName(null);
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName(
        "org.thingsboard.server.dao.model.sql.NotificationTemplateEntity");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(null);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.ALARM);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.randomUUID());
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(null);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTemplateEntity.equals(Object)",
    "int NotificationTemplateEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  public void testGettersAndSetters() {
    // Arrange and Act
    NotificationTemplateEntity actualNotificationTemplateEntity = new NotificationTemplateEntity();
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualNotificationTemplateEntity.setConfiguration(configuration);
    actualNotificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    actualNotificationTemplateEntity.setName("Name");
    actualNotificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    UUID tenantId = ModelConstants.NULL_UUID;
    actualNotificationTemplateEntity.setTenantId(tenantId);
    String actualToStringResult = actualNotificationTemplateEntity.toString();
    JsonNode actualConfiguration = actualNotificationTemplateEntity.getConfiguration();
    UUID actualExternalId = actualNotificationTemplateEntity.getExternalId();
    String actualName = actualNotificationTemplateEntity.getName();
    NotificationType actualNotificationType =
        actualNotificationTemplateEntity.getNotificationType();
    UUID actualTenantId = actualNotificationTemplateEntity.getTenantId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Name", actualName);
    assertEquals(
        "NotificationTemplateEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, notificationType"
            + "=GENERAL, configuration={\"isPublic\":true}, externalId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertNull(actualNotificationTemplateEntity.getId());
    assertNull(actualNotificationTemplateEntity.getUuid());
    assertEquals(0L, actualNotificationTemplateEntity.getCreatedTime());
    assertEquals(NotificationType.GENERAL, actualNotificationType);
    assertSame(configuration, actualConfiguration);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}.
   *
   * <p>Method under test: {@link
   * NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTemplateEntity.<init>(NotificationTemplate)"})
  public void testNewNotificationTemplateEntity() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setExternalId(new NotificationTemplateId(ModelConstants.NULL_UUID));

    // Act
    NotificationTemplateEntity actualNotificationTemplateEntity =
        new NotificationTemplateEntity(notificationTemplate);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationTemplateEntity.getExternalId().toString());
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationTemplateEntity.getTenantId().toString());
    assertNull(actualNotificationTemplateEntity.getConfiguration());
    assertNull(actualNotificationTemplateEntity.getName());
    assertNull(actualNotificationTemplateEntity.getId());
    assertNull(actualNotificationTemplateEntity.getUuid());
    assertNull(actualNotificationTemplateEntity.getNotificationType());
    assertEquals(0L, actualNotificationTemplateEntity.getCreatedTime());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTemplateEntity.<init>(NotificationTemplate)"})
  public void testNewNotificationTemplateEntity_givenOne_thenReturnCreatedTimeIsOne() {
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
    assertNull(actualNotificationTemplateEntity.getConfiguration());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTemplateEntity.<init>(NotificationTemplate)"})
  public void testNewNotificationTemplateEntity_givenSystem_tenant() {
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
    assertNull(actualNotificationTemplateEntity.getConfiguration());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTemplateEntity.<init>(NotificationTemplate)"})
  public void testNewNotificationTemplateEntity_thenConfigurationReturnObjectNode() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTemplateEntity.<init>(NotificationTemplate)"})
  public void testNewNotificationTemplateEntity_whenNotificationTemplate() {
    // Arrange and Act
    NotificationTemplateEntity actualNotificationTemplateEntity =
        new NotificationTemplateEntity(new NotificationTemplate());

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationTemplateEntity.getTenantId().toString());
    assertNull(actualNotificationTemplateEntity.getConfiguration());
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
   * <ul>
   *   <li>Given {@link NotificationTemplateEntity#NotificationTemplateEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateEntity.toData()"})
  public void testToData_givenNotificationTemplateEntity() {
    // Arrange and Act
    NotificationTemplate actualToDataResult = new NotificationTemplateEntity().toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getExternalId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationTemplateEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateEntity.toData()"})
  public void testToData_thenReturnExternalIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    NotificationTemplate actualToDataResult = notificationTemplateEntity.toData();

    // Assert
    NotificationTemplateId externalId = actualToDataResult.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.getId().toString());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateEntity.toData()"})
  public void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    UUID tenantId = UUID.randomUUID();
    notificationTemplateEntity.setTenantId(tenantId);

    // Act
    NotificationTemplate actualToDataResult = notificationTemplateEntity.toData();

    // Assert
    assertNull(actualToDataResult.getExternalId());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link NotificationTemplateEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act
    NotificationTemplate actualToDataResult = notificationTemplateEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getExternalId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationTemplateEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 00000000-0000-0001-0000-000000000001}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs00000000000000010000000000000001() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setTenantId(new UUID(1L, 1L));

    // Act
    NotificationTemplate actualToDataResult = notificationTemplateEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("00000000-0000-0001-0000-000000000001", tenantId.getId().toString());
    assertNull(actualToDataResult.getExternalId());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationTemplateEntity#toData()}.
   *
   * <ul>
   *   <li>Then return UuidId toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTemplateEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateEntity.toData()"})
  public void testToData_thenReturnUuidIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    NotificationTemplate actualToDataResult = notificationTemplateEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(NotificationType.GENERAL, actualToDataResult.getNotificationType());
    NotificationTemplateId externalId = actualToDataResult.getExternalId();
    assertEquals(externalId, actualToDataResult.getId());
    assertSame(uuidId, externalId.getId());
  }
}
