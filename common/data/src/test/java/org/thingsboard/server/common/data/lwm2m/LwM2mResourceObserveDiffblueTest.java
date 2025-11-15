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
package org.thingsboard.server.common.data.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class LwM2mResourceObserveDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mResourceObserve#equals(Object)}
   *   <li>{@link LwM2mResourceObserve#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve = new LwM2mResourceObserve(1, "Name", true, true, true);
    LwM2mResourceObserve lwM2mResourceObserve2 = new LwM2mResourceObserve(1, "Name", true, true, true);

    // Act and Assert
    assertEquals(lwM2mResourceObserve, lwM2mResourceObserve2);
    int expectedHashCodeResult = lwM2mResourceObserve.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mResourceObserve2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mResourceObserve#equals(Object)}
   *   <li>{@link LwM2mResourceObserve#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve = new LwM2mResourceObserve(1, "Name", true, true, true);

    // Act and Assert
    assertEquals(lwM2mResourceObserve, lwM2mResourceObserve);
    int expectedHashCodeResult = lwM2mResourceObserve.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mResourceObserve.hashCode());
  }

  /**
   * Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve = new LwM2mResourceObserve(2, "Name", true, true, true);

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve = new LwM2mResourceObserve(1, "name", true, true, true);

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve = new LwM2mResourceObserve(1, "Name", false, true, true);

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve = new LwM2mResourceObserve(1, "Name", true, false, true);

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve = new LwM2mResourceObserve(1, "Name", true, true, false);

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve = new LwM2mResourceObserve(1, "Name", true, true, true, "Name");

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve = new LwM2mResourceObserve(1, null, true, true, true, "Name");

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    LwM2mResourceObserve lwM2mResourceObserve = new LwM2mResourceObserve(1, "Name", true, true, true, null);

    // Act and Assert
    assertNotEquals(lwM2mResourceObserve, new LwM2mResourceObserve(1, "Name", true, true, true));
  }

  /**
   * Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2mResourceObserve(1, "Name", true, true, true), null);
  }

  /**
   * Method under test: {@link LwM2mResourceObserve#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2mResourceObserve(1, "Name", true, true, true), "Different type to LwM2mResourceObserve");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link LwM2mResourceObserve#LwM2mResourceObserve(int, String, boolean, boolean, boolean, String)}
   *   <li>{@link LwM2mResourceObserve#setAttribute(boolean)}
   *   <li>{@link LwM2mResourceObserve#setId(int)}
   *   <li>{@link LwM2mResourceObserve#setKeyName(String)}
   *   <li>{@link LwM2mResourceObserve#setName(String)}
   *   <li>{@link LwM2mResourceObserve#setObserve(boolean)}
   *   <li>{@link LwM2mResourceObserve#setTelemetry(boolean)}
   *   <li>{@link LwM2mResourceObserve#toString()}
   *   <li>{@link LwM2mResourceObserve#getId()}
   *   <li>{@link LwM2mResourceObserve#getKeyName()}
   *   <li>{@link LwM2mResourceObserve#getName()}
   *   <li>{@link LwM2mResourceObserve#isAttribute()}
   *   <li>{@link LwM2mResourceObserve#isObserve()}
   *   <li>{@link LwM2mResourceObserve#isTelemetry()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2mResourceObserve actualLwM2mResourceObserve = new LwM2mResourceObserve(1, "Name", true, true, true, "Key Name");
    actualLwM2mResourceObserve.setAttribute(true);
    actualLwM2mResourceObserve.setId(1);
    actualLwM2mResourceObserve.setKeyName("Key Name");
    actualLwM2mResourceObserve.setName("Name");
    actualLwM2mResourceObserve.setObserve(true);
    actualLwM2mResourceObserve.setTelemetry(true);
    String actualToStringResult = actualLwM2mResourceObserve.toString();
    int actualId = actualLwM2mResourceObserve.getId();
    String actualKeyName = actualLwM2mResourceObserve.getKeyName();
    String actualName = actualLwM2mResourceObserve.getName();
    boolean actualIsAttributeResult = actualLwM2mResourceObserve.isAttribute();
    boolean actualIsObserveResult = actualLwM2mResourceObserve.isObserve();

    // Assert that nothing has changed
    assertEquals("Key Name", actualKeyName);
    assertEquals(
        "LwM2mResourceObserve(id=1, name=Name, observe=true, attribute=true, telemetry=true, keyName=Key" + " Name)",
        actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals(1, actualId);
    assertTrue(actualIsAttributeResult);
    assertTrue(actualIsObserveResult);
    assertTrue(actualLwM2mResourceObserve.isTelemetry());
  }

  /**
   * Method under test:
   * {@link LwM2mResourceObserve#LwM2mResourceObserve(int, String, boolean, boolean, boolean)}
   */
  @Test
  void testNewLwM2mResourceObserve() {
    // Arrange and Act
    LwM2mResourceObserve actualLwM2mResourceObserve = new LwM2mResourceObserve(1, "Name", true, true, true);

    // Assert
    assertEquals("Name", actualLwM2mResourceObserve.getName());
    assertEquals("name", actualLwM2mResourceObserve.getKeyName());
    assertEquals(1, actualLwM2mResourceObserve.getId());
    assertTrue(actualLwM2mResourceObserve.isAttribute());
    assertTrue(actualLwM2mResourceObserve.isObserve());
    assertTrue(actualLwM2mResourceObserve.isTelemetry());
  }

  /**
   * Method under test:
   * {@link LwM2mResourceObserve#LwM2mResourceObserve(int, String, boolean, boolean, boolean)}
   */
  @Test
  void testNewLwM2mResourceObserve2() {
    // Arrange and Act
    LwM2mResourceObserve actualLwM2mResourceObserve = new LwM2mResourceObserve(1, "-", true, true, true);

    // Assert
    assertEquals("", actualLwM2mResourceObserve.getKeyName());
    assertEquals("-", actualLwM2mResourceObserve.getName());
    assertEquals(1, actualLwM2mResourceObserve.getId());
    assertTrue(actualLwM2mResourceObserve.isAttribute());
    assertTrue(actualLwM2mResourceObserve.isObserve());
    assertTrue(actualLwM2mResourceObserve.isTelemetry());
  }

  /**
   * Method under test:
   * {@link LwM2mResourceObserve#LwM2mResourceObserve(int, String, boolean, boolean, boolean)}
   */
  @Test
  void testNewLwM2mResourceObserve3() {
    // Arrange and Act
    LwM2mResourceObserve actualLwM2mResourceObserve = new LwM2mResourceObserve(1, LwM2mConstants.LWM2M_SEPARATOR_KEY,
        true, true, true);

    // Assert
    assertEquals("", actualLwM2mResourceObserve.getKeyName());
    assertEquals(1, actualLwM2mResourceObserve.getId());
    assertTrue(actualLwM2mResourceObserve.isAttribute());
    assertTrue(actualLwM2mResourceObserve.isObserve());
    assertTrue(actualLwM2mResourceObserve.isTelemetry());
    assertEquals(LwM2mConstants.LWM2M_SEPARATOR_KEY, actualLwM2mResourceObserve.getName());
  }

  /**
   * Method under test:
   * {@link LwM2mResourceObserve#LwM2mResourceObserve(int, String, boolean, boolean, boolean)}
   */
  @Test
  void testNewLwM2mResourceObserve4() {
    // Arrange and Act
    LwM2mResourceObserve actualLwM2mResourceObserve = new LwM2mResourceObserve(1, "", true, true, true);

    // Assert
    assertEquals("", actualLwM2mResourceObserve.getKeyName());
    assertEquals("", actualLwM2mResourceObserve.getName());
    assertEquals(1, actualLwM2mResourceObserve.getId());
    assertTrue(actualLwM2mResourceObserve.isAttribute());
    assertTrue(actualLwM2mResourceObserve.isObserve());
    assertTrue(actualLwM2mResourceObserve.isTelemetry());
  }
}
