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
package org.thingsboard.server.dao.oauth2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientLoginInfo;
import org.thingsboard.server.dao.model.ModelConstants;

public class OAuth2UtilsDiffblueTest {
  /**
   * Test {@link OAuth2Utils#toClientLoginInfo(OAuth2Client)}.
   *
   * <p>Method under test: {@link OAuth2Utils#toClientLoginInfo(OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuth2ClientLoginInfo OAuth2Utils.toClientLoginInfo(OAuth2Client)"})
  public void testToClientLoginInfo() {
    // Arrange and Act
    OAuth2ClientLoginInfo actualToClientLoginInfoResult =
        OAuth2Utils.toClientLoginInfo(
            new OAuth2Client(new OAuth2ClientId(ModelConstants.NULL_UUID)));

    // Assert
    assertEquals(
        "/oauth2/authorization/13814000-1dd2-11b2-8080-808080808080",
        actualToClientLoginInfoResult.getUrl());
    assertNull(actualToClientLoginInfoResult.getIcon());
    assertNull(actualToClientLoginInfoResult.getName());
  }
}
