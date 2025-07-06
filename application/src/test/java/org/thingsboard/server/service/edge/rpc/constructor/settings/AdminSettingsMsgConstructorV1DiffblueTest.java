package org.thingsboard.server.service.edge.rpc.constructor.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.IntNode;
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
   *
   * <ul>
   *   <li>Given valueOf ten.
   *   <li>Then return JsonValue is {@code 10.0}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminSettingsMsgConstructorV1#constructAdminSettingsUpdateMsg(AdminSettings)}
   */
  @Test
  @DisplayName(
      "Test constructAdminSettingsUpdateMsg(AdminSettings); given valueOf ten; then return JsonValue is '10.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AdminSettingsUpdateMsg AdminSettingsMsgConstructorV1.constructAdminSettingsUpdateMsg(AdminSettings)"
  })
  void testConstructAdminSettingsUpdateMsg_givenValueOfTen_thenReturnJsonValueIs100() {
    // Arrange
    AdminSettingsMsgConstructorV1 adminSettingsMsgConstructorV1 =
        new AdminSettingsMsgConstructorV1();

    AdminSettings adminSettings = new AdminSettings(new AdminSettings());
    adminSettings.setKey("Admin Settings");
    adminSettings.setJsonValue(DoubleNode.valueOf(10.0d));

    // Act
    AdminSettingsUpdateMsg actualConstructAdminSettingsUpdateMsgResult =
        adminSettingsMsgConstructorV1.constructAdminSettingsUpdateMsg(adminSettings);

    // Assert
    assertEquals("10.0", actualConstructAdminSettingsUpdateMsgResult.getJsonValue());
    ByteString jsonValueBytes = actualConstructAdminSettingsUpdateMsgResult.getJsonValueBytes();
    ByteIterator iteratorResult = jsonValueBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('1', iteratorResult.next().byteValue());
    assertEquals('0', iteratorResult.next().byteValue());
    assertEquals('.', iteratorResult.next().byteValue());
    assertEquals("10.0", jsonValueBytes.toStringUtf8());
    assertEquals(22, actualConstructAdminSettingsUpdateMsgResult.getSerializedSize());
  }

  /**
   * Test {@link AdminSettingsMsgConstructorV1#constructAdminSettingsUpdateMsg(AdminSettings)}.
   *
   * <ul>
   *   <li>Given valueOf two.
   *   <li>Then return JsonValue is {@code 2}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminSettingsMsgConstructorV1#constructAdminSettingsUpdateMsg(AdminSettings)}
   */
  @Test
  @DisplayName(
      "Test constructAdminSettingsUpdateMsg(AdminSettings); given valueOf two; then return JsonValue is '2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AdminSettingsUpdateMsg AdminSettingsMsgConstructorV1.constructAdminSettingsUpdateMsg(AdminSettings)"
  })
  void testConstructAdminSettingsUpdateMsg_givenValueOfTwo_thenReturnJsonValueIs2() {
    // Arrange
    AdminSettingsMsgConstructorV1 adminSettingsMsgConstructorV1 =
        new AdminSettingsMsgConstructorV1();

    AdminSettings adminSettings = new AdminSettings(new AdminSettings());
    adminSettings.setKey("Admin Settings");
    adminSettings.setJsonValue(IntNode.valueOf(2));

    // Act
    AdminSettingsUpdateMsg actualConstructAdminSettingsUpdateMsgResult =
        adminSettingsMsgConstructorV1.constructAdminSettingsUpdateMsg(adminSettings);

    // Assert
    assertEquals("2", actualConstructAdminSettingsUpdateMsgResult.getJsonValue());
    ByteString jsonValueBytes = actualConstructAdminSettingsUpdateMsgResult.getJsonValueBytes();
    ByteIterator iteratorResult = jsonValueBytes.iterator();
    Byte nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('2', nextResult.byteValue());
    assertEquals("2", jsonValueBytes.toStringUtf8());
    assertEquals(19, actualConstructAdminSettingsUpdateMsgResult.getSerializedSize());
  }
}
