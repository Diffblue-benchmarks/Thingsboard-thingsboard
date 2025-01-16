package org.thingsboard.server.service.edge.instructions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.File;
import java.nio.file.Path;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.install.InstallScripts;

class BaseEdgeInstallUpgradeInstructionsServiceDiffblueTest {
  /**
   * Test {@link BaseEdgeInstallUpgradeInstructionsService#getTagVersion(String)}.
   * <ul>
   *   <li>Given
   * {@link DefaultEdgeInstallInstructionsService#DefaultEdgeInstallInstructionsService(InstallScripts)}
   * with {@link InstallScripts}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeInstallUpgradeInstructionsService#getTagVersion(String)}
   */
  @Test
  @DisplayName("Test getTagVersion(String); given DefaultEdgeInstallInstructionsService(InstallScripts) with InstallScripts")
  void testGetTagVersion_givenDefaultEdgeInstallInstructionsServiceWithInstallScripts() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("1.0.2",
        (new DefaultEdgeInstallInstructionsService(mock(InstallScripts.class))).getTagVersion("1.0.2"));
  }

  /**
   * Test {@link BaseEdgeInstallUpgradeInstructionsService#getTagVersion(String)}.
   * <ul>
   *   <li>Then return {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeInstallUpgradeInstructionsService#getTagVersion(String)}
   */
  @Test
  @DisplayName("Test getTagVersion(String); then return '1.0.2'")
  void testGetTagVersion_thenReturn102() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("1.0.2", (new DefaultEdgeInstallInstructionsService(new InstallScripts())).getTagVersion("1.0.2"));
  }

  /**
   * Test {@link BaseEdgeInstallUpgradeInstructionsService#getTagVersion(String)}.
   * <ul>
   *   <li>When {@code .0}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeInstallUpgradeInstructionsService#getTagVersion(String)}
   */
  @Test
  @DisplayName("Test getTagVersion(String); when '.0'; then return empty string")
  void testGetTagVersion_when0_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new DefaultEdgeInstallInstructionsService(new InstallScripts())).getTagVersion(".0"));
  }

  /**
   * Test
   * {@link BaseEdgeInstallUpgradeInstructionsService#resolveFile(String, String[])}.
   * <ul>
   *   <li>Then return not toFile Absolute.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeInstallUpgradeInstructionsService#resolveFile(String, String[])}
   */
  @Test
  @DisplayName("Test resolveFile(String, String[]); then return not toFile Absolute")
  void testResolveFile_thenReturnNotToFileAbsolute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InstallScripts installScripts = mock(InstallScripts.class);
    when(installScripts.getDataDir()).thenReturn("Data Dir");

    // Act
    Path actualResolveFileResult = (new DefaultEdgeInstallInstructionsService(installScripts)).resolveFile("Sub Dir",
        "Sub Dirs");

    // Assert
    verify(installScripts).getDataDir();
    File toFileResult = actualResolveFileResult.toFile();
    assertEquals("Sub Dirs", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test
   * {@link BaseEdgeInstallUpgradeInstructionsService#resolveFile(String, String[])}.
   * <ul>
   *   <li>Then return toFile Absolute.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeInstallUpgradeInstructionsService#resolveFile(String, String[])}
   */
  @Test
  @DisplayName("Test resolveFile(String, String[]); then return toFile Absolute")
  void testResolveFile_thenReturnToFileAbsolute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    File toFileResult = (new DefaultEdgeInstallInstructionsService(new InstallScripts()))
        .resolveFile("Sub Dir", "Sub Dirs")
        .toFile();
    assertEquals("Sub Dirs", toFileResult.getName());
    assertTrue(toFileResult.isAbsolute());
  }

  /**
   * Test
   * {@link BaseEdgeInstallUpgradeInstructionsService#getEdgeInstructionsDir()}.
   * <ul>
   *   <li>Then return not toFile Absolute.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeInstallUpgradeInstructionsService#getEdgeInstructionsDir()}
   */
  @Test
  @DisplayName("Test getEdgeInstructionsDir(); then return not toFile Absolute")
  void testGetEdgeInstructionsDir_thenReturnNotToFileAbsolute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InstallScripts installScripts = mock(InstallScripts.class);
    when(installScripts.getDataDir()).thenReturn("Data Dir");

    // Act
    Path actualEdgeInstructionsDir = (new DefaultEdgeInstallInstructionsService(installScripts))
        .getEdgeInstructionsDir();

    // Assert
    verify(installScripts).getDataDir();
    File toFileResult = actualEdgeInstructionsDir.toFile();
    assertEquals("install", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test
   * {@link BaseEdgeInstallUpgradeInstructionsService#getEdgeInstructionsDir()}.
   * <ul>
   *   <li>Then return toFile Absolute.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeInstallUpgradeInstructionsService#getEdgeInstructionsDir()}
   */
  @Test
  @DisplayName("Test getEdgeInstructionsDir(); then return toFile Absolute")
  void testGetEdgeInstructionsDir_thenReturnToFileAbsolute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    File toFileResult = (new DefaultEdgeInstallInstructionsService(new InstallScripts())).getEdgeInstructionsDir()
        .toFile();
    assertEquals("install", toFileResult.getName());
    assertTrue(toFileResult.isAbsolute());
  }

  /**
   * Test {@link BaseEdgeInstallUpgradeInstructionsService#setAppVersion(String)}.
   * <p>
   * Method under test:
   * {@link BaseEdgeInstallUpgradeInstructionsService#setAppVersion(String)}
   */
  @Test
  @DisplayName("Test setAppVersion(String)")
  void testSetAppVersion() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEdgeInstallInstructionsService defaultEdgeInstallInstructionsService = new DefaultEdgeInstallInstructionsService(
        new InstallScripts());

    // Act
    defaultEdgeInstallInstructionsService.setAppVersion("1.0.2");

    // Assert
    assertEquals("1.0.2", defaultEdgeInstallInstructionsService.appVersion);
  }

  /**
   * Test {@link BaseEdgeInstallUpgradeInstructionsService#setAppVersion(String)}.
   * <p>
   * Method under test:
   * {@link BaseEdgeInstallUpgradeInstructionsService#setAppVersion(String)}
   */
  @Test
  @DisplayName("Test setAppVersion(String)")
  void testSetAppVersion2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEdgeInstallInstructionsService defaultEdgeInstallInstructionsService = new DefaultEdgeInstallInstructionsService(
        mock(InstallScripts.class));

    // Act
    defaultEdgeInstallInstructionsService.setAppVersion("1.0.2");

    // Assert
    assertEquals("1.0.2", defaultEdgeInstallInstructionsService.appVersion);
  }
}
