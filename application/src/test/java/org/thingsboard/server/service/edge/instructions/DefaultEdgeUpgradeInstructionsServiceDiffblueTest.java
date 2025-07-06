package org.thingsboard.server.service.edge.instructions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;
import org.thingsboard.server.service.install.InstallScripts;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class DefaultEdgeUpgradeInstructionsServiceDiffblueTest {
  /**
   * Test {@link DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}.
   *
   * <ul>
   *   <li>When {@code centos}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}
   */
  @Test
  @DisplayName("Test getUpgradeInstructions(String, String); when 'centos'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.edge.EdgeInstructions DefaultEdgeUpgradeInstructionsService.getUpgradeInstructions(String, String)"
  })
  void testGetUpgradeInstructions_whenCentos() {
    // Arrange
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());

    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    defaultEdgeUpgradeInstructionsService.setAppVersion("1.0.2");

    // Act and Assert
    assertEquals(
        "Edge upgrade instruction for 0.2EDGE is not available.",
        defaultEdgeUpgradeInstructionsService
            .getUpgradeInstructions("1.0.2", "centos")
            .getInstructions());
  }

  /**
   * Test {@link DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}.
   *
   * <ul>
   *   <li>When {@code docker}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}
   */
  @Test
  @DisplayName("Test getUpgradeInstructions(String, String); when 'docker'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.edge.EdgeInstructions DefaultEdgeUpgradeInstructionsService.getUpgradeInstructions(String, String)"
  })
  void testGetUpgradeInstructions_whenDocker() {
    // Arrange
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());

    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    defaultEdgeUpgradeInstructionsService.setAppVersion("1.0.2");

    // Act and Assert
    assertEquals(
        "Edge upgrade instruction for 0.2EDGE is not available.",
        defaultEdgeUpgradeInstructionsService
            .getUpgradeInstructions("1.0.2", "docker")
            .getInstructions());
  }

  /**
   * Test {@link DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}.
   *
   * <ul>
   *   <li>When {@code Ubuntu}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}
   */
  @Test
  @DisplayName("Test getUpgradeInstructions(String, String); when 'Ubuntu'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.edge.EdgeInstructions DefaultEdgeUpgradeInstructionsService.getUpgradeInstructions(String, String)"
  })
  void testGetUpgradeInstructions_whenUbuntu() {
    // Arrange
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());

    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    defaultEdgeUpgradeInstructionsService.setAppVersion("1.0.2");

    // Act and Assert
    assertEquals(
        "Edge upgrade instruction for 0.2EDGE is not available.",
        defaultEdgeUpgradeInstructionsService
            .getUpgradeInstructions("1.0.2", "Ubuntu")
            .getInstructions());
  }

  /**
   * Test {@link DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}.
   *
   * <ul>
   *   <li>When {@code Upgrade Method}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}
   */
  @Test
  @DisplayName(
      "Test getUpgradeInstructions(String, String); when 'Upgrade Method'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.edge.EdgeInstructions DefaultEdgeUpgradeInstructionsService.getUpgradeInstructions(String, String)"
  })
  void testGetUpgradeInstructions_whenUpgradeMethod_thenThrowIllegalArgumentException() {
    // Arrange
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());

    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());
    defaultEdgeUpgradeInstructionsService.setAppVersion("1.0.2");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultEdgeUpgradeInstructionsService.getUpgradeInstructions(
                "1.0.2", "Upgrade Method"));
  }

  /**
   * Test {@link DefaultEdgeUpgradeInstructionsService#getBaseDirName()}.
   *
   * <p>Method under test: {@link DefaultEdgeUpgradeInstructionsService#getBaseDirName()}
   */
  @Test
  @DisplayName("Test getBaseDirName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DefaultEdgeUpgradeInstructionsService.getBaseDirName()"})
  void testGetBaseDirName() {
    // Arrange
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());

    // Act and Assert
    assertEquals(
        "upgrade",
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts())
            .getBaseDirName());
  }
}
