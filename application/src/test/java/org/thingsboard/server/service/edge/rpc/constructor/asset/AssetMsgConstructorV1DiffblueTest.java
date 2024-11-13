package org.thingsboard.server.service.edge.rpc.constructor.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.DecimalNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.gen.edge.v1.AssetUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class AssetMsgConstructorV1DiffblueTest {
  /**
   * Test
   * {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   * <ul>
   *   <li>Given {@link AssetProfileId#AssetProfileId(UUID)} with id is
   * randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}
   */
  @Test
  @DisplayName("Test constructAssetUpdatedMsg(UpdateMsgType, Asset); given AssetProfileId(UUID) with id is randomUUID")
  void testConstructAssetUpdatedMsg_givenAssetProfileIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetMsgConstructorV1 assetMsgConstructorV1 = new AssetMsgConstructorV1();
    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(asset.getLabel()).thenReturn("Label");
    when(asset.getAssetProfileId()).thenReturn(new AssetProfileId(UUID.randomUUID()));
    when(asset.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.randomUUID());

    // Act
    assetMsgConstructorV1.constructAssetUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, asset);

    // Assert
    verify(asset, atLeast(1)).getAdditionalInfo();
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset, atLeast(1)).getCustomerId();
    verify(asset, atLeast(1)).getLabel();
    verify(asset).getName();
    verify(asset).getType();
    verify(asset, atLeast(1)).getUuidId();
  }

  /**
   * Test
   * {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   * <ul>
   *   <li>Then return AssetProfileIdLSB is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}
   */
  @Test
  @DisplayName("Test constructAssetUpdatedMsg(UpdateMsgType, Asset); then return AssetProfileIdLSB is zero")
  void testConstructAssetUpdatedMsg_thenReturnAssetProfileIdLSBIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetMsgConstructorV1 assetMsgConstructorV1 = new AssetMsgConstructorV1();
    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(asset.getLabel()).thenReturn("Label");
    when(asset.getAssetProfileId()).thenReturn(null);
    when(asset.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.randomUUID());

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
    assertFalse(actualConstructAssetUpdatedMsgResult.hasAssetProfileIdLSB());
    assertFalse(actualConstructAssetUpdatedMsgResult.hasAssetProfileIdMSB());
  }

  /**
   * Test
   * {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   * <ul>
   *   <li>Then return CustomerIdLSB is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}
   */
  @Test
  @DisplayName("Test constructAssetUpdatedMsg(UpdateMsgType, Asset); then return CustomerIdLSB is zero")
  void testConstructAssetUpdatedMsg_thenReturnCustomerIdLSBIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetMsgConstructorV1 assetMsgConstructorV1 = new AssetMsgConstructorV1();
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(UUID.randomUUID());
    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(asset.getLabel()).thenReturn("Label");
    when(asset.getAssetProfileId()).thenReturn(assetProfileId);
    when(asset.getCustomerId()).thenReturn(null);
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.randomUUID());

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult = assetMsgConstructorV1
        .constructAssetUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, asset);

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
   * Test
   * {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   * <ul>
   *   <li>Then return Label is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}
   */
  @Test
  @DisplayName("Test constructAssetUpdatedMsg(UpdateMsgType, Asset); then return Label is empty string")
  void testConstructAssetUpdatedMsg_thenReturnLabelIsEmptyString() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetMsgConstructorV1 assetMsgConstructorV1 = new AssetMsgConstructorV1();
    DecimalNode decimalNode = mock(DecimalNode.class);
    doNothing().when(decimalNode).serialize(Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(UUID.randomUUID());
    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(decimalNode);
    when(asset.getLabel()).thenReturn(null);
    when(asset.getAssetProfileId()).thenReturn(assetProfileId);
    when(asset.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.randomUUID());

    // Act
    AssetUpdateMsg actualConstructAssetUpdatedMsgResult = assetMsgConstructorV1
        .constructAssetUpdatedMsg(UpdateMsgType.ENTITY_CREATED_RPC_MESSAGE, asset);

    // Assert
    verify(decimalNode).serialize(isA(JsonGenerator.class), isA(SerializerProvider.class));
    verify(asset, atLeast(1)).getAdditionalInfo();
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset, atLeast(1)).getCustomerId();
    verify(asset).getLabel();
    verify(asset).getName();
    verify(asset).getType();
    verify(asset, atLeast(1)).getUuidId();
    verify(assetProfileId, atLeast(1)).getId();
    assertEquals("", actualConstructAssetUpdatedMsgResult.getLabel());
    assertFalse(actualConstructAssetUpdatedMsgResult.hasLabel());
  }

  /**
   * Test
   * {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}.
   * <ul>
   *   <li>Then return not hasAdditionalInfo.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetMsgConstructorV1#constructAssetUpdatedMsg(UpdateMsgType, Asset)}
   */
  @Test
  @DisplayName("Test constructAssetUpdatedMsg(UpdateMsgType, Asset); then return not hasAdditionalInfo")
  void testConstructAssetUpdatedMsg_thenReturnNotHasAdditionalInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetMsgConstructorV1 assetMsgConstructorV1 = new AssetMsgConstructorV1();
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(UUID.randomUUID());
    Asset asset = mock(Asset.class);
    when(asset.getAdditionalInfo()).thenReturn(null);
    when(asset.getLabel()).thenReturn("Label");
    when(asset.getAssetProfileId()).thenReturn(assetProfileId);
    when(asset.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(asset.getType()).thenReturn("Type");
    when(asset.getName()).thenReturn("Name");
    when(asset.getUuidId()).thenReturn(UUID.randomUUID());

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
    assertFalse(actualConstructAssetUpdatedMsgResult.hasAdditionalInfo());
  }
}
