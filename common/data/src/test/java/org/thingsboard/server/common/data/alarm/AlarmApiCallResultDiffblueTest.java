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
package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class AlarmApiCallResultDiffblueTest {
  /**
   * Method under test: {@link AlarmApiCallResult#isSeverityChanged()}
   */
  @Test
  void testIsSeverityChanged() {
    // Arrange
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(null)
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
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertFalse((new AlarmApiCallResult(other, new ArrayList<>())).isSeverityChanged());
  }

  /**
   * Method under test: {@link AlarmApiCallResult#isSeverityChanged()}
   */
  @Test
  void testIsSeverityChanged2() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();
    alarm.setSeverity(AlarmSeverity.CRITICAL);
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(alarm)
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
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertFalse((new AlarmApiCallResult(other, new ArrayList<>())).isSeverityChanged());
  }

  /**
   * Method under test: {@link AlarmApiCallResult#isSeverityChanged()}
   */
  @Test
  void testIsSeverityChanged3() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();
    alarm.setSeverity(AlarmSeverity.MAJOR);
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(alarm)
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
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertTrue((new AlarmApiCallResult(other, new ArrayList<>())).isSeverityChanged());
  }

  /**
   * Method under test: {@link AlarmApiCallResult#isAcknowledged()}
   */
  @Test
  void testIsAcknowledged() {
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
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertTrue((new AlarmApiCallResult(other, new ArrayList<>())).isAcknowledged());
  }

  /**
   * Method under test: {@link AlarmApiCallResult#isAcknowledged()}
   */
  @Test
  void testIsAcknowledged2() {
    // Arrange
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(null)
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
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertFalse((new AlarmApiCallResult(other, new ArrayList<>())).isAcknowledged());
  }

  /**
   * Method under test: {@link AlarmApiCallResult#isAcknowledged()}
   */
  @Test
  void testIsAcknowledged3() {
    // Arrange
    AlarmApiCallResult.AlarmApiCallResultBuilder builderResult = AlarmApiCallResult.builder();
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = builderResult.alarm(new AlarmInfo())
        .cleared(true)
        .created(true)
        .deleted(true)
        .modified(true);
    Alarm.AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(false)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertFalse((new AlarmApiCallResult(other, new ArrayList<>())).isAcknowledged());
  }

  /**
   * Method under test: {@link AlarmApiCallResult#getOldSeverity()}
   */
  @Test
  void testGetOldSeverity() {
    // Arrange
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(null)
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
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertNull((new AlarmApiCallResult(other, new ArrayList<>())).getOldSeverity());
  }

  /**
   * Method under test: {@link AlarmApiCallResult#getOldSeverity()}
   */
  @Test
  void testGetOldSeverity2() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();
    alarm.setSeverity(AlarmSeverity.CRITICAL);
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(alarm)
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
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertNull((new AlarmApiCallResult(other, new ArrayList<>())).getOldSeverity());
  }

  /**
   * Method under test: {@link AlarmApiCallResult#getOldSeverity()}
   */
  @Test
  void testGetOldSeverity3() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();
    alarm.setSeverity(AlarmSeverity.MAJOR);
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(alarm)
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
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertEquals(AlarmSeverity.CRITICAL, (new AlarmApiCallResult(other, new ArrayList<>())).getOldSeverity());
  }

  /**
   * Method under test: {@link AlarmApiCallResult#isPropagationChanged()}
   */
  @Test
  void testIsPropagationChanged() {
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
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertTrue((new AlarmApiCallResult(other, new ArrayList<>())).isPropagationChanged());
  }

  /**
   * Method under test: {@link AlarmApiCallResult#isPropagationChanged()}
   */
  @Test
  void testIsPropagationChanged2() {
    // Arrange
    AlarmApiCallResult.AlarmApiCallResultBuilder builderResult = AlarmApiCallResult.builder();
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = builderResult.alarm(new AlarmInfo())
        .cleared(true)
        .created(false)
        .deleted(true)
        .modified(true);
    Alarm.AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(true)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertTrue((new AlarmApiCallResult(other, new ArrayList<>())).isPropagationChanged());
  }

  /**
   * Method under test: {@link AlarmApiCallResult#isPropagationChanged()}
   */
  @Test
  void testIsPropagationChanged3() {
    // Arrange
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(null)
        .cleared(true)
        .created(false)
        .deleted(true)
        .modified(true);
    Alarm.AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(true)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertFalse((new AlarmApiCallResult(other, new ArrayList<>())).isPropagationChanged());
  }

  /**
   * Method under test: {@link AlarmApiCallResult#isPropagationChanged()}
   */
  @Test
  void testIsPropagationChanged4() {
    // Arrange
    AlarmApiCallResult.AlarmApiCallResultBuilder builderResult = AlarmApiCallResult.builder();
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = builderResult.alarm(new AlarmInfo())
        .cleared(true)
        .created(false)
        .deleted(true)
        .modified(true);
    Alarm.AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(true)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
    Alarm.AlarmBuilder propagateResult = customerIdResult.details(MissingNode.getInstance())
        .endTs(1L)
        .originator(TenantId.SYS_TENANT_ID)
        .propagate(false);
    Alarm old = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .severity(AlarmSeverity.CRITICAL)
        .startTs(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();
    AlarmApiCallResult.AlarmApiCallResultBuilder oldResult = modifiedResult.old(old);
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertTrue((new AlarmApiCallResult(other, new ArrayList<>())).isPropagationChanged());
  }
}
