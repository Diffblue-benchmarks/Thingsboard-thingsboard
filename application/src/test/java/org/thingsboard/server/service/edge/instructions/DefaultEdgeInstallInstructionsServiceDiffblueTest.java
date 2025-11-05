package org.thingsboard.server.service.edge.instructions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.service.install.InstallScripts;

@ExtendWith(MockitoExtension.class)
class DefaultEdgeInstallInstructionsServiceDiffblueTest {
  @InjectMocks private DefaultEdgeInstallInstructionsService defaultEdgeInstallInstructionsService;

  @Mock private InstallScripts installScripts;

  /**
   * Test {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge, String,
   * HttpServletRequest)}.
   *
   * <p>Method under test: {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge,
   * String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getInstallInstructions(Edge, String, HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeInstructions DefaultEdgeInstallInstructionsService.getInstallInstructions(Edge, String, HttpServletRequest)"
  })
  void testGetInstallInstructions() {
    // Arrange
    DefaultEdgeInstallInstructionsService defaultEdgeInstallInstructionsService =
        new DefaultEdgeInstallInstructionsService(new InstallScripts());
    Edge edge = new Edge();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultEdgeInstallInstructionsService.getInstallInstructions(
                edge, "Installation Method", new MockHttpServletRequest()));
  }

  /**
   * Test {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge, String,
   * HttpServletRequest)}.
   *
   * <p>Method under test: {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge,
   * String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getInstallInstructions(Edge, String, HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeInstructions DefaultEdgeInstallInstructionsService.getInstallInstructions(Edge, String, HttpServletRequest)"
  })
  void testGetInstallInstructions2() {
    // Arrange
    when(installScripts.getDataDir()).thenThrow(new IllegalArgumentException());
    Edge edge = new Edge();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultEdgeInstallInstructionsService.getInstallInstructions(
                edge, "centos", new MockHttpServletRequest()));
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge, String,
   * HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@code centos}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge,
   * String, HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test getInstallInstructions(Edge, String, HttpServletRequest); when 'centos'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeInstructions DefaultEdgeInstallInstructionsService.getInstallInstructions(Edge, String, HttpServletRequest)"
  })
  void testGetInstallInstructions_whenCentos_thenThrowRuntimeException() {
    // Arrange
    InstallScripts installScripts = mock(InstallScripts.class);
    when(installScripts.getDataDir()).thenReturn("Data Dir");
    DefaultEdgeInstallInstructionsService defaultEdgeInstallInstructionsService =
        new DefaultEdgeInstallInstructionsService(installScripts);
    Edge edge = new Edge();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultEdgeInstallInstructionsService.getInstallInstructions(
                edge, "centos", new MockHttpServletRequest()));
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge, String,
   * HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@code docker}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge,
   * String, HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test getInstallInstructions(Edge, String, HttpServletRequest); when 'docker'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeInstructions DefaultEdgeInstallInstructionsService.getInstallInstructions(Edge, String, HttpServletRequest)"
  })
  void testGetInstallInstructions_whenDocker_thenThrowRuntimeException() {
    // Arrange
    InstallScripts installScripts = mock(InstallScripts.class);
    when(installScripts.getDataDir()).thenReturn("Data Dir");
    DefaultEdgeInstallInstructionsService defaultEdgeInstallInstructionsService =
        new DefaultEdgeInstallInstructionsService(installScripts);
    Edge edge = new Edge();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultEdgeInstallInstructionsService.getInstallInstructions(
                edge, "docker", new MockHttpServletRequest()));
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge, String,
   * HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@code ubuntu}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge,
   * String, HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test getInstallInstructions(Edge, String, HttpServletRequest); when 'ubuntu'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeInstructions DefaultEdgeInstallInstructionsService.getInstallInstructions(Edge, String, HttpServletRequest)"
  })
  void testGetInstallInstructions_whenUbuntu_thenThrowRuntimeException() {
    // Arrange
    InstallScripts installScripts = mock(InstallScripts.class);
    when(installScripts.getDataDir()).thenReturn("Data Dir");
    DefaultEdgeInstallInstructionsService defaultEdgeInstallInstructionsService =
        new DefaultEdgeInstallInstructionsService(installScripts);
    Edge edge = new Edge();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultEdgeInstallInstructionsService.getInstallInstructions(
                edge, "ubuntu", new MockHttpServletRequest()));
    verify(installScripts).getDataDir();
  }

  /**
   * Test {@link DefaultEdgeInstallInstructionsService#getBaseDirName()}.
   *
   * <p>Method under test: {@link DefaultEdgeInstallInstructionsService#getBaseDirName()}
   */
  @Test
  @DisplayName("Test getBaseDirName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultEdgeInstallInstructionsService.getBaseDirName()"})
  void testGetBaseDirName() {
    // Arrange, Act and Assert
    assertEquals(
        "install",
        new DefaultEdgeInstallInstructionsService(new InstallScripts()).getBaseDirName());
  }
}
