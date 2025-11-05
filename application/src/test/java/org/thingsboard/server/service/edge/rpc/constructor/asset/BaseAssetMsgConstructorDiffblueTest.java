package org.thingsboard.server.service.edge.rpc.constructor.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.gen.edge.v1.AssetUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class BaseAssetMsgConstructorDiffblueTest {
  /**
   * Test {@link BaseAssetMsgConstructor#constructAssetDeleteMsg(AssetId)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetMsgConstructor#constructAssetDeleteMsg(AssetId)}
   */
  @Test
  @DisplayName(
      "Test constructAssetDeleteMsg(AssetId); then return InitializationErrorString is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetUpdateMsg BaseAssetMsgConstructor.constructAssetDeleteMsg(AssetId)"})
  void testConstructAssetDeleteMsg_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    AssetMsgConstructorV1 assetMsgConstructorV1 = new AssetMsgConstructorV1();

    // Act
    AssetUpdateMsg actualConstructAssetDeleteMsgResult =
        assetMsgConstructorV1.constructAssetDeleteMsg(
            new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals("", actualConstructAssetDeleteMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructAssetDeleteMsgResult.getAdditionalInfo());
    assertEquals("", actualConstructAssetDeleteMsgResult.getEntity());
    assertEquals("", actualConstructAssetDeleteMsgResult.getLabel());
    assertEquals("", actualConstructAssetDeleteMsgResult.getName());
    assertEquals("", actualConstructAssetDeleteMsgResult.getType());
    assertEquals(-7476899250389416711L, actualConstructAssetDeleteMsgResult.getIdLSB());
    assertEquals(0L, actualConstructAssetDeleteMsgResult.getAssetProfileIdLSB());
    assertEquals(0L, actualConstructAssetDeleteMsgResult.getAssetProfileIdMSB());
    assertEquals(0L, actualConstructAssetDeleteMsgResult.getCustomerIdLSB());
    assertEquals(0L, actualConstructAssetDeleteMsgResult.getCustomerIdMSB());
    assertEquals(2, actualConstructAssetDeleteMsgResult.getMsgTypeValue());
    assertEquals(23, actualConstructAssetDeleteMsgResult.getSerializedSize());
    assertEquals(3, actualConstructAssetDeleteMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructAssetDeleteMsgResult.getIdMSB());
    assertEquals(
        UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE, actualConstructAssetDeleteMsgResult.getMsgType());
    assertFalse(actualConstructAssetDeleteMsgResult.hasAdditionalInfo());
    assertFalse(actualConstructAssetDeleteMsgResult.hasAssetProfileIdLSB());
    assertFalse(actualConstructAssetDeleteMsgResult.hasAssetProfileIdMSB());
    assertFalse(actualConstructAssetDeleteMsgResult.hasCustomerIdLSB());
    assertFalse(actualConstructAssetDeleteMsgResult.hasCustomerIdMSB());
    assertFalse(actualConstructAssetDeleteMsgResult.hasLabel());
    assertTrue(actualConstructAssetDeleteMsgResult.findInitializationErrors().isEmpty());
  }
}
