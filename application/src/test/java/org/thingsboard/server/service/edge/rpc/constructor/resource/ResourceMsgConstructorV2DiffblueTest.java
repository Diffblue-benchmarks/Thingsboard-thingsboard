package org.thingsboard.server.service.edge.rpc.constructor.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.BooleanNode;
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
   * <p>Method under test: {@link
   * ResourceMsgConstructorV2#constructResourceUpdatedMsg(UpdateMsgType, TbResource)}
   */
  @Test
  @DisplayName("Test constructResourceUpdatedMsg(UpdateMsgType, TbResource)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceUpdateMsg ResourceMsgConstructorV2.constructResourceUpdatedMsg(UpdateMsgType, TbResource)"
  })
  void testConstructResourceUpdatedMsg() {
    // Arrange
    ResourceMsgConstructorV2 resourceMsgConstructorV2 = new ResourceMsgConstructorV2();

    TbResource tbResource = new TbResource();
    tbResource.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ResourceUpdateMsg actualConstructResourceUpdatedMsgResult =
        resourceMsgConstructorV2.constructResourceUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tbResource);

    // Assert
    assertEquals(
        "{\"id\":{\"entityType\":\"TB_RESOURCE\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,\"tenantId"
            + "\":null,\"title\":null,\"resourceType\":null,\"resourceSubType\":null,\"resourceKey\":null,\"publicResourceKey"
            + "\":null,\"etag\":null,\"fileName\":null,\"descriptor\":null,\"externalId\":null,\"data\":null,\"preview\":null,"
            + "\"public\":false,\"link\":null,\"name\":null,\"publicLink\":null}",
        actualConstructResourceUpdatedMsgResult.getEntity());
    assertEquals(383, actualConstructResourceUpdatedMsgResult.getSerializedSize());
  }

  /**
   * Test {@link ResourceMsgConstructorV2#constructResourceUpdatedMsg(UpdateMsgType, TbResource)}.
   *
   * <ul>
   *   <li>Then return SerializedSize is three hundred eighty-four.
   * </ul>
   *
   * <p>Method under test: {@link
   * ResourceMsgConstructorV2#constructResourceUpdatedMsg(UpdateMsgType, TbResource)}
   */
  @Test
  @DisplayName(
      "Test constructResourceUpdatedMsg(UpdateMsgType, TbResource); then return SerializedSize is three hundred eighty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceUpdateMsg ResourceMsgConstructorV2.constructResourceUpdatedMsg(UpdateMsgType, TbResource)"
  })
  void testConstructResourceUpdatedMsg_thenReturnSerializedSizeIsThreeHundredEightyFour() {
    // Arrange
    ResourceMsgConstructorV2 resourceMsgConstructorV2 = new ResourceMsgConstructorV2();

    TbResource tbResource = new TbResource();
    tbResource.setDescriptor(BooleanNode.getFalse());
    tbResource.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ResourceUpdateMsg actualConstructResourceUpdatedMsgResult =
        resourceMsgConstructorV2.constructResourceUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tbResource);

    // Assert
    assertEquals(
        "{\"id\":{\"entityType\":\"TB_RESOURCE\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,\"tenantId"
            + "\":null,\"title\":null,\"resourceType\":null,\"resourceSubType\":null,\"resourceKey\":null,\"publicResourceKey"
            + "\":null,\"etag\":null,\"fileName\":null,\"descriptor\":false,\"externalId\":null,\"data\":null,\"preview\":null,"
            + "\"public\":false,\"link\":null,\"name\":null,\"publicLink\":null}",
        actualConstructResourceUpdatedMsgResult.getEntity());
    assertEquals(384, actualConstructResourceUpdatedMsgResult.getSerializedSize());
  }
}
