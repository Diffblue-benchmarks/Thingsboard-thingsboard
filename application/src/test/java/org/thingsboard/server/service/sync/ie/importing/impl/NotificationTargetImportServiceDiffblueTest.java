package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.access.AccessDeniedException;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.targets.MicrosoftTeamsNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.targets.NotificationTargetType;
import org.thingsboard.server.common.data.notification.targets.platform.PlatformUsersNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilter;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilterType;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.notification.DefaultNotificationTargetService;
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
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

@ExtendWith(MockitoExtension.class)
class NotificationTargetImportServiceDiffblueTest {
  @InjectMocks
  private NotificationTargetImportService notificationTargetImportService;

  /**
   * Test {@link NotificationTargetImportService#setOwner(TenantId, NotificationTarget, IdProvider)}.
   * <p>
   * Method under test: {@link NotificationTargetImportService#setOwner(TenantId, NotificationTarget, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, NotificationTarget, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationTargetImportService.setOwner(TenantId, NotificationTarget, IdProvider)"})
  void testSetOwner() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationTarget notificationTarget = new NotificationTarget();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    notificationTargetImportService.setOwner(tenantId, notificationTarget,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    assertSame(tenantId, notificationTarget.getTenantId());
  }

  /**
   * Test {@link NotificationTargetImportService#setOwner(TenantId, NotificationTarget, IdProvider)}.
   * <ul>
   *   <li>When {@link NotificationTarget} {@link NotificationTarget#setTenantId(TenantId)} does nothing.</li>
   *   <li>Then calls {@link NotificationTarget#setTenantId(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetImportService#setOwner(TenantId, NotificationTarget, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, NotificationTarget, IdProvider); when NotificationTarget setTenantId(TenantId) does nothing; then calls setTenantId(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationTargetImportService.setOwner(TenantId, NotificationTarget, IdProvider)"})
  void testSetOwner_whenNotificationTargetSetTenantIdDoesNothing_thenCallsSetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    doNothing().when(notificationTarget).setTenantId(Mockito.<TenantId>any());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    notificationTargetImportService.setOwner(tenantId, notificationTarget,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    verify(notificationTarget).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link NotificationTargetImportService#prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)}.
   * <p>
   * Method under test: {@link NotificationTargetImportService#prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "NotificationTarget NotificationTargetImportService.prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)"})
  void testPrepare() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(new MicrosoftTeamsNotificationTargetConfig());
    NotificationTarget oldNotificationTarget = new NotificationTarget();
    EntityExportData<NotificationTarget> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    NotificationTarget actualPrepareResult = notificationTargetImportService.prepare(ctx, notificationTarget,
        oldNotificationTarget, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(notificationTarget).getConfiguration();
    assertSame(notificationTarget, actualPrepareResult);
  }

  /**
   * Test {@link NotificationTargetImportService#prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then throw {@link AccessDeniedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetImportService#prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider); given ArrayList(); then throw AccessDeniedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "NotificationTarget NotificationTargetImportService.prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)"})
  void testPrepare_givenArrayList_thenThrowAccessDeniedException() {
    // Arrange
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    doNothing().when(ctx).addRelations(Mockito.<Collection<EntityRelation>>any());
    ctx.addRelations(new ArrayList<>());
    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.SYSTEM_ADMINISTRATORS);
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = mock(
        PlatformUsersNotificationTargetConfig.class);
    when(platformUsersNotificationTargetConfig.getUsersFilter()).thenReturn(usersFilter);
    when(platformUsersNotificationTargetConfig.getType()).thenReturn(NotificationTargetType.PLATFORM_USERS);
    doNothing().when(platformUsersNotificationTargetConfig).setDescription(Mockito.<String>any());
    doNothing().when(platformUsersNotificationTargetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(mock(UsersFilter.class));
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    NotificationTarget oldNotificationTarget = new NotificationTarget();
    EntityExportData<NotificationTarget> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act and Assert
    assertThrows(AccessDeniedException.class,
        () -> notificationTargetImportService.prepare(ctx, notificationTarget, oldNotificationTarget, exportData,
            (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult())));
    verify(notificationTarget, atLeast(1)).getConfiguration();
    verify(platformUsersNotificationTargetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(platformUsersNotificationTargetConfig).getType();
    verify(platformUsersNotificationTargetConfig).getUsersFilter();
    verify(platformUsersNotificationTargetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter).getType();
    verify(ctx).addRelations(isA(Collection.class));
  }

  /**
   * Test {@link NotificationTargetImportService#prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link UsersFilter} {@link UsersFilter#getType()} return {@code AFFECTED_TENANT_ADMINISTRATORS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetImportService#prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider); given UsersFilter getType() return 'AFFECTED_TENANT_ADMINISTRATORS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "NotificationTarget NotificationTargetImportService.prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)"})
  void testPrepare_givenUsersFilterGetTypeReturnAffectedTenantAdministrators() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenReturn(UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS);
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = mock(
        PlatformUsersNotificationTargetConfig.class);
    when(platformUsersNotificationTargetConfig.getUsersFilter()).thenReturn(usersFilter);
    when(platformUsersNotificationTargetConfig.getType()).thenReturn(NotificationTargetType.PLATFORM_USERS);
    doNothing().when(platformUsersNotificationTargetConfig).setDescription(Mockito.<String>any());
    doNothing().when(platformUsersNotificationTargetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(mock(UsersFilter.class));
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    NotificationTarget oldNotificationTarget = new NotificationTarget();
    EntityExportData<NotificationTarget> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    NotificationTarget actualPrepareResult = notificationTargetImportService.prepare(ctx, notificationTarget,
        oldNotificationTarget, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(notificationTarget, atLeast(1)).getConfiguration();
    verify(platformUsersNotificationTargetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(platformUsersNotificationTargetConfig).getType();
    verify(platformUsersNotificationTargetConfig).getUsersFilter();
    verify(platformUsersNotificationTargetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter).getType();
    assertSame(notificationTarget, actualPrepareResult);
  }

  /**
   * Test {@link NotificationTargetImportService#prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Then return {@link NotificationTarget#NotificationTarget()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetImportService#prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider); then return NotificationTarget()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "NotificationTarget NotificationTargetImportService.prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)"})
  void testPrepare_thenReturnNotificationTarget() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(new MicrosoftTeamsNotificationTargetConfig());
    NotificationTarget oldNotificationTarget = new NotificationTarget();
    EntityExportData<NotificationTarget> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertSame(notificationTarget,
        notificationTargetImportService.prepare(ctx, notificationTarget, oldNotificationTarget, exportData,
            (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult())));
  }

  /**
   * Test {@link NotificationTargetImportService#prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetImportService#prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "NotificationTarget NotificationTargetImportService.prepare(EntitiesImportCtx, NotificationTarget, NotificationTarget, EntityExportData, IdProvider)"})
  void testPrepare_thenThrowIllegalArgumentException() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    UsersFilter usersFilter = mock(UsersFilter.class);
    when(usersFilter.getType()).thenThrow(new IllegalArgumentException("foo"));
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = mock(
        PlatformUsersNotificationTargetConfig.class);
    when(platformUsersNotificationTargetConfig.getUsersFilter()).thenReturn(usersFilter);
    when(platformUsersNotificationTargetConfig.getType()).thenReturn(NotificationTargetType.PLATFORM_USERS);
    doNothing().when(platformUsersNotificationTargetConfig).setDescription(Mockito.<String>any());
    doNothing().when(platformUsersNotificationTargetConfig).setUsersFilter(Mockito.<UsersFilter>any());
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(mock(UsersFilter.class));
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    NotificationTarget oldNotificationTarget = new NotificationTarget();
    EntityExportData<NotificationTarget> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> notificationTargetImportService.prepare(ctx, notificationTarget, oldNotificationTarget, exportData,
            (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult())));
    verify(notificationTarget, atLeast(1)).getConfiguration();
    verify(platformUsersNotificationTargetConfig).setDescription(eq("The characteristics of someone or something"));
    verify(platformUsersNotificationTargetConfig).getType();
    verify(platformUsersNotificationTargetConfig).getUsersFilter();
    verify(platformUsersNotificationTargetConfig).setUsersFilter(isA(UsersFilter.class));
    verify(usersFilter).getType();
  }

  /**
   * Test {@link NotificationTargetImportService#deepCopy(NotificationTarget)} with {@code NotificationTarget}.
   * <p>
   * Method under test: {@link NotificationTargetImportService#deepCopy(NotificationTarget)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTarget) with 'NotificationTarget'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTarget NotificationTargetImportService.deepCopy(NotificationTarget)"})
  void testDeepCopyWithNotificationTarget() {
    // Arrange
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getCreatedTime()).thenReturn(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    NotificationTargetId notificationTargetId = new NotificationTargetId(id);
    when(notificationTarget.getId()).thenReturn(notificationTargetId);

    // Act
    NotificationTarget actualDeepCopyResult = notificationTargetImportService.deepCopy(notificationTarget);

    // Assert
    verify(notificationTarget).getCreatedTime();
    verify(notificationTarget).getId();
    UUID uuidId = actualDeepCopyResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertNull(actualDeepCopyResult.getConfiguration());
    assertEquals(1L, actualDeepCopyResult.getCreatedTime());
    assertSame(notificationTargetId, actualDeepCopyResult.getId());
    assertSame(id, uuidId);
  }

  /**
   * Test {@link NotificationTargetImportService#deepCopy(NotificationTarget)} with {@code NotificationTarget}.
   * <ul>
   *   <li>Then return {@link NotificationTarget#NotificationTarget()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetImportService#deepCopy(NotificationTarget)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTarget) with 'NotificationTarget'; then return NotificationTarget()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTarget NotificationTargetImportService.deepCopy(NotificationTarget)"})
  void testDeepCopyWithNotificationTarget_thenReturnNotificationTarget() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();

    // Act and Assert
    assertEquals(notificationTarget, notificationTargetImportService.deepCopy(notificationTarget));
  }

  /**
   * Test {@link NotificationTargetImportService#getEntityType()}.
   * <p>
   * Method under test: {@link NotificationTargetImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType NotificationTargetImportService.getEntityType()"})
  void testGetEntityType() {
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
        (new NotificationTargetImportService(
            new DefaultNotificationTargetService(notificationTargetDao, notificationRequestDao, notificationRuleDao,
                new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService,
                    userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator, eventPublisher,
                    countService, new JpaExecutorService()))))
            .getEntityType());
  }
}
