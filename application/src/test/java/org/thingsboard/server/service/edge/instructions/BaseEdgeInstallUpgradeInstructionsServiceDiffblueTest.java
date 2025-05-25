package org.thingsboard.server.service.edge.instructions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.nio.file.Path;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.service.install.InstallScripts;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class BaseEdgeInstallUpgradeInstructionsServiceDiffblueTest {
  @Mock
  private InstallScripts installScripts;

  /**
   * Test {@link BaseEdgeInstallUpgradeInstructionsService#getTagVersion(String)}.
   * <ul>
   *   <li>When {@code .0}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeInstallUpgradeInstructionsService#getTagVersion(String)}
   */
  @Test
  @DisplayName("Test getTagVersion(String); when '.0'; then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BaseEdgeInstallUpgradeInstructionsService.getTagVersion(String)"})
  void testGetTagVersion_when0_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new DefaultEdgeInstallInstructionsService(installScripts)).getTagVersion(".0"));
  }

  /**
   * Test {@link BaseEdgeInstallUpgradeInstructionsService#getTagVersion(String)}.
   * <ul>
   *   <li>When {@code 1.0.2}.</li>
   *   <li>Then return {@code 1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeInstallUpgradeInstructionsService#getTagVersion(String)}
   */
  @Test
  @DisplayName("Test getTagVersion(String); when '1.0.2'; then return '1.0.2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BaseEdgeInstallUpgradeInstructionsService.getTagVersion(String)"})
  void testGetTagVersion_when102_thenReturn102() {
    // Arrange, Act and Assert
    assertEquals("1.0.2", (new DefaultEdgeInstallInstructionsService(installScripts)).getTagVersion("1.0.2"));
  }

  /**
   * Test {@link BaseEdgeInstallUpgradeInstructionsService#resolveFile(String, String[])}.
   * <ul>
   *   <li>Then return toFile Name is {@code Sub Dirs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeInstallUpgradeInstructionsService#resolveFile(String, String[])}
   */
  @Test
  @DisplayName("Test resolveFile(String, String[]); then return toFile Name is 'Sub Dirs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Path BaseEdgeInstallUpgradeInstructionsService.resolveFile(String, String[])"})
  void testResolveFile_thenReturnToFileNameIsSubDirs() {
    // Arrange
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
   * Test {@link BaseEdgeInstallUpgradeInstructionsService#resolveFile(String, String[])}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeInstallUpgradeInstructionsService#resolveFile(String, String[])}
   */
  @Test
  @DisplayName("Test resolveFile(String, String[]); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Path BaseEdgeInstallUpgradeInstructionsService.resolveFile(String, String[])"})
  void testResolveFile_thenThrowRuntimeException() {
    // Arrange
    when(installScripts.getDataDir()).thenThrow(new RuntimeException("json"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new DefaultEdgeInstallInstructionsService(installScripts)).resolveFile("Sub Dir", "Sub Dirs"));
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link BaseEdgeInstallUpgradeInstructionsService#getEdgeInstructionsDir()}.
   * <ul>
   *   <li>Then return toFile Name is {@code install}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeInstallUpgradeInstructionsService#getEdgeInstructionsDir()}
   */
  @Test
  @DisplayName("Test getEdgeInstructionsDir(); then return toFile Name is 'install'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Path BaseEdgeInstallUpgradeInstructionsService.getEdgeInstructionsDir()"})
  void testGetEdgeInstructionsDir_thenReturnToFileNameIsInstall() {
    // Arrange
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
   * Test {@link BaseEdgeInstallUpgradeInstructionsService#getEdgeInstructionsDir()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeInstallUpgradeInstructionsService#getEdgeInstructionsDir()}
   */
  @Test
  @DisplayName("Test getEdgeInstructionsDir(); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Path BaseEdgeInstallUpgradeInstructionsService.getEdgeInstructionsDir()"})
  void testGetEdgeInstructionsDir_thenThrowRuntimeException() {
    // Arrange
    when(installScripts.getDataDir()).thenThrow(new RuntimeException("json"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new DefaultEdgeInstallInstructionsService(installScripts)).getEdgeInstructionsDir());
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link BaseEdgeInstallUpgradeInstructionsService#setAppVersion(String)}.
   * <p>
   * Method under test: {@link BaseEdgeInstallUpgradeInstructionsService#setAppVersion(String)}
   */
  @Test
  @DisplayName("Test setAppVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseEdgeInstallUpgradeInstructionsService.setAppVersion(String)"})
  void testSetAppVersion() {
    // Arrange
    DefaultEdgeInstallInstructionsService defaultEdgeInstallInstructionsService = new DefaultEdgeInstallInstructionsService(
        installScripts);

    // Act
    defaultEdgeInstallInstructionsService.setAppVersion("1.0.2");

    // Assert
    assertEquals("1.0.2", defaultEdgeInstallInstructionsService.appVersion);
  }
}
