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
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversation;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversationType;
import org.thingsboard.server.common.data.notification.targets.slack.SlackNotificationTargetConfig;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class NotificationTargetEntityDiffblueTest {
  /**
   * Test {@link NotificationTargetEntity#equals(Object)}, and {@link
   * NotificationTargetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTargetEntity#equals(Object)}
   *   <li>{@link NotificationTargetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTargetEntity, notificationTargetEntity2);
    assertEquals(notificationTargetEntity.hashCode(), notificationTargetEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}, and {@link
   * NotificationTargetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTargetEntity#equals(Object)}
   *   <li>{@link NotificationTargetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(null);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(null);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTargetEntity, notificationTargetEntity2);
    assertEquals(notificationTargetEntity.hashCode(), notificationTargetEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}, and {@link
   * NotificationTargetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTargetEntity#equals(Object)}
   *   <li>{@link NotificationTargetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(null);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(null);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTargetEntity, notificationTargetEntity2);
    assertEquals(notificationTargetEntity.hashCode(), notificationTargetEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}, and {@link
   * NotificationTargetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTargetEntity#equals(Object)}
   *   <li>{@link NotificationTargetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName(null);
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName(null);
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTargetEntity, notificationTargetEntity2);
    assertEquals(notificationTargetEntity.hashCode(), notificationTargetEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}, and {@link
   * NotificationTargetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTargetEntity#equals(Object)}
   *   <li>{@link NotificationTargetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(null);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(null);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTargetEntity, notificationTargetEntity2);
    assertEquals(notificationTargetEntity.hashCode(), notificationTargetEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}, and {@link
   * NotificationTargetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTargetEntity#equals(Object)}
   *   <li>{@link NotificationTargetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTargetEntity, notificationTargetEntity);
    int expectedHashCodeResult = notificationTargetEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTargetEntity.hashCode());
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(DoubleNode.valueOf(10.0d));
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(null);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(3L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.randomUUID());
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(null);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName(null);
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName(
        "org.thingsboard.server.dao.model.sql.NotificationTargetEntity");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.randomUUID());
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(null);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, null);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, "Different type to NotificationTargetEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTargetEntity#NotificationTargetEntity()}
   *   <li>{@link NotificationTargetEntity#setConfiguration(JsonNode)}
   *   <li>{@link NotificationTargetEntity#setExternalId(UUID)}
   *   <li>{@link NotificationTargetEntity#setName(String)}
   *   <li>{@link NotificationTargetEntity#setTenantId(UUID)}
   *   <li>{@link NotificationTargetEntity#toString()}
   *   <li>{@link NotificationTargetEntity#getConfiguration()}
   *   <li>{@link NotificationTargetEntity#getExternalId()}
   *   <li>{@link NotificationTargetEntity#getName()}
   *   <li>{@link NotificationTargetEntity#getTenantId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationTargetEntity.<init>()",
    "JsonNode NotificationTargetEntity.getConfiguration()",
    "UUID NotificationTargetEntity.getExternalId()",
    "String NotificationTargetEntity.getName()",
    "UUID NotificationTargetEntity.getTenantId()",
    "void NotificationTargetEntity.setConfiguration(JsonNode)",
    "void NotificationTargetEntity.setExternalId(UUID)",
    "void NotificationTargetEntity.setName(String)",
    "void NotificationTargetEntity.setTenantId(UUID)",
    "String NotificationTargetEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    NotificationTargetEntity actualNotificationTargetEntity = new NotificationTargetEntity();
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualNotificationTargetEntity.setConfiguration(configuration);
    actualNotificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    actualNotificationTargetEntity.setName("Name");
    UUID tenantId = ModelConstants.NULL_UUID;
    actualNotificationTargetEntity.setTenantId(tenantId);
    String actualToStringResult = actualNotificationTargetEntity.toString();
    JsonNode actualConfiguration = actualNotificationTargetEntity.getConfiguration();
    UUID actualExternalId = actualNotificationTargetEntity.getExternalId();
    String actualName = actualNotificationTargetEntity.getName();
    UUID actualTenantId = actualNotificationTargetEntity.getTenantId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Name", actualName);
    assertEquals(
        "NotificationTargetEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, configuration={"
            + "\"isPublic\":true}, externalId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertNull(actualNotificationTargetEntity.getId());
    assertNull(actualNotificationTargetEntity.getUuid());
    assertEquals(0L, actualNotificationTargetEntity.getCreatedTime());
    assertSame(configuration, actualConfiguration);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   *
   * <p>Method under test: {@link
   * NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTargetEntity.<init>(NotificationTarget)"})
  public void testNewNotificationTargetEntity() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setExternalId(new NotificationTargetId(ModelConstants.NULL_UUID));

    // Act
    NotificationTargetEntity actualNotificationTargetEntity =
        new NotificationTargetEntity(notificationTarget);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationTargetEntity.getExternalId().toString());
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationTargetEntity.getTenantId().toString());
    assertNull(actualNotificationTargetEntity.getConfiguration());
    assertNull(actualNotificationTargetEntity.getName());
    assertNull(actualNotificationTargetEntity.getId());
    assertNull(actualNotificationTargetEntity.getUuid());
    assertEquals(0L, actualNotificationTargetEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   *
   * <p>Method under test: {@link
   * NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTargetEntity.<init>(NotificationTarget)"})
  public void testNewNotificationTargetEntity2() {
    // Arrange
    SlackNotificationTargetConfig configuration = new SlackNotificationTargetConfig();
    configuration.setConversation(
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build());
    configuration.setConversationType(SlackConversationType.DIRECT);
    configuration.setDescription("The characteristics of someone or something");

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(configuration);

    // Act and Assert
    JsonNode configuration2 = new NotificationTargetEntity(notificationTarget).getConfiguration();
    assertTrue(configuration2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = configuration2.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertEquals(4, configuration2.size());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   *
   * <p>Method under test: {@link
   * NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTargetEntity.<init>(NotificationTarget)"})
  public void testNewNotificationTargetEntity3() {
    // Arrange
    SlackNotificationTargetConfig configuration = new SlackNotificationTargetConfig();
    configuration.setConversation(
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("")
            .build());
    configuration.setConversationType(SlackConversationType.DIRECT);
    configuration.setDescription("The characteristics of someone or something");

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(configuration);

    // Act and Assert
    JsonNode configuration2 = new NotificationTargetEntity(notificationTarget).getConfiguration();
    assertTrue(configuration2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = configuration2.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertEquals(4, configuration2.size());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   *
   * <p>Method under test: {@link
   * NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTargetEntity.<init>(NotificationTarget)"})
  public void testNewNotificationTargetEntity4() {
    // Arrange
    SlackNotificationTargetConfig configuration = new SlackNotificationTargetConfig();
    configuration.setConversation(
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName(null)
            .build());
    configuration.setConversationType(SlackConversationType.DIRECT);
    configuration.setDescription("The characteristics of someone or something");

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(configuration);

    // Act and Assert
    JsonNode configuration2 = new NotificationTargetEntity(notificationTarget).getConfiguration();
    assertTrue(configuration2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = configuration2.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertEquals(4, configuration2.size());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTargetEntity.<init>(NotificationTarget)"})
  public void testNewNotificationTargetEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setCreatedTime(1L);

    // Act
    NotificationTargetEntity actualNotificationTargetEntity =
        new NotificationTargetEntity(notificationTarget);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationTargetEntity.getTenantId().toString());
    assertNull(actualNotificationTargetEntity.getConfiguration());
    assertNull(actualNotificationTargetEntity.getName());
    assertNull(actualNotificationTargetEntity.getId());
    assertNull(actualNotificationTargetEntity.getUuid());
    assertNull(actualNotificationTargetEntity.getExternalId());
    assertEquals(1L, actualNotificationTargetEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTargetEntity.<init>(NotificationTarget)"})
  public void testNewNotificationTargetEntity_givenSystem_tenant() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    NotificationTargetEntity actualNotificationTargetEntity =
        new NotificationTargetEntity(notificationTarget);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationTargetEntity.getTenantId().toString());
    assertNull(actualNotificationTargetEntity.getConfiguration());
    assertNull(actualNotificationTargetEntity.getName());
    assertNull(actualNotificationTargetEntity.getId());
    assertNull(actualNotificationTargetEntity.getUuid());
    assertNull(actualNotificationTargetEntity.getExternalId());
    assertEquals(0L, actualNotificationTargetEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   *
   * <ul>
   *   <li>When {@link NotificationTarget#NotificationTarget()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTargetEntity.<init>(NotificationTarget)"})
  public void testNewNotificationTargetEntity_whenNotificationTarget() {
    // Arrange and Act
    NotificationTargetEntity actualNotificationTargetEntity =
        new NotificationTargetEntity(new NotificationTarget());

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationTargetEntity.getTenantId().toString());
    assertNull(actualNotificationTargetEntity.getConfiguration());
    assertNull(actualNotificationTargetEntity.getName());
    assertNull(actualNotificationTargetEntity.getId());
    assertNull(actualNotificationTargetEntity.getUuid());
    assertNull(actualNotificationTargetEntity.getExternalId());
    assertEquals(0L, actualNotificationTargetEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationTargetEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link NotificationTargetEntity#NotificationTargetEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTarget NotificationTargetEntity.toData()"})
  public void testToData_givenNotificationTargetEntity() {
    // Arrange and Act
    NotificationTarget actualToDataResult = new NotificationTargetEntity().toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getExternalId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationTargetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTarget NotificationTargetEntity.toData()"})
  public void testToData_thenReturnExternalIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    NotificationTarget actualToDataResult = notificationTargetEntity.toData();

    // Assert
    NotificationTargetId externalId = actualToDataResult.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.getId().toString());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationTargetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTarget NotificationTargetEntity.toData()"})
  public void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    UUID tenantId = UUID.randomUUID();
    notificationTargetEntity.setTenantId(tenantId);

    // Act
    NotificationTarget actualToDataResult = notificationTargetEntity.toData();

    // Assert
    assertNull(actualToDataResult.getExternalId());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link NotificationTargetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTarget NotificationTargetEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act
    NotificationTarget actualToDataResult = notificationTargetEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getExternalId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationTargetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 00000000-0000-0001-0000-000000000001}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTarget NotificationTargetEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs00000000000000010000000000000001() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setTenantId(new UUID(1L, 1L));

    // Act
    NotificationTarget actualToDataResult = notificationTargetEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("00000000-0000-0001-0000-000000000001", tenantId.getId().toString());
    assertNull(actualToDataResult.getExternalId());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationTargetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return UuidId toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTarget NotificationTargetEntity.toData()"})
  public void testToData_thenReturnUuidIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    NotificationTarget actualToDataResult = notificationTargetEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    NotificationTargetId externalId = actualToDataResult.getExternalId();
    assertEquals(externalId, actualToDataResult.getId());
    assertSame(uuidId, externalId.getId());
  }
}
