package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
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
   *
   * <p>Method under test: {@link AlarmApiCallResult#isSeverityChanged()}
   */
  @Test
  @DisplayName("Test isSeverityChanged()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmApiCallResult.isSeverityChanged()"})
  void testIsSeverityChanged() {
    // Arrange
    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(null)
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

    AlarmBuilder propagateResult =
        clearedResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .details(DoubleNode.valueOf(10.0d))
            .endTs(1L)
            .originator(TenantId.SYS_TENANT_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(TenantId.SYS_TENANT_ID)
                .type("Type")
                .build());
    AlarmApiCallResult other =
        oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    AlarmApiCallResult alarmApiCallResult = new AlarmApiCallResult(other, new ArrayList<>());

    // Act and Assert
    assertFalse(alarmApiCallResult.isSeverityChanged());
  }

  /**
   * Test {@link AlarmApiCallResult#isSeverityChanged()}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfo#AlarmInfo()} Severity is {@code CRITICAL}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmApiCallResult#isSeverityChanged()}
   */
  @Test
  @DisplayName(
      "Test isSeverityChanged(); given AlarmInfo() Severity is 'CRITICAL'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmApiCallResult.isSeverityChanged()"})
  void testIsSeverityChanged_givenAlarmInfoSeverityIsCritical_thenReturnFalse() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();
    alarm.setSeverity(AlarmSeverity.CRITICAL);

    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(alarm)
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

    AlarmBuilder propagateResult =
        clearedResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .details(DoubleNode.valueOf(10.0d))
            .endTs(1L)
            .originator(TenantId.SYS_TENANT_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(TenantId.SYS_TENANT_ID)
                .type("Type")
                .build());
    AlarmApiCallResult other =
        oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    AlarmApiCallResult alarmApiCallResult = new AlarmApiCallResult(other, new ArrayList<>());

    // Act and Assert
    assertFalse(alarmApiCallResult.isSeverityChanged());
  }

  /**
   * Test {@link AlarmApiCallResult#isSeverityChanged()}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfo#AlarmInfo()} Severity is {@code MAJOR}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmApiCallResult#isSeverityChanged()}
   */
  @Test
  @DisplayName(
      "Test isSeverityChanged(); given AlarmInfo() Severity is 'MAJOR'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmApiCallResult.isSeverityChanged()"})
  void testIsSeverityChanged_givenAlarmInfoSeverityIsMajor_thenReturnTrue() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();
    alarm.setSeverity(AlarmSeverity.MAJOR);

    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(alarm)
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

    AlarmBuilder propagateResult =
        clearedResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .details(DoubleNode.valueOf(10.0d))
            .endTs(1L)
            .originator(TenantId.SYS_TENANT_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(TenantId.SYS_TENANT_ID)
                .type("Type")
                .build());
    AlarmApiCallResult other =
        oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    AlarmApiCallResult alarmApiCallResult = new AlarmApiCallResult(other, new ArrayList<>());

    // Act and Assert
    assertTrue(alarmApiCallResult.isSeverityChanged());
  }

  /**
   * Test {@link AlarmApiCallResult#isAcknowledged()}.
   *
   * <p>Method under test: {@link AlarmApiCallResult#isAcknowledged()}
   */
  @Test
  @DisplayName("Test isAcknowledged()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmApiCallResult.isAcknowledged()"})
  void testIsAcknowledged() {
    // Arrange
    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(null)
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

    AlarmBuilder propagateResult =
        clearedResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .details(DoubleNode.valueOf(10.0d))
            .endTs(1L)
            .originator(TenantId.SYS_TENANT_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(TenantId.SYS_TENANT_ID)
                .type("Type")
                .build());
    AlarmApiCallResult other =
        oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    AlarmApiCallResult alarmApiCallResult = new AlarmApiCallResult(other, new ArrayList<>());

    // Act and Assert
    assertFalse(alarmApiCallResult.isAcknowledged());
  }

  /**
   * Test {@link AlarmApiCallResult#isAcknowledged()}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfo#AlarmInfo()} Acknowledged is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmApiCallResult#isAcknowledged()}
   */
  @Test
  @DisplayName(
      "Test isAcknowledged(); given AlarmInfo() Acknowledged is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmApiCallResult.isAcknowledged()"})
  void testIsAcknowledged_givenAlarmInfoAcknowledgedIsTrue_thenReturnFalse() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();
    alarm.setAcknowledged(true);

    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(alarm)
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

    AlarmBuilder propagateResult =
        clearedResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .details(DoubleNode.valueOf(10.0d))
            .endTs(1L)
            .originator(TenantId.SYS_TENANT_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(TenantId.SYS_TENANT_ID)
                .type("Type")
                .build());
    AlarmApiCallResult other =
        oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    AlarmApiCallResult alarmApiCallResult = new AlarmApiCallResult(other, new ArrayList<>());

    // Act and Assert
    assertFalse(alarmApiCallResult.isAcknowledged());
  }

  /**
   * Test {@link AlarmApiCallResult#isAcknowledged()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmApiCallResult#isAcknowledged()}
   */
  @Test
  @DisplayName("Test isAcknowledged(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmApiCallResult.isAcknowledged()"})
  void testIsAcknowledged_thenReturnTrue() {
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

    AlarmBuilder propagateResult =
        clearedResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .details(DoubleNode.valueOf(10.0d))
            .endTs(1L)
            .originator(TenantId.SYS_TENANT_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(TenantId.SYS_TENANT_ID)
                .type("Type")
                .build());
    AlarmApiCallResult other =
        oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    AlarmApiCallResult alarmApiCallResult = new AlarmApiCallResult(other, new ArrayList<>());

    // Act and Assert
    assertTrue(alarmApiCallResult.isAcknowledged());
  }

  /**
   * Test {@link AlarmApiCallResult#getOldSeverity()}.
   *
   * <p>Method under test: {@link AlarmApiCallResult#getOldSeverity()}
   */
  @Test
  @DisplayName("Test getOldSeverity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmSeverity AlarmApiCallResult.getOldSeverity()"})
  void testGetOldSeverity() {
    // Arrange
    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(null)
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

    AlarmBuilder propagateResult =
        clearedResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .details(DoubleNode.valueOf(10.0d))
            .endTs(1L)
            .originator(TenantId.SYS_TENANT_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(TenantId.SYS_TENANT_ID)
                .type("Type")
                .build());
    AlarmApiCallResult other =
        oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    AlarmApiCallResult alarmApiCallResult = new AlarmApiCallResult(other, new ArrayList<>());

    // Act and Assert
    assertNull(alarmApiCallResult.getOldSeverity());
  }

  /**
   * Test {@link AlarmApiCallResult#getOldSeverity()}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfo#AlarmInfo()} Severity is {@code CRITICAL}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmApiCallResult#getOldSeverity()}
   */
  @Test
  @DisplayName(
      "Test getOldSeverity(); given AlarmInfo() Severity is 'CRITICAL'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmSeverity AlarmApiCallResult.getOldSeverity()"})
  void testGetOldSeverity_givenAlarmInfoSeverityIsCritical_thenReturnNull() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();
    alarm.setSeverity(AlarmSeverity.CRITICAL);

    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(alarm)
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

    AlarmBuilder propagateResult =
        clearedResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .details(DoubleNode.valueOf(10.0d))
            .endTs(1L)
            .originator(TenantId.SYS_TENANT_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(TenantId.SYS_TENANT_ID)
                .type("Type")
                .build());
    AlarmApiCallResult other =
        oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    AlarmApiCallResult alarmApiCallResult = new AlarmApiCallResult(other, new ArrayList<>());

    // Act and Assert
    assertNull(alarmApiCallResult.getOldSeverity());
  }

  /**
   * Test {@link AlarmApiCallResult#getOldSeverity()}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfo#AlarmInfo()} Severity is {@code MAJOR}.
   *   <li>Then return {@code CRITICAL}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmApiCallResult#getOldSeverity()}
   */
  @Test
  @DisplayName(
      "Test getOldSeverity(); given AlarmInfo() Severity is 'MAJOR'; then return 'CRITICAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmSeverity AlarmApiCallResult.getOldSeverity()"})
  void testGetOldSeverity_givenAlarmInfoSeverityIsMajor_thenReturnCritical() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();
    alarm.setSeverity(AlarmSeverity.MAJOR);

    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(alarm)
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

    AlarmBuilder propagateResult =
        clearedResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .details(DoubleNode.valueOf(10.0d))
            .endTs(1L)
            .originator(TenantId.SYS_TENANT_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(TenantId.SYS_TENANT_ID)
                .type("Type")
                .build());
    AlarmApiCallResult other =
        oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    AlarmApiCallResult alarmApiCallResult = new AlarmApiCallResult(other, new ArrayList<>());

    // Act and Assert
    assertEquals(AlarmSeverity.CRITICAL, alarmApiCallResult.getOldSeverity());
  }

  /**
   * Test {@link AlarmApiCallResult#isPropagationChanged()}.
   *
   * <p>Method under test: {@link AlarmApiCallResult#isPropagationChanged()}
   */
  @Test
  @DisplayName("Test isPropagationChanged()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmApiCallResult.isPropagationChanged()"})
  void testIsPropagationChanged() {
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

    AlarmBuilder propagateResult =
        clearedResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .details(DoubleNode.valueOf(10.0d))
            .endTs(1L)
            .originator(TenantId.SYS_TENANT_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(TenantId.SYS_TENANT_ID)
                .type("Type")
                .build());
    AlarmApiCallResult other =
        oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    AlarmApiCallResult alarmApiCallResult = new AlarmApiCallResult(other, new ArrayList<>());

    // Act and Assert
    assertTrue(alarmApiCallResult.isPropagationChanged());
  }

  /**
   * Test {@link AlarmApiCallResult#isPropagationChanged()}.
   *
   * <p>Method under test: {@link AlarmApiCallResult#isPropagationChanged()}
   */
  @Test
  @DisplayName("Test isPropagationChanged()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmApiCallResult.isPropagationChanged()"})
  void testIsPropagationChanged2() {
    // Arrange
    AlarmApiCallResultBuilder builderResult = AlarmApiCallResult.builder();

    AlarmApiCallResultBuilder modifiedResult =
        builderResult
            .alarm(new AlarmInfo())
            .cleared(true)
            .created(false)
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

    AlarmBuilder propagateResult =
        clearedResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .details(DoubleNode.valueOf(10.0d))
            .endTs(1L)
            .originator(TenantId.SYS_TENANT_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(TenantId.SYS_TENANT_ID)
                .type("Type")
                .build());
    AlarmApiCallResult other =
        oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    AlarmApiCallResult alarmApiCallResult = new AlarmApiCallResult(other, new ArrayList<>());

    // Act and Assert
    assertTrue(alarmApiCallResult.isPropagationChanged());
  }

  /**
   * Test {@link AlarmApiCallResult#isPropagationChanged()}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfo#AlarmInfo()} Propagate is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmApiCallResult#isPropagationChanged()}
   */
  @Test
  @DisplayName(
      "Test isPropagationChanged(); given AlarmInfo() Propagate is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmApiCallResult.isPropagationChanged()"})
  void testIsPropagationChanged_givenAlarmInfoPropagateIsTrue_thenReturnTrue() {
    // Arrange
    AlarmInfo alarm = new AlarmInfo();
    alarm.setPropagate(true);

    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(alarm)
            .cleared(true)
            .created(false)
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

    AlarmBuilder propagateResult =
        clearedResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .details(DoubleNode.valueOf(10.0d))
            .endTs(1L)
            .originator(TenantId.SYS_TENANT_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(TenantId.SYS_TENANT_ID)
                .type("Type")
                .build());
    AlarmApiCallResult other =
        oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    AlarmApiCallResult alarmApiCallResult = new AlarmApiCallResult(other, new ArrayList<>());

    // Act and Assert
    assertTrue(alarmApiCallResult.isPropagationChanged());
  }

  /**
   * Test {@link AlarmApiCallResult#isPropagationChanged()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmApiCallResult#isPropagationChanged()}
   */
  @Test
  @DisplayName("Test isPropagationChanged(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmApiCallResult.isPropagationChanged()"})
  void testIsPropagationChanged_thenReturnFalse() {
    // Arrange
    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(null)
            .cleared(true)
            .created(false)
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

    AlarmBuilder propagateResult =
        clearedResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .details(DoubleNode.valueOf(10.0d))
            .endTs(1L)
            .originator(TenantId.SYS_TENANT_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(TenantId.SYS_TENANT_ID)
                .type("Type")
                .build());
    AlarmApiCallResult other =
        oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    AlarmApiCallResult alarmApiCallResult = new AlarmApiCallResult(other, new ArrayList<>());

    // Act and Assert
    assertFalse(alarmApiCallResult.isPropagationChanged());
  }
}
