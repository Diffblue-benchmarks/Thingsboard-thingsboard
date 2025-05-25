package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.vc.AutoCommitSettings;
import org.thingsboard.server.common.data.sync.vc.BranchInfo;
import org.thingsboard.server.common.data.sync.vc.EntityVersion;
import org.thingsboard.server.common.data.sync.vc.RepositorySettings;
import org.thingsboard.server.common.data.sync.vc.VersionedEntityInfo;
import org.thingsboard.server.common.data.sync.vc.request.create.AutoVersionCreateConfig;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.common.data.sync.vc.request.create.VersionCreateRequest;
import org.thingsboard.server.service.sync.ie.exporting.ExportableEntitiesService;
import org.thingsboard.server.service.sync.vc.autocommit.TbAutoCommitSettingsService;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.repository.TbRepositorySettingsService;

@ExtendWith(MockitoExtension.class)
class DefaultEntitiesVersionControlServiceDiffblueTest {
  @InjectMocks
  private DefaultEntitiesVersionControlService defaultEntitiesVersionControlService;

  @Mock
  private ExportableEntitiesService exportableEntitiesService;

  @Mock
  private GitVersionControlQueueService gitVersionControlQueueService;

  @Mock
  private TbAutoCommitSettingsService tbAutoCommitSettingsService;

  @Mock
  private TbRepositorySettingsService tbRepositorySettingsService;

  /**
   * Test {@link DefaultEntitiesVersionControlService#saveEntitiesVersion(User, VersionCreateRequest)}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#saveEntitiesVersion(User, VersionCreateRequest)}
   */
  @Test
  @DisplayName("Test saveEntitiesVersion(User, VersionCreateRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.saveEntitiesVersion(User, VersionCreateRequest)"})
  void testSaveEntitiesVersion() throws Exception {
    // Arrange
    ListenableFutureTask<CommitGitRequest> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(gitVersionControlQueueService.prepareCommit(Mockito.<User>any(), Mockito.<VersionCreateRequest>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    User user = new User();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getBranch()).thenReturn("");

    // Act
    defaultEntitiesVersionControlService.saveEntitiesVersion(user, request);

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isA(Executor.class));
    verify(request).getBranch();
    verify(gitVersionControlQueueService).prepareCommit(isA(User.class), isA(VersionCreateRequest.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#saveEntitiesVersion(User, VersionCreateRequest)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#saveEntitiesVersion(User, VersionCreateRequest)}
   */
  @Test
  @DisplayName("Test saveEntitiesVersion(User, VersionCreateRequest); given 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.saveEntitiesVersion(User, VersionCreateRequest)"})
  void testSaveEntitiesVersion_givenFoo() throws Exception {
    // Arrange
    ListenableFutureTask<CommitGitRequest> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(gitVersionControlQueueService.prepareCommit(Mockito.<User>any(), Mockito.<VersionCreateRequest>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    User user = new User();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getBranch()).thenReturn("foo");

    // Act
    defaultEntitiesVersionControlService.saveEntitiesVersion(user, request);

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isA(Executor.class));
    verify(request).getBranch();
    verify(gitVersionControlQueueService).prepareCommit(isA(User.class), isA(VersionCreateRequest.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#saveEntitiesVersion(User, VersionCreateRequest)}.
   * <ul>
   *   <li>Given {@code janedoe/featurebranch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#saveEntitiesVersion(User, VersionCreateRequest)}
   */
  @Test
  @DisplayName("Test saveEntitiesVersion(User, VersionCreateRequest); given 'janedoe/featurebranch'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.saveEntitiesVersion(User, VersionCreateRequest)"})
  void testSaveEntitiesVersion_givenJanedoeFeaturebranch() throws Exception {
    // Arrange
    ListenableFutureTask<CommitGitRequest> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(gitVersionControlQueueService.prepareCommit(Mockito.<User>any(), Mockito.<VersionCreateRequest>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    User user = new User();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getBranch()).thenReturn("janedoe/featurebranch");

    // Act
    defaultEntitiesVersionControlService.saveEntitiesVersion(user, request);

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isA(Executor.class));
    verify(request).getBranch();
    verify(gitVersionControlQueueService).prepareCommit(isA(User.class), isA(VersionCreateRequest.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#saveEntitiesVersion(User, VersionCreateRequest)}.
   * <ul>
   *   <li>Given {@link ListenableFutureToApiFuture#ListenableFutureToApiFuture(ListenableFuture)} with delegate is create.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#saveEntitiesVersion(User, VersionCreateRequest)}
   */
  @Test
  @DisplayName("Test saveEntitiesVersion(User, VersionCreateRequest); given ListenableFutureToApiFuture(ListenableFuture) with delegate is create")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.saveEntitiesVersion(User, VersionCreateRequest)"})
  void testSaveEntitiesVersion_givenListenableFutureToApiFutureWithDelegateIsCreate() throws Exception {
    // Arrange
    SettableFuture<CommitGitRequest> delegate = SettableFuture.create();
    when(gitVersionControlQueueService.prepareCommit(Mockito.<User>any(), Mockito.<VersionCreateRequest>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    User user = new User();

    // Act
    defaultEntitiesVersionControlService.saveEntitiesVersion(user, new ComplexVersionCreateRequest());

    // Assert
    verify(gitVersionControlQueueService).prepareCommit(isA(User.class), isA(VersionCreateRequest.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#saveEntitiesVersion(User, VersionCreateRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#saveEntitiesVersion(User, VersionCreateRequest)}
   */
  @Test
  @DisplayName("Test saveEntitiesVersion(User, VersionCreateRequest); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.saveEntitiesVersion(User, VersionCreateRequest)"})
  void testSaveEntitiesVersion_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    when(gitVersionControlQueueService.prepareCommit(Mockito.<User>any(), Mockito.<VersionCreateRequest>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    User user = new User();

    ComplexVersionCreateRequest request = new ComplexVersionCreateRequest();
    request.setBranch("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntitiesVersionControlService.saveEntitiesVersion(user, request));
    verify(gitVersionControlQueueService).prepareCommit(isA(User.class), isA(VersionCreateRequest.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#saveEntitiesVersion(User, VersionCreateRequest)}.
   * <ul>
   *   <li>When {@link ComplexVersionCreateRequest} (default constructor).</li>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#saveEntitiesVersion(User, VersionCreateRequest)}
   */
  @Test
  @DisplayName("Test saveEntitiesVersion(User, VersionCreateRequest); when ComplexVersionCreateRequest (default constructor); then calls addListener(Runnable, Executor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.saveEntitiesVersion(User, VersionCreateRequest)"})
  void testSaveEntitiesVersion_whenComplexVersionCreateRequest_thenCallsAddListener() throws Exception {
    // Arrange
    ListenableFutureTask<CommitGitRequest> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(gitVersionControlQueueService.prepareCommit(Mockito.<User>any(), Mockito.<VersionCreateRequest>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    User user = new User();

    // Act
    defaultEntitiesVersionControlService.saveEntitiesVersion(user, new ComplexVersionCreateRequest());

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isA(Executor.class));
    verify(gitVersionControlQueueService).prepareCommit(isA(User.class), isA(VersionCreateRequest.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#listEntityVersions(TenantId, String, EntityId, PageLink)}.
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#listEntityVersions(TenantId, String, EntityId, PageLink)}
   */
  @Test
  @DisplayName("Test listEntityVersions(TenantId, String, EntityId, PageLink); then return ApiFutureToListenableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.listEntityVersions(TenantId, String, EntityId, PageLink)"})
  void testListEntityVersions_thenReturnApiFutureToListenableFuture() throws Exception {
    // Arrange
    SettableFuture<PageData<EntityVersion>> delegate = SettableFuture.create();
    ApiFutureToListenableFuture<PageData<EntityVersion>> apiFutureToListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    when(gitVersionControlQueueService.listVersions(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<EntityId>any(), Mockito.<PageLink>any())).thenReturn(apiFutureToListenableFuture);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<PageData<EntityVersion>> actualListEntityVersionsResult = defaultEntitiesVersionControlService
        .listEntityVersions(tenantId, "janedoe/featurebranch", null, new PageLink(3));

    // Assert
    verify(gitVersionControlQueueService).listVersions(isA(TenantId.class), eq("janedoe/featurebranch"),
        (EntityId) isNull(), isA(PageLink.class));
    assertTrue(actualListEntityVersionsResult instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualListEntityVersionsResult);
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#listEntityVersions(TenantId, String, EntityId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#listEntityVersions(TenantId, String, EntityId, PageLink)}
   */
  @Test
  @DisplayName("Test listEntityVersions(TenantId, String, EntityId, PageLink); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.listEntityVersions(TenantId, String, EntityId, PageLink)"})
  void testListEntityVersions_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    when(gitVersionControlQueueService.listVersions(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<EntityId>any(), Mockito.<PageLink>any())).thenThrow(new IllegalArgumentException("foo"));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultEntitiesVersionControlService.listEntityVersions(tenantId,
        "janedoe/featurebranch", null, new PageLink(3)));
    verify(gitVersionControlQueueService).listVersions(isA(TenantId.class), eq("janedoe/featurebranch"),
        (EntityId) isNull(), isA(PageLink.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#listEntityTypeVersions(TenantId, String, EntityType, PageLink)}.
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#listEntityTypeVersions(TenantId, String, EntityType, PageLink)}
   */
  @Test
  @DisplayName("Test listEntityTypeVersions(TenantId, String, EntityType, PageLink); then return ApiFutureToListenableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.listEntityTypeVersions(TenantId, String, EntityType, PageLink)"})
  void testListEntityTypeVersions_thenReturnApiFutureToListenableFuture() throws Exception {
    // Arrange
    SettableFuture<PageData<EntityVersion>> delegate = SettableFuture.create();
    ApiFutureToListenableFuture<PageData<EntityVersion>> apiFutureToListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    when(gitVersionControlQueueService.listVersions(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<EntityType>any(), Mockito.<PageLink>any())).thenReturn(apiFutureToListenableFuture);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<PageData<EntityVersion>> actualListEntityTypeVersionsResult = defaultEntitiesVersionControlService
        .listEntityTypeVersions(tenantId, "janedoe/featurebranch", EntityType.TENANT, new PageLink(3));

    // Assert
    verify(gitVersionControlQueueService).listVersions(isA(TenantId.class), eq("janedoe/featurebranch"),
        eq(EntityType.TENANT), isA(PageLink.class));
    assertTrue(actualListEntityTypeVersionsResult instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualListEntityTypeVersionsResult);
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#listEntityTypeVersions(TenantId, String, EntityType, PageLink)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#listEntityTypeVersions(TenantId, String, EntityType, PageLink)}
   */
  @Test
  @DisplayName("Test listEntityTypeVersions(TenantId, String, EntityType, PageLink); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.listEntityTypeVersions(TenantId, String, EntityType, PageLink)"})
  void testListEntityTypeVersions_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    when(gitVersionControlQueueService.listVersions(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<EntityType>any(), Mockito.<PageLink>any())).thenThrow(new IllegalArgumentException("foo"));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultEntitiesVersionControlService
        .listEntityTypeVersions(tenantId, "janedoe/featurebranch", EntityType.TENANT, new PageLink(3)));
    verify(gitVersionControlQueueService).listVersions(isA(TenantId.class), eq("janedoe/featurebranch"),
        eq(EntityType.TENANT), isA(PageLink.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#listVersions(TenantId, String, PageLink)}.
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#listVersions(TenantId, String, PageLink)}
   */
  @Test
  @DisplayName("Test listVersions(TenantId, String, PageLink); then return ApiFutureToListenableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.listVersions(TenantId, String, PageLink)"})
  void testListVersions_thenReturnApiFutureToListenableFuture() throws Exception {
    // Arrange
    SettableFuture<PageData<EntityVersion>> delegate = SettableFuture.create();
    ApiFutureToListenableFuture<PageData<EntityVersion>> apiFutureToListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    when(gitVersionControlQueueService.listVersions(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<PageLink>any())).thenReturn(apiFutureToListenableFuture);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<PageData<EntityVersion>> actualListVersionsResult = defaultEntitiesVersionControlService
        .listVersions(tenantId, "janedoe/featurebranch", new PageLink(3));

    // Assert
    verify(gitVersionControlQueueService).listVersions(isA(TenantId.class), eq("janedoe/featurebranch"),
        isA(PageLink.class));
    assertTrue(actualListVersionsResult instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualListVersionsResult);
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#listVersions(TenantId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#listVersions(TenantId, String, PageLink)}
   */
  @Test
  @DisplayName("Test listVersions(TenantId, String, PageLink); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.listVersions(TenantId, String, PageLink)"})
  void testListVersions_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    when(gitVersionControlQueueService.listVersions(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<PageLink>any())).thenThrow(new IllegalArgumentException("foo"));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntitiesVersionControlService.listVersions(tenantId, "janedoe/featurebranch", new PageLink(3)));
    verify(gitVersionControlQueueService).listVersions(isA(TenantId.class), eq("janedoe/featurebranch"),
        isA(PageLink.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#listEntitiesAtVersion(TenantId, String, EntityType)}.
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#listEntitiesAtVersion(TenantId, String, EntityType)}
   */
  @Test
  @DisplayName("Test listEntitiesAtVersion(TenantId, String, EntityType); then return ApiFutureToListenableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.listEntitiesAtVersion(TenantId, String, EntityType)"})
  void testListEntitiesAtVersion_thenReturnApiFutureToListenableFuture() throws Exception {
    // Arrange
    SettableFuture<List<VersionedEntityInfo>> delegate = SettableFuture.create();
    ApiFutureToListenableFuture<List<VersionedEntityInfo>> apiFutureToListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    when(gitVersionControlQueueService.listEntitiesAtVersion(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<EntityType>any())).thenReturn(apiFutureToListenableFuture);

    // Act
    ListenableFuture<List<VersionedEntityInfo>> actualListEntitiesAtVersionResult = defaultEntitiesVersionControlService
        .listEntitiesAtVersion(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "42",
            EntityType.TENANT);

    // Assert
    verify(gitVersionControlQueueService).listEntitiesAtVersion(isA(TenantId.class), eq("42"), eq(EntityType.TENANT));
    assertTrue(actualListEntitiesAtVersionResult instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualListEntitiesAtVersionResult);
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#listEntitiesAtVersion(TenantId, String, EntityType)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#listEntitiesAtVersion(TenantId, String, EntityType)}
   */
  @Test
  @DisplayName("Test listEntitiesAtVersion(TenantId, String, EntityType); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.listEntitiesAtVersion(TenantId, String, EntityType)"})
  void testListEntitiesAtVersion_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    when(gitVersionControlQueueService.listEntitiesAtVersion(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<EntityType>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultEntitiesVersionControlService.listEntitiesAtVersion(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "42", EntityType.TENANT));
    verify(gitVersionControlQueueService).listEntitiesAtVersion(isA(TenantId.class), eq("42"), eq(EntityType.TENANT));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#listAllEntitiesAtVersion(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#listAllEntitiesAtVersion(TenantId, String)}
   */
  @Test
  @DisplayName("Test listAllEntitiesAtVersion(TenantId, String); then return ApiFutureToListenableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.listAllEntitiesAtVersion(TenantId, String)"})
  void testListAllEntitiesAtVersion_thenReturnApiFutureToListenableFuture() throws Exception {
    // Arrange
    SettableFuture<List<VersionedEntityInfo>> delegate = SettableFuture.create();
    ApiFutureToListenableFuture<List<VersionedEntityInfo>> apiFutureToListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    when(gitVersionControlQueueService.listEntitiesAtVersion(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(apiFutureToListenableFuture);

    // Act
    ListenableFuture<List<VersionedEntityInfo>> actualListAllEntitiesAtVersionResult = defaultEntitiesVersionControlService
        .listAllEntitiesAtVersion(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "42");

    // Assert
    verify(gitVersionControlQueueService).listEntitiesAtVersion(isA(TenantId.class), eq("42"));
    assertTrue(actualListAllEntitiesAtVersionResult instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualListAllEntitiesAtVersionResult);
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#listAllEntitiesAtVersion(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#listAllEntitiesAtVersion(TenantId, String)}
   */
  @Test
  @DisplayName("Test listAllEntitiesAtVersion(TenantId, String); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.listAllEntitiesAtVersion(TenantId, String)"})
  void testListAllEntitiesAtVersion_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    when(gitVersionControlQueueService.listEntitiesAtVersion(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultEntitiesVersionControlService
        .listAllEntitiesAtVersion(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "42"));
    verify(gitVersionControlQueueService).listEntitiesAtVersion(isA(TenantId.class), eq("42"));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#compareEntityDataToVersion(User, EntityId, String)}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#compareEntityDataToVersion(User, EntityId, String)}
   */
  @Test
  @DisplayName("Test compareEntityDataToVersion(User, EntityId, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.compareEntityDataToVersion(User, EntityId, String)"})
  void testCompareEntityDataToVersion() throws Exception {
    // Arrange
    when(exportableEntitiesService.findEntityByTenantIdAndId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenThrow(new IllegalArgumentException("Unsupported entity type"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntitiesVersionControlService.compareEntityDataToVersion(new User(), null, "42"));
    verify(exportableEntitiesService).findEntityByTenantIdAndId(isNull(), isNull());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#compareEntityDataToVersion(User, EntityId, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#compareEntityDataToVersion(User, EntityId, String)}
   */
  @Test
  @DisplayName("Test compareEntityDataToVersion(User, EntityId, String); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.compareEntityDataToVersion(User, EntityId, String)"})
  void testCompareEntityDataToVersion_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    when(exportableEntitiesService.findEntityByTenantIdAndId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(mock(HasId.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntitiesVersionControlService.compareEntityDataToVersion(new User(), null, "42"));
    verify(exportableEntitiesService).findEntityByTenantIdAndId(isNull(), isNull());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#getEntityDataInfo(User, EntityId, String)}.
   * <ul>
   *   <li>Given {@link ListenableFutureToApiFuture#ListenableFutureToApiFuture(ListenableFuture)} with delegate is create.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#getEntityDataInfo(User, EntityId, String)}
   */
  @Test
  @DisplayName("Test getEntityDataInfo(User, EntityId, String); given ListenableFutureToApiFuture(ListenableFuture) with delegate is create")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.getEntityDataInfo(User, EntityId, String)"})
  void testGetEntityDataInfo_givenListenableFutureToApiFutureWithDelegateIsCreate() {
    // Arrange
    SettableFuture<EntityExportData> delegate = SettableFuture.create();
    when(gitVersionControlQueueService.getEntity(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<EntityId>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));

    // Act
    defaultEntitiesVersionControlService.getEntityDataInfo(new User(), null, "42");

    // Assert
    verify(gitVersionControlQueueService).getEntity(isNull(), eq("42"), isNull());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#getEntityDataInfo(User, EntityId, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#getEntityDataInfo(User, EntityId, String)}
   */
  @Test
  @DisplayName("Test getEntityDataInfo(User, EntityId, String); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.getEntityDataInfo(User, EntityId, String)"})
  void testGetEntityDataInfo_thenThrowIllegalArgumentException() {
    // Arrange
    ListenableFutureTask<EntityExportData> delegate = mock(ListenableFutureTask.class);
    doThrow(new IllegalArgumentException("foo")).when(delegate)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(gitVersionControlQueueService.getEntity(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<EntityId>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntitiesVersionControlService.getEntityDataInfo(new User(), null, "42"));
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(gitVersionControlQueueService).getEntity(isNull(), eq("42"), isNull());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#listBranches(TenantId)}.
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#listBranches(TenantId)}
   */
  @Test
  @DisplayName("Test listBranches(TenantId); then return ApiFutureToListenableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.listBranches(TenantId)"})
  void testListBranches_thenReturnApiFutureToListenableFuture() throws Exception {
    // Arrange
    SettableFuture<List<BranchInfo>> delegate = SettableFuture.create();
    ApiFutureToListenableFuture<List<BranchInfo>> apiFutureToListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    when(gitVersionControlQueueService.listBranches(Mockito.<TenantId>any())).thenReturn(apiFutureToListenableFuture);

    // Act
    ListenableFuture<List<BranchInfo>> actualListBranchesResult = defaultEntitiesVersionControlService
        .listBranches(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(gitVersionControlQueueService).listBranches(isA(TenantId.class));
    assertTrue(actualListBranchesResult instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualListBranchesResult);
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#listBranches(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#listBranches(TenantId)}
   */
  @Test
  @DisplayName("Test listBranches(TenantId); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.listBranches(TenantId)"})
  void testListBranches_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    when(gitVersionControlQueueService.listBranches(Mockito.<TenantId>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultEntitiesVersionControlService
        .listBranches(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(gitVersionControlQueueService).listBranches(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#getVersionControlSettings(TenantId)}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#getVersionControlSettings(TenantId)}
   */
  @Test
  @DisplayName("Test getVersionControlSettings(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RepositorySettings DefaultEntitiesVersionControlService.getVersionControlSettings(TenantId)"})
  void testGetVersionControlSettings() {
    // Arrange
    RepositorySettings repositorySettings = new RepositorySettings();
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(repositorySettings);

    // Act
    RepositorySettings actualVersionControlSettings = defaultEntitiesVersionControlService
        .getVersionControlSettings(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(tbRepositorySettingsService).get(isA(TenantId.class));
    assertSame(repositorySettings, actualVersionControlSettings);
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#getVersionControlSettings(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#getVersionControlSettings(TenantId)}
   */
  @Test
  @DisplayName("Test getVersionControlSettings(TenantId); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RepositorySettings DefaultEntitiesVersionControlService.getVersionControlSettings(TenantId)"})
  void testGetVersionControlSettings_thenThrowIllegalArgumentException() {
    // Arrange
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultEntitiesVersionControlService
        .getVersionControlSettings(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(tbRepositorySettingsService).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#saveVersionControlSettings(TenantId, RepositorySettings)}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#saveVersionControlSettings(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test saveVersionControlSettings(TenantId, RepositorySettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.saveVersionControlSettings(TenantId, RepositorySettings)"})
  void testSaveVersionControlSettings() {
    // Arrange
    when(tbRepositorySettingsService.restore(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(new RepositorySettings());
    when(gitVersionControlQueueService.initRepository(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenThrow(new IllegalArgumentException("{} Failed to init repository: {}"));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultEntitiesVersionControlService.saveVersionControlSettings(tenantId, new RepositorySettings()));
    verify(gitVersionControlQueueService).initRepository(isA(TenantId.class), isA(RepositorySettings.class));
    verify(tbRepositorySettingsService).restore(isA(TenantId.class), isA(RepositorySettings.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#saveVersionControlSettings(TenantId, RepositorySettings)}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#saveVersionControlSettings(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test saveVersionControlSettings(TenantId, RepositorySettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.saveVersionControlSettings(TenantId, RepositorySettings)"})
  void testSaveVersionControlSettings2() {
    // Arrange
    when(tbRepositorySettingsService.restore(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(new RepositorySettings());
    SettableFuture<Void> delegate = SettableFuture.create();
    when(gitVersionControlQueueService.initRepository(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    defaultEntitiesVersionControlService.saveVersionControlSettings(tenantId, new RepositorySettings());

    // Assert
    verify(gitVersionControlQueueService).initRepository(isA(TenantId.class), isA(RepositorySettings.class));
    verify(tbRepositorySettingsService).restore(isA(TenantId.class), isA(RepositorySettings.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#saveVersionControlSettings(TenantId, RepositorySettings)}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#saveVersionControlSettings(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test saveVersionControlSettings(TenantId, RepositorySettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.saveVersionControlSettings(TenantId, RepositorySettings)"})
  void testSaveVersionControlSettings3() {
    // Arrange
    when(tbRepositorySettingsService.restore(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(new RepositorySettings());
    ListenableFutureTask<Void> delegate = mock(ListenableFutureTask.class);
    doThrow(new IllegalArgumentException("foo")).when(delegate)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(gitVersionControlQueueService.initRepository(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RepositorySettings versionControlSettings = mock(RepositorySettings.class);
    when(versionControlSettings.getDefaultBranch()).thenReturn("");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultEntitiesVersionControlService.saveVersionControlSettings(tenantId, versionControlSettings));
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(versionControlSettings).getDefaultBranch();
    verify(gitVersionControlQueueService).initRepository(isA(TenantId.class), isA(RepositorySettings.class));
    verify(tbRepositorySettingsService).restore(isA(TenantId.class), isA(RepositorySettings.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#saveVersionControlSettings(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#saveVersionControlSettings(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test saveVersionControlSettings(TenantId, RepositorySettings); given 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.saveVersionControlSettings(TenantId, RepositorySettings)"})
  void testSaveVersionControlSettings_givenFoo() {
    // Arrange
    when(tbRepositorySettingsService.restore(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(new RepositorySettings());
    ListenableFutureTask<Void> delegate = mock(ListenableFutureTask.class);
    doThrow(new IllegalArgumentException("foo")).when(delegate)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(gitVersionControlQueueService.initRepository(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RepositorySettings versionControlSettings = mock(RepositorySettings.class);
    when(versionControlSettings.getDefaultBranch()).thenReturn("foo");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultEntitiesVersionControlService.saveVersionControlSettings(tenantId, versionControlSettings));
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(versionControlSettings).getDefaultBranch();
    verify(gitVersionControlQueueService).initRepository(isA(TenantId.class), isA(RepositorySettings.class));
    verify(tbRepositorySettingsService).restore(isA(TenantId.class), isA(RepositorySettings.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#saveVersionControlSettings(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Given {@code janedoe/featurebranch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#saveVersionControlSettings(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test saveVersionControlSettings(TenantId, RepositorySettings); given 'janedoe/featurebranch'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.saveVersionControlSettings(TenantId, RepositorySettings)"})
  void testSaveVersionControlSettings_givenJanedoeFeaturebranch() {
    // Arrange
    when(tbRepositorySettingsService.restore(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(new RepositorySettings());
    ListenableFutureTask<Void> delegate = mock(ListenableFutureTask.class);
    doThrow(new IllegalArgumentException("foo")).when(delegate)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(gitVersionControlQueueService.initRepository(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RepositorySettings versionControlSettings = mock(RepositorySettings.class);
    when(versionControlSettings.getDefaultBranch()).thenReturn("janedoe/featurebranch");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultEntitiesVersionControlService.saveVersionControlSettings(tenantId, versionControlSettings));
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(versionControlSettings).getDefaultBranch();
    verify(gitVersionControlQueueService).initRepository(isA(TenantId.class), isA(RepositorySettings.class));
    verify(tbRepositorySettingsService).restore(isA(TenantId.class), isA(RepositorySettings.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#saveVersionControlSettings(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#saveVersionControlSettings(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test saveVersionControlSettings(TenantId, RepositorySettings); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.saveVersionControlSettings(TenantId, RepositorySettings)"})
  void testSaveVersionControlSettings_thenThrowIllegalArgumentException() {
    // Arrange
    when(tbRepositorySettingsService.restore(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenThrow(new IllegalArgumentException("{} Failed to init repository: {}"));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RepositorySettings versionControlSettings = new RepositorySettings();
    versionControlSettings.setDefaultBranch("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntitiesVersionControlService.saveVersionControlSettings(tenantId, versionControlSettings));
    verify(tbRepositorySettingsService).restore(isA(TenantId.class), isA(RepositorySettings.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#saveVersionControlSettings(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>When {@link RepositorySettings#RepositorySettings()}.</li>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#saveVersionControlSettings(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test saveVersionControlSettings(TenantId, RepositorySettings); when RepositorySettings(); then calls addListener(Runnable, Executor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.saveVersionControlSettings(TenantId, RepositorySettings)"})
  void testSaveVersionControlSettings_whenRepositorySettings_thenCallsAddListener() {
    // Arrange
    when(tbRepositorySettingsService.restore(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(new RepositorySettings());
    ListenableFutureTask<Void> delegate = mock(ListenableFutureTask.class);
    doThrow(new IllegalArgumentException("foo")).when(delegate)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(gitVersionControlQueueService.initRepository(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultEntitiesVersionControlService.saveVersionControlSettings(tenantId, new RepositorySettings()));
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(gitVersionControlQueueService).initRepository(isA(TenantId.class), isA(RepositorySettings.class));
    verify(tbRepositorySettingsService).restore(isA(TenantId.class), isA(RepositorySettings.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#deleteVersionControlSettings(TenantId)}.
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#deleteVersionControlSettings(TenantId)}
   */
  @Test
  @DisplayName("Test deleteVersionControlSettings(TenantId); then return ApiFutureToListenableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.deleteVersionControlSettings(TenantId)"})
  void testDeleteVersionControlSettings_thenReturnApiFutureToListenableFuture() {
    // Arrange
    SettableFuture<Void> delegate = SettableFuture.create();
    ApiFutureToListenableFuture<Void> apiFutureToListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    when(gitVersionControlQueueService.clearRepository(Mockito.<TenantId>any()))
        .thenReturn(apiFutureToListenableFuture);

    // Act
    ListenableFuture<Void> actualDeleteVersionControlSettingsResult = defaultEntitiesVersionControlService
        .deleteVersionControlSettings(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(gitVersionControlQueueService).clearRepository(isA(TenantId.class));
    assertTrue(actualDeleteVersionControlSettingsResult instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualDeleteVersionControlSettingsResult);
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#deleteVersionControlSettings(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#deleteVersionControlSettings(TenantId)}
   */
  @Test
  @DisplayName("Test deleteVersionControlSettings(TenantId); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.deleteVersionControlSettings(TenantId)"})
  void testDeleteVersionControlSettings_thenThrowIllegalArgumentException() {
    // Arrange
    when(gitVersionControlQueueService.clearRepository(Mockito.<TenantId>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultEntitiesVersionControlService
        .deleteVersionControlSettings(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(gitVersionControlQueueService).clearRepository(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test checkVersionControlAccess(TenantId, RepositorySettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.checkVersionControlAccess(TenantId, RepositorySettings)"})
  void testCheckVersionControlAccess() throws ThingsboardException {
    // Arrange
    when(tbRepositorySettingsService.restore(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(new RepositorySettings());
    when(gitVersionControlQueueService.testRepository(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.getDefaultBranch()).thenReturn("");

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultEntitiesVersionControlService.checkVersionControlAccess(tenantId, settings));
    verify(settings).getDefaultBranch();
    verify(gitVersionControlQueueService).testRepository(isA(TenantId.class), isA(RepositorySettings.class));
    verify(tbRepositorySettingsService).restore(isA(TenantId.class), isA(RepositorySettings.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test checkVersionControlAccess(TenantId, RepositorySettings); given 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.checkVersionControlAccess(TenantId, RepositorySettings)"})
  void testCheckVersionControlAccess_givenFoo() throws ThingsboardException {
    // Arrange
    when(tbRepositorySettingsService.restore(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(new RepositorySettings());
    when(gitVersionControlQueueService.testRepository(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.getDefaultBranch()).thenReturn("foo");

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultEntitiesVersionControlService.checkVersionControlAccess(tenantId, settings));
    verify(settings).getDefaultBranch();
    verify(gitVersionControlQueueService).testRepository(isA(TenantId.class), isA(RepositorySettings.class));
    verify(tbRepositorySettingsService).restore(isA(TenantId.class), isA(RepositorySettings.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Given {@code janedoe/featurebranch}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test checkVersionControlAccess(TenantId, RepositorySettings); given 'janedoe/featurebranch'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.checkVersionControlAccess(TenantId, RepositorySettings)"})
  void testCheckVersionControlAccess_givenJanedoeFeaturebranch() throws ThingsboardException {
    // Arrange
    when(tbRepositorySettingsService.restore(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(new RepositorySettings());
    when(gitVersionControlQueueService.testRepository(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.getDefaultBranch()).thenReturn("janedoe/featurebranch");

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultEntitiesVersionControlService.checkVersionControlAccess(tenantId, settings));
    verify(settings).getDefaultBranch();
    verify(gitVersionControlQueueService).testRepository(isA(TenantId.class), isA(RepositorySettings.class));
    verify(tbRepositorySettingsService).restore(isA(TenantId.class), isA(RepositorySettings.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Then calls {@link GitVersionControlQueueService#testRepository(TenantId, RepositorySettings)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test checkVersionControlAccess(TenantId, RepositorySettings); then calls testRepository(TenantId, RepositorySettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.checkVersionControlAccess(TenantId, RepositorySettings)"})
  void testCheckVersionControlAccess_thenCallsTestRepository() throws ThingsboardException {
    // Arrange
    when(tbRepositorySettingsService.restore(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(new RepositorySettings());
    when(gitVersionControlQueueService.testRepository(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultEntitiesVersionControlService.checkVersionControlAccess(tenantId, new RepositorySettings()));
    verify(gitVersionControlQueueService).testRepository(isA(TenantId.class), isA(RepositorySettings.class));
    verify(tbRepositorySettingsService).restore(isA(TenantId.class), isA(RepositorySettings.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test checkVersionControlAccess(TenantId, RepositorySettings); then return ApiFutureToListenableFuture")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.checkVersionControlAccess(TenantId, RepositorySettings)"})
  void testCheckVersionControlAccess_thenReturnApiFutureToListenableFuture() throws ThingsboardException {
    // Arrange
    when(tbRepositorySettingsService.restore(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(new RepositorySettings());
    SettableFuture<Void> delegate = SettableFuture.create();
    ApiFutureToListenableFuture<Void> apiFutureToListenableFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    when(gitVersionControlQueueService.testRepository(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenReturn(apiFutureToListenableFuture);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Void> actualCheckVersionControlAccessResult = defaultEntitiesVersionControlService
        .checkVersionControlAccess(tenantId, new RepositorySettings());

    // Assert
    verify(gitVersionControlQueueService).testRepository(isA(TenantId.class), isA(RepositorySettings.class));
    verify(tbRepositorySettingsService).restore(isA(TenantId.class), isA(RepositorySettings.class));
    assertTrue(actualCheckVersionControlAccessResult instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualCheckVersionControlAccessResult);
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test checkVersionControlAccess(TenantId, RepositorySettings); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DefaultEntitiesVersionControlService.checkVersionControlAccess(TenantId, RepositorySettings)"})
  void testCheckVersionControlAccess_thenThrowIllegalArgumentException() throws ThingsboardException {
    // Arrange
    when(tbRepositorySettingsService.restore(Mockito.<TenantId>any(), Mockito.<RepositorySettings>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RepositorySettings settings = new RepositorySettings();
    settings.setDefaultBranch("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntitiesVersionControlService.checkVersionControlAccess(tenantId, settings));
    verify(tbRepositorySettingsService).restore(isA(TenantId.class), isA(RepositorySettings.class));
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityId)} with {@code user}, {@code entityId}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityId)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityId) with 'user', 'entityId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityId)"})
  void testAutoCommitWithUserEntityId() throws Exception {
    // Arrange
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(new RepositorySettings());
    when(tbAutoCommitSettingsService.get(Mockito.<TenantId>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntitiesVersionControlService.autoCommit(new User(), null));
    verify(tbAutoCommitSettingsService).get(isNull());
    verify(tbRepositorySettingsService).get(isNull());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityId)} with {@code user}, {@code entityId}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityId)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityId) with 'user', 'entityId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityId)"})
  void testAutoCommitWithUserEntityId2() throws Exception {
    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isReadOnly()).thenThrow(new IllegalArgumentException("foo"));
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(repositorySettings);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntitiesVersionControlService.autoCommit(new User(), null));
    verify(repositorySettings).isReadOnly();
    verify(tbRepositorySettingsService).get(isNull());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityId)} with {@code user}, {@code entityId}.
   * <ul>
   *   <li>Given {@link RepositorySettings} {@link RepositorySettings#isReadOnly()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityId)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityId) with 'user', 'entityId'; given RepositorySettings isReadOnly() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityId)"})
  void testAutoCommitWithUserEntityId_givenRepositorySettingsIsReadOnlyReturnFalse() throws Exception {
    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isReadOnly()).thenReturn(false);
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(repositorySettings);
    when(tbAutoCommitSettingsService.get(Mockito.<TenantId>any())).thenReturn(new AutoCommitSettings());
    User user = new User();

    // Act
    ListenableFuture<UUID> actualAutoCommitResult = defaultEntitiesVersionControlService.autoCommit(user,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(repositorySettings).isReadOnly();
    verify(tbAutoCommitSettingsService).get(isNull());
    verify(tbRepositorySettingsService).get(isNull());
    assertNull(actualAutoCommitResult.get());
    assertTrue(actualAutoCommitResult.isDone());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityId)} with {@code user}, {@code entityId}.
   * <ul>
   *   <li>Given {@link RepositorySettings} {@link RepositorySettings#isReadOnly()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityId)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityId) with 'user', 'entityId'; given RepositorySettings isReadOnly() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityId)"})
  void testAutoCommitWithUserEntityId_givenRepositorySettingsIsReadOnlyReturnTrue() throws Exception {
    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isReadOnly()).thenReturn(true);
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(repositorySettings);

    // Act
    ListenableFuture<UUID> actualAutoCommitResult = defaultEntitiesVersionControlService.autoCommit(new User(), null);

    // Assert
    verify(repositorySettings).isReadOnly();
    verify(tbRepositorySettingsService).get(isNull());
    assertNull(actualAutoCommitResult.get());
    assertTrue(actualAutoCommitResult.isDone());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityId)} with {@code user}, {@code entityId}.
   * <ul>
   *   <li>Given {@link TbRepositorySettingsService} {@link TbRepositorySettingsService#get(TenantId)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityId)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityId) with 'user', 'entityId'; given TbRepositorySettingsService get(TenantId) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityId)"})
  void testAutoCommitWithUserEntityId_givenTbRepositorySettingsServiceGetReturnNull() throws Exception {
    // Arrange
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(null);

    // Act
    ListenableFuture<UUID> actualAutoCommitResult = defaultEntitiesVersionControlService.autoCommit(new User(), null);

    // Assert
    verify(tbRepositorySettingsService).get(isNull());
    assertNull(actualAutoCommitResult.get());
    assertTrue(actualAutoCommitResult.isDone());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)} with {@code user}, {@code entityType}, {@code entityIds}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityType, List)"})
  void testAutoCommitWithUserEntityTypeEntityIds() throws Exception {
    // Arrange
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(new RepositorySettings());
    when(tbAutoCommitSettingsService.get(Mockito.<TenantId>any())).thenReturn(new AutoCommitSettings());
    User user = new User();

    // Act
    ListenableFuture<UUID> actualAutoCommitResult = defaultEntitiesVersionControlService.autoCommit(user,
        EntityType.TENANT, new ArrayList<>());

    // Assert
    verify(tbAutoCommitSettingsService).get(isNull());
    verify(tbRepositorySettingsService).get(isNull());
    assertNull(actualAutoCommitResult.get());
    assertTrue(actualAutoCommitResult.isDone());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)} with {@code user}, {@code entityType}, {@code entityIds}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityType, List)"})
  void testAutoCommitWithUserEntityTypeEntityIds2() throws Exception {
    // Arrange
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(new RepositorySettings());
    when(tbAutoCommitSettingsService.get(Mockito.<TenantId>any())).thenThrow(new IllegalArgumentException("foo"));
    User user = new User();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntitiesVersionControlService.autoCommit(user, EntityType.TENANT, new ArrayList<>()));
    verify(tbAutoCommitSettingsService).get(isNull());
    verify(tbRepositorySettingsService).get(isNull());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)} with {@code user}, {@code entityType}, {@code entityIds}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityType, List)"})
  void testAutoCommitWithUserEntityTypeEntityIds3() throws Exception {
    // Arrange
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(null);
    User user = new User();

    // Act
    ListenableFuture<UUID> actualAutoCommitResult = defaultEntitiesVersionControlService.autoCommit(user,
        EntityType.TENANT, new ArrayList<>());

    // Assert
    verify(tbRepositorySettingsService).get(isNull());
    assertNull(actualAutoCommitResult.get());
    assertTrue(actualAutoCommitResult.isDone());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)} with {@code user}, {@code entityType}, {@code entityIds}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityType, List)"})
  void testAutoCommitWithUserEntityTypeEntityIds4() throws Exception {
    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isReadOnly()).thenReturn(true);
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(repositorySettings);
    User user = new User();

    // Act
    ListenableFuture<UUID> actualAutoCommitResult = defaultEntitiesVersionControlService.autoCommit(user,
        EntityType.TENANT, new ArrayList<>());

    // Assert
    verify(repositorySettings).isReadOnly();
    verify(tbRepositorySettingsService).get(isNull());
    assertNull(actualAutoCommitResult.get());
    assertTrue(actualAutoCommitResult.isDone());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)} with {@code user}, {@code entityType}, {@code entityIds}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityType, List)"})
  void testAutoCommitWithUserEntityTypeEntityIds5() throws Exception {
    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isReadOnly()).thenReturn(true);
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(repositorySettings);
    User user = new User();

    ArrayList<UUID> entityIds = new ArrayList<>();
    entityIds.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<UUID> actualAutoCommitResult = defaultEntitiesVersionControlService.autoCommit(user,
        EntityType.TENANT, entityIds);

    // Assert
    verify(repositorySettings).isReadOnly();
    verify(tbRepositorySettingsService).get(isNull());
    assertNull(actualAutoCommitResult.get());
    assertTrue(actualAutoCommitResult.isDone());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)} with {@code user}, {@code entityType}, {@code entityIds}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityType, List)"})
  void testAutoCommitWithUserEntityTypeEntityIds6() throws Exception {
    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isReadOnly()).thenReturn(true);
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(repositorySettings);
    User user = new User();

    ArrayList<UUID> entityIds = new ArrayList<>();
    entityIds.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    entityIds.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<UUID> actualAutoCommitResult = defaultEntitiesVersionControlService.autoCommit(user,
        EntityType.TENANT, entityIds);

    // Assert
    verify(repositorySettings).isReadOnly();
    verify(tbRepositorySettingsService).get(isNull());
    assertNull(actualAutoCommitResult.get());
    assertTrue(actualAutoCommitResult.isDone());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)} with {@code user}, {@code entityType}, {@code entityIds}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityType, List)"})
  void testAutoCommitWithUserEntityTypeEntityIds7() throws Exception {
    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isReadOnly()).thenThrow(new IllegalArgumentException("foo"));
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(repositorySettings);
    User user = new User();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntitiesVersionControlService.autoCommit(user, EntityType.TENANT, new ArrayList<>()));
    verify(repositorySettings).isReadOnly();
    verify(tbRepositorySettingsService).get(isNull());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)} with {@code user}, {@code entityType}, {@code entityIds}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityType, List)"})
  void testAutoCommitWithUserEntityTypeEntityIds8() throws Exception {
    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isReadOnly()).thenReturn(false);
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(repositorySettings);
    AutoVersionCreateConfig autoVersionCreateConfig = mock(AutoVersionCreateConfig.class);
    when(autoVersionCreateConfig.getBranch()).thenReturn("janedoe/featurebranch");
    doNothing().when(autoVersionCreateConfig).setBranch(Mockito.<String>any());
    doNothing().when(autoVersionCreateConfig).setSaveAttributes(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveCredentials(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveRelations(anyBoolean());
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoCommitSettings autoCommitSettings = new AutoCommitSettings();
    autoCommitSettings.put(EntityType.TENANT, autoVersionCreateConfig);
    when(tbAutoCommitSettingsService.get(Mockito.<TenantId>any())).thenReturn(autoCommitSettings);
    SettableFuture<CommitGitRequest> delegate = SettableFuture.create();
    when(gitVersionControlQueueService.prepareCommit(Mockito.<User>any(), Mockito.<VersionCreateRequest>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    User user = new User();

    // Act
    defaultEntitiesVersionControlService.autoCommit(user, EntityType.TENANT, new ArrayList<>());

    // Assert
    verify(repositorySettings).isReadOnly();
    verify(autoVersionCreateConfig).getBranch();
    verify(autoVersionCreateConfig).setBranch(eq("janedoe/featurebranch"));
    verify(autoVersionCreateConfig).setSaveAttributes(eq(true));
    verify(autoVersionCreateConfig).setSaveCredentials(eq(true));
    verify(autoVersionCreateConfig).setSaveRelations(eq(true));
    verify(gitVersionControlQueueService).prepareCommit(isA(User.class), isA(VersionCreateRequest.class));
    verify(tbAutoCommitSettingsService).get(isNull());
    verify(tbRepositorySettingsService).get(isNull());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)} with {@code user}, {@code entityType}, {@code entityIds}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityType, List)"})
  void testAutoCommitWithUserEntityTypeEntityIds9() throws Exception {
    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isReadOnly()).thenReturn(false);
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(repositorySettings);
    AutoVersionCreateConfig autoVersionCreateConfig = mock(AutoVersionCreateConfig.class);
    when(autoVersionCreateConfig.getBranch()).thenThrow(new IllegalArgumentException("auto-commits"));
    doNothing().when(autoVersionCreateConfig).setBranch(Mockito.<String>any());
    doNothing().when(autoVersionCreateConfig).setSaveAttributes(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveCredentials(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveRelations(anyBoolean());
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoCommitSettings autoCommitSettings = new AutoCommitSettings();
    autoCommitSettings.put(EntityType.TENANT, autoVersionCreateConfig);
    when(tbAutoCommitSettingsService.get(Mockito.<TenantId>any())).thenReturn(autoCommitSettings);
    User user = new User();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntitiesVersionControlService.autoCommit(user, EntityType.TENANT, new ArrayList<>()));
    verify(repositorySettings).isReadOnly();
    verify(autoVersionCreateConfig).getBranch();
    verify(autoVersionCreateConfig).setBranch(eq("janedoe/featurebranch"));
    verify(autoVersionCreateConfig).setSaveAttributes(eq(true));
    verify(autoVersionCreateConfig).setSaveCredentials(eq(true));
    verify(autoVersionCreateConfig).setSaveRelations(eq(true));
    verify(tbAutoCommitSettingsService).get(isNull());
    verify(tbRepositorySettingsService).get(isNull());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)} with {@code user}, {@code entityType}, {@code entityIds}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityType, List)"})
  void testAutoCommitWithUserEntityTypeEntityIds10() throws Exception {
    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isReadOnly()).thenReturn(false);
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(repositorySettings);
    AutoVersionCreateConfig autoVersionCreateConfig = mock(AutoVersionCreateConfig.class);
    when(autoVersionCreateConfig.getBranch()).thenReturn("foo");
    doNothing().when(autoVersionCreateConfig).setBranch(Mockito.<String>any());
    doNothing().when(autoVersionCreateConfig).setSaveAttributes(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveCredentials(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveRelations(anyBoolean());
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoCommitSettings autoCommitSettings = new AutoCommitSettings();
    autoCommitSettings.put(EntityType.TENANT, autoVersionCreateConfig);
    when(tbAutoCommitSettingsService.get(Mockito.<TenantId>any())).thenReturn(autoCommitSettings);
    SettableFuture<CommitGitRequest> delegate = SettableFuture.create();
    when(gitVersionControlQueueService.prepareCommit(Mockito.<User>any(), Mockito.<VersionCreateRequest>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    User user = new User();

    // Act
    defaultEntitiesVersionControlService.autoCommit(user, EntityType.TENANT, new ArrayList<>());

    // Assert
    verify(repositorySettings).isReadOnly();
    verify(autoVersionCreateConfig).getBranch();
    verify(autoVersionCreateConfig).setBranch(eq("janedoe/featurebranch"));
    verify(autoVersionCreateConfig).setSaveAttributes(eq(true));
    verify(autoVersionCreateConfig).setSaveCredentials(eq(true));
    verify(autoVersionCreateConfig).setSaveRelations(eq(true));
    verify(gitVersionControlQueueService).prepareCommit(isA(User.class), isA(VersionCreateRequest.class));
    verify(tbAutoCommitSettingsService).get(isNull());
    verify(tbRepositorySettingsService).get(isNull());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)} with {@code user}, {@code entityType}, {@code entityIds}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityType, List)"})
  void testAutoCommitWithUserEntityTypeEntityIds11() throws Exception {
    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.getDefaultBranch()).thenReturn("janedoe/featurebranch");
    when(repositorySettings.isReadOnly()).thenReturn(false);
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(repositorySettings);
    AutoVersionCreateConfig autoVersionCreateConfig = mock(AutoVersionCreateConfig.class);
    when(autoVersionCreateConfig.getBranch()).thenReturn(null);
    doNothing().when(autoVersionCreateConfig).setBranch(Mockito.<String>any());
    doNothing().when(autoVersionCreateConfig).setSaveAttributes(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveCredentials(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveRelations(anyBoolean());
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoCommitSettings autoCommitSettings = new AutoCommitSettings();
    autoCommitSettings.put(EntityType.TENANT, autoVersionCreateConfig);
    when(tbAutoCommitSettingsService.get(Mockito.<TenantId>any())).thenReturn(autoCommitSettings);
    SettableFuture<CommitGitRequest> delegate = SettableFuture.create();
    when(gitVersionControlQueueService.prepareCommit(Mockito.<User>any(), Mockito.<VersionCreateRequest>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    User user = new User();

    // Act
    defaultEntitiesVersionControlService.autoCommit(user, EntityType.TENANT, new ArrayList<>());

    // Assert
    verify(repositorySettings, atLeast(1)).getDefaultBranch();
    verify(repositorySettings).isReadOnly();
    verify(autoVersionCreateConfig).getBranch();
    verify(autoVersionCreateConfig).setBranch(eq("janedoe/featurebranch"));
    verify(autoVersionCreateConfig).setSaveAttributes(eq(true));
    verify(autoVersionCreateConfig).setSaveCredentials(eq(true));
    verify(autoVersionCreateConfig).setSaveRelations(eq(true));
    verify(gitVersionControlQueueService).prepareCommit(isA(User.class), isA(VersionCreateRequest.class));
    verify(tbAutoCommitSettingsService).get(isNull());
    verify(tbRepositorySettingsService).get(isNull());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)} with {@code user}, {@code entityType}, {@code entityIds}.
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityType, List)"})
  void testAutoCommitWithUserEntityTypeEntityIds12() throws Exception {
    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.getDefaultBranch()).thenReturn("janedoe/featurebranch");
    when(repositorySettings.isReadOnly()).thenReturn(false);
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(repositorySettings);
    AutoVersionCreateConfig autoVersionCreateConfig = mock(AutoVersionCreateConfig.class);
    when(autoVersionCreateConfig.getBranch()).thenReturn("");
    doNothing().when(autoVersionCreateConfig).setBranch(Mockito.<String>any());
    doNothing().when(autoVersionCreateConfig).setSaveAttributes(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveCredentials(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveRelations(anyBoolean());
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoCommitSettings autoCommitSettings = new AutoCommitSettings();
    autoCommitSettings.put(EntityType.TENANT, autoVersionCreateConfig);
    when(tbAutoCommitSettingsService.get(Mockito.<TenantId>any())).thenReturn(autoCommitSettings);
    SettableFuture<CommitGitRequest> delegate = SettableFuture.create();
    when(gitVersionControlQueueService.prepareCommit(Mockito.<User>any(), Mockito.<VersionCreateRequest>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    User user = new User();

    // Act
    defaultEntitiesVersionControlService.autoCommit(user, EntityType.TENANT, new ArrayList<>());

    // Assert
    verify(repositorySettings, atLeast(1)).getDefaultBranch();
    verify(repositorySettings).isReadOnly();
    verify(autoVersionCreateConfig).getBranch();
    verify(autoVersionCreateConfig).setBranch(eq("janedoe/featurebranch"));
    verify(autoVersionCreateConfig).setSaveAttributes(eq(true));
    verify(autoVersionCreateConfig).setSaveCredentials(eq(true));
    verify(autoVersionCreateConfig).setSaveRelations(eq(true));
    verify(gitVersionControlQueueService).prepareCommit(isA(User.class), isA(VersionCreateRequest.class));
    verify(tbAutoCommitSettingsService).get(isNull());
    verify(tbRepositorySettingsService).get(isNull());
  }

  /**
   * Test {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)} with {@code user}, {@code entityType}, {@code entityIds}.
   * <ul>
   *   <li>Then calls {@link ListenableFuture#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'; then calls addListener(Runnable, Executor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ListenableFuture DefaultEntitiesVersionControlService.autoCommit(User, EntityType, List)"})
  void testAutoCommitWithUserEntityTypeEntityIds_thenCallsAddListener() throws Exception {
    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isReadOnly()).thenReturn(false);
    when(tbRepositorySettingsService.get(Mockito.<TenantId>any())).thenReturn(repositorySettings);
    AutoVersionCreateConfig autoVersionCreateConfig = mock(AutoVersionCreateConfig.class);
    when(autoVersionCreateConfig.getBranch()).thenReturn("janedoe/featurebranch");
    doNothing().when(autoVersionCreateConfig).setBranch(Mockito.<String>any());
    doNothing().when(autoVersionCreateConfig).setSaveAttributes(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveCredentials(anyBoolean());
    doNothing().when(autoVersionCreateConfig).setSaveRelations(anyBoolean());
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoCommitSettings autoCommitSettings = new AutoCommitSettings();
    autoCommitSettings.put(EntityType.TENANT, autoVersionCreateConfig);
    when(tbAutoCommitSettingsService.get(Mockito.<TenantId>any())).thenReturn(autoCommitSettings);
    ListenableFuture<CommitGitRequest> delegate = mock(ListenableFuture.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(gitVersionControlQueueService.prepareCommit(Mockito.<User>any(), Mockito.<VersionCreateRequest>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    User user = new User();

    // Act
    defaultEntitiesVersionControlService.autoCommit(user, EntityType.TENANT, new ArrayList<>());

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isA(Executor.class));
    verify(repositorySettings).isReadOnly();
    verify(autoVersionCreateConfig).getBranch();
    verify(autoVersionCreateConfig).setBranch(eq("janedoe/featurebranch"));
    verify(autoVersionCreateConfig).setSaveAttributes(eq(true));
    verify(autoVersionCreateConfig).setSaveCredentials(eq(true));
    verify(autoVersionCreateConfig).setSaveRelations(eq(true));
    verify(gitVersionControlQueueService).prepareCommit(isA(User.class), isA(VersionCreateRequest.class));
    verify(tbAutoCommitSettingsService).get(isNull());
    verify(tbRepositorySettingsService).get(isNull());
  }
}
