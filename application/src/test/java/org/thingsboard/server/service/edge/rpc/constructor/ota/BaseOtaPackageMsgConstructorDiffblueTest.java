package org.thingsboard.server.service.edge.rpc.constructor.ota;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.gen.edge.v1.OtaPackageUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class BaseOtaPackageMsgConstructorDiffblueTest {
  /**
   * Test {@link BaseOtaPackageMsgConstructor#constructOtaPackageDeleteMsg(OtaPackageId)}.
   * <p>
   * Method under test: {@link BaseOtaPackageMsgConstructor#constructOtaPackageDeleteMsg(OtaPackageId)}
   */
  @Test
  @DisplayName("Test constructOtaPackageDeleteMsg(OtaPackageId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OtaPackageUpdateMsg BaseOtaPackageMsgConstructor.constructOtaPackageDeleteMsg(OtaPackageId)"})
  void testConstructOtaPackageDeleteMsg() {
    // Arrange
    OtaPackageMsgConstructorV1 otaPackageMsgConstructorV1 = new OtaPackageMsgConstructorV1();

    // Act
    OtaPackageUpdateMsg actualConstructOtaPackageDeleteMsgResult = otaPackageMsgConstructorV1
        .constructOtaPackageDeleteMsg(new OtaPackageId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals("", actualConstructOtaPackageDeleteMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructOtaPackageDeleteMsgResult.getAdditionalInfo());
    assertEquals("", actualConstructOtaPackageDeleteMsgResult.getChecksum());
    assertEquals("", actualConstructOtaPackageDeleteMsgResult.getChecksumAlgorithm());
    assertEquals("", actualConstructOtaPackageDeleteMsgResult.getContentType());
    assertEquals("", actualConstructOtaPackageDeleteMsgResult.getEntity());
    assertEquals("", actualConstructOtaPackageDeleteMsgResult.getFileName());
    assertEquals("", actualConstructOtaPackageDeleteMsgResult.getTag());
    assertEquals("", actualConstructOtaPackageDeleteMsgResult.getTitle());
    assertEquals("", actualConstructOtaPackageDeleteMsgResult.getType());
    assertEquals("", actualConstructOtaPackageDeleteMsgResult.getUrl());
    assertEquals("", actualConstructOtaPackageDeleteMsgResult.getVersion());
    assertEquals(-7476899250389416711L, actualConstructOtaPackageDeleteMsgResult.getIdLSB());
    assertEquals(0L, actualConstructOtaPackageDeleteMsgResult.getDataSize());
    assertEquals(0L, actualConstructOtaPackageDeleteMsgResult.getDeviceProfileIdLSB());
    assertEquals(0L, actualConstructOtaPackageDeleteMsgResult.getDeviceProfileIdMSB());
    assertEquals(2, actualConstructOtaPackageDeleteMsgResult.getMsgTypeValue());
    assertEquals(23, actualConstructOtaPackageDeleteMsgResult.getSerializedSize());
    assertEquals(3, actualConstructOtaPackageDeleteMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructOtaPackageDeleteMsgResult.getIdMSB());
    assertEquals(UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE, actualConstructOtaPackageDeleteMsgResult.getMsgType());
    assertFalse(actualConstructOtaPackageDeleteMsgResult.hasAdditionalInfo());
    assertFalse(actualConstructOtaPackageDeleteMsgResult.hasChecksum());
    assertFalse(actualConstructOtaPackageDeleteMsgResult.hasChecksumAlgorithm());
    assertFalse(actualConstructOtaPackageDeleteMsgResult.hasContentType());
    assertFalse(actualConstructOtaPackageDeleteMsgResult.hasData());
    assertFalse(actualConstructOtaPackageDeleteMsgResult.hasDataSize());
    assertFalse(actualConstructOtaPackageDeleteMsgResult.hasFileName());
    assertFalse(actualConstructOtaPackageDeleteMsgResult.hasUrl());
    assertTrue(actualConstructOtaPackageDeleteMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructOtaPackageDeleteMsgResult.isInitialized());
  }
}
