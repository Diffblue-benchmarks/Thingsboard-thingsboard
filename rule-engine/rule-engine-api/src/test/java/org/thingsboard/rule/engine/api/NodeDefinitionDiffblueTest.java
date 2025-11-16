/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.rule.engine.api;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NodeDefinitionDiffblueTest {
  /**
   * Test {@link NodeDefinition#equals(Object)}, and {@link NodeDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeDefinition#equals(Object)}
   *   <li>{@link NodeDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertEquals(nodeDefinition, nodeDefinition2);
    assertEquals(nodeDefinition.hashCode(), nodeDefinition2.hashCode());
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}, and {@link NodeDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeDefinition#equals(Object)}
   *   <li>{@link NodeDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective(null);
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective(null);
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertEquals(nodeDefinition, nodeDefinition2);
    assertEquals(nodeDefinition.hashCode(), nodeDefinition2.hashCode());
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}, and {@link NodeDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeDefinition#equals(Object)}
   *   <li>{@link NodeDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(null);
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(null);
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertEquals(nodeDefinition, nodeDefinition2);
    assertEquals(nodeDefinition.hashCode(), nodeDefinition2.hashCode());
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}, and {@link NodeDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeDefinition#equals(Object)}
   *   <li>{@link NodeDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription(null);
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription(null);
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertEquals(nodeDefinition, nodeDefinition2);
    assertEquals(nodeDefinition.hashCode(), nodeDefinition2.hashCode());
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}, and {@link NodeDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeDefinition#equals(Object)}
   *   <li>{@link NodeDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails(null);
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails(null);
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertEquals(nodeDefinition, nodeDefinition2);
    assertEquals(nodeDefinition.hashCode(), nodeDefinition2.hashCode());
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}, and {@link NodeDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeDefinition#equals(Object)}
   *   <li>{@link NodeDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl(null);
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl(null);
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertEquals(nodeDefinition, nodeDefinition2);
    assertEquals(nodeDefinition.hashCode(), nodeDefinition2.hashCode());
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}, and {@link NodeDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NodeDefinition#equals(Object)}
   *   <li>{@link NodeDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertEquals(nodeDefinition, nodeDefinition);
    int expectedHashCodeResult = nodeDefinition.hashCode();
    assertEquals(expectedHashCodeResult, nodeDefinition.hashCode());
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Details");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective(null);
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(false);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(BooleanNode.getFalse());
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(null);
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("Details");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription(null);
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("The characteristics of someone or something");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails(null);
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("Details");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl(null);
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Details");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon(null);
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("Details");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl(null);
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(false);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(false);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(null);
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(false);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(null);

    NodeDefinition nodeDefinition2 = new NodeDefinition();
    nodeDefinition2.setConfigDirective("Config Directive");
    nodeDefinition2.setCustomRelations(true);
    nodeDefinition2.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition2.setDescription("The characteristics of someone or something");
    nodeDefinition2.setDetails("Details");
    nodeDefinition2.setDocUrl("https://example.org/example");
    nodeDefinition2.setIcon("Icon");
    nodeDefinition2.setIconUrl("https://example.org/example");
    nodeDefinition2.setInEnabled(true);
    nodeDefinition2.setOutEnabled(true);
    nodeDefinition2.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition2.setRuleChainNode(true);
    nodeDefinition2.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, nodeDefinition2);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, null);
  }

  /**
   * Test {@link NodeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NodeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NodeDefinition.equals(Object)", "int NodeDefinition.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NodeDefinition nodeDefinition = new NodeDefinition();
    nodeDefinition.setConfigDirective("Config Directive");
    nodeDefinition.setCustomRelations(true);
    nodeDefinition.setDefaultConfiguration(DoubleNode.valueOf(10.0d));
    nodeDefinition.setDescription("The characteristics of someone or something");
    nodeDefinition.setDetails("Details");
    nodeDefinition.setDocUrl("https://example.org/example");
    nodeDefinition.setIcon("Icon");
    nodeDefinition.setIconUrl("https://example.org/example");
    nodeDefinition.setInEnabled(true);
    nodeDefinition.setOutEnabled(true);
    nodeDefinition.setRelationTypes(new String[] {"Relation Types"});
    nodeDefinition.setRuleChainNode(true);
    nodeDefinition.setUiResources(new String[] {"Ui Resources"});

    // Act and Assert
    assertNotEquals(nodeDefinition, "Different type to NodeDefinition");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NodeDefinition}
   *   <li>{@link NodeDefinition#setConfigDirective(String)}
   *   <li>{@link NodeDefinition#setCustomRelations(boolean)}
   *   <li>{@link NodeDefinition#setDefaultConfiguration(JsonNode)}
   *   <li>{@link NodeDefinition#setDescription(String)}
   *   <li>{@link NodeDefinition#setDetails(String)}
   *   <li>{@link NodeDefinition#setDocUrl(String)}
   *   <li>{@link NodeDefinition#setIcon(String)}
   *   <li>{@link NodeDefinition#setIconUrl(String)}
   *   <li>{@link NodeDefinition#setInEnabled(boolean)}
   *   <li>{@link NodeDefinition#setOutEnabled(boolean)}
   *   <li>{@link NodeDefinition#setRelationTypes(String[])}
   *   <li>{@link NodeDefinition#setRuleChainNode(boolean)}
   *   <li>{@link NodeDefinition#setUiResources(String[])}
   *   <li>{@link NodeDefinition#toString()}
   *   <li>{@link NodeDefinition#getConfigDirective()}
   *   <li>{@link NodeDefinition#getDefaultConfiguration()}
   *   <li>{@link NodeDefinition#getDescription()}
   *   <li>{@link NodeDefinition#getDetails()}
   *   <li>{@link NodeDefinition#getDocUrl()}
   *   <li>{@link NodeDefinition#getIcon()}
   *   <li>{@link NodeDefinition#getIconUrl()}
   *   <li>{@link NodeDefinition#getRelationTypes()}
   *   <li>{@link NodeDefinition#getUiResources()}
   *   <li>{@link NodeDefinition#isCustomRelations()}
   *   <li>{@link NodeDefinition#isInEnabled()}
   *   <li>{@link NodeDefinition#isOutEnabled()}
   *   <li>{@link NodeDefinition#isRuleChainNode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NodeDefinition.<init>()",
    "String NodeDefinition.getConfigDirective()",
    "JsonNode NodeDefinition.getDefaultConfiguration()",
    "String NodeDefinition.getDescription()",
    "String NodeDefinition.getDetails()",
    "String NodeDefinition.getDocUrl()",
    "String NodeDefinition.getIcon()",
    "String NodeDefinition.getIconUrl()",
    "String[] NodeDefinition.getRelationTypes()",
    "String[] NodeDefinition.getUiResources()",
    "boolean NodeDefinition.isCustomRelations()",
    "boolean NodeDefinition.isInEnabled()",
    "boolean NodeDefinition.isOutEnabled()",
    "boolean NodeDefinition.isRuleChainNode()",
    "void NodeDefinition.setConfigDirective(String)",
    "void NodeDefinition.setCustomRelations(boolean)",
    "void NodeDefinition.setDefaultConfiguration(JsonNode)",
    "void NodeDefinition.setDescription(String)",
    "void NodeDefinition.setDetails(String)",
    "void NodeDefinition.setDocUrl(String)",
    "void NodeDefinition.setIcon(String)",
    "void NodeDefinition.setIconUrl(String)",
    "void NodeDefinition.setInEnabled(boolean)",
    "void NodeDefinition.setOutEnabled(boolean)",
    "void NodeDefinition.setRelationTypes(String[])",
    "void NodeDefinition.setRuleChainNode(boolean)",
    "void NodeDefinition.setUiResources(String[])",
    "String NodeDefinition.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NodeDefinition actualNodeDefinition = new NodeDefinition();
    actualNodeDefinition.setConfigDirective("Config Directive");
    actualNodeDefinition.setCustomRelations(true);
    DoubleNode defaultConfiguration = DoubleNode.valueOf(10.0d);
    actualNodeDefinition.setDefaultConfiguration(defaultConfiguration);
    actualNodeDefinition.setDescription("The characteristics of someone or something");
    actualNodeDefinition.setDetails("Details");
    actualNodeDefinition.setDocUrl("https://example.org/example");
    actualNodeDefinition.setIcon("Icon");
    actualNodeDefinition.setIconUrl("https://example.org/example");
    actualNodeDefinition.setInEnabled(true);
    actualNodeDefinition.setOutEnabled(true);
    String[] relationTypes = new String[] {"Relation Types"};
    actualNodeDefinition.setRelationTypes(relationTypes);
    actualNodeDefinition.setRuleChainNode(true);
    String[] uiResources = new String[] {"Ui Resources"};
    actualNodeDefinition.setUiResources(uiResources);
    String actualToStringResult = actualNodeDefinition.toString();
    String actualConfigDirective = actualNodeDefinition.getConfigDirective();
    JsonNode actualDefaultConfiguration = actualNodeDefinition.getDefaultConfiguration();
    String actualDescription = actualNodeDefinition.getDescription();
    String actualDetails = actualNodeDefinition.getDetails();
    String actualDocUrl = actualNodeDefinition.getDocUrl();
    String actualIcon = actualNodeDefinition.getIcon();
    String actualIconUrl = actualNodeDefinition.getIconUrl();
    String[] actualRelationTypes = actualNodeDefinition.getRelationTypes();
    String[] actualUiResources = actualNodeDefinition.getUiResources();
    boolean actualIsCustomRelationsResult = actualNodeDefinition.isCustomRelations();
    boolean actualIsInEnabledResult = actualNodeDefinition.isInEnabled();
    boolean actualIsOutEnabledResult = actualNodeDefinition.isOutEnabled();

    // Assert
    assertEquals("Config Directive", actualConfigDirective);
    assertEquals("Details", actualDetails);
    assertEquals("Icon", actualIcon);
    assertEquals(
        "NodeDefinition(details=Details, description=The characteristics of someone or something, inEnabled=true,"
            + " outEnabled=true, relationTypes=[Relation Types], customRelations=true, ruleChainNode=true,"
            + " defaultConfiguration=10.0, uiResources=[Ui Resources], configDirective=Config Directive, icon=Icon,"
            + " iconUrl=https://example.org/example, docUrl=https://example.org/example)",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("https://example.org/example", actualDocUrl);
    assertEquals("https://example.org/example", actualIconUrl);
    assertTrue(actualIsCustomRelationsResult);
    assertTrue(actualIsInEnabledResult);
    assertTrue(actualIsOutEnabledResult);
    assertTrue(actualNodeDefinition.isRuleChainNode());
    assertSame(defaultConfiguration, actualDefaultConfiguration);
    assertSame(relationTypes, actualRelationTypes);
    assertSame(uiResources, actualUiResources);
    assertArrayEquals(new String[] {"Relation Types"}, actualRelationTypes);
    assertArrayEquals(new String[] {"Ui Resources"}, actualUiResources);
  }
}
