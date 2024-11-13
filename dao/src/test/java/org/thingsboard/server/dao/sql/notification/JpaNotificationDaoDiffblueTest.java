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
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.thingsboard.server.common.data.id.NotificationId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.notification.Notification;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationStatus;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
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
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaNotificationDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaNotificationDao jpaNotificationDao;

  @MockBean
  private NotificationRepository notificationRepository;

  @MockBean
  private SqlPartitioningRepository sqlPartitioningRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndPageLink() {
    // Arrange
    when(
        notificationRepository.findByDeliveryMethodAndRecipientIdAndStatusNot(Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(), Mockito.<NotificationStatus>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Notification> actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult = jpaNotificationDao
        .findUnreadByDeliveryMethodAndRecipientIdAndPageLink(ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB, new UserId(ModelConstants.NULL_UUID), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRepository).findByDeliveryMethodAndRecipientIdAndStatusNot(eq(NotificationDeliveryMethod.WEB),
        isA(UUID.class), eq(NotificationStatus.READ), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.hasNext());
    assertTrue(actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndPageLink2() {
    // Arrange
    when(
        notificationRepository.findByDeliveryMethodAndRecipientIdAndStatusNot(Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(), Mockito.<NotificationStatus>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Notification> actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult = jpaNotificationDao
        .findUnreadByDeliveryMethodAndRecipientIdAndPageLink(ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB, recipientId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository).findByDeliveryMethodAndRecipientIdAndStatusNot(eq(NotificationDeliveryMethod.WEB),
        isA(UUID.class), eq(NotificationStatus.READ), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.hasNext());
    assertTrue(actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}.
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndPageLink_thenCallsGetPage() {
    // Arrange
    when(
        notificationRepository.findByDeliveryMethodAndRecipientIdAndStatusNot(Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(), Mockito.<NotificationStatus>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Notification> actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult = jpaNotificationDao
        .findUnreadByDeliveryMethodAndRecipientIdAndPageLink(ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB, recipientId, pageLink);

    // Assert
    verify(recipientId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRepository).findByDeliveryMethodAndRecipientIdAndStatusNot(eq(NotificationDeliveryMethod.WEB),
        isA(UUID.class), eq(NotificationStatus.READ), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.hasNext());
    assertTrue(actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndPageLink_thenReturnDataSizeIsOne() {
    // Arrange
    Notification.NotificationBuilder notificationBuilder = mock(Notification.NotificationBuilder.class);
    when(notificationBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(Notification.builder());
    Notification.NotificationBuilder notificationBuilder2 = mock(Notification.NotificationBuilder.class);
    when(notificationBuilder2.deliveryMethod(Mockito.<NotificationDeliveryMethod>any()))
        .thenReturn(notificationBuilder);
    Notification.NotificationBuilder recipientIdResult = notificationBuilder2
        .deliveryMethod(NotificationDeliveryMethod.WEB)
        .info(mock(NotificationInfo.class))
        .recipientId(null);
    NotificationRequestId requestId = new NotificationRequestId(ModelConstants.NULL_UUID);
    Notification buildResult = recipientIdResult.requestId(requestId)
        .status(NotificationStatus.SENT)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    NotificationEntity notificationEntity = mock(NotificationEntity.class);
    when(notificationEntity.toData()).thenReturn(buildResult);
    doNothing().when(notificationEntity).setCreatedTime(anyLong());
    doNothing().when(notificationEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationEntity).setDeliveryMethod(Mockito.<NotificationDeliveryMethod>any());
    doNothing().when(notificationEntity).setInfo(Mockito.<JsonNode>any());
    doNothing().when(notificationEntity).setRecipientId(Mockito.<UUID>any());
    doNothing().when(notificationEntity).setRequestId(Mockito.<UUID>any());
    doNothing().when(notificationEntity).setStatus(Mockito.<NotificationStatus>any());
    doNothing().when(notificationEntity).setSubject(Mockito.<String>any());
    doNothing().when(notificationEntity).setText(Mockito.<String>any());
    doNothing().when(notificationEntity).setType(Mockito.<NotificationType>any());
    notificationEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(ModelConstants.NULL_UUID);
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(ModelConstants.NULL_UUID);
    notificationEntity.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity.setStatus(NotificationStatus.READ);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationEntity> content = new ArrayList<>();
    content.add(notificationEntity);
    PageImpl<NotificationEntity> pageImpl = new PageImpl<>(content);
    when(
        notificationRepository.findByDeliveryMethodAndRecipientIdAndStatusNot(Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(), Mockito.<NotificationStatus>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Notification> actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult = jpaNotificationDao
        .findUnreadByDeliveryMethodAndRecipientIdAndPageLink(ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB, recipientId, pageLink);

    // Assert
    verify(recipientId).getId();
    verify(notificationBuilder2).deliveryMethod(eq(NotificationDeliveryMethod.WEB));
    verify(notificationBuilder).info(isA(NotificationInfo.class));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationEntity).setCreatedTime(eq(1L));
    verify(notificationEntity).setId(isA(UUID.class));
    verify(notificationEntity).setUuid(isA(UUID.class));
    verify(notificationEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationEntity).setDeliveryMethod(eq(NotificationDeliveryMethod.WEB));
    verify(notificationEntity).setInfo(isA(JsonNode.class));
    verify(notificationEntity).setRecipientId(isA(UUID.class));
    verify(notificationEntity).setRequestId(isA(UUID.class));
    verify(notificationEntity).setStatus(eq(NotificationStatus.READ));
    verify(notificationEntity).setSubject(eq("Hello from the Dreaming Spires"));
    verify(notificationEntity).setText(eq("Text"));
    verify(notificationEntity).setType(eq(NotificationType.GENERAL));
    verify(notificationEntity).toData();
    verify(notificationRepository).findByDeliveryMethodAndRecipientIdAndStatusNot(eq(NotificationDeliveryMethod.WEB),
        isA(UUID.class), eq(NotificationStatus.READ), eq("Text Search"), isA(Pageable.class));
    List<Notification> data = actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getData();
    assertEquals(1, data.size());
    Notification getResult = data.get(0);
    assertEquals("Hello from the Dreaming Spires", getResult.getSubject());
    assertEquals("Text", getResult.getText());
    assertNull(getResult.getAdditionalConfig());
    assertNull(getResult.getUuidId());
    assertNull(getResult.getId());
    assertNull(getResult.getRecipientId());
    assertNull(getResult.getDeliveryMethod());
    assertNull(getResult.getInfo());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1L, actualFindUnreadByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(NotificationStatus.SENT, getResult.getStatus());
    assertEquals(NotificationType.GENERAL, getResult.getType());
    assertSame(requestId, getResult.getRequestId());
  }

  /**
   * Test
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId, NotificationDeliveryMethod, UserId, Set, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId, NotificationDeliveryMethod, UserId, Set, PageLink)}
   */
  @Test
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink() {
    // Arrange
    when(
        notificationRepository.findByDeliveryMethodAndRecipientIdAndStatusNot(Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(), Mockito.<NotificationStatus>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId recipientId = new UserId(ModelConstants.NULL_UUID);

    // Act
    PageData<Notification> actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult = jpaNotificationDao
        .findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB, recipientId, new HashSet<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRepository).findByDeliveryMethodAndRecipientIdAndStatusNot(eq(NotificationDeliveryMethod.WEB),
        isA(UUID.class), eq(NotificationStatus.READ), isNull(), isA(Pageable.class));
    assertEquals(0L,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.getTotalElements());
    assertEquals(1,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.getTotalPages());
    assertFalse(actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.hasNext());
    assertTrue(actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId, NotificationDeliveryMethod, UserId, Set, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId, NotificationDeliveryMethod, UserId, Set, PageLink)}
   */
  @Test
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink2() {
    // Arrange
    when(
        notificationRepository.findByDeliveryMethodAndRecipientIdAndStatusNot(Mockito.<NotificationDeliveryMethod>any(),
            Mockito.<UUID>any(), Mockito.<NotificationStatus>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Notification> actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult = jpaNotificationDao
        .findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB, recipientId, new HashSet<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository).findByDeliveryMethodAndRecipientIdAndStatusNot(eq(NotificationDeliveryMethod.WEB),
        isA(UUID.class), eq(NotificationStatus.READ), isNull(), isA(Pageable.class));
    assertEquals(0L,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.getTotalElements());
    assertEquals(1,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.getTotalPages());
    assertFalse(actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.hasNext());
    assertTrue(actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId, NotificationDeliveryMethod, UserId, Set, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId, NotificationDeliveryMethod, UserId, Set, PageLink)}
   */
  @Test
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink3() {
    // Arrange
    when(notificationRepository.findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UUID>any(), Mockito.<Set<NotificationType>>any(),
        Mockito.<NotificationStatus>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    HashSet<NotificationType> types = new HashSet<>();
    types.add(NotificationType.GENERAL);

    // Act
    PageData<Notification> actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult = jpaNotificationDao
        .findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB, recipientId, types, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository).findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
        eq(NotificationDeliveryMethod.WEB), isA(UUID.class), isA(Set.class), eq(NotificationStatus.READ), isNull(),
        isA(Pageable.class));
    assertEquals(0L,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.getTotalElements());
    assertEquals(1,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.getTotalPages());
    assertFalse(actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.hasNext());
    assertTrue(actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId, NotificationDeliveryMethod, UserId, Set, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(TenantId, NotificationDeliveryMethod, UserId, Set, PageLink)}
   */
  @Test
  public void testFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink4() {
    // Arrange
    when(notificationRepository.findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UUID>any(), Mockito.<Set<NotificationType>>any(),
        Mockito.<NotificationStatus>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    HashSet<NotificationType> types = new HashSet<>();
    types.add(NotificationType.GENERAL);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Notification> actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult = jpaNotificationDao
        .findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB, recipientId, types, pageLink);

    // Assert
    verify(recipientId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRepository).findByDeliveryMethodAndRecipientIdAndTypeInAndStatusNot(
        eq(NotificationDeliveryMethod.WEB), isA(UUID.class), isA(Set.class), eq(NotificationStatus.READ),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.getTotalElements());
    assertEquals(1,
        actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.getTotalPages());
    assertFalse(actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.hasNext());
    assertTrue(actualFindUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  public void testFindByDeliveryMethodAndRecipientIdAndPageLink_givenOne_thenCallsGetPage() {
    // Arrange
    when(notificationRepository.findByDeliveryMethodAndRecipientId(Mockito.<NotificationDeliveryMethod>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Notification> actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult = jpaNotificationDao
        .findByDeliveryMethodAndRecipientIdAndPageLink(ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB,
            recipientId, pageLink);

    // Assert
    verify(recipientId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationRepository).findByDeliveryMethodAndRecipientId(eq(NotificationDeliveryMethod.WEB),
        isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  public void testFindByDeliveryMethodAndRecipientIdAndPageLink_thenReturnDataSizeIsOne() {
    // Arrange
    Notification.NotificationBuilder notificationBuilder = mock(Notification.NotificationBuilder.class);
    when(notificationBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(Notification.builder());
    Notification.NotificationBuilder notificationBuilder2 = mock(Notification.NotificationBuilder.class);
    when(notificationBuilder2.deliveryMethod(Mockito.<NotificationDeliveryMethod>any()))
        .thenReturn(notificationBuilder);
    Notification.NotificationBuilder recipientIdResult = notificationBuilder2
        .deliveryMethod(NotificationDeliveryMethod.WEB)
        .info(mock(NotificationInfo.class))
        .recipientId(null);
    NotificationRequestId requestId = new NotificationRequestId(ModelConstants.NULL_UUID);
    Notification buildResult = recipientIdResult.requestId(requestId)
        .status(NotificationStatus.SENT)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();
    NotificationEntity notificationEntity = mock(NotificationEntity.class);
    when(notificationEntity.toData()).thenReturn(buildResult);
    doNothing().when(notificationEntity).setCreatedTime(anyLong());
    doNothing().when(notificationEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationEntity).setDeliveryMethod(Mockito.<NotificationDeliveryMethod>any());
    doNothing().when(notificationEntity).setInfo(Mockito.<JsonNode>any());
    doNothing().when(notificationEntity).setRecipientId(Mockito.<UUID>any());
    doNothing().when(notificationEntity).setRequestId(Mockito.<UUID>any());
    doNothing().when(notificationEntity).setStatus(Mockito.<NotificationStatus>any());
    doNothing().when(notificationEntity).setSubject(Mockito.<String>any());
    doNothing().when(notificationEntity).setText(Mockito.<String>any());
    doNothing().when(notificationEntity).setType(Mockito.<NotificationType>any());
    notificationEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(ModelConstants.NULL_UUID);
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(ModelConstants.NULL_UUID);
    notificationEntity.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity.setStatus(NotificationStatus.READ);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<NotificationEntity> content = new ArrayList<>();
    content.add(notificationEntity);
    PageImpl<NotificationEntity> pageImpl = new PageImpl<>(content);
    when(notificationRepository.findByDeliveryMethodAndRecipientId(Mockito.<NotificationDeliveryMethod>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Notification> actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult = jpaNotificationDao
        .findByDeliveryMethodAndRecipientIdAndPageLink(ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB,
            recipientId, pageLink);

    // Assert
    verify(recipientId).getId();
    verify(notificationBuilder2).deliveryMethod(eq(NotificationDeliveryMethod.WEB));
    verify(notificationBuilder).info(isA(NotificationInfo.class));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(notificationEntity).setCreatedTime(eq(1L));
    verify(notificationEntity).setId(isA(UUID.class));
    verify(notificationEntity).setUuid(isA(UUID.class));
    verify(notificationEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationEntity).setDeliveryMethod(eq(NotificationDeliveryMethod.WEB));
    verify(notificationEntity).setInfo(isA(JsonNode.class));
    verify(notificationEntity).setRecipientId(isA(UUID.class));
    verify(notificationEntity).setRequestId(isA(UUID.class));
    verify(notificationEntity).setStatus(eq(NotificationStatus.READ));
    verify(notificationEntity).setSubject(eq("Hello from the Dreaming Spires"));
    verify(notificationEntity).setText(eq("Text"));
    verify(notificationEntity).setType(eq(NotificationType.GENERAL));
    verify(notificationEntity).toData();
    verify(notificationRepository).findByDeliveryMethodAndRecipientId(eq(NotificationDeliveryMethod.WEB),
        isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Notification> data = actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getData();
    assertEquals(1, data.size());
    Notification getResult = data.get(0);
    assertEquals("Hello from the Dreaming Spires", getResult.getSubject());
    assertEquals("Text", getResult.getText());
    assertNull(getResult.getAdditionalConfig());
    assertNull(getResult.getUuidId());
    assertNull(getResult.getId());
    assertNull(getResult.getRecipientId());
    assertNull(getResult.getDeliveryMethod());
    assertNull(getResult.getInfo());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(NotificationStatus.SENT, getResult.getStatus());
    assertEquals(NotificationType.GENERAL, getResult.getType());
    assertSame(requestId, getResult.getRequestId());
  }

  /**
   * Test
   * {@link JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  public void testFindByDeliveryMethodAndRecipientIdAndPageLink_thenReturnTotalElementsIsZero() {
    // Arrange
    when(notificationRepository.findByDeliveryMethodAndRecipientId(Mockito.<NotificationDeliveryMethod>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Notification> actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult = jpaNotificationDao
        .findByDeliveryMethodAndRecipientIdAndPageLink(ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB,
            new UserId(ModelConstants.NULL_UUID), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationRepository).findByDeliveryMethodAndRecipientId(eq(NotificationDeliveryMethod.WEB),
        isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#findByDeliveryMethodAndRecipientIdAndPageLink(TenantId, NotificationDeliveryMethod, UserId, PageLink)}
   */
  @Test
  public void testFindByDeliveryMethodAndRecipientIdAndPageLink_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(notificationRepository.findByDeliveryMethodAndRecipientId(Mockito.<NotificationDeliveryMethod>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Notification> actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult = jpaNotificationDao
        .findByDeliveryMethodAndRecipientIdAndPageLink(ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB,
            recipientId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository).findByDeliveryMethodAndRecipientId(eq(NotificationDeliveryMethod.WEB),
        isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalElements());
    assertEquals(1, actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getTotalPages());
    assertFalse(actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.hasNext());
    assertTrue(actualFindByDeliveryMethodAndRecipientIdAndPageLinkResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId, NotificationStatus)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId, NotificationStatus)}
   */
  @Test
  public void testUpdateStatusByIdAndRecipientId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(notificationRepository.updateStatusByIdAndRecipientId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<NotificationStatus>any())).thenReturn(1);
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualUpdateStatusByIdAndRecipientIdResult = jpaNotificationDao.updateStatusByIdAndRecipientId(
        ModelConstants.SYSTEM_TENANT, recipientId, new NotificationId(ModelConstants.NULL_UUID),
        NotificationStatus.SENT);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository).updateStatusByIdAndRecipientId(isA(UUID.class), isA(UUID.class),
        eq(NotificationStatus.SENT));
    assertTrue(actualUpdateStatusByIdAndRecipientIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId, NotificationStatus)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId, NotificationStatus)}
   */
  @Test
  public void testUpdateStatusByIdAndRecipientId_thenReturnFalse() {
    // Arrange
    when(notificationRepository.updateStatusByIdAndRecipientId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<NotificationStatus>any())).thenReturn(0);
    UserId recipientId = new UserId(ModelConstants.NULL_UUID);

    // Act
    boolean actualUpdateStatusByIdAndRecipientIdResult = jpaNotificationDao.updateStatusByIdAndRecipientId(
        ModelConstants.SYSTEM_TENANT, recipientId, new NotificationId(ModelConstants.NULL_UUID),
        NotificationStatus.SENT);

    // Assert
    verify(notificationRepository).updateStatusByIdAndRecipientId(isA(UUID.class), isA(UUID.class),
        eq(NotificationStatus.SENT));
    assertFalse(actualUpdateStatusByIdAndRecipientIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId, NotificationStatus)}.
   * <ul>
   *   <li>When {@link NotificationId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId, NotificationStatus)}
   */
  @Test
  public void testUpdateStatusByIdAndRecipientId_whenNotificationIdGetIdReturnNull_uuid() {
    // Arrange
    when(notificationRepository.updateStatusByIdAndRecipientId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<NotificationStatus>any())).thenReturn(1);
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);
    NotificationId notificationId = mock(NotificationId.class);
    when(notificationId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualUpdateStatusByIdAndRecipientIdResult = jpaNotificationDao.updateStatusByIdAndRecipientId(
        ModelConstants.SYSTEM_TENANT, recipientId, notificationId, NotificationStatus.SENT);

    // Assert
    verify(notificationId).getId();
    verify(recipientId).getId();
    verify(notificationRepository).updateStatusByIdAndRecipientId(isA(UUID.class), isA(UUID.class),
        eq(NotificationStatus.SENT));
    assertTrue(actualUpdateStatusByIdAndRecipientIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId, NotificationStatus)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#updateStatusByIdAndRecipientId(TenantId, UserId, NotificationId, NotificationStatus)}
   */
  @Test
  public void testUpdateStatusByIdAndRecipientId_whenUserIdWithIdIsNull_uuid_thenReturnTrue() {
    // Arrange
    when(notificationRepository.updateStatusByIdAndRecipientId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<NotificationStatus>any())).thenReturn(1);
    UserId recipientId = new UserId(ModelConstants.NULL_UUID);

    // Act
    boolean actualUpdateStatusByIdAndRecipientIdResult = jpaNotificationDao.updateStatusByIdAndRecipientId(
        ModelConstants.SYSTEM_TENANT, recipientId, new NotificationId(ModelConstants.NULL_UUID),
        NotificationStatus.SENT);

    // Assert
    verify(notificationRepository).updateStatusByIdAndRecipientId(isA(UUID.class), isA(UUID.class),
        eq(NotificationStatus.SENT));
    assertTrue(actualUpdateStatusByIdAndRecipientIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId)}
   */
  @Test
  public void testCountUnreadByDeliveryMethodAndRecipientId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(notificationRepository.countByDeliveryMethodAndRecipientIdAndStatusNot(
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UUID>any(), Mockito.<NotificationStatus>any()))
        .thenReturn(1);
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    int actualCountUnreadByDeliveryMethodAndRecipientIdResult = jpaNotificationDao
        .countUnreadByDeliveryMethodAndRecipientId(ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB,
            recipientId);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository).countByDeliveryMethodAndRecipientIdAndStatusNot(eq(NotificationDeliveryMethod.WEB),
        isA(UUID.class), eq(NotificationStatus.READ));
    assertEquals(1, actualCountUnreadByDeliveryMethodAndRecipientIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId)}
   */
  @Test
  public void testCountUnreadByDeliveryMethodAndRecipientId_whenUserIdWithIdIsNull_uuid() {
    // Arrange
    when(notificationRepository.countByDeliveryMethodAndRecipientIdAndStatusNot(
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UUID>any(), Mockito.<NotificationStatus>any()))
        .thenReturn(1);

    // Act
    int actualCountUnreadByDeliveryMethodAndRecipientIdResult = jpaNotificationDao
        .countUnreadByDeliveryMethodAndRecipientId(ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB,
            new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRepository).countByDeliveryMethodAndRecipientIdAndStatusNot(eq(NotificationDeliveryMethod.WEB),
        isA(UUID.class), eq(NotificationStatus.READ));
    assertEquals(1, actualCountUnreadByDeliveryMethodAndRecipientIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId, NotificationId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId, NotificationId)}
   */
  @Test
  public void testDeleteByIdAndRecipientId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(notificationRepository.deleteByIdAndRecipientId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(1);
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualDeleteByIdAndRecipientIdResult = jpaNotificationDao.deleteByIdAndRecipientId(
        ModelConstants.SYSTEM_TENANT, recipientId, new NotificationId(ModelConstants.NULL_UUID));

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository).deleteByIdAndRecipientId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualDeleteByIdAndRecipientIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId, NotificationId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId, NotificationId)}
   */
  @Test
  public void testDeleteByIdAndRecipientId_thenReturnFalse() {
    // Arrange
    when(notificationRepository.deleteByIdAndRecipientId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(0);
    UserId recipientId = new UserId(ModelConstants.NULL_UUID);

    // Act
    boolean actualDeleteByIdAndRecipientIdResult = jpaNotificationDao.deleteByIdAndRecipientId(
        ModelConstants.SYSTEM_TENANT, recipientId, new NotificationId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRepository).deleteByIdAndRecipientId(isA(UUID.class), isA(UUID.class));
    assertFalse(actualDeleteByIdAndRecipientIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId, NotificationId)}.
   * <ul>
   *   <li>When {@link NotificationId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId, NotificationId)}
   */
  @Test
  public void testDeleteByIdAndRecipientId_whenNotificationIdGetIdReturnNull_uuid() {
    // Arrange
    when(notificationRepository.deleteByIdAndRecipientId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(1);
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);
    NotificationId notificationId = mock(NotificationId.class);
    when(notificationId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualDeleteByIdAndRecipientIdResult = jpaNotificationDao
        .deleteByIdAndRecipientId(ModelConstants.SYSTEM_TENANT, recipientId, notificationId);

    // Assert
    verify(notificationId).getId();
    verify(recipientId).getId();
    verify(notificationRepository).deleteByIdAndRecipientId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualDeleteByIdAndRecipientIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId, NotificationId)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#deleteByIdAndRecipientId(TenantId, UserId, NotificationId)}
   */
  @Test
  public void testDeleteByIdAndRecipientId_whenUserIdWithIdIsNull_uuid_thenReturnTrue() {
    // Arrange
    when(notificationRepository.deleteByIdAndRecipientId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(1);
    UserId recipientId = new UserId(ModelConstants.NULL_UUID);

    // Act
    boolean actualDeleteByIdAndRecipientIdResult = jpaNotificationDao.deleteByIdAndRecipientId(
        ModelConstants.SYSTEM_TENANT, recipientId, new NotificationId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationRepository).deleteByIdAndRecipientId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualDeleteByIdAndRecipientIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationDao#updateStatusByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId, NotificationStatus)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#updateStatusByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId, NotificationStatus)}
   */
  @Test
  public void testUpdateStatusByDeliveryMethodAndRecipientId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(notificationRepository.updateStatusByDeliveryMethodAndRecipientIdAndStatusNot(
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UUID>any(), Mockito.<NotificationStatus>any()))
        .thenReturn(1);
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    int actualUpdateStatusByDeliveryMethodAndRecipientIdResult = jpaNotificationDao
        .updateStatusByDeliveryMethodAndRecipientId(ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB,
            recipientId, NotificationStatus.SENT);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository).updateStatusByDeliveryMethodAndRecipientIdAndStatusNot(
        eq(NotificationDeliveryMethod.WEB), isA(UUID.class), eq(NotificationStatus.SENT));
    assertEquals(1, actualUpdateStatusByDeliveryMethodAndRecipientIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationDao#updateStatusByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId, NotificationStatus)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#updateStatusByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId, NotificationStatus)}
   */
  @Test
  public void testUpdateStatusByDeliveryMethodAndRecipientId_whenUserIdWithIdIsNull_uuid() {
    // Arrange
    when(notificationRepository.updateStatusByDeliveryMethodAndRecipientIdAndStatusNot(
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UUID>any(), Mockito.<NotificationStatus>any()))
        .thenReturn(1);

    // Act
    int actualUpdateStatusByDeliveryMethodAndRecipientIdResult = jpaNotificationDao
        .updateStatusByDeliveryMethodAndRecipientId(ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB,
            new UserId(ModelConstants.NULL_UUID), NotificationStatus.SENT);

    // Assert
    verify(notificationRepository).updateStatusByDeliveryMethodAndRecipientIdAndStatusNot(
        eq(NotificationDeliveryMethod.WEB), isA(UUID.class), eq(NotificationStatus.SENT));
    assertEquals(1, actualUpdateStatusByDeliveryMethodAndRecipientIdResult);
  }

  /**
   * Test
   * {@link JpaNotificationDao#deleteByRequestId(TenantId, NotificationRequestId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#deleteByRequestId(TenantId, NotificationRequestId)}
   */
  @Test
  public void testDeleteByRequestId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(notificationRepository).deleteByRequestId(Mockito.<UUID>any());
    NotificationRequestId requestId = mock(NotificationRequestId.class);
    when(requestId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaNotificationDao.deleteByRequestId(ModelConstants.SYSTEM_TENANT, requestId);

    // Assert that nothing has changed
    verify(requestId).getId();
    verify(notificationRepository).deleteByRequestId(isA(UUID.class));
  }

  /**
   * Test
   * {@link JpaNotificationDao#deleteByRequestId(TenantId, NotificationRequestId)}.
   * <ul>
   *   <li>When {@link NotificationRequestId#NotificationRequestId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#deleteByRequestId(TenantId, NotificationRequestId)}
   */
  @Test
  public void testDeleteByRequestId_whenNotificationRequestIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(notificationRepository).deleteByRequestId(Mockito.<UUID>any());

    // Act
    jpaNotificationDao.deleteByRequestId(ModelConstants.SYSTEM_TENANT,
        new NotificationRequestId(ModelConstants.NULL_UUID));

    // Assert that nothing has changed
    verify(notificationRepository).deleteByRequestId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationDao#deleteByRecipientId(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#deleteByRecipientId(TenantId, UserId)}
   */
  @Test
  public void testDeleteByRecipientId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(notificationRepository).deleteByRecipientId(Mockito.<UUID>any());
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaNotificationDao.deleteByRecipientId(ModelConstants.SYSTEM_TENANT, recipientId);

    // Assert that nothing has changed
    verify(recipientId).getId();
    verify(notificationRepository).deleteByRecipientId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationDao#deleteByRecipientId(TenantId, UserId)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link NotificationRepository#deleteByRecipientId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#deleteByRecipientId(TenantId, UserId)}
   */
  @Test
  public void testDeleteByRecipientId_whenUserIdWithIdIsNull_uuid_thenCallsDeleteByRecipientId() {
    // Arrange
    doNothing().when(notificationRepository).deleteByRecipientId(Mockito.<UUID>any());

    // Act
    jpaNotificationDao.deleteByRecipientId(ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID));

    // Assert that nothing has changed
    verify(notificationRepository).deleteByRecipientId(isA(UUID.class));
  }

  /**
   * Test {@link JpaNotificationDao#createPartition(NotificationEntity)} with
   * {@code NotificationEntity}.
   * <p>
   * Method under test:
   * {@link JpaNotificationDao#createPartition(NotificationEntity)}
   */
  @Test
  public void testCreatePartitionWithNotificationEntity() {
    // Arrange
    doNothing().when(sqlPartitioningRepository).createPartitionIfNotExists(Mockito.<String>any(), anyLong(), anyLong());

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

    // Assert that nothing has changed
    verify(sqlPartitioningRepository).createPartitionIfNotExists(eq("notification"), eq(1L), eq(604800000L));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaNotificationDao#getEntityClass()}
   *   <li>{@link JpaNotificationDao#getEntityType()}
   *   <li>{@link JpaNotificationDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationDao jpaNotificationDao = new JpaNotificationDao(mock(NotificationRepository.class),
        mock(SqlPartitioningRepository.class));

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
