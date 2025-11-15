/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.UserId;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserAuthSettings.<init>()", "AccountTwoFaSettings UserAuthSettings.getTwoFaSettings()",
      "UserId UserAuthSettings.getUserId()", "void UserAuthSettings.setTwoFaSettings(AccountTwoFaSettings)",
      "void UserAuthSettings.setUserId(UserId)", "String UserAuthSettings.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    UserAuthSettings actualUserAuthSettings = new UserAuthSettings();
    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(new LinkedHashMap<>());
    actualUserAuthSettings.setTwoFaSettings(twoFaSettings);
    String actualToStringResult = actualUserAuthSettings.toString();
    AccountTwoFaSettings actualTwoFaSettings = actualUserAuthSettings.getTwoFaSettings();
    UserId actualUserId = actualUserAuthSettings.getUserId();

    // Assert
    assertEquals("UserAuthSettings(userId=null, twoFaSettings=AccountTwoFaSettings(configs={}))", actualToStringResult);
    assertNull(actualUserAuthSettings.getId());
    assertNull(actualUserId);
    assertEquals(0L, actualUserAuthSettings.getCreatedTime());
    assertSame(twoFaSettings, actualTwoFaSettings);
  }
}
