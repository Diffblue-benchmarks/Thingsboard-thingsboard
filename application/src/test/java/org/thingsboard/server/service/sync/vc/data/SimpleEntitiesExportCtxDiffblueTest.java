package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportSettings;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.common.data.sync.vc.request.create.SingleEntityVersionCreateRequest;
import org.thingsboard.server.common.data.sync.vc.request.create.VersionCreateConfig;

class SimpleEntitiesExportCtxDiffblueTest {
  /**
   * Test {@link SimpleEntitiesExportCtx#SimpleEntitiesExportCtx(User, CommitGitRequest, SingleEntityVersionCreateRequest)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return Settings ExportAttributes.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleEntitiesExportCtx#SimpleEntitiesExportCtx(User, CommitGitRequest, SingleEntityVersionCreateRequest)}
   */
  @Test
  @DisplayName("Test new SimpleEntitiesExportCtx(User, CommitGitRequest, SingleEntityVersionCreateRequest); given 'null'; then return Settings ExportAttributes")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SimpleEntitiesExportCtx.<init>(User, CommitGitRequest, SingleEntityVersionCreateRequest)"})
  void testNewSimpleEntitiesExportCtx_givenNull_thenReturnSettingsExportAttributes() {
    // Arrange
    User user = new User();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CommitGitRequest commit = new CommitGitRequest(tenantId, new ComplexVersionCreateRequest());

    VersionCreateConfig config = new VersionCreateConfig();
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);

    SingleEntityVersionCreateRequest request = new SingleEntityVersionCreateRequest();
    request.setBranch("janedoe/featurebranch");
    request.setConfig(config);
    request.setEntityId(null);
    request.setVersionName("1.0.2");

    // Act
    SimpleEntitiesExportCtx actualSimpleEntitiesExportCtx = new SimpleEntitiesExportCtx(user, commit, request);

    // Assert
    assertNull(actualSimpleEntitiesExportCtx.getTenantId());
    assertTrue(actualSimpleEntitiesExportCtx.getFutures().isEmpty());
    assertTrue(actualSimpleEntitiesExportCtx.getExternalIdMap().isEmpty());
    EntityExportSettings settings = actualSimpleEntitiesExportCtx.getSettings();
    assertTrue(settings.isExportAttributes());
    assertTrue(settings.isExportCredentials());
    assertTrue(settings.isExportRelations());
    assertSame(user, actualSimpleEntitiesExportCtx.getUser());
    assertSame(request, actualSimpleEntitiesExportCtx.getRequest());
    assertSame(commit, actualSimpleEntitiesExportCtx.getCommit());
  }

  /**
   * Test {@link SimpleEntitiesExportCtx#SimpleEntitiesExportCtx(User, CommitGitRequest, SingleEntityVersionCreateRequest)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Settings is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SimpleEntitiesExportCtx#SimpleEntitiesExportCtx(User, CommitGitRequest, SingleEntityVersionCreateRequest)}
   */
  @Test
  @DisplayName("Test new SimpleEntitiesExportCtx(User, CommitGitRequest, SingleEntityVersionCreateRequest); when 'null'; then return Settings is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SimpleEntitiesExportCtx.<init>(User, CommitGitRequest, SingleEntityVersionCreateRequest)"})
  void testNewSimpleEntitiesExportCtx_whenNull_thenReturnSettingsIsNull() {
    // Arrange
    User user = new User();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CommitGitRequest commit = new CommitGitRequest(tenantId, new ComplexVersionCreateRequest());

    // Act
    SimpleEntitiesExportCtx actualSimpleEntitiesExportCtx = new SimpleEntitiesExportCtx(user, commit, null);

    // Assert
    assertNull(actualSimpleEntitiesExportCtx.getTenantId());
    assertNull(actualSimpleEntitiesExportCtx.getSettings());
    assertNull(actualSimpleEntitiesExportCtx.getRequest());
    assertTrue(actualSimpleEntitiesExportCtx.getFutures().isEmpty());
    assertTrue(actualSimpleEntitiesExportCtx.getExternalIdMap().isEmpty());
    assertSame(user, actualSimpleEntitiesExportCtx.getUser());
    assertSame(commit, actualSimpleEntitiesExportCtx.getCommit());
  }
}
