package org.thingsboard.server.service.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportColumnType;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.service.entitiy.asset.DefaultTbAssetService;

@ExtendWith(MockitoExtension.class)
class AssetBulkImportServiceDiffblueTest {
  @InjectMocks private AssetBulkImportService assetBulkImportService;

  /**
   * Test {@link AssetBulkImportService#setEntityFields(Asset, Map)} with {@code Asset}, {@code
   * Map}.
   *
   * <p>Method under test: {@link AssetBulkImportService#setEntityFields(Asset, Map)}
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
    JsonNode additionalInfo = entity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertEquals("{ }", additionalInfo.toPrettyString());
    assertEquals(0, additionalInfo.size());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isNull());
    assertFalse(additionalInfo.isValueNode());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isObject());
  }

  /**
   * Test {@link AssetBulkImportService#setEntityFields(Asset, Map)} with {@code Asset}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code LABEL}.
   *   <li>Then calls {@link Asset#setLabel(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AssetBulkImportService#setEntityFields(Asset, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Asset, Map) with 'Asset', 'Map'; given 'LABEL'; then calls setLabel(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetBulkImportService.setEntityFields(Asset, Map)"})
  void testSetEntityFieldsWithAssetMap_givenLabel_thenCallsSetLabel() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Asset entity = mock(Asset.class);
    doNothing().when(entity).setLabel(Mockito.<String>any());
    doNothing().when(entity).setType(Mockito.<String>any());
    doNothing().when(entity).setName(Mockito.<String>any());
    when(entity.getAdditionalInfo()).thenReturn(jsonNode);
    doNothing().when(entity).setAdditionalInfo(Mockito.<JsonNode>any());

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.LABEL, "");
    fields.put(BulkImportColumnType.TYPE, "42");
    fields.put(BulkImportColumnType.NAME, "foo");

    // Act
    assetBulkImportService.setEntityFields(entity, fields);

    // Assert
    verify(jsonNode).isNull();
    verify(entity).setAdditionalInfo(isA(JsonNode.class));
    verify(entity, atLeast(1)).getAdditionalInfo();
    verify(entity).setLabel(eq(""));
    verify(entity).setName(eq("foo"));
    verify(entity).setType(eq("42"));
  }

  /**
   * Test {@link AssetBulkImportService#setEntityFields(Asset, Map)} with {@code Asset}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code NAME}.
   *   <li>Then calls {@link Asset#setName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AssetBulkImportService#setEntityFields(Asset, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Asset, Map) with 'Asset', 'Map'; given 'NAME'; then calls setName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetBulkImportService.setEntityFields(Asset, Map)"})
  void testSetEntityFieldsWithAssetMap_givenName_thenCallsSetName() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Asset entity = mock(Asset.class);
    doNothing().when(entity).setName(Mockito.<String>any());
    when(entity.getAdditionalInfo()).thenReturn(jsonNode);
    doNothing().when(entity).setAdditionalInfo(Mockito.<JsonNode>any());

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.NAME, "foo");

    // Act
    assetBulkImportService.setEntityFields(entity, fields);

    // Assert
    verify(jsonNode).isNull();
    verify(entity).setAdditionalInfo(isA(JsonNode.class));
    verify(entity, atLeast(1)).getAdditionalInfo();
    verify(entity).setName(eq("foo"));
  }

  /**
   * Test {@link AssetBulkImportService#setEntityFields(Asset, Map)} with {@code Asset}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code SHARED_ATTRIBUTE}.
   * </ul>
   *
   * <p>Method under test: {@link AssetBulkImportService#setEntityFields(Asset, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Asset, Map) with 'Asset', 'Map'; given 'SHARED_ATTRIBUTE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetBulkImportService.setEntityFields(Asset, Map)"})
  void testSetEntityFieldsWithAssetMap_givenSharedAttribute() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Asset entity = mock(Asset.class);
    doNothing().when(entity).setType(Mockito.<String>any());
    doNothing().when(entity).setName(Mockito.<String>any());
    when(entity.getAdditionalInfo()).thenReturn(jsonNode);
    doNothing().when(entity).setAdditionalInfo(Mockito.<JsonNode>any());

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.SHARED_ATTRIBUTE, "");
    fields.put(BulkImportColumnType.TYPE, "42");
    fields.put(BulkImportColumnType.NAME, "foo");

    // Act
    assetBulkImportService.setEntityFields(entity, fields);

    // Assert
    verify(jsonNode).isNull();
    verify(entity).setAdditionalInfo(isA(JsonNode.class));
    verify(entity, atLeast(1)).getAdditionalInfo();
    verify(entity).setName(eq("foo"));
    verify(entity).setType(eq("42"));
  }

  /**
   * Test {@link AssetBulkImportService#setEntityFields(Asset, Map)} with {@code Asset}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code TYPE}.
   *   <li>Then calls {@link Asset#setType(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AssetBulkImportService#setEntityFields(Asset, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Asset, Map) with 'Asset', 'Map'; given 'TYPE'; then calls setType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetBulkImportService.setEntityFields(Asset, Map)"})
  void testSetEntityFieldsWithAssetMap_givenType_thenCallsSetType() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Asset entity = mock(Asset.class);
    doNothing().when(entity).setType(Mockito.<String>any());
    doNothing().when(entity).setName(Mockito.<String>any());
    when(entity.getAdditionalInfo()).thenReturn(jsonNode);
    doNothing().when(entity).setAdditionalInfo(Mockito.<JsonNode>any());

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.TYPE, "42");
    fields.put(BulkImportColumnType.NAME, "foo");

    // Act
    assetBulkImportService.setEntityFields(entity, fields);

    // Assert
    verify(jsonNode).isNull();
    verify(entity).setAdditionalInfo(isA(JsonNode.class));
    verify(entity, atLeast(1)).getAdditionalInfo();
    verify(entity).setName(eq("foo"));
    verify(entity).setType(eq("42"));
  }

  /**
   * Test {@link AssetBulkImportService#setEntityFields(Asset, Map)} with {@code Asset}, {@code
   * Map}.
   *
   * <ul>
   *   <li>When {@link Asset#Asset()}.
   *   <li>Then {@link Asset#Asset()} AdditionalInfo {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link AssetBulkImportService#setEntityFields(Asset, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Asset, Map) with 'Asset', 'Map'; when Asset(); then Asset() AdditionalInfo ObjectNode")
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
   * Test {@link AssetBulkImportService#setEntityFields(Asset, Map)} with {@code Asset}, {@code
   * Map}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then calls {@link JsonNode#isNull()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetBulkImportService#setEntityFields(Asset, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Asset, Map) with 'Asset', 'Map'; when HashMap(); then calls isNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetBulkImportService.setEntityFields(Asset, Map)"})
  void testSetEntityFieldsWithAssetMap_whenHashMap_thenCallsIsNull() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Asset entity = mock(Asset.class);
    when(entity.getAdditionalInfo()).thenReturn(jsonNode);
    doNothing().when(entity).setAdditionalInfo(Mockito.<JsonNode>any());

    // Act
    assetBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    verify(jsonNode).isNull();
    verify(entity).setAdditionalInfo(isA(JsonNode.class));
    verify(entity, atLeast(1)).getAdditionalInfo();
  }

  /**
   * Test {@link AssetBulkImportService#getEntityType()}.
   *
   * <p>Method under test: {@link AssetBulkImportService#getEntityType()}
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
    assertEquals(
        EntityType.ASSET,
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl())
            .getEntityType());
  }
}
