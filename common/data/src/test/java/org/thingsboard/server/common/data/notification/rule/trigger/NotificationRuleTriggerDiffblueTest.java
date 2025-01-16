package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.UpdateMessage;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.AlarmApiCallResult;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.id.CustomerId;
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
  void testDeduplicate_thenReturnFalse() {
    // Arrange
    AlarmApiCallResult.AlarmApiCallResultBuilder builderResult = AlarmApiCallResult.builder();
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = builderResult.alarm(new AlarmInfo())
        .cleared(true)
        .created(true)
        .deleted(true)
        .modified(true);
    Alarm.AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(true)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    Alarm.AlarmBuilder customerIdResult = clearedResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    Alarm.AlarmBuilder propagateResult = customerIdResult.details(MissingNode.getInstance())
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
    AlarmApiCallResult.AlarmApiCallResultBuilder oldResult = modifiedResult.old(old);
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
  void testGetDeduplicationKey() {
    // Arrange, Act and Assert
    assertEquals("NEW_PLATFORM_VERSION:TENANT:13814000-1dd2-11b2-8080-808080808080:1.0.2:1.0.2",
        (new NewPlatformVersionTrigger(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))).getDeduplicationKey());
  }

  /**
   * Test {@link NotificationRuleTrigger#getDefaultDeduplicationDuration()}.
   * <p>
   * Method under test:
   * {@link NotificationRuleTrigger#getDefaultDeduplicationDuration()}
   */
  @Test
  @DisplayName("Test getDefaultDeduplicationDuration()")
  void testGetDefaultDeduplicationDuration() {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new NewPlatformVersionTrigger(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))).getDefaultDeduplicationDuration());
  }

  /**
   * Test {@link NotificationRuleTrigger#getDefaultDeduplicationDuration()}.
   * <p>
   * Method under test:
   * {@link NotificationRuleTrigger#getDefaultDeduplicationDuration()}
   */
  @Test
  @DisplayName("Test getDefaultDeduplicationDuration()")
  void testGetDefaultDeduplicationDuration2() {
    // Arrange
    AlarmApiCallResult.AlarmApiCallResultBuilder builderResult = AlarmApiCallResult.builder();
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = builderResult.alarm(new AlarmInfo())
        .cleared(true)
        .created(true)
        .deleted(true)
        .modified(true);
    Alarm.AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(true)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    Alarm.AlarmBuilder customerIdResult = clearedResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    Alarm.AlarmBuilder propagateResult = customerIdResult.details(MissingNode.getInstance())
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
    AlarmApiCallResult.AlarmApiCallResultBuilder oldResult = modifiedResult.old(old);
    AlarmApiCallResult alarmUpdate = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertEquals(0L, (new AlarmTrigger(TenantId.SYS_TENANT_ID, alarmUpdate)).getDefaultDeduplicationDuration());
  }
}
