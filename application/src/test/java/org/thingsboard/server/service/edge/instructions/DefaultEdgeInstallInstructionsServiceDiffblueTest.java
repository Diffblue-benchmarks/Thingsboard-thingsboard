package org.thingsboard.server.service.edge.instructions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.service.install.InstallScripts;

@ExtendWith(MockitoExtension.class)
class DefaultEdgeInstallInstructionsServiceDiffblueTest {
  @InjectMocks
  private DefaultEdgeInstallInstructionsService defaultEdgeInstallInstructionsService;

  /**
   * Test {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge, String, HttpServletRequest)}.
   * <ul>
   *   <li>Then calls {@link InetAddress#getByName(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge, String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getInstallInstructions(Edge, String, HttpServletRequest); then calls getByName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EdgeInstructions DefaultEdgeInstallInstructionsService.getInstallInstructions(Edge, String, HttpServletRequest)"})
  void testGetInstallInstructions_thenCallsGetByName() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.isLoopbackAddress()).thenThrow(new IllegalArgumentException("docker"));
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);
      DefaultEdgeInstallInstructionsService defaultEdgeInstallInstructionsService = new DefaultEdgeInstallInstructionsService(
          new InstallScripts());
      Edge edge = new Edge();

      // Act and Assert
      assertThrows(IllegalArgumentException.class, () -> defaultEdgeInstallInstructionsService
          .getInstallInstructions(edge, "docker", new MockHttpServletRequest()));
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()));
      verify(inetAddress).isLoopbackAddress();
    }
  }

  /**
   * Test {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge, String, HttpServletRequest)}.
   * <ul>
   *   <li>When {@code Installation Method}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEdgeInstallInstructionsService#getInstallInstructions(Edge, String, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getInstallInstructions(Edge, String, HttpServletRequest); when 'Installation Method'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EdgeInstructions DefaultEdgeInstallInstructionsService.getInstallInstructions(Edge, String, HttpServletRequest)"})
  void testGetInstallInstructions_whenInstallationMethod() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultEdgeInstallInstructionsService
        .getInstallInstructions(edge, "Installation Method", new MockHttpServletRequest()));
  }

  /**
   * Test {@link DefaultEdgeInstallInstructionsService#getBaseDirName()}.
   * <p>
   * Method under test: {@link DefaultEdgeInstallInstructionsService#getBaseDirName()}
   */
  @Test
  @DisplayName("Test getBaseDirName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DefaultEdgeInstallInstructionsService.getBaseDirName()"})
  void testGetBaseDirName() {
    // Arrange, Act and Assert
    assertEquals("install", (new DefaultEdgeInstallInstructionsService(new InstallScripts())).getBaseDirName());
  }
}
