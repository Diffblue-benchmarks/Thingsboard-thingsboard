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
package org.thingsboard.server.dao.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.info.RuleOriginatedNotificationInfo;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.targets.NotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.platform.CustomerUsersFilter;
import org.thingsboard.server.common.data.notification.targets.platform.PlatformUsersNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.platform.TenantAdministratorsFilter;
import org.thingsboard.server.common.data.notification.targets.platform.UserListFilter;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilter;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilterType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.security.Authority;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
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
import org.thingsboard.server.dao.user.UserDao;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;

@ContextConfiguration(classes = {DefaultNotificationTargetService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultNotificationTargetServiceDiffblueTest {
  @MockBean private CleanUpService cleanUpService;

  @Autowired private DefaultNotificationTargetService defaultNotificationTargetService;

  @MockBean private NotificationRequestDao notificationRequestDao;

  @MockBean private NotificationRuleDao notificationRuleDao;

  @MockBean private NotificationTargetDao notificationTargetDao;

  @MockBean private UserService userService;

  /**
   * Test {@link DefaultNotificationTargetService#saveNotificationTarget(TenantId,
   * NotificationTarget)}.
   *
   * <ul>
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTargetService#saveNotificationTarget(TenantId,
   * NotificationTarget)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget DefaultNotificationTargetService.saveNotificationTarget(TenantId, NotificationTarget)"
  })
  public void testSaveNotificationTarget_thenReturnNameIsNull() {
    // Arrange
    when(notificationTargetDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(new NotificationTarget());

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setId(new NotificationTargetId(ModelConstants.NULL_UUID));

    // Act
    NotificationTarget actualSaveNotificationTargetResult =
        defaultNotificationTargetService.saveNotificationTarget(
            ModelConstants.SYSTEM_TENANT, notificationTarget);

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
   * Test {@link DefaultNotificationTargetService#saveNotificationTarget(TenantId,
   * NotificationTarget)}.
   *
   * <ul>
   *   <li>Then return {@link NotificationTarget#NotificationTarget()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTargetService#saveNotificationTarget(TenantId,
   * NotificationTarget)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget DefaultNotificationTargetService.saveNotificationTarget(TenantId, NotificationTarget)"
  })
  public void testSaveNotificationTarget_thenReturnNotificationTarget() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    when(notificationTargetDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenReturn(notificationTarget);

    // Act
    NotificationTarget actualSaveNotificationTargetResult =
        defaultNotificationTargetService.saveNotificationTarget(
            ModelConstants.SYSTEM_TENANT, new NotificationTarget());

    // Assert
    verify(notificationTargetDao).saveAndFlush(isA(TenantId.class), isA(NotificationTarget.class));
    assertSame(notificationTarget, actualSaveNotificationTargetResult);
  }

  /**
   * Test {@link DefaultNotificationTargetService#saveNotificationTarget(TenantId,
   * NotificationTarget)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTargetService#saveNotificationTarget(TenantId,
   * NotificationTarget)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget DefaultNotificationTargetService.saveNotificationTarget(TenantId, NotificationTarget)"
  })
  public void testSaveNotificationTarget_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTargetDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<NotificationTarget>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.saveNotificationTarget(
                ModelConstants.SYSTEM_TENANT, new NotificationTarget()));
    verify(notificationTargetDao).saveAndFlush(isA(TenantId.class), isA(NotificationTarget.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#findNotificationTargetById(TenantId,
   * NotificationTargetId)}.
   *
   * <ul>
   *   <li>Then return {@link NotificationTarget#NotificationTarget()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findNotificationTargetById(TenantId, NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget DefaultNotificationTargetService.findNotificationTargetById(TenantId, NotificationTargetId)"
  })
  public void testFindNotificationTargetById_thenReturnNotificationTarget() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTarget);

    // Act
    NotificationTarget actualFindNotificationTargetByIdResult =
        defaultNotificationTargetService.findNotificationTargetById(
            ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(notificationTarget, actualFindNotificationTargetByIdResult);
  }

  /**
   * Test {@link DefaultNotificationTargetService#findNotificationTargetById(TenantId,
   * NotificationTargetId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findNotificationTargetById(TenantId, NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget DefaultNotificationTargetService.findNotificationTargetById(TenantId, NotificationTargetId)"
  })
  public void testFindNotificationTargetById_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findNotificationTargetById(
                ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID)));
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#findNotificationTargetsByTenantId(TenantId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findNotificationTargetsByTenantId(TenantId, PageLink)"
  })
  public void testFindNotificationTargetsByTenantId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<NotificationTarget> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTargetDao.findByTenantIdAndPageLink(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<NotificationTarget> actualFindNotificationTargetsByTenantIdResult =
        defaultNotificationTargetService.findNotificationTargetsByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTargetDao)
        .findByTenantIdAndPageLink(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindNotificationTargetsByTenantIdResult);
  }

  /**
   * Test {@link DefaultNotificationTargetService#findNotificationTargetsByTenantId(TenantId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findNotificationTargetsByTenantId(TenantId, PageLink)"
  })
  public void testFindNotificationTargetsByTenantId_thenReturnTotalElementsIsZero() {
    // Arrange
    NotificationTargetRepository notificationTargetRepository =
        mock(NotificationTargetRepository.class);
    when(notificationTargetRepository.findByTenantIdAndSearchText(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(notificationTargetRepository);
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    DefaultNotificationTargetService defaultNotificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);

    // Act
    PageData<NotificationTarget> actualFindNotificationTargetsByTenantIdResult =
        defaultNotificationTargetService.findNotificationTargetsByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchText(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindNotificationTargetsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindNotificationTargetsByTenantIdResult.getTotalPages());
    assertFalse(actualFindNotificationTargetsByTenantIdResult.hasNext());
    assertTrue(actualFindNotificationTargetsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link DefaultNotificationTargetService#findNotificationTargetsByTenantId(TenantId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findNotificationTargetsByTenantId(TenantId, PageLink)"
  })
  public void testFindNotificationTargetsByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTargetDao.findByTenantIdAndPageLink(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findNotificationTargetsByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationTargetDao)
        .findByTenantIdAndPageLink(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndSupportedNotificationType(TenantId,
   * NotificationType, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndSupportedNotificationType(TenantId,
   * NotificationType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findNotificationTargetsByTenantIdAndSupportedNotificationType(TenantId, NotificationType, PageLink)"
  })
  public void testFindNotificationTargetsByTenantIdAndSupportedNotificationType() {
    // Arrange
    PageData<NotificationTarget> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(
            Mockito.<TenantId>any(), Mockito.<NotificationType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<NotificationTarget>
        actualFindNotificationTargetsByTenantIdAndSupportedNotificationTypeResult =
            defaultNotificationTargetService
                .findNotificationTargetsByTenantIdAndSupportedNotificationType(
                    ModelConstants.SYSTEM_TENANT,
                    NotificationType.GENERAL,
                    BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTargetDao)
        .findByTenantIdAndSupportedNotificationTypeAndPageLink(
            isA(TenantId.class), eq(NotificationType.GENERAL), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA,
        actualFindNotificationTargetsByTenantIdAndSupportedNotificationTypeResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndSupportedNotificationType(TenantId,
   * NotificationType, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndSupportedNotificationType(TenantId,
   * NotificationType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findNotificationTargetsByTenantIdAndSupportedNotificationType(TenantId, NotificationType, PageLink)"
  })
  public void testFindNotificationTargetsByTenantIdAndSupportedNotificationType2() {
    // Arrange
    when(notificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(
            Mockito.<TenantId>any(), Mockito.<NotificationType>any(), Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService
                .findNotificationTargetsByTenantIdAndSupportedNotificationType(
                    ModelConstants.SYSTEM_TENANT,
                    NotificationType.GENERAL,
                    BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationTargetDao)
        .findByTenantIdAndSupportedNotificationTypeAndPageLink(
            isA(TenantId.class), eq(NotificationType.GENERAL), isA(PageLink.class));
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndSupportedNotificationType(TenantId,
   * NotificationType, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndSupportedNotificationType(TenantId,
   * NotificationType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findNotificationTargetsByTenantIdAndSupportedNotificationType(TenantId, NotificationType, PageLink)"
  })
  public void testFindNotificationTargetsByTenantIdAndSupportedNotificationType3() {
    // Arrange
    NotificationTargetRepository notificationTargetRepository =
        mock(NotificationTargetRepository.class);
    when(notificationTargetRepository.findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<List<String>>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(notificationTargetRepository);
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    DefaultNotificationTargetService defaultNotificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);

    // Act
    PageData<NotificationTarget>
        actualFindNotificationTargetsByTenantIdAndSupportedNotificationTypeResult =
            defaultNotificationTargetService
                .findNotificationTargetsByTenantIdAndSupportedNotificationType(
                    ModelConstants.SYSTEM_TENANT,
                    NotificationType.GENERAL,
                    BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTargetRepository)
        .findByTenantIdAndSearchTextAndUsersFilterTypeIfPresent(
            isA(UUID.class), isNull(), isA(List.class), isA(Pageable.class));
    assertEquals(
        0L,
        actualFindNotificationTargetsByTenantIdAndSupportedNotificationTypeResult
            .getTotalElements());
    assertEquals(
        1,
        actualFindNotificationTargetsByTenantIdAndSupportedNotificationTypeResult.getTotalPages());
    assertFalse(
        actualFindNotificationTargetsByTenantIdAndSupportedNotificationTypeResult.hasNext());
    assertTrue(
        actualFindNotificationTargetsByTenantIdAndSupportedNotificationTypeResult
            .getData()
            .isEmpty());
  }

  /**
   * Test {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId,
   * List)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DefaultNotificationTargetService.findNotificationTargetsByTenantIdAndIds(TenantId, List)"
  })
  public void testFindNotificationTargetsByTenantIdAndIds() {
    // Arrange
    when(notificationTargetDao.findByTenantIdAndIds(
            Mockito.<TenantId>any(), Mockito.<List<NotificationTargetId>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<NotificationTargetId> ids = new ArrayList<>();
    ids.add(new NotificationTargetId(ModelConstants.NULL_UUID));

    // Act
    List<NotificationTarget> actualFindNotificationTargetsByTenantIdAndIdsResult =
        defaultNotificationTargetService.findNotificationTargetsByTenantIdAndIds(
            ModelConstants.SYSTEM_TENANT, ids);

    // Assert
    verify(notificationTargetDao).findByTenantIdAndIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindNotificationTargetsByTenantIdAndIdsResult.isEmpty());
  }

  /**
   * Test {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId,
   * List)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DefaultNotificationTargetService.findNotificationTargetsByTenantIdAndIds(TenantId, List)"
  })
  public void testFindNotificationTargetsByTenantIdAndIds2() {
    // Arrange
    when(notificationTargetDao.findByTenantIdAndIds(
            Mockito.<TenantId>any(), Mockito.<List<NotificationTargetId>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<NotificationTargetId> ids = new ArrayList<>();
    ids.add(new NotificationTargetId(ModelConstants.NULL_UUID));
    ids.add(new NotificationTargetId(ModelConstants.NULL_UUID));

    // Act
    List<NotificationTarget> actualFindNotificationTargetsByTenantIdAndIdsResult =
        defaultNotificationTargetService.findNotificationTargetsByTenantIdAndIds(
            ModelConstants.SYSTEM_TENANT, ids);

    // Assert
    verify(notificationTargetDao).findByTenantIdAndIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindNotificationTargetsByTenantIdAndIdsResult.isEmpty());
  }

  /**
   * Test {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId,
   * List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DefaultNotificationTargetService.findNotificationTargetsByTenantIdAndIds(TenantId, List)"
  })
  public void testFindNotificationTargetsByTenantIdAndIds_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTargetDao.findByTenantIdAndIds(
            Mockito.<TenantId>any(), Mockito.<List<NotificationTargetId>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findNotificationTargetsByTenantIdAndIds(
                ModelConstants.SYSTEM_TENANT, new ArrayList<>()));
    verify(notificationTargetDao).findByTenantIdAndIds(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DefaultNotificationTargetService.findNotificationTargetsByTenantIdAndIds(TenantId, List)"
  })
  public void testFindNotificationTargetsByTenantIdAndIds_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(notificationTargetDao.findByTenantIdAndIds(
            Mockito.<TenantId>any(), Mockito.<List<NotificationTargetId>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<NotificationTarget> actualFindNotificationTargetsByTenantIdAndIdsResult =
        defaultNotificationTargetService.findNotificationTargetsByTenantIdAndIds(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(notificationTargetDao).findByTenantIdAndIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindNotificationTargetsByTenantIdAndIdsResult.isEmpty());
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndUsersFilterType(TenantId,
   * UsersFilterType)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndUsersFilterType(TenantId,
   * UsersFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DefaultNotificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(TenantId, UsersFilterType)"
  })
  public void testFindNotificationTargetsByTenantIdAndUsersFilterType() {
    // Arrange
    when(notificationTargetDao.findByTenantIdAndUsersFilterType(
            Mockito.<TenantId>any(), Mockito.<UsersFilterType>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(
                ModelConstants.SYSTEM_TENANT, UsersFilterType.USER_LIST));
    verify(notificationTargetDao)
        .findByTenantIdAndUsersFilterType(isA(TenantId.class), eq(UsersFilterType.USER_LIST));
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndUsersFilterType(TenantId,
   * UsersFilterType)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findNotificationTargetsByTenantIdAndUsersFilterType(TenantId,
   * UsersFilterType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DefaultNotificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(TenantId, UsersFilterType)"
  })
  public void testFindNotificationTargetsByTenantIdAndUsersFilterType_thenReturnEmpty() {
    // Arrange
    when(notificationTargetDao.findByTenantIdAndUsersFilterType(
            Mockito.<TenantId>any(), Mockito.<UsersFilterType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<NotificationTarget> actualFindNotificationTargetsByTenantIdAndUsersFilterTypeResult =
        defaultNotificationTargetService.findNotificationTargetsByTenantIdAndUsersFilterType(
            ModelConstants.SYSTEM_TENANT, UsersFilterType.USER_LIST);

    // Assert
    verify(notificationTargetDao)
        .findByTenantIdAndUsersFilterType(isA(TenantId.class), eq(UsersFilterType.USER_LIST));
    assertTrue(actualFindNotificationTargetsByTenantIdAndUsersFilterTypeResult.isEmpty());
  }

  /**
   * Test {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId,
   * CustomerId, NotificationTargetId, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId,
   * NotificationTargetId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)"
  })
  public void testFindRecipientsForNotificationTarget() {
    // Arrange
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForNotificationTarget(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new NotificationTargetId(ModelConstants.NULL_UUID),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId,
   * CustomerId, NotificationTargetId, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId,
   * NotificationTargetId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)"
  })
  public void testFindRecipientsForNotificationTarget2() {
    // Arrange
    CustomerUsersFilter usersFilter = new CustomerUsersFilter();
    usersFilter.setCustomerId(ModelConstants.NULL_UUID);

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTarget);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForNotificationTarget(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new NotificationTargetId(ModelConstants.NULL_UUID),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationTarget).getConfiguration();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId,
   * CustomerId, NotificationTargetId, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId,
   * NotificationTargetId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)"
  })
  public void testFindRecipientsForNotificationTarget3() {
    // Arrange
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenThrow(new IllegalArgumentException());
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTarget);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForNotificationTarget(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new NotificationTargetId(ModelConstants.NULL_UUID),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationTarget).getConfiguration();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId,
   * CustomerId, NotificationTargetId, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId,
   * NotificationTargetId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)"
  })
  public void testFindRecipientsForNotificationTarget4() {
    // Arrange
    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantProfilesIds(new HashSet<>());
    usersFilter.setTenantsIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTarget);
    when(userService.findAllTenantAdmins(Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForNotificationTarget(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new NotificationTargetId(ModelConstants.NULL_UUID),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationTarget).getConfiguration();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findAllTenantAdmins(isA(PageLink.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId,
   * CustomerId, NotificationTargetId, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId,
   * NotificationTargetId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)"
  })
  public void testFindRecipientsForNotificationTarget5() {
    // Arrange
    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantProfilesIds(new HashSet<>());
    usersFilter.setTenantsIds(null);

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTarget);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findAllTenantAdmins(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindRecipientsForNotificationTargetResult =
        defaultNotificationTargetService.findRecipientsForNotificationTarget(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new NotificationTargetId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTarget).getConfiguration();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findAllTenantAdmins(isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRecipientsForNotificationTargetResult);
  }

  /**
   * Test {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId,
   * CustomerId, NotificationTargetId, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId,
   * NotificationTargetId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)"
  })
  public void testFindRecipientsForNotificationTarget6() {
    // Arrange
    HashSet<UUID> tenantProfilesIds = new HashSet<>();
    tenantProfilesIds.add(ModelConstants.NULL_UUID);

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantProfilesIds(tenantProfilesIds);
    usersFilter.setTenantsIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTarget);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findTenantAdminsByTenantProfilesIds(
            Mockito.<List<TenantProfileId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindRecipientsForNotificationTargetResult =
        defaultNotificationTargetService.findRecipientsForNotificationTarget(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new NotificationTargetId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTarget).getConfiguration();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findTenantAdminsByTenantProfilesIds(isA(List.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRecipientsForNotificationTargetResult);
  }

  /**
   * Test {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId,
   * CustomerId, NotificationTargetId, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId,
   * NotificationTargetId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)"
  })
  public void testFindRecipientsForNotificationTarget7() {
    // Arrange
    HashSet<UUID> tenantProfilesIds = new HashSet<>();
    tenantProfilesIds.add(ModelConstants.NULL_UUID);

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantProfilesIds(tenantProfilesIds);
    usersFilter.setTenantsIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTarget);
    when(userService.findTenantAdminsByTenantProfilesIds(
            Mockito.<List<TenantProfileId>>any(), Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForNotificationTarget(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new NotificationTargetId(ModelConstants.NULL_UUID),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationTarget).getConfiguration();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findTenantAdminsByTenantProfilesIds(isA(List.class), isA(PageLink.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId,
   * CustomerId, NotificationTargetId, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId,
   * NotificationTargetId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)"
  })
  public void testFindRecipientsForNotificationTarget8() {
    // Arrange
    HashSet<UUID> tenantProfilesIds = new HashSet<>();
    tenantProfilesIds.add(ModelConstants.NULL_UUID);

    HashSet<UUID> tenantsIds = new HashSet<>();
    tenantsIds.add(ModelConstants.NULL_UUID);

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantProfilesIds(tenantProfilesIds);
    usersFilter.setTenantsIds(tenantsIds);

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTarget);
    when(userService.findTenantAdminsByTenantsIds(
            Mockito.<List<TenantId>>any(), Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForNotificationTarget(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new NotificationTargetId(ModelConstants.NULL_UUID),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationTarget).getConfiguration();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findTenantAdminsByTenantsIds(isA(List.class), isA(PageLink.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId,
   * CustomerId, NotificationTargetId, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId,
   * NotificationTargetId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)"
  })
  public void testFindRecipientsForNotificationTarget9() {
    // Arrange
    HashSet<UUID> tenantProfilesIds = new HashSet<>();
    tenantProfilesIds.add(ModelConstants.NULL_UUID);

    HashSet<UUID> tenantsIds = new HashSet<>();
    tenantsIds.add(ModelConstants.NULL_UUID);

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantProfilesIds(tenantProfilesIds);
    usersFilter.setTenantsIds(tenantsIds);

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTarget);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findTenantAdmins(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantId tenantId = mock(TenantId.class);

    // Act
    PageData<User> actualFindRecipientsForNotificationTargetResult =
        defaultNotificationTargetService.findRecipientsForNotificationTarget(
            tenantId,
            BaseEntityService.NULL_CUSTOMER_ID,
            new NotificationTargetId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTarget).getConfiguration();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findTenantAdmins(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRecipientsForNotificationTargetResult);
  }

  /**
   * Test {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId,
   * CustomerId, NotificationTargetId, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId,
   * NotificationTargetId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)"
  })
  public void testFindRecipientsForNotificationTarget10() {
    // Arrange
    HashSet<UUID> tenantProfilesIds = new HashSet<>();
    tenantProfilesIds.add(ModelConstants.NULL_UUID);

    HashSet<UUID> tenantsIds = new HashSet<>();
    tenantsIds.add(ModelConstants.NULL_UUID);

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantProfilesIds(tenantProfilesIds);
    usersFilter.setTenantsIds(tenantsIds);

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTarget);
    when(userService.findTenantAdmins(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException());
    TenantId tenantId = mock(TenantId.class);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForNotificationTarget(
                tenantId,
                BaseEntityService.NULL_CUSTOMER_ID,
                new NotificationTargetId(ModelConstants.NULL_UUID),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationTarget).getConfiguration();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findTenantAdmins(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId,
   * CustomerId, NotificationTargetId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link UserService#findAllTenantAdmins(PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId,
   * NotificationTargetId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)"
  })
  public void testFindRecipientsForNotificationTarget_thenCallsFindAllTenantAdmins() {
    // Arrange
    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantProfilesIds(new HashSet<>());
    usersFilter.setTenantsIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTarget);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findAllTenantAdmins(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindRecipientsForNotificationTargetResult =
        defaultNotificationTargetService.findRecipientsForNotificationTarget(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new NotificationTargetId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTarget).getConfiguration();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findAllTenantAdmins(isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRecipientsForNotificationTargetResult);
  }

  /**
   * Test {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId,
   * CustomerId, NotificationTargetId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link UserService#findTenantAdminsByTenantsIds(List, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId,
   * NotificationTargetId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)"
  })
  public void testFindRecipientsForNotificationTarget_thenCallsFindTenantAdminsByTenantsIds() {
    // Arrange
    HashSet<UUID> tenantProfilesIds = new HashSet<>();
    tenantProfilesIds.add(ModelConstants.NULL_UUID);

    HashSet<UUID> tenantsIds = new HashSet<>();
    tenantsIds.add(ModelConstants.NULL_UUID);

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantProfilesIds(tenantProfilesIds);
    usersFilter.setTenantsIds(tenantsIds);

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTarget);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findTenantAdminsByTenantsIds(
            Mockito.<List<TenantId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindRecipientsForNotificationTargetResult =
        defaultNotificationTargetService.findRecipientsForNotificationTarget(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new NotificationTargetId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTarget).getConfiguration();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findTenantAdminsByTenantsIds(isA(List.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRecipientsForNotificationTargetResult);
  }

  /**
   * Test {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId,
   * CustomerId, NotificationTargetId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationTargetId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId,
   * NotificationTargetId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)"
  })
  public void testFindRecipientsForNotificationTarget_thenCallsGetId() {
    // Arrange
    PlatformUsersNotificationTargetConfig configuration =
        new PlatformUsersNotificationTargetConfig();
    configuration.setDescription("The characteristics of someone or something");
    configuration.setUsersFilter(mock(UsersFilter.class));

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS);

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    doNothing().when(notificationTarget).setConfiguration(Mockito.<NotificationTargetConfig>any());
    notificationTarget.setConfiguration(configuration);

    JpaNotificationTargetDao notificationTargetDao = mock(JpaNotificationTargetDao.class);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTarget);
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    DefaultNotificationTargetService defaultNotificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);

    NotificationTargetId targetId = mock(NotificationTargetId.class);
    when(targetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForNotificationTarget(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                targetId,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(targetId).getId();
    verify(notificationTarget).getConfiguration();
    verify(notificationTarget).setConfiguration(isA(NotificationTargetConfig.class));
    verify(usersFilter).getType();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId,
   * CustomerId, NotificationTargetId, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTarget(TenantId, CustomerId,
   * NotificationTargetId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTarget(TenantId, CustomerId, NotificationTargetId, PageLink)"
  })
  public void testFindRecipientsForNotificationTarget_thenReturnTotalElementsIsZero() {
    // Arrange
    UserListFilter usersFilter = new UserListFilter();
    usersFilter.setUsersIds(new ArrayList<>());

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTarget);

    // Act
    PageData<User> actualFindRecipientsForNotificationTargetResult =
        defaultNotificationTargetService.findRecipientsForNotificationTarget(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new NotificationTargetId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTarget).getConfiguration();
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertEquals(0L, actualFindRecipientsForNotificationTargetResult.getTotalElements());
    assertEquals(1, actualFindRecipientsForNotificationTargetResult.getTotalPages());
    assertFalse(actualFindRecipientsForNotificationTargetResult.hasNext());
    assertTrue(actualFindRecipientsForNotificationTargetResult.getData().isEmpty());
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)"
  })
  public void testFindRecipientsForNotificationTargetConfig() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.CUSTOMER_USERS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(
                ModelConstants.SYSTEM_TENANT, targetConfig, BaseRelatedEdgesService.FIRST_PAGE));
    verify(usersFilter).getType();
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)"
  })
  public void testFindRecipientsForNotificationTargetConfig2() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenThrow(new IllegalArgumentException());

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(
                ModelConstants.SYSTEM_TENANT, targetConfig, BaseRelatedEdgesService.FIRST_PAGE));
    verify(usersFilter).getType();
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)"
  })
  public void testFindRecipientsForNotificationTargetConfig3() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findSysAdmins(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.SYSTEM_ADMINISTRATORS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act
    PageData<User> actualFindRecipientsForNotificationTargetConfigResult =
        defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(usersFilter).getType();
    verify(userService).findSysAdmins(isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRecipientsForNotificationTargetConfigResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)"
  })
  public void testFindRecipientsForNotificationTargetConfig4() {
    // Arrange
    when(userService.findSysAdmins(Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException());

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.SYSTEM_ADMINISTRATORS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(
                ModelConstants.SYSTEM_TENANT, targetConfig, BaseRelatedEdgesService.FIRST_PAGE));
    verify(usersFilter).getType();
    verify(userService).findSysAdmins(isA(PageLink.class));
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)"
  })
  public void testFindRecipientsForNotificationTargetConfig5() {
    // Arrange
    when(userService.findAllUsers(Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException());

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.ALL_USERS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(
                ModelConstants.SYSTEM_TENANT, targetConfig, BaseRelatedEdgesService.FIRST_PAGE));
    verify(usersFilter).getType();
    verify(userService).findAllUsers(isA(PageLink.class));
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)"
  })
  public void testFindRecipientsForNotificationTargetConfig6() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(
                ModelConstants.SYSTEM_TENANT, targetConfig, BaseRelatedEdgesService.FIRST_PAGE));
    verify(usersFilter).getType();
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)"
  })
  public void testFindRecipientsForNotificationTargetConfig7() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findUsersByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantId tenantId = mock(TenantId.class);

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.ALL_USERS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act
    PageData<User> actualFindRecipientsForNotificationTargetConfigResult =
        defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(
            tenantId, targetConfig, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(usersFilter).getType();
    verify(userService).findUsersByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRecipientsForNotificationTargetConfigResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)"
  })
  public void testFindRecipientsForNotificationTargetConfig8() {
    // Arrange
    when(userService.findUsersByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException());
    TenantId tenantId = mock(TenantId.class);

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.ALL_USERS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(
                tenantId, targetConfig, BaseRelatedEdgesService.FIRST_PAGE));
    verify(usersFilter).getType();
    verify(userService).findUsersByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)"
  })
  public void testFindRecipientsForNotificationTargetConfig9() {
    // Arrange
    UserDao userDao = mock(UserDao.class);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByAuthorityAndTenantsIds(
            Mockito.<Authority>any(), Mockito.<List<TenantId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));

    DefaultNotificationTargetService defaultNotificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);

    HashSet<UUID> tenantsIds = new HashSet<>();
    tenantsIds.add(ModelConstants.NULL_UUID);

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantsIds(tenantsIds);
    usersFilter.setTenantProfilesIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act
    PageData<User> actualFindRecipientsForNotificationTargetConfigResult =
        defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao)
        .findByAuthorityAndTenantsIds(
            eq(Authority.TENANT_ADMIN), isA(List.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRecipientsForNotificationTargetConfigResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link UserService#findAllTenantAdmins(PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)"
  })
  public void testFindRecipientsForNotificationTargetConfig_thenCallsFindAllTenantAdmins() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findAllTenantAdmins(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantsIds(new HashSet<>());
    usersFilter.setTenantProfilesIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act
    PageData<User> actualFindRecipientsForNotificationTargetConfigResult =
        defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userService).findAllTenantAdmins(isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRecipientsForNotificationTargetConfigResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link UserService#findAllUsers(PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, PageLink)"
  })
  public void testFindRecipientsForNotificationTargetConfig_thenCallsFindAllUsers() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findAllUsers(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.ALL_USERS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act
    PageData<User> actualFindRecipientsForNotificationTargetConfigResult =
        defaultNotificationTargetService.findRecipientsForNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(usersFilter).getType();
    verify(userService).findAllUsers(isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRecipientsForNotificationTargetConfigResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.USER_LIST);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
                ModelConstants.SYSTEM_TENANT,
                targetConfig,
                mock(RuleOriginatedNotificationInfo.class),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(usersFilter).getType();
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig2() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenThrow(new IllegalArgumentException());

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
                ModelConstants.SYSTEM_TENANT,
                targetConfig,
                mock(RuleOriginatedNotificationInfo.class),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(usersFilter).getType();
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig3() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.ORIGINATOR_ENTITY_OWNER_USERS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedCustomerId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
                ModelConstants.SYSTEM_TENANT,
                targetConfig,
                info,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(info).getAffectedCustomerId();
    verify(usersFilter).getType();
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig4() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findTenantAdmins(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.ORIGINATOR_ENTITY_OWNER_USERS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedCustomerId()).thenReturn(null);

    // Act
    PageData<User> actualFindRecipientsForRuleNotificationTargetConfigResult =
        defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, info, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(info).getAffectedCustomerId();
    verify(usersFilter).getType();
    verify(userService).findTenantAdmins(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRecipientsForRuleNotificationTargetConfigResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig5() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.AFFECTED_USER);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedUserId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
                ModelConstants.SYSTEM_TENANT,
                targetConfig,
                info,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(info).getAffectedUserId();
    verify(usersFilter).getType();
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig6() {
    // Arrange
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.AFFECTED_USER);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedUserId()).thenReturn(null);

    // Act
    PageData<User> actualFindRecipientsForRuleNotificationTargetConfigResult =
        defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, info, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(info).getAffectedUserId();
    verify(usersFilter).getType();
    assertEquals(
        PageData.EMPTY_PAGE_DATA, actualFindRecipientsForRuleNotificationTargetConfigResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig7() {
    // Arrange
    when(userService.findUserById(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenThrow(new IllegalArgumentException());

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.AFFECTED_USER);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
                ModelConstants.SYSTEM_TENANT,
                targetConfig,
                info,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(info).getAffectedUserId();
    verify(usersFilter).getType();
    verify(userService).findUserById(isA(TenantId.class), isA(UserId.class));
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig8() {
    // Arrange
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));

    DefaultNotificationTargetService defaultNotificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao,
            notificationRequestDao,
            notificationRuleDao,
            mock(UserService.class));

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
                ModelConstants.SYSTEM_TENANT,
                targetConfig,
                info,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(info).getAffectedTenantId();
    verify(usersFilter).getType();
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig9() {
    // Arrange
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));

    DefaultNotificationTargetService defaultNotificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao,
            notificationRequestDao,
            notificationRuleDao,
            mock(UserService.class));

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedTenantId()).thenReturn(null);

    // Act
    PageData<User> actualFindRecipientsForRuleNotificationTargetConfigResult =
        defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, info, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(info).getAffectedTenantId();
    verify(usersFilter).getType();
    assertEquals(
        PageData.EMPTY_PAGE_DATA, actualFindRecipientsForRuleNotificationTargetConfigResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig10() {
    // Arrange
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));

    DefaultNotificationTargetService defaultNotificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao,
            notificationRequestDao,
            notificationRuleDao,
            mock(UserService.class));

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isNullUid()).thenReturn(true);

    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedTenantId()).thenReturn(tenantId);

    // Act
    PageData<User> actualFindRecipientsForRuleNotificationTargetConfigResult =
        defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, info, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).isNullUid();
    verify(info).getAffectedTenantId();
    verify(usersFilter).getType();
    assertEquals(
        PageData.EMPTY_PAGE_DATA, actualFindRecipientsForRuleNotificationTargetConfigResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig11() {
    // Arrange
    UserService userService = mock(UserService.class);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findTenantAdmins(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));

    DefaultNotificationTargetService defaultNotificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isNullUid()).thenReturn(false);

    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedTenantId()).thenReturn(tenantId);

    // Act
    PageData<User> actualFindRecipientsForRuleNotificationTargetConfigResult =
        defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, info, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).isNullUid();
    verify(info).getAffectedTenantId();
    verify(usersFilter).getType();
    verify(userService).findTenantAdmins(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRecipientsForRuleNotificationTargetConfigResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig12() {
    // Arrange
    UserService userService = mock(UserService.class);
    when(userService.findTenantAdmins(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException());
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));

    DefaultNotificationTargetService defaultNotificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isNullUid()).thenReturn(false);

    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedTenantId()).thenReturn(tenantId);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
                ModelConstants.SYSTEM_TENANT,
                targetConfig,
                info,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(tenantId).isNullUid();
    verify(info).getAffectedTenantId();
    verify(usersFilter).getType();
    verify(userService).findTenantAdmins(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig_givenNull_customer_id() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findTenantAdmins(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.ORIGINATOR_ENTITY_OWNER_USERS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    PageData<User> actualFindRecipientsForRuleNotificationTargetConfigResult =
        defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, info, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(info).getAffectedCustomerId();
    verify(usersFilter).getType();
    verify(userService).findTenantAdmins(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRecipientsForRuleNotificationTargetConfigResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig_givenSystem_tenant() {
    // Arrange
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));

    DefaultNotificationTargetService defaultNotificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao,
            notificationRequestDao,
            notificationRuleDao,
            mock(UserService.class));

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<User> actualFindRecipientsForRuleNotificationTargetConfigResult =
        defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, info, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(info).getAffectedTenantId();
    verify(usersFilter).getType();
    assertEquals(
        PageData.EMPTY_PAGE_DATA, actualFindRecipientsForRuleNotificationTargetConfigResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerId#isNullUid()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig_thenCallsIsNullUid() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findTenantAdmins(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.ORIGINATOR_ENTITY_OWNER_USERS);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.isNullUid()).thenReturn(true);

    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedCustomerId()).thenReturn(customerId);

    // Act
    PageData<User> actualFindRecipientsForRuleNotificationTargetConfigResult =
        defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, info, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(customerId).isNullUid();
    verify(info).getAffectedCustomerId();
    verify(usersFilter).getType();
    verify(userService).findTenantAdmins(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRecipientsForRuleNotificationTargetConfigResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#findRecipientsForRuleNotificationTargetConfig(TenantId,
   * PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(TenantId, PlatformUsersNotificationTargetConfig, RuleOriginatedNotificationInfo, PageLink)"
  })
  public void testFindRecipientsForRuleNotificationTargetConfig_thenReturnDataSizeIsOne() {
    // Arrange
    User user = new User();
    when(userService.findUserById(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(user);

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.AFFECTED_USER);

    PlatformUsersNotificationTargetConfig targetConfig =
        new PlatformUsersNotificationTargetConfig();
    targetConfig.setDescription("The characteristics of someone or something");
    targetConfig.setUsersFilter(usersFilter);

    RuleOriginatedNotificationInfo info = mock(RuleOriginatedNotificationInfo.class);
    when(info.getAffectedUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act
    PageData<User> actualFindRecipientsForRuleNotificationTargetConfigResult =
        defaultNotificationTargetService.findRecipientsForRuleNotificationTargetConfig(
            ModelConstants.SYSTEM_TENANT, targetConfig, info, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(info).getAffectedUserId();
    verify(usersFilter).getType();
    verify(userService).findUserById(isA(TenantId.class), isA(UserId.class));
    List<User> data = actualFindRecipientsForRuleNotificationTargetConfigResult.getData();
    assertEquals(1, data.size());
    assertEquals(1, actualFindRecipientsForRuleNotificationTargetConfigResult.getTotalPages());
    assertEquals(1L, actualFindRecipientsForRuleNotificationTargetConfigResult.getTotalElements());
    assertSame(user, data.get(0));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteNotificationTargetById(TenantId,
   * NotificationTargetId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#deleteNotificationTargetById(TenantId, NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTargetService.deleteNotificationTargetById(TenantId, NotificationTargetId)"
  })
  public void testDeleteNotificationTargetById() {
    // Arrange
    when(notificationRequestDao.existsByTenantIdAndStatusAndTargetId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTargetId>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.deleteNotificationTargetById(
                ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID)));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTargetId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTargetId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteNotificationTargetById(TenantId,
   * NotificationTargetId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#deleteNotificationTargetById(TenantId, NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTargetService.deleteNotificationTargetById(TenantId, NotificationTargetId)"
  })
  public void testDeleteNotificationTargetById2() {
    // Arrange
    when(notificationRequestDao.existsByTenantIdAndStatusAndTargetId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTargetId>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.deleteNotificationTargetById(
                ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID)));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTargetId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTargetId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteNotificationTargetById(TenantId,
   * NotificationTargetId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#deleteNotificationTargetById(TenantId, NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTargetService.deleteNotificationTargetById(TenantId, NotificationTargetId)"
  })
  public void testDeleteNotificationTargetById3() {
    // Arrange
    when(notificationRequestDao.existsByTenantIdAndStatusAndTargetId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTargetId>any()))
        .thenReturn(false);
    when(notificationRuleDao.existsByTenantIdAndTargetId(
            Mockito.<TenantId>any(), Mockito.<NotificationTargetId>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.deleteNotificationTargetById(
                ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID)));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTargetId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTargetId.class));
    verify(notificationRuleDao)
        .existsByTenantIdAndTargetId(isA(TenantId.class), isA(NotificationTargetId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteNotificationTargetById(TenantId,
   * NotificationTargetId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#deleteNotificationTargetById(TenantId, NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTargetService.deleteNotificationTargetById(TenantId, NotificationTargetId)"
  })
  public void testDeleteNotificationTargetById4() {
    // Arrange
    when(notificationRequestDao.existsByTenantIdAndStatusAndTargetId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTargetId>any()))
        .thenReturn(false);
    when(notificationRuleDao.existsByTenantIdAndTargetId(
            Mockito.<TenantId>any(), Mockito.<NotificationTargetId>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.deleteNotificationTargetById(
                ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID)));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTargetId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTargetId.class));
    verify(notificationRuleDao)
        .existsByTenantIdAndTargetId(isA(TenantId.class), isA(NotificationTargetId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteNotificationTargetById(TenantId,
   * NotificationTargetId)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationTargetDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#deleteNotificationTargetById(TenantId, NotificationTargetId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTargetService.deleteNotificationTargetById(TenantId, NotificationTargetId)"
  })
  public void testDeleteNotificationTargetById_thenCallsRemoveById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(notificationTargetDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(notificationRequestDao.existsByTenantIdAndStatusAndTargetId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTargetId>any()))
        .thenReturn(false);
    when(notificationRuleDao.existsByTenantIdAndTargetId(
            Mockito.<TenantId>any(), Mockito.<NotificationTargetId>any()))
        .thenReturn(false);

    // Act
    defaultNotificationTargetService.deleteNotificationTargetById(
        ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationTargetDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTargetId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTargetId.class));
    verify(notificationRuleDao)
        .existsByTenantIdAndTargetId(isA(TenantId.class), isA(NotificationTargetId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTargetService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity() {
    // Arrange
    when(notificationRequestDao.existsByTenantIdAndStatusAndTargetId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTargetId>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.deleteEntity(
                ModelConstants.SYSTEM_TENANT,
                new NotificationTargetId(ModelConstants.NULL_UUID),
                false));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTargetId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTargetId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTargetService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity2() {
    // Arrange
    when(notificationRequestDao.existsByTenantIdAndStatusAndTargetId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTargetId>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.deleteEntity(
                ModelConstants.SYSTEM_TENANT,
                new NotificationTargetId(ModelConstants.NULL_UUID),
                false));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTargetId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTargetId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTargetService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity3() {
    // Arrange
    when(notificationRequestDao.existsByTenantIdAndStatusAndTargetId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTargetId>any()))
        .thenReturn(false);
    when(notificationRuleDao.existsByTenantIdAndTargetId(
            Mockito.<TenantId>any(), Mockito.<NotificationTargetId>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.deleteEntity(
                ModelConstants.SYSTEM_TENANT,
                new NotificationTargetId(ModelConstants.NULL_UUID),
                false));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTargetId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTargetId.class));
    verify(notificationRuleDao)
        .existsByTenantIdAndTargetId(isA(TenantId.class), isA(NotificationTargetId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link NotificationRequestDao}.
   *   <li>When {@code true}.
   *   <li>Then calls {@link NotificationTargetDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTargetService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity_givenNotificationRequestDao_whenTrue_thenCallsRemoveById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(notificationTargetDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    defaultNotificationTargetService.deleteEntity(
        ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID), true);

    // Assert
    verify(notificationTargetDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link NotificationRuleDao} {@link
   *       NotificationRuleDao#existsByTenantIdAndTargetId(TenantId, NotificationTargetId)} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTargetService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity_givenNotificationRuleDaoExistsByTenantIdAndTargetIdReturnFalse() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(notificationTargetDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(notificationRequestDao.existsByTenantIdAndStatusAndTargetId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTargetId>any()))
        .thenReturn(false);
    when(notificationRuleDao.existsByTenantIdAndTargetId(
            Mockito.<TenantId>any(), Mockito.<NotificationTargetId>any()))
        .thenReturn(false);

    // Act
    defaultNotificationTargetService.deleteEntity(
        ModelConstants.SYSTEM_TENANT, new NotificationTargetId(ModelConstants.NULL_UUID), false);

    // Assert
    verify(notificationTargetDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTargetId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTargetId.class));
    verify(notificationRuleDao)
        .existsByTenantIdAndTargetId(isA(TenantId.class), isA(NotificationTargetId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link NotificationRuleDao} {@link
   *       NotificationRuleDao#existsByTenantIdAndTargetId(TenantId, NotificationTargetId)} return
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTargetService#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTargetService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity_givenNotificationRuleDaoExistsByTenantIdAndTargetIdReturnTrue() {
    // Arrange
    when(notificationRequestDao.existsByTenantIdAndStatusAndTargetId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTargetId>any()))
        .thenReturn(false);
    when(notificationRuleDao.existsByTenantIdAndTargetId(
            Mockito.<TenantId>any(), Mockito.<NotificationTargetId>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.deleteEntity(
                ModelConstants.SYSTEM_TENANT,
                new NotificationTargetId(ModelConstants.NULL_UUID),
                false));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTargetId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTargetId.class));
    verify(notificationRuleDao)
        .existsByTenantIdAndTargetId(isA(TenantId.class), isA(NotificationTargetId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteNotificationTargetsByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#deleteNotificationTargetsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTargetService.deleteNotificationTargetsByTenantId(TenantId)"
  })
  public void testDeleteNotificationTargetsByTenantId() {
    // Arrange
    doNothing().when(notificationTargetDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationTargetService.deleteNotificationTargetsByTenantId(
        ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTargetDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteNotificationTargetsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#deleteNotificationTargetsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTargetService.deleteNotificationTargetsByTenantId(TenantId)"
  })
  public void testDeleteNotificationTargetsByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(notificationTargetDao)
        .removeByTenantId(Mockito.<TenantId>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.deleteNotificationTargetsByTenantId(
                ModelConstants.SYSTEM_TENANT));
    verify(notificationTargetDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link NotificationTargetDao} {@link
   *       NotificationTargetDao#removeByTenantId(TenantId)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTargetService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultNotificationTargetService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenNotificationTargetDaoRemoveByTenantIdDoesNothing() {
    // Arrange
    doNothing().when(notificationTargetDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationTargetService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTargetDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTargetService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultNotificationTargetService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(notificationTargetDao)
        .removeByTenantId(Mockito.<TenantId>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultNotificationTargetService.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(notificationTargetDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#countNotificationTargetsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#countNotificationTargetsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DefaultNotificationTargetService.countNotificationTargetsByTenantId(TenantId)"
  })
  public void testCountNotificationTargetsByTenantId_thenReturnOne() {
    // Arrange
    when(notificationTargetDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualCountNotificationTargetsByTenantIdResult =
        defaultNotificationTargetService.countNotificationTargetsByTenantId(
            ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTargetDao).countByTenantId(isA(TenantId.class));
    assertEquals(1L, actualCountNotificationTargetsByTenantIdResult);
  }

  /**
   * Test {@link DefaultNotificationTargetService#countNotificationTargetsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTargetService#countNotificationTargetsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long DefaultNotificationTargetService.countNotificationTargetsByTenantId(TenantId)"
  })
  public void testCountNotificationTargetsByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTargetDao.countByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.countNotificationTargetsByTenantId(
                ModelConstants.SYSTEM_TENANT));
    verify(notificationTargetDao).countByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTargetService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DefaultNotificationTargetService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenReturnPresent() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTarget);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        defaultNotificationTargetService.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(notificationTarget, actualFindEntityResult.get());
  }

  /**
   * Test {@link DefaultNotificationTargetService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTargetService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DefaultNotificationTargetService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTargetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTargetService.findEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(notificationTargetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationTargetService#getEntityType()}.
   *
   * <p>Method under test: {@link DefaultNotificationTargetService#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DefaultNotificationTargetService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    DefaultNotificationTargetService defaultNotificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);

    // Act and Assert
    assertEquals(EntityType.NOTIFICATION_TARGET, defaultNotificationTargetService.getEntityType());
  }
}
