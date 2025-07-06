package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.Alarm.AlarmBuilder;
import org.thingsboard.server.common.data.alarm.AlarmApiCallResult;
import org.thingsboard.server.common.data.alarm.AlarmApiCallResult.AlarmApiCallResultBuilder;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;

class AlarmTriggerDiffblueTest {
  /**
   * Test {@link AlarmTrigger#getOriginatorEntityId()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmTrigger#getOriginatorEntityId()}
   */
  @Test
  @DisplayName("Test getOriginatorEntityId(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId AlarmTrigger.getOriginatorEntityId()"
  })
  void testGetOriginatorEntityId_thenReturnNull() {
    // Arrange
    AlarmApiCallResultBuilder builderResult = AlarmApiCallResult.builder();
    AlarmApiCallResultBuilder modifiedResult =
        builderResult
            .alarm(new AlarmInfo())
            .cleared(true)
            .created(true)
            .deleted(true)
            .modified(true);
    AlarmBuilder clearedResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true);
    AlarmBuilder customerIdResult =
        clearedResult.customerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AlarmBuilder propagateResult =
        customerIdResult
            .details(DoubleNode.valueOf(10.0d))
            .endTs(1L)
            .originator(TenantId.SYS_TENANT_ID)
            .propagate(true);
    Alarm old =
        propagateResult
            .propagateRelationTypes(new ArrayList<>())
            .propagateToOwner(true)
            .propagateToTenant(true)
            .severity(AlarmSeverity.CRITICAL)
            .startTs(1L)
            .tenantId(TenantId.SYS_TENANT_ID)
            .type("Type")
            .build();
    AlarmApiCallResultBuilder oldResult = modifiedResult.old(old);
    AlarmApiCallResult alarmUpdate =
        oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertNull(new AlarmTrigger(TenantId.SYS_TENANT_ID, alarmUpdate).getOriginatorEntityId());
  }
}
