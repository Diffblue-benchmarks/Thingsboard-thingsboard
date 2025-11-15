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
package org.thingsboard.server.transport.lwm2m.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.eclipse.leshan.core.model.ResourceModel;
import org.junit.jupiter.api.Test;

class LwM2mOtaConvertDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mOtaConvert#equals(Object)}
   *   <li>{@link LwM2mOtaConvert#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert.setValue("Value");

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert2.setValue("Value");

    // Act and Assert
    assertEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
    int expectedHashCodeResult = lwM2mOtaConvert.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mOtaConvert2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mOtaConvert#equals(Object)}
   *   <li>{@link LwM2mOtaConvert#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(null);
    lwM2mOtaConvert.setValue("Value");

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(null);
    lwM2mOtaConvert2.setValue("Value");

    // Act and Assert
    assertEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
    int expectedHashCodeResult = lwM2mOtaConvert.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mOtaConvert2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mOtaConvert#equals(Object)}
   *   <li>{@link LwM2mOtaConvert#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert.setValue(null);

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert2.setValue(null);

    // Act and Assert
    assertEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
    int expectedHashCodeResult = lwM2mOtaConvert.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mOtaConvert2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2mOtaConvert#equals(Object)}
   *   <li>{@link LwM2mOtaConvert#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert.setValue("Value");

    // Act and Assert
    assertEquals(lwM2mOtaConvert, lwM2mOtaConvert);
    int expectedHashCodeResult = lwM2mOtaConvert.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mOtaConvert.hashCode());
  }

  /**
   * Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(null);
    lwM2mOtaConvert.setValue("Value");

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert2.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
  }

  /**
   * Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.STRING);
    lwM2mOtaConvert.setValue("Value");

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert2.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
  }

  /**
   * Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert.setValue("Value");

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert2.setValue(lwM2mOtaConvert);

    LwM2mOtaConvert lwM2mOtaConvert3 = new LwM2mOtaConvert();
    lwM2mOtaConvert3.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert3.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert2, lwM2mOtaConvert3);
  }

  /**
   * Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert.setValue(null);

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert2.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
  }

  /**
   * Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert, null);
  }

  /**
   * Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    lwM2mOtaConvert.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert, "Different type to LwM2mOtaConvert");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2mOtaConvert}
   *   <li>{@link LwM2mOtaConvert#setCurrentType(ResourceModel.Type)}
   *   <li>{@link LwM2mOtaConvert#setValue(Object)}
   *   <li>{@link LwM2mOtaConvert#toString()}
   *   <li>{@link LwM2mOtaConvert#getCurrentType()}
   *   <li>{@link LwM2mOtaConvert#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2mOtaConvert actualLwM2mOtaConvert = new LwM2mOtaConvert();
    actualLwM2mOtaConvert.setCurrentType(ResourceModel.Type.NONE);
    actualLwM2mOtaConvert.setValue("Value");
    String actualToStringResult = actualLwM2mOtaConvert.toString();
    ResourceModel.Type actualCurrentType = actualLwM2mOtaConvert.getCurrentType();

    // Assert that nothing has changed
    assertEquals("LwM2mOtaConvert(currentType=NONE, value=Value)", actualToStringResult);
    assertEquals("Value", actualLwM2mOtaConvert.getValue());
    assertEquals(ResourceModel.Type.NONE, actualCurrentType);
  }
}
