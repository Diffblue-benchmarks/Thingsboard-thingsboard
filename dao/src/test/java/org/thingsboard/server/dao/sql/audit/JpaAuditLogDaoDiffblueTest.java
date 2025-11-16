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
package org.thingsboard.server.dao.sql.audit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AuditLogEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {JpaAuditLogDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaAuditLogDaoDiffblueTest {
  @MockBean private AuditLogRepository auditLogRepository;

  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaAuditLogDao jpaAuditLogDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private SqlPartitioningRepository sqlPartitioningRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List,
   * TimePageLink)}.
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId,
   * List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndEntityId() {
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
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, entityId, actionTypes, pageLink);

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
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndEntityId(
            isA(UUID.class),
            eq(EntityType.TENANT),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdAndEntityIdResult.getData();
    assertEquals(1, data.size());
    AuditLog getResult = data.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId2.getId().toString());
    assertTrue(entityId2.isNullUid());
    assertTrue(((TenantId) entityId2).isSysTenantId());
    assertSame(entityId2, getResult.getTenantId());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List,
   * TimePageLink)}.
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId,
   * List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndEntityId2() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    UUID entityId = UUID.randomUUID();
    auditLogEntity.setEntityId(entityId);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AuditLogEntity> content = new ArrayList<>();
    content.add(auditLogEntity);
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    EntityId entityId2 = mock(EntityId.class);
    when(entityId2.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId2.getEntityType()).thenReturn(EntityType.TENANT);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, entityId2, actionTypes, pageLink);

    // Assert
    verify(entityId2).getEntityType();
    verify(entityId2).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndEntityId(
            isA(UUID.class),
            eq(EntityType.TENANT),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdAndEntityIdResult.getData();
    assertEquals(1, data.size());
    AuditLog getResult = data.get(0);
    EntityId entityId3 = getResult.getEntityId();
    assertTrue(entityId3 instanceof TenantId);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(entityId3.isNullUid());
    assertFalse(((TenantId) entityId3).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId3.getId());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ADDED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId,
   * List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndEntityId_givenAdded_whenArrayListAddAdded() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, entityId, actionTypes, pageLink);

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
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndEntityId(
            isA(UUID.class),
            eq(EntityType.TENANT),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DELETED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId,
   * List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndEntityId_givenDeleted_whenArrayListAddDeleted() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, entityId, actionTypes, pageLink);

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
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndEntityId(
            isA(UUID.class),
            eq(EntityType.TENANT),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link TimePageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId,
   * List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndEntityId_givenOne_thenCallsGetPage() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, entityId, actionTypes, pageLink);

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
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndEntityId(
            isA(UUID.class),
            eq(EntityType.TENANT),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId,
   * List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndEntityId_whenNull_customer_id() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID,
            BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes,
            new TimePageLink(3));

    // Assert
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndEntityId(
            isA(UUID.class),
            eq(EntityType.CUSTOMER),
            isA(UUID.class),
            isNull(),
            isNull(),
            isNull(),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId,
   * List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndEntityId_whenSystem_tenant() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID,
            ModelConstants.SYSTEM_TENANT,
            actionTypes,
            new TimePageLink(3));

    // Assert
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndEntityId(
            isA(UUID.class),
            eq(EntityType.TENANT),
            isA(UUID.class),
            isNull(),
            isNull(),
            isNull(),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link TimePageLink#TimePageLink(int)} with pageSize is three.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndEntityId(UUID, EntityId,
   * List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(UUID, EntityId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndEntityId_whenTimePageLinkWithPageSizeIsThree() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndEntityId(
            ModelConstants.NULL_UUID, entityId, actionTypes, new TimePageLink(3));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndEntityId(
            isA(UUID.class),
            eq(EntityType.TENANT),
            isA(UUID.class),
            isNull(),
            isNull(),
            isNull(),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List,
   * TimePageLink)}.
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID,
   * CustomerId, List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndCustomerId() {
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
    when(auditLogRepository.findAuditLogsByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, customerId, actionTypes, pageLink);

    // Assert
    verify(customerId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndCustomerId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    AuditLog getResult = data.get(0);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List,
   * TimePageLink)}.
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID,
   * CustomerId, List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndCustomerId2() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    UUID entityId = UUID.randomUUID();
    auditLogEntity.setEntityId(entityId);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AuditLogEntity> content = new ArrayList<>();
    content.add(auditLogEntity);
    when(auditLogRepository.findAuditLogsByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, customerId, actionTypes, pageLink);

    // Assert
    verify(customerId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndCustomerId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    AuditLog getResult = data.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ADDED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID,
   * CustomerId, List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndCustomerId_givenAdded_whenArrayListAddAdded() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, customerId, actionTypes, pageLink);

    // Assert
    verify(customerId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndCustomerId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DELETED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID,
   * CustomerId, List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndCustomerId_givenDeleted_whenArrayListAddDeleted() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, customerId, actionTypes, pageLink);

    // Assert
    verify(customerId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndCustomerId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID,
   * CustomerId, List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndCustomerId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, customerId, actionTypes, pageLink);

    // Assert
    verify(customerId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndCustomerId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID,
   * CustomerId, List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndCustomerId_whenNull_customer_id() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID,
            BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes,
            new TimePageLink(3));

    // Assert
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndCustomerId(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            isNull(),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link TimePageLink#TimePageLink(int)} with pageSize is three.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndCustomerId(UUID,
   * CustomerId, List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndCustomerId(UUID, CustomerId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndCustomerId_whenTimePageLinkWithPageSizeIsThree() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndCustomerId(
            ModelConstants.NULL_UUID, customerId, actionTypes, new TimePageLink(3));

    // Assert
    verify(customerId).getId();
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndCustomerId(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            isNull(),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}.
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId,
   * List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndUserId() {
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
    when(auditLogRepository.findAuditLogsByTenantIdAndUserId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = UUID.randomUUID();

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndUserId(tenantId, userId, actionTypes, pageLink);

    // Assert
    verify(userId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndUserId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdAndUserIdResult.getData();
    assertEquals(1, data.size());
    AuditLog getResult = data.get(0);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}.
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId,
   * List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndUserId2() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    UUID entityId = UUID.randomUUID();
    auditLogEntity.setEntityId(entityId);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AuditLogEntity> content = new ArrayList<>();
    content.add(auditLogEntity);
    when(auditLogRepository.findAuditLogsByTenantIdAndUserId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = UUID.randomUUID();

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndUserId(tenantId, userId, actionTypes, pageLink);

    // Assert
    verify(userId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndUserId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdAndUserIdResult.getData();
    assertEquals(1, data.size());
    AuditLog getResult = data.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ADDED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId,
   * List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndUserId_givenAdded_whenArrayListAddAdded() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndUserId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = UUID.randomUUID();

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndUserId(tenantId, userId, actionTypes, pageLink);

    // Assert
    verify(userId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndUserId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndUserIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndUserIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DELETED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId,
   * List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndUserId_givenDeleted_whenArrayListAddDeleted() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndUserId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = UUID.randomUUID();

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndUserId(tenantId, userId, actionTypes, pageLink);

    // Assert
    verify(userId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndUserId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndUserIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndUserIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId,
   * List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndUserId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndUserId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = UUID.randomUUID();

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndUserId(tenantId, userId, actionTypes, pageLink);

    // Assert
    verify(userId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndUserId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndUserIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndUserIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link TimePageLink#TimePageLink(int)} with pageSize is three.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId,
   * List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndUserId_whenTimePageLinkWithPageSizeIsThree() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndUserId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = UUID.randomUUID();

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndUserId(
            tenantId, userId, actionTypes, new TimePageLink(3));

    // Assert
    verify(userId).getId();
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndUserId(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            isNull(),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndUserIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndUserIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantIdAndUserId(UUID, UserId,
   * List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaAuditLogDao.findAuditLogsByTenantIdAndUserId(UUID, UserId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndUserId_whenUserIdWithIdIsNull_uuid() {
    // Arrange
    when(auditLogRepository.findAuditLogsByTenantIdAndUserId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = UUID.randomUUID();
    UserId userId = new UserId(ModelConstants.NULL_UUID);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult =
        jpaAuditLogDao.findAuditLogsByTenantIdAndUserId(
            tenantId, userId, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogRepository)
        .findAuditLogsByTenantIdAndUserId(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            isNull(),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdAndUserIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdAndUserIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdAndUserIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}.
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAuditLogDao.findAuditLogsByTenantId(UUID, List, TimePageLink)"})
  public void testFindAuditLogsByTenantId() {
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
    when(auditLogRepository.findByTenantId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    ArrayList<ActionType> actionTypes = new ArrayList<>();

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult =
        jpaAuditLogDao.findAuditLogsByTenantId(ModelConstants.NULL_UUID, actionTypes, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findByTenantId(
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdResult.getData();
    assertEquals(1, data.size());
    AuditLog getResult = data.get(0);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}.
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAuditLogDao.findAuditLogsByTenantId(UUID, List, TimePageLink)"})
  public void testFindAuditLogsByTenantId2() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    UUID entityId = UUID.randomUUID();
    auditLogEntity.setEntityId(entityId);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<AuditLogEntity> content = new ArrayList<>();
    content.add(auditLogEntity);
    when(auditLogRepository.findByTenantId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    ArrayList<ActionType> actionTypes = new ArrayList<>();

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult =
        jpaAuditLogDao.findAuditLogsByTenantId(ModelConstants.NULL_UUID, actionTypes, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findByTenantId(
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    List<AuditLog> data = actualFindAuditLogsByTenantIdResult.getData();
    assertEquals(1, data.size());
    AuditLog getResult = data.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ADDED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAuditLogDao.findAuditLogsByTenantId(UUID, List, TimePageLink)"})
  public void testFindAuditLogsByTenantId_givenAdded_whenArrayListAddAdded() {
    // Arrange
    when(auditLogRepository.findByTenantId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult =
        jpaAuditLogDao.findAuditLogsByTenantId(ModelConstants.NULL_UUID, actionTypes, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findByTenantId(
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DELETED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAuditLogDao.findAuditLogsByTenantId(UUID, List, TimePageLink)"})
  public void testFindAuditLogsByTenantId_givenDeleted_whenArrayListAddDeleted() {
    // Arrange
    when(auditLogRepository.findByTenantId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult =
        jpaAuditLogDao.findAuditLogsByTenantId(ModelConstants.NULL_UUID, actionTypes, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findByTenantId(
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAuditLogDao.findAuditLogsByTenantId(UUID, List, TimePageLink)"})
  public void testFindAuditLogsByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(auditLogRepository.findByTenantId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<ActionType> actionTypes = new ArrayList<>();

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

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult =
        jpaAuditLogDao.findAuditLogsByTenantId(ModelConstants.NULL_UUID, actionTypes, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(auditLogRepository)
        .findByTenantId(
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            isA(List.class),
            isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link TimePageLink#TimePageLink(int)} with pageSize is three.
   * </ul>
   *
   * <p>Method under test: {@link JpaAuditLogDao#findAuditLogsByTenantId(UUID, List, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaAuditLogDao.findAuditLogsByTenantId(UUID, List, TimePageLink)"})
  public void testFindAuditLogsByTenantId_whenTimePageLinkWithPageSizeIsThree() {
    // Arrange
    when(auditLogRepository.findByTenantId(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult =
        jpaAuditLogDao.findAuditLogsByTenantId(
            ModelConstants.NULL_UUID, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogRepository)
        .findByTenantId(
            isA(UUID.class), isNull(), isNull(), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(0L, actualFindAuditLogsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAuditLogsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAuditLogsByTenantIdResult.hasNext());
    assertTrue(actualFindAuditLogsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAuditLogDao#cleanUpAuditLogs(long)}.
   *
   * <p>Method under test: {@link JpaAuditLogDao#cleanUpAuditLogs(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaAuditLogDao.cleanUpAuditLogs(long)"})
  public void testCleanUpAuditLogs() {
    // Arrange
    when(sqlPartitioningRepository.dropPartitionsBefore(
            Mockito.<String>any(), anyLong(), anyLong()))
        .thenReturn(1L);

    // Act
    jpaAuditLogDao.cleanUpAuditLogs(1L);

    // Assert
    verify(sqlPartitioningRepository).dropPartitionsBefore("audit_log", 1L, 604800000L);
  }

  /**
   * Test {@link JpaAuditLogDao#createPartition(AuditLogEntity)} with {@code AuditLogEntity}.
   *
   * <p>Method under test: {@link JpaAuditLogDao#createPartition(AuditLogEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaAuditLogDao.createPartition(AuditLogEntity)"})
  public void testCreatePartitionWithAuditLogEntity() {
    // Arrange
    doNothing()
        .when(sqlPartitioningRepository)
        .createPartitionIfNotExists(Mockito.<String>any(), anyLong(), anyLong());

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

    // Assert
    verify(sqlPartitioningRepository).createPartitionIfNotExists("audit_log", 1L, 604800000L);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaAuditLogDao#getEntityClass()}
   *   <li>{@link JpaAuditLogDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaAuditLogDao.getEntityClass()",
    "org.springframework.data.jpa.repository.JpaRepository JpaAuditLogDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaAuditLogDao jpaAuditLogDao =
        new JpaAuditLogDao(mock(AuditLogRepository.class), mock(SqlPartitioningRepository.class));

    // Act
    Class<AuditLogEntity> actualEntityClass = jpaAuditLogDao.getEntityClass();
    jpaAuditLogDao.getRepository();

    // Assert
    Class<AuditLogEntity> expectedEntityClass = AuditLogEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
