package org.thingsboard.server.service.security.auth.mfa.provider.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.security.model.mfa.account.TotpTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TotpTwoFaProviderConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

class TotpTwoFaProviderDiffblueTest {
  /**
   * Test {@link TotpTwoFaProvider#generateNewAccountConfig(User, TotpTwoFaProviderConfig)} with {@code User}, {@code TotpTwoFaProviderConfig}.
   * <p>
   * Method under test: {@link TotpTwoFaProvider#generateNewAccountConfig(User, TotpTwoFaProviderConfig)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, TotpTwoFaProviderConfig) with 'User', 'TotpTwoFaProviderConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TotpTwoFaAccountConfig TotpTwoFaProvider.generateNewAccountConfig(User, TotpTwoFaProviderConfig)"})
  void testGenerateNewAccountConfigWithUserTotpTwoFaProviderConfig() {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TwoFaProviderType TotpTwoFaProvider.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals(TwoFaProviderType.TOTP, (new TotpTwoFaProvider()).getType());
  }
}
