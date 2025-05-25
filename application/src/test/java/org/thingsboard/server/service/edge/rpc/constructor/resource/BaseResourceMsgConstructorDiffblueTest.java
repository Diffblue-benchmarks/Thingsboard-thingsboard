package org.thingsboard.server.service.edge.rpc.constructor.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.gen.edge.v1.ResourceUpdateMsg;

class BaseResourceMsgConstructorDiffblueTest {
  /**
   * Test {@link BaseResourceMsgConstructor#constructResourceDeleteMsg(TbResourceId)}.
   * <ul>
   *   <li>Then return IdLSB is {@code -7476899250389416711}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseResourceMsgConstructor#constructResourceDeleteMsg(TbResourceId)}
   */
  @Test
  @DisplayName("Test constructResourceDeleteMsg(TbResourceId); then return IdLSB is '-7476899250389416711'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResourceUpdateMsg BaseResourceMsgConstructor.constructResourceDeleteMsg(TbResourceId)"})
  void testConstructResourceDeleteMsg_thenReturnIdLSBIs7476899250389416711() {
    // Arrange
    ResourceMsgConstructorV1 resourceMsgConstructorV1 = new ResourceMsgConstructorV1();

    // Act
    ResourceUpdateMsg actualConstructResourceDeleteMsgResult = resourceMsgConstructorV1
        .constructResourceDeleteMsg(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(-7476899250389416711L, actualConstructResourceDeleteMsgResult.getIdLSB());
    assertEquals(23, actualConstructResourceDeleteMsgResult.getSerializedSize());
    assertEquals(8669210807411032922L, actualConstructResourceDeleteMsgResult.getIdMSB());
  }
}
