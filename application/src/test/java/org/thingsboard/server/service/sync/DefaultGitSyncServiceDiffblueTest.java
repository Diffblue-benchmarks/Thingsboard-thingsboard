package org.thingsboard.server.service.sync;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.sync.vc.GitRepository;
import org.thingsboard.server.service.sync.vc.GitRepository.FileType;

class DefaultGitSyncServiceDiffblueTest {
  /**
   * Test {@link DefaultGitSyncService#listFiles(String, String, int, FileType)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultGitSyncService#listFiles(String, String, int, GitRepository.FileType)}
   */
  @Test
  @DisplayName("Test listFiles(String, String, int, FileType); when 'Key'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List DefaultGitSyncService.listFiles(String, String, int, GitRepository.FileType)"})
  void testListFiles_whenKey_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new DefaultGitSyncService()).listFiles("Key", "Path", 2, FileType.FILE));
  }

  /**
   * Test {@link DefaultGitSyncService#getFileContent(String, String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultGitSyncService#getFileContent(String, String)}
   */
  @Test
  @DisplayName("Test getFileContent(String, String); when 'Key'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DefaultGitSyncService.getFileContent(String, String)"})
  void testGetFileContent_whenKey_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new DefaultGitSyncService()).getFileContent("Key", "Path"));
  }

  /**
   * Test {@link DefaultGitSyncService#getGithubRawContentUrl(String, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultGitSyncService#getGithubRawContentUrl(String, String)}
   */
  @Test
  @DisplayName("Test getGithubRawContentUrl(String, String); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DefaultGitSyncService.getGithubRawContentUrl(String, String)"})
  void testGetGithubRawContentUrl_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new DefaultGitSyncService())
        .getGithubRawContentUrl("https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link DefaultGitSyncService#getGithubRawContentUrl(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultGitSyncService#getGithubRawContentUrl(String, String)}
   */
  @Test
  @DisplayName("Test getGithubRawContentUrl(String, String); when 'null'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DefaultGitSyncService.getGithubRawContentUrl(String, String)"})
  void testGetGithubRawContentUrl_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new DefaultGitSyncService()).getGithubRawContentUrl("https://example.org/example", null));
  }
}
