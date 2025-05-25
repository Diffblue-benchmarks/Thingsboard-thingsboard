package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.TbResourceInfo;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.dao.asset.BaseAssetService;
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
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

@ExtendWith(MockitoExtension.class)
class ResourceImportServiceDiffblueTest {
  @InjectMocks
  private ResourceImportService resourceImportService;

  /**
   * Test {@link ResourceImportService#setOwner(TenantId, TbResource, IdProvider)}.
   * <p>
   * Method under test: {@link ResourceImportService#setOwner(TenantId, TbResource, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, TbResource, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResourceImportService.setOwner(TenantId, TbResource, IdProvider)"})
  void testSetOwner() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbResource resource = new TbResource();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    resourceImportService.setOwner(tenantId, resource,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    assertSame(tenantId, resource.getTenantId());
  }

  /**
   * Test {@link ResourceImportService#setOwner(TenantId, TbResource, IdProvider)}.
   * <ul>
   *   <li>When {@link TbResource} {@link TbResourceInfo#setTenantId(TenantId)} does nothing.</li>
   *   <li>Then calls {@link TbResourceInfo#setTenantId(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceImportService#setOwner(TenantId, TbResource, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, TbResource, IdProvider); when TbResource setTenantId(TenantId) does nothing; then calls setTenantId(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ResourceImportService.setOwner(TenantId, TbResource, IdProvider)"})
  void testSetOwner_whenTbResourceSetTenantIdDoesNothing_thenCallsSetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbResource resource = mock(TbResource.class);
    doNothing().when(resource).setTenantId(Mockito.<TenantId>any());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    resourceImportService.setOwner(tenantId, resource,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    verify(resource).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link ResourceImportService#prepare(EntitiesImportCtx, TbResource, TbResource, EntityExportData, IdProvider)}.
   * <p>
   * Method under test: {@link ResourceImportService#prepare(EntitiesImportCtx, TbResource, TbResource, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, TbResource, TbResource, EntityExportData, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TbResource ResourceImportService.prepare(EntitiesImportCtx, TbResource, TbResource, EntityExportData, IdProvider)"})
  void testPrepare() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    TbResource resource = new TbResource();
    TbResource oldResource = new TbResource();
    EntityExportData<TbResource> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertSame(resource, resourceImportService.prepare(ctx, resource, oldResource, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult())));
  }

  /**
   * Test {@link ResourceImportService#compare(EntitiesImportCtx, EntityExportData, TbResource, TbResource)} with {@code EntitiesImportCtx}, {@code EntityExportData}, {@code TbResource}, {@code TbResource}.
   * <p>
   * Method under test: {@link ResourceImportService#compare(EntitiesImportCtx, EntityExportData, TbResource, TbResource)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, EntityExportData, TbResource, TbResource) with 'EntitiesImportCtx', 'EntityExportData', 'TbResource', 'TbResource'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean ResourceImportService.compare(EntitiesImportCtx, EntityExportData, TbResource, TbResource)"})
  void testCompareWithEntitiesImportCtxEntityExportDataTbResourceTbResource() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    EntityExportData<TbResource> exportData = new EntityExportData<>();
    TbResource prepared = new TbResource();

    // Act and Assert
    assertTrue(resourceImportService.compare(ctx, exportData, prepared, new TbResource()));
  }

  /**
   * Test {@link ResourceImportService#deepCopy(TbResource)} with {@code TbResource}.
   * <p>
   * Method under test: {@link ResourceImportService#deepCopy(TbResource)}
   */
  @Test
  @DisplayName("Test deepCopy(TbResource) with 'TbResource'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbResource ResourceImportService.deepCopy(TbResource)"})
  void testDeepCopyWithTbResource() {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getCreatedTime()).thenReturn(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TbResourceId tbResourceId = new TbResourceId(id);
    when(resource.getId()).thenReturn(tbResourceId);

    // Act
    TbResource actualDeepCopyResult = resourceImportService.deepCopy(resource);

    // Assert
    verify(resource).getCreatedTime();
    verify(resource).getId();
    UUID uuidId = actualDeepCopyResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertNull(actualDeepCopyResult.getDescriptor());
    assertEquals(1L, actualDeepCopyResult.getCreatedTime());
    assertSame(tbResourceId, actualDeepCopyResult.getId());
    assertSame(id, uuidId);
  }

  /**
   * Test {@link ResourceImportService#deepCopy(TbResource)} with {@code TbResource}.
   * <ul>
   *   <li>Given {@code Resource}.</li>
   *   <li>Then Descriptor return {@link TextNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceImportService#deepCopy(TbResource)}
   */
  @Test
  @DisplayName("Test deepCopy(TbResource) with 'TbResource'; given 'Resource'; then Descriptor return TextNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbResource ResourceImportService.deepCopy(TbResource)"})
  void testDeepCopyWithTbResource_givenResource_thenDescriptorReturnTextNode() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setDescriptorValue("Resource");

    // Act
    TbResource actualDeepCopyResult = resourceImportService.deepCopy(resource);

    // Assert
    assertTrue(actualDeepCopyResult.getDescriptor() instanceof TextNode);
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getId());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
  }

  /**
   * Test {@link ResourceImportService#deepCopy(TbResource)} with {@code TbResource}.
   * <ul>
   *   <li>When {@link TbResource#TbResource()}.</li>
   *   <li>Then return {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourceImportService#deepCopy(TbResource)}
   */
  @Test
  @DisplayName("Test deepCopy(TbResource) with 'TbResource'; when TbResource(); then return TbResource()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbResource ResourceImportService.deepCopy(TbResource)"})
  void testDeepCopyWithTbResource_whenTbResource_thenReturnTbResource() {
    // Arrange
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType ResourceImportService.getEntityType()"})
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
