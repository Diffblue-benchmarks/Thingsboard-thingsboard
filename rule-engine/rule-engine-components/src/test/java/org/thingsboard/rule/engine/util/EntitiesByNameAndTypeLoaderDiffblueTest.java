package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entityview.EntityViewServiceImpl;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;

class EntitiesByNameAndTypeLoaderDiffblueTest {
  /**
   * Test {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType, String)}.
   *
   * <ul>
   *   <li>Given {@link BaseAssetService} (default constructor).
   *   <li>Then calls {@link TbContext#getAssetService()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findEntityId(TbContext, EntityType, String); given BaseAssetService (default constructor); then calls getAssetService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntitiesByNameAndTypeLoader.findEntityId(TbContext, EntityType, String)"
  })
  void testFindEntityId_givenBaseAssetService_thenCallsGetAssetService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getAssetService()).thenReturn(new BaseAssetService());
    when(ctx.getTenantId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> EntitiesByNameAndTypeLoader.findEntityId(ctx, EntityType.ASSET, "Entity Name"));
    verify(ctx).getAssetService();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType, String)}.
   *
   * <ul>
   *   <li>Given {@link EdgeServiceImpl} (default constructor).
   *   <li>Then calls {@link TbContext#getEdgeService()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findEntityId(TbContext, EntityType, String); given EdgeServiceImpl (default constructor); then calls getEdgeService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntitiesByNameAndTypeLoader.findEntityId(TbContext, EntityType, String)"
  })
  void testFindEntityId_givenEdgeServiceImpl_thenCallsGetEdgeService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getEdgeService()).thenReturn(new EdgeServiceImpl());
    when(ctx.getTenantId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> EntitiesByNameAndTypeLoader.findEntityId(ctx, EntityType.EDGE, "Entity Name"));
    verify(ctx).getEdgeService();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityViewServiceImpl} (default constructor).
   *   <li>Then calls {@link TbContext#getEntityViewService()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findEntityId(TbContext, EntityType, String); given EntityViewServiceImpl (default constructor); then calls getEntityViewService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntitiesByNameAndTypeLoader.findEntityId(TbContext, EntityType, String)"
  })
  void testFindEntityId_givenEntityViewServiceImpl_thenCallsGetEntityViewService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getEntityViewService()).thenReturn(new EntityViewServiceImpl());
    when(ctx.getTenantId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> EntitiesByNameAndTypeLoader.findEntityId(ctx, EntityType.ENTITY_VIEW, "Entity Name"));
    verify(ctx).getEntityViewService();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType, String)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getUserService()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType,
   * String)}
   */
  @Test
  @DisplayName("Test findEntityId(TbContext, EntityType, String); then calls getUserService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntitiesByNameAndTypeLoader.findEntityId(TbContext, EntityType, String)"
  })
  void testFindEntityId_thenCallsGetUserService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
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

    UserServiceImpl userServiceImpl =
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
    when(ctx.getUserService()).thenReturn(userServiceImpl);
    when(ctx.getTenantId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> EntitiesByNameAndTypeLoader.findEntityId(ctx, EntityType.USER, "Entity Name"));
    verify(ctx).getTenantId();
    verify(ctx).getUserService();
  }

  /**
   * Test {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType, String)}.
   *
   * <ul>
   *   <li>When {@code TENANT}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findEntityId(TbContext, EntityType, String); when 'TENANT'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntitiesByNameAndTypeLoader.findEntityId(TbContext, EntityType, String)"
  })
  void testFindEntityId_whenTenant_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            EntitiesByNameAndTypeLoader.findEntityId(
                TbContextMinimalFactory.minimalForOnMsg(), EntityType.TENANT, "Entity Name"));
  }

  /**
   * Test {@link EntitiesByNameAndTypeLoader#checkEntityType(EntityType)}.
   *
   * <ul>
   *   <li>When {@code TENANT}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#checkEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test checkEntityType(EntityType); when 'TENANT'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitiesByNameAndTypeLoader.checkEntityType(EntityType)"})
  void testCheckEntityType_whenTenant_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> EntitiesByNameAndTypeLoader.checkEntityType(EntityType.TENANT));
  }

  /**
   * Test {@link EntitiesByNameAndTypeLoader#checkEntityType(EntityType)}.
   *
   * <ul>
   *   <li>When {@code USER}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#checkEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test checkEntityType(EntityType); when 'USER'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitiesByNameAndTypeLoader.checkEntityType(EntityType)"})
  void testCheckEntityType_whenUser_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> EntitiesByNameAndTypeLoader.checkEntityType(EntityType.USER));
  }
}
