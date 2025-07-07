package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.UUID;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.sync.vc.RepositoryAuthMethod;
import org.thingsboard.server.common.data.sync.vc.RepositorySettings;

@ContextConfiguration(classes = {DefaultGitRepositoryService.class})
@ExtendWith(SpringExtension.class)
class DefaultGitRepositoryServiceDiffblueTest {
  @Autowired private DefaultGitRepositoryService defaultGitRepositoryService;

  /**
   * Test {@link DefaultGitRepositoryService#getActiveRepositoryTenants()}.
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#getActiveRepositoryTenants()}
   */
  @Test
  @DisplayName("Test getActiveRepositoryTenants()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set DefaultGitRepositoryService.getActiveRepositoryTenants()"})
  void testGetActiveRepositoryTenants() {
    // Arrange, Act and Assert
    assertTrue(defaultGitRepositoryService.getActiveRepositoryTenants().isEmpty());
  }

  /**
   * Test {@link DefaultGitRepositoryService#prepareCommit(PendingCommit)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#prepareCommit(PendingCommit)}
   */
  @Test
  @DisplayName("Test prepareCommit(PendingCommit); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultGitRepositoryService.prepareCommit(PendingCommit)"})
  void testPrepareCommit_thenThrowIllegalStateException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.prepareCommit(
                new PendingCommit(
                    tenantId,
                    "42",
                    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                    "janedoe/featurebranch",
                    "1.0.2",
                    "JaneDoe",
                    "jane.doe@example.org")));
  }

  /**
   * Test {@link DefaultGitRepositoryService#deleteFolderContent(PendingCommit, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#deleteFolderContent(PendingCommit,
   * String)}
   */
  @Test
  @DisplayName("Test deleteFolderContent(PendingCommit, String); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultGitRepositoryService.deleteFolderContent(PendingCommit, String)"})
  void testDeleteFolderContent_thenThrowIllegalStateException() throws IOException {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.deleteFolderContent(
                new PendingCommit(
                    tenantId,
                    "42",
                    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                    "janedoe/featurebranch",
                    "1.0.2",
                    "JaneDoe",
                    "jane.doe@example.org"),
                "Relative Path"));
  }

  /**
   * Test {@link DefaultGitRepositoryService#add(PendingCommit, String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#add(PendingCommit, String, String)}
   */
  @Test
  @DisplayName("Test add(PendingCommit, String, String); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultGitRepositoryService.add(PendingCommit, String, String)"})
  void testAdd_thenThrowIllegalStateException() throws IOException {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.add(
                new PendingCommit(
                    tenantId,
                    "42",
                    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                    "janedoe/featurebranch",
                    "1.0.2",
                    "JaneDoe",
                    "jane.doe@example.org"),
                "Relative Path",
                "Entity Data Json"));
  }

  /**
   * Test {@link DefaultGitRepositoryService#push(PendingCommit)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#push(PendingCommit)}
   */
  @Test
  @DisplayName("Test push(PendingCommit); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.sync.vc.VersionCreationResult DefaultGitRepositoryService.push(PendingCommit)"
  })
  void testPush_thenThrowIllegalStateException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.push(
                new PendingCommit(
                    tenantId,
                    "42",
                    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                    "janedoe/featurebranch",
                    "1.0.2",
                    "JaneDoe",
                    "jane.doe@example.org")));
  }

  /**
   * Test {@link DefaultGitRepositoryService#cleanUp(PendingCommit)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#cleanUp(PendingCommit)}
   */
  @Test
  @DisplayName("Test cleanUp(PendingCommit); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultGitRepositoryService.cleanUp(PendingCommit)"})
  void testCleanUp_thenThrowIllegalStateException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.cleanUp(
                new PendingCommit(
                    tenantId,
                    "42",
                    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                    "janedoe/featurebranch",
                    "1.0.2",
                    "JaneDoe",
                    "jane.doe@example.org")));
  }

  /**
   * Test {@link DefaultGitRepositoryService#abort(PendingCommit)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#abort(PendingCommit)}
   */
  @Test
  @DisplayName("Test abort(PendingCommit); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultGitRepositoryService.abort(PendingCommit)"})
  void testAbort_thenThrowIllegalStateException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.abort(
                new PendingCommit(
                    tenantId,
                    "42",
                    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                    "janedoe/featurebranch",
                    "1.0.2",
                    "JaneDoe",
                    "jane.doe@example.org")));
  }

  /**
   * Test {@link DefaultGitRepositoryService#fetch(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#fetch(TenantId)}
   */
  @Test
  @DisplayName("Test fetch(TenantId); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultGitRepositoryService.fetch(TenantId)"})
  void testFetch_thenThrowIllegalStateException() throws GitAPIException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.fetch(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link DefaultGitRepositoryService#getFileContentAtCommit(TenantId, String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#getFileContentAtCommit(TenantId,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getFileContentAtCommit(TenantId, String, String); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "String DefaultGitRepositoryService.getFileContentAtCommit(TenantId, String, String)"
  })
  void testGetFileContentAtCommit_thenThrowIllegalStateException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.getFileContentAtCommit(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                "Relative Path",
                "42"));
  }

  /**
   * Test {@link DefaultGitRepositoryService#getVersionsDiffList(TenantId, String, String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#getVersionsDiffList(TenantId, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getVersionsDiffList(TenantId, String, String, String); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List DefaultGitRepositoryService.getVersionsDiffList(TenantId, String, String, String)"
  })
  void testGetVersionsDiffList_thenThrowIllegalStateException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.getVersionsDiffList(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                "Path",
                "1.0.2",
                "1.0.2"));
  }

  /**
   * Test {@link DefaultGitRepositoryService#getContentsDiff(TenantId, String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#getContentsDiff(TenantId, String,
   * String)}
   */
  @Test
  @DisplayName("Test getContentsDiff(TenantId, String, String); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "String DefaultGitRepositoryService.getContentsDiff(TenantId, String, String)"
  })
  void testGetContentsDiff_thenThrowIllegalStateException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.getContentsDiff(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                "Not all who wander are lost",
                "Not all who wander are lost"));
  }

  /**
   * Test {@link DefaultGitRepositoryService#listBranches(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#listBranches(TenantId)}
   */
  @Test
  @DisplayName("Test listBranches(TenantId); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List DefaultGitRepositoryService.listBranches(TenantId)"})
  void testListBranches_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.listBranches(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link DefaultGitRepositoryService#listVersions(TenantId, String, String, PageLink)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#listVersions(TenantId, String, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test listVersions(TenantId, String, String, PageLink); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DefaultGitRepositoryService.listVersions(TenantId, String, String, PageLink)"
  })
  void testListVersions_thenThrowIllegalStateException() throws Exception {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.listVersions(
                tenantId, "janedoe/featurebranch", "Path", new PageLink(3)));
  }

  /**
   * Test {@link DefaultGitRepositoryService#listEntitiesAtVersion(TenantId, String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#listEntitiesAtVersion(TenantId,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test listEntitiesAtVersion(TenantId, String, String); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List DefaultGitRepositoryService.listEntitiesAtVersion(TenantId, String, String)"
  })
  void testListEntitiesAtVersion_thenThrowIllegalStateException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.listEntitiesAtVersion(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                "42",
                "Path"));
  }

  /**
   * Test {@link DefaultGitRepositoryService#testRepository(TenantId, RepositorySettings)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link RepositorySettings} {@link RepositorySettings#getRepositoryUri()} return
   *       {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#testRepository(TenantId,
   * RepositorySettings)}
   */
  @Test
  @DisplayName(
      "Test testRepository(TenantId, RepositorySettings); given 'foo'; when RepositorySettings getRepositoryUri() return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultGitRepositoryService.testRepository(TenantId, RepositorySettings)"
  })
  void testTestRepository_givenFoo_whenRepositorySettingsGetRepositoryUriReturnFoo()
      throws Exception {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.getPrivateKey()).thenThrow(new RuntimeException("stale Ufile Uhandle"));
    when(settings.isLocalOnly()).thenReturn(false);
    when(settings.getRepositoryUri()).thenReturn("foo");
    when(settings.getAuthMethod()).thenReturn(RepositoryAuthMethod.PRIVATE_KEY);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> defaultGitRepositoryService.testRepository(tenantId, settings));
    verify(settings, atLeast(1)).getAuthMethod();
    verify(settings).getPrivateKey();
    verify(settings, atLeast(1)).getRepositoryUri();
    verify(settings, atLeast(1)).isLocalOnly();
  }

  /**
   * Test {@link DefaultGitRepositoryService#testRepository(TenantId, RepositorySettings)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link RepositorySettings} {@link RepositorySettings#isLocalOnly()} return {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#testRepository(TenantId,
   * RepositorySettings)}
   */
  @Test
  @DisplayName(
      "Test testRepository(TenantId, RepositorySettings); given 'true'; when RepositorySettings isLocalOnly() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultGitRepositoryService.testRepository(TenantId, RepositorySettings)"
  })
  void testTestRepository_givenTrue_whenRepositorySettingsIsLocalOnlyReturnTrue() throws Exception {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.isLocalOnly()).thenReturn(true);

    // Act
    defaultGitRepositoryService.testRepository(tenantId, settings);

    // Assert
    verify(settings).isLocalOnly();
  }

  /**
   * Test {@link DefaultGitRepositoryService#testRepository(TenantId, RepositorySettings)}.
   *
   * <ul>
   *   <li>Then calls {@link RepositorySettings#getPrivateKey()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#testRepository(TenantId,
   * RepositorySettings)}
   */
  @Test
  @DisplayName("Test testRepository(TenantId, RepositorySettings); then calls getPrivateKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultGitRepositoryService.testRepository(TenantId, RepositorySettings)"
  })
  void testTestRepository_thenCallsGetPrivateKey() throws Exception {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.getPrivateKey()).thenThrow(new RuntimeException("stale Ufile Uhandle"));
    when(settings.isLocalOnly()).thenReturn(false);
    when(settings.getRepositoryUri()).thenReturn("Repository Uri");
    when(settings.getAuthMethod()).thenReturn(RepositoryAuthMethod.PRIVATE_KEY);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> defaultGitRepositoryService.testRepository(tenantId, settings));
    verify(settings, atLeast(1)).getAuthMethod();
    verify(settings).getPrivateKey();
    verify(settings, atLeast(1)).getRepositoryUri();
    verify(settings, atLeast(1)).isLocalOnly();
  }

  /**
   * Test {@link DefaultGitRepositoryService#testRepository(TenantId, RepositorySettings)}.
   *
   * <ul>
   *   <li>Then calls {@link RepositorySettings#getUsername()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#testRepository(TenantId,
   * RepositorySettings)}
   */
  @Test
  @DisplayName("Test testRepository(TenantId, RepositorySettings); then calls getUsername()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultGitRepositoryService.testRepository(TenantId, RepositorySettings)"
  })
  void testTestRepository_thenCallsGetUsername() throws Exception {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.getUsername()).thenThrow(new RuntimeException("stale Ufile Uhandle"));
    when(settings.isLocalOnly()).thenReturn(false);
    when(settings.getRepositoryUri()).thenReturn("Repository Uri");
    when(settings.getAuthMethod()).thenReturn(RepositoryAuthMethod.USERNAME_PASSWORD);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> defaultGitRepositoryService.testRepository(tenantId, settings));
    verify(settings).getAuthMethod();
    verify(settings).getRepositoryUri();
    verify(settings).getUsername();
    verify(settings, atLeast(1)).isLocalOnly();
  }

  /**
   * Test {@link DefaultGitRepositoryService#initRepository(TenantId, RepositorySettings, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#initRepository(TenantId,
   * RepositorySettings, boolean)}
   */
  @Test
  @DisplayName(
      "Test initRepository(TenantId, RepositorySettings, boolean); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultGitRepositoryService.initRepository(TenantId, RepositorySettings, boolean)"
  })
  void testInitRepository_thenThrowRuntimeException() throws Exception {
    // Arrange
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.getRepositoryUri()).thenThrow(new RuntimeException("stale Ufile Uhandle"));
    when(settings.isLocalOnly()).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> defaultGitRepositoryService.initRepository(null, settings, true));
    verify(settings).getRepositoryUri();
    verify(settings, atLeast(1)).isLocalOnly();
  }

  /**
   * Test {@link DefaultGitRepositoryService#getRepositorySettings(TenantId)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#getRepositorySettings(TenantId)}
   */
  @Test
  @DisplayName("Test getRepositorySettings(TenantId); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "RepositorySettings DefaultGitRepositoryService.getRepositorySettings(TenantId)"
  })
  void testGetRepositorySettings_thenReturnNull() throws Exception {
    // Arrange, Act and Assert
    assertNull(
        defaultGitRepositoryService.getRepositorySettings(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }
}
