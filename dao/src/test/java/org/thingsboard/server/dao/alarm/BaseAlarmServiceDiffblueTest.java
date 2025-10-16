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
package org.thingsboard.server.dao.alarm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.Alarm.AlarmBuilder;
import org.thingsboard.server.common.data.alarm.AlarmApiCallResult;
import org.thingsboard.server.common.data.alarm.AlarmApiCallResult.AlarmApiCallResultBuilder;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.alarm.AlarmQuery;
import org.thingsboard.server.common.data.alarm.AlarmQueryV2;
import org.thingsboard.server.common.data.alarm.AlarmSearchStatus;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.alarm.AlarmStatusFilter;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.common.data.query.AlarmCountQuery;
import org.thingsboard.server.common.data.query.AlarmDataQuery;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.validator.AlarmDataValidator;
import org.thingsboard.server.dao.sql.alarm.JpaAlarmDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BaseAlarmServiceDiffblueTest {
  @Mock private AlarmDao alarmDao;

  @InjectMocks private BaseAlarmService baseAlarmService;

  /**
   * Test {@link BaseAlarmService#acknowledgeAlarm(TenantId, AlarmId, long)}.
   *
   * <ul>
   *   <li>Then return not Successful.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#acknowledgeAlarm(TenantId, AlarmId, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmApiCallResult BaseAlarmService.acknowledgeAlarm(TenantId, AlarmId, long)"
  })
  public void testAcknowledgeAlarm_thenReturnNotSuccessful() {
    // Arrange
    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(null)
            .cleared(true)
            .created(true)
            .deleted(true)
            .modified(true);

    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .type("Type")
                .build());
    when(alarmDao.acknowledgeAlarm(Mockito.<TenantId>any(), Mockito.<AlarmId>any(), anyLong()))
        .thenReturn(oldResult.propagatedEntitiesList(new ArrayList<>()).successful(false).build());

    // Act
    AlarmApiCallResult actualAcknowledgeAlarmResult =
        baseAlarmService.acknowledgeAlarm(ModelConstants.SYSTEM_TENANT, null, 1L);

    // Assert
    verify(alarmDao).acknowledgeAlarm(isA(TenantId.class), isNull(), eq(1L));
    assertNull(actualAcknowledgeAlarmResult.getAlarm());
    assertNull(actualAcknowledgeAlarmResult.getOldSeverity());
    assertFalse(actualAcknowledgeAlarmResult.isAcknowledged());
    assertFalse(actualAcknowledgeAlarmResult.isSeverityChanged());
    assertFalse(actualAcknowledgeAlarmResult.isSuccessful());
    assertTrue(actualAcknowledgeAlarmResult.getPropagatedEntitiesList().isEmpty());
    assertTrue(actualAcknowledgeAlarmResult.isCleared());
    assertTrue(actualAcknowledgeAlarmResult.isCreated());
    assertTrue(actualAcknowledgeAlarmResult.isDeleted());
    assertTrue(actualAcknowledgeAlarmResult.isModified());
    assertTrue(actualAcknowledgeAlarmResult.isPropagationChanged());
  }

  /**
   * Test {@link BaseAlarmService#acknowledgeAlarm(TenantId, AlarmId, long)}.
   *
   * <ul>
   *   <li>Then return Successful.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#acknowledgeAlarm(TenantId, AlarmId, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmApiCallResult BaseAlarmService.acknowledgeAlarm(TenantId, AlarmId, long)"
  })
  public void testAcknowledgeAlarm_thenReturnSuccessful() {
    // Arrange
    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(null)
            .cleared(true)
            .created(true)
            .deleted(true)
            .modified(true);

    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .type("Type")
                .build());
    when(alarmDao.acknowledgeAlarm(Mockito.<TenantId>any(), Mockito.<AlarmId>any(), anyLong()))
        .thenReturn(oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build());

    // Act
    AlarmApiCallResult actualAcknowledgeAlarmResult =
        baseAlarmService.acknowledgeAlarm(ModelConstants.SYSTEM_TENANT, null, 1L);

    // Assert
    verify(alarmDao).acknowledgeAlarm(isA(TenantId.class), isNull(), eq(1L));
    assertNull(actualAcknowledgeAlarmResult.getAlarm());
    assertNull(actualAcknowledgeAlarmResult.getOldSeverity());
    assertFalse(actualAcknowledgeAlarmResult.isAcknowledged());
    assertFalse(actualAcknowledgeAlarmResult.isSeverityChanged());
    assertTrue(actualAcknowledgeAlarmResult.getPropagatedEntitiesList().isEmpty());
    assertTrue(actualAcknowledgeAlarmResult.isCleared());
    assertTrue(actualAcknowledgeAlarmResult.isCreated());
    assertTrue(actualAcknowledgeAlarmResult.isDeleted());
    assertTrue(actualAcknowledgeAlarmResult.isModified());
    assertTrue(actualAcknowledgeAlarmResult.isPropagationChanged());
    assertTrue(actualAcknowledgeAlarmResult.isSuccessful());
  }

  /**
   * Test {@link BaseAlarmService#acknowledgeAlarm(TenantId, AlarmId, long)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#acknowledgeAlarm(TenantId, AlarmId, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmApiCallResult BaseAlarmService.acknowledgeAlarm(TenantId, AlarmId, long)"
  })
  public void testAcknowledgeAlarm_thenThrowDataValidationException() {
    // Arrange
    when(alarmDao.acknowledgeAlarm(Mockito.<TenantId>any(), Mockito.<AlarmId>any(), anyLong()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAlarmService.acknowledgeAlarm(ModelConstants.SYSTEM_TENANT, null, 1L));
    verify(alarmDao).acknowledgeAlarm(isA(TenantId.class), isNull(), eq(1L));
  }

  /**
   * Test {@link BaseAlarmService#clearAlarm(TenantId, AlarmId, long, JsonNode)}.
   *
   * <p>Method under test: {@link BaseAlarmService#clearAlarm(TenantId, AlarmId, long, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmApiCallResult BaseAlarmService.clearAlarm(TenantId, AlarmId, long, JsonNode)"
  })
  public void testClearAlarm() {
    // Arrange
    when(alarmDao.clearAlarm(
            Mockito.<TenantId>any(), Mockito.<AlarmId>any(), anyLong(), Mockito.<JsonNode>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.clearAlarm(
                ModelConstants.SYSTEM_TENANT,
                null,
                1L,
                CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    verify(alarmDao).clearAlarm(isA(TenantId.class), isNull(), eq(1L), isA(JsonNode.class));
  }

  /**
   * Test {@link BaseAlarmService#clearAlarm(TenantId, AlarmId, long, JsonNode)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmInfo#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#clearAlarm(TenantId, AlarmId, long, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmApiCallResult BaseAlarmService.clearAlarm(TenantId, AlarmId, long, JsonNode)"
  })
  public void testClearAlarm_thenCallsGetId() {
    // Arrange
    AlarmInfo alarm = mock(AlarmInfo.class);
    when(alarm.getId()).thenThrow(new DataValidationException("An error occurred"));

    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(alarm)
            .cleared(true)
            .created(true)
            .deleted(true)
            .modified(true);

    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .type("Type")
                .build());
    when(alarmDao.clearAlarm(
            Mockito.<TenantId>any(), Mockito.<AlarmId>any(), anyLong(), Mockito.<JsonNode>any()))
        .thenReturn(oldResult.propagatedEntitiesList(new ArrayList<>()).successful(false).build());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.clearAlarm(
                ModelConstants.SYSTEM_TENANT,
                null,
                1L,
                CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    verify(alarm).getId();
    verify(alarmDao).clearAlarm(isA(TenantId.class), isNull(), eq(1L), isA(JsonNode.class));
  }

  /**
   * Test {@link BaseAlarmService#clearAlarm(TenantId, AlarmId, long, JsonNode)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmInfo#getOriginator()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#clearAlarm(TenantId, AlarmId, long, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmApiCallResult BaseAlarmService.clearAlarm(TenantId, AlarmId, long, JsonNode)"
  })
  public void testClearAlarm_thenCallsGetOriginator() {
    // Arrange
    AlarmInfo alarm = mock(AlarmInfo.class);
    when(alarm.getOriginator()).thenThrow(new DataValidationException("An error occurred"));

    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(alarm)
            .cleared(true)
            .created(true)
            .deleted(true)
            .modified(true);

    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .type("Type")
                .build());
    when(alarmDao.clearAlarm(
            Mockito.<TenantId>any(), Mockito.<AlarmId>any(), anyLong(), Mockito.<JsonNode>any()))
        .thenReturn(oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.clearAlarm(
                ModelConstants.SYSTEM_TENANT,
                null,
                1L,
                CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    verify(alarm).getOriginator();
    verify(alarmDao).clearAlarm(isA(TenantId.class), isNull(), eq(1L), isA(JsonNode.class));
  }

  /**
   * Test {@link BaseAlarmService#clearAlarm(TenantId, AlarmId, long, JsonNode)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmInfo#isPropagate()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#clearAlarm(TenantId, AlarmId, long, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmApiCallResult BaseAlarmService.clearAlarm(TenantId, AlarmId, long, JsonNode)"
  })
  public void testClearAlarm_thenCallsIsPropagate() {
    // Arrange
    AlarmInfo alarm = mock(AlarmInfo.class);
    when(alarm.isPropagate()).thenThrow(new DataValidationException("An error occurred"));

    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(alarm)
            .cleared(true)
            .created(false)
            .deleted(true)
            .modified(true);

    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .type("Type")
                .build());
    when(alarmDao.clearAlarm(
            Mockito.<TenantId>any(), Mockito.<AlarmId>any(), anyLong(), Mockito.<JsonNode>any()))
        .thenReturn(oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.clearAlarm(
                ModelConstants.SYSTEM_TENANT,
                null,
                1L,
                CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    verify(alarm).isPropagate();
    verify(alarmDao).clearAlarm(isA(TenantId.class), isNull(), eq(1L), isA(JsonNode.class));
  }

  /**
   * Test {@link BaseAlarmService#clearAlarm(TenantId, AlarmId, long, JsonNode)}.
   *
   * <ul>
   *   <li>Then return Alarm is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#clearAlarm(TenantId, AlarmId, long, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmApiCallResult BaseAlarmService.clearAlarm(TenantId, AlarmId, long, JsonNode)"
  })
  public void testClearAlarm_thenReturnAlarmIsNull() {
    // Arrange
    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(null)
            .cleared(true)
            .created(true)
            .deleted(true)
            .modified(true);

    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .type("Type")
                .build());
    when(alarmDao.clearAlarm(
            Mockito.<TenantId>any(), Mockito.<AlarmId>any(), anyLong(), Mockito.<JsonNode>any()))
        .thenReturn(oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build());

    // Act
    AlarmApiCallResult actualClearAlarmResult =
        baseAlarmService.clearAlarm(
            ModelConstants.SYSTEM_TENANT,
            null,
            1L,
            CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Assert
    verify(alarmDao).clearAlarm(isA(TenantId.class), isNull(), eq(1L), isA(JsonNode.class));
    assertNull(actualClearAlarmResult.getAlarm());
    assertNull(actualClearAlarmResult.getOldSeverity());
    assertFalse(actualClearAlarmResult.isAcknowledged());
    assertFalse(actualClearAlarmResult.isSeverityChanged());
    assertTrue(actualClearAlarmResult.getPropagatedEntitiesList().isEmpty());
    assertTrue(actualClearAlarmResult.isCleared());
    assertTrue(actualClearAlarmResult.isCreated());
    assertTrue(actualClearAlarmResult.isDeleted());
    assertTrue(actualClearAlarmResult.isModified());
    assertTrue(actualClearAlarmResult.isPropagationChanged());
    assertTrue(actualClearAlarmResult.isSuccessful());
  }

  /**
   * Test {@link BaseAlarmService#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then Details return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findLatestActiveByOriginatorAndType(TenantId,
   * EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Alarm BaseAlarmService.findLatestActiveByOriginatorAndType(TenantId, EntityId, String)"
  })
  public void testFindLatestActiveByOriginatorAndType_thenDetailsReturnObjectNode() {
    // Arrange
    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);
    when(alarmDao.findLatestActiveByOriginatorAndType(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any()))
        .thenReturn(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .type("Type")
                .build());
    CustomerId originator = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult =
        baseAlarmService.findLatestActiveByOriginatorAndType(
            ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(alarmDao)
        .findLatestActiveByOriginatorAndType(isA(TenantId.class), isA(EntityId.class), eq("Type"));
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.getDetails() instanceof ObjectNode);
    assertEquals("Type", actualFindLatestActiveByOriginatorAndTypeResult.getName());
    assertEquals("Type", actualFindLatestActiveByOriginatorAndTypeResult.getType());
    assertNull(actualFindLatestActiveByOriginatorAndTypeResult.getUuidId());
    assertNull(actualFindLatestActiveByOriginatorAndTypeResult.getId());
    assertNull(actualFindLatestActiveByOriginatorAndTypeResult.getDashboardId());
    assertNull(actualFindLatestActiveByOriginatorAndTypeResult.getAssigneeId());
    assertEquals(0L, actualFindLatestActiveByOriginatorAndTypeResult.getCreatedTime());
    assertEquals(1L, actualFindLatestActiveByOriginatorAndTypeResult.getAckTs());
    assertEquals(1L, actualFindLatestActiveByOriginatorAndTypeResult.getAssignTs());
    assertEquals(1L, actualFindLatestActiveByOriginatorAndTypeResult.getClearTs());
    assertEquals(1L, actualFindLatestActiveByOriginatorAndTypeResult.getEndTs());
    assertEquals(1L, actualFindLatestActiveByOriginatorAndTypeResult.getStartTs());
    assertEquals(
        AlarmSeverity.CRITICAL, actualFindLatestActiveByOriginatorAndTypeResult.getSeverity());
    assertEquals(
        AlarmStatus.CLEARED_ACK, actualFindLatestActiveByOriginatorAndTypeResult.getStatus());
    assertTrue(
        actualFindLatestActiveByOriginatorAndTypeResult.getPropagateRelationTypes().isEmpty());
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.isAcknowledged());
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.isCleared());
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.isPropagate());
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.isPropagateToOwner());
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.isPropagateToTenant());
    assertSame(
        TenantId.SYS_TENANT_ID, actualFindLatestActiveByOriginatorAndTypeResult.getTenantId());
    assertSame(originator, actualFindLatestActiveByOriginatorAndTypeResult.getCustomerId());
    assertSame(originator, actualFindLatestActiveByOriginatorAndTypeResult.getOriginator());
  }

  /**
   * Test {@link BaseAlarmService#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findLatestActiveByOriginatorAndType(TenantId,
   * EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Alarm BaseAlarmService.findLatestActiveByOriginatorAndType(TenantId, EntityId, String)"
  })
  public void testFindLatestActiveByOriginatorAndType_thenThrowDataValidationException() {
    // Arrange
    when(alarmDao.findLatestActiveByOriginatorAndType(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.findLatestActiveByOriginatorAndType(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type"));
    verify(alarmDao)
        .findLatestActiveByOriginatorAndType(isA(TenantId.class), isA(EntityId.class), eq("Type"));
  }

  /**
   * Test {@link BaseAlarmService#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery,
   * Collection)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmDataByQueryForEntities(TenantId,
   * AlarmDataQuery, Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAlarmService.findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)"
  })
  public void testFindAlarmDataByQueryForEntities_thenThrowDataValidationException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));
    AlarmDataQuery query = new AlarmDataQuery();

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAlarmService.findAlarmDataByQueryForEntities(tenantId, query, new ArrayList<>()));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAlarmService#delAlarm(TenantId, AlarmId)} with {@code tenantId}, {@code
   * alarmId}.
   *
   * <p>Method under test: {@link BaseAlarmService#delAlarm(TenantId, AlarmId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmApiCallResult BaseAlarmService.delAlarm(TenantId, AlarmId)"})
  public void testDelAlarmWithTenantIdAlarmId() {
    // Arrange
    when(alarmDao.findAlarmInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.delAlarm(
                ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID)));
    verify(alarmDao).findAlarmInfoById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAlarmService#delAlarm(TenantId, AlarmId, boolean)} with {@code tenantId},
   * {@code alarmId}, {@code checkAndDeleteAlarmType}.
   *
   * <p>Method under test: {@link BaseAlarmService#delAlarm(TenantId, AlarmId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmApiCallResult BaseAlarmService.delAlarm(TenantId, AlarmId, boolean)"})
  public void testDelAlarmWithTenantIdAlarmIdCheckAndDeleteAlarmType() {
    // Arrange
    when(alarmDao.findAlarmInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.delAlarm(
                ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID), true));
    verify(alarmDao).findAlarmInfoById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAlarmService#delAlarm(TenantId, AlarmId, boolean)} with {@code tenantId},
   * {@code alarmId}, {@code checkAndDeleteAlarmType}.
   *
   * <p>Method under test: {@link BaseAlarmService#delAlarm(TenantId, AlarmId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmApiCallResult BaseAlarmService.delAlarm(TenantId, AlarmId, boolean)"})
  public void testDelAlarmWithTenantIdAlarmIdCheckAndDeleteAlarmType2() {
    // Arrange
    when(alarmDao.findAlarmInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    AlarmApiCallResult actualDelAlarmResult =
        baseAlarmService.delAlarm(
            ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID), true);

    // Assert
    verify(alarmDao).findAlarmInfoById(isA(TenantId.class), isA(UUID.class));
    assertNull(actualDelAlarmResult.getPropagatedEntitiesList());
    assertNull(actualDelAlarmResult.getOld());
    assertNull(actualDelAlarmResult.getAlarm());
    assertNull(actualDelAlarmResult.getOldSeverity());
    assertFalse(actualDelAlarmResult.isAcknowledged());
    assertFalse(actualDelAlarmResult.isCleared());
    assertFalse(actualDelAlarmResult.isCreated());
    assertFalse(actualDelAlarmResult.isDeleted());
    assertFalse(actualDelAlarmResult.isModified());
    assertFalse(actualDelAlarmResult.isPropagationChanged());
    assertFalse(actualDelAlarmResult.isSeverityChanged());
    assertFalse(actualDelAlarmResult.isSuccessful());
  }

  /**
   * Test {@link BaseAlarmService#delAlarm(TenantId, AlarmId, boolean)} with {@code tenantId},
   * {@code alarmId}, {@code checkAndDeleteAlarmType}.
   *
   * <p>Method under test: {@link BaseAlarmService#delAlarm(TenantId, AlarmId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmApiCallResult BaseAlarmService.delAlarm(TenantId, AlarmId, boolean)"})
  public void testDelAlarmWithTenantIdAlarmIdCheckAndDeleteAlarmType3() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setPropagate(true);
    when(alarmDao.findEntityAlarmRecords(Mockito.<TenantId>any(), Mockito.<AlarmId>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(alarmDao.findAlarmInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(alarmInfo);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.delAlarm(
                ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID), true));
    verify(alarmDao).findAlarmInfoById(isA(TenantId.class), isA(UUID.class));
    verify(alarmDao).findEntityAlarmRecords(isNull(), isNull());
  }

  /**
   * Test {@link BaseAlarmService#delAlarm(TenantId, AlarmId, boolean)} with {@code tenantId},
   * {@code alarmId}, {@code checkAndDeleteAlarmType}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#delAlarm(TenantId, AlarmId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmApiCallResult BaseAlarmService.delAlarm(TenantId, AlarmId, boolean)"})
  public void testDelAlarmWithTenantIdAlarmIdCheckAndDeleteAlarmType_thenCallsRemoveById() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(alarmDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(alarmDao.findAlarmInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new AlarmInfo());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.delAlarm(
                ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID), true));
    verify(alarmDao).removeById(isA(TenantId.class), isNull());
    verify(alarmDao).findAlarmInfoById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAlarmService#delAlarm(TenantId, AlarmId)} with {@code tenantId}, {@code
   * alarmId}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmDao#findEntityAlarmRecords(TenantId, AlarmId)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#delAlarm(TenantId, AlarmId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmApiCallResult BaseAlarmService.delAlarm(TenantId, AlarmId)"})
  public void testDelAlarmWithTenantIdAlarmId_thenCallsFindEntityAlarmRecords() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setPropagate(true);
    when(alarmDao.findEntityAlarmRecords(Mockito.<TenantId>any(), Mockito.<AlarmId>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(alarmDao.findAlarmInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(alarmInfo);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.delAlarm(
                ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID)));
    verify(alarmDao).findAlarmInfoById(isA(TenantId.class), isA(UUID.class));
    verify(alarmDao).findEntityAlarmRecords(isNull(), isNull());
  }

  /**
   * Test {@link BaseAlarmService#delAlarm(TenantId, AlarmId)} with {@code tenantId}, {@code
   * alarmId}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#delAlarm(TenantId, AlarmId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmApiCallResult BaseAlarmService.delAlarm(TenantId, AlarmId)"})
  public void testDelAlarmWithTenantIdAlarmId_thenCallsRemoveById() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(alarmDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(alarmDao.findAlarmInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new AlarmInfo());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.delAlarm(
                ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID)));
    verify(alarmDao).removeById(isA(TenantId.class), isNull());
    verify(alarmDao).findAlarmInfoById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAlarmService#delAlarm(TenantId, AlarmId)} with {@code tenantId}, {@code
   * alarmId}.
   *
   * <ul>
   *   <li>Then return PropagatedEntitiesList is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#delAlarm(TenantId, AlarmId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmApiCallResult BaseAlarmService.delAlarm(TenantId, AlarmId)"})
  public void testDelAlarmWithTenantIdAlarmId_thenReturnPropagatedEntitiesListIsNull() {
    // Arrange
    when(alarmDao.findAlarmInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    AlarmApiCallResult actualDelAlarmResult =
        baseAlarmService.delAlarm(
            ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID));

    // Assert
    verify(alarmDao).findAlarmInfoById(isA(TenantId.class), isA(UUID.class));
    assertNull(actualDelAlarmResult.getPropagatedEntitiesList());
    assertNull(actualDelAlarmResult.getOld());
    assertNull(actualDelAlarmResult.getAlarm());
    assertNull(actualDelAlarmResult.getOldSeverity());
    assertFalse(actualDelAlarmResult.isAcknowledged());
    assertFalse(actualDelAlarmResult.isCleared());
    assertFalse(actualDelAlarmResult.isCreated());
    assertFalse(actualDelAlarmResult.isDeleted());
    assertFalse(actualDelAlarmResult.isModified());
    assertFalse(actualDelAlarmResult.isPropagationChanged());
    assertFalse(actualDelAlarmResult.isSeverityChanged());
    assertFalse(actualDelAlarmResult.isSuccessful());
  }

  /**
   * Test {@link BaseAlarmService#delAlarmTypes(TenantId, Set)}.
   *
   * <ul>
   *   <li>Given {@link AlarmDao} {@link AlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#delAlarmTypes(TenantId, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAlarmService.delAlarmTypes(TenantId, Set)"})
  public void testDelAlarmTypes_givenAlarmDaoRemoveAlarmTypesIfNoAlarmsPresentReturnFalse() {
    // Arrange
    when(alarmDao.removeAlarmTypesIfNoAlarmsPresent(
            Mockito.<UUID>any(), Mockito.<Set<String>>any()))
        .thenReturn(false);

    HashSet<String> types = new HashSet<>();
    types.add("foo");

    // Act
    baseAlarmService.delAlarmTypes(ModelConstants.SYSTEM_TENANT, types);

    // Assert
    verify(alarmDao).removeAlarmTypesIfNoAlarmsPresent(isA(UUID.class), isA(Set.class));
  }

  /**
   * Test {@link BaseAlarmService#delAlarmTypes(TenantId, Set)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#delAlarmTypes(TenantId, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAlarmService.delAlarmTypes(TenantId, Set)"})
  public void testDelAlarmTypes_thenThrowDataValidationException() {
    // Arrange
    when(alarmDao.removeAlarmTypesIfNoAlarmsPresent(
            Mockito.<UUID>any(), Mockito.<Set<String>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    HashSet<String> types = new HashSet<>();
    types.add("foo");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAlarmService.delAlarmTypes(ModelConstants.SYSTEM_TENANT, types));
    verify(alarmDao).removeAlarmTypesIfNoAlarmsPresent(isA(UUID.class), isA(Set.class));
  }

  /**
   * Test {@link BaseAlarmService#assignAlarm(TenantId, AlarmId, UserId, long)}.
   *
   * <p>Method under test: {@link BaseAlarmService#assignAlarm(TenantId, AlarmId, UserId, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmApiCallResult BaseAlarmService.assignAlarm(TenantId, AlarmId, UserId, long)"
  })
  public void testAssignAlarm() {
    // Arrange
    when(alarmDao.assignAlarm(
            Mockito.<TenantId>any(), Mockito.<AlarmId>any(), Mockito.<UserId>any(), anyLong()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAlarmService.assignAlarm(ModelConstants.SYSTEM_TENANT, null, null, 1L));
    verify(alarmDao).assignAlarm(isA(TenantId.class), isNull(), isNull(), eq(1L));
  }

  /**
   * Test {@link BaseAlarmService#assignAlarm(TenantId, AlarmId, UserId, long)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmInfo#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#assignAlarm(TenantId, AlarmId, UserId, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmApiCallResult BaseAlarmService.assignAlarm(TenantId, AlarmId, UserId, long)"
  })
  public void testAssignAlarm_thenCallsGetId() {
    // Arrange
    AlarmInfo alarm = mock(AlarmInfo.class);
    when(alarm.getId()).thenThrow(new DataValidationException("An error occurred"));

    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(alarm)
            .cleared(true)
            .created(true)
            .deleted(true)
            .modified(true);

    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .type("Type")
                .build());
    when(alarmDao.assignAlarm(
            Mockito.<TenantId>any(), Mockito.<AlarmId>any(), Mockito.<UserId>any(), anyLong()))
        .thenReturn(oldResult.propagatedEntitiesList(new ArrayList<>()).successful(false).build());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAlarmService.assignAlarm(ModelConstants.SYSTEM_TENANT, null, null, 1L));
    verify(alarm).getId();
    verify(alarmDao).assignAlarm(isA(TenantId.class), isNull(), isNull(), eq(1L));
  }

  /**
   * Test {@link BaseAlarmService#assignAlarm(TenantId, AlarmId, UserId, long)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmInfo#getOriginator()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#assignAlarm(TenantId, AlarmId, UserId, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmApiCallResult BaseAlarmService.assignAlarm(TenantId, AlarmId, UserId, long)"
  })
  public void testAssignAlarm_thenCallsGetOriginator() {
    // Arrange
    AlarmInfo alarm = mock(AlarmInfo.class);
    when(alarm.getOriginator()).thenThrow(new DataValidationException("An error occurred"));

    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(alarm)
            .cleared(true)
            .created(true)
            .deleted(true)
            .modified(true);

    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .type("Type")
                .build());
    when(alarmDao.assignAlarm(
            Mockito.<TenantId>any(), Mockito.<AlarmId>any(), Mockito.<UserId>any(), anyLong()))
        .thenReturn(oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAlarmService.assignAlarm(ModelConstants.SYSTEM_TENANT, null, null, 1L));
    verify(alarm).getOriginator();
    verify(alarmDao).assignAlarm(isA(TenantId.class), isNull(), isNull(), eq(1L));
  }

  /**
   * Test {@link BaseAlarmService#assignAlarm(TenantId, AlarmId, UserId, long)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmInfo#isPropagate()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#assignAlarm(TenantId, AlarmId, UserId, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmApiCallResult BaseAlarmService.assignAlarm(TenantId, AlarmId, UserId, long)"
  })
  public void testAssignAlarm_thenCallsIsPropagate() {
    // Arrange
    AlarmInfo alarm = mock(AlarmInfo.class);
    when(alarm.isPropagate()).thenThrow(new DataValidationException("An error occurred"));

    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(alarm)
            .cleared(true)
            .created(false)
            .deleted(true)
            .modified(true);

    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .type("Type")
                .build());
    when(alarmDao.assignAlarm(
            Mockito.<TenantId>any(), Mockito.<AlarmId>any(), Mockito.<UserId>any(), anyLong()))
        .thenReturn(oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAlarmService.assignAlarm(ModelConstants.SYSTEM_TENANT, null, null, 1L));
    verify(alarm).isPropagate();
    verify(alarmDao).assignAlarm(isA(TenantId.class), isNull(), isNull(), eq(1L));
  }

  /**
   * Test {@link BaseAlarmService#assignAlarm(TenantId, AlarmId, UserId, long)}.
   *
   * <ul>
   *   <li>Then return Alarm is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#assignAlarm(TenantId, AlarmId, UserId, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmApiCallResult BaseAlarmService.assignAlarm(TenantId, AlarmId, UserId, long)"
  })
  public void testAssignAlarm_thenReturnAlarmIsNull() {
    // Arrange
    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(null)
            .cleared(true)
            .created(true)
            .deleted(true)
            .modified(true);

    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .type("Type")
                .build());
    when(alarmDao.assignAlarm(
            Mockito.<TenantId>any(), Mockito.<AlarmId>any(), Mockito.<UserId>any(), anyLong()))
        .thenReturn(oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build());

    // Act
    AlarmApiCallResult actualAssignAlarmResult =
        baseAlarmService.assignAlarm(ModelConstants.SYSTEM_TENANT, null, null, 1L);

    // Assert
    verify(alarmDao).assignAlarm(isA(TenantId.class), isNull(), isNull(), eq(1L));
    assertNull(actualAssignAlarmResult.getAlarm());
    assertNull(actualAssignAlarmResult.getOldSeverity());
    assertFalse(actualAssignAlarmResult.isAcknowledged());
    assertFalse(actualAssignAlarmResult.isSeverityChanged());
    assertTrue(actualAssignAlarmResult.getPropagatedEntitiesList().isEmpty());
    assertTrue(actualAssignAlarmResult.isCleared());
    assertTrue(actualAssignAlarmResult.isCreated());
    assertTrue(actualAssignAlarmResult.isDeleted());
    assertTrue(actualAssignAlarmResult.isModified());
    assertTrue(actualAssignAlarmResult.isPropagationChanged());
    assertTrue(actualAssignAlarmResult.isSuccessful());
  }

  /**
   * Test {@link BaseAlarmService#unassignAlarm(TenantId, AlarmId, long)}.
   *
   * <ul>
   *   <li>Then return not Successful.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#unassignAlarm(TenantId, AlarmId, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmApiCallResult BaseAlarmService.unassignAlarm(TenantId, AlarmId, long)"})
  public void testUnassignAlarm_thenReturnNotSuccessful() {
    // Arrange
    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(null)
            .cleared(true)
            .created(true)
            .deleted(true)
            .modified(true);

    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .type("Type")
                .build());
    when(alarmDao.unassignAlarm(Mockito.<TenantId>any(), Mockito.<AlarmId>any(), anyLong()))
        .thenReturn(oldResult.propagatedEntitiesList(new ArrayList<>()).successful(false).build());

    // Act
    AlarmApiCallResult actualUnassignAlarmResult =
        baseAlarmService.unassignAlarm(ModelConstants.SYSTEM_TENANT, null, 1L);

    // Assert
    verify(alarmDao).unassignAlarm(isA(TenantId.class), isNull(), eq(1L));
    assertNull(actualUnassignAlarmResult.getAlarm());
    assertNull(actualUnassignAlarmResult.getOldSeverity());
    assertFalse(actualUnassignAlarmResult.isAcknowledged());
    assertFalse(actualUnassignAlarmResult.isSeverityChanged());
    assertFalse(actualUnassignAlarmResult.isSuccessful());
    assertTrue(actualUnassignAlarmResult.getPropagatedEntitiesList().isEmpty());
    assertTrue(actualUnassignAlarmResult.isCleared());
    assertTrue(actualUnassignAlarmResult.isCreated());
    assertTrue(actualUnassignAlarmResult.isDeleted());
    assertTrue(actualUnassignAlarmResult.isModified());
    assertTrue(actualUnassignAlarmResult.isPropagationChanged());
  }

  /**
   * Test {@link BaseAlarmService#unassignAlarm(TenantId, AlarmId, long)}.
   *
   * <ul>
   *   <li>Then return Successful.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#unassignAlarm(TenantId, AlarmId, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmApiCallResult BaseAlarmService.unassignAlarm(TenantId, AlarmId, long)"})
  public void testUnassignAlarm_thenReturnSuccessful() {
    // Arrange
    AlarmApiCallResultBuilder modifiedResult =
        AlarmApiCallResult.builder()
            .alarm(null)
            .cleared(true)
            .created(true)
            .deleted(true)
            .modified(true);

    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);

    AlarmApiCallResultBuilder oldResult =
        modifiedResult.old(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .type("Type")
                .build());
    when(alarmDao.unassignAlarm(Mockito.<TenantId>any(), Mockito.<AlarmId>any(), anyLong()))
        .thenReturn(oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build());

    // Act
    AlarmApiCallResult actualUnassignAlarmResult =
        baseAlarmService.unassignAlarm(ModelConstants.SYSTEM_TENANT, null, 1L);

    // Assert
    verify(alarmDao).unassignAlarm(isA(TenantId.class), isNull(), eq(1L));
    assertNull(actualUnassignAlarmResult.getAlarm());
    assertNull(actualUnassignAlarmResult.getOldSeverity());
    assertFalse(actualUnassignAlarmResult.isAcknowledged());
    assertFalse(actualUnassignAlarmResult.isSeverityChanged());
    assertTrue(actualUnassignAlarmResult.getPropagatedEntitiesList().isEmpty());
    assertTrue(actualUnassignAlarmResult.isCleared());
    assertTrue(actualUnassignAlarmResult.isCreated());
    assertTrue(actualUnassignAlarmResult.isDeleted());
    assertTrue(actualUnassignAlarmResult.isModified());
    assertTrue(actualUnassignAlarmResult.isPropagationChanged());
    assertTrue(actualUnassignAlarmResult.isSuccessful());
  }

  /**
   * Test {@link BaseAlarmService#unassignAlarm(TenantId, AlarmId, long)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#unassignAlarm(TenantId, AlarmId, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmApiCallResult BaseAlarmService.unassignAlarm(TenantId, AlarmId, long)"})
  public void testUnassignAlarm_thenThrowDataValidationException() {
    // Arrange
    when(alarmDao.unassignAlarm(Mockito.<TenantId>any(), Mockito.<AlarmId>any(), anyLong()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAlarmService.unassignAlarm(ModelConstants.SYSTEM_TENANT, null, 1L));
    verify(alarmDao).unassignAlarm(isA(TenantId.class), isNull(), eq(1L));
  }

  /**
   * Test {@link BaseAlarmService#findAlarmById(TenantId, AlarmId)}.
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmById(TenantId, AlarmId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm BaseAlarmService.findAlarmById(TenantId, AlarmId)"})
  public void testFindAlarmById() {
    // Arrange
    when(alarmDao.findAlarmById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.findAlarmById(
                ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID)));
    verify(alarmDao).findAlarmById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAlarmService#findAlarmById(TenantId, AlarmId)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmById(TenantId, AlarmId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm BaseAlarmService.findAlarmById(TenantId, AlarmId)"})
  public void testFindAlarmById_thenCallsGetId() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAlarmService.findAlarmById(ModelConstants.SYSTEM_TENANT, alarmId));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseAlarmService#findAlarmById(TenantId, AlarmId)}.
   *
   * <ul>
   *   <li>Then Details return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmById(TenantId, AlarmId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm BaseAlarmService.findAlarmById(TenantId, AlarmId)"})
  public void testFindAlarmById_thenDetailsReturnObjectNode() {
    // Arrange
    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);
    when(alarmDao.findAlarmById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .type("Type")
                .build());

    // Act
    Alarm actualFindAlarmByIdResult =
        baseAlarmService.findAlarmById(
            ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID));

    // Assert
    verify(alarmDao).findAlarmById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindAlarmByIdResult.getDetails() instanceof ObjectNode);
    assertEquals("Type", actualFindAlarmByIdResult.getName());
    assertEquals("Type", actualFindAlarmByIdResult.getType());
    assertNull(actualFindAlarmByIdResult.getUuidId());
    assertNull(actualFindAlarmByIdResult.getId());
    assertNull(actualFindAlarmByIdResult.getDashboardId());
    assertNull(actualFindAlarmByIdResult.getAssigneeId());
    assertEquals(0L, actualFindAlarmByIdResult.getCreatedTime());
    assertEquals(1L, actualFindAlarmByIdResult.getAckTs());
    assertEquals(1L, actualFindAlarmByIdResult.getAssignTs());
    assertEquals(1L, actualFindAlarmByIdResult.getClearTs());
    assertEquals(1L, actualFindAlarmByIdResult.getEndTs());
    assertEquals(1L, actualFindAlarmByIdResult.getStartTs());
    assertEquals(AlarmSeverity.CRITICAL, actualFindAlarmByIdResult.getSeverity());
    assertEquals(AlarmStatus.CLEARED_ACK, actualFindAlarmByIdResult.getStatus());
    assertTrue(actualFindAlarmByIdResult.getPropagateRelationTypes().isEmpty());
    assertTrue(actualFindAlarmByIdResult.isAcknowledged());
    assertTrue(actualFindAlarmByIdResult.isCleared());
    assertTrue(actualFindAlarmByIdResult.isPropagate());
    assertTrue(actualFindAlarmByIdResult.isPropagateToOwner());
    assertTrue(actualFindAlarmByIdResult.isPropagateToTenant());
    assertSame(TenantId.SYS_TENANT_ID, actualFindAlarmByIdResult.getTenantId());
  }

  /**
   * Test {@link BaseAlarmService#findAlarmByIdAsync(TenantId, AlarmId)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmByIdAsync(TenantId, AlarmId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseAlarmService.findAlarmByIdAsync(TenantId, AlarmId)"})
  public void testFindAlarmByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Alarm> createResult = SettableFuture.create();
    when(alarmDao.findAlarmByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Alarm> actualFindAlarmByIdAsyncResult =
        baseAlarmService.findAlarmByIdAsync(
            ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID));

    // Assert
    verify(alarmDao).findAlarmByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindAlarmByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAlarmByIdAsyncResult);
  }

  /**
   * Test {@link BaseAlarmService#findAlarmByIdAsync(TenantId, AlarmId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmByIdAsync(TenantId, AlarmId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseAlarmService.findAlarmByIdAsync(TenantId, AlarmId)"})
  public void testFindAlarmByIdAsync_thenThrowDataValidationException() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAlarmService.findAlarmByIdAsync(ModelConstants.SYSTEM_TENANT, alarmId));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseAlarmService#findAlarmInfoById(TenantId, AlarmId)}.
   *
   * <ul>
   *   <li>Then return {@link AlarmInfo#AlarmInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmInfoById(TenantId, AlarmId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo BaseAlarmService.findAlarmInfoById(TenantId, AlarmId)"})
  public void testFindAlarmInfoById_thenReturnAlarmInfo() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    when(alarmDao.findAlarmInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(alarmInfo);

    // Act
    AlarmInfo actualFindAlarmInfoByIdResult =
        baseAlarmService.findAlarmInfoById(
            ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID));

    // Assert
    verify(alarmDao).findAlarmInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(alarmInfo, actualFindAlarmInfoByIdResult);
  }

  /**
   * Test {@link BaseAlarmService#findAlarmInfoById(TenantId, AlarmId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmInfoById(TenantId, AlarmId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo BaseAlarmService.findAlarmInfoById(TenantId, AlarmId)"})
  public void testFindAlarmInfoById_thenThrowDataValidationException() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAlarmService.findAlarmInfoById(ModelConstants.SYSTEM_TENANT, alarmId));
    verify(alarmId).getId();
  }

  /**
   * Test {@link BaseAlarmService#findAlarms(TenantId, AlarmQuery)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAlarmService.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AlarmInfo> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findAlarms(Mockito.<TenantId>any(), Mockito.<AlarmQuery>any()))
        .thenReturn(emptyPageDataResult);
    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            new TimePageLink(3),
            AlarmSearchStatus.ANY,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        baseAlarmService.findAlarms(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(alarmDao).findAlarms(isA(TenantId.class), isA(AlarmQuery.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAlarmsResult);
  }

  /**
   * Test {@link BaseAlarmService#findAlarms(TenantId, AlarmQuery)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAlarmService.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms_thenThrowDataValidationException() {
    // Arrange
    when(alarmDao.findAlarms(Mockito.<TenantId>any(), Mockito.<AlarmQuery>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            new TimePageLink(3),
            AlarmSearchStatus.ANY,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAlarmService.findAlarms(ModelConstants.SYSTEM_TENANT, query));
    verify(alarmDao).findAlarms(isA(TenantId.class), isA(AlarmQuery.class));
  }

  /**
   * Test {@link BaseAlarmService#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findCustomerAlarms(TenantId, CustomerId,
   * AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAlarmService.findCustomerAlarms(TenantId, CustomerId, AlarmQuery)"
  })
  public void testFindCustomerAlarms_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AlarmInfo> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findCustomerAlarms(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<AlarmQuery>any()))
        .thenReturn(emptyPageDataResult);
    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            new TimePageLink(3),
            AlarmSearchStatus.ANY,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult =
        baseAlarmService.findCustomerAlarms(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(alarmDao)
        .findCustomerAlarms(isA(TenantId.class), isA(CustomerId.class), isA(AlarmQuery.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindCustomerAlarmsResult);
  }

  /**
   * Test {@link BaseAlarmService#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findCustomerAlarms(TenantId, CustomerId,
   * AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAlarmService.findCustomerAlarms(TenantId, CustomerId, AlarmQuery)"
  })
  public void testFindCustomerAlarms_thenThrowDataValidationException() {
    // Arrange
    when(alarmDao.findCustomerAlarms(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<AlarmQuery>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            new TimePageLink(3),
            AlarmSearchStatus.ANY,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.findCustomerAlarms(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(alarmDao)
        .findCustomerAlarms(isA(TenantId.class), isA(CustomerId.class), isA(AlarmQuery.class));
  }

  /**
   * Test {@link BaseAlarmService#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAlarmService.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AlarmInfo> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findAlarmsV2(Mockito.<TenantId>any(), Mockito.<AlarmQueryV2>any()))
        .thenReturn(emptyPageDataResult);
    TimePageLink pageLink = new TimePageLink(3);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            typeList,
            statusList,
            new ArrayList<>(),
            null);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        baseAlarmService.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(alarmDao).findAlarmsV2(isA(TenantId.class), isA(AlarmQueryV2.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAlarmsV2Result);
  }

  /**
   * Test {@link BaseAlarmService#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAlarmService.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2_thenThrowDataValidationException() {
    // Arrange
    when(alarmDao.findAlarmsV2(Mockito.<TenantId>any(), Mockito.<AlarmQueryV2>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    TimePageLink pageLink = new TimePageLink(3);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            typeList,
            statusList,
            new ArrayList<>(),
            null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAlarmService.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query));
    verify(alarmDao).findAlarmsV2(isA(TenantId.class), isA(AlarmQueryV2.class));
  }

  /**
   * Test {@link BaseAlarmService#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAlarmService.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AlarmInfo> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findCustomerAlarmsV2(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<AlarmQueryV2>any()))
        .thenReturn(emptyPageDataResult);
    TimePageLink pageLink = new TimePageLink(3);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            typeList,
            statusList,
            new ArrayList<>(),
            null);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsV2Result =
        baseAlarmService.findCustomerAlarmsV2(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(alarmDao)
        .findCustomerAlarmsV2(isA(TenantId.class), isA(CustomerId.class), isA(AlarmQueryV2.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindCustomerAlarmsV2Result);
  }

  /**
   * Test {@link BaseAlarmService#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAlarmService.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2_thenThrowDataValidationException() {
    // Arrange
    when(alarmDao.findCustomerAlarmsV2(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<AlarmQueryV2>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    TimePageLink pageLink = new TimePageLink(3);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            typeList,
            statusList,
            new ArrayList<>(),
            null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.findCustomerAlarmsV2(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(alarmDao)
        .findCustomerAlarmsV2(isA(TenantId.class), isA(CustomerId.class), isA(AlarmQueryV2.class));
  }

  /**
   * Test {@link BaseAlarmService#findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)}.
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmIdsByAssigneeId(TenantId, UserId, long,
   * AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseAlarmService.findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByAssigneeId() {
    // Arrange
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.findAlarmIdsByAssigneeId(
                ModelConstants.SYSTEM_TENANT, userId, 1L, null, 1));
    verify(userId).getId();
  }

  /**
   * Test {@link BaseAlarmService#findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)}.
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmIdsByAssigneeId(TenantId, UserId, long,
   * AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseAlarmService.findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByAssigneeId2() {
    // Arrange
    when(alarmDao.findAlarmIdsByAssigneeId(
            Mockito.<TenantId>any(),
            Mockito.<UserId>any(),
            anyLong(),
            Mockito.<AlarmId>any(),
            anyInt()))
        .thenThrow(new DataValidationException("An error occurred"));

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.findAlarmIdsByAssigneeId(
                ModelConstants.SYSTEM_TENANT, userId, 1L, null, 1));
    verify(userId).getId();
    verify(alarmDao)
        .findAlarmIdsByAssigneeId(isA(TenantId.class), isA(UserId.class), eq(1L), isNull(), eq(1));
  }

  /**
   * Test {@link BaseAlarmService#findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmIdsByAssigneeId(TenantId, UserId, long,
   * AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseAlarmService.findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByAssigneeId_thenReturnEmpty() {
    // Arrange
    PageData<TbPair<UUID, Long>> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findAlarmIdsByAssigneeId(
            Mockito.<TenantId>any(),
            Mockito.<UserId>any(),
            anyLong(),
            Mockito.<AlarmId>any(),
            anyInt()))
        .thenReturn(emptyPageDataResult);

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<TbPair<UUID, Long>> actualFindAlarmIdsByAssigneeIdResult =
        baseAlarmService.findAlarmIdsByAssigneeId(
            ModelConstants.SYSTEM_TENANT, userId, 1L, null, 1);

    // Assert
    verify(userId).getId();
    verify(alarmDao)
        .findAlarmIdsByAssigneeId(isA(TenantId.class), isA(UserId.class), eq(1L), isNull(), eq(1));
    assertTrue(actualFindAlarmIdsByAssigneeIdResult.isEmpty());
  }

  /**
   * Test {@link BaseAlarmService#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId,
   * int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmIdsByOriginatorId(TenantId, EntityId,
   * long, AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseAlarmService.findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByOriginatorId_thenReturnEmpty() {
    // Arrange
    PageData<TbPair<UUID, Long>> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findAlarmIdsByOriginatorId(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            anyLong(),
            Mockito.<AlarmId>any(),
            anyInt()))
        .thenReturn(emptyPageDataResult);

    // Act
    List<TbPair<UUID, Long>> actualFindAlarmIdsByOriginatorIdResult =
        baseAlarmService.findAlarmIdsByOriginatorId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, 1L, null, 1);

    // Assert
    verify(alarmDao)
        .findAlarmIdsByOriginatorId(
            isA(TenantId.class), isA(EntityId.class), eq(1L), isNull(), eq(1));
    assertTrue(actualFindAlarmIdsByOriginatorIdResult.isEmpty());
  }

  /**
   * Test {@link BaseAlarmService#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId,
   * int)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmIdsByOriginatorId(TenantId, EntityId,
   * long, AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseAlarmService.findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByOriginatorId_thenThrowDataValidationException() {
    // Arrange
    when(alarmDao.findAlarmIdsByOriginatorId(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            anyLong(),
            Mockito.<AlarmId>any(),
            anyInt()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.findAlarmIdsByOriginatorId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, 1L, null, 1));
    verify(alarmDao)
        .findAlarmIdsByOriginatorId(
            isA(TenantId.class), isA(EntityId.class), eq(1L), isNull(), eq(1));
  }

  /**
   * Test {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus,
   * AlarmStatus, String)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId,
   * AlarmSearchStatus, AlarmStatus, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmSeverity BaseAlarmService.findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus, AlarmStatus, String)"
  })
  public void testFindHighestAlarmSeverity_thenThrowDataValidationException() {
    // Arrange
    when(alarmDao.findAlarmSeverities(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AlarmStatusFilter>any(),
            Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.findHighestAlarmSeverity(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                AlarmSearchStatus.ANY,
                AlarmStatus.ACTIVE_UNACK,
                "42"));
    verify(alarmDao)
        .findAlarmSeverities(
            isA(TenantId.class), isA(EntityId.class), isA(AlarmStatusFilter.class), eq("42"));
  }

  /**
   * Test {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus,
   * AlarmStatus, String)}.
   *
   * <ul>
   *   <li>When {@code ACK}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId,
   * AlarmSearchStatus, AlarmStatus, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmSeverity BaseAlarmService.findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus, AlarmStatus, String)"
  })
  public void testFindHighestAlarmSeverity_whenAck_thenReturnNull() {
    // Arrange
    when(alarmDao.findAlarmSeverities(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AlarmStatusFilter>any(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    AlarmSeverity actualFindHighestAlarmSeverityResult =
        baseAlarmService.findHighestAlarmSeverity(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            "42");

    // Assert
    verify(alarmDao)
        .findAlarmSeverities(
            isA(TenantId.class), isA(EntityId.class), isA(AlarmStatusFilter.class), eq("42"));
    assertNull(actualFindHighestAlarmSeverityResult);
  }

  /**
   * Test {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus,
   * AlarmStatus, String)}.
   *
   * <ul>
   *   <li>When {@code ACTIVE_ACK}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId,
   * AlarmSearchStatus, AlarmStatus, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmSeverity BaseAlarmService.findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus, AlarmStatus, String)"
  })
  public void testFindHighestAlarmSeverity_whenActiveAck_thenReturnNull() {
    // Arrange
    when(alarmDao.findAlarmSeverities(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AlarmStatusFilter>any(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    AlarmSeverity actualFindHighestAlarmSeverityResult =
        baseAlarmService.findHighestAlarmSeverity(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            AlarmStatus.ACTIVE_ACK,
            "42");

    // Assert
    verify(alarmDao)
        .findAlarmSeverities(
            isA(TenantId.class), isA(EntityId.class), isA(AlarmStatusFilter.class), eq("42"));
    assertNull(actualFindHighestAlarmSeverityResult);
  }

  /**
   * Test {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus,
   * AlarmStatus, String)}.
   *
   * <ul>
   *   <li>When {@code ACTIVE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId,
   * AlarmSearchStatus, AlarmStatus, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmSeverity BaseAlarmService.findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus, AlarmStatus, String)"
  })
  public void testFindHighestAlarmSeverity_whenActive_thenReturnNull() {
    // Arrange
    when(alarmDao.findAlarmSeverities(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AlarmStatusFilter>any(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    AlarmSeverity actualFindHighestAlarmSeverityResult =
        baseAlarmService.findHighestAlarmSeverity(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AlarmSearchStatus.ACTIVE,
            AlarmStatus.ACTIVE_UNACK,
            "42");

    // Assert
    verify(alarmDao)
        .findAlarmSeverities(
            isA(TenantId.class), isA(EntityId.class), isA(AlarmStatusFilter.class), eq("42"));
    assertNull(actualFindHighestAlarmSeverityResult);
  }

  /**
   * Test {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus,
   * AlarmStatus, String)}.
   *
   * <ul>
   *   <li>When {@code ANY}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId,
   * AlarmSearchStatus, AlarmStatus, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmSeverity BaseAlarmService.findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus, AlarmStatus, String)"
  })
  public void testFindHighestAlarmSeverity_whenAny_thenReturnNull() {
    // Arrange
    when(alarmDao.findAlarmSeverities(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AlarmStatusFilter>any(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    AlarmSeverity actualFindHighestAlarmSeverityResult =
        baseAlarmService.findHighestAlarmSeverity(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AlarmSearchStatus.ANY,
            AlarmStatus.ACTIVE_UNACK,
            "42");

    // Assert
    verify(alarmDao)
        .findAlarmSeverities(
            isA(TenantId.class), isA(EntityId.class), isA(AlarmStatusFilter.class), eq("42"));
    assertNull(actualFindHighestAlarmSeverityResult);
  }

  /**
   * Test {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus,
   * AlarmStatus, String)}.
   *
   * <ul>
   *   <li>When {@code CLEARED_ACK}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId,
   * AlarmSearchStatus, AlarmStatus, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmSeverity BaseAlarmService.findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus, AlarmStatus, String)"
  })
  public void testFindHighestAlarmSeverity_whenClearedAck_thenReturnNull() {
    // Arrange
    when(alarmDao.findAlarmSeverities(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AlarmStatusFilter>any(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    AlarmSeverity actualFindHighestAlarmSeverityResult =
        baseAlarmService.findHighestAlarmSeverity(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            AlarmStatus.CLEARED_ACK,
            "42");

    // Assert
    verify(alarmDao)
        .findAlarmSeverities(
            isA(TenantId.class), isA(EntityId.class), isA(AlarmStatusFilter.class), eq("42"));
    assertNull(actualFindHighestAlarmSeverityResult);
  }

  /**
   * Test {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus,
   * AlarmStatus, String)}.
   *
   * <ul>
   *   <li>When {@code CLEARED_UNACK}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId,
   * AlarmSearchStatus, AlarmStatus, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmSeverity BaseAlarmService.findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus, AlarmStatus, String)"
  })
  public void testFindHighestAlarmSeverity_whenClearedUnack_thenReturnNull() {
    // Arrange
    when(alarmDao.findAlarmSeverities(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AlarmStatusFilter>any(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    AlarmSeverity actualFindHighestAlarmSeverityResult =
        baseAlarmService.findHighestAlarmSeverity(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            AlarmStatus.CLEARED_UNACK,
            "42");

    // Assert
    verify(alarmDao)
        .findAlarmSeverities(
            isA(TenantId.class), isA(EntityId.class), isA(AlarmStatusFilter.class), eq("42"));
    assertNull(actualFindHighestAlarmSeverityResult);
  }

  /**
   * Test {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus,
   * AlarmStatus, String)}.
   *
   * <ul>
   *   <li>When {@code CLEARED}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId,
   * AlarmSearchStatus, AlarmStatus, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmSeverity BaseAlarmService.findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus, AlarmStatus, String)"
  })
  public void testFindHighestAlarmSeverity_whenCleared_thenReturnNull() {
    // Arrange
    when(alarmDao.findAlarmSeverities(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AlarmStatusFilter>any(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    AlarmSeverity actualFindHighestAlarmSeverityResult =
        baseAlarmService.findHighestAlarmSeverity(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AlarmSearchStatus.CLEARED,
            AlarmStatus.ACTIVE_UNACK,
            "42");

    // Assert
    verify(alarmDao)
        .findAlarmSeverities(
            isA(TenantId.class), isA(EntityId.class), isA(AlarmStatusFilter.class), eq("42"));
    assertNull(actualFindHighestAlarmSeverityResult);
  }

  /**
   * Test {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus,
   * AlarmStatus, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId,
   * AlarmSearchStatus, AlarmStatus, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmSeverity BaseAlarmService.findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus, AlarmStatus, String)"
  })
  public void testFindHighestAlarmSeverity_whenNull_thenReturnNull() {
    // Arrange
    when(alarmDao.findAlarmSeverities(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AlarmStatusFilter>any(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    AlarmSeverity actualFindHighestAlarmSeverityResult =
        baseAlarmService.findHighestAlarmSeverity(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            AlarmStatus.ACTIVE_UNACK,
            "42");

    // Assert
    verify(alarmDao)
        .findAlarmSeverities(
            isA(TenantId.class), isA(EntityId.class), isA(AlarmStatusFilter.class), eq("42"));
    assertNull(actualFindHighestAlarmSeverityResult);
  }

  /**
   * Test {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus,
   * AlarmStatus, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId,
   * AlarmSearchStatus, AlarmStatus, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmSeverity BaseAlarmService.findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus, AlarmStatus, String)"
  })
  public void testFindHighestAlarmSeverity_whenNull_thenReturnNull2() {
    // Arrange
    when(alarmDao.findAlarmSeverities(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AlarmStatusFilter>any(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    AlarmSeverity actualFindHighestAlarmSeverityResult =
        baseAlarmService.findHighestAlarmSeverity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null, null, "42");

    // Assert
    verify(alarmDao)
        .findAlarmSeverities(
            isA(TenantId.class), isA(EntityId.class), isA(AlarmStatusFilter.class), eq("42"));
    assertNull(actualFindHighestAlarmSeverityResult);
  }

  /**
   * Test {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus,
   * AlarmStatus, String)}.
   *
   * <ul>
   *   <li>When {@code UNACK}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId,
   * AlarmSearchStatus, AlarmStatus, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AlarmSeverity BaseAlarmService.findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus, AlarmStatus, String)"
  })
  public void testFindHighestAlarmSeverity_whenUnack_thenReturnNull() {
    // Arrange
    when(alarmDao.findAlarmSeverities(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AlarmStatusFilter>any(),
            Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    AlarmSeverity actualFindHighestAlarmSeverityResult =
        baseAlarmService.findHighestAlarmSeverity(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AlarmSearchStatus.UNACK,
            AlarmStatus.ACTIVE_UNACK,
            "42");

    // Assert
    verify(alarmDao)
        .findAlarmSeverities(
            isA(TenantId.class), isA(EntityId.class), isA(AlarmStatusFilter.class), eq("42"));
    assertNull(actualFindHighestAlarmSeverityResult);
  }

  /**
   * Test {@link BaseAlarmService#deleteEntityAlarmRecords(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#deleteEntityAlarmRecords(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseAlarmService.deleteEntityAlarmRecords(TenantId, EntityId)"})
  public void testDeleteEntityAlarmRecords_thenReturnOne() {
    // Arrange
    when(alarmDao.deleteEntityAlarmRecords(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(1);

    // Act
    int actualDeleteEntityAlarmRecordsResult =
        baseAlarmService.deleteEntityAlarmRecords(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(alarmDao).deleteEntityAlarmRecords(isA(TenantId.class), isA(EntityId.class));
    assertEquals(1, actualDeleteEntityAlarmRecordsResult);
  }

  /**
   * Test {@link BaseAlarmService#deleteEntityAlarmRecords(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#deleteEntityAlarmRecords(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseAlarmService.deleteEntityAlarmRecords(TenantId, EntityId)"})
  public void testDeleteEntityAlarmRecords_thenThrowDataValidationException() {
    // Arrange
    when(alarmDao.deleteEntityAlarmRecords(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.deleteEntityAlarmRecords(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(alarmDao).deleteEntityAlarmRecords(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseAlarmService#deleteEntityAlarmRecordsByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link BaseAlarmService#deleteEntityAlarmRecordsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAlarmService.deleteEntityAlarmRecordsByTenantId(TenantId)"})
  public void testDeleteEntityAlarmRecordsByTenantId() {
    // Arrange
    doNothing().when(alarmDao).deleteEntityAlarmRecordsByTenantId(Mockito.<TenantId>any());

    // Act
    baseAlarmService.deleteEntityAlarmRecordsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(alarmDao).deleteEntityAlarmRecordsByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link BaseAlarmService#deleteEntityAlarmRecordsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#deleteEntityAlarmRecordsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAlarmService.deleteEntityAlarmRecordsByTenantId(TenantId)"})
  public void testDeleteEntityAlarmRecordsByTenantId_thenThrowDataValidationException() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(alarmDao)
        .deleteEntityAlarmRecordsByTenantId(Mockito.<TenantId>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAlarmService.deleteEntityAlarmRecordsByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(alarmDao).deleteEntityAlarmRecordsByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link BaseAlarmService#countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)}.
   *
   * <p>Method under test: {@link BaseAlarmService#countAlarmsByQuery(TenantId, CustomerId,
   * AlarmCountQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long BaseAlarmService.countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)"
  })
  public void testCountAlarmsByQuery() {
    // Arrange
    when(alarmDao.countAlarmsByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<AlarmCountQuery>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.countAlarmsByQuery(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new AlarmCountQuery()));
    verify(alarmDao)
        .countAlarmsByQuery(isA(TenantId.class), isA(CustomerId.class), isA(AlarmCountQuery.class));
  }

  /**
   * Test {@link BaseAlarmService#countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#countAlarmsByQuery(TenantId, CustomerId,
   * AlarmCountQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long BaseAlarmService.countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)"
  })
  public void testCountAlarmsByQuery_thenCallsGetId() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.countAlarmsByQuery(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, new AlarmCountQuery()));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAlarmService#countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#countAlarmsByQuery(TenantId, CustomerId,
   * AlarmCountQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long BaseAlarmService.countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)"
  })
  public void testCountAlarmsByQuery_thenReturnThree() {
    // Arrange
    when(alarmDao.countAlarmsByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<AlarmCountQuery>any()))
        .thenReturn(3L);

    // Act
    long actualCountAlarmsByQueryResult =
        baseAlarmService.countAlarmsByQuery(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new AlarmCountQuery());

    // Assert
    verify(alarmDao)
        .countAlarmsByQuery(isA(TenantId.class), isA(CustomerId.class), isA(AlarmCountQuery.class));
    assertEquals(3L, actualCountAlarmsByQueryResult);
  }

  /**
   * Test {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAlarmService.findAlarmTypesByTenantId(TenantId, PageLink)"})
  public void testFindAlarmTypesByTenantId() {
    // Arrange
    when(alarmDao.findTenantAlarmTypes(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.findAlarmTypesByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(alarmDao).findTenantAlarmTypes(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAlarmService.findAlarmTypesByTenantId(TenantId, PageLink)"})
  public void testFindAlarmTypesByTenantId_thenCallsGetId() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.findAlarmTypesByTenantId(
                tenantId, BaseRelatedEdgesService.FIRST_PAGE));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAlarmService.findAlarmTypesByTenantId(TenantId, PageLink)"})
  public void testFindAlarmTypesByTenantId_whenNull_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EntitySubtype> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findTenantAlarmTypes(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntitySubtype> actualFindAlarmTypesByTenantIdResult =
        baseAlarmService.findAlarmTypesByTenantId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(alarmDao).findTenantAlarmTypes(isA(UUID.class), isNull());
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAlarmTypesByTenantIdResult);
  }

  /**
   * Test {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAlarmService.findAlarmTypesByTenantId(TenantId, PageLink)"})
  public void testFindAlarmTypesByTenantId_whenSystem_tenant_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EntitySubtype> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findTenantAlarmTypes(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntitySubtype> actualFindAlarmTypesByTenantIdResult =
        baseAlarmService.findAlarmTypesByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmDao).findTenantAlarmTypes(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAlarmTypesByTenantIdResult);
  }

  /**
   * Test {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link TimePageLink#TimePageLink(int)} with pageSize is three.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAlarmService.findAlarmTypesByTenantId(TenantId, PageLink)"})
  public void testFindAlarmTypesByTenantId_whenTimePageLinkWithPageSizeIsThree() {
    // Arrange
    PageData<EntitySubtype> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findTenantAlarmTypes(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EntitySubtype> actualFindAlarmTypesByTenantIdResult =
        baseAlarmService.findAlarmTypesByTenantId(
            ModelConstants.SYSTEM_TENANT, new TimePageLink(3));

    // Assert
    verify(alarmDao).findTenantAlarmTypes(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAlarmTypesByTenantIdResult);
  }

  /**
   * Test {@link BaseAlarmService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then {@link Optional#get()} return {@link Alarm}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseAlarmService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenGetReturnAlarm() {
    // Arrange
    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);
    when(alarmDao.findAlarmById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(
            propagateResult
                .propagateRelationTypes(new ArrayList<>())
                .propagateToOwner(true)
                .propagateToTenant(true)
                .severity(AlarmSeverity.CRITICAL)
                .startTs(1L)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .type("Type")
                .build());

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        baseAlarmService.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(alarmDao).findAlarmById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.get() instanceof Alarm);
    assertTrue(actualFindEntityResult.isPresent());
  }

  /**
   * Test {@link BaseAlarmService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseAlarmService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_whenNull_customer_id_thenThrowDataValidationException() {
    // Arrange
    when(alarmDao.findAlarmById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAlarmService.findEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(alarmDao).findAlarmById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAlarmService#getEntityType()}.
   *
   * <p>Method under test: {@link BaseAlarmService#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType BaseAlarmService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    TenantServiceImpl tenantService = new TenantServiceImpl();
    JpaAlarmDao alarmDao = new JpaAlarmDao();
    BaseEntityService entityService = new BaseEntityService();

    BaseAlarmService baseAlarmService =
        new BaseAlarmService(
            tenantService,
            alarmDao,
            entityService,
            new AlarmDataValidator(new TenantServiceImpl()));

    // Act and Assert
    assertEquals(EntityType.ALARM, baseAlarmService.getEntityType());
  }
}
