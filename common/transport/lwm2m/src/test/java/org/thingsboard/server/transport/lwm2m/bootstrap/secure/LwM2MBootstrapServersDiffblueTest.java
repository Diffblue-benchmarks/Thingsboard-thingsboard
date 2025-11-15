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
package org.thingsboard.server.transport.lwm2m.bootstrap.secure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class LwM2MBootstrapServersDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MBootstrapServers#equals(Object)}
   *   <li>{@link LwM2MBootstrapServers#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
    int expectedHashCodeResult = lwM2MBootstrapServers.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MBootstrapServers2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MBootstrapServers#equals(Object)}
   *   <li>{@link LwM2MBootstrapServers#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding(null);
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding(null);
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
    int expectedHashCodeResult = lwM2MBootstrapServers.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MBootstrapServers2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MBootstrapServers#equals(Object)}
   *   <li>{@link LwM2MBootstrapServers#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(null);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(null);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
    int expectedHashCodeResult = lwM2MBootstrapServers.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MBootstrapServers2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MBootstrapServers#equals(Object)}
   *   <li>{@link LwM2MBootstrapServers#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(null);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(null);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
    int expectedHashCodeResult = lwM2MBootstrapServers.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MBootstrapServers2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MBootstrapServers#equals(Object)}
   *   <li>{@link LwM2MBootstrapServers#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    // Act and Assert
    assertEquals(lwM2MBootstrapServers, lwM2MBootstrapServers);
    int expectedHashCodeResult = lwM2MBootstrapServers.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MBootstrapServers.hashCode());
  }

  /**
   * Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding(null);
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("UQ");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(3);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(null);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(3);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(null);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(false);
    lwM2MBootstrapServers.setShortId(1);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(2);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(null);

    LwM2MBootstrapServers lwM2MBootstrapServers2 = new LwM2MBootstrapServers();
    lwM2MBootstrapServers2.setBinding("Binding");
    lwM2MBootstrapServers2.setDefaultMinPeriod(1);
    lwM2MBootstrapServers2.setLifetime(1);
    lwM2MBootstrapServers2.setNotifIfDisabled(true);
    lwM2MBootstrapServers2.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, lwM2MBootstrapServers2);
  }

  /**
   * Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, null);
  }

  /**
   * Method under test: {@link LwM2MBootstrapServers#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2MBootstrapServers lwM2MBootstrapServers = new LwM2MBootstrapServers();
    lwM2MBootstrapServers.setBinding("Binding");
    lwM2MBootstrapServers.setDefaultMinPeriod(1);
    lwM2MBootstrapServers.setLifetime(1);
    lwM2MBootstrapServers.setNotifIfDisabled(true);
    lwM2MBootstrapServers.setShortId(1);

    // Act and Assert
    assertNotEquals(lwM2MBootstrapServers, "Different type to LwM2MBootstrapServers");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2MBootstrapServers}
   *   <li>{@link LwM2MBootstrapServers#setBinding(String)}
   *   <li>{@link LwM2MBootstrapServers#setDefaultMinPeriod(Integer)}
   *   <li>{@link LwM2MBootstrapServers#setLifetime(Integer)}
   *   <li>{@link LwM2MBootstrapServers#setNotifIfDisabled(boolean)}
   *   <li>{@link LwM2MBootstrapServers#setShortId(Integer)}
   *   <li>{@link LwM2MBootstrapServers#toString()}
   *   <li>{@link LwM2MBootstrapServers#getBinding()}
   *   <li>{@link LwM2MBootstrapServers#getDefaultMinPeriod()}
   *   <li>{@link LwM2MBootstrapServers#getLifetime()}
   *   <li>{@link LwM2MBootstrapServers#getShortId()}
   *   <li>{@link LwM2MBootstrapServers#isNotifIfDisabled()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MBootstrapServers actualLwM2MBootstrapServers = new LwM2MBootstrapServers();
    actualLwM2MBootstrapServers.setBinding("Binding");
    actualLwM2MBootstrapServers.setDefaultMinPeriod(1);
    actualLwM2MBootstrapServers.setLifetime(1);
    actualLwM2MBootstrapServers.setNotifIfDisabled(true);
    actualLwM2MBootstrapServers.setShortId(1);
    String actualToStringResult = actualLwM2MBootstrapServers.toString();
    String actualBinding = actualLwM2MBootstrapServers.getBinding();
    Integer actualDefaultMinPeriod = actualLwM2MBootstrapServers.getDefaultMinPeriod();
    Integer actualLifetime = actualLwM2MBootstrapServers.getLifetime();
    Integer actualShortId = actualLwM2MBootstrapServers.getShortId();
    boolean actualIsNotifIfDisabledResult = actualLwM2MBootstrapServers.isNotifIfDisabled();

    // Assert that nothing has changed
    assertEquals("Binding", actualBinding);
    assertEquals(
        "LwM2MBootstrapServers(shortId=1, lifetime=1, defaultMinPeriod=1, notifIfDisabled=true," + " binding=Binding)",
        actualToStringResult);
    assertEquals(1, actualDefaultMinPeriod.intValue());
    assertEquals(1, actualLifetime.intValue());
    assertEquals(1, actualShortId.intValue());
    assertTrue(actualIsNotifIfDisabledResult);
  }
}
