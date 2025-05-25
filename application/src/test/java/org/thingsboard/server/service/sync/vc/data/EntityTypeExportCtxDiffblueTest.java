package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportSettings;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.common.data.sync.vc.request.create.EntityTypeVersionCreateConfig;
import org.thingsboard.server.common.data.sync.vc.request.create.SyncStrategy;
import org.thingsboard.server.common.data.sync.vc.request.create.VersionCreateRequest;

class EntityTypeExportCtxDiffblueTest {
  /**
   * Test {@link EntityTypeExportCtx#EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)}.
   * <p>
   * Method under test: {@link EntityTypeExportCtx#EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)}
   */
  @Test
  @DisplayName("Test new EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void EntityTypeExportCtx.<init>(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)"})
  void testNewEntityTypeExportCtx() {
    // Arrange
    ComplexVersionCreateRequest request = new ComplexVersionCreateRequest();
    request.setBranch("janedoe/featurebranch");
    request.setEntityTypes(new HashMap<>());
    request.setSyncStrategy(SyncStrategy.MERGE);
    request.setVersionName("1.0.2");
    User user = new User();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ComplexEntitiesExportCtx parent = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    EntityTypeVersionCreateConfig config = new EntityTypeVersionCreateConfig();
    config.setAllEntities(true);
    config.setEntityIds(new ArrayList<>());
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);
    config.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertEquals(parent, new EntityTypeExportCtx(parent, config, SyncStrategy.MERGE, EntityType.TENANT));
  }

  /**
   * Test {@link EntityTypeExportCtx#EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeExportCtx#EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)}
   */
  @Test
  @DisplayName("Test new EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void EntityTypeExportCtx.<init>(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)"})
  void testNewEntityTypeExportCtx_givenNull() {
    // Arrange
    ComplexVersionCreateRequest request = new ComplexVersionCreateRequest();
    request.setBranch("janedoe/featurebranch");
    request.setEntityTypes(new HashMap<>());
    request.setSyncStrategy(SyncStrategy.MERGE);
    request.setVersionName("1.0.2");
    User user = new User();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ComplexEntitiesExportCtx parent = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    EntityTypeVersionCreateConfig config = new EntityTypeVersionCreateConfig();
    config.setAllEntities(true);
    config.setEntityIds(new ArrayList<>());
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);
    config.setSyncStrategy(null);

    // Act and Assert
    assertEquals(parent, new EntityTypeExportCtx(parent, config, SyncStrategy.OVERWRITE, EntityType.TENANT));
  }

  /**
   * Test {@link EntityTypeExportCtx#EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)}.
   * <ul>
   *   <li>Then Request return {@link ComplexVersionCreateRequest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityTypeExportCtx#EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)}
   */
  @Test
  @DisplayName("Test new EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType); then Request return ComplexVersionCreateRequest")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void EntityTypeExportCtx.<init>(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)"})
  void testNewEntityTypeExportCtx_thenRequestReturnComplexVersionCreateRequest() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest.setVersionName("1.0.2");
    ComplexEntitiesExportCtx parent = mock(ComplexEntitiesExportCtx.class);
    when(parent.getFutures()).thenReturn(new ArrayList<>());
    when(parent.getExternalIdMap()).thenReturn(new HashMap<>());
    User user = new User();
    when(parent.getUser()).thenReturn(user);
    when(parent.getRequest()).thenReturn(complexVersionCreateRequest);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CommitGitRequest commitGitRequest = new CommitGitRequest(tenantId, new ComplexVersionCreateRequest());

    when(parent.getCommit()).thenReturn(commitGitRequest);

    EntityTypeVersionCreateConfig config = new EntityTypeVersionCreateConfig();
    config.setAllEntities(true);
    config.setEntityIds(new ArrayList<>());
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);
    config.setSyncStrategy(SyncStrategy.MERGE);

    // Act
    EntityTypeExportCtx actualEntityTypeExportCtx = new EntityTypeExportCtx(parent, config, SyncStrategy.MERGE,
        EntityType.TENANT);

    // Assert
    verify(parent).getCommit();
    verify(parent).getExternalIdMap();
    verify(parent).getFutures();
    verify(parent).getRequest();
    verify(parent).getUser();
    VersionCreateRequest request = actualEntityTypeExportCtx.getRequest();
    assertTrue(request instanceof ComplexVersionCreateRequest);
    assertNull(actualEntityTypeExportCtx.getTenantId());
    assertEquals(EntityType.TENANT, actualEntityTypeExportCtx.getEntityType());
    assertFalse(actualEntityTypeExportCtx.isOverwrite());
    assertTrue(actualEntityTypeExportCtx.getFutures().isEmpty());
    assertTrue(actualEntityTypeExportCtx.getExternalIdMap().isEmpty());
    assertSame(user, actualEntityTypeExportCtx.getUser());
    assertSame(complexVersionCreateRequest, request);
    assertSame(commitGitRequest, actualEntityTypeExportCtx.getCommit());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeExportCtx#getEntityType()}
   *   <li>{@link EntityTypeExportCtx#getSettings()}
   *   <li>{@link EntityTypeExportCtx#isOverwrite()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType EntityTypeExportCtx.getEntityType()",
      "EntityExportSettings EntityTypeExportCtx.getSettings()", "boolean EntityTypeExportCtx.isOverwrite()"})
  void testGettersAndSetters() {
    // Arrange
    ComplexVersionCreateRequest request = new ComplexVersionCreateRequest();
    request.setBranch("janedoe/featurebranch");
    request.setEntityTypes(new HashMap<>());
    request.setSyncStrategy(SyncStrategy.MERGE);
    request.setVersionName("1.0.2");
    User user = new User();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ComplexEntitiesExportCtx parent = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    EntityTypeVersionCreateConfig config = new EntityTypeVersionCreateConfig();
    config.setAllEntities(true);
    config.setEntityIds(new ArrayList<>());
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);
    config.setSyncStrategy(SyncStrategy.MERGE);
    EntityTypeExportCtx entityTypeExportCtx = new EntityTypeExportCtx(parent, config, SyncStrategy.MERGE,
        EntityType.TENANT);

    // Act
    EntityType actualEntityType = entityTypeExportCtx.getEntityType();
    EntityExportSettings actualSettings = entityTypeExportCtx.getSettings();

    // Assert
    assertEquals(EntityType.TENANT, actualEntityType);
    assertFalse(entityTypeExportCtx.isOverwrite());
    assertTrue(actualSettings.isExportAttributes());
    assertTrue(actualSettings.isExportCredentials());
    assertTrue(actualSettings.isExportRelations());
  }
}
