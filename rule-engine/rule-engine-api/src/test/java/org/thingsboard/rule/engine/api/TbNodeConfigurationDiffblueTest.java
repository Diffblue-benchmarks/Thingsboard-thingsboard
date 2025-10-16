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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbNodeConfiguration#equals(Object)}, and {@link TbNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNodeConfiguration#equals(Object)}
   *   <li>{@link TbNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNodeConfiguration.equals(Object)",
    "int TbNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DoubleNode data = DoubleNode.valueOf(10.0d);
    TbNodeConfiguration tbNodeConfiguration = new TbNodeConfiguration(data);
    DoubleNode data2 = DoubleNode.valueOf(10.0d);
    TbNodeConfiguration tbNodeConfiguration2 = new TbNodeConfiguration(data2);

    // Act and Assert
    assertEquals(tbNodeConfiguration, tbNodeConfiguration2);
    assertEquals(tbNodeConfiguration.hashCode(), tbNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbNodeConfiguration#equals(Object)}, and {@link TbNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNodeConfiguration#equals(Object)}
   *   <li>{@link TbNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNodeConfiguration.equals(Object)",
    "int TbNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbNodeConfiguration tbNodeConfiguration = new TbNodeConfiguration(null);
    TbNodeConfiguration tbNodeConfiguration2 = new TbNodeConfiguration(null);

    // Act and Assert
    assertEquals(tbNodeConfiguration, tbNodeConfiguration2);
    assertEquals(tbNodeConfiguration.hashCode(), tbNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbNodeConfiguration#equals(Object)}, and {@link TbNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNodeConfiguration#equals(Object)}
   *   <li>{@link TbNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNodeConfiguration.equals(Object)",
    "int TbNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DoubleNode data = DoubleNode.valueOf(10.0d);
    TbNodeConfiguration tbNodeConfiguration = new TbNodeConfiguration(data);

    // Act and Assert
    assertEquals(tbNodeConfiguration, tbNodeConfiguration);
    int expectedHashCodeResult = tbNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNodeConfiguration.equals(Object)",
    "int TbNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbNodeConfiguration tbNodeConfiguration = new TbNodeConfiguration(BooleanNode.getFalse());
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertNotEquals(tbNodeConfiguration, new TbNodeConfiguration(data));
  }

  /**
   * Test {@link TbNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNodeConfiguration.equals(Object)",
    "int TbNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbNodeConfiguration tbNodeConfiguration = new TbNodeConfiguration(null);
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertNotEquals(tbNodeConfiguration, new TbNodeConfiguration(data));
  }

  /**
   * Test {@link TbNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNodeConfiguration.equals(Object)",
    "int TbNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertNotEquals(new TbNodeConfiguration(data), null);
  }

  /**
   * Test {@link TbNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbNodeConfiguration.equals(Object)",
    "int TbNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertNotEquals(new TbNodeConfiguration(data), "Different type to TbNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)}
   *   <li>{@link TbNodeConfiguration#toString()}
   *   <li>{@link TbNodeConfiguration#getData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbNodeConfiguration.<init>(JsonNode)",
    "JsonNode TbNodeConfiguration.getData()",
    "String TbNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act
    TbNodeConfiguration actualTbNodeConfiguration = new TbNodeConfiguration(data);
    String actualToStringResult = actualTbNodeConfiguration.toString();

    // Assert
    assertEquals("TbNodeConfiguration(data=10.0)", actualToStringResult);
    assertSame(data, actualTbNodeConfiguration.getData());
  }
}
