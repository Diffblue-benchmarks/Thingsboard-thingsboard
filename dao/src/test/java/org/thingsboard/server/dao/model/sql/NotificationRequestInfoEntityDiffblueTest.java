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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class NotificationRequestInfoEntityDiffblueTest {
  /**
   * Test {@link
   * NotificationRequestInfoEntity#NotificationRequestInfoEntity(NotificationRequestEntity, String,
   * Object)}.
   *
   * <p>Method under test: {@link
   * NotificationRequestInfoEntity#NotificationRequestInfoEntity(NotificationRequestEntity, String,
   * Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationRequestInfoEntity.<init>(NotificationRequestEntity, String, Object)"
  })
  public void testNewNotificationRequestInfoEntity() {
    // Arrange
    NotificationRequestEntity requestEntity = new NotificationRequestEntity();
    requestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    requestEntity.setCreatedTime(1L);
    requestEntity.setId(ModelConstants.NULL_UUID);
    requestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    requestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    requestEntity.setOriginatorEntityType(EntityType.TENANT);
    requestEntity.setRuleId(ModelConstants.NULL_UUID);
    requestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    requestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    requestEntity.setTargets("Targets");
    requestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    requestEntity.setTemplateId(ModelConstants.NULL_UUID);
    requestEntity.setTenantId(ModelConstants.NULL_UUID);
    requestEntity.setUuid(ModelConstants.NULL_UUID);
    JsonNode jsonNode = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    NotificationRequestInfoEntity actualNotificationRequestInfoEntity =
        new NotificationRequestInfoEntity(requestEntity, "Template Name", jsonNode);

    // Assert
    JsonNode additionalConfig = actualNotificationRequestInfoEntity.getAdditionalConfig();
    assertTrue(additionalConfig instanceof ObjectNode);
    assertEquals("Targets", actualNotificationRequestInfoEntity.getTargets());
    assertEquals("Template Name", actualNotificationRequestInfoEntity.getTemplateName());
    assertEquals(1L, actualNotificationRequestInfoEntity.getCreatedTime());
    assertEquals(EntityType.TENANT, actualNotificationRequestInfoEntity.getOriginatorEntityType());
    assertEquals(
        NotificationRequestStatus.PROCESSING, actualNotificationRequestInfoEntity.getStatus());
    assertSame(jsonNode, additionalConfig);
    assertSame(jsonNode, actualNotificationRequestInfoEntity.getInfo());
    assertSame(jsonNode, actualNotificationRequestInfoEntity.getStats());
    assertSame(jsonNode, actualNotificationRequestInfoEntity.getTemplate());
    assertSame(jsonNode, actualNotificationRequestInfoEntity.getTemplateConfig());
  }
}
