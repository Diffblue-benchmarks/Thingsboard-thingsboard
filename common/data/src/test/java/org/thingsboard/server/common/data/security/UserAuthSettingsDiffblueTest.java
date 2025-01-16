package org.thingsboard.server.common.data.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings;

class UserAuthSettingsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UserAuthSettings}
   *   <li>{@link UserAuthSettings#setTwoFaSettings(AccountTwoFaSettings)}
   *   <li>{@link UserAuthSettings#toString()}
   *   <li>{@link UserAuthSettings#getTwoFaSettings()}
   *   <li>{@link UserAuthSettings#getUserId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    UserAuthSettings actualUserAuthSettings = new UserAuthSettings();
    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(new LinkedHashMap<>());
    actualUserAuthSettings.setTwoFaSettings(twoFaSettings);
    String actualToStringResult = actualUserAuthSettings.toString();
    AccountTwoFaSettings actualTwoFaSettings = actualUserAuthSettings.getTwoFaSettings();
    actualUserAuthSettings.getUserId();

    // Assert that nothing has changed
    assertEquals("UserAuthSettings(userId=null, twoFaSettings=AccountTwoFaSettings(configs={}))", actualToStringResult);
    assertEquals(0L, actualUserAuthSettings.getCreatedTime());
    assertSame(twoFaSettings, actualTwoFaSettings);
  }
}
