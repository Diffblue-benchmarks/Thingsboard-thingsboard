package org.thingsboard.server.service.edge.rpc.constructor.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.gen.edge.v1.OAuth2ClientUpdateMsg;
import org.thingsboard.server.gen.edge.v1.OAuth2DomainUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class OAuth2MsgConstructorDiffblueTest {
  /**
   * Test {@link OAuth2MsgConstructor#constructOAuth2ClientDeleteMsg(OAuth2ClientId)}.
   * <p>
   * Method under test: {@link OAuth2MsgConstructor#constructOAuth2ClientDeleteMsg(OAuth2ClientId)}
   */
  @Test
  @DisplayName("Test constructOAuth2ClientDeleteMsg(OAuth2ClientId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OAuth2ClientUpdateMsg OAuth2MsgConstructor.constructOAuth2ClientDeleteMsg(OAuth2ClientId)"})
  void testConstructOAuth2ClientDeleteMsg() {
    // Arrange
    OAuth2MsgConstructor oAuth2MsgConstructor = new OAuth2MsgConstructor();

    // Act
    OAuth2ClientUpdateMsg actualConstructOAuth2ClientDeleteMsgResult = oAuth2MsgConstructor
        .constructOAuth2ClientDeleteMsg(new OAuth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals("", actualConstructOAuth2ClientDeleteMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructOAuth2ClientDeleteMsgResult.getEntity());
    assertEquals(-7476899250389416711L, actualConstructOAuth2ClientDeleteMsgResult.getIdLSB());
    assertEquals(2, actualConstructOAuth2ClientDeleteMsgResult.getMsgTypeValue());
    assertEquals(23, actualConstructOAuth2ClientDeleteMsgResult.getSerializedSize());
    assertEquals(3, actualConstructOAuth2ClientDeleteMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructOAuth2ClientDeleteMsgResult.getIdMSB());
    assertEquals(UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE, actualConstructOAuth2ClientDeleteMsgResult.getMsgType());
    assertFalse(actualConstructOAuth2ClientDeleteMsgResult.hasEntity());
    assertTrue(actualConstructOAuth2ClientDeleteMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructOAuth2ClientDeleteMsgResult.hasIdLSB());
    assertTrue(actualConstructOAuth2ClientDeleteMsgResult.hasIdMSB());
    assertTrue(actualConstructOAuth2ClientDeleteMsgResult.isInitialized());
  }

  /**
   * Test {@link OAuth2MsgConstructor#constructOAuth2DomainDeleteMsg(DomainId)}.
   * <p>
   * Method under test: {@link OAuth2MsgConstructor#constructOAuth2DomainDeleteMsg(DomainId)}
   */
  @Test
  @DisplayName("Test constructOAuth2DomainDeleteMsg(DomainId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OAuth2DomainUpdateMsg OAuth2MsgConstructor.constructOAuth2DomainDeleteMsg(DomainId)"})
  void testConstructOAuth2DomainDeleteMsg() {
    // Arrange
    OAuth2MsgConstructor oAuth2MsgConstructor = new OAuth2MsgConstructor();

    // Act
    OAuth2DomainUpdateMsg actualConstructOAuth2DomainDeleteMsgResult = oAuth2MsgConstructor
        .constructOAuth2DomainDeleteMsg(new DomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals("", actualConstructOAuth2DomainDeleteMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructOAuth2DomainDeleteMsgResult.getEntity());
    assertEquals(-7476899250389416711L, actualConstructOAuth2DomainDeleteMsgResult.getIdLSB());
    assertEquals(2, actualConstructOAuth2DomainDeleteMsgResult.getMsgTypeValue());
    assertEquals(23, actualConstructOAuth2DomainDeleteMsgResult.getSerializedSize());
    assertEquals(3, actualConstructOAuth2DomainDeleteMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructOAuth2DomainDeleteMsgResult.getIdMSB());
    assertEquals(UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE, actualConstructOAuth2DomainDeleteMsgResult.getMsgType());
    assertFalse(actualConstructOAuth2DomainDeleteMsgResult.hasEntity());
    assertTrue(actualConstructOAuth2DomainDeleteMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructOAuth2DomainDeleteMsgResult.hasIdLSB());
    assertTrue(actualConstructOAuth2DomainDeleteMsgResult.hasIdMSB());
    assertTrue(actualConstructOAuth2DomainDeleteMsgResult.isInitialized());
  }
}
