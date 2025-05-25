package org.thingsboard.server.service.edge.rpc.constructor.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;
import org.thingsboard.server.gen.edge.v1.UserUpdateMsg;

class BaseUserMsgConstructorDiffblueTest {
  /**
   * Test {@link BaseUserMsgConstructor#constructUserDeleteMsg(UserId)}.
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseUserMsgConstructor#constructUserDeleteMsg(UserId)}
   */
  @Test
  @DisplayName("Test constructUserDeleteMsg(UserId); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserUpdateMsg BaseUserMsgConstructor.constructUserDeleteMsg(UserId)"})
  void testConstructUserDeleteMsg_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    UserMsgConstructorV1 userMsgConstructorV1 = new UserMsgConstructorV1();

    // Act
    UserUpdateMsg actualConstructUserDeleteMsgResult = userMsgConstructorV1
        .constructUserDeleteMsg(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals("", actualConstructUserDeleteMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructUserDeleteMsgResult.getAdditionalInfo());
    assertEquals("", actualConstructUserDeleteMsgResult.getAuthority());
    assertEquals("", actualConstructUserDeleteMsgResult.getEmail());
    assertEquals("", actualConstructUserDeleteMsgResult.getEntity());
    assertEquals("", actualConstructUserDeleteMsgResult.getFirstName());
    assertEquals("", actualConstructUserDeleteMsgResult.getLastName());
    assertEquals(-7476899250389416711L, actualConstructUserDeleteMsgResult.getIdLSB());
    assertEquals(0L, actualConstructUserDeleteMsgResult.getCustomerIdLSB());
    assertEquals(0L, actualConstructUserDeleteMsgResult.getCustomerIdMSB());
    assertEquals(2, actualConstructUserDeleteMsgResult.getMsgTypeValue());
    assertEquals(23, actualConstructUserDeleteMsgResult.getSerializedSize());
    assertEquals(3, actualConstructUserDeleteMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructUserDeleteMsgResult.getIdMSB());
    assertEquals(UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE, actualConstructUserDeleteMsgResult.getMsgType());
    assertFalse(actualConstructUserDeleteMsgResult.hasAdditionalInfo());
    assertFalse(actualConstructUserDeleteMsgResult.hasCustomerIdLSB());
    assertFalse(actualConstructUserDeleteMsgResult.hasCustomerIdMSB());
    assertFalse(actualConstructUserDeleteMsgResult.hasFirstName());
    assertFalse(actualConstructUserDeleteMsgResult.hasLastName());
    assertTrue(actualConstructUserDeleteMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructUserDeleteMsgResult.isInitialized());
  }
}
