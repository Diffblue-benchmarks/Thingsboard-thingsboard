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
package org.thingsboard.server.common.data.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;

class RuleChainExportDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainExportData#equals(Object)}
   *   <li>{@link RuleChainExportData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainExportData ruleChainExportData = new RuleChainExportData();
    RuleChainExportData ruleChainExportData2 = new RuleChainExportData();

    // Act and Assert
    assertEquals(ruleChainExportData, ruleChainExportData2);
    int expectedHashCodeResult = ruleChainExportData.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainExportData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainExportData#equals(Object)}
   *   <li>{@link RuleChainExportData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleChainExportData ruleChainExportData = new RuleChainExportData();
    ruleChainExportData.setMetaData(new RuleChainMetaData());

    RuleChainExportData ruleChainExportData2 = new RuleChainExportData();
    ruleChainExportData2.setMetaData(new RuleChainMetaData());

    // Act and Assert
    assertEquals(ruleChainExportData, ruleChainExportData2);
    int expectedHashCodeResult = ruleChainExportData.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainExportData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainExportData#equals(Object)}
   *   <li>{@link RuleChainExportData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainExportData ruleChainExportData = new RuleChainExportData();

    // Act and Assert
    assertEquals(ruleChainExportData, ruleChainExportData);
    int expectedHashCodeResult = ruleChainExportData.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainExportData.hashCode());
  }

  /**
   * Method under test: {@link RuleChainExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChainExportData(), 1);
    assertNotEquals(new RuleChainExportData(), mock(DeviceExportData.class));
  }

  /**
   * Method under test: {@link RuleChainExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainExportData ruleChainExportData = new RuleChainExportData();
    ruleChainExportData.setMetaData(new RuleChainMetaData());

    // Act and Assert
    assertNotEquals(ruleChainExportData, new RuleChainExportData());
  }

  /**
   * Method under test: {@link RuleChainExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainExportData ruleChainExportData = new RuleChainExportData();
    ruleChainExportData.setEntity(new RuleChain());

    // Act and Assert
    assertNotEquals(ruleChainExportData, new RuleChainExportData());
  }

  /**
   * Method under test: {@link RuleChainExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainExportData ruleChainExportData = new RuleChainExportData();

    RuleChainExportData ruleChainExportData2 = new RuleChainExportData();
    ruleChainExportData2.setMetaData(new RuleChainMetaData());

    // Act and Assert
    assertNotEquals(ruleChainExportData, ruleChainExportData2);
  }

  /**
   * Method under test: {@link RuleChainExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChainExportData(), null);
  }

  /**
   * Method under test: {@link RuleChainExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChainExportData(), "Different type to RuleChainExportData");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RuleChainExportData}
   *   <li>{@link RuleChainExportData#setMetaData(RuleChainMetaData)}
   *   <li>{@link RuleChainExportData#toString()}
   *   <li>{@link RuleChainExportData#getMetaData()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RuleChainExportData actualRuleChainExportData = new RuleChainExportData();
    RuleChainMetaData metaData = new RuleChainMetaData();
    actualRuleChainExportData.setMetaData(metaData);
    String actualToStringResult = actualRuleChainExportData.toString();

    // Assert that nothing has changed
    assertEquals(
        "RuleChainExportData(super=EntityExportData(entity=null, entityType=null, relations=null, attributes=null),"
            + " metaData=RuleChainMetaData(ruleChainId=null, version=null, firstNodeIndex=null, nodes=null,"
            + " connections=null, ruleChainConnections=null))",
        actualToStringResult);
    assertSame(metaData, actualRuleChainExportData.getMetaData());
  }
}
