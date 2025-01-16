package org.thingsboard.server.service.edge.instructions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.service.install.InstallScripts;

class DefaultEdgeInstallInstructionsServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge, String, HttpServletRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge, String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getInstallInstructions(Edge, String, HttpServletRequest); then throw IllegalArgumentException")
  void testGetInstallInstructions_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEdgeInstallInstructionsService defaultEdgeInstallInstructionsService = new DefaultEdgeInstallInstructionsService(
        new InstallScripts());
    Edge edge = new Edge();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultEdgeInstallInstructionsService
        .getInstallInstructions(edge, "Installation Method", new MockHttpServletRequest()));
  }

  /**
   * Test {@link DefaultEdgeInstallInstructionsService#getBaseDirName()}.
   * <p>
   * Method under test:
   * {@link DefaultEdgeInstallInstructionsService#getBaseDirName()}
   */
  @Test
  @DisplayName("Test getBaseDirName()")
  void testGetBaseDirName() {
    // Arrange, Act and Assert
    assertEquals("install", (new DefaultEdgeInstallInstructionsService(new InstallScripts())).getBaseDirName());
  }
}
