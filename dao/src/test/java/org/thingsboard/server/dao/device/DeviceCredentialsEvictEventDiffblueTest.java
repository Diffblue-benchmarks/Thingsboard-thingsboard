package org.thingsboard.server.dao.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DeviceCredentialsEvictEventDiffblueTest {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEvictEvent.equals(Object)",
    "int DeviceCredentialsEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsEvictEvent.<init>(String, String)",
    "String DeviceCredentialsEvictEvent.getNewCedentialsId()",
    "String DeviceCredentialsEvictEvent.getOldCredentialsId()",
    "String DeviceCredentialsEvictEvent.toString()"
  })
  void testGettersAndSetters() {
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
