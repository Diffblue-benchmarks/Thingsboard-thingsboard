package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class DeviceCredentialsEvictEventDiffblueTest {
  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}, and
   * {@link DeviceCredentialsEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentialsEvictEvent#equals(Object)}
   *   <li>{@link DeviceCredentialsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent = new DeviceCredentialsEvictEvent("42", "42");
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent2 = new DeviceCredentialsEvictEvent("42", "42");

    // Act and Assert
    assertEquals(deviceCredentialsEvictEvent, deviceCredentialsEvictEvent2);
    int expectedHashCodeResult = deviceCredentialsEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentialsEvictEvent2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}, and
   * {@link DeviceCredentialsEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentialsEvictEvent#equals(Object)}
   *   <li>{@link DeviceCredentialsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent = new DeviceCredentialsEvictEvent(null, "42");
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent2 = new DeviceCredentialsEvictEvent(null, "42");

    // Act and Assert
    assertEquals(deviceCredentialsEvictEvent, deviceCredentialsEvictEvent2);
    int expectedHashCodeResult = deviceCredentialsEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentialsEvictEvent2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}, and
   * {@link DeviceCredentialsEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentialsEvictEvent#equals(Object)}
   *   <li>{@link DeviceCredentialsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent = new DeviceCredentialsEvictEvent("42", null);
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent2 = new DeviceCredentialsEvictEvent("42", null);

    // Act and Assert
    assertEquals(deviceCredentialsEvictEvent, deviceCredentialsEvictEvent2);
    int expectedHashCodeResult = deviceCredentialsEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentialsEvictEvent2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}, and
   * {@link DeviceCredentialsEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentialsEvictEvent#equals(Object)}
   *   <li>{@link DeviceCredentialsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent = new DeviceCredentialsEvictEvent("42", "42");

    // Act and Assert
    assertEquals(deviceCredentialsEvictEvent, deviceCredentialsEvictEvent);
    int expectedHashCodeResult = deviceCredentialsEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentialsEvictEvent.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent = new DeviceCredentialsEvictEvent("New Cedentials Id",
        "42");

    // Act and Assert
    assertNotEquals(deviceCredentialsEvictEvent, new DeviceCredentialsEvictEvent("42", "42"));
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent = new DeviceCredentialsEvictEvent(null, "42");

    // Act and Assert
    assertNotEquals(deviceCredentialsEvictEvent, new DeviceCredentialsEvictEvent("42", "42"));
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent = new DeviceCredentialsEvictEvent("42",
        "Old Credentials Id");

    // Act and Assert
    assertNotEquals(deviceCredentialsEvictEvent, new DeviceCredentialsEvictEvent("42", "42"));
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceCredentialsEvictEvent deviceCredentialsEvictEvent = new DeviceCredentialsEvictEvent("42", null);

    // Act and Assert
    assertNotEquals(deviceCredentialsEvictEvent, new DeviceCredentialsEvictEvent("42", "42"));
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceCredentialsEvictEvent("42", "42"), null);
  }

  /**
   * Test {@link DeviceCredentialsEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceCredentialsEvictEvent("42", "42"), "Different type to DeviceCredentialsEvictEvent");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DeviceCredentialsEvictEvent#DeviceCredentialsEvictEvent(String, String)}
   *   <li>{@link DeviceCredentialsEvictEvent#toString()}
   *   <li>{@link DeviceCredentialsEvictEvent#getNewCedentialsId()}
   *   <li>{@link DeviceCredentialsEvictEvent#getOldCredentialsId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DeviceCredentialsEvictEvent actualDeviceCredentialsEvictEvent = new DeviceCredentialsEvictEvent("42", "42");
    String actualToStringResult = actualDeviceCredentialsEvictEvent.toString();
    String actualNewCedentialsId = actualDeviceCredentialsEvictEvent.getNewCedentialsId();

    // Assert
    assertEquals("42", actualNewCedentialsId);
    assertEquals("42", actualDeviceCredentialsEvictEvent.getOldCredentialsId());
    assertEquals("DeviceCredentialsEvictEvent(newCedentialsId=42, oldCredentialsId=42)", actualToStringResult);
  }
}
