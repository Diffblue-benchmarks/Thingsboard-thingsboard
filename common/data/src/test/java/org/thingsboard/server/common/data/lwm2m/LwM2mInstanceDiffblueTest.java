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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2mInstanceDiffblueTest {
  /**
   * Test {@link LwM2mInstance#equals(Object)}, and {@link LwM2mInstance#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mInstance#equals(Object)}
   *   <li>{@link LwM2mInstance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mInstance.equals(Object)", "int LwM2mInstance.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(1, "Name", true, true, true);
    lwM2mInstance.setResources(new LwM2mResourceObserve[] {lwM2mResourceObserve});

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    LwM2mResourceObserve lwM2mResourceObserve2 =
        new LwM2mResourceObserve(1, "Name", true, true, true);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[] {lwM2mResourceObserve2});

    // Act and Assert
    assertEquals(lwM2mInstance, lwM2mInstance2);
    assertEquals(lwM2mInstance.hashCode(), lwM2mInstance2.hashCode());
  }

  /**
   * Test {@link LwM2mInstance#equals(Object)}, and {@link LwM2mInstance#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2mInstance#equals(Object)}
   *   <li>{@link LwM2mInstance#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mInstance.equals(Object)", "int LwM2mInstance.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(1, "Name", true, true, true);
    lwM2mInstance.setResources(new LwM2mResourceObserve[] {lwM2mResourceObserve});

    // Act and Assert
    assertEquals(lwM2mInstance, lwM2mInstance);
    int expectedHashCodeResult = lwM2mInstance.hashCode();
    assertEquals(expectedHashCodeResult, lwM2mInstance.hashCode());
  }

  /**
   * Test {@link LwM2mInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mInstance.equals(Object)", "int LwM2mInstance.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(2);
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(1, "Name", true, true, true);
    lwM2mInstance.setResources(new LwM2mResourceObserve[] {lwM2mResourceObserve});

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    LwM2mResourceObserve lwM2mResourceObserve2 =
        new LwM2mResourceObserve(1, "Name", true, true, true);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[] {lwM2mResourceObserve2});

    // Act and Assert
    assertNotEquals(lwM2mInstance, lwM2mInstance2);
  }

  /**
   * Test {@link LwM2mInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mInstance.equals(Object)", "int LwM2mInstance.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(2, "Name", true, true, true);
    lwM2mInstance.setResources(new LwM2mResourceObserve[] {lwM2mResourceObserve});

    LwM2mInstance lwM2mInstance2 = new LwM2mInstance();
    lwM2mInstance2.setId(1);
    LwM2mResourceObserve lwM2mResourceObserve2 =
        new LwM2mResourceObserve(1, "Name", true, true, true);
    lwM2mInstance2.setResources(new LwM2mResourceObserve[] {lwM2mResourceObserve2});

    // Act and Assert
    assertNotEquals(lwM2mInstance, lwM2mInstance2);
  }

  /**
   * Test {@link LwM2mInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mInstance.equals(Object)", "int LwM2mInstance.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(1, "Name", true, true, true);
    lwM2mInstance.setResources(new LwM2mResourceObserve[] {lwM2mResourceObserve});

    // Act and Assert
    assertNotEquals(lwM2mInstance, null);
  }

  /**
   * Test {@link LwM2mInstance#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mInstance#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LwM2mInstance.equals(Object)", "int LwM2mInstance.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2mInstance lwM2mInstance = new LwM2mInstance();
    lwM2mInstance.setId(1);
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(1, "Name", true, true, true);
    lwM2mInstance.setResources(new LwM2mResourceObserve[] {lwM2mResourceObserve});

    // Act and Assert
    assertNotEquals(lwM2mInstance, "Different type to LwM2mInstance");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mInstance.<init>()",
    "int LwM2mInstance.getId()",
    "LwM2mResourceObserve[] LwM2mInstance.getResources()",
    "void LwM2mInstance.setId(int)",
    "void LwM2mInstance.setResources(LwM2mResourceObserve[])",
    "String LwM2mInstance.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2mInstance actualLwM2mInstance = new LwM2mInstance();
    actualLwM2mInstance.setId(1);
    LwM2mResourceObserve lwM2mResourceObserve =
        new LwM2mResourceObserve(1, "Name", true, true, true);
    LwM2mResourceObserve[] resources = new LwM2mResourceObserve[] {lwM2mResourceObserve};
    actualLwM2mInstance.setResources(resources);
    String actualToStringResult = actualLwM2mInstance.toString();
    int actualId = actualLwM2mInstance.getId();

    // Assert
    assertEquals(
        "LwM2mInstance(id=1, resources=[LwM2mResourceObserve(id=1, name=Name, observe=true, attribute=true,"
            + " telemetry=true, keyName=name)])",
        actualToStringResult);
    assertEquals(1, actualId);
    assertSame(resources, actualLwM2mInstance.getResources());
  }
}
