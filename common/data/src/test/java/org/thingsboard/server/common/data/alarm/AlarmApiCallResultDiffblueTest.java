package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.Alarm.AlarmBuilder;
import org.thingsboard.server.common.data.alarm.AlarmApiCallResult.AlarmApiCallResultBuilder;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;

class AlarmApiCallResultDiffblueTest {
  /**
   * Test {@link AlarmApiCallResult#isSeverityChanged()}.
   * <p>
   * Method under test: {@link AlarmApiCallResult#isSeverityChanged()}
   */
  @Test
  @DisplayName("Test isSeverityChanged()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmApiCallResult.isSeverityChanged()"})
  void testIsSeverityChanged() {
    // Arrange
    AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(null)
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
    AlarmBuilder customerIdResult = clearedResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertFalse((new AlarmApiCallResult(other, new ArrayList<>())).isSeverityChanged());
  }

  /**
   * Test {@link AlarmApiCallResult#isSeverityChanged()}.
   * <ul>
   *   <li>Given {@link AlarmInfo#AlarmInfo()} Severity is {@code CRITICAL}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmApiCallResult#isSeverityChanged()}
   */
  @Test
  @DisplayName("Test isSeverityChanged(); given AlarmInfo() Severity is 'CRITICAL'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmApiCallResult.isSeverityChanged()"})
  void testIsSeverityChanged_givenAlarmInfoSeverityIsCritical_thenReturnFalse() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();
    alarm.setSeverity(AlarmSeverity.CRITICAL);
    AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(alarm)
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
    AlarmBuilder customerIdResult = clearedResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertFalse((new AlarmApiCallResult(other, new ArrayList<>())).isSeverityChanged());
  }

  /**
   * Test {@link AlarmApiCallResult#isSeverityChanged()}.
   * <ul>
   *   <li>Given {@link AlarmInfo#AlarmInfo()} Severity is {@code MAJOR}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmApiCallResult#isSeverityChanged()}
   */
  @Test
  @DisplayName("Test isSeverityChanged(); given AlarmInfo() Severity is 'MAJOR'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmApiCallResult.isSeverityChanged()"})
  void testIsSeverityChanged_givenAlarmInfoSeverityIsMajor_thenReturnTrue() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();
    alarm.setSeverity(AlarmSeverity.MAJOR);
    AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(alarm)
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
    AlarmBuilder customerIdResult = clearedResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertTrue((new AlarmApiCallResult(other, new ArrayList<>())).isSeverityChanged());
  }

  /**
   * Test {@link AlarmApiCallResult#isAcknowledged()}.
   * <p>
   * Method under test: {@link AlarmApiCallResult#isAcknowledged()}
   */
  @Test
  @DisplayName("Test isAcknowledged()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmApiCallResult.isAcknowledged()"})
  void testIsAcknowledged() {
    // Arrange
    AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(null)
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
    AlarmBuilder customerIdResult = clearedResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertFalse((new AlarmApiCallResult(other, new ArrayList<>())).isAcknowledged());
  }

  /**
   * Test {@link AlarmApiCallResult#isAcknowledged()}.
   * <p>
   * Method under test: {@link AlarmApiCallResult#isAcknowledged()}
   */
  @Test
  @DisplayName("Test isAcknowledged()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmApiCallResult.isAcknowledged()"})
  void testIsAcknowledged2() {
    // Arrange
    AlarmApiCallResultBuilder builderResult = AlarmApiCallResult.builder();
    AlarmApiCallResultBuilder modifiedResult = builderResult.alarm(new AlarmInfo())
        .cleared(true)
        .created(true)
        .deleted(true)
        .modified(true);
    AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(false)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    AlarmBuilder customerIdResult = clearedResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertFalse((new AlarmApiCallResult(other, new ArrayList<>())).isAcknowledged());
  }

  /**
   * Test {@link AlarmApiCallResult#isAcknowledged()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmApiCallResult#isAcknowledged()}
   */
  @Test
  @DisplayName("Test isAcknowledged(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmApiCallResult.isAcknowledged()"})
  void testIsAcknowledged_thenReturnTrue() {
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
    AlarmBuilder customerIdResult = clearedResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertTrue((new AlarmApiCallResult(other, new ArrayList<>())).isAcknowledged());
  }

  /**
   * Test {@link AlarmApiCallResult#getOldSeverity()}.
   * <p>
   * Method under test: {@link AlarmApiCallResult#getOldSeverity()}
   */
  @Test
  @DisplayName("Test getOldSeverity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmSeverity AlarmApiCallResult.getOldSeverity()"})
  void testGetOldSeverity() {
    // Arrange
    AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(null)
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
    AlarmBuilder customerIdResult = clearedResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertNull((new AlarmApiCallResult(other, new ArrayList<>())).getOldSeverity());
  }

  /**
   * Test {@link AlarmApiCallResult#getOldSeverity()}.
   * <ul>
   *   <li>Given {@link AlarmInfo#AlarmInfo()} Severity is {@code CRITICAL}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmApiCallResult#getOldSeverity()}
   */
  @Test
  @DisplayName("Test getOldSeverity(); given AlarmInfo() Severity is 'CRITICAL'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmSeverity AlarmApiCallResult.getOldSeverity()"})
  void testGetOldSeverity_givenAlarmInfoSeverityIsCritical_thenReturnNull() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();
    alarm.setSeverity(AlarmSeverity.CRITICAL);
    AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(alarm)
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
    AlarmBuilder customerIdResult = clearedResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertNull((new AlarmApiCallResult(other, new ArrayList<>())).getOldSeverity());
  }

  /**
   * Test {@link AlarmApiCallResult#getOldSeverity()}.
   * <ul>
   *   <li>Given {@link AlarmInfo#AlarmInfo()} Severity is {@code MAJOR}.</li>
   *   <li>Then return {@code CRITICAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmApiCallResult#getOldSeverity()}
   */
  @Test
  @DisplayName("Test getOldSeverity(); given AlarmInfo() Severity is 'MAJOR'; then return 'CRITICAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmSeverity AlarmApiCallResult.getOldSeverity()"})
  void testGetOldSeverity_givenAlarmInfoSeverityIsMajor_thenReturnCritical() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();
    alarm.setSeverity(AlarmSeverity.MAJOR);
    AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(alarm)
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
    AlarmBuilder customerIdResult = clearedResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertEquals(AlarmSeverity.CRITICAL, (new AlarmApiCallResult(other, new ArrayList<>())).getOldSeverity());
  }

  /**
   * Test {@link AlarmApiCallResult#isPropagationChanged()}.
   * <p>
   * Method under test: {@link AlarmApiCallResult#isPropagationChanged()}
   */
  @Test
  @DisplayName("Test isPropagationChanged()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmApiCallResult.isPropagationChanged()"})
  void testIsPropagationChanged() {
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
    AlarmBuilder customerIdResult = clearedResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertTrue((new AlarmApiCallResult(other, new ArrayList<>())).isPropagationChanged());
  }

  /**
   * Test {@link AlarmApiCallResult#isPropagationChanged()}.
   * <p>
   * Method under test: {@link AlarmApiCallResult#isPropagationChanged()}
   */
  @Test
  @DisplayName("Test isPropagationChanged()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmApiCallResult.isPropagationChanged()"})
  void testIsPropagationChanged2() {
    // Arrange
    AlarmApiCallResultBuilder builderResult = AlarmApiCallResult.builder();
    AlarmApiCallResultBuilder modifiedResult = builderResult.alarm(new AlarmInfo())
        .cleared(true)
        .created(false)
        .deleted(true)
        .modified(true);
    AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(true)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    AlarmBuilder customerIdResult = clearedResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertTrue((new AlarmApiCallResult(other, new ArrayList<>())).isPropagationChanged());
  }

  /**
   * Test {@link AlarmApiCallResult#isPropagationChanged()}.
   * <p>
   * Method under test: {@link AlarmApiCallResult#isPropagationChanged()}
   */
  @Test
  @DisplayName("Test isPropagationChanged()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmApiCallResult.isPropagationChanged()"})
  void testIsPropagationChanged3() {
    // Arrange
    AlarmApiCallResultBuilder builderResult = AlarmApiCallResult.builder();
    AlarmApiCallResultBuilder modifiedResult = builderResult.alarm(new AlarmInfo())
        .cleared(true)
        .created(false)
        .deleted(true)
        .modified(true);
    AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(true)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    AlarmBuilder customerIdResult = clearedResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AlarmBuilder propagateResult = customerIdResult.details(MissingNode.getInstance())
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
    AlarmApiCallResultBuilder oldResult = modifiedResult.old(old);
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertTrue((new AlarmApiCallResult(other, new ArrayList<>())).isPropagationChanged());
  }

  /**
   * Test {@link AlarmApiCallResult#isPropagationChanged()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmApiCallResult#isPropagationChanged()}
   */
  @Test
  @DisplayName("Test isPropagationChanged(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmApiCallResult.isPropagationChanged()"})
  void testIsPropagationChanged_thenReturnFalse() {
    // Arrange
    AlarmApiCallResultBuilder modifiedResult = AlarmApiCallResult.builder()
        .alarm(null)
        .cleared(true)
        .created(false)
        .deleted(true)
        .modified(true);
    AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(true)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    AlarmBuilder customerIdResult = clearedResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
    AlarmApiCallResult other = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();

    // Act and Assert
    assertFalse((new AlarmApiCallResult(other, new ArrayList<>())).isPropagationChanged());
  }
}
