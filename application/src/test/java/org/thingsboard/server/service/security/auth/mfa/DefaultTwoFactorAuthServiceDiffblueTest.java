package org.thingsboard.server.service.security.auth.mfa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.LockedException;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.model.mfa.PlatformTwoFaSettings;
import org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings;
import org.thingsboard.server.common.data.security.model.mfa.account.BackupCodeTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.account.TwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;
import org.thingsboard.server.service.security.auth.mfa.config.TwoFaConfigManager;

@ExtendWith(MockitoExtension.class)
class DefaultTwoFactorAuthServiceDiffblueTest {
  @InjectMocks
  private DefaultTwoFactorAuthService defaultTwoFactorAuthService;

  @Mock
  private TwoFaConfigManager twoFaConfigManager;

  /**
   * Test {@link DefaultTwoFactorAuthService#isTwoFaEnabled(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link TwoFaConfigManager} {@link TwoFaConfigManager#getAccountTwoFaSettings(TenantId, UserId)} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTwoFactorAuthService#isTwoFaEnabled(TenantId, UserId)}
   */
  @Test
  @DisplayName("Test isTwoFaEnabled(TenantId, UserId); given TwoFaConfigManager getAccountTwoFaSettings(TenantId, UserId) return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultTwoFactorAuthService.isTwoFaEnabled(TenantId, UserId)"})
  void testIsTwoFaEnabled_givenTwoFaConfigManagerGetAccountTwoFaSettingsReturnEmpty() {
    // Arrange
    Optional<AccountTwoFaSettings> emptyResult = Optional.empty();
    when(twoFaConfigManager.getAccountTwoFaSettings(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(emptyResult);

    // Act
    boolean actualIsTwoFaEnabledResult = defaultTwoFactorAuthService
        .isTwoFaEnabled(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null);

    // Assert
    verify(twoFaConfigManager).getAccountTwoFaSettings(isA(TenantId.class), isNull());
    assertFalse(actualIsTwoFaEnabledResult);
  }

  /**
   * Test {@link DefaultTwoFactorAuthService#isTwoFaEnabled(TenantId, UserId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTwoFactorAuthService#isTwoFaEnabled(TenantId, UserId)}
   */
  @Test
  @DisplayName("Test isTwoFaEnabled(TenantId, UserId); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultTwoFactorAuthService.isTwoFaEnabled(TenantId, UserId)"})
  void testIsTwoFaEnabled_thenReturnFalse() {
    // Arrange
    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());
    Optional<AccountTwoFaSettings> ofResult = Optional.of(accountTwoFaSettings);
    when(twoFaConfigManager.getAccountTwoFaSettings(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(ofResult);

    // Act
    boolean actualIsTwoFaEnabledResult = defaultTwoFactorAuthService
        .isTwoFaEnabled(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null);

    // Assert
    verify(twoFaConfigManager).getAccountTwoFaSettings(isA(TenantId.class), isNull());
    assertFalse(actualIsTwoFaEnabledResult);
  }

  /**
   * Test {@link DefaultTwoFactorAuthService#isTwoFaEnabled(TenantId, UserId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTwoFactorAuthService#isTwoFaEnabled(TenantId, UserId)}
   */
  @Test
  @DisplayName("Test isTwoFaEnabled(TenantId, UserId); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultTwoFactorAuthService.isTwoFaEnabled(TenantId, UserId)"})
  void testIsTwoFaEnabled_thenReturnTrue() {
    // Arrange
    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.put(TwoFaProviderType.TOTP, new BackupCodeTwoFaAccountConfig());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(configs);
    Optional<AccountTwoFaSettings> ofResult = Optional.of(accountTwoFaSettings);
    when(twoFaConfigManager.getAccountTwoFaSettings(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(ofResult);

    // Act
    boolean actualIsTwoFaEnabledResult = defaultTwoFactorAuthService
        .isTwoFaEnabled(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null);

    // Assert
    verify(twoFaConfigManager).getAccountTwoFaSettings(isA(TenantId.class), isNull());
    assertTrue(actualIsTwoFaEnabledResult);
  }

  /**
   * Test {@link DefaultTwoFactorAuthService#isTwoFaEnabled(TenantId, UserId)}.
   * <ul>
   *   <li>Then throw {@link LockedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTwoFactorAuthService#isTwoFaEnabled(TenantId, UserId)}
   */
  @Test
  @DisplayName("Test isTwoFaEnabled(TenantId, UserId); then throw LockedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultTwoFactorAuthService.isTwoFaEnabled(TenantId, UserId)"})
  void testIsTwoFaEnabled_thenThrowLockedException() {
    // Arrange
    when(twoFaConfigManager.getAccountTwoFaSettings(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenThrow(new LockedException("Msg"));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultTwoFactorAuthService
        .isTwoFaEnabled(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null));
    verify(twoFaConfigManager).getAccountTwoFaSettings(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DefaultTwoFactorAuthService#checkProvider(TenantId, TwoFaProviderType)}.
   * <p>
   * Method under test: {@link DefaultTwoFactorAuthService#checkProvider(TenantId, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test checkProvider(TenantId, TwoFaProviderType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTwoFactorAuthService.checkProvider(TenantId, TwoFaProviderType)"})
  void testCheckProvider() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultTwoFactorAuthService
        .checkProvider(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), TwoFaProviderType.TOTP));
  }

  /**
   * Test {@link DefaultTwoFactorAuthService#generateNewAccountConfig(User, TwoFaProviderType)}.
   * <p>
   * Method under test: {@link DefaultTwoFactorAuthService#generateNewAccountConfig(User, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, TwoFaProviderType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TwoFaAccountConfig DefaultTwoFactorAuthService.generateNewAccountConfig(User, TwoFaProviderType)"})
  void testGenerateNewAccountConfig() throws ThingsboardException {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult = Optional.of(platformTwoFaSettings);
    when(twoFaConfigManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.generateNewAccountConfig(new User(), TwoFaProviderType.TOTP));
    verify(twoFaConfigManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test {@link DefaultTwoFactorAuthService#generateNewAccountConfig(User, TwoFaProviderType)}.
   * <p>
   * Method under test: {@link DefaultTwoFactorAuthService#generateNewAccountConfig(User, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, TwoFaProviderType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TwoFaAccountConfig DefaultTwoFactorAuthService.generateNewAccountConfig(User, TwoFaProviderType)"})
  void testGenerateNewAccountConfig2() throws ThingsboardException {
    // Arrange
    Optional<PlatformTwoFaSettings> emptyResult = Optional.empty();
    when(twoFaConfigManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(emptyResult);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.generateNewAccountConfig(new User(), TwoFaProviderType.TOTP));
    verify(twoFaConfigManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test {@link DefaultTwoFactorAuthService#generateNewAccountConfig(User, TwoFaProviderType)}.
   * <ul>
   *   <li>Then calls {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTwoFactorAuthService#generateNewAccountConfig(User, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, TwoFaProviderType); then calls getProviderConfig(TwoFaProviderType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TwoFaAccountConfig DefaultTwoFactorAuthService.generateNewAccountConfig(User, TwoFaProviderType)"})
  void testGenerateNewAccountConfig_thenCallsGetProviderConfig() throws ThingsboardException {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    when(twoFaConfigManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.generateNewAccountConfig(new User(), TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(twoFaConfigManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }
}
