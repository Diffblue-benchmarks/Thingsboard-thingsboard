package org.thingsboard.server.service.edge.rpc.constructor.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.UserCredentials;
import org.thingsboard.server.gen.edge.v1.UserCredentialsUpdateMsg;

class UserMsgConstructorV2DiffblueTest {
  /**
   * Test {@link UserMsgConstructorV2#constructUserCredentialsUpdatedMsg(UserCredentials)}.
   * <p>
   * Method under test: {@link UserMsgConstructorV2#constructUserCredentialsUpdatedMsg(UserCredentials)}
   */
  @Test
  @DisplayName("Test constructUserCredentialsUpdatedMsg(UserCredentials)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "UserCredentialsUpdateMsg UserMsgConstructorV2.constructUserCredentialsUpdatedMsg(UserCredentials)"})
  void testConstructUserCredentialsUpdatedMsg() {
    // Arrange
    UserMsgConstructorV2 userMsgConstructorV2 = new UserMsgConstructorV2();

    // Act
    UserCredentialsUpdateMsg actualConstructUserCredentialsUpdatedMsgResult = userMsgConstructorV2
        .constructUserCredentialsUpdatedMsg(new UserCredentials());

    // Assert
    assertEquals("", actualConstructUserCredentialsUpdatedMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructUserCredentialsUpdatedMsgResult.getPassword());
    assertEquals(
        "{\"id\":null,\"createdTime\":0,\"userId\":null,\"enabled\":false,\"password\":null,\"activateToken\":null,"
            + "\"activateTokenExpTime\":null,\"resetToken\":null,\"resetTokenExpTime\":null,\"lastLoginTs\":null,\"failedLog"
            + "inAttempts\":null,\"additionalInfo\":null}",
        actualConstructUserCredentialsUpdatedMsgResult.getEntity());
    assertEquals(0L, actualConstructUserCredentialsUpdatedMsgResult.getUserIdLSB());
    assertEquals(0L, actualConstructUserCredentialsUpdatedMsgResult.getUserIdMSB());
    assertEquals(1, actualConstructUserCredentialsUpdatedMsgResult.getAllFields().size());
    assertEquals(236, actualConstructUserCredentialsUpdatedMsgResult.getSerializedSize());
    assertFalse(actualConstructUserCredentialsUpdatedMsgResult.getEnabled());
    assertTrue(actualConstructUserCredentialsUpdatedMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructUserCredentialsUpdatedMsgResult.isInitialized());
  }
}
