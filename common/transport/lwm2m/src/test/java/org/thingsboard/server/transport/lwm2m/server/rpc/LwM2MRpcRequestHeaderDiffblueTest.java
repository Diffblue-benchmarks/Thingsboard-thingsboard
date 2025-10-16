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
package org.thingsboard.server.transport.lwm2m.server.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2MRpcRequestHeaderDiffblueTest {
  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}, and {@link
   * LwM2MRpcRequestHeader#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MRpcRequestHeader#equals(Object)}
   *   <li>{@link LwM2MRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcRequestHeader.equals(Object)",
    "int LwM2MRpcRequestHeader.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
    assertEquals(lwM2MRpcRequestHeader.hashCode(), lwM2MRpcRequestHeader2.hashCode());
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}, and {@link
   * LwM2MRpcRequestHeader#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MRpcRequestHeader#equals(Object)}
   *   <li>{@link LwM2MRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcRequestHeader.equals(Object)",
    "int LwM2MRpcRequestHeader.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat(null);
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat(null);
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
    assertEquals(lwM2MRpcRequestHeader.hashCode(), lwM2MRpcRequestHeader2.hashCode());
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}, and {@link
   * LwM2MRpcRequestHeader#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MRpcRequestHeader#equals(Object)}
   *   <li>{@link LwM2MRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcRequestHeader.equals(Object)",
    "int LwM2MRpcRequestHeader.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId(null);
    lwM2MRpcRequestHeader.setKey("Key");

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId(null);
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
    assertEquals(lwM2MRpcRequestHeader.hashCode(), lwM2MRpcRequestHeader2.hashCode());
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}, and {@link
   * LwM2MRpcRequestHeader#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MRpcRequestHeader#equals(Object)}
   *   <li>{@link LwM2MRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcRequestHeader.equals(Object)",
    "int LwM2MRpcRequestHeader.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey(null);

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey(null);

    // Act and Assert
    assertEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
    assertEquals(lwM2MRpcRequestHeader.hashCode(), lwM2MRpcRequestHeader2.hashCode());
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}, and {@link
   * LwM2MRpcRequestHeader#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MRpcRequestHeader#equals(Object)}
   *   <li>{@link LwM2MRpcRequestHeader#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcRequestHeader.equals(Object)",
    "int LwM2MRpcRequestHeader.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    // Act and Assert
    assertEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader);
    int expectedHashCodeResult = lwM2MRpcRequestHeader.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MRpcRequestHeader.hashCode());
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcRequestHeader.equals(Object)",
    "int LwM2MRpcRequestHeader.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Key");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcRequestHeader.equals(Object)",
    "int LwM2MRpcRequestHeader.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat(null);
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcRequestHeader.equals(Object)",
    "int LwM2MRpcRequestHeader.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("Key");
    lwM2MRpcRequestHeader.setKey("Key");

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcRequestHeader.equals(Object)",
    "int LwM2MRpcRequestHeader.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId(null);
    lwM2MRpcRequestHeader.setKey("Key");

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcRequestHeader.equals(Object)",
    "int LwM2MRpcRequestHeader.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("42");

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcRequestHeader.equals(Object)",
    "int LwM2MRpcRequestHeader.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey(null);

    LwM2MRpcRequestHeader lwM2MRpcRequestHeader2 = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader2.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader2.setId("42");
    lwM2MRpcRequestHeader2.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, lwM2MRpcRequestHeader2);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcRequestHeader.equals(Object)",
    "int LwM2MRpcRequestHeader.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, null);
  }

  /**
   * Test {@link LwM2MRpcRequestHeader#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcRequestHeader#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcRequestHeader.equals(Object)",
    "int LwM2MRpcRequestHeader.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2MRpcRequestHeader lwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    lwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    lwM2MRpcRequestHeader.setId("42");
    lwM2MRpcRequestHeader.setKey("Key");

    // Act and Assert
    assertNotEquals(lwM2MRpcRequestHeader, "Different type to LwM2MRpcRequestHeader");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LwM2MRpcRequestHeader}
   *   <li>{@link LwM2MRpcRequestHeader#setContentFormat(String)}
   *   <li>{@link LwM2MRpcRequestHeader#setId(String)}
   *   <li>{@link LwM2MRpcRequestHeader#setKey(String)}
   *   <li>{@link LwM2MRpcRequestHeader#toString()}
   *   <li>{@link LwM2MRpcRequestHeader#getContentFormat()}
   *   <li>{@link LwM2MRpcRequestHeader#getId()}
   *   <li>{@link LwM2MRpcRequestHeader#getKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MRpcRequestHeader.<init>()",
    "String LwM2MRpcRequestHeader.getContentFormat()",
    "String LwM2MRpcRequestHeader.getId()",
    "String LwM2MRpcRequestHeader.getKey()",
    "void LwM2MRpcRequestHeader.setContentFormat(String)",
    "void LwM2MRpcRequestHeader.setId(String)",
    "void LwM2MRpcRequestHeader.setKey(String)",
    "String LwM2MRpcRequestHeader.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MRpcRequestHeader actualLwM2MRpcRequestHeader = new LwM2MRpcRequestHeader();
    actualLwM2MRpcRequestHeader.setContentFormat("Not all who wander are lost");
    actualLwM2MRpcRequestHeader.setId("42");
    actualLwM2MRpcRequestHeader.setKey("Key");
    String actualToStringResult = actualLwM2MRpcRequestHeader.toString();
    String actualContentFormat = actualLwM2MRpcRequestHeader.getContentFormat();
    String actualId = actualLwM2MRpcRequestHeader.getId();

    // Assert
    assertEquals("42", actualId);
    assertEquals("Key", actualLwM2MRpcRequestHeader.getKey());
    assertEquals(
        "LwM2MRpcRequestHeader(key=Key, id=42, contentFormat=Not all who wander are lost)",
        actualToStringResult);
    assertEquals("Not all who wander are lost", actualContentFormat);
  }
}
