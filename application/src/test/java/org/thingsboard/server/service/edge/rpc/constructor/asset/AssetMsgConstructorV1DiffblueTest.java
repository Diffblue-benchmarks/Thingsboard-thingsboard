package org.thingsboard.server.service.edge.rpc.constructor.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.ByteIterator;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.gen.edge.v1.AssetUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

@ExtendWith(MockitoExtension.class)
class AssetMsgConstructorV1DiffblueTest {
  @InjectMocks
  private AssetMsgConstructorV1 assetMsgConstructorV1;

  /**
   * Test {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   * <p>
   * Method under test: {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}
   */
  @Test
  @DisplayName("Test constructAssetUpdatedMsg(UpdateMsgType, Asset)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetUpdateMsg AssetMsgConstructorV1.constructAssetUpdatedMsg(UpdateMsgType, Asset)"})
  void testConstructAssetUpdatedMsg() {
    // Arrange
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(null);
    when(asset.getLabel()).thenReturn("Label");
    when(asset.getAssetProfileId()).thenReturn(assetProfileId);
    when(asset.getCustomerId()).thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult = assetMsgConstructorV1
        .constructAssetUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, asset);

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
    assertEquals(12, actualConstructAssetUpdatedMsgResult.getDescriptorForType().getFields().size());
    assertEquals(82, actualConstructAssetUpdatedMsgResult.getSerializedSize());
    assertEquals(9, actualConstructAssetUpdatedMsgResult.getAllFields().size());
    assertFalse(additionalInfoBytes.iterator().hasNext());
    assertFalse(actualConstructAssetUpdatedMsgResult.hasAdditionalInfo());
    assertTrue(additionalInfoBytes.isEmpty());
    AssetUpdateMsg defaultInstanceForType = actualConstructAssetUpdatedMsgResult.getDefaultInstanceForType();
    assertEquals(additionalInfoBytes, defaultInstanceForType.getAdditionalInfoBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getEntityBytes());
    assertEquals(additionalInfoBytes, actualConstructAssetUpdatedMsgResult.getEntityBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getLabelBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getNameBytes());
    assertEquals(additionalInfoBytes, defaultInstanceForType.getTypeBytes());
  }

  /**
   * Test {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   * <p>
   * Method under test: {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}
   */
  @Test
  @DisplayName("Test constructAssetUpdatedMsg(UpdateMsgType, Asset)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetUpdateMsg AssetMsgConstructorV1.constructAssetUpdatedMsg(UpdateMsgType, Asset)"})
  void testConstructAssetUpdatedMsg2() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true), 3));
    when(asset.getLabel()).thenReturn("Label");
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(asset.getAssetProfileId()).thenReturn(assetProfileId);
    when(asset.getCustomerId()).thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult = assetMsgConstructorV1
        .constructAssetUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, asset);

    // Assert
    assertEquals("[]", actualConstructAssetUpdatedMsgResult.getAdditionalInfo());
    ByteString additionalInfoBytes = actualConstructAssetUpdatedMsgResult.getAdditionalInfoBytes();
    ByteIterator iteratorResult = additionalInfoBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('[', nextResult.byteValue());
    assertEquals(']', nextResult2.byteValue());
    assertEquals("[]", additionalInfoBytes.toStringUtf8());
    assertEquals(86, actualConstructAssetUpdatedMsgResult.getSerializedSize());
    verify(asset, atLeast(1)).getAdditionalInfo();
    verify(asset, atLeast(1)).getLabel();
    verify(asset).getName();
    verify(asset).getType();
    verify(asset, atLeast(1)).getUuidId();
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset, atLeast(1)).getCustomerId();
    verify(assetProfileId, atLeast(1)).getId();
  }

  /**
   * Test {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}
   */
  @Test
  @DisplayName("Test constructAssetUpdatedMsg(UpdateMsgType, Asset); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetUpdateMsg AssetMsgConstructorV1.constructAssetUpdatedMsg(UpdateMsgType, Asset)"})
  void testConstructAssetUpdatedMsg_givenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(asset.getLabel()).thenReturn("Label");
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(asset.getAssetProfileId()).thenReturn(assetProfileId);
    when(asset.getCustomerId()).thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult = assetMsgConstructorV1
        .constructAssetUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, asset);

    // Assert
    assertEquals("[]", actualConstructAssetUpdatedMsgResult.getAdditionalInfo());
    ByteString additionalInfoBytes = actualConstructAssetUpdatedMsgResult.getAdditionalInfoBytes();
    ByteIterator iteratorResult = additionalInfoBytes.iterator();
    Byte nextResult = iteratorResult.next();
    Byte nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals('[', nextResult.byteValue());
    assertEquals(']', nextResult2.byteValue());
    assertEquals("[]", additionalInfoBytes.toStringUtf8());
    assertEquals(86, actualConstructAssetUpdatedMsgResult.getSerializedSize());
    verify(asset, atLeast(1)).getAdditionalInfo();
    verify(asset, atLeast(1)).getLabel();
    verify(asset).getName();
    verify(asset).getType();
    verify(asset, atLeast(1)).getUuidId();
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset, atLeast(1)).getCustomerId();
    verify(assetProfileId, atLeast(1)).getId();
  }

  /**
   * Test {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   * <ul>
   *   <li>Then return AdditionalInfo is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}
   */
  @Test
  @DisplayName("Test constructAssetUpdatedMsg(UpdateMsgType, Asset); then return AdditionalInfo is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetUpdateMsg AssetMsgConstructorV1.constructAssetUpdatedMsg(UpdateMsgType, Asset)"})
  void testConstructAssetUpdatedMsg_thenReturnAdditionalInfoIsNull() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(asset.getLabel()).thenReturn("Label");
    when(asset.getAssetProfileId())
        .thenReturn(new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getCustomerId()).thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult = assetMsgConstructorV1
        .constructAssetUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, asset);

    // Assert
    assertEquals("null", actualConstructAssetUpdatedMsgResult.getAdditionalInfo());
    ByteString additionalInfoBytes = actualConstructAssetUpdatedMsgResult.getAdditionalInfoBytes();
    ByteIterator iteratorResult = additionalInfoBytes.iterator();
    assertTrue(iteratorResult.hasNext());
    assertEquals('n', iteratorResult.next().byteValue());
    assertEquals('u', iteratorResult.next().byteValue());
    assertEquals('l', iteratorResult.next().byteValue());
    assertEquals("null", additionalInfoBytes.toStringUtf8());
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
   * <ul>
   *   <li>Then return AssetProfileIdLSB is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}
   */
  @Test
  @DisplayName("Test constructAssetUpdatedMsg(UpdateMsgType, Asset); then return AssetProfileIdLSB is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetUpdateMsg AssetMsgConstructorV1.constructAssetUpdatedMsg(UpdateMsgType, Asset)"})
  void testConstructAssetUpdatedMsg_thenReturnAssetProfileIdLSBIsZero() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(asset.getLabel()).thenReturn("Label");
    when(asset.getAssetProfileId()).thenReturn(null);
    when(asset.getCustomerId()).thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult = assetMsgConstructorV1
        .constructAssetUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, asset);

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
    assertEquals(67, actualConstructAssetUpdatedMsgResult.getSerializedSize());
    assertFalse(actualConstructAssetUpdatedMsgResult.hasAssetProfileIdLSB());
    assertFalse(actualConstructAssetUpdatedMsgResult.hasAssetProfileIdMSB());
  }

  /**
   * Test {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   * <ul>
   *   <li>Then return CustomerIdLSB is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}
   */
  @Test
  @DisplayName("Test constructAssetUpdatedMsg(UpdateMsgType, Asset); then return CustomerIdLSB is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetUpdateMsg AssetMsgConstructorV1.constructAssetUpdatedMsg(UpdateMsgType, Asset)"})
  void testConstructAssetUpdatedMsg_thenReturnCustomerIdLSBIsZero() throws IOException {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    doNothing().when(jsonNode).serialize(Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(jsonNode);
    when(asset.getLabel()).thenReturn("Label");
    when(asset.getAssetProfileId()).thenReturn(assetProfileId);
    when(asset.getCustomerId()).thenReturn(null);
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult = assetMsgConstructorV1
        .constructAssetUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, asset);

    // Assert
    verify(jsonNode).serialize(isA(JsonGenerator.class), isA(SerializerProvider.class));
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
    assertEquals(63, actualConstructAssetUpdatedMsgResult.getSerializedSize());
    assertEquals(8, actualConstructAssetUpdatedMsgResult.getAllFields().size());
    assertFalse(actualConstructAssetUpdatedMsgResult.hasCustomerIdLSB());
    assertFalse(actualConstructAssetUpdatedMsgResult.hasCustomerIdMSB());
  }

  /**
   * Test {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   * <ul>
   *   <li>Then return Label is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}
   */
  @Test
  @DisplayName("Test constructAssetUpdatedMsg(UpdateMsgType, Asset); then return Label is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetUpdateMsg AssetMsgConstructorV1.constructAssetUpdatedMsg(UpdateMsgType, Asset)"})
  void testConstructAssetUpdatedMsg_thenReturnLabelIsEmptyString() throws IOException {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    doNothing().when(jsonNode).serialize(Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(jsonNode);
    when(asset.getLabel()).thenReturn(null);
    when(asset.getAssetProfileId()).thenReturn(assetProfileId);
    when(asset.getCustomerId()).thenReturn(null);
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult = assetMsgConstructorV1
        .constructAssetUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, asset);

    // Assert
    verify(jsonNode).serialize(isA(JsonGenerator.class), isA(SerializerProvider.class));
    verify(asset, atLeast(1)).getAdditionalInfo();
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset).getCustomerId();
    verify(asset).getLabel();
    verify(asset).getName();
    verify(asset).getType();
    verify(asset, atLeast(1)).getUuidId();
    verify(assetProfileId, atLeast(1)).getId();
    assertEquals("", actualConstructAssetUpdatedMsgResult.getLabel());
    assertEquals(56, actualConstructAssetUpdatedMsgResult.getSerializedSize());
    assertEquals(7, actualConstructAssetUpdatedMsgResult.getAllFields().size());
    assertFalse(actualConstructAssetUpdatedMsgResult.hasLabel());
  }
}
