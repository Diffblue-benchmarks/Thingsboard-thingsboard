package org.thingsboard.server.service.edge.instructions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;
import org.thingsboard.server.service.install.InstallScripts;

class DefaultEdgeUpgradeInstructionsServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}.
   * <ul>
   *   <li>When {@code centos}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}
   */
  @Test
  @DisplayName("Test getUpgradeInstructions(String, String); when 'centos'")
  void testGetUpgradeInstructions_whenCentos() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());

    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService = new DefaultEdgeUpgradeInstructionsService(
        attributesService, new InstallScripts());
    defaultEdgeUpgradeInstructionsService.setAppVersion("1.0.2");

    // Act and Assert
    assertEquals("Edge upgrade instruction for 0.2EDGE is not available.",
        defaultEdgeUpgradeInstructionsService.getUpgradeInstructions("1.0.2", "centos").getInstructions());
  }

  /**
   * Test
   * {@link DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}.
   * <ul>
   *   <li>When {@code docker}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}
   */
  @Test
  @DisplayName("Test getUpgradeInstructions(String, String); when 'docker'")
  void testGetUpgradeInstructions_whenDocker() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());

    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService = new DefaultEdgeUpgradeInstructionsService(
        attributesService, new InstallScripts());
    defaultEdgeUpgradeInstructionsService.setAppVersion("1.0.2");

    // Act and Assert
    assertEquals("Edge upgrade instruction for 0.2EDGE is not available.",
        defaultEdgeUpgradeInstructionsService.getUpgradeInstructions("1.0.2", "docker").getInstructions());
  }

  /**
   * Test
   * {@link DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}.
   * <ul>
   *   <li>When {@code Ubuntu}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}
   */
  @Test
  @DisplayName("Test getUpgradeInstructions(String, String); when 'Ubuntu'")
  void testGetUpgradeInstructions_whenUbuntu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());

    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService = new DefaultEdgeUpgradeInstructionsService(
        attributesService, new InstallScripts());
    defaultEdgeUpgradeInstructionsService.setAppVersion("1.0.2");

    // Act and Assert
    assertEquals("Edge upgrade instruction for 0.2EDGE is not available.",
        defaultEdgeUpgradeInstructionsService.getUpgradeInstructions("1.0.2", "Ubuntu").getInstructions());
  }

  /**
   * Test
   * {@link DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}.
   * <ul>
   *   <li>When {@code Upgrade Method}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEdgeUpgradeInstructionsService#getUpgradeInstructions(String, String)}
   */
  @Test
  @DisplayName("Test getUpgradeInstructions(String, String); when 'Upgrade Method'; then throw IllegalArgumentException")
  void testGetUpgradeInstructions_whenUpgradeMethod_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());

    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService = new DefaultEdgeUpgradeInstructionsService(
        attributesService, new InstallScripts());
    defaultEdgeUpgradeInstructionsService.setAppVersion("1.0.2");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEdgeUpgradeInstructionsService.getUpgradeInstructions("1.0.2", "Upgrade Method"));
  }

  /**
   * Test
   * {@link DefaultEdgeUpgradeInstructionsService#isUpgradeAvailable(TenantId, EdgeId)}.
   * <ul>
   *   <li>Given {@link JpaAttributeDao}
   * {@link JpaAttributeDao#find(TenantId, EntityId, AttributeScope, String)}
   * return empty.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEdgeUpgradeInstructionsService#isUpgradeAvailable(TenantId, EdgeId)}
   */
  @Test
  @DisplayName("Test isUpgradeAvailable(TenantId, EdgeId); given JpaAttributeDao find(TenantId, EntityId, AttributeScope, String) return empty; then return 'false'")
  void testIsUpgradeAvailable_givenJpaAttributeDaoFindReturnEmpty_thenReturnFalse() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    Optional<AttributeKvEntry> emptyResult = Optional.empty();
    when(attributesDao.find(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<String>any())).thenReturn(emptyResult);
    BaseAttributesService attributesService = new BaseAttributesService(attributesDao);
    DefaultEdgeUpgradeInstructionsService defaultEdgeUpgradeInstructionsService = new DefaultEdgeUpgradeInstructionsService(
        attributesService, new InstallScripts());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    boolean actualIsUpgradeAvailableResult = defaultEdgeUpgradeInstructionsService.isUpgradeAvailable(tenantId,
        new EdgeId(UUID.randomUUID()));

    // Assert
    verify(attributesDao).find(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.SERVER_SCOPE),
        eq("edgeVersion"));
    assertFalse(actualIsUpgradeAvailableResult);
  }

  /**
   * Test {@link DefaultEdgeUpgradeInstructionsService#getBaseDirName()}.
   * <p>
   * Method under test:
   * {@link DefaultEdgeUpgradeInstructionsService#getBaseDirName()}
   */
  @Test
  @DisplayName("Test getBaseDirName()")
  void testGetBaseDirName() {
    // Arrange
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());

    // Act and Assert
    assertEquals("upgrade",
        (new DefaultEdgeUpgradeInstructionsService(attributesService, new InstallScripts())).getBaseDirName());
  }
}
