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
package org.thingsboard.server.common.data.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;

class RuleChainOutputLabelsUsageDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainOutputLabelsUsage#equals(Object)}
   *   <li>{@link RuleChainOutputLabelsUsage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");

    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage2 = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage2.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage2.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertEquals(ruleChainOutputLabelsUsage, ruleChainOutputLabelsUsage2);
    int expectedHashCodeResult = ruleChainOutputLabelsUsage.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainOutputLabelsUsage2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainOutputLabelsUsage#equals(Object)}
   *   <li>{@link RuleChainOutputLabelsUsage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(null);
    ruleChainOutputLabelsUsage.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");

    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage2 = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage2.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage2.setRuleChainId(null);
    ruleChainOutputLabelsUsage2.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage2.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertEquals(ruleChainOutputLabelsUsage, ruleChainOutputLabelsUsage2);
    int expectedHashCodeResult = ruleChainOutputLabelsUsage.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainOutputLabelsUsage2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainOutputLabelsUsage#equals(Object)}
   *   <li>{@link RuleChainOutputLabelsUsage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleChainName(null);
    ruleChainOutputLabelsUsage.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");

    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage2 = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage2.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleChainName(null);
    ruleChainOutputLabelsUsage2.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertEquals(ruleChainOutputLabelsUsage, ruleChainOutputLabelsUsage2);
    int expectedHashCodeResult = ruleChainOutputLabelsUsage.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainOutputLabelsUsage2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainOutputLabelsUsage#equals(Object)}
   *   <li>{@link RuleChainOutputLabelsUsage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage.setRuleNodeId(null);
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");

    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage2 = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage2.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage2.setRuleNodeId(null);
    ruleChainOutputLabelsUsage2.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertEquals(ruleChainOutputLabelsUsage, ruleChainOutputLabelsUsage2);
    int expectedHashCodeResult = ruleChainOutputLabelsUsage.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainOutputLabelsUsage2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainOutputLabelsUsage#equals(Object)}
   *   <li>{@link RuleChainOutputLabelsUsage#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertEquals(ruleChainOutputLabelsUsage, ruleChainOutputLabelsUsage);
    int expectedHashCodeResult = ruleChainOutputLabelsUsage.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainOutputLabelsUsage.hashCode());
  }

  /**
   * Method under test: {@link RuleChainOutputLabelsUsage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<String> labels = new HashSet<>();
    labels.add("Rule Chain Name");

    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(labels);
    ruleChainOutputLabelsUsage.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");

    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage2 = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage2.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage2.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertNotEquals(ruleChainOutputLabelsUsage, ruleChainOutputLabelsUsage2);
  }

  /**
   * Method under test: {@link RuleChainOutputLabelsUsage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(new RuleChainId(UUID.randomUUID()));
    ruleChainOutputLabelsUsage.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");

    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage2 = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage2.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage2.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertNotEquals(ruleChainOutputLabelsUsage, ruleChainOutputLabelsUsage2);
  }

  /**
   * Method under test: {@link RuleChainOutputLabelsUsage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(null);
    ruleChainOutputLabelsUsage.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");

    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage2 = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage2.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage2.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertNotEquals(ruleChainOutputLabelsUsage, ruleChainOutputLabelsUsage2);
  }

  /**
   * Method under test: {@link RuleChainOutputLabelsUsage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(mock(RuleChainId.class));
    ruleChainOutputLabelsUsage.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");

    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage2 = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage2.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage2.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertNotEquals(ruleChainOutputLabelsUsage, ruleChainOutputLabelsUsage2);
  }

  /**
   * Method under test: {@link RuleChainOutputLabelsUsage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleChainName("Rule Node Name");
    ruleChainOutputLabelsUsage.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");

    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage2 = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage2.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage2.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertNotEquals(ruleChainOutputLabelsUsage, ruleChainOutputLabelsUsage2);
  }

  /**
   * Method under test: {@link RuleChainOutputLabelsUsage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleChainName(null);
    ruleChainOutputLabelsUsage.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");

    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage2 = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage2.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage2.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertNotEquals(ruleChainOutputLabelsUsage, ruleChainOutputLabelsUsage2);
  }

  /**
   * Method under test: {@link RuleChainOutputLabelsUsage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage.setRuleNodeId(new RuleNodeId(UUID.randomUUID()));
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");

    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage2 = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage2.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage2.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertNotEquals(ruleChainOutputLabelsUsage, ruleChainOutputLabelsUsage2);
  }

  /**
   * Method under test: {@link RuleChainOutputLabelsUsage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage.setRuleNodeId(null);
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");

    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage2 = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage2.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage2.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertNotEquals(ruleChainOutputLabelsUsage, ruleChainOutputLabelsUsage2);
  }

  /**
   * Method under test: {@link RuleChainOutputLabelsUsage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Chain Name");

    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage2 = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage2.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage2.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertNotEquals(ruleChainOutputLabelsUsage, ruleChainOutputLabelsUsage2);
  }

  /**
   * Method under test: {@link RuleChainOutputLabelsUsage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleNodeName(null);

    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage2 = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage2.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage2.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage2.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage2.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertNotEquals(ruleChainOutputLabelsUsage, ruleChainOutputLabelsUsage2);
  }

  /**
   * Method under test: {@link RuleChainOutputLabelsUsage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertNotEquals(ruleChainOutputLabelsUsage, null);
  }

  /**
   * Method under test: {@link RuleChainOutputLabelsUsage#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleChainOutputLabelsUsage ruleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    ruleChainOutputLabelsUsage.setLabels(new HashSet<>());
    ruleChainOutputLabelsUsage.setRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleChainName("Rule Chain Name");
    ruleChainOutputLabelsUsage.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));
    ruleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");

    // Act and Assert
    assertNotEquals(ruleChainOutputLabelsUsage, "Different type to RuleChainOutputLabelsUsage");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link RuleChainOutputLabelsUsage}
   *   <li>{@link RuleChainOutputLabelsUsage#setLabels(Set)}
   *   <li>{@link RuleChainOutputLabelsUsage#setRuleChainId(RuleChainId)}
   *   <li>{@link RuleChainOutputLabelsUsage#setRuleChainName(String)}
   *   <li>{@link RuleChainOutputLabelsUsage#setRuleNodeId(RuleNodeId)}
   *   <li>{@link RuleChainOutputLabelsUsage#setRuleNodeName(String)}
   *   <li>{@link RuleChainOutputLabelsUsage#toString()}
   *   <li>{@link RuleChainOutputLabelsUsage#getLabels()}
   *   <li>{@link RuleChainOutputLabelsUsage#getRuleChainId()}
   *   <li>{@link RuleChainOutputLabelsUsage#getRuleChainName()}
   *   <li>{@link RuleChainOutputLabelsUsage#getRuleNodeId()}
   *   <li>{@link RuleChainOutputLabelsUsage#getRuleNodeName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RuleChainOutputLabelsUsage actualRuleChainOutputLabelsUsage = new RuleChainOutputLabelsUsage();
    HashSet<String> labels = new HashSet<>();
    actualRuleChainOutputLabelsUsage.setLabels(labels);
    RuleChainId ruleChainId = new RuleChainId(EntityId.NULL_UUID);
    actualRuleChainOutputLabelsUsage.setRuleChainId(ruleChainId);
    actualRuleChainOutputLabelsUsage.setRuleChainName("Rule Chain Name");
    RuleNodeId ruleNodeId = new RuleNodeId(EntityId.NULL_UUID);
    actualRuleChainOutputLabelsUsage.setRuleNodeId(ruleNodeId);
    actualRuleChainOutputLabelsUsage.setRuleNodeName("Rule Node Name");
    String actualToStringResult = actualRuleChainOutputLabelsUsage.toString();
    Set<String> actualLabels = actualRuleChainOutputLabelsUsage.getLabels();
    RuleChainId actualRuleChainId = actualRuleChainOutputLabelsUsage.getRuleChainId();
    String actualRuleChainName = actualRuleChainOutputLabelsUsage.getRuleChainName();
    RuleNodeId actualRuleNodeId = actualRuleChainOutputLabelsUsage.getRuleNodeId();

    // Assert that nothing has changed
    assertEquals("Rule Chain Name", actualRuleChainName);
    assertEquals("Rule Node Name", actualRuleChainOutputLabelsUsage.getRuleNodeName());
    assertEquals(
        "RuleChainOutputLabelsUsage(ruleChainId=13814000-1dd2-11b2-8080-808080808080, ruleNodeId=13814000-1dd2"
            + "-11b2-8080-808080808080, ruleChainName=Rule Chain Name, ruleNodeName=Rule Node Name, labels=[])",
        actualToStringResult);
    assertTrue(actualLabels.isEmpty());
    assertSame(labels, actualLabels);
    assertSame(ruleChainId, actualRuleChainId);
    assertSame(ruleNodeId, actualRuleNodeId);
  }
}
