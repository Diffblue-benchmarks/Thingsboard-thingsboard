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
package org.thingsboard.server.common.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestInfo#equals(Object)}
   *   <li>{@link NotificationRequestInfo#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestInfo#equals(Object)}
   *   <li>{@link NotificationRequestInfo#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestInfo#equals(Object)}
   *   <li>{@link NotificationRequestInfo#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestInfo#equals(Object)}
   *   <li>{@link NotificationRequestInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();

    // Act and Assert
    assertEquals(notificationRequestInfo, notificationRequestInfo);
    int expectedHashCodeResult = notificationRequestInfo.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestInfo.hashCode());
  }

  /**
   * Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(EntityId.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest request = templateResult.templateId(new NotificationTemplateId(EntityId.NULL_UUID))
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo(request, "Template Name",
        new ArrayList<>());

    // Act and Assert
    assertNotEquals(notificationRequestInfo, new NotificationRequestInfo());
  }

  /**
   * Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();
    notificationRequestInfo.setTemplateName("Template Name");

    // Act and Assert
    assertNotEquals(notificationRequestInfo, new NotificationRequestInfo());
  }

  /**
   * Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();
    notificationRequestInfo.setDeliveryMethods(new ArrayList<>());

    // Act and Assert
    assertNotEquals(notificationRequestInfo, new NotificationRequestInfo());
  }

  /**
   * Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();

    NotificationRequestInfo notificationRequestInfo2 = new NotificationRequestInfo();
    notificationRequestInfo2.setTemplateName("Template Name");

    // Act and Assert
    assertNotEquals(notificationRequestInfo, notificationRequestInfo2);
  }

  /**
   * Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRequestInfo notificationRequestInfo = new NotificationRequestInfo();

    NotificationRequestInfo notificationRequestInfo2 = new NotificationRequestInfo();
    notificationRequestInfo2.setDeliveryMethods(new ArrayList<>());

    // Act and Assert
    assertNotEquals(notificationRequestInfo, notificationRequestInfo2);
  }

  /**
   * Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRequestInfo(), null);
  }

  /**
   * Method under test: {@link NotificationRequestInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRequestInfo(), "Different type to NotificationRequestInfo");
  }

  /**
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
   * Method under test:
   * {@link NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String, List)}
   */
  @Test
  void testNewNotificationRequestInfo() {
    // Arrange
    NotificationRequest request = new NotificationRequest();
    ArrayList<NotificationDeliveryMethod> deliveryMethods = new ArrayList<>();

    // Act
    NotificationRequestInfo actualNotificationRequestInfo = new NotificationRequestInfo(request, "Template Name",
        deliveryMethods);

    // Assert
    assertEquals("Template Name", actualNotificationRequestInfo.getTemplateName());
    assertEquals("To targets null", actualNotificationRequestInfo.getName());
    assertNull(actualNotificationRequestInfo.getTargets());
    assertNull(actualNotificationRequestInfo.getUuidId());
    assertNull(actualNotificationRequestInfo.getOriginatorEntityId());
    assertNull(actualNotificationRequestInfo.getId());
    assertNull(actualNotificationRequestInfo.getRuleId());
    assertNull(actualNotificationRequestInfo.getTemplateId());
    assertNull(actualNotificationRequestInfo.getTenantId());
    assertNull(actualNotificationRequestInfo.getSenderId());
    assertNull(actualNotificationRequestInfo.getAdditionalConfig());
    assertNull(actualNotificationRequestInfo.getStats());
    assertNull(actualNotificationRequestInfo.getStatus());
    assertNull(actualNotificationRequestInfo.getInfo());
    assertNull(actualNotificationRequestInfo.getTemplate());
    assertEquals(0L, actualNotificationRequestInfo.getCreatedTime());
    assertFalse(actualNotificationRequestInfo.isScheduled());
    assertFalse(actualNotificationRequestInfo.isSent());
    List<NotificationDeliveryMethod> deliveryMethods2 = actualNotificationRequestInfo.getDeliveryMethods();
    assertTrue(deliveryMethods2.isEmpty());
    assertSame(deliveryMethods, deliveryMethods2);
  }

  /**
   * Method under test:
   * {@link NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String, List)}
   */
  @Test
  void testNewNotificationRequestInfo2() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = NotificationRequest.builder()
        .info(mock(NotificationInfo.class))
        .originatorEntityId(TenantId.SYS_TENANT_ID);
    NotificationRuleId ruleId = new NotificationRuleId(EntityId.NULL_UUID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult.ruleId(ruleId);
    NotificationRequestStats stats = new NotificationRequestStats();
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(stats)
        .status(NotificationRequestStatus.PROCESSING);
    ArrayList<UUID> targets = new ArrayList<>();
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(targets);
    NotificationTemplate template = new NotificationTemplate();
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(template);
    NotificationTemplateId templateId = new NotificationTemplateId(EntityId.NULL_UUID);
    NotificationRequest request = templateResult.templateId(templateId).tenantId(TenantId.SYS_TENANT_ID).build();
    ArrayList<NotificationDeliveryMethod> deliveryMethods = new ArrayList<>();

    // Act
    NotificationRequestInfo actualNotificationRequestInfo = new NotificationRequestInfo(request, "Template Name",
        deliveryMethods);

    // Assert
    EntityId originatorEntityId = actualNotificationRequestInfo.getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof TenantId);
    assertEquals("Template Name", actualNotificationRequestInfo.getTemplateName());
    assertEquals("To targets []", actualNotificationRequestInfo.getName());
    assertNull(actualNotificationRequestInfo.getUuidId());
    assertNull(actualNotificationRequestInfo.getId());
    assertNull(actualNotificationRequestInfo.getSenderId());
    assertNull(actualNotificationRequestInfo.getAdditionalConfig());
    assertEquals(0L, actualNotificationRequestInfo.getCreatedTime());
    assertEquals(EntityType.TENANT, originatorEntityId.getEntityType());
    assertEquals(NotificationRequestStatus.PROCESSING, actualNotificationRequestInfo.getStatus());
    assertFalse(actualNotificationRequestInfo.isScheduled());
    assertFalse(actualNotificationRequestInfo.isSent());
    List<UUID> targets2 = actualNotificationRequestInfo.getTargets();
    assertTrue(targets2.isEmpty());
    List<NotificationDeliveryMethod> deliveryMethods2 = actualNotificationRequestInfo.getDeliveryMethods();
    assertTrue(deliveryMethods2.isEmpty());
    assertTrue(originatorEntityId.isNullUid());
    assertTrue(((TenantId) originatorEntityId).isSysTenantId());
    assertSame(targets, targets2);
    assertSame(deliveryMethods, deliveryMethods2);
    assertSame(ruleId, actualNotificationRequestInfo.getRuleId());
    assertSame(templateId, actualNotificationRequestInfo.getTemplateId());
    assertSame(stats, actualNotificationRequestInfo.getStats());
    assertSame(template, actualNotificationRequestInfo.getTemplate());
    assertSame(originatorEntityId, actualNotificationRequestInfo.getTenantId());
  }

  /**
   * Method under test:
   * {@link NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String, List)}
   */
  @Test
  void testNewNotificationRequestInfo3() {
    // Arrange
    NotificationRequest request = new NotificationRequest();

    ArrayList<NotificationDeliveryMethod> deliveryMethods = new ArrayList<>();
    deliveryMethods.add(NotificationDeliveryMethod.WEB);

    // Act
    NotificationRequestInfo actualNotificationRequestInfo = new NotificationRequestInfo(request, "Template Name",
        deliveryMethods);

    // Assert
    assertEquals("Template Name", actualNotificationRequestInfo.getTemplateName());
    assertEquals("To targets null", actualNotificationRequestInfo.getName());
    assertNull(actualNotificationRequestInfo.getTargets());
    assertNull(actualNotificationRequestInfo.getUuidId());
    assertNull(actualNotificationRequestInfo.getOriginatorEntityId());
    assertNull(actualNotificationRequestInfo.getId());
    assertNull(actualNotificationRequestInfo.getRuleId());
    assertNull(actualNotificationRequestInfo.getTemplateId());
    assertNull(actualNotificationRequestInfo.getTenantId());
    assertNull(actualNotificationRequestInfo.getSenderId());
    assertNull(actualNotificationRequestInfo.getAdditionalConfig());
    assertNull(actualNotificationRequestInfo.getStats());
    assertNull(actualNotificationRequestInfo.getStatus());
    assertNull(actualNotificationRequestInfo.getInfo());
    assertNull(actualNotificationRequestInfo.getTemplate());
    assertEquals(0L, actualNotificationRequestInfo.getCreatedTime());
    List<NotificationDeliveryMethod> deliveryMethods2 = actualNotificationRequestInfo.getDeliveryMethods();
    assertEquals(1, deliveryMethods2.size());
    assertEquals(NotificationDeliveryMethod.WEB, deliveryMethods2.get(0));
    assertFalse(actualNotificationRequestInfo.isScheduled());
    assertFalse(actualNotificationRequestInfo.isSent());
    assertSame(deliveryMethods, deliveryMethods2);
  }

  /**
   * Method under test:
   * {@link NotificationRequestInfo#NotificationRequestInfo(NotificationRequest, String, List)}
   */
  @Test
  void testNewNotificationRequestInfo4() {
    // Arrange
    NotificationRequest request = new NotificationRequest();

    ArrayList<NotificationDeliveryMethod> deliveryMethods = new ArrayList<>();
    deliveryMethods.add(NotificationDeliveryMethod.EMAIL);
    deliveryMethods.add(NotificationDeliveryMethod.WEB);

    // Act
    NotificationRequestInfo actualNotificationRequestInfo = new NotificationRequestInfo(request, "Template Name",
        deliveryMethods);

    // Assert
    assertEquals("Template Name", actualNotificationRequestInfo.getTemplateName());
    assertEquals("To targets null", actualNotificationRequestInfo.getName());
    assertNull(actualNotificationRequestInfo.getTargets());
    assertNull(actualNotificationRequestInfo.getUuidId());
    assertNull(actualNotificationRequestInfo.getOriginatorEntityId());
    assertNull(actualNotificationRequestInfo.getId());
    assertNull(actualNotificationRequestInfo.getRuleId());
    assertNull(actualNotificationRequestInfo.getTemplateId());
    assertNull(actualNotificationRequestInfo.getTenantId());
    assertNull(actualNotificationRequestInfo.getSenderId());
    assertNull(actualNotificationRequestInfo.getAdditionalConfig());
    assertNull(actualNotificationRequestInfo.getStats());
    assertNull(actualNotificationRequestInfo.getStatus());
    assertNull(actualNotificationRequestInfo.getInfo());
    assertNull(actualNotificationRequestInfo.getTemplate());
    assertEquals(0L, actualNotificationRequestInfo.getCreatedTime());
    assertFalse(actualNotificationRequestInfo.isScheduled());
    assertFalse(actualNotificationRequestInfo.isSent());
    assertSame(deliveryMethods, actualNotificationRequestInfo.getDeliveryMethods());
  }
}
