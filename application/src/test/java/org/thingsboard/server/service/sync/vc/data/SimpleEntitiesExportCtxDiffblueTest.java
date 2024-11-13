package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportSettings;
import org.thingsboard.server.common.data.sync.vc.request.create.AutoVersionCreateConfig;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.common.data.sync.vc.request.create.SingleEntityVersionCreateRequest;
import org.thingsboard.server.common.data.sync.vc.request.create.VersionCreateConfig;

@DisabledInAotMode
class SimpleEntitiesExportCtxDiffblueTest {
  @MockBean
  private SimpleEntitiesExportCtx simpleEntitiesExportCtx;

  /**
   * Test
   * {@link SimpleEntitiesExportCtx#SimpleEntitiesExportCtx(User, CommitGitRequest, SingleEntityVersionCreateRequest)}.
   * <ul>
   *   <li>Then return TenantId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SimpleEntitiesExportCtx#SimpleEntitiesExportCtx(User, CommitGitRequest, SingleEntityVersionCreateRequest)}
   */
  @Test
  @DisplayName("Test new SimpleEntitiesExportCtx(User, CommitGitRequest, SingleEntityVersionCreateRequest); then return TenantId is 'null'")
  void testNewSimpleEntitiesExportCtx_thenReturnTenantIdIsNull() {
    // Arrange
    User user = mock(User.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CommitGitRequest commit = new CommitGitRequest(tenantId, new ComplexVersionCreateRequest());

    AutoVersionCreateConfig config = mock(AutoVersionCreateConfig.class);
    doNothing().when(config).setSaveAttributes(anyBoolean());
    doNothing().when(config).setSaveCredentials(anyBoolean());
    doNothing().when(config).setSaveRelations(anyBoolean());
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);

    VersionCreateConfig versionCreateConfig = new VersionCreateConfig();
    versionCreateConfig.setSaveAttributes(true);
    versionCreateConfig.setSaveCredentials(true);
    versionCreateConfig.setSaveRelations(true);
    SingleEntityVersionCreateRequest request = mock(SingleEntityVersionCreateRequest.class);
    when(request.getConfig()).thenReturn(versionCreateConfig);
    doNothing().when(request).setEntityId(Mockito.<EntityId>any());
    doNothing().when(request).setVersionName(Mockito.<String>any());
    doNothing().when(request).setConfig(Mockito.<VersionCreateConfig>any());
    doNothing().when(request).setBranch(Mockito.<String>any());
    request.setBranch("janedoe/featurebranch");
    request.setConfig(config);
    request.setEntityId(null);
    request.setVersionName("1.0.2");

    // Act
    SimpleEntitiesExportCtx actualSimpleEntitiesExportCtx = new SimpleEntitiesExportCtx(user, commit, request);

    // Assert
    verify(request).getConfig();
    verify(request).setConfig(isA(VersionCreateConfig.class));
    verify(request).setEntityId(isNull());
    verify(config).setSaveAttributes(eq(true));
    verify(config).setSaveCredentials(eq(true));
    verify(config).setSaveRelations(eq(true));
    verify(request).setBranch(eq("janedoe/featurebranch"));
    verify(request).setVersionName(eq("1.0.2"));
    assertNull(actualSimpleEntitiesExportCtx.getTenantId());
    assertTrue(actualSimpleEntitiesExportCtx.getFutures().isEmpty());
    assertTrue(actualSimpleEntitiesExportCtx.getExternalIdMap().isEmpty());
    EntityExportSettings settings = actualSimpleEntitiesExportCtx.getSettings();
    assertTrue(settings.isExportAttributes());
    assertTrue(settings.isExportCredentials());
    assertTrue(settings.isExportRelations());
    assertSame(commit, actualSimpleEntitiesExportCtx.getCommit());
    assertSame(user, actualSimpleEntitiesExportCtx.getUser());
    assertSame(request, actualSimpleEntitiesExportCtx.getRequest());
  }
}
