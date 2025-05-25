package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.common.data.sync.vc.request.create.EntityTypeVersionCreateConfig;
import org.thingsboard.server.common.data.sync.vc.request.create.SyncStrategy;

@ContextConfiguration(classes = {ComplexEntitiesExportCtx.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class ComplexEntitiesExportCtxDiffblueTest {
  @MockBean
  private CommitGitRequest commitGitRequest;

  @Autowired
  private ComplexEntitiesExportCtx complexEntitiesExportCtx;

  @MockBean
  private ComplexVersionCreateRequest complexVersionCreateRequest;

  @MockBean
  private User user;

  /**
   * Test {@link ComplexEntitiesExportCtx#ComplexEntitiesExportCtx(User, CommitGitRequest, ComplexVersionCreateRequest)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return TenantId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexEntitiesExportCtx#ComplexEntitiesExportCtx(User, CommitGitRequest, ComplexVersionCreateRequest)}
   */
  @Test
  @DisplayName("Test new ComplexEntitiesExportCtx(User, CommitGitRequest, ComplexVersionCreateRequest); given HashMap(); then return TenantId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ComplexEntitiesExportCtx.<init>(User, CommitGitRequest, ComplexVersionCreateRequest)"})
  void testNewComplexEntitiesExportCtx_givenHashMap_thenReturnTenantIdIsNull() {
    // Arrange
    ComplexVersionCreateRequest request = new ComplexVersionCreateRequest();
    request.setBranch("janedoe/featurebranch");
    request.setEntityTypes(new HashMap<>());
    request.setSyncStrategy(SyncStrategy.MERGE);
    request.setVersionName("1.0.2");

    // Act
    ComplexEntitiesExportCtx actualComplexEntitiesExportCtx = new ComplexEntitiesExportCtx(user, commitGitRequest,
        request);

    // Assert
    assertNull(actualComplexEntitiesExportCtx.getTenantId());
    assertTrue(actualComplexEntitiesExportCtx.getFutures().isEmpty());
    assertTrue(actualComplexEntitiesExportCtx.getExternalIdMap().isEmpty());
    assertSame(request, actualComplexEntitiesExportCtx.getRequest());
    assertSame(user, actualComplexEntitiesExportCtx.getUser());
    assertSame(commitGitRequest, actualComplexEntitiesExportCtx.getCommit());
  }

  /**
   * Test {@link ComplexEntitiesExportCtx#ComplexEntitiesExportCtx(User, CommitGitRequest, ComplexVersionCreateRequest)}.
   * <ul>
   *   <li>Then return Request EntityTypes is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexEntitiesExportCtx#ComplexEntitiesExportCtx(User, CommitGitRequest, ComplexVersionCreateRequest)}
   */
  @Test
  @DisplayName("Test new ComplexEntitiesExportCtx(User, CommitGitRequest, ComplexVersionCreateRequest); then return Request EntityTypes is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ComplexEntitiesExportCtx.<init>(User, CommitGitRequest, ComplexVersionCreateRequest)"})
  void testNewComplexEntitiesExportCtx_thenReturnRequestEntityTypesIsHashMap() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    HashMap<EntityType, EntityTypeVersionCreateConfig> entityTypes = new HashMap<>();
    entityTypes.put(EntityType.TENANT, entityTypeVersionCreateConfig);

    ComplexVersionCreateRequest request = new ComplexVersionCreateRequest();
    request.setBranch("janedoe/featurebranch");
    request.setEntityTypes(entityTypes);
    request.setSyncStrategy(SyncStrategy.MERGE);
    request.setVersionName("1.0.2");

    // Act and Assert
    assertSame(entityTypes,
        (new ComplexEntitiesExportCtx(user, commitGitRequest, request)).getRequest().getEntityTypes());
  }

  /**
   * Test {@link ComplexEntitiesExportCtx#ComplexEntitiesExportCtx(User, CommitGitRequest, ComplexVersionCreateRequest)}.
   * <ul>
   *   <li>Then return Request EntityTypes size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexEntitiesExportCtx#ComplexEntitiesExportCtx(User, CommitGitRequest, ComplexVersionCreateRequest)}
   */
  @Test
  @DisplayName("Test new ComplexEntitiesExportCtx(User, CommitGitRequest, ComplexVersionCreateRequest); then return Request EntityTypes size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ComplexEntitiesExportCtx.<init>(User, CommitGitRequest, ComplexVersionCreateRequest)"})
  void testNewComplexEntitiesExportCtx_thenReturnRequestEntityTypesSizeIsTwo() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig2 = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig2.setAllEntities(false);
    entityTypeVersionCreateConfig2.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig2.setSaveAttributes(false);
    entityTypeVersionCreateConfig2.setSaveCredentials(false);
    entityTypeVersionCreateConfig2.setSaveRelations(false);
    entityTypeVersionCreateConfig2.setSyncStrategy(SyncStrategy.OVERWRITE);

    HashMap<EntityType, EntityTypeVersionCreateConfig> entityTypes = new HashMap<>();
    entityTypes.put(EntityType.CUSTOMER, entityTypeVersionCreateConfig2);
    entityTypes.put(EntityType.TENANT, entityTypeVersionCreateConfig);

    ComplexVersionCreateRequest request = new ComplexVersionCreateRequest();
    request.setBranch("janedoe/featurebranch");
    request.setEntityTypes(entityTypes);
    request.setSyncStrategy(SyncStrategy.MERGE);
    request.setVersionName("1.0.2");

    // Act and Assert
    Map<EntityType, EntityTypeVersionCreateConfig> entityTypes2 = (new ComplexEntitiesExportCtx(user, commitGitRequest,
        request)).getRequest().getEntityTypes();
    assertEquals(2, entityTypes2.size());
    assertTrue(entityTypes2.containsKey(EntityType.TENANT));
    assertSame(entityTypeVersionCreateConfig2, entityTypes2.get(EntityType.CUSTOMER));
  }

  /**
   * Test {@link ComplexEntitiesExportCtx#getSettings()}.
   * <p>
   * Method under test: {@link ComplexEntitiesExportCtx#getSettings()}
   */
  @Test
  @DisplayName("Test getSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.sync.ie.EntityExportSettings ComplexEntitiesExportCtx.getSettings()"})
  void testGetSettings() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> complexEntitiesExportCtx.getSettings());
  }

  /**
   * Test {@link ComplexEntitiesExportCtx#getSettings(EntityType)} with {@code EntityType}.
   * <p>
   * Method under test: {@link ComplexEntitiesExportCtx#getSettings(EntityType)}
   */
  @Test
  @DisplayName("Test getSettings(EntityType) with 'EntityType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.sync.ie.EntityExportSettings ComplexEntitiesExportCtx.getSettings(EntityType)"})
  void testGetSettingsWithEntityType() {
    // Arrange, Act and Assert
    assertNull(complexEntitiesExportCtx.getSettings(EntityType.TENANT));
  }
}
