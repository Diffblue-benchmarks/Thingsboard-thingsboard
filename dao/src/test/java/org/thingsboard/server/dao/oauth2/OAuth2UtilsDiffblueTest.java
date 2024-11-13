package org.thingsboard.server.dao.oauth2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientLoginInfo;
import org.thingsboard.server.dao.model.ModelConstants;

public class OAuth2UtilsDiffblueTest {
  /**
   * Test {@link OAuth2Utils#toClientLoginInfo(OAuth2Client)}.
   * <p>
   * Method under test: {@link OAuth2Utils#toClientLoginInfo(OAuth2Client)}
   */
  @Test
  public void testToClientLoginInfo() {
    // Arrange and Act
    OAuth2ClientLoginInfo actualToClientLoginInfoResult = OAuth2Utils
        .toClientLoginInfo(new OAuth2Client(new OAuth2ClientId(ModelConstants.NULL_UUID)));

    // Assert
    assertEquals("/oauth2/authorization/13814000-1dd2-11b2-8080-808080808080", actualToClientLoginInfoResult.getUrl());
    assertNull(actualToClientLoginInfoResult.getIcon());
    assertNull(actualToClientLoginInfoResult.getName());
  }
}
