package org.thingsboard.server.service.component;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.plugin.ComponentType;
import org.thingsboard.server.common.data.rule.RuleChainType;

class AnnotationComponentDiscoveryServiceDiffblueTest {
  /**
   * Test {@link AnnotationComponentDiscoveryService#getRuleNodeInfo(String)}.
   * <p>
   * Method under test:
   * {@link AnnotationComponentDiscoveryService#getRuleNodeInfo(String)}
   */
  @Test
  @DisplayName("Test getRuleNodeInfo(String)")
  void testGetRuleNodeInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new AnnotationComponentDiscoveryService()).getRuleNodeInfo("Clazz").isPresent());
  }

  /**
   * Test {@link AnnotationComponentDiscoveryService#getVersionedNodes()}.
   * <p>
   * Method under test:
   * {@link AnnotationComponentDiscoveryService#getVersionedNodes()}
   */
  @Test
  @DisplayName("Test getVersionedNodes()")
  void testGetVersionedNodes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new AnnotationComponentDiscoveryService()).getVersionedNodes().isEmpty());
  }

  /**
   * Test
   * {@link AnnotationComponentDiscoveryService#getComponents(ComponentType, RuleChainType)}
   * with {@code type}, {@code ruleChainType}.
   * <ul>
   *   <li>When {@code CORE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AnnotationComponentDiscoveryService#getComponents(ComponentType, RuleChainType)}
   */
  @Test
  @DisplayName("Test getComponents(ComponentType, RuleChainType) with 'type', 'ruleChainType'; when 'CORE'")
  void testGetComponentsWithTypeRuleChainType_whenCore() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new AnnotationComponentDiscoveryService()).getComponents(ComponentType.ENRICHMENT, RuleChainType.CORE)
        .isEmpty());
  }

  /**
   * Test
   * {@link AnnotationComponentDiscoveryService#getComponents(ComponentType, RuleChainType)}
   * with {@code type}, {@code ruleChainType}.
   * <ul>
   *   <li>When {@code EDGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AnnotationComponentDiscoveryService#getComponents(ComponentType, RuleChainType)}
   */
  @Test
  @DisplayName("Test getComponents(ComponentType, RuleChainType) with 'type', 'ruleChainType'; when 'EDGE'")
  void testGetComponentsWithTypeRuleChainType_whenEdge() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new AnnotationComponentDiscoveryService()).getComponents(ComponentType.ENRICHMENT, RuleChainType.EDGE)
        .isEmpty());
  }

  /**
   * Test
   * {@link AnnotationComponentDiscoveryService#getComponents(Set, RuleChainType)}
   * with {@code types}, {@code ruleChainType}.
   * <ul>
   *   <li>Given {@code ENRICHMENT}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code ENRICHMENT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AnnotationComponentDiscoveryService#getComponents(Set, RuleChainType)}
   */
  @Test
  @DisplayName("Test getComponents(Set, RuleChainType) with 'types', 'ruleChainType'; given 'ENRICHMENT'; when HashSet() add 'ENRICHMENT'")
  void testGetComponentsWithTypesRuleChainType_givenEnrichment_whenHashSetAddEnrichment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationComponentDiscoveryService annotationComponentDiscoveryService = new AnnotationComponentDiscoveryService();

    HashSet<ComponentType> types = new HashSet<>();
    types.add(ComponentType.ENRICHMENT);

    // Act and Assert
    assertTrue(annotationComponentDiscoveryService.getComponents(types, RuleChainType.CORE).isEmpty());
  }

  /**
   * Test
   * {@link AnnotationComponentDiscoveryService#getComponents(Set, RuleChainType)}
   * with {@code types}, {@code ruleChainType}.
   * <ul>
   *   <li>Given {@code FILTER}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code FILTER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AnnotationComponentDiscoveryService#getComponents(Set, RuleChainType)}
   */
  @Test
  @DisplayName("Test getComponents(Set, RuleChainType) with 'types', 'ruleChainType'; given 'FILTER'; when HashSet() add 'FILTER'")
  void testGetComponentsWithTypesRuleChainType_givenFilter_whenHashSetAddFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationComponentDiscoveryService annotationComponentDiscoveryService = new AnnotationComponentDiscoveryService();

    HashSet<ComponentType> types = new HashSet<>();
    types.add(ComponentType.FILTER);
    types.add(ComponentType.ENRICHMENT);

    // Act and Assert
    assertTrue(annotationComponentDiscoveryService.getComponents(types, RuleChainType.CORE).isEmpty());
  }

  /**
   * Test
   * {@link AnnotationComponentDiscoveryService#getComponents(Set, RuleChainType)}
   * with {@code types}, {@code ruleChainType}.
   * <ul>
   *   <li>When {@code EDGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AnnotationComponentDiscoveryService#getComponents(Set, RuleChainType)}
   */
  @Test
  @DisplayName("Test getComponents(Set, RuleChainType) with 'types', 'ruleChainType'; when 'EDGE'")
  void testGetComponentsWithTypesRuleChainType_whenEdge() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationComponentDiscoveryService annotationComponentDiscoveryService = new AnnotationComponentDiscoveryService();

    // Act and Assert
    assertTrue(annotationComponentDiscoveryService.getComponents(new HashSet<>(), RuleChainType.EDGE).isEmpty());
  }

  /**
   * Test
   * {@link AnnotationComponentDiscoveryService#getComponents(Set, RuleChainType)}
   * with {@code types}, {@code ruleChainType}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AnnotationComponentDiscoveryService#getComponents(Set, RuleChainType)}
   */
  @Test
  @DisplayName("Test getComponents(Set, RuleChainType) with 'types', 'ruleChainType'; when HashSet()")
  void testGetComponentsWithTypesRuleChainType_whenHashSet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationComponentDiscoveryService annotationComponentDiscoveryService = new AnnotationComponentDiscoveryService();

    // Act and Assert
    assertTrue(annotationComponentDiscoveryService.getComponents(new HashSet<>(), RuleChainType.CORE).isEmpty());
  }

  /**
   * Test {@link AnnotationComponentDiscoveryService#getComponent(String)}.
   * <p>
   * Method under test:
   * {@link AnnotationComponentDiscoveryService#getComponent(String)}
   */
  @Test
  @DisplayName("Test getComponent(String)")
  void testGetComponent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new AnnotationComponentDiscoveryService()).getComponent("Clazz").isPresent());
  }
}
