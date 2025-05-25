package org.thingsboard.server.service.asset;

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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.BaseDataWithAdditionalInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.service.entitiy.asset.DefaultTbAssetService;

@ExtendWith(MockitoExtension.class)
class AssetBulkImportServiceDiffblueTest {
  @InjectMocks
  private AssetBulkImportService assetBulkImportService;

  /**
   * Test {@link AssetBulkImportService#setEntityFields(Asset, Map)} with {@code Asset}, {@code Map}.
   * <p>
   * Method under test: {@link AssetBulkImportService#setEntityFields(Asset, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Asset, Map) with 'Asset', 'Map'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetBulkImportService.setEntityFields(Asset, Map)"})
  void testSetEntityFieldsWithAssetMap() {
    // Arrange
    Asset entity = new Asset(new Asset());

    // Act
    assetBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    assertTrue(entity.getAdditionalInfo() instanceof ObjectNode);
  }

  /**
   * Test {@link AssetBulkImportService#setEntityFields(Asset, Map)} with {@code Asset}, {@code Map}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>Then calls {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetBulkImportService#setEntityFields(Asset, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Asset, Map) with 'Asset', 'Map'; given Instance; then calls setAdditionalInfo(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetBulkImportService.setEntityFields(Asset, Map)"})
  void testSetEntityFieldsWithAssetMap_givenInstance_thenCallsSetAdditionalInfo() {
    // Arrange
    Asset entity = mock(Asset.class);
    when(entity.getAdditionalInfo()).thenReturn(NullNode.getInstance());
    doNothing().when(entity).setAdditionalInfo(Mockito.<JsonNode>any());

    // Act
    assetBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    verify(entity).setAdditionalInfo(isA(JsonNode.class));
    verify(entity, atLeast(1)).getAdditionalInfo();
  }

  /**
   * Test {@link AssetBulkImportService#setEntityFields(Asset, Map)} with {@code Asset}, {@code Map}.
   * <ul>
   *   <li>When {@link Asset#Asset()}.</li>
   *   <li>Then {@link Asset#Asset()} AdditionalInfo {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetBulkImportService#setEntityFields(Asset, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Asset, Map) with 'Asset', 'Map'; when Asset(); then Asset() AdditionalInfo ObjectNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetBulkImportService.setEntityFields(Asset, Map)"})
  void testSetEntityFieldsWithAssetMap_whenAsset_thenAssetAdditionalInfoObjectNode() {
    // Arrange
    Asset entity = new Asset();

    // Act
    assetBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    JsonNode additionalInfo = entity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
  }

  /**
   * Test {@link AssetBulkImportService#getEntityType()}.
   * <p>
   * Method under test: {@link AssetBulkImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType AssetBulkImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    // Act and Assert
    assertEquals(EntityType.ASSET,
        (new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl())).getEntityType());
  }
}
