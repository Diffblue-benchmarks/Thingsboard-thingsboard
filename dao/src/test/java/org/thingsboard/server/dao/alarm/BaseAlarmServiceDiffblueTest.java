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
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.AlarmApiCallResult;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.alarm.AlarmQuery;
import org.thingsboard.server.common.data.alarm.AlarmSearchStatus;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.alarm.AlarmStatusFilter;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.common.data.query.AlarmCountQuery;
import org.thingsboard.server.common.data.query.AlarmData;
import org.thingsboard.server.common.data.query.AlarmDataPageLink;
import org.thingsboard.server.common.data.query.AlarmDataQuery;
import org.thingsboard.server.common.data.query.EntityDataSortOrder;
import org.thingsboard.server.common.data.query.EntityFilter;
import org.thingsboard.server.common.data.query.EntityKey;
import org.thingsboard.server.common.data.query.EntityKeyType;
import org.thingsboard.server.common.data.query.KeyFilter;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.validator.AlarmDataValidator;
import org.thingsboard.server.dao.sql.alarm.JpaAlarmDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

public class BaseAlarmServiceDiffblueTest {
  /**
   * Test {@link BaseAlarmService#acknowledgeAlarm(TenantId, AlarmId, long)}.
   * <ul>
   *   <li>Then Old Details iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#acknowledgeAlarm(TenantId, AlarmId, long)}
   */
  @Test
  public void testAcknowledgeAlarm_thenOldDetailsIteratorNextReturnBooleanNode() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmApiCallResult.AlarmApiCallResultBuilder alarmApiCallResultBuilder = mock(
        AlarmApiCallResult.AlarmApiCallResultBuilder.class);
    when(alarmApiCallResultBuilder.modified(anyBoolean())).thenReturn(AlarmApiCallResult.builder());
    AlarmApiCallResult.AlarmApiCallResultBuilder alarmApiCallResultBuilder2 = mock(
        AlarmApiCallResult.AlarmApiCallResultBuilder.class);
    when(alarmApiCallResultBuilder2.deleted(anyBoolean())).thenReturn(alarmApiCallResultBuilder);
    AlarmApiCallResult.AlarmApiCallResultBuilder alarmApiCallResultBuilder3 = mock(
        AlarmApiCallResult.AlarmApiCallResultBuilder.class);
    when(alarmApiCallResultBuilder3.created(anyBoolean())).thenReturn(alarmApiCallResultBuilder2);
    AlarmApiCallResult.AlarmApiCallResultBuilder alarmApiCallResultBuilder4 = mock(
        AlarmApiCallResult.AlarmApiCallResultBuilder.class);
    when(alarmApiCallResultBuilder4.cleared(anyBoolean())).thenReturn(alarmApiCallResultBuilder3);
    AlarmApiCallResult.AlarmApiCallResultBuilder alarmApiCallResultBuilder5 = mock(
        AlarmApiCallResult.AlarmApiCallResultBuilder.class);
    when(alarmApiCallResultBuilder5.alarm(Mockito.<AlarmInfo>any())).thenReturn(alarmApiCallResultBuilder4);
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = alarmApiCallResultBuilder5.alarm(new AlarmInfo())
        .cleared(true)
        .created(true)
        .deleted(true)
        .modified(true);
    Alarm.AlarmBuilder alarmBuilder = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder.assignTs(anyLong())).thenReturn(Alarm.builder());
    Alarm.AlarmBuilder alarmBuilder2 = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder2.acknowledged(anyBoolean())).thenReturn(alarmBuilder);
    Alarm.AlarmBuilder alarmBuilder3 = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder3.ackTs(anyLong())).thenReturn(alarmBuilder2);
    Alarm.AlarmBuilder propagateResult = alarmBuilder3.ackTs(1L)
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
    Alarm old = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .severity(AlarmSeverity.CRITICAL)
        .startTs(1L)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .type("Type")
        .build();
    AlarmApiCallResult.AlarmApiCallResultBuilder oldResult = modifiedResult.old(old);
    AlarmApiCallResult buildResult = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    when(alarmDao.acknowledgeAlarm(Mockito.<TenantId>any(), Mockito.<AlarmId>any(), anyLong())).thenReturn(buildResult);
    TenantServiceImpl tenantService = mock(TenantServiceImpl.class);
    BaseEntityService entityService = new BaseEntityService();
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    AlarmApiCallResult actualAcknowledgeAlarmResult = (new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()))).acknowledgeAlarm(tenantId, null, 1L);

    // Assert
    verify(alarmBuilder3).ackTs(eq(1L));
    verify(alarmBuilder2).acknowledged(eq(true));
    verify(alarmBuilder).assignTs(eq(1L));
    verify(alarmApiCallResultBuilder5).alarm(isA(AlarmInfo.class));
    verify(alarmApiCallResultBuilder4).cleared(eq(true));
    verify(alarmApiCallResultBuilder3).created(eq(true));
    verify(alarmApiCallResultBuilder2).deleted(eq(true));
    verify(alarmApiCallResultBuilder).modified(eq(true));
    verify(alarmDao).acknowledgeAlarm(isA(TenantId.class), isNull(), eq(1L));
    Alarm old2 = actualAcknowledgeAlarmResult.getOld();
    JsonNode details = old2.getDetails();
    Iterator<JsonNode> iteratorResult = details.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(details instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = details.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Type", old2.getName());
    assertEquals("Type", old2.getType());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", details.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(old2.getUuidId());
    assertNull(actualAcknowledgeAlarmResult.getAlarm());
    assertNull(actualAcknowledgeAlarmResult.getOldSeverity());
    assertNull(old2.getId());
    assertNull(old2.getDashboardId());
    assertNull(old2.getAssigneeId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, old2.getAckTs());
    assertEquals(0L, old2.getAssignTs());
    assertEquals(0L, old2.getCreatedTime());
    assertEquals(1, details.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, old2.getClearTs());
    assertEquals(1L, old2.getEndTs());
    assertEquals(1L, old2.getStartTs());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, details.getNodeType());
    assertEquals(AlarmSeverity.CRITICAL, old2.getSeverity());
    assertEquals(AlarmStatus.CLEARED_UNACK, old2.getStatus());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(details.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(details.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(details.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(details.isBinary());
    assertFalse(details.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(details.isDouble());
    assertFalse(details.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(details.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(details.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(details.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(details.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(details.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(details.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(details.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(details.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(details.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(details.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(details.isTextual());
    assertFalse(details.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(old2.isAcknowledged());
    assertFalse(actualAcknowledgeAlarmResult.isAcknowledged());
    assertFalse(actualAcknowledgeAlarmResult.isCleared());
    assertFalse(actualAcknowledgeAlarmResult.isCreated());
    assertFalse(actualAcknowledgeAlarmResult.isDeleted());
    assertFalse(actualAcknowledgeAlarmResult.isModified());
    assertFalse(actualAcknowledgeAlarmResult.isPropagationChanged());
    assertFalse(actualAcknowledgeAlarmResult.isSeverityChanged());
    assertTrue(nextResult.isBoolean());
    assertTrue(details.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(details.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(old2.getPropagateRelationTypes().isEmpty());
    assertTrue(actualAcknowledgeAlarmResult.getPropagatedEntitiesList().isEmpty());
    assertTrue(old2.isCleared());
    assertTrue(old2.isPropagate());
    assertTrue(old2.isPropagateToOwner());
    assertTrue(old2.isPropagateToTenant());
    assertTrue(actualAcknowledgeAlarmResult.isSuccessful());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, old2.getTenantId());
    CustomerId customerId = entityService.NULL_CUSTOMER_ID;
    assertSame(customerId, old2.getCustomerId());
    assertSame(customerId, old2.getOriginator());
  }

  /**
   * Test {@link BaseAlarmService#clearAlarm(TenantId, AlarmId, long, JsonNode)}.
   * <ul>
   *   <li>Then return Old Name is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#clearAlarm(TenantId, AlarmId, long, JsonNode)}
   */
  @Test
  public void testClearAlarm_thenReturnOldNameIsType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmApiCallResult.AlarmApiCallResultBuilder alarmApiCallResultBuilder = mock(
        AlarmApiCallResult.AlarmApiCallResultBuilder.class);
    when(alarmApiCallResultBuilder.modified(anyBoolean())).thenReturn(AlarmApiCallResult.builder());
    AlarmApiCallResult.AlarmApiCallResultBuilder alarmApiCallResultBuilder2 = mock(
        AlarmApiCallResult.AlarmApiCallResultBuilder.class);
    when(alarmApiCallResultBuilder2.deleted(anyBoolean())).thenReturn(alarmApiCallResultBuilder);
    AlarmApiCallResult.AlarmApiCallResultBuilder alarmApiCallResultBuilder3 = mock(
        AlarmApiCallResult.AlarmApiCallResultBuilder.class);
    when(alarmApiCallResultBuilder3.created(anyBoolean())).thenReturn(alarmApiCallResultBuilder2);
    AlarmApiCallResult.AlarmApiCallResultBuilder alarmApiCallResultBuilder4 = mock(
        AlarmApiCallResult.AlarmApiCallResultBuilder.class);
    when(alarmApiCallResultBuilder4.cleared(anyBoolean())).thenReturn(alarmApiCallResultBuilder3);
    AlarmApiCallResult.AlarmApiCallResultBuilder alarmApiCallResultBuilder5 = mock(
        AlarmApiCallResult.AlarmApiCallResultBuilder.class);
    when(alarmApiCallResultBuilder5.alarm(Mockito.<AlarmInfo>any())).thenReturn(alarmApiCallResultBuilder4);
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = alarmApiCallResultBuilder5.alarm(new AlarmInfo())
        .cleared(true)
        .created(true)
        .deleted(true)
        .modified(true);
    Alarm.AlarmBuilder alarmBuilder = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder.assignTs(anyLong())).thenReturn(Alarm.builder());
    Alarm.AlarmBuilder alarmBuilder2 = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder2.acknowledged(anyBoolean())).thenReturn(alarmBuilder);
    Alarm.AlarmBuilder alarmBuilder3 = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder3.ackTs(anyLong())).thenReturn(alarmBuilder2);
    Alarm.AlarmBuilder propagateResult = alarmBuilder3.ackTs(1L)
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
    Alarm old = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .severity(AlarmSeverity.CRITICAL)
        .startTs(1L)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .type("Type")
        .build();
    AlarmApiCallResult.AlarmApiCallResultBuilder oldResult = modifiedResult.old(old);
    AlarmApiCallResult buildResult = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    when(alarmDao.clearAlarm(Mockito.<TenantId>any(), Mockito.<AlarmId>any(), anyLong(), Mockito.<JsonNode>any()))
        .thenReturn(buildResult);
    TenantServiceImpl tenantService = mock(TenantServiceImpl.class);
    BaseEntityService entityService = new BaseEntityService();
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;
    JsonNode details = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    AlarmApiCallResult actualClearAlarmResult = (new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()))).clearAlarm(tenantId, null, 1L, details);

    // Assert
    verify(alarmBuilder3).ackTs(eq(1L));
    verify(alarmBuilder2).acknowledged(eq(true));
    verify(alarmBuilder).assignTs(eq(1L));
    verify(alarmApiCallResultBuilder5).alarm(isA(AlarmInfo.class));
    verify(alarmApiCallResultBuilder4).cleared(eq(true));
    verify(alarmApiCallResultBuilder3).created(eq(true));
    verify(alarmApiCallResultBuilder2).deleted(eq(true));
    verify(alarmApiCallResultBuilder).modified(eq(true));
    verify(alarmDao).clearAlarm(isA(TenantId.class), isNull(), eq(1L), isA(JsonNode.class));
    Alarm old2 = actualClearAlarmResult.getOld();
    assertEquals("Type", old2.getName());
    assertEquals("Type", old2.getType());
    assertNull(old2.getUuidId());
    assertNull(actualClearAlarmResult.getAlarm());
    assertNull(actualClearAlarmResult.getOldSeverity());
    assertNull(old2.getId());
    assertNull(old2.getDashboardId());
    assertNull(old2.getAssigneeId());
    assertEquals(0L, old2.getAckTs());
    assertEquals(0L, old2.getAssignTs());
    assertEquals(0L, old2.getCreatedTime());
    assertEquals(1L, old2.getClearTs());
    assertEquals(1L, old2.getEndTs());
    assertEquals(1L, old2.getStartTs());
    assertEquals(AlarmSeverity.CRITICAL, old2.getSeverity());
    assertEquals(AlarmStatus.CLEARED_UNACK, old2.getStatus());
    assertFalse(old2.isAcknowledged());
    assertFalse(actualClearAlarmResult.isAcknowledged());
    assertFalse(actualClearAlarmResult.isCleared());
    assertFalse(actualClearAlarmResult.isCreated());
    assertFalse(actualClearAlarmResult.isDeleted());
    assertFalse(actualClearAlarmResult.isModified());
    assertFalse(actualClearAlarmResult.isPropagationChanged());
    assertFalse(actualClearAlarmResult.isSeverityChanged());
    assertTrue(old2.getPropagateRelationTypes().isEmpty());
    assertTrue(actualClearAlarmResult.getPropagatedEntitiesList().isEmpty());
    assertTrue(old2.isCleared());
    assertTrue(old2.isPropagate());
    assertTrue(old2.isPropagateToOwner());
    assertTrue(old2.isPropagateToTenant());
    assertTrue(actualClearAlarmResult.isSuccessful());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, old2.getTenantId());
    CustomerId customerId = entityService.NULL_CUSTOMER_ID;
    assertSame(customerId, old2.getCustomerId());
    assertSame(customerId, old2.getOriginator());
    assertSame(details, old2.getDetails());
  }

  /**
   * Test
   * {@link BaseAlarmService#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   * <ul>
   *   <li>Then Details iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestActiveByOriginatorAndType_thenDetailsIteratorNextReturnBooleanNode() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Alarm.AlarmBuilder alarmBuilder = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder.assignTs(anyLong())).thenReturn(Alarm.builder());
    Alarm.AlarmBuilder alarmBuilder2 = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder2.acknowledged(anyBoolean())).thenReturn(alarmBuilder);
    Alarm.AlarmBuilder alarmBuilder3 = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder3.ackTs(anyLong())).thenReturn(alarmBuilder2);
    Alarm.AlarmBuilder propagateResult = alarmBuilder3.ackTs(1L)
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
    Alarm buildResult = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .severity(AlarmSeverity.CRITICAL)
        .startTs(1L)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .type("Type")
        .build();
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    when(alarmDao.findLatestActiveByOriginatorAndType(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<String>any())).thenReturn(buildResult);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseEntityService entityService = new BaseEntityService();
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;
    CustomerId originator = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult = (new BaseAlarmService(tenantService, alarmDao,
        entityService, new AlarmDataValidator(new TenantServiceImpl())))
        .findLatestActiveByOriginatorAndType(tenantId, originator, "Type");

    // Assert
    verify(alarmBuilder3).ackTs(eq(1L));
    verify(alarmBuilder2).acknowledged(eq(true));
    verify(alarmBuilder).assignTs(eq(1L));
    verify(alarmDao).findLatestActiveByOriginatorAndType(isA(TenantId.class), isA(EntityId.class), eq("Type"));
    JsonNode details = actualFindLatestActiveByOriginatorAndTypeResult.getDetails();
    Iterator<JsonNode> iteratorResult = details.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(details instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = details.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Type", actualFindLatestActiveByOriginatorAndTypeResult.getName());
    assertEquals("Type", actualFindLatestActiveByOriginatorAndTypeResult.getType());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", details.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(actualFindLatestActiveByOriginatorAndTypeResult.getUuidId());
    assertNull(actualFindLatestActiveByOriginatorAndTypeResult.getId());
    assertNull(actualFindLatestActiveByOriginatorAndTypeResult.getDashboardId());
    assertNull(actualFindLatestActiveByOriginatorAndTypeResult.getAssigneeId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, actualFindLatestActiveByOriginatorAndTypeResult.getAckTs());
    assertEquals(0L, actualFindLatestActiveByOriginatorAndTypeResult.getAssignTs());
    assertEquals(0L, actualFindLatestActiveByOriginatorAndTypeResult.getCreatedTime());
    assertEquals(1, details.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindLatestActiveByOriginatorAndTypeResult.getClearTs());
    assertEquals(1L, actualFindLatestActiveByOriginatorAndTypeResult.getEndTs());
    assertEquals(1L, actualFindLatestActiveByOriginatorAndTypeResult.getStartTs());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, details.getNodeType());
    assertEquals(AlarmSeverity.CRITICAL, actualFindLatestActiveByOriginatorAndTypeResult.getSeverity());
    assertEquals(AlarmStatus.CLEARED_UNACK, actualFindLatestActiveByOriginatorAndTypeResult.getStatus());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(details.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(details.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(details.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(details.isBinary());
    assertFalse(details.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(details.isDouble());
    assertFalse(details.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(details.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(details.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(details.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(details.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(details.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(details.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(details.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(details.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(details.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(details.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(details.isTextual());
    assertFalse(details.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualFindLatestActiveByOriginatorAndTypeResult.isAcknowledged());
    assertTrue(nextResult.isBoolean());
    assertTrue(details.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(details.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.getPropagateRelationTypes().isEmpty());
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.isCleared());
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.isPropagate());
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.isPropagateToOwner());
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.isPropagateToTenant());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualFindLatestActiveByOriginatorAndTypeResult.getTenantId());
    assertSame(originator, actualFindLatestActiveByOriginatorAndTypeResult.getCustomerId());
    assertSame(originator, actualFindLatestActiveByOriginatorAndTypeResult.getOriginator());
  }

  /**
   * Test
   * {@link BaseAlarmService#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}.
   * <ul>
   *   <li>Given {@link EntityKey#EntityKey(EntityKeyType, String)} with type is
   * {@code ATTRIBUTE} and {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}
   */
  @Test
  public void testFindAlarmDataByQueryForEntities_givenEntityKeyWithTypeIsAttributeAndKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    PageData<AlarmData> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findAlarmDataByQueryForEntities(Mockito.<TenantId>any(), Mockito.<AlarmDataQuery>any(),
        Mockito.<Collection<EntityId>>any())).thenReturn(emptyPageDataResult);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService baseAlarmService = new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));
    AlarmDataPageLink pageLink = mock(AlarmDataPageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key")));
    when(pageLink.getPageSize()).thenReturn(3);
    EntityFilter entityFilter = mock(EntityFilter.class);
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    AlarmDataQuery query = new AlarmDataQuery(entityFilter, pageLink, entityFields, latestValues, keyFilters,
        new ArrayList<>());

    // Act
    PageData<AlarmData> actualFindAlarmDataByQueryForEntitiesResult = baseAlarmService
        .findAlarmDataByQueryForEntities(ModelConstants.SYSTEM_TENANT, query, new ArrayList<>());

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(alarmDao).findAlarmDataByQueryForEntities(isA(TenantId.class), isA(AlarmDataQuery.class),
        isA(Collection.class));
    assertSame(actualFindAlarmDataByQueryForEntitiesResult.EMPTY_PAGE_DATA,
        actualFindAlarmDataByQueryForEntitiesResult);
  }

  /**
   * Test
   * {@link BaseAlarmService#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}
   */
  @Test
  public void testFindAlarmDataByQueryForEntities_givenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    PageData<AlarmData> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findAlarmDataByQueryForEntities(Mockito.<TenantId>any(), Mockito.<AlarmDataQuery>any(),
        Mockito.<Collection<EntityId>>any())).thenReturn(emptyPageDataResult);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService baseAlarmService = new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));
    AlarmDataPageLink pageLink = mock(AlarmDataPageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPageSize()).thenReturn(3);
    EntityFilter entityFilter = mock(EntityFilter.class);
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    AlarmDataQuery query = new AlarmDataQuery(entityFilter, pageLink, entityFields, latestValues, keyFilters,
        new ArrayList<>());

    // Act
    PageData<AlarmData> actualFindAlarmDataByQueryForEntitiesResult = baseAlarmService
        .findAlarmDataByQueryForEntities(ModelConstants.SYSTEM_TENANT, query, new ArrayList<>());

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(alarmDao).findAlarmDataByQueryForEntities(isA(TenantId.class), isA(AlarmDataQuery.class),
        isA(Collection.class));
    assertSame(actualFindAlarmDataByQueryForEntitiesResult.EMPTY_PAGE_DATA,
        actualFindAlarmDataByQueryForEntitiesResult);
  }

  /**
   * Test
   * {@link BaseAlarmService#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}
   */
  @Test
  public void testFindAlarmDataByQueryForEntities_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    PageData<AlarmData> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findAlarmDataByQueryForEntities(Mockito.<TenantId>any(), Mockito.<AlarmDataQuery>any(),
        Mockito.<Collection<EntityId>>any())).thenReturn(emptyPageDataResult);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService baseAlarmService = new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));
    AlarmDataPageLink pageLink = mock(AlarmDataPageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(new EntityDataSortOrder());
    when(pageLink.getPageSize()).thenReturn(3);
    EntityFilter entityFilter = mock(EntityFilter.class);
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    AlarmDataQuery query = new AlarmDataQuery(entityFilter, pageLink, entityFields, latestValues, keyFilters,
        new ArrayList<>());

    // Act
    PageData<AlarmData> actualFindAlarmDataByQueryForEntitiesResult = baseAlarmService
        .findAlarmDataByQueryForEntities(ModelConstants.SYSTEM_TENANT, query, new ArrayList<>());

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(alarmDao).findAlarmDataByQueryForEntities(isA(TenantId.class), isA(AlarmDataQuery.class),
        isA(Collection.class));
    assertSame(actualFindAlarmDataByQueryForEntitiesResult.EMPTY_PAGE_DATA,
        actualFindAlarmDataByQueryForEntitiesResult);
  }

  /**
   * Test
   * {@link BaseAlarmService#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}
   */
  @Test
  public void testFindAlarmDataByQueryForEntities_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantServiceImpl tenantService = new TenantServiceImpl();
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService baseAlarmService = new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));
    EntityDataSortOrder entityDataSortOrder = mock(EntityDataSortOrder.class);
    when(entityDataSortOrder.getKey()).thenThrow(new DataValidationException("An error occurred"));
    AlarmDataPageLink pageLink = mock(AlarmDataPageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(entityDataSortOrder);
    when(pageLink.getPageSize()).thenReturn(3);
    EntityFilter entityFilter = mock(EntityFilter.class);
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();
    AlarmDataQuery query = new AlarmDataQuery(entityFilter, pageLink, entityFields, latestValues, keyFilters,
        new ArrayList<>());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAlarmService.findAlarmDataByQueryForEntities(ModelConstants.SYSTEM_TENANT, query, new ArrayList<>()));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(entityDataSortOrder).getKey();
  }

  /**
   * Test {@link BaseAlarmService#delAlarm(TenantId, AlarmId, boolean)} with
   * {@code tenantId}, {@code alarmId}, {@code checkAndDeleteAlarmType}.
   * <p>
   * Method under test:
   * {@link BaseAlarmService#delAlarm(TenantId, AlarmId, boolean)}
   */
  @Test
  public void testDelAlarmWithTenantIdAlarmIdCheckAndDeleteAlarmType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    when(alarmDao.findAlarmInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    TenantServiceImpl tenantService = mock(TenantServiceImpl.class);
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService baseAlarmService = new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));

    // Act
    AlarmApiCallResult actualDelAlarmResult = baseAlarmService.delAlarm(ModelConstants.SYSTEM_TENANT,
        new AlarmId(ModelConstants.NULL_UUID), true);

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
   * Test {@link BaseAlarmService#delAlarm(TenantId, AlarmId)} with
   * {@code tenantId}, {@code alarmId}.
   * <ul>
   *   <li>Then return PropagatedEntitiesList is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAlarmService#delAlarm(TenantId, AlarmId)}
   */
  @Test
  public void testDelAlarmWithTenantIdAlarmId_thenReturnPropagatedEntitiesListIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    when(alarmDao.findAlarmInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    TenantServiceImpl tenantService = mock(TenantServiceImpl.class);
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService baseAlarmService = new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));

    // Act
    AlarmApiCallResult actualDelAlarmResult = baseAlarmService.delAlarm(ModelConstants.SYSTEM_TENANT,
        new AlarmId(ModelConstants.NULL_UUID));

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
   * <ul>
   *   <li>Then calls
   * {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAlarmService#delAlarmTypes(TenantId, Set)}
   */
  @Test
  public void testDelAlarmTypes_thenCallsRemoveAlarmTypesIfNoAlarmsPresent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    when(alarmDao.removeAlarmTypesIfNoAlarmsPresent(Mockito.<UUID>any(), Mockito.<Set<String>>any())).thenReturn(false);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService baseAlarmService = new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));

    HashSet<String> types = new HashSet<>();
    types.add("foo");

    // Act
    baseAlarmService.delAlarmTypes(ModelConstants.SYSTEM_TENANT, types);

    // Assert that nothing has changed
    verify(alarmDao).removeAlarmTypesIfNoAlarmsPresent(isA(UUID.class), isA(Set.class));
  }

  /**
   * Test {@link BaseAlarmService#unassignAlarm(TenantId, AlarmId, long)}.
   * <ul>
   *   <li>Then Old Details iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#unassignAlarm(TenantId, AlarmId, long)}
   */
  @Test
  public void testUnassignAlarm_thenOldDetailsIteratorNextReturnBooleanNode() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmApiCallResult.AlarmApiCallResultBuilder alarmApiCallResultBuilder = mock(
        AlarmApiCallResult.AlarmApiCallResultBuilder.class);
    when(alarmApiCallResultBuilder.modified(anyBoolean())).thenReturn(AlarmApiCallResult.builder());
    AlarmApiCallResult.AlarmApiCallResultBuilder alarmApiCallResultBuilder2 = mock(
        AlarmApiCallResult.AlarmApiCallResultBuilder.class);
    when(alarmApiCallResultBuilder2.deleted(anyBoolean())).thenReturn(alarmApiCallResultBuilder);
    AlarmApiCallResult.AlarmApiCallResultBuilder alarmApiCallResultBuilder3 = mock(
        AlarmApiCallResult.AlarmApiCallResultBuilder.class);
    when(alarmApiCallResultBuilder3.created(anyBoolean())).thenReturn(alarmApiCallResultBuilder2);
    AlarmApiCallResult.AlarmApiCallResultBuilder alarmApiCallResultBuilder4 = mock(
        AlarmApiCallResult.AlarmApiCallResultBuilder.class);
    when(alarmApiCallResultBuilder4.cleared(anyBoolean())).thenReturn(alarmApiCallResultBuilder3);
    AlarmApiCallResult.AlarmApiCallResultBuilder alarmApiCallResultBuilder5 = mock(
        AlarmApiCallResult.AlarmApiCallResultBuilder.class);
    when(alarmApiCallResultBuilder5.alarm(Mockito.<AlarmInfo>any())).thenReturn(alarmApiCallResultBuilder4);
    AlarmApiCallResult.AlarmApiCallResultBuilder modifiedResult = alarmApiCallResultBuilder5.alarm(new AlarmInfo())
        .cleared(true)
        .created(true)
        .deleted(true)
        .modified(true);
    Alarm.AlarmBuilder alarmBuilder = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder.assignTs(anyLong())).thenReturn(Alarm.builder());
    Alarm.AlarmBuilder alarmBuilder2 = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder2.acknowledged(anyBoolean())).thenReturn(alarmBuilder);
    Alarm.AlarmBuilder alarmBuilder3 = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder3.ackTs(anyLong())).thenReturn(alarmBuilder2);
    Alarm.AlarmBuilder propagateResult = alarmBuilder3.ackTs(1L)
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
    Alarm old = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .severity(AlarmSeverity.CRITICAL)
        .startTs(1L)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .type("Type")
        .build();
    AlarmApiCallResult.AlarmApiCallResultBuilder oldResult = modifiedResult.old(old);
    AlarmApiCallResult buildResult = oldResult.propagatedEntitiesList(new ArrayList<>()).successful(true).build();
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    when(alarmDao.unassignAlarm(Mockito.<TenantId>any(), Mockito.<AlarmId>any(), anyLong())).thenReturn(buildResult);
    TenantServiceImpl tenantService = mock(TenantServiceImpl.class);
    BaseEntityService entityService = new BaseEntityService();
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    AlarmApiCallResult actualUnassignAlarmResult = (new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()))).unassignAlarm(tenantId, null, 1L);

    // Assert
    verify(alarmBuilder3).ackTs(eq(1L));
    verify(alarmBuilder2).acknowledged(eq(true));
    verify(alarmBuilder).assignTs(eq(1L));
    verify(alarmApiCallResultBuilder5).alarm(isA(AlarmInfo.class));
    verify(alarmApiCallResultBuilder4).cleared(eq(true));
    verify(alarmApiCallResultBuilder3).created(eq(true));
    verify(alarmApiCallResultBuilder2).deleted(eq(true));
    verify(alarmApiCallResultBuilder).modified(eq(true));
    verify(alarmDao).unassignAlarm(isA(TenantId.class), isNull(), eq(1L));
    Alarm old2 = actualUnassignAlarmResult.getOld();
    JsonNode details = old2.getDetails();
    Iterator<JsonNode> iteratorResult = details.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(details instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = details.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Type", old2.getName());
    assertEquals("Type", old2.getType());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", details.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(old2.getUuidId());
    assertNull(actualUnassignAlarmResult.getAlarm());
    assertNull(actualUnassignAlarmResult.getOldSeverity());
    assertNull(old2.getId());
    assertNull(old2.getDashboardId());
    assertNull(old2.getAssigneeId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, old2.getAckTs());
    assertEquals(0L, old2.getAssignTs());
    assertEquals(0L, old2.getCreatedTime());
    assertEquals(1, details.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, old2.getClearTs());
    assertEquals(1L, old2.getEndTs());
    assertEquals(1L, old2.getStartTs());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, details.getNodeType());
    assertEquals(AlarmSeverity.CRITICAL, old2.getSeverity());
    assertEquals(AlarmStatus.CLEARED_UNACK, old2.getStatus());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(details.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(details.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(details.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(details.isBinary());
    assertFalse(details.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(details.isDouble());
    assertFalse(details.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(details.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(details.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(details.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(details.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(details.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(details.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(details.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(details.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(details.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(details.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(details.isTextual());
    assertFalse(details.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(old2.isAcknowledged());
    assertFalse(actualUnassignAlarmResult.isAcknowledged());
    assertFalse(actualUnassignAlarmResult.isCleared());
    assertFalse(actualUnassignAlarmResult.isCreated());
    assertFalse(actualUnassignAlarmResult.isDeleted());
    assertFalse(actualUnassignAlarmResult.isModified());
    assertFalse(actualUnassignAlarmResult.isPropagationChanged());
    assertFalse(actualUnassignAlarmResult.isSeverityChanged());
    assertTrue(nextResult.isBoolean());
    assertTrue(details.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(details.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(old2.getPropagateRelationTypes().isEmpty());
    assertTrue(actualUnassignAlarmResult.getPropagatedEntitiesList().isEmpty());
    assertTrue(old2.isCleared());
    assertTrue(old2.isPropagate());
    assertTrue(old2.isPropagateToOwner());
    assertTrue(old2.isPropagateToTenant());
    assertTrue(actualUnassignAlarmResult.isSuccessful());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, old2.getTenantId());
    CustomerId customerId = entityService.NULL_CUSTOMER_ID;
    assertSame(customerId, old2.getCustomerId());
    assertSame(customerId, old2.getOriginator());
  }

  /**
   * Test {@link BaseAlarmService#findAlarmById(TenantId, AlarmId)}.
   * <ul>
   *   <li>Then Details iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAlarmService#findAlarmById(TenantId, AlarmId)}
   */
  @Test
  public void testFindAlarmById_thenDetailsIteratorNextReturnBooleanNode() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Alarm.AlarmBuilder alarmBuilder = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder.assignTs(anyLong())).thenReturn(Alarm.builder());
    Alarm.AlarmBuilder alarmBuilder2 = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder2.acknowledged(anyBoolean())).thenReturn(alarmBuilder);
    Alarm.AlarmBuilder alarmBuilder3 = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder3.ackTs(anyLong())).thenReturn(alarmBuilder2);
    Alarm.AlarmBuilder propagateResult = alarmBuilder3.ackTs(1L)
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
    Alarm buildResult = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .severity(AlarmSeverity.CRITICAL)
        .startTs(1L)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .type("Type")
        .build();
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    when(alarmDao.findAlarmById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(buildResult);
    TenantServiceImpl tenantService = mock(TenantServiceImpl.class);
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService baseAlarmService = new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindAlarmByIdResult = baseAlarmService.findAlarmById(tenantId, alarmId);

    // Assert
    verify(alarmBuilder3).ackTs(eq(1L));
    verify(alarmBuilder2).acknowledged(eq(true));
    verify(alarmBuilder).assignTs(eq(1L));
    verify(alarmId, atLeast(1)).getId();
    verify(alarmDao).findAlarmById(isA(TenantId.class), isA(UUID.class));
    JsonNode details = actualFindAlarmByIdResult.getDetails();
    Iterator<JsonNode> iteratorResult = details.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(details instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = details.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Type", actualFindAlarmByIdResult.getName());
    assertEquals("Type", actualFindAlarmByIdResult.getType());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", details.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(actualFindAlarmByIdResult.getUuidId());
    assertNull(actualFindAlarmByIdResult.getId());
    assertNull(actualFindAlarmByIdResult.getDashboardId());
    assertNull(actualFindAlarmByIdResult.getAssigneeId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, actualFindAlarmByIdResult.getAckTs());
    assertEquals(0L, actualFindAlarmByIdResult.getAssignTs());
    assertEquals(0L, actualFindAlarmByIdResult.getCreatedTime());
    assertEquals(1, details.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindAlarmByIdResult.getClearTs());
    assertEquals(1L, actualFindAlarmByIdResult.getEndTs());
    assertEquals(1L, actualFindAlarmByIdResult.getStartTs());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, details.getNodeType());
    assertEquals(AlarmSeverity.CRITICAL, actualFindAlarmByIdResult.getSeverity());
    assertEquals(AlarmStatus.CLEARED_UNACK, actualFindAlarmByIdResult.getStatus());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(details.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(details.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(details.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(details.isBinary());
    assertFalse(details.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(details.isDouble());
    assertFalse(details.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(details.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(details.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(details.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(details.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(details.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(details.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(details.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(details.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(details.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(details.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(details.isTextual());
    assertFalse(details.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualFindAlarmByIdResult.isAcknowledged());
    assertTrue(nextResult.isBoolean());
    assertTrue(details.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(details.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(actualFindAlarmByIdResult.getPropagateRelationTypes().isEmpty());
    assertTrue(actualFindAlarmByIdResult.isCleared());
    assertTrue(actualFindAlarmByIdResult.isPropagate());
    assertTrue(actualFindAlarmByIdResult.isPropagateToOwner());
    assertTrue(actualFindAlarmByIdResult.isPropagateToTenant());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualFindAlarmByIdResult.getTenantId());
    CustomerId customerId = entityService.NULL_CUSTOMER_ID;
    assertSame(customerId, actualFindAlarmByIdResult.getCustomerId());
    assertSame(customerId, actualFindAlarmByIdResult.getOriginator());
  }

  /**
   * Test {@link BaseAlarmService#findAlarmByIdAsync(TenantId, AlarmId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#findAlarmByIdAsync(TenantId, AlarmId)}
   */
  @Test
  public void testFindAlarmByIdAsync_givenNull_uuid_thenReturnSettableFuture() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    SettableFuture<Alarm> createResult = SettableFuture.create();
    when(alarmDao.findAlarmByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);
    TenantServiceImpl tenantService = mock(TenantServiceImpl.class);
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService baseAlarmService = new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<Alarm> actualFindAlarmByIdAsyncResult = baseAlarmService
        .findAlarmByIdAsync(ModelConstants.SYSTEM_TENANT, alarmId);

    // Assert
    verify(alarmId, atLeast(1)).getId();
    verify(alarmDao).findAlarmByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindAlarmByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAlarmByIdAsyncResult);
  }

  /**
   * Test {@link BaseAlarmService#findAlarmInfoById(TenantId, AlarmId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link AlarmInfo#AlarmInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#findAlarmInfoById(TenantId, AlarmId)}
   */
  @Test
  public void testFindAlarmInfoById_givenNull_uuid_thenReturnAlarmInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    AlarmInfo alarmInfo = new AlarmInfo();
    when(alarmDao.findAlarmInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(alarmInfo);
    TenantServiceImpl tenantService = mock(TenantServiceImpl.class);
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService baseAlarmService = new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    AlarmInfo actualFindAlarmInfoByIdResult = baseAlarmService.findAlarmInfoById(ModelConstants.SYSTEM_TENANT, alarmId);

    // Assert
    verify(alarmId, atLeast(1)).getId();
    verify(alarmDao).findAlarmInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(alarmInfo, actualFindAlarmInfoByIdResult);
  }

  /**
   * Test {@link BaseAlarmService#findAlarms(TenantId, AlarmQuery)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAlarmService#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  public void testFindAlarms_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    PageData<AlarmInfo> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findAlarms(Mockito.<TenantId>any(), Mockito.<AlarmQuery>any())).thenReturn(emptyPageDataResult);
    TenantServiceImpl tenantService = mock(TenantServiceImpl.class);
    BaseEntityService entityService = new BaseEntityService();

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult = (new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl())))
        .findAlarms(ModelConstants.SYSTEM_TENANT, mock(AlarmQuery.class));

    // Assert
    verify(alarmDao).findAlarms(isA(TenantId.class), isA(AlarmQuery.class));
    assertSame(actualFindAlarmsResult.EMPTY_PAGE_DATA, actualFindAlarmsResult);
  }

  /**
   * Test
   * {@link BaseAlarmService#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  public void testFindCustomerAlarms_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    PageData<AlarmInfo> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findCustomerAlarms(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<AlarmQuery>any()))
        .thenReturn(emptyPageDataResult);
    TenantServiceImpl tenantService = mock(TenantServiceImpl.class);
    BaseEntityService entityService = new BaseEntityService();

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult = (new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl())))
        .findCustomerAlarms(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, mock(AlarmQuery.class));

    // Assert
    verify(alarmDao).findCustomerAlarms(isA(TenantId.class), isA(CustomerId.class), isA(AlarmQuery.class));
    assertSame(actualFindCustomerAlarmsResult.EMPTY_PAGE_DATA, actualFindCustomerAlarmsResult);
  }

  /**
   * Test
   * {@link BaseAlarmService#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)}
   */
  @Test
  public void testFindAlarmIdsByOriginatorId_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    PageData<TbPair<UUID, Long>> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findAlarmIdsByOriginatorId(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(),
        Mockito.<AlarmId>any(), anyInt())).thenReturn(emptyPageDataResult);
    TenantServiceImpl tenantService = mock(TenantServiceImpl.class);
    BaseEntityService entityService = new BaseEntityService();

    // Act
    List<TbPair<UUID, Long>> actualFindAlarmIdsByOriginatorIdResult = (new BaseAlarmService(tenantService, alarmDao,
        entityService, new AlarmDataValidator(new TenantServiceImpl())))
        .findAlarmIdsByOriginatorId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, 1L, null, 1);

    // Assert
    verify(alarmDao).findAlarmIdsByOriginatorId(isA(TenantId.class), isA(EntityId.class), eq(1L), isNull(), eq(1));
    assertTrue(actualFindAlarmIdsByOriginatorIdResult.isEmpty());
  }

  /**
   * Test
   * {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus, AlarmStatus, String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#findHighestAlarmSeverity(TenantId, EntityId, AlarmSearchStatus, AlarmStatus, String)}
   */
  @Test
  public void testFindHighestAlarmSeverity_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    when(alarmDao.findAlarmSeverities(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<AlarmStatusFilter>any(), Mockito.<String>any())).thenReturn(new HashSet<>());
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseEntityService entityService = new BaseEntityService();

    // Act
    AlarmSeverity actualFindHighestAlarmSeverityResult = (new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()))).findHighestAlarmSeverity(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, AlarmSearchStatus.ANY, AlarmStatus.ACTIVE_UNACK, "42");

    // Assert
    verify(alarmDao).findAlarmSeverities(isA(TenantId.class), isA(EntityId.class), isA(AlarmStatusFilter.class),
        eq("42"));
    assertNull(actualFindHighestAlarmSeverityResult);
  }

  /**
   * Test {@link BaseAlarmService#deleteEntityAlarmRecords(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#deleteEntityAlarmRecords(TenantId, EntityId)}
   */
  @Test
  public void testDeleteEntityAlarmRecords_thenReturnOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    when(alarmDao.deleteEntityAlarmRecords(Mockito.<TenantId>any(), Mockito.<EntityId>any())).thenReturn(1);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseEntityService entityService = new BaseEntityService();

    // Act
    int actualDeleteEntityAlarmRecordsResult = (new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl())))
        .deleteEntityAlarmRecords(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(alarmDao).deleteEntityAlarmRecords(isA(TenantId.class), isA(EntityId.class));
    assertEquals(1, actualDeleteEntityAlarmRecordsResult);
  }

  /**
   * Test {@link BaseAlarmService#deleteEntityAlarmRecordsByTenantId(TenantId)}.
   * <p>
   * Method under test:
   * {@link BaseAlarmService#deleteEntityAlarmRecordsByTenantId(TenantId)}
   */
  @Test
  public void testDeleteEntityAlarmRecordsByTenantId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    doNothing().when(alarmDao).deleteEntityAlarmRecordsByTenantId(Mockito.<TenantId>any());
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseEntityService entityService = new BaseEntityService();

    // Act
    (new BaseAlarmService(tenantService, alarmDao, entityService, new AlarmDataValidator(new TenantServiceImpl())))
        .deleteEntityAlarmRecordsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(alarmDao).deleteEntityAlarmRecordsByTenantId(isA(TenantId.class));
  }

  /**
   * Test
   * {@link BaseAlarmService#countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)}.
   * <ul>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)}
   */
  @Test
  public void testCountAlarmsByQuery_thenReturnThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    when(
        alarmDao.countAlarmsByQuery(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<AlarmCountQuery>any()))
        .thenReturn(3L);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService baseAlarmService = new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));

    // Act
    long actualCountAlarmsByQueryResult = baseAlarmService.countAlarmsByQuery(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, new AlarmCountQuery());

    // Assert
    verify(alarmDao).countAlarmsByQuery(isA(TenantId.class), isA(CustomerId.class), isA(AlarmCountQuery.class));
    assertEquals(3L, actualCountAlarmsByQueryResult);
  }

  /**
   * Test {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAlarmTypesByTenantId_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmDao alarmDao = mock(AlarmDao.class);
    PageData<EntitySubtype> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findTenantAlarmTypes(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseEntityService entityService = new BaseEntityService();

    // Act
    PageData<EntitySubtype> actualFindAlarmTypesByTenantIdResult = (new BaseAlarmService(tenantService, alarmDao,
        entityService, new AlarmDataValidator(new TenantServiceImpl())))
        .findAlarmTypesByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmDao).findTenantAlarmTypes(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAlarmTypesByTenantIdResult.EMPTY_PAGE_DATA, actualFindAlarmTypesByTenantIdResult);
  }

  /**
   * Test {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAlarmTypesByTenantId_whenNull_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmDao alarmDao = mock(AlarmDao.class);
    PageData<EntitySubtype> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findTenantAlarmTypes(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseEntityService entityService = new BaseEntityService();

    // Act
    PageData<EntitySubtype> actualFindAlarmTypesByTenantIdResult = (new BaseAlarmService(tenantService, alarmDao,
        entityService, new AlarmDataValidator(new TenantServiceImpl())))
        .findAlarmTypesByTenantId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(alarmDao).findTenantAlarmTypes(isA(UUID.class), isNull());
    assertSame(actualFindAlarmTypesByTenantIdResult.EMPTY_PAGE_DATA, actualFindAlarmTypesByTenantIdResult);
  }

  /**
   * Test {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link TimePageLink#TimePageLink(int)} with pageSize is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmService#findAlarmTypesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAlarmTypesByTenantId_whenTimePageLinkWithPageSizeIsThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmDao alarmDao = mock(AlarmDao.class);
    PageData<EntitySubtype> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findTenantAlarmTypes(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService baseAlarmService = new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));

    // Act
    PageData<EntitySubtype> actualFindAlarmTypesByTenantIdResult = baseAlarmService
        .findAlarmTypesByTenantId(ModelConstants.SYSTEM_TENANT, new TimePageLink(3));

    // Assert
    verify(alarmDao).findTenantAlarmTypes(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAlarmTypesByTenantIdResult.EMPTY_PAGE_DATA, actualFindAlarmTypesByTenantIdResult);
  }

  /**
   * Test {@link BaseAlarmService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Then {@link Optional#get()} Details iterator next return
   * {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAlarmService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_thenGetDetailsIteratorNextReturnBooleanNode() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Alarm.AlarmBuilder alarmBuilder = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder.assignTs(anyLong())).thenReturn(Alarm.builder());
    Alarm.AlarmBuilder alarmBuilder2 = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder2.acknowledged(anyBoolean())).thenReturn(alarmBuilder);
    Alarm.AlarmBuilder alarmBuilder3 = mock(Alarm.AlarmBuilder.class);
    when(alarmBuilder3.ackTs(anyLong())).thenReturn(alarmBuilder2);
    Alarm.AlarmBuilder propagateResult = alarmBuilder3.ackTs(1L)
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
    Alarm buildResult = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .severity(AlarmSeverity.CRITICAL)
        .startTs(1L)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .type("Type")
        .build();
    JpaAlarmDao alarmDao = mock(JpaAlarmDao.class);
    when(alarmDao.findAlarmById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(buildResult);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseEntityService entityService = new BaseEntityService();
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Optional<HasId<?>> actualFindEntityResult = (new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()))).findEntity(tenantId, entityId);

    // Assert
    verify(alarmBuilder3).ackTs(eq(1L));
    verify(alarmBuilder2).acknowledged(eq(true));
    verify(alarmBuilder).assignTs(eq(1L));
    verify(alarmDao).findAlarmById(isA(TenantId.class), isA(UUID.class));
    HasId<?> getResult = actualFindEntityResult.get();
    JsonNode details = ((Alarm) getResult).getDetails();
    Iterator<JsonNode> iteratorResult = details.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(details instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = details.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    assertTrue(getResult instanceof Alarm);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Type", ((Alarm) getResult).getName());
    assertEquals("Type", ((Alarm) getResult).getType());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", details.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(((Alarm) getResult).getUuidId());
    assertNull(getResult.getId());
    assertNull(((Alarm) getResult).getDashboardId());
    assertNull(((Alarm) getResult).getAssigneeId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, ((Alarm) getResult).getAckTs());
    assertEquals(0L, ((Alarm) getResult).getAssignTs());
    assertEquals(0L, ((Alarm) getResult).getCreatedTime());
    assertEquals(1, details.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, ((Alarm) getResult).getClearTs());
    assertEquals(1L, ((Alarm) getResult).getEndTs());
    assertEquals(1L, ((Alarm) getResult).getStartTs());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, details.getNodeType());
    assertEquals(AlarmSeverity.CRITICAL, ((Alarm) getResult).getSeverity());
    assertEquals(AlarmStatus.CLEARED_UNACK, ((Alarm) getResult).getStatus());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(details.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(details.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(details.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(details.isBinary());
    assertFalse(details.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(details.isDouble());
    assertFalse(details.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(details.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(details.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(details.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(details.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(details.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(details.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(details.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(details.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(details.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(details.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(details.isTextual());
    assertFalse(details.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(((Alarm) getResult).isAcknowledged());
    assertTrue(nextResult.isBoolean());
    assertTrue(details.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(details.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(((Alarm) getResult).getPropagateRelationTypes().isEmpty());
    assertTrue(actualFindEntityResult.isPresent());
    assertTrue(((Alarm) getResult).isCleared());
    assertTrue(((Alarm) getResult).isPropagate());
    assertTrue(((Alarm) getResult).isPropagateToOwner());
    assertTrue(((Alarm) getResult).isPropagateToTenant());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, ((Alarm) getResult).getTenantId());
    assertSame(entityId, ((Alarm) getResult).getCustomerId());
    assertSame(entityId, ((Alarm) getResult).getOriginator());
  }

  /**
   * Test {@link BaseAlarmService#getEntityType()}.
   * <p>
   * Method under test: {@link BaseAlarmService#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange
    TenantServiceImpl tenantService = new TenantServiceImpl();
    JpaAlarmDao alarmDao = new JpaAlarmDao();
    BaseEntityService entityService = new BaseEntityService();

    // Act and Assert
    assertEquals(EntityType.ALARM,
        (new BaseAlarmService(tenantService, alarmDao, entityService, new AlarmDataValidator(new TenantServiceImpl())))
            .getEntityType());
  }
}
