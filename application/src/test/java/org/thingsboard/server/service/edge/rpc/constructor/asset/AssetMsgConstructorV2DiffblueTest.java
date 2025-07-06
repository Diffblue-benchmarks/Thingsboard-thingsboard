package org.thingsboard.server.service.edge.rpc.constructor.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.asset.AssetInfo;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.gen.edge.v1.AssetUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class AssetMsgConstructorV2DiffblueTest {
  /**
   * Test {@link AssetMsgConstructorV2#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   *
   * <ul>
   *   <li>Then return MsgTypeValue is one.
   * </ul>
   *
   * <p>Method under test: {@link AssetMsgConstructorV2#constructAssetUpdatedMsg(UpdateMsgType,
   * Asset)}
   */
  @Test
  @DisplayName(
      "Test constructAssetUpdatedMsg(UpdateMsgType, Asset); then return MsgTypeValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AssetUpdateMsg AssetMsgConstructorV2.constructAssetUpdatedMsg(UpdateMsgType, Asset)"
  })
  void testConstructAssetUpdatedMsg_thenReturnMsgTypeValueIsOne() {
    // Arrange
    AssetMsgConstructorV2 assetMsgConstructorV2 = new AssetMsgConstructorV2();

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult =
        assetMsgConstructorV2.constructAssetUpdatedMsg(
            UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE,
            new AssetInfo(new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));

    // Assert
    assertEquals(1, actualConstructAssetUpdatedMsgResult.getMsgTypeValue());
    assertEquals(333, actualConstructAssetUpdatedMsgResult.getSerializedSize());
    assertEquals(4, actualConstructAssetUpdatedMsgResult.getAllFields().size());
    assertEquals(
        UpdateMsgType.ENTITY_UPDATED_RPC_MESSAGE,
        actualConstructAssetUpdatedMsgResult.getMsgType());
  }

  /**
   * Test {@link AssetMsgConstructorV2#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   *
   * <ul>
   *   <li>Then return MsgTypeValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetMsgConstructorV2#constructAssetUpdatedMsg(UpdateMsgType,
   * Asset)}
   */
  @Test
  @DisplayName(
      "Test constructAssetUpdatedMsg(UpdateMsgType, Asset); then return MsgTypeValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AssetUpdateMsg AssetMsgConstructorV2.constructAssetUpdatedMsg(UpdateMsgType, Asset)"
  })
  void testConstructAssetUpdatedMsg_thenReturnMsgTypeValueIsZero() {
    // Arrange
    AssetMsgConstructorV2 assetMsgConstructorV2 = new AssetMsgConstructorV2();

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult =
        assetMsgConstructorV2.constructAssetUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
            new AssetInfo(new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));

    // Assert
    assertEquals(0, actualConstructAssetUpdatedMsgResult.getMsgTypeValue());
    assertEquals(3, actualConstructAssetUpdatedMsgResult.getAllFields().size());
    assertEquals(331, actualConstructAssetUpdatedMsgResult.getSerializedSize());
    assertEquals(
        UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE,
        actualConstructAssetUpdatedMsgResult.getMsgType());
  }
}
