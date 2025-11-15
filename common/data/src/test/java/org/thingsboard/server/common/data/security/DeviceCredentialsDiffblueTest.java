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
package org.thingsboard.server.common.data.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.id.EntityId;

class DeviceCredentialsDiffblueTest {
  /**
   * Method under test: {@link DeviceCredentials#getId()}
   */
  @Test
  void testGetId() {
    // Arrange
    DeviceCredentialsId id = mock(DeviceCredentialsId.class);
    when(id.getId()).thenReturn(EntityId.NULL_UUID);

    // Act
    (new DeviceCredentials(id)).getId().getId();

    // Assert
    verify(id).getId();
  }

  /**
   * Method under test: {@link DeviceCredentials#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new DeviceCredentials()).getCreatedTime());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceCredentials#equals(Object)}
   *   <li>{@link DeviceCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    // Act and Assert
    assertEquals(deviceCredentials, deviceCredentials);
    int expectedHashCodeResult = deviceCredentials.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentials.hashCode());
  }

  /**
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials(new DeviceCredentialsId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(deviceCredentials, new DeviceCredentials());
  }

  /**
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceCredentials(), mock(UserAuthSettings.class));
  }

  /**
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertNotEquals(deviceCredentials, new DeviceCredentials());
  }

  /**
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsId("42");

    // Act and Assert
    assertNotEquals(deviceCredentials, new DeviceCredentials());
  }

  /**
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsValue("42");

    // Act and Assert
    assertNotEquals(deviceCredentials, new DeviceCredentials());
  }

  /**
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentials, new DeviceCredentials());
  }

  /**
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertNotEquals(deviceCredentials, deviceCredentials2);
  }

  /**
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setCredentialsId("42");

    // Act and Assert
    assertNotEquals(deviceCredentials, deviceCredentials2);
  }

  /**
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setCredentialsValue("42");

    // Act and Assert
    assertNotEquals(deviceCredentials, deviceCredentials2);
  }

  /**
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    DeviceCredentials deviceCredentials2 = new DeviceCredentials();
    deviceCredentials2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentials, deviceCredentials2);
  }

  /**
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceCredentials(), null);
  }

  /**
   * Method under test: {@link DeviceCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceCredentials(), "Different type to DeviceCredentials");
  }

  /**
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
  void testGettersAndSetters2() {
    // Arrange
    DeviceCredentialsId id = new DeviceCredentialsId(EntityId.NULL_UUID);

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
            + " createdTime=0, id=13814000-1dd2-11b2-8080-808080808080]",
        actualToStringResult);
    assertEquals(0L, actualDeviceCredentials.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualCredentialsType);
    assertSame(id, actualDeviceCredentials.getId());
  }

  /**
   * Method under test:
   * {@link DeviceCredentials#DeviceCredentials(DeviceCredentials)}
   */
  @Test
  void testNewDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    // Act and Assert
    assertEquals(deviceCredentials, new DeviceCredentials(deviceCredentials));
  }
}
