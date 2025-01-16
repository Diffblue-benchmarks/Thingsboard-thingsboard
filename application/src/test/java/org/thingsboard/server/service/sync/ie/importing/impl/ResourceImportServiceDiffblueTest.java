package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.dao.resource.BaseImageService;
import org.thingsboard.server.dao.resource.BaseResourceService;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.sql.asset.JpaAssetProfileDao;
import org.thingsboard.server.dao.sql.dashboard.JpaDashboardInfoDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceProfileDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.sql.widget.JpaWidgetTypeDao;
import org.thingsboard.server.dao.sql.widget.JpaWidgetsBundleDao;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

class ResourceImportServiceDiffblueTest {
  /**
   * Test
   * {@link ResourceImportService#compare(EntitiesImportCtx, EntityExportData, TbResource, TbResource)}
   * with {@code EntitiesImportCtx}, {@code EntityExportData}, {@code TbResource},
   * {@code TbResource}.
   * <p>
   * Method under test:
   * {@link ResourceImportService#compare(EntitiesImportCtx, EntityExportData, TbResource, TbResource)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, EntityExportData, TbResource, TbResource) with 'EntitiesImportCtx', 'EntityExportData', 'TbResource', 'TbResource'")
  void testCompareWithEntitiesImportCtxEntityExportDataTbResourceTbResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    BaseResourceService resourceService = new BaseResourceService(resourceDao, resourceInfoDao,
        new ResourceDataValidator());

    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    ResourceImportService resourceImportService = new ResourceImportService(resourceService,
        new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()));
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    EntityExportData<TbResource> exportData = new EntityExportData<>();
    TbResource prepared = new TbResource();

    // Act and Assert
    assertTrue(resourceImportService.compare(ctx, exportData, prepared, new TbResource()));
  }

  /**
   * Test {@link ResourceImportService#deepCopy(TbResource)} with
   * {@code TbResource}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return Descriptor is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceImportService#deepCopy(TbResource)}
   */
  @Test
  @DisplayName("Test deepCopy(TbResource) with 'TbResource'; given one; then return Descriptor is 'null'")
  void testDeepCopyWithTbResource_givenOne_thenReturnDescriptorIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    BaseResourceService resourceService = new BaseResourceService(resourceDao, resourceInfoDao,
        new ResourceDataValidator());

    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    ResourceImportService resourceImportService = new ResourceImportService(resourceService,
        new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()));
    TbResource resource = mock(TbResource.class);
    when(resource.getCreatedTime()).thenReturn(1L);
    UUID id = UUID.randomUUID();
    TbResourceId tbResourceId = new TbResourceId(id);
    when(resource.getId()).thenReturn(tbResourceId);

    // Act
    TbResource actualDeepCopyResult = resourceImportService.deepCopy(resource);

    // Assert
    verify(resource).getCreatedTime();
    verify(resource).getId();
    assertNull(actualDeepCopyResult.getDescriptor());
    assertEquals(1L, actualDeepCopyResult.getCreatedTime());
    assertSame(tbResourceId, actualDeepCopyResult.getId());
    assertSame(id, actualDeepCopyResult.getUuidId());
  }

  /**
   * Test {@link ResourceImportService#deepCopy(TbResource)} with
   * {@code TbResource}.
   * <ul>
   *   <li>Given {@code Resource}.</li>
   *   <li>Then Descriptor return {@link TextNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceImportService#deepCopy(TbResource)}
   */
  @Test
  @DisplayName("Test deepCopy(TbResource) with 'TbResource'; given 'Resource'; then Descriptor return TextNode")
  void testDeepCopyWithTbResource_givenResource_thenDescriptorReturnTextNode() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    BaseResourceService resourceService = new BaseResourceService(resourceDao, resourceInfoDao,
        new ResourceDataValidator());

    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    ResourceImportService resourceImportService = new ResourceImportService(resourceService,
        new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()));

    TbResource resource = new TbResource();
    resource.setDescriptorValue("Resource");

    // Act
    TbResource actualDeepCopyResult = resourceImportService.deepCopy(resource);

    // Assert
    JsonNode descriptor = actualDeepCopyResult.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"Resource\"", descriptor.toPrettyString());
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
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getId());
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
    assertEquals(0, descriptor.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
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
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(descriptor.isBigInteger());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isBoolean());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isFloat());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(descriptor.isInt());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(descriptor.isLong());
    assertFalse(descriptor.isMissingNode());
    assertFalse(descriptor.isNull());
    assertFalse(descriptor.isNumber());
    assertFalse(descriptor.isObject());
    assertFalse(descriptor.isPojo());
    assertFalse(descriptor.isShort());
    assertFalse(descriptor.iterator().hasNext());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link ResourceImportService#deepCopy(TbResource)} with
   * {@code TbResource}.
   * <ul>
   *   <li>When {@link TbResource#TbResource()}.</li>
   *   <li>Then return {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceImportService#deepCopy(TbResource)}
   */
  @Test
  @DisplayName("Test deepCopy(TbResource) with 'TbResource'; when TbResource(); then return TbResource()")
  void testDeepCopyWithTbResource_whenTbResource_thenReturnTbResource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    BaseResourceService resourceService = new BaseResourceService(resourceDao, resourceInfoDao,
        new ResourceDataValidator());

    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    ResourceImportService resourceImportService = new ResourceImportService(resourceService,
        new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()));
    TbResource resource = new TbResource();

    // Act and Assert
    assertEquals(resource, resourceImportService.deepCopy(resource));
  }

  /**
   * Test {@link ResourceImportService#getEntityType()}.
   * <p>
   * Method under test: {@link ResourceImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  void testGetEntityType() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    BaseResourceService resourceService = new BaseResourceService(resourceDao, resourceInfoDao,
        new ResourceDataValidator());

    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    // Act and Assert
    assertEquals(EntityType.TB_RESOURCE,
        (new ResourceImportService(resourceService,
            new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator, assetProfileDao, deviceProfileDao,
                widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao())))
            .getEntityType());
  }
}
