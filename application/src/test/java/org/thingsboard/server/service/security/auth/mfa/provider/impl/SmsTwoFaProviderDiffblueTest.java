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
import org.thingsboard.server.common.data.security.model.mfa.account.SmsTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.SmsTwoFaProviderConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

@ExtendWith(MockitoExtension.class)
class SmsTwoFaProviderDiffblueTest {
  @Mock
  private CacheManager cacheManager;

  @InjectMocks
  private SmsTwoFaProvider smsTwoFaProvider;

  /**
   * Test {@link SmsTwoFaProvider#generateNewAccountConfig(User, SmsTwoFaProviderConfig)} with {@code User}, {@code SmsTwoFaProviderConfig}.
   * <p>
   * Method under test: {@link SmsTwoFaProvider#generateNewAccountConfig(User, SmsTwoFaProviderConfig)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, SmsTwoFaProviderConfig) with 'User', 'SmsTwoFaProviderConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SmsTwoFaAccountConfig SmsTwoFaProvider.generateNewAccountConfig(User, SmsTwoFaProviderConfig)"})
  void testGenerateNewAccountConfigWithUserSmsTwoFaProviderConfig() {
    // Arrange
    User user = new User();

    SmsTwoFaProviderConfig providerConfig = new SmsTwoFaProviderConfig();
    providerConfig.setSmsVerificationMessageTemplate("Sms Verification Message Template");
    providerConfig.setVerificationCodeLifetime(1);

    // Act
    SmsTwoFaAccountConfig actualGenerateNewAccountConfigResult = smsTwoFaProvider.generateNewAccountConfig(user,
        providerConfig);

    // Assert
    assertNull(actualGenerateNewAccountConfigResult.getPhoneNumber());
    assertEquals(TwoFaProviderType.SMS, actualGenerateNewAccountConfigResult.getProviderType());
    assertFalse(actualGenerateNewAccountConfigResult.isSerializeHiddenFields());
    assertFalse(actualGenerateNewAccountConfigResult.isUseByDefault());
  }
}
