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
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RuleChainDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainData#equals(Object)}
   *   <li>{@link RuleChainData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(new ArrayList<>());

    RuleChainData ruleChainData2 = new RuleChainData();
    ruleChainData2.setMetadata(new ArrayList<>());
    ruleChainData2.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertEquals(ruleChainData, ruleChainData2);
    int expectedHashCodeResult = ruleChainData.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainData#equals(Object)}
   *   <li>{@link RuleChainData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertEquals(ruleChainData, ruleChainData);
    int expectedHashCodeResult = ruleChainData.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainData.hashCode());
  }

  /**
   * Method under test: {@link RuleChainData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(new RuleChainMetaData());

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(new ArrayList<>());

    RuleChainData ruleChainData2 = new RuleChainData();
    ruleChainData2.setMetadata(new ArrayList<>());
    ruleChainData2.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ruleChainData, ruleChainData2);
  }

  /**
   * Method under test: {@link RuleChainData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<RuleChain> ruleChains = new ArrayList<>();
    ruleChains.add(new RuleChain());

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(ruleChains);

    RuleChainData ruleChainData2 = new RuleChainData();
    ruleChainData2.setMetadata(new ArrayList<>());
    ruleChainData2.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ruleChainData, ruleChainData2);
  }

  /**
   * Method under test: {@link RuleChainData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(mock(RuleChainMetaData.class));

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(new ArrayList<>());

    RuleChainData ruleChainData2 = new RuleChainData();
    ruleChainData2.setMetadata(new ArrayList<>());
    ruleChainData2.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ruleChainData, ruleChainData2);
  }

  /**
   * Method under test: {@link RuleChainData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ruleChainData, null);
  }

  /**
   * Method under test: {@link RuleChainData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertNotEquals(ruleChainData, "Different type to RuleChainData");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RuleChainData}
   *   <li>{@link RuleChainData#setMetadata(List)}
   *   <li>{@link RuleChainData#setRuleChains(List)}
   *   <li>{@link RuleChainData#toString()}
   *   <li>{@link RuleChainData#getMetadata()}
   *   <li>{@link RuleChainData#getRuleChains()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RuleChainData actualRuleChainData = new RuleChainData();
    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    actualRuleChainData.setMetadata(metadata);
    ArrayList<RuleChain> ruleChains = new ArrayList<>();
    actualRuleChainData.setRuleChains(ruleChains);
    String actualToStringResult = actualRuleChainData.toString();
    List<RuleChainMetaData> actualMetadata = actualRuleChainData.getMetadata();
    List<RuleChain> actualRuleChains = actualRuleChainData.getRuleChains();

    // Assert that nothing has changed
    assertEquals("RuleChainData(ruleChains=[], metadata=[])", actualToStringResult);
    assertTrue(actualMetadata.isEmpty());
    assertTrue(actualRuleChains.isEmpty());
    assertSame(metadata, actualMetadata);
    assertSame(ruleChains, actualRuleChains);
  }
}
