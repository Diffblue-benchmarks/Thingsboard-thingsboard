package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.common.data.sync.vc.request.create.EntityTypeVersionCreateConfig;
import org.thingsboard.server.common.data.sync.vc.request.create.SyncStrategy;

class EntityTypeExportCtxDiffblueTest {
  /**
   * Test
   * {@link EntityTypeExportCtx#EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)}.
   * <p>
   * Method under test:
   * {@link EntityTypeExportCtx#EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)}
   */
  @Test
  @DisplayName("Test new EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)")
  void testNewEntityTypeExportCtx() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    User user = mock(User.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx parent = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

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
    verify(request).getEntityTypes();
    assertEquals(parent, actualEntityTypeExportCtx);
  }

  /**
   * Test
   * {@link EntityTypeExportCtx#EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)}.
   * <p>
   * Method under test:
   * {@link EntityTypeExportCtx#EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)}
   */
  @Test
  @DisplayName("Test new EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)")
  void testNewEntityTypeExportCtx2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    User user = new User();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx parent = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    EntityTypeVersionCreateConfig config = new EntityTypeVersionCreateConfig();
    config.setAllEntities(true);
    config.setEntityIds(new ArrayList<>());
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);
    config.setSyncStrategy(null);

    // Act
    EntityTypeExportCtx actualEntityTypeExportCtx = new EntityTypeExportCtx(parent, config, SyncStrategy.OVERWRITE,
        EntityType.TENANT);

    // Assert
    verify(request).getEntityTypes();
    assertEquals(parent, actualEntityTypeExportCtx);
  }

  /**
   * Test
   * {@link EntityTypeExportCtx#EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)}.
   * <ul>
   *   <li>Given {@code OVERWRITE}.</li>
   *   <li>Then return Overwrite.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityTypeExportCtx#EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)}
   */
  @Test
  @DisplayName("Test new EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType); given 'OVERWRITE'; then return Overwrite")
  void testNewEntityTypeExportCtx_givenOverwrite_thenReturnOverwrite() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest.setVersionName("1.0.2");
    ComplexEntitiesExportCtx parent = mock(ComplexEntitiesExportCtx.class);
    when(parent.getFutures()).thenReturn(new ArrayList<>());
    when(parent.getExternalIdMap()).thenReturn(new HashMap<>());
    when(parent.getUser()).thenReturn(new User());
    when(parent.getRequest()).thenReturn(complexVersionCreateRequest);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    when(parent.getCommit()).thenReturn(new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()));
    EntityTypeVersionCreateConfig config = mock(EntityTypeVersionCreateConfig.class);
    when(config.isSaveAttributes()).thenReturn(true);
    when(config.isSaveCredentials()).thenReturn(true);
    when(config.isSaveRelations()).thenReturn(true);
    when(config.getSyncStrategy()).thenReturn(SyncStrategy.OVERWRITE);
    doNothing().when(config).setAllEntities(anyBoolean());
    doNothing().when(config).setEntityIds(Mockito.<List<UUID>>any());
    doNothing().when(config).setSyncStrategy(Mockito.<SyncStrategy>any());
    doNothing().when(config).setSaveAttributes(anyBoolean());
    doNothing().when(config).setSaveCredentials(anyBoolean());
    doNothing().when(config).setSaveRelations(anyBoolean());
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
    verify(config).getSyncStrategy();
    verify(config).setAllEntities(eq(true));
    verify(config).setEntityIds(isA(List.class));
    verify(config).setSyncStrategy(eq(SyncStrategy.MERGE));
    verify(config).isSaveAttributes();
    verify(config).isSaveCredentials();
    verify(config).isSaveRelations();
    verify(config).setSaveAttributes(eq(true));
    verify(config).setSaveCredentials(eq(true));
    verify(config).setSaveRelations(eq(true));
    verify(parent).getCommit();
    verify(parent).getExternalIdMap();
    verify(parent).getFutures();
    verify(parent).getRequest();
    verify(parent).getUser();
    assertTrue(actualEntityTypeExportCtx.isOverwrite());
    assertSame(complexVersionCreateRequest, actualEntityTypeExportCtx.getRequest());
  }

  /**
   * Test
   * {@link EntityTypeExportCtx#EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)}.
   * <ul>
   *   <li>Then return not Overwrite.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityTypeExportCtx#EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType)}
   */
  @Test
  @DisplayName("Test new EntityTypeExportCtx(EntitiesExportCtx, EntityTypeVersionCreateConfig, SyncStrategy, EntityType); then return not Overwrite")
  void testNewEntityTypeExportCtx_thenReturnNotOverwrite() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest.setEntityTypes(new HashMap<>());
    complexVersionCreateRequest.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest.setVersionName("1.0.2");
    ComplexEntitiesExportCtx parent = mock(ComplexEntitiesExportCtx.class);
    when(parent.getFutures()).thenReturn(new ArrayList<>());
    when(parent.getExternalIdMap()).thenReturn(new HashMap<>());
    when(parent.getUser()).thenReturn(new User());
    when(parent.getRequest()).thenReturn(complexVersionCreateRequest);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    when(parent.getCommit()).thenReturn(new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()));

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
    assertFalse(actualEntityTypeExportCtx.isOverwrite());
    assertSame(complexVersionCreateRequest, actualEntityTypeExportCtx.getRequest());
  }
}
