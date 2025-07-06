package org.thingsboard.server.service.edge.rpc.constructor.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.domain.DomainInfo;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.gen.edge.v1.OAuth2ClientUpdateMsg;
import org.thingsboard.server.gen.edge.v1.OAuth2DomainUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class OAuth2MsgConstructorDiffblueTest {
  /**
   * Test {@link OAuth2MsgConstructor#constructOAuth2ClientUpdateMsg(UpdateMsgType, OAuth2Client)}.
   *
   * <p>Method under test: {@link OAuth2MsgConstructor#constructOAuth2ClientUpdateMsg(UpdateMsgType,
   * OAuth2Client)}
   */
  @Test
  @DisplayName("Test constructOAuth2ClientUpdateMsg(UpdateMsgType, OAuth2Client)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "OAuth2ClientUpdateMsg OAuth2MsgConstructor.constructOAuth2ClientUpdateMsg(UpdateMsgType, OAuth2Client)"
  })
  void testConstructOAuth2ClientUpdateMsg() {
    // Arrange
    OAuth2MsgConstructor oAuth2MsgConstructor = new OAuth2MsgConstructor();

    // Act
    OAuth2ClientUpdateMsg actualConstructOAuth2ClientUpdateMsgResult =
        oAuth2MsgConstructor.constructOAuth2ClientUpdateMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
            new OAuth2Client(
                new OAuth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));

    // Assert
    assertEquals("", actualConstructOAuth2ClientUpdateMsgResult.getInitializationErrorString());
    assertEquals(
        "{\"id\":{\"entityType\":\"OAUTH2_CLIENT\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,"
            + "\"additionalInfo\":null,\"tenantId\":null,\"title\":null,\"mapperConfig\":null,\"clientId\":null,\"clientSecret"
            + "\":null,\"authorizationUri\":null,\"accessTokenUri\":null,\"scope\":null,\"userInfoUri\":null,\"userNameAttributeName"
            + "\":null,\"jwkSetUri\":null,\"clientAuthenticationMethod\":null,\"loginButtonLabel\":null,\"loginButtonIcon\""
            + ":null,\"platforms\":null,\"name\":null}",
        actualConstructOAuth2ClientUpdateMsgResult.getEntity());
    assertEquals(-7476899250389416711L, actualConstructOAuth2ClientUpdateMsgResult.getIdLSB());
    assertEquals(0, actualConstructOAuth2ClientUpdateMsgResult.getMsgTypeValue());
    assertEquals(3, actualConstructOAuth2ClientUpdateMsgResult.getAllFields().size());
    assertEquals(462, actualConstructOAuth2ClientUpdateMsgResult.getSerializedSize());
    assertEquals(8669210807411032922L, actualConstructOAuth2ClientUpdateMsgResult.getIdMSB());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructOAuth2ClientUpdateMsgResult.getMsgType());
    assertTrue(actualConstructOAuth2ClientUpdateMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructOAuth2ClientUpdateMsgResult.hasEntity());
    assertTrue(actualConstructOAuth2ClientUpdateMsgResult.hasIdLSB());
    assertTrue(actualConstructOAuth2ClientUpdateMsgResult.hasIdMSB());
    assertTrue(actualConstructOAuth2ClientUpdateMsgResult.isInitialized());
  }

  /**
   * Test {@link OAuth2MsgConstructor#constructOAuth2ClientDeleteMsg(OAuth2ClientId)}.
   *
   * <p>Method under test: {@link
   * OAuth2MsgConstructor#constructOAuth2ClientDeleteMsg(OAuth2ClientId)}
   */
  @Test
  @DisplayName("Test constructOAuth2ClientDeleteMsg(OAuth2ClientId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "OAuth2ClientUpdateMsg OAuth2MsgConstructor.constructOAuth2ClientDeleteMsg(OAuth2ClientId)"
  })
  void testConstructOAuth2ClientDeleteMsg() {
    // Arrange
    OAuth2MsgConstructor oAuth2MsgConstructor = new OAuth2MsgConstructor();

    // Act
    OAuth2ClientUpdateMsg actualConstructOAuth2ClientDeleteMsgResult =
        oAuth2MsgConstructor.constructOAuth2ClientDeleteMsg(
            new OAuth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals("", actualConstructOAuth2ClientDeleteMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructOAuth2ClientDeleteMsgResult.getEntity());
    assertEquals(-7476899250389416711L, actualConstructOAuth2ClientDeleteMsgResult.getIdLSB());
    assertEquals(2, actualConstructOAuth2ClientDeleteMsgResult.getMsgTypeValue());
    assertEquals(23, actualConstructOAuth2ClientDeleteMsgResult.getSerializedSize());
    assertEquals(3, actualConstructOAuth2ClientDeleteMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructOAuth2ClientDeleteMsgResult.getIdMSB());
    assertEquals(
        UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE,
        actualConstructOAuth2ClientDeleteMsgResult.getMsgType());
    assertFalse(actualConstructOAuth2ClientDeleteMsgResult.hasEntity());
    assertTrue(actualConstructOAuth2ClientDeleteMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructOAuth2ClientDeleteMsgResult.hasIdLSB());
    assertTrue(actualConstructOAuth2ClientDeleteMsgResult.hasIdMSB());
    assertTrue(actualConstructOAuth2ClientDeleteMsgResult.isInitialized());
  }

  /**
   * Test {@link OAuth2MsgConstructor#constructOAuth2DomainUpdateMsg(UpdateMsgType, DomainInfo)}.
   *
   * <p>Method under test: {@link OAuth2MsgConstructor#constructOAuth2DomainUpdateMsg(UpdateMsgType,
   * DomainInfo)}
   */
  @Test
  @DisplayName("Test constructOAuth2DomainUpdateMsg(UpdateMsgType, DomainInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "OAuth2DomainUpdateMsg OAuth2MsgConstructor.constructOAuth2DomainUpdateMsg(UpdateMsgType, DomainInfo)"
  })
  void testConstructOAuth2DomainUpdateMsg() {
    // Arrange
    OAuth2MsgConstructor oAuth2MsgConstructor = new OAuth2MsgConstructor();

    DomainInfo domainInfo = new DomainInfo();
    domainInfo.setId(new DomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    OAuth2DomainUpdateMsg actualConstructOAuth2DomainUpdateMsgResult =
        oAuth2MsgConstructor.constructOAuth2DomainUpdateMsg(
            UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE, domainInfo);

    // Assert
    assertEquals("", actualConstructOAuth2DomainUpdateMsgResult.getInitializationErrorString());
    assertEquals(
        "{\"id\":{\"entityType\":\"DOMAIN\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,\"tenantId\""
            + ":null,\"name\":null,\"oauth2Enabled\":false,\"propagateToEdge\":false,\"oauth2ClientInfos\":null}",
        actualConstructOAuth2DomainUpdateMsgResult.getEntity());
    assertEquals(-7476899250389416711L, actualConstructOAuth2DomainUpdateMsgResult.getIdLSB());
    assertEquals(1, actualConstructOAuth2DomainUpdateMsgResult.getMsgTypeValue());
    assertEquals(215, actualConstructOAuth2DomainUpdateMsgResult.getSerializedSize());
    assertEquals(4, actualConstructOAuth2DomainUpdateMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructOAuth2DomainUpdateMsgResult.getIdMSB());
    assertEquals(
        UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE,
        actualConstructOAuth2DomainUpdateMsgResult.getMsgType());
    assertTrue(actualConstructOAuth2DomainUpdateMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructOAuth2DomainUpdateMsgResult.hasEntity());
    assertTrue(actualConstructOAuth2DomainUpdateMsgResult.hasIdLSB());
    assertTrue(actualConstructOAuth2DomainUpdateMsgResult.hasIdMSB());
    assertTrue(actualConstructOAuth2DomainUpdateMsgResult.isInitialized());
  }

  /**
   * Test {@link OAuth2MsgConstructor#constructOAuth2DomainDeleteMsg(DomainId)}.
   *
   * <p>Method under test: {@link OAuth2MsgConstructor#constructOAuth2DomainDeleteMsg(DomainId)}
   */
  @Test
  @DisplayName("Test constructOAuth2DomainDeleteMsg(DomainId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "OAuth2DomainUpdateMsg OAuth2MsgConstructor.constructOAuth2DomainDeleteMsg(DomainId)"
  })
  void testConstructOAuth2DomainDeleteMsg() {
    // Arrange
    OAuth2MsgConstructor oAuth2MsgConstructor = new OAuth2MsgConstructor();

    // Act
    OAuth2DomainUpdateMsg actualConstructOAuth2DomainDeleteMsgResult =
        oAuth2MsgConstructor.constructOAuth2DomainDeleteMsg(
            new DomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals("", actualConstructOAuth2DomainDeleteMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructOAuth2DomainDeleteMsgResult.getEntity());
    assertEquals(-7476899250389416711L, actualConstructOAuth2DomainDeleteMsgResult.getIdLSB());
    assertEquals(2, actualConstructOAuth2DomainDeleteMsgResult.getMsgTypeValue());
    assertEquals(23, actualConstructOAuth2DomainDeleteMsgResult.getSerializedSize());
    assertEquals(3, actualConstructOAuth2DomainDeleteMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructOAuth2DomainDeleteMsgResult.getIdMSB());
    assertEquals(
        UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE,
        actualConstructOAuth2DomainDeleteMsgResult.getMsgType());
    assertFalse(actualConstructOAuth2DomainDeleteMsgResult.hasEntity());
    assertTrue(actualConstructOAuth2DomainDeleteMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructOAuth2DomainDeleteMsgResult.hasIdLSB());
    assertTrue(actualConstructOAuth2DomainDeleteMsgResult.hasIdMSB());
    assertTrue(actualConstructOAuth2DomainDeleteMsgResult.isInitialized());
  }
}
