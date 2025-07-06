package org.thingsboard.server.service.edge.rpc.constructor.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.UnknownFieldSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.gen.edge.v1.AdminSettingsUpdateMsg;

class AdminSettingsMsgConstructorV2DiffblueTest {
  /**
   * Test {@link AdminSettingsMsgConstructorV2#constructAdminSettingsUpdateMsg(AdminSettings)}.
   *
   * <p>Method under test: {@link
   * AdminSettingsMsgConstructorV2#constructAdminSettingsUpdateMsg(AdminSettings)}
   */
  @Test
  @DisplayName("Test constructAdminSettingsUpdateMsg(AdminSettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AdminSettingsUpdateMsg AdminSettingsMsgConstructorV2.constructAdminSettingsUpdateMsg(AdminSettings)"
  })
  void testConstructAdminSettingsUpdateMsg() {
    // Arrange
    AdminSettingsMsgConstructorV2 adminSettingsMsgConstructorV2 =
        new AdminSettingsMsgConstructorV2();

    // Act
    AdminSettingsUpdateMsg actualConstructAdminSettingsUpdateMsgResult =
        adminSettingsMsgConstructorV2.constructAdminSettingsUpdateMsg(
            new AdminSettings(new AdminSettings()));

    // Assert
    UnknownFieldSet unknownFields = actualConstructAdminSettingsUpdateMsgResult.getUnknownFields();
    AdminSettingsUpdateMsg defaultInstanceForType =
        actualConstructAdminSettingsUpdateMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link AdminSettingsMsgConstructorV2#constructAdminSettingsUpdateMsg(AdminSettings)}.
   *
   * <ul>
   *   <li>Then return EntityBytes toStringUtf8 is a string.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminSettingsMsgConstructorV2#constructAdminSettingsUpdateMsg(AdminSettings)}
   */
  @Test
  @DisplayName(
      "Test constructAdminSettingsUpdateMsg(AdminSettings); then return EntityBytes toStringUtf8 is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AdminSettingsUpdateMsg AdminSettingsMsgConstructorV2.constructAdminSettingsUpdateMsg(AdminSettings)"
  })
  void testConstructAdminSettingsUpdateMsg_thenReturnEntityBytesToStringUtf8IsAString() {
    // Arrange
    AdminSettingsMsgConstructorV2 adminSettingsMsgConstructorV2 =
        new AdminSettingsMsgConstructorV2();

    // Act
    AdminSettingsUpdateMsg actualConstructAdminSettingsUpdateMsgResult =
        adminSettingsMsgConstructorV2.constructAdminSettingsUpdateMsg(
            new AdminSettings(
                new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));

    // Assert
    assertEquals(
        "{\"id\":{\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,\"tenantId\":null,\"key\":null,\"jsonValue"
            + "\":null}",
        actualConstructAdminSettingsUpdateMsgResult.getEntityBytes().toStringUtf8());
    assertEquals(
        "{\"id\":{\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,\"tenantId\":null,\"key\":null,\"jsonValue"
            + "\":null}",
        actualConstructAdminSettingsUpdateMsgResult.getEntity());
    assertEquals(114, actualConstructAdminSettingsUpdateMsgResult.getSerializedSize());
    UnknownFieldSet unknownFields = actualConstructAdminSettingsUpdateMsgResult.getUnknownFields();
    AdminSettingsUpdateMsg defaultInstanceForType =
        actualConstructAdminSettingsUpdateMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link AdminSettingsMsgConstructorV2#constructAdminSettingsUpdateMsg(AdminSettings)}.
   *
   * <ul>
   *   <li>When {@link AdminSettings#AdminSettings()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminSettingsMsgConstructorV2#constructAdminSettingsUpdateMsg(AdminSettings)}
   */
  @Test
  @DisplayName("Test constructAdminSettingsUpdateMsg(AdminSettings); when AdminSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AdminSettingsUpdateMsg AdminSettingsMsgConstructorV2.constructAdminSettingsUpdateMsg(AdminSettings)"
  })
  void testConstructAdminSettingsUpdateMsg_whenAdminSettings() {
    // Arrange
    AdminSettingsMsgConstructorV2 adminSettingsMsgConstructorV2 =
        new AdminSettingsMsgConstructorV2();

    // Act
    AdminSettingsUpdateMsg actualConstructAdminSettingsUpdateMsgResult =
        adminSettingsMsgConstructorV2.constructAdminSettingsUpdateMsg(new AdminSettings());

    // Assert
    UnknownFieldSet unknownFields = actualConstructAdminSettingsUpdateMsgResult.getUnknownFields();
    AdminSettingsUpdateMsg defaultInstanceForType =
        actualConstructAdminSettingsUpdateMsgResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }
}
