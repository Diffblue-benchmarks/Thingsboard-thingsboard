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
package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.UpdateMessage;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.Alarm.AlarmBuilder;
import org.thingsboard.server.common.data.alarm.AlarmApiCallResult;
import org.thingsboard.server.common.data.alarm.AlarmApiCallResult.AlarmApiCallResultBuilder;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class NotificationRuleTriggerDiffblueTest {
  /**
   * Test {@link NotificationRuleTrigger#deduplicate()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleTrigger#deduplicate()}
   */
  @Test
  @DisplayName("Test deduplicate(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleTrigger.deduplicate()"})
  void testDeduplicate_thenReturnFalse() {
    // Arrange
    AlarmApiCallResultBuilder builderResult = AlarmApiCallResult.builder();
    AlarmApiCallResultBuilder modifiedResult = builderResult.alarm(new AlarmInfo())
        .cleared(true)
        .created(true)
        .deleted(true)
        .modified(true);
    AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(true)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
    AlarmBuilder propagateResult = customerIdResult.details(MissingNode.getInstance())
        .endTs(1L)
        .originator(TenantId.SYS_TENANT_ID)
        .propagate(true);
    Alarm old = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .severity(AlarmSeverity.CRITICAL)
        .startTs(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    AlarmApiCallResultBuilder oldResult = modifiedResult.old(old);
    AlarmApiCallResult alarmUpdate = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertFalse((new AlarmTrigger(TenantId.SYS_TENANT_ID, alarmUpdate)).deduplicate());
  }

  /**
   * Test {@link NotificationRuleTrigger#deduplicate()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleTrigger#deduplicate()}
   */
  @Test
  @DisplayName("Test deduplicate(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleTrigger.deduplicate()"})
  void testDeduplicate_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new NewPlatformVersionTrigger(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"))).deduplicate());
  }

  /**
   * Test {@link NotificationRuleTrigger#getDeduplicationKey()}.
   * <p>
   * Method under test: {@link NotificationRuleTrigger#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String NotificationRuleTrigger.getDeduplicationKey()"})
  void testGetDeduplicationKey() {
    // Arrange, Act and Assert
    assertEquals("NEW_PLATFORM_VERSION:TENANT:13814000-1dd2-11b2-8080-808080808080:1.0.2:1.0.2",
        (new NewPlatformVersionTrigger(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))).getDeduplicationKey());
  }

  /**
   * Test {@link NotificationRuleTrigger#getDefaultDeduplicationDuration()}.
   * <p>
   * Method under test: {@link NotificationRuleTrigger#getDefaultDeduplicationDuration()}
   */
  @Test
  @DisplayName("Test getDefaultDeduplicationDuration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long NotificationRuleTrigger.getDefaultDeduplicationDuration()"})
  void testGetDefaultDeduplicationDuration() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new NewPlatformVersionTrigger(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))).getDefaultDeduplicationDuration());
  }

  /**
   * Test {@link NotificationRuleTrigger#getDefaultDeduplicationDuration()}.
   * <p>
   * Method under test: {@link NotificationRuleTrigger#getDefaultDeduplicationDuration()}
   */
  @Test
  @DisplayName("Test getDefaultDeduplicationDuration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long NotificationRuleTrigger.getDefaultDeduplicationDuration()"})
  void testGetDefaultDeduplicationDuration2() {
    // Arrange
    AlarmApiCallResultBuilder builderResult = AlarmApiCallResult.builder();
    AlarmApiCallResultBuilder modifiedResult = builderResult.alarm(new AlarmInfo())
        .cleared(true)
        .created(true)
        .deleted(true)
        .modified(true);
    AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(true)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
    AlarmBuilder propagateResult = customerIdResult.details(MissingNode.getInstance())
        .endTs(1L)
        .originator(TenantId.SYS_TENANT_ID)
        .propagate(true);
    Alarm old = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .severity(AlarmSeverity.CRITICAL)
        .startTs(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    AlarmApiCallResultBuilder oldResult = modifiedResult.old(old);
    AlarmApiCallResult alarmUpdate = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertEquals(0L, (new AlarmTrigger(TenantId.SYS_TENANT_ID, alarmUpdate)).getDefaultDeduplicationDuration());
  }
}
