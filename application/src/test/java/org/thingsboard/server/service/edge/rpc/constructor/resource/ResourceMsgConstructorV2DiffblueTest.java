package org.thingsboard.server.service.edge.rpc.constructor.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.gen.edge.v1.ResourceUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class ResourceMsgConstructorV2DiffblueTest {
  /**
   * Test {@link ResourceMsgConstructorV2#constructResourceUpdatedMsg(UpdateMsgType, TbResource)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceMsgConstructorV2#constructResourceUpdatedMsg(UpdateMsgType, TbResource)}
   */
  @Test
  @DisplayName(
      "Test constructResourceUpdatedMsg(UpdateMsgType, TbResource); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ResourceUpdateMsg ResourceMsgConstructorV2.constructResourceUpdatedMsg(UpdateMsgType, TbResource)"
  })
  void testConstructResourceUpdatedMsg_thenReturnInitializationErrorStringIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ResourceMsgConstructorV2 resourceMsgConstructorV2 = new ResourceMsgConstructorV2();

    TbResource tbResource = new TbResource();
    tbResource.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ResourceUpdateMsg actualConstructResourceUpdatedMsgResult =
        resourceMsgConstructorV2.constructResourceUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tbResource);

    // Assert
    assertEquals("", actualConstructResourceUpdatedMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructResourceUpdatedMsgResult.getData());
    assertEquals("", actualConstructResourceUpdatedMsgResult.getEtag());
    assertEquals("", actualConstructResourceUpdatedMsgResult.getFileName());
    assertEquals("", actualConstructResourceUpdatedMsgResult.getResourceKey());
    assertEquals("", actualConstructResourceUpdatedMsgResult.getResourceType());
    assertEquals("", actualConstructResourceUpdatedMsgResult.getTitle());
    assertEquals(
        "{\"id\":{\"entityType\":\"TB_RESOURCE\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,\"tenantId"
            + "\":null,\"title\":null,\"resourceType\":null,\"resourceSubType\":null,\"resourceKey\":null,\"publicResourceKey"
            + "\":null,\"etag\":null,\"fileName\":null,\"descriptor\":null,\"externalId\":null,\"data\":null,\"preview\":null,"
            + "\"public\":false,\"link\":null,\"name\":null,\"publicLink\":null}",
        actualConstructResourceUpdatedMsgResult.getEntity());
    assertEquals(-7476899250389416711L, actualConstructResourceUpdatedMsgResult.getIdLSB());
    assertEquals(0, actualConstructResourceUpdatedMsgResult.getMsgTypeValue());
    assertEquals(3, actualConstructResourceUpdatedMsgResult.getAllFields().size());
    assertEquals(383, actualConstructResourceUpdatedMsgResult.getSerializedSize());
    assertEquals(8669210807411032922L, actualConstructResourceUpdatedMsgResult.getIdMSB());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructResourceUpdatedMsgResult.getMsgType());
    assertFalse(actualConstructResourceUpdatedMsgResult.getIsSystem());
    assertFalse(actualConstructResourceUpdatedMsgResult.hasData());
    assertFalse(actualConstructResourceUpdatedMsgResult.hasEtag());
    assertTrue(actualConstructResourceUpdatedMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructResourceUpdatedMsgResult.isInitialized());
  }
}
