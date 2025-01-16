package org.thingsboard.server.common.data.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;

class DeviceCredentialsDiffblueTest {
  /**
   * Test {@link DeviceCredentials#equals(Object)}, and
   * {@link DeviceCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    DeviceCredentials deviceCredentials2 = new DeviceCredentials();

    // Act and Assert
    assertEquals(deviceCredentials, deviceCredentials2);
    int expectedHashCodeResult = deviceCredentials.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentials2.hashCode());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}, and
   * {@link DeviceCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertEquals(deviceCredentials, deviceCredentials2);
    int expectedHashCodeResult = deviceCredentials.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentials2.hashCode());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}, and
   * {@link DeviceCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsId("42");

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setCredentialsId("42");

    // Act and Assert
    assertEquals(deviceCredentials, deviceCredentials2);
    int expectedHashCodeResult = deviceCredentials.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentials2.hashCode());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}, and
   * {@link DeviceCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsValue("42");

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setCredentialsValue("42");

    // Act and Assert
    assertEquals(deviceCredentials, deviceCredentials2);
    int expectedHashCodeResult = deviceCredentials.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentials2.hashCode());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}, and
   * {@link DeviceCredentials#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setVersion(1L);

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceCredentials, deviceCredentials2);
    int expectedHashCodeResult = deviceCredentials.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentials2.hashCode());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}, and
   * {@link DeviceCredentials#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    // Act and Assert
    assertEquals(deviceCredentials, deviceCredentials);
    int expectedHashCodeResult = deviceCredentials.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentials.hashCode());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials(
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(deviceCredentials, new DeviceCredentials());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceCredentials(), mock(UserAuthSettings.class));
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertNotEquals(deviceCredentials, new DeviceCredentials());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsId("42");

    // Act and Assert
    assertNotEquals(deviceCredentials, new DeviceCredentials());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsValue("42");

    // Act and Assert
    assertNotEquals(deviceCredentials, new DeviceCredentials());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentials, new DeviceCredentials());
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertNotEquals(deviceCredentials, deviceCredentials2);
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setCredentialsId("42");

    // Act and Assert
    assertNotEquals(deviceCredentials, deviceCredentials2);
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setCredentialsValue("42");

    // Act and Assert
    assertNotEquals(deviceCredentials, deviceCredentials2);
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentials, deviceCredentials2);
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceCredentials(), null);
  }

  /**
   * Test {@link DeviceCredentials#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceCredentials(), "Different type to DeviceCredentials");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentials#DeviceCredentials()}
   *   <li>{@link DeviceCredentials#setCredentialsId(String)}
   *   <li>{@link DeviceCredentials#setCredentialsType(DeviceCredentialsType)}
   *   <li>{@link DeviceCredentials#setCredentialsValue(String)}
   *   <li>{@link DeviceCredentials#setVersion(Long)}
   *   <li>{@link DeviceCredentials#toString()}
   *   <li>{@link DeviceCredentials#getCredentialsId()}
   *   <li>{@link DeviceCredentials#getCredentialsType()}
   *   <li>{@link DeviceCredentials#getCredentialsValue()}
   *   <li>{@link DeviceCredentials#getDeviceId()}
   *   <li>{@link DeviceCredentials#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceCredentials actualDeviceCredentials = new DeviceCredentials();
    actualDeviceCredentials.setCredentialsId("42");
    actualDeviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    actualDeviceCredentials.setCredentialsValue("42");
    actualDeviceCredentials.setVersion(1L);
    String actualToStringResult = actualDeviceCredentials.toString();
    String actualCredentialsId = actualDeviceCredentials.getCredentialsId();
    DeviceCredentialsType actualCredentialsType = actualDeviceCredentials.getCredentialsType();
    String actualCredentialsValue = actualDeviceCredentials.getCredentialsValue();
    actualDeviceCredentials.getDeviceId();
    Long actualVersion = actualDeviceCredentials.getVersion();

    // Assert that nothing has changed
    assertEquals("42", actualCredentialsId);
    assertEquals("42", actualCredentialsValue);
    assertEquals(
        "DeviceCredentials [deviceId=null, credentialsType=ACCESS_TOKEN, credentialsId=42, credentialsValue=42,"
            + " createdTime=0, id=null]",
        actualToStringResult);
    assertEquals(0L, actualDeviceCredentials.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualCredentialsType);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentials#DeviceCredentials(DeviceCredentialsId)}
   *   <li>{@link DeviceCredentials#setCredentialsId(String)}
   *   <li>{@link DeviceCredentials#setCredentialsType(DeviceCredentialsType)}
   *   <li>{@link DeviceCredentials#setCredentialsValue(String)}
   *   <li>{@link DeviceCredentials#setVersion(Long)}
   *   <li>{@link DeviceCredentials#toString()}
   *   <li>{@link DeviceCredentials#getCredentialsId()}
   *   <li>{@link DeviceCredentials#getCredentialsType()}
   *   <li>{@link DeviceCredentials#getCredentialsValue()}
   *   <li>{@link DeviceCredentials#getDeviceId()}
   *   <li>{@link DeviceCredentials#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters2() {
    // Arrange
    DeviceCredentialsId id = new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    DeviceCredentials actualDeviceCredentials = new DeviceCredentials(id);
    actualDeviceCredentials.setCredentialsId("42");
    actualDeviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    actualDeviceCredentials.setCredentialsValue("42");
    actualDeviceCredentials.setVersion(1L);
    String actualToStringResult = actualDeviceCredentials.toString();
    String actualCredentialsId = actualDeviceCredentials.getCredentialsId();
    DeviceCredentialsType actualCredentialsType = actualDeviceCredentials.getCredentialsType();
    String actualCredentialsValue = actualDeviceCredentials.getCredentialsValue();
    actualDeviceCredentials.getDeviceId();
    Long actualVersion = actualDeviceCredentials.getVersion();

    // Assert that nothing has changed
    assertEquals("42", actualCredentialsId);
    assertEquals("42", actualCredentialsValue);
    assertEquals(
        "DeviceCredentials [deviceId=null, credentialsType=ACCESS_TOKEN, credentialsId=42, credentialsValue=42,"
            + " createdTime=0, id=784f394c-42b6-435a-983c-b7beff2784f9]",
        actualToStringResult);
    assertEquals(0L, actualDeviceCredentials.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualCredentialsType);
    assertSame(id, actualDeviceCredentials.getId());
  }

  /**
   * Test {@link DeviceCredentials#DeviceCredentials(DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentials#DeviceCredentials(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test new DeviceCredentials(DeviceCredentials)")
  void testNewDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    // Act and Assert
    assertEquals(deviceCredentials, new DeviceCredentials(deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentials#getId()}.
   * <ul>
   *   <li>Then return Id is fromString
   * {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentials#getId()}
   */
  @Test
  @DisplayName("Test getId(); then return Id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  void testGetId_thenReturnIdIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    DeviceCredentialsId id = mock(DeviceCredentialsId.class);
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(id.getId()).thenReturn(fromStringResult);

    // Act
    UUID actualId = (new DeviceCredentials(id)).getId().getId();

    // Assert
    verify(id).getId();
    assertSame(fromStringResult, actualId);
  }

  /**
   * Test {@link DeviceCredentials#getCreatedTime()}.
   * <p>
   * Method under test: {@link DeviceCredentials#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DeviceCredentials()).getCreatedTime());
  }
}
