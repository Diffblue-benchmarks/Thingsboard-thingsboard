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
package org.thingsboard.server.transport.lwm2m.bootstrap.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class LwM2MBootstrapClientInstanceIdsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MBootstrapClientInstanceIds#equals(Object)}
   *   <li>{@link LwM2MBootstrapClientInstanceIds#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds = new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds.setServerInstances(new HashMap<>());

    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds2 = new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds2.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds2.setServerInstances(new HashMap<>());

    // Act and Assert
    assertEquals(lwM2MBootstrapClientInstanceIds, lwM2MBootstrapClientInstanceIds2);
    int expectedHashCodeResult = lwM2MBootstrapClientInstanceIds.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MBootstrapClientInstanceIds2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MBootstrapClientInstanceIds#equals(Object)}
   *   <li>{@link LwM2MBootstrapClientInstanceIds#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds = new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds.setServerInstances(new HashMap<>());

    // Act and Assert
    assertEquals(lwM2MBootstrapClientInstanceIds, lwM2MBootstrapClientInstanceIds);
    int expectedHashCodeResult = lwM2MBootstrapClientInstanceIds.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MBootstrapClientInstanceIds.hashCode());
  }

  /**
   * Method under test: {@link LwM2MBootstrapClientInstanceIds#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<Integer, Integer> securityInstances = new HashMap<>();
    securityInstances.put(1, 1);

    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds = new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds.setSecurityInstances(securityInstances);
    lwM2MBootstrapClientInstanceIds.setServerInstances(new HashMap<>());

    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds2 = new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds2.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds2.setServerInstances(new HashMap<>());

    // Act and Assert
    assertNotEquals(lwM2MBootstrapClientInstanceIds, lwM2MBootstrapClientInstanceIds2);
  }

  /**
   * Method under test: {@link LwM2MBootstrapClientInstanceIds#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<Integer, Integer> securityInstances = new HashMap<>();
    securityInstances.computeIfPresent(1, mock(BiFunction.class));
    securityInstances.put(1, 1);

    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds = new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds.setSecurityInstances(securityInstances);
    lwM2MBootstrapClientInstanceIds.setServerInstances(new HashMap<>());

    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds2 = new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds2.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds2.setServerInstances(new HashMap<>());

    // Act and Assert
    assertNotEquals(lwM2MBootstrapClientInstanceIds, lwM2MBootstrapClientInstanceIds2);
  }

  /**
   * Method under test: {@link LwM2MBootstrapClientInstanceIds#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashMap<Integer, Integer> serverInstances = new HashMap<>();
    serverInstances.put(1, 1);

    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds = new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds.setServerInstances(serverInstances);

    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds2 = new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds2.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds2.setServerInstances(new HashMap<>());

    // Act and Assert
    assertNotEquals(lwM2MBootstrapClientInstanceIds, lwM2MBootstrapClientInstanceIds2);
  }

  /**
   * Method under test: {@link LwM2MBootstrapClientInstanceIds#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds = new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds.setServerInstances(new HashMap<>());

    // Act and Assert
    assertNotEquals(lwM2MBootstrapClientInstanceIds, null);
  }

  /**
   * Method under test: {@link LwM2MBootstrapClientInstanceIds#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2MBootstrapClientInstanceIds lwM2MBootstrapClientInstanceIds = new LwM2MBootstrapClientInstanceIds();
    lwM2MBootstrapClientInstanceIds.setSecurityInstances(new HashMap<>());
    lwM2MBootstrapClientInstanceIds.setServerInstances(new HashMap<>());

    // Act and Assert
    assertNotEquals(lwM2MBootstrapClientInstanceIds, "Different type to LwM2MBootstrapClientInstanceIds");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link LwM2MBootstrapClientInstanceIds}
   *   <li>{@link LwM2MBootstrapClientInstanceIds#setSecurityInstances(Map)}
   *   <li>{@link LwM2MBootstrapClientInstanceIds#setServerInstances(Map)}
   *   <li>{@link LwM2MBootstrapClientInstanceIds#toString()}
   *   <li>{@link LwM2MBootstrapClientInstanceIds#getSecurityInstances()}
   *   <li>{@link LwM2MBootstrapClientInstanceIds#getServerInstances()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MBootstrapClientInstanceIds actualLwM2MBootstrapClientInstanceIds = new LwM2MBootstrapClientInstanceIds();
    HashMap<Integer, Integer> securityInstances = new HashMap<>();
    actualLwM2MBootstrapClientInstanceIds.setSecurityInstances(securityInstances);
    HashMap<Integer, Integer> serverInstances = new HashMap<>();
    actualLwM2MBootstrapClientInstanceIds.setServerInstances(serverInstances);
    String actualToStringResult = actualLwM2MBootstrapClientInstanceIds.toString();
    Map<Integer, Integer> actualSecurityInstances = actualLwM2MBootstrapClientInstanceIds.getSecurityInstances();
    Map<Integer, Integer> actualServerInstances = actualLwM2MBootstrapClientInstanceIds.getServerInstances();

    // Assert that nothing has changed
    assertEquals("LwM2MBootstrapClientInstanceIds(securityInstances={}, serverInstances={})", actualToStringResult);
    assertTrue(actualSecurityInstances.isEmpty());
    assertTrue(actualServerInstances.isEmpty());
    assertSame(securityInstances, actualSecurityInstances);
    assertSame(serverInstances, actualServerInstances);
  }
}
