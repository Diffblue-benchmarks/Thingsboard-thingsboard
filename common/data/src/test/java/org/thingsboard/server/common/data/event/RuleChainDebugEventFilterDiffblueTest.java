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
package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class RuleChainDebugEventFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainDebugEventFilter#equals(Object)}
   *   <li>{@link RuleChainDebugEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setErrorStr("An error occurred");
    ruleChainDebugEventFilter.setIsError(true);
    ruleChainDebugEventFilter.setMessage("Not all who wander are lost");
    ruleChainDebugEventFilter.setServer("Server");

    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter2.setErrorStr("An error occurred");
    ruleChainDebugEventFilter2.setIsError(true);
    ruleChainDebugEventFilter2.setMessage("Not all who wander are lost");
    ruleChainDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
    int expectedHashCodeResult = ruleChainDebugEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainDebugEventFilter2.hashCode());
  }

  /**
   * Method under test: {@link RuleChainDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty() {
    // Arrange, Act and Assert
    assertFalse((new RuleChainDebugEventFilter()).isNotEmpty());
  }

  /**
   * Method under test: {@link RuleChainDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty2() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setErrorStr("An error occurred");
    ruleChainDebugEventFilter.setIsError(true);
    ruleChainDebugEventFilter.setServer("Server");
    ruleChainDebugEventFilter.setMessage(null);

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link RuleChainDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty3() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setMessage("Not all who wander are lost");
    ruleChainDebugEventFilter.setServer(null);
    ruleChainDebugEventFilter.setErrorStr(null);
    ruleChainDebugEventFilter.setIsError(false);

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link RuleChainDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty4() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setMessage("Not all who wander are lost");
    ruleChainDebugEventFilter.setServer(null);
    ruleChainDebugEventFilter.setErrorStr("");
    ruleChainDebugEventFilter.setIsError(false);

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link RuleChainDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty5() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setMessage("Not all who wander are lost");
    ruleChainDebugEventFilter.setServer(null);
    ruleChainDebugEventFilter.setErrorStr("foo");
    ruleChainDebugEventFilter.setIsError(false);

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link RuleChainDebugEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty6() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setIsError(true);

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainDebugEventFilter#equals(Object)}
   *   <li>{@link RuleChainDebugEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setErrorStr("An error occurred");
    ruleChainDebugEventFilter.setIsError(true);
    ruleChainDebugEventFilter.setMessage("Not all who wander are lost");
    ruleChainDebugEventFilter.setServer("Server");

    // Act and Assert
    assertEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter);
    int expectedHashCodeResult = ruleChainDebugEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, ruleChainDebugEventFilter.hashCode());
  }

  /**
   * Method under test: {@link RuleChainDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setErrorStr("Server");
    ruleChainDebugEventFilter.setIsError(true);
    ruleChainDebugEventFilter.setMessage("Not all who wander are lost");
    ruleChainDebugEventFilter.setServer("Server");

    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter2.setErrorStr("An error occurred");
    ruleChainDebugEventFilter2.setIsError(true);
    ruleChainDebugEventFilter2.setMessage("Not all who wander are lost");
    ruleChainDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleChainDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setErrorStr("An error occurred");
    ruleChainDebugEventFilter.setIsError(true);
    ruleChainDebugEventFilter.setMessage("Server");
    ruleChainDebugEventFilter.setServer("Server");

    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter2.setErrorStr("An error occurred");
    ruleChainDebugEventFilter2.setIsError(true);
    ruleChainDebugEventFilter2.setMessage("Not all who wander are lost");
    ruleChainDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleChainDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setErrorStr("An error occurred");
    ruleChainDebugEventFilter.setIsError(true);
    ruleChainDebugEventFilter.setMessage(null);
    ruleChainDebugEventFilter.setServer("Server");

    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter2.setErrorStr("An error occurred");
    ruleChainDebugEventFilter2.setIsError(true);
    ruleChainDebugEventFilter2.setMessage("Not all who wander are lost");
    ruleChainDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
  }

  /**
   * Method under test: {@link RuleChainDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setErrorStr("An error occurred");
    ruleChainDebugEventFilter.setIsError(true);
    ruleChainDebugEventFilter.setMessage("Not all who wander are lost");
    ruleChainDebugEventFilter.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, null);
  }

  /**
   * Method under test: {@link RuleChainDebugEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setErrorStr("An error occurred");
    ruleChainDebugEventFilter.setIsError(true);
    ruleChainDebugEventFilter.setMessage("Not all who wander are lost");
    ruleChainDebugEventFilter.setServer("Server");

    // Act and Assert
    assertNotEquals(ruleChainDebugEventFilter, "Different type to RuleChainDebugEventFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RuleChainDebugEventFilter}
   *   <li>{@link RuleChainDebugEventFilter#setMessage(String)}
   *   <li>{@link RuleChainDebugEventFilter#toString()}
   *   <li>{@link RuleChainDebugEventFilter#getEventType()}
   *   <li>{@link RuleChainDebugEventFilter#getMessage()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RuleChainDebugEventFilter actualRuleChainDebugEventFilter = new RuleChainDebugEventFilter();
    actualRuleChainDebugEventFilter.setMessage("Not all who wander are lost");
    String actualToStringResult = actualRuleChainDebugEventFilter.toString();
    EventType actualEventType = actualRuleChainDebugEventFilter.getEventType();

    // Assert that nothing has changed
    assertEquals("Not all who wander are lost", actualRuleChainDebugEventFilter.getMessage());
    assertEquals("RuleChainDebugEventFilter(message=Not all who wander are lost)", actualToStringResult);
    assertEquals(EventType.DEBUG_RULE_CHAIN, actualEventType);
    assertFalse(actualRuleChainDebugEventFilter.isError());
  }
}
