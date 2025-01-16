package org.thingsboard.server.service.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.BaseDataWithAdditionalInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.asset.AssetProfileService;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.AssetService;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.service.entitiy.asset.DefaultTbAssetService;
import org.thingsboard.server.service.entitiy.asset.TbAssetService;
import org.thingsboard.server.service.security.model.SecurityUser;

class AssetBulkImportServiceDiffblueTest {
  /**
   * Test {@link AssetBulkImportService#setEntityFields(Asset, Map)} with
   * {@code Asset}, {@code Map}.
   * <p>
   * Method under test: {@link AssetBulkImportService#setEntityFields(Asset, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Asset, Map) with 'Asset', 'Map'")
  void testSetEntityFieldsWithAssetMap() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());
    AssetBulkImportService assetBulkImportService = new AssetBulkImportService(null, tbAssetService,
        new AssetProfileServiceImpl());
    Asset entity = new Asset();

    // Act
    assetBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    JsonNode additionalInfo = entity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
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
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link AssetBulkImportService#setEntityFields(Asset, Map)} with
   * {@code Asset}, {@code Map}.
   * <p>
   * Method under test: {@link AssetBulkImportService#setEntityFields(Asset, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Asset, Map) with 'Asset', 'Map'")
  void testSetEntityFieldsWithAssetMap2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetService assetService = mock(AssetService.class);
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());
    AssetBulkImportService assetBulkImportService = new AssetBulkImportService(assetService, tbAssetService,
        new AssetProfileServiceImpl());
    Asset entity = new Asset();

    // Act
    assetBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    JsonNode additionalInfo = entity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
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
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link AssetBulkImportService#setEntityFields(Asset, Map)} with
   * {@code Asset}, {@code Map}.
   * <p>
   * Method under test: {@link AssetBulkImportService#setEntityFields(Asset, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Asset, Map) with 'Asset', 'Map'")
  void testSetEntityFieldsWithAssetMap3() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());
    AssetBulkImportService assetBulkImportService = new AssetBulkImportService(assetService, tbAssetService,
        new AssetProfileServiceImpl());
    Asset entity = new Asset(new Asset());

    // Act
    assetBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    JsonNode additionalInfo = entity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
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
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link AssetBulkImportService#setEntityFields(Asset, Map)} with
   * {@code Asset}, {@code Map}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>Then calls
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetBulkImportService#setEntityFields(Asset, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Asset, Map) with 'Asset', 'Map'; given Instance; then calls setAdditionalInfo(JsonNode)")
  void testSetEntityFieldsWithAssetMap_givenInstance_thenCallsSetAdditionalInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());
    AssetBulkImportService assetBulkImportService = new AssetBulkImportService(assetService, tbAssetService,
        new AssetProfileServiceImpl());
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
   * Test {@link AssetBulkImportService#setEntityFields(Asset, Map)} with
   * {@code Asset}, {@code Map}.
   * <ul>
   *   <li>When {@link Asset#Asset()}.</li>
   *   <li>Then {@link Asset#Asset()} AdditionalInfo {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetBulkImportService#setEntityFields(Asset, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Asset, Map) with 'Asset', 'Map'; when Asset(); then Asset() AdditionalInfo ObjectNode")
  void testSetEntityFieldsWithAssetMap_whenAsset_thenAssetAdditionalInfoObjectNode() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());
    AssetBulkImportService assetBulkImportService = new AssetBulkImportService(assetService, tbAssetService,
        new AssetProfileServiceImpl());
    Asset entity = new Asset();

    // Act
    assetBulkImportService.setEntityFields(entity, new HashMap<>());

    // Assert
    JsonNode additionalInfo = entity.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
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
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link AssetBulkImportService#saveEntity(SecurityUser, Asset, Map)} with
   * {@code SecurityUser}, {@code Asset}, {@code Map}.
   * <ul>
   *   <li>Then return AdditionalInfo is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetBulkImportService#saveEntity(SecurityUser, Asset, Map)}
   */
  @Test
  @DisplayName("Test saveEntity(SecurityUser, Asset, Map) with 'SecurityUser', 'Asset', 'Map'; then return AdditionalInfo is 'null'")
  void testSaveEntityWithSecurityUserAssetMap_thenReturnAdditionalInfoIsNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbAssetService tbAssetService = mock(TbAssetService.class);
    when(tbAssetService.save(Mockito.<Asset>any(), Mockito.<User>any())).thenReturn(new Asset());
    AssetProfileService assetProfileService = mock(AssetProfileService.class);
    when(assetProfileService.findOrCreateAssetProfile(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AssetProfile());
    AssetBulkImportService assetBulkImportService = new AssetBulkImportService(new BaseAssetService(), tbAssetService,
        assetProfileService);
    SecurityUser user = new SecurityUser();
    Asset entity = mock(Asset.class);
    when(entity.getType()).thenReturn("Type");
    when(entity.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(entity).setAssetProfileId(Mockito.<AssetProfileId>any());

    // Act
    Asset actualSaveEntityResult = assetBulkImportService.saveEntity(user, entity, new HashMap<>());

    // Assert
    verify(entity).getTenantId();
    verify(entity, atLeast(1)).getType();
    verify(entity).setAssetProfileId(isNull());
    verify(assetProfileService).findOrCreateAssetProfile(isA(TenantId.class), eq("Type"));
    verify(tbAssetService).save(isA(Asset.class), isA(User.class));
    assertNull(actualSaveEntityResult.getAdditionalInfo());
    assertNull(actualSaveEntityResult.getVersion());
    assertNull(actualSaveEntityResult.getLabel());
    assertNull(actualSaveEntityResult.getName());
    assertNull(actualSaveEntityResult.getType());
    assertNull(actualSaveEntityResult.getUuidId());
    assertNull(actualSaveEntityResult.getExternalId());
    assertNull(actualSaveEntityResult.getId());
    assertNull(actualSaveEntityResult.getAssetProfileId());
    assertNull(actualSaveEntityResult.getCustomerId());
    assertNull(actualSaveEntityResult.getTenantId());
    assertEquals(0L, actualSaveEntityResult.getCreatedTime());
  }

  /**
   * Test {@link AssetBulkImportService#saveEntity(SecurityUser, Asset, Map)} with
   * {@code SecurityUser}, {@code Asset}, {@code Map}.
   * <ul>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetBulkImportService#saveEntity(SecurityUser, Asset, Map)}
   */
  @Test
  @DisplayName("Test saveEntity(SecurityUser, Asset, Map) with 'SecurityUser', 'Asset', 'Map'; then return Asset()")
  void testSaveEntityWithSecurityUserAssetMap_thenReturnAsset() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbAssetService tbAssetService = mock(TbAssetService.class);
    Asset asset = new Asset();
    when(tbAssetService.save(Mockito.<Asset>any(), Mockito.<User>any())).thenReturn(asset);
    AssetProfileService assetProfileService = mock(AssetProfileService.class);
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any())).thenReturn(new AssetProfile());
    AssetBulkImportService assetBulkImportService = new AssetBulkImportService(new BaseAssetService(), tbAssetService,
        assetProfileService);
    SecurityUser user = new SecurityUser();
    Asset entity = new Asset();

    // Act
    Asset actualSaveEntityResult = assetBulkImportService.saveEntity(user, entity, new HashMap<>());

    // Assert
    verify(assetProfileService).findDefaultAssetProfile(isNull());
    verify(tbAssetService).save(isA(Asset.class), isA(User.class));
    assertSame(asset, actualSaveEntityResult);
  }

  /**
   * Test {@link AssetBulkImportService#findOrCreateEntity(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetBulkImportService#findOrCreateEntity(TenantId, String)}
   */
  @Test
  @DisplayName("Test findOrCreateEntity(TenantId, String); then return Asset()")
  void testFindOrCreateEntity_thenReturnAsset() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAssetService assetService = mock(BaseAssetService.class);
    Asset asset = new Asset();
    when(assetService.findAssetByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(asset);
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());
    AssetBulkImportService assetBulkImportService = new AssetBulkImportService(assetService, tbAssetService,
        new AssetProfileServiceImpl());

    // Act
    Asset actualFindOrCreateEntityResult = assetBulkImportService.findOrCreateEntity(new TenantId(UUID.randomUUID()),
        "Name");

    // Assert
    verify(assetService).findAssetByTenantIdAndName(isA(TenantId.class), eq("Name"));
    assertSame(asset, actualFindOrCreateEntityResult);
  }

  /**
   * Test {@link AssetBulkImportService#getEntityType()}.
   * <p>
   * Method under test: {@link AssetBulkImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  void testGetEntityType() {
    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    // Act and Assert
    assertEquals(EntityType.ASSET,
        (new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl())).getEntityType());
  }
}
