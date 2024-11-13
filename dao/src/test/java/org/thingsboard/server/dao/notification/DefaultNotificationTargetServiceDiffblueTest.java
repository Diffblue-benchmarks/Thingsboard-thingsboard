package org.thingsboard.server.dao.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.info.RuleOriginatedNotificationInfo;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.targets.platform.PlatformUsersNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilter;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilterType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTargetDao;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRuleRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTargetRepository;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;

@ContextConfiguration(classes = {DefaultNotificationTargetService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class DefaultNotificationTargetServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private CleanUpService cleanUpService;

  @Autowired
  private DefaultNotificationTargetService defaultNotificationTargetService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private NotificationRequestDao notificationRequestDao;

  @MockBean
  private NotificationRuleDao notificationRuleDao;

  @MockBean
  private NotificationTargetDao notificationTargetDao;

  @MockBean
  private RelationService relationService;

  @MockBean
  private UserService userService;

  /**
   * Test
   * {@link DefaultNotificationTargetService#saveNotificationTarget(TenantId, NotificationTarget)}.
   * <ul>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#saveNotificationTarget(TenantId, NotificationTarget)}
   */
  @Test
  public void testSaveNotificationTarget_thenReturnNameIsNull() {
    // Arrange
    when(notificationTargetDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setId(new NotificationTargetId(ModelConstants.NULL_UUID));

    // Act
    NotificationTarget actualSaveNotificationTargetResult = defaultNotificationTargetService
        .saveNotificationTarget(ModelConstants.SYSTEM_TENANT, notificationTarget);

    // Assert
    verify(notificationTargetDao).saveAndFlush(isA(TenantId.class), isA(NotificationTarget.class));
    assertNull(actualSaveNotificationTargetResult.getName());
    assertNull(actualSaveNotificationTargetResult.getUuidId());
    assertNull(actualSaveNotificationTargetResult.getId());
    assertNull(actualSaveNotificationTargetResult.getExternalId());
    assertNull(actualSaveNotificationTargetResult.getTenantId());
    assertNull(actualSaveNotificationTargetResult.getConfiguration());
    assertEquals(0L, actualSaveNotificationTargetResult.getCreatedTime());
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#saveNotificationTarget(TenantId, NotificationTarget)}.
   * <ul>
   *   <li>Then return {@link NotificationTarget#NotificationTarget()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#saveNotificationTarget(TenantId, NotificationTarget)}
   */
  @Test
  public void testSaveNotificationTarget_thenReturnNotificationTarget() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    when(notificationTargetDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(notificationTarget);

    // Act
    NotificationTarget actualSaveNotificationTargetResult = defaultNotificationTargetService
        .saveNotificationTarget(ModelConstants.SYSTEM_TENANT, new NotificationTarget());

    // Assert
    verify(notificationTargetDao).saveAndFlush(isA(TenantId.class), isA(NotificationTarget.class));
    assertSame(notificationTarget, actualSaveNotificationTargetResult);
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#saveNotificationTarget(TenantId, NotificationTarget)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#saveNotificationTarget(TenantId, NotificationTarget)}
   */
  @Test
  public void testSaveNotificationTarget_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTargetDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenThrow(new IllegalArgumentException("uq_notification_target_name"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationTargetService
        .saveNotificationTarget(ModelConstants.SYSTEM_TENANT, new NotificationTarget()));
    verify(notificationTargetDao).saveAndFlush(isA(TenantId.class), isA(NotificationTarget.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findNotificationTargetById(TenantId, NotificationTargetId)}.
   * <ul>
   *   <li>Then return {@link NotificationTarget#NotificationTarget()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findNotificationTargetById(TenantId, NotificationTargetId)}
   */
  @Test
  public void testFindNotificationTargetById_thenReturnNotificationTarget() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(notificationTarget);

    // Act
    NotificationTarget actualFindNotificationTargetByIdResult = defaultNotificationTargetService
        .findNotificationTargetById(ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(notificationTarget, actualFindNotificationTargetByIdResult);
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findNotificationTargetById(TenantId, NotificationTargetId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findNotificationTargetById(TenantId, NotificationTargetId)}
   */
  @Test
  public void testFindNotificationTargetById_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationTargetService
        .findNotificationTargetById(ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID)));
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindNotificationTargetsByTenantId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<NotificationTarget> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTargetDao.findByTenantIdAndPageLink(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<NotificationTarget> actualFindNotificationTargetsByTenantIdResult = defaultNotificationTargetService
        .findNotificationTargetsByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTargetDao).findByTenantIdAndPageLink(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindNotificationTargetsByTenantIdResult.EMPTY_PAGE_DATA,
        actualFindNotificationTargetsByTenantIdResult);
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindNotificationTargetsByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTargetDao.findByTenantIdAndPageLink(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationTargetService
        .findNotificationTargetsByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationTargetDao).findByTenantIdAndPageLink(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndSupportedNotificationType(TenantId, NotificationType, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndSupportedNotificationType(TenantId, NotificationType, PageLink)}
   */
  @Test
  public void testFindNotificationTargetsByTenantIdAndSupportedNotificationType() {
    // Arrange
    PageData<NotificationTarget> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(Mockito.<TenantId>any(),
        Mockito.<NotificationType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<NotificationTarget> actualFindNotificationTargetsByTenantIdAndSupportedNotificationTypeResult = defaultNotificationTargetService
        .findNotificationTargetsByTenantIdAndSupportedNotificationType(ModelConstants.SYSTEM_TENANT,
            NotificationType.GENERAL, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTargetDao).findByTenantIdAndSupportedNotificationTypeAndPageLink(isA(TenantId.class),
        eq(NotificationType.GENERAL), isA(PageLink.class));
    assertSame(actualFindNotificationTargetsByTenantIdAndSupportedNotificationTypeResult.EMPTY_PAGE_DATA,
        actualFindNotificationTargetsByTenantIdAndSupportedNotificationTypeResult);
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndSupportedNotificationType(TenantId, NotificationType, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndSupportedNotificationType(TenantId, NotificationType, PageLink)}
   */
  @Test
  public void testFindNotificationTargetsByTenantIdAndSupportedNotificationType2() {
    // Arrange
    when(notificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(Mockito.<TenantId>any(),
        Mockito.<NotificationType>any(), Mockito.<PageLink>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.findNotificationTargetsByTenantIdAndSupportedNotificationType(
            ModelConstants.SYSTEM_TENANT, NotificationType.GENERAL, BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationTargetDao).findByTenantIdAndSupportedNotificationTypeAndPageLink(isA(TenantId.class),
        eq(NotificationType.GENERAL), isA(PageLink.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId, List)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId, List)}
   */
  @Test
  public void testFindNotificationTargetsByTenantIdAndIds() {
    // Arrange
    when(notificationTargetDao.findByTenantIdAndIds(Mockito.<TenantId>any(), Mockito.<List<NotificationTargetId>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<NotificationTargetId> ids = new ArrayList<>();
    ids.add(new NotificationTargetId(ModelConstants.NULL_UUID));

    // Act
    List<NotificationTarget> actualFindNotificationTargetsByTenantIdAndIdsResult = defaultNotificationTargetService
        .findNotificationTargetsByTenantIdAndIds(ModelConstants.SYSTEM_TENANT, ids);

    // Assert
    verify(notificationTargetDao).findByTenantIdAndIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindNotificationTargetsByTenantIdAndIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId, List)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId, List)}
   */
  @Test
  public void testFindNotificationTargetsByTenantIdAndIds2() {
    // Arrange
    when(notificationTargetDao.findByTenantIdAndIds(Mockito.<TenantId>any(), Mockito.<List<NotificationTargetId>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<NotificationTargetId> ids = new ArrayList<>();
    ids.add(new NotificationTargetId(ModelConstants.NULL_UUID));
    ids.add(new NotificationTargetId(ModelConstants.NULL_UUID));

    // Act
    List<NotificationTarget> actualFindNotificationTargetsByTenantIdAndIdsResult = defaultNotificationTargetService
        .findNotificationTargetsByTenantIdAndIds(ModelConstants.SYSTEM_TENANT, ids);

    // Assert
    verify(notificationTargetDao).findByTenantIdAndIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindNotificationTargetsByTenantIdAndIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId, List)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId, List)}
   */
  @Test
  public void testFindNotificationTargetsByTenantIdAndIds_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTargetDao.findByTenantIdAndIds(Mockito.<TenantId>any(), Mockito.<List<NotificationTargetId>>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationTargetService
        .findNotificationTargetsByTenantIdAndIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>()));
    verify(notificationTargetDao).findByTenantIdAndIds(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId, List)}
   */
  @Test
  public void testFindNotificationTargetsByTenantIdAndIds_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(notificationTargetDao.findByTenantIdAndIds(Mockito.<TenantId>any(), Mockito.<List<NotificationTargetId>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<NotificationTarget> actualFindNotificationTargetsByTenantIdAndIdsResult = defaultNotificationTargetService
        .findNotificationTargetsByTenantIdAndIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(notificationTargetDao).findByTenantIdAndIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindNotificationTargetsByTenantIdAndIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}
   */
  @Test
  public void testFindNotificationTargetsByTenantIdAndUsersFilterType() {
    // Arrange
    when(
        notificationTargetDao.findByTenantIdAndUsersFilterType(Mockito.<TenantId>any(), Mockito.<UsersFilterType>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationTargetService
        .findNotificationTargetsByTenantIdAndUsersFilterType(ModelConstants.SYSTEM_TENANT, UsersFilterType.USER_LIST));
    verify(notificationTargetDao).findByTenantIdAndUsersFilterType(isA(TenantId.class), eq(UsersFilterType.USER_LIST));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndUsersFilterType(TenantId, UsersFilterType)}
   */
  @Test
  public void testFindNotificationTargetsByTenantIdAndUsersFilterType_thenReturnEmpty() {
    // Arrange
    when(
        notificationTargetDao.findByTenantIdAndUsersFilterType(Mockito.<TenantId>any(), Mockito.<UsersFilterType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<NotificationTarget> actualFindNotificationTargetsByTenantIdAndUsersFilterTypeResult = defaultNotificationTargetService
        .findNotificationTargetsByTenantIdAndUsersFilterType(ModelConstants.SYSTEM_TENANT, UsersFilterType.USER_LIST);

    // Assert
    verify(notificationTargetDao).findByTenantIdAndUsersFilterType(isA(TenantId.class), eq(UsersFilterType.USER_LIST));
    assertTrue(actualFindNotificationTargetsByTenantIdAndUsersFilterTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)}
   */
  @Test
  public void testFindRecipientsForNotificationTarget() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenThrow(new IllegalArgumentException("foo"));
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = mock(
        PlatformUsersNotificationTargetConfig.class);
    when(platformUsersNotificationTargetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(platformUsersNotificationTargetConfig).setDescription(Mockito.<String>any());
    doNothing().when(platformUsersNotificationTargetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(notificationTarget);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.findRecipientsForNotificationTarget(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, new NotificationTargetId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationTarget).getConfiguration();
    verify(platformUsersNotificationTargetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(platformUsersNotificationTargetConfig).getUsersFilter();
    verify(platformUsersNotificationTargetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)}
   */
  @Test
  public void testFindRecipientsForNotificationTarget2() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.CUSTOMER_USERS);
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = mock(
        PlatformUsersNotificationTargetConfig.class);
    when(platformUsersNotificationTargetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(platformUsersNotificationTargetConfig).setDescription(Mockito.<String>any());
    doNothing().when(platformUsersNotificationTargetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(notificationTarget);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.findRecipientsForNotificationTarget(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, new NotificationTargetId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationTarget).getConfiguration();
    verify(platformUsersNotificationTargetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(platformUsersNotificationTargetConfig).getUsersFilter();
    verify(platformUsersNotificationTargetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)}
   */
  @Test
  public void testFindRecipientsForNotificationTarget3() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS);
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = mock(
        PlatformUsersNotificationTargetConfig.class);
    when(platformUsersNotificationTargetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(platformUsersNotificationTargetConfig).setDescription(Mockito.<String>any());
    doNothing().when(platformUsersNotificationTargetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(notificationTarget);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.findRecipientsForNotificationTarget(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, new NotificationTargetId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationTarget).getConfiguration();
    verify(platformUsersNotificationTargetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(platformUsersNotificationTargetConfig).getUsersFilter();
    verify(platformUsersNotificationTargetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)}
   */
  @Test
  public void testFindRecipientsForNotificationTarget4() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.SYSTEM_ADMINISTRATORS);
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = mock(
        PlatformUsersNotificationTargetConfig.class);
    when(platformUsersNotificationTargetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(platformUsersNotificationTargetConfig).setDescription(Mockito.<String>any());
    doNothing().when(platformUsersNotificationTargetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(notificationTarget);
    when(userService.findSysAdmins(Mockito.<PageLink>any())).thenThrow(new IllegalArgumentException("foo"));
    NotificationTargetId targetId = mock(NotificationTargetId.class);
    when(targetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.findRecipientsForNotificationTarget(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, targetId, BaseRelatedEdgesService.FIRST_PAGE));
    verify(targetId).getId();
    verify(notificationTarget).getConfiguration();
    verify(platformUsersNotificationTargetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(platformUsersNotificationTargetConfig).getUsersFilter();
    verify(platformUsersNotificationTargetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findSysAdmins(isA(PageLink.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)}
   */
  @Test
  public void testFindRecipientsForNotificationTarget5() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.ALL_USERS);
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = mock(
        PlatformUsersNotificationTargetConfig.class);
    when(platformUsersNotificationTargetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(platformUsersNotificationTargetConfig).setDescription(Mockito.<String>any());
    doNothing().when(platformUsersNotificationTargetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(notificationTarget);
    when(userService.findAllUsers(Mockito.<PageLink>any())).thenThrow(new IllegalArgumentException("foo"));
    NotificationTargetId targetId = mock(NotificationTargetId.class);
    when(targetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.findRecipientsForNotificationTarget(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, targetId, BaseRelatedEdgesService.FIRST_PAGE));
    verify(targetId).getId();
    verify(notificationTarget).getConfiguration();
    verify(platformUsersNotificationTargetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(platformUsersNotificationTargetConfig).getUsersFilter();
    verify(platformUsersNotificationTargetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findAllUsers(isA(PageLink.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)}
   */
  @Test
  public void testFindRecipientsForNotificationTarget_thenReturnEmpty_page_data() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.SYSTEM_ADMINISTRATORS);
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = mock(
        PlatformUsersNotificationTargetConfig.class);
    when(platformUsersNotificationTargetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(platformUsersNotificationTargetConfig).setDescription(Mockito.<String>any());
    doNothing().when(platformUsersNotificationTargetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(notificationTarget);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findSysAdmins(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    NotificationTargetId targetId = mock(NotificationTargetId.class);
    when(targetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<User> actualFindRecipientsForNotificationTargetResult = defaultNotificationTargetService
        .findRecipientsForNotificationTarget(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, targetId,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(targetId).getId();
    verify(notificationTarget).getConfiguration();
    verify(platformUsersNotificationTargetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(platformUsersNotificationTargetConfig).getUsersFilter();
    verify(platformUsersNotificationTargetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findSysAdmins(isA(PageLink.class));
    assertSame(actualFindRecipientsForNotificationTargetResult.EMPTY_PAGE_DATA,
        actualFindRecipientsForNotificationTargetResult);
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)}
   */
  @Test
  public void testFindRecipientsForNotificationTarget_thenReturnEmpty_page_data2() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.ALL_USERS);
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = mock(
        PlatformUsersNotificationTargetConfig.class);
    when(platformUsersNotificationTargetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(platformUsersNotificationTargetConfig).setDescription(Mockito.<String>any());
    doNothing().when(platformUsersNotificationTargetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(notificationTarget);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findAllUsers(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    NotificationTargetId targetId = mock(NotificationTargetId.class);
    when(targetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<User> actualFindRecipientsForNotificationTargetResult = defaultNotificationTargetService
        .findRecipientsForNotificationTarget(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, targetId,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(targetId).getId();
    verify(notificationTarget).getConfiguration();
    verify(platformUsersNotificationTargetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(platformUsersNotificationTargetConfig).getUsersFilter();
    verify(platformUsersNotificationTargetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findAllUsers(isA(PageLink.class));
    assertSame(actualFindRecipientsForNotificationTargetResult.EMPTY_PAGE_DATA,
        actualFindRecipientsForNotificationTargetResult);
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  public void testFindRecipientsForNotificationTargetConfig() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenThrow(new IllegalArgumentException("foo"));
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(ModelConstants.SYSTEM_TENANT,
            targetConfig, BaseRelatedEdgesService.FIRST_PAGE));
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  public void testFindRecipientsForNotificationTargetConfig2() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.CUSTOMER_USERS);
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(ModelConstants.SYSTEM_TENANT,
            targetConfig, BaseRelatedEdgesService.FIRST_PAGE));
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  public void testFindRecipientsForNotificationTargetConfig3() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS);
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(ModelConstants.SYSTEM_TENANT,
            targetConfig, BaseRelatedEdgesService.FIRST_PAGE));
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  public void testFindRecipientsForNotificationTargetConfig4() {
    // Arrange
    when(userService.findSysAdmins(Mockito.<PageLink>any())).thenThrow(new IllegalArgumentException("foo"));
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.SYSTEM_ADMINISTRATORS);
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(ModelConstants.SYSTEM_TENANT,
            targetConfig, BaseRelatedEdgesService.FIRST_PAGE));
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    verify(userService).findSysAdmins(isA(PageLink.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  public void testFindRecipientsForNotificationTargetConfig5() {
    // Arrange
    when(userService.findAllUsers(Mockito.<PageLink>any())).thenThrow(new IllegalArgumentException("foo"));
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.ALL_USERS);
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(ModelConstants.SYSTEM_TENANT,
            targetConfig, BaseRelatedEdgesService.FIRST_PAGE));
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    verify(userService).findAllUsers(isA(PageLink.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  public void testFindRecipientsForNotificationTargetConfig_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findSysAdmins(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.SYSTEM_ADMINISTRATORS);
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act
    PageData<User> actualFindRecipientsForNotificationTargetConfigResult = defaultNotificationTargetService
        .findRecipientsForNotificationTargetConfig(ModelConstants.SYSTEM_TENANT, targetConfig,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    verify(userService).findSysAdmins(isA(PageLink.class));
    assertSame(actualFindRecipientsForNotificationTargetConfigResult.EMPTY_PAGE_DATA,
        actualFindRecipientsForNotificationTargetConfigResult);
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  public void testFindRecipientsForNotificationTargetConfig_thenReturnEmpty_page_data2() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findAllUsers(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.ALL_USERS);
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act
    PageData<User> actualFindRecipientsForNotificationTargetConfigResult = defaultNotificationTargetService
        .findRecipientsForNotificationTargetConfig(ModelConstants.SYSTEM_TENANT, targetConfig,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    verify(userService).findAllUsers(isA(PageLink.class));
    assertSame(actualFindRecipientsForNotificationTargetConfigResult.EMPTY_PAGE_DATA,
        actualFindRecipientsForNotificationTargetConfigResult);
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  public void testFindRecipientsForRuleNotificationTargetConfig() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);

    PlatformUsersNotificationTargetConfig targetConfig = new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, mock(RuleOriginatedNotificationInfo.class),
            BaseRelatedEdgesService.FIRST_PAGE));
    verify(usersFilter).getType();
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  public void testFindRecipientsForRuleNotificationTargetConfig2() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenThrow(new IllegalArgumentException("foo"));
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, mock(RuleOriginatedNotificationInfo.class),
            BaseRelatedEdgesService.FIRST_PAGE));
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  public void testFindRecipientsForRuleNotificationTargetConfig3() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS);
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);
    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedTenantId()).thenReturn(null);

    // Act
    PageData<User> actualFindRecipientsForRuleNotificationTargetConfigResult = defaultNotificationTargetService
        .findRecipientsForRuleNotificationTargetConfig(ModelConstants.SYSTEM_TENANT, targetConfig, info,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(info).getAffectedTenantId();
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    assertEquals(actualFindRecipientsForRuleNotificationTargetConfigResult.EMPTY_PAGE_DATA,
        actualFindRecipientsForRuleNotificationTargetConfigResult);
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  public void testFindRecipientsForRuleNotificationTargetConfig4() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS);
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);
    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedTenantId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, info, BaseRelatedEdgesService.FIRST_PAGE));
    verify(info).getAffectedTenantId();
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  public void testFindRecipientsForRuleNotificationTargetConfig5() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.ORIGINATOR_ENTITY_OWNER_USERS);
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);
    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedCustomerId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, info, BaseRelatedEdgesService.FIRST_PAGE));
    verify(info).getAffectedCustomerId();
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  public void testFindRecipientsForRuleNotificationTargetConfig6() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findTenantAdmins(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.ORIGINATOR_ENTITY_OWNER_USERS);
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);
    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedCustomerId()).thenReturn(null);

    // Act
    PageData<User> actualFindRecipientsForRuleNotificationTargetConfigResult = defaultNotificationTargetService
        .findRecipientsForRuleNotificationTargetConfig(ModelConstants.SYSTEM_TENANT, targetConfig, info,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(info).getAffectedCustomerId();
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    verify(userService).findTenantAdmins(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindRecipientsForRuleNotificationTargetConfigResult.EMPTY_PAGE_DATA,
        actualFindRecipientsForRuleNotificationTargetConfigResult);
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  public void testFindRecipientsForRuleNotificationTargetConfig7() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.AFFECTED_USER);
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);
    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedUserId()).thenReturn(null);

    // Act
    PageData<User> actualFindRecipientsForRuleNotificationTargetConfigResult = defaultNotificationTargetService
        .findRecipientsForRuleNotificationTargetConfig(ModelConstants.SYSTEM_TENANT, targetConfig, info,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(info).getAffectedUserId();
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    assertEquals(actualFindRecipientsForRuleNotificationTargetConfigResult.EMPTY_PAGE_DATA,
        actualFindRecipientsForRuleNotificationTargetConfigResult);
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   * <ul>
   *   <li>Then calls {@link UserService#findTenantAdmins(TenantId, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  public void testFindRecipientsForRuleNotificationTargetConfig_thenCallsFindTenantAdmins() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findTenantAdmins(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.ORIGINATOR_ENTITY_OWNER_USERS);
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);
    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    PageData<User> actualFindRecipientsForRuleNotificationTargetConfigResult = defaultNotificationTargetService
        .findRecipientsForRuleNotificationTargetConfig(ModelConstants.SYSTEM_TENANT, targetConfig, info,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(info).getAffectedCustomerId();
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    verify(userService).findTenantAdmins(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindRecipientsForRuleNotificationTargetConfigResult.EMPTY_PAGE_DATA,
        actualFindRecipientsForRuleNotificationTargetConfigResult);
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   * <ul>
   *   <li>Then calls
   * {@link RuleOriginatedNotificationInfo#getAffectedTenantId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  public void testFindRecipientsForRuleNotificationTargetConfig_thenCallsGetAffectedTenantId() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS);
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);
    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<User> actualFindRecipientsForRuleNotificationTargetConfigResult = defaultNotificationTargetService
        .findRecipientsForRuleNotificationTargetConfig(ModelConstants.SYSTEM_TENANT, targetConfig, info,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(info).getAffectedTenantId();
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    assertEquals(actualFindRecipientsForRuleNotificationTargetConfigResult.EMPTY_PAGE_DATA,
        actualFindRecipientsForRuleNotificationTargetConfigResult);
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  public void testFindRecipientsForRuleNotificationTargetConfig_thenReturnDataSizeIsOne() {
    // Arrange
    User user = new User();
    when(userService.findUserById(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(user);
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);
    UsersFilter usersFilter2 = mock(UsersFilter.class);
    when(usersFilter2.getType()).thenReturn(UsersFilterType.AFFECTED_USER);
    PlatformUsersNotificationTargetConfig targetConfig = mock(PlatformUsersNotificationTargetConfig.class);
    when(targetConfig.getUsersFilter()).thenReturn(usersFilter2);
    doNothing().when(targetConfig).setDescription(Mockito.<String>any());
    doNothing().when(targetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);
    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act
    PageData<User> actualFindRecipientsForRuleNotificationTargetConfigResult = defaultNotificationTargetService
        .findRecipientsForRuleNotificationTargetConfig(ModelConstants.SYSTEM_TENANT, targetConfig, info,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(info).getAffectedUserId();
    verify(targetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(targetConfig).getUsersFilter();
    verify(targetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter2).getType();
    verify(userService).findUserById(isA(TenantId.class), isA(UserId.class));
    List<User> data = actualFindRecipientsForRuleNotificationTargetConfigResult.getData();
    assertEquals(1, data.size());
    assertEquals(1, actualFindRecipientsForRuleNotificationTargetConfigResult.getTotalPages());
    assertEquals(1L, actualFindRecipientsForRuleNotificationTargetConfigResult.getTotalElements());
    assertSame(user, data.get(0));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#deleteNotificationTargetById(TenantId, NotificationTargetId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#deleteNotificationTargetById(TenantId, NotificationTargetId)}
   */
  @Test
  public void testDeleteNotificationTargetById() {
    // Arrange
    when(notificationRequestDao.existsByTenantIdAndStatusAndTargetId(Mockito.<TenantId>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<NotificationTargetId>any())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.deleteNotificationTargetById(ModelConstants.SYSTEM_TENANT,
            new NotificationTargetId(ModelConstants.NULL_UUID)));
    verify(notificationRequestDao).existsByTenantIdAndStatusAndTargetId(isA(TenantId.class),
        eq(NotificationRequestStatus.SCHEDULED), isA(NotificationTargetId.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#deleteNotificationTargetById(TenantId, NotificationTargetId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#deleteNotificationTargetById(TenantId, NotificationTargetId)}
   */
  @Test
  public void testDeleteNotificationTargetById2() {
    // Arrange
    when(notificationRequestDao.existsByTenantIdAndStatusAndTargetId(Mockito.<TenantId>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<NotificationTargetId>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.deleteNotificationTargetById(ModelConstants.SYSTEM_TENANT,
            new NotificationTargetId(ModelConstants.NULL_UUID)));
    verify(notificationRequestDao).existsByTenantIdAndStatusAndTargetId(isA(TenantId.class),
        eq(NotificationRequestStatus.SCHEDULED), isA(NotificationTargetId.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#deleteNotificationTargetById(TenantId, NotificationTargetId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#deleteNotificationTargetById(TenantId, NotificationTargetId)}
   */
  @Test
  public void testDeleteNotificationTargetById3() {
    // Arrange
    when(notificationRequestDao.existsByTenantIdAndStatusAndTargetId(Mockito.<TenantId>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<NotificationTargetId>any())).thenReturn(false);
    when(notificationRuleDao.existsByTenantIdAndTargetId(Mockito.<TenantId>any(), Mockito.<NotificationTargetId>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.deleteNotificationTargetById(ModelConstants.SYSTEM_TENANT,
            new NotificationTargetId(ModelConstants.NULL_UUID)));
    verify(notificationRequestDao).existsByTenantIdAndStatusAndTargetId(isA(TenantId.class),
        eq(NotificationRequestStatus.SCHEDULED), isA(NotificationTargetId.class));
    verify(notificationRuleDao).existsByTenantIdAndTargetId(isA(TenantId.class), isA(NotificationTargetId.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#deleteNotificationTargetById(TenantId, NotificationTargetId)}.
   * <ul>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#deleteNotificationTargetById(TenantId, NotificationTargetId)}
   */
  @Test
  public void testDeleteNotificationTargetById_thenCallsRemoveById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(notificationTargetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(notificationRequestDao.existsByTenantIdAndStatusAndTargetId(Mockito.<TenantId>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<NotificationTargetId>any())).thenReturn(false);
    when(notificationRuleDao.existsByTenantIdAndTargetId(Mockito.<TenantId>any(), Mockito.<NotificationTargetId>any()))
        .thenReturn(false);

    // Act
    defaultNotificationTargetService.deleteNotificationTargetById(ModelConstants.SYSTEM_TENANT,
        new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationTargetDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(notificationRequestDao).existsByTenantIdAndStatusAndTargetId(isA(TenantId.class),
        eq(NotificationRequestStatus.SCHEDULED), isA(NotificationTargetId.class));
    verify(notificationRuleDao).existsByTenantIdAndTargetId(isA(TenantId.class), isA(NotificationTargetId.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Then calls
   * {@link NotificationRuleRepository#existsByTenantIdAndRecipientsConfigContaining(UUID, String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_thenCallsExistsByTenantIdAndRecipientsConfigContaining() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRequestRepository notificationRequestRepository = mock(NotificationRequestRepository.class);
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTargetsContaining(Mockito.<UUID>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<String>any())).thenReturn(false);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(notificationRequestRepository);
    NotificationRuleRepository notificationRuleRepository = mock(NotificationRuleRepository.class);
    when(notificationRuleRepository.existsByTenantIdAndRecipientsConfigContaining(Mockito.<UUID>any(),
        Mockito.<String>any())).thenReturn(true);
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(notificationRuleRepository);
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService defaultNotificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationTargetService
        .deleteEntity(ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID), false));
    verify(notificationRequestRepository).existsByTenantIdAndStatusAndTargetsContaining(isA(UUID.class),
        eq(NotificationRequestStatus.SCHEDULED), eq("13814000-1dd2-11b2-8080-808080808080"));
    verify(notificationRuleRepository).existsByTenantIdAndRecipientsConfigContaining(isA(UUID.class),
        eq("13814000-1dd2-11b2-8080-808080808080"));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRequestRepository notificationRequestRepository = mock(NotificationRequestRepository.class);
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTargetsContaining(Mockito.<UUID>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<String>any())).thenReturn(true);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(notificationRequestRepository);
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService defaultNotificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationTargetService
        .deleteEntity(ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID), false));
    verify(notificationRequestRepository).existsByTenantIdAndStatusAndTargetsContaining(isA(UUID.class),
        eq(NotificationRequestStatus.SCHEDULED), eq("13814000-1dd2-11b2-8080-808080808080"));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#deleteNotificationTargetsByTenantId(TenantId)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#deleteNotificationTargetsByTenantId(TenantId)}
   */
  @Test
  public void testDeleteNotificationTargetsByTenantId() {
    // Arrange
    doNothing().when(notificationTargetDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationTargetService.deleteNotificationTargetsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(notificationTargetDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#deleteNotificationTargetsByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#deleteNotificationTargetsByTenantId(TenantId)}
   */
  @Test
  public void testDeleteNotificationTargetsByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(notificationTargetDao).removeByTenantId(Mockito.<TenantId>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.deleteNotificationTargetsByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(notificationTargetDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link NotificationTargetDao}
   * {@link NotificationTargetDao#removeByTenantId(TenantId)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_givenNotificationTargetDaoRemoveByTenantIdDoesNothing() {
    // Arrange
    doNothing().when(notificationTargetDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationTargetService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(notificationTargetDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(notificationTargetDao).removeByTenantId(Mockito.<TenantId>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(notificationTargetDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#countNotificationTargetsByTenantId(TenantId)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#countNotificationTargetsByTenantId(TenantId)}
   */
  @Test
  public void testCountNotificationTargetsByTenantId_thenReturnOne() {
    // Arrange
    when(notificationTargetDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualCountNotificationTargetsByTenantIdResult = defaultNotificationTargetService
        .countNotificationTargetsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTargetDao).countByTenantId(isA(TenantId.class));
    assertEquals(1L, actualCountNotificationTargetsByTenantIdResult);
  }

  /**
   * Test
   * {@link DefaultNotificationTargetService#countNotificationTargetsByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#countNotificationTargetsByTenantId(TenantId)}
   */
  @Test
  public void testCountNotificationTargetsByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTargetDao.countByTenantId(Mockito.<TenantId>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTargetService.countNotificationTargetsByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(notificationTargetDao).countByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_thenReturnPresent() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(notificationTarget);

    // Act
    Optional<HasId<?>> actualFindEntityResult = defaultNotificationTargetService
        .findEntity(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(notificationTarget, actualFindEntityResult.get());
  }

  /**
   * Test {@link DefaultNotificationTargetService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationTargetService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationTargetService
        .findEntity(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#getEntityType()}.
   * <p>
   * Method under test: {@link DefaultNotificationTargetService#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act and Assert
    assertEquals(EntityType.NOTIFICATION_TARGET,
        (new DefaultNotificationTargetService(notificationTargetDao, notificationRequestDao, notificationRuleDao,
            new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
                securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
                new JpaExecutorService())))
            .getEntityType());
  }
}
