package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.UUID;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.jupiter.api.DisplayName;
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
  @Autowired
  private DefaultGitRepositoryService defaultGitRepositoryService;

  /**
   * Test {@link DefaultGitRepositoryService#getActiveRepositoryTenants()}.
   * <p>
   * Method under test:
   * {@link DefaultGitRepositoryService#getActiveRepositoryTenants()}
   */
  @Test
  @DisplayName("Test getActiveRepositoryTenants()")
  void testGetActiveRepositoryTenants() {
    // Arrange, Act and Assert
    assertTrue(defaultGitRepositoryService.getActiveRepositoryTenants().isEmpty());
  }

  /**
   * Test {@link DefaultGitRepositoryService#prepareCommit(PendingCommit)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitRepositoryService#prepareCommit(PendingCommit)}
   */
  @Test
  @DisplayName("Test prepareCommit(PendingCommit); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  void testPrepareCommit_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> defaultGitRepositoryService.prepareCommit(new PendingCommit(tenantId, "42", UUID.randomUUID(),
            "janedoe/featurebranch", "1.0.2", "JaneDoe", "jane.doe@example.org")));
  }

  /**
   * Test
   * {@link DefaultGitRepositoryService#deleteFolderContent(PendingCommit, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitRepositoryService#deleteFolderContent(PendingCommit, String)}
   */
  @Test
  @DisplayName("Test deleteFolderContent(PendingCommit, String); then throw IllegalStateException")
  void testDeleteFolderContent_thenThrowIllegalStateException() throws IOException {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> defaultGitRepositoryService.deleteFolderContent(new PendingCommit(tenantId, "42", UUID.randomUUID(),
            "janedoe/featurebranch", "1.0.2", "JaneDoe", "jane.doe@example.org"), "Relative Path"));
  }

  /**
   * Test {@link DefaultGitRepositoryService#add(PendingCommit, String, String)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitRepositoryService#add(PendingCommit, String, String)}
   */
  @Test
  @DisplayName("Test add(PendingCommit, String, String); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  void testAdd_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException() throws IOException {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> defaultGitRepositoryService.add(new PendingCommit(tenantId, "42", UUID.randomUUID(),
            "janedoe/featurebranch", "1.0.2", "JaneDoe", "jane.doe@example.org"), "Relative Path", "Entity Data Json"));
  }

  /**
   * Test {@link DefaultGitRepositoryService#push(PendingCommit)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultGitRepositoryService#push(PendingCommit)}
   */
  @Test
  @DisplayName("Test push(PendingCommit); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  void testPush_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> defaultGitRepositoryService.push(new PendingCommit(tenantId, "42",
        UUID.randomUUID(), "janedoe/featurebranch", "1.0.2", "JaneDoe", "jane.doe@example.org")));
  }

  /**
   * Test {@link DefaultGitRepositoryService#cleanUp(PendingCommit)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultGitRepositoryService#cleanUp(PendingCommit)}
   */
  @Test
  @DisplayName("Test cleanUp(PendingCommit); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  void testCleanUp_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> defaultGitRepositoryService.cleanUp(new PendingCommit(tenantId,
        "42", UUID.randomUUID(), "janedoe/featurebranch", "1.0.2", "JaneDoe", "jane.doe@example.org")));
  }

  /**
   * Test {@link DefaultGitRepositoryService#abort(PendingCommit)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultGitRepositoryService#abort(PendingCommit)}
   */
  @Test
  @DisplayName("Test abort(PendingCommit); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  void testAbort_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> defaultGitRepositoryService.abort(new PendingCommit(tenantId, "42",
        UUID.randomUUID(), "janedoe/featurebranch", "1.0.2", "JaneDoe", "jane.doe@example.org")));
  }

  /**
   * Test {@link DefaultGitRepositoryService#fetch(TenantId)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultGitRepositoryService#fetch(TenantId)}
   */
  @Test
  @DisplayName("Test fetch(TenantId); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  void testFetch_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException() throws GitAPIException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> defaultGitRepositoryService.fetch(new TenantId(UUID.randomUUID())));
  }

  /**
   * Test
   * {@link DefaultGitRepositoryService#getFileContentAtCommit(TenantId, String, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitRepositoryService#getFileContentAtCommit(TenantId, String, String)}
   */
  @Test
  @DisplayName("Test getFileContentAtCommit(TenantId, String, String); then throw IllegalStateException")
  void testGetFileContentAtCommit_thenThrowIllegalStateException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> defaultGitRepositoryService
        .getFileContentAtCommit(new TenantId(UUID.randomUUID()), "Relative Path", "42"));
  }

  /**
   * Test
   * {@link DefaultGitRepositoryService#getVersionsDiffList(TenantId, String, String, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitRepositoryService#getVersionsDiffList(TenantId, String, String, String)}
   */
  @Test
  @DisplayName("Test getVersionsDiffList(TenantId, String, String, String); then throw IllegalStateException")
  void testGetVersionsDiffList_thenThrowIllegalStateException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> defaultGitRepositoryService
        .getVersionsDiffList(new TenantId(UUID.randomUUID()), "Path", "1.0.2", "1.0.2"));
  }

  /**
   * Test
   * {@link DefaultGitRepositoryService#getContentsDiff(TenantId, String, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitRepositoryService#getContentsDiff(TenantId, String, String)}
   */
  @Test
  @DisplayName("Test getContentsDiff(TenantId, String, String); then throw IllegalStateException")
  void testGetContentsDiff_thenThrowIllegalStateException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> defaultGitRepositoryService.getContentsDiff(new TenantId(UUID.randomUUID()),
            "Not all who wander are lost", "Not all who wander are lost"));
  }

  /**
   * Test {@link DefaultGitRepositoryService#listBranches(TenantId)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultGitRepositoryService#listBranches(TenantId)}
   */
  @Test
  @DisplayName("Test listBranches(TenantId); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  void testListBranches_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> defaultGitRepositoryService.listBranches(new TenantId(UUID.randomUUID())));
  }

  /**
   * Test
   * {@link DefaultGitRepositoryService#listVersions(TenantId, String, String, PageLink)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitRepositoryService#listVersions(TenantId, String, String, PageLink)}
   */
  @Test
  @DisplayName("Test listVersions(TenantId, String, String, PageLink); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  void testListVersions_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException() throws Exception {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> defaultGitRepositoryService.listVersions(tenantId, "janedoe/featurebranch", "Path", new PageLink(3)));
  }

  /**
   * Test
   * {@link DefaultGitRepositoryService#listEntitiesAtVersion(TenantId, String, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitRepositoryService#listEntitiesAtVersion(TenantId, String, String)}
   */
  @Test
  @DisplayName("Test listEntitiesAtVersion(TenantId, String, String); then throw IllegalStateException")
  void testListEntitiesAtVersion_thenThrowIllegalStateException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> defaultGitRepositoryService.listEntitiesAtVersion(new TenantId(UUID.randomUUID()), "42", "Path"));
  }

  /**
   * Test
   * {@link DefaultGitRepositoryService#testRepository(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitRepositoryService#testRepository(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test testRepository(TenantId, RepositorySettings); then throw IllegalStateException")
  void testTestRepository_thenThrowIllegalStateException() throws Exception {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.getPrivateKey()).thenThrow(new IllegalStateException("file:/U:U/U/U/"));
    when(settings.isLocalOnly()).thenReturn(false);
    when(settings.getRepositoryUri()).thenReturn("Repository Uri");
    when(settings.getAuthMethod()).thenReturn(RepositoryAuthMethod.PRIVATE_KEY);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> defaultGitRepositoryService.testRepository(tenantId, settings));
    verify(settings, atLeast(1)).getAuthMethod();
    verify(settings).getPrivateKey();
    verify(settings, atLeast(1)).getRepositoryUri();
    verify(settings, atLeast(1)).isLocalOnly();
  }

  /**
   * Test
   * {@link DefaultGitRepositoryService#testRepository(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>When {@link RepositorySettings} {@link RepositorySettings#isLocalOnly()}
   * return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitRepositoryService#testRepository(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test testRepository(TenantId, RepositorySettings); when RepositorySettings isLocalOnly() return 'true'")
  void testTestRepository_whenRepositorySettingsIsLocalOnlyReturnTrue() throws Exception {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.isLocalOnly()).thenReturn(true);

    // Act
    defaultGitRepositoryService.testRepository(tenantId, settings);

    // Assert
    verify(settings).isLocalOnly();
  }

  /**
   * Test
   * {@link DefaultGitRepositoryService#initRepository(TenantId, RepositorySettings, boolean)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitRepositoryService#initRepository(TenantId, RepositorySettings, boolean)}
   */
  @Test
  @DisplayName("Test initRepository(TenantId, RepositorySettings, boolean); then throw RuntimeException")
  void testInitRepository_thenThrowRuntimeException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultGitRepositoryService defaultGitRepositoryService = new DefaultGitRepositoryService();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.getRepositoryUri()).thenThrow(new RuntimeException("[{}] Init tenant repository started."));
    when(settings.isLocalOnly()).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitRepositoryService.initRepository(tenantId, settings, true));
    verify(settings).getRepositoryUri();
    verify(settings, atLeast(1)).isLocalOnly();
  }

  /**
   * Test {@link DefaultGitRepositoryService#getRepositorySettings(TenantId)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitRepositoryService#getRepositorySettings(TenantId)}
   */
  @Test
  @DisplayName("Test getRepositorySettings(TenantId); when TenantId(UUID) with id is randomUUID; then return 'null'")
  void testGetRepositorySettings_whenTenantIdWithIdIsRandomUUID_thenReturnNull() throws Exception {
    // Arrange, Act and Assert
    assertNull(defaultGitRepositoryService.getRepositorySettings(new TenantId(UUID.randomUUID())));
  }
}
