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
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;

class RuleChainConnectionInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainConnectionInfo#equals(Object)}
   *   <li>{@link RuleChainConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
    int expectedHashCodeResult = ruleChainConnectionInfo.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainConnectionInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainConnectionInfo#equals(Object)}
   *   <li>{@link RuleChainConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(null);
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(null);
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
    int expectedHashCodeResult = ruleChainConnectionInfo.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainConnectionInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainConnectionInfo#equals(Object)}
   *   <li>{@link RuleChainConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(null);
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(null);
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
    int expectedHashCodeResult = ruleChainConnectionInfo.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainConnectionInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainConnectionInfo#equals(Object)}
   *   <li>{@link RuleChainConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo.setType(null);

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo2.setType(null);

    // Act and Assert
    assertEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
    int expectedHashCodeResult = ruleChainConnectionInfo.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainConnectionInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainConnectionInfo#equals(Object)}
   *   <li>{@link RuleChainConnectionInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo.setType("Type");

    // Act and Assert
    assertEquals(ruleChainConnectionInfo, ruleChainConnectionInfo);
    int expectedHashCodeResult = ruleChainConnectionInfo.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainConnectionInfo.hashCode());
  }

  /**
   * Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(null);
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
  }

  /**
   * Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(NullNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
  }

  /**
   * Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(mock(JsonNode.class));
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
  }

  /**
   * Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(3);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
  }

  /**
   * Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(UUID.randomUUID()));
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
  }

  /**
   * Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(null);
    ruleChainConnectionInfo.setType("Type");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
  }

  /**
   * Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo.setType(null);

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
  }

  /**
   * Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo.setType("org.thingsboard.server.common.data.rule.RuleChainConnectionInfo");

    RuleChainConnectionInfo ruleChainConnectionInfo2 = new RuleChainConnectionInfo();
    ruleChainConnectionInfo2.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo2.setFromIndex(1);
    ruleChainConnectionInfo2.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, ruleChainConnectionInfo2);
  }

  /**
   * Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, null);
  }

  /**
   * Method under test: {@link RuleChainConnectionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(MissingNode.getInstance());
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(EntityId.NULL_UUID));
    ruleChainConnectionInfo.setType("Type");

    // Act and Assert
    assertNotEquals(ruleChainConnectionInfo, "Different type to RuleChainConnectionInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RuleChainConnectionInfo}
   *   <li>{@link RuleChainConnectionInfo#setAdditionalInfo(JsonNode)}
   *   <li>{@link RuleChainConnectionInfo#setFromIndex(int)}
   *   <li>{@link RuleChainConnectionInfo#setTargetRuleChainId(RuleChainId)}
   *   <li>{@link RuleChainConnectionInfo#setType(String)}
   *   <li>{@link RuleChainConnectionInfo#toString()}
   *   <li>{@link RuleChainConnectionInfo#getAdditionalInfo()}
   *   <li>{@link RuleChainConnectionInfo#getFromIndex()}
   *   <li>{@link RuleChainConnectionInfo#getTargetRuleChainId()}
   *   <li>{@link RuleChainConnectionInfo#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RuleChainConnectionInfo actualRuleChainConnectionInfo = new RuleChainConnectionInfo();
    MissingNode additionalInfo = MissingNode.getInstance();
    actualRuleChainConnectionInfo.setAdditionalInfo(additionalInfo);
    actualRuleChainConnectionInfo.setFromIndex(1);
    RuleChainId targetRuleChainId = new RuleChainId(EntityId.NULL_UUID);
    actualRuleChainConnectionInfo.setTargetRuleChainId(targetRuleChainId);
    actualRuleChainConnectionInfo.setType("Type");
    String actualToStringResult = actualRuleChainConnectionInfo.toString();
    JsonNode actualAdditionalInfo = actualRuleChainConnectionInfo.getAdditionalInfo();
    int actualFromIndex = actualRuleChainConnectionInfo.getFromIndex();
    RuleChainId actualTargetRuleChainId = actualRuleChainConnectionInfo.getTargetRuleChainId();

    // Assert that nothing has changed
    assertEquals("RuleChainConnectionInfo(fromIndex=1, targetRuleChainId=13814000-1dd2-11b2-8080-808080808080,"
        + " additionalInfo=, type=Type)", actualToStringResult);
    assertEquals("Type", actualRuleChainConnectionInfo.getType());
    assertEquals(1, actualFromIndex);
    assertSame(targetRuleChainId, actualTargetRuleChainId);
    assertSame(additionalInfo, actualAdditionalInfo);
  }
}
