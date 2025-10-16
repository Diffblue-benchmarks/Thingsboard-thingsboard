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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.MissingNode;
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
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilterType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationTargetEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaNotificationTargetDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaNotificationTargetDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaNotificationTargetDao jpaNotificationTargetDao;

  @MockBean private NotificationTargetRepository notificationTargetRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTargetDao.findByTenantIdAndPageLink(TenantId, PageLink)"
  })
  public void testFindByTenantIdAndPageLink() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(new UUID(1L, 1L));
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndSearchText(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndPageLinkResult =
        jpaNotificationTargetDao.findByTenantIdAndPageLink(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchText(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<NotificationTarget> data = actualFindByTenantIdAndPageLinkResult.getData();
    assertEquals(1, data.size());
    NotificationTarget getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("00000000-0000-0001-0000-000000000001", tenantId2.getId().toString());
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTargetDao.findByTenantIdAndPageLink(TenantId, PageLink)"
  })
  public void testFindByTenantIdAndPageLink_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndSearchText(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndPageLinkResult =
        jpaNotificationTargetDao.findByTenantIdAndPageLink(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchText(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTargetDao.findByTenantIdAndPageLink(TenantId, PageLink)"
  })
  public void testFindByTenantIdAndPageLink_thenReturnDataFirstExternalIdIsNull() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(null);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndSearchText(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndPageLinkResult =
        jpaNotificationTargetDao.findByTenantIdAndPageLink(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchText(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<NotificationTarget> data = actualFindByTenantIdAndPageLinkResult.getData();
    assertEquals(1, data.size());
    NotificationTarget getResult = data.get(0);
    assertNull(getResult.getExternalId());
    NotificationTargetId id = getResult.getId();
    assertEquals(EntityType.NOTIFICATION_TARGET, id.getEntityType());
    assertTrue(id.isNullUid());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTargetDao.findByTenantIdAndPageLink(TenantId, PageLink)"
  })
  public void testFindByTenantIdAndPageLink_thenReturnDataFirstTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    notificationTargetEntity.setTenantId(tenantId);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndSearchText(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndPageLinkResult =
        jpaNotificationTargetDao.findByTenantIdAndPageLink(tenantId2, pageLink);

    // Assert
    verify(tenantId2).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchText(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<NotificationTarget> data = actualFindByTenantIdAndPageLinkResult.getData();
    assertEquals(1, data.size());
    NotificationTarget getResult = data.get(0);
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    TenantId tenantId3 = getResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
    assertSame(tenantId, tenantId3.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTargetDao.findByTenantIdAndPageLink(TenantId, PageLink)"
  })
  public void testFindByTenantIdAndPageLink_thenReturnDataFirstTenantIdIsSys_tenant_id() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndSearchText(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndPageLinkResult =
        jpaNotificationTargetDao.findByTenantIdAndPageLink(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchText(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<NotificationTarget> data = actualFindByTenantIdAndPageLinkResult.getData();
    assertEquals(1, data.size());
    assertSame(TenantId.SYS_TENANT_ID, data.get(0).getTenantId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTargetDao.findByTenantIdAndPageLink(TenantId, PageLink)"
  })
  public void testFindByTenantIdAndPageLink_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndSearchText(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndPageLinkResult =
        jpaNotificationTargetDao.findByTenantIdAndPageLink(
            tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchText(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndPageLink(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTargetDao.findByTenantIdAndPageLink(TenantId, PageLink)"
  })
  public void testFindByTenantIdAndPageLink_whenSystem_tenant_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndSearchText(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndPageLinkResult =
        jpaNotificationTargetDao.findByTenantIdAndPageLink(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchText(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)"
  })
  public void testFindByTenantIdAndSupportedNotificationTypeAndPageLink() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult =
        jpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(
            tenantId, NotificationType.GENERAL, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            isA(UUID.class), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(
        0L, actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getTotalElements());
    assertEquals(
        1, actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.hasNext());
    assertTrue(
        actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)"
  })
  public void testFindByTenantIdAndSupportedNotificationTypeAndPageLink2() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult =
        jpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(
            tenantId, NotificationType.GENERAL, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            isA(UUID.class), eq("Text Search"), isA(List.class), isA(Pageable.class));
    assertEquals(
        0L, actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getTotalElements());
    assertEquals(
        1, actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.hasNext());
    assertTrue(
        actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)"
  })
  public void testFindByTenantIdAndSupportedNotificationTypeAndPageLink3() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(3L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult =
        jpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(
            tenantId, NotificationType.GENERAL, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            isA(UUID.class), eq("Text Search"), isA(List.class), isA(Pageable.class));
    List<NotificationTarget> data =
        actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getData();
    assertEquals(1, data.size());
    assertSame(TenantId.SYS_TENANT_ID, data.get(0).getTenantId());
  }

  /**
   * Test {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)"
  })
  public void testFindByTenantIdAndSupportedNotificationTypeAndPageLink4() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(3L);
    notificationTargetEntity.setExternalId(null);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult =
        jpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(
            tenantId, NotificationType.GENERAL, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            isA(UUID.class), eq("Text Search"), isA(List.class), isA(Pageable.class));
    List<NotificationTarget> data =
        actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getData();
    assertEquals(1, data.size());
    NotificationTarget getResult = data.get(0);
    assertNull(getResult.getExternalId());
    NotificationTargetId id = getResult.getId();
    assertEquals(EntityType.NOTIFICATION_TARGET, id.getEntityType());
    assertTrue(id.isNullUid());
  }

  /**
   * Test {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)"
  })
  public void testFindByTenantIdAndSupportedNotificationTypeAndPageLink5() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(3L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    notificationTargetEntity.setTenantId(tenantId);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult =
        jpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(
            tenantId2, NotificationType.GENERAL, pageLink);

    // Assert
    verify(tenantId2).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            isA(UUID.class), eq("Text Search"), isA(List.class), isA(Pageable.class));
    List<NotificationTarget> data =
        actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getData();
    assertEquals(1, data.size());
    NotificationTarget getResult = data.get(0);
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    TenantId tenantId3 = getResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
    assertSame(tenantId, tenantId3.getId());
  }

  /**
   * Test {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)"
  })
  public void testFindByTenantIdAndSupportedNotificationTypeAndPageLink6() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(3L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(new UUID(3L, 3L));
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult =
        jpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(
            tenantId, NotificationType.GENERAL, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            isA(UUID.class), eq("Text Search"), isA(List.class), isA(Pageable.class));
    List<NotificationTarget> data =
        actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getData();
    assertEquals(1, data.size());
    NotificationTarget getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("00000000-0000-0003-0000-000000000003", tenantId2.getId().toString());
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
  }

  /**
   * Test {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}.
   *
   * <ul>
   *   <li>When {@code ALARM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)"
  })
  public void testFindByTenantIdAndSupportedNotificationTypeAndPageLink_whenAlarm() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult =
        jpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(
            tenantId, NotificationType.ALARM, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            isA(UUID.class), eq("Text Search"), isA(List.class), isA(Pageable.class));
    assertEquals(
        0L, actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getTotalElements());
    assertEquals(
        1, actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.hasNext());
    assertTrue(
        actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId,
   * NotificationType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(TenantId, NotificationType, PageLink)"
  })
  public void testFindByTenantIdAndSupportedNotificationTypeAndPageLink_whenSystem_tenant() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult =
        jpaNotificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT,
            NotificationType.GENERAL,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            isA(UUID.class), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(
        0L, actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getTotalElements());
    assertEquals(
        1, actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.hasNext());
    assertTrue(
        actualFindByTenantIdAndSupportedNotificationTypeAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaNotificationTargetDao.findByTenantIdAndIds(TenantId, List)"})
  public void testFindByTenantIdAndIds() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(null);
    notificationTargetEntity.setCreatedTime(0L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("42");
    notificationTargetEntity.setTenantId(new UUID(2L, 2L));
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> notificationTargetEntityList = new ArrayList<>();
    notificationTargetEntityList.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(notificationTargetEntityList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult =
        jpaNotificationTargetDao.findByTenantIdAndIds(tenantId, new ArrayList<>());

    // Assert
    verify(tenantId).getId();
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindByTenantIdAndIdsResult.size());
    NotificationTarget getResult = actualFindByTenantIdAndIdsResult.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("00000000-0000-0002-0000-000000000002", tenantId2.getId().toString());
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link JdbcTemplate}.
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaNotificationTargetDao.findByTenantIdAndIds(TenantId, List)"})
  public void testFindByTenantIdAndIds_givenJdbcTemplate_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult =
        jpaNotificationTargetDao.findByTenantIdAndIds(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByTenantIdAndIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link NotificationTargetId#NotificationTargetId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaNotificationTargetDao.findByTenantIdAndIds(TenantId, List)"})
  public void testFindByTenantIdAndIds_givenNotificationTargetIdWithIdIsNull_uuid() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<NotificationTargetId> ids = new ArrayList<>();
    ids.add(new NotificationTargetId(ModelConstants.NULL_UUID));

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult =
        jpaNotificationTargetDao.findByTenantIdAndIds(ModelConstants.SYSTEM_TENANT, ids);

    // Assert
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByTenantIdAndIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link NotificationTargetId#NotificationTargetId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaNotificationTargetDao.findByTenantIdAndIds(TenantId, List)"})
  public void testFindByTenantIdAndIds_givenNotificationTargetIdWithIdIsNull_uuid2() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<NotificationTargetId> ids = new ArrayList<>();
    ids.add(new NotificationTargetId(ModelConstants.NULL_UUID));
    ids.add(new NotificationTargetId(ModelConstants.NULL_UUID));

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult =
        jpaNotificationTargetDao.findByTenantIdAndIds(ModelConstants.SYSTEM_TENANT, ids);

    // Assert
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByTenantIdAndIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaNotificationTargetDao.findByTenantIdAndIds(TenantId, List)"})
  public void testFindByTenantIdAndIds_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult =
        jpaNotificationTargetDao.findByTenantIdAndIds(tenantId, new ArrayList<>());

    // Assert
    verify(tenantId).getId();
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByTenantIdAndIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaNotificationTargetDao.findByTenantIdAndIds(TenantId, List)"})
  public void testFindByTenantIdAndIds_givenNull_whenArrayListAddNull_thenReturnEmpty() {
    // Arrange
    NotificationTargetRepository notificationTargetRepository =
        mock(NotificationTargetRepository.class);
    when(notificationTargetRepository.findByTenantIdAndIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());
    JpaNotificationTargetDao jpaNotificationTargetDao =
        new JpaNotificationTargetDao(notificationTargetRepository);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetId> ids = new ArrayList<>();
    ids.add(null);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult =
        jpaNotificationTargetDao.findByTenantIdAndIds(tenantId, ids);

    // Assert
    verify(tenantId).getId();
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByTenantIdAndIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationTargetId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaNotificationTargetDao.findByTenantIdAndIds(TenantId, List)"})
  public void testFindByTenantIdAndIds_thenCallsGetId() {
    // Arrange
    NotificationTargetRepository notificationTargetRepository =
        mock(NotificationTargetRepository.class);
    when(notificationTargetRepository.findByTenantIdAndIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());
    JpaNotificationTargetDao jpaNotificationTargetDao =
        new JpaNotificationTargetDao(notificationTargetRepository);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    NotificationTargetId notificationTargetId = mock(NotificationTargetId.class);
    when(notificationTargetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetId> ids = new ArrayList<>();
    ids.add(notificationTargetId);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult =
        jpaNotificationTargetDao.findByTenantIdAndIds(tenantId, ids);

    // Assert
    verify(notificationTargetId).getId();
    verify(tenantId).getId();
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByTenantIdAndIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Then return first ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaNotificationTargetDao.findByTenantIdAndIds(TenantId, List)"})
  public void testFindByTenantIdAndIds_thenReturnFirstExternalIdIsNull() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(null);
    notificationTargetEntity.setCreatedTime(0L);
    notificationTargetEntity.setExternalId(null);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("42");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> notificationTargetEntityList = new ArrayList<>();
    notificationTargetEntityList.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(notificationTargetEntityList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult =
        jpaNotificationTargetDao.findByTenantIdAndIds(tenantId, new ArrayList<>());

    // Assert
    verify(tenantId).getId();
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindByTenantIdAndIdsResult.size());
    NotificationTarget getResult = actualFindByTenantIdAndIdsResult.get(0);
    assertNull(getResult.getExternalId());
    NotificationTargetId id = getResult.getId();
    assertEquals(EntityType.NOTIFICATION_TARGET, id.getEntityType());
    assertTrue(id.isNullUid());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Then return first TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaNotificationTargetDao.findByTenantIdAndIds(TenantId, List)"})
  public void testFindByTenantIdAndIds_thenReturnFirstTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(null);
    notificationTargetEntity.setCreatedTime(0L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("42");
    UUID tenantId = UUID.randomUUID();
    notificationTargetEntity.setTenantId(tenantId);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> notificationTargetEntityList = new ArrayList<>();
    notificationTargetEntityList.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(notificationTargetEntityList);

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult =
        jpaNotificationTargetDao.findByTenantIdAndIds(tenantId2, new ArrayList<>());

    // Assert
    verify(tenantId2).getId();
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindByTenantIdAndIdsResult.size());
    NotificationTarget getResult = actualFindByTenantIdAndIdsResult.get(0);
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    TenantId tenantId3 = getResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
    assertSame(tenantId, tenantId3.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Then return first TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaNotificationTargetDao.findByTenantIdAndIds(TenantId, List)"})
  public void testFindByTenantIdAndIds_thenReturnFirstTenantIdIsSys_tenant_id() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(null);
    notificationTargetEntity.setCreatedTime(0L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("42");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> notificationTargetEntityList = new ArrayList<>();
    notificationTargetEntityList.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(notificationTargetEntityList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndIdsResult =
        jpaNotificationTargetDao.findByTenantIdAndIds(tenantId, new ArrayList<>());

    // Assert
    verify(tenantId).getId();
    verify(notificationTargetRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindByTenantIdAndIdsResult.size());
    assertSame(TenantId.SYS_TENANT_ID, actualFindByTenantIdAndIdsResult.get(0).getTenantId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId,
   * UsersFilterType)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationTargetDao.findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)"
  })
  public void testFindByTenantIdAndUsersFilterType() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(2147483647L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(new UUID(2147483647L, 2147483647L));
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndUsersFilterTypeResult =
        jpaNotificationTargetDao.findByTenantIdAndUsersFilterType(
            tenantId, UsersFilterType.USER_LIST);

    // Assert
    verify(tenantId).getId();
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            isA(UUID.class), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(1, actualFindByTenantIdAndUsersFilterTypeResult.size());
    NotificationTarget getResult = actualFindByTenantIdAndUsersFilterTypeResult.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("00000000-7fff-ffff-0000-00007fffffff", tenantId2.getId().toString());
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId,
   * UsersFilterType)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationTargetDao.findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)"
  })
  public void testFindByTenantIdAndUsersFilterType_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndUsersFilterTypeResult =
        jpaNotificationTargetDao.findByTenantIdAndUsersFilterType(
            tenantId, UsersFilterType.USER_LIST);

    // Assert
    verify(tenantId).getId();
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            isA(UUID.class), isNull(), isA(List.class), isA(Pageable.class));
    assertTrue(actualFindByTenantIdAndUsersFilterTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId,
   * UsersFilterType)}.
   *
   * <ul>
   *   <li>Then return first ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationTargetDao.findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)"
  })
  public void testFindByTenantIdAndUsersFilterType_thenReturnFirstExternalIdIsNull() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(2147483647L);
    notificationTargetEntity.setExternalId(null);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndUsersFilterTypeResult =
        jpaNotificationTargetDao.findByTenantIdAndUsersFilterType(
            tenantId, UsersFilterType.USER_LIST);

    // Assert
    verify(tenantId).getId();
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            isA(UUID.class), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(1, actualFindByTenantIdAndUsersFilterTypeResult.size());
    NotificationTarget getResult = actualFindByTenantIdAndUsersFilterTypeResult.get(0);
    assertNull(getResult.getExternalId());
    NotificationTargetId id = getResult.getId();
    assertEquals(EntityType.NOTIFICATION_TARGET, id.getEntityType());
    assertTrue(id.isNullUid());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId,
   * UsersFilterType)}.
   *
   * <ul>
   *   <li>Then return first TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationTargetDao.findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)"
  })
  public void testFindByTenantIdAndUsersFilterType_thenReturnFirstTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(2147483647L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    notificationTargetEntity.setTenantId(tenantId);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndUsersFilterTypeResult =
        jpaNotificationTargetDao.findByTenantIdAndUsersFilterType(
            tenantId2, UsersFilterType.USER_LIST);

    // Assert
    verify(tenantId2).getId();
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            isA(UUID.class), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(1, actualFindByTenantIdAndUsersFilterTypeResult.size());
    NotificationTarget getResult = actualFindByTenantIdAndUsersFilterTypeResult.get(0);
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    TenantId tenantId3 = getResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
    assertSame(tenantId, tenantId3.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId,
   * UsersFilterType)}.
   *
   * <ul>
   *   <li>Then return first TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationTargetDao.findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)"
  })
  public void testFindByTenantIdAndUsersFilterType_thenReturnFirstTenantIdIsSys_tenant_id() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(2147483647L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationTarget> actualFindByTenantIdAndUsersFilterTypeResult =
        jpaNotificationTargetDao.findByTenantIdAndUsersFilterType(
            tenantId, UsersFilterType.USER_LIST);

    // Assert
    verify(tenantId).getId();
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            isA(UUID.class), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(1, actualFindByTenantIdAndUsersFilterTypeResult.size());
    assertSame(
        TenantId.SYS_TENANT_ID, actualFindByTenantIdAndUsersFilterTypeResult.get(0).getTenantId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId,
   * UsersFilterType)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationTargetDao.findByTenantIdAndUsersFilterType(TenantId, UsersFilterType)"
  })
  public void testFindByTenantIdAndUsersFilterType_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    List<NotificationTarget> actualFindByTenantIdAndUsersFilterTypeResult =
        jpaNotificationTargetDao.findByTenantIdAndUsersFilterType(
            ModelConstants.SYSTEM_TENANT, UsersFilterType.USER_LIST);

    // Assert
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            isA(UUID.class), isNull(), isA(List.class), isA(Pageable.class));
    assertTrue(actualFindByTenantIdAndUsersFilterTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#removeByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#removeByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaNotificationTargetDao.removeByTenantId(TenantId)"})
  public void testRemoveByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(notificationTargetRepository).deleteByTenantId(Mockito.<UUID>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaNotificationTargetDao.removeByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(notificationTargetRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationTargetDao#removeByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link NotificationTargetRepository#deleteByTenantId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#removeByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaNotificationTargetDao.removeByTenantId(TenantId)"})
  public void testRemoveByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(notificationTargetRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaNotificationTargetDao.removeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTargetRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationTargetDao#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaNotificationTargetDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(notificationTargetRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Long actualCountByTenantIdResult = jpaNotificationTargetDao.countByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(notificationTargetRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaNotificationTargetDao#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long JpaNotificationTargetDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(notificationTargetRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult =
        jpaNotificationTargetDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTargetRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget JpaNotificationTargetDao.findByTenantIdAndExternalId(UUID, UUID)"
  })
  public void testFindByTenantIdAndExternalId() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTargetRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTargetEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    NotificationTarget actualFindByTenantIdAndExternalIdResult =
        jpaNotificationTargetDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(notificationTargetRepository)
        .findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    TenantId tenantId = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    NotificationTargetId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId2.getEntityType());
    assertTrue(externalId2.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertSame(externalId, externalId2.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget JpaNotificationTargetDao.findByTenantIdAndExternalId(UUID, UUID)"
  })
  public void testFindByTenantIdAndExternalId2() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(new UUID(2L, 2L));
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTargetRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTargetEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    NotificationTarget actualFindByTenantIdAndExternalIdResult =
        jpaNotificationTargetDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(notificationTargetRepository)
        .findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    TenantId tenantId = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertEquals("00000000-0000-0002-0000-000000000002", tenantId.getId().toString());
    NotificationTargetId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId2.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertTrue(externalId2.isNullUid());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertSame(externalId, externalId2.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget JpaNotificationTargetDao.findByTenantIdAndExternalId(UUID, UUID)"
  })
  public void testFindByTenantIdAndExternalId_thenReturnExternalIdIsNull() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(null);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTargetRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTargetEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    NotificationTarget actualFindByTenantIdAndExternalIdResult =
        jpaNotificationTargetDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(notificationTargetRepository)
        .findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertNull(actualFindByTenantIdAndExternalIdResult.getExternalId());
    NotificationTargetId id = actualFindByTenantIdAndExternalIdResult.getId();
    assertEquals(EntityType.NOTIFICATION_TARGET, id.getEntityType());
    assertTrue(id.isNullUid());
    assertSame(externalId, id.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget JpaNotificationTargetDao.findByTenantIdAndExternalId(UUID, UUID)"
  })
  public void testFindByTenantIdAndExternalId_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    notificationTargetEntity.setTenantId(tenantId);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTargetRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTargetEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    NotificationTarget actualFindByTenantIdAndExternalIdResult =
        jpaNotificationTargetDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(notificationTargetRepository)
        .findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    NotificationTargetId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId2.getEntityType());
    TenantId tenantId2 = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId2.isNullUid());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertSame(tenantId, tenantId2.getId());
    assertSame(externalId, externalId2.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndName(UUID, String)}.
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget JpaNotificationTargetDao.findByTenantIdAndName(UUID, String)"
  })
  public void testFindByTenantIdAndName() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTargetRepository.findByTenantIdAndName(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(notificationTargetEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    NotificationTarget actualFindByTenantIdAndNameResult =
        jpaNotificationTargetDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(notificationTargetRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    TenantId tenantId2 = actualFindByTenantIdAndNameResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    NotificationTargetId externalId = actualFindByTenantIdAndNameResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertEquals(externalId, actualFindByTenantIdAndNameResult.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndName(UUID, String)}.
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget JpaNotificationTargetDao.findByTenantIdAndName(UUID, String)"
  })
  public void testFindByTenantIdAndName2() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(new UUID(2L, 2L));
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTargetRepository.findByTenantIdAndName(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(notificationTargetEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    NotificationTarget actualFindByTenantIdAndNameResult =
        jpaNotificationTargetDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(notificationTargetRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    TenantId tenantId2 = actualFindByTenantIdAndNameResult.getTenantId();
    assertEquals("00000000-0000-0002-0000-000000000002", tenantId2.getId().toString());
    NotificationTargetId externalId = actualFindByTenantIdAndNameResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualFindByTenantIdAndNameResult.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Then return ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget JpaNotificationTargetDao.findByTenantIdAndName(UUID, String)"
  })
  public void testFindByTenantIdAndName_thenReturnExternalIdIsNull() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(null);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTargetRepository.findByTenantIdAndName(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(notificationTargetEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    NotificationTarget actualFindByTenantIdAndNameResult =
        jpaNotificationTargetDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(notificationTargetRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertNull(actualFindByTenantIdAndNameResult.getExternalId());
    NotificationTargetId id = actualFindByTenantIdAndNameResult.getId();
    assertEquals(EntityType.NOTIFICATION_TARGET, id.getEntityType());
    assertTrue(id.isNullUid());
    assertSame(tenantId, id.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget JpaNotificationTargetDao.findByTenantIdAndName(UUID, String)"
  })
  public void testFindByTenantIdAndName_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    notificationTargetEntity.setTenantId(tenantId);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTargetRepository.findByTenantIdAndName(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(notificationTargetEntity);
    UUID tenantId2 = ModelConstants.NULL_UUID;

    // Act
    NotificationTarget actualFindByTenantIdAndNameResult =
        jpaNotificationTargetDao.findByTenantIdAndName(tenantId2, "Name");

    // Assert
    verify(notificationTargetRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    NotificationTargetId externalId = actualFindByTenantIdAndNameResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    TenantId tenantId3 = actualFindByTenantIdAndNameResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualFindByTenantIdAndNameResult.getId());
    assertSame(tenantId, tenantId3.getId());
    assertSame(tenantId2, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaNotificationTargetDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdResult =
        jpaNotificationTargetDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<NotificationTarget> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    NotificationTarget getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertEquals(externalId, getResult.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaNotificationTargetDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId2() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(new UUID(1L, 1L));
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdResult =
        jpaNotificationTargetDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<NotificationTarget> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    NotificationTarget getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("00000000-0000-0001-0000-000000000001", tenantId2.getId().toString());
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaNotificationTargetDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationTargetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdResult =
        jpaNotificationTargetDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaNotificationTargetDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_thenReturnDataFirstExternalIdIsNull() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(null);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdResult =
        jpaNotificationTargetDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<NotificationTarget> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    NotificationTarget getResult = data.get(0);
    assertNull(getResult.getExternalId());
    NotificationTargetId id = getResult.getId();
    assertEquals(EntityType.NOTIFICATION_TARGET, id.getEntityType());
    assertTrue(id.isNullUid());
    assertSame(tenantId, id.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaNotificationTargetDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_thenReturnDataFirstTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    notificationTargetEntity.setTenantId(tenantId);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTargetEntity> content = new ArrayList<>();
    content.add(notificationTargetEntity);
    when(notificationTargetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    UUID tenantId2 = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTarget> actualFindByTenantIdResult =
        jpaNotificationTargetDao.findByTenantId(tenantId2, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTargetRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<NotificationTarget> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    NotificationTarget getResult = data.get(0);
    NotificationTargetId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    TenantId tenantId3 = getResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
    assertSame(tenantId, tenantId3.getId());
    assertSame(tenantId2, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTargetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaNotificationTargetDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationTargetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationTarget> actualFindByTenantIdResult =
        jpaNotificationTargetDao.findByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTargetRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationTargetDao#getExternalIdByInternal(NotificationTargetId)} with {@code
   * NotificationTargetId}.
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#getExternalIdByInternal(NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTargetId JpaNotificationTargetDao.getExternalIdByInternal(NotificationTargetId)"
  })
  public void testGetExternalIdByInternalWithNotificationTargetId() {
    // Arrange
    when(notificationTargetRepository.getExternalIdByInternal(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    NotificationTargetId internalId = new NotificationTargetId(ModelConstants.NULL_UUID);

    // Act
    NotificationTargetId actualExternalIdByInternal =
        jpaNotificationTargetDao.getExternalIdByInternal(internalId);

    // Assert
    verify(notificationTargetRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaNotificationTargetDao#getExternalIdByInternal(NotificationTargetId)} with {@code
   * NotificationTargetId}.
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#getExternalIdByInternal(NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTargetId JpaNotificationTargetDao.getExternalIdByInternal(NotificationTargetId)"
  })
  public void testGetExternalIdByInternalWithNotificationTargetId2() {
    // Arrange
    when(notificationTargetRepository.getExternalIdByInternal(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);

    NotificationTargetId internalId = mock(NotificationTargetId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    NotificationTargetId actualExternalIdByInternal =
        jpaNotificationTargetDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(notificationTargetRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TARGET, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaNotificationTargetDao#getExternalIdByInternal(NotificationTargetId)} with {@code
   * NotificationTargetId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTargetDao#getExternalIdByInternal(NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTargetId JpaNotificationTargetDao.getExternalIdByInternal(NotificationTargetId)"
  })
  public void testGetExternalIdByInternalWithNotificationTargetId_thenReturnNull() {
    // Arrange
    when(notificationTargetRepository.getExternalIdByInternal(Mockito.<UUID>any()))
        .thenReturn(null);

    NotificationTargetId internalId = mock(NotificationTargetId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    NotificationTargetId actualExternalIdByInternal =
        jpaNotificationTargetDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(notificationTargetRepository).getExternalIdByInternal(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaNotificationTargetDao#getEntityClass()}
   *   <li>{@link JpaNotificationTargetDao#getEntityType()}
   *   <li>{@link JpaNotificationTargetDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaNotificationTargetDao.getEntityClass()",
    "EntityType JpaNotificationTargetDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaNotificationTargetDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationTargetDao jpaNotificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));

    // Act
    Class<NotificationTargetEntity> actualEntityClass = jpaNotificationTargetDao.getEntityClass();
    EntityType actualEntityType = jpaNotificationTargetDao.getEntityType();
    jpaNotificationTargetDao.getRepository();

    // Assert
    assertEquals(EntityType.NOTIFICATION_TARGET, actualEntityType);
    Class<NotificationTargetEntity> expectedEntityClass = NotificationTargetEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
