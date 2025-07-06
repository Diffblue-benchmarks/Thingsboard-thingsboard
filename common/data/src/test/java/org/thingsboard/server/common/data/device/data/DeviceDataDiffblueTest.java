package org.thingsboard.server.common.data.device.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DeviceDataDiffblueTest {
  /**
   * Test {@link DeviceData#equals(Object)}, and {@link DeviceData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceData#equals(Object)}
   *   <li>{@link DeviceData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceData.equals(Object)", "int DeviceData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(null);
    deviceData.setTransportConfiguration(null);

    DeviceData deviceData2 = new DeviceData();
    deviceData2.setConfiguration(null);
    deviceData2.setTransportConfiguration(null);

    // Act and Assert
    assertEquals(deviceData, deviceData2);
    int expectedHashCodeResult = deviceData.hashCode();
    assertEquals(expectedHashCodeResult, deviceData2.hashCode());
  }

  /**
   * Test {@link DeviceData#equals(Object)}, and {@link DeviceData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceData#equals(Object)}
   *   <li>{@link DeviceData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceData.equals(Object)", "int DeviceData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(mock(DeviceConfiguration.class));
    deviceData.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act and Assert
    assertEquals(deviceData, deviceData);
    int expectedHashCodeResult = deviceData.hashCode();
    assertEquals(expectedHashCodeResult, deviceData.hashCode());
  }

  /**
   * Test {@link DeviceData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceData.equals(Object)", "int DeviceData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(mock(DeviceConfiguration.class));
    deviceData.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    DeviceData deviceData2 = new DeviceData();
    deviceData2.setConfiguration(mock(DeviceConfiguration.class));
    deviceData2.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceData, deviceData2);
  }

  /**
   * Test {@link DeviceData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceData.equals(Object)", "int DeviceData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(null);
    deviceData.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    DeviceData deviceData2 = new DeviceData();
    deviceData2.setConfiguration(mock(DeviceConfiguration.class));
    deviceData2.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceData, deviceData2);
  }

  /**
   * Test {@link DeviceData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceData.equals(Object)", "int DeviceData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(null);
    deviceData.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    DeviceData deviceData2 = new DeviceData();
    deviceData2.setConfiguration(null);
    deviceData2.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceData, deviceData2);
  }

  /**
   * Test {@link DeviceData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceData.equals(Object)", "int DeviceData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(null);
    deviceData.setTransportConfiguration(null);

    DeviceData deviceData2 = new DeviceData();
    deviceData2.setConfiguration(null);
    deviceData2.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceData, deviceData2);
  }

  /**
   * Test {@link DeviceData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceData.equals(Object)", "int DeviceData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(mock(DeviceConfiguration.class));
    deviceData.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceData, null);
  }

  /**
   * Test {@link DeviceData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceData.equals(Object)", "int DeviceData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(mock(DeviceConfiguration.class));
    deviceData.setTransportConfiguration(mock(DeviceTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceData, "Different type to DeviceData");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceData}
   *   <li>{@link DeviceData#setConfiguration(DeviceConfiguration)}
   *   <li>{@link DeviceData#setTransportConfiguration(DeviceTransportConfiguration)}
   *   <li>{@link DeviceData#toString()}
   *   <li>{@link DeviceData#getConfiguration()}
   *   <li>{@link DeviceData#getTransportConfiguration()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceData.<init>()",
    "DeviceConfiguration DeviceData.getConfiguration()",
    "DeviceTransportConfiguration DeviceData.getTransportConfiguration()",
    "void DeviceData.setConfiguration(DeviceConfiguration)",
    "void DeviceData.setTransportConfiguration(DeviceTransportConfiguration)",
    "java.lang.String DeviceData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceData actualDeviceData = new DeviceData();
    DeviceConfiguration configuration = mock(DeviceConfiguration.class);
    actualDeviceData.setConfiguration(configuration);
    DeviceTransportConfiguration transportConfiguration = mock(DeviceTransportConfiguration.class);
    actualDeviceData.setTransportConfiguration(transportConfiguration);
    actualDeviceData.toString();
    DeviceConfiguration actualConfiguration = actualDeviceData.getConfiguration();

    // Assert
    assertSame(configuration, actualConfiguration);
    assertSame(transportConfiguration, actualDeviceData.getTransportConfiguration());
  }
}
