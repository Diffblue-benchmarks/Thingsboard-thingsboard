package org.thingsboard.server.service.security.auth.mfa.provider.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.security.model.mfa.account.TotpTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TotpTwoFaProviderConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

class TotpTwoFaProviderDiffblueTest {
  /**
   * Test
   * {@link TotpTwoFaProvider#generateNewAccountConfig(User, TotpTwoFaProviderConfig)}
   * with {@code User}, {@code TotpTwoFaProviderConfig}.
   * <ul>
   *   <li>Then calls {@link User#getEmail()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TotpTwoFaProvider#generateNewAccountConfig(User, TotpTwoFaProviderConfig)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, TotpTwoFaProviderConfig) with 'User', 'TotpTwoFaProviderConfig'; then calls getEmail()")
  void testGenerateNewAccountConfigWithUserTotpTwoFaProviderConfig_thenCallsGetEmail() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotpTwoFaProvider totpTwoFaProvider = new TotpTwoFaProvider();
    User user = mock(User.class);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    TotpTwoFaProviderConfig providerConfig = new TotpTwoFaProviderConfig();
    providerConfig.setIssuerName("Issuer Name");

    // Act
    TotpTwoFaAccountConfig actualGenerateNewAccountConfigResult = totpTwoFaProvider.generateNewAccountConfig(user,
        providerConfig);

    // Assert
    verify(user).getEmail();
    assertEquals(TwoFaProviderType.TOTP, actualGenerateNewAccountConfigResult.getProviderType());
    assertFalse(actualGenerateNewAccountConfigResult.isSerializeHiddenFields());
    assertFalse(actualGenerateNewAccountConfigResult.isUseByDefault());
  }

  /**
   * Test
   * {@link TotpTwoFaProvider#generateNewAccountConfig(User, TotpTwoFaProviderConfig)}
   * with {@code User}, {@code TotpTwoFaProviderConfig}.
   * <ul>
   *   <li>When {@link User#User()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TotpTwoFaProvider#generateNewAccountConfig(User, TotpTwoFaProviderConfig)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, TotpTwoFaProviderConfig) with 'User', 'TotpTwoFaProviderConfig'; when User()")
  void testGenerateNewAccountConfigWithUserTotpTwoFaProviderConfig_whenUser() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TotpTwoFaProvider totpTwoFaProvider = new TotpTwoFaProvider();
    User user = new User();

    TotpTwoFaProviderConfig providerConfig = new TotpTwoFaProviderConfig();
    providerConfig.setIssuerName("Issuer Name");

    // Act
    TotpTwoFaAccountConfig actualGenerateNewAccountConfigResult = totpTwoFaProvider.generateNewAccountConfig(user,
        providerConfig);

    // Assert
    assertEquals(TwoFaProviderType.TOTP, actualGenerateNewAccountConfigResult.getProviderType());
    assertFalse(actualGenerateNewAccountConfigResult.isSerializeHiddenFields());
    assertFalse(actualGenerateNewAccountConfigResult.isUseByDefault());
  }

  /**
   * Test {@link TotpTwoFaProvider#getType()}.
   * <p>
   * Method under test: {@link TotpTwoFaProvider#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals(TwoFaProviderType.TOTP, (new TotpTwoFaProvider()).getType());
  }
}
