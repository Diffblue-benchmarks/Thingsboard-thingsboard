package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityExportSettings;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.service.sync.ie.importing.impl.DashboardImportService;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.data.ComplexEntitiesExportCtx;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;

class BaseEntityExportServiceDiffblueTest {
  /**
   * Test
   * {@link BaseEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}.
   * <ul>
   *   <li>Then {@link Asset#Asset()} CustomerId is
   * {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}
   */
  @Test
  @DisplayName("Test setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData); then Asset() CustomerId is CustomerId(UUID) with id is randomUUID")
  void testSetAdditionalExportData_thenAssetCustomerIdIsCustomerIdWithIdIsRandomUUID() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetExportService assetExportService = new AssetExportService();
    EntityExportSettings.EntityExportSettingsBuilder entityExportSettingsBuilder = mock(
        EntityExportSettings.EntityExportSettingsBuilder.class);
    when(entityExportSettingsBuilder.exportAttributes(anyBoolean())).thenReturn(EntityExportSettings.builder());
    EntityExportSettings buildResult = entityExportSettingsBuilder.exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(false)
        .build();
    EntitiesExportCtx<?> ctx = mock(EntitiesExportCtx.class);
    UUID id = UUID.randomUUID();
    CustomerId customerId = new CustomerId(id);
    when(ctx.getExternalId(Mockito.<CustomerId>any())).thenReturn(customerId);
    when(ctx.getSettings()).thenReturn(buildResult);

    Asset asset = new Asset();
    asset.setCustomerId(new CustomerId(null));

    // Act
    assetExportService.setAdditionalExportData(ctx, asset, new EntityExportData<>());

    // Assert
    verify(entityExportSettingsBuilder).exportAttributes(eq(true));
    verify(ctx).getExternalId(isA(CustomerId.class));
    verify(ctx).getSettings();
    CustomerId customerId2 = asset.getCustomerId();
    assertSame(customerId, customerId2);
    assertSame(id, customerId2.getId());
  }

  /**
   * Test
   * {@link BaseEntityExportService#setRelatedEntities(EntitiesExportCtx, ExportableEntity, EntityExportData)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link ComplexVersionCreateRequest#getEntityTypes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityExportService#setRelatedEntities(EntitiesExportCtx, ExportableEntity, EntityExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, ExportableEntity, EntityExportData); given HashMap(); then calls getEntityTypes()")
  void testSetRelatedEntities_givenHashMap_thenCallsGetEntityTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceExportService resourceExportService = new ResourceExportService();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    User user = mock(User.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    TbResource tbResource = new TbResource();

    // Act
    resourceExportService.setRelatedEntities(ctx, tbResource, new EntityExportData<>());

    // Assert that nothing has changed
    verify(request).getEntityTypes();
  }

  /**
   * Test {@link BaseEntityExportService#newExportData()}.
   * <p>
   * Method under test: {@link BaseEntityExportService#newExportData()}
   */
  @Test
  @DisplayName("Test newExportData()")
  void testNewExportData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityExportData<Asset> actualNewExportDataResult = (new AssetExportService()).newExportData();

    // Assert
    assertNull(actualNewExportDataResult.getRelations());
    assertNull(actualNewExportDataResult.getAttributes());
    assertNull(actualNewExportDataResult.getEntityType());
    assertNull(actualNewExportDataResult.getEntity());
    assertFalse(actualNewExportDataResult.hasAttributes());
    assertFalse(actualNewExportDataResult.hasCredentials());
    assertFalse(actualNewExportDataResult.hasRelations());
  }

  /**
   * Test
   * {@link BaseEntityExportService#replaceUuidsRecursively(EntitiesExportCtx, JsonNode, Set, Pattern)}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityExportService#replaceUuidsRecursively(EntitiesExportCtx, JsonNode, Set, Pattern)}
   */
  @Test
  @DisplayName("Test replaceUuidsRecursively(EntitiesExportCtx, JsonNode, Set, Pattern); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  void testReplaceUuidsRecursively_whenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetExportService assetExportService = new AssetExportService();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    User user = mock(User.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    ArrayNode node = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act
    assetExportService.replaceUuidsRecursively(ctx, node, new HashSet<>(),
        DashboardImportService.WIDGET_CONFIG_PROCESSED_FIELDS_PATTERN);

    // Assert that nothing has changed
    verify(request).getEntityTypes();
  }

  /**
   * Test
   * {@link BaseEntityExportService#replaceUuidsRecursively(EntitiesExportCtx, JsonNode, Set, Pattern)}.
   * <ul>
   *   <li>When Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityExportService#replaceUuidsRecursively(EntitiesExportCtx, JsonNode, Set, Pattern)}
   */
  @Test
  @DisplayName("Test replaceUuidsRecursively(EntitiesExportCtx, JsonNode, Set, Pattern); when Instance")
  void testReplaceUuidsRecursively_whenInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetExportService assetExportService = new AssetExportService();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    User user = mock(User.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    MissingNode node = MissingNode.getInstance();

    // Act
    assetExportService.replaceUuidsRecursively(ctx, node, new HashSet<>(),
        DashboardImportService.WIDGET_CONFIG_PROCESSED_FIELDS_PATTERN);

    // Assert that nothing has changed
    verify(request).getEntityTypes();
  }

  /**
   * Test
   * {@link BaseEntityExportService#replaceUuidsRecursively(EntitiesExportCtx, JsonNode, Set, Pattern)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityExportService#replaceUuidsRecursively(EntitiesExportCtx, JsonNode, Set, Pattern)}
   */
  @Test
  @DisplayName("Test replaceUuidsRecursively(EntitiesExportCtx, JsonNode, Set, Pattern); when 'null'")
  void testReplaceUuidsRecursively_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetExportService assetExportService = new AssetExportService();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    User user = mock(User.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    // Act
    assetExportService.replaceUuidsRecursively(ctx, null, new HashSet<>(),
        DashboardImportService.WIDGET_CONFIG_PROCESSED_FIELDS_PATTERN);

    // Assert that nothing has changed
    verify(request).getEntityTypes();
  }
}
