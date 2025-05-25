package org.thingsboard.server.service.security.auth.mfa.provider.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cache.CacheManager;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.security.model.mfa.account.EmailTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.EmailTwoFaProviderConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

@ExtendWith(MockitoExtension.class)
class EmailTwoFaProviderDiffblueTest {
  @Mock
  private CacheManager cacheManager;

  @InjectMocks
  private EmailTwoFaProvider emailTwoFaProvider;

  /**
   * Test {@link EmailTwoFaProvider#generateNewAccountConfig(User, EmailTwoFaProviderConfig)} with {@code User}, {@code EmailTwoFaProviderConfig}.
   * <p>
   * Method under test: {@link EmailTwoFaProvider#generateNewAccountConfig(User, EmailTwoFaProviderConfig)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, EmailTwoFaProviderConfig) with 'User', 'EmailTwoFaProviderConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EmailTwoFaAccountConfig EmailTwoFaProvider.generateNewAccountConfig(User, EmailTwoFaProviderConfig)"})
  void testGenerateNewAccountConfigWithUserEmailTwoFaProviderConfig() {
    // Arrange
    User user = new User();

    EmailTwoFaProviderConfig providerConfig = new EmailTwoFaProviderConfig();
    providerConfig.setVerificationCodeLifetime(1);

    // Act
    EmailTwoFaAccountConfig actualGenerateNewAccountConfigResult = emailTwoFaProvider.generateNewAccountConfig(user,
        providerConfig);

    // Assert
    assertNull(actualGenerateNewAccountConfigResult.getEmail());
    assertEquals(TwoFaProviderType.EMAIL, actualGenerateNewAccountConfigResult.getProviderType());
    assertFalse(actualGenerateNewAccountConfigResult.isSerializeHiddenFields());
    assertFalse(actualGenerateNewAccountConfigResult.isUseByDefault());
  }
}
