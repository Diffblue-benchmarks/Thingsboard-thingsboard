package org.thingsboard.server.dao.sql.audit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
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
import jakarta.persistence.EntityManagerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.audit.ActionStatus;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.audit.AuditLog;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AuditLogEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {JpaAuditLogDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaAuditLogDaoDiffblueTest {
  @MockBean
  private AuditLogRepository auditLogRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaAuditLogDao jpaAuditLogDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private SqlPartitioningRepository sqlPartitioningRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndEntityId() throws IOException {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AuditLogEntity> content = new ArrayList<>();
    content.add(auditLogEntity);
    PageImpl<AuditLogEntity> pageImpl = new PageImpl<>(content);
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<EntityType>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<List<ActionType>>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndEntityId(tenantId, entityId, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogRepository).findAuditLogsByTenantIdAndEntityId(isA(UUID.class), eq(EntityType.CUSTOMER),
        isA(UUID.class), isNull(), isNull(), isNull(), isA(List.class), isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdAndEntityIdResult.getData();
    assertEquals(1, data.size());
    AuditLog getResult = data.get(0);
    JsonNode actionData = getResult.getActionData();
    Iterator<JsonNode> iteratorResult = actionData.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(actionData instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = actionData.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId2.getId().toString());
    assertEquals("Action Failure Details", getResult.getActionFailureDetails());
    assertEquals("Entity Name", getResult.getEntityName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("janedoe", getResult.getUserName());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", actionData.toPrettyString());
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
    assertEquals(1, actionData.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, actionData.getNodeType());
    assertEquals(EntityType.TENANT, entityId2.getEntityType());
    UserId userId = getResult.getUserId();
    assertEquals(EntityType.USER, userId.getEntityType());
    assertEquals(ActionStatus.SUCCESS, getResult.getActionStatus());
    assertEquals(ActionType.ADDED, getResult.getActionType());
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
    assertFalse(actionData.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(actionData.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(actionData.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(actionData.isBinary());
    assertFalse(actionData.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(actionData.isDouble());
    assertFalse(actionData.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(actionData.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(actionData.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(actionData.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(actionData.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(actionData.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(actionData.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(actionData.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(actionData.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(actionData.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(actionData.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(actionData.isTextual());
    assertFalse(actionData.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(actionData.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(actionData.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(entityId2.isNullUid());
    assertTrue(userId.isNullUid());
    assertTrue(((TenantId) entityId2).isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(entityId, getResult.getCustomerId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, getResult.getId().getId());
    assertSame(tenantId, userId.getId());
    assertSame(entityId2, getResult.getTenantId());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndEntityId_givenAdded_whenArrayListAddAdded() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<EntityType>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<List<ActionType>>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndEntityId(ModelConstants.NULL_UUID, entityId, actionTypes, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(auditLogRepository).findAuditLogsByTenantIdAndEntityId(isA(UUID.class), eq(EntityType.TENANT),
        isA(UUID.class), isNull(), isNull(), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code DELETED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndEntityId_givenDeleted_whenArrayListAddDeleted() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<EntityType>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<List<ActionType>>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndEntityId(ModelConstants.NULL_UUID, entityId, actionTypes, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(auditLogRepository).findAuditLogsByTenantIdAndEntityId(isA(UUID.class), eq(EntityType.TENANT),
        isA(UUID.class), isNull(), isNull(), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndEntityId_givenNull_uuid_thenCallsGetEntityType() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<EntityType>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<List<ActionType>>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndEntityId(ModelConstants.NULL_UUID, entityId, actionTypes, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(auditLogRepository).findAuditLogsByTenantIdAndEntityId(isA(UUID.class), eq(EntityType.TENANT),
        isA(UUID.class), isNull(), isNull(), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndEntityId_givenOne_thenCallsGetPage() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<EntityType>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<List<ActionType>>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    ArrayList<ActionType> actionTypes = new ArrayList<>();
    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndEntityId(ModelConstants.NULL_UUID, entityId, actionTypes, pageLink);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository).findAuditLogsByTenantIdAndEntityId(isA(UUID.class), eq(EntityType.TENANT),
        isA(UUID.class), eq("Text Search"), eq(1L), eq(1L), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link AuditLog#AuditLog()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndEntityId_thenReturnDataFirstIsAuditLog() {
    // Arrange
    AuditLogEntity auditLogEntity = mock(AuditLogEntity.class);
    AuditLog auditLog = new AuditLog();
    when(auditLogEntity.toData()).thenReturn(auditLog);
    doNothing().when(auditLogEntity).setCreatedTime(anyLong());
    doNothing().when(auditLogEntity).setId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setActionData(Mockito.<JsonNode>any());
    doNothing().when(auditLogEntity).setActionFailureDetails(Mockito.<String>any());
    doNothing().when(auditLogEntity).setActionStatus(Mockito.<ActionStatus>any());
    doNothing().when(auditLogEntity).setActionType(Mockito.<ActionType>any());
    doNothing().when(auditLogEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setEntityName(Mockito.<String>any());
    doNothing().when(auditLogEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(auditLogEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setUserId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setUserName(Mockito.<String>any());
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.FAILURE);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AuditLogEntity> content = new ArrayList<>();
    content.add(auditLogEntity);
    PageImpl<AuditLogEntity> pageImpl = new PageImpl<>(content);
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<EntityType>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<List<ActionType>>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    ArrayList<ActionType> actionTypes = new ArrayList<>();
    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndEntityId(ModelConstants.NULL_UUID, entityId, actionTypes, pageLink);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogEntity).setCreatedTime(eq(1L));
    verify(auditLogEntity).setId(isA(UUID.class));
    verify(auditLogEntity).setUuid(isA(UUID.class));
    verify(auditLogEntity).setActionData(isA(JsonNode.class));
    verify(auditLogEntity).setActionFailureDetails(eq("Action Failure Details"));
    verify(auditLogEntity).setActionStatus(eq(ActionStatus.FAILURE));
    verify(auditLogEntity).setActionType(eq(ActionType.ADDED));
    verify(auditLogEntity).setCustomerId(isA(UUID.class));
    verify(auditLogEntity).setEntityId(isA(UUID.class));
    verify(auditLogEntity).setEntityName(eq("Entity Name"));
    verify(auditLogEntity).setEntityType(eq(EntityType.TENANT));
    verify(auditLogEntity).setTenantId(isA(UUID.class));
    verify(auditLogEntity).setUserId(isA(UUID.class));
    verify(auditLogEntity).setUserName(eq("janedoe"));
    verify(auditLogEntity).toData();
    verify(auditLogRepository).findAuditLogsByTenantIdAndEntityId(isA(UUID.class), eq(EntityType.TENANT),
        isA(UUID.class), eq("Text Search"), eq(1L), eq(1L), isA(List.class), isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdAndEntityIdResult.getData();
    assertEquals(1, data.size());
    assertSame(auditLog, data.get(0));
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndEntityId_whenNull_customer_id() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<EntityType>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<List<ActionType>>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndEntityId(ModelConstants.NULL_UUID, BaseEntityService.NULL_CUSTOMER_ID, actionTypes,
            new TimePageLink(3));

    // Assert
    verify(auditLogRepository).findAuditLogsByTenantIdAndEntityId(isA(UUID.class), eq(EntityType.CUSTOMER),
        isA(UUID.class), isNull(), isNull(), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndEntityId_whenSystem_tenant() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<EntityType>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<List<ActionType>>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndEntityId(ModelConstants.NULL_UUID, ModelConstants.SYSTEM_TENANT, actionTypes,
            new TimePageLink(3));

    // Assert
    verify(auditLogRepository).findAuditLogsByTenantIdAndEntityId(isA(UUID.class), eq(EntityType.TENANT),
        isA(UUID.class), isNull(), isNull(), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndCustomerId() throws IOException {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AuditLogEntity> content = new ArrayList<>();
    content.add(auditLogEntity);
    PageImpl<AuditLogEntity> pageImpl = new PageImpl<>(content);
    when(auditLogRepository.findAuditLogsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<List<ActionType>>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;
    CustomerId customerId = BaseEntityService.NULL_CUSTOMER_ID;
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndCustomerId(tenantId, customerId, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogRepository).findAuditLogsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isNull(), isNull(), isA(List.class), isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    AuditLog getResult = data.get(0);
    JsonNode actionData = getResult.getActionData();
    Iterator<JsonNode> iteratorResult = actionData.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(actionData instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = actionData.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals("Action Failure Details", getResult.getActionFailureDetails());
    assertEquals("Entity Name", getResult.getEntityName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("janedoe", getResult.getUserName());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", actionData.toPrettyString());
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
    assertEquals(1, actionData.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, actionData.getNodeType());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    UserId userId = getResult.getUserId();
    assertEquals(EntityType.USER, userId.getEntityType());
    assertEquals(ActionStatus.SUCCESS, getResult.getActionStatus());
    assertEquals(ActionType.ADDED, getResult.getActionType());
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
    assertFalse(actionData.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(actionData.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(actionData.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(actionData.isBinary());
    assertFalse(actionData.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(actionData.isDouble());
    assertFalse(actionData.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(actionData.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(actionData.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(actionData.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(actionData.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(actionData.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(actionData.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(actionData.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(actionData.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(actionData.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(actionData.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(actionData.isTextual());
    assertFalse(actionData.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(actionData.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(actionData.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(entityId.isNullUid());
    assertTrue(userId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(customerId, getResult.getCustomerId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, getResult.getId().getId());
    assertSame(tenantId, userId.getId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndCustomerId_givenAdded_whenArrayListAddAdded() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<List<ActionType>>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, BaseEntityService.NULL_CUSTOMER_ID, actionTypes,
            new TimePageLink(3));

    // Assert
    verify(auditLogRepository).findAuditLogsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isNull(), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code DELETED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndCustomerId_givenDeleted_whenArrayListAddDeleted() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<List<ActionType>>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, BaseEntityService.NULL_CUSTOMER_ID, actionTypes,
            new TimePageLink(3));

    // Assert
    verify(auditLogRepository).findAuditLogsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isNull(), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndCustomerId_givenOne_thenCallsGetPage() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<List<ActionType>>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<ActionType> actionTypes = new ArrayList<>();
    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, BaseEntityService.NULL_CUSTOMER_ID, actionTypes,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository).findAuditLogsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        eq(1L), eq(1L), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link AuditLog#AuditLog()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndCustomerId_thenReturnDataFirstIsAuditLog() {
    // Arrange
    AuditLogEntity auditLogEntity = mock(AuditLogEntity.class);
    AuditLog auditLog = new AuditLog();
    when(auditLogEntity.toData()).thenReturn(auditLog);
    doNothing().when(auditLogEntity).setCreatedTime(anyLong());
    doNothing().when(auditLogEntity).setId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setActionData(Mockito.<JsonNode>any());
    doNothing().when(auditLogEntity).setActionFailureDetails(Mockito.<String>any());
    doNothing().when(auditLogEntity).setActionStatus(Mockito.<ActionStatus>any());
    doNothing().when(auditLogEntity).setActionType(Mockito.<ActionType>any());
    doNothing().when(auditLogEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setEntityName(Mockito.<String>any());
    doNothing().when(auditLogEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(auditLogEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setUserId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setUserName(Mockito.<String>any());
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("42");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.UPDATED);
    auditLogEntity.setCreatedTime(-1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("42");
    auditLogEntity.setEntityType(EntityType.USER);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("org.thingsboard.server.dao.model.sql.AuditLogEntity");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AuditLogEntity> content = new ArrayList<>();
    content.add(auditLogEntity);
    PageImpl<AuditLogEntity> pageImpl = new PageImpl<>(content);
    when(auditLogRepository.findAuditLogsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<List<ActionType>>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    ArrayList<ActionType> actionTypes = new ArrayList<>();
    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, BaseEntityService.NULL_CUSTOMER_ID, actionTypes,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogEntity).setCreatedTime(eq(-1L));
    verify(auditLogEntity).setId(isA(UUID.class));
    verify(auditLogEntity).setUuid(isA(UUID.class));
    verify(auditLogEntity).setActionData(isA(JsonNode.class));
    verify(auditLogEntity).setActionFailureDetails(eq("42"));
    verify(auditLogEntity).setActionStatus(eq(ActionStatus.SUCCESS));
    verify(auditLogEntity).setActionType(eq(ActionType.UPDATED));
    verify(auditLogEntity).setCustomerId(isA(UUID.class));
    verify(auditLogEntity).setEntityId(isA(UUID.class));
    verify(auditLogEntity).setEntityName(eq("42"));
    verify(auditLogEntity).setEntityType(eq(EntityType.USER));
    verify(auditLogEntity).setTenantId(isA(UUID.class));
    verify(auditLogEntity).setUserId(isA(UUID.class));
    verify(auditLogEntity).setUserName(eq("org.thingsboard.server.dao.model.sql.AuditLogEntity"));
    verify(auditLogEntity).toData();
    verify(auditLogRepository).findAuditLogsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        eq(1L), eq(1L), isA(List.class), isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    assertSame(auditLog, data.get(0));
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<List<ActionType>>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, BaseEntityService.NULL_CUSTOMER_ID, actionTypes,
            new TimePageLink(3));

    // Assert
    verify(auditLogRepository).findAuditLogsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isNull(), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndUserId() throws IOException {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AuditLogEntity> content = new ArrayList<>();
    content.add(auditLogEntity);
    PageImpl<AuditLogEntity> pageImpl = new PageImpl<>(content);
    when(auditLogRepository.findAuditLogsByTenantIdAndUserId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<List<ActionType>>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;
    UserId userId = new UserId(ModelConstants.NULL_UUID);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndUserId(tenantId, userId, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogRepository).findAuditLogsByTenantIdAndUserId(isA(UUID.class), isA(UUID.class), isNull(), isNull(),
        isNull(), isA(List.class), isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdAndUserIdResult.getData();
    assertEquals(1, data.size());
    AuditLog getResult = data.get(0);
    JsonNode actionData = getResult.getActionData();
    Iterator<JsonNode> iteratorResult = actionData.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(actionData instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = actionData.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals("Action Failure Details", getResult.getActionFailureDetails());
    assertEquals("Entity Name", getResult.getEntityName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("janedoe", getResult.getUserName());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", actionData.toPrettyString());
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
    assertEquals(1, actionData.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, actionData.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertEquals(ActionStatus.SUCCESS, getResult.getActionStatus());
    assertEquals(ActionType.ADDED, getResult.getActionType());
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
    assertFalse(actionData.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(actionData.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(actionData.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(actionData.isBinary());
    assertFalse(actionData.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(actionData.isDouble());
    assertFalse(actionData.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(actionData.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(actionData.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(actionData.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(actionData.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(actionData.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(actionData.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(actionData.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(actionData.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(actionData.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(actionData.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(actionData.isTextual());
    assertFalse(actionData.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(actionData.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(actionData.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(customerId.isNullUid());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertEquals(userId, getResult.getUserId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, getResult.getId().getId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndUserId_givenOne_thenCallsGetPage() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndUserId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<List<ActionType>>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<ActionType> actionTypes = new ArrayList<>();
    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndUserId(ModelConstants.NULL_UUID, userId, actionTypes, pageLink);

    // Assert
    verify(userId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository).findAuditLogsByTenantIdAndUserId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        eq(1L), eq(1L), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndUserIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndUserIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link AuditLog#AuditLog()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndUserId_thenReturnDataFirstIsAuditLog() {
    // Arrange
    AuditLogEntity auditLogEntity = mock(AuditLogEntity.class);
    AuditLog auditLog = new AuditLog();
    when(auditLogEntity.toData()).thenReturn(auditLog);
    doNothing().when(auditLogEntity).setCreatedTime(anyLong());
    doNothing().when(auditLogEntity).setId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setActionData(Mockito.<JsonNode>any());
    doNothing().when(auditLogEntity).setActionFailureDetails(Mockito.<String>any());
    doNothing().when(auditLogEntity).setActionStatus(Mockito.<ActionStatus>any());
    doNothing().when(auditLogEntity).setActionType(Mockito.<ActionType>any());
    doNothing().when(auditLogEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setEntityName(Mockito.<String>any());
    doNothing().when(auditLogEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(auditLogEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setUserId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setUserName(Mockito.<String>any());
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.FAILURE);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AuditLogEntity> content = new ArrayList<>();
    content.add(auditLogEntity);
    PageImpl<AuditLogEntity> pageImpl = new PageImpl<>(content);
    when(auditLogRepository.findAuditLogsByTenantIdAndUserId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<List<ActionType>>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<ActionType> actionTypes = new ArrayList<>();
    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndUserId(ModelConstants.NULL_UUID, userId, actionTypes, pageLink);

    // Assert
    verify(userId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogEntity).setCreatedTime(eq(1L));
    verify(auditLogEntity).setId(isA(UUID.class));
    verify(auditLogEntity).setUuid(isA(UUID.class));
    verify(auditLogEntity).setActionData(isA(JsonNode.class));
    verify(auditLogEntity).setActionFailureDetails(eq("Action Failure Details"));
    verify(auditLogEntity).setActionStatus(eq(ActionStatus.FAILURE));
    verify(auditLogEntity).setActionType(eq(ActionType.ADDED));
    verify(auditLogEntity).setCustomerId(isA(UUID.class));
    verify(auditLogEntity).setEntityId(isA(UUID.class));
    verify(auditLogEntity).setEntityName(eq("Entity Name"));
    verify(auditLogEntity).setEntityType(eq(EntityType.TENANT));
    verify(auditLogEntity).setTenantId(isA(UUID.class));
    verify(auditLogEntity).setUserId(isA(UUID.class));
    verify(auditLogEntity).setUserName(eq("janedoe"));
    verify(auditLogEntity).toData();
    verify(auditLogRepository).findAuditLogsByTenantIdAndUserId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        eq(1L), eq(1L), isA(List.class), isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdAndUserIdResult.getData();
    assertEquals(1, data.size());
    assertSame(auditLog, data.get(0));
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndUserId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndUserId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<List<ActionType>>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId userId = new UserId(ModelConstants.NULL_UUID);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndUserId(ModelConstants.NULL_UUID, userId, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogRepository).findAuditLogsByTenantIdAndUserId(isA(UUID.class), isA(UUID.class), isNull(), isNull(),
        isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndUserIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndUserIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantIdAndUserId_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndUserId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<List<ActionType>>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult = jpaAuditLogDao
        .findAuditLogsByTenantIdAndUserId(ModelConstants.NULL_UUID, userId, actionTypes, new TimePageLink(3));

    // Assert
    verify(userId).getId();
    verify(auditLogRepository).findAuditLogsByTenantIdAndUserId(isA(UUID.class), isA(UUID.class), isNull(), isNull(),
        isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndUserIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndUserIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantId_givenAdded_whenArrayListAddAdded() {
    // Arrange
    when(auditLogRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<ActionType>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult = jpaAuditLogDao
        .findAuditLogsByTenantId(ModelConstants.NULL_UUID, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogRepository).findByTenantId(isA(UUID.class), isNull(), isNull(), isNull(), isA(List.class),
        isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code DELETED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantId_givenDeleted_whenArrayListAddDeleted() {
    // Arrange
    when(auditLogRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<ActionType>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult = jpaAuditLogDao
        .findAuditLogsByTenantId(ModelConstants.NULL_UUID, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogRepository).findByTenantId(isA(UUID.class), isNull(), isNull(), isNull(), isA(List.class),
        isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantId_givenOne_thenCallsGetPage() {
    // Arrange
    when(auditLogRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<ActionType>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<ActionType> actionTypes = new ArrayList<>();
    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult = jpaAuditLogDao
        .findAuditLogsByTenantId(ModelConstants.NULL_UUID, actionTypes, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository).findByTenantId(isA(UUID.class), eq("Text Search"), eq(1L), eq(1L), isA(List.class),
        isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}.
   * <ul>
   *   <li>Then Data first ActionData iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantId_thenDataFirstActionDataIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AuditLogEntity> content = new ArrayList<>();
    content.add(auditLogEntity);
    PageImpl<AuditLogEntity> pageImpl = new PageImpl<>(content);
    when(auditLogRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<ActionType>>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult = jpaAuditLogDao.findAuditLogsByTenantId(tenantId,
        actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogRepository).findByTenantId(isA(UUID.class), isNull(), isNull(), isNull(), isA(List.class),
        isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdResult.getData();
    assertEquals(1, data.size());
    AuditLog getResult = data.get(0);
    JsonNode actionData = getResult.getActionData();
    Iterator<JsonNode> iteratorResult = actionData.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(actionData instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = actionData.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals("Action Failure Details", getResult.getActionFailureDetails());
    assertEquals("Entity Name", getResult.getEntityName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("janedoe", getResult.getUserName());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", actionData.toPrettyString());
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
    assertEquals(1, actionData.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, actionData.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    UserId userId = getResult.getUserId();
    assertEquals(EntityType.USER, userId.getEntityType());
    assertEquals(ActionStatus.SUCCESS, getResult.getActionStatus());
    assertEquals(ActionType.ADDED, getResult.getActionType());
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
    assertFalse(actionData.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(actionData.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(actionData.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(actionData.isBinary());
    assertFalse(actionData.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(actionData.isDouble());
    assertFalse(actionData.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(actionData.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(actionData.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(actionData.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(actionData.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(actionData.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(actionData.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(actionData.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(actionData.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(actionData.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(actionData.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(actionData.isTextual());
    assertFalse(actionData.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(actionData.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(actionData.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(customerId.isNullUid());
    assertTrue(entityId.isNullUid());
    assertTrue(userId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, getResult.getId().getId());
    assertSame(tenantId, userId.getId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link AuditLog#AuditLog()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantId_thenReturnDataFirstIsAuditLog() {
    // Arrange
    AuditLogEntity auditLogEntity = mock(AuditLogEntity.class);
    AuditLog auditLog = new AuditLog();
    when(auditLogEntity.toData()).thenReturn(auditLog);
    doNothing().when(auditLogEntity).setCreatedTime(anyLong());
    doNothing().when(auditLogEntity).setId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setActionData(Mockito.<JsonNode>any());
    doNothing().when(auditLogEntity).setActionFailureDetails(Mockito.<String>any());
    doNothing().when(auditLogEntity).setActionStatus(Mockito.<ActionStatus>any());
    doNothing().when(auditLogEntity).setActionType(Mockito.<ActionType>any());
    doNothing().when(auditLogEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setEntityName(Mockito.<String>any());
    doNothing().when(auditLogEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(auditLogEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setUserId(Mockito.<UUID>any());
    doNothing().when(auditLogEntity).setUserName(Mockito.<String>any());
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("42");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.UPDATED);
    auditLogEntity.setCreatedTime(-1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("42");
    auditLogEntity.setEntityType(EntityType.USER);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("org.thingsboard.server.dao.model.sql.AuditLogEntity");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AuditLogEntity> content = new ArrayList<>();
    content.add(auditLogEntity);
    PageImpl<AuditLogEntity> pageImpl = new PageImpl<>(content);
    when(auditLogRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<ActionType>>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    ArrayList<ActionType> actionTypes = new ArrayList<>();
    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult = jpaAuditLogDao
        .findAuditLogsByTenantId(ModelConstants.NULL_UUID, actionTypes, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogEntity).setCreatedTime(eq(-1L));
    verify(auditLogEntity).setId(isA(UUID.class));
    verify(auditLogEntity).setUuid(isA(UUID.class));
    verify(auditLogEntity).setActionData(isA(JsonNode.class));
    verify(auditLogEntity).setActionFailureDetails(eq("42"));
    verify(auditLogEntity).setActionStatus(eq(ActionStatus.SUCCESS));
    verify(auditLogEntity).setActionType(eq(ActionType.UPDATED));
    verify(auditLogEntity).setCustomerId(isA(UUID.class));
    verify(auditLogEntity).setEntityId(isA(UUID.class));
    verify(auditLogEntity).setEntityName(eq("42"));
    verify(auditLogEntity).setEntityType(eq(EntityType.USER));
    verify(auditLogEntity).setTenantId(isA(UUID.class));
    verify(auditLogEntity).setUserId(isA(UUID.class));
    verify(auditLogEntity).setUserName(eq("org.thingsboard.server.dao.model.sql.AuditLogEntity"));
    verify(auditLogEntity).toData();
    verify(auditLogRepository).findByTenantId(isA(UUID.class), eq("Text Search"), eq(1L), eq(1L), isA(List.class),
        isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(auditLog, data.get(0));
  }

  /**
   * Test
   * {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}
   */
  @Test
  public void testFindAuditLogsByTenantId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(auditLogRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<ActionType>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult = jpaAuditLogDao
        .findAuditLogsByTenantId(ModelConstants.NULL_UUID, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogRepository).findByTenantId(isA(UUID.class), isNull(), isNull(), isNull(), isA(List.class),
        isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#cleanUpAuditLogs(long)}.
   * <p>
   * Method under test: {@link JpaAuditLogDao#cleanUpAuditLogs(long)}
   */
  @Test
  public void testCleanUpAuditLogs() {
    // Arrange
    when(sqlPartitioningRepository.dropPartitionsBefore(Mockito.<String>any(), anyLong(), anyLong())).thenReturn(1L);

    // Act
    jpaAuditLogDao.cleanUpAuditLogs(1L);

    // Assert that nothing has changed
    verify(sqlPartitioningRepository).dropPartitionsBefore(eq("audit_log"), eq(1L), eq(604800000L));
  }

  /**
   * Test {@link JpaAuditLogDao#createPartition(AuditLogEntity)} with
   * {@code AuditLogEntity}.
   * <p>
   * Method under test: {@link JpaAuditLogDao#createPartition(AuditLogEntity)}
   */
  @Test
  public void testCreatePartitionWithAuditLogEntity() {
    // Arrange
    doNothing().when(sqlPartitioningRepository).createPartitionIfNotExists(Mockito.<String>any(), anyLong(), anyLong());

    AuditLogEntity entity = new AuditLogEntity();
    entity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entity.setActionFailureDetails("Action Failure Details");
    entity.setActionStatus(ActionStatus.SUCCESS);
    entity.setActionType(ActionType.ADDED);
    entity.setCreatedTime(1L);
    entity.setCustomerId(ModelConstants.NULL_UUID);
    entity.setEntityId(ModelConstants.NULL_UUID);
    entity.setEntityName("Entity Name");
    entity.setEntityType(EntityType.TENANT);
    entity.setId(ModelConstants.NULL_UUID);
    entity.setTenantId(ModelConstants.NULL_UUID);
    entity.setUserId(ModelConstants.NULL_UUID);
    entity.setUserName("janedoe");
    entity.setUuid(ModelConstants.NULL_UUID);

    // Act
    jpaAuditLogDao.createPartition(entity);

    // Assert that nothing has changed
    verify(sqlPartitioningRepository).createPartitionIfNotExists(eq("audit_log"), eq(1L), eq(604800000L));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaAuditLogDao#getEntityClass()}
   *   <li>{@link JpaAuditLogDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaAuditLogDao jpaAuditLogDao = new JpaAuditLogDao(mock(AuditLogRepository.class),
        mock(SqlPartitioningRepository.class));

    // Act
    Class<AuditLogEntity> actualEntityClass = jpaAuditLogDao.getEntityClass();
    jpaAuditLogDao.getRepository();

    // Assert
    Class<AuditLogEntity> expectedEntityClass = AuditLogEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
