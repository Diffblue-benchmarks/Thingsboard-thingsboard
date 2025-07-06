package org.thingsboard.server.service.edge.rpc.constructor.ota;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.OtaPackage;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.gen.edge.v1.OtaPackageUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class OtaPackageMsgConstructorV2DiffblueTest {
  /**
   * Test {@link OtaPackageMsgConstructorV2#constructOtaPackageUpdatedMsg(UpdateMsgType,
   * OtaPackage)}.
   *
   * <ul>
   *   <li>Then return MsgTypeValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * OtaPackageMsgConstructorV2#constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)}
   */
  @Test
  @DisplayName(
      "Test constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage); then return MsgTypeValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "OtaPackageUpdateMsg OtaPackageMsgConstructorV2.constructOtaPackageUpdatedMsg(UpdateMsgType, OtaPackage)"
  })
  void testConstructOtaPackageUpdatedMsg_thenReturnMsgTypeValueIsZero() {
    // Arrange
    OtaPackageMsgConstructorV2 otaPackageMsgConstructorV2 = new OtaPackageMsgConstructorV2();

    OtaPackage otaPackage = new OtaPackage();
    otaPackage.setId(new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageUpdatedMsgResult =
        otaPackageMsgConstructorV2.constructOtaPackageUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, otaPackage);

    // Assert
    assertEquals(0, actualConstructOtaPackageUpdatedMsgResult.getMsgTypeValue());
    assertEquals(3, actualConstructOtaPackageUpdatedMsgResult.getAllFields().size());
    assertEquals(363, actualConstructOtaPackageUpdatedMsgResult.getSerializedSize());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructOtaPackageUpdatedMsgResult.getMsgType());
  }
}
