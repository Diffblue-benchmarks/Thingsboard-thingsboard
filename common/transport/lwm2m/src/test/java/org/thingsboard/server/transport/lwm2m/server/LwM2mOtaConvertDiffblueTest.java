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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.model.ResourceModel.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2mOtaConvertDiffblueTest {
  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}, and {@link LwM2mOtaConvert#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mOtaConvert#equals(Object)}
   *   <li>{@link LwM2mOtaConvert#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mOtaConvert.equals(Object)", "int LwM2mOtaConvert.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(Type.NONE);
    lwM2mOtaConvert.setValue("Value");

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(Type.NONE);
    lwM2mOtaConvert2.setValue("Value");

    // Act and Assert
    assertEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
    assertEquals(lwM2mOtaConvert.hashCode(), lwM2mOtaConvert2.hashCode());
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}, and {@link LwM2mOtaConvert#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mOtaConvert#equals(Object)}
   *   <li>{@link LwM2mOtaConvert#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mOtaConvert.equals(Object)", "int LwM2mOtaConvert.hashCode()"})
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
    assertEquals(lwM2mOtaConvert.hashCode(), lwM2mOtaConvert2.hashCode());
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}, and {@link LwM2mOtaConvert#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mOtaConvert#equals(Object)}
   *   <li>{@link LwM2mOtaConvert#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mOtaConvert.equals(Object)", "int LwM2mOtaConvert.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(Type.NONE);
    lwM2mOtaConvert.setValue(null);

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(Type.NONE);
    lwM2mOtaConvert2.setValue(null);

    // Act and Assert
    assertEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
    assertEquals(lwM2mOtaConvert.hashCode(), lwM2mOtaConvert2.hashCode());
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}, and {@link LwM2mOtaConvert#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mOtaConvert#equals(Object)}
   *   <li>{@link LwM2mOtaConvert#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mOtaConvert.equals(Object)", "int LwM2mOtaConvert.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(Type.NONE);
    lwM2mOtaConvert.setValue("Value");

    // Act and Assert
    assertEquals(lwM2mOtaConvert, lwM2mOtaConvert);
    int expectedHashCodeResult = lwM2mOtaConvert.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mOtaConvert.hashCode());
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mOtaConvert.equals(Object)", "int LwM2mOtaConvert.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(null);
    lwM2mOtaConvert.setValue("Value");

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(Type.NONE);
    lwM2mOtaConvert2.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mOtaConvert.equals(Object)", "int LwM2mOtaConvert.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(Type.STRING);
    lwM2mOtaConvert.setValue("Value");

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(Type.NONE);
    lwM2mOtaConvert2.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mOtaConvert.equals(Object)", "int LwM2mOtaConvert.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(Type.NONE);
    lwM2mOtaConvert.setValue("Value");

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(Type.NONE);
    lwM2mOtaConvert2.setValue(lwM2mOtaConvert);

    LwM2mOtaConvert lwM2mOtaConvert3 = new LwM2mOtaConvert();
    lwM2mOtaConvert3.setCurrentType(Type.NONE);
    lwM2mOtaConvert3.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert2, lwM2mOtaConvert3);
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mOtaConvert.equals(Object)", "int LwM2mOtaConvert.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(Type.NONE);
    lwM2mOtaConvert.setValue(null);

    LwM2mOtaConvert lwM2mOtaConvert2 = new LwM2mOtaConvert();
    lwM2mOtaConvert2.setCurrentType(Type.NONE);
    lwM2mOtaConvert2.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert, lwM2mOtaConvert2);
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mOtaConvert.equals(Object)", "int LwM2mOtaConvert.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(Type.NONE);
    lwM2mOtaConvert.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert, null);
  }

  /**
   * Test {@link LwM2mOtaConvert#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mOtaConvert#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mOtaConvert.equals(Object)", "int LwM2mOtaConvert.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2mOtaConvert lwM2mOtaConvert = new LwM2mOtaConvert();
    lwM2mOtaConvert.setCurrentType(Type.NONE);
    lwM2mOtaConvert.setValue("Value");

    // Act and Assert
    assertNotEquals(lwM2mOtaConvert, "Different type to LwM2mOtaConvert");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2mOtaConvert}
   *   <li>{@link LwM2mOtaConvert#setCurrentType(Type)}
   *   <li>{@link LwM2mOtaConvert#setValue(Object)}
   *   <li>{@link LwM2mOtaConvert#toString()}
   *   <li>{@link LwM2mOtaConvert#getCurrentType()}
   *   <li>{@link LwM2mOtaConvert#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mOtaConvert.<init>()",
    "Type LwM2mOtaConvert.getCurrentType()",
    "Object LwM2mOtaConvert.getValue()",
    "void LwM2mOtaConvert.setCurrentType(Type)",
    "void LwM2mOtaConvert.setValue(Object)",
    "String LwM2mOtaConvert.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2mOtaConvert actualLwM2mOtaConvert = new LwM2mOtaConvert();
    actualLwM2mOtaConvert.setCurrentType(Type.NONE);
    actualLwM2mOtaConvert.setValue("Value");
    String actualToStringResult = actualLwM2mOtaConvert.toString();
    Type actualCurrentType = actualLwM2mOtaConvert.getCurrentType();

    // Assert
    assertEquals("LwM2mOtaConvert(currentType=NONE, value=Value)", actualToStringResult);
    assertEquals("Value", actualLwM2mOtaConvert.getValue());
    assertEquals(Type.NONE, actualCurrentType);
  }
}
