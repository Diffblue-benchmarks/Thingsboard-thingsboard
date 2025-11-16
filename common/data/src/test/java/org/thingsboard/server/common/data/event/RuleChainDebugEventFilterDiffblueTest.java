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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RuleChainDebugEventFilterDiffblueTest {
  /**
   * Test {@link RuleChainDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleChainDebugEventFilter} (default constructor) ErrorStr is {@code An error
   *       occurred}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleChainDebugEventFilter (default constructor) ErrorStr is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleChainDebugEventFilterErrorStrIsAnErrorOccurred() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setErrorStr("An error occurred");

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link RuleChainDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleChainDebugEventFilter} (default constructor) IsError is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleChainDebugEventFilter (default constructor) IsError is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleChainDebugEventFilterIsErrorIsTrue_thenReturnTrue() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setIsError(true);

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link RuleChainDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleChainDebugEventFilter} (default constructor) Message is {@code Not all
   *       who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleChainDebugEventFilter (default constructor) Message is 'Not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleChainDebugEventFilterMessageIsNotAllWhoWanderAreLost() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setMessage("Not all who wander are lost");
    ruleChainDebugEventFilter.setServer("");
    ruleChainDebugEventFilter.setIsError(false);
    ruleChainDebugEventFilter.setErrorStr("");

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link RuleChainDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleChainDebugEventFilter} (default constructor) Server is {@code Server}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleChainDebugEventFilter (default constructor) Server is 'Server'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleChainDebugEventFilterServerIsServer_thenReturnTrue() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setErrorStr("An error occurred");
    ruleChainDebugEventFilter.setIsError(true);
    ruleChainDebugEventFilter.setServer("Server");
    ruleChainDebugEventFilter.setMessage("");

    // Act and Assert
    assertTrue(ruleChainDebugEventFilter.isNotEmpty());
  }

  /**
   * Test {@link RuleChainDebugEventFilter#isNotEmpty()}.
   *
   * <ul>
   *   <li>Given {@link RuleChainDebugEventFilter} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventFilter#isNotEmpty()}
   */
  @Test
  @DisplayName(
      "Test isNotEmpty(); given RuleChainDebugEventFilter (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RuleChainDebugEventFilter.isNotEmpty()"})
  void testIsNotEmpty_givenRuleChainDebugEventFilter_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new RuleChainDebugEventFilter().isNotEmpty());
  }

  /**
   * Test {@link RuleChainDebugEventFilter#equals(Object)}, and {@link
   * RuleChainDebugEventFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainDebugEventFilter#equals(Object)}
   *   <li>{@link RuleChainDebugEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainDebugEventFilter.equals(Object)",
    "int RuleChainDebugEventFilter.hashCode()"
  })
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
    assertEquals(ruleChainDebugEventFilter.hashCode(), ruleChainDebugEventFilter2.hashCode());
  }

  /**
   * Test {@link RuleChainDebugEventFilter#equals(Object)}, and {@link
   * RuleChainDebugEventFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainDebugEventFilter#equals(Object)}
   *   <li>{@link RuleChainDebugEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainDebugEventFilter.equals(Object)",
    "int RuleChainDebugEventFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleChainDebugEventFilter ruleChainDebugEventFilter = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter.setErrorStr("An error occurred");
    ruleChainDebugEventFilter.setIsError(true);
    ruleChainDebugEventFilter.setMessage(null);
    ruleChainDebugEventFilter.setServer("Server");

    RuleChainDebugEventFilter ruleChainDebugEventFilter2 = new RuleChainDebugEventFilter();
    ruleChainDebugEventFilter2.setErrorStr("An error occurred");
    ruleChainDebugEventFilter2.setIsError(true);
    ruleChainDebugEventFilter2.setMessage(null);
    ruleChainDebugEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(ruleChainDebugEventFilter, ruleChainDebugEventFilter2);
    assertEquals(ruleChainDebugEventFilter.hashCode(), ruleChainDebugEventFilter2.hashCode());
  }

  /**
   * Test {@link RuleChainDebugEventFilter#equals(Object)}, and {@link
   * RuleChainDebugEventFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainDebugEventFilter#equals(Object)}
   *   <li>{@link RuleChainDebugEventFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainDebugEventFilter.equals(Object)",
    "int RuleChainDebugEventFilter.hashCode()"
  })
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
   * Test {@link RuleChainDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainDebugEventFilter.equals(Object)",
    "int RuleChainDebugEventFilter.hashCode()"
  })
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
   * Test {@link RuleChainDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainDebugEventFilter.equals(Object)",
    "int RuleChainDebugEventFilter.hashCode()"
  })
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
   * Test {@link RuleChainDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainDebugEventFilter.equals(Object)",
    "int RuleChainDebugEventFilter.hashCode()"
  })
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
   * Test {@link RuleChainDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainDebugEventFilter.equals(Object)",
    "int RuleChainDebugEventFilter.hashCode()"
  })
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
   * Test {@link RuleChainDebugEventFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEventFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleChainDebugEventFilter.equals(Object)",
    "int RuleChainDebugEventFilter.hashCode()"
  })
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RuleChainDebugEventFilter}
   *   <li>{@link RuleChainDebugEventFilter#setMessage(String)}
   *   <li>{@link RuleChainDebugEventFilter#toString()}
   *   <li>{@link RuleChainDebugEventFilter#getEventType()}
   *   <li>{@link RuleChainDebugEventFilter#getMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainDebugEventFilter.<init>()",
    "EventType RuleChainDebugEventFilter.getEventType()",
    "String RuleChainDebugEventFilter.getMessage()",
    "void RuleChainDebugEventFilter.setMessage(String)",
    "String RuleChainDebugEventFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RuleChainDebugEventFilter actualRuleChainDebugEventFilter = new RuleChainDebugEventFilter();
    actualRuleChainDebugEventFilter.setMessage("Not all who wander are lost");
    String actualToStringResult = actualRuleChainDebugEventFilter.toString();
    EventType actualEventType = actualRuleChainDebugEventFilter.getEventType();

    // Assert
    assertEquals("Not all who wander are lost", actualRuleChainDebugEventFilter.getMessage());
    assertEquals(
        "RuleChainDebugEventFilter(message=Not all who wander are lost)", actualToStringResult);
    assertNull(actualRuleChainDebugEventFilter.getErrorStr());
    assertNull(actualRuleChainDebugEventFilter.getServer());
    assertEquals(EventType.DEBUG_RULE_CHAIN, actualEventType);
    assertFalse(actualRuleChainDebugEventFilter.isError());
  }
}
