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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class LwM2mInstanceDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mInstance#equals(Object)}
   *   <li>{@link LwM2mInstance#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    // Act and Assert
    assertEquals(lwM2mInstance, lwM2mInstance2);
    int expectedHashCodeResult = lwM2mInstance.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mInstance2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mInstance#equals(Object)}
   *   <li>{@link LwM2mInstance#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    // Act and Assert
    assertEquals(lwM2mInstance, lwM2mInstance);
    int expectedHashCodeResult = lwM2mInstance.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mInstance.hashCode());
  }

  /**
   * Method under test: {@link LwM2mInstance#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(2);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    // Act and Assert
    assertNotEquals(lwM2mInstance, lwM2mInstance2);
  }

  /**
   * Method under test: {@link LwM2mInstance#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(2, "Name", true, true, true)});

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    // Act and Assert
    assertNotEquals(lwM2mInstance, lwM2mInstance2);
  }

  /**
   * Method under test: {@link LwM2mInstance#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{mock(LwM2mResourceObserve.class)});

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    // Act and Assert
    assertNotEquals(lwM2mInstance, lwM2mInstance2);
  }

  /**
   * Method under test: {@link LwM2mInstance#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    // Act and Assert
    assertNotEquals(lwM2mInstance, null);
  }

  /**
   * Method under test: {@link LwM2mInstance#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    lwM2mInstance.setResources(new LwM2mResourceObserve[]{new LwM2mResourceObserve(1, "Name", true, true, true)});

    // Act and Assert
    assertNotEquals(lwM2mInstance, "Different type to LwM2mInstance");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2mInstance}
   *   <li>{@link LwM2mInstance#setId(int)}
   *   <li>{@link LwM2mInstance#setResources(LwM2mResourceObserve[])}
   *   <li>{@link LwM2mInstance#toString()}
   *   <li>{@link LwM2mInstance#getId()}
   *   <li>{@link LwM2mInstance#getResources()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2mInstance actualLwM2mInstance = new LwM2mInstance();
    actualLwM2mInstance.setId(1);
    LwM2mResourceObserve[] resources = new LwM2mResourceObserve[]{
        new LwM2mResourceObserve(1, "Name", true, true, true)};
    actualLwM2mInstance.setResources(resources);
    String actualToStringResult = actualLwM2mInstance.toString();
    int actualId = actualLwM2mInstance.getId();

    // Assert that nothing has changed
    assertEquals("LwM2mInstance(id=1, resources=[LwM2mResourceObserve(id=1, name=Name, observe=true, attribute=true,"
        + " telemetry=true, keyName=name)])", actualToStringResult);
    assertEquals(1, actualId);
    assertSame(resources, actualLwM2mInstance.getResources());
  }
}
