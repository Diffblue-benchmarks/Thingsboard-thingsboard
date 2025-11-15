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
package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class SimpleAlarmConditionSpecDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SimpleAlarmConditionSpec#equals(Object)}
   *   <li>{@link SimpleAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SimpleAlarmConditionSpec simpleAlarmConditionSpec = new SimpleAlarmConditionSpec();
    SimpleAlarmConditionSpec simpleAlarmConditionSpec2 = new SimpleAlarmConditionSpec();

    // Act and Assert
    assertEquals(simpleAlarmConditionSpec, simpleAlarmConditionSpec2);
    int expectedHashCodeResult = simpleAlarmConditionSpec.hashCode();
    assertEquals(expectedHashCodeResult, simpleAlarmConditionSpec2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SimpleAlarmConditionSpec#equals(Object)}
   *   <li>{@link SimpleAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SimpleAlarmConditionSpec simpleAlarmConditionSpec = new SimpleAlarmConditionSpec();

    // Act and Assert
    assertEquals(simpleAlarmConditionSpec, simpleAlarmConditionSpec);
    int expectedHashCodeResult = simpleAlarmConditionSpec.hashCode();
    assertEquals(expectedHashCodeResult, simpleAlarmConditionSpec.hashCode());
  }

  /**
   * Method under test: {@link SimpleAlarmConditionSpec#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SimpleAlarmConditionSpec(), 1);
  }

  /**
   * Method under test: {@link SimpleAlarmConditionSpec#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SimpleAlarmConditionSpec(), null);
  }

  /**
   * Method under test: {@link SimpleAlarmConditionSpec#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SimpleAlarmConditionSpec(), "Different type to SimpleAlarmConditionSpec");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SimpleAlarmConditionSpec}
   *   <li>{@link SimpleAlarmConditionSpec#toString()}
   *   <li>{@link SimpleAlarmConditionSpec#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SimpleAlarmConditionSpec actualSimpleAlarmConditionSpec = new SimpleAlarmConditionSpec();
    String actualToStringResult = actualSimpleAlarmConditionSpec.toString();

    // Assert
    assertEquals("SimpleAlarmConditionSpec()", actualToStringResult);
    assertEquals(AlarmConditionSpecType.SIMPLE, actualSimpleAlarmConditionSpec.getType());
  }
}
