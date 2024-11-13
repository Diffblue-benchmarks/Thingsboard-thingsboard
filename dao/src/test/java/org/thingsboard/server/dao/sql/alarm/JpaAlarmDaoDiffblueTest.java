package org.thingsboard.server.dao.sql.alarm;

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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
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
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.AlarmAssignee;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.alarm.AlarmQuery;
import org.thingsboard.server.common.data.alarm.AlarmQueryV2;
import org.thingsboard.server.common.data.alarm.AlarmSearchStatus;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.alarm.AlarmStatusFilter;
import org.thingsboard.server.common.data.alarm.EntityAlarm;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.common.data.query.AlarmCountQuery;
import org.thingsboard.server.common.data.query.AlarmData;
import org.thingsboard.server.common.data.query.AlarmDataQuery;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AlarmEntity;
import org.thingsboard.server.dao.model.sql.AlarmInfoEntity;
import org.thingsboard.server.dao.model.sql.EntityAlarmEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.query.AlarmQueryRepository;

@ContextConfiguration(classes = {JpaAlarmDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaAlarmDaoDiffblueTest {
  @MockBean
  private AlarmQueryRepository alarmQueryRepository;

  @MockBean
  private AlarmRepository alarmRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityAlarmRepository entityAlarmRepository;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaAlarmDao jpaAlarmDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaAlarmDao#getEntityClass()}
   *   <li>{@link JpaAlarmDao#getEntityType()}
   *   <li>{@link JpaAlarmDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaAlarmDao jpaAlarmDao = new JpaAlarmDao();

    // Act
    Class<AlarmEntity> actualEntityClass = jpaAlarmDao.getEntityClass();
    EntityType actualEntityType = jpaAlarmDao.getEntityType();

    // Assert
    assertNull(jpaAlarmDao.getRepository());
    assertEquals(EntityType.ALARM, actualEntityType);
    Class<AlarmEntity> expectedEntityClass = AlarmEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test
   * {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestByOriginatorAndType_givenNull_uuid_thenReturnNull() {
    // Arrange
    when(alarmRepository.findLatestByOriginatorAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new ArrayList<>());
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult = jpaAlarmDao
        .findLatestByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository).findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertNull(actualFindLatestByOriginatorAndTypeResult);
  }

  /**
   * Test
   * {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   * <ul>
   *   <li>Then Originator return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestByOriginatorAndType_thenOriginatorReturnCustomerId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setAckTs(2L);
    alarmEntity2.setAcknowledged(false);
    alarmEntity2.setAssignTs(2L);
    alarmEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity2.setClearTs(2L);
    alarmEntity2.setCleared(false);
    alarmEntity2.setCreatedTime(2L);
    alarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity2.setEndTs(2L);
    alarmEntity2.setId(ModelConstants.NULL_UUID);
    alarmEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity2.setOriginatorType(EntityType.CUSTOMER);
    alarmEntity2.setPropagate(false);
    alarmEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity2.setPropagateToOwner(false);
    alarmEntity2.setPropagateToTenant(false);
    alarmEntity2.setSeverity(AlarmSeverity.MAJOR);
    alarmEntity2.setStartTs(2L);
    alarmEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity2.setType("Type");
    alarmEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmEntity> alarmEntityList = new ArrayList<>();
    alarmEntityList.add(alarmEntity2);
    alarmEntityList.add(alarmEntity);
    when(alarmRepository.findLatestByOriginatorAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(alarmEntityList);
    CustomerId originator = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult = jpaAlarmDao
        .findLatestByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(alarmRepository).findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    EntityId originator2 = actualFindLatestByOriginatorAndTypeResult.getOriginator();
    assertTrue(originator2 instanceof CustomerId);
    assertEquals(2L, actualFindLatestByOriginatorAndTypeResult.getAckTs());
    assertEquals(2L, actualFindLatestByOriginatorAndTypeResult.getAssignTs());
    assertEquals(2L, actualFindLatestByOriginatorAndTypeResult.getClearTs());
    assertEquals(2L, actualFindLatestByOriginatorAndTypeResult.getCreatedTime());
    assertEquals(2L, actualFindLatestByOriginatorAndTypeResult.getEndTs());
    assertEquals(2L, actualFindLatestByOriginatorAndTypeResult.getStartTs());
    assertEquals(AlarmSeverity.MAJOR, actualFindLatestByOriginatorAndTypeResult.getSeverity());
    assertEquals(AlarmStatus.ACTIVE_UNACK, actualFindLatestByOriginatorAndTypeResult.getStatus());
    assertFalse(actualFindLatestByOriginatorAndTypeResult.isAcknowledged());
    assertFalse(actualFindLatestByOriginatorAndTypeResult.isCleared());
    assertFalse(actualFindLatestByOriginatorAndTypeResult.isPropagate());
    assertFalse(actualFindLatestByOriginatorAndTypeResult.isPropagateToOwner());
    assertFalse(actualFindLatestByOriginatorAndTypeResult.isPropagateToTenant());
    assertEquals(originator, originator2);
  }

  /**
   * Test
   * {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   * <ul>
   *   <li>Then Originator return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestByOriginatorAndType_thenOriginatorReturnDashboardId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(-1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(-1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(-1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(-1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(-1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.DASHBOARD);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("42");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.MINOR);
    alarmEntity.setStartTs(-1L);
    alarmEntity.setTenantId(UUID.randomUUID());
    alarmEntity.setType("42");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmEntity> alarmEntityList = new ArrayList<>();
    alarmEntityList.add(alarmEntity);
    when(alarmRepository.findLatestByOriginatorAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(alarmEntityList);
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult = jpaAlarmDao
        .findLatestByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository).findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    EntityId originator2 = actualFindLatestByOriginatorAndTypeResult.getOriginator();
    assertTrue(originator2 instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, originator2.getEntityType());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   * <ul>
   *   <li>Then return PropagateRelationTypes Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestByOriginatorAndType_thenReturnPropagateRelationTypesEmpty() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(-1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(-1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(-1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(-1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(-1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.USER);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.MINOR);
    alarmEntity.setStartTs(-1L);
    UUID tenantId = UUID.randomUUID();
    alarmEntity.setTenantId(tenantId);
    alarmEntity.setType("42");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmEntity> alarmEntityList = new ArrayList<>();
    alarmEntityList.add(alarmEntity);
    when(alarmRepository.findLatestByOriginatorAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(alarmEntityList);
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult = jpaAlarmDao
        .findLatestByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository).findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertTrue(actualFindLatestByOriginatorAndTypeResult.getOriginator() instanceof UserId);
    TenantId tenantId2 = actualFindLatestByOriginatorAndTypeResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(actualFindLatestByOriginatorAndTypeResult.getPropagateRelationTypes().isEmpty());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   * <ul>
   *   <li>Then return PropagateRelationTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestByOriginatorAndType_thenReturnPropagateRelationTypesSizeIsOne() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(-1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(-1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(-1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(-1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(-1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.USER);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("42");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.MINOR);
    alarmEntity.setStartTs(-1L);
    UUID tenantId = UUID.randomUUID();
    alarmEntity.setTenantId(tenantId);
    alarmEntity.setType("42");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmEntity> alarmEntityList = new ArrayList<>();
    alarmEntityList.add(alarmEntity);
    when(alarmRepository.findLatestByOriginatorAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(alarmEntityList);
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult = jpaAlarmDao
        .findLatestByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository).findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertTrue(actualFindLatestByOriginatorAndTypeResult.getOriginator() instanceof UserId);
    List<String> propagateRelationTypes = actualFindLatestByOriginatorAndTypeResult.getPropagateRelationTypes();
    assertEquals(1, propagateRelationTypes.size());
    assertEquals("42", propagateRelationTypes.get(0));
    TenantId tenantId2 = actualFindLatestByOriginatorAndTypeResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestByOriginatorAndType_whenNull_customer_id_thenReturnNull() {
    // Arrange
    when(alarmRepository.findLatestByOriginatorAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new ArrayList<>());

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult = jpaAlarmDao
        .findLatestByOriginatorAndType(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type");

    // Assert
    verify(alarmRepository).findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertNull(actualFindLatestByOriginatorAndTypeResult);
  }

  /**
   * Test
   * {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestActiveByOriginatorAndType() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(-1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(-1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(-1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(-1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(-1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.USER);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("42");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.MINOR);
    alarmEntity.setStartTs(-1L);
    UUID tenantId = UUID.randomUUID();
    alarmEntity.setTenantId(tenantId);
    alarmEntity.setType("42");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmEntity> alarmEntityList = new ArrayList<>();
    alarmEntityList.add(alarmEntity);
    when(alarmRepository.findLatestActiveByOriginatorAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(alarmEntityList);
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult = jpaAlarmDao
        .findLatestActiveByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository).findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.getOriginator() instanceof UserId);
    List<String> propagateRelationTypes = actualFindLatestActiveByOriginatorAndTypeResult.getPropagateRelationTypes();
    assertEquals(1, propagateRelationTypes.size());
    assertEquals("42", propagateRelationTypes.get(0));
    TenantId tenantId2 = actualFindLatestActiveByOriginatorAndTypeResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestActiveByOriginatorAndType_givenNull_uuid_thenReturnNull() {
    // Arrange
    when(alarmRepository.findLatestActiveByOriginatorAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new ArrayList<>());
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult = jpaAlarmDao
        .findLatestActiveByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository).findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertNull(actualFindLatestActiveByOriginatorAndTypeResult);
  }

  /**
   * Test
   * {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   * <ul>
   *   <li>Then Originator return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestActiveByOriginatorAndType_thenOriginatorReturnCustomerId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setAckTs(2L);
    alarmEntity2.setAcknowledged(false);
    alarmEntity2.setAssignTs(2L);
    alarmEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity2.setClearTs(2L);
    alarmEntity2.setCleared(false);
    alarmEntity2.setCreatedTime(2L);
    alarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity2.setEndTs(2L);
    alarmEntity2.setId(ModelConstants.NULL_UUID);
    alarmEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity2.setOriginatorType(EntityType.CUSTOMER);
    alarmEntity2.setPropagate(false);
    alarmEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity2.setPropagateToOwner(false);
    alarmEntity2.setPropagateToTenant(false);
    alarmEntity2.setSeverity(AlarmSeverity.MAJOR);
    alarmEntity2.setStartTs(2L);
    alarmEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity2.setType("Type");
    alarmEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmEntity> alarmEntityList = new ArrayList<>();
    alarmEntityList.add(alarmEntity2);
    alarmEntityList.add(alarmEntity);
    when(alarmRepository.findLatestActiveByOriginatorAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(alarmEntityList);
    CustomerId originator = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult = jpaAlarmDao
        .findLatestActiveByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(alarmRepository).findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    EntityId originator2 = actualFindLatestActiveByOriginatorAndTypeResult.getOriginator();
    assertTrue(originator2 instanceof CustomerId);
    assertEquals(2L, actualFindLatestActiveByOriginatorAndTypeResult.getAckTs());
    assertEquals(2L, actualFindLatestActiveByOriginatorAndTypeResult.getAssignTs());
    assertEquals(2L, actualFindLatestActiveByOriginatorAndTypeResult.getClearTs());
    assertEquals(2L, actualFindLatestActiveByOriginatorAndTypeResult.getCreatedTime());
    assertEquals(2L, actualFindLatestActiveByOriginatorAndTypeResult.getEndTs());
    assertEquals(2L, actualFindLatestActiveByOriginatorAndTypeResult.getStartTs());
    assertEquals(AlarmSeverity.MAJOR, actualFindLatestActiveByOriginatorAndTypeResult.getSeverity());
    assertEquals(AlarmStatus.ACTIVE_UNACK, actualFindLatestActiveByOriginatorAndTypeResult.getStatus());
    assertFalse(actualFindLatestActiveByOriginatorAndTypeResult.isAcknowledged());
    assertFalse(actualFindLatestActiveByOriginatorAndTypeResult.isCleared());
    assertFalse(actualFindLatestActiveByOriginatorAndTypeResult.isPropagate());
    assertFalse(actualFindLatestActiveByOriginatorAndTypeResult.isPropagateToOwner());
    assertFalse(actualFindLatestActiveByOriginatorAndTypeResult.isPropagateToTenant());
    assertEquals(originator, originator2);
  }

  /**
   * Test
   * {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   * <ul>
   *   <li>Then Originator return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestActiveByOriginatorAndType_thenOriginatorReturnDashboardId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(-1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(-1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(-1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(-1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(-1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.DASHBOARD);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("42");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.MINOR);
    alarmEntity.setStartTs(-1L);
    alarmEntity.setTenantId(UUID.randomUUID());
    alarmEntity.setType("42");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmEntity> alarmEntityList = new ArrayList<>();
    alarmEntityList.add(alarmEntity);
    when(alarmRepository.findLatestActiveByOriginatorAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(alarmEntityList);
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult = jpaAlarmDao
        .findLatestActiveByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository).findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    EntityId originator2 = actualFindLatestActiveByOriginatorAndTypeResult.getOriginator();
    assertTrue(originator2 instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, originator2.getEntityType());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   * <ul>
   *   <li>Then return PropagateRelationTypes Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestActiveByOriginatorAndType_thenReturnPropagateRelationTypesEmpty() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(-1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(-1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(-1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(-1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(-1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.USER);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.MINOR);
    alarmEntity.setStartTs(-1L);
    UUID tenantId = UUID.randomUUID();
    alarmEntity.setTenantId(tenantId);
    alarmEntity.setType("42");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmEntity> alarmEntityList = new ArrayList<>();
    alarmEntityList.add(alarmEntity);
    when(alarmRepository.findLatestActiveByOriginatorAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(alarmEntityList);
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult = jpaAlarmDao
        .findLatestActiveByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository).findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.getOriginator() instanceof UserId);
    TenantId tenantId2 = actualFindLatestActiveByOriginatorAndTypeResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.getPropagateRelationTypes().isEmpty());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestActiveByOriginatorAndType_whenNull_customer_id_thenReturnNull() {
    // Arrange
    when(alarmRepository.findLatestActiveByOriginatorAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new ArrayList<>());

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult = jpaAlarmDao
        .findLatestActiveByOriginatorAndType(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type");

    // Assert
    verify(alarmRepository).findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertNull(actualFindLatestActiveByOriginatorAndTypeResult);
  }

  /**
   * Test
   * {@link JpaAlarmDao#findLatestByOriginatorAndTypeAsync(TenantId, EntityId, String)}.
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findLatestByOriginatorAndTypeAsync(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestByOriginatorAndTypeAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Alarm> actualFindLatestByOriginatorAndTypeAsyncResult = jpaAlarmDao
        .findLatestByOriginatorAndTypeAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindLatestByOriginatorAndTypeAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindLatestByOriginatorAndTypeAsyncResult);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link CrudRepository#findById(Object)}
   * return empty.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmById_givenAlarmRepositoryFindByIdReturnEmpty_thenReturnNull() {
    // Arrange
    Optional<AlarmEntity> emptyResult = Optional.empty();
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(emptyResult);

    // Act
    Alarm actualFindAlarmByIdResult = jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    assertNull(actualFindAlarmByIdResult);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   * <ul>
   *   <li>Then Originator return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmById_thenOriginatorReturnAlarmId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.ALARM);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<AlarmEntity> ofResult = Optional.of(alarmEntity);
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);

    // Act
    Alarm actualFindAlarmByIdResult = jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    assertTrue(actualFindAlarmByIdResult.getOriginator() instanceof AlarmId);
    TenantId tenantId = actualFindAlarmByIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   * <ul>
   *   <li>Then Originator return {@link AssetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmById_thenOriginatorReturnAssetId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.ASSET);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<AlarmEntity> ofResult = Optional.of(alarmEntity);
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    UUID key = ModelConstants.NULL_UUID;

    // Act
    Alarm actualFindAlarmByIdResult = jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, key);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    EntityId originator = actualFindAlarmByIdResult.getOriginator();
    assertTrue(originator instanceof AssetId);
    assertEquals(EntityType.ASSET, originator.getEntityType());
    assertSame(key, originator.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   * <ul>
   *   <li>Then Originator return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmById_thenOriginatorReturnCustomerId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.CUSTOMER);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<AlarmEntity> ofResult = Optional.of(alarmEntity);
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);

    // Act
    Alarm actualFindAlarmByIdResult = jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    assertTrue(actualFindAlarmByIdResult.getOriginator() instanceof CustomerId);
    TenantId tenantId = actualFindAlarmByIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   * <ul>
   *   <li>Then Originator return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmById_thenOriginatorReturnDashboardId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.DASHBOARD);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<AlarmEntity> ofResult = Optional.of(alarmEntity);
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    UUID key = ModelConstants.NULL_UUID;

    // Act
    Alarm actualFindAlarmByIdResult = jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, key);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    EntityId originator = actualFindAlarmByIdResult.getOriginator();
    assertTrue(originator instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, originator.getEntityType());
    assertSame(key, originator.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   * <ul>
   *   <li>Then Originator return {@link DeviceId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmById_thenOriginatorReturnDeviceId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.DEVICE);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<AlarmEntity> ofResult = Optional.of(alarmEntity);
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    UUID key = ModelConstants.NULL_UUID;

    // Act
    Alarm actualFindAlarmByIdResult = jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, key);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    EntityId originator = actualFindAlarmByIdResult.getOriginator();
    assertTrue(originator instanceof DeviceId);
    assertEquals(EntityType.DEVICE, originator.getEntityType());
    assertSame(key, originator.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   * <ul>
   *   <li>Then Originator return {@link EntityViewId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmById_thenOriginatorReturnEntityViewId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.ENTITY_VIEW);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<AlarmEntity> ofResult = Optional.of(alarmEntity);
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    UUID key = ModelConstants.NULL_UUID;

    // Act
    Alarm actualFindAlarmByIdResult = jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, key);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    EntityId originator = actualFindAlarmByIdResult.getOriginator();
    assertTrue(originator instanceof EntityViewId);
    assertEquals(EntityType.ENTITY_VIEW, originator.getEntityType());
    assertSame(key, originator.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   * <ul>
   *   <li>Then Originator return {@link RuleChainId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmById_thenOriginatorReturnRuleChainId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.RULE_CHAIN);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<AlarmEntity> ofResult = Optional.of(alarmEntity);
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    UUID key = ModelConstants.NULL_UUID;

    // Act
    Alarm actualFindAlarmByIdResult = jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, key);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    EntityId originator = actualFindAlarmByIdResult.getOriginator();
    assertTrue(originator instanceof RuleChainId);
    assertEquals(EntityType.RULE_CHAIN, originator.getEntityType());
    assertSame(key, originator.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   * <ul>
   *   <li>Then Originator return {@link RuleNodeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmById_thenOriginatorReturnRuleNodeId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.RULE_NODE);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<AlarmEntity> ofResult = Optional.of(alarmEntity);
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    UUID key = ModelConstants.NULL_UUID;

    // Act
    Alarm actualFindAlarmByIdResult = jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, key);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    EntityId originator = actualFindAlarmByIdResult.getOriginator();
    assertTrue(originator instanceof RuleNodeId);
    assertEquals(EntityType.RULE_NODE, originator.getEntityType());
    assertSame(key, originator.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   * <ul>
   *   <li>Then Originator return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmById_thenOriginatorReturnTenantId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    UUID originatorId = UUID.randomUUID();
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<AlarmEntity> ofResult = Optional.of(alarmEntity);
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);

    // Act
    Alarm actualFindAlarmByIdResult = jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    EntityId originator = actualFindAlarmByIdResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertFalse(originator.isNullUid());
    assertFalse(((TenantId) originator).isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   * <ul>
   *   <li>Then Originator return {@link UserId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmById_thenOriginatorReturnUserId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.USER);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<AlarmEntity> ofResult = Optional.of(alarmEntity);
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);

    // Act
    Alarm actualFindAlarmByIdResult = jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    assertTrue(actualFindAlarmByIdResult.getOriginator() instanceof UserId);
    TenantId tenantId = actualFindAlarmByIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@link AlarmInfo#AlarmInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmInfoById_thenReturnAlarmInfo() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = mock(AlarmInfoEntity.class);
    AlarmInfo alarmInfo = new AlarmInfo();
    when(alarmInfoEntity.toData()).thenReturn(alarmInfo);
    doNothing().when(alarmInfoEntity).setCreatedTime(anyLong());
    doNothing().when(alarmInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(alarmInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(alarmInfoEntity).setAckTs(Mockito.<Long>any());
    doNothing().when(alarmInfoEntity).setAcknowledged(anyBoolean());
    doNothing().when(alarmInfoEntity).setAssignTs(Mockito.<Long>any());
    doNothing().when(alarmInfoEntity).setAssigneeId(Mockito.<UUID>any());
    doNothing().when(alarmInfoEntity).setClearTs(Mockito.<Long>any());
    doNothing().when(alarmInfoEntity).setCleared(anyBoolean());
    doNothing().when(alarmInfoEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(alarmInfoEntity).setDetails(Mockito.<JsonNode>any());
    doNothing().when(alarmInfoEntity).setEndTs(Mockito.<Long>any());
    doNothing().when(alarmInfoEntity).setOriginatorId(Mockito.<UUID>any());
    doNothing().when(alarmInfoEntity).setOriginatorType(Mockito.<EntityType>any());
    doNothing().when(alarmInfoEntity).setPropagate(Mockito.<Boolean>any());
    doNothing().when(alarmInfoEntity).setPropagateRelationTypes(Mockito.<String>any());
    doNothing().when(alarmInfoEntity).setPropagateToOwner(Mockito.<Boolean>any());
    doNothing().when(alarmInfoEntity).setPropagateToTenant(Mockito.<Boolean>any());
    doNothing().when(alarmInfoEntity).setSeverity(Mockito.<AlarmSeverity>any());
    doNothing().when(alarmInfoEntity).setStartTs(Mockito.<Long>any());
    doNothing().when(alarmInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(alarmInfoEntity).setType(Mockito.<String>any());
    doNothing().when(alarmInfoEntity).setAssigneeEmail(Mockito.<String>any());
    doNothing().when(alarmInfoEntity).setAssigneeFirstName(Mockito.<String>any());
    doNothing().when(alarmInfoEntity).setAssigneeLastName(Mockito.<String>any());
    doNothing().when(alarmInfoEntity).setOriginatorLabel(Mockito.<String>any());
    doNothing().when(alarmInfoEntity).setOriginatorName(Mockito.<String>any());
    doNothing().when(alarmInfoEntity).setStatus(Mockito.<String>any());
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);
    when(alarmRepository.findAlarmInfoById(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(alarmInfoEntity);

    // Act
    AlarmInfo actualFindAlarmInfoByIdResult = jpaAlarmDao.findAlarmInfoById(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(alarmInfoEntity).setCreatedTime(eq(1L));
    verify(alarmInfoEntity).setId(isA(UUID.class));
    verify(alarmInfoEntity).setUuid(isA(UUID.class));
    verify(alarmInfoEntity).setAckTs(eq(1L));
    verify(alarmInfoEntity).setAcknowledged(eq(true));
    verify(alarmInfoEntity).setAssignTs(eq(1L));
    verify(alarmInfoEntity).setAssigneeId(isA(UUID.class));
    verify(alarmInfoEntity).setClearTs(eq(1L));
    verify(alarmInfoEntity).setCleared(eq(true));
    verify(alarmInfoEntity).setCustomerId(isA(UUID.class));
    verify(alarmInfoEntity).setDetails(isA(JsonNode.class));
    verify(alarmInfoEntity).setEndTs(eq(1L));
    verify(alarmInfoEntity).setOriginatorId(isA(UUID.class));
    verify(alarmInfoEntity).setOriginatorType(eq(EntityType.TENANT));
    verify(alarmInfoEntity).setPropagate(eq(true));
    verify(alarmInfoEntity).setPropagateRelationTypes(eq("Propagate Relation Types"));
    verify(alarmInfoEntity).setPropagateToOwner(eq(true));
    verify(alarmInfoEntity).setPropagateToTenant(eq(true));
    verify(alarmInfoEntity).setSeverity(eq(AlarmSeverity.CRITICAL));
    verify(alarmInfoEntity).setStartTs(eq(1L));
    verify(alarmInfoEntity).setTenantId(isA(UUID.class));
    verify(alarmInfoEntity).setType(eq("Type"));
    verify(alarmInfoEntity).setAssigneeEmail(eq("jane.doe@example.org"));
    verify(alarmInfoEntity).setAssigneeFirstName(eq("Jane"));
    verify(alarmInfoEntity).setAssigneeLastName(eq("Doe"));
    verify(alarmInfoEntity).setOriginatorLabel(eq("Originator Label"));
    verify(alarmInfoEntity).setOriginatorName(eq("Originator Name"));
    verify(alarmInfoEntity).setStatus(eq("Status"));
    verify(alarmInfoEntity).toData();
    verify(alarmRepository).findAlarmInfoById(isA(UUID.class), isA(UUID.class));
    assertSame(alarmInfo, actualFindAlarmInfoByIdResult);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmByIdAsync(TenantId, UUID)}.
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarmByIdAsync(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmByIdAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Alarm> actualFindAlarmByIdAsyncResult = jpaAlarmDao
        .findAlarmByIdAsync(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAlarmByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAlarmByIdAsyncResult);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  public void testFindAlarms() {
    // Arrange
    when(alarmRepository.findAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);
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
    PageData<AlarmInfo> actualFindAlarmsResult = jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT,
        new AlarmQuery(affectedEntityId, pageLink, AlarmSearchStatus.ANY, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    verify(affectedEntityId).getEntityType();
    verify(affectedEntityId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository).findAlarms(isA(UUID.class), isA(UUID.class), eq("TENANT"), eq(1L), eq(1L), eq(false),
        eq(false), eq(false), eq(false), isNull(), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  public void testFindAlarms2() {
    // Arrange
    when(alarmRepository.findAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);
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
    PageData<AlarmInfo> actualFindAlarmsResult = jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT,
        new AlarmQuery(affectedEntityId, pageLink, null, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    verify(affectedEntityId).getEntityType();
    verify(affectedEntityId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository).findAlarms(isA(UUID.class), isA(UUID.class), eq("TENANT"), eq(1L), eq(1L), eq(true),
        eq(false), eq(true), eq(false), isNull(), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  public void testFindAlarms3() {
    // Arrange
    when(alarmRepository.findAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);
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
    PageData<AlarmInfo> actualFindAlarmsResult = jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT,
        new AlarmQuery(affectedEntityId, pageLink, AlarmSearchStatus.ACTIVE, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    verify(affectedEntityId).getEntityType();
    verify(affectedEntityId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository).findAlarms(isA(UUID.class), isA(UUID.class), eq("TENANT"), eq(1L), eq(1L), eq(true),
        eq(false), eq(false), eq(false), isNull(), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  public void testFindAlarms4() {
    // Arrange
    when(alarmRepository.findAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);
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
    PageData<AlarmInfo> actualFindAlarmsResult = jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT,
        new AlarmQuery(affectedEntityId, pageLink, AlarmSearchStatus.CLEARED, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    verify(affectedEntityId).getEntityType();
    verify(affectedEntityId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository).findAlarms(isA(UUID.class), isA(UUID.class), eq("TENANT"), eq(1L), eq(1L), eq(true),
        eq(true), eq(false), eq(false), isNull(), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  public void testFindAlarms5() {
    // Arrange
    when(alarmRepository.findAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);
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
    PageData<AlarmInfo> actualFindAlarmsResult = jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT,
        new AlarmQuery(affectedEntityId, pageLink, AlarmSearchStatus.ACK, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    verify(affectedEntityId).getEntityType();
    verify(affectedEntityId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository).findAlarms(isA(UUID.class), isA(UUID.class), eq("TENANT"), eq(1L), eq(1L), eq(false),
        eq(false), eq(true), eq(true), isNull(), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   * <ul>
   *   <li>Then Data first Details iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  public void testFindAlarms_thenDataFirstDetailsIteratorNextReturnBooleanNode() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(2L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(2L);
    alarmInfoEntity.setAssigneeEmail("prof.einstein@example.org");
    alarmInfoEntity.setAssigneeFirstName("Albert");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Einstein");
    alarmInfoEntity.setClearTs(2L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(2L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(2L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("org.thingsboard.server.dao.model.sql.AlarmInfoEntity");
    alarmInfoEntity.setOriginatorName("org.thingsboard.server.dao.model.sql.AlarmInfoEntity");
    alarmInfoEntity.setOriginatorType(EntityType.USER);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("org.thingsboard.server.dao.model.sql.AlarmInfoEntity");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.MINOR);
    alarmInfoEntity.setStartTs(2L);
    alarmInfoEntity.setStatus("org.thingsboard.server.dao.model.sql.AlarmInfoEntity");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("org.thingsboard.server.dao.model.sql.AlarmInfoEntity");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity);
    PageImpl<AlarmInfoEntity> pageImpl = new PageImpl<>(content);
    when(alarmRepository.findAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);
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
    PageData<AlarmInfo> actualFindAlarmsResult = jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT,
        new AlarmQuery(affectedEntityId, pageLink, AlarmSearchStatus.ANY, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    verify(affectedEntityId).getEntityType();
    verify(affectedEntityId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository).findAlarms(isA(UUID.class), isA(UUID.class), eq("TENANT"), eq(1L), eq(1L), eq(false),
        eq(false), eq(false), eq(false), isNull(), eq("Text Search"), isA(Pageable.class));
    List<AlarmInfo> data = actualFindAlarmsResult.getData();
    assertEquals(1, data.size());
    AlarmInfo getResult = data.get(0);
    JsonNode details = getResult.getDetails();
    Iterator<JsonNode> iteratorResult = details.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(details instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(details.traverse() instanceof TreeTraversingParser);
    EntityId originator = getResult.getOriginator();
    assertTrue(originator instanceof UserId);
    AlarmAssignee assignee = getResult.getAssignee();
    assertEquals("Albert Einstein", assignee.getTitle());
    assertEquals("Albert", assignee.getFirstName());
    assertEquals("Einstein", assignee.getLastName());
    List<String> propagateRelationTypes = getResult.getPropagateRelationTypes();
    assertEquals(1, propagateRelationTypes.size());
    assertEquals("org.thingsboard.server.dao.model.sql.AlarmInfoEntity", propagateRelationTypes.get(0));
    assertEquals("org.thingsboard.server.dao.model.sql.AlarmInfoEntity", getResult.getName());
    assertEquals("org.thingsboard.server.dao.model.sql.AlarmInfoEntity", getResult.getType());
    assertEquals("org.thingsboard.server.dao.model.sql.AlarmInfoEntity", getResult.getOriginatorLabel());
    assertEquals("org.thingsboard.server.dao.model.sql.AlarmInfoEntity", getResult.getOriginatorName());
    assertEquals("prof.einstein@example.org", assignee.getEmail());
    assertEquals(2L, getResult.getAckTs());
    assertEquals(2L, getResult.getAssignTs());
    assertEquals(2L, getResult.getClearTs());
    assertEquals(2L, getResult.getCreatedTime());
    assertEquals(2L, getResult.getEndTs());
    assertEquals(2L, getResult.getStartTs());
    assertEquals(AlarmSeverity.MINOR, getResult.getSeverity());
    assertFalse(iteratorResult.hasNext());
    UserId assigneeId = getResult.getAssigneeId();
    assertEquals(assigneeId, assignee.getId());
    assertEquals(assigneeId, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   * <ul>
   *   <li>When {@link TimePageLink#TimePageLink(int)} with pageSize is three.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  public void testFindAlarms_whenTimePageLinkWithPageSizeIsThree_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmRepository.findAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult = jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, new AlarmQuery(
        affectedEntityId, new TimePageLink(3), AlarmSearchStatus.ANY, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    verify(affectedEntityId).getEntityType();
    verify(affectedEntityId).getId();
    verify(alarmRepository).findAlarms(isA(UUID.class), isA(UUID.class), eq("TENANT"), isNull(), isNull(), eq(false),
        eq(false), eq(false), eq(false), isNull(), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   * <ul>
   *   <li>When {@link UserId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  public void testFindAlarms_whenUserIdGetIdReturnNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmRepository.findAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);
    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult = jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT,
        new AlarmQuery(affectedEntityId, pageLink, AlarmSearchStatus.ANY, AlarmStatus.ACTIVE_UNACK, assigneeId, true));

    // Assert
    verify(affectedEntityId).getEntityType();
    verify(affectedEntityId).getId();
    verify(assigneeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository).findAlarms(isA(UUID.class), isA(UUID.class), eq("TENANT"), eq(1L), eq(1L), eq(false),
        eq(false), eq(false), eq(false), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  public void testFindAlarms_whenUserIdWithIdIsNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmRepository.findAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Long>any(), Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);
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
    PageData<AlarmInfo> actualFindAlarmsResult = jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT,
        new AlarmQuery(affectedEntityId, pageLink, AlarmSearchStatus.ANY, AlarmStatus.ACTIVE_UNACK,
            new UserId(ModelConstants.NULL_UUID), true));

    // Assert
    verify(affectedEntityId).getEntityType();
    verify(affectedEntityId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository).findAlarms(isA(UUID.class), isA(UUID.class), eq("TENANT"), eq(1L), eq(1L), eq(false),
        eq(false), eq(false), eq(false), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  public void testFindCustomerAlarms() {
    // Arrange
    when(alarmRepository.findCustomerAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
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
    PageData<AlarmInfo> actualFindCustomerAlarmsResult = jpaAlarmDao.findCustomerAlarms(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        new AlarmQuery(mock(AlarmId.class), pageLink, AlarmSearchStatus.ANY, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository).findCustomerAlarms(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L), eq(false), eq(false),
        eq(false), eq(false), isNull(), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsResult.getTotalPages());
    assertFalse(actualFindCustomerAlarmsResult.hasNext());
    assertTrue(actualFindCustomerAlarmsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  public void testFindCustomerAlarms2() {
    // Arrange
    when(alarmRepository.findCustomerAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
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
    PageData<AlarmInfo> actualFindCustomerAlarmsResult = jpaAlarmDao.findCustomerAlarms(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        new AlarmQuery(mock(AlarmId.class), pageLink, AlarmSearchStatus.ACTIVE, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository).findCustomerAlarms(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L), eq(true), eq(false),
        eq(false), eq(false), isNull(), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsResult.getTotalPages());
    assertFalse(actualFindCustomerAlarmsResult.hasNext());
    assertTrue(actualFindCustomerAlarmsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  public void testFindCustomerAlarms3() {
    // Arrange
    when(alarmRepository.findCustomerAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
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
    PageData<AlarmInfo> actualFindCustomerAlarmsResult = jpaAlarmDao.findCustomerAlarms(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        new AlarmQuery(mock(AlarmId.class), pageLink, AlarmSearchStatus.CLEARED, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository).findCustomerAlarms(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L), eq(true), eq(true),
        eq(false), eq(false), isNull(), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsResult.getTotalPages());
    assertFalse(actualFindCustomerAlarmsResult.hasNext());
    assertTrue(actualFindCustomerAlarmsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  public void testFindCustomerAlarms4() {
    // Arrange
    when(alarmRepository.findCustomerAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
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
    PageData<AlarmInfo> actualFindCustomerAlarmsResult = jpaAlarmDao.findCustomerAlarms(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        new AlarmQuery(mock(AlarmId.class), pageLink, AlarmSearchStatus.ACK, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository).findCustomerAlarms(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L), eq(false), eq(false),
        eq(true), eq(true), isNull(), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsResult.getTotalPages());
    assertFalse(actualFindCustomerAlarmsResult.hasNext());
    assertTrue(actualFindCustomerAlarmsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  public void testFindCustomerAlarms_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(alarmRepository.findCustomerAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult = jpaAlarmDao.findCustomerAlarms(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, new AlarmQuery(mock(AlarmId.class), pageLink, AlarmSearchStatus.ANY,
            AlarmStatus.ACTIVE_UNACK, assigneeId, true));

    // Assert
    verify(assigneeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository).findCustomerAlarms(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L), eq(false), eq(false),
        eq(false), eq(false), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsResult.getTotalPages());
    assertFalse(actualFindCustomerAlarmsResult.hasNext());
    assertTrue(actualFindCustomerAlarmsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   * <ul>
   *   <li>Then Data first Details iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  public void testFindCustomerAlarms_thenDataFirstDetailsIteratorNextReturnBooleanNode() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(3L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(3L);
    alarmInfoEntity.setAssigneeEmail("prof.einstein@example.org");
    alarmInfoEntity.setAssigneeFirstName("Albert");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Einstein");
    alarmInfoEntity.setClearTs(3L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(3L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(3L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("org.thingsboard.server.dao.model.sql.AlarmInfoEntity");
    alarmInfoEntity.setOriginatorName("org.thingsboard.server.dao.model.sql.AlarmInfoEntity");
    alarmInfoEntity.setOriginatorType(EntityType.USER);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("org.thingsboard.server.dao.model.sql.AlarmInfoEntity");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.MINOR);
    alarmInfoEntity.setStartTs(3L);
    alarmInfoEntity.setStatus("org.thingsboard.server.dao.model.sql.AlarmInfoEntity");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("org.thingsboard.server.dao.model.sql.AlarmInfoEntity");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity);
    PageImpl<AlarmInfoEntity> pageImpl = new PageImpl<>(content);
    when(alarmRepository.findCustomerAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
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
    PageData<AlarmInfo> actualFindCustomerAlarmsResult = jpaAlarmDao.findCustomerAlarms(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        new AlarmQuery(mock(AlarmId.class), pageLink, AlarmSearchStatus.ANY, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository).findCustomerAlarms(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L), eq(false), eq(false),
        eq(false), eq(false), isNull(), eq("Text Search"), isA(Pageable.class));
    List<AlarmInfo> data = actualFindCustomerAlarmsResult.getData();
    assertEquals(1, data.size());
    AlarmInfo getResult = data.get(0);
    JsonNode details = getResult.getDetails();
    Iterator<JsonNode> iteratorResult = details.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(details instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(details.traverse() instanceof TreeTraversingParser);
    EntityId originator = getResult.getOriginator();
    assertTrue(originator instanceof UserId);
    AlarmAssignee assignee = getResult.getAssignee();
    assertEquals("Albert Einstein", assignee.getTitle());
    assertEquals("Albert", assignee.getFirstName());
    assertEquals("Einstein", assignee.getLastName());
    List<String> propagateRelationTypes = getResult.getPropagateRelationTypes();
    assertEquals(1, propagateRelationTypes.size());
    assertEquals("org.thingsboard.server.dao.model.sql.AlarmInfoEntity", propagateRelationTypes.get(0));
    assertEquals("org.thingsboard.server.dao.model.sql.AlarmInfoEntity", getResult.getName());
    assertEquals("org.thingsboard.server.dao.model.sql.AlarmInfoEntity", getResult.getType());
    assertEquals("org.thingsboard.server.dao.model.sql.AlarmInfoEntity", getResult.getOriginatorLabel());
    assertEquals("org.thingsboard.server.dao.model.sql.AlarmInfoEntity", getResult.getOriginatorName());
    assertEquals("prof.einstein@example.org", assignee.getEmail());
    assertEquals(3L, getResult.getAckTs());
    assertEquals(3L, getResult.getAssignTs());
    assertEquals(3L, getResult.getClearTs());
    assertEquals(3L, getResult.getCreatedTime());
    assertEquals(3L, getResult.getEndTs());
    assertEquals(3L, getResult.getStartTs());
    assertEquals(AlarmSeverity.MINOR, getResult.getSeverity());
    assertFalse(iteratorResult.hasNext());
    UserId assigneeId = getResult.getAssigneeId();
    assertEquals(assigneeId, assignee.getId());
    assertEquals(assigneeId, originator);
  }

  /**
   * Test
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  public void testFindCustomerAlarms_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmRepository.findCustomerAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId affectedEntityId = mock(AlarmId.class);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult = jpaAlarmDao.findCustomerAlarms(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, new AlarmQuery(affectedEntityId, new TimePageLink(3), AlarmSearchStatus.ANY,
            AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    verify(alarmRepository).findCustomerAlarms(isA(UUID.class), isA(UUID.class), isNull(), isNull(), eq(false),
        eq(false), eq(false), eq(false), isNull(), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsResult.getTotalPages());
    assertFalse(actualFindCustomerAlarmsResult.hasNext());
    assertTrue(actualFindCustomerAlarmsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  public void testFindCustomerAlarms_whenUserIdWithIdIsNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmRepository.findCustomerAlarms(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    AlarmId affectedEntityId = mock(AlarmId.class);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult = jpaAlarmDao.findCustomerAlarms(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, new AlarmQuery(affectedEntityId, pageLink, AlarmSearchStatus.ANY,
            AlarmStatus.ACTIVE_UNACK, new UserId(ModelConstants.NULL_UUID), true));

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository).findCustomerAlarms(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L), eq(false), eq(false),
        eq(false), eq(false), isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsResult.getTotalPages());
    assertFalse(actualFindCustomerAlarmsResult.hasNext());
    assertTrue(actualFindCustomerAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  public void testFindAlarmsV2_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmRepository.findAllAlarmsV2(Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<List<String>>any(), Mockito.<List<AlarmSeverity>>any(), anyBoolean(), anyBoolean(), anyBoolean(),
        anyBoolean(), Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmQueryV2.AlarmQueryV2Builder alarmQueryV2Builder = mock(AlarmQueryV2.AlarmQueryV2Builder.class);
    when(alarmQueryV2Builder.affectedEntityId(Mockito.<EntityId>any())).thenReturn(AlarmQueryV2.builder());
    AlarmQueryV2.AlarmQueryV2Builder assigneeIdResult = alarmQueryV2Builder
        .affectedEntityId(BaseEntityService.NULL_CUSTOMER_ID)
        .assigneeId(null);
    AlarmQueryV2.AlarmQueryV2Builder pageLinkResult = assigneeIdResult.pageLink(new TimePageLink(3));
    AlarmQueryV2.AlarmQueryV2Builder severityListResult = pageLinkResult.severityList(new ArrayList<>());
    AlarmQueryV2.AlarmQueryV2Builder statusListResult = severityListResult.statusList(new ArrayList<>());
    AlarmQueryV2 query = statusListResult.typeList(new ArrayList<>()).build();

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result = jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(alarmQueryV2Builder).affectedEntityId(isA(EntityId.class));
    verify(alarmRepository).findAllAlarmsV2(isA(UUID.class), isNull(), isNull(), isNull(), isNull(), eq(false),
        eq(false), eq(false), eq(false), isNull(), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindAlarmsV2Result.getTotalPages());
    assertFalse(actualFindAlarmsV2Result.hasNext());
    assertTrue(actualFindAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}
   */
  @Test
  public void testFindCustomerAlarmsV2_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmRepository.findCustomerAlarmsV2(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<List<String>>any(), Mockito.<List<AlarmSeverity>>any(), anyBoolean(),
        anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmQueryV2.AlarmQueryV2Builder alarmQueryV2Builder = mock(AlarmQueryV2.AlarmQueryV2Builder.class);
    when(alarmQueryV2Builder.affectedEntityId(Mockito.<EntityId>any())).thenReturn(AlarmQueryV2.builder());
    AlarmQueryV2.AlarmQueryV2Builder assigneeIdResult = alarmQueryV2Builder
        .affectedEntityId(BaseEntityService.NULL_CUSTOMER_ID)
        .assigneeId(null);
    AlarmQueryV2.AlarmQueryV2Builder pageLinkResult = assigneeIdResult.pageLink(new TimePageLink(3));
    AlarmQueryV2.AlarmQueryV2Builder severityListResult = pageLinkResult.severityList(new ArrayList<>());
    AlarmQueryV2.AlarmQueryV2Builder statusListResult = severityListResult.statusList(new ArrayList<>());
    AlarmQueryV2 query = statusListResult.typeList(new ArrayList<>()).build();

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsV2Result = jpaAlarmDao
        .findCustomerAlarmsV2(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(alarmQueryV2Builder).affectedEntityId(isA(EntityId.class));
    verify(alarmRepository).findCustomerAlarmsV2(isA(UUID.class), isA(UUID.class), isNull(), isNull(), isNull(),
        isNull(), eq(false), eq(false), eq(false), eq(false), isNull(), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsV2Result.getTotalPages());
    assertFalse(actualFindCustomerAlarmsV2Result.hasNext());
    assertTrue(actualFindCustomerAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}
   */
  @Test
  public void testFindAlarmDataByQueryForEntities_givenNull_customer_id() {
    // Arrange
    PageData<AlarmData> emptyPageDataResult = PageData.emptyPageData();
    when(alarmQueryRepository.findAlarmDataByQueryForEntities(Mockito.<TenantId>any(), Mockito.<AlarmDataQuery>any(),
        Mockito.<Collection<EntityId>>any())).thenReturn(emptyPageDataResult);
    AlarmDataQuery query = new AlarmDataQuery();

    ArrayList<EntityId> orderedEntityIds = new ArrayList<>();
    orderedEntityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    PageData<AlarmData> actualFindAlarmDataByQueryForEntitiesResult = jpaAlarmDao
        .findAlarmDataByQueryForEntities(ModelConstants.SYSTEM_TENANT, query, orderedEntityIds);

    // Assert
    verify(alarmQueryRepository).findAlarmDataByQueryForEntities(isA(TenantId.class), isA(AlarmDataQuery.class),
        isA(Collection.class));
    assertSame(actualFindAlarmDataByQueryForEntitiesResult.EMPTY_PAGE_DATA,
        actualFindAlarmDataByQueryForEntitiesResult);
  }

  /**
   * Test
   * {@link JpaAlarmDao#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}
   */
  @Test
  public void testFindAlarmDataByQueryForEntities_givenNull_customer_id2() {
    // Arrange
    PageData<AlarmData> emptyPageDataResult = PageData.emptyPageData();
    when(alarmQueryRepository.findAlarmDataByQueryForEntities(Mockito.<TenantId>any(), Mockito.<AlarmDataQuery>any(),
        Mockito.<Collection<EntityId>>any())).thenReturn(emptyPageDataResult);
    AlarmDataQuery query = new AlarmDataQuery();

    ArrayList<EntityId> orderedEntityIds = new ArrayList<>();
    orderedEntityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    orderedEntityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    PageData<AlarmData> actualFindAlarmDataByQueryForEntitiesResult = jpaAlarmDao
        .findAlarmDataByQueryForEntities(ModelConstants.SYSTEM_TENANT, query, orderedEntityIds);

    // Assert
    verify(alarmQueryRepository).findAlarmDataByQueryForEntities(isA(TenantId.class), isA(AlarmDataQuery.class),
        isA(Collection.class));
    assertSame(actualFindAlarmDataByQueryForEntitiesResult.EMPTY_PAGE_DATA,
        actualFindAlarmDataByQueryForEntitiesResult);
  }

  /**
   * Test
   * {@link JpaAlarmDao#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}
   */
  @Test
  public void testFindAlarmDataByQueryForEntities_whenArrayList() {
    // Arrange
    PageData<AlarmData> emptyPageDataResult = PageData.emptyPageData();
    when(alarmQueryRepository.findAlarmDataByQueryForEntities(Mockito.<TenantId>any(), Mockito.<AlarmDataQuery>any(),
        Mockito.<Collection<EntityId>>any())).thenReturn(emptyPageDataResult);
    AlarmDataQuery query = new AlarmDataQuery();

    // Act
    PageData<AlarmData> actualFindAlarmDataByQueryForEntitiesResult = jpaAlarmDao
        .findAlarmDataByQueryForEntities(ModelConstants.SYSTEM_TENANT, query, new ArrayList<>());

    // Assert
    verify(alarmQueryRepository).findAlarmDataByQueryForEntities(isA(TenantId.class), isA(AlarmDataQuery.class),
        isA(Collection.class));
    assertSame(actualFindAlarmDataByQueryForEntitiesResult.EMPTY_PAGE_DATA,
        actualFindAlarmDataByQueryForEntitiesResult);
  }

  /**
   * Test
   * {@link JpaAlarmDao#findAlarmSeverities(TenantId, EntityId, AlarmStatusFilter, String)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findAlarmSeverities(TenantId, EntityId, AlarmStatusFilter, String)}
   */
  @Test
  public void testFindAlarmSeverities_thenReturnEmpty() {
    // Arrange
    when(alarmRepository.findAlarmSeverities(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        anyBoolean(), anyBoolean(), anyBoolean(), anyBoolean(), Mockito.<UUID>any())).thenReturn(new HashSet<>());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    AlarmStatusFilter asf = mock(AlarmStatusFilter.class);
    when(asf.getAckFilter()).thenReturn(true);
    when(asf.getClearFilter()).thenReturn(true);
    when(asf.hasAckFilter()).thenReturn(true);
    when(asf.hasClearFilter()).thenReturn(true);

    // Act
    Set<AlarmSeverity> actualFindAlarmSeveritiesResult = jpaAlarmDao.findAlarmSeverities(ModelConstants.SYSTEM_TENANT,
        entityId, asf, "");

    // Assert
    verify(asf).getAckFilter();
    verify(asf).getClearFilter();
    verify(asf, atLeast(1)).hasAckFilter();
    verify(asf, atLeast(1)).hasClearFilter();
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(alarmRepository).findAlarmSeverities(isA(UUID.class), isA(UUID.class), eq("TENANT"), eq(true), eq(true),
        eq(true), eq(true), isNull());
    assertTrue(actualFindAlarmSeveritiesResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)}
   */
  @Test
  public void testFindAlarmsIdsByEndTsBeforeAndTenantId_givenOne_thenCallsGetPage() {
    // Arrange
    when(alarmRepository.findAlarmsIdsByEndTsBeforeAndTenantId(Mockito.<Long>any(), Mockito.<UUID>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AlarmId> actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult = jpaAlarmDao
        .findAlarmsIdsByEndTsBeforeAndTenantId(10L, ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(alarmRepository).findAlarmsIdsByEndTsBeforeAndTenantId(eq(10L), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getTotalPages());
    assertFalse(actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.hasNext());
    assertTrue(actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)}
   */
  @Test
  public void testFindAlarmsIdsByEndTsBeforeAndTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(alarmRepository.findAlarmsIdsByEndTsBeforeAndTenantId(Mockito.<Long>any(), Mockito.<UUID>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<AlarmId> actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult = jpaAlarmDao
        .findAlarmsIdsByEndTsBeforeAndTenantId(10L, ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmRepository).findAlarmsIdsByEndTsBeforeAndTenantId(eq(10L), isA(UUID.class), isA(Pageable.class));
    List<AlarmId> data = actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getData();
    assertEquals(1, data.size());
    AlarmId getResult = data.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertEquals(1L, actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getTotalElements());
    assertEquals(EntityType.ALARM, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)}.
   * <ul>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)}
   */
  @Test
  public void testFindAlarmsIdsByEndTsBeforeAndTenantId_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(alarmRepository.findAlarmsIdsByEndTsBeforeAndTenantId(Mockito.<Long>any(), Mockito.<UUID>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<AlarmId> actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult = jpaAlarmDao
        .findAlarmsIdsByEndTsBeforeAndTenantId(10L, ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmRepository).findAlarmsIdsByEndTsBeforeAndTenantId(eq(10L), isA(UUID.class), isA(Pageable.class));
    List<AlarmId> data = actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getTotalElements());
    assertEquals(data.get(0), data.get(1));
  }

  /**
   * Test
   * {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)}
   */
  @Test
  public void testFindAlarmsIdsByEndTsBeforeAndTenantId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmRepository.findAlarmsIdsByEndTsBeforeAndTenantId(Mockito.<Long>any(), Mockito.<UUID>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AlarmId> actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult = jpaAlarmDao
        .findAlarmsIdsByEndTsBeforeAndTenantId(10L, ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmRepository).findAlarmsIdsByEndTsBeforeAndTenantId(eq(10L), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getTotalPages());
    assertFalse(actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.hasNext());
    assertTrue(actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)}.
   * <ul>
   *   <li>Then calls
   * {@link AlarmRepository#findAlarmIdsByAssigneeId(UUID, UUID, Pageable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)}
   */
  @Test
  public void testFindAlarmIdsByAssigneeId_thenCallsFindAlarmIdsByAssigneeId() {
    // Arrange
    when(alarmRepository.findAlarmIdsByAssigneeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByAssigneeIdResult = jpaAlarmDao
        .findAlarmIdsByAssigneeId(ModelConstants.SYSTEM_TENANT, userId, 1L, null, 1);

    // Assert
    verify(userId).getId();
    verify(alarmRepository).findAlarmIdsByAssigneeId(isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmIdsByAssigneeIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmIdsByAssigneeIdResult.getTotalPages());
    assertFalse(actualFindAlarmIdsByAssigneeIdResult.hasNext());
    assertTrue(actualFindAlarmIdsByAssigneeIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)}.
   * <ul>
   *   <li>Then calls
   * {@link AlarmRepository#findAlarmIdsByAssigneeId(UUID, UUID, long, UUID, Pageable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)}
   */
  @Test
  public void testFindAlarmIdsByAssigneeId_thenCallsFindAlarmIdsByAssigneeId2() {
    // Arrange
    when(alarmRepository.findAlarmIdsByAssigneeId(Mockito.<UUID>any(), Mockito.<UUID>any(), anyLong(),
        Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByAssigneeIdResult = jpaAlarmDao
        .findAlarmIdsByAssigneeId(ModelConstants.SYSTEM_TENANT, userId, 1L, new AlarmId(ModelConstants.NULL_UUID), 1);

    // Assert
    verify(userId).getId();
    verify(alarmRepository).findAlarmIdsByAssigneeId(isA(UUID.class), isA(UUID.class), eq(1L), isA(UUID.class),
        isA(Pageable.class));
    assertEquals(0L, actualFindAlarmIdsByAssigneeIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmIdsByAssigneeIdResult.getTotalPages());
    assertFalse(actualFindAlarmIdsByAssigneeIdResult.hasNext());
    assertTrue(actualFindAlarmIdsByAssigneeIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)}.
   * <ul>
   *   <li>Then calls
   * {@link AlarmRepository#findAlarmIdsByAssigneeId(UUID, UUID, long, UUID, Pageable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)}
   */
  @Test
  public void testFindAlarmIdsByAssigneeId_thenCallsFindAlarmIdsByAssigneeId3() {
    // Arrange
    when(alarmRepository.findAlarmIdsByAssigneeId(Mockito.<UUID>any(), Mockito.<UUID>any(), anyLong(),
        Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);
    AlarmId idOffset = mock(AlarmId.class);
    when(idOffset.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByAssigneeIdResult = jpaAlarmDao
        .findAlarmIdsByAssigneeId(ModelConstants.SYSTEM_TENANT, userId, 1L, idOffset, 1);

    // Assert
    verify(idOffset).getId();
    verify(userId).getId();
    verify(alarmRepository).findAlarmIdsByAssigneeId(isA(UUID.class), isA(UUID.class), eq(1L), isA(UUID.class),
        isA(Pageable.class));
    assertEquals(0L, actualFindAlarmIdsByAssigneeIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmIdsByAssigneeIdResult.getTotalPages());
    assertFalse(actualFindAlarmIdsByAssigneeIdResult.hasNext());
    assertTrue(actualFindAlarmIdsByAssigneeIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)}.
   * <ul>
   *   <li>Then calls
   * {@link AlarmRepository#findAlarmIdsByOriginatorId(UUID, Pageable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)}
   */
  @Test
  public void testFindAlarmIdsByOriginatorId_thenCallsFindAlarmIdsByOriginatorId() {
    // Arrange
    when(alarmRepository.findAlarmIdsByOriginatorId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId originatorId = mock(AlarmId.class);
    when(originatorId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByOriginatorIdResult = jpaAlarmDao
        .findAlarmIdsByOriginatorId(ModelConstants.SYSTEM_TENANT, originatorId, 1L, null, 1);

    // Assert
    verify(originatorId).getId();
    verify(alarmRepository).findAlarmIdsByOriginatorId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmIdsByOriginatorIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmIdsByOriginatorIdResult.getTotalPages());
    assertFalse(actualFindAlarmIdsByOriginatorIdResult.hasNext());
    assertTrue(actualFindAlarmIdsByOriginatorIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)}.
   * <ul>
   *   <li>Then calls
   * {@link AlarmRepository#findAlarmIdsByOriginatorId(UUID, long, UUID, Pageable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)}
   */
  @Test
  public void testFindAlarmIdsByOriginatorId_thenCallsFindAlarmIdsByOriginatorId2() {
    // Arrange
    when(alarmRepository.findAlarmIdsByOriginatorId(Mockito.<UUID>any(), anyLong(), Mockito.<UUID>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId originatorId = mock(AlarmId.class);
    when(originatorId.getId()).thenReturn(ModelConstants.NULL_UUID);
    AlarmId idOffset = mock(AlarmId.class);
    when(idOffset.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByOriginatorIdResult = jpaAlarmDao
        .findAlarmIdsByOriginatorId(ModelConstants.SYSTEM_TENANT, originatorId, 1L, idOffset, 1);

    // Assert
    verify(originatorId).getId();
    verify(idOffset).getId();
    verify(alarmRepository).findAlarmIdsByOriginatorId(isA(UUID.class), eq(1L), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmIdsByOriginatorIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmIdsByOriginatorIdResult.getTotalPages());
    assertFalse(actualFindAlarmIdsByOriginatorIdResult.hasNext());
    assertTrue(actualFindAlarmIdsByOriginatorIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)}
   */
  @Test
  public void testFindAlarmIdsByOriginatorId_whenAlarmIdWithIdIsNull_uuid() {
    // Arrange
    when(alarmRepository.findAlarmIdsByOriginatorId(Mockito.<UUID>any(), anyLong(), Mockito.<UUID>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId originatorId = mock(AlarmId.class);
    when(originatorId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByOriginatorIdResult = jpaAlarmDao.findAlarmIdsByOriginatorId(
        ModelConstants.SYSTEM_TENANT, originatorId, 1L, new AlarmId(ModelConstants.NULL_UUID), 1);

    // Assert
    verify(originatorId).getId();
    verify(alarmRepository).findAlarmIdsByOriginatorId(isA(UUID.class), eq(1L), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmIdsByOriginatorIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmIdsByOriginatorIdResult.getTotalPages());
    assertFalse(actualFindAlarmIdsByOriginatorIdResult.hasNext());
    assertTrue(actualFindAlarmIdsByOriginatorIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#createEntityAlarmRecord(EntityAlarm)}.
   * <ul>
   *   <li>Given {@link AlarmId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#createEntityAlarmRecord(EntityAlarm)}
   */
  @Test
  public void testCreateEntityAlarmRecord_givenAlarmIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);
    when(entityAlarmRepository.save(Mockito.<EntityAlarmEntity>any())).thenReturn(entityAlarmEntity);
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(ModelConstants.NULL_UUID);
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmType()).thenReturn("Alarm Type");
    when(entityAlarm.getCreatedTime()).thenReturn(1L);
    when(entityAlarm.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getAlarmId()).thenReturn(alarmId);
    when(entityAlarm.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entityAlarm).setTenantId(Mockito.<TenantId>any());
    entityAlarm.setTenantId(new TenantId(ModelConstants.NULL_UUID));

    // Act
    jpaAlarmDao.createEntityAlarmRecord(entityAlarm);

    // Assert
    verify(entityAlarmRepository).save(isA(EntityAlarmEntity.class));
    verify(entityAlarm).getAlarmId();
    verify(entityAlarm).getAlarmType();
    verify(entityAlarm).getCreatedTime();
    verify(entityAlarm, atLeast(1)).getCustomerId();
    verify(entityAlarm, atLeast(1)).getEntityId();
    verify(entityAlarm).getTenantId();
    verify(entityAlarm).setTenantId(isA(TenantId.class));
    verify(alarmId).getId();
  }

  /**
   * Test {@link JpaAlarmDao#createEntityAlarmRecord(EntityAlarm)}.
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#createEntityAlarmRecord(EntityAlarm)}
   */
  @Test
  public void testCreateEntityAlarmRecord_givenAlarmIdWithIdIsNull_uuid() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);
    when(entityAlarmRepository.save(Mockito.<EntityAlarmEntity>any())).thenReturn(entityAlarmEntity);
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmType()).thenReturn("Alarm Type");
    when(entityAlarm.getCreatedTime()).thenReturn(1L);
    when(entityAlarm.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getAlarmId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(entityAlarm.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entityAlarm).setTenantId(Mockito.<TenantId>any());
    entityAlarm.setTenantId(new TenantId(ModelConstants.NULL_UUID));

    // Act
    jpaAlarmDao.createEntityAlarmRecord(entityAlarm);

    // Assert
    verify(entityAlarmRepository).save(isA(EntityAlarmEntity.class));
    verify(entityAlarm).getAlarmId();
    verify(entityAlarm).getAlarmType();
    verify(entityAlarm).getCreatedTime();
    verify(entityAlarm, atLeast(1)).getCustomerId();
    verify(entityAlarm, atLeast(1)).getEntityId();
    verify(entityAlarm).getTenantId();
    verify(entityAlarm).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link JpaAlarmDao#createEntityAlarmRecord(EntityAlarm)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EntityAlarm} {@link EntityAlarm#getCustomerId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#createEntityAlarmRecord(EntityAlarm)}
   */
  @Test
  public void testCreateEntityAlarmRecord_givenNull_whenEntityAlarmGetCustomerIdReturnNull() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);
    when(entityAlarmRepository.save(Mockito.<EntityAlarmEntity>any())).thenReturn(entityAlarmEntity);
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmType()).thenReturn("Alarm Type");
    when(entityAlarm.getCreatedTime()).thenReturn(1L);
    when(entityAlarm.getCustomerId()).thenReturn(null);
    when(entityAlarm.getAlarmId()).thenReturn(new AlarmId(ModelConstants.NULL_UUID));
    when(entityAlarm.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entityAlarm).setTenantId(Mockito.<TenantId>any());
    entityAlarm.setTenantId(new TenantId(ModelConstants.NULL_UUID));

    // Act
    jpaAlarmDao.createEntityAlarmRecord(entityAlarm);

    // Assert
    verify(entityAlarmRepository).save(isA(EntityAlarmEntity.class));
    verify(entityAlarm).getAlarmId();
    verify(entityAlarm).getAlarmType();
    verify(entityAlarm).getCreatedTime();
    verify(entityAlarm).getCustomerId();
    verify(entityAlarm, atLeast(1)).getEntityId();
    verify(entityAlarm).getTenantId();
    verify(entityAlarm).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link JpaAlarmDao#createEntityAlarmRecord(EntityAlarm)}.
   * <ul>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#createEntityAlarmRecord(EntityAlarm)}
   */
  @Test
  public void testCreateEntityAlarmRecord_thenCallsGetEntityType() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);
    when(entityAlarmRepository.save(Mockito.<EntityAlarmEntity>any())).thenReturn(entityAlarmEntity);
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    AlarmId alarmId2 = mock(AlarmId.class);
    when(alarmId2.getId()).thenReturn(ModelConstants.NULL_UUID);
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmType()).thenReturn("Alarm Type");
    when(entityAlarm.getCreatedTime()).thenReturn(1L);
    when(entityAlarm.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getAlarmId()).thenReturn(alarmId2);
    when(entityAlarm.getEntityId()).thenReturn(alarmId);
    when(entityAlarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entityAlarm).setTenantId(Mockito.<TenantId>any());
    entityAlarm.setTenantId(new TenantId(ModelConstants.NULL_UUID));

    // Act
    jpaAlarmDao.createEntityAlarmRecord(entityAlarm);

    // Assert
    verify(entityAlarmRepository).save(isA(EntityAlarmEntity.class));
    verify(entityAlarm).getAlarmId();
    verify(entityAlarm).getAlarmType();
    verify(entityAlarm).getCreatedTime();
    verify(entityAlarm, atLeast(1)).getCustomerId();
    verify(entityAlarm, atLeast(1)).getEntityId();
    verify(entityAlarm).getTenantId();
    verify(entityAlarm).setTenantId(isA(TenantId.class));
    verify(alarmId).getEntityType();
    verify(alarmId2).getId();
    verify(alarmId).getId();
  }

  /**
   * Test {@link JpaAlarmDao#createEntityAlarmRecord(EntityAlarm)}.
   * <ul>
   *   <li>When {@link EntityAlarm} {@link EntityAlarm#getEntityId()} return
   * {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#createEntityAlarmRecord(EntityAlarm)}
   */
  @Test
  public void testCreateEntityAlarmRecord_whenEntityAlarmGetEntityIdReturnSystem_tenant() {
    // Arrange
    EntityAlarmEntity entityAlarmEntity = new EntityAlarmEntity();
    entityAlarmEntity.setAlarmId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setAlarmType("Alarm Type");
    entityAlarmEntity.setCreatedTime(1L);
    entityAlarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityId(ModelConstants.NULL_UUID);
    entityAlarmEntity.setEntityType("Entity Type");
    entityAlarmEntity.setTenantId(ModelConstants.NULL_UUID);
    when(entityAlarmRepository.save(Mockito.<EntityAlarmEntity>any())).thenReturn(entityAlarmEntity);
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(ModelConstants.NULL_UUID);
    EntityAlarm entityAlarm = mock(EntityAlarm.class);
    when(entityAlarm.getAlarmType()).thenReturn("Alarm Type");
    when(entityAlarm.getCreatedTime()).thenReturn(1L);
    when(entityAlarm.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityAlarm.getAlarmId()).thenReturn(alarmId);
    when(entityAlarm.getEntityId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entityAlarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entityAlarm).setTenantId(Mockito.<TenantId>any());
    entityAlarm.setTenantId(new TenantId(ModelConstants.NULL_UUID));

    // Act
    jpaAlarmDao.createEntityAlarmRecord(entityAlarm);

    // Assert
    verify(entityAlarmRepository).save(isA(EntityAlarmEntity.class));
    verify(entityAlarm).getAlarmId();
    verify(entityAlarm).getAlarmType();
    verify(entityAlarm).getCreatedTime();
    verify(entityAlarm, atLeast(1)).getCustomerId();
    verify(entityAlarm, atLeast(1)).getEntityId();
    verify(entityAlarm).getTenantId();
    verify(entityAlarm).setTenantId(isA(TenantId.class));
    verify(alarmId).getId();
  }

  /**
   * Test {@link JpaAlarmDao#findEntityAlarmRecords(TenantId, AlarmId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findEntityAlarmRecords(TenantId, AlarmId)}
   */
  @Test
  public void testFindEntityAlarmRecords_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(entityAlarmRepository.findAllByAlarmId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());
    AlarmId id = mock(AlarmId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EntityAlarm> actualFindEntityAlarmRecordsResult = jpaAlarmDao
        .findEntityAlarmRecords(ModelConstants.SYSTEM_TENANT, id);

    // Assert
    verify(id).getId();
    verify(entityAlarmRepository).findAllByAlarmId(isA(UUID.class));
    assertTrue(actualFindEntityAlarmRecordsResult.isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findEntityAlarmRecords(TenantId, AlarmId)}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findEntityAlarmRecords(TenantId, AlarmId)}
   */
  @Test
  public void testFindEntityAlarmRecords_whenAlarmIdWithIdIsNull_uuid_thenReturnEmpty() {
    // Arrange
    when(entityAlarmRepository.findAllByAlarmId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityAlarm> actualFindEntityAlarmRecordsResult = jpaAlarmDao
        .findEntityAlarmRecords(ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID));

    // Assert
    verify(entityAlarmRepository).findAllByAlarmId(isA(UUID.class));
    assertTrue(actualFindEntityAlarmRecordsResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findEntityAlarmRecordsByEntityId(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findEntityAlarmRecordsByEntityId(TenantId, EntityId)}
   */
  @Test
  public void testFindEntityAlarmRecordsByEntityId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(entityAlarmRepository.findAllByEntityId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EntityAlarm> actualFindEntityAlarmRecordsByEntityIdResult = jpaAlarmDao
        .findEntityAlarmRecordsByEntityId(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getId();
    verify(entityAlarmRepository).findAllByEntityId(isA(UUID.class));
    assertTrue(actualFindEntityAlarmRecordsByEntityIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmDao#findEntityAlarmRecordsByEntityId(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#findEntityAlarmRecordsByEntityId(TenantId, EntityId)}
   */
  @Test
  public void testFindEntityAlarmRecordsByEntityId_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(entityAlarmRepository.findAllByEntityId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityAlarm> actualFindEntityAlarmRecordsByEntityIdResult = jpaAlarmDao
        .findEntityAlarmRecordsByEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityAlarmRepository).findAllByEntityId(isA(UUID.class));
    assertTrue(actualFindEntityAlarmRecordsByEntityIdResult.isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#deleteEntityAlarmRecords(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#deleteEntityAlarmRecords(TenantId, EntityId)}
   */
  @Test
  public void testDeleteEntityAlarmRecords_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(entityAlarmRepository.deleteByEntityId(Mockito.<UUID>any())).thenReturn(1);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    int actualDeleteEntityAlarmRecordsResult = jpaAlarmDao.deleteEntityAlarmRecords(ModelConstants.SYSTEM_TENANT,
        entityId);

    // Assert
    verify(entityId).getId();
    verify(entityAlarmRepository).deleteByEntityId(isA(UUID.class));
    assertEquals(1, actualDeleteEntityAlarmRecordsResult);
  }

  /**
   * Test {@link JpaAlarmDao#deleteEntityAlarmRecords(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#deleteEntityAlarmRecords(TenantId, EntityId)}
   */
  @Test
  public void testDeleteEntityAlarmRecords_whenNull_customer_id_thenReturnOne() {
    // Arrange
    when(entityAlarmRepository.deleteByEntityId(Mockito.<UUID>any())).thenReturn(1);

    // Act
    int actualDeleteEntityAlarmRecordsResult = jpaAlarmDao.deleteEntityAlarmRecords(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityAlarmRepository).deleteByEntityId(isA(UUID.class));
    assertEquals(1, actualDeleteEntityAlarmRecordsResult);
  }

  /**
   * Test {@link JpaAlarmDao#deleteEntityAlarmRecordsByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls {@link EntityAlarmRepository#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#deleteEntityAlarmRecordsByTenantId(TenantId)}
   */
  @Test
  public void testDeleteEntityAlarmRecordsByTenantId_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(entityAlarmRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaAlarmDao.deleteEntityAlarmRecordsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(entityAlarmRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test
   * {@link JpaAlarmDao#countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)}.
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)}
   */
  @Test
  public void testCountAlarmsByQuery() {
    // Arrange
    when(alarmQueryRepository.countAlarmsByQuery(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<AlarmCountQuery>any())).thenReturn(3L);

    // Act
    long actualCountAlarmsByQueryResult = jpaAlarmDao.countAlarmsByQuery(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, new AlarmCountQuery());

    // Assert
    verify(alarmQueryRepository).countAlarmsByQuery(isA(TenantId.class), isA(CustomerId.class),
        isA(AlarmCountQuery.class));
    assertEquals(3L, actualCountAlarmsByQueryResult);
  }

  /**
   * Test {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}.
   * <p>
   * Method under test: {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}
   */
  @Test
  public void testFindTenantAlarmTypes() {
    // Arrange
    ArrayList<String> content = new ArrayList<>();
    content.add("foo");
    PageImpl<String> pageImpl = new PageImpl<>(content);
    when(alarmRepository.findTenantAlarmTypes(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);

    // Act
    PageData<EntitySubtype> actualFindTenantAlarmTypesResult = jpaAlarmDao
        .findTenantAlarmTypes(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmRepository).findTenantAlarmTypes(isA(UUID.class), eq(""), isA(Pageable.class));
    List<EntitySubtype> data = actualFindTenantAlarmTypesResult.getData();
    assertEquals(1, data.size());
    EntitySubtype getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("foo", getResult.getType());
    assertEquals(1L, actualFindTenantAlarmTypesResult.getTotalElements());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Data first Type is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}
   */
  @Test
  public void testFindTenantAlarmTypes_givenArrayListAdd42_thenReturnDataFirstTypeIs42() {
    // Arrange
    ArrayList<String> content = new ArrayList<>();
    content.add("42");
    PageImpl<String> pageImpl = new PageImpl<>(content);
    when(alarmRepository.findTenantAlarmTypes(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID tenantId = UUID.randomUUID();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntitySubtype> actualFindTenantAlarmTypesResult = jpaAlarmDao.findTenantAlarmTypes(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(false));
    verify(alarmRepository).findTenantAlarmTypes(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntitySubtype> data = actualFindTenantAlarmTypesResult.getData();
    assertEquals(1, data.size());
    EntitySubtype getResult = data.get(0);
    assertEquals("42", getResult.getType());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add empty string.</li>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}
   */
  @Test
  public void testFindTenantAlarmTypes_givenArrayListAddEmptyString_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<String> content = new ArrayList<>();
    content.add("");
    content.add("foo");
    PageImpl<String> pageImpl = new PageImpl<>(content);
    when(alarmRepository.findTenantAlarmTypes(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);

    // Act
    PageData<EntitySubtype> actualFindTenantAlarmTypesResult = jpaAlarmDao
        .findTenantAlarmTypes(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmRepository).findTenantAlarmTypes(isA(UUID.class), eq(""), isA(Pageable.class));
    List<EntitySubtype> data = actualFindTenantAlarmTypesResult.getData();
    assertEquals(2, data.size());
    assertEquals("", data.get(0).getType());
    EntitySubtype getResult = data.get(1);
    assertEquals("foo", getResult.getType());
    assertEquals(2L, actualFindTenantAlarmTypesResult.getTotalElements());
    assertEquals(EntityType.ALARM, getResult.getEntityType());
  }

  /**
   * Test {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}
   */
  @Test
  public void testFindTenantAlarmTypes_givenOne_thenReturnEmpty_page_data() {
    // Arrange
    when(alarmRepository.findTenantAlarmTypes(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntitySubtype> actualFindTenantAlarmTypesResult = jpaAlarmDao
        .findTenantAlarmTypes(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(false));
    verify(alarmRepository).findTenantAlarmTypes(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertSame(actualFindTenantAlarmTypesResult.EMPTY_PAGE_DATA, actualFindTenantAlarmTypesResult);
  }

  /**
   * Test {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}
   */
  @Test
  public void testFindTenantAlarmTypes_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    when(alarmRepository.findTenantAlarmTypes(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntitySubtype> actualFindTenantAlarmTypesResult = jpaAlarmDao
        .findTenantAlarmTypes(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmRepository).findTenantAlarmTypes(isA(UUID.class), eq(""), isA(Pageable.class));
    assertSame(actualFindTenantAlarmTypesResult.EMPTY_PAGE_DATA, actualFindTenantAlarmTypesResult);
  }

  /**
   * Test {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}
   */
  @Test
  public void testRemoveAlarmTypesIfNoAlarmsPresent_given42_whenHashSetAdd42_thenReturnTrue() {
    // Arrange
    when(alarmRepository.deleteTypeIfNoAlarmsExist(Mockito.<UUID>any(), Mockito.<Set<String>>any())).thenReturn(1);

    HashSet<String> types = new HashSet<>();
    types.add("42");
    types.add("foo");

    // Act
    boolean actualRemoveAlarmTypesIfNoAlarmsPresentResult = jpaAlarmDao
        .removeAlarmTypesIfNoAlarmsPresent(ModelConstants.NULL_UUID, types);

    // Assert
    verify(alarmRepository).deleteTypeIfNoAlarmsExist(isA(UUID.class), isA(Set.class));
    assertTrue(actualRemoveAlarmTypesIfNoAlarmsPresentResult);
  }

  /**
   * Test {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}
   */
  @Test
  public void testRemoveAlarmTypesIfNoAlarmsPresent_givenFoo_whenHashSetAddFoo_thenReturnTrue() {
    // Arrange
    when(alarmRepository.deleteTypeIfNoAlarmsExist(Mockito.<UUID>any(), Mockito.<Set<String>>any())).thenReturn(1);

    HashSet<String> types = new HashSet<>();
    types.add("foo");

    // Act
    boolean actualRemoveAlarmTypesIfNoAlarmsPresentResult = jpaAlarmDao
        .removeAlarmTypesIfNoAlarmsPresent(ModelConstants.NULL_UUID, types);

    // Assert
    verify(alarmRepository).deleteTypeIfNoAlarmsExist(isA(UUID.class), isA(Set.class));
    assertTrue(actualRemoveAlarmTypesIfNoAlarmsPresentResult);
  }

  /**
   * Test {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}
   */
  @Test
  public void testRemoveAlarmTypesIfNoAlarmsPresent_thenReturnFalse() {
    // Arrange
    when(alarmRepository.deleteTypeIfNoAlarmsExist(Mockito.<UUID>any(), Mockito.<Set<String>>any())).thenReturn(0);

    // Act
    boolean actualRemoveAlarmTypesIfNoAlarmsPresentResult = jpaAlarmDao
        .removeAlarmTypesIfNoAlarmsPresent(ModelConstants.NULL_UUID, new HashSet<>());

    // Assert
    verify(alarmRepository).deleteTypeIfNoAlarmsExist(isA(UUID.class), isA(Set.class));
    assertFalse(actualRemoveAlarmTypesIfNoAlarmsPresentResult);
  }

  /**
   * Test {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}
   */
  @Test
  public void testRemoveAlarmTypesIfNoAlarmsPresent_whenHashSet_thenReturnTrue() {
    // Arrange
    when(alarmRepository.deleteTypeIfNoAlarmsExist(Mockito.<UUID>any(), Mockito.<Set<String>>any())).thenReturn(1);

    // Act
    boolean actualRemoveAlarmTypesIfNoAlarmsPresentResult = jpaAlarmDao
        .removeAlarmTypesIfNoAlarmsPresent(ModelConstants.NULL_UUID, new HashSet<>());

    // Assert
    verify(alarmRepository).deleteTypeIfNoAlarmsExist(isA(UUID.class), isA(Set.class));
    assertTrue(actualRemoveAlarmTypesIfNoAlarmsPresentResult);
  }
}
