package org.thingsboard.server.service.sync.ie.exporting;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;

@ExtendWith(MockitoExtension.class)
class DefaultExportableEntitiesServiceDiffblueTest {
  @InjectMocks
  private DefaultExportableEntitiesService defaultExportableEntitiesService;

  /**
   * Test {@link DefaultExportableEntitiesService#findEntityByTenantIdAndExternalId(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultExportableEntitiesService#findEntityByTenantIdAndExternalId(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityByTenantIdAndExternalId(TenantId, EntityId); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ExportableEntity DefaultExportableEntitiesService.findEntityByTenantIdAndExternalId(TenantId, EntityId)"})
  void testFindEntityByTenantIdAndExternalId_thenReturnNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNull(defaultExportableEntitiesService.findEntityByTenantIdAndExternalId(tenantId,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link DefaultExportableEntitiesService#findEntityByTenantIdAndName(TenantId, EntityType, String)}.
   * <p>
   * Method under test: {@link DefaultExportableEntitiesService#findEntityByTenantIdAndName(TenantId, EntityType, String)}
   */
  @Test
  @DisplayName("Test findEntityByTenantIdAndName(TenantId, EntityType, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ExportableEntity DefaultExportableEntitiesService.findEntityByTenantIdAndName(TenantId, EntityType, String)"})
  void testFindEntityByTenantIdAndName() {
    // Arrange, Act and Assert
    assertNull(defaultExportableEntitiesService.findEntityByTenantIdAndName(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), EntityType.TENANT, "Name"));
  }

  /**
   * Test {@link DefaultExportableEntitiesService#findDefaultEntityByTenantId(TenantId, EntityType)}.
   * <p>
   * Method under test: {@link DefaultExportableEntitiesService#findDefaultEntityByTenantId(TenantId, EntityType)}
   */
  @Test
  @DisplayName("Test findDefaultEntityByTenantId(TenantId, EntityType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ExportableEntity DefaultExportableEntitiesService.findDefaultEntityByTenantId(TenantId, EntityType)"})
  void testFindDefaultEntityByTenantId() {
    // Arrange, Act and Assert
    assertNull(defaultExportableEntitiesService.findDefaultEntityByTenantId(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), EntityType.TENANT));
  }

  /**
   * Test {@link DefaultExportableEntitiesService#findEntitiesByTenantId(TenantId, EntityType, PageLink)}.
   * <p>
   * Method under test: {@link DefaultExportableEntitiesService#findEntitiesByTenantId(TenantId, EntityType, PageLink)}
   */
  @Test
  @DisplayName("Test findEntitiesByTenantId(TenantId, EntityType, PageLink)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PageData DefaultExportableEntitiesService.findEntitiesByTenantId(TenantId, EntityType, PageLink)"})
  void testFindEntitiesByTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    PageData<ExportableEntity<EntityId>> actualFindEntitiesByTenantIdResult = defaultExportableEntitiesService
        .findEntitiesByTenantId(tenantId, EntityType.TENANT, new PageLink(3));

    // Assert
    assertSame(actualFindEntitiesByTenantIdResult.EMPTY_PAGE_DATA, actualFindEntitiesByTenantIdResult);
  }

  /**
   * Test {@link DefaultExportableEntitiesService#findEntitiesIdsByTenantId(TenantId, EntityType, PageLink)}.
   * <p>
   * Method under test: {@link DefaultExportableEntitiesService#findEntitiesIdsByTenantId(TenantId, EntityType, PageLink)}
   */
  @Test
  @DisplayName("Test findEntitiesIdsByTenantId(TenantId, EntityType, PageLink)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PageData DefaultExportableEntitiesService.findEntitiesIdsByTenantId(TenantId, EntityType, PageLink)"})
  void testFindEntitiesIdsByTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    PageData<EntityId> actualFindEntitiesIdsByTenantIdResult = defaultExportableEntitiesService
        .findEntitiesIdsByTenantId(tenantId, EntityType.TENANT, new PageLink(3));

    // Assert
    assertSame(actualFindEntitiesIdsByTenantIdResult.EMPTY_PAGE_DATA, actualFindEntitiesIdsByTenantIdResult);
  }

  /**
   * Test {@link DefaultExportableEntitiesService#getExternalIdByInternal(EntityId)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultExportableEntitiesService#getExternalIdByInternal(EntityId)}
   */
  @Test
  @DisplayName("Test getExternalIdByInternal(EntityId); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId DefaultExportableEntitiesService.getExternalIdByInternal(EntityId)"})
  void testGetExternalIdByInternal_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(defaultExportableEntitiesService
        .getExternalIdByInternal(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }
}
