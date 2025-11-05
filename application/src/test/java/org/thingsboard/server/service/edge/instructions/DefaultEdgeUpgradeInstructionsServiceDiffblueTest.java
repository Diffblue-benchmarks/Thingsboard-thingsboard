package org.thingsboard.server.service.edge.instructions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.attributes.AttributesService;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;
import org.thingsboard.server.service.install.InstallScripts;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultEdgeUpgradeInstructionsServiceDiffblueTest {
  @Mock private AttributesService attributesService;

  @InjectMocks private DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService;

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link DefaultEdgeUpgradeInstructionsService#isUpgradeAvailable(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEdgeUpgradeInstructionsService#isUpgradeAvailable(TenantId,
   * EdgeId)}
   */
  @Test
  @DisplayName("Test isUpgradeAvailable(TenantId, EdgeId); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultEdgeUpgradeInstructionsService.isUpgradeAvailable(TenantId, EdgeId)"
  })
  void testIsUpgradeAvailable_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    when(attributesService.find(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultEdgeUpgradeInstructionsService.isUpgradeAvailable(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null));
    verify(attributesService)
        .find(
            isA(TenantId.class),
            (EntityId) isNull(),
            eq(AttributeScope.SERVER_SCOPE),
            eq("edgeVersion"));
  }

  /**
   * Test {@link DefaultEdgeUpgradeInstructionsService#getBaseDirName()}.
   *
   * <p>Method under test: {@link DefaultEdgeUpgradeInstructionsService#getBaseDirName()}
   */
  @Test
  @DisplayName("Test getBaseDirName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultEdgeUpgradeInstructionsService.getBaseDirName()"})
  void testGetBaseDirName() {
    // Arrange
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService =
        new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts());

    // Act and Assert
    assertEquals("upgrade", defaultEdgeUpgradeInstructionsService.getBaseDirName());
  }
}
