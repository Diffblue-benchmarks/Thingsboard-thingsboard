package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.data.PendingGitRequest;

@ExtendWith(MockitoExtension.class)
class DefaultGitVersionControlQueueServiceDiffblueTest {
  @InjectMocks
  private DefaultGitVersionControlQueueService defaultGitVersionControlQueueService;

  /**
   * Test {@link DefaultGitVersionControlQueueService#addToCommit(CommitGitRequest, EntityExportData)}.
   * <p>
   * Method under test: {@link DefaultGitVersionControlQueueService#addToCommit(CommitGitRequest, EntityExportData)}
   */
  @Test
  @DisplayName("Test addToCommit(CommitGitRequest, EntityExportData)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.google.common.util.concurrent.ListenableFuture DefaultGitVersionControlQueueService.addToCommit(CommitGitRequest, EntityExportData)"})
  void testAddToCommit() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CommitGitRequest commit = new CommitGitRequest(tenantId, new ComplexVersionCreateRequest());

    ExportableEntity<EntityId> exportableEntity = mock(ExportableEntity.class);
    when(exportableEntity.getId()).thenThrow(new RuntimeException("Executing addToCommit [{}][{}][{}]"));
    EntityExportData<ExportableEntity<EntityId>> entityData = mock(EntityExportData.class);
    when(entityData.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityData.getEntity()).thenReturn(exportableEntity);
    doNothing().when(entityData).setEntity(Mockito.<ExportableEntity<EntityId>>any());
    entityData.setEntity(mock(ExportableEntity.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService.addToCommit(commit, entityData));
    verify(exportableEntity).getId();
    verify(entityData).getEntity();
    verify(entityData).getEntityType();
    verify(entityData).setEntity(isA(ExportableEntity.class));
  }

  /**
   * Test {@link DefaultGitVersionControlQueueService#addToCommit(CommitGitRequest, EntityExportData)}.
   * <ul>
   *   <li>Given {@link ExportableEntity} {@link HasId#getId()} return {@code null}.</li>
   *   <li>Then calls {@link EntityExportData#getExternalId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultGitVersionControlQueueService#addToCommit(CommitGitRequest, EntityExportData)}
   */
  @Test
  @DisplayName("Test addToCommit(CommitGitRequest, EntityExportData); given ExportableEntity getId() return 'null'; then calls getExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.google.common.util.concurrent.ListenableFuture DefaultGitVersionControlQueueService.addToCommit(CommitGitRequest, EntityExportData)"})
  void testAddToCommit_givenExportableEntityGetIdReturnNull_thenCallsGetExternalId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CommitGitRequest commit = new CommitGitRequest(tenantId, new ComplexVersionCreateRequest());

    ExportableEntity<EntityId> exportableEntity = mock(ExportableEntity.class);
    when(exportableEntity.getId()).thenReturn(null);
    EntityExportData<ExportableEntity<EntityId>> entityData = mock(EntityExportData.class);
    when(entityData.getExternalId()).thenThrow(new RuntimeException("Executing addToCommit [{}][{}][{}]"));
    when(entityData.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityData.getEntity()).thenReturn(exportableEntity);
    doNothing().when(entityData).setEntity(Mockito.<ExportableEntity<EntityId>>any());
    entityData.setEntity(mock(ExportableEntity.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService.addToCommit(commit, entityData));
    verify(exportableEntity).getId();
    verify(entityData).getEntity();
    verify(entityData, atLeast(1)).getEntityType();
    verify(entityData).getExternalId();
    verify(entityData).setEntity(isA(ExportableEntity.class));
  }

  /**
   * Test {@link DefaultGitVersionControlQueueService#addToCommit(CommitGitRequest, EntityExportData)}.
   * <ul>
   *   <li>Then calls {@link PendingGitRequest#getRequestId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultGitVersionControlQueueService#addToCommit(CommitGitRequest, EntityExportData)}
   */
  @Test
  @DisplayName("Test addToCommit(CommitGitRequest, EntityExportData); then calls getRequestId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.google.common.util.concurrent.ListenableFuture DefaultGitVersionControlQueueService.addToCommit(CommitGitRequest, EntityExportData)"})
  void testAddToCommit_thenCallsGetRequestId() {
    // Arrange
    CommitGitRequest commit = mock(CommitGitRequest.class);
    when(commit.getRequestId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ExportableEntity<EntityId> exportableEntity = mock(ExportableEntity.class);
    when(exportableEntity.getId()).thenReturn(null);
    EntityExportData<ExportableEntity<EntityId>> entityData = mock(EntityExportData.class);
    when(entityData.getExternalId()).thenThrow(new RuntimeException("Executing addToCommit [{}][{}][{}]"));
    when(entityData.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityData.getEntity()).thenReturn(exportableEntity);
    doNothing().when(entityData).setEntity(Mockito.<ExportableEntity<EntityId>>any());
    entityData.setEntity(mock(ExportableEntity.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService.addToCommit(commit, entityData));
    verify(exportableEntity).getId();
    verify(entityData).getEntity();
    verify(entityData, atLeast(1)).getEntityType();
    verify(entityData).getExternalId();
    verify(entityData).setEntity(isA(ExportableEntity.class));
    verify(commit).getRequestId();
  }
}
