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
import org.junit.jupiter.api.Test;

class DefaultRuleChainCreateRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultRuleChainCreateRequest#equals(Object)}
   *   <li>{@link DefaultRuleChainCreateRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName("Name");

    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest2 = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest2.setName("Name");

    // Act and Assert
    assertEquals(defaultRuleChainCreateRequest, defaultRuleChainCreateRequest2);
    int expectedHashCodeResult = defaultRuleChainCreateRequest.hashCode();
    assertEquals(expectedHashCodeResult, defaultRuleChainCreateRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultRuleChainCreateRequest#equals(Object)}
   *   <li>{@link DefaultRuleChainCreateRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName(null);

    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest2 = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest2.setName(null);

    // Act and Assert
    assertEquals(defaultRuleChainCreateRequest, defaultRuleChainCreateRequest2);
    int expectedHashCodeResult = defaultRuleChainCreateRequest.hashCode();
    assertEquals(expectedHashCodeResult, defaultRuleChainCreateRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultRuleChainCreateRequest#equals(Object)}
   *   <li>{@link DefaultRuleChainCreateRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName("Name");

    // Act and Assert
    assertEquals(defaultRuleChainCreateRequest, defaultRuleChainCreateRequest);
    int expectedHashCodeResult = defaultRuleChainCreateRequest.hashCode();
    assertEquals(expectedHashCodeResult, defaultRuleChainCreateRequest.hashCode());
  }

  /**
   * Method under test: {@link DefaultRuleChainCreateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName(null);

    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest2 = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest2.setName("Name");

    // Act and Assert
    assertNotEquals(defaultRuleChainCreateRequest, defaultRuleChainCreateRequest2);
  }

  /**
   * Method under test: {@link DefaultRuleChainCreateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName("org.thingsboard.server.common.data.rule.DefaultRuleChainCreateRequest");

    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest2 = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest2.setName("Name");

    // Act and Assert
    assertNotEquals(defaultRuleChainCreateRequest, defaultRuleChainCreateRequest2);
  }

  /**
   * Method under test: {@link DefaultRuleChainCreateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName("Name");

    // Act and Assert
    assertNotEquals(defaultRuleChainCreateRequest, null);
  }

  /**
   * Method under test: {@link DefaultRuleChainCreateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DefaultRuleChainCreateRequest defaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    defaultRuleChainCreateRequest.setName("Name");

    // Act and Assert
    assertNotEquals(defaultRuleChainCreateRequest, "Different type to DefaultRuleChainCreateRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link DefaultRuleChainCreateRequest}
   *   <li>{@link DefaultRuleChainCreateRequest#setName(String)}
   *   <li>{@link DefaultRuleChainCreateRequest#toString()}
   *   <li>{@link DefaultRuleChainCreateRequest#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultRuleChainCreateRequest actualDefaultRuleChainCreateRequest = new DefaultRuleChainCreateRequest();
    actualDefaultRuleChainCreateRequest.setName("Name");
    String actualToStringResult = actualDefaultRuleChainCreateRequest.toString();

    // Assert that nothing has changed
    assertEquals("DefaultRuleChainCreateRequest(name=Name)", actualToStringResult);
    assertEquals("Name", actualDefaultRuleChainCreateRequest.getName());
  }
}
