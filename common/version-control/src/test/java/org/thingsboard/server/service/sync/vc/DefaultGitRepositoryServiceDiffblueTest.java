/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.UUID;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.sync.vc.RepositorySettings;

@ContextConfiguration(classes = {DefaultGitRepositoryService.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set DefaultGitRepositoryService.getActiveRepositoryTenants()"})
  void testGetActiveRepositoryTenants() {
    // Arrange, Act and Assert
    assertTrue(defaultGitRepositoryService.getActiveRepositoryTenants().isEmpty());
  }

  /**
   * Test {@link DefaultGitRepositoryService#prepareCommit(PendingCommit)}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#prepareCommit(PendingCommit)}
   */
  @Test
  @DisplayName(
      "Test prepareCommit(PendingCommit); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultGitRepositoryService.prepareCommit(PendingCommit)"})
  void testPrepareCommit_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    PendingCommit commit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.randomUUID(),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> defaultGitRepositoryService.prepareCommit(commit));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultGitRepositoryService.deleteFolderContent(PendingCommit, String)"})
  void testDeleteFolderContent_thenThrowIllegalStateException() throws IOException {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    PendingCommit commit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.randomUUID(),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> defaultGitRepositoryService.deleteFolderContent(commit, "Relative Path"));
  }

  /**
   * Test {@link DefaultGitRepositoryService#add(PendingCommit, String, String)}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#add(PendingCommit, String, String)}
   */
  @Test
  @DisplayName(
      "Test add(PendingCommit, String, String); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultGitRepositoryService.add(PendingCommit, String, String)"})
  void testAdd_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException() throws IOException {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    PendingCommit commit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.randomUUID(),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> defaultGitRepositoryService.add(commit, "Relative Path", "Entity Data Json"));
  }

  /**
   * Test {@link DefaultGitRepositoryService#push(PendingCommit)}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#push(PendingCommit)}
   */
  @Test
  @DisplayName(
      "Test push(PendingCommit); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.sync.vc.VersionCreationResult DefaultGitRepositoryService.push(PendingCommit)"
  })
  void testPush_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    PendingCommit commit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.randomUUID(),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> defaultGitRepositoryService.push(commit));
  }

  /**
   * Test {@link DefaultGitRepositoryService#cleanUp(PendingCommit)}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#cleanUp(PendingCommit)}
   */
  @Test
  @DisplayName(
      "Test cleanUp(PendingCommit); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultGitRepositoryService.cleanUp(PendingCommit)"})
  void testCleanUp_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    PendingCommit commit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.randomUUID(),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> defaultGitRepositoryService.cleanUp(commit));
  }

  /**
   * Test {@link DefaultGitRepositoryService#abort(PendingCommit)}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#abort(PendingCommit)}
   */
  @Test
  @DisplayName(
      "Test abort(PendingCommit); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultGitRepositoryService.abort(PendingCommit)"})
  void testAbort_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    PendingCommit commit =
        new PendingCommit(
            tenantId,
            "42",
            UUID.randomUUID(),
            "janedoe/featurebranch",
            "1.0.2",
            "JaneDoe",
            "jane.doe@example.org");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> defaultGitRepositoryService.abort(commit));
  }

  /**
   * Test {@link DefaultGitRepositoryService#fetch(TenantId)}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#fetch(TenantId)}
   */
  @Test
  @DisplayName(
      "Test fetch(TenantId); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultGitRepositoryService.fetch(TenantId)"})
  void testFetch_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException()
      throws GitAPIException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> defaultGitRepositoryService.fetch(new TenantId(UUID.randomUUID())));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DefaultGitRepositoryService.getFileContentAtCommit(TenantId, String, String)"
  })
  void testGetFileContentAtCommit_thenThrowIllegalStateException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.getFileContentAtCommit(
                new TenantId(UUID.randomUUID()), "Relative Path", "42"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List DefaultGitRepositoryService.getVersionsDiffList(TenantId, String, String, String)"
  })
  void testGetVersionsDiffList_thenThrowIllegalStateException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.getVersionsDiffList(
                new TenantId(UUID.randomUUID()), "Path", "1.0.2", "1.0.2"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DefaultGitRepositoryService.getContentsDiff(TenantId, String, String)"
  })
  void testGetContentsDiff_thenThrowIllegalStateException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.getContentsDiff(
                new TenantId(UUID.randomUUID()),
                "Not all who wander are lost",
                "Not all who wander are lost"));
  }

  /**
   * Test {@link DefaultGitRepositoryService#listBranches(TenantId)}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#listBranches(TenantId)}
   */
  @Test
  @DisplayName(
      "Test listBranches(TenantId); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List DefaultGitRepositoryService.listBranches(TenantId)"})
  void testListBranches_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> defaultGitRepositoryService.listBranches(new TenantId(UUID.randomUUID())));
  }

  /**
   * Test {@link DefaultGitRepositoryService#listVersions(TenantId, String, String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#listVersions(TenantId, String, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test listVersions(TenantId, String, String, PageLink); when TenantId(UUID) with id is randomUUID; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DefaultGitRepositoryService.listVersions(TenantId, String, String, PageLink)"
  })
  void testListVersions_whenTenantIdWithIdIsRandomUUID_thenThrowIllegalStateException()
      throws Exception {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List DefaultGitRepositoryService.listEntitiesAtVersion(TenantId, String, String)"
  })
  void testListEntitiesAtVersion_thenThrowIllegalStateException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultGitRepositoryService.listEntitiesAtVersion(
                new TenantId(UUID.randomUUID()), "42", "Path"));
  }

  /**
   * Test {@link DefaultGitRepositoryService#initRepository(TenantId, RepositorySettings, boolean)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link TenantId}.
   *   <li>Then calls {@link RepositorySettings#getRepositoryUri()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#initRepository(TenantId,
   * RepositorySettings, boolean)}
   */
  @Test
  @DisplayName(
      "Test initRepository(TenantId, RepositorySettings, boolean); given 'true'; when TenantId; then calls getRepositoryUri()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultGitRepositoryService.initRepository(TenantId, RepositorySettings, boolean)"
  })
  void testInitRepository_givenTrue_whenTenantId_thenCallsGetRepositoryUri() throws Exception {
    // Arrange
    TenantId tenantId = mock(TenantId.class);

    RepositorySettings settings = mock(RepositorySettings.class);
    when(settings.getRepositoryUri()).thenThrow(new RuntimeException());
    when(settings.isLocalOnly()).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> defaultGitRepositoryService.initRepository(tenantId, settings, true));
    verify(settings).getRepositoryUri();
    verify(settings, atLeast(1)).isLocalOnly();
  }

  /**
   * Test {@link DefaultGitRepositoryService#initRepository(TenantId, RepositorySettings, boolean)}.
   *
   * <ul>
   *   <li>When {@link TenantId} {@link TenantId#getId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#initRepository(TenantId,
   * RepositorySettings, boolean)}
   */
  @Test
  @DisplayName(
      "Test initRepository(TenantId, RepositorySettings, boolean); when TenantId getId() throw RuntimeException(); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultGitRepositoryService.initRepository(TenantId, RepositorySettings, boolean)"
  })
  void testInitRepository_whenTenantIdGetIdThrowRuntimeException_thenCallsGetId() throws Exception {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> defaultGitRepositoryService.initRepository(tenantId, new RepositorySettings(), true));
    verify(tenantId).getId();
  }

  /**
   * Test {@link DefaultGitRepositoryService#getRepositorySettings(TenantId)}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGitRepositoryService#getRepositorySettings(TenantId)}
   */
  @Test
  @DisplayName(
      "Test getRepositorySettings(TenantId); when TenantId(UUID) with id is randomUUID; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RepositorySettings DefaultGitRepositoryService.getRepositorySettings(TenantId)"
  })
  void testGetRepositorySettings_whenTenantIdWithIdIsRandomUUID_thenReturnNull() throws Exception {
    // Arrange, Act and Assert
    assertNull(defaultGitRepositoryService.getRepositorySettings(new TenantId(UUID.randomUUID())));
  }
}
