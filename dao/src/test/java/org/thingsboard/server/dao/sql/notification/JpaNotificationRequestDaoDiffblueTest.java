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
package org.thingsboard.server.dao.sql.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
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
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationRequest;
import org.thingsboard.server.common.data.notification.NotificationRequestInfo;
import org.thingsboard.server.common.data.notification.NotificationRequestStats;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationRequestEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaNotificationRequestDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaNotificationRequestDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaNotificationRequestDao jpaNotificationRequestDao;

  @MockBean private NotificationRequestRepository notificationRequestRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaNotificationRequestDao#findByTenantIdAndOriginatorTypeAndPageLink(TenantId,
   * EntityType, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#findByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRequestDao.findByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)"
  })
  public void testFindByTenantIdAndOriginatorTypeAndPageLink_givenOne_thenCallsGetPage() {
    // Arrange
    when(notificationRequestRepository.findByTenantIdAndOriginatorEntityType(
            Mockito.<UUID>any(), Mockito.<EntityType>any(), Mockito.<Pageable>any()))
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
    PageData<NotificationRequest> actualFindByTenantIdAndOriginatorTypeAndPageLinkResult =
        jpaNotificationRequestDao.findByTenantIdAndOriginatorTypeAndPageLink(
            tenantId, EntityType.TENANT, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRequestRepository)
        .findByTenantIdAndOriginatorEntityType(
            isA(UUID.class), eq(EntityType.TENANT), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRequestDao#findByTenantIdAndOriginatorTypeAndPageLink(TenantId,
   * EntityType, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#findByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRequestDao.findByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)"
  })
  public void testFindByTenantIdAndOriginatorTypeAndPageLink_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRequestRepository.findByTenantIdAndOriginatorEntityType(
            Mockito.<UUID>any(), Mockito.<EntityType>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationRequest> actualFindByTenantIdAndOriginatorTypeAndPageLinkResult =
        jpaNotificationRequestDao.findByTenantIdAndOriginatorTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT, EntityType.TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRequestRepository)
        .findByTenantIdAndOriginatorEntityType(
            isA(UUID.class), eq(EntityType.TENANT), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRequestDao#findByTenantIdAndOriginatorTypeAndPageLink(TenantId,
   * EntityType, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#findByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRequestDao.findByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)"
  })
  public void testFindByTenantIdAndOriginatorTypeAndPageLink_whenFirst_page_thenCallsGetId() {
    // Arrange
    when(notificationRequestRepository.findByTenantIdAndOriginatorEntityType(
            Mockito.<UUID>any(), Mockito.<EntityType>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<NotificationRequest> actualFindByTenantIdAndOriginatorTypeAndPageLinkResult =
        jpaNotificationRequestDao.findByTenantIdAndOriginatorTypeAndPageLink(
            tenantId, EntityType.TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(notificationRequestRepository)
        .findByTenantIdAndOriginatorEntityType(
            isA(UUID.class), eq(EntityType.TENANT), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndOriginatorTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRequestDao#findInfosByTenantIdAndOriginatorTypeAndPageLink(TenantId,
   * EntityType, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#findInfosByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRequestDao.findInfosByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)"
  })
  public void testFindInfosByTenantIdAndOriginatorTypeAndPageLink() {
    // Arrange
    when(notificationRequestRepository.findInfosByTenantIdAndOriginatorEntityTypeAndSearchText(
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationRequestInfo> actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult =
        jpaNotificationRequestDao.findInfosByTenantIdAndOriginatorTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT, EntityType.TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRequestRepository)
        .findInfosByTenantIdAndOriginatorEntityTypeAndSearchText(
            isA(UUID.class), eq(EntityType.TENANT), isNull(), isA(Pageable.class));
    assertEquals(
        0L, actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRequestDao#findInfosByTenantIdAndOriginatorTypeAndPageLink(TenantId,
   * EntityType, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#findInfosByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRequestDao.findInfosByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)"
  })
  public void testFindInfosByTenantIdAndOriginatorTypeAndPageLink_givenOne_thenCallsGetPage() {
    // Arrange
    when(notificationRequestRepository.findInfosByTenantIdAndOriginatorEntityTypeAndSearchText(
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<NotificationRequestInfo> actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult =
        jpaNotificationRequestDao.findInfosByTenantIdAndOriginatorTypeAndPageLink(
            tenantId, EntityType.TENANT, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRequestRepository)
        .findInfosByTenantIdAndOriginatorEntityTypeAndSearchText(
            isA(UUID.class), eq(EntityType.TENANT), eq("Text Search"), isA(Pageable.class));
    assertEquals(
        0L, actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRequestDao#findInfosByTenantIdAndOriginatorTypeAndPageLink(TenantId,
   * EntityType, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#findInfosByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRequestDao.findInfosByTenantIdAndOriginatorTypeAndPageLink(TenantId, EntityType, PageLink)"
  })
  public void testFindInfosByTenantIdAndOriginatorTypeAndPageLink_thenCallsGetId() {
    // Arrange
    when(notificationRequestRepository.findInfosByTenantIdAndOriginatorEntityTypeAndSearchText(
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<NotificationRequestInfo> actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult =
        jpaNotificationRequestDao.findInfosByTenantIdAndOriginatorTypeAndPageLink(
            tenantId, EntityType.TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(notificationRequestRepository)
        .findInfosByTenantIdAndOriginatorEntityTypeAndSearchText(
            isA(UUID.class), eq(EntityType.TENANT), isNull(), isA(Pageable.class));
    assertEquals(
        0L, actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.hasNext());
    assertTrue(actualFindInfosByTenantIdAndOriginatorTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId, NotificationRequestStatus,
   * NotificationRuleId)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId,
   * NotificationRequestStatus, NotificationRuleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationRequestDao.findIdsByRuleId(TenantId, NotificationRequestStatus, NotificationRuleId)"
  })
  public void testFindIdsByRuleId_givenArrayListAddNull_uuid_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(ModelConstants.NULL_UUID);
    when(notificationRequestRepository.findAllIdsByStatusAndRuleId(
            Mockito.<NotificationRequestStatus>any(), Mockito.<UUID>any()))
        .thenReturn(uuidList);

    // Act
    List<NotificationRequestId> actualFindIdsByRuleIdResult =
        jpaNotificationRequestDao.findIdsByRuleId(
            ModelConstants.SYSTEM_TENANT,
            NotificationRequestStatus.PROCESSING,
            new NotificationRuleId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestRepository)
        .findAllIdsByStatusAndRuleId(eq(NotificationRequestStatus.PROCESSING), isA(UUID.class));
    assertEquals(1, actualFindIdsByRuleIdResult.size());
    NotificationRequestId getResult = actualFindIdsByRuleIdResult.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertEquals(EntityType.NOTIFICATION_REQUEST, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
  }

  /**
   * Test {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId, NotificationRequestStatus,
   * NotificationRuleId)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId,
   * NotificationRequestStatus, NotificationRuleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationRequestDao.findIdsByRuleId(TenantId, NotificationRequestStatus, NotificationRuleId)"
  })
  public void testFindIdsByRuleId_givenArrayListAddNull_uuid_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(ModelConstants.NULL_UUID);
    uuidList.add(ModelConstants.NULL_UUID);
    when(notificationRequestRepository.findAllIdsByStatusAndRuleId(
            Mockito.<NotificationRequestStatus>any(), Mockito.<UUID>any()))
        .thenReturn(uuidList);

    // Act
    List<NotificationRequestId> actualFindIdsByRuleIdResult =
        jpaNotificationRequestDao.findIdsByRuleId(
            ModelConstants.SYSTEM_TENANT,
            NotificationRequestStatus.PROCESSING,
            new NotificationRuleId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestRepository)
        .findAllIdsByStatusAndRuleId(eq(NotificationRequestStatus.PROCESSING), isA(UUID.class));
    assertEquals(2, actualFindIdsByRuleIdResult.size());
    NotificationRequestId expectedGetResult = actualFindIdsByRuleIdResult.get(0);
    assertEquals(expectedGetResult, actualFindIdsByRuleIdResult.get(1));
  }

  /**
   * Test {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId, NotificationRequestStatus,
   * NotificationRuleId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link NotificationRuleId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId,
   * NotificationRequestStatus, NotificationRuleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationRequestDao.findIdsByRuleId(TenantId, NotificationRequestStatus, NotificationRuleId)"
  })
  public void testFindIdsByRuleId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(notificationRequestRepository.findAllIdsByStatusAndRuleId(
            Mockito.<NotificationRequestStatus>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    NotificationRuleId ruleId = mock(NotificationRuleId.class);
    when(ruleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationRequestId> actualFindIdsByRuleIdResult =
        jpaNotificationRequestDao.findIdsByRuleId(
            ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING, ruleId);

    // Assert
    verify(ruleId).getId();
    verify(notificationRequestRepository)
        .findAllIdsByStatusAndRuleId(eq(NotificationRequestStatus.PROCESSING), isA(UUID.class));
    assertTrue(actualFindIdsByRuleIdResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId, NotificationRequestStatus,
   * NotificationRuleId)}.
   *
   * <ul>
   *   <li>When {@link NotificationRuleId#NotificationRuleId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRequestDao#findIdsByRuleId(TenantId,
   * NotificationRequestStatus, NotificationRuleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationRequestDao.findIdsByRuleId(TenantId, NotificationRequestStatus, NotificationRuleId)"
  })
  public void testFindIdsByRuleId_whenNotificationRuleIdWithIdIsNull_uuid_thenReturnEmpty() {
    // Arrange
    when(notificationRequestRepository.findAllIdsByStatusAndRuleId(
            Mockito.<NotificationRequestStatus>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<NotificationRequestId> actualFindIdsByRuleIdResult =
        jpaNotificationRequestDao.findIdsByRuleId(
            ModelConstants.SYSTEM_TENANT,
            NotificationRequestStatus.PROCESSING,
            new NotificationRuleId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestRepository)
        .findAllIdsByStatusAndRuleId(eq(NotificationRequestStatus.PROCESSING), isA(UUID.class));
    assertTrue(actualFindIdsByRuleIdResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId,
   * NotificationRuleId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>Then calls {@link EntityId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationRequestDao.findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)"
  })
  public void testFindByRuleIdAndOriginatorEntityId_givenTenant_thenCallsGetEntityType() {
    // Arrange
    when(notificationRequestRepository.findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EntityType>any()))
        .thenReturn(new ArrayList<>());

    NotificationRuleId ruleId = mock(NotificationRuleId.class);
    when(ruleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityId originatorEntityId = mock(EntityId.class);
    when(originatorEntityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(originatorEntityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    List<NotificationRequest> actualFindByRuleIdAndOriginatorEntityIdResult =
        jpaNotificationRequestDao.findByRuleIdAndOriginatorEntityId(
            ModelConstants.SYSTEM_TENANT, ruleId, originatorEntityId);

    // Assert
    verify(originatorEntityId).getEntityType();
    verify(originatorEntityId).getId();
    verify(ruleId).getId();
    verify(notificationRequestRepository)
        .findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(
            isA(UUID.class), isA(UUID.class), eq(EntityType.TENANT));
    assertTrue(actualFindByRuleIdAndOriginatorEntityIdResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId,
   * NotificationRuleId, EntityId)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationRequestDao.findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)"
  })
  public void testFindByRuleIdAndOriginatorEntityId_thenReturnEmpty() {
    // Arrange
    when(notificationRequestRepository.findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EntityType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<NotificationRequest> actualFindByRuleIdAndOriginatorEntityIdResult =
        jpaNotificationRequestDao.findByRuleIdAndOriginatorEntityId(
            ModelConstants.SYSTEM_TENANT,
            new NotificationRuleId(ModelConstants.NULL_UUID),
            BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationRequestRepository)
        .findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(
            isA(UUID.class), isA(UUID.class), eq(EntityType.CUSTOMER));
    assertTrue(actualFindByRuleIdAndOriginatorEntityIdResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId,
   * NotificationRuleId, EntityId)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationRequestDao.findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)"
  })
  public void testFindByRuleIdAndOriginatorEntityId_thenReturnEmpty2() {
    // Arrange
    when(notificationRequestRepository.findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EntityType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<NotificationRequest> actualFindByRuleIdAndOriginatorEntityIdResult =
        jpaNotificationRequestDao.findByRuleIdAndOriginatorEntityId(
            ModelConstants.SYSTEM_TENANT,
            new NotificationRuleId(ModelConstants.NULL_UUID),
            ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationRequestRepository)
        .findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(
            isA(UUID.class), isA(UUID.class), eq(EntityType.TENANT));
    assertTrue(actualFindByRuleIdAndOriginatorEntityIdResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId,
   * NotificationRuleId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then calls {@link NotificationRuleId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationRequestDao.findByRuleIdAndOriginatorEntityId(TenantId, NotificationRuleId, EntityId)"
  })
  public void testFindByRuleIdAndOriginatorEntityId_whenNull_customer_id_thenCallsGetId() {
    // Arrange
    when(notificationRequestRepository.findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<EntityType>any()))
        .thenReturn(new ArrayList<>());

    NotificationRuleId ruleId = mock(NotificationRuleId.class);
    when(ruleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationRequest> actualFindByRuleIdAndOriginatorEntityIdResult =
        jpaNotificationRequestDao.findByRuleIdAndOriginatorEntityId(
            ModelConstants.SYSTEM_TENANT, ruleId, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(ruleId).getId();
    verify(notificationRequestRepository)
        .findAllByRuleIdAndOriginatorEntityIdAndOriginatorEntityType(
            isA(UUID.class), isA(UUID.class), eq(EntityType.CUSTOMER));
    assertTrue(actualFindByRuleIdAndOriginatorEntityIdResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationRequestDao#findAllByStatus(NotificationRequestStatus, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#findAllByStatus(NotificationRequestStatus, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRequestDao.findAllByStatus(NotificationRequestStatus, PageLink)"
  })
  public void testFindAllByStatus_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(notificationRequestRepository.findAllByStatus(
            Mockito.<NotificationRequestStatus>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<NotificationRequest> actualFindAllByStatusResult =
        jpaNotificationRequestDao.findAllByStatus(NotificationRequestStatus.PROCESSING, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRequestRepository)
        .findAllByStatus(eq(NotificationRequestStatus.PROCESSING), isA(Pageable.class));
    assertEquals(0L, actualFindAllByStatusResult.getTotalElements());
    assertEquals(1, actualFindAllByStatusResult.getTotalPages());
    assertFalse(actualFindAllByStatusResult.hasNext());
    assertTrue(actualFindAllByStatusResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRequestDao#findAllByStatus(NotificationRequestStatus, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#findAllByStatus(NotificationRequestStatus, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRequestDao.findAllByStatus(NotificationRequestStatus, PageLink)"
  })
  public void testFindAllByStatus_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRequestRepository.findAllByStatus(
            Mockito.<NotificationRequestStatus>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationRequest> actualFindAllByStatusResult =
        jpaNotificationRequestDao.findAllByStatus(
            NotificationRequestStatus.PROCESSING, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRequestRepository)
        .findAllByStatus(eq(NotificationRequestStatus.PROCESSING), isA(Pageable.class));
    assertEquals(0L, actualFindAllByStatusResult.getTotalElements());
    assertEquals(1, actualFindAllByStatusResult.getTotalPages());
    assertFalse(actualFindAllByStatusResult.hasNext());
    assertTrue(actualFindAllByStatusResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRequestDao#findAllByStatus(NotificationRequestStatus, PageLink)}.
   *
   * <ul>
   *   <li>When {@link PageLink#PageLink(int)} with pageSize is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#findAllByStatus(NotificationRequestStatus, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRequestDao.findAllByStatus(NotificationRequestStatus, PageLink)"
  })
  public void testFindAllByStatus_whenPageLinkWithPageSizeIsThree() {
    // Arrange
    when(notificationRequestRepository.findAllByStatus(
            Mockito.<NotificationRequestStatus>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationRequest> actualFindAllByStatusResult =
        jpaNotificationRequestDao.findAllByStatus(
            NotificationRequestStatus.PROCESSING, new PageLink(3));

    // Assert
    verify(notificationRequestRepository)
        .findAllByStatus(eq(NotificationRequestStatus.PROCESSING), isA(Pageable.class));
    assertEquals(0L, actualFindAllByStatusResult.getTotalElements());
    assertEquals(1, actualFindAllByStatusResult.getTotalPages());
    assertFalse(actualFindAllByStatusResult.hasNext());
    assertTrue(actualFindAllByStatusResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRequestDao#updateById(TenantId, NotificationRequestId,
   * NotificationRequestStatus, NotificationRequestStats)}.
   *
   * <p>Method under test: {@link JpaNotificationRequestDao#updateById(TenantId,
   * NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JpaNotificationRequestDao.updateById(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)"
  })
  public void testUpdateById() {
    // Arrange
    doNothing()
        .when(notificationRequestRepository)
        .updateStatusAndStatsById(
            Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(), Mockito.<JsonNode>any());

    NotificationRequestId requestId = mock(NotificationRequestId.class);
    when(requestId.getId()).thenReturn(ModelConstants.NULL_UUID);
    HashMap<NotificationDeliveryMethod, AtomicInteger> sent = new HashMap<>();
    NotificationRequestStats stats =
        new NotificationRequestStats(sent, new HashMap<>(), -1, "An error occurred");

    // Act
    jpaNotificationRequestDao.updateById(
        ModelConstants.SYSTEM_TENANT, requestId, NotificationRequestStatus.PROCESSING, stats);

    // Assert
    verify(requestId).getId();
    verify(notificationRequestRepository)
        .updateStatusAndStatsById(
            isA(UUID.class), eq(NotificationRequestStatus.PROCESSING), isA(JsonNode.class));
  }

  /**
   * Test {@link JpaNotificationRequestDao#updateById(TenantId, NotificationRequestId,
   * NotificationRequestStatus, NotificationRequestStats)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link NotificationRequestStats#NotificationRequestStats()}.
   *   <li>Then calls {@link NotificationRequestId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRequestDao#updateById(TenantId,
   * NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JpaNotificationRequestDao.updateById(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)"
  })
  public void testUpdateById_givenNull_uuid_whenNotificationRequestStats_thenCallsGetId() {
    // Arrange
    doNothing()
        .when(notificationRequestRepository)
        .updateStatusAndStatsById(
            Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(), Mockito.<JsonNode>any());

    NotificationRequestId requestId = mock(NotificationRequestId.class);
    when(requestId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaNotificationRequestDao.updateById(
        ModelConstants.SYSTEM_TENANT,
        requestId,
        NotificationRequestStatus.PROCESSING,
        new NotificationRequestStats());

    // Assert
    verify(requestId).getId();
    verify(notificationRequestRepository)
        .updateStatusAndStatsById(
            isA(UUID.class), eq(NotificationRequestStatus.PROCESSING), isA(JsonNode.class));
  }

  /**
   * Test {@link JpaNotificationRequestDao#updateById(TenantId, NotificationRequestId,
   * NotificationRequestStatus, NotificationRequestStats)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link NotificationRequestId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRequestDao#updateById(TenantId,
   * NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JpaNotificationRequestDao.updateById(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)"
  })
  public void testUpdateById_givenNull_uuid_whenNull_thenCallsGetId() {
    // Arrange
    doNothing()
        .when(notificationRequestRepository)
        .updateStatusAndStatsById(
            Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(), Mockito.<JsonNode>any());

    NotificationRequestId requestId = mock(NotificationRequestId.class);
    when(requestId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaNotificationRequestDao.updateById(
        ModelConstants.SYSTEM_TENANT, requestId, NotificationRequestStatus.PROCESSING, null);

    // Assert
    verify(requestId).getId();
    verify(notificationRequestRepository)
        .updateStatusAndStatsById(
            isA(UUID.class), eq(NotificationRequestStatus.PROCESSING), isA(JsonNode.class));
  }

  /**
   * Test {@link JpaNotificationRequestDao#updateById(TenantId, NotificationRequestId,
   * NotificationRequestStatus, NotificationRequestStats)}.
   *
   * <ul>
   *   <li>Given {@code WEB}.
   *   <li>When {@link HashMap#HashMap()} {@code WEB} is {@link HashMap#HashMap()}.
   *   <li>Then calls {@link NotificationRequestId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRequestDao#updateById(TenantId,
   * NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JpaNotificationRequestDao.updateById(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)"
  })
  public void testUpdateById_givenWeb_whenHashMapWebIsHashMap_thenCallsGetId() {
    // Arrange
    doNothing()
        .when(notificationRequestRepository)
        .updateStatusAndStatsById(
            Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(), Mockito.<JsonNode>any());

    NotificationRequestId requestId = mock(NotificationRequestId.class);
    when(requestId.getId()).thenReturn(ModelConstants.NULL_UUID);

    HashMap<NotificationDeliveryMethod, Map<String, String>> errors = new HashMap<>();
    errors.put(NotificationDeliveryMethod.WEB, new HashMap<>());
    NotificationRequestStats stats =
        new NotificationRequestStats(new HashMap<>(), errors, -1, "An error occurred");

    // Act
    jpaNotificationRequestDao.updateById(
        ModelConstants.SYSTEM_TENANT, requestId, NotificationRequestStatus.PROCESSING, stats);

    // Assert
    verify(requestId).getId();
    verify(notificationRequestRepository)
        .updateStatusAndStatsById(
            isA(UUID.class), eq(NotificationRequestStatus.PROCESSING), isA(JsonNode.class));
  }

  /**
   * Test {@link JpaNotificationRequestDao#updateById(TenantId, NotificationRequestId,
   * NotificationRequestStatus, NotificationRequestStats)}.
   *
   * <ul>
   *   <li>When {@link NotificationRequestId#NotificationRequestId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRequestDao#updateById(TenantId,
   * NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JpaNotificationRequestDao.updateById(TenantId, NotificationRequestId, NotificationRequestStatus, NotificationRequestStats)"
  })
  public void testUpdateById_whenNotificationRequestIdWithIdIsNull_uuid() {
    // Arrange
    doNothing()
        .when(notificationRequestRepository)
        .updateStatusAndStatsById(
            Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(), Mockito.<JsonNode>any());
    NotificationRequestId requestId = new NotificationRequestId(ModelConstants.NULL_UUID);

    // Act
    jpaNotificationRequestDao.updateById(
        ModelConstants.SYSTEM_TENANT,
        requestId,
        NotificationRequestStatus.PROCESSING,
        new NotificationRequestStats());

    // Assert
    verify(notificationRequestRepository)
        .updateStatusAndStatsById(
            isA(UUID.class), eq(NotificationRequestStatus.PROCESSING), isA(JsonNode.class));
  }

  /**
   * Test {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId,
   * NotificationRequestStatus, NotificationTargetId)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationTargetId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId,
   * NotificationRequestStatus, NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationRequestDao.existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)"
  })
  public void testExistsByTenantIdAndStatusAndTargetId_thenCallsGetId() {
    // Arrange
    NotificationRequestRepository notificationRequestRepository =
        mock(NotificationRequestRepository.class);
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTargetsContaining(
            Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(), Mockito.<String>any()))
        .thenReturn(true);
    JpaNotificationRequestDao jpaNotificationRequestDao =
        new JpaNotificationRequestDao(notificationRequestRepository);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    NotificationTargetId targetId = mock(NotificationTargetId.class);
    when(targetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTargetIdResult =
        jpaNotificationRequestDao.existsByTenantIdAndStatusAndTargetId(
            tenantId, NotificationRequestStatus.PROCESSING, targetId);

    // Assert
    verify(targetId).getId();
    verify(tenantId).getId();
    verify(notificationRequestRepository)
        .existsByTenantIdAndStatusAndTargetsContaining(
            isA(UUID.class),
            eq(NotificationRequestStatus.PROCESSING),
            eq("13814000-1dd2-11b2-8080-808080808080"));
    assertTrue(actualExistsByTenantIdAndStatusAndTargetIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId,
   * NotificationRequestStatus, NotificationTargetId)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId,
   * NotificationRequestStatus, NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationRequestDao.existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)"
  })
  public void testExistsByTenantIdAndStatusAndTargetId_thenReturnFalse() {
    // Arrange
    NotificationRequestRepository notificationRequestRepository =
        mock(NotificationRequestRepository.class);
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTargetsContaining(
            Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(), Mockito.<String>any()))
        .thenReturn(false);
    JpaNotificationRequestDao jpaNotificationRequestDao =
        new JpaNotificationRequestDao(notificationRequestRepository);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    NotificationTargetId targetId = mock(NotificationTargetId.class);
    when(targetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTargetIdResult =
        jpaNotificationRequestDao.existsByTenantIdAndStatusAndTargetId(
            tenantId, NotificationRequestStatus.PROCESSING, targetId);

    // Assert
    verify(targetId).getId();
    verify(tenantId).getId();
    verify(notificationRequestRepository)
        .existsByTenantIdAndStatusAndTargetsContaining(
            isA(UUID.class),
            eq(NotificationRequestStatus.PROCESSING),
            eq("13814000-1dd2-11b2-8080-808080808080"));
    assertFalse(actualExistsByTenantIdAndStatusAndTargetIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId,
   * NotificationRequestStatus, NotificationTargetId)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId,
   * NotificationRequestStatus, NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationRequestDao.existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)"
  })
  public void testExistsByTenantIdAndStatusAndTargetId_thenReturnTrue() {
    // Arrange
    NotificationRequestRepository notificationRequestRepository =
        mock(NotificationRequestRepository.class);
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTargetsContaining(
            Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(), Mockito.<String>any()))
        .thenReturn(true);
    JpaNotificationRequestDao jpaNotificationRequestDao =
        new JpaNotificationRequestDao(notificationRequestRepository);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTargetIdResult =
        jpaNotificationRequestDao.existsByTenantIdAndStatusAndTargetId(
            tenantId,
            NotificationRequestStatus.PROCESSING,
            new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantId).getId();
    verify(notificationRequestRepository)
        .existsByTenantIdAndStatusAndTargetsContaining(
            isA(UUID.class),
            eq(NotificationRequestStatus.PROCESSING),
            eq("13814000-1dd2-11b2-8080-808080808080"));
    assertTrue(actualExistsByTenantIdAndStatusAndTargetIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId,
   * NotificationRequestStatus, NotificationTargetId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId,
   * NotificationRequestStatus, NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationRequestDao.existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)"
  })
  public void testExistsByTenantIdAndStatusAndTargetId_whenSystem_tenant_thenReturnTrue() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTargetsContaining(
            Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTargetIdResult =
        jpaNotificationRequestDao.existsByTenantIdAndStatusAndTargetId(
            ModelConstants.SYSTEM_TENANT,
            NotificationRequestStatus.PROCESSING,
            new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestRepository)
        .existsByTenantIdAndStatusAndTargetsContaining(
            isA(UUID.class),
            eq(NotificationRequestStatus.PROCESSING),
            eq("13814000-1dd2-11b2-8080-808080808080"));
    assertTrue(actualExistsByTenantIdAndStatusAndTargetIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId,
   * NotificationRequestStatus, NotificationTemplateId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId,
   * NotificationRequestStatus, NotificationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationRequestDao.existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)"
  })
  public void testExistsByTenantIdAndStatusAndTemplateId_givenNull_uuid_thenReturnTrue() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTemplateId(
            Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(), Mockito.<UUID>any()))
        .thenReturn(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTemplateIdResult =
        jpaNotificationRequestDao.existsByTenantIdAndStatusAndTemplateId(
            tenantId,
            NotificationRequestStatus.PROCESSING,
            new NotificationTemplateId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantId).getId();
    verify(notificationRequestRepository)
        .existsByTenantIdAndStatusAndTemplateId(
            isA(UUID.class), eq(NotificationRequestStatus.PROCESSING), isA(UUID.class));
    assertTrue(actualExistsByTenantIdAndStatusAndTemplateIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId,
   * NotificationRequestStatus, NotificationTemplateId)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationTemplateId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId,
   * NotificationRequestStatus, NotificationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationRequestDao.existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)"
  })
  public void testExistsByTenantIdAndStatusAndTemplateId_thenCallsGetId() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTemplateId(
            Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(), Mockito.<UUID>any()))
        .thenReturn(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    NotificationTemplateId templateId = mock(NotificationTemplateId.class);
    when(templateId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTemplateIdResult =
        jpaNotificationRequestDao.existsByTenantIdAndStatusAndTemplateId(
            tenantId, NotificationRequestStatus.PROCESSING, templateId);

    // Assert
    verify(templateId).getId();
    verify(tenantId).getId();
    verify(notificationRequestRepository)
        .existsByTenantIdAndStatusAndTemplateId(
            isA(UUID.class), eq(NotificationRequestStatus.PROCESSING), isA(UUID.class));
    assertTrue(actualExistsByTenantIdAndStatusAndTemplateIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId,
   * NotificationRequestStatus, NotificationTemplateId)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId,
   * NotificationRequestStatus, NotificationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationRequestDao.existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)"
  })
  public void testExistsByTenantIdAndStatusAndTemplateId_thenReturnFalse() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTemplateId(
            Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(), Mockito.<UUID>any()))
        .thenReturn(false);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    NotificationTemplateId templateId = mock(NotificationTemplateId.class);
    when(templateId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTemplateIdResult =
        jpaNotificationRequestDao.existsByTenantIdAndStatusAndTemplateId(
            tenantId, NotificationRequestStatus.PROCESSING, templateId);

    // Assert
    verify(templateId).getId();
    verify(tenantId).getId();
    verify(notificationRequestRepository)
        .existsByTenantIdAndStatusAndTemplateId(
            isA(UUID.class), eq(NotificationRequestStatus.PROCESSING), isA(UUID.class));
    assertFalse(actualExistsByTenantIdAndStatusAndTemplateIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId,
   * NotificationRequestStatus, NotificationTemplateId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId,
   * NotificationRequestStatus, NotificationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationRequestDao.existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)"
  })
  public void testExistsByTenantIdAndStatusAndTemplateId_whenSystem_tenant_thenReturnTrue() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTemplateId(
            Mockito.<UUID>any(), Mockito.<NotificationRequestStatus>any(), Mockito.<UUID>any()))
        .thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTemplateIdResult =
        jpaNotificationRequestDao.existsByTenantIdAndStatusAndTemplateId(
            ModelConstants.SYSTEM_TENANT,
            NotificationRequestStatus.PROCESSING,
            new NotificationTemplateId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestRepository)
        .existsByTenantIdAndStatusAndTemplateId(
            isA(UUID.class), eq(NotificationRequestStatus.PROCESSING), isA(UUID.class));
    assertTrue(actualExistsByTenantIdAndStatusAndTemplateIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#removeAllByCreatedTimeBefore(long)}.
   *
   * <p>Method under test: {@link JpaNotificationRequestDao#removeAllByCreatedTimeBefore(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JpaNotificationRequestDao.removeAllByCreatedTimeBefore(long)"})
  public void testRemoveAllByCreatedTimeBefore() {
    // Arrange
    when(notificationRequestRepository.deleteAllByCreatedTimeBefore(anyLong())).thenReturn(1);

    // Act
    int actualRemoveAllByCreatedTimeBeforeResult =
        jpaNotificationRequestDao.removeAllByCreatedTimeBefore(1L);

    // Assert
    verify(notificationRequestRepository).deleteAllByCreatedTimeBefore(1L);
    assertEquals(1, actualRemoveAllByCreatedTimeBeforeResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#findInfoById(TenantId, NotificationRequestId)}.
   *
   * <p>Method under test: {@link JpaNotificationRequestDao#findInfoById(TenantId,
   * NotificationRequestId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRequestInfo JpaNotificationRequestDao.findInfoById(TenantId, NotificationRequestId)"
  })
  public void testFindInfoById() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    NotificationRequestRepository notificationRequestRepository =
        mock(NotificationRequestRepository.class);
    when(notificationRequestRepository.findInfoById(Mockito.<UUID>any())).thenReturn(null);
    JpaNotificationRequestDao jpaNotificationRequestDao =
        new JpaNotificationRequestDao(notificationRequestRepository);

    // Act
    NotificationRequestInfo actualFindInfoByIdResult =
        jpaNotificationRequestDao.findInfoById(
            ModelConstants.SYSTEM_TENANT, new NotificationRequestId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRequestRepository).findInfoById(isA(UUID.class));
    assertNull(actualFindInfoByIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#removeByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRequestDao#removeByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaNotificationRequestDao.removeByTenantId(TenantId)"})
  public void testRemoveByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(notificationRequestRepository).deleteByTenantId(Mockito.<UUID>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaNotificationRequestDao.removeByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(notificationRequestRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationRequestDao#removeByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link NotificationRequestRepository#deleteByTenantId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRequestDao#removeByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaNotificationRequestDao.removeByTenantId(TenantId)"})
  public void testRemoveByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(notificationRequestRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaNotificationRequestDao.removeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationRequestRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaNotificationRequestDao#getEntityClass()}
   *   <li>{@link JpaNotificationRequestDao#getEntityType()}
   *   <li>{@link JpaNotificationRequestDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaNotificationRequestDao.getEntityClass()",
    "EntityType JpaNotificationRequestDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaNotificationRequestDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationRequestDao jpaNotificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    // Act
    Class<NotificationRequestEntity> actualEntityClass = jpaNotificationRequestDao.getEntityClass();
    EntityType actualEntityType = jpaNotificationRequestDao.getEntityType();
    jpaNotificationRequestDao.getRepository();

    // Assert
    assertEquals(EntityType.NOTIFICATION_REQUEST, actualEntityType);
    Class<NotificationRequestEntity> expectedEntityClass = NotificationRequestEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
