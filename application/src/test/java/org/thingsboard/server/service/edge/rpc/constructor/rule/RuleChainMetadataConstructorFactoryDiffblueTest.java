package org.thingsboard.server.service.edge.rpc.constructor.rule;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

class RuleChainMetadataConstructorFactoryDiffblueTest {
  /**
   * Test
   * {@link RuleChainMetadataConstructorFactory#getByEdgeVersion(EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_3_0}.</li>
   *   <li>Then return {@link RuleChainMetadataConstructorV330}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainMetadataConstructorFactory#getByEdgeVersion(EdgeVersion)}
   */
  @Test
  @DisplayName("Test getByEdgeVersion(EdgeVersion); when 'V_3_3_0'; then return RuleChainMetadataConstructorV330")
  void testGetByEdgeVersion_whenV330_thenReturnRuleChainMetadataConstructorV330() {
    // Arrange, Act and Assert
    assertTrue(RuleChainMetadataConstructorFactory
        .getByEdgeVersion(EdgeVersion.V_3_3_0) instanceof RuleChainMetadataConstructorV330);
  }

  /**
   * Test
   * {@link RuleChainMetadataConstructorFactory#getByEdgeVersion(EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_3_3}.</li>
   *   <li>Then return {@link RuleChainMetadataConstructorV340}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainMetadataConstructorFactory#getByEdgeVersion(EdgeVersion)}
   */
  @Test
  @DisplayName("Test getByEdgeVersion(EdgeVersion); when 'V_3_3_3'; then return RuleChainMetadataConstructorV340")
  void testGetByEdgeVersion_whenV333_thenReturnRuleChainMetadataConstructorV340() {
    // Arrange, Act and Assert
    assertTrue(RuleChainMetadataConstructorFactory
        .getByEdgeVersion(EdgeVersion.V_3_3_3) instanceof RuleChainMetadataConstructorV340);
  }

  /**
   * Test
   * {@link RuleChainMetadataConstructorFactory#getByEdgeVersion(EdgeVersion)}.
   * <ul>
   *   <li>When {@code V_3_6_2}.</li>
   *   <li>Then return {@link RuleChainMetadataConstructorV362}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainMetadataConstructorFactory#getByEdgeVersion(EdgeVersion)}
   */
  @Test
  @DisplayName("Test getByEdgeVersion(EdgeVersion); when 'V_3_6_2'; then return RuleChainMetadataConstructorV362")
  void testGetByEdgeVersion_whenV362_thenReturnRuleChainMetadataConstructorV362() {
    // Arrange, Act and Assert
    assertTrue(RuleChainMetadataConstructorFactory
        .getByEdgeVersion(EdgeVersion.V_3_6_2) instanceof RuleChainMetadataConstructorV362);
  }
}
