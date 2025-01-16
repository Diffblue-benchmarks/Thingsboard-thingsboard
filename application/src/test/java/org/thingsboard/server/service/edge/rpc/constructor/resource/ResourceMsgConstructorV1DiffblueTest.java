package org.thingsboard.server.service.edge.rpc.constructor.resource;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class ResourceMsgConstructorV1DiffblueTest {
  /**
   * Test
   * {@link ResourceMsgConstructorV1#constructResourceUpdatedMsg(UpdateMsgType, TbResource)}.
   * <ul>
   *   <li>Given {@code IMAGE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceMsgConstructorV1#constructResourceUpdatedMsg(UpdateMsgType, TbResource)}
   */
  @Test
  @DisplayName("Test constructResourceUpdatedMsg(UpdateMsgType, TbResource); given 'IMAGE'; then return 'null'")
  void testConstructResourceUpdatedMsg_givenImage_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceMsgConstructorV1 resourceMsgConstructorV1 = new ResourceMsgConstructorV1();

    TbResource tbResource = new TbResource();
    tbResource.setResourceType(ResourceType.IMAGE);
    tbResource.setResourceKey("Resource Key");
    tbResource.setTitle("Mr");
    tbResource.setId(mock(TbResourceId.class));

    // Act and Assert
    assertNull(
        resourceMsgConstructorV1.constructResourceUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, tbResource));
  }
}
