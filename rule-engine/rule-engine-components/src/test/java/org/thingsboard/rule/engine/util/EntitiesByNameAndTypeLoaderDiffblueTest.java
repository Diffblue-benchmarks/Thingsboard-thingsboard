package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
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
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType,
   * String)}
   */
  @Test
  @DisplayName("Test findEntityId(TbContext, EntityType, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntitiesByNameAndTypeLoader.findEntityId(TbContext, EntityType, String)"
  })
  void testFindEntityId() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getEntityViewService()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> EntitiesByNameAndTypeLoader.findEntityId(ctx, EntityType.ENTITY_VIEW, "Entity Name"));
    verify(ctx).getEntityViewService();
  }

  /**
   * Test {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType, String)}.
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType,
   * String)}
   */
  @Test
  @DisplayName("Test findEntityId(TbContext, EntityType, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntitiesByNameAndTypeLoader.findEntityId(TbContext, EntityType, String)"
  })
  void testFindEntityId2() {
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
    when(ctx.getUserService())
        .thenReturn(
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
                new JpaExecutorService()));
    when(ctx.getTenantId()).thenThrow(new IllegalStateException("foo"));

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
   *   <li>Given {@link BaseAssetService} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findEntityId(TbContext, EntityType, String); given BaseAssetService (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntitiesByNameAndTypeLoader.findEntityId(TbContext, EntityType, String)"
  })
  void testFindEntityId_givenBaseAssetService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getAssetService()).thenReturn(new BaseAssetService());
    when(ctx.getTenantId()).thenThrow(new IllegalStateException("foo"));

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
   * </ul>
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findEntityId(TbContext, EntityType, String); given EdgeServiceImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntitiesByNameAndTypeLoader.findEntityId(TbContext, EntityType, String)"
  })
  void testFindEntityId_givenEdgeServiceImpl() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getEdgeService()).thenReturn(new EdgeServiceImpl());
    when(ctx.getTenantId()).thenThrow(new IllegalStateException("foo"));

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
   * </ul>
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findEntityId(TbContext, EntityType, String); given EntityViewServiceImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntitiesByNameAndTypeLoader.findEntityId(TbContext, EntityType, String)"
  })
  void testFindEntityId_givenEntityViewServiceImpl() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getEntityViewService()).thenReturn(new EntityViewServiceImpl());
    when(ctx.getTenantId()).thenThrow(new IllegalStateException("foo"));

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
   *   <li>Then calls {@link TbContext#getDeviceService()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType,
   * String)}
   */
  @Test
  @DisplayName("Test findEntityId(TbContext, EntityType, String); then calls getDeviceService()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntitiesByNameAndTypeLoader.findEntityId(TbContext, EntityType, String)"
  })
  void testFindEntityId_thenCallsGetDeviceService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> EntitiesByNameAndTypeLoader.findEntityId(ctx, EntityType.DEVICE, "Entity Name"));
    verify(ctx).getDeviceService();
  }

  /**
   * Test {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType, String)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getAssetService()} throw {@link
   *       IllegalStateException#IllegalStateException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findEntityId(TbContext, EntityType, String); when TbContext getAssetService() throw IllegalStateException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntitiesByNameAndTypeLoader.findEntityId(TbContext, EntityType, String)"
  })
  void testFindEntityId_whenTbContextGetAssetServiceThrowIllegalStateExceptionWithFoo() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getAssetService()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> EntitiesByNameAndTypeLoader.findEntityId(ctx, EntityType.ASSET, "Entity Name"));
    verify(ctx).getAssetService();
  }

  /**
   * Test {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType, String)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getEdgeService()} throw {@link
   *       IllegalStateException#IllegalStateException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findEntityId(TbContext, EntityType, String); when TbContext getEdgeService() throw IllegalStateException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntitiesByNameAndTypeLoader.findEntityId(TbContext, EntityType, String)"
  })
  void testFindEntityId_whenTbContextGetEdgeServiceThrowIllegalStateExceptionWithFoo() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getEdgeService()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> EntitiesByNameAndTypeLoader.findEntityId(ctx, EntityType.EDGE, "Entity Name"));
    verify(ctx).getEdgeService();
  }

  /**
   * Test {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType, String)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getUserService()} throw {@link
   *       IllegalStateException#IllegalStateException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findEntityId(TbContext, EntityType, String); when TbContext getUserService() throw IllegalStateException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntitiesByNameAndTypeLoader.findEntityId(TbContext, EntityType, String)"
  })
  void testFindEntityId_whenTbContextGetUserServiceThrowIllegalStateExceptionWithFoo() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getUserService()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> EntitiesByNameAndTypeLoader.findEntityId(ctx, EntityType.USER, "Entity Name"));
    verify(ctx).getUserService();
  }

  /**
   * Test {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType, String)}.
   *
   * <ul>
   *   <li>When {@link TbContext}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesByNameAndTypeLoader#findEntityId(TbContext, EntityType,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findEntityId(TbContext, EntityType, String); when TbContext; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId EntitiesByNameAndTypeLoader.findEntityId(TbContext, EntityType, String)"
  })
  void testFindEntityId_whenTbContext_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            EntitiesByNameAndTypeLoader.findEntityId(
                mock(TbContext.class), EntityType.TENANT, "Entity Name"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitiesByNameAndTypeLoader.checkEntityType(EntityType)"})
  void testCheckEntityType_whenTenant_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> EntitiesByNameAndTypeLoader.checkEntityType(EntityType.TENANT));
  }
}
