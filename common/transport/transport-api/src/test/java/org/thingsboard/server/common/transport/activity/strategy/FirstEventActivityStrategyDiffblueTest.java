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
package org.thingsboard.server.common.transport.activity.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FirstEventActivityStrategyDiffblueTest {
  /**
   * Test {@link FirstEventActivityStrategy#onActivity()}.
   * <p>
   * Method under test: {@link FirstEventActivityStrategy#onActivity()}
   */
  @Test
  @DisplayName("Test onActivity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FirstEventActivityStrategy.onActivity()"})
  void testOnActivity() {
    // Arrange, Act and Assert
    assertTrue((new FirstEventActivityStrategy()).onActivity());
  }

  /**
   * Test {@link FirstEventActivityStrategy#equals(Object)}, and {@link FirstEventActivityStrategy#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FirstEventActivityStrategy#equals(Object)}
   *   <li>{@link FirstEventActivityStrategy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FirstEventActivityStrategy.equals(Object)", "int FirstEventActivityStrategy.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FirstEventActivityStrategy firstEventActivityStrategy = new FirstEventActivityStrategy();
    FirstEventActivityStrategy firstEventActivityStrategy2 = new FirstEventActivityStrategy();

    // Act and Assert
    assertEquals(firstEventActivityStrategy, firstEventActivityStrategy2);
    int expectedHashCodeResult = firstEventActivityStrategy.hashCode();
    assertEquals(expectedHashCodeResult, firstEventActivityStrategy2.hashCode());
  }

  /**
   * Test {@link FirstEventActivityStrategy#equals(Object)}, and {@link FirstEventActivityStrategy#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FirstEventActivityStrategy#equals(Object)}
   *   <li>{@link FirstEventActivityStrategy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FirstEventActivityStrategy.equals(Object)", "int FirstEventActivityStrategy.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FirstEventActivityStrategy firstEventActivityStrategy = new FirstEventActivityStrategy();

    // Act and Assert
    assertEquals(firstEventActivityStrategy, firstEventActivityStrategy);
    int expectedHashCodeResult = firstEventActivityStrategy.hashCode();
    assertEquals(expectedHashCodeResult, firstEventActivityStrategy.hashCode());
  }

  /**
   * Test {@link FirstEventActivityStrategy#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirstEventActivityStrategy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FirstEventActivityStrategy.equals(Object)", "int FirstEventActivityStrategy.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FirstEventActivityStrategy(), 1);
  }

  /**
   * Test {@link FirstEventActivityStrategy#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirstEventActivityStrategy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FirstEventActivityStrategy.equals(Object)", "int FirstEventActivityStrategy.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FirstEventActivityStrategy(), null);
  }

  /**
   * Test {@link FirstEventActivityStrategy#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirstEventActivityStrategy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean FirstEventActivityStrategy.equals(Object)", "int FirstEventActivityStrategy.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FirstEventActivityStrategy(), "Different type to FirstEventActivityStrategy");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FirstEventActivityStrategy}
   *   <li>{@link FirstEventActivityStrategy#onReportingPeriodEnd()}
   *   <li>{@link FirstEventActivityStrategy#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FirstEventActivityStrategy.<init>()",
      "boolean FirstEventActivityStrategy.onReportingPeriodEnd()",
      "java.lang.String FirstEventActivityStrategy.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    FirstEventActivityStrategy actualFirstEventActivityStrategy = new FirstEventActivityStrategy();
    boolean actualOnReportingPeriodEndResult = actualFirstEventActivityStrategy.onReportingPeriodEnd();

    // Assert
    assertEquals("FirstEventActivityStrategy(firstEventReceived=false)", actualFirstEventActivityStrategy.toString());
    assertFalse(actualOnReportingPeriodEndResult);
  }
}
