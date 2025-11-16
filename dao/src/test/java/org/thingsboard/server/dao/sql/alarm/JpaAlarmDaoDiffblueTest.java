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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.alarm.AlarmQuery;
import org.thingsboard.server.common.data.alarm.AlarmQueryV2;
import org.thingsboard.server.common.data.alarm.AlarmSearchStatus;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
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
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.query.AlarmQueryRepository;

@ContextConfiguration(classes = {JpaAlarmDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaAlarmDaoDiffblueTest {
  @MockBean private AlarmQueryRepository alarmQueryRepository;

  @MockBean private AlarmRepository alarmRepository;

  @MockBean private DataSource dataSource;

  @MockBean private EntityAlarmRepository entityAlarmRepository;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaAlarmDao jpaAlarmDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaAlarmDao#getEntityClass()}
   *   <li>{@link JpaAlarmDao#getEntityType()}
   *   <li>{@link JpaAlarmDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaAlarmDao.getEntityClass()",
    "EntityType JpaAlarmDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaAlarmDao.getRepository()"
  })
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
   * Test {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findLatestByOriginatorAndType(TenantId, EntityId, String)"})
  public void testFindLatestByOriginatorAndType() {
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
    when(alarmRepository.findLatestByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository)
        .findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertTrue(actualFindLatestByOriginatorAndTypeResult.getOriginator() instanceof UserId);
    TenantId tenantId2 = actualFindLatestByOriginatorAndTypeResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(actualFindLatestByOriginatorAndTypeResult.getPropagateRelationTypes().isEmpty());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} PropagateRelationTypes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findLatestByOriginatorAndType(TenantId, EntityId, String)"})
  public void testFindLatestByOriginatorAndType_givenAlarmEntityPropagateRelationTypesIsNull() {
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
    alarmEntity.setPropagateRelationTypes(null);
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
    when(alarmRepository.findLatestByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository)
        .findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertTrue(actualFindLatestByOriginatorAndTypeResult.getOriginator() instanceof UserId);
    TenantId tenantId2 = actualFindLatestByOriginatorAndTypeResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(actualFindLatestByOriginatorAndTypeResult.getPropagateRelationTypes().isEmpty());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findLatestByOriginatorAndType(TenantId, EntityId, String)"})
  public void testFindLatestByOriginatorAndType_givenNull_uuid_thenReturnNull() {
    // Arrange
    when(alarmRepository.findLatestByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new ArrayList<>());

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository)
        .findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertNull(actualFindLatestByOriginatorAndTypeResult);
  }

  /**
   * Test {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then Originator return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findLatestByOriginatorAndType(TenantId, EntityId, String)"})
  public void testFindLatestByOriginatorAndType_thenOriginatorReturnAssetId() {
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
    alarmEntity.setOriginatorType(EntityType.ASSET);
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
    when(alarmRepository.findLatestByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository)
        .findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    EntityId originator2 = actualFindLatestByOriginatorAndTypeResult.getOriginator();
    assertTrue(originator2 instanceof AssetId);
    assertEquals(EntityType.ASSET, originator2.getEntityType());
    assertTrue(originator2.isNullUid());
  }

  /**
   * Test {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then Originator return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findLatestByOriginatorAndType(TenantId, EntityId, String)"})
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
    when(alarmRepository.findLatestByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);
    CustomerId originator = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(alarmRepository)
        .findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
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
   * Test {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then Originator return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findLatestByOriginatorAndType(TenantId, EntityId, String)"})
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
    when(alarmRepository.findLatestByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository)
        .findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    EntityId originator2 = actualFindLatestByOriginatorAndTypeResult.getOriginator();
    assertTrue(originator2 instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, originator2.getEntityType());
    assertTrue(originator2.isNullUid());
  }

  /**
   * Test {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then return AckTs is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findLatestByOriginatorAndType(TenantId, EntityId, String)"})
  public void testFindLatestByOriginatorAndType_thenReturnAckTsIsOne() {
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

    ArrayList<AlarmEntity> alarmEntityList = new ArrayList<>();
    alarmEntityList.add(alarmEntity);
    when(alarmRepository.findLatestByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestByOriginatorAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type");

    // Assert
    verify(alarmRepository)
        .findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertEquals(1L, actualFindLatestByOriginatorAndTypeResult.getAckTs());
    assertEquals(1L, actualFindLatestByOriginatorAndTypeResult.getAssignTs());
    assertEquals(1L, actualFindLatestByOriginatorAndTypeResult.getClearTs());
    assertEquals(1L, actualFindLatestByOriginatorAndTypeResult.getCreatedTime());
    assertEquals(1L, actualFindLatestByOriginatorAndTypeResult.getEndTs());
    assertEquals(1L, actualFindLatestByOriginatorAndTypeResult.getStartTs());
    assertEquals(AlarmSeverity.CRITICAL, actualFindLatestByOriginatorAndTypeResult.getSeverity());
    EntityId originator = actualFindLatestByOriginatorAndTypeResult.getOriginator();
    assertSame(originator, actualFindLatestByOriginatorAndTypeResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then return PropagateRelationTypes size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findLatestByOriginatorAndType(TenantId, EntityId, String)"})
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
    when(alarmRepository.findLatestByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository)
        .findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertTrue(actualFindLatestByOriginatorAndTypeResult.getOriginator() instanceof UserId);
    List<String> propagateRelationTypes =
        actualFindLatestByOriginatorAndTypeResult.getPropagateRelationTypes();
    assertEquals(1, propagateRelationTypes.size());
    assertEquals("42", propagateRelationTypes.get(0));
    TenantId tenantId2 = actualFindLatestByOriginatorAndTypeResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then return TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findLatestByOriginatorAndType(TenantId, EntityId, String)"})
  public void testFindLatestByOriginatorAndType_thenReturnTenantIdIsSys_tenant_id() {
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
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("42");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmEntity> alarmEntityList = new ArrayList<>();
    alarmEntityList.add(alarmEntity);
    when(alarmRepository.findLatestByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestByOriginatorAndType(ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository)
        .findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertSame(TenantId.SYS_TENANT_ID, actualFindLatestByOriginatorAndTypeResult.getTenantId());
  }

  /**
   * Test {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestByOriginatorAndType(TenantId, EntityId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findLatestByOriginatorAndType(TenantId, EntityId, String)"})
  public void testFindLatestByOriginatorAndType_whenNull_customer_id_thenReturnNull() {
    // Arrange
    when(alarmRepository.findLatestByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Alarm actualFindLatestByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestByOriginatorAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type");

    // Assert
    verify(alarmRepository)
        .findLatestByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertNull(actualFindLatestByOriginatorAndTypeResult);
  }

  /**
   * Test {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId,
   * EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Alarm JpaAlarmDao.findLatestActiveByOriginatorAndType(TenantId, EntityId, String)"
  })
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
    when(alarmRepository.findLatestActiveByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestActiveByOriginatorAndType(
            ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository)
        .findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.getOriginator() instanceof UserId);
    List<String> propagateRelationTypes =
        actualFindLatestActiveByOriginatorAndTypeResult.getPropagateRelationTypes();
    assertEquals(1, propagateRelationTypes.size());
    assertEquals("42", propagateRelationTypes.get(0));
    TenantId tenantId2 = actualFindLatestActiveByOriginatorAndTypeResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId,
   * EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Alarm JpaAlarmDao.findLatestActiveByOriginatorAndType(TenantId, EntityId, String)"
  })
  public void testFindLatestActiveByOriginatorAndType2() {
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
    when(alarmRepository.findLatestActiveByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestActiveByOriginatorAndType(
            ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository)
        .findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.getOriginator() instanceof UserId);
    TenantId tenantId2 = actualFindLatestActiveByOriginatorAndTypeResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(
        actualFindLatestActiveByOriginatorAndTypeResult.getPropagateRelationTypes().isEmpty());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId,
   * EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Alarm JpaAlarmDao.findLatestActiveByOriginatorAndType(TenantId, EntityId, String)"
  })
  public void testFindLatestActiveByOriginatorAndType3() {
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
    alarmEntity.setPropagateRelationTypes(null);
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
    when(alarmRepository.findLatestActiveByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestActiveByOriginatorAndType(
            ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository)
        .findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertTrue(actualFindLatestActiveByOriginatorAndTypeResult.getOriginator() instanceof UserId);
    TenantId tenantId2 = actualFindLatestActiveByOriginatorAndTypeResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(
        actualFindLatestActiveByOriginatorAndTypeResult.getPropagateRelationTypes().isEmpty());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId,
   * EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Alarm JpaAlarmDao.findLatestActiveByOriginatorAndType(TenantId, EntityId, String)"
  })
  public void testFindLatestActiveByOriginatorAndType_givenNull_uuid_thenReturnNull() {
    // Arrange
    when(alarmRepository.findLatestActiveByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new ArrayList<>());

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestActiveByOriginatorAndType(
            ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository)
        .findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertNull(actualFindLatestActiveByOriginatorAndTypeResult);
  }

  /**
   * Test {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then Originator return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId,
   * EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Alarm JpaAlarmDao.findLatestActiveByOriginatorAndType(TenantId, EntityId, String)"
  })
  public void testFindLatestActiveByOriginatorAndType_thenOriginatorReturnAssetId() {
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
    alarmEntity.setOriginatorType(EntityType.ASSET);
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
    when(alarmRepository.findLatestActiveByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestActiveByOriginatorAndType(
            ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository)
        .findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    EntityId originator2 = actualFindLatestActiveByOriginatorAndTypeResult.getOriginator();
    assertTrue(originator2 instanceof AssetId);
    assertEquals(EntityType.ASSET, originator2.getEntityType());
    assertTrue(originator2.isNullUid());
  }

  /**
   * Test {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then Originator return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId,
   * EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Alarm JpaAlarmDao.findLatestActiveByOriginatorAndType(TenantId, EntityId, String)"
  })
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
    when(alarmRepository.findLatestActiveByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);
    CustomerId originator = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestActiveByOriginatorAndType(
            ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(alarmRepository)
        .findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    EntityId originator2 = actualFindLatestActiveByOriginatorAndTypeResult.getOriginator();
    assertTrue(originator2 instanceof CustomerId);
    assertEquals(2L, actualFindLatestActiveByOriginatorAndTypeResult.getAckTs());
    assertEquals(2L, actualFindLatestActiveByOriginatorAndTypeResult.getAssignTs());
    assertEquals(2L, actualFindLatestActiveByOriginatorAndTypeResult.getClearTs());
    assertEquals(2L, actualFindLatestActiveByOriginatorAndTypeResult.getCreatedTime());
    assertEquals(2L, actualFindLatestActiveByOriginatorAndTypeResult.getEndTs());
    assertEquals(2L, actualFindLatestActiveByOriginatorAndTypeResult.getStartTs());
    assertEquals(
        AlarmSeverity.MAJOR, actualFindLatestActiveByOriginatorAndTypeResult.getSeverity());
    assertEquals(
        AlarmStatus.ACTIVE_UNACK, actualFindLatestActiveByOriginatorAndTypeResult.getStatus());
    assertFalse(actualFindLatestActiveByOriginatorAndTypeResult.isAcknowledged());
    assertFalse(actualFindLatestActiveByOriginatorAndTypeResult.isCleared());
    assertFalse(actualFindLatestActiveByOriginatorAndTypeResult.isPropagate());
    assertFalse(actualFindLatestActiveByOriginatorAndTypeResult.isPropagateToOwner());
    assertFalse(actualFindLatestActiveByOriginatorAndTypeResult.isPropagateToTenant());
    assertEquals(originator, originator2);
  }

  /**
   * Test {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then Originator return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId,
   * EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Alarm JpaAlarmDao.findLatestActiveByOriginatorAndType(TenantId, EntityId, String)"
  })
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
    when(alarmRepository.findLatestActiveByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestActiveByOriginatorAndType(
            ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository)
        .findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    EntityId originator2 = actualFindLatestActiveByOriginatorAndTypeResult.getOriginator();
    assertTrue(originator2 instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, originator2.getEntityType());
    assertTrue(originator2.isNullUid());
  }

  /**
   * Test {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then return AckTs is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId,
   * EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Alarm JpaAlarmDao.findLatestActiveByOriginatorAndType(TenantId, EntityId, String)"
  })
  public void testFindLatestActiveByOriginatorAndType_thenReturnAckTsIsOne() {
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

    ArrayList<AlarmEntity> alarmEntityList = new ArrayList<>();
    alarmEntityList.add(alarmEntity);
    when(alarmRepository.findLatestActiveByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestActiveByOriginatorAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type");

    // Assert
    verify(alarmRepository)
        .findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertEquals(1L, actualFindLatestActiveByOriginatorAndTypeResult.getAckTs());
    assertEquals(1L, actualFindLatestActiveByOriginatorAndTypeResult.getAssignTs());
    assertEquals(1L, actualFindLatestActiveByOriginatorAndTypeResult.getClearTs());
    assertEquals(1L, actualFindLatestActiveByOriginatorAndTypeResult.getCreatedTime());
    assertEquals(1L, actualFindLatestActiveByOriginatorAndTypeResult.getEndTs());
    assertEquals(1L, actualFindLatestActiveByOriginatorAndTypeResult.getStartTs());
    assertEquals(
        AlarmSeverity.CRITICAL, actualFindLatestActiveByOriginatorAndTypeResult.getSeverity());
    EntityId originator = actualFindLatestActiveByOriginatorAndTypeResult.getOriginator();
    assertSame(originator, actualFindLatestActiveByOriginatorAndTypeResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then return TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId,
   * EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Alarm JpaAlarmDao.findLatestActiveByOriginatorAndType(TenantId, EntityId, String)"
  })
  public void testFindLatestActiveByOriginatorAndType_thenReturnTenantIdIsSys_tenant_id() {
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
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("42");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmEntity> alarmEntityList = new ArrayList<>();
    alarmEntityList.add(alarmEntity);
    when(alarmRepository.findLatestActiveByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(alarmEntityList);

    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestActiveByOriginatorAndType(
            ModelConstants.SYSTEM_TENANT, originator, "Type");

    // Assert
    verify(originator).getId();
    verify(alarmRepository)
        .findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertSame(
        TenantId.SYS_TENANT_ID, actualFindLatestActiveByOriginatorAndTypeResult.getTenantId());
  }

  /**
   * Test {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestActiveByOriginatorAndType(TenantId,
   * EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Alarm JpaAlarmDao.findLatestActiveByOriginatorAndType(TenantId, EntityId, String)"
  })
  public void testFindLatestActiveByOriginatorAndType_whenNull_customer_id_thenReturnNull() {
    // Arrange
    when(alarmRepository.findLatestActiveByOriginatorAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Alarm actualFindLatestActiveByOriginatorAndTypeResult =
        jpaAlarmDao.findLatestActiveByOriginatorAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type");

    // Assert
    verify(alarmRepository)
        .findLatestActiveByOriginatorAndType(isA(UUID.class), eq("Type"), isA(Pageable.class));
    assertNull(actualFindLatestActiveByOriginatorAndTypeResult);
  }

  /**
   * Test {@link JpaAlarmDao#findLatestByOriginatorAndTypeAsync(TenantId, EntityId, String)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findLatestByOriginatorAndTypeAsync(TenantId, EntityId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture JpaAlarmDao.findLatestByOriginatorAndTypeAsync(TenantId, EntityId, String)"
  })
  public void testFindLatestByOriginatorAndTypeAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Alarm> actualFindLatestByOriginatorAndTypeAsyncResult =
        jpaAlarmDao.findLatestByOriginatorAndTypeAsync(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindLatestByOriginatorAndTypeAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindLatestByOriginatorAndTypeAsyncResult);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} PropagateRelationTypes is empty string.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findAlarmById(TenantId, UUID)"})
  public void testFindAlarmById_givenAlarmEntityPropagateRelationTypesIsEmptyString() {
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
    alarmEntity.setPropagateRelationTypes("");
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
    Alarm actualFindAlarmByIdResult =
        jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    assertTrue(actualFindAlarmByIdResult.getPropagateRelationTypes().isEmpty());
    EntityId originator = actualFindAlarmByIdResult.getOriginator();
    assertSame(originator, actualFindAlarmByIdResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} PropagateRelationTypes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findAlarmById(TenantId, UUID)"})
  public void testFindAlarmById_givenAlarmEntityPropagateRelationTypesIsNull() {
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
    alarmEntity.setPropagateRelationTypes(null);
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
    Alarm actualFindAlarmByIdResult =
        jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    assertTrue(actualFindAlarmByIdResult.getPropagateRelationTypes().isEmpty());
    EntityId originator = actualFindAlarmByIdResult.getOriginator();
    assertSame(originator, actualFindAlarmByIdResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Given {@link AlarmRepository} {@link AlarmRepository#findById(Object)} return empty.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findAlarmById(TenantId, UUID)"})
  public void testFindAlarmById_givenAlarmRepositoryFindByIdReturnEmpty_thenReturnNull() {
    // Arrange
    Optional<AlarmEntity> emptyResult = Optional.empty();
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(emptyResult);

    // Act
    Alarm actualFindAlarmByIdResult =
        jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    assertNull(actualFindAlarmByIdResult);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then Originator return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findAlarmById(TenantId, UUID)"})
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
    Alarm actualFindAlarmByIdResult =
        jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

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
   *
   * <ul>
   *   <li>Then Originator return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findAlarmById(TenantId, UUID)"})
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
   *
   * <ul>
   *   <li>Then Originator return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findAlarmById(TenantId, UUID)"})
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
    Alarm actualFindAlarmByIdResult =
        jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

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
   *
   * <ul>
   *   <li>Then Originator return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findAlarmById(TenantId, UUID)"})
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
   *
   * <ul>
   *   <li>Then Originator return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findAlarmById(TenantId, UUID)"})
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
   *
   * <ul>
   *   <li>Then Originator return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findAlarmById(TenantId, UUID)"})
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
   *
   * <ul>
   *   <li>Then Originator return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findAlarmById(TenantId, UUID)"})
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
   *
   * <ul>
   *   <li>Then Originator return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findAlarmById(TenantId, UUID)"})
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
   *
   * <ul>
   *   <li>Then Originator return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findAlarmById(TenantId, UUID)"})
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
    Alarm actualFindAlarmByIdResult =
        jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    EntityId originator = actualFindAlarmByIdResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertFalse(originator.isNullUid());
    assertFalse(((TenantId) originator).isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then Originator return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findAlarmById(TenantId, UUID)"})
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
    Alarm actualFindAlarmByIdResult =
        jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

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
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return AckTs is twenty-seven.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findAlarmById(TenantId, UUID)"})
  public void testFindAlarmById_thenReturnAckTsIsTwentySeven() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(27L);
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
    Optional<AlarmEntity> ofResult = Optional.of(alarmEntity);
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);

    // Act
    Alarm actualFindAlarmByIdResult =
        jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    assertEquals(27L, actualFindAlarmByIdResult.getAckTs());
    EntityId originator = actualFindAlarmByIdResult.getOriginator();
    assertSame(originator, actualFindAlarmByIdResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return TenantId is Originator.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm JpaAlarmDao.findAlarmById(TenantId, UUID)"})
  public void testFindAlarmById_thenReturnTenantIdIsOriginator() {
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
    Optional<AlarmEntity> ofResult = Optional.of(alarmEntity);
    when(alarmRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);

    // Act
    Alarm actualFindAlarmByIdResult =
        jpaAlarmDao.findAlarmById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findById(isA(UUID.class));
    EntityId originator = actualFindAlarmByIdResult.getOriginator();
    assertSame(originator, actualFindAlarmByIdResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) PropagateRelationTypes is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo JpaAlarmDao.findAlarmInfoById(TenantId, UUID)"})
  public void testFindAlarmInfoById_givenAlarmInfoEntityPropagateRelationTypesIsEmptyString() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);
    when(alarmRepository.findAlarmInfoById(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(alarmInfoEntity);

    // Act
    AlarmInfo actualFindAlarmInfoByIdResult =
        jpaAlarmDao.findAlarmInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findAlarmInfoById(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindAlarmInfoByIdResult.getPropagateRelationTypes().isEmpty());
    assertSame(TenantId.SYS_TENANT_ID, actualFindAlarmInfoByIdResult.getOriginator());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) PropagateRelationTypes is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo JpaAlarmDao.findAlarmInfoById(TenantId, UUID)"})
  public void testFindAlarmInfoById_givenAlarmInfoEntityPropagateRelationTypesIsNull() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    alarmInfoEntity.setPropagateRelationTypes(null);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);
    when(alarmRepository.findAlarmInfoById(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(alarmInfoEntity);

    // Act
    AlarmInfo actualFindAlarmInfoByIdResult =
        jpaAlarmDao.findAlarmInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findAlarmInfoById(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindAlarmInfoByIdResult.getPropagateRelationTypes().isEmpty());
    assertSame(TenantId.SYS_TENANT_ID, actualFindAlarmInfoByIdResult.getOriginator());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then Details iterator next return {@link BooleanNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo JpaAlarmDao.findAlarmInfoById(TenantId, UUID)"})
  public void testFindAlarmInfoById_givenNull_uuid_thenDetailsIteratorNextReturnBooleanNode() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    when(alarmRepository.findAlarmInfoById(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(alarmInfoEntity);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    AlarmInfo actualFindAlarmInfoByIdResult =
        jpaAlarmDao.findAlarmInfoById(tenantId, ModelConstants.NULL_UUID);

    // Assert
    verify(tenantId).getId();
    verify(alarmRepository).findAlarmInfoById(isA(UUID.class), isA(UUID.class));
    JsonNode details = actualFindAlarmInfoByIdResult.getDetails();
    Iterator<JsonNode> iteratorResult = details.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(details instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(details.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    UserId expectedId = actualFindAlarmInfoByIdResult.getAssigneeId();
    assertEquals(expectedId, actualFindAlarmInfoByIdResult.getAssignee().getId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then Originator return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo JpaAlarmDao.findAlarmInfoById(TenantId, UUID)"})
  public void testFindAlarmInfoById_thenOriginatorReturnAssetId() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    alarmInfoEntity.setOriginatorType(EntityType.ASSET);
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
    when(alarmRepository.findAlarmInfoById(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(alarmInfoEntity);
    UUID key = ModelConstants.NULL_UUID;

    // Act
    AlarmInfo actualFindAlarmInfoByIdResult =
        jpaAlarmDao.findAlarmInfoById(ModelConstants.SYSTEM_TENANT, key);

    // Assert
    verify(alarmRepository).findAlarmInfoById(isA(UUID.class), isA(UUID.class));
    EntityId originator = actualFindAlarmInfoByIdResult.getOriginator();
    assertTrue(originator instanceof AssetId);
    assertEquals(EntityType.ASSET, originator.getEntityType());
    assertSame(key, originator.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then Originator return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo JpaAlarmDao.findAlarmInfoById(TenantId, UUID)"})
  public void testFindAlarmInfoById_thenOriginatorReturnCustomerId() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    alarmInfoEntity.setOriginatorType(EntityType.CUSTOMER);
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
    when(alarmRepository.findAlarmInfoById(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(alarmInfoEntity);

    // Act
    AlarmInfo actualFindAlarmInfoByIdResult =
        jpaAlarmDao.findAlarmInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findAlarmInfoById(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindAlarmInfoByIdResult.getOriginator() instanceof CustomerId);
    TenantId tenantId = actualFindAlarmInfoByIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then Originator return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo JpaAlarmDao.findAlarmInfoById(TenantId, UUID)"})
  public void testFindAlarmInfoById_thenOriginatorReturnDashboardId() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    alarmInfoEntity.setOriginatorType(EntityType.DASHBOARD);
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
    when(alarmRepository.findAlarmInfoById(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(alarmInfoEntity);
    UUID key = ModelConstants.NULL_UUID;

    // Act
    AlarmInfo actualFindAlarmInfoByIdResult =
        jpaAlarmDao.findAlarmInfoById(ModelConstants.SYSTEM_TENANT, key);

    // Assert
    verify(alarmRepository).findAlarmInfoById(isA(UUID.class), isA(UUID.class));
    EntityId originator = actualFindAlarmInfoByIdResult.getOriginator();
    assertTrue(originator instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, originator.getEntityType());
    assertSame(key, originator.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then Originator return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo JpaAlarmDao.findAlarmInfoById(TenantId, UUID)"})
  public void testFindAlarmInfoById_thenOriginatorReturnTenantId() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    UUID originatorId = UUID.randomUUID();
    alarmInfoEntity.setOriginatorId(originatorId);
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
    when(alarmRepository.findAlarmInfoById(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(alarmInfoEntity);

    // Act
    AlarmInfo actualFindAlarmInfoByIdResult =
        jpaAlarmDao.findAlarmInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findAlarmInfoById(isA(UUID.class), isA(UUID.class));
    EntityId originator = actualFindAlarmInfoByIdResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    TenantId tenantId = actualFindAlarmInfoByIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(originator.isNullUid());
    assertFalse(((TenantId) originator).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then Originator return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo JpaAlarmDao.findAlarmInfoById(TenantId, UUID)"})
  public void testFindAlarmInfoById_thenOriginatorReturnUserId() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    alarmInfoEntity.setOriginatorType(EntityType.USER);
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
    when(alarmRepository.findAlarmInfoById(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(alarmInfoEntity);

    // Act
    AlarmInfo actualFindAlarmInfoByIdResult =
        jpaAlarmDao.findAlarmInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findAlarmInfoById(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindAlarmInfoByIdResult.getOriginator() instanceof UserId);
    TenantId tenantId = actualFindAlarmInfoByIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return Status is {@code CLEARED_UNACK}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo JpaAlarmDao.findAlarmInfoById(TenantId, UUID)"})
  public void testFindAlarmInfoById_thenReturnStatusIsClearedUnack() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(false);
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
    when(alarmRepository.findAlarmInfoById(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(alarmInfoEntity);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    AlarmInfo actualFindAlarmInfoByIdResult =
        jpaAlarmDao.findAlarmInfoById(tenantId, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findAlarmInfoById(isA(UUID.class), isA(UUID.class));
    assertEquals(AlarmStatus.CLEARED_UNACK, actualFindAlarmInfoByIdResult.getStatus());
    assertFalse(actualFindAlarmInfoByIdResult.isAcknowledged());
    EntityId originator = actualFindAlarmInfoByIdResult.getOriginator();
    assertSame(originator, actualFindAlarmInfoByIdResult.getTenantId());
    assertSame(tenantId, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return TenantId is Originator.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmInfoById(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmInfo JpaAlarmDao.findAlarmInfoById(TenantId, UUID)"})
  public void testFindAlarmInfoById_thenReturnTenantIdIsOriginator() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    when(alarmRepository.findAlarmInfoById(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(alarmInfoEntity);

    // Act
    AlarmInfo actualFindAlarmInfoByIdResult =
        jpaAlarmDao.findAlarmInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmRepository).findAlarmInfoById(isA(UUID.class), isA(UUID.class));
    EntityId originator = actualFindAlarmInfoByIdResult.getOriginator();
    assertSame(originator, actualFindAlarmInfoByIdResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmByIdAsync(TenantId, UUID)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmByIdAsync(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture JpaAlarmDao.findAlarmByIdAsync(TenantId, UUID)"})
  public void testFindAlarmByIdAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Alarm> actualFindAlarmByIdAsyncResult =
        jpaAlarmDao.findAlarmByIdAsync(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAlarmByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAlarmByIdAsyncResult);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms() {
    // Arrange
    when(alarmRepository.findAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            new TimePageLink(3),
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(alarmRepository)
        .findAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq("CUSTOMER"),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms2() {
    // Arrange
    when(alarmRepository.findAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmQuery query =
        new AlarmQuery(
            ModelConstants.SYSTEM_TENANT,
            new TimePageLink(3),
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(alarmRepository)
        .findAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms3() {
    // Arrange
    when(alarmRepository.findAllAlarms(
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmQuery query =
        new AlarmQuery(
            null, new TimePageLink(3), AlarmSearchStatus.ACK, AlarmStatus.ACTIVE_UNACK, null, true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(alarmRepository)
        .findAllAlarms(
            isA(UUID.class),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms4() {
    // Arrange
    when(alarmRepository.findAllAlarms(
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmQuery query =
        new AlarmQuery(
            null, new TimePageLink(3), AlarmSearchStatus.ANY, AlarmStatus.ACTIVE_UNACK, null, true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(alarmRepository)
        .findAllAlarms(
            isA(UUID.class),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms5() {
    // Arrange
    when(alarmRepository.findAllAlarms(
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmQuery query =
        new AlarmQuery(null, new TimePageLink(3), null, AlarmStatus.ACTIVE_UNACK, null, true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(alarmRepository)
        .findAllAlarms(
            isA(UUID.class),
            isNull(),
            isNull(),
            eq(true),
            eq(false),
            eq(true),
            eq(false),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms6() {
    // Arrange
    when(alarmRepository.findAllAlarms(
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmQuery query =
        new AlarmQuery(
            null,
            new TimePageLink(3),
            AlarmSearchStatus.ACTIVE,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(alarmRepository)
        .findAllAlarms(
            isA(UUID.class),
            isNull(),
            isNull(),
            eq(true),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms7() {
    // Arrange
    when(alarmRepository.findAllAlarms(
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmQuery query =
        new AlarmQuery(
            null,
            new TimePageLink(3),
            AlarmSearchStatus.CLEARED,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(alarmRepository)
        .findAllAlarms(
            isA(UUID.class),
            isNull(),
            isNull(),
            eq(true),
            eq(true),
            eq(false),
            eq(false),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms8() {
    // Arrange
    when(alarmRepository.findAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    EntityId affectedEntityId = mock(EntityId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);
    AlarmQuery query =
        new AlarmQuery(
            affectedEntityId,
            new TimePageLink(3),
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(affectedEntityId).getEntityType();
    verify(affectedEntityId).getId();
    verify(alarmRepository)
        .findAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms9() {
    // Arrange
    when(alarmRepository.findAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    EntityId affectedEntityId = mock(EntityId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);
    AlarmQuery query =
        new AlarmQuery(
            affectedEntityId,
            new TimePageLink(3),
            AlarmSearchStatus.ANY,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(affectedEntityId).getEntityType();
    verify(affectedEntityId).getId();
    verify(alarmRepository)
        .findAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms10() {
    // Arrange
    when(alarmRepository.findAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    EntityId affectedEntityId = mock(EntityId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);
    AlarmQuery query =
        new AlarmQuery(
            affectedEntityId, new TimePageLink(3), null, AlarmStatus.ACTIVE_UNACK, null, true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(affectedEntityId).getEntityType();
    verify(affectedEntityId).getId();
    verify(alarmRepository)
        .findAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            isNull(),
            isNull(),
            eq(true),
            eq(false),
            eq(true),
            eq(false),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms11() {
    // Arrange
    when(alarmRepository.findAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    EntityId affectedEntityId = mock(EntityId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);
    AlarmQuery query =
        new AlarmQuery(
            affectedEntityId,
            new TimePageLink(3),
            AlarmSearchStatus.CLEARED,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(affectedEntityId).getEntityType();
    verify(affectedEntityId).getId();
    verify(alarmRepository)
        .findAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            isNull(),
            isNull(),
            eq(true),
            eq(true),
            eq(false),
            eq(false),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms12() {
    // Arrange
    when(alarmRepository.findAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    EntityId affectedEntityId = mock(EntityId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    AlarmQuery query =
        new AlarmQuery(
            affectedEntityId,
            pageLink,
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isNull(),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms13() {
    // Arrange
    when(alarmRepository.findAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    EntityId affectedEntityId = mock(EntityId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    AlarmQuery query =
        new AlarmQuery(
            affectedEntityId,
            pageLink,
            AlarmSearchStatus.UNACK,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            eq(false),
            eq(false),
            eq(true),
            eq(false),
            isNull(),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) AckTs is one.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms_givenAlarmInfoEntityAckTsIsOne_thenReturnDataSizeIsTwo() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(3L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(3L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(3L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(3L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(3L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel(
        "Try to find alarms by entity [{}], status [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find alarms by entity [{}], status [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find alarms by entity [{}], status [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(3L);
    alarmInfoEntity.setStatus("Try to find alarms by entity [{}], status [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find alarms by entity [{}], status [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(false);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("john.smith@example.org");
    alarmInfoEntity2.setAssigneeFirstName("John");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Smith");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(false);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel(",");
    alarmInfoEntity2.setOriginatorName(",");
    alarmInfoEntity2.setOriginatorType(EntityType.CUSTOMER);
    alarmInfoEntity2.setPropagate(false);
    alarmInfoEntity2.setPropagateRelationTypes(",");
    alarmInfoEntity2.setPropagateToOwner(false);
    alarmInfoEntity2.setPropagateToTenant(false);
    alarmInfoEntity2.setSeverity(AlarmSeverity.MAJOR);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus(",");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType(",");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity2);
    content.add(alarmInfoEntity);
    when(alarmRepository.findAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    EntityId affectedEntityId = mock(EntityId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmQuery query =
        new AlarmQuery(
            affectedEntityId,
            pageLink,
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            assigneeId,
            true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(2, actualFindAlarmsResult.getData().size());
    assertEquals(2L, actualFindAlarmsResult.getTotalElements());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) AckTs is three.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms_givenAlarmInfoEntityAckTsIsThree_thenReturnDataSizeIsOne() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(3L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(3L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(3L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(3L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(3L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel(
        "Try to find alarms by entity [{}], status [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find alarms by entity [{}], status [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find alarms by entity [{}], status [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(3L);
    alarmInfoEntity.setStatus("Try to find alarms by entity [{}], status [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find alarms by entity [{}], status [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity);
    when(alarmRepository.findAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    EntityId affectedEntityId = mock(EntityId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmQuery query =
        new AlarmQuery(
            affectedEntityId,
            pageLink,
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            assigneeId,
            true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(1, actualFindAlarmsResult.getData().size());
    assertEquals(1L, actualFindAlarmsResult.getTotalElements());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link UserId} {@link UserId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms_givenOne_whenUserIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    when(alarmRepository.findAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    EntityId affectedEntityId = mock(EntityId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmQuery query =
        new AlarmQuery(
            affectedEntityId,
            pageLink,
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            assigneeId,
            true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmRepository#findAllAlarms(UUID, Long, Long, boolean, boolean,
   *       boolean, boolean, UUID, String, Pageable)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarms(TenantId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarms(TenantId, AlarmQuery)"})
  public void testFindAlarms_whenUserIdWithIdIsNull_uuid_thenCallsFindAllAlarms() {
    // Arrange
    when(alarmRepository.findAllAlarms(
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    TimePageLink pageLink = new TimePageLink(3);
    AlarmQuery query =
        new AlarmQuery(
            null,
            pageLink,
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            new UserId(ModelConstants.NULL_UUID),
            true);

    // Act
    PageData<AlarmInfo> actualFindAlarmsResult =
        jpaAlarmDao.findAlarms(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(alarmRepository)
        .findAllAlarms(
            isA(UUID.class),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isA(UUID.class),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsResult.getTotalElements());
    assertEquals(1, actualFindAlarmsResult.getTotalPages());
    assertFalse(actualFindAlarmsResult.hasNext());
    assertTrue(actualFindAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findCustomerAlarms(TenantId, CustomerId, AlarmQuery)"})
  public void testFindCustomerAlarms() {
    // Arrange
    when(alarmRepository.findCustomerAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            new TimePageLink(3),
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult =
        jpaAlarmDao.findCustomerAlarms(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(alarmRepository)
        .findCustomerAlarms(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsResult.getTotalPages());
    assertFalse(actualFindCustomerAlarmsResult.hasNext());
    assertTrue(actualFindCustomerAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findCustomerAlarms(TenantId, CustomerId, AlarmQuery)"})
  public void testFindCustomerAlarms2() {
    // Arrange
    when(alarmRepository.findCustomerAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
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
        jpaAlarmDao.findCustomerAlarms(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(alarmRepository)
        .findCustomerAlarms(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsResult.getTotalPages());
    assertFalse(actualFindCustomerAlarmsResult.hasNext());
    assertTrue(actualFindCustomerAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findCustomerAlarms(TenantId, CustomerId, AlarmQuery)"})
  public void testFindCustomerAlarms3() {
    // Arrange
    when(alarmRepository.findCustomerAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            new TimePageLink(3),
            AlarmSearchStatus.ACTIVE,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult =
        jpaAlarmDao.findCustomerAlarms(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(alarmRepository)
        .findCustomerAlarms(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            eq(true),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsResult.getTotalPages());
    assertFalse(actualFindCustomerAlarmsResult.hasNext());
    assertTrue(actualFindCustomerAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findCustomerAlarms(TenantId, CustomerId, AlarmQuery)"})
  public void testFindCustomerAlarms4() {
    // Arrange
    when(alarmRepository.findCustomerAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            new TimePageLink(3),
            AlarmSearchStatus.CLEARED,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult =
        jpaAlarmDao.findCustomerAlarms(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(alarmRepository)
        .findCustomerAlarms(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            eq(true),
            eq(true),
            eq(false),
            eq(false),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsResult.getTotalPages());
    assertFalse(actualFindCustomerAlarmsResult.hasNext());
    assertTrue(actualFindCustomerAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findCustomerAlarms(TenantId, CustomerId, AlarmQuery)"})
  public void testFindCustomerAlarms5() {
    // Arrange
    when(alarmRepository.findCustomerAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult =
        jpaAlarmDao.findCustomerAlarms(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isNull(),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsResult.getTotalPages());
    assertFalse(actualFindCustomerAlarmsResult.hasNext());
    assertTrue(actualFindCustomerAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findCustomerAlarms(TenantId, CustomerId, AlarmQuery)"})
  public void testFindCustomerAlarms6() {
    // Arrange
    when(alarmRepository.findCustomerAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            AlarmSearchStatus.UNACK,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult =
        jpaAlarmDao.findCustomerAlarms(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            eq(false),
            eq(false),
            eq(true),
            eq(false),
            isNull(),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsResult.getTotalPages());
    assertFalse(actualFindCustomerAlarmsResult.hasNext());
    assertTrue(actualFindCustomerAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findCustomerAlarms(TenantId, CustomerId, AlarmQuery)"})
  public void testFindCustomerAlarms7() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    alarmInfoEntity.setOriginatorId(UUID.randomUUID());
    alarmInfoEntity.setOriginatorLabel(
        "Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity);
    when(alarmRepository.findCustomerAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            assigneeId,
            true);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult =
        jpaAlarmDao.findCustomerAlarms(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(assigneeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<AlarmInfo> data = actualFindCustomerAlarmsResult.getData();
    assertEquals(1, data.size());
    AlarmInfo getResult = data.get(0);
    assertEquals(
        "Try to find customer alarms by status [{}] and pageLink [{}]", getResult.getName());
    assertEquals(
        "Try to find customer alarms by status [{}] and pageLink [{}]", getResult.getType());
    assertEquals(
        "Try to find customer alarms by status [{}] and pageLink [{}]",
        getResult.getOriginatorLabel());
    assertEquals(
        "Try to find customer alarms by status [{}] and pageLink [{}]",
        getResult.getOriginatorName());
    assertEquals(1, getResult.getPropagateRelationTypes().size());
    assertEquals(1L, getResult.getAckTs());
    assertEquals(1L, getResult.getAssignTs());
    assertEquals(1L, getResult.getClearTs());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, getResult.getEndTs());
    assertEquals(1L, getResult.getStartTs());
    assertEquals(1L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(AlarmSeverity.CRITICAL, getResult.getSeverity());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) AckTs is two.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findCustomerAlarms(TenantId, CustomerId, AlarmQuery)"})
  public void testFindCustomerAlarms_givenAlarmInfoEntityAckTsIsTwo_thenReturnDataSizeIsTwo() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    alarmInfoEntity.setOriginatorLabel(
        "Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(2L);
    alarmInfoEntity2.setAcknowledged(false);
    alarmInfoEntity2.setAssignTs(2L);
    alarmInfoEntity2.setAssigneeEmail("john.smith@example.org");
    alarmInfoEntity2.setAssigneeFirstName("John");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Smith");
    alarmInfoEntity2.setClearTs(2L);
    alarmInfoEntity2.setCleared(false);
    alarmInfoEntity2.setCreatedTime(2L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(2L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel(",");
    alarmInfoEntity2.setOriginatorName(",");
    alarmInfoEntity2.setOriginatorType(EntityType.CUSTOMER);
    alarmInfoEntity2.setPropagate(false);
    alarmInfoEntity2.setPropagateRelationTypes(",");
    alarmInfoEntity2.setPropagateToOwner(false);
    alarmInfoEntity2.setPropagateToTenant(false);
    alarmInfoEntity2.setSeverity(AlarmSeverity.MAJOR);
    alarmInfoEntity2.setStartTs(2L);
    alarmInfoEntity2.setStatus(",");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType(",");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity2);
    content.add(alarmInfoEntity);
    when(alarmRepository.findCustomerAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            assigneeId,
            true);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult =
        jpaAlarmDao.findCustomerAlarms(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(assigneeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(2, actualFindCustomerAlarmsResult.getData().size());
    assertEquals(2L, actualFindCustomerAlarmsResult.getTotalElements());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findCustomerAlarms(TenantId, CustomerId, AlarmQuery)"})
  public void testFindCustomerAlarms_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(alarmRepository.findCustomerAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            assigneeId,
            true);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult =
        jpaAlarmDao.findCustomerAlarms(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(assigneeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsResult.getTotalPages());
    assertFalse(actualFindCustomerAlarmsResult.hasNext());
    assertTrue(actualFindCustomerAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId is Data first Originator.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findCustomerAlarms(TenantId, CustomerId, AlarmQuery)"})
  public void testFindCustomerAlarms_thenReturnDataFirstTenantIdIsDataFirstOriginator() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    alarmInfoEntity.setOriginatorLabel(
        "Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity);
    when(alarmRepository.findCustomerAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            assigneeId,
            true);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult =
        jpaAlarmDao.findCustomerAlarms(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(assigneeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<AlarmInfo> data = actualFindCustomerAlarmsResult.getData();
    assertEquals(1, data.size());
    AlarmInfo getResult = data.get(0);
    EntityId originator = getResult.getOriginator();
    assertSame(originator, getResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   *
   * <ul>
   *   <li>Then return Data size is three.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findCustomerAlarms(TenantId, CustomerId, AlarmQuery)"})
  public void testFindCustomerAlarms_thenReturnDataSizeIsThree() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    alarmInfoEntity.setOriginatorLabel(
        "Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find customer alarms by status [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(2L);
    alarmInfoEntity2.setAcknowledged(false);
    alarmInfoEntity2.setAssignTs(2L);
    alarmInfoEntity2.setAssigneeEmail("john.smith@example.org");
    alarmInfoEntity2.setAssigneeFirstName("John");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Smith");
    alarmInfoEntity2.setClearTs(2L);
    alarmInfoEntity2.setCleared(false);
    alarmInfoEntity2.setCreatedTime(2L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(2L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel(",");
    alarmInfoEntity2.setOriginatorName(",");
    alarmInfoEntity2.setOriginatorType(EntityType.CUSTOMER);
    alarmInfoEntity2.setPropagate(false);
    alarmInfoEntity2.setPropagateRelationTypes(",");
    alarmInfoEntity2.setPropagateToOwner(false);
    alarmInfoEntity2.setPropagateToTenant(false);
    alarmInfoEntity2.setSeverity(AlarmSeverity.MAJOR);
    alarmInfoEntity2.setStartTs(2L);
    alarmInfoEntity2.setStatus(",");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType(",");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity3 = new AlarmInfoEntity();
    alarmInfoEntity3.setAckTs(3L);
    alarmInfoEntity3.setAcknowledged(true);
    alarmInfoEntity3.setAssignTs(3L);
    alarmInfoEntity3.setAssigneeEmail("prof.einstein@example.org");
    alarmInfoEntity3.setAssigneeFirstName("Albert");
    alarmInfoEntity3.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity3.setAssigneeLastName("Einstein");
    alarmInfoEntity3.setClearTs(3L);
    alarmInfoEntity3.setCleared(true);
    alarmInfoEntity3.setCreatedTime(3L);
    alarmInfoEntity3.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity3.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity3.setEndTs(3L);
    alarmInfoEntity3.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity3.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity3.setOriginatorLabel("Originator Label");
    alarmInfoEntity3.setOriginatorName("Originator Name");
    alarmInfoEntity3.setOriginatorType(EntityType.USER);
    alarmInfoEntity3.setPropagate(true);
    alarmInfoEntity3.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity3.setPropagateToOwner(true);
    alarmInfoEntity3.setPropagateToTenant(true);
    alarmInfoEntity3.setSeverity(AlarmSeverity.MINOR);
    alarmInfoEntity3.setStartTs(3L);
    alarmInfoEntity3.setStatus("Status");
    alarmInfoEntity3.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity3.setType("Type");
    alarmInfoEntity3.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity3);
    content.add(alarmInfoEntity2);
    content.add(alarmInfoEntity);
    when(alarmRepository.findCustomerAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            assigneeId,
            true);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult =
        jpaAlarmDao.findCustomerAlarms(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(assigneeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarms(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(3, actualFindCustomerAlarmsResult.getData().size());
    assertEquals(3L, actualFindCustomerAlarmsResult.getTotalElements());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarms(TenantId, CustomerId, AlarmQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findCustomerAlarms(TenantId, CustomerId, AlarmQuery)"})
  public void testFindCustomerAlarms_whenUserIdWithIdIsNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmRepository.findCustomerAlarms(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    TimePageLink pageLink = new TimePageLink(3);
    AlarmQuery query =
        new AlarmQuery(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            new UserId(ModelConstants.NULL_UUID),
            true);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsResult =
        jpaAlarmDao.findCustomerAlarms(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(alarmRepository)
        .findCustomerAlarms(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(true),
            eq(true),
            isA(UUID.class),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsResult.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsResult.getTotalPages());
    assertFalse(actualFindCustomerAlarmsResult.hasNext());
    assertTrue(actualFindCustomerAlarmsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2() {
    // Arrange
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
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
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("CUSTOMER"),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindAlarmsV2Result.getTotalPages());
    assertFalse(actualFindAlarmsV2Result.hasNext());
    assertTrue(actualFindAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2_givenActive_whenArrayListAddActive() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(3L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(3L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(3L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(3L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(3L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(3L);
    alarmInfoEntity.setStatus("Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity);
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.ACTIVE);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            affectedEntityId, pageLink, typeList, statusList, new ArrayList<>(), assigneeId);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(true),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<AlarmInfo> data = actualFindAlarmsV2Result.getData();
    assertEquals(1, data.size());
    AlarmInfo getResult = data.get(0);
    EntityId originator = getResult.getOriginator();
    assertSame(originator, getResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) AckTs is one.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2_givenAlarmInfoEntityAckTsIsOne_thenReturnDataSizeIsTwo() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(3L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(3L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(3L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(3L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(3L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(3L);
    alarmInfoEntity.setStatus("Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(false);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("john.smith@example.org");
    alarmInfoEntity2.setAssigneeFirstName("John");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Smith");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(false);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel(",");
    alarmInfoEntity2.setOriginatorName(",");
    alarmInfoEntity2.setOriginatorType(EntityType.CUSTOMER);
    alarmInfoEntity2.setPropagate(false);
    alarmInfoEntity2.setPropagateRelationTypes(",");
    alarmInfoEntity2.setPropagateToOwner(false);
    alarmInfoEntity2.setPropagateToTenant(false);
    alarmInfoEntity2.setSeverity(AlarmSeverity.MAJOR);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus(",");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType(",");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity2);
    content.add(alarmInfoEntity);
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            affectedEntityId, pageLink, typeList, statusList, new ArrayList<>(), assigneeId);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(2, actualFindAlarmsV2Result.getData().size());
    assertEquals(2L, actualFindAlarmsV2Result.getTotalElements());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) AckTs is two.
   *   <li>Then return Data size is three.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2_givenAlarmInfoEntityAckTsIsTwo_thenReturnDataSizeIsThree() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(3L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(3L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(3L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(3L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(3L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(3L);
    alarmInfoEntity.setStatus("Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(false);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("john.smith@example.org");
    alarmInfoEntity2.setAssigneeFirstName("John");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Smith");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(false);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel(",");
    alarmInfoEntity2.setOriginatorName(",");
    alarmInfoEntity2.setOriginatorType(EntityType.CUSTOMER);
    alarmInfoEntity2.setPropagate(false);
    alarmInfoEntity2.setPropagateRelationTypes(",");
    alarmInfoEntity2.setPropagateToOwner(false);
    alarmInfoEntity2.setPropagateToTenant(false);
    alarmInfoEntity2.setSeverity(AlarmSeverity.MAJOR);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus(",");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType(",");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity3 = new AlarmInfoEntity();
    alarmInfoEntity3.setAckTs(2L);
    alarmInfoEntity3.setAcknowledged(true);
    alarmInfoEntity3.setAssignTs(2L);
    alarmInfoEntity3.setAssigneeEmail("prof.einstein@example.org");
    alarmInfoEntity3.setAssigneeFirstName("Albert");
    alarmInfoEntity3.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity3.setAssigneeLastName("Einstein");
    alarmInfoEntity3.setClearTs(2L);
    alarmInfoEntity3.setCleared(true);
    alarmInfoEntity3.setCreatedTime(2L);
    alarmInfoEntity3.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity3.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity3.setEndTs(2L);
    alarmInfoEntity3.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity3.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity3.setOriginatorLabel("Originator Label");
    alarmInfoEntity3.setOriginatorName("Originator Name");
    alarmInfoEntity3.setOriginatorType(EntityType.USER);
    alarmInfoEntity3.setPropagate(true);
    alarmInfoEntity3.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity3.setPropagateToOwner(true);
    alarmInfoEntity3.setPropagateToTenant(true);
    alarmInfoEntity3.setSeverity(AlarmSeverity.MINOR);
    alarmInfoEntity3.setStartTs(2L);
    alarmInfoEntity3.setStatus("Status");
    alarmInfoEntity3.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity3.setType("Type");
    alarmInfoEntity3.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity3);
    content.add(alarmInfoEntity2);
    content.add(alarmInfoEntity);
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            affectedEntityId, pageLink, typeList, statusList, new ArrayList<>(), assigneeId);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(3, actualFindAlarmsV2Result.getData().size());
    assertEquals(3L, actualFindAlarmsV2Result.getTotalElements());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@code ANY}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ANY}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2_givenAny_whenArrayListAddAny_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
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
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.ANY);
    ArrayList<String> typeList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(affectedEntityId, pageLink, typeList, statusList, new ArrayList<>(), null);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindAlarmsV2Result.getTotalPages());
    assertFalse(actualFindAlarmsV2Result.hasNext());
    assertTrue(actualFindAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@code CLEARED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code CLEARED}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2_givenCleared_whenArrayListAddCleared() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(3L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(3L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(3L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(3L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(3L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(3L);
    alarmInfoEntity.setStatus("Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity);
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.CLEARED);
    statusList.add(AlarmSearchStatus.ACTIVE);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            affectedEntityId, pageLink, typeList, statusList, new ArrayList<>(), assigneeId);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<AlarmInfo> data = actualFindAlarmsV2Result.getData();
    assertEquals(1, data.size());
    AlarmInfo getResult = data.get(0);
    EntityId originator = getResult.getOriginator();
    assertSame(originator, getResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@code CLEARED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code CLEARED}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2_givenCleared_whenArrayListAddCleared_thenCallsGetId() {
    // Arrange
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
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
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.CLEARED);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            affectedEntityId, pageLink, typeList, statusList, new ArrayList<>(), assigneeId);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(true),
            eq(true),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindAlarmsV2Result.getTotalPages());
    assertFalse(actualFindAlarmsV2Result.hasNext());
    assertTrue(actualFindAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@code CRITICAL}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code CRITICAL}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2_givenCritical_whenArrayListAddCritical() {
    // Arrange
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
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
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    ArrayList<AlarmSeverity> severityList = new ArrayList<>();
    severityList.add(AlarmSeverity.CRITICAL);
    ArrayList<String> typeList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            affectedEntityId, pageLink, typeList, new ArrayList<>(), severityList, null);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            isNull(),
            isA(List.class),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindAlarmsV2Result.getTotalPages());
    assertFalse(actualFindAlarmsV2Result.hasNext());
    assertTrue(actualFindAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link UserId} {@link UserId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2_givenOne_whenUserIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
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
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            affectedEntityId, pageLink, typeList, statusList, new ArrayList<>(), assigneeId);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindAlarmsV2Result.getTotalPages());
    assertFalse(actualFindAlarmsV2Result.hasNext());
    assertTrue(actualFindAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@code Try to find alarms by entity [{}], query [{}] and pageLink [{}]}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2_givenTryToFindAlarmsByEntityQueryAndPageLink() {
    // Arrange
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
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
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    ArrayList<String> typeList = new ArrayList<>();
    typeList.add("Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(affectedEntityId, pageLink, typeList, statusList, new ArrayList<>(), null);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindAlarmsV2Result.getTotalPages());
    assertFalse(actualFindAlarmsV2Result.hasNext());
    assertTrue(actualFindAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmRepository#findAllAlarmsV2(UUID, Long, Long, List, List, boolean,
   *       boolean, boolean, boolean, UUID, String, Pageable)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2_thenCallsFindAllAlarmsV2() {
    // Arrange
    when(alarmRepository.findAllAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    TimePageLink pageLink = new TimePageLink(3);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(null, pageLink, typeList, statusList, new ArrayList<>(), null);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(alarmRepository)
        .findAllAlarmsV2(
            isA(UUID.class),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindAlarmsV2Result.getTotalPages());
    assertFalse(actualFindAlarmsV2Result.hasNext());
    assertTrue(actualFindAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Then Data first Originator return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2_thenDataFirstOriginatorReturnTenantId() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(3L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(3L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(3L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(3L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(3L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    UUID originatorId = UUID.randomUUID();
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(3L);
    alarmInfoEntity.setStatus("Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity);
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            affectedEntityId, pageLink, typeList, statusList, new ArrayList<>(), assigneeId);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<AlarmInfo> data = actualFindAlarmsV2Result.getData();
    assertEquals(1, data.size());
    AlarmInfo getResult = data.get(0);
    EntityId originator = getResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(originator.isNullUid());
    assertFalse(((TenantId) originator).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId is Data first Originator.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2_thenReturnDataFirstTenantIdIsDataFirstOriginator() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(3L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(3L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(3L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(3L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(3L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(3L);
    alarmInfoEntity.setStatus("Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find alarms by entity [{}], query [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity);
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            affectedEntityId, pageLink, typeList, statusList, new ArrayList<>(), assigneeId);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<AlarmInfo> data = actualFindAlarmsV2Result.getData();
    assertEquals(1, data.size());
    AlarmInfo getResult = data.get(0);
    EntityId originator = getResult.getOriginator();
    assertSame(originator, getResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV2_whenUserIdWithIdIsNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
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
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            affectedEntityId,
            pageLink,
            typeList,
            statusList,
            severityList,
            new UserId(ModelConstants.NULL_UUID));

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindAlarmsV2Result.getTotalPages());
    assertFalse(actualFindAlarmsV2Result.hasNext());
    assertTrue(actualFindAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV22() {
    // Arrange
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    TimePageLink pageLink = new TimePageLink(3);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            ModelConstants.SYSTEM_TENANT, pageLink, typeList, statusList, new ArrayList<>(), null);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindAlarmsV2Result.getTotalPages());
    assertFalse(actualFindAlarmsV2Result.hasNext());
    assertTrue(actualFindAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV23() {
    // Arrange
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    AlarmId affectedEntityId = mock(AlarmId.class);
    when(affectedEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(affectedEntityId.getEntityType()).thenReturn(EntityType.TENANT);
    TimePageLink pageLink = new TimePageLink(3);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(affectedEntityId, pageLink, typeList, statusList, new ArrayList<>(), null);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(affectedEntityId).getEntityType();
    verify(affectedEntityId).getId();
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindAlarmsV2Result.getTotalPages());
    assertFalse(actualFindAlarmsV2Result.hasNext());
    assertTrue(actualFindAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsV2(TenantId, AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findAlarmsV2(TenantId, AlarmQueryV2)"})
  public void testFindAlarmsV24() {
    // Arrange
    when(alarmRepository.findAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
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
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(affectedEntityId, pageLink, typeList, statusList, new ArrayList<>(), null);

    // Act
    PageData<AlarmInfo> actualFindAlarmsV2Result =
        jpaAlarmDao.findAlarmsV2(ModelConstants.SYSTEM_TENANT, query);

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
    verify(alarmRepository)
        .findAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq("TENANT"),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindAlarmsV2Result.getTotalPages());
    assertFalse(actualFindAlarmsV2Result.hasNext());
    assertTrue(actualFindAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2() {
    // Arrange
    when(alarmRepository.findCustomerAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
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
        jpaAlarmDao.findCustomerAlarmsV2(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsV2Result.getTotalPages());
    assertFalse(actualFindCustomerAlarmsV2Result.hasNext());
    assertTrue(actualFindCustomerAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2_givenActive_whenArrayListAddActive() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    alarmInfoEntity.setOriginatorLabel(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity);
    when(alarmRepository.findCustomerAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.ACTIVE);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            typeList,
            statusList,
            new ArrayList<>(),
            assigneeId);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsV2Result =
        jpaAlarmDao.findCustomerAlarmsV2(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(assigneeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(true),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<AlarmInfo> data = actualFindCustomerAlarmsV2Result.getData();
    assertEquals(1, data.size());
    AlarmInfo getResult = data.get(0);
    EntityId originator = getResult.getOriginator();
    assertSame(originator, getResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) AckTs is four.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2_givenAlarmInfoEntityAckTsIsFour_thenReturnDataSizeIsTwo() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    alarmInfoEntity.setOriginatorLabel(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(4L);
    alarmInfoEntity2.setAcknowledged(false);
    alarmInfoEntity2.setAssignTs(4L);
    alarmInfoEntity2.setAssigneeEmail("john.smith@example.org");
    alarmInfoEntity2.setAssigneeFirstName("John");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Smith");
    alarmInfoEntity2.setClearTs(4L);
    alarmInfoEntity2.setCleared(false);
    alarmInfoEntity2.setCreatedTime(4L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(4L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel(",");
    alarmInfoEntity2.setOriginatorName(",");
    alarmInfoEntity2.setOriginatorType(EntityType.CUSTOMER);
    alarmInfoEntity2.setPropagate(false);
    alarmInfoEntity2.setPropagateRelationTypes(",");
    alarmInfoEntity2.setPropagateToOwner(false);
    alarmInfoEntity2.setPropagateToTenant(false);
    alarmInfoEntity2.setSeverity(AlarmSeverity.MAJOR);
    alarmInfoEntity2.setStartTs(4L);
    alarmInfoEntity2.setStatus(",");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType(",");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity2);
    content.add(alarmInfoEntity);
    when(alarmRepository.findCustomerAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            typeList,
            statusList,
            new ArrayList<>(),
            assigneeId);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsV2Result =
        jpaAlarmDao.findCustomerAlarmsV2(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(assigneeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(2, actualFindCustomerAlarmsV2Result.getData().size());
    assertEquals(2L, actualFindCustomerAlarmsV2Result.getTotalElements());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@code ANY}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ANY}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2_givenAny_whenArrayListAddAny() {
    // Arrange
    when(alarmRepository.findCustomerAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.ANY);
    ArrayList<String> typeList = new ArrayList<>();

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
        jpaAlarmDao.findCustomerAlarmsV2(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsV2Result.getTotalPages());
    assertFalse(actualFindCustomerAlarmsV2Result.hasNext());
    assertTrue(actualFindCustomerAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@code CLEARED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code CLEARED}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2_givenCleared_whenArrayListAddCleared() {
    // Arrange
    when(alarmRepository.findCustomerAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.CLEARED);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            typeList,
            statusList,
            new ArrayList<>(),
            assigneeId);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsV2Result =
        jpaAlarmDao.findCustomerAlarmsV2(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(assigneeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(true),
            eq(true),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsV2Result.getTotalPages());
    assertFalse(actualFindCustomerAlarmsV2Result.hasNext());
    assertTrue(actualFindCustomerAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@code CLEARED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code CLEARED}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2_givenCleared_whenArrayListAddCleared2() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    alarmInfoEntity.setOriginatorLabel(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity);
    when(alarmRepository.findCustomerAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.CLEARED);
    statusList.add(AlarmSearchStatus.ACTIVE);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            typeList,
            statusList,
            new ArrayList<>(),
            assigneeId);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsV2Result =
        jpaAlarmDao.findCustomerAlarmsV2(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(assigneeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<AlarmInfo> data = actualFindCustomerAlarmsV2Result.getData();
    assertEquals(1, data.size());
    AlarmInfo getResult = data.get(0);
    EntityId originator = getResult.getOriginator();
    assertSame(originator, getResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@code CRITICAL}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code CRITICAL}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2_givenCritical_whenArrayListAddCritical() {
    // Arrange
    when(alarmRepository.findCustomerAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    ArrayList<AlarmSeverity> severityList = new ArrayList<>();
    severityList.add(AlarmSeverity.CRITICAL);
    ArrayList<String> typeList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            typeList,
            new ArrayList<>(),
            severityList,
            null);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsV2Result =
        jpaAlarmDao.findCustomerAlarmsV2(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            isNull(),
            isA(List.class),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsV2Result.getTotalPages());
    assertFalse(actualFindCustomerAlarmsV2Result.hasNext());
    assertTrue(actualFindCustomerAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2_givenNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmRepository.findCustomerAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            typeList,
            statusList,
            new ArrayList<>(),
            assigneeId);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsV2Result =
        jpaAlarmDao.findCustomerAlarmsV2(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(assigneeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsV2Result.getTotalPages());
    assertFalse(actualFindCustomerAlarmsV2Result.hasNext());
    assertTrue(actualFindCustomerAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Given {@code Try to find customer alarms by query [{}] and pageLink [{}]}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2_givenTryToFindCustomerAlarmsByQueryAndPageLink() {
    // Arrange
    when(alarmRepository.findCustomerAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    ArrayList<String> typeList = new ArrayList<>();
    typeList.add("Try to find customer alarms by query [{}] and pageLink [{}]");
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
        jpaAlarmDao.findCustomerAlarmsV2(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            isA(List.class),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsV2Result.getTotalPages());
    assertFalse(actualFindCustomerAlarmsV2Result.hasNext());
    assertTrue(actualFindCustomerAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Then Data first Originator return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2_thenDataFirstOriginatorReturnTenantId() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    UUID originatorId = UUID.randomUUID();
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity);
    when(alarmRepository.findCustomerAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            typeList,
            statusList,
            new ArrayList<>(),
            assigneeId);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsV2Result =
        jpaAlarmDao.findCustomerAlarmsV2(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(assigneeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<AlarmInfo> data = actualFindCustomerAlarmsV2Result.getData();
    assertEquals(1, data.size());
    AlarmInfo getResult = data.get(0);
    EntityId originator = getResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(originator.isNullUid());
    assertFalse(((TenantId) originator).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId is Data first Originator.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2_thenReturnDataFirstTenantIdIsDataFirstOriginator() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    alarmInfoEntity.setOriginatorLabel(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity);
    when(alarmRepository.findCustomerAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            typeList,
            statusList,
            new ArrayList<>(),
            assigneeId);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsV2Result =
        jpaAlarmDao.findCustomerAlarmsV2(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(assigneeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<AlarmInfo> data = actualFindCustomerAlarmsV2Result.getData();
    assertEquals(1, data.size());
    AlarmInfo getResult = data.get(0);
    EntityId originator = getResult.getOriginator();
    assertSame(originator, getResult.getTenantId());
    assertSame(TenantId.SYS_TENANT_ID, originator);
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>Then return Data size is three.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2_thenReturnDataSizeIsThree() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
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
    alarmInfoEntity.setOriginatorLabel(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorName(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(
        "Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Try to find customer alarms by query [{}] and pageLink [{}]");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(4L);
    alarmInfoEntity2.setAcknowledged(false);
    alarmInfoEntity2.setAssignTs(4L);
    alarmInfoEntity2.setAssigneeEmail("john.smith@example.org");
    alarmInfoEntity2.setAssigneeFirstName("John");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Smith");
    alarmInfoEntity2.setClearTs(4L);
    alarmInfoEntity2.setCleared(false);
    alarmInfoEntity2.setCreatedTime(4L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(4L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel(",");
    alarmInfoEntity2.setOriginatorName(",");
    alarmInfoEntity2.setOriginatorType(EntityType.CUSTOMER);
    alarmInfoEntity2.setPropagate(false);
    alarmInfoEntity2.setPropagateRelationTypes(",");
    alarmInfoEntity2.setPropagateToOwner(false);
    alarmInfoEntity2.setPropagateToTenant(false);
    alarmInfoEntity2.setSeverity(AlarmSeverity.MAJOR);
    alarmInfoEntity2.setStartTs(4L);
    alarmInfoEntity2.setStatus(",");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType(",");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity3 = new AlarmInfoEntity();
    alarmInfoEntity3.setAckTs(0L);
    alarmInfoEntity3.setAcknowledged(true);
    alarmInfoEntity3.setAssignTs(0L);
    alarmInfoEntity3.setAssigneeEmail("prof.einstein@example.org");
    alarmInfoEntity3.setAssigneeFirstName("Albert");
    alarmInfoEntity3.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity3.setAssigneeLastName("Einstein");
    alarmInfoEntity3.setClearTs(0L);
    alarmInfoEntity3.setCleared(true);
    alarmInfoEntity3.setCreatedTime(0L);
    alarmInfoEntity3.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity3.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity3.setEndTs(0L);
    alarmInfoEntity3.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity3.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity3.setOriginatorLabel("Originator Label");
    alarmInfoEntity3.setOriginatorName("Originator Name");
    alarmInfoEntity3.setOriginatorType(EntityType.USER);
    alarmInfoEntity3.setPropagate(true);
    alarmInfoEntity3.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity3.setPropagateToOwner(true);
    alarmInfoEntity3.setPropagateToTenant(true);
    alarmInfoEntity3.setSeverity(AlarmSeverity.MINOR);
    alarmInfoEntity3.setStartTs(0L);
    alarmInfoEntity3.setStatus("Status");
    alarmInfoEntity3.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity3.setType("Type");
    alarmInfoEntity3.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AlarmInfoEntity> content = new ArrayList<>();
    content.add(alarmInfoEntity3);
    content.add(alarmInfoEntity2);
    content.add(alarmInfoEntity);
    when(alarmRepository.findCustomerAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    UserId assigneeId = mock(UserId.class);
    when(assigneeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            typeList,
            statusList,
            new ArrayList<>(),
            assigneeId);

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsV2Result =
        jpaAlarmDao.findCustomerAlarmsV2(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(assigneeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(3, actualFindCustomerAlarmsV2Result.getData().size());
    assertEquals(3L, actualFindCustomerAlarmsV2Result.getTotalElements());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>When {@link TimePageLink#TimePageLink(int)} with pageSize is three.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2_whenTimePageLinkWithPageSizeIsThree() {
    // Arrange
    when(alarmRepository.findCustomerAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
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
        jpaAlarmDao.findCustomerAlarmsV2(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(alarmRepository)
        .findCustomerAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isNull(),
            isNull(),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsV2Result.getTotalPages());
    assertFalse(actualFindCustomerAlarmsV2Result.hasNext());
    assertTrue(actualFindCustomerAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findCustomerAlarmsV2(TenantId, CustomerId,
   * AlarmQueryV2)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findCustomerAlarmsV2(TenantId, CustomerId, AlarmQueryV2)"
  })
  public void testFindCustomerAlarmsV2_whenUserIdWithIdIsNull_uuid() {
    // Arrange
    when(alarmRepository.findCustomerAlarmsV2(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<String>>any(),
            Mockito.<List<AlarmSeverity>>any(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    AlarmQueryV2 query =
        new AlarmQueryV2(
            BaseEntityService.NULL_CUSTOMER_ID,
            pageLink,
            typeList,
            statusList,
            severityList,
            new UserId(ModelConstants.NULL_UUID));

    // Act
    PageData<AlarmInfo> actualFindCustomerAlarmsV2Result =
        jpaAlarmDao.findCustomerAlarmsV2(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(alarmRepository)
        .findCustomerAlarmsV2(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            isNull(),
            isNull(),
            eq(false),
            eq(false),
            eq(false),
            eq(false),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindCustomerAlarmsV2Result.getTotalElements());
    assertEquals(1, actualFindCustomerAlarmsV2Result.getTotalPages());
    assertFalse(actualFindCustomerAlarmsV2Result.hasNext());
    assertTrue(actualFindCustomerAlarmsV2Result.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmDataByQueryForEntities(TenantId,
   * AlarmDataQuery, Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)"
  })
  public void testFindAlarmDataByQueryForEntities() {
    // Arrange
    PageData<AlarmData> emptyPageDataResult = PageData.emptyPageData();
    when(alarmQueryRepository.findAlarmDataByQueryForEntities(
            Mockito.<TenantId>any(),
            Mockito.<AlarmDataQuery>any(),
            Mockito.<Collection<EntityId>>any()))
        .thenReturn(emptyPageDataResult);
    AlarmDataQuery query = new AlarmDataQuery();

    // Act
    PageData<AlarmData> actualFindAlarmDataByQueryForEntitiesResult =
        jpaAlarmDao.findAlarmDataByQueryForEntities(
            ModelConstants.SYSTEM_TENANT, query, new ArrayList<>());

    // Assert
    verify(alarmQueryRepository)
        .findAlarmDataByQueryForEntities(
            isA(TenantId.class), isA(AlarmDataQuery.class), isA(Collection.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAlarmDataByQueryForEntitiesResult);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)"
  })
  public void testFindAlarmsIdsByEndTsBeforeAndTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmRepository.findAlarmsIdsByEndTsBeforeAndTenantId(
            Mockito.<Long>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<AlarmId> actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult =
        jpaAlarmDao.findAlarmsIdsByEndTsBeforeAndTenantId(10L, tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(alarmRepository)
        .findAlarmsIdsByEndTsBeforeAndTenantId(eq(10L), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getTotalPages());
    assertFalse(actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.hasNext());
    assertTrue(actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)"
  })
  public void testFindAlarmsIdsByEndTsBeforeAndTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    when(alarmRepository.findAlarmsIdsByEndTsBeforeAndTenantId(
            Mockito.<Long>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<AlarmId> actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult =
        jpaAlarmDao.findAlarmsIdsByEndTsBeforeAndTenantId(10L, tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(alarmRepository)
        .findAlarmsIdsByEndTsBeforeAndTenantId(eq(10L), isA(UUID.class), isA(Pageable.class));
    List<AlarmId> data = actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getData();
    assertEquals(1, data.size());
    AlarmId getResult = data.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertEquals(1L, actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getTotalElements());
    assertEquals(EntityType.ALARM, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)"
  })
  public void testFindAlarmsIdsByEndTsBeforeAndTenantId_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    when(alarmRepository.findAlarmsIdsByEndTsBeforeAndTenantId(
            Mockito.<Long>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<AlarmId> actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult =
        jpaAlarmDao.findAlarmsIdsByEndTsBeforeAndTenantId(10L, tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(alarmRepository)
        .findAlarmsIdsByEndTsBeforeAndTenantId(eq(10L), isA(UUID.class), isA(Pageable.class));
    List<AlarmId> data = actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getTotalElements());
    AlarmId expectedGetResult = data.get(0);
    assertEquals(expectedGetResult, data.get(1));
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)"
  })
  public void testFindAlarmsIdsByEndTsBeforeAndTenantId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmRepository.findAlarmsIdsByEndTsBeforeAndTenantId(
            Mockito.<Long>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AlarmId> actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult =
        jpaAlarmDao.findAlarmsIdsByEndTsBeforeAndTenantId(
            10L, ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmRepository)
        .findAlarmsIdsByEndTsBeforeAndTenantId(eq(10L), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getTotalPages());
    assertFalse(actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.hasNext());
    assertTrue(actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmsIdsByEndTsBeforeAndTenantId(Long, TenantId, PageLink)"
  })
  public void testFindAlarmsIdsByEndTsBeforeAndTenantId_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(alarmRepository.findAlarmsIdsByEndTsBeforeAndTenantId(
            Mockito.<Long>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<AlarmId> actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult =
        jpaAlarmDao.findAlarmsIdsByEndTsBeforeAndTenantId(
            10L, tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(alarmRepository)
        .findAlarmsIdsByEndTsBeforeAndTenantId(eq(10L), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getTotalPages());
    assertFalse(actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.hasNext());
    assertTrue(actualFindAlarmsIdsByEndTsBeforeAndTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmRepository#findAlarmIdsByAssigneeId(UUID, UUID, Pageable)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long,
   * AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByAssigneeId_thenCallsFindAlarmIdsByAssigneeId() {
    // Arrange
    when(alarmRepository.findAlarmIdsByAssigneeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByAssigneeIdResult =
        jpaAlarmDao.findAlarmIdsByAssigneeId(
            ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID), 1L, null, 1);

    // Assert
    verify(alarmRepository)
        .findAlarmIdsByAssigneeId(isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmIdsByAssigneeIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmIdsByAssigneeIdResult.getTotalPages());
    assertFalse(actualFindAlarmIdsByAssigneeIdResult.hasNext());
    assertTrue(actualFindAlarmIdsByAssigneeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long,
   * AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByAssigneeId_thenCallsGetId() {
    // Arrange
    when(alarmRepository.findAlarmIdsByAssigneeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByAssigneeIdResult =
        jpaAlarmDao.findAlarmIdsByAssigneeId(
            tenantId, new UserId(ModelConstants.NULL_UUID), 1L, null, 1);

    // Assert
    verify(tenantId).getId();
    verify(alarmRepository)
        .findAlarmIdsByAssigneeId(isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmIdsByAssigneeIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmIdsByAssigneeIdResult.getTotalPages());
    assertFalse(actualFindAlarmIdsByAssigneeIdResult.hasNext());
    assertTrue(actualFindAlarmIdsByAssigneeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long,
   * AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByAssigneeId_thenReturnEmpty_page_data() {
    // Arrange
    when(alarmRepository.findAlarmIdsByAssigneeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new SliceImpl<>(new ArrayList<>()));

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByAssigneeIdResult =
        jpaAlarmDao.findAlarmIdsByAssigneeId(
            ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID), 1L, null, 1);

    // Assert
    verify(alarmRepository)
        .findAlarmIdsByAssigneeId(isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    assertEquals(PageData.EMPTY_PAGE_DATA, actualFindAlarmIdsByAssigneeIdResult);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)}.
   *
   * <ul>
   *   <li>When {@link AlarmId} {@link AlarmId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long,
   * AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByAssigneeId_whenAlarmIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    when(alarmRepository.findAlarmIdsByAssigneeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            anyLong(),
            Mockito.<UUID>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmId idOffset = mock(AlarmId.class);
    when(idOffset.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByAssigneeIdResult =
        jpaAlarmDao.findAlarmIdsByAssigneeId(tenantId, userId, 1L, idOffset, 1);

    // Assert
    verify(idOffset).getId();
    verify(tenantId).getId();
    verify(userId).getId();
    verify(alarmRepository)
        .findAlarmIdsByAssigneeId(
            isA(UUID.class), isA(UUID.class), eq(1L), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmIdsByAssigneeIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmIdsByAssigneeIdResult.getTotalPages());
    assertFalse(actualFindAlarmIdsByAssigneeIdResult.hasNext());
    assertTrue(actualFindAlarmIdsByAssigneeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long,
   * AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByAssigneeId_whenAlarmIdWithIdIsNull_uuid() {
    // Arrange
    when(alarmRepository.findAlarmIdsByAssigneeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            anyLong(),
            Mockito.<UUID>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByAssigneeIdResult =
        jpaAlarmDao.findAlarmIdsByAssigneeId(
            tenantId, userId, 1L, new AlarmId(ModelConstants.NULL_UUID), 1);

    // Assert
    verify(tenantId).getId();
    verify(userId).getId();
    verify(alarmRepository)
        .findAlarmIdsByAssigneeId(
            isA(UUID.class), isA(UUID.class), eq(1L), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmIdsByAssigneeIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmIdsByAssigneeIdResult.getTotalPages());
    assertFalse(actualFindAlarmIdsByAssigneeIdResult.hasNext());
    assertTrue(actualFindAlarmIdsByAssigneeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)}.
   *
   * <ul>
   *   <li>When {@link UserId} {@link UserId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmIdsByAssigneeId(TenantId, UserId, long,
   * AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmIdsByAssigneeId(TenantId, UserId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByAssigneeId_whenUserIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    when(alarmRepository.findAlarmIdsByAssigneeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByAssigneeIdResult =
        jpaAlarmDao.findAlarmIdsByAssigneeId(tenantId, userId, 1L, null, 1);

    // Assert
    verify(tenantId).getId();
    verify(userId).getId();
    verify(alarmRepository)
        .findAlarmIdsByAssigneeId(isA(UUID.class), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmIdsByAssigneeIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmIdsByAssigneeIdResult.getTotalPages());
    assertFalse(actualFindAlarmIdsByAssigneeIdResult.hasNext());
    assertTrue(actualFindAlarmIdsByAssigneeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmRepository#findAlarmIdsByOriginatorId(UUID, Pageable)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long,
   * AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByOriginatorId_thenCallsFindAlarmIdsByOriginatorId() {
    // Arrange
    when(alarmRepository.findAlarmIdsByOriginatorId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByOriginatorIdResult =
        jpaAlarmDao.findAlarmIdsByOriginatorId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, 1L, null, 1);

    // Assert
    verify(alarmRepository).findAlarmIdsByOriginatorId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmIdsByOriginatorIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmIdsByOriginatorIdResult.getTotalPages());
    assertFalse(actualFindAlarmIdsByOriginatorIdResult.hasNext());
    assertTrue(actualFindAlarmIdsByOriginatorIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long,
   * AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByOriginatorId_thenCallsGetId() {
    // Arrange
    when(alarmRepository.findAlarmIdsByOriginatorId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    EntityId originatorId = mock(EntityId.class);
    when(originatorId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByOriginatorIdResult =
        jpaAlarmDao.findAlarmIdsByOriginatorId(
            ModelConstants.SYSTEM_TENANT, originatorId, 1L, null, 1);

    // Assert
    verify(originatorId).getId();
    verify(alarmRepository).findAlarmIdsByOriginatorId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmIdsByOriginatorIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmIdsByOriginatorIdResult.getTotalPages());
    assertFalse(actualFindAlarmIdsByOriginatorIdResult.hasNext());
    assertTrue(actualFindAlarmIdsByOriginatorIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long,
   * AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByOriginatorId_thenReturnEmpty_page_data() {
    // Arrange
    when(alarmRepository.findAlarmIdsByOriginatorId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new SliceImpl<>(new ArrayList<>()));

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByOriginatorIdResult =
        jpaAlarmDao.findAlarmIdsByOriginatorId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, 1L, null, 1);

    // Assert
    verify(alarmRepository).findAlarmIdsByOriginatorId(isA(UUID.class), isA(Pageable.class));
    assertEquals(PageData.EMPTY_PAGE_DATA, actualFindAlarmIdsByOriginatorIdResult);
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)}.
   *
   * <ul>
   *   <li>When {@link AlarmId} {@link AlarmId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long,
   * AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByOriginatorId_whenAlarmIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    when(alarmRepository.findAlarmIdsByOriginatorId(
            Mockito.<UUID>any(), anyLong(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    EntityId originatorId = mock(EntityId.class);
    when(originatorId.getId()).thenReturn(ModelConstants.NULL_UUID);

    AlarmId idOffset = mock(AlarmId.class);
    when(idOffset.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByOriginatorIdResult =
        jpaAlarmDao.findAlarmIdsByOriginatorId(
            ModelConstants.SYSTEM_TENANT, originatorId, 1L, idOffset, 1);

    // Assert
    verify(originatorId).getId();
    verify(idOffset).getId();
    verify(alarmRepository)
        .findAlarmIdsByOriginatorId(isA(UUID.class), eq(1L), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmIdsByOriginatorIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmIdsByOriginatorIdResult.getTotalPages());
    assertFalse(actualFindAlarmIdsByOriginatorIdResult.hasNext());
    assertTrue(actualFindAlarmIdsByOriginatorIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findAlarmIdsByOriginatorId(TenantId, EntityId, long,
   * AlarmId, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAlarmDao.findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)"
  })
  public void testFindAlarmIdsByOriginatorId_whenAlarmIdWithIdIsNull_uuid() {
    // Arrange
    when(alarmRepository.findAlarmIdsByOriginatorId(
            Mockito.<UUID>any(), anyLong(), Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    EntityId originatorId = mock(EntityId.class);
    when(originatorId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<TbPair<UUID, Long>> actualFindAlarmIdsByOriginatorIdResult =
        jpaAlarmDao.findAlarmIdsByOriginatorId(
            ModelConstants.SYSTEM_TENANT,
            originatorId,
            1L,
            new AlarmId(ModelConstants.NULL_UUID),
            1);

    // Assert
    verify(originatorId).getId();
    verify(alarmRepository)
        .findAlarmIdsByOriginatorId(isA(UUID.class), eq(1L), isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmIdsByOriginatorIdResult.getTotalElements());
    assertEquals(1, actualFindAlarmIdsByOriginatorIdResult.getTotalPages());
    assertFalse(actualFindAlarmIdsByOriginatorIdResult.hasNext());
    assertTrue(actualFindAlarmIdsByOriginatorIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findEntityAlarmRecords(TenantId, AlarmId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findEntityAlarmRecords(TenantId, AlarmId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAlarmDao.findEntityAlarmRecords(TenantId, AlarmId)"})
  public void testFindEntityAlarmRecords_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(entityAlarmRepository.findAllByAlarmId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    AlarmId id = mock(AlarmId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EntityAlarm> actualFindEntityAlarmRecordsResult =
        jpaAlarmDao.findEntityAlarmRecords(ModelConstants.SYSTEM_TENANT, id);

    // Assert
    verify(id).getId();
    verify(entityAlarmRepository).findAllByAlarmId(isA(UUID.class));
    assertTrue(actualFindEntityAlarmRecordsResult.isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findEntityAlarmRecords(TenantId, AlarmId)}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findEntityAlarmRecords(TenantId, AlarmId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAlarmDao.findEntityAlarmRecords(TenantId, AlarmId)"})
  public void testFindEntityAlarmRecords_whenAlarmIdWithIdIsNull_uuid_thenReturnEmpty() {
    // Arrange
    when(entityAlarmRepository.findAllByAlarmId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<EntityAlarm> actualFindEntityAlarmRecordsResult =
        jpaAlarmDao.findEntityAlarmRecords(
            ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID));

    // Assert
    verify(entityAlarmRepository).findAllByAlarmId(isA(UUID.class));
    assertTrue(actualFindEntityAlarmRecordsResult.isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findEntityAlarmRecordsByEntityId(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findEntityAlarmRecordsByEntityId(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAlarmDao.findEntityAlarmRecordsByEntityId(TenantId, EntityId)"})
  public void testFindEntityAlarmRecordsByEntityId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(entityAlarmRepository.findAllByEntityId(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EntityAlarm> actualFindEntityAlarmRecordsByEntityIdResult =
        jpaAlarmDao.findEntityAlarmRecordsByEntityId(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getId();
    verify(entityAlarmRepository).findAllByEntityId(isA(UUID.class));
    assertTrue(actualFindEntityAlarmRecordsByEntityIdResult.isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#findEntityAlarmRecordsByEntityId(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findEntityAlarmRecordsByEntityId(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaAlarmDao.findEntityAlarmRecordsByEntityId(TenantId, EntityId)"})
  public void testFindEntityAlarmRecordsByEntityId_whenNull_customer_id_thenReturnEmpty() {
    // Arrange
    when(entityAlarmRepository.findAllByEntityId(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityAlarm> actualFindEntityAlarmRecordsByEntityIdResult =
        jpaAlarmDao.findEntityAlarmRecordsByEntityId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityAlarmRepository).findAllByEntityId(isA(UUID.class));
    assertTrue(actualFindEntityAlarmRecordsByEntityIdResult.isEmpty());
  }

  /**
   * Test {@link JpaAlarmDao#deleteEntityAlarmRecords(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#deleteEntityAlarmRecords(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JpaAlarmDao.deleteEntityAlarmRecords(TenantId, EntityId)"})
  public void testDeleteEntityAlarmRecords_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(entityAlarmRepository.deleteByEntityId(Mockito.<UUID>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    int actualDeleteEntityAlarmRecordsResult =
        jpaAlarmDao.deleteEntityAlarmRecords(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getId();
    verify(entityAlarmRepository).deleteByEntityId(isA(UUID.class));
    assertEquals(1, actualDeleteEntityAlarmRecordsResult);
  }

  /**
   * Test {@link JpaAlarmDao#deleteEntityAlarmRecords(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#deleteEntityAlarmRecords(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JpaAlarmDao.deleteEntityAlarmRecords(TenantId, EntityId)"})
  public void testDeleteEntityAlarmRecords_whenNull_customer_id_thenReturnOne() {
    // Arrange
    when(entityAlarmRepository.deleteByEntityId(Mockito.<UUID>any())).thenReturn(1);

    // Act
    int actualDeleteEntityAlarmRecordsResult =
        jpaAlarmDao.deleteEntityAlarmRecords(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(entityAlarmRepository).deleteByEntityId(isA(UUID.class));
    assertEquals(1, actualDeleteEntityAlarmRecordsResult);
  }

  /**
   * Test {@link JpaAlarmDao#deleteEntityAlarmRecordsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#deleteEntityAlarmRecordsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaAlarmDao.deleteEntityAlarmRecordsByTenantId(TenantId)"})
  public void testDeleteEntityAlarmRecordsByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(entityAlarmRepository).deleteByTenantId(Mockito.<UUID>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaAlarmDao.deleteEntityAlarmRecordsByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(entityAlarmRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaAlarmDao#deleteEntityAlarmRecordsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#deleteEntityAlarmRecordsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaAlarmDao.deleteEntityAlarmRecordsByTenantId(TenantId)"})
  public void testDeleteEntityAlarmRecordsByTenantId_whenSystem_tenant() {
    // Arrange
    doNothing().when(entityAlarmRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaAlarmDao.deleteEntityAlarmRecordsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(entityAlarmRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaAlarmDao#countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#countAlarmsByQuery(TenantId, CustomerId,
   * AlarmCountQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long JpaAlarmDao.countAlarmsByQuery(TenantId, CustomerId, AlarmCountQuery)"})
  public void testCountAlarmsByQuery() {
    // Arrange
    when(alarmQueryRepository.countAlarmsByQuery(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<AlarmCountQuery>any()))
        .thenReturn(3L);

    // Act
    long actualCountAlarmsByQueryResult =
        jpaAlarmDao.countAlarmsByQuery(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new AlarmCountQuery());

    // Assert
    verify(alarmQueryRepository)
        .countAlarmsByQuery(isA(TenantId.class), isA(CustomerId.class), isA(AlarmCountQuery.class));
    assertEquals(3L, actualCountAlarmsByQueryResult);
  }

  /**
   * Test {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findTenantAlarmTypes(UUID, PageLink)"})
  public void testFindTenantAlarmTypes() {
    // Arrange
    ArrayList<String> content = new ArrayList<>();
    content.add("foo");
    when(alarmRepository.findTenantAlarmTypes(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntitySubtype> actualFindTenantAlarmTypesResult =
        jpaAlarmDao.findTenantAlarmTypes(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(false));
    verify(alarmRepository)
        .findTenantAlarmTypes(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add empty string.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findTenantAlarmTypes(UUID, PageLink)"})
  public void testFindTenantAlarmTypes_givenArrayListAddEmptyString_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<String> content = new ArrayList<>();
    content.add("");
    content.add("foo");
    when(alarmRepository.findTenantAlarmTypes(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntitySubtype> actualFindTenantAlarmTypesResult =
        jpaAlarmDao.findTenantAlarmTypes(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(false));
    verify(alarmRepository)
        .findTenantAlarmTypes(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
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
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findTenantAlarmTypes(UUID, PageLink)"})
  public void testFindTenantAlarmTypes_givenOne_thenReturnEmpty_page_data() {
    // Arrange
    when(alarmRepository.findTenantAlarmTypes(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntitySubtype> actualFindTenantAlarmTypesResult =
        jpaAlarmDao.findTenantAlarmTypes(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(false));
    verify(alarmRepository)
        .findTenantAlarmTypes(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantAlarmTypesResult);
  }

  /**
   * Test {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findTenantAlarmTypes(UUID, PageLink)"})
  public void testFindTenantAlarmTypes_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    when(alarmRepository.findTenantAlarmTypes(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntitySubtype> actualFindTenantAlarmTypesResult =
        jpaAlarmDao.findTenantAlarmTypes(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmRepository).findTenantAlarmTypes(isA(UUID.class), eq(""), isA(Pageable.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantAlarmTypesResult);
  }

  /**
   * Test {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When randomUUID.
   *   <li>Then return not Data first TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#findTenantAlarmTypes(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAlarmDao.findTenantAlarmTypes(UUID, PageLink)"})
  public void testFindTenantAlarmTypes_whenRandomUUID_thenReturnNotDataFirstTenantIdNullUid() {
    // Arrange
    ArrayList<String> content = new ArrayList<>();
    content.add("foo");
    when(alarmRepository.findTenantAlarmTypes(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = UUID.randomUUID();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EntitySubtype> actualFindTenantAlarmTypesResult =
        jpaAlarmDao.findTenantAlarmTypes(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(false));
    verify(alarmRepository)
        .findTenantAlarmTypes(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntitySubtype> data = actualFindTenantAlarmTypesResult.getData();
    assertEquals(1, data.size());
    EntitySubtype getResult = data.get(0);
    assertEquals("foo", getResult.getType());
    assertEquals(1L, actualFindTenantAlarmTypesResult.getTotalElements());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaAlarmDao.removeAlarmTypesIfNoAlarmsPresent(UUID, Set)"})
  public void testRemoveAlarmTypesIfNoAlarmsPresent_given42_whenHashSetAdd42_thenReturnTrue() {
    // Arrange
    when(alarmRepository.deleteTypeIfNoAlarmsExist(Mockito.<UUID>any(), Mockito.<Set<String>>any()))
        .thenReturn(1);

    HashSet<String> types = new HashSet<>();
    types.add("42");
    types.add("foo");

    // Act
    boolean actualRemoveAlarmTypesIfNoAlarmsPresentResult =
        jpaAlarmDao.removeAlarmTypesIfNoAlarmsPresent(ModelConstants.NULL_UUID, types);

    // Assert
    verify(alarmRepository).deleteTypeIfNoAlarmsExist(isA(UUID.class), isA(Set.class));
    assertTrue(actualRemoveAlarmTypesIfNoAlarmsPresentResult);
  }

  /**
   * Test {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaAlarmDao.removeAlarmTypesIfNoAlarmsPresent(UUID, Set)"})
  public void testRemoveAlarmTypesIfNoAlarmsPresent_givenFoo_whenHashSetAddFoo_thenReturnTrue() {
    // Arrange
    when(alarmRepository.deleteTypeIfNoAlarmsExist(Mockito.<UUID>any(), Mockito.<Set<String>>any()))
        .thenReturn(1);

    HashSet<String> types = new HashSet<>();
    types.add("foo");

    // Act
    boolean actualRemoveAlarmTypesIfNoAlarmsPresentResult =
        jpaAlarmDao.removeAlarmTypesIfNoAlarmsPresent(ModelConstants.NULL_UUID, types);

    // Assert
    verify(alarmRepository).deleteTypeIfNoAlarmsExist(isA(UUID.class), isA(Set.class));
    assertTrue(actualRemoveAlarmTypesIfNoAlarmsPresentResult);
  }

  /**
   * Test {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaAlarmDao.removeAlarmTypesIfNoAlarmsPresent(UUID, Set)"})
  public void testRemoveAlarmTypesIfNoAlarmsPresent_thenReturnFalse() {
    // Arrange
    when(alarmRepository.deleteTypeIfNoAlarmsExist(Mockito.<UUID>any(), Mockito.<Set<String>>any()))
        .thenReturn(0);

    // Act
    boolean actualRemoveAlarmTypesIfNoAlarmsPresentResult =
        jpaAlarmDao.removeAlarmTypesIfNoAlarmsPresent(ModelConstants.NULL_UUID, new HashSet<>());

    // Assert
    verify(alarmRepository).deleteTypeIfNoAlarmsExist(isA(UUID.class), isA(Set.class));
    assertFalse(actualRemoveAlarmTypesIfNoAlarmsPresentResult);
  }

  /**
   * Test {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAlarmDao#removeAlarmTypesIfNoAlarmsPresent(UUID, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaAlarmDao.removeAlarmTypesIfNoAlarmsPresent(UUID, Set)"})
  public void testRemoveAlarmTypesIfNoAlarmsPresent_whenHashSet_thenReturnTrue() {
    // Arrange
    when(alarmRepository.deleteTypeIfNoAlarmsExist(Mockito.<UUID>any(), Mockito.<Set<String>>any()))
        .thenReturn(1);

    // Act
    boolean actualRemoveAlarmTypesIfNoAlarmsPresentResult =
        jpaAlarmDao.removeAlarmTypesIfNoAlarmsPresent(ModelConstants.NULL_UUID, new HashSet<>());

    // Assert
    verify(alarmRepository).deleteTypeIfNoAlarmsExist(isA(UUID.class), isA(Set.class));
    assertTrue(actualRemoveAlarmTypesIfNoAlarmsPresentResult);
  }
}
