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
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationTemplateEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaNotificationTemplateDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaNotificationTemplateDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaNotificationTemplateDao jpaNotificationTemplateDao;

  @MockBean private NotificationTemplateRepository notificationTemplateRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaNotificationTemplateDao#getEntityClass()}
   *   <li>{@link JpaNotificationTemplateDao#getEntityType()}
   *   <li>{@link JpaNotificationTemplateDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaNotificationTemplateDao.getEntityClass()",
    "EntityType JpaNotificationTemplateDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaNotificationTemplateDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationTemplateDao jpaNotificationTemplateDao =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));

    // Act
    Class<NotificationTemplateEntity> actualEntityClass =
        jpaNotificationTemplateDao.getEntityClass();
    EntityType actualEntityType = jpaNotificationTemplateDao.getEntityType();
    jpaNotificationTemplateDao.getRepository();

    // Assert
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, actualEntityType);
    Class<NotificationTemplateEntity> expectedEntityClass = NotificationTemplateEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId,
   * List, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)"
  })
  public void testFindByTenantIdAndNotificationTypesAndPageLink() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTemplateEntity> content = new ArrayList<>();
    content.add(notificationTemplateEntity);
    when(notificationTemplateRepository.findByTenantIdAndNotificationTypesAndSearchText(
            Mockito.<UUID>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<NotificationType> notificationTypes = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdAndNotificationTypesAndPageLinkResult =
        jpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(
            tenantId, notificationTypes, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTemplateRepository)
        .findByTenantIdAndNotificationTypesAndSearchText(
            isA(UUID.class), isA(List.class), eq("Text Search"), isA(Pageable.class));
    List<NotificationTemplate> data =
        actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getData();
    assertEquals(1, data.size());
    assertSame(TenantId.SYS_TENANT_ID, data.get(0).getTenantId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId,
   * List, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)"
  })
  public void testFindByTenantIdAndNotificationTypesAndPageLink2() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(null);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTemplateEntity> content = new ArrayList<>();
    content.add(notificationTemplateEntity);
    when(notificationTemplateRepository.findByTenantIdAndNotificationTypesAndSearchText(
            Mockito.<UUID>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<NotificationType> notificationTypes = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdAndNotificationTypesAndPageLinkResult =
        jpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(
            tenantId, notificationTypes, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTemplateRepository)
        .findByTenantIdAndNotificationTypesAndSearchText(
            isA(UUID.class), isA(List.class), eq("Text Search"), isA(Pageable.class));
    List<NotificationTemplate> data =
        actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getData();
    assertEquals(1, data.size());
    NotificationTemplate getResult = data.get(0);
    assertNull(getResult.getExternalId());
    NotificationTemplateId id = getResult.getId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, id.getEntityType());
    assertTrue(id.isNullUid());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId,
   * List, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)"
  })
  public void testFindByTenantIdAndNotificationTypesAndPageLink3() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    UUID tenantId = UUID.randomUUID();
    notificationTemplateEntity.setTenantId(tenantId);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTemplateEntity> content = new ArrayList<>();
    content.add(notificationTemplateEntity);
    when(notificationTemplateRepository.findByTenantIdAndNotificationTypesAndSearchText(
            Mockito.<UUID>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<NotificationType> notificationTypes = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdAndNotificationTypesAndPageLinkResult =
        jpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(
            tenantId2, notificationTypes, pageLink);

    // Assert
    verify(tenantId2).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTemplateRepository)
        .findByTenantIdAndNotificationTypesAndSearchText(
            isA(UUID.class), isA(List.class), eq("Text Search"), isA(Pageable.class));
    List<NotificationTemplate> data =
        actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getData();
    assertEquals(1, data.size());
    NotificationTemplate getResult = data.get(0);
    NotificationTemplateId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, externalId.getEntityType());
    TenantId tenantId3 = getResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
    assertSame(tenantId, tenantId3.getId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId,
   * List, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)"
  })
  public void testFindByTenantIdAndNotificationTypesAndPageLink4() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(new UUID(1L, 1L));
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTemplateEntity> content = new ArrayList<>();
    content.add(notificationTemplateEntity);
    when(notificationTemplateRepository.findByTenantIdAndNotificationTypesAndSearchText(
            Mockito.<UUID>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<NotificationType> notificationTypes = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdAndNotificationTypesAndPageLinkResult =
        jpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(
            tenantId, notificationTypes, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTemplateRepository)
        .findByTenantIdAndNotificationTypesAndSearchText(
            isA(UUID.class), isA(List.class), eq("Text Search"), isA(Pageable.class));
    List<NotificationTemplate> data =
        actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getData();
    assertEquals(1, data.size());
    NotificationTemplate getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("00000000-0000-0001-0000-000000000001", tenantId2.getId().toString());
    NotificationTemplateId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, externalId.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId,
   * List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@code ALARM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)"
  })
  public void testFindByTenantIdAndNotificationTypesAndPageLink_givenAlarm() {
    // Arrange
    when(notificationTemplateRepository.findByTenantIdAndNotificationTypesAndSearchText(
            Mockito.<UUID>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.ALARM);
    notificationTypes.add(NotificationType.GENERAL);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdAndNotificationTypesAndPageLinkResult =
        jpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(
            tenantId, notificationTypes, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTemplateRepository)
        .findByTenantIdAndNotificationTypesAndSearchText(
            isA(UUID.class), isA(List.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId,
   * List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@code GENERAL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)"
  })
  public void testFindByTenantIdAndNotificationTypesAndPageLink_givenGeneral() {
    // Arrange
    when(notificationTemplateRepository.findByTenantIdAndNotificationTypesAndSearchText(
            Mockito.<UUID>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.GENERAL);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdAndNotificationTypesAndPageLinkResult =
        jpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(
            tenantId, notificationTypes, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTemplateRepository)
        .findByTenantIdAndNotificationTypesAndSearchText(
            isA(UUID.class), isA(List.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId,
   * List, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)"
  })
  public void testFindByTenantIdAndNotificationTypesAndPageLink_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationTemplateRepository.findByTenantIdAndNotificationTypesAndSearchText(
            Mockito.<UUID>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<NotificationType> notificationTypes = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdAndNotificationTypesAndPageLinkResult =
        jpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(
            tenantId, notificationTypes, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTemplateRepository)
        .findByTenantIdAndNotificationTypesAndSearchText(
            isA(UUID.class), isA(List.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId,
   * List, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)"
  })
  public void testFindByTenantIdAndNotificationTypesAndPageLink_whenFirst_page() {
    // Arrange
    when(notificationTemplateRepository.findByTenantIdAndNotificationTypesAndSearchText(
            Mockito.<UUID>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdAndNotificationTypesAndPageLinkResult =
        jpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(
            tenantId, new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(notificationTemplateRepository)
        .findByTenantIdAndNotificationTypesAndSearchText(
            isA(UUID.class), isA(List.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId,
   * List, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#findByTenantIdAndNotificationTypesAndPageLink(TenantId, List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(TenantId, List, PageLink)"
  })
  public void testFindByTenantIdAndNotificationTypesAndPageLink_whenSystem_tenant() {
    // Arrange
    when(notificationTemplateRepository.findByTenantIdAndNotificationTypesAndSearchText(
            Mockito.<UUID>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdAndNotificationTypesAndPageLinkResult =
        jpaNotificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTemplateRepository)
        .findByTenantIdAndNotificationTypesAndSearchText(
            isA(UUID.class), isA(List.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.hasNext());
    assertTrue(actualFindByTenantIdAndNotificationTypesAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@code ALARM}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ALARM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int JpaNotificationTemplateDao.countByTenantIdAndNotificationTypes(TenantId, List)"
  })
  public void testCountByTenantIdAndNotificationTypes_givenAlarm_whenArrayListAddAlarm() {
    // Arrange
    when(notificationTemplateRepository.countByTenantIdAndNotificationTypes(
            Mockito.<UUID>any(), Mockito.<List<NotificationType>>any()))
        .thenReturn(1);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.ALARM);
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    int actualCountByTenantIdAndNotificationTypesResult =
        jpaNotificationTemplateDao.countByTenantIdAndNotificationTypes(tenantId, notificationTypes);

    // Assert
    verify(tenantId).getId();
    verify(notificationTemplateRepository)
        .countByTenantIdAndNotificationTypes(isA(UUID.class), isA(List.class));
    assertEquals(1, actualCountByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@code GENERAL}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code GENERAL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int JpaNotificationTemplateDao.countByTenantIdAndNotificationTypes(TenantId, List)"
  })
  public void testCountByTenantIdAndNotificationTypes_givenGeneral_whenArrayListAddGeneral() {
    // Arrange
    when(notificationTemplateRepository.countByTenantIdAndNotificationTypes(
            Mockito.<UUID>any(), Mockito.<List<NotificationType>>any()))
        .thenReturn(1);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    int actualCountByTenantIdAndNotificationTypesResult =
        jpaNotificationTemplateDao.countByTenantIdAndNotificationTypes(tenantId, notificationTypes);

    // Assert
    verify(tenantId).getId();
    verify(notificationTemplateRepository)
        .countByTenantIdAndNotificationTypes(isA(UUID.class), isA(List.class));
    assertEquals(1, actualCountByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int JpaNotificationTemplateDao.countByTenantIdAndNotificationTypes(TenantId, List)"
  })
  public void testCountByTenantIdAndNotificationTypes_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(notificationTemplateRepository.countByTenantIdAndNotificationTypes(
            Mockito.<UUID>any(), Mockito.<List<NotificationType>>any()))
        .thenReturn(1);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    int actualCountByTenantIdAndNotificationTypesResult =
        jpaNotificationTemplateDao.countByTenantIdAndNotificationTypes(tenantId, new ArrayList<>());

    // Assert
    verify(tenantId).getId();
    verify(notificationTemplateRepository)
        .countByTenantIdAndNotificationTypes(isA(UUID.class), isA(List.class));
    assertEquals(1, actualCountByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int JpaNotificationTemplateDao.countByTenantIdAndNotificationTypes(TenantId, List)"
  })
  public void testCountByTenantIdAndNotificationTypes_whenSystem_tenant_thenReturnOne() {
    // Arrange
    when(notificationTemplateRepository.countByTenantIdAndNotificationTypes(
            Mockito.<UUID>any(), Mockito.<List<NotificationType>>any()))
        .thenReturn(1);

    // Act
    int actualCountByTenantIdAndNotificationTypesResult =
        jpaNotificationTemplateDao.countByTenantIdAndNotificationTypes(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(notificationTemplateRepository)
        .countByTenantIdAndNotificationTypes(isA(UUID.class), isA(List.class));
    assertEquals(1, actualCountByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link JpaNotificationTemplateDao#removeByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#removeByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaNotificationTemplateDao.removeByTenantId(TenantId)"})
  public void testRemoveByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(notificationTemplateRepository).deleteByTenantId(Mockito.<UUID>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaNotificationTemplateDao.removeByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(notificationTemplateRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationTemplateDao#removeByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link NotificationTemplateRepository#deleteByTenantId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#removeByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaNotificationTemplateDao.removeByTenantId(TenantId)"})
  public void testRemoveByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(notificationTemplateRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaNotificationTemplateDao.removeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTemplateRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#findByTenantIdAndExternalId(UUID,
   * UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate JpaNotificationTemplateDao.findByTenantIdAndExternalId(UUID, UUID)"
  })
  public void testFindByTenantIdAndExternalId() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTemplateRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTemplateEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    NotificationTemplate actualFindByTenantIdAndExternalIdResult =
        jpaNotificationTemplateDao.findByTenantIdAndExternalId(
            ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(notificationTemplateRepository)
        .findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    TenantId tenantId = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    NotificationTemplateId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, externalId2.getEntityType());
    assertTrue(externalId2.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertSame(externalId, externalId2.getId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#findByTenantIdAndExternalId(UUID,
   * UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate JpaNotificationTemplateDao.findByTenantIdAndExternalId(UUID, UUID)"
  })
  public void testFindByTenantIdAndExternalId2() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(new UUID(2L, 2L));
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTemplateRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTemplateEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    NotificationTemplate actualFindByTenantIdAndExternalIdResult =
        jpaNotificationTemplateDao.findByTenantIdAndExternalId(
            ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(notificationTemplateRepository)
        .findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    TenantId tenantId = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertEquals("00000000-0000-0002-0000-000000000002", tenantId.getId().toString());
    NotificationTemplateId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, externalId2.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertTrue(externalId2.isNullUid());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertSame(externalId, externalId2.getId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#findByTenantIdAndExternalId(UUID,
   * UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate JpaNotificationTemplateDao.findByTenantIdAndExternalId(UUID, UUID)"
  })
  public void testFindByTenantIdAndExternalId_thenReturnExternalIdIsNull() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(null);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTemplateRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTemplateEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    NotificationTemplate actualFindByTenantIdAndExternalIdResult =
        jpaNotificationTemplateDao.findByTenantIdAndExternalId(
            ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(notificationTemplateRepository)
        .findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    assertNull(actualFindByTenantIdAndExternalIdResult.getExternalId());
    NotificationTemplateId id = actualFindByTenantIdAndExternalIdResult.getId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, id.getEntityType());
    assertTrue(id.isNullUid());
    assertSame(externalId, id.getId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndExternalId(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#findByTenantIdAndExternalId(UUID,
   * UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate JpaNotificationTemplateDao.findByTenantIdAndExternalId(UUID, UUID)"
  })
  public void testFindByTenantIdAndExternalId_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    UUID tenantId = UUID.randomUUID();
    notificationTemplateEntity.setTenantId(tenantId);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTemplateRepository.findByTenantIdAndExternalId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTemplateEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    NotificationTemplate actualFindByTenantIdAndExternalIdResult =
        jpaNotificationTemplateDao.findByTenantIdAndExternalId(
            ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(notificationTemplateRepository)
        .findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    NotificationTemplateId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, externalId2.getEntityType());
    TenantId tenantId2 = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId2.isNullUid());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertSame(tenantId, tenantId2.getId());
    assertSame(externalId, externalId2.getId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndName(UUID, String)}.
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate JpaNotificationTemplateDao.findByTenantIdAndName(UUID, String)"
  })
  public void testFindByTenantIdAndName() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTemplateRepository.findByTenantIdAndName(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(notificationTemplateEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    NotificationTemplate actualFindByTenantIdAndNameResult =
        jpaNotificationTemplateDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(notificationTemplateRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    TenantId tenantId2 = actualFindByTenantIdAndNameResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    NotificationTemplateId externalId = actualFindByTenantIdAndNameResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertEquals(externalId, actualFindByTenantIdAndNameResult.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndName(UUID, String)}.
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate JpaNotificationTemplateDao.findByTenantIdAndName(UUID, String)"
  })
  public void testFindByTenantIdAndName2() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(new UUID(2L, 2L));
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTemplateRepository.findByTenantIdAndName(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(notificationTemplateEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    NotificationTemplate actualFindByTenantIdAndNameResult =
        jpaNotificationTemplateDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(notificationTemplateRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    TenantId tenantId2 = actualFindByTenantIdAndNameResult.getTenantId();
    assertEquals("00000000-0000-0002-0000-000000000002", tenantId2.getId().toString());
    NotificationTemplateId externalId = actualFindByTenantIdAndNameResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, externalId.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualFindByTenantIdAndNameResult.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Then return ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate JpaNotificationTemplateDao.findByTenantIdAndName(UUID, String)"
  })
  public void testFindByTenantIdAndName_thenReturnExternalIdIsNull() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(null);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTemplateRepository.findByTenantIdAndName(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(notificationTemplateEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    NotificationTemplate actualFindByTenantIdAndNameResult =
        jpaNotificationTemplateDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(notificationTemplateRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertNull(actualFindByTenantIdAndNameResult.getExternalId());
    NotificationTemplateId id = actualFindByTenantIdAndNameResult.getId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, id.getEntityType());
    assertTrue(id.isNullUid());
    assertSame(tenantId, id.getId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantIdAndName(UUID, String)}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate JpaNotificationTemplateDao.findByTenantIdAndName(UUID, String)"
  })
  public void testFindByTenantIdAndName_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    UUID tenantId = UUID.randomUUID();
    notificationTemplateEntity.setTenantId(tenantId);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);
    when(notificationTemplateRepository.findByTenantIdAndName(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(notificationTemplateEntity);
    UUID tenantId2 = ModelConstants.NULL_UUID;

    // Act
    NotificationTemplate actualFindByTenantIdAndNameResult =
        jpaNotificationTemplateDao.findByTenantIdAndName(tenantId2, "Name");

    // Assert
    verify(notificationTemplateRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    NotificationTemplateId externalId = actualFindByTenantIdAndNameResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, externalId.getEntityType());
    TenantId tenantId3 = actualFindByTenantIdAndNameResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualFindByTenantIdAndNameResult.getId());
    assertSame(tenantId, tenantId3.getId());
    assertSame(tenantId2, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaNotificationTemplateDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTemplateEntity> content = new ArrayList<>();
    content.add(notificationTemplateEntity);
    when(notificationTemplateRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<Pageable>any()))
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
    PageData<NotificationTemplate> actualFindByTenantIdResult =
        jpaNotificationTemplateDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTemplateRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<NotificationTemplate> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    NotificationTemplate getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    NotificationTemplateId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertEquals(externalId, getResult.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}.
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaNotificationTemplateDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId2() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(new UUID(1L, 1L));
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTemplateEntity> content = new ArrayList<>();
    content.add(notificationTemplateEntity);
    when(notificationTemplateRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<Pageable>any()))
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
    PageData<NotificationTemplate> actualFindByTenantIdResult =
        jpaNotificationTemplateDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTemplateRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<NotificationTemplate> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    NotificationTemplate getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("00000000-0000-0001-0000-000000000001", tenantId2.getId().toString());
    NotificationTemplateId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, externalId.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaNotificationTemplateDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationTemplateRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdResult =
        jpaNotificationTemplateDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTemplateRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaNotificationTemplateDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_thenReturnDataFirstExternalIdIsNull() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(null);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTemplateEntity> content = new ArrayList<>();
    content.add(notificationTemplateEntity);
    when(notificationTemplateRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<Pageable>any()))
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
    PageData<NotificationTemplate> actualFindByTenantIdResult =
        jpaNotificationTemplateDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTemplateRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<NotificationTemplate> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    NotificationTemplate getResult = data.get(0);
    assertNull(getResult.getExternalId());
    NotificationTemplateId id = getResult.getId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, id.getEntityType());
    assertTrue(id.isNullUid());
    assertSame(tenantId, id.getId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaNotificationTemplateDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_thenReturnDataFirstTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    UUID tenantId = UUID.randomUUID();
    notificationTemplateEntity.setTenantId(tenantId);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationTemplateEntity> content = new ArrayList<>();
    content.add(notificationTemplateEntity);
    when(notificationTemplateRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<Pageable>any()))
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
    PageData<NotificationTemplate> actualFindByTenantIdResult =
        jpaNotificationTemplateDao.findByTenantId(tenantId2, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationTemplateRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<NotificationTemplate> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    NotificationTemplate getResult = data.get(0);
    NotificationTemplateId externalId = getResult.getExternalId();
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, externalId.getEntityType());
    TenantId tenantId3 = getResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, getResult.getId());
    assertSame(tenantId, tenantId3.getId());
    assertSame(tenantId2, externalId.getId());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationTemplateDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaNotificationTemplateDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationTemplateRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<NotificationTemplate> actualFindByTenantIdResult =
        jpaNotificationTemplateDao.findByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTemplateRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#getExternalIdByInternal(NotificationTemplateId)} with
   * {@code NotificationTemplateId}.
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#getExternalIdByInternal(NotificationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplateId JpaNotificationTemplateDao.getExternalIdByInternal(NotificationTemplateId)"
  })
  public void testGetExternalIdByInternalWithNotificationTemplateId() {
    // Arrange
    when(notificationTemplateRepository.getExternalIdByInternal(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);
    NotificationTemplateId internalId = new NotificationTemplateId(ModelConstants.NULL_UUID);

    // Act
    NotificationTemplateId actualExternalIdByInternal =
        jpaNotificationTemplateDao.getExternalIdByInternal(internalId);

    // Assert
    verify(notificationTemplateRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaNotificationTemplateDao#getExternalIdByInternal(NotificationTemplateId)} with
   * {@code NotificationTemplateId}.
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#getExternalIdByInternal(NotificationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplateId JpaNotificationTemplateDao.getExternalIdByInternal(NotificationTemplateId)"
  })
  public void testGetExternalIdByInternalWithNotificationTemplateId2() {
    // Arrange
    when(notificationTemplateRepository.getExternalIdByInternal(Mockito.<UUID>any()))
        .thenReturn(ModelConstants.NULL_UUID);

    NotificationTemplateId internalId = mock(NotificationTemplateId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    NotificationTemplateId actualExternalIdByInternal =
        jpaNotificationTemplateDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(notificationTemplateRepository).getExternalIdByInternal(isA(UUID.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaNotificationTemplateDao#getExternalIdByInternal(NotificationTemplateId)} with
   * {@code NotificationTemplateId}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationTemplateDao#getExternalIdByInternal(NotificationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplateId JpaNotificationTemplateDao.getExternalIdByInternal(NotificationTemplateId)"
  })
  public void testGetExternalIdByInternalWithNotificationTemplateId_thenReturnNull() {
    // Arrange
    when(notificationTemplateRepository.getExternalIdByInternal(Mockito.<UUID>any()))
        .thenReturn(null);

    NotificationTemplateId internalId = mock(NotificationTemplateId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    NotificationTemplateId actualExternalIdByInternal =
        jpaNotificationTemplateDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(notificationTemplateRepository).getExternalIdByInternal(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }
}
