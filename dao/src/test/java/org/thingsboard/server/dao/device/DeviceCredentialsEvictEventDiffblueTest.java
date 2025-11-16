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
package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DeviceCredentialsEvictEventDiffblueTest {
  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}, and {@link
   * DeviceCredentialsEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentialsEvictEvent#equals(Object)}
   *   <li>{@link DeviceCredentialsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent =
        new DeviceCredentialsEvictEvent("42", "42");
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent2 =
        new DeviceCredentialsEvictEvent("42", "42");

    // Act and Assert
    assertEquals(deviceCredentialsEvictEvent, deviceCredentialsEvictEvent2);
    assertEquals(deviceCredentialsEvictEvent.hashCode(), deviceCredentialsEvictEvent2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}, and {@link
   * DeviceCredentialsEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentialsEvictEvent#equals(Object)}
   *   <li>{@link DeviceCredentialsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent =
        new DeviceCredentialsEvictEvent(null, "42");
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent2 =
        new DeviceCredentialsEvictEvent(null, "42");

    // Act and Assert
    assertEquals(deviceCredentialsEvictEvent, deviceCredentialsEvictEvent2);
    assertEquals(deviceCredentialsEvictEvent.hashCode(), deviceCredentialsEvictEvent2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}, and {@link
   * DeviceCredentialsEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentialsEvictEvent#equals(Object)}
   *   <li>{@link DeviceCredentialsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent =
        new DeviceCredentialsEvictEvent("42", null);
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent2 =
        new DeviceCredentialsEvictEvent("42", null);

    // Act and Assert
    assertEquals(deviceCredentialsEvictEvent, deviceCredentialsEvictEvent2);
    assertEquals(deviceCredentialsEvictEvent.hashCode(), deviceCredentialsEvictEvent2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}, and {@link
   * DeviceCredentialsEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentialsEvictEvent#equals(Object)}
   *   <li>{@link DeviceCredentialsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent =
        new DeviceCredentialsEvictEvent("42", "42");

    // Act and Assert
    assertEquals(deviceCredentialsEvictEvent, deviceCredentialsEvictEvent);
    int expectedHashCodeResult = deviceCredentialsEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentialsEvictEvent.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent =
        new DeviceCredentialsEvictEvent("New Cedentials Id", "42");

    // Act and Assert
    assertNotEquals(deviceCredentialsEvictEvent, new DeviceCredentialsEvictEvent("42", "42"));
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent =
        new DeviceCredentialsEvictEvent(null, "42");

    // Act and Assert
    assertNotEquals(deviceCredentialsEvictEvent, new DeviceCredentialsEvictEvent("42", "42"));
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent =
        new DeviceCredentialsEvictEvent("42", "Old Credentials Id");

    // Act and Assert
    assertNotEquals(deviceCredentialsEvictEvent, new DeviceCredentialsEvictEvent("42", "42"));
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent =
        new DeviceCredentialsEvictEvent("42", null);

    // Act and Assert
    assertNotEquals(deviceCredentialsEvictEvent, new DeviceCredentialsEvictEvent("42", "42"));
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceCredentialsEvictEvent("42", "42"), null);
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DeviceCredentialsEvictEvent("42", "42"),
        "Different type to DeviceCredentialsEvictEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentialsEvictEvent#DeviceCredentialsEvictEvent(String, String)}
   *   <li>{@link DeviceCredentialsEvictEvent#toString()}
   *   <li>{@link DeviceCredentialsEvictEvent#getNewCedentialsId()}
   *   <li>{@link DeviceCredentialsEvictEvent#getOldCredentialsId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsEvictEvent.<init>(String, String)",
    "String DeviceCredentialsEvictEvent.getNewCedentialsId()",
    "String DeviceCredentialsEvictEvent.getOldCredentialsId()",
    "String DeviceCredentialsEvictEvent.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DeviceCredentialsEvictEvent actualDeviceCredentialsEvictEvent =
        new DeviceCredentialsEvictEvent("42", "42");
    String actualToStringResult = actualDeviceCredentialsEvictEvent.toString();
    String actualNewCedentialsId = actualDeviceCredentialsEvictEvent.getNewCedentialsId();

    // Assert
    assertEquals("42", actualNewCedentialsId);
    assertEquals("42", actualDeviceCredentialsEvictEvent.getOldCredentialsId());
    assertEquals(
        "DeviceCredentialsEvictEvent(newCedentialsId=42, oldCredentialsId=42)",
        actualToStringResult);
  }
}
