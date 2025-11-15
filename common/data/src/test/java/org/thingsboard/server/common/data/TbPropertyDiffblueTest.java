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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbPropertyDiffblueTest {
  /**
   * Test {@link TbProperty#equals(Object)}, and {@link TbProperty#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbProperty#equals(Object)}
   *   <li>{@link TbProperty#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProperty.equals(Object)", "int TbProperty.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey("Key");
    tbProperty.setValue("42");

    TbProperty tbProperty2 = new TbProperty();
    tbProperty2.setKey("Key");
    tbProperty2.setValue("42");

    // Act and Assert
    assertEquals(tbProperty, tbProperty2);
    int expectedHashCodeResult = tbProperty.hashCode();
    assertEquals(expectedHashCodeResult, tbProperty2.hashCode());
  }

  /**
   * Test {@link TbProperty#equals(Object)}, and {@link TbProperty#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbProperty#equals(Object)}
   *   <li>{@link TbProperty#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProperty.equals(Object)", "int TbProperty.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey(null);
    tbProperty.setValue("42");

    TbProperty tbProperty2 = new TbProperty();
    tbProperty2.setKey(null);
    tbProperty2.setValue("42");

    // Act and Assert
    assertEquals(tbProperty, tbProperty2);
    int expectedHashCodeResult = tbProperty.hashCode();
    assertEquals(expectedHashCodeResult, tbProperty2.hashCode());
  }

  /**
   * Test {@link TbProperty#equals(Object)}, and {@link TbProperty#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbProperty#equals(Object)}
   *   <li>{@link TbProperty#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProperty.equals(Object)", "int TbProperty.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey("Key");
    tbProperty.setValue(null);

    TbProperty tbProperty2 = new TbProperty();
    tbProperty2.setKey("Key");
    tbProperty2.setValue(null);

    // Act and Assert
    assertEquals(tbProperty, tbProperty2);
    int expectedHashCodeResult = tbProperty.hashCode();
    assertEquals(expectedHashCodeResult, tbProperty2.hashCode());
  }

  /**
   * Test {@link TbProperty#equals(Object)}, and {@link TbProperty#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbProperty#equals(Object)}
   *   <li>{@link TbProperty#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProperty.equals(Object)", "int TbProperty.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey("Key");
    tbProperty.setValue("42");

    // Act and Assert
    assertEquals(tbProperty, tbProperty);
    int expectedHashCodeResult = tbProperty.hashCode();
    assertEquals(expectedHashCodeResult, tbProperty.hashCode());
  }

  /**
   * Test {@link TbProperty#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProperty.equals(Object)", "int TbProperty.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey("42");
    tbProperty.setValue("42");

    TbProperty tbProperty2 = new TbProperty();
    tbProperty2.setKey("Key");
    tbProperty2.setValue("42");

    // Act and Assert
    assertNotEquals(tbProperty, tbProperty2);
  }

  /**
   * Test {@link TbProperty#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProperty.equals(Object)", "int TbProperty.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey(null);
    tbProperty.setValue("42");

    TbProperty tbProperty2 = new TbProperty();
    tbProperty2.setKey("Key");
    tbProperty2.setValue("42");

    // Act and Assert
    assertNotEquals(tbProperty, tbProperty2);
  }

  /**
   * Test {@link TbProperty#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProperty.equals(Object)", "int TbProperty.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey("Key");
    tbProperty.setValue("Key");

    TbProperty tbProperty2 = new TbProperty();
    tbProperty2.setKey("Key");
    tbProperty2.setValue("42");

    // Act and Assert
    assertNotEquals(tbProperty, tbProperty2);
  }

  /**
   * Test {@link TbProperty#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProperty.equals(Object)", "int TbProperty.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey("Key");
    tbProperty.setValue(null);

    TbProperty tbProperty2 = new TbProperty();
    tbProperty2.setKey("Key");
    tbProperty2.setValue("42");

    // Act and Assert
    assertNotEquals(tbProperty, tbProperty2);
  }

  /**
   * Test {@link TbProperty#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProperty.equals(Object)", "int TbProperty.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey("Key");
    tbProperty.setValue("42");

    // Act and Assert
    assertNotEquals(tbProperty, null);
  }

  /**
   * Test {@link TbProperty#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbProperty.equals(Object)", "int TbProperty.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TbProperty tbProperty = new TbProperty();
    tbProperty.setKey("Key");
    tbProperty.setValue("42");

    // Act and Assert
    assertNotEquals(tbProperty, "Different type to TbProperty");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbProperty}
   *   <li>{@link TbProperty#setKey(String)}
   *   <li>{@link TbProperty#setValue(String)}
   *   <li>{@link TbProperty#toString()}
   *   <li>{@link TbProperty#getKey()}
   *   <li>{@link TbProperty#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbProperty.<init>()", "String TbProperty.getKey()", "String TbProperty.getValue()",
      "void TbProperty.setKey(String)", "void TbProperty.setValue(String)", "String TbProperty.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TbProperty actualTbProperty = new TbProperty();
    actualTbProperty.setKey("Key");
    actualTbProperty.setValue("42");
    String actualToStringResult = actualTbProperty.toString();
    String actualKey = actualTbProperty.getKey();

    // Assert
    assertEquals("42", actualTbProperty.getValue());
    assertEquals("Key", actualKey);
    assertEquals("TbProperty(key=Key, value=42)", actualToStringResult);
  }
}
