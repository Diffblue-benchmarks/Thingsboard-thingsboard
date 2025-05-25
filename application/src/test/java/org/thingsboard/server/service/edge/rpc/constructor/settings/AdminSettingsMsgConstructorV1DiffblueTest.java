package org.thingsboard.server.service.edge.rpc.constructor.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.gen.edge.v1.AdminSettingsUpdateMsg;

class AdminSettingsMsgConstructorV1DiffblueTest {
  /**
   * Test {@link AdminSettingsMsgConstructorV1#constructAdminSettingsUpdateMsg(AdminSettings)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>Then return JsonValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsMsgConstructorV1#constructAdminSettingsUpdateMsg(AdminSettings)}
   */
  @Test
  @DisplayName("Test constructAdminSettingsUpdateMsg(AdminSettings); given Instance; then return JsonValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "AdminSettingsUpdateMsg AdminSettingsMsgConstructorV1.constructAdminSettingsUpdateMsg(AdminSettings)"})
  void testConstructAdminSettingsUpdateMsg_givenInstance_thenReturnJsonValueIsNull() {
    // Arrange
    AdminSettingsMsgConstructorV1 adminSettingsMsgConstructorV1 = new AdminSettingsMsgConstructorV1();

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(MissingNode.getInstance());
    adminSettings.setKey("");

    // Act
    AdminSettingsUpdateMsg actualConstructAdminSettingsUpdateMsgResult = adminSettingsMsgConstructorV1
        .constructAdminSettingsUpdateMsg(adminSettings);

    // Assert
    assertEquals("null", actualConstructAdminSettingsUpdateMsgResult.getJsonValue());
    ByteString jsonValueBytes = actualConstructAdminSettingsUpdateMsgResult.getJsonValueBytes();
    ByteIterator iteratorResult = jsonValueBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('l', iteratorResult.next().byteValue());
    assertEquals("null", jsonValueBytes.toStringUtf8());
    assertEquals(6, actualConstructAdminSettingsUpdateMsgResult.getSerializedSize());
  }
}
