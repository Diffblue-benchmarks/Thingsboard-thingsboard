package org.thingsboard.server.dao.oauth2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientLoginInfo;

public class OAuth2UtilsDiffblueTest {
  /**
   * Test {@link OAuth2Utils#toClientLoginInfo(OAuth2Client)}.
   * <p>
   * Method under test: {@link OAuth2Utils#toClientLoginInfo(OAuth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OAuth2ClientLoginInfo OAuth2Utils.toClientLoginInfo(OAuth2Client)"})
  public void testToClientLoginInfo() {
    // Arrange and Act
    OAuth2ClientLoginInfo actualToClientLoginInfoResult = OAuth2Utils.toClientLoginInfo(
        new OAuth2Client(new OAuth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));

    // Assert
    assertEquals("/oauth2/authorization/784f394c-42b6-435a-983c-b7beff2784f9", actualToClientLoginInfoResult.getUrl());
    assertNull(actualToClientLoginInfoResult.getIcon());
    assertNull(actualToClientLoginInfoResult.getName());
  }
}
