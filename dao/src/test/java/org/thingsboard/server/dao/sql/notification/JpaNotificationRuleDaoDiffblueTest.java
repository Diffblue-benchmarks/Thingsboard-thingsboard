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
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.NotificationRuleInfo;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationRuleEntity;
import org.thingsboard.server.dao.model.sql.NotificationRuleInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaNotificationRuleDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaNotificationRuleDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaNotificationRuleDao jpaNotificationRuleDao;

  @MockBean private NotificationRuleRepository notificationRuleRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findByTenantIdAndPageLink(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRuleDao.findByTenantIdAndPageLink(TenantId, PageLink)"
  })
  public void testFindByTenantIdAndPageLink_givenOne_thenCallsGetPage() {
    // Arrange
    when(notificationRuleRepository.findByTenantIdAndSearchText(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
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
    PageData<NotificationRule> actualFindByTenantIdAndPageLinkResult =
        jpaNotificationRuleDao.findByTenantIdAndPageLink(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRuleRepository)
        .findByTenantIdAndSearchText(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findByTenantIdAndPageLink(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRuleDao.findByTenantIdAndPageLink(TenantId, PageLink)"
  })
  public void testFindByTenantIdAndPageLink_thenReturnDataSizeIsOne() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(MissingNode.getInstance());
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationRuleEntity> content = new ArrayList<>();
    content.add(notificationRuleEntity);

    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.findByTenantIdAndSearchText(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    JpaNotificationRuleDao jpaNotificationRuleDao =
        new JpaNotificationRuleDao(notificationRuleRepository);

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
    PageData<NotificationRule> actualFindByTenantIdAndPageLinkResult =
        jpaNotificationRuleDao.findByTenantIdAndPageLink(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRuleRepository)
        .findByTenantIdAndSearchText(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<NotificationRule> data = actualFindByTenantIdAndPageLinkResult.getData();
    assertEquals(1, data.size());
    assertSame(TenantId.SYS_TENANT_ID, data.get(0).getTenantId());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findByTenantIdAndPageLink(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRuleDao.findByTenantIdAndPageLink(TenantId, PageLink)"
  })
  public void testFindByTenantIdAndPageLink_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRuleRepository.findByTenantIdAndSearchText(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<NotificationRule> actualFindByTenantIdAndPageLinkResult =
        jpaNotificationRuleDao.findByTenantIdAndPageLink(
            tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(notificationRuleRepository)
        .findByTenantIdAndSearchText(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndPageLink(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findByTenantIdAndPageLink(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRuleDao.findByTenantIdAndPageLink(TenantId, PageLink)"
  })
  public void testFindByTenantIdAndPageLink_whenSystem_tenant_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRuleRepository.findByTenantIdAndSearchText(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationRule> actualFindByTenantIdAndPageLinkResult =
        jpaNotificationRuleDao.findByTenantIdAndPageLink(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRuleRepository)
        .findByTenantIdAndSearchText(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findInfosByTenantIdAndPageLink(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findInfosByTenantIdAndPageLink(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRuleDao.findInfosByTenantIdAndPageLink(TenantId, PageLink)"
  })
  public void testFindInfosByTenantIdAndPageLink_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(notificationRuleRepository.findInfosByTenantIdAndSearchText(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<NotificationRuleInfo> actualFindInfosByTenantIdAndPageLinkResult =
        jpaNotificationRuleDao.findInfosByTenantIdAndPageLink(
            tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(notificationRuleRepository)
        .findInfosByTenantIdAndSearchText(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindInfosByTenantIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindInfosByTenantIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindInfosByTenantIdAndPageLinkResult.hasNext());
    assertTrue(actualFindInfosByTenantIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findInfosByTenantIdAndPageLink(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findInfosByTenantIdAndPageLink(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRuleDao.findInfosByTenantIdAndPageLink(TenantId, PageLink)"
  })
  public void testFindInfosByTenantIdAndPageLink_givenOne_thenCallsGetPage() {
    // Arrange
    when(notificationRuleRepository.findInfosByTenantIdAndSearchText(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
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
    PageData<NotificationRuleInfo> actualFindInfosByTenantIdAndPageLinkResult =
        jpaNotificationRuleDao.findInfosByTenantIdAndPageLink(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRuleRepository)
        .findInfosByTenantIdAndSearchText(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindInfosByTenantIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindInfosByTenantIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindInfosByTenantIdAndPageLinkResult.hasNext());
    assertTrue(actualFindInfosByTenantIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findInfosByTenantIdAndPageLink(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findInfosByTenantIdAndPageLink(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationRuleDao.findInfosByTenantIdAndPageLink(TenantId, PageLink)"
  })
  public void testFindInfosByTenantIdAndPageLink_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRuleRepository.findInfosByTenantIdAndSearchText(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationRuleInfo> actualFindInfosByTenantIdAndPageLinkResult =
        jpaNotificationRuleDao.findInfosByTenantIdAndPageLink(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRuleRepository)
        .findInfosByTenantIdAndSearchText(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindInfosByTenantIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindInfosByTenantIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindInfosByTenantIdAndPageLinkResult.hasNext());
    assertTrue(actualFindInfosByTenantIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId,
   * NotificationTargetId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId,
   * NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationRuleDao.existsByTenantIdAndTargetId(TenantId, NotificationTargetId)"
  })
  public void testExistsByTenantIdAndTargetId_givenNull_uuid_thenReturnTrue() {
    // Arrange
    when(notificationRuleRepository.existsByTenantIdAndRecipientsConfigContaining(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndTargetIdResult =
        jpaNotificationRuleDao.existsByTenantIdAndTargetId(
            tenantId, new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantId).getId();
    verify(notificationRuleRepository)
        .existsByTenantIdAndRecipientsConfigContaining(
            isA(UUID.class), eq("13814000-1dd2-11b2-8080-808080808080"));
    assertTrue(actualExistsByTenantIdAndTargetIdResult);
  }

  /**
   * Test {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId,
   * NotificationTargetId)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationTargetId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId,
   * NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationRuleDao.existsByTenantIdAndTargetId(TenantId, NotificationTargetId)"
  })
  public void testExistsByTenantIdAndTargetId_thenCallsGetId() {
    // Arrange
    when(notificationRuleRepository.existsByTenantIdAndRecipientsConfigContaining(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    NotificationTargetId targetId = mock(NotificationTargetId.class);
    when(targetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndTargetIdResult =
        jpaNotificationRuleDao.existsByTenantIdAndTargetId(tenantId, targetId);

    // Assert
    verify(targetId).getId();
    verify(tenantId).getId();
    verify(notificationRuleRepository)
        .existsByTenantIdAndRecipientsConfigContaining(
            isA(UUID.class), eq("13814000-1dd2-11b2-8080-808080808080"));
    assertTrue(actualExistsByTenantIdAndTargetIdResult);
  }

  /**
   * Test {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId,
   * NotificationTargetId)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId,
   * NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationRuleDao.existsByTenantIdAndTargetId(TenantId, NotificationTargetId)"
  })
  public void testExistsByTenantIdAndTargetId_thenReturnFalse() {
    // Arrange
    when(notificationRuleRepository.existsByTenantIdAndRecipientsConfigContaining(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(false);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    NotificationTargetId targetId = mock(NotificationTargetId.class);
    when(targetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualExistsByTenantIdAndTargetIdResult =
        jpaNotificationRuleDao.existsByTenantIdAndTargetId(tenantId, targetId);

    // Assert
    verify(targetId).getId();
    verify(tenantId).getId();
    verify(notificationRuleRepository)
        .existsByTenantIdAndRecipientsConfigContaining(
            isA(UUID.class), eq("13814000-1dd2-11b2-8080-808080808080"));
    assertFalse(actualExistsByTenantIdAndTargetIdResult);
  }

  /**
   * Test {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId,
   * NotificationTargetId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId,
   * NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationRuleDao.existsByTenantIdAndTargetId(TenantId, NotificationTargetId)"
  })
  public void testExistsByTenantIdAndTargetId_whenSystem_tenant_thenReturnTrue() {
    // Arrange
    when(notificationRuleRepository.existsByTenantIdAndRecipientsConfigContaining(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndTargetIdResult =
        jpaNotificationRuleDao.existsByTenantIdAndTargetId(
            ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRuleRepository)
        .existsByTenantIdAndRecipientsConfigContaining(
            isA(UUID.class), eq("13814000-1dd2-11b2-8080-808080808080"));
    assertTrue(actualExistsByTenantIdAndTargetIdResult);
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId,
   * NotificationRuleTriggerType, boolean)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId,
   * NotificationRuleTriggerType, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationRuleDao.findByTenantIdAndTriggerTypeAndEnabled(TenantId, NotificationRuleTriggerType, boolean)"
  })
  public void testFindByTenantIdAndTriggerTypeAndEnabled() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRuleEntity.setCreatedTime(2L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("42");
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());
    notificationRuleEntity.setTemplateId(null);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(MissingNode.getInstance());
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ALARM_COMMENT);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationRuleEntity> notificationRuleEntityList = new ArrayList<>();
    notificationRuleEntityList.add(notificationRuleEntity);

    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.findAllByTenantIdAndTriggerTypeAndEnabled(
            Mockito.<UUID>any(), Mockito.<NotificationRuleTriggerType>any(), anyBoolean()))
        .thenReturn(notificationRuleEntityList);
    JpaNotificationRuleDao jpaNotificationRuleDao =
        new JpaNotificationRuleDao(notificationRuleRepository);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationRule> actualFindByTenantIdAndTriggerTypeAndEnabledResult =
        jpaNotificationRuleDao.findByTenantIdAndTriggerTypeAndEnabled(
            tenantId, NotificationRuleTriggerType.ENTITY_ACTION, true);

    // Assert
    verify(tenantId).getId();
    verify(notificationRuleRepository)
        .findAllByTenantIdAndTriggerTypeAndEnabled(
            isA(UUID.class), eq(NotificationRuleTriggerType.ENTITY_ACTION), eq(true));
    assertEquals(1, actualFindByTenantIdAndTriggerTypeAndEnabledResult.size());
    assertSame(
        TenantId.SYS_TENANT_ID,
        actualFindByTenantIdAndTriggerTypeAndEnabledResult.get(0).getTenantId());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId,
   * NotificationRuleTriggerType, boolean)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId,
   * NotificationRuleTriggerType, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationRuleDao.findByTenantIdAndTriggerTypeAndEnabled(TenantId, NotificationRuleTriggerType, boolean)"
  })
  public void testFindByTenantIdAndTriggerTypeAndEnabled2() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRuleEntity.setCreatedTime(2L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("42");
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());
    notificationRuleEntity.setTemplateId(null);
    notificationRuleEntity.setTenantId(UUID.randomUUID());
    notificationRuleEntity.setTriggerConfig(MissingNode.getInstance());
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ALARM_COMMENT);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationRuleEntity> notificationRuleEntityList = new ArrayList<>();
    notificationRuleEntityList.add(notificationRuleEntity);

    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.findAllByTenantIdAndTriggerTypeAndEnabled(
            Mockito.<UUID>any(), Mockito.<NotificationRuleTriggerType>any(), anyBoolean()))
        .thenReturn(notificationRuleEntityList);
    JpaNotificationRuleDao jpaNotificationRuleDao =
        new JpaNotificationRuleDao(notificationRuleRepository);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationRule> actualFindByTenantIdAndTriggerTypeAndEnabledResult =
        jpaNotificationRuleDao.findByTenantIdAndTriggerTypeAndEnabled(
            tenantId, NotificationRuleTriggerType.ENTITY_ACTION, true);

    // Assert
    verify(tenantId).getId();
    verify(notificationRuleRepository)
        .findAllByTenantIdAndTriggerTypeAndEnabled(
            isA(UUID.class), eq(NotificationRuleTriggerType.ENTITY_ACTION), eq(true));
    assertEquals(1, actualFindByTenantIdAndTriggerTypeAndEnabledResult.size());
    NotificationRule getResult = actualFindByTenantIdAndTriggerTypeAndEnabledResult.get(0);
    assertEquals("42", getResult.getName());
    assertNull(getResult.getTemplateId());
    assertNull(getResult.getAdditionalConfig());
    assertNull(getResult.getRecipientsConfig());
    assertNull(getResult.getTriggerConfig());
    assertEquals(2L, getResult.getCreatedTime());
    assertEquals(NotificationRuleTriggerType.ALARM_COMMENT, getResult.getTriggerType());
    assertTrue(getResult.isEnabled());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId,
   * NotificationRuleTriggerType, boolean)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId,
   * NotificationRuleTriggerType, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationRuleDao.findByTenantIdAndTriggerTypeAndEnabled(TenantId, NotificationRuleTriggerType, boolean)"
  })
  public void testFindByTenantIdAndTriggerTypeAndEnabled3() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRuleEntity.setCreatedTime(2L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("42");
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());
    notificationRuleEntity.setTemplateId(null);
    notificationRuleEntity.setTenantId(new UUID(3L, 3L));
    notificationRuleEntity.setTriggerConfig(MissingNode.getInstance());
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ALARM_COMMENT);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationRuleEntity> notificationRuleEntityList = new ArrayList<>();
    notificationRuleEntityList.add(notificationRuleEntity);

    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.findAllByTenantIdAndTriggerTypeAndEnabled(
            Mockito.<UUID>any(), Mockito.<NotificationRuleTriggerType>any(), anyBoolean()))
        .thenReturn(notificationRuleEntityList);
    JpaNotificationRuleDao jpaNotificationRuleDao =
        new JpaNotificationRuleDao(notificationRuleRepository);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationRule> actualFindByTenantIdAndTriggerTypeAndEnabledResult =
        jpaNotificationRuleDao.findByTenantIdAndTriggerTypeAndEnabled(
            tenantId, NotificationRuleTriggerType.ENTITY_ACTION, true);

    // Assert
    verify(tenantId).getId();
    verify(notificationRuleRepository)
        .findAllByTenantIdAndTriggerTypeAndEnabled(
            isA(UUID.class), eq(NotificationRuleTriggerType.ENTITY_ACTION), eq(true));
    assertEquals(1, actualFindByTenantIdAndTriggerTypeAndEnabledResult.size());
    NotificationRule getResult = actualFindByTenantIdAndTriggerTypeAndEnabledResult.get(0);
    assertEquals("42", getResult.getName());
    assertNull(getResult.getTemplateId());
    assertNull(getResult.getAdditionalConfig());
    assertNull(getResult.getRecipientsConfig());
    assertNull(getResult.getTriggerConfig());
    assertEquals(2L, getResult.getCreatedTime());
    assertEquals(NotificationRuleTriggerType.ALARM_COMMENT, getResult.getTriggerType());
    assertTrue(getResult.isEnabled());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId,
   * NotificationRuleTriggerType, boolean)}.
   *
   * <ul>
   *   <li>Given {@link JdbcTemplate}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId,
   * NotificationRuleTriggerType, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationRuleDao.findByTenantIdAndTriggerTypeAndEnabled(TenantId, NotificationRuleTriggerType, boolean)"
  })
  public void testFindByTenantIdAndTriggerTypeAndEnabled_givenJdbcTemplate_thenReturnEmpty() {
    // Arrange
    when(notificationRuleRepository.findAllByTenantIdAndTriggerTypeAndEnabled(
            Mockito.<UUID>any(), Mockito.<NotificationRuleTriggerType>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<NotificationRule> actualFindByTenantIdAndTriggerTypeAndEnabledResult =
        jpaNotificationRuleDao.findByTenantIdAndTriggerTypeAndEnabled(
            tenantId, NotificationRuleTriggerType.ENTITY_ACTION, true);

    // Assert
    verify(tenantId).getId();
    verify(notificationRuleRepository)
        .findAllByTenantIdAndTriggerTypeAndEnabled(
            isA(UUID.class), eq(NotificationRuleTriggerType.ENTITY_ACTION), eq(true));
    assertTrue(actualFindByTenantIdAndTriggerTypeAndEnabledResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId,
   * NotificationRuleTriggerType, boolean)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRuleDao#findByTenantIdAndTriggerTypeAndEnabled(TenantId,
   * NotificationRuleTriggerType, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaNotificationRuleDao.findByTenantIdAndTriggerTypeAndEnabled(TenantId, NotificationRuleTriggerType, boolean)"
  })
  public void testFindByTenantIdAndTriggerTypeAndEnabled_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(notificationRuleRepository.findAllByTenantIdAndTriggerTypeAndEnabled(
            Mockito.<UUID>any(), Mockito.<NotificationRuleTriggerType>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());

    // Act
    List<NotificationRule> actualFindByTenantIdAndTriggerTypeAndEnabledResult =
        jpaNotificationRuleDao.findByTenantIdAndTriggerTypeAndEnabled(
            ModelConstants.SYSTEM_TENANT, NotificationRuleTriggerType.ENTITY_ACTION, true);

    // Assert
    verify(notificationRuleRepository)
        .findAllByTenantIdAndTriggerTypeAndEnabled(
            isA(UUID.class), eq(NotificationRuleTriggerType.ENTITY_ACTION), eq(true));
    assertTrue(actualFindByTenantIdAndTriggerTypeAndEnabledResult.isEmpty());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findInfoById(TenantId, NotificationRuleId)}.
   *
   * <ul>
   *   <li>Given {@link JdbcTemplate}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findInfoById(TenantId, NotificationRuleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRuleInfo JpaNotificationRuleDao.findInfoById(TenantId, NotificationRuleId)"
  })
  public void testFindInfoById_givenJdbcTemplate_thenReturnNull() {
    // Arrange
    when(notificationRuleRepository.findInfoById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    NotificationRuleInfo actualFindInfoByIdResult =
        jpaNotificationRuleDao.findInfoById(
            ModelConstants.SYSTEM_TENANT, new NotificationRuleId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRuleRepository).findInfoById(isA(UUID.class));
    assertNull(actualFindInfoByIdResult);
  }

  /**
   * Test {@link JpaNotificationRuleDao#findInfoById(TenantId, NotificationRuleId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link NotificationRuleId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findInfoById(TenantId, NotificationRuleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRuleInfo JpaNotificationRuleDao.findInfoById(TenantId, NotificationRuleId)"
  })
  public void testFindInfoById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    when(notificationRuleInfoEntity.toData()).thenReturn(notificationRuleInfo);

    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.findInfoById(Mockito.<UUID>any()))
        .thenReturn(notificationRuleInfoEntity);
    JpaNotificationRuleDao jpaNotificationRuleDao =
        new JpaNotificationRuleDao(notificationRuleRepository);

    NotificationRuleId id = mock(NotificationRuleId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    NotificationRuleInfo actualFindInfoByIdResult =
        jpaNotificationRuleDao.findInfoById(ModelConstants.SYSTEM_TENANT, id);

    // Assert
    verify(id).getId();
    verify(notificationRuleInfoEntity).toData();
    verify(notificationRuleRepository).findInfoById(isA(UUID.class));
    assertSame(notificationRuleInfo, actualFindInfoByIdResult);
  }

  /**
   * Test {@link JpaNotificationRuleDao#findInfoById(TenantId, NotificationRuleId)}.
   *
   * <ul>
   *   <li>Then return {@link NotificationRuleInfo#NotificationRuleInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findInfoById(TenantId, NotificationRuleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRuleInfo JpaNotificationRuleDao.findInfoById(TenantId, NotificationRuleId)"
  })
  public void testFindInfoById_thenReturnNotificationRuleInfo() {
    // Arrange
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();
    when(notificationRuleInfoEntity.toData()).thenReturn(notificationRuleInfo);

    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.findInfoById(Mockito.<UUID>any()))
        .thenReturn(notificationRuleInfoEntity);
    JpaNotificationRuleDao jpaNotificationRuleDao =
        new JpaNotificationRuleDao(notificationRuleRepository);

    // Act
    NotificationRuleInfo actualFindInfoByIdResult =
        jpaNotificationRuleDao.findInfoById(
            ModelConstants.SYSTEM_TENANT, new NotificationRuleId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRuleInfoEntity).toData();
    verify(notificationRuleRepository).findInfoById(isA(UUID.class));
    assertSame(notificationRuleInfo, actualFindInfoByIdResult);
  }

  /**
   * Test {@link JpaNotificationRuleDao#removeByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#removeByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaNotificationRuleDao.removeByTenantId(TenantId)"})
  public void testRemoveByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(notificationRuleRepository).deleteByTenantId(Mockito.<UUID>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaNotificationRuleDao.removeByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(notificationRuleRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationRuleDao#removeByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link NotificationRuleRepository#deleteByTenantId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#removeByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaNotificationRuleDao.removeByTenantId(TenantId)"})
  public void testRemoveByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(notificationRuleRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaNotificationRuleDao.removeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationRuleRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRule JpaNotificationRuleDao.findByTenantIdAndExternalId(UUID, UUID)"
  })
  public void testFindByTenantIdAndExternalId() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(MissingNode.getInstance());
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationRuleEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    NotificationRule actualFindByTenantIdAndExternalIdResult =
        new JpaNotificationRuleDao(notificationRuleRepository)
            .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(notificationRuleRepository)
        .findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    TenantId tenantId = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    NotificationRuleId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_RULE, externalId2.getEntityType());
    assertTrue(externalId2.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertSame(externalId, externalId2.getId());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRule JpaNotificationRuleDao.findByTenantIdAndExternalId(UUID, UUID)"
  })
  public void testFindByTenantIdAndExternalId2() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(new UUID(2L, 2L));
    notificationRuleEntity.setTriggerConfig(MissingNode.getInstance());
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationRuleEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    NotificationRule actualFindByTenantIdAndExternalIdResult =
        new JpaNotificationRuleDao(notificationRuleRepository)
            .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(notificationRuleRepository)
        .findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    TenantId tenantId = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertEquals("00000000-0000-0002-0000-000000000002", tenantId.getId().toString());
    NotificationRuleId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_RULE, externalId2.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertTrue(externalId2.isNullUid());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertSame(externalId, externalId2.getId());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRule JpaNotificationRuleDao.findByTenantIdAndExternalId(UUID, UUID)"
  })
  public void testFindByTenantIdAndExternalId_thenReturnExternalIdIsNull() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(null);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(MissingNode.getInstance());
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationRuleEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    NotificationRule actualFindByTenantIdAndExternalIdResult =
        new JpaNotificationRuleDao(notificationRuleRepository)
            .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(notificationRuleRepository)
        .findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertNull(actualFindByTenantIdAndExternalIdResult.getExternalId());
    NotificationRuleId id = actualFindByTenantIdAndExternalIdResult.getId();
    assertEquals(EntityType.NOTIFICATION_RULE, id.getEntityType());
    assertTrue(id.isNullUid());
    assertSame(externalId, id.getId());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRule JpaNotificationRuleDao.findByTenantIdAndExternalId(UUID, UUID)"
  })
  public void testFindByTenantIdAndExternalId_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    notificationRuleEntity.setTenantId(tenantId);
    notificationRuleEntity.setTriggerConfig(MissingNode.getInstance());
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationRuleEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    NotificationRule actualFindByTenantIdAndExternalIdResult =
        new JpaNotificationRuleDao(notificationRuleRepository)
            .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(notificationRuleRepository)
        .findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    NotificationRuleId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_RULE, externalId2.getEntityType());
    TenantId tenantId2 = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId2.isNullUid());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertSame(tenantId, tenantId2.getId());
    assertSame(externalId, externalId2.getId());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndName(UUID, String)}.
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRule JpaNotificationRuleDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(MissingNode.getInstance());
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.findByTenantIdAndName(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(notificationRuleEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    NotificationRule actualFindByTenantIdAndNameResult =
        new JpaNotificationRuleDao(notificationRuleRepository)
            .findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(notificationRuleRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    TenantId tenantId2 = actualFindByTenantIdAndNameResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    NotificationRuleId externalId = actualFindByTenantIdAndNameResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_RULE, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertEquals(externalId, actualFindByTenantIdAndNameResult.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndName(UUID, String)}.
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRule JpaNotificationRuleDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName2() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(new UUID(2L, 2L));
    notificationRuleEntity.setTriggerConfig(MissingNode.getInstance());
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.findByTenantIdAndName(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(notificationRuleEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    NotificationRule actualFindByTenantIdAndNameResult =
        new JpaNotificationRuleDao(notificationRuleRepository)
            .findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(notificationRuleRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    TenantId tenantId2 = actualFindByTenantIdAndNameResult.getTenantId();
    assertEquals("00000000-0000-0002-0000-000000000002", tenantId2.getId().toString());
    NotificationRuleId externalId = actualFindByTenantIdAndNameResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_RULE, externalId.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualFindByTenantIdAndNameResult.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Then return ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRule JpaNotificationRuleDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName_thenReturnExternalIdIsNull() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(null);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(MissingNode.getInstance());
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.findByTenantIdAndName(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(notificationRuleEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    NotificationRule actualFindByTenantIdAndNameResult =
        new JpaNotificationRuleDao(notificationRuleRepository)
            .findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(notificationRuleRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertNull(actualFindByTenantIdAndNameResult.getExternalId());
    NotificationRuleId id = actualFindByTenantIdAndNameResult.getId();
    assertEquals(EntityType.NOTIFICATION_RULE, id.getEntityType());
    assertTrue(id.isNullUid());
    assertSame(tenantId, id.getId());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRule JpaNotificationRuleDao.findByTenantIdAndName(UUID, String)"})
  public void testFindByTenantIdAndName_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    notificationRuleEntity.setTenantId(tenantId);
    notificationRuleEntity.setTriggerConfig(MissingNode.getInstance());
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.findByTenantIdAndName(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(notificationRuleEntity);
    UUID tenantId2 = ModelConstants.NULL_UUID;

    // Act
    NotificationRule actualFindByTenantIdAndNameResult =
        new JpaNotificationRuleDao(notificationRuleRepository)
            .findByTenantIdAndName(tenantId2, "Name");

    // Assert
    verify(notificationRuleRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    NotificationRuleId externalId = actualFindByTenantIdAndNameResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_RULE, externalId.getEntityType());
    TenantId tenantId3 = actualFindByTenantIdAndNameResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualFindByTenantIdAndNameResult.getId());
    assertSame(tenantId, tenantId3.getId());
    assertSame(tenantId2, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaNotificationRuleDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRuleRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<NotificationRule> actualFindByTenantIdResult =
        jpaNotificationRuleDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRuleRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaNotificationRuleDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(MissingNode.getInstance());
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationRuleEntity> content = new ArrayList<>();
    content.add(notificationRuleEntity);

    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    JpaNotificationRuleDao jpaNotificationRuleDao =
        new JpaNotificationRuleDao(notificationRuleRepository);
    UUID tenantId = ModelConstants.NULL_UUID;

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<NotificationRule> actualFindByTenantIdResult =
        jpaNotificationRuleDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRuleRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<NotificationRule> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    NotificationRule getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    NotificationRuleId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_RULE, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertEquals(externalId, getResult.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationRuleDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationRuleDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaNotificationRuleDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRuleRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationRule> actualFindByTenantIdResult =
        jpaNotificationRuleDao.findByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRuleRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationRuleDao#getExternalIdByInternal(NotificationRuleId)} with {@code
   * NotificationRuleId}.
   *
   * <p>Method under test: {@link
   * JpaNotificationRuleDao#getExternalIdByInternal(NotificationRuleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRuleId JpaNotificationRuleDao.getExternalIdByInternal(NotificationRuleId)"
  })
  public void testGetExternalIdByInternalWithNotificationRuleId() {
    // Arrange
    when(notificationRuleRepository.getExternalIdByInternal(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    NotificationRuleId internalId = new NotificationRuleId(ModelConstants.NULL_UUID);

    // Act
    NotificationRuleId actualExternalIdByInternal =
        jpaNotificationRuleDao.getExternalIdByInternal(internalId);

    // Assert
    verify(notificationRuleRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaNotificationRuleDao#getExternalIdByInternal(NotificationRuleId)} with {@code
   * NotificationRuleId}.
   *
   * <p>Method under test: {@link
   * JpaNotificationRuleDao#getExternalIdByInternal(NotificationRuleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRuleId JpaNotificationRuleDao.getExternalIdByInternal(NotificationRuleId)"
  })
  public void testGetExternalIdByInternalWithNotificationRuleId2() {
    // Arrange
    when(notificationRuleRepository.getExternalIdByInternal(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);

    NotificationRuleId internalId = mock(NotificationRuleId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    NotificationRuleId actualExternalIdByInternal =
        jpaNotificationRuleDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(notificationRuleRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.NOTIFICATION_RULE, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaNotificationRuleDao#getExternalIdByInternal(NotificationRuleId)} with {@code
   * NotificationRuleId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationRuleDao#getExternalIdByInternal(NotificationRuleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationRuleId JpaNotificationRuleDao.getExternalIdByInternal(NotificationRuleId)"
  })
  public void testGetExternalIdByInternalWithNotificationRuleId_thenReturnNull() {
    // Arrange
    when(notificationRuleRepository.getExternalIdByInternal(Mockito.<UUID>any())).thenReturn(null);

    NotificationRuleId internalId = mock(NotificationRuleId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    NotificationRuleId actualExternalIdByInternal =
        jpaNotificationRuleDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(notificationRuleRepository).getExternalIdByInternal(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaNotificationRuleDao#getEntityClass()}
   *   <li>{@link JpaNotificationRuleDao#getEntityType()}
   *   <li>{@link JpaNotificationRuleDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaNotificationRuleDao.getEntityClass()",
    "EntityType JpaNotificationRuleDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaNotificationRuleDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationRuleDao jpaNotificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));

    // Act
    Class<NotificationRuleEntity> actualEntityClass = jpaNotificationRuleDao.getEntityClass();
    EntityType actualEntityType = jpaNotificationRuleDao.getEntityType();
    jpaNotificationRuleDao.getRepository();

    // Assert
    assertEquals(EntityType.NOTIFICATION_RULE, actualEntityType);
    Class<NotificationRuleEntity> expectedEntityClass = NotificationRuleEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
