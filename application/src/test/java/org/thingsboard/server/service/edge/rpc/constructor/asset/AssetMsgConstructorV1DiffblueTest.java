package org.thingsboard.server.service.edge.rpc.constructor.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.gen.edge.v1.AssetUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class AssetMsgConstructorV1DiffblueTest {
  /**
   * Test {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   *
   * <p>Method under test: {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType,
   * Asset)}
   */
  @Test
  @DisplayName("Test constructAssetUpdatedMsg(UpdateMsgType, Asset)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetUpdateMsg AssetMsgConstructorV1.constructAssetUpdatedMsg(UpdateMsgType, Asset)"
  })
  void testConstructAssetUpdatedMsg() {
    // Arrange
    AssetMsgConstructorV1 assetMsgConstructorV1 = new AssetMsgConstructorV1();

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(null);
    when(asset.getLabel()).thenReturn("Label");
    when(asset.getAssetProfileId()).thenReturn(assetProfileId);
    when(asset.getCustomerId())
        .thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult =
        assetMsgConstructorV1.constructAssetUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, asset);

    // Assert
    verify(asset).getAdditionalInfo();
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset, atLeast(1)).getCustomerId();
    verify(asset, atLeast(1)).getLabel();
    verify(asset).getName();
    verify(asset).getType();
    verify(asset, atLeast(1)).getUuidId();
    verify(assetProfileId, atLeast(1)).getId();
    ByteString additionalInfoBytes = actualConstructAssetUpdatedMsgResult.getAdditionalInfoBytes();
    assertEquals("", additionalInfoBytes.toStringUtf8());
    assertEquals("", actualConstructAssetUpdatedMsgResult.getAdditionalInfo());
    assertEquals(
        12, actualConstructAssetUpdatedMsgResult.getDescriptorForType().getFields().size());
    assertEquals(82, actualConstructAssetUpdatedMsgResult.getSerializedSize());
    assertFalse(additionalInfoBytes.iterator().hasNext());
    assertFalse(actualConstructAssetUpdatedMsgResult.hasAdditionalInfo());
    assertTrue(additionalInfoBytes.isEmpty());
    AssetUpdateMsg defaultInstanceForType =
        actualConstructAssetUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType.getAdditionalInfoBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getEntityBytes());
    assertEquals(additionalInfoBytes, actualConstructAssetUpdatedMsgResult.getEntityBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getLabelBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getNameBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getTypeBytes());
  }

  /**
   * Test {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   *
   * <ul>
   *   <li>Then return AdditionalInfo is {@code 10.0}.
   * </ul>
   *
   * <p>Method under test: {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType,
   * Asset)}
   */
  @Test
  @DisplayName(
      "Test constructAssetUpdatedMsg(UpdateMsgType, Asset); then return AdditionalInfo is '10.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetUpdateMsg AssetMsgConstructorV1.constructAssetUpdatedMsg(UpdateMsgType, Asset)"
  })
  void testConstructAssetUpdatedMsg_thenReturnAdditionalInfoIs100() {
    // Arrange
    AssetMsgConstructorV1 assetMsgConstructorV1 = new AssetMsgConstructorV1();

    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(DoubleNode.valueOf(10.0d));
    when(asset.getLabel()).thenReturn("Label");
    when(asset.getAssetProfileId())
        .thenReturn(new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getCustomerId())
        .thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult =
        assetMsgConstructorV1.constructAssetUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, asset);

    // Assert
    assertEquals("10.0", actualConstructAssetUpdatedMsgResult.getAdditionalInfo());
    ByteString additionalInfoBytes = actualConstructAssetUpdatedMsgResult.getAdditionalInfoBytes();
    ByteIterator iteratorResult = additionalInfoBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('1', iteratorResult.next().byteValue());
    assertEquals('0', iteratorResult.next().byteValue());
    assertEquals('.', iteratorResult.next().byteValue());
    assertEquals("10.0", additionalInfoBytes.toStringUtf8());
    assertEquals(88, actualConstructAssetUpdatedMsgResult.getSerializedSize());
    verify(asset, atLeast(1)).getAdditionalInfo();
    verify(asset, atLeast(1)).getLabel();
    verify(asset).getName();
    verify(asset).getType();
    verify(asset, atLeast(1)).getUuidId();
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset, atLeast(1)).getCustomerId();
  }

  /**
   * Test {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   *
   * <ul>
   *   <li>Then return AssetProfileIdLSB is zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType,
   * Asset)}
   */
  @Test
  @DisplayName(
      "Test constructAssetUpdatedMsg(UpdateMsgType, Asset); then return AssetProfileIdLSB is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetUpdateMsg AssetMsgConstructorV1.constructAssetUpdatedMsg(UpdateMsgType, Asset)"
  })
  void testConstructAssetUpdatedMsg_thenReturnAssetProfileIdLSBIsZero() {
    // Arrange
    AssetMsgConstructorV1 assetMsgConstructorV1 = new AssetMsgConstructorV1();

    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(DoubleNode.valueOf(10.0d));
    when(asset.getLabel()).thenReturn("Label");
    when(asset.getAssetProfileId()).thenReturn(null);
    when(asset.getCustomerId())
        .thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult =
        assetMsgConstructorV1.constructAssetUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, asset);

    // Assert
    verify(asset, atLeast(1)).getAdditionalInfo();
    verify(asset).getAssetProfileId();
    verify(asset, atLeast(1)).getCustomerId();
    verify(asset, atLeast(1)).getLabel();
    verify(asset).getName();
    verify(asset).getType();
    verify(asset, atLeast(1)).getUuidId();
    assertEquals(0L, actualConstructAssetUpdatedMsgResult.getAssetProfileIdLSB());
    assertEquals(0L, actualConstructAssetUpdatedMsgResult.getAssetProfileIdMSB());
    assertFalse(actualConstructAssetUpdatedMsgResult.hasAssetProfileIdLSB());
    assertFalse(actualConstructAssetUpdatedMsgResult.hasAssetProfileIdMSB());
  }

  /**
   * Test {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   *
   * <ul>
   *   <li>Then return CustomerIdLSB is zero.
   * </ul>
   *
   * <p>Method under test: {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType,
   * Asset)}
   */
  @Test
  @DisplayName(
      "Test constructAssetUpdatedMsg(UpdateMsgType, Asset); then return CustomerIdLSB is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetUpdateMsg AssetMsgConstructorV1.constructAssetUpdatedMsg(UpdateMsgType, Asset)"
  })
  void testConstructAssetUpdatedMsg_thenReturnCustomerIdLSBIsZero() {
    // Arrange
    AssetMsgConstructorV1 assetMsgConstructorV1 = new AssetMsgConstructorV1();

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(DoubleNode.valueOf(10.0d));
    when(asset.getLabel()).thenReturn("Label");
    when(asset.getAssetProfileId()).thenReturn(assetProfileId);
    when(asset.getCustomerId()).thenReturn(null);
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult =
        assetMsgConstructorV1.constructAssetUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, asset);

    // Assert
    verify(asset, atLeast(1)).getAdditionalInfo();
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset).getCustomerId();
    verify(asset, atLeast(1)).getLabel();
    verify(asset).getName();
    verify(asset).getType();
    verify(asset, atLeast(1)).getUuidId();
    verify(assetProfileId, atLeast(1)).getId();
    assertEquals(0L, actualConstructAssetUpdatedMsgResult.getCustomerIdLSB());
    assertEquals(0L, actualConstructAssetUpdatedMsgResult.getCustomerIdMSB());
    assertFalse(actualConstructAssetUpdatedMsgResult.hasCustomerIdLSB());
    assertFalse(actualConstructAssetUpdatedMsgResult.hasCustomerIdMSB());
  }

  /**
   * Test {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   *
   * <ul>
   *   <li>Then return Label is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType,
   * Asset)}
   */
  @Test
  @DisplayName(
      "Test constructAssetUpdatedMsg(UpdateMsgType, Asset); then return Label is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetUpdateMsg AssetMsgConstructorV1.constructAssetUpdatedMsg(UpdateMsgType, Asset)"
  })
  void testConstructAssetUpdatedMsg_thenReturnLabelIsEmptyString() {
    // Arrange
    AssetMsgConstructorV1 assetMsgConstructorV1 = new AssetMsgConstructorV1();

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Asset asset = mock(Asset.class);
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    when(asset.getAdditionalInfo()).thenReturn(new ArrayNode(nf));
    when(asset.getLabel()).thenReturn(null);
    when(asset.getAssetProfileId()).thenReturn(assetProfileId);
    when(asset.getCustomerId())
        .thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult =
        assetMsgConstructorV1.constructAssetUpdatedMsg(
            UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, asset);

    // Assert
    verify(asset, atLeast(1)).getAdditionalInfo();
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset, atLeast(1)).getCustomerId();
    verify(asset).getLabel();
    verify(asset).getName();
    verify(asset).getType();
    verify(asset, atLeast(1)).getUuidId();
    verify(assetProfileId, atLeast(1)).getId();
    assertEquals("", actualConstructAssetUpdatedMsgResult.getLabel());
    assertEquals(79, actualConstructAssetUpdatedMsgResult.getSerializedSize());
    assertFalse(actualConstructAssetUpdatedMsgResult.hasLabel());
  }
}
