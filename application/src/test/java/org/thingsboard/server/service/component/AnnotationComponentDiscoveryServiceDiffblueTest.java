package org.thingsboard.server.service.component;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.plugin.ComponentType;
import org.thingsboard.server.common.data.rule.RuleChainType;

@ExtendWith(MockitoExtension.class)
class AnnotationComponentDiscoveryServiceDiffblueTest {
  @InjectMocks private AnnotationComponentDiscoveryService annotationComponentDiscoveryService;

  /**
   * Test {@link AnnotationComponentDiscoveryService#getRuleNodeInfo(String)}.
   *
   * <p>Method under test: {@link AnnotationComponentDiscoveryService#getRuleNodeInfo(String)}
   */
  @Test
  @DisplayName("Test getRuleNodeInfo(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Optional AnnotationComponentDiscoveryService.getRuleNodeInfo(String)"
  })
  void testGetRuleNodeInfo() {
    // Arrange, Act and Assert
    assertFalse(annotationComponentDiscoveryService.getRuleNodeInfo("Clazz").isPresent());
  }

  /**
   * Test {@link AnnotationComponentDiscoveryService#getVersionedNodes()}.
   *
   * <p>Method under test: {@link AnnotationComponentDiscoveryService#getVersionedNodes()}
   */
  @Test
  @DisplayName("Test getVersionedNodes()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List AnnotationComponentDiscoveryService.getVersionedNodes()"})
  void testGetVersionedNodes() {
    // Arrange, Act and Assert
    assertTrue(annotationComponentDiscoveryService.getVersionedNodes().isEmpty());
  }

  /**
   * Test {@link AnnotationComponentDiscoveryService#getComponents(ComponentType, RuleChainType)}
   * with {@code type}, {@code ruleChainType}.
   *
   * <ul>
   *   <li>When {@code CORE}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationComponentDiscoveryService#getComponents(ComponentType,
   * RuleChainType)}
   */
  @Test
  @DisplayName(
      "Test getComponents(ComponentType, RuleChainType) with 'type', 'ruleChainType'; when 'CORE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List AnnotationComponentDiscoveryService.getComponents(ComponentType, RuleChainType)"
  })
  void testGetComponentsWithTypeRuleChainType_whenCore() {
    // Arrange, Act and Assert
    assertTrue(
        annotationComponentDiscoveryService
            .getComponents(ComponentType.ENRICHMENT, RuleChainType.CORE)
            .isEmpty());
  }

  /**
   * Test {@link AnnotationComponentDiscoveryService#getComponents(ComponentType, RuleChainType)}
   * with {@code type}, {@code ruleChainType}.
   *
   * <ul>
   *   <li>When {@code EDGE}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationComponentDiscoveryService#getComponents(ComponentType,
   * RuleChainType)}
   */
  @Test
  @DisplayName(
      "Test getComponents(ComponentType, RuleChainType) with 'type', 'ruleChainType'; when 'EDGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List AnnotationComponentDiscoveryService.getComponents(ComponentType, RuleChainType)"
  })
  void testGetComponentsWithTypeRuleChainType_whenEdge() {
    // Arrange, Act and Assert
    assertTrue(
        annotationComponentDiscoveryService
            .getComponents(ComponentType.ENRICHMENT, RuleChainType.EDGE)
            .isEmpty());
  }

  /**
   * Test {@link AnnotationComponentDiscoveryService#getComponents(Set, RuleChainType)} with {@code
   * types}, {@code ruleChainType}.
   *
   * <ul>
   *   <li>Given {@code ENRICHMENT}.
   *   <li>When {@link HashSet#HashSet()} add {@code ENRICHMENT}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationComponentDiscoveryService#getComponents(Set,
   * RuleChainType)}
   */
  @Test
  @DisplayName(
      "Test getComponents(Set, RuleChainType) with 'types', 'ruleChainType'; given 'ENRICHMENT'; when HashSet() add 'ENRICHMENT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List AnnotationComponentDiscoveryService.getComponents(Set, RuleChainType)"
  })
  void testGetComponentsWithTypesRuleChainType_givenEnrichment_whenHashSetAddEnrichment() {
    // Arrange
    HashSet<ComponentType> types = new HashSet<>();
    types.add(ComponentType.ENRICHMENT);

    // Act and Assert
    assertTrue(
        annotationComponentDiscoveryService.getComponents(types, RuleChainType.CORE).isEmpty());
  }

  /**
   * Test {@link AnnotationComponentDiscoveryService#getComponents(Set, RuleChainType)} with {@code
   * types}, {@code ruleChainType}.
   *
   * <ul>
   *   <li>Given {@code FILTER}.
   *   <li>When {@link HashSet#HashSet()} add {@code FILTER}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationComponentDiscoveryService#getComponents(Set,
   * RuleChainType)}
   */
  @Test
  @DisplayName(
      "Test getComponents(Set, RuleChainType) with 'types', 'ruleChainType'; given 'FILTER'; when HashSet() add 'FILTER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List AnnotationComponentDiscoveryService.getComponents(Set, RuleChainType)"
  })
  void testGetComponentsWithTypesRuleChainType_givenFilter_whenHashSetAddFilter() {
    // Arrange
    HashSet<ComponentType> types = new HashSet<>();
    types.add(ComponentType.FILTER);
    types.add(ComponentType.ENRICHMENT);

    // Act and Assert
    assertTrue(
        annotationComponentDiscoveryService.getComponents(types, RuleChainType.CORE).isEmpty());
  }

  /**
   * Test {@link AnnotationComponentDiscoveryService#getComponents(Set, RuleChainType)} with {@code
   * types}, {@code ruleChainType}.
   *
   * <ul>
   *   <li>When {@code EDGE}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationComponentDiscoveryService#getComponents(Set,
   * RuleChainType)}
   */
  @Test
  @DisplayName("Test getComponents(Set, RuleChainType) with 'types', 'ruleChainType'; when 'EDGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List AnnotationComponentDiscoveryService.getComponents(Set, RuleChainType)"
  })
  void testGetComponentsWithTypesRuleChainType_whenEdge() {
    // Arrange, Act and Assert
    assertTrue(
        annotationComponentDiscoveryService
            .getComponents(new HashSet<>(), RuleChainType.EDGE)
            .isEmpty());
  }

  /**
   * Test {@link AnnotationComponentDiscoveryService#getComponents(Set, RuleChainType)} with {@code
   * types}, {@code ruleChainType}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationComponentDiscoveryService#getComponents(Set,
   * RuleChainType)}
   */
  @Test
  @DisplayName(
      "Test getComponents(Set, RuleChainType) with 'types', 'ruleChainType'; when HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List AnnotationComponentDiscoveryService.getComponents(Set, RuleChainType)"
  })
  void testGetComponentsWithTypesRuleChainType_whenHashSet() {
    // Arrange, Act and Assert
    assertTrue(
        annotationComponentDiscoveryService
            .getComponents(new HashSet<>(), RuleChainType.CORE)
            .isEmpty());
  }

  /**
   * Test {@link AnnotationComponentDiscoveryService#getComponent(String)}.
   *
   * <p>Method under test: {@link AnnotationComponentDiscoveryService#getComponent(String)}
   */
  @Test
  @DisplayName("Test getComponent(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Optional AnnotationComponentDiscoveryService.getComponent(String)"})
  void testGetComponent() {
    // Arrange, Act and Assert
    assertFalse(annotationComponentDiscoveryService.getComponent("Clazz").isPresent());
  }
}
