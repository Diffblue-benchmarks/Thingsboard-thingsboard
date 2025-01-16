package org.thingsboard.server.service.sync;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.sync.vc.GitRepository;

class DefaultGitSyncServiceDiffblueTest {
  /**
   * Test {@link DefaultGitSyncService#listFiles(String, String, int, FileType)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitSyncService#listFiles(String, String, int, GitRepository.FileType)}
   */
  @Test
  @DisplayName("Test listFiles(String, String, int, FileType); when 'Key'; then throw IllegalStateException")
  void testListFiles_whenKey_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new DefaultGitSyncService()).listFiles("Key", "Path", 2, GitRepository.FileType.FILE));
  }

  /**
   * Test {@link DefaultGitSyncService#getFileContent(String, String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitSyncService#getFileContent(String, String)}
   */
  @Test
  @DisplayName("Test getFileContent(String, String); when 'Key'; then throw IllegalStateException")
  void testGetFileContent_whenKey_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new DefaultGitSyncService()).getFileContent("Key", "Path"));
  }

  /**
   * Test {@link DefaultGitSyncService#getGithubRawContentUrl(String, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitSyncService#getGithubRawContentUrl(String, String)}
   */
  @Test
  @DisplayName("Test getGithubRawContentUrl(String, String); then throw IllegalStateException")
  void testGetGithubRawContentUrl_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link DefaultGitSyncService#getGithubRawContentUrl(String, String)}
   */
  @Test
  @DisplayName("Test getGithubRawContentUrl(String, String); when 'null'; then return empty string")
  void testGetGithubRawContentUrl_whenNull_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new DefaultGitSyncService()).getGithubRawContentUrl("https://example.org/example", null));
  }
}
