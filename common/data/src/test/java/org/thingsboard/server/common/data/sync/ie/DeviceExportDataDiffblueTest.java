package org.thingsboard.server.common.data.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class DeviceExportDataDiffblueTest {
  /**
   * Test {@link DeviceExportData#hasCredentials()}.
   * <ul>
   *   <li>Given {@link DeviceExportData} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceExportData#hasCredentials()}
   */
  @Test
  @DisplayName("Test hasCredentials(); given DeviceExportData (default constructor); then return 'false'")
  void testHasCredentials_givenDeviceExportData_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DeviceExportData()).hasCredentials());
  }

  /**
   * Test {@link DeviceExportData#hasCredentials()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceExportData#hasCredentials()}
   */
  @Test
  @DisplayName("Test hasCredentials(); given HashMap() computeIfPresent 'foo' and BiFunction; then return 'false'")
  void testHasCredentials_givenHashMapComputeIfPresentFooAndBiFunction_thenReturnFalse() {
    // Arrange
    HashMap<String, List<AttributeExportData>> attributes = new HashMap<>();
    attributes.computeIfPresent("foo", mock(BiFunction.class));

    DeviceExportData deviceExportData = new DeviceExportData();
    deviceExportData.setAttributes(attributes);

    // Act and Assert
    assertFalse(deviceExportData.hasCredentials());
  }

  /**
   * Test {@link DeviceExportData#hasCredentials()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceExportData#hasCredentials()}
   */
  @Test
  @DisplayName("Test hasCredentials(); then return 'true'")
  void testHasCredentials_thenReturnTrue() {
    // Arrange
    DeviceExportData deviceExportData = new DeviceExportData();
    deviceExportData.setCredentials(new DeviceCredentials());

    // Act and Assert
    assertTrue(deviceExportData.hasCredentials());
  }

  /**
   * Test {@link DeviceExportData#equals(Object)}, and
   * {@link DeviceExportData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceExportData#equals(Object)}
   *   <li>{@link DeviceExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceExportData deviceExportData = new DeviceExportData();
    DeviceExportData deviceExportData2 = new DeviceExportData();

    // Act and Assert
    assertEquals(deviceExportData, deviceExportData2);
    int expectedHashCodeResult = deviceExportData.hashCode();
    assertEquals(expectedHashCodeResult, deviceExportData2.hashCode());
  }

  /**
   * Test {@link DeviceExportData#equals(Object)}, and
   * {@link DeviceExportData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceExportData#equals(Object)}
   *   <li>{@link DeviceExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceExportData deviceExportData = new DeviceExportData();
    deviceExportData.setCredentials(new DeviceCredentials());

    DeviceExportData deviceExportData2 = new DeviceExportData();
    deviceExportData2.setCredentials(new DeviceCredentials());

    // Act and Assert
    assertEquals(deviceExportData, deviceExportData2);
    int expectedHashCodeResult = deviceExportData.hashCode();
    assertEquals(expectedHashCodeResult, deviceExportData2.hashCode());
  }

  /**
   * Test {@link DeviceExportData#equals(Object)}, and
   * {@link DeviceExportData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceExportData#equals(Object)}
   *   <li>{@link DeviceExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceExportData deviceExportData = new DeviceExportData();

    // Act and Assert
    assertEquals(deviceExportData, deviceExportData);
    int expectedHashCodeResult = deviceExportData.hashCode();
    assertEquals(expectedHashCodeResult, deviceExportData.hashCode());
  }

  /**
   * Test {@link DeviceExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceExportData(), 1);
    assertNotEquals(new DeviceExportData(), mock(EntityExportData.class));
  }

  /**
   * Test {@link DeviceExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceExportData deviceExportData = new DeviceExportData();
    deviceExportData.setCredentials(new DeviceCredentials());

    // Act and Assert
    assertNotEquals(deviceExportData, new DeviceExportData());
  }

  /**
   * Test {@link DeviceExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceExportData deviceExportData = new DeviceExportData();
    deviceExportData.setEntity(new Device());

    // Act and Assert
    assertNotEquals(deviceExportData, new DeviceExportData());
  }

  /**
   * Test {@link DeviceExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceExportData deviceExportData = new DeviceExportData();

    DeviceExportData deviceExportData2 = new DeviceExportData();
    deviceExportData2.setCredentials(new DeviceCredentials());

    // Act and Assert
    assertNotEquals(deviceExportData, deviceExportData2);
  }

  /**
   * Test {@link DeviceExportData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceExportData(), null);
  }

  /**
   * Test {@link DeviceExportData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceExportData(), "Different type to DeviceExportData");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceExportData}
   *   <li>{@link DeviceExportData#setCredentials(DeviceCredentials)}
   *   <li>{@link DeviceExportData#toString()}
   *   <li>{@link DeviceExportData#getCredentials()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceExportData actualDeviceExportData = new DeviceExportData();
    DeviceCredentials credentials = new DeviceCredentials();
    actualDeviceExportData.setCredentials(credentials);
    String actualToStringResult = actualDeviceExportData.toString();

    // Assert that nothing has changed
    assertEquals(
        "DeviceExportData(super=EntityExportData(entity=null, entityType=null, relations=null, attributes=null),"
            + " credentials=DeviceCredentials [deviceId=null, credentialsType=null, credentialsId=null, credentialsValue"
            + "=null, createdTime=0, id=null])",
        actualToStringResult);
    assertSame(credentials, actualDeviceExportData.getCredentials());
  }
}
