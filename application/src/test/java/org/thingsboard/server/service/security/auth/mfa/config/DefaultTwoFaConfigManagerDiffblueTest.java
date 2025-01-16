package org.thingsboard.server.service.security.auth.mfa.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserAuthSettingsId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.UserAuthSettings;
import org.thingsboard.server.common.data.security.model.mfa.PlatformTwoFaSettings;
import org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings;
import org.thingsboard.server.common.data.security.model.mfa.account.BackupCodeTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.account.TwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.settings.AdminSettingsDao;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.dao.user.UserAuthSettingsDao;
import org.thingsboard.server.service.security.auth.mfa.TwoFactorAuthService;

@ContextConfiguration(classes = {DefaultTwoFaConfigManager.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DefaultTwoFaConfigManagerDiffblueTest {
  @MockBean
  private AdminSettingsDao adminSettingsDao;

  @MockBean
  private AdminSettingsService adminSettingsService;

  @Autowired
  private DefaultTwoFaConfigManager defaultTwoFaConfigManager;

  @MockBean
  private TwoFactorAuthService twoFactorAuthService;

  @MockBean
  private UserAuthSettingsDao userAuthSettingsDao;

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getAccountTwoFaSettings(TenantId, UserId)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getAccountTwoFaSettings(TenantId, UserId)}
   */
  @Test
  @DisplayName("Test getAccountTwoFaSettings(TenantId, UserId)")
  void testGetAccountTwoFaSettings() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    when(userAuthSettings.getTwoFaSettings()).thenReturn(accountTwoFaSettings);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    Optional<AccountTwoFaSettings> actualAccountTwoFaSettings = defaultTwoFaConfigManager
        .getAccountTwoFaSettings(new TenantId(UUID.randomUUID()), null);

    // Assert
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).getTwoFaSettings();
    verify(userAuthSettings).setTwoFaSettings(isA(AccountTwoFaSettings.class));
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    verify(userAuthSettingsDao).findByUserId(isNull());
    assertTrue(actualAccountTwoFaSettings.isPresent());
    assertSame(accountTwoFaSettings, actualAccountTwoFaSettings.get());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getAccountTwoFaSettings(TenantId, UserId)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getAccountTwoFaSettings(TenantId, UserId)}
   */
  @Test
  @DisplayName("Test getAccountTwoFaSettings(TenantId, UserId)")
  void testGetAccountTwoFaSettings2() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.put(TwoFaProviderType.TOTP, new BackupCodeTwoFaAccountConfig());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(configs);
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    when(userAuthSettings.getTwoFaSettings()).thenReturn(accountTwoFaSettings);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    AccountTwoFaSettings twoFaSettings2 = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings2).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings2.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings2 = mock(UserAuthSettings.class);
    doNothing().when(userAuthSettings2).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings2).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings2).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings2).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings2.setCreatedTime(1L);
    userAuthSettings2.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings2.setTwoFaSettings(twoFaSettings2);
    userAuthSettings2.setUserId(null);
    when(userAuthSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserAuthSettings>any()))
        .thenReturn(userAuthSettings2);
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    Optional<AccountTwoFaSettings> actualAccountTwoFaSettings = defaultTwoFaConfigManager
        .getAccountTwoFaSettings(new TenantId(UUID.randomUUID()), null);

    // Assert
    verify(userAuthSettings2).setCreatedTime(eq(1L));
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings2).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).getTwoFaSettings();
    verify(userAuthSettings2).setTwoFaSettings(isA(AccountTwoFaSettings.class));
    verify(userAuthSettings, atLeast(1)).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    verify(userAuthSettings2).setUserId(isNull());
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings2).setConfigs(isA(LinkedHashMap.class));
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsDao).save(isA(TenantId.class), isA(UserAuthSettings.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    verify(userAuthSettingsDao, atLeast(1)).findByUserId(isNull());
    assertTrue(actualAccountTwoFaSettings.isPresent());
    assertSame(accountTwoFaSettings, actualAccountTwoFaSettings.get());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getAccountTwoFaSettings(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link LinkedHashMap#LinkedHashMap()} {@code SMS} is
   * {@link BackupCodeTwoFaAccountConfig} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getAccountTwoFaSettings(TenantId, UserId)}
   */
  @Test
  @DisplayName("Test getAccountTwoFaSettings(TenantId, UserId); given LinkedHashMap() 'SMS' is BackupCodeTwoFaAccountConfig (default constructor)")
  void testGetAccountTwoFaSettings_givenLinkedHashMapSmsIsBackupCodeTwoFaAccountConfig() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.put(TwoFaProviderType.SMS, new BackupCodeTwoFaAccountConfig());
    configs.put(TwoFaProviderType.TOTP, new BackupCodeTwoFaAccountConfig());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(configs);
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    when(userAuthSettings.getTwoFaSettings()).thenReturn(accountTwoFaSettings);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    AccountTwoFaSettings twoFaSettings2 = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings2).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings2.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings2 = mock(UserAuthSettings.class);
    doNothing().when(userAuthSettings2).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings2).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings2).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings2).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings2.setCreatedTime(1L);
    userAuthSettings2.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings2.setTwoFaSettings(twoFaSettings2);
    userAuthSettings2.setUserId(null);
    when(userAuthSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserAuthSettings>any()))
        .thenReturn(userAuthSettings2);
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    Optional<AccountTwoFaSettings> actualAccountTwoFaSettings = defaultTwoFaConfigManager
        .getAccountTwoFaSettings(new TenantId(UUID.randomUUID()), null);

    // Assert
    verify(userAuthSettings2).setCreatedTime(eq(1L));
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings2).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).getTwoFaSettings();
    verify(userAuthSettings2).setTwoFaSettings(isA(AccountTwoFaSettings.class));
    verify(userAuthSettings, atLeast(1)).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    verify(userAuthSettings2).setUserId(isNull());
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings2).setConfigs(isA(LinkedHashMap.class));
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsDao).save(isA(TenantId.class), isA(UserAuthSettings.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    verify(userAuthSettingsDao, atLeast(1)).findByUserId(isNull());
    assertTrue(actualAccountTwoFaSettings.isPresent());
    assertSame(accountTwoFaSettings, actualAccountTwoFaSettings.get());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getAccountTwoFaSettings(TenantId, UserId)}.
   * <ul>
   *   <li>Then calls {@link Dao#save(TenantId, Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getAccountTwoFaSettings(TenantId, UserId)}
   */
  @Test
  @DisplayName("Test getAccountTwoFaSettings(TenantId, UserId); then calls save(TenantId, Object)")
  void testGetAccountTwoFaSettings_thenCallsSave() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.put(TwoFaProviderType.TOTP, new BackupCodeTwoFaAccountConfig());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(configs);
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    when(userAuthSettings.getTwoFaSettings()).thenReturn(accountTwoFaSettings);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    AccountTwoFaSettings twoFaSettings2 = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings2).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings2.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings2 = mock(UserAuthSettings.class);
    doNothing().when(userAuthSettings2).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings2).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings2).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings2).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings2.setCreatedTime(1L);
    userAuthSettings2.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings2.setTwoFaSettings(twoFaSettings2);
    userAuthSettings2.setUserId(null);
    when(userAuthSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserAuthSettings>any()))
        .thenReturn(userAuthSettings2);
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    Optional<AccountTwoFaSettings> actualAccountTwoFaSettings = defaultTwoFaConfigManager
        .getAccountTwoFaSettings(new TenantId(UUID.randomUUID()), null);

    // Assert
    verify(userAuthSettings2).setCreatedTime(eq(1L));
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings2).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).getTwoFaSettings();
    verify(userAuthSettings2).setTwoFaSettings(isA(AccountTwoFaSettings.class));
    verify(userAuthSettings, atLeast(1)).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    verify(userAuthSettings2).setUserId(isNull());
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings2).setConfigs(isA(LinkedHashMap.class));
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsDao).save(isA(TenantId.class), isA(UserAuthSettings.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    verify(userAuthSettingsDao, atLeast(1)).findByUserId(isNull());
    assertTrue(actualAccountTwoFaSettings.isPresent());
    assertSame(accountTwoFaSettings, actualAccountTwoFaSettings.get());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getAccountTwoFaSettings(TenantId, UserId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getAccountTwoFaSettings(TenantId, UserId)}
   */
  @Test
  @DisplayName("Test getAccountTwoFaSettings(TenantId, UserId); then throw IllegalArgumentException")
  void testGetAccountTwoFaSettings_thenThrowIllegalArgumentException() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("twoFaSettings"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultTwoFaConfigManager.getAccountTwoFaSettings(new TenantId(UUID.randomUUID()), null));
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).setTwoFaSettings(isA(AccountTwoFaSettings.class));
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#saveAccountTwoFaSettings(TenantId, UserId, AccountTwoFaSettings)}.
   * <ul>
   *   <li>Then return {@link AccountTwoFaSettings} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#saveAccountTwoFaSettings(TenantId, UserId, AccountTwoFaSettings)}
   */
  @Test
  @DisplayName("Test saveAccountTwoFaSettings(TenantId, UserId, AccountTwoFaSettings); then return AccountTwoFaSettings (default constructor)")
  void testSaveAccountTwoFaSettings_thenReturnAccountTwoFaSettings() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    AccountTwoFaSettings twoFaSettings2 = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings2).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings2.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings2 = mock(UserAuthSettings.class);
    doNothing().when(userAuthSettings2).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings2).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings2).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings2).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings2.setCreatedTime(1L);
    userAuthSettings2.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings2.setTwoFaSettings(twoFaSettings2);
    userAuthSettings2.setUserId(null);
    when(userAuthSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserAuthSettings>any()))
        .thenReturn(userAuthSettings);
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings2);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    AccountTwoFaSettings settings = new AccountTwoFaSettings();
    settings.setConfigs(new LinkedHashMap<>());

    // Act
    AccountTwoFaSettings actualSaveAccountTwoFaSettingsResult = defaultTwoFaConfigManager
        .saveAccountTwoFaSettings(tenantId, null, settings);

    // Assert
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings2).setCreatedTime(eq(1L));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings2).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).setTwoFaSettings(isA(AccountTwoFaSettings.class));
    verify(userAuthSettings2, atLeast(1)).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    verify(userAuthSettings).setUserId(isNull());
    verify(userAuthSettings2).setUserId(isNull());
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(twoFaSettings2).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsDao).save(isA(TenantId.class), isA(UserAuthSettings.class));
    verify(userAuthSettingsDao).findByUserId(isNull());
    assertSame(settings, actualSaveAccountTwoFaSettingsResult);
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#saveAccountTwoFaSettings(TenantId, UserId, AccountTwoFaSettings)}.
   * <ul>
   *   <li>Then return Configs size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#saveAccountTwoFaSettings(TenantId, UserId, AccountTwoFaSettings)}
   */
  @Test
  @DisplayName("Test saveAccountTwoFaSettings(TenantId, UserId, AccountTwoFaSettings); then return Configs size is one")
  void testSaveAccountTwoFaSettings_thenReturnConfigsSizeIsOne() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    AccountTwoFaSettings twoFaSettings2 = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings2).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings2.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings2 = mock(UserAuthSettings.class);
    doNothing().when(userAuthSettings2).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings2).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings2).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings2).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings2.setCreatedTime(1L);
    userAuthSettings2.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings2.setTwoFaSettings(twoFaSettings2);
    userAuthSettings2.setUserId(null);
    when(userAuthSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserAuthSettings>any()))
        .thenReturn(userAuthSettings);
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings2);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    configs.put(TwoFaProviderType.TOTP, backupCodeTwoFaAccountConfig);

    AccountTwoFaSettings settings = new AccountTwoFaSettings();
    settings.setConfigs(configs);

    // Act
    AccountTwoFaSettings actualSaveAccountTwoFaSettingsResult = defaultTwoFaConfigManager
        .saveAccountTwoFaSettings(tenantId, null, settings);

    // Assert
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings2).setCreatedTime(eq(1L));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings2).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).setTwoFaSettings(isA(AccountTwoFaSettings.class));
    verify(userAuthSettings2, atLeast(1)).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    verify(userAuthSettings).setUserId(isNull());
    verify(userAuthSettings2).setUserId(isNull());
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(twoFaSettings2).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsDao).save(isA(TenantId.class), isA(UserAuthSettings.class));
    verify(userAuthSettingsDao).findByUserId(isNull());
    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs2 = actualSaveAccountTwoFaSettingsResult.getConfigs();
    assertEquals(1, configs2.size());
    assertSame(backupCodeTwoFaAccountConfig, configs2.get(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test getTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)")
  void testGetTwoFaAccountConfig() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    when(userAuthSettings.getTwoFaSettings()).thenReturn(accountTwoFaSettings);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    Optional<TwoFaAccountConfig> actualTwoFaAccountConfig = defaultTwoFaConfigManager
        .getTwoFaAccountConfig(new TenantId(UUID.randomUUID()), null, TwoFaProviderType.TOTP);

    // Assert
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).getTwoFaSettings();
    verify(userAuthSettings).setTwoFaSettings(isA(AccountTwoFaSettings.class));
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    verify(userAuthSettingsDao).findByUserId(isNull());
    assertFalse(actualTwoFaAccountConfig.isPresent());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test getTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)")
  void testGetTwoFaAccountConfig2() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.put(TwoFaProviderType.TOTP, new BackupCodeTwoFaAccountConfig());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(configs);
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    when(userAuthSettings.getTwoFaSettings()).thenReturn(accountTwoFaSettings);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    AccountTwoFaSettings twoFaSettings2 = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings2).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings2.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings2 = mock(UserAuthSettings.class);
    doNothing().when(userAuthSettings2).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings2).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings2).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings2).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings2.setCreatedTime(1L);
    userAuthSettings2.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings2.setTwoFaSettings(twoFaSettings2);
    userAuthSettings2.setUserId(null);
    when(userAuthSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserAuthSettings>any()))
        .thenReturn(userAuthSettings2);
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    Optional<TwoFaAccountConfig> actualTwoFaAccountConfig = defaultTwoFaConfigManager
        .getTwoFaAccountConfig(new TenantId(UUID.randomUUID()), null, TwoFaProviderType.TOTP);

    // Assert
    verify(userAuthSettings2).setCreatedTime(eq(1L));
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings2).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).getTwoFaSettings();
    verify(userAuthSettings2).setTwoFaSettings(isA(AccountTwoFaSettings.class));
    verify(userAuthSettings, atLeast(1)).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    verify(userAuthSettings2).setUserId(isNull());
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings2).setConfigs(isA(LinkedHashMap.class));
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsDao).save(isA(TenantId.class), isA(UserAuthSettings.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    verify(userAuthSettingsDao, atLeast(1)).findByUserId(isNull());
    assertFalse(actualTwoFaAccountConfig.isPresent());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}.
   * <ul>
   *   <li>Given {@link LinkedHashMap#LinkedHashMap()} {@code SMS} is
   * {@link BackupCodeTwoFaAccountConfig} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test getTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType); given LinkedHashMap() 'SMS' is BackupCodeTwoFaAccountConfig (default constructor)")
  void testGetTwoFaAccountConfig_givenLinkedHashMapSmsIsBackupCodeTwoFaAccountConfig() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.put(TwoFaProviderType.SMS, new BackupCodeTwoFaAccountConfig());
    configs.put(TwoFaProviderType.TOTP, new BackupCodeTwoFaAccountConfig());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(configs);
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    when(userAuthSettings.getTwoFaSettings()).thenReturn(accountTwoFaSettings);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    AccountTwoFaSettings twoFaSettings2 = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings2).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings2.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings2 = mock(UserAuthSettings.class);
    doNothing().when(userAuthSettings2).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings2).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings2).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings2).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings2.setCreatedTime(1L);
    userAuthSettings2.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings2.setTwoFaSettings(twoFaSettings2);
    userAuthSettings2.setUserId(null);
    when(userAuthSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserAuthSettings>any()))
        .thenReturn(userAuthSettings2);
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    Optional<TwoFaAccountConfig> actualTwoFaAccountConfig = defaultTwoFaConfigManager
        .getTwoFaAccountConfig(new TenantId(UUID.randomUUID()), null, TwoFaProviderType.TOTP);

    // Assert
    verify(userAuthSettings2).setCreatedTime(eq(1L));
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings2).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).getTwoFaSettings();
    verify(userAuthSettings2).setTwoFaSettings(isA(AccountTwoFaSettings.class));
    verify(userAuthSettings, atLeast(1)).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    verify(userAuthSettings2).setUserId(isNull());
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings2).setConfigs(isA(LinkedHashMap.class));
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsDao).save(isA(TenantId.class), isA(UserAuthSettings.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    verify(userAuthSettingsDao, atLeast(1)).findByUserId(isNull());
    assertFalse(actualTwoFaAccountConfig.isPresent());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}.
   * <ul>
   *   <li>Then calls {@link Dao#save(TenantId, Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test getTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType); then calls save(TenantId, Object)")
  void testGetTwoFaAccountConfig_thenCallsSave() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.put(TwoFaProviderType.TOTP, new BackupCodeTwoFaAccountConfig());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(configs);
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    when(userAuthSettings.getTwoFaSettings()).thenReturn(accountTwoFaSettings);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    AccountTwoFaSettings twoFaSettings2 = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings2).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings2.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings2 = mock(UserAuthSettings.class);
    doNothing().when(userAuthSettings2).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings2).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings2).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings2).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings2.setCreatedTime(1L);
    userAuthSettings2.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings2.setTwoFaSettings(twoFaSettings2);
    userAuthSettings2.setUserId(null);
    when(userAuthSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserAuthSettings>any()))
        .thenReturn(userAuthSettings2);
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    Optional<TwoFaAccountConfig> actualTwoFaAccountConfig = defaultTwoFaConfigManager
        .getTwoFaAccountConfig(new TenantId(UUID.randomUUID()), null, TwoFaProviderType.TOTP);

    // Assert
    verify(userAuthSettings2).setCreatedTime(eq(1L));
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings2).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).getTwoFaSettings();
    verify(userAuthSettings2).setTwoFaSettings(isA(AccountTwoFaSettings.class));
    verify(userAuthSettings, atLeast(1)).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    verify(userAuthSettings2).setUserId(isNull());
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings2).setConfigs(isA(LinkedHashMap.class));
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsDao).save(isA(TenantId.class), isA(UserAuthSettings.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    verify(userAuthSettingsDao, atLeast(1)).findByUserId(isNull());
    assertFalse(actualTwoFaAccountConfig.isPresent());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test getTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType); then throw IllegalArgumentException")
  void testGetTwoFaAccountConfig_thenThrowIllegalArgumentException() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("twoFaSettings"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTwoFaConfigManager
        .getTwoFaAccountConfig(new TenantId(UUID.randomUUID()), null, TwoFaProviderType.TOTP));
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).setTwoFaSettings(isA(AccountTwoFaSettings.class));
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)")
  void testSaveTwoFaAccountConfig() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultTwoFaConfigManager.saveTwoFaAccountConfig(tenantId, null, new BackupCodeTwoFaAccountConfig()));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)")
  void testSaveTwoFaAccountConfig2() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultTwoFaConfigManager.saveTwoFaAccountConfig(tenantId, null, new BackupCodeTwoFaAccountConfig()));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_ARRAY}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig); given ArrayNode asToken() return 'END_ARRAY'; then calls asToken()")
  void testSaveTwoFaAccountConfig_givenArrayNodeAsTokenReturnEndArray_thenCallsAsToken() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_ARRAY);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultTwoFaConfigManager.saveTwoFaAccountConfig(tenantId, null, new BackupCodeTwoFaAccountConfig()));
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_OBJECT}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig); given ArrayNode asToken() return 'END_OBJECT'; then calls asToken()")
  void testSaveTwoFaAccountConfig_givenArrayNodeAsTokenReturnEndObject_thenCallsAsToken() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultTwoFaConfigManager.saveTwoFaAccountConfig(tenantId, null, new BackupCodeTwoFaAccountConfig()));
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code VALUE_NULL}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig); given ArrayNode asToken() return 'VALUE_NULL'; then calls asToken()")
  void testSaveTwoFaAccountConfig_givenArrayNodeAsTokenReturnValueNull_thenCallsAsToken() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.VALUE_NULL);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultTwoFaConfigManager.saveTwoFaAccountConfig(tenantId, null, new BackupCodeTwoFaAccountConfig()));
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)}.
   * <ul>
   *   <li>Then calls {@link ArrayNode#elements()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig); then calls elements()")
  void testSaveTwoFaAccountConfig_thenCallsElements() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.elements()).thenThrow(new IllegalArgumentException("foo"));
    when(arrayNode.asToken()).thenReturn(JsonToken.START_ARRAY);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultTwoFaConfigManager.saveTwoFaAccountConfig(tenantId, null, new BackupCodeTwoFaAccountConfig()));
    verify(arrayNode, atLeast(1)).asToken();
    verify(arrayNode).elements();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)}.
   * <ul>
   *   <li>Then calls {@link JsonNode#fields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test saveTwoFaAccountConfig(TenantId, UserId, TwoFaAccountConfig); then calls fields()")
  void testSaveTwoFaAccountConfig_thenCallsFields() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(arrayNode.fields()).thenReturn(entryList.iterator());
    when(arrayNode.asToken()).thenReturn(JsonToken.START_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultTwoFaConfigManager.saveTwoFaAccountConfig(tenantId, null, new BackupCodeTwoFaAccountConfig()));
    verify(arrayNode).fields();
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)")
  void testDeleteTwoFaAccountConfig() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    when(userAuthSettings.getTwoFaSettings()).thenReturn(accountTwoFaSettings);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    when(userAuthSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserAuthSettings>any()))
        .thenThrow(new IllegalArgumentException("twoFaSettings"));
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTwoFaConfigManager
        .deleteTwoFaAccountConfig(new TenantId(UUID.randomUUID()), null, TwoFaProviderType.TOTP));
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).getTwoFaSettings();
    verify(userAuthSettings, atLeast(1)).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsDao).save(isA(TenantId.class), isA(UserAuthSettings.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    verify(userAuthSettingsDao, atLeast(1)).findByUserId(isNull());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)")
  void testDeleteTwoFaAccountConfig2() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("twoFaSettings"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTwoFaConfigManager
        .deleteTwoFaAccountConfig(new TenantId(UUID.randomUUID()), null, TwoFaProviderType.TOTP));
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).setTwoFaSettings(isA(AccountTwoFaSettings.class));
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)")
  void testDeleteTwoFaAccountConfig3() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.put(TwoFaProviderType.TOTP, new BackupCodeTwoFaAccountConfig());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(configs);
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    when(userAuthSettings.getTwoFaSettings()).thenReturn(accountTwoFaSettings);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    when(userAuthSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserAuthSettings>any()))
        .thenThrow(new IllegalArgumentException("twoFaSettings"));
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTwoFaConfigManager
        .deleteTwoFaAccountConfig(new TenantId(UUID.randomUUID()), null, TwoFaProviderType.TOTP));
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).getTwoFaSettings();
    verify(userAuthSettings, atLeast(1)).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsDao).save(isA(TenantId.class), isA(UserAuthSettings.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    verify(userAuthSettingsDao, atLeast(1)).findByUserId(isNull());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)")
  void testDeleteTwoFaAccountConfig4() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    when(userAuthSettings.getTwoFaSettings()).thenReturn(accountTwoFaSettings);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    when(userAuthSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserAuthSettings>any()))
        .thenThrow(new IllegalArgumentException("twoFaSettings"));
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTwoFaConfigManager
        .deleteTwoFaAccountConfig(new TenantId(UUID.randomUUID()), null, TwoFaProviderType.TOTP));
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).getTwoFaSettings();
    verify(userAuthSettings, atLeast(1)).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsDao).save(isA(TenantId.class), isA(UserAuthSettings.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    verify(userAuthSettingsDao, atLeast(1)).findByUserId(isNull());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}.
   * <ul>
   *   <li>Given {@link LinkedHashMap#LinkedHashMap()} {@code SMS} is
   * {@link BackupCodeTwoFaAccountConfig} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType); given LinkedHashMap() 'SMS' is BackupCodeTwoFaAccountConfig (default constructor)")
  void testDeleteTwoFaAccountConfig_givenLinkedHashMapSmsIsBackupCodeTwoFaAccountConfig() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.put(TwoFaProviderType.SMS, new BackupCodeTwoFaAccountConfig());
    configs.put(TwoFaProviderType.TOTP, new BackupCodeTwoFaAccountConfig());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(configs);
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    when(userAuthSettings.getTwoFaSettings()).thenReturn(accountTwoFaSettings);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    when(userAuthSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserAuthSettings>any()))
        .thenThrow(new IllegalArgumentException("twoFaSettings"));
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTwoFaConfigManager
        .deleteTwoFaAccountConfig(new TenantId(UUID.randomUUID()), null, TwoFaProviderType.TOTP));
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).getTwoFaSettings();
    verify(userAuthSettings, atLeast(1)).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsDao).save(isA(TenantId.class), isA(UserAuthSettings.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    verify(userAuthSettingsDao, atLeast(1)).findByUserId(isNull());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}.
   * <ul>
   *   <li>Then calls {@link JsonNode#fields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType); then calls fields()")
  void testDeleteTwoFaAccountConfig_thenCallsFields() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    when(userAuthSettings.getTwoFaSettings()).thenReturn(accountTwoFaSettings);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    when(userAuthSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserAuthSettings>any()))
        .thenThrow(new IllegalArgumentException("twoFaSettings"));
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings);
    ArrayNode arrayNode = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(arrayNode.fields()).thenReturn(entryList.iterator());
    when(arrayNode.asToken()).thenReturn(JsonToken.START_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTwoFaConfigManager
        .deleteTwoFaAccountConfig(new TenantId(UUID.randomUUID()), null, TwoFaProviderType.TOTP));
    verify(arrayNode).fields();
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).getTwoFaSettings();
    verify(userAuthSettings, atLeast(1)).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsDao).save(isA(TenantId.class), isA(UserAuthSettings.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    verify(userAuthSettingsDao, atLeast(1)).findByUserId(isNull());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}.
   * <ul>
   *   <li>Then calls {@link JsonNode#fields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test deleteTwoFaAccountConfig(TenantId, UserId, TwoFaProviderType); then calls fields()")
  void testDeleteTwoFaAccountConfig_thenCallsFields2() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = mock(AccountTwoFaSettings.class);
    doNothing().when(twoFaSettings).setConfigs(Mockito.<LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig>>any());
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.put(TwoFaProviderType.SMS, new BackupCodeTwoFaAccountConfig());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(configs);
    UserAuthSettings userAuthSettings = mock(UserAuthSettings.class);
    when(userAuthSettings.getTwoFaSettings()).thenReturn(accountTwoFaSettings);
    doNothing().when(userAuthSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userAuthSettings).setCreatedTime(anyLong());
    doNothing().when(userAuthSettings).setId(Mockito.<UserAuthSettingsId>any());
    doNothing().when(userAuthSettings).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(UUID.randomUUID()));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);
    when(userAuthSettingsDao.save(Mockito.<TenantId>any(), Mockito.<UserAuthSettings>any()))
        .thenThrow(new IllegalArgumentException("twoFaSettings"));
    when(userAuthSettingsDao.findByUserId(Mockito.<UserId>any())).thenReturn(userAuthSettings);
    ArrayNode arrayNode = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(arrayNode.fields()).thenReturn(entryList.iterator());
    when(arrayNode.asToken()).thenReturn(JsonToken.START_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTwoFaConfigManager
        .deleteTwoFaAccountConfig(new TenantId(UUID.randomUUID()), null, TwoFaProviderType.TOTP));
    verify(arrayNode).fields();
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(userAuthSettings).setCreatedTime(eq(1L));
    verify(userAuthSettings).setId(isA(UserAuthSettingsId.class));
    verify(userAuthSettings).getTwoFaSettings();
    verify(userAuthSettings, atLeast(1)).setTwoFaSettings(Mockito.<AccountTwoFaSettings>any());
    verify(userAuthSettings).setUserId(isNull());
    verify(twoFaSettings).setConfigs(isA(LinkedHashMap.class));
    verify(userAuthSettingsDao).save(isA(TenantId.class), isA(UserAuthSettings.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    verify(userAuthSettingsDao, atLeast(1)).findByUserId(isNull());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getPlatformTwoFaSettings(TenantId, boolean)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getPlatformTwoFaSettings(TenantId, boolean)}
   */
  @Test
  @DisplayName("Test getPlatformTwoFaSettings(TenantId, boolean)")
  void testGetPlatformTwoFaSettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    Optional<PlatformTwoFaSettings> actualPlatformTwoFaSettings = defaultTwoFaConfigManager
        .getPlatformTwoFaSettings(new TenantId(UUID.randomUUID()), true);

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    assertFalse(actualPlatformTwoFaSettings.isPresent());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getPlatformTwoFaSettings(TenantId, boolean)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getPlatformTwoFaSettings(TenantId, boolean)}
   */
  @Test
  @DisplayName("Test getPlatformTwoFaSettings(TenantId, boolean)")
  void testGetPlatformTwoFaSettings2() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    Optional<PlatformTwoFaSettings> actualPlatformTwoFaSettings = defaultTwoFaConfigManager
        .getPlatformTwoFaSettings(new TenantId(UUID.randomUUID()), true);

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    assertFalse(actualPlatformTwoFaSettings.isPresent());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getPlatformTwoFaSettings(TenantId, boolean)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getPlatformTwoFaSettings(TenantId, boolean)}
   */
  @Test
  @DisplayName("Test getPlatformTwoFaSettings(TenantId, boolean)")
  void testGetPlatformTwoFaSettings3() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(arrayNode.fields()).thenReturn(entryList.iterator());
    when(arrayNode.asToken()).thenReturn(JsonToken.START_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    Optional<PlatformTwoFaSettings> actualPlatformTwoFaSettings = defaultTwoFaConfigManager
        .getPlatformTwoFaSettings(new TenantId(UUID.randomUUID()), true);

    // Assert
    verify(arrayNode).fields();
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    PlatformTwoFaSettings getResult = actualPlatformTwoFaSettings.get();
    assertNull(getResult.getMaxVerificationFailuresBeforeUserLockout());
    assertNull(getResult.getMinVerificationCodeSendPeriod());
    assertNull(getResult.getTotalAllowedTimeForVerification());
    assertNull(getResult.getVerificationCodeCheckRateLimit());
    assertNull(getResult.getProviders());
    assertTrue(actualPlatformTwoFaSettings.isPresent());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getPlatformTwoFaSettings(TenantId, boolean)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_ARRAY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getPlatformTwoFaSettings(TenantId, boolean)}
   */
  @Test
  @DisplayName("Test getPlatformTwoFaSettings(TenantId, boolean); given ArrayNode asToken() return 'END_ARRAY'")
  void testGetPlatformTwoFaSettings_givenArrayNodeAsTokenReturnEndArray() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_ARRAY);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    Optional<PlatformTwoFaSettings> actualPlatformTwoFaSettings = defaultTwoFaConfigManager
        .getPlatformTwoFaSettings(new TenantId(UUID.randomUUID()), true);

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    assertFalse(actualPlatformTwoFaSettings.isPresent());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getPlatformTwoFaSettings(TenantId, boolean)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getPlatformTwoFaSettings(TenantId, boolean)}
   */
  @Test
  @DisplayName("Test getPlatformTwoFaSettings(TenantId, boolean); given ArrayNode asToken() return 'END_OBJECT'")
  void testGetPlatformTwoFaSettings_givenArrayNodeAsTokenReturnEndObject() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    Optional<PlatformTwoFaSettings> actualPlatformTwoFaSettings = defaultTwoFaConfigManager
        .getPlatformTwoFaSettings(new TenantId(UUID.randomUUID()), true);

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    assertFalse(actualPlatformTwoFaSettings.isPresent());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getPlatformTwoFaSettings(TenantId, boolean)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code VALUE_NULL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getPlatformTwoFaSettings(TenantId, boolean)}
   */
  @Test
  @DisplayName("Test getPlatformTwoFaSettings(TenantId, boolean); given ArrayNode asToken() return 'VALUE_NULL'")
  void testGetPlatformTwoFaSettings_givenArrayNodeAsTokenReturnValueNull() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.VALUE_NULL);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    Optional<PlatformTwoFaSettings> actualPlatformTwoFaSettings = defaultTwoFaConfigManager
        .getPlatformTwoFaSettings(new TenantId(UUID.randomUUID()), true);

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    assertFalse(actualPlatformTwoFaSettings.isPresent());
  }

  /**
   * Test
   * {@link DefaultTwoFaConfigManager#getPlatformTwoFaSettings(TenantId, boolean)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#getPlatformTwoFaSettings(TenantId, boolean)}
   */
  @Test
  @DisplayName("Test getPlatformTwoFaSettings(TenantId, boolean); then throw IllegalArgumentException")
  void testGetPlatformTwoFaSettings_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.elements()).thenThrow(new IllegalArgumentException("foo"));
    when(arrayNode.asToken()).thenReturn(JsonToken.START_ARRAY);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultTwoFaConfigManager.getPlatformTwoFaSettings(new TenantId(UUID.randomUUID()), true));
    verify(arrayNode, atLeast(1)).asToken();
    verify(arrayNode).elements();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
  }

  /**
   * Test {@link DefaultTwoFaConfigManager#deletePlatformTwoFaSettings(TenantId)}.
   * <ul>
   *   <li>Given {@link AdminSettingsDao} {@link Dao#removeById(TenantId, UUID)}
   * does nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#deletePlatformTwoFaSettings(TenantId)}
   */
  @Test
  @DisplayName("Test deletePlatformTwoFaSettings(TenantId); given AdminSettingsDao removeById(TenantId, UUID) does nothing")
  void testDeletePlatformTwoFaSettings_givenAdminSettingsDaoRemoveByIdDoesNothing() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setId(new AdminSettingsId(UUID.randomUUID()));
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    doNothing().when(adminSettingsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    defaultTwoFaConfigManager.deletePlatformTwoFaSettings(new TenantId(UUID.randomUUID()));

    // Assert
    verify(adminSettingsDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
  }

  /**
   * Test {@link DefaultTwoFaConfigManager#deletePlatformTwoFaSettings(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFaConfigManager#deletePlatformTwoFaSettings(TenantId)}
   */
  @Test
  @DisplayName("Test deletePlatformTwoFaSettings(TenantId); then throw IllegalArgumentException")
  void testDeletePlatformTwoFaSettings_thenThrowIllegalArgumentException() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setId(new AdminSettingsId(UUID.randomUUID()));
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    doThrow(new IllegalArgumentException("twoFaSettings")).when(adminSettingsDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultTwoFaConfigManager.deletePlatformTwoFaSettings(new TenantId(UUID.randomUUID())));
    verify(adminSettingsDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
  }
}
