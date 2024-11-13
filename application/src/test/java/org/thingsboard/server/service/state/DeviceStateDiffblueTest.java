package org.thingsboard.server.service.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.state.DeviceState.DeviceStateBuilder;

class DeviceStateDiffblueTest {
  /**
   * Test DeviceStateBuilder {@link DeviceStateBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceState.DeviceStateBuilder#build()}
   *   <li>{@link DeviceState.DeviceStateBuilder#active(boolean)}
   *   <li>{@link DeviceState.DeviceStateBuilder#inactivityTimeout(long)}
   *   <li>{@link DeviceState.DeviceStateBuilder#lastActivityTime(long)}
   *   <li>{@link DeviceState.DeviceStateBuilder#lastConnectTime(long)}
   *   <li>{@link DeviceState.DeviceStateBuilder#lastDisconnectTime(long)}
   *   <li>{@link DeviceState.DeviceStateBuilder#lastInactivityAlarmTime(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test DeviceStateBuilder build()")
  void testDeviceStateBuilderBuild() {
    // Arrange and Act
    DeviceState actualBuildResult = DeviceState.builder()
        .active(true)
        .inactivityTimeout(1L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();

    // Assert
    assertEquals(1L, actualBuildResult.getInactivityTimeout());
    assertEquals(1L, actualBuildResult.getLastActivityTime());
    assertEquals(1L, actualBuildResult.getLastConnectTime());
    assertEquals(1L, actualBuildResult.getLastDisconnectTime());
    assertEquals(1L, actualBuildResult.getLastInactivityAlarmTime());
    assertTrue(actualBuildResult.isActive());
  }

  /**
   * Test {@link DeviceState#equals(Object)}, and {@link DeviceState#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceState#equals(Object)}
   *   <li>{@link DeviceState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceState buildResult = DeviceState.builder()
        .active(true)
        .inactivityTimeout(1L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();
    DeviceState buildResult2 = DeviceState.builder()
        .active(true)
        .inactivityTimeout(1L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link DeviceState#equals(Object)}, and {@link DeviceState#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceState#equals(Object)}
   *   <li>{@link DeviceState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceState buildResult = DeviceState.builder()
        .active(true)
        .inactivityTimeout(1L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link DeviceState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceState.DeviceStateBuilder deviceStateBuilder = mock(DeviceState.DeviceStateBuilder.class);
    when(deviceStateBuilder.active(anyBoolean())).thenReturn(DeviceState.builder());
    DeviceState buildResult = deviceStateBuilder.active(true)
        .inactivityTimeout(1L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();
    DeviceState buildResult2 = DeviceState.builder()
        .active(true)
        .inactivityTimeout(1L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceState.DeviceStateBuilder deviceStateBuilder = mock(DeviceState.DeviceStateBuilder.class);
    when(deviceStateBuilder.active(anyBoolean())).thenReturn(DeviceState.builder());
    DeviceState buildResult = deviceStateBuilder.active(true)
        .inactivityTimeout(3L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();
    DeviceState buildResult2 = DeviceState.builder()
        .active(false)
        .inactivityTimeout(1L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceState.DeviceStateBuilder deviceStateBuilder = mock(DeviceState.DeviceStateBuilder.class);
    when(deviceStateBuilder.active(anyBoolean())).thenReturn(DeviceState.builder());
    DeviceState buildResult = deviceStateBuilder.active(true)
        .inactivityTimeout(3L)
        .lastActivityTime(3L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();
    DeviceState buildResult2 = DeviceState.builder()
        .active(false)
        .inactivityTimeout(1L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceState.DeviceStateBuilder deviceStateBuilder = mock(DeviceState.DeviceStateBuilder.class);
    when(deviceStateBuilder.active(anyBoolean())).thenReturn(DeviceState.builder());
    DeviceState buildResult = deviceStateBuilder.active(true)
        .inactivityTimeout(3L)
        .lastActivityTime(1L)
        .lastConnectTime(3L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();
    DeviceState buildResult2 = DeviceState.builder()
        .active(false)
        .inactivityTimeout(1L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceState.DeviceStateBuilder deviceStateBuilder = mock(DeviceState.DeviceStateBuilder.class);
    when(deviceStateBuilder.active(anyBoolean())).thenReturn(DeviceState.builder());
    DeviceState buildResult = deviceStateBuilder.active(true)
        .inactivityTimeout(3L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(3L)
        .lastInactivityAlarmTime(1L)
        .build();
    DeviceState buildResult2 = DeviceState.builder()
        .active(false)
        .inactivityTimeout(1L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceState.DeviceStateBuilder deviceStateBuilder = mock(DeviceState.DeviceStateBuilder.class);
    when(deviceStateBuilder.active(anyBoolean())).thenReturn(DeviceState.builder());
    DeviceState buildResult = deviceStateBuilder.active(true)
        .inactivityTimeout(3L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(3L)
        .build();
    DeviceState buildResult2 = DeviceState.builder()
        .active(false)
        .inactivityTimeout(1L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceState#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceState buildResult = DeviceState.builder()
        .active(true)
        .inactivityTimeout(1L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link DeviceState#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceState buildResult = DeviceState.builder()
        .active(true)
        .inactivityTimeout(1L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to DeviceState");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceState#setActive(boolean)}
   *   <li>{@link DeviceState#setInactivityTimeout(long)}
   *   <li>{@link DeviceState#setLastActivityTime(long)}
   *   <li>{@link DeviceState#setLastConnectTime(long)}
   *   <li>{@link DeviceState#setLastDisconnectTime(long)}
   *   <li>{@link DeviceState#setLastInactivityAlarmTime(long)}
   *   <li>{@link DeviceState#toString()}
   *   <li>{@link DeviceState#getInactivityTimeout()}
   *   <li>{@link DeviceState#getLastActivityTime()}
   *   <li>{@link DeviceState#getLastConnectTime()}
   *   <li>{@link DeviceState#getLastDisconnectTime()}
   *   <li>{@link DeviceState#getLastInactivityAlarmTime()}
   *   <li>{@link DeviceState#isActive()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    DeviceState buildResult = DeviceState.builder()
        .active(true)
        .inactivityTimeout(1L)
        .lastActivityTime(1L)
        .lastConnectTime(1L)
        .lastDisconnectTime(1L)
        .lastInactivityAlarmTime(1L)
        .build();

    // Act
    buildResult.setActive(true);
    buildResult.setInactivityTimeout(1L);
    buildResult.setLastActivityTime(1L);
    buildResult.setLastConnectTime(1L);
    buildResult.setLastDisconnectTime(1L);
    buildResult.setLastInactivityAlarmTime(1L);
    String actualToStringResult = buildResult.toString();
    long actualInactivityTimeout = buildResult.getInactivityTimeout();
    long actualLastActivityTime = buildResult.getLastActivityTime();
    long actualLastConnectTime = buildResult.getLastConnectTime();
    long actualLastDisconnectTime = buildResult.getLastDisconnectTime();
    long actualLastInactivityAlarmTime = buildResult.getLastInactivityAlarmTime();

    // Assert that nothing has changed
    assertEquals(
        "DeviceState(active=true, lastConnectTime=1, lastActivityTime=1, lastDisconnectTime=1, lastInactivityAlarmTime"
            + "=1, inactivityTimeout=1)",
        actualToStringResult);
    assertEquals(1L, actualInactivityTimeout);
    assertEquals(1L, actualLastActivityTime);
    assertEquals(1L, actualLastConnectTime);
    assertEquals(1L, actualLastDisconnectTime);
    assertEquals(1L, actualLastInactivityAlarmTime);
    assertTrue(buildResult.isActive());
  }

  /**
   * Test {@link DeviceState#DeviceState(boolean, long, long, long, long, long)}.
   * <p>
   * Method under test:
   * {@link DeviceState#DeviceState(boolean, long, long, long, long, long)}
   */
  @Test
  @DisplayName("Test new DeviceState(boolean, long, long, long, long, long)")
  void testNewDeviceState() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    DeviceState actualDeviceState = new DeviceState(true, 1L, 1L, 1L, 1L, 1L);

    // Assert
    assertEquals(1L, actualDeviceState.getInactivityTimeout());
    assertEquals(1L, actualDeviceState.getLastActivityTime());
    assertEquals(1L, actualDeviceState.getLastConnectTime());
    assertEquals(1L, actualDeviceState.getLastDisconnectTime());
    assertEquals(1L, actualDeviceState.getLastInactivityAlarmTime());
    assertTrue(actualDeviceState.isActive());
  }
}
