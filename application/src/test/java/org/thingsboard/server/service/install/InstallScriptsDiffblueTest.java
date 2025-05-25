package org.thingsboard.server.service.install;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InstallScriptsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InstallScripts#setUpdateImages(boolean)}
   *   <li>{@link InstallScripts#isUpdateImages()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean InstallScripts.isUpdateImages()", "void InstallScripts.setUpdateImages(boolean)"})
  void testGettersAndSetters() {
    // Arrange
    InstallScripts installScripts = new InstallScripts();

    // Act
    installScripts.setUpdateImages(true);

    // Assert
    assertTrue(installScripts.isUpdateImages());
  }
}
