package org.thingsboard.server.service.security.auth.mfa.provider.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.security.model.mfa.account.BackupCodeTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.BackupCodeTwoFaProviderConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;
import org.thingsboard.server.service.security.model.SecurityUser;

class BackupCodeTwoFaProviderDiffblueTest {
  /**
   * Test
   * {@link BackupCodeTwoFaProvider#generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig)}
   * with {@code User}, {@code BackupCodeTwoFaProviderConfig}.
   * <p>
   * Method under test:
   * {@link BackupCodeTwoFaProvider#generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig) with 'User', 'BackupCodeTwoFaProviderConfig'")
  void testGenerateNewAccountConfigWithUserBackupCodeTwoFaProviderConfig() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaProvider backupCodeTwoFaProvider = new BackupCodeTwoFaProvider();
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
   * Test
   * {@link BackupCodeTwoFaProvider#generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig)}
   * with {@code User}, {@code BackupCodeTwoFaProviderConfig}.
   * <p>
   * Method under test:
   * {@link BackupCodeTwoFaProvider#generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig) with 'User', 'BackupCodeTwoFaProviderConfig'")
  void testGenerateNewAccountConfigWithUserBackupCodeTwoFaProviderConfig2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaProvider backupCodeTwoFaProvider = new BackupCodeTwoFaProvider();
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
   * Test
   * {@link BackupCodeTwoFaProvider#generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig)}
   * with {@code User}, {@code BackupCodeTwoFaProviderConfig}.
   * <ul>
   *   <li>When {@link User}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BackupCodeTwoFaProvider#generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, BackupCodeTwoFaProviderConfig) with 'User', 'BackupCodeTwoFaProviderConfig'; when User")
  void testGenerateNewAccountConfigWithUserBackupCodeTwoFaProviderConfig_whenUser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaProvider backupCodeTwoFaProvider = new BackupCodeTwoFaProvider();
    User user = mock(User.class);

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
   * Test
   * {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)}
   * with {@code SecurityUser}, {@code String},
   * {@code BackupCodeTwoFaProviderConfig}, {@code BackupCodeTwoFaAccountConfig}.
   * <p>
   * Method under test:
   * {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig) with 'SecurityUser', 'String', 'BackupCodeTwoFaProviderConfig', 'BackupCodeTwoFaAccountConfig'")
  void testCheckVerificationCodeWithSecurityUserStringBackupCodeTwoFaProviderConfigBackupCodeTwoFaAccountConfig() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaProvider backupCodeTwoFaProvider = new BackupCodeTwoFaProvider();
    SecurityUser user = new SecurityUser();

    BackupCodeTwoFaProviderConfig providerConfig = new BackupCodeTwoFaProviderConfig();
    providerConfig.setCodesQuantity(1);

    BackupCodeTwoFaAccountConfig accountConfig = new BackupCodeTwoFaAccountConfig();
    accountConfig.setCodes(new HashSet<>());
    accountConfig.setSerializeHiddenFields(true);
    accountConfig.setUseByDefault(true);

    // Act and Assert
    assertFalse(backupCodeTwoFaProvider.checkVerificationCode(user, "Code", providerConfig, accountConfig));
  }

  /**
   * Test
   * {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)}
   * with {@code SecurityUser}, {@code String},
   * {@code BackupCodeTwoFaProviderConfig}, {@code BackupCodeTwoFaAccountConfig}.
   * <p>
   * Method under test:
   * {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig) with 'SecurityUser', 'String', 'BackupCodeTwoFaProviderConfig', 'BackupCodeTwoFaAccountConfig'")
  void testCheckVerificationCodeWithSecurityUserStringBackupCodeTwoFaProviderConfigBackupCodeTwoFaAccountConfig2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaProvider backupCodeTwoFaProvider = new BackupCodeTwoFaProvider();
    SecurityUser user = new SecurityUser();

    BackupCodeTwoFaProviderConfig providerConfig = new BackupCodeTwoFaProviderConfig();
    providerConfig.setCodesQuantity(1);

    BackupCodeTwoFaAccountConfig accountConfig = new BackupCodeTwoFaAccountConfig();
    accountConfig.setSerializeHiddenFields(true);
    accountConfig.setUseByDefault(true);
    accountConfig.setCodes(null);

    // Act and Assert
    assertFalse(backupCodeTwoFaProvider.checkVerificationCode(user, "Code", providerConfig, accountConfig));
  }

  /**
   * Test
   * {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)}
   * with {@code SecurityUser}, {@code String},
   * {@code BackupCodeTwoFaProviderConfig}, {@code BackupCodeTwoFaAccountConfig}.
   * <p>
   * Method under test:
   * {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig) with 'SecurityUser', 'String', 'BackupCodeTwoFaProviderConfig', 'BackupCodeTwoFaAccountConfig'")
  void testCheckVerificationCodeWithSecurityUserStringBackupCodeTwoFaProviderConfigBackupCodeTwoFaAccountConfig3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaProvider backupCodeTwoFaProvider = new BackupCodeTwoFaProvider();
    SecurityUser user = mock(SecurityUser.class);

    BackupCodeTwoFaProviderConfig providerConfig = new BackupCodeTwoFaProviderConfig();
    providerConfig.setCodesQuantity(1);

    BackupCodeTwoFaAccountConfig accountConfig = new BackupCodeTwoFaAccountConfig();
    accountConfig.setCodes(new HashSet<>());
    accountConfig.setSerializeHiddenFields(true);
    accountConfig.setUseByDefault(true);

    // Act and Assert
    assertFalse(backupCodeTwoFaProvider.checkVerificationCode(user, "Code", providerConfig, accountConfig));
  }

  /**
   * Test
   * {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)}
   * with {@code SecurityUser}, {@code String},
   * {@code BackupCodeTwoFaProviderConfig}, {@code BackupCodeTwoFaAccountConfig}.
   * <p>
   * Method under test:
   * {@link BackupCodeTwoFaProvider#checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, BackupCodeTwoFaProviderConfig, BackupCodeTwoFaAccountConfig) with 'SecurityUser', 'String', 'BackupCodeTwoFaProviderConfig', 'BackupCodeTwoFaAccountConfig'")
  void testCheckVerificationCodeWithSecurityUserStringBackupCodeTwoFaProviderConfigBackupCodeTwoFaAccountConfig4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaProvider backupCodeTwoFaProvider = new BackupCodeTwoFaProvider();
    SecurityUser user = new SecurityUser();

    BackupCodeTwoFaProviderConfig providerConfig = new BackupCodeTwoFaProviderConfig();
    providerConfig.setCodesQuantity(1);

    HashSet<String> codes = new HashSet<>();
    codes.add("foo");

    BackupCodeTwoFaAccountConfig accountConfig = new BackupCodeTwoFaAccountConfig();
    accountConfig.setCodes(codes);
    accountConfig.setSerializeHiddenFields(true);
    accountConfig.setUseByDefault(true);

    // Act and Assert
    assertFalse(backupCodeTwoFaProvider.checkVerificationCode(user, "Code", providerConfig, accountConfig));
  }

  /**
   * Test {@link BackupCodeTwoFaProvider#getType()}.
   * <p>
   * Method under test: {@link BackupCodeTwoFaProvider#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals(TwoFaProviderType.BACKUP_CODE, (new BackupCodeTwoFaProvider()).getType());
  }
}
