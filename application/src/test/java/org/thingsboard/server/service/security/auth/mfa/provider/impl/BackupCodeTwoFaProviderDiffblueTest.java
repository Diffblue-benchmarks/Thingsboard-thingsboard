package org.thingsboard.server.service.security.auth.mfa.provider.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings;
import org.thingsboard.server.common.data.security.model.mfa.account.BackupCodeTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.account.TwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.BackupCodeTwoFaProviderConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;
import org.thingsboard.server.service.security.auth.mfa.config.TwoFaConfigManager;
import org.thingsboard.server.service.security.model.SecurityUser;

@ExtendWith(MockitoExtension.class)
class BackupCodeTwoFaProviderDiffblueTest {
  @InjectMocks
  private BackupCodeTwoFaProvider backupCodeTwoFaProvider;

  @Mock
  private TwoFaConfigManager twoFaConfigManager;

  /**
   * Test {@link BackupCodeTwoFaProvider#generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig)} with {@code User}, {@code BackupCodeTwoFaProviderConfig}.
   * <p>
   * Method under test: {@link BackupCodeTwoFaProvider#generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig) with 'User', 'BackupCodeTwoFaProviderConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BackupCodeTwoFaAccountConfig BackupCodeTwoFaProvider.generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig)"})
  void testGenerateNewAccountConfigWithUserBackupCodeTwoFaProviderConfig() {
    // Arrange
    User user = new User();

    BackupCodeTwoFaProviderConfig providerConfig = new BackupCodeTwoFaProviderConfig();
    providerConfig.setCodesQuantity(1);

    // Act
    BackupCodeTwoFaAccountConfig actualGenerateNewAccountConfigResult = backupCodeTwoFaProvider
        .generateNewAccountConfig(user, providerConfig);

    // Assert
    assertEquals(1, actualGenerateNewAccountConfigResult.getCodes().size());
    assertEquals(TwoFaProviderType.BACKUP_CODE, actualGenerateNewAccountConfigResult.getProviderType());
    assertFalse(actualGenerateNewAccountConfigResult.isUseByDefault());
    assertTrue(actualGenerateNewAccountConfigResult.isSerializeHiddenFields());
  }

  /**
   * Test {@link BackupCodeTwoFaProvider#generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig)} with {@code User}, {@code BackupCodeTwoFaProviderConfig}.
   * <p>
   * Method under test: {@link BackupCodeTwoFaProvider#generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig) with 'User', 'BackupCodeTwoFaProviderConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BackupCodeTwoFaAccountConfig BackupCodeTwoFaProvider.generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig)"})
  void testGenerateNewAccountConfigWithUserBackupCodeTwoFaProviderConfig2() {
    // Arrange
    User user = new User();
    BackupCodeTwoFaProviderConfig providerConfig = mock(BackupCodeTwoFaProviderConfig.class);
    when(providerConfig.getCodesQuantity()).thenReturn(0);
    doNothing().when(providerConfig).setCodesQuantity(anyInt());
    providerConfig.setCodesQuantity(1);

    // Act
    BackupCodeTwoFaAccountConfig actualGenerateNewAccountConfigResult = backupCodeTwoFaProvider
        .generateNewAccountConfig(user, providerConfig);

    // Assert
    verify(providerConfig).getCodesQuantity();
    verify(providerConfig).setCodesQuantity(eq(1));
    assertEquals(TwoFaProviderType.BACKUP_CODE, actualGenerateNewAccountConfigResult.getProviderType());
    assertFalse(actualGenerateNewAccountConfigResult.isUseByDefault());
    assertTrue(actualGenerateNewAccountConfigResult.getCodes().isEmpty());
    assertTrue(actualGenerateNewAccountConfigResult.isSerializeHiddenFields());
  }

  /**
   * Test {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)} with {@code SecurityUser}, {@code String}, {@code BackupCodeTwoFaProviderConfig}, {@code BackupCodeTwoFaAccountConfig}.
   * <p>
   * Method under test: {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig) with 'SecurityUser', 'String', 'BackupCodeTwoFaProviderConfig', 'BackupCodeTwoFaAccountConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean BackupCodeTwoFaProvider.checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)"})
  void testCheckVerificationCodeWithSecurityUserStringBackupCodeTwoFaProviderConfigBackupCodeTwoFaAccountConfig() {
    // Arrange
    SecurityUser user = new SecurityUser();

    BackupCodeTwoFaProviderConfig providerConfig = new BackupCodeTwoFaProviderConfig();
    providerConfig.setCodesQuantity(1);

    BackupCodeTwoFaAccountConfig accountConfig = new BackupCodeTwoFaAccountConfig();
    accountConfig.setCodes(new HashSet<>());
    accountConfig.setSerializeHiddenFields(true);
    accountConfig.setUseByDefault(true);

    // Act and Assert
    assertFalse(backupCodeTwoFaProvider.checkVerificationCode(user, "Code", providerConfig, accountConfig));
    assertTrue(accountConfig.getCodes().isEmpty());
  }

  /**
   * Test {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)} with {@code SecurityUser}, {@code String}, {@code BackupCodeTwoFaProviderConfig}, {@code BackupCodeTwoFaAccountConfig}.
   * <p>
   * Method under test: {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig) with 'SecurityUser', 'String', 'BackupCodeTwoFaProviderConfig', 'BackupCodeTwoFaAccountConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean BackupCodeTwoFaProvider.checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)"})
  void testCheckVerificationCodeWithSecurityUserStringBackupCodeTwoFaProviderConfigBackupCodeTwoFaAccountConfig2() {
    // Arrange
    SecurityUser user = new SecurityUser();

    BackupCodeTwoFaProviderConfig providerConfig = new BackupCodeTwoFaProviderConfig();
    providerConfig.setCodesQuantity(1);

    BackupCodeTwoFaAccountConfig accountConfig = new BackupCodeTwoFaAccountConfig();
    accountConfig.setSerializeHiddenFields(true);
    accountConfig.setUseByDefault(true);
    accountConfig.setCodes(null);

    // Act
    boolean actualCheckVerificationCodeResult = backupCodeTwoFaProvider.checkVerificationCode(user, "Code",
        providerConfig, accountConfig);

    // Assert
    assertNull(accountConfig.getCodes());
    assertFalse(actualCheckVerificationCodeResult);
  }

  /**
   * Test {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)} with {@code SecurityUser}, {@code String}, {@code BackupCodeTwoFaProviderConfig}, {@code BackupCodeTwoFaAccountConfig}.
   * <p>
   * Method under test: {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig) with 'SecurityUser', 'String', 'BackupCodeTwoFaProviderConfig', 'BackupCodeTwoFaAccountConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean BackupCodeTwoFaProvider.checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)"})
  void testCheckVerificationCodeWithSecurityUserStringBackupCodeTwoFaProviderConfigBackupCodeTwoFaAccountConfig3() {
    // Arrange
    SecurityUser user = new SecurityUser();

    BackupCodeTwoFaProviderConfig providerConfig = new BackupCodeTwoFaProviderConfig();
    providerConfig.setCodesQuantity(1);

    HashSet<String> codes = new HashSet<>();
    codes.add("foo");

    BackupCodeTwoFaAccountConfig accountConfig = new BackupCodeTwoFaAccountConfig();
    accountConfig.setCodes(codes);
    accountConfig.setSerializeHiddenFields(true);
    accountConfig.setUseByDefault(true);

    // Act
    boolean actualCheckVerificationCodeResult = backupCodeTwoFaProvider.checkVerificationCode(user, "Code",
        providerConfig, accountConfig);

    // Assert
    Set<String> codes2 = accountConfig.getCodes();
    assertEquals(1, codes2.size());
    assertFalse(actualCheckVerificationCodeResult);
    assertSame(codes, codes2);
  }

  /**
   * Test {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)} with {@code SecurityUser}, {@code String}, {@code BackupCodeTwoFaProviderConfig}, {@code BackupCodeTwoFaAccountConfig}.
   * <p>
   * Method under test: {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig) with 'SecurityUser', 'String', 'BackupCodeTwoFaProviderConfig', 'BackupCodeTwoFaAccountConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean BackupCodeTwoFaProvider.checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)"})
  void testCheckVerificationCodeWithSecurityUserStringBackupCodeTwoFaProviderConfigBackupCodeTwoFaAccountConfig4() {
    // Arrange
    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());
    when(twoFaConfigManager.saveTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaAccountConfig>any())).thenReturn(accountTwoFaSettings);
    SecurityUser user = new SecurityUser();

    BackupCodeTwoFaProviderConfig providerConfig = new BackupCodeTwoFaProviderConfig();
    providerConfig.setCodesQuantity(1);

    HashSet<String> codes = new HashSet<>();
    codes.add("42");

    BackupCodeTwoFaAccountConfig accountConfig = new BackupCodeTwoFaAccountConfig();
    accountConfig.setCodes(codes);
    accountConfig.setSerializeHiddenFields(true);
    accountConfig.setUseByDefault(true);

    // Act
    boolean actualCheckVerificationCodeResult = backupCodeTwoFaProvider.checkVerificationCode(user, "42",
        providerConfig, accountConfig);

    // Assert
    verify(twoFaConfigManager).saveTwoFaAccountConfig(isNull(), isNull(), isA(TwoFaAccountConfig.class));
    assertTrue(accountConfig.getCodes().isEmpty());
    assertTrue(actualCheckVerificationCodeResult);
  }

  /**
   * Test {@link BackupCodeTwoFaProvider#getType()}.
   * <p>
   * Method under test: {@link BackupCodeTwoFaProvider#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TwoFaProviderType BackupCodeTwoFaProvider.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals(TwoFaProviderType.BACKUP_CODE, (new BackupCodeTwoFaProvider()).getType());
  }
}
