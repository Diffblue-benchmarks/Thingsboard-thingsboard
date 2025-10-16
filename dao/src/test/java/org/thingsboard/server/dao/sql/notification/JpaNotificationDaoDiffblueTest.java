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
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.thingsboard.server.common.data.id.NotificationId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.notification.Notification;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationStatus;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {JpaNotificationDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaNotificationDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaNotificationDao jpaNotificationDao;

  @MockBean private NotificationRepository notificationRepository;

  @MockBean private SqlPartitioningRepository sqlPartitioningRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)"
  })
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndPageLink() {
    // Arrange
    when(notificationRepository.findByDeliveryMethodAndRecipientIdAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<NotificationStatus>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Notification> actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult =
        jpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndPageLink(
            ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB,
            new UserId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientIdAndStatusNot(
            eq(NotificationDeliveryMethod.WEB),
            isA(UUID.class),
            eq(NotificationStatus.READ),
            isNull(),
            isA(Pageable.class));
    assertEquals(
        0L, actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(
        1, actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.hasNext());
    assertTrue(actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)"
  })
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndPageLink2() {
    // Arrange
    when(notificationRepository.findByDeliveryMethodAndRecipientIdAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<NotificationStatus>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Notification> actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult =
        jpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndPageLink(
            ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB,
            recipientId,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientIdAndStatusNot(
            eq(NotificationDeliveryMethod.WEB),
            isA(UUID.class),
            eq(NotificationStatus.READ),
            isNull(),
            isA(Pageable.class));
    assertEquals(
        0L, actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(
        1, actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.hasNext());
    assertTrue(actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)"
  })
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndPageLink3() {
    // Arrange
    when(notificationRepository.findByDeliveryMethodAndRecipientIdAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<NotificationStatus>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Notification> actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult =
        jpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndPageLink(
            ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB, recipientId, pageLink);

    // Assert
    verify(recipientId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientIdAndStatusNot(
            eq(NotificationDeliveryMethod.WEB),
            isA(UUID.class),
            eq(NotificationStatus.READ),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(
        0L, actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(
        1, actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.hasNext());
    assertTrue(actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)"
  })
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndPageLink4() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(ModelConstants.NULL_UUID);
    notificationEntity.setInfo(MissingNode.getInstance());
    notificationEntity.setRecipientId(null);
    notificationEntity.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationEntity> content = new ArrayList<>();
    content.add(notificationEntity);
    when(notificationRepository.findByDeliveryMethodAndRecipientIdAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<NotificationStatus>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Notification> actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult =
        jpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndPageLink(
            ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB, recipientId, pageLink);

    // Assert
    verify(recipientId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientIdAndStatusNot(
            eq(NotificationDeliveryMethod.WEB),
            isA(UUID.class),
            eq(NotificationStatus.READ),
            eq("Text Search"),
            isA(Pageable.class));
    List<Notification> data =
        actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getData();
    assertEquals(1, data.size());
    Notification getResult = data.get(0);
    assertTrue(getResult.getAdditionalConfig() instanceof ObjectNode);
    assertEquals("Hello from the Dreaming Spires", getResult.getSubject());
    assertEquals("Text", getResult.getText());
    assertNull(getResult.getRecipientId());
    assertNull(getResult.getInfo());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(
        1L, actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(NotificationDeliveryMethod.WEB, getResult.getDeliveryMethod());
    assertEquals(NotificationStatus.SENT, getResult.getStatus());
    assertEquals(NotificationType.GENERAL, getResult.getType());
  }

  /**
   * Test {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)"
  })
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndPageLink_thenReturnDataSizeIsOne() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(ModelConstants.NULL_UUID);
    notificationEntity.setInfo(MissingNode.getInstance());
    notificationEntity.setRecipientId(ModelConstants.NULL_UUID);
    notificationEntity.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationEntity> content = new ArrayList<>();
    content.add(notificationEntity);
    when(notificationRepository.findByDeliveryMethodAndRecipientIdAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<NotificationStatus>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Notification> actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult =
        jpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndPageLink(
            ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB, recipientId, pageLink);

    // Assert
    verify(recipientId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientIdAndStatusNot(
            eq(NotificationDeliveryMethod.WEB),
            isA(UUID.class),
            eq(NotificationStatus.READ),
            eq("Text Search"),
            isA(Pageable.class));
    List<Notification> data =
        actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getData();
    assertEquals(1, data.size());
    Notification getResult = data.get(0);
    assertTrue(getResult.getAdditionalConfig() instanceof ObjectNode);
    assertEquals("Hello from the Dreaming Spires", getResult.getSubject());
    assertEquals("Text", getResult.getText());
    assertNull(getResult.getInfo());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(
        1L, actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(NotificationDeliveryMethod.WEB, getResult.getDeliveryMethod());
    assertEquals(NotificationStatus.SENT, getResult.getStatus());
    assertEquals(NotificationType.GENERAL, getResult.getType());
  }

  /**
   * Test {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, Set, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, Set, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId, NotificationDeliveryMethod, UserId, Set, PageLink)"
  })
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink() {
    // Arrange
    when(notificationRepository.findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<Set<NotificationType>>any(),
            Mockito.<NotificationStatus>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId recipientId = new UserId(ModelConstants.NULL_UUID);

    HashSet<NotificationType> types = new HashSet<>();
    types.add(NotificationType.GENERAL);

    // Act
    PageData<Notification>
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult =
            jpaNotificationDao
                .findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(
                    ModelConstants.SYSTEM_TENANT,
                    NotificationDeliveryMethod.WEB,
                    recipientId,
                    types,
                    BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
            eq(NotificationDeliveryMethod.WEB),
            isA(UUID.class),
            isA(Set.class),
            eq(NotificationStatus.READ),
            isNull(),
            isA(Pageable.class));
    assertEquals(
        0L,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getTotalElements());
    assertEquals(
        1,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getTotalPages());
    assertFalse(
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .hasNext());
    assertTrue(
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getData()
            .isEmpty());
  }

  /**
   * Test {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, Set, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, Set, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId, NotificationDeliveryMethod, UserId, Set, PageLink)"
  })
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink2() {
    // Arrange
    when(notificationRepository.findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<Set<NotificationType>>any(),
            Mockito.<NotificationStatus>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId recipientId = new UserId(ModelConstants.NULL_UUID);

    HashSet<NotificationType> types = new HashSet<>();
    types.add(NotificationType.ALARM);
    types.add(NotificationType.GENERAL);

    // Act
    PageData<Notification>
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult =
            jpaNotificationDao
                .findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(
                    ModelConstants.SYSTEM_TENANT,
                    NotificationDeliveryMethod.WEB,
                    recipientId,
                    types,
                    BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
            eq(NotificationDeliveryMethod.WEB),
            isA(UUID.class),
            isA(Set.class),
            eq(NotificationStatus.READ),
            isNull(),
            isA(Pageable.class));
    assertEquals(
        0L,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getTotalElements());
    assertEquals(
        1,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getTotalPages());
    assertFalse(
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .hasNext());
    assertTrue(
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getData()
            .isEmpty());
  }

  /**
   * Test {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, Set, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, Set, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId, NotificationDeliveryMethod, UserId, Set, PageLink)"
  })
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink3() {
    // Arrange
    when(notificationRepository.findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<Set<NotificationType>>any(),
            Mockito.<NotificationStatus>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    HashSet<NotificationType> types = new HashSet<>();
    types.add(NotificationType.GENERAL);

    // Act
    PageData<Notification>
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult =
            jpaNotificationDao
                .findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(
                    ModelConstants.SYSTEM_TENANT,
                    NotificationDeliveryMethod.WEB,
                    recipientId,
                    types,
                    BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
            eq(NotificationDeliveryMethod.WEB),
            isA(UUID.class),
            isA(Set.class),
            eq(NotificationStatus.READ),
            isNull(),
            isA(Pageable.class));
    assertEquals(
        0L,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getTotalElements());
    assertEquals(
        1,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getTotalPages());
    assertFalse(
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .hasNext());
    assertTrue(
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getData()
            .isEmpty());
  }

  /**
   * Test {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, Set, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, Set, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId, NotificationDeliveryMethod, UserId, Set, PageLink)"
  })
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink4() {
    // Arrange
    when(notificationRepository.findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<Set<NotificationType>>any(),
            Mockito.<NotificationStatus>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    HashSet<NotificationType> types = new HashSet<>();
    types.add(NotificationType.GENERAL);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Notification>
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult =
            jpaNotificationDao
                .findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(
                    ModelConstants.SYSTEM_TENANT,
                    NotificationDeliveryMethod.WEB,
                    recipientId,
                    types,
                    pageLink);

    // Assert
    verify(recipientId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
            eq(NotificationDeliveryMethod.WEB),
            isA(UUID.class),
            isA(Set.class),
            eq(NotificationStatus.READ),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(
        0L,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getTotalElements());
    assertEquals(
        1,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getTotalPages());
    assertFalse(
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .hasNext());
    assertTrue(
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getData()
            .isEmpty());
  }

  /**
   * Test {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, Set, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, Set, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId, NotificationDeliveryMethod, UserId, Set, PageLink)"
  })
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink5() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(ModelConstants.NULL_UUID);
    notificationEntity.setInfo(MissingNode.getInstance());
    notificationEntity.setRecipientId(ModelConstants.NULL_UUID);
    notificationEntity.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationEntity> content = new ArrayList<>();
    content.add(notificationEntity);
    when(notificationRepository.findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<Set<NotificationType>>any(),
            Mockito.<NotificationStatus>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    HashSet<NotificationType> types = new HashSet<>();
    types.add(NotificationType.GENERAL);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Notification>
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult =
            jpaNotificationDao
                .findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(
                    ModelConstants.SYSTEM_TENANT,
                    NotificationDeliveryMethod.WEB,
                    recipientId,
                    types,
                    pageLink);

    // Assert
    verify(recipientId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
            eq(NotificationDeliveryMethod.WEB),
            isA(UUID.class),
            isA(Set.class),
            eq(NotificationStatus.READ),
            eq("Text Search"),
            isA(Pageable.class));
    List<Notification> data =
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getData();
    assertEquals(1, data.size());
    Notification getResult = data.get(0);
    assertTrue(getResult.getAdditionalConfig() instanceof ObjectNode);
    assertEquals("Hello from the Dreaming Spires", getResult.getSubject());
    assertEquals("Text", getResult.getText());
    assertNull(getResult.getInfo());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(
        1L,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getTotalElements());
    assertEquals(NotificationDeliveryMethod.WEB, getResult.getDeliveryMethod());
    assertEquals(NotificationStatus.SENT, getResult.getStatus());
    assertEquals(NotificationType.GENERAL, getResult.getType());
  }

  /**
   * Test {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, Set, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, Set, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId, NotificationDeliveryMethod, UserId, Set, PageLink)"
  })
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink6() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(ModelConstants.NULL_UUID);
    notificationEntity.setInfo(MissingNode.getInstance());
    notificationEntity.setRecipientId(null);
    notificationEntity.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationEntity> content = new ArrayList<>();
    content.add(notificationEntity);
    when(notificationRepository.findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<Set<NotificationType>>any(),
            Mockito.<NotificationStatus>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    HashSet<NotificationType> types = new HashSet<>();
    types.add(NotificationType.GENERAL);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<Notification>
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult =
            jpaNotificationDao
                .findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(
                    ModelConstants.SYSTEM_TENANT,
                    NotificationDeliveryMethod.WEB,
                    recipientId,
                    types,
                    pageLink);

    // Assert
    verify(recipientId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
            eq(NotificationDeliveryMethod.WEB),
            isA(UUID.class),
            isA(Set.class),
            eq(NotificationStatus.READ),
            eq("Text Search"),
            isA(Pageable.class));
    List<Notification> data =
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getData();
    assertEquals(1, data.size());
    Notification getResult = data.get(0);
    assertTrue(getResult.getAdditionalConfig() instanceof ObjectNode);
    assertEquals("Hello from the Dreaming Spires", getResult.getSubject());
    assertEquals("Text", getResult.getText());
    assertNull(getResult.getRecipientId());
    assertNull(getResult.getInfo());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(
        1L,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getTotalElements());
    assertEquals(NotificationDeliveryMethod.WEB, getResult.getDeliveryMethod());
    assertEquals(NotificationStatus.SENT, getResult.getStatus());
    assertEquals(NotificationType.GENERAL, getResult.getType());
  }

  /**
   * Test {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, Set, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, Set, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId, NotificationDeliveryMethod, UserId, Set, PageLink)"
  })
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink7() {
    // Arrange
    NotificationRepository notificationRepository = mock(NotificationRepository.class);
    when(notificationRepository.findByDeliveryMethodAndRecipientIdAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<NotificationStatus>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    JpaNotificationDao jpaNotificationDao =
        new JpaNotificationDao(notificationRepository, mock(SqlPartitioningRepository.class));
    UserId recipientId = new UserId(ModelConstants.NULL_UUID);

    // Act
    PageData<Notification>
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult =
            jpaNotificationDao
                .findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(
                    ModelConstants.SYSTEM_TENANT,
                    NotificationDeliveryMethod.WEB,
                    recipientId,
                    new HashSet<>(),
                    BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientIdAndStatusNot(
            eq(NotificationDeliveryMethod.WEB),
            isA(UUID.class),
            eq(NotificationStatus.READ),
            isNull(),
            isA(Pageable.class));
    assertEquals(
        0L,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getTotalElements());
    assertEquals(
        1,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getTotalPages());
    assertFalse(
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .hasNext());
    assertTrue(
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult
            .getData()
            .isEmpty());
  }

  /**
   * Test {@link JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}.
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)"
  })
  public void testFindByDeliveryMethodAndRecipientIdAndPageLink() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(ModelConstants.NULL_UUID);
    notificationEntity.setInfo(MissingNode.getInstance());
    notificationEntity.setRecipientId(null);
    notificationEntity.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationEntity> content = new ArrayList<>();
    content.add(notificationEntity);
    when(notificationRepository.findByDeliveryMethodAndRecipientId(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Notification> actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult =
        jpaNotificationDao.findByDeliveryMethodAndRecipientIdAndPageLink(
            ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB, recipientId, pageLink);

    // Assert
    verify(recipientId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientId(
            eq(NotificationDeliveryMethod.WEB),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<Notification> data = actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getData();
    assertEquals(1, data.size());
    Notification getResult = data.get(0);
    assertTrue(getResult.getAdditionalConfig() instanceof ObjectNode);
    assertEquals("Hello from the Dreaming Spires", getResult.getSubject());
    assertEquals("Text", getResult.getText());
    assertNull(getResult.getRecipientId());
    assertNull(getResult.getInfo());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(NotificationDeliveryMethod.WEB, getResult.getDeliveryMethod());
    assertEquals(NotificationStatus.SENT, getResult.getStatus());
    assertEquals(NotificationType.GENERAL, getResult.getType());
  }

  /**
   * Test {@link JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)"
  })
  public void testFindByDeliveryMethodAndRecipientIdAndPageLink_thenReturnDataSizeIsOne() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(ModelConstants.NULL_UUID);
    notificationEntity.setInfo(MissingNode.getInstance());
    notificationEntity.setRecipientId(ModelConstants.NULL_UUID);
    notificationEntity.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationEntity> content = new ArrayList<>();
    content.add(notificationEntity);
    when(notificationRepository.findByDeliveryMethodAndRecipientId(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Notification> actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult =
        jpaNotificationDao.findByDeliveryMethodAndRecipientIdAndPageLink(
            ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB, recipientId, pageLink);

    // Assert
    verify(recipientId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientId(
            eq(NotificationDeliveryMethod.WEB),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    List<Notification> data = actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getData();
    assertEquals(1, data.size());
    Notification getResult = data.get(0);
    assertTrue(getResult.getAdditionalConfig() instanceof ObjectNode);
    assertEquals("Hello from the Dreaming Spires", getResult.getSubject());
    assertEquals("Text", getResult.getText());
    assertNull(getResult.getInfo());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(NotificationDeliveryMethod.WEB, getResult.getDeliveryMethod());
    assertEquals(NotificationStatus.SENT, getResult.getStatus());
    assertEquals(NotificationType.GENERAL, getResult.getType());
  }

  /**
   * Test {@link JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)"
  })
  public void testFindByDeliveryMethodAndRecipientIdAndPageLink_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRepository.findByDeliveryMethodAndRecipientId(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Notification> actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult =
        jpaNotificationDao.findByDeliveryMethodAndRecipientIdAndPageLink(
            ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB,
            new UserId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientId(
            eq(NotificationDeliveryMethod.WEB), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)"
  })
  public void testFindByDeliveryMethodAndRecipientIdAndPageLink_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(notificationRepository.findByDeliveryMethodAndRecipientId(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Notification> actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult =
        jpaNotificationDao.findByDeliveryMethodAndRecipientIdAndPageLink(
            ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB,
            recipientId,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientId(
            eq(NotificationDeliveryMethod.WEB), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId,
   * NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaNotificationDao.findByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)"
  })
  public void testFindByDeliveryMethodAndRecipientIdAndPageLink_thenReturnTotalElementsIsZero3() {
    // Arrange
    when(notificationRepository.findByDeliveryMethodAndRecipientId(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Notification> actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult =
        jpaNotificationDao.findByDeliveryMethodAndRecipientIdAndPageLink(
            ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB, recipientId, pageLink);

    // Assert
    verify(recipientId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(notificationRepository)
        .findByDeliveryMethodAndRecipientId(
            eq(NotificationDeliveryMethod.WEB),
            isA(UUID.class),
            eq("Text Search"),
            isA(Pageable.class));
    assertEquals(0L, actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId,
   * NotificationStatus)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId,
   * UserId, NotificationId, NotificationStatus)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationDao.updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId, NotificationStatus)"
  })
  public void testUpdateStatusByIdAndRecipientId_givenNull_uuid_thenReturnTrue() {
    // Arrange
    when(notificationRepository.updateStatusByIdAndRecipientId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<NotificationStatus>any()))
        .thenReturn(1);

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualUpdateStatusByIdAndRecipientIdResult =
        jpaNotificationDao.updateStatusByIdAndRecipientId(
            ModelConstants.SYSTEM_TENANT,
            recipientId,
            new NotificationId(ModelConstants.NULL_UUID),
            NotificationStatus.SENT);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository)
        .updateStatusByIdAndRecipientId(
            isA(UUID.class), isA(UUID.class), eq(NotificationStatus.SENT));
    assertTrue(actualUpdateStatusByIdAndRecipientIdResult);
  }

  /**
   * Test {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId,
   * NotificationStatus)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId,
   * UserId, NotificationId, NotificationStatus)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationDao.updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId, NotificationStatus)"
  })
  public void testUpdateStatusByIdAndRecipientId_thenCallsGetId() {
    // Arrange
    when(notificationRepository.updateStatusByIdAndRecipientId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<NotificationStatus>any()))
        .thenReturn(1);

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    NotificationId notificationId = mock(NotificationId.class);
    when(notificationId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualUpdateStatusByIdAndRecipientIdResult =
        jpaNotificationDao.updateStatusByIdAndRecipientId(
            ModelConstants.SYSTEM_TENANT, recipientId, notificationId, NotificationStatus.SENT);

    // Assert
    verify(notificationId).getId();
    verify(recipientId).getId();
    verify(notificationRepository)
        .updateStatusByIdAndRecipientId(
            isA(UUID.class), isA(UUID.class), eq(NotificationStatus.SENT));
    assertTrue(actualUpdateStatusByIdAndRecipientIdResult);
  }

  /**
   * Test {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId,
   * NotificationStatus)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId,
   * UserId, NotificationId, NotificationStatus)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationDao.updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId, NotificationStatus)"
  })
  public void testUpdateStatusByIdAndRecipientId_thenReturnFalse() {
    // Arrange
    when(notificationRepository.updateStatusByIdAndRecipientId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<NotificationStatus>any()))
        .thenReturn(0);

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    NotificationId notificationId = mock(NotificationId.class);
    when(notificationId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualUpdateStatusByIdAndRecipientIdResult =
        jpaNotificationDao.updateStatusByIdAndRecipientId(
            ModelConstants.SYSTEM_TENANT, recipientId, notificationId, NotificationStatus.SENT);

    // Assert
    verify(notificationId).getId();
    verify(recipientId).getId();
    verify(notificationRepository)
        .updateStatusByIdAndRecipientId(
            isA(UUID.class), isA(UUID.class), eq(NotificationStatus.SENT));
    assertFalse(actualUpdateStatusByIdAndRecipientIdResult);
  }

  /**
   * Test {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId,
   * NotificationStatus)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId,
   * UserId, NotificationId, NotificationStatus)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationDao.updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId, NotificationStatus)"
  })
  public void testUpdateStatusByIdAndRecipientId_whenUserIdWithIdIsNull_uuid_thenReturnTrue() {
    // Arrange
    when(notificationRepository.updateStatusByIdAndRecipientId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<NotificationStatus>any()))
        .thenReturn(1);
    UserId recipientId = new UserId(ModelConstants.NULL_UUID);

    // Act
    boolean actualUpdateStatusByIdAndRecipientIdResult =
        jpaNotificationDao.updateStatusByIdAndRecipientId(
            ModelConstants.SYSTEM_TENANT,
            recipientId,
            new NotificationId(ModelConstants.NULL_UUID),
            NotificationStatus.SENT);

    // Assert
    verify(notificationRepository)
        .updateStatusByIdAndRecipientId(
            isA(UUID.class), isA(UUID.class), eq(NotificationStatus.SENT));
    assertTrue(actualUpdateStatusByIdAndRecipientIdResult);
  }

  /**
   * Test {@link JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId,
   * NotificationDeliveryMethod, UserId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId,
   * NotificationDeliveryMethod, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int JpaNotificationDao.countUnreadByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId)"
  })
  public void testCountUnreadByDeliveryMethodAndRecipientId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(notificationRepository.countByDeliveryMethodAndRecipientIdAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<NotificationStatus>any()))
        .thenReturn(1);

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    int actualCountUnreadByDeliveryMethodAndRecipientIdResult =
        jpaNotificationDao.countUnreadByDeliveryMethodAndRecipientId(
            ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB, recipientId);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository)
        .countByDeliveryMethodAndRecipientIdAndStatusNot(
            eq(NotificationDeliveryMethod.WEB), isA(UUID.class), eq(NotificationStatus.READ));
    assertEquals(1, actualCountUnreadByDeliveryMethodAndRecipientIdResult);
  }

  /**
   * Test {@link JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId,
   * NotificationDeliveryMethod, UserId)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId,
   * NotificationDeliveryMethod, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int JpaNotificationDao.countUnreadByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId)"
  })
  public void testCountUnreadByDeliveryMethodAndRecipientId_whenUserIdWithIdIsNull_uuid() {
    // Arrange
    when(notificationRepository.countByDeliveryMethodAndRecipientIdAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<NotificationStatus>any()))
        .thenReturn(1);

    // Act
    int actualCountUnreadByDeliveryMethodAndRecipientIdResult =
        jpaNotificationDao.countUnreadByDeliveryMethodAndRecipientId(
            ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB,
            new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRepository)
        .countByDeliveryMethodAndRecipientIdAndStatusNot(
            eq(NotificationDeliveryMethod.WEB), isA(UUID.class), eq(NotificationStatus.READ));
    assertEquals(1, actualCountUnreadByDeliveryMethodAndRecipientIdResult);
  }

  /**
   * Test {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId, NotificationId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId,
   * NotificationId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationDao.deleteByIdAndRecipientId(TenantId, UserId, NotificationId)"
  })
  public void testDeleteByIdAndRecipientId_givenNull_uuid_thenReturnTrue() {
    // Arrange
    when(notificationRepository.deleteByIdAndRecipientId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(1);

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualDeleteByIdAndRecipientIdResult =
        jpaNotificationDao.deleteByIdAndRecipientId(
            ModelConstants.SYSTEM_TENANT,
            recipientId,
            new NotificationId(ModelConstants.NULL_UUID));

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository).deleteByIdAndRecipientId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualDeleteByIdAndRecipientIdResult);
  }

  /**
   * Test {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId, NotificationId)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId,
   * NotificationId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationDao.deleteByIdAndRecipientId(TenantId, UserId, NotificationId)"
  })
  public void testDeleteByIdAndRecipientId_thenCallsGetId() {
    // Arrange
    when(notificationRepository.deleteByIdAndRecipientId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(1);

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    NotificationId notificationId = mock(NotificationId.class);
    when(notificationId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualDeleteByIdAndRecipientIdResult =
        jpaNotificationDao.deleteByIdAndRecipientId(
            ModelConstants.SYSTEM_TENANT, recipientId, notificationId);

    // Assert
    verify(notificationId).getId();
    verify(recipientId).getId();
    verify(notificationRepository).deleteByIdAndRecipientId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualDeleteByIdAndRecipientIdResult);
  }

  /**
   * Test {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId, NotificationId)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId,
   * NotificationId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationDao.deleteByIdAndRecipientId(TenantId, UserId, NotificationId)"
  })
  public void testDeleteByIdAndRecipientId_thenReturnFalse() {
    // Arrange
    when(notificationRepository.deleteByIdAndRecipientId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(0);

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    NotificationId notificationId = mock(NotificationId.class);
    when(notificationId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualDeleteByIdAndRecipientIdResult =
        jpaNotificationDao.deleteByIdAndRecipientId(
            ModelConstants.SYSTEM_TENANT, recipientId, notificationId);

    // Assert
    verify(notificationId).getId();
    verify(recipientId).getId();
    verify(notificationRepository).deleteByIdAndRecipientId(isA(UUID.class), isA(UUID.class));
    assertFalse(actualDeleteByIdAndRecipientIdResult);
  }

  /**
   * Test {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId, NotificationId)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId,
   * NotificationId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JpaNotificationDao.deleteByIdAndRecipientId(TenantId, UserId, NotificationId)"
  })
  public void testDeleteByIdAndRecipientId_whenUserIdWithIdIsNull_uuid_thenReturnTrue() {
    // Arrange
    when(notificationRepository.deleteByIdAndRecipientId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(1);
    UserId recipientId = new UserId(ModelConstants.NULL_UUID);

    // Act
    boolean actualDeleteByIdAndRecipientIdResult =
        jpaNotificationDao.deleteByIdAndRecipientId(
            ModelConstants.SYSTEM_TENANT,
            recipientId,
            new NotificationId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRepository).deleteByIdAndRecipientId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualDeleteByIdAndRecipientIdResult);
  }

  /**
   * Test {@link JpaNotificationDao#updateStatusByDeliveryMethodAndRecipientId(TenantId,
   * NotificationDeliveryMethod, UserId, NotificationStatus)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#updateStatusByDeliveryMethodAndRecipientId(TenantId,
   * NotificationDeliveryMethod, UserId, NotificationStatus)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int JpaNotificationDao.updateStatusByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId, NotificationStatus)"
  })
  public void testUpdateStatusByDeliveryMethodAndRecipientId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(notificationRepository.updateStatusByDeliveryMethodAndRecipientIdAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<NotificationStatus>any()))
        .thenReturn(1);

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    int actualUpdateStatusByDeliveryMethodAndRecipientIdResult =
        jpaNotificationDao.updateStatusByDeliveryMethodAndRecipientId(
            ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB,
            recipientId,
            NotificationStatus.SENT);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository)
        .updateStatusByDeliveryMethodAndRecipientIdAndStatusNot(
            eq(NotificationDeliveryMethod.WEB), isA(UUID.class), eq(NotificationStatus.SENT));
    assertEquals(1, actualUpdateStatusByDeliveryMethodAndRecipientIdResult);
  }

  /**
   * Test {@link JpaNotificationDao#updateStatusByDeliveryMethodAndRecipientId(TenantId,
   * NotificationDeliveryMethod, UserId, NotificationStatus)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JpaNotificationDao#updateStatusByDeliveryMethodAndRecipientId(TenantId,
   * NotificationDeliveryMethod, UserId, NotificationStatus)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int JpaNotificationDao.updateStatusByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId, NotificationStatus)"
  })
  public void testUpdateStatusByDeliveryMethodAndRecipientId_whenUserIdWithIdIsNull_uuid() {
    // Arrange
    when(notificationRepository.updateStatusByDeliveryMethodAndRecipientIdAndStatusNot(
            Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(),
            Mockito.<NotificationStatus>any()))
        .thenReturn(1);

    // Act
    int actualUpdateStatusByDeliveryMethodAndRecipientIdResult =
        jpaNotificationDao.updateStatusByDeliveryMethodAndRecipientId(
            ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB,
            new UserId(ModelConstants.NULL_UUID),
            NotificationStatus.SENT);

    // Assert
    verify(notificationRepository)
        .updateStatusByDeliveryMethodAndRecipientIdAndStatusNot(
            eq(NotificationDeliveryMethod.WEB), isA(UUID.class), eq(NotificationStatus.SENT));
    assertEquals(1, actualUpdateStatusByDeliveryMethodAndRecipientIdResult);
  }

  /**
   * Test {@link JpaNotificationDao#deleteByRequestId(TenantId, NotificationRequestId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link NotificationRequestId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationDao#deleteByRequestId(TenantId,
   * NotificationRequestId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaNotificationDao.deleteByRequestId(TenantId, NotificationRequestId)"})
  public void testDeleteByRequestId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(notificationRepository).deleteByRequestId(Mockito.<UUID>any());

    NotificationRequestId requestId = mock(NotificationRequestId.class);
    when(requestId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaNotificationDao.deleteByRequestId(ModelConstants.SYSTEM_TENANT, requestId);

    // Assert
    verify(requestId).getId();
    verify(notificationRepository).deleteByRequestId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationDao#deleteByRequestId(TenantId, NotificationRequestId)}.
   *
   * <ul>
   *   <li>When {@link NotificationRequestId#NotificationRequestId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationDao#deleteByRequestId(TenantId,
   * NotificationRequestId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaNotificationDao.deleteByRequestId(TenantId, NotificationRequestId)"})
  public void testDeleteByRequestId_whenNotificationRequestIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(notificationRepository).deleteByRequestId(Mockito.<UUID>any());

    // Act
    jpaNotificationDao.deleteByRequestId(
        ModelConstants.SYSTEM_TENANT, new NotificationRequestId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRepository).deleteByRequestId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationDao#deleteByRecipientId(TenantId, UserId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationDao#deleteByRecipientId(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaNotificationDao.deleteByRecipientId(TenantId, UserId)"})
  public void testDeleteByRecipientId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(notificationRepository).deleteByRecipientId(Mockito.<UUID>any());

    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaNotificationDao.deleteByRecipientId(ModelConstants.SYSTEM_TENANT, recipientId);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository).deleteByRecipientId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationDao#deleteByRecipientId(TenantId, UserId)}.
   *
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link NotificationRepository#deleteByRecipientId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaNotificationDao#deleteByRecipientId(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaNotificationDao.deleteByRecipientId(TenantId, UserId)"})
  public void testDeleteByRecipientId_whenUserIdWithIdIsNull_uuid_thenCallsDeleteByRecipientId() {
    // Arrange
    doNothing().when(notificationRepository).deleteByRecipientId(Mockito.<UUID>any());

    // Act
    jpaNotificationDao.deleteByRecipientId(
        ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRepository).deleteByRecipientId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationDao#createPartition(NotificationEntity)} with {@code
   * NotificationEntity}.
   *
   * <p>Method under test: {@link JpaNotificationDao#createPartition(NotificationEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaNotificationDao.createPartition(NotificationEntity)"})
  public void testCreatePartitionWithNotificationEntity() {
    // Arrange
    doNothing()
        .when(sqlPartitioningRepository)
        .createPartitionIfNotExists(Mockito.<String>any(), anyLong(), anyLong());

    NotificationEntity entity = new NotificationEntity();
    entity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entity.setCreatedTime(1L);
    entity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    entity.setId(ModelConstants.NULL_UUID);
    entity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entity.setRecipientId(ModelConstants.NULL_UUID);
    entity.setRequestId(ModelConstants.NULL_UUID);
    entity.setStatus(NotificationStatus.SENT);
    entity.setSubject("Hello from the Dreaming Spires");
    entity.setText("Text");
    entity.setType(NotificationType.GENERAL);
    entity.setUuid(ModelConstants.NULL_UUID);

    // Act
    jpaNotificationDao.createPartition(entity);

    // Assert
    verify(sqlPartitioningRepository).createPartitionIfNotExists("notification", 1L, 604800000L);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaNotificationDao#getEntityClass()}
   *   <li>{@link JpaNotificationDao#getEntityType()}
   *   <li>{@link JpaNotificationDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaNotificationDao.getEntityClass()",
    "EntityType JpaNotificationDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaNotificationDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationDao jpaNotificationDao =
        new JpaNotificationDao(
            mock(NotificationRepository.class), mock(SqlPartitioningRepository.class));

    // Act
    Class<NotificationEntity> actualEntityClass = jpaNotificationDao.getEntityClass();
    EntityType actualEntityType = jpaNotificationDao.getEntityType();
    jpaNotificationDao.getRepository();

    // Assert
    assertEquals(EntityType.NOTIFICATION, actualEntityType);
    Class<NotificationEntity> expectedEntityClass = NotificationEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
