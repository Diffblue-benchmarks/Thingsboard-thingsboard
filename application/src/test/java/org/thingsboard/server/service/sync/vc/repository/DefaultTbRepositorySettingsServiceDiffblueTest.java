package org.thingsboard.server.service.sync.vc.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.thingsboard.server.cache.CacheSpecsMap;
import org.thingsboard.server.cache.TBRedisClusterConfiguration;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.vc.RepositoryAuthMethod;
import org.thingsboard.server.common.data.sync.vc.RepositorySettings;
import org.thingsboard.server.dao.settings.AdminSettingsService;

class DefaultTbRepositorySettingsServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}.
   * <p>
   * Method under test:
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test restore(TenantId, RepositorySettings)")
  void testRestore() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RepositorySettings settings = new RepositorySettings();

    // Act
    RepositorySettings actualRestoreResult = defaultTbRepositorySettingsService.restore(tenantId, settings);

    // Assert
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    assertNull(settings.getPassword());
    assertSame(settings, actualRestoreResult);
  }

  /**
   * Test
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}.
   * <p>
   * Method under test:
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test restore(TenantId, RepositorySettings)")
  void testRestore2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService,
        new RepositorySettingsRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RepositorySettings settings = new RepositorySettings();

    // Act
    RepositorySettings actualRestoreResult = defaultTbRepositorySettingsService.restore(tenantId, settings);

    // Assert
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    assertNull(settings.getPassword());
    assertSame(settings, actualRestoreResult);
  }

  /**
   * Test
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}.
   * <p>
   * Method under test:
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test restore(TenantId, RepositorySettings)")
  void testRestore3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(new RepositorySettings());
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        mock(AdminSettingsService.class), cache);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RepositorySettings settings = new RepositorySettings();

    // Act
    RepositorySettings actualRestoreResult = defaultTbRepositorySettingsService.restore(tenantId, settings);

    // Assert
    verify(cache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    assertSame(settings, actualRestoreResult);
  }

  /**
   * Test
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Given {@link AdminSettings} {@link AdminSettings#getJsonValue()} return
   * Instance.</li>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test restore(TenantId, RepositorySettings); given AdminSettings getJsonValue() return Instance; then calls getJsonValue()")
  void testRestore_givenAdminSettingsGetJsonValueReturnInstance_thenCallsGetJsonValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RepositorySettings settings = new RepositorySettings();

    // Act
    RepositorySettings actualRestoreResult = defaultTbRepositorySettingsService.restore(tenantId, settings);

    // Assert
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    assertNull(settings.getPassword());
    assertSame(settings, actualRestoreResult);
  }

  /**
   * Test
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Given {@link AdminSettingsService}
   * {@link AdminSettingsService#findAdminSettingsByTenantIdAndKey(TenantId, String)}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test restore(TenantId, RepositorySettings); given AdminSettingsService findAdminSettingsByTenantIdAndKey(TenantId, String) return 'null'")
  void testRestore_givenAdminSettingsServiceFindAdminSettingsByTenantIdAndKeyReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RepositorySettings settings = new RepositorySettings();

    // Act
    RepositorySettings actualRestoreResult = defaultTbRepositorySettingsService.restore(tenantId, settings);

    // Assert
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    assertNull(settings.getPassword());
    assertSame(settings, actualRestoreResult);
  }

  /**
   * Test
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Given {@code Private Key}.</li>
   *   <li>When {@link RepositorySettings}
   * {@link RepositorySettings#getPrivateKey()} return {@code Private Key}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test restore(TenantId, RepositorySettings); given 'Private Key'; when RepositorySettings getPrivateKey() return 'Private Key'")
  void testRestore_givenPrivateKey_whenRepositorySettingsGetPrivateKeyReturnPrivateKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isLocalOnly()).thenReturn(true);
    when(repositorySettings.isReadOnly()).thenReturn(true);
    when(repositorySettings.isShowMergeCommits()).thenReturn(true);
    when(repositorySettings.getDefaultBranch()).thenReturn("janedoe/featurebranch");
    when(repositorySettings.getPassword()).thenReturn("iloveyou");
    when(repositorySettings.getPrivateKey()).thenReturn("Private Key");
    when(repositorySettings.getPrivateKeyFileName()).thenReturn("foo.txt");
    when(repositorySettings.getPrivateKeyPassword()).thenReturn("iloveyou");
    when(repositorySettings.getRepositoryUri()).thenReturn("Repository Uri");
    when(repositorySettings.getUsername()).thenReturn("janedoe");
    when(repositorySettings.getAuthMethod()).thenReturn(RepositoryAuthMethod.USERNAME_PASSWORD);
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(repositorySettings);
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        mock(AdminSettingsService.class), cache);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.getPrivateKey()).thenReturn("Private Key");
    when(settings.getPrivateKeyPassword()).thenReturn("iloveyou");
    when(settings.getPassword()).thenReturn("iloveyou");
    when(settings.getAuthMethod()).thenReturn(RepositoryAuthMethod.PRIVATE_KEY);

    // Act
    RepositorySettings actualRestoreResult = defaultTbRepositorySettingsService.restore(tenantId, settings);

    // Assert
    verify(cache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    verify(repositorySettings).getAuthMethod();
    verify(settings).getAuthMethod();
    verify(repositorySettings).getDefaultBranch();
    verify(repositorySettings).getPassword();
    verify(repositorySettings).getPrivateKey();
    verify(settings).getPrivateKey();
    verify(repositorySettings).getPrivateKeyFileName();
    verify(repositorySettings).getPrivateKeyPassword();
    verify(repositorySettings).getRepositoryUri();
    verify(repositorySettings).getUsername();
    verify(repositorySettings).isLocalOnly();
    verify(repositorySettings).isReadOnly();
    verify(repositorySettings).isShowMergeCommits();
    assertSame(settings, actualRestoreResult);
  }

  /**
   * Test
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Then calls {@link RepositorySettings#setPrivateKeyPassword(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test restore(TenantId, RepositorySettings); then calls setPrivateKeyPassword(String)")
  void testRestore_thenCallsSetPrivateKeyPassword() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isLocalOnly()).thenReturn(true);
    when(repositorySettings.isReadOnly()).thenReturn(true);
    when(repositorySettings.isShowMergeCommits()).thenReturn(true);
    when(repositorySettings.getDefaultBranch()).thenReturn("janedoe/featurebranch");
    when(repositorySettings.getPassword()).thenReturn("iloveyou");
    when(repositorySettings.getPrivateKey()).thenReturn("Private Key");
    when(repositorySettings.getPrivateKeyFileName()).thenReturn("foo.txt");
    when(repositorySettings.getPrivateKeyPassword()).thenReturn("iloveyou");
    when(repositorySettings.getRepositoryUri()).thenReturn("Repository Uri");
    when(repositorySettings.getUsername()).thenReturn("janedoe");
    when(repositorySettings.getAuthMethod()).thenReturn(RepositoryAuthMethod.USERNAME_PASSWORD);
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(repositorySettings);
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        mock(AdminSettingsService.class), cache);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.getPrivateKey()).thenReturn(null);
    when(settings.getPrivateKeyPassword()).thenReturn(null);
    doNothing().when(settings).setPrivateKey(Mockito.<String>any());
    doNothing().when(settings).setPrivateKeyPassword(Mockito.<String>any());
    when(settings.getPassword()).thenReturn("iloveyou");
    when(settings.getAuthMethod()).thenReturn(RepositoryAuthMethod.PRIVATE_KEY);

    // Act
    RepositorySettings actualRestoreResult = defaultTbRepositorySettingsService.restore(tenantId, settings);

    // Assert
    verify(cache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    verify(repositorySettings).getAuthMethod();
    verify(settings).getAuthMethod();
    verify(repositorySettings).getDefaultBranch();
    verify(repositorySettings).getPassword();
    verify(repositorySettings).getPrivateKey();
    verify(settings).getPrivateKey();
    verify(repositorySettings).getPrivateKeyFileName();
    verify(repositorySettings).getPrivateKeyPassword();
    verify(settings).getPrivateKeyPassword();
    verify(repositorySettings).getRepositoryUri();
    verify(repositorySettings).getUsername();
    verify(repositorySettings).isLocalOnly();
    verify(repositorySettings).isReadOnly();
    verify(repositorySettings).isShowMergeCommits();
    verify(settings).setPrivateKey(eq("Private Key"));
    verify(settings).setPrivateKeyPassword(eq("iloveyou"));
    assertSame(settings, actualRestoreResult);
  }

  /**
   * Test
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Then {@link RepositorySettings#RepositorySettings()} Password is
   * {@code iloveyou}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test restore(TenantId, RepositorySettings); then RepositorySettings() Password is 'iloveyou'")
  void testRestore_thenRepositorySettingsPasswordIsIloveyou() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isLocalOnly()).thenReturn(true);
    when(repositorySettings.isReadOnly()).thenReturn(true);
    when(repositorySettings.isShowMergeCommits()).thenReturn(true);
    when(repositorySettings.getDefaultBranch()).thenReturn("janedoe/featurebranch");
    when(repositorySettings.getPassword()).thenReturn("iloveyou");
    when(repositorySettings.getPrivateKey()).thenReturn("Private Key");
    when(repositorySettings.getPrivateKeyFileName()).thenReturn("foo.txt");
    when(repositorySettings.getPrivateKeyPassword()).thenReturn("iloveyou");
    when(repositorySettings.getRepositoryUri()).thenReturn("Repository Uri");
    when(repositorySettings.getUsername()).thenReturn("janedoe");
    when(repositorySettings.getAuthMethod()).thenReturn(RepositoryAuthMethod.USERNAME_PASSWORD);
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(repositorySettings);
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        mock(AdminSettingsService.class), cache);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    RepositorySettings settings = new RepositorySettings();
    settings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);

    // Act
    RepositorySettings actualRestoreResult = defaultTbRepositorySettingsService.restore(tenantId, settings);

    // Assert
    verify(cache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    verify(repositorySettings).getAuthMethod();
    verify(repositorySettings).getDefaultBranch();
    verify(repositorySettings).getPassword();
    verify(repositorySettings).getPrivateKey();
    verify(repositorySettings).getPrivateKeyFileName();
    verify(repositorySettings).getPrivateKeyPassword();
    verify(repositorySettings).getRepositoryUri();
    verify(repositorySettings).getUsername();
    verify(repositorySettings).isLocalOnly();
    verify(repositorySettings).isReadOnly();
    verify(repositorySettings).isShowMergeCommits();
    assertEquals("iloveyou", settings.getPassword());
    assertSame(settings, actualRestoreResult);
  }

  /**
   * Test
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Then {@link RepositorySettings#RepositorySettings()} Password is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test restore(TenantId, RepositorySettings); then RepositorySettings() Password is 'null'")
  void testRestore_thenRepositorySettingsPasswordIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isLocalOnly()).thenReturn(true);
    when(repositorySettings.isReadOnly()).thenReturn(true);
    when(repositorySettings.isShowMergeCommits()).thenReturn(true);
    when(repositorySettings.getDefaultBranch()).thenReturn("janedoe/featurebranch");
    when(repositorySettings.getPassword()).thenReturn("iloveyou");
    when(repositorySettings.getPrivateKey()).thenReturn("Private Key");
    when(repositorySettings.getPrivateKeyFileName()).thenReturn("foo.txt");
    when(repositorySettings.getPrivateKeyPassword()).thenReturn("iloveyou");
    when(repositorySettings.getRepositoryUri()).thenReturn("Repository Uri");
    when(repositorySettings.getUsername()).thenReturn("janedoe");
    when(repositorySettings.getAuthMethod()).thenReturn(RepositoryAuthMethod.USERNAME_PASSWORD);
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(repositorySettings);
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        mock(AdminSettingsService.class), cache);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RepositorySettings settings = new RepositorySettings();

    // Act
    RepositorySettings actualRestoreResult = defaultTbRepositorySettingsService.restore(tenantId, settings);

    // Assert
    verify(cache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    verify(repositorySettings).getAuthMethod();
    verify(repositorySettings).getDefaultBranch();
    verify(repositorySettings).getPassword();
    verify(repositorySettings).getPrivateKey();
    verify(repositorySettings).getPrivateKeyFileName();
    verify(repositorySettings).getPrivateKeyPassword();
    verify(repositorySettings).getRepositoryUri();
    verify(repositorySettings).getUsername();
    verify(repositorySettings).isLocalOnly();
    verify(repositorySettings).isReadOnly();
    verify(repositorySettings).isShowMergeCommits();
    assertNull(settings.getPassword());
    assertSame(settings, actualRestoreResult);
  }

  /**
   * Test
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>When {@link RepositorySettings}
   * {@link RepositorySettings#getAuthMethod()} return
   * {@code USERNAME_PASSWORD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test restore(TenantId, RepositorySettings); when RepositorySettings getAuthMethod() return 'USERNAME_PASSWORD'")
  void testRestore_whenRepositorySettingsGetAuthMethodReturnUsernamePassword() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isLocalOnly()).thenReturn(true);
    when(repositorySettings.isReadOnly()).thenReturn(true);
    when(repositorySettings.isShowMergeCommits()).thenReturn(true);
    when(repositorySettings.getDefaultBranch()).thenReturn("janedoe/featurebranch");
    when(repositorySettings.getPassword()).thenReturn("iloveyou");
    when(repositorySettings.getPrivateKey()).thenReturn("Private Key");
    when(repositorySettings.getPrivateKeyFileName()).thenReturn("foo.txt");
    when(repositorySettings.getPrivateKeyPassword()).thenReturn("iloveyou");
    when(repositorySettings.getRepositoryUri()).thenReturn("Repository Uri");
    when(repositorySettings.getUsername()).thenReturn("janedoe");
    when(repositorySettings.getAuthMethod()).thenReturn(RepositoryAuthMethod.USERNAME_PASSWORD);
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(repositorySettings);
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        mock(AdminSettingsService.class), cache);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.getPassword()).thenReturn("iloveyou");
    when(settings.getAuthMethod()).thenReturn(RepositoryAuthMethod.USERNAME_PASSWORD);

    // Act
    RepositorySettings actualRestoreResult = defaultTbRepositorySettingsService.restore(tenantId, settings);

    // Assert
    verify(cache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    verify(repositorySettings).getAuthMethod();
    verify(settings).getAuthMethod();
    verify(repositorySettings).getDefaultBranch();
    verify(repositorySettings).getPassword();
    verify(settings).getPassword();
    verify(repositorySettings).getPrivateKey();
    verify(repositorySettings).getPrivateKeyFileName();
    verify(repositorySettings).getPrivateKeyPassword();
    verify(repositorySettings).getRepositoryUri();
    verify(repositorySettings).getUsername();
    verify(repositorySettings).isLocalOnly();
    verify(repositorySettings).isReadOnly();
    verify(repositorySettings).isShowMergeCommits();
    assertSame(settings, actualRestoreResult);
  }

  /**
   * Test
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>When {@link RepositorySettings} {@link RepositorySettings#getPassword()}
   * return {@code null}.</li>
   *   <li>Then calls {@link RepositorySettings#setPassword(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test restore(TenantId, RepositorySettings); when RepositorySettings getPassword() return 'null'; then calls setPassword(String)")
  void testRestore_whenRepositorySettingsGetPasswordReturnNull_thenCallsSetPassword() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isLocalOnly()).thenReturn(true);
    when(repositorySettings.isReadOnly()).thenReturn(true);
    when(repositorySettings.isShowMergeCommits()).thenReturn(true);
    when(repositorySettings.getDefaultBranch()).thenReturn("janedoe/featurebranch");
    when(repositorySettings.getPassword()).thenReturn("iloveyou");
    when(repositorySettings.getPrivateKey()).thenReturn("Private Key");
    when(repositorySettings.getPrivateKeyFileName()).thenReturn("foo.txt");
    when(repositorySettings.getPrivateKeyPassword()).thenReturn("iloveyou");
    when(repositorySettings.getRepositoryUri()).thenReturn("Repository Uri");
    when(repositorySettings.getUsername()).thenReturn("janedoe");
    when(repositorySettings.getAuthMethod()).thenReturn(RepositoryAuthMethod.USERNAME_PASSWORD);
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(repositorySettings);
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        mock(AdminSettingsService.class), cache);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.getPassword()).thenReturn(null);
    doNothing().when(settings).setPassword(Mockito.<String>any());
    when(settings.getAuthMethod()).thenReturn(RepositoryAuthMethod.USERNAME_PASSWORD);

    // Act
    RepositorySettings actualRestoreResult = defaultTbRepositorySettingsService.restore(tenantId, settings);

    // Assert
    verify(cache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    verify(repositorySettings).getAuthMethod();
    verify(settings).getAuthMethod();
    verify(repositorySettings).getDefaultBranch();
    verify(repositorySettings).getPassword();
    verify(settings).getPassword();
    verify(repositorySettings).getPrivateKey();
    verify(repositorySettings).getPrivateKeyFileName();
    verify(repositorySettings).getPrivateKeyPassword();
    verify(repositorySettings).getRepositoryUri();
    verify(repositorySettings).getUsername();
    verify(repositorySettings).isLocalOnly();
    verify(repositorySettings).isReadOnly();
    verify(repositorySettings).isShowMergeCommits();
    verify(settings).setPassword(eq("iloveyou"));
    assertSame(settings, actualRestoreResult);
  }

  /**
   * Test
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>When {@link RepositorySettings}
   * {@link RepositorySettings#getPrivateKey()} return {@code null}.</li>
   *   <li>Then calls {@link RepositorySettings#setPrivateKey(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRepositorySettingsService#restore(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test restore(TenantId, RepositorySettings); when RepositorySettings getPrivateKey() return 'null'; then calls setPrivateKey(String)")
  void testRestore_whenRepositorySettingsGetPrivateKeyReturnNull_thenCallsSetPrivateKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isLocalOnly()).thenReturn(true);
    when(repositorySettings.isReadOnly()).thenReturn(true);
    when(repositorySettings.isShowMergeCommits()).thenReturn(true);
    when(repositorySettings.getDefaultBranch()).thenReturn("janedoe/featurebranch");
    when(repositorySettings.getPassword()).thenReturn("iloveyou");
    when(repositorySettings.getPrivateKey()).thenReturn("Private Key");
    when(repositorySettings.getPrivateKeyFileName()).thenReturn("foo.txt");
    when(repositorySettings.getPrivateKeyPassword()).thenReturn("iloveyou");
    when(repositorySettings.getRepositoryUri()).thenReturn("Repository Uri");
    when(repositorySettings.getUsername()).thenReturn("janedoe");
    when(repositorySettings.getAuthMethod()).thenReturn(RepositoryAuthMethod.USERNAME_PASSWORD);
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(repositorySettings);
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        mock(AdminSettingsService.class), cache);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.getPrivateKey()).thenReturn(null);
    when(settings.getPrivateKeyPassword()).thenReturn("iloveyou");
    doNothing().when(settings).setPrivateKey(Mockito.<String>any());
    when(settings.getPassword()).thenReturn("iloveyou");
    when(settings.getAuthMethod()).thenReturn(RepositoryAuthMethod.PRIVATE_KEY);

    // Act
    RepositorySettings actualRestoreResult = defaultTbRepositorySettingsService.restore(tenantId, settings);

    // Assert
    verify(cache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    verify(repositorySettings).getAuthMethod();
    verify(settings).getAuthMethod();
    verify(repositorySettings).getDefaultBranch();
    verify(repositorySettings).getPassword();
    verify(repositorySettings).getPrivateKey();
    verify(settings).getPrivateKey();
    verify(repositorySettings).getPrivateKeyFileName();
    verify(repositorySettings).getPrivateKeyPassword();
    verify(settings).getPrivateKeyPassword();
    verify(repositorySettings).getRepositoryUri();
    verify(repositorySettings).getUsername();
    verify(repositorySettings).isLocalOnly();
    verify(repositorySettings).isReadOnly();
    verify(repositorySettings).isShowMergeCommits();
    verify(settings).setPrivateKey(eq("Private Key"));
    assertSame(settings, actualRestoreResult);
  }

  /**
   * Test {@link DefaultTbRepositorySettingsService#get(TenantId)}.
   * <p>
   * Method under test: {@link DefaultTbRepositorySettingsService#get(TenantId)}
   */
  @Test
  @DisplayName("Test get(TenantId)")
  void testGet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    // Act
    RepositorySettings actualGetResult = defaultTbRepositorySettingsService.get(new TenantId(UUID.randomUUID()));

    // Assert
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbRepositorySettingsService#get(TenantId)}.
   * <p>
   * Method under test: {@link DefaultTbRepositorySettingsService#get(TenantId)}
   */
  @Test
  @DisplayName("Test get(TenantId)")
  void testGet2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService,
        new RepositorySettingsRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory()));

    // Act
    RepositorySettings actualGetResult = defaultTbRepositorySettingsService.get(new TenantId(UUID.randomUUID()));

    // Assert
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbRepositorySettingsService#get(TenantId)}.
   * <ul>
   *   <li>Given {@link AdminSettings} {@link AdminSettings#getJsonValue()} return
   * Instance.</li>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRepositorySettingsService#get(TenantId)}
   */
  @Test
  @DisplayName("Test get(TenantId); given AdminSettings getJsonValue() return Instance; then calls getJsonValue()")
  void testGet_givenAdminSettingsGetJsonValueReturnInstance_thenCallsGetJsonValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    // Act
    RepositorySettings actualGetResult = defaultTbRepositorySettingsService.get(new TenantId(UUID.randomUUID()));

    // Assert
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbRepositorySettingsService#get(TenantId)}.
   * <ul>
   *   <li>Given {@link AdminSettingsService}
   * {@link AdminSettingsService#findAdminSettingsByTenantIdAndKey(TenantId, String)}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRepositorySettingsService#get(TenantId)}
   */
  @Test
  @DisplayName("Test get(TenantId); given AdminSettingsService findAdminSettingsByTenantIdAndKey(TenantId, String) return 'null'")
  void testGet_givenAdminSettingsServiceFindAdminSettingsByTenantIdAndKeyReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    // Act
    RepositorySettings actualGetResult = defaultTbRepositorySettingsService.get(new TenantId(UUID.randomUUID()));

    // Assert
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbRepositorySettingsService#get(TenantId)}.
   * <ul>
   *   <li>Given {@link RepositorySettings} {@link RepositorySettings#isLocalOnly()}
   * return {@code true}.</li>
   *   <li>Then return {@code Private Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRepositorySettingsService#get(TenantId)}
   */
  @Test
  @DisplayName("Test get(TenantId); given RepositorySettings isLocalOnly() return 'true'; then return 'Private Key'")
  void testGet_givenRepositorySettingsIsLocalOnlyReturnTrue_thenReturnPrivateKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isLocalOnly()).thenReturn(true);
    when(repositorySettings.isReadOnly()).thenReturn(true);
    when(repositorySettings.isShowMergeCommits()).thenReturn(true);
    when(repositorySettings.getDefaultBranch()).thenReturn("janedoe/featurebranch");
    when(repositorySettings.getPassword()).thenReturn("iloveyou");
    when(repositorySettings.getPrivateKey()).thenReturn("Private Key");
    when(repositorySettings.getPrivateKeyFileName()).thenReturn("foo.txt");
    when(repositorySettings.getPrivateKeyPassword()).thenReturn("iloveyou");
    when(repositorySettings.getRepositoryUri()).thenReturn("Repository Uri");
    when(repositorySettings.getUsername()).thenReturn("janedoe");
    when(repositorySettings.getAuthMethod()).thenReturn(RepositoryAuthMethod.USERNAME_PASSWORD);
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(repositorySettings);
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        mock(AdminSettingsService.class), cache);

    // Act
    RepositorySettings actualGetResult = defaultTbRepositorySettingsService.get(new TenantId(UUID.randomUUID()));

    // Assert
    verify(cache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    verify(repositorySettings).getAuthMethod();
    verify(repositorySettings).getDefaultBranch();
    verify(repositorySettings).getPassword();
    verify(repositorySettings).getPrivateKey();
    verify(repositorySettings).getPrivateKeyFileName();
    verify(repositorySettings).getPrivateKeyPassword();
    verify(repositorySettings).getRepositoryUri();
    verify(repositorySettings).getUsername();
    verify(repositorySettings).isLocalOnly();
    verify(repositorySettings).isReadOnly();
    verify(repositorySettings).isShowMergeCommits();
    assertEquals("Private Key", actualGetResult.getPrivateKey());
    assertEquals("Repository Uri", actualGetResult.getRepositoryUri());
    assertEquals("foo.txt", actualGetResult.getPrivateKeyFileName());
    assertEquals("iloveyou", actualGetResult.getPassword());
    assertEquals("iloveyou", actualGetResult.getPrivateKeyPassword());
    assertEquals("janedoe", actualGetResult.getUsername());
    assertEquals("janedoe/featurebranch", actualGetResult.getDefaultBranch());
    assertEquals(RepositoryAuthMethod.USERNAME_PASSWORD, actualGetResult.getAuthMethod());
    assertTrue(actualGetResult.isLocalOnly());
    assertTrue(actualGetResult.isReadOnly());
    assertTrue(actualGetResult.isShowMergeCommits());
  }

  /**
   * Test {@link DefaultTbRepositorySettingsService#get(TenantId)}.
   * <ul>
   *   <li>Then return {@link RepositorySettings#RepositorySettings()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRepositorySettingsService#get(TenantId)}
   */
  @Test
  @DisplayName("Test get(TenantId); then return RepositorySettings()")
  void testGet_thenReturnRepositorySettings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    RepositorySettings repositorySettings = new RepositorySettings();
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(repositorySettings);
    DefaultTbRepositorySettingsService defaultTbRepositorySettingsService = new DefaultTbRepositorySettingsService(
        mock(AdminSettingsService.class), cache);

    // Act
    RepositorySettings actualGetResult = defaultTbRepositorySettingsService.get(new TenantId(UUID.randomUUID()));

    // Assert
    verify(cache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    assertEquals(repositorySettings, actualGetResult);
  }
}
