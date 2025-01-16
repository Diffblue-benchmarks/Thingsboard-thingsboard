package org.thingsboard.server.dao.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.NotificationId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.notification.Notification;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationStatus;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.notification.JpaNotificationDao;
import org.thingsboard.server.dao.sql.notification.NotificationRepository;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {DefaultNotificationService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class DefaultNotificationServiceDiffblueTest {
  @Autowired
  private DefaultNotificationService defaultNotificationService;

  @MockBean
  private NotificationDao notificationDao;

  /**
   * Test
   * {@link DefaultNotificationService#saveNotification(TenantId, Notification)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationService#saveNotification(TenantId, Notification)}
   */
  @Test
  public void testSaveNotification() {
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
    when(notificationDao.save(Mockito.<TenantId>any(), Mockito.<Notification>any())).thenReturn(buildResult);

    // Act
    Notification actualSaveNotificationResult = defaultNotificationService
        .saveNotification(ModelConstants.SYSTEM_TENANT, new Notification());

    // Assert
    verify(notificationBuilder2).deliveryMethod(eq(NotificationDeliveryMethod.WEB));
    verify(notificationBuilder).info(isA(NotificationInfo.class));
    verify(notificationDao).save(isA(TenantId.class), isA(Notification.class));
    assertEquals("Hello from the Dreaming Spires", actualSaveNotificationResult.getSubject());
    assertEquals("Text", actualSaveNotificationResult.getText());
    assertNull(actualSaveNotificationResult.getAdditionalConfig());
    assertNull(actualSaveNotificationResult.getUuidId());
    assertNull(actualSaveNotificationResult.getId());
    assertNull(actualSaveNotificationResult.getRecipientId());
    assertNull(actualSaveNotificationResult.getDeliveryMethod());
    assertNull(actualSaveNotificationResult.getInfo());
    assertEquals(0L, actualSaveNotificationResult.getCreatedTime());
    assertEquals(NotificationStatus.SENT, actualSaveNotificationResult.getStatus());
    assertEquals(NotificationType.GENERAL, actualSaveNotificationResult.getType());
    assertSame(requestId, actualSaveNotificationResult.getRequestId());
  }

  /**
   * Test
   * {@link DefaultNotificationService#findNotificationById(TenantId, NotificationId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationService#findNotificationById(TenantId, NotificationId)}
   */
  @Test
  public void testFindNotificationById() {
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
    when(notificationDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(buildResult);

    // Act
    Notification actualFindNotificationByIdResult = defaultNotificationService
        .findNotificationById(ModelConstants.SYSTEM_TENANT, new NotificationId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationBuilder2).deliveryMethod(eq(NotificationDeliveryMethod.WEB));
    verify(notificationBuilder).info(isA(NotificationInfo.class));
    verify(notificationDao).findById(isA(TenantId.class), isA(UUID.class));
    assertEquals("Hello from the Dreaming Spires", actualFindNotificationByIdResult.getSubject());
    assertEquals("Text", actualFindNotificationByIdResult.getText());
    assertNull(actualFindNotificationByIdResult.getAdditionalConfig());
    assertNull(actualFindNotificationByIdResult.getUuidId());
    assertNull(actualFindNotificationByIdResult.getId());
    assertNull(actualFindNotificationByIdResult.getRecipientId());
    assertNull(actualFindNotificationByIdResult.getDeliveryMethod());
    assertNull(actualFindNotificationByIdResult.getInfo());
    assertEquals(0L, actualFindNotificationByIdResult.getCreatedTime());
    assertEquals(NotificationStatus.SENT, actualFindNotificationByIdResult.getStatus());
    assertEquals(NotificationType.GENERAL, actualFindNotificationByIdResult.getType());
    assertSame(requestId, actualFindNotificationByIdResult.getRequestId());
  }

  /**
   * Test
   * {@link DefaultNotificationService#markNotificationAsRead(TenantId, UserId, NotificationId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationService#markNotificationAsRead(TenantId, UserId, NotificationId)}
   */
  @Test
  public void testMarkNotificationAsRead_thenReturnFalse() {
    // Arrange
    when(notificationDao.updateStatusByIdAndRecipientId(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<NotificationId>any(), Mockito.<NotificationStatus>any())).thenReturn(false);

    // Act
    boolean actualMarkNotificationAsReadResult = defaultNotificationService
        .markNotificationAsRead(ModelConstants.SYSTEM_TENANT, null, new NotificationId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationDao).updateStatusByIdAndRecipientId(isA(TenantId.class), isNull(), isA(NotificationId.class),
        eq(NotificationStatus.READ));
    assertFalse(actualMarkNotificationAsReadResult);
  }

  /**
   * Test
   * {@link DefaultNotificationService#markNotificationAsRead(TenantId, UserId, NotificationId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationService#markNotificationAsRead(TenantId, UserId, NotificationId)}
   */
  @Test
  public void testMarkNotificationAsRead_thenReturnTrue() {
    // Arrange
    when(notificationDao.updateStatusByIdAndRecipientId(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<NotificationId>any(), Mockito.<NotificationStatus>any())).thenReturn(true);

    // Act
    boolean actualMarkNotificationAsReadResult = defaultNotificationService
        .markNotificationAsRead(ModelConstants.SYSTEM_TENANT, null, new NotificationId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationDao).updateStatusByIdAndRecipientId(isA(TenantId.class), isNull(), isA(NotificationId.class),
        eq(NotificationStatus.READ));
    assertTrue(actualMarkNotificationAsReadResult);
  }

  /**
   * Test
   * {@link DefaultNotificationService#markAllNotificationsAsRead(TenantId, NotificationDeliveryMethod, UserId)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationService#markAllNotificationsAsRead(TenantId, NotificationDeliveryMethod, UserId)}
   */
  @Test
  public void testMarkAllNotificationsAsRead_thenReturnOne() {
    // Arrange
    when(notificationDao.updateStatusByDeliveryMethodAndRecipientId(Mockito.<TenantId>any(),
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UserId>any(), Mockito.<NotificationStatus>any()))
        .thenReturn(1);

    // Act
    int actualMarkAllNotificationsAsReadResult = defaultNotificationService
        .markAllNotificationsAsRead(ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB, null);

    // Assert
    verify(notificationDao).updateStatusByDeliveryMethodAndRecipientId(isA(TenantId.class),
        eq(NotificationDeliveryMethod.WEB), isNull(), eq(NotificationStatus.READ));
    assertEquals(1, actualMarkAllNotificationsAsReadResult);
  }

  /**
   * Test
   * {@link DefaultNotificationService#findNotificationsByRecipientIdAndReadStatus(TenantId, NotificationDeliveryMethod, UserId, boolean, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationService#findNotificationsByRecipientIdAndReadStatus(TenantId, NotificationDeliveryMethod, UserId, boolean, PageLink)}
   */
  @Test
  public void testFindNotificationsByRecipientIdAndReadStatus() {
    // Arrange
    PageData<Notification> emptyPageDataResult = PageData.emptyPageData();
    when(notificationDao.findUnreadByDeliveryMethodAndRecipientIdAndPageLink(Mockito.<TenantId>any(),
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UserId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Notification> actualFindNotificationsByRecipientIdAndReadStatusResult = defaultNotificationService
        .findNotificationsByRecipientIdAndReadStatus(ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB, null,
            true, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationDao).findUnreadByDeliveryMethodAndRecipientIdAndPageLink(isA(TenantId.class),
        eq(NotificationDeliveryMethod.WEB), isNull(), isA(PageLink.class));
    assertSame(actualFindNotificationsByRecipientIdAndReadStatusResult.EMPTY_PAGE_DATA,
        actualFindNotificationsByRecipientIdAndReadStatusResult);
  }

  /**
   * Test
   * {@link DefaultNotificationService#findNotificationsByRecipientIdAndReadStatus(TenantId, NotificationDeliveryMethod, UserId, boolean, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationService#findNotificationsByRecipientIdAndReadStatus(TenantId, NotificationDeliveryMethod, UserId, boolean, PageLink)}
   */
  @Test
  public void testFindNotificationsByRecipientIdAndReadStatus2() {
    // Arrange
    PageData<Notification> emptyPageDataResult = PageData.emptyPageData();
    when(notificationDao.findByDeliveryMethodAndRecipientIdAndPageLink(Mockito.<TenantId>any(),
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UserId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Notification> actualFindNotificationsByRecipientIdAndReadStatusResult = defaultNotificationService
        .findNotificationsByRecipientIdAndReadStatus(ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB, null,
            false, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationDao).findByDeliveryMethodAndRecipientIdAndPageLink(isA(TenantId.class),
        eq(NotificationDeliveryMethod.WEB), isNull(), isA(PageLink.class));
    assertSame(actualFindNotificationsByRecipientIdAndReadStatusResult.EMPTY_PAGE_DATA,
        actualFindNotificationsByRecipientIdAndReadStatusResult);
  }

  /**
   * Test
   * {@link DefaultNotificationService#findLatestUnreadNotificationsByRecipientIdAndNotificationTypes(TenantId, NotificationDeliveryMethod, UserId, Set, int)}.
   * <ul>
   *   <li>Given {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationService#findLatestUnreadNotificationsByRecipientIdAndNotificationTypes(TenantId, NotificationDeliveryMethod, UserId, Set, int)}
   */
  @Test
  public void testFindLatestUnreadNotificationsByRecipientIdAndNotificationTypes_givenAlarm() {
    // Arrange
    PageData<Notification> emptyPageDataResult = PageData.emptyPageData();
    when(notificationDao.findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(
        Mockito.<TenantId>any(), Mockito.<NotificationDeliveryMethod>any(), Mockito.<UserId>any(),
        Mockito.<Set<NotificationType>>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    HashSet<NotificationType> types = new HashSet<>();
    types.add(NotificationType.ALARM);
    types.add(NotificationType.GENERAL);

    // Act
    PageData<Notification> actualFindLatestUnreadNotificationsByRecipientIdAndNotificationTypesResult = defaultNotificationService
        .findLatestUnreadNotificationsByRecipientIdAndNotificationTypes(ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB, null, types, 1);

    // Assert
    verify(notificationDao).findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(isA(TenantId.class),
        eq(NotificationDeliveryMethod.WEB), isNull(), isA(Set.class), isA(PageLink.class));
    assertSame(actualFindLatestUnreadNotificationsByRecipientIdAndNotificationTypesResult.EMPTY_PAGE_DATA,
        actualFindLatestUnreadNotificationsByRecipientIdAndNotificationTypesResult);
  }

  /**
   * Test
   * {@link DefaultNotificationService#findLatestUnreadNotificationsByRecipientIdAndNotificationTypes(TenantId, NotificationDeliveryMethod, UserId, Set, int)}.
   * <ul>
   *   <li>Given {@code GENERAL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationService#findLatestUnreadNotificationsByRecipientIdAndNotificationTypes(TenantId, NotificationDeliveryMethod, UserId, Set, int)}
   */
  @Test
  public void testFindLatestUnreadNotificationsByRecipientIdAndNotificationTypes_givenGeneral() {
    // Arrange
    PageData<Notification> emptyPageDataResult = PageData.emptyPageData();
    when(notificationDao.findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(
        Mockito.<TenantId>any(), Mockito.<NotificationDeliveryMethod>any(), Mockito.<UserId>any(),
        Mockito.<Set<NotificationType>>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    HashSet<NotificationType> types = new HashSet<>();
    types.add(NotificationType.GENERAL);

    // Act
    PageData<Notification> actualFindLatestUnreadNotificationsByRecipientIdAndNotificationTypesResult = defaultNotificationService
        .findLatestUnreadNotificationsByRecipientIdAndNotificationTypes(ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB, null, types, 1);

    // Assert
    verify(notificationDao).findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(isA(TenantId.class),
        eq(NotificationDeliveryMethod.WEB), isNull(), isA(Set.class), isA(PageLink.class));
    assertSame(actualFindLatestUnreadNotificationsByRecipientIdAndNotificationTypesResult.EMPTY_PAGE_DATA,
        actualFindLatestUnreadNotificationsByRecipientIdAndNotificationTypesResult);
  }

  /**
   * Test
   * {@link DefaultNotificationService#findLatestUnreadNotificationsByRecipientIdAndNotificationTypes(TenantId, NotificationDeliveryMethod, UserId, Set, int)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationService#findLatestUnreadNotificationsByRecipientIdAndNotificationTypes(TenantId, NotificationDeliveryMethod, UserId, Set, int)}
   */
  @Test
  public void testFindLatestUnreadNotificationsByRecipientIdAndNotificationTypes_whenHashSet() {
    // Arrange
    PageData<Notification> emptyPageDataResult = PageData.emptyPageData();
    when(notificationDao.findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(
        Mockito.<TenantId>any(), Mockito.<NotificationDeliveryMethod>any(), Mockito.<UserId>any(),
        Mockito.<Set<NotificationType>>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<Notification> actualFindLatestUnreadNotificationsByRecipientIdAndNotificationTypesResult = defaultNotificationService
        .findLatestUnreadNotificationsByRecipientIdAndNotificationTypes(ModelConstants.SYSTEM_TENANT,
            NotificationDeliveryMethod.WEB, null, new HashSet<>(), 1);

    // Assert
    verify(notificationDao).findUnreadByDeliveryMethodAndRecipientIdAndNotificationTypesAndPageLink(isA(TenantId.class),
        eq(NotificationDeliveryMethod.WEB), isNull(), isA(Set.class), isA(PageLink.class));
    assertSame(actualFindLatestUnreadNotificationsByRecipientIdAndNotificationTypesResult.EMPTY_PAGE_DATA,
        actualFindLatestUnreadNotificationsByRecipientIdAndNotificationTypesResult);
  }

  /**
   * Test
   * {@link DefaultNotificationService#countUnreadNotificationsByRecipientId(TenantId, NotificationDeliveryMethod, UserId)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationService#countUnreadNotificationsByRecipientId(TenantId, NotificationDeliveryMethod, UserId)}
   */
  @Test
  public void testCountUnreadNotificationsByRecipientId_thenReturnOne() {
    // Arrange
    when(notificationDao.countUnreadByDeliveryMethodAndRecipientId(Mockito.<TenantId>any(),
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UserId>any())).thenReturn(1);

    // Act
    int actualCountUnreadNotificationsByRecipientIdResult = defaultNotificationService
        .countUnreadNotificationsByRecipientId(ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB, null);

    // Assert
    verify(notificationDao).countUnreadByDeliveryMethodAndRecipientId(isA(TenantId.class),
        eq(NotificationDeliveryMethod.WEB), isNull());
    assertEquals(1, actualCountUnreadNotificationsByRecipientIdResult);
  }

  /**
   * Test
   * {@link DefaultNotificationService#deleteNotification(TenantId, UserId, NotificationId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationService#deleteNotification(TenantId, UserId, NotificationId)}
   */
  @Test
  public void testDeleteNotification_thenReturnFalse() {
    // Arrange
    when(notificationDao.deleteByIdAndRecipientId(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<NotificationId>any())).thenReturn(false);

    // Act
    boolean actualDeleteNotificationResult = defaultNotificationService.deleteNotification(ModelConstants.SYSTEM_TENANT,
        null, new NotificationId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationDao).deleteByIdAndRecipientId(isA(TenantId.class), isNull(), isA(NotificationId.class));
    assertFalse(actualDeleteNotificationResult);
  }

  /**
   * Test
   * {@link DefaultNotificationService#deleteNotification(TenantId, UserId, NotificationId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationService#deleteNotification(TenantId, UserId, NotificationId)}
   */
  @Test
  public void testDeleteNotification_thenReturnTrue() {
    // Arrange
    when(notificationDao.deleteByIdAndRecipientId(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<NotificationId>any())).thenReturn(true);

    // Act
    boolean actualDeleteNotificationResult = defaultNotificationService.deleteNotification(ModelConstants.SYSTEM_TENANT,
        null, new NotificationId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationDao).deleteByIdAndRecipientId(isA(TenantId.class), isNull(), isA(NotificationId.class));
    assertTrue(actualDeleteNotificationResult);
  }

  /**
   * Test {@link DefaultNotificationService#findEntity(TenantId, EntityId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity() {
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
    when(notificationDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(buildResult);

    // Act
    Optional<HasId<?>> actualFindEntityResult = defaultNotificationService.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationBuilder2).deliveryMethod(eq(NotificationDeliveryMethod.WEB));
    verify(notificationBuilder).info(isA(NotificationInfo.class));
    verify(notificationDao).findById(isA(TenantId.class), isA(UUID.class));
    HasId<?> getResult = actualFindEntityResult.get();
    assertTrue(getResult instanceof Notification);
    assertEquals("Hello from the Dreaming Spires", ((Notification) getResult).getSubject());
    assertEquals("Text", ((Notification) getResult).getText());
    assertNull(((Notification) getResult).getAdditionalConfig());
    assertNull(((Notification) getResult).getUuidId());
    assertNull(getResult.getId());
    assertNull(((Notification) getResult).getRecipientId());
    assertNull(((Notification) getResult).getDeliveryMethod());
    assertNull(((Notification) getResult).getInfo());
    assertEquals(0L, ((Notification) getResult).getCreatedTime());
    assertEquals(NotificationStatus.SENT, ((Notification) getResult).getStatus());
    assertEquals(NotificationType.GENERAL, ((Notification) getResult).getType());
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(requestId, ((Notification) getResult).getRequestId());
  }

  /**
   * Test {@link DefaultNotificationService#getEntityType()}.
   * <p>
   * Method under test: {@link DefaultNotificationService#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.NOTIFICATION,
        (new DefaultNotificationService(
            new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class))))
            .getEntityType());
  }
}
